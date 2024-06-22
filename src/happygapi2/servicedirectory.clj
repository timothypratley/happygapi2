(ns happygapi2.servicedirectory
  "Service Directory API
Service Directory is a platform for discovering, publishing, and connecting services. 
See: https://cloud.google.com/service-directory"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/service-directory/docs/reference/rest/v1/projects.locations/list

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://servicedirectory.googleapis.com/v1/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/service-directory/docs/reference/rest/v1/projects.locations/get

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://servicedirectory.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-namespaces-create
  "Creates a namespace, and returns the new namespace.
https://cloud.google.com/service-directory/docs/reference/rest/v1/projects.locations.namespaces/create

parent <string> Required. The resource name of the project and location the namespace will be created in.
Namespace:
{:name string, :labels object, :uid string}

optional:
namespaceId <string> Required. The Resource ID must be 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters long and match the regular expression `[a-z](?:[-a-z0-9]{0,61}[a-z0-9])?` which means the first character must be a lowercase letter, and all following characters must be a dash, lowercase letter, or digit, except the last character, which cannot be a dash."
  ([parent Namespace]
    (projects-locations-namespaces-create parent Namespace nil))
  ([parent Namespace optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://servicedirectory.googleapis.com/v1/{+parent}/namespaces",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Namespace})))

(defn projects-locations-namespaces-list
  "Lists all namespaces.
https://cloud.google.com/service-directory/docs/reference/rest/v1/projects.locations.namespaces/list

parent <string> Required. The resource name of the project and location whose namespaces you'd like to list.

optional:
pageSize <integer> Optional. The maximum number of items to return.
filter <string> Optional. The filter to list results by. General `filter` string syntax: ` ()` * `` can be `name` or `labels.` for map field * `` can be `<`, `>`, `<=`, `>=`, `!=`, `=`, `:`. Of which `:` means `HAS`, and is roughly the same as `=` * `` must be the same data type as field * `` can be `AND`, `OR`, `NOT` Examples of valid filters: * `labels.owner` returns namespaces that have a label with the key `owner`, this is the same as `labels:owner` * `labels.owner=sd` returns namespaces that have key/value `owner=sd` * `name>projects/my-project/locations/us-east1/namespaces/namespace-c` returns namespaces that have name that is alphabetically later than the string, so \"namespace-e\" is returned but \"namespace-a\" is not * `labels.owner!=sd AND labels.foo=bar` returns namespaces that have `owner` in label key but value is not `sd` AND have key/value `foo=bar` * `doesnotexist.foo=bar` returns an empty list. Note that namespace doesn't have a field called \"doesnotexist\". Since the filter does not match any namespaces, it returns no results For more information about filtering, see [API Filtering](https://aip.dev/160).
orderBy <string> Optional. The order to list results by. General `order_by` string syntax: ` () (,)` * `` allows value: `name` * `` ascending or descending order by ``. If this is left blank, `asc` is used Note that an empty `order_by` string results in default order, which is order by `name` in ascending order."
  ([parent] (projects-locations-namespaces-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://servicedirectory.googleapis.com/v1/{+parent}/namespaces",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-namespaces-get
  "Gets a namespace.
https://cloud.google.com/service-directory/docs/reference/rest/v1/projects.locations.namespaces/get

name <string> Required. The name of the namespace to retrieve."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://servicedirectory.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-namespaces-patch
  "Updates a namespace.
https://cloud.google.com/service-directory/docs/reference/rest/v1/projects.locations.namespaces/patch

name <string> Immutable. The resource name for the namespace in the format `projects/*/locations/*/namespaces/*`.
Namespace:
{:name string, :labels object, :uid string}

optional:
updateMask <string> Required. List of fields to be updated in this request."
  ([name Namespace]
    (projects-locations-namespaces-patch name Namespace nil))
  ([name Namespace optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://servicedirectory.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Namespace})))

(defn projects-locations-namespaces-delete
  "Deletes a namespace. This also deletes all services and endpoints in the namespace.
https://cloud.google.com/service-directory/docs/reference/rest/v1/projects.locations.namespaces/delete

name <string> Required. The name of the namespace to delete."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://servicedirectory.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-namespaces-getIamPolicy
  "Gets the IAM Policy for a resource (namespace or service only).
https://cloud.google.com/service-directory/docs/reference/rest/v1/projects.locations.namespaces/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://servicedirectory.googleapis.com/v1/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GetIamPolicyRequest}))

(defn projects-locations-namespaces-setIamPolicy
  "Sets the IAM Policy for a resource (namespace or service only).
https://cloud.google.com/service-directory/docs/reference/rest/v1/projects.locations.namespaces/setIamPolicy

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
     "https://servicedirectory.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-namespaces-testIamPermissions
  "Tests IAM permissions for a resource (namespace or service only).
https://cloud.google.com/service-directory/docs/reference/rest/v1/projects.locations.namespaces/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://servicedirectory.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-namespaces-services-get
  "Gets a service.
https://cloud.google.com/service-directory/docs/reference/rest/v1/projects.locations.namespaces.services/get

name <string> Required. The name of the service to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://servicedirectory.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-namespaces-services-setIamPolicy
  "Sets the IAM Policy for a resource (namespace or service only).
https://cloud.google.com/service-directory/docs/reference/rest/v1/projects.locations.namespaces.services/setIamPolicy

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
     "https://servicedirectory.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-namespaces-services-patch
  "Updates a service.
https://cloud.google.com/service-directory/docs/reference/rest/v1/projects.locations.namespaces.services/patch

name <string> Immutable. The resource name for the service in the format `projects/*/locations/*/namespaces/*/services/*`.
Service:
{:name string,
 :annotations object,
 :endpoints
 [{:name string,
   :address string,
   :port integer,
   :annotations object,
   :network string,
   :uid string}],
 :uid string}

optional:
updateMask <string> Required. List of fields to be updated in this request."
  ([name Service]
    (projects-locations-namespaces-services-patch name Service nil))
  ([name Service optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://servicedirectory.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Service})))

(defn projects-locations-namespaces-services-testIamPermissions
  "Tests IAM permissions for a resource (namespace or service only).
https://cloud.google.com/service-directory/docs/reference/rest/v1/projects.locations.namespaces.services/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://servicedirectory.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-namespaces-services-create
  "Creates a service, and returns the new service.
https://cloud.google.com/service-directory/docs/reference/rest/v1/projects.locations.namespaces.services/create

parent <string> Required. The resource name of the namespace this service will belong to.
Service:
{:name string,
 :annotations object,
 :endpoints
 [{:name string,
   :address string,
   :port integer,
   :annotations object,
   :network string,
   :uid string}],
 :uid string}

optional:
serviceId <string> Required. The Resource ID must be 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters long and match the regular expression `[a-z](?:[-a-z0-9]{0,61}[a-z0-9])?` which means the first character must be a lowercase letter, and all following characters must be a dash, lowercase letter, or digit, except the last character, which cannot be a dash."
  ([parent Service]
    (projects-locations-namespaces-services-create parent Service nil))
  ([parent Service optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://servicedirectory.googleapis.com/v1/{+parent}/services",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Service})))

(defn projects-locations-namespaces-services-delete
  "Deletes a service. This also deletes all endpoints associated with the service.
https://cloud.google.com/service-directory/docs/reference/rest/v1/projects.locations.namespaces.services/delete

name <string> Required. The name of the service to delete."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://servicedirectory.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-namespaces-services-getIamPolicy
  "Gets the IAM Policy for a resource (namespace or service only).
https://cloud.google.com/service-directory/docs/reference/rest/v1/projects.locations.namespaces.services/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://servicedirectory.googleapis.com/v1/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GetIamPolicyRequest}))

(defn projects-locations-namespaces-services-list
  "Lists all services belonging to a namespace.
https://cloud.google.com/service-directory/docs/reference/rest/v1/projects.locations.namespaces.services/list

parent <string> Required. The resource name of the namespace whose services you'd like to list.

optional:
pageSize <integer> Optional. The maximum number of items to return.
filter <string> Optional. The filter to list results by. General `filter` string syntax: ` ()` * `` can be `name` or `annotations.` for map field * `` can be `<`, `>`, `<=`, `>=`, `!=`, `=`, `:`. Of which `:` means `HAS`, and is roughly the same as `=` * `` must be the same data type as field * `` can be `AND`, `OR`, `NOT` Examples of valid filters: * `annotations.owner` returns services that have a annotation with the key `owner`, this is the same as `annotations:owner` * `annotations.protocol=gRPC` returns services that have key/value `protocol=gRPC` * `name>projects/my-project/locations/us-east1/namespaces/my-namespace/services/service-c` returns services that have name that is alphabetically later than the string, so \"service-e\" is returned but \"service-a\" is not * `annotations.owner!=sd AND annotations.foo=bar` returns services that have `owner` in annotation key but value is not `sd` AND have key/value `foo=bar` * `doesnotexist.foo=bar` returns an empty list. Note that service doesn't have a field called \"doesnotexist\". Since the filter does not match any services, it returns no results For more information about filtering, see [API Filtering](https://aip.dev/160).
orderBy <string> Optional. The order to list results by. General `order_by` string syntax: ` () (,)` * `` allows value: `name` * `` ascending or descending order by ``. If this is left blank, `asc` is used Note that an empty `order_by` string results in default order, which is order by `name` in ascending order."
  ([parent] (projects-locations-namespaces-services-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://servicedirectory.googleapis.com/v1/{+parent}/services",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-namespaces-services-resolve
  "Returns a service and its associated endpoints. Resolving a service is not considered an active developer method.
https://cloud.google.com/service-directory/docs/reference/rest/v1/projects.locations.namespaces.services/resolve

name <string> Required. The name of the service to resolve.
ResolveServiceRequest:
{:maxEndpoints integer, :endpointFilter string}"
  [name ResolveServiceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://servicedirectory.googleapis.com/v1/{+name}:resolve",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ResolveServiceRequest}))

(defn projects-locations-namespaces-services-endpoints-create
  "Creates an endpoint, and returns the new endpoint.
https://cloud.google.com/service-directory/docs/reference/rest/v1/projects.locations.namespaces.services.endpoints/create

parent <string> Required. The resource name of the service that this endpoint provides.
Endpoint:
{:name string,
 :address string,
 :port integer,
 :annotations object,
 :network string,
 :uid string}

optional:
endpointId <string> Required. The Resource ID must be 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters long and match the regular expression `[a-z](?:[-a-z0-9]{0,61}[a-z0-9])?` which means the first character must be a lowercase letter, and all following characters must be a dash, lowercase letter, or digit, except the last character, which cannot be a dash."
  ([parent Endpoint]
    (projects-locations-namespaces-services-endpoints-create
      parent
      Endpoint
      nil))
  ([parent Endpoint optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://servicedirectory.googleapis.com/v1/{+parent}/endpoints",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Endpoint})))

(defn projects-locations-namespaces-services-endpoints-list
  "Lists all endpoints.
https://cloud.google.com/service-directory/docs/reference/rest/v1/projects.locations.namespaces.services.endpoints/list

parent <string> Required. The resource name of the service whose endpoints you'd like to list.

optional:
pageSize <integer> Optional. The maximum number of items to return.
filter <string> Optional. The filter to list results by. General `filter` string syntax: ` ()` * `` can be `name`, `address`, `port`, or `annotations.` for map field * `` can be `<`, `>`, `<=`, `>=`, `!=`, `=`, `:`. Of which `:` means `HAS`, and is roughly the same as `=` * `` must be the same data type as field * `` can be `AND`, `OR`, `NOT` Examples of valid filters: * `annotations.owner` returns endpoints that have a annotation with the key `owner`, this is the same as `annotations:owner` * `annotations.protocol=gRPC` returns endpoints that have key/value `protocol=gRPC` * `address=192.108.1.105` returns endpoints that have this address * `port>8080` returns endpoints that have port number larger than 8080 * `name>projects/my-project/locations/us-east1/namespaces/my-namespace/services/my-service/endpoints/endpoint-c` returns endpoints that have name that is alphabetically later than the string, so \"endpoint-e\" is returned but \"endpoint-a\" is not * `annotations.owner!=sd AND annotations.foo=bar` returns endpoints that have `owner` in annotation key but value is not `sd` AND have key/value `foo=bar` * `doesnotexist.foo=bar` returns an empty list. Note that endpoint doesn't have a field called \"doesnotexist\". Since the filter does not match any endpoints, it returns no results For more information about filtering, see [API Filtering](https://aip.dev/160).
orderBy <string> Optional. The order to list results by. General `order_by` string syntax: ` () (,)` * `` allows values: `name`, `address`, `port` * `` ascending or descending order by ``. If this is left blank, `asc` is used Note that an empty `order_by` string results in default order, which is order by `name` in ascending order."
  ([parent]
    (projects-locations-namespaces-services-endpoints-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://servicedirectory.googleapis.com/v1/{+parent}/endpoints",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-namespaces-services-endpoints-get
  "Gets an endpoint.
https://cloud.google.com/service-directory/docs/reference/rest/v1/projects.locations.namespaces.services.endpoints/get

name <string> Required. The name of the endpoint to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://servicedirectory.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-namespaces-services-endpoints-patch
  "Updates an endpoint.
https://cloud.google.com/service-directory/docs/reference/rest/v1/projects.locations.namespaces.services.endpoints/patch

name <string> Immutable. The resource name for the endpoint in the format `projects/*/locations/*/namespaces/*/services/*/endpoints/*`.
Endpoint:
{:name string,
 :address string,
 :port integer,
 :annotations object,
 :network string,
 :uid string}

optional:
updateMask <string> Required. List of fields to be updated in this request."
  ([name Endpoint]
    (projects-locations-namespaces-services-endpoints-patch
      name
      Endpoint
      nil))
  ([name Endpoint optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://servicedirectory.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Endpoint})))

(defn projects-locations-namespaces-services-endpoints-delete
  "Deletes an endpoint.
https://cloud.google.com/service-directory/docs/reference/rest/v1/projects.locations.namespaces.services.endpoints/delete

name <string> Required. The name of the endpoint to delete."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://servicedirectory.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

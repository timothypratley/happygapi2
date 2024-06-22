(ns happygapi2.cloudcontrolspartner
  "Cloud Controls Partner API
Provides insights about your customers and their Assured Workloads based on your Sovereign Controls by Partners offering.
See: https://cloud.google.com/sovereign-controls-by-partners/docs/sovereign-partners/reference/rest"
  (:require [happy.oauth2.client :as client]))

(defn organizations-locations-getPartner
  "Get details of a Partner.
https://cloud.google.com/sovereign-controls-by-partners/docs/sovereign-partners/reference/rest/v1/organizations.locations/getPartner

name <string> Required. Format: `organizations/{organization}/locations/{location}/partner`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://cloudcontrolspartner.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-locations-customers-get
  "Gets details of a single customer
https://cloud.google.com/sovereign-controls-by-partners/docs/sovereign-partners/reference/rest/v1/organizations.locations.customers/get

name <string> Required. Format: `organizations/{organization}/locations/{location}/customers/{customer}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://cloudcontrolspartner.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-locations-customers-list
  "Lists customers of a partner identified by its Google Cloud organization ID
https://cloud.google.com/sovereign-controls-by-partners/docs/sovereign-partners/reference/rest/v1/organizations.locations.customers/list

parent <string> Required. Parent resource Format: `organizations/{organization}/locations/{location}`

optional:
pageSize <integer> The maximum number of Customers to return. The service may return fewer than this value. If unspecified, at most 500 Customers will be returned.
filter <string> Optional. Filtering results
orderBy <string> Optional. Hint for how to order the results"
  ([parent] (organizations-locations-customers-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudcontrolspartner.googleapis.com/v1/{+parent}/customers",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-locations-customers-workloads-get
  "Gets details of a single workload
https://cloud.google.com/sovereign-controls-by-partners/docs/sovereign-partners/reference/rest/v1/organizations.locations.customers.workloads/get

name <string> Required. Format: `organizations/{organization}/locations/{location}/customers/{customer}/workloads/{workload}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://cloudcontrolspartner.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-locations-customers-workloads-list
  "Lists customer workloads for a given customer org id
https://cloud.google.com/sovereign-controls-by-partners/docs/sovereign-partners/reference/rest/v1/organizations.locations.customers.workloads/list

parent <string> Required. Parent resource Format: `organizations/{organization}/locations/{location}/customers/{customer}`

optional:
pageSize <integer> The maximum number of workloads to return. The service may return fewer than this value. If unspecified, at most 500 workloads will be returned.
filter <string> Optional. Filtering results.
orderBy <string> Optional. Hint for how to order the results."
  ([parent]
    (organizations-locations-customers-workloads-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudcontrolspartner.googleapis.com/v1/{+parent}/workloads",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-locations-customers-workloads-getEkmConnections
  "Gets the EKM connections associated with a workload
https://cloud.google.com/sovereign-controls-by-partners/docs/sovereign-partners/reference/rest/v1/organizations.locations.customers.workloads/getEkmConnections

name <string> Required. Format: `organizations/{organization}/locations/{location}/customers/{customer}/workloads/{workload}/ekmConnections`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://cloudcontrolspartner.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-locations-customers-workloads-getPartnerPermissions
  "Gets the partner permissions granted for a workload
https://cloud.google.com/sovereign-controls-by-partners/docs/sovereign-partners/reference/rest/v1/organizations.locations.customers.workloads/getPartnerPermissions

name <string> Required. Name of the resource to get in the format: `organizations/{organization}/locations/{location}/customers/{customer}/workloads/{workload}/partnerPermissions`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://cloudcontrolspartner.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-locations-customers-workloads-accessApprovalRequests-list
  "Lists access requests associated with a workload
https://cloud.google.com/sovereign-controls-by-partners/docs/sovereign-partners/reference/rest/v1/organizations.locations.customers.workloads.accessApprovalRequests/list

parent <string> Required. Parent resource Format: `organizations/{organization}/locations/{location}/customers/{customer}/workloads/{workload}`

optional:
pageSize <integer> Optional. The maximum number of access requests to return. The service may return fewer than this value. If unspecified, at most 500 access requests will be returned.
filter <string> Optional. Filtering results.
orderBy <string> Optional. Hint for how to order the results."
  ([parent]
    (organizations-locations-customers-workloads-accessApprovalRequests-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudcontrolspartner.googleapis.com/v1/{+parent}/accessApprovalRequests",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-locations-customers-workloads-violations-list
  "Lists Violations for a workload Callers may also choose to read across multiple Customers or for a single customer as per [AIP-159](https://google.aip.dev/159) by using '-' (the hyphen or dash character) as a wildcard character instead of {customer} & {workload}. Format: `organizations/{organization}/locations/{location}/customers/{customer}/workloads/{workload}`
https://cloud.google.com/sovereign-controls-by-partners/docs/sovereign-partners/reference/rest/v1/organizations.locations.customers.workloads.violations/list

parent <string> Required. Parent resource Format `organizations/{organization}/locations/{location}/customers/{customer}/workloads/{workload}`

optional:
pageSize <integer> Optional. The maximum number of customers row to return. The service may return fewer than this value. If unspecified, at most 10 customers will be returned.
filter <string> Optional. Filtering results
orderBy <string> Optional. Hint for how to order the results
interval.startTime <string> Optional. Inclusive start of the interval. If specified, a Timestamp matching this interval will have to be the same or after the start.
interval.endTime <string> Optional. Exclusive end of the interval. If specified, a Timestamp matching this interval will have to be before the end."
  ([parent]
    (organizations-locations-customers-workloads-violations-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudcontrolspartner.googleapis.com/v1/{+parent}/violations",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-locations-customers-workloads-violations-get
  "Gets details of a single Violation.
https://cloud.google.com/sovereign-controls-by-partners/docs/sovereign-partners/reference/rest/v1/organizations.locations.customers.workloads.violations/get

name <string> Required. Format: `organizations/{organization}/locations/{location}/customers/{customer}/workloads/{workload}/violations/{violation}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://cloudcontrolspartner.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

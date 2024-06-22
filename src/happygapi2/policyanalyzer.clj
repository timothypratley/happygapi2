(ns happygapi2.policyanalyzer
  "Policy Analyzer API

See: https://www.google.com"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-activityTypes-activities-query
  "Queries policy activities on Google Cloud resources.
https://cloud.google.com/policy-intelligence/docs/reference/policyanalyzer/rest/v1/projects.locations.activityTypes.activities/query

parent <string> Required. The container resource on which to execute the request. Acceptable formats: `projects/[PROJECT_ID|PROJECT_NUMBER]/locations/[LOCATION]/activityTypes/[ACTIVITY_TYPE]` LOCATION here refers to Google Cloud Locations: https://cloud.google.com/about/locations/

optional:
filter <string> Optional. Filter expression to restrict the activities returned. For serviceAccountLastAuthentication activities, supported filters are: - `activities.full_resource_name {=} [STRING]` - `activities.fullResourceName {=} [STRING]` where `[STRING]` is the full resource name of the service account. For serviceAccountKeyLastAuthentication activities, supported filters are: - `activities.full_resource_name {=} [STRING]` - `activities.fullResourceName {=} [STRING]` where `[STRING]` is the full resource name of the service account key.
pageSize <integer> Optional. The maximum number of results to return from this request. Max limit is 1000. Non-positive values are ignored. The presence of `nextPageToken` in the response indicates that more results might be available."
  ([parent]
    (projects-locations-activityTypes-activities-query parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://policyanalyzer.googleapis.com/v1/{+parent}/activities:query",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-locations-activityTypes-activities-query
  "Queries policy activities on Google Cloud resources.
https://cloud.google.com/policy-intelligence/docs/reference/policyanalyzer/rest/v1/organizations.locations.activityTypes.activities/query

parent <string> Required. The container resource on which to execute the request. Acceptable formats: `projects/[PROJECT_ID|PROJECT_NUMBER]/locations/[LOCATION]/activityTypes/[ACTIVITY_TYPE]` LOCATION here refers to Google Cloud Locations: https://cloud.google.com/about/locations/

optional:
filter <string> Optional. Filter expression to restrict the activities returned. For serviceAccountLastAuthentication activities, supported filters are: - `activities.full_resource_name {=} [STRING]` - `activities.fullResourceName {=} [STRING]` where `[STRING]` is the full resource name of the service account. For serviceAccountKeyLastAuthentication activities, supported filters are: - `activities.full_resource_name {=} [STRING]` - `activities.fullResourceName {=} [STRING]` where `[STRING]` is the full resource name of the service account key.
pageSize <integer> Optional. The maximum number of results to return from this request. Max limit is 1000. Non-positive values are ignored. The presence of `nextPageToken` in the response indicates that more results might be available."
  ([parent]
    (organizations-locations-activityTypes-activities-query
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://policyanalyzer.googleapis.com/v1/{+parent}/activities:query",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn folders-locations-activityTypes-activities-query
  "Queries policy activities on Google Cloud resources.
https://cloud.google.com/policy-intelligence/docs/reference/policyanalyzer/rest/v1/folders.locations.activityTypes.activities/query

parent <string> Required. The container resource on which to execute the request. Acceptable formats: `projects/[PROJECT_ID|PROJECT_NUMBER]/locations/[LOCATION]/activityTypes/[ACTIVITY_TYPE]` LOCATION here refers to Google Cloud Locations: https://cloud.google.com/about/locations/

optional:
filter <string> Optional. Filter expression to restrict the activities returned. For serviceAccountLastAuthentication activities, supported filters are: - `activities.full_resource_name {=} [STRING]` - `activities.fullResourceName {=} [STRING]` where `[STRING]` is the full resource name of the service account. For serviceAccountKeyLastAuthentication activities, supported filters are: - `activities.full_resource_name {=} [STRING]` - `activities.fullResourceName {=} [STRING]` where `[STRING]` is the full resource name of the service account key.
pageSize <integer> Optional. The maximum number of results to return from this request. Max limit is 1000. Non-positive values are ignored. The presence of `nextPageToken` in the response indicates that more results might be available."
  ([parent]
    (folders-locations-activityTypes-activities-query parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://policyanalyzer.googleapis.com/v1/{+parent}/activities:query",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

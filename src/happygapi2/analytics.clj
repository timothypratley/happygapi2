(ns happygapi2.analytics
  "Google Analytics API
Views and manages your Google Analytics data.
See: https://developers.google.com/analytics/"
  (:require [happy.oauth2.client :as client]))

(defn data-ga-get
  "Returns Analytics data for a view (profile).
https://developers.google.com/analytics

ids <string> Unique table ID for retrieving Analytics data. Table ID is of the form ga:XXXX, where XXXX is the Analytics view (profile) ID.
start-date <string> Start date for fetching Analytics data. Requests can specify a start date formatted as YYYY-MM-DD, or as a relative date (e.g., today, yesterday, or 7daysAgo). The default value is 7daysAgo.
end-date <string> End date for fetching Analytics data. Request can should specify an end date formatted as YYYY-MM-DD, or as a relative date (e.g., today, yesterday, or 7daysAgo). The default value is yesterday.
metrics <string> A comma-separated list of Analytics metrics. E.g., 'ga:sessions,ga:pageviews'. At least one metric must be specified.

optional:
start-index <integer> An index of the first entity to retrieve. Use this parameter as a pagination mechanism along with the max-results parameter.
include-empty-rows <boolean> The response will include empty rows if this parameter is set to true, the default is true
filters <string> A comma-separated list of dimension or metric filters to be applied to Analytics data.
max-results <integer> The maximum number of entries to include in this feed.
output <string> The selected format for the response. Default format is JSON.
dimensions <string> A comma-separated list of Analytics dimensions. E.g., 'ga:browser,ga:city'.
segment <string> An Analytics segment to be applied to data.
samplingLevel <string> The desired sampling level.
sort <string> A comma-separated list of dimensions or metrics that determine the sort order for Analytics data."
  ([ids start-date end-date metrics]
    (data-ga-get ids start-date end-date metrics nil))
  ([ids start-date end-date metrics optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://www.googleapis.com/analytics/v3/data/ga",
       :uri-template-args {},
       :query-params
       (merge
         {:end-date end-date,
          :ids ids,
          :start-date start-date,
          :metrics metrics}
         optional),
       :scopes
       ["https://www.googleapis.com/auth/analytics"
        "https://www.googleapis.com/auth/analytics.readonly"]})))

(defn data-mcf-get
  "Returns Analytics Multi-Channel Funnels data for a view (profile).
https://developers.google.com/analytics

ids <string> Unique table ID for retrieving Analytics data. Table ID is of the form ga:XXXX, where XXXX is the Analytics view (profile) ID.
start-date <string> Start date for fetching Analytics data. Requests can specify a start date formatted as YYYY-MM-DD, or as a relative date (e.g., today, yesterday, or 7daysAgo). The default value is 7daysAgo.
end-date <string> End date for fetching Analytics data. Requests can specify a start date formatted as YYYY-MM-DD, or as a relative date (e.g., today, yesterday, or 7daysAgo). The default value is 7daysAgo.
metrics <string> A comma-separated list of Multi-Channel Funnels metrics. E.g., 'mcf:totalConversions,mcf:totalConversionValue'. At least one metric must be specified.

optional:
start-index <integer> An index of the first entity to retrieve. Use this parameter as a pagination mechanism along with the max-results parameter.
filters <string> A comma-separated list of dimension or metric filters to be applied to the Analytics data.
max-results <integer> The maximum number of entries to include in this feed.
dimensions <string> A comma-separated list of Multi-Channel Funnels dimensions. E.g., 'mcf:source,mcf:medium'.
samplingLevel <string> The desired sampling level.
sort <string> A comma-separated list of dimensions or metrics that determine the sort order for the Analytics data."
  ([ids start-date end-date metrics]
    (data-mcf-get ids start-date end-date metrics nil))
  ([ids start-date end-date metrics optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/analytics/v3/data/mcf",
       :uri-template-args {},
       :query-params
       (merge
         {:end-date end-date,
          :ids ids,
          :start-date start-date,
          :metrics metrics}
         optional),
       :scopes
       ["https://www.googleapis.com/auth/analytics"
        "https://www.googleapis.com/auth/analytics.readonly"]})))

(defn data-realtime-get
  "Returns real time data for a view (profile).
https://developers.google.com/analytics

ids <string> Unique table ID for retrieving real time data. Table ID is of the form ga:XXXX, where XXXX is the Analytics view (profile) ID.
metrics <string> A comma-separated list of real time metrics. E.g., 'rt:activeUsers'. At least one metric must be specified.

optional:
dimensions <string> A comma-separated list of real time dimensions. E.g., 'rt:medium,rt:city'.
filters <string> A comma-separated list of dimension or metric filters to be applied to real time data.
max-results <integer> The maximum number of entries to include in this feed.
sort <string> A comma-separated list of dimensions or metrics that determine the sort order for real time data."
  ([ids metrics] (data-realtime-get ids metrics nil))
  ([ids metrics optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/analytics/v3/data/realtime",
       :uri-template-args {},
       :query-params (merge {:ids ids, :metrics metrics} optional),
       :scopes
       ["https://www.googleapis.com/auth/analytics"
        "https://www.googleapis.com/auth/analytics.readonly"]})))

(defn management-clientId-hashClientId
  "Hashes the given Client ID.
https://developers.google.com/analytics

HashClientIdRequest:
{:clientId string, :kind string, :webPropertyId string}"
  [HashClientIdRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/clientId:hashClientId",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics.edit"
      "https://www.googleapis.com/auth/analytics.readonly"],
     :body HashClientIdRequest}))

(defn management-goals-get
  "Gets a goal to which the user has access.
https://developers.google.com/analytics

accountId <string> Account ID to retrieve the goal for.
webPropertyId <string> Web property ID to retrieve the goal for.
profileId <string> View (Profile) ID to retrieve the goal for.
goalId <string> Goal ID to retrieve the goal for."
  [accountId webPropertyId profileId goalId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/goals/{goalId}",
     :uri-template-args
     {:accountId accountId,
      :goalId goalId,
      :profileId profileId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics.edit"
      "https://www.googleapis.com/auth/analytics.readonly"]}))

(defn management-goals-insert
  "Create a new goal.
https://developers.google.com/analytics

accountId <string> Account ID to create the goal for.
webPropertyId <string> Web property ID to create the goal for.
profileId <string> View (Profile) ID to create the goal for.
Goal:
{:eventDetails
 {:eventConditions
  [{:comparisonType string,
    :comparisonValue string,
    :expression string,
    :matchType string,
    :type string}],
  :useEventValue boolean},
 :updated string,
 :visitNumPagesDetails
 {:comparisonType string, :comparisonValue string},
 :name string,
 :value number,
 :selfLink string,
 :type string,
 :urlDestinationDetails
 {:caseSensitive boolean,
  :firstStepRequired boolean,
  :matchType string,
  :steps [{:name string, :number integer, :url string}],
  :url string},
 :created string,
 :parentLink {:href string, :type string},
 :visitTimeOnSiteDetails
 {:comparisonType string, :comparisonValue string},
 :webPropertyId string,
 :active boolean,
 :id string,
 :kind string,
 :internalWebPropertyId string,
 :profileId string,
 :accountId string}"
  [accountId webPropertyId profileId Goal]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/goals",
     :uri-template-args
     {:accountId accountId,
      :profileId profileId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"],
     :body Goal}))

(defn management-goals-list
  "Lists goals to which the user has access.
https://developers.google.com/analytics

accountId <string> Account ID to retrieve goals for. Can either be a specific account ID or '~all', which refers to all the accounts that user has access to.
webPropertyId <string> Web property ID to retrieve goals for. Can either be a specific web property ID or '~all', which refers to all the web properties that user has access to.
profileId <string> View (Profile) ID to retrieve goals for. Can either be a specific view (profile) ID or '~all', which refers to all the views (profiles) that user has access to.

optional:
max-results <integer> The maximum number of goals to include in this response.
start-index <integer> An index of the first goal to retrieve. Use this parameter as a pagination mechanism along with the max-results parameter."
  ([accountId webPropertyId profileId]
    (management-goals-list accountId webPropertyId profileId nil))
  ([accountId webPropertyId profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/goals",
       :uri-template-args
       {:accountId accountId,
        :profileId profileId,
        :webPropertyId webPropertyId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/analytics"
        "https://www.googleapis.com/auth/analytics.edit"
        "https://www.googleapis.com/auth/analytics.readonly"]})))

(defn management-goals-patch
  "Updates an existing goal. This method supports patch semantics.
https://developers.google.com/analytics

accountId <string> Account ID to update the goal.
webPropertyId <string> Web property ID to update the goal.
profileId <string> View (Profile) ID to update the goal.
goalId <string> Index of the goal to be updated.
Goal:
{:eventDetails
 {:eventConditions
  [{:comparisonType string,
    :comparisonValue string,
    :expression string,
    :matchType string,
    :type string}],
  :useEventValue boolean},
 :updated string,
 :visitNumPagesDetails
 {:comparisonType string, :comparisonValue string},
 :name string,
 :value number,
 :selfLink string,
 :type string,
 :urlDestinationDetails
 {:caseSensitive boolean,
  :firstStepRequired boolean,
  :matchType string,
  :steps [{:name string, :number integer, :url string}],
  :url string},
 :created string,
 :parentLink {:href string, :type string},
 :visitTimeOnSiteDetails
 {:comparisonType string, :comparisonValue string},
 :webPropertyId string,
 :active boolean,
 :id string,
 :kind string,
 :internalWebPropertyId string,
 :profileId string,
 :accountId string}"
  [accountId webPropertyId profileId goalId Goal]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/goals/{goalId}",
     :uri-template-args
     {:accountId accountId,
      :goalId goalId,
      :profileId profileId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"],
     :body Goal}))

(defn management-goals-update
  "Updates an existing goal.
https://developers.google.com/analytics

accountId <string> Account ID to update the goal.
webPropertyId <string> Web property ID to update the goal.
profileId <string> View (Profile) ID to update the goal.
goalId <string> Index of the goal to be updated.
Goal:
{:eventDetails
 {:eventConditions
  [{:comparisonType string,
    :comparisonValue string,
    :expression string,
    :matchType string,
    :type string}],
  :useEventValue boolean},
 :updated string,
 :visitNumPagesDetails
 {:comparisonType string, :comparisonValue string},
 :name string,
 :value number,
 :selfLink string,
 :type string,
 :urlDestinationDetails
 {:caseSensitive boolean,
  :firstStepRequired boolean,
  :matchType string,
  :steps [{:name string, :number integer, :url string}],
  :url string},
 :created string,
 :parentLink {:href string, :type string},
 :visitTimeOnSiteDetails
 {:comparisonType string, :comparisonValue string},
 :webPropertyId string,
 :active boolean,
 :id string,
 :kind string,
 :internalWebPropertyId string,
 :profileId string,
 :accountId string}"
  [accountId webPropertyId profileId goalId Goal]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/goals/{goalId}",
     :uri-template-args
     {:accountId accountId,
      :goalId goalId,
      :profileId profileId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"],
     :body Goal}))

(defn management-experiments-delete
  "Delete an experiment.
https://developers.google.com/analytics

accountId <string> Account ID to which the experiment belongs
webPropertyId <string> Web property ID to which the experiment belongs
profileId <string> View (Profile) ID to which the experiment belongs
experimentId <string> ID of the experiment to delete"
  [accountId webPropertyId profileId experimentId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/experiments/{experimentId}",
     :uri-template-args
     {:accountId accountId,
      :experimentId experimentId,
      :profileId profileId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics"
      "https://www.googleapis.com/auth/analytics.edit"]}))

(defn management-experiments-get
  "Returns an experiment to which the user has access.
https://developers.google.com/analytics

accountId <string> Account ID to retrieve the experiment for.
webPropertyId <string> Web property ID to retrieve the experiment for.
profileId <string> View (Profile) ID to retrieve the experiment for.
experimentId <string> Experiment ID to retrieve the experiment for."
  [accountId webPropertyId profileId experimentId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/experiments/{experimentId}",
     :uri-template-args
     {:accountId accountId,
      :experimentId experimentId,
      :profileId profileId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics"
      "https://www.googleapis.com/auth/analytics.edit"
      "https://www.googleapis.com/auth/analytics.readonly"]}))

(defn management-experiments-insert
  "Create a new experiment.
https://developers.google.com/analytics

accountId <string> Account ID to create the experiment for.
webPropertyId <string> Web property ID to create the experiment for.
profileId <string> View (Profile) ID to create the experiment for.
Experiment:
{:description string,
 :equalWeighting boolean,
 :winnerFound boolean,
 :trafficCoverage number,
 :startTime string,
 :updated string,
 :name string,
 :rewriteVariationUrlsAsOriginal boolean,
 :endTime string,
 :snippet string,
 :selfLink string,
 :created string,
 :minimumExperimentLengthInDays integer,
 :parentLink {:href string, :type string},
 :webPropertyId string,
 :reasonExperimentEnded string,
 :objectiveMetric string,
 :winnerConfidenceLevel number,
 :editableInGaUi boolean,
 :status string,
 :id string,
 :kind string,
 :internalWebPropertyId string,
 :profileId string,
 :servingFramework string,
 :variations
 [{:name string,
   :status string,
   :url string,
   :weight number,
   :won boolean}],
 :accountId string,
 :optimizationType string}"
  [accountId webPropertyId profileId Experiment]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/experiments",
     :uri-template-args
     {:accountId accountId,
      :profileId profileId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics"
      "https://www.googleapis.com/auth/analytics.edit"],
     :body Experiment}))

(defn management-experiments-list
  "Lists experiments to which the user has access.
https://developers.google.com/analytics

accountId <string> Account ID to retrieve experiments for.
webPropertyId <string> Web property ID to retrieve experiments for.
profileId <string> View (Profile) ID to retrieve experiments for.

optional:
max-results <integer> The maximum number of experiments to include in this response.
start-index <integer> An index of the first experiment to retrieve. Use this parameter as a pagination mechanism along with the max-results parameter."
  ([accountId webPropertyId profileId]
    (management-experiments-list
      accountId
      webPropertyId
      profileId
      nil))
  ([accountId webPropertyId profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/experiments",
       :uri-template-args
       {:accountId accountId,
        :profileId profileId,
        :webPropertyId webPropertyId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/analytics"
        "https://www.googleapis.com/auth/analytics.edit"
        "https://www.googleapis.com/auth/analytics.readonly"]})))

(defn management-experiments-patch
  "Update an existing experiment. This method supports patch semantics.
https://developers.google.com/analytics

accountId <string> Account ID of the experiment to update.
webPropertyId <string> Web property ID of the experiment to update.
profileId <string> View (Profile) ID of the experiment to update.
experimentId <string> Experiment ID of the experiment to update.
Experiment:
{:description string,
 :equalWeighting boolean,
 :winnerFound boolean,
 :trafficCoverage number,
 :startTime string,
 :updated string,
 :name string,
 :rewriteVariationUrlsAsOriginal boolean,
 :endTime string,
 :snippet string,
 :selfLink string,
 :created string,
 :minimumExperimentLengthInDays integer,
 :parentLink {:href string, :type string},
 :webPropertyId string,
 :reasonExperimentEnded string,
 :objectiveMetric string,
 :winnerConfidenceLevel number,
 :editableInGaUi boolean,
 :status string,
 :id string,
 :kind string,
 :internalWebPropertyId string,
 :profileId string,
 :servingFramework string,
 :variations
 [{:name string,
   :status string,
   :url string,
   :weight number,
   :won boolean}],
 :accountId string,
 :optimizationType string}"
  [accountId webPropertyId profileId experimentId Experiment]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/experiments/{experimentId}",
     :uri-template-args
     {:accountId accountId,
      :experimentId experimentId,
      :profileId profileId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics"
      "https://www.googleapis.com/auth/analytics.edit"],
     :body Experiment}))

(defn management-experiments-update
  "Update an existing experiment.
https://developers.google.com/analytics

accountId <string> Account ID of the experiment to update.
webPropertyId <string> Web property ID of the experiment to update.
profileId <string> View (Profile) ID of the experiment to update.
experimentId <string> Experiment ID of the experiment to update.
Experiment:
{:description string,
 :equalWeighting boolean,
 :winnerFound boolean,
 :trafficCoverage number,
 :startTime string,
 :updated string,
 :name string,
 :rewriteVariationUrlsAsOriginal boolean,
 :endTime string,
 :snippet string,
 :selfLink string,
 :created string,
 :minimumExperimentLengthInDays integer,
 :parentLink {:href string, :type string},
 :webPropertyId string,
 :reasonExperimentEnded string,
 :objectiveMetric string,
 :winnerConfidenceLevel number,
 :editableInGaUi boolean,
 :status string,
 :id string,
 :kind string,
 :internalWebPropertyId string,
 :profileId string,
 :servingFramework string,
 :variations
 [{:name string,
   :status string,
   :url string,
   :weight number,
   :won boolean}],
 :accountId string,
 :optimizationType string}"
  [accountId webPropertyId profileId experimentId Experiment]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/experiments/{experimentId}",
     :uri-template-args
     {:accountId accountId,
      :experimentId experimentId,
      :profileId profileId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics"
      "https://www.googleapis.com/auth/analytics.edit"],
     :body Experiment}))

(defn management-profileFilterLinks-delete
  "Delete a profile filter link.
https://developers.google.com/analytics

accountId <string> Account ID to which the profile filter link belongs.
webPropertyId <string> Web property Id to which the profile filter link belongs.
profileId <string> Profile ID to which the filter link belongs.
linkId <string> ID of the profile filter link to delete."
  [accountId webPropertyId profileId linkId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/profileFilterLinks/{linkId}",
     :uri-template-args
     {:accountId accountId,
      :linkId linkId,
      :profileId profileId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"]}))

(defn management-profileFilterLinks-get
  "Returns a single profile filter link.
https://developers.google.com/analytics

accountId <string> Account ID to retrieve profile filter link for.
webPropertyId <string> Web property Id to retrieve profile filter link for.
profileId <string> Profile ID to retrieve filter link for.
linkId <string> ID of the profile filter link."
  [accountId webPropertyId profileId linkId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/profileFilterLinks/{linkId}",
     :uri-template-args
     {:accountId accountId,
      :linkId linkId,
      :profileId profileId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics.edit"
      "https://www.googleapis.com/auth/analytics.readonly"]}))

(defn management-profileFilterLinks-insert
  "Create a new profile filter link.
https://developers.google.com/analytics

accountId <string> Account ID to create profile filter link for.
webPropertyId <string> Web property Id to create profile filter link for.
profileId <string> Profile ID to create filter link for.
ProfileFilterLink:
{:filterRef
 {:accountId string,
  :href string,
  :id string,
  :kind string,
  :name string},
 :id string,
 :kind string,
 :profileRef
 {:accountId string,
  :href string,
  :id string,
  :internalWebPropertyId string,
  :kind string,
  :name string,
  :webPropertyId string},
 :rank integer,
 :selfLink string}"
  [accountId webPropertyId profileId ProfileFilterLink]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/profileFilterLinks",
     :uri-template-args
     {:accountId accountId,
      :profileId profileId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"],
     :body ProfileFilterLink}))

(defn management-profileFilterLinks-list
  "Lists all profile filter links for a profile.
https://developers.google.com/analytics

accountId <string> Account ID to retrieve profile filter links for.
webPropertyId <string> Web property Id for profile filter links for. Can either be a specific web property ID or '~all', which refers to all the web properties that user has access to.
profileId <string> Profile ID to retrieve filter links for. Can either be a specific profile ID or '~all', which refers to all the profiles that user has access to.

optional:
max-results <integer> The maximum number of profile filter links to include in this response.
start-index <integer> An index of the first entity to retrieve. Use this parameter as a pagination mechanism along with the max-results parameter."
  ([accountId webPropertyId profileId]
    (management-profileFilterLinks-list
      accountId
      webPropertyId
      profileId
      nil))
  ([accountId webPropertyId profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/profileFilterLinks",
       :uri-template-args
       {:accountId accountId,
        :profileId profileId,
        :webPropertyId webPropertyId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/analytics.edit"
        "https://www.googleapis.com/auth/analytics.readonly"]})))

(defn management-profileFilterLinks-patch
  "Update an existing profile filter link. This method supports patch semantics.
https://developers.google.com/analytics

accountId <string> Account ID to which profile filter link belongs.
webPropertyId <string> Web property Id to which profile filter link belongs
profileId <string> Profile ID to which filter link belongs
linkId <string> ID of the profile filter link to be updated.
ProfileFilterLink:
{:filterRef
 {:accountId string,
  :href string,
  :id string,
  :kind string,
  :name string},
 :id string,
 :kind string,
 :profileRef
 {:accountId string,
  :href string,
  :id string,
  :internalWebPropertyId string,
  :kind string,
  :name string,
  :webPropertyId string},
 :rank integer,
 :selfLink string}"
  [accountId webPropertyId profileId linkId ProfileFilterLink]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/profileFilterLinks/{linkId}",
     :uri-template-args
     {:accountId accountId,
      :linkId linkId,
      :profileId profileId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"],
     :body ProfileFilterLink}))

(defn management-profileFilterLinks-update
  "Update an existing profile filter link.
https://developers.google.com/analytics

accountId <string> Account ID to which profile filter link belongs.
webPropertyId <string> Web property Id to which profile filter link belongs
profileId <string> Profile ID to which filter link belongs
linkId <string> ID of the profile filter link to be updated.
ProfileFilterLink:
{:filterRef
 {:accountId string,
  :href string,
  :id string,
  :kind string,
  :name string},
 :id string,
 :kind string,
 :profileRef
 {:accountId string,
  :href string,
  :id string,
  :internalWebPropertyId string,
  :kind string,
  :name string,
  :webPropertyId string},
 :rank integer,
 :selfLink string}"
  [accountId webPropertyId profileId linkId ProfileFilterLink]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/profileFilterLinks/{linkId}",
     :uri-template-args
     {:accountId accountId,
      :linkId linkId,
      :profileId profileId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"],
     :body ProfileFilterLink}))

(defn management-filters-delete
  "Delete a filter.
https://developers.google.com/analytics

accountId <string> Account ID to delete the filter for.
filterId <string> ID of the filter to be deleted."
  [accountId filterId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/filters/{filterId}",
     :uri-template-args {:accountId accountId, :filterId filterId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"]}))

(defn management-filters-get
  "Returns filters to which the user has access.
https://developers.google.com/analytics

accountId <string> Account ID to retrieve filters for.
filterId <string> Filter ID to retrieve filters for."
  [accountId filterId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/filters/{filterId}",
     :uri-template-args {:accountId accountId, :filterId filterId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics.edit"
      "https://www.googleapis.com/auth/analytics.readonly"]}))

(defn management-filters-insert
  "Create a new filter.
https://developers.google.com/analytics

accountId <string> Account ID to create filter for.
Filter:
{:advancedDetails
 {:fieldAIndex integer,
  :outputToFieldIndex integer,
  :fieldA string,
  :extractB string,
  :fieldB string,
  :outputConstructor string,
  :outputToField string,
  :fieldBRequired boolean,
  :fieldARequired boolean,
  :extractA string,
  :caseSensitive boolean,
  :overrideOutputField boolean,
  :fieldBIndex integer},
 :searchAndReplaceDetails
 {:caseSensitive boolean,
  :field string,
  :fieldIndex integer,
  :replaceString string,
  :searchString string},
 :updated string,
 :name string,
 :selfLink string,
 :type string,
 :created string,
 :parentLink {:href string, :type string},
 :uppercaseDetails {:field string, :fieldIndex integer},
 :lowercaseDetails {:field string, :fieldIndex integer},
 :id string,
 :kind string,
 :includeDetails
 {:caseSensitive boolean,
  :expressionValue string,
  :field string,
  :fieldIndex integer,
  :kind string,
  :matchType string},
 :excludeDetails
 {:caseSensitive boolean,
  :expressionValue string,
  :field string,
  :fieldIndex integer,
  :kind string,
  :matchType string},
 :accountId string}"
  [accountId Filter]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/filters",
     :uri-template-args {:accountId accountId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"],
     :body Filter}))

(defn management-filters-list
  "Lists all filters for an account
https://developers.google.com/analytics

accountId <string> Account ID to retrieve filters for.

optional:
max-results <integer> The maximum number of filters to include in this response.
start-index <integer> An index of the first entity to retrieve. Use this parameter as a pagination mechanism along with the max-results parameter."
  ([accountId] (management-filters-list accountId nil))
  ([accountId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/filters",
       :uri-template-args {:accountId accountId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/analytics.edit"
        "https://www.googleapis.com/auth/analytics.readonly"]})))

(defn management-filters-patch
  "Updates an existing filter. This method supports patch semantics.
https://developers.google.com/analytics

accountId <string> Account ID to which the filter belongs.
filterId <string> ID of the filter to be updated.
Filter:
{:advancedDetails
 {:fieldAIndex integer,
  :outputToFieldIndex integer,
  :fieldA string,
  :extractB string,
  :fieldB string,
  :outputConstructor string,
  :outputToField string,
  :fieldBRequired boolean,
  :fieldARequired boolean,
  :extractA string,
  :caseSensitive boolean,
  :overrideOutputField boolean,
  :fieldBIndex integer},
 :searchAndReplaceDetails
 {:caseSensitive boolean,
  :field string,
  :fieldIndex integer,
  :replaceString string,
  :searchString string},
 :updated string,
 :name string,
 :selfLink string,
 :type string,
 :created string,
 :parentLink {:href string, :type string},
 :uppercaseDetails {:field string, :fieldIndex integer},
 :lowercaseDetails {:field string, :fieldIndex integer},
 :id string,
 :kind string,
 :includeDetails
 {:caseSensitive boolean,
  :expressionValue string,
  :field string,
  :fieldIndex integer,
  :kind string,
  :matchType string},
 :excludeDetails
 {:caseSensitive boolean,
  :expressionValue string,
  :field string,
  :fieldIndex integer,
  :kind string,
  :matchType string},
 :accountId string}"
  [accountId filterId Filter]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/filters/{filterId}",
     :uri-template-args {:accountId accountId, :filterId filterId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"],
     :body Filter}))

(defn management-filters-update
  "Updates an existing filter.
https://developers.google.com/analytics

accountId <string> Account ID to which the filter belongs.
filterId <string> ID of the filter to be updated.
Filter:
{:advancedDetails
 {:fieldAIndex integer,
  :outputToFieldIndex integer,
  :fieldA string,
  :extractB string,
  :fieldB string,
  :outputConstructor string,
  :outputToField string,
  :fieldBRequired boolean,
  :fieldARequired boolean,
  :extractA string,
  :caseSensitive boolean,
  :overrideOutputField boolean,
  :fieldBIndex integer},
 :searchAndReplaceDetails
 {:caseSensitive boolean,
  :field string,
  :fieldIndex integer,
  :replaceString string,
  :searchString string},
 :updated string,
 :name string,
 :selfLink string,
 :type string,
 :created string,
 :parentLink {:href string, :type string},
 :uppercaseDetails {:field string, :fieldIndex integer},
 :lowercaseDetails {:field string, :fieldIndex integer},
 :id string,
 :kind string,
 :includeDetails
 {:caseSensitive boolean,
  :expressionValue string,
  :field string,
  :fieldIndex integer,
  :kind string,
  :matchType string},
 :excludeDetails
 {:caseSensitive boolean,
  :expressionValue string,
  :field string,
  :fieldIndex integer,
  :kind string,
  :matchType string},
 :accountId string}"
  [accountId filterId Filter]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/filters/{filterId}",
     :uri-template-args {:accountId accountId, :filterId filterId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"],
     :body Filter}))

(defn management-customMetrics-get
  "Get a custom metric to which the user has access.
https://developers.google.com/analytics

accountId <string> Account ID for the custom metric to retrieve.
webPropertyId <string> Web property ID for the custom metric to retrieve.
customMetricId <string> The ID of the custom metric to retrieve."
  [accountId webPropertyId customMetricId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/customMetrics/{customMetricId}",
     :uri-template-args
     {:accountId accountId,
      :customMetricId customMetricId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics.edit"
      "https://www.googleapis.com/auth/analytics.readonly"]}))

(defn management-customMetrics-insert
  "Create a new custom metric.
https://developers.google.com/analytics

accountId <string> Account ID for the custom metric to create.
webPropertyId <string> Web property ID for the custom dimension to create.
CustomMetric:
{:max_value string,
 :index integer,
 :updated string,
 :name string,
 :selfLink string,
 :type string,
 :created string,
 :scope string,
 :parentLink {:href string, :type string},
 :webPropertyId string,
 :min_value string,
 :active boolean,
 :id string,
 :kind string,
 :accountId string}"
  [accountId webPropertyId CustomMetric]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/customMetrics",
     :uri-template-args
     {:accountId accountId, :webPropertyId webPropertyId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"],
     :body CustomMetric}))

(defn management-customMetrics-list
  "Lists custom metrics to which the user has access.
https://developers.google.com/analytics

accountId <string> Account ID for the custom metrics to retrieve.
webPropertyId <string> Web property ID for the custom metrics to retrieve.

optional:
max-results <integer> The maximum number of custom metrics to include in this response.
start-index <integer> An index of the first entity to retrieve. Use this parameter as a pagination mechanism along with the max-results parameter."
  ([accountId webPropertyId]
    (management-customMetrics-list accountId webPropertyId nil))
  ([accountId webPropertyId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/customMetrics",
       :uri-template-args
       {:accountId accountId, :webPropertyId webPropertyId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/analytics"
        "https://www.googleapis.com/auth/analytics.readonly"]})))

(defn management-customMetrics-patch
  "Updates an existing custom metric. This method supports patch semantics.
https://developers.google.com/analytics

accountId <string> Account ID for the custom metric to update.
webPropertyId <string> Web property ID for the custom metric to update.
customMetricId <string> Custom metric ID for the custom metric to update.
CustomMetric:
{:max_value string,
 :index integer,
 :updated string,
 :name string,
 :selfLink string,
 :type string,
 :created string,
 :scope string,
 :parentLink {:href string, :type string},
 :webPropertyId string,
 :min_value string,
 :active boolean,
 :id string,
 :kind string,
 :accountId string}

optional:
ignoreCustomDataSourceLinks <boolean> Force the update and ignore any warnings related to the custom metric being linked to a custom data source / data set."
  ([accountId webPropertyId customMetricId CustomMetric]
    (management-customMetrics-patch
      accountId
      webPropertyId
      customMetricId
      CustomMetric
      nil))
  ([accountId webPropertyId customMetricId CustomMetric optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/customMetrics/{customMetricId}",
       :uri-template-args
       {:accountId accountId,
        :customMetricId customMetricId,
        :webPropertyId webPropertyId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/analytics.edit"],
       :body CustomMetric})))

(defn management-customMetrics-update
  "Updates an existing custom metric.
https://developers.google.com/analytics

accountId <string> Account ID for the custom metric to update.
webPropertyId <string> Web property ID for the custom metric to update.
customMetricId <string> Custom metric ID for the custom metric to update.
CustomMetric:
{:max_value string,
 :index integer,
 :updated string,
 :name string,
 :selfLink string,
 :type string,
 :created string,
 :scope string,
 :parentLink {:href string, :type string},
 :webPropertyId string,
 :min_value string,
 :active boolean,
 :id string,
 :kind string,
 :accountId string}

optional:
ignoreCustomDataSourceLinks <boolean> Force the update and ignore any warnings related to the custom metric being linked to a custom data source / data set."
  ([accountId webPropertyId customMetricId CustomMetric]
    (management-customMetrics-update
      accountId
      webPropertyId
      customMetricId
      CustomMetric
      nil))
  ([accountId webPropertyId customMetricId CustomMetric optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/customMetrics/{customMetricId}",
       :uri-template-args
       {:accountId accountId,
        :customMetricId customMetricId,
        :webPropertyId webPropertyId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/analytics.edit"],
       :body CustomMetric})))

(defn management-webpropertyUserLinks-delete
  "Removes a user from the given web property.
https://developers.google.com/analytics

accountId <string> Account ID to delete the user link for.
webPropertyId <string> Web Property ID to delete the user link for.
linkId <string> Link ID to delete the user link for."
  [accountId webPropertyId linkId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/entityUserLinks/{linkId}",
     :uri-template-args
     {:accountId accountId,
      :linkId linkId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics.manage.users"]}))

(defn management-webpropertyUserLinks-insert
  "Adds a new user to the given web property.
https://developers.google.com/analytics

accountId <string> Account ID to create the user link for.
webPropertyId <string> Web Property ID to create the user link for.
EntityUserLink:
{:entity
 {:accountRef {:href string, :id string, :kind string, :name string},
  :profileRef
  {:accountId string,
   :href string,
   :id string,
   :internalWebPropertyId string,
   :kind string,
   :name string,
   :webPropertyId string},
  :webPropertyRef
  {:accountId string,
   :href string,
   :id string,
   :internalWebPropertyId string,
   :kind string,
   :name string}},
 :id string,
 :kind string,
 :permissions {:effective [string], :local [string]},
 :selfLink string,
 :userRef {:email string, :id string, :kind string}}"
  [accountId webPropertyId EntityUserLink]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/entityUserLinks",
     :uri-template-args
     {:accountId accountId, :webPropertyId webPropertyId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics.manage.users"],
     :body EntityUserLink}))

(defn management-webpropertyUserLinks-list
  "Lists webProperty-user links for a given web property.
https://developers.google.com/analytics

accountId <string> Account ID which the given web property belongs to.
webPropertyId <string> Web Property ID for the webProperty-user links to retrieve. Can either be a specific web property ID or '~all', which refers to all the web properties that user has access to.

optional:
max-results <integer> The maximum number of webProperty-user Links to include in this response.
start-index <integer> An index of the first webProperty-user link to retrieve. Use this parameter as a pagination mechanism along with the max-results parameter."
  ([accountId webPropertyId]
    (management-webpropertyUserLinks-list accountId webPropertyId nil))
  ([accountId webPropertyId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/entityUserLinks",
       :uri-template-args
       {:accountId accountId, :webPropertyId webPropertyId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/analytics.manage.users"
        "https://www.googleapis.com/auth/analytics.manage.users.readonly"]})))

(defn management-webpropertyUserLinks-update
  "Updates permissions for an existing user on the given web property.
https://developers.google.com/analytics

accountId <string> Account ID to update the account-user link for.
webPropertyId <string> Web property ID to update the account-user link for.
linkId <string> Link ID to update the account-user link for.
EntityUserLink:
{:entity
 {:accountRef {:href string, :id string, :kind string, :name string},
  :profileRef
  {:accountId string,
   :href string,
   :id string,
   :internalWebPropertyId string,
   :kind string,
   :name string,
   :webPropertyId string},
  :webPropertyRef
  {:accountId string,
   :href string,
   :id string,
   :internalWebPropertyId string,
   :kind string,
   :name string}},
 :id string,
 :kind string,
 :permissions {:effective [string], :local [string]},
 :selfLink string,
 :userRef {:email string, :id string, :kind string}}"
  [accountId webPropertyId linkId EntityUserLink]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/entityUserLinks/{linkId}",
     :uri-template-args
     {:accountId accountId,
      :linkId linkId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics.manage.users"],
     :body EntityUserLink}))

(defn management-webPropertyAdWordsLinks-delete
  "Deletes a web property-Google Ads link.
https://developers.google.com/analytics

accountId <string> ID of the account which the given web property belongs to.
webPropertyId <string> Web property ID to delete the Google Ads link for.
webPropertyAdWordsLinkId <string> Web property Google Ads link ID."
  [accountId webPropertyId webPropertyAdWordsLinkId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/entityAdWordsLinks/{webPropertyAdWordsLinkId}",
     :uri-template-args
     {:accountId accountId,
      :webPropertyAdWordsLinkId webPropertyAdWordsLinkId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"]}))

(defn management-webPropertyAdWordsLinks-get
  "Returns a web property-Google Ads link to which the user has access.
https://developers.google.com/analytics

accountId <string> ID of the account which the given web property belongs to.
webPropertyId <string> Web property ID to retrieve the Google Ads link for.
webPropertyAdWordsLinkId <string> Web property-Google Ads link ID."
  [accountId webPropertyId webPropertyAdWordsLinkId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/entityAdWordsLinks/{webPropertyAdWordsLinkId}",
     :uri-template-args
     {:accountId accountId,
      :webPropertyAdWordsLinkId webPropertyAdWordsLinkId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics.edit"
      "https://www.googleapis.com/auth/analytics.readonly"]}))

(defn management-webPropertyAdWordsLinks-insert
  "Creates a webProperty-Google Ads link.
https://developers.google.com/analytics

accountId <string> ID of the Google Analytics account to create the link for.
webPropertyId <string> Web property ID to create the link for.
EntityAdWordsLink:
{:adWordsAccounts
 [{:autoTaggingEnabled boolean, :customerId string, :kind string}],
 :entity
 {:webPropertyRef
  {:accountId string,
   :href string,
   :id string,
   :internalWebPropertyId string,
   :kind string,
   :name string}},
 :id string,
 :kind string,
 :name string,
 :profileIds [string],
 :selfLink string}"
  [accountId webPropertyId EntityAdWordsLink]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/entityAdWordsLinks",
     :uri-template-args
     {:accountId accountId, :webPropertyId webPropertyId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"],
     :body EntityAdWordsLink}))

(defn management-webPropertyAdWordsLinks-list
  "Lists webProperty-Google Ads links for a given web property.
https://developers.google.com/analytics

accountId <string> ID of the account which the given web property belongs to.
webPropertyId <string> Web property ID to retrieve the Google Ads links for.

optional:
max-results <integer> The maximum number of webProperty-Google Ads links to include in this response.
start-index <integer> An index of the first webProperty-Google Ads link to retrieve. Use this parameter as a pagination mechanism along with the max-results parameter."
  ([accountId webPropertyId]
    (management-webPropertyAdWordsLinks-list
      accountId
      webPropertyId
      nil))
  ([accountId webPropertyId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/entityAdWordsLinks",
       :uri-template-args
       {:accountId accountId, :webPropertyId webPropertyId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/analytics.edit"
        "https://www.googleapis.com/auth/analytics.readonly"]})))

(defn management-webPropertyAdWordsLinks-patch
  "Updates an existing webProperty-Google Ads link. This method supports patch semantics.
https://developers.google.com/analytics

accountId <string> ID of the account which the given web property belongs to.
webPropertyId <string> Web property ID to retrieve the Google Ads link for.
webPropertyAdWordsLinkId <string> Web property-Google Ads link ID.
EntityAdWordsLink:
{:adWordsAccounts
 [{:autoTaggingEnabled boolean, :customerId string, :kind string}],
 :entity
 {:webPropertyRef
  {:accountId string,
   :href string,
   :id string,
   :internalWebPropertyId string,
   :kind string,
   :name string}},
 :id string,
 :kind string,
 :name string,
 :profileIds [string],
 :selfLink string}"
  [accountId webPropertyId webPropertyAdWordsLinkId EntityAdWordsLink]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/entityAdWordsLinks/{webPropertyAdWordsLinkId}",
     :uri-template-args
     {:accountId accountId,
      :webPropertyAdWordsLinkId webPropertyAdWordsLinkId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"],
     :body EntityAdWordsLink}))

(defn management-webPropertyAdWordsLinks-update
  "Updates an existing webProperty-Google Ads link.
https://developers.google.com/analytics

accountId <string> ID of the account which the given web property belongs to.
webPropertyId <string> Web property ID to retrieve the Google Ads link for.
webPropertyAdWordsLinkId <string> Web property-Google Ads link ID.
EntityAdWordsLink:
{:adWordsAccounts
 [{:autoTaggingEnabled boolean, :customerId string, :kind string}],
 :entity
 {:webPropertyRef
  {:accountId string,
   :href string,
   :id string,
   :internalWebPropertyId string,
   :kind string,
   :name string}},
 :id string,
 :kind string,
 :name string,
 :profileIds [string],
 :selfLink string}"
  [accountId webPropertyId webPropertyAdWordsLinkId EntityAdWordsLink]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/entityAdWordsLinks/{webPropertyAdWordsLinkId}",
     :uri-template-args
     {:accountId accountId,
      :webPropertyAdWordsLinkId webPropertyAdWordsLinkId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"],
     :body EntityAdWordsLink}))

(defn management-webproperties-get
  "Gets a web property to which the user has access.
https://developers.google.com/analytics

accountId <string> Account ID to retrieve the web property for.
webPropertyId <string> ID to retrieve the web property for."
  [accountId webPropertyId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}",
     :uri-template-args
     {:accountId accountId, :webPropertyId webPropertyId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics.edit"
      "https://www.googleapis.com/auth/analytics.readonly"]}))

(defn management-webproperties-insert
  "Create a new property if the account has fewer than 20 properties. Web properties are visible in the Google Analytics interface only if they have at least one profile.
https://developers.google.com/analytics

accountId <string> Account ID to create the web property for.
Webproperty:
{:permissions {:effective [string]},
 :defaultProfileId string,
 :starred boolean,
 :websiteUrl string,
 :updated string,
 :name string,
 :industryVertical string,
 :selfLink string,
 :created string,
 :parentLink {:href string, :type string},
 :level string,
 :id string,
 :kind string,
 :childLink {:href string, :type string},
 :internalWebPropertyId string,
 :dataRetentionTtl string,
 :profileCount integer,
 :dataRetentionResetOnNewActivity boolean,
 :accountId string}"
  [accountId Webproperty]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties",
     :uri-template-args {:accountId accountId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"],
     :body Webproperty}))

(defn management-webproperties-list
  "Lists web properties to which the user has access.
https://developers.google.com/analytics

accountId <string> Account ID to retrieve web properties for. Can either be a specific account ID or '~all', which refers to all the accounts that user has access to.

optional:
max-results <integer> The maximum number of web properties to include in this response.
start-index <integer> An index of the first entity to retrieve. Use this parameter as a pagination mechanism along with the max-results parameter."
  ([accountId] (management-webproperties-list accountId nil))
  ([accountId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties",
       :uri-template-args {:accountId accountId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/analytics"
        "https://www.googleapis.com/auth/analytics.edit"
        "https://www.googleapis.com/auth/analytics.readonly"]})))

(defn management-webproperties-patch
  "Updates an existing web property. This method supports patch semantics.
https://developers.google.com/analytics

accountId <string> Account ID to which the web property belongs
webPropertyId <string> Web property ID
Webproperty:
{:permissions {:effective [string]},
 :defaultProfileId string,
 :starred boolean,
 :websiteUrl string,
 :updated string,
 :name string,
 :industryVertical string,
 :selfLink string,
 :created string,
 :parentLink {:href string, :type string},
 :level string,
 :id string,
 :kind string,
 :childLink {:href string, :type string},
 :internalWebPropertyId string,
 :dataRetentionTtl string,
 :profileCount integer,
 :dataRetentionResetOnNewActivity boolean,
 :accountId string}"
  [accountId webPropertyId Webproperty]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}",
     :uri-template-args
     {:accountId accountId, :webPropertyId webPropertyId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"],
     :body Webproperty}))

(defn management-webproperties-update
  "Updates an existing web property.
https://developers.google.com/analytics

accountId <string> Account ID to which the web property belongs
webPropertyId <string> Web property ID
Webproperty:
{:permissions {:effective [string]},
 :defaultProfileId string,
 :starred boolean,
 :websiteUrl string,
 :updated string,
 :name string,
 :industryVertical string,
 :selfLink string,
 :created string,
 :parentLink {:href string, :type string},
 :level string,
 :id string,
 :kind string,
 :childLink {:href string, :type string},
 :internalWebPropertyId string,
 :dataRetentionTtl string,
 :profileCount integer,
 :dataRetentionResetOnNewActivity boolean,
 :accountId string}"
  [accountId webPropertyId Webproperty]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}",
     :uri-template-args
     {:accountId accountId, :webPropertyId webPropertyId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"],
     :body Webproperty}))

(defn management-customDimensions-get
  "Get a custom dimension to which the user has access.
https://developers.google.com/analytics

accountId <string> Account ID for the custom dimension to retrieve.
webPropertyId <string> Web property ID for the custom dimension to retrieve.
customDimensionId <string> The ID of the custom dimension to retrieve."
  [accountId webPropertyId customDimensionId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/customDimensions/{customDimensionId}",
     :uri-template-args
     {:accountId accountId,
      :customDimensionId customDimensionId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics.edit"
      "https://www.googleapis.com/auth/analytics.readonly"]}))

(defn management-customDimensions-insert
  "Create a new custom dimension.
https://developers.google.com/analytics

accountId <string> Account ID for the custom dimension to create.
webPropertyId <string> Web property ID for the custom dimension to create.
CustomDimension:
{:index integer,
 :updated string,
 :name string,
 :selfLink string,
 :created string,
 :scope string,
 :parentLink {:href string, :type string},
 :webPropertyId string,
 :active boolean,
 :id string,
 :kind string,
 :accountId string}"
  [accountId webPropertyId CustomDimension]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/customDimensions",
     :uri-template-args
     {:accountId accountId, :webPropertyId webPropertyId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"],
     :body CustomDimension}))

(defn management-customDimensions-list
  "Lists custom dimensions to which the user has access.
https://developers.google.com/analytics

accountId <string> Account ID for the custom dimensions to retrieve.
webPropertyId <string> Web property ID for the custom dimensions to retrieve.

optional:
max-results <integer> The maximum number of custom dimensions to include in this response.
start-index <integer> An index of the first entity to retrieve. Use this parameter as a pagination mechanism along with the max-results parameter."
  ([accountId webPropertyId]
    (management-customDimensions-list accountId webPropertyId nil))
  ([accountId webPropertyId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/customDimensions",
       :uri-template-args
       {:accountId accountId, :webPropertyId webPropertyId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/analytics"
        "https://www.googleapis.com/auth/analytics.readonly"]})))

(defn management-customDimensions-patch
  "Updates an existing custom dimension. This method supports patch semantics.
https://developers.google.com/analytics

accountId <string> Account ID for the custom dimension to update.
webPropertyId <string> Web property ID for the custom dimension to update.
customDimensionId <string> Custom dimension ID for the custom dimension to update.
CustomDimension:
{:index integer,
 :updated string,
 :name string,
 :selfLink string,
 :created string,
 :scope string,
 :parentLink {:href string, :type string},
 :webPropertyId string,
 :active boolean,
 :id string,
 :kind string,
 :accountId string}

optional:
ignoreCustomDataSourceLinks <boolean> Force the update and ignore any warnings related to the custom dimension being linked to a custom data source / data set."
  ([accountId webPropertyId customDimensionId CustomDimension]
    (management-customDimensions-patch
      accountId
      webPropertyId
      customDimensionId
      CustomDimension
      nil))
  ([accountId webPropertyId customDimensionId CustomDimension optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/customDimensions/{customDimensionId}",
       :uri-template-args
       {:accountId accountId,
        :customDimensionId customDimensionId,
        :webPropertyId webPropertyId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/analytics.edit"],
       :body CustomDimension})))

(defn management-customDimensions-update
  "Updates an existing custom dimension.
https://developers.google.com/analytics

accountId <string> Account ID for the custom dimension to update.
webPropertyId <string> Web property ID for the custom dimension to update.
customDimensionId <string> Custom dimension ID for the custom dimension to update.
CustomDimension:
{:index integer,
 :updated string,
 :name string,
 :selfLink string,
 :created string,
 :scope string,
 :parentLink {:href string, :type string},
 :webPropertyId string,
 :active boolean,
 :id string,
 :kind string,
 :accountId string}

optional:
ignoreCustomDataSourceLinks <boolean> Force the update and ignore any warnings related to the custom dimension being linked to a custom data source / data set."
  ([accountId webPropertyId customDimensionId CustomDimension]
    (management-customDimensions-update
      accountId
      webPropertyId
      customDimensionId
      CustomDimension
      nil))
  ([accountId webPropertyId customDimensionId CustomDimension optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/customDimensions/{customDimensionId}",
       :uri-template-args
       {:accountId accountId,
        :customDimensionId customDimensionId,
        :webPropertyId webPropertyId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/analytics.edit"],
       :body CustomDimension})))

(defn management-segments-list
  "Lists segments to which the user has access.
https://developers.google.com/analytics

optional:
max-results <integer> The maximum number of segments to include in this response.
start-index <integer> An index of the first segment to retrieve. Use this parameter as a pagination mechanism along with the max-results parameter."
  ([] (management-segments-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/analytics/v3/management/segments",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/analytics"
        "https://www.googleapis.com/auth/analytics.edit"
        "https://www.googleapis.com/auth/analytics.readonly"]})))

(defn management-accountSummaries-list
  "Lists account summaries (lightweight tree comprised of accounts/properties/profiles) to which the user has access.
https://developers.google.com/analytics

optional:
max-results <integer> The maximum number of account summaries to include in this response, where the largest acceptable value is 1000.
start-index <integer> An index of the first entity to retrieve. Use this parameter as a pagination mechanism along with the max-results parameter."
  ([] (management-accountSummaries-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/analytics/v3/management/accountSummaries",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/analytics.edit"
        "https://www.googleapis.com/auth/analytics.readonly"]})))

(defn management-accountUserLinks-delete
  "Removes a user from the given account.
https://developers.google.com/analytics

accountId <string> Account ID to delete the user link for.
linkId <string> Link ID to delete the user link for."
  [accountId linkId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/entityUserLinks/{linkId}",
     :uri-template-args {:accountId accountId, :linkId linkId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics.manage.users"]}))

(defn management-accountUserLinks-insert
  "Adds a new user to the given account.
https://developers.google.com/analytics

accountId <string> Account ID to create the user link for.
EntityUserLink:
{:entity
 {:accountRef {:href string, :id string, :kind string, :name string},
  :profileRef
  {:accountId string,
   :href string,
   :id string,
   :internalWebPropertyId string,
   :kind string,
   :name string,
   :webPropertyId string},
  :webPropertyRef
  {:accountId string,
   :href string,
   :id string,
   :internalWebPropertyId string,
   :kind string,
   :name string}},
 :id string,
 :kind string,
 :permissions {:effective [string], :local [string]},
 :selfLink string,
 :userRef {:email string, :id string, :kind string}}"
  [accountId EntityUserLink]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/entityUserLinks",
     :uri-template-args {:accountId accountId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics.manage.users"],
     :body EntityUserLink}))

(defn management-accountUserLinks-list
  "Lists account-user links for a given account.
https://developers.google.com/analytics

accountId <string> Account ID to retrieve the user links for.

optional:
max-results <integer> The maximum number of account-user links to include in this response.
start-index <integer> An index of the first account-user link to retrieve. Use this parameter as a pagination mechanism along with the max-results parameter."
  ([accountId] (management-accountUserLinks-list accountId nil))
  ([accountId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/entityUserLinks",
       :uri-template-args {:accountId accountId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/analytics.manage.users"
        "https://www.googleapis.com/auth/analytics.manage.users.readonly"]})))

(defn management-accountUserLinks-update
  "Updates permissions for an existing user on the given account.
https://developers.google.com/analytics

accountId <string> Account ID to update the account-user link for.
linkId <string> Link ID to update the account-user link for.
EntityUserLink:
{:entity
 {:accountRef {:href string, :id string, :kind string, :name string},
  :profileRef
  {:accountId string,
   :href string,
   :id string,
   :internalWebPropertyId string,
   :kind string,
   :name string,
   :webPropertyId string},
  :webPropertyRef
  {:accountId string,
   :href string,
   :id string,
   :internalWebPropertyId string,
   :kind string,
   :name string}},
 :id string,
 :kind string,
 :permissions {:effective [string], :local [string]},
 :selfLink string,
 :userRef {:email string, :id string, :kind string}}"
  [accountId linkId EntityUserLink]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/entityUserLinks/{linkId}",
     :uri-template-args {:accountId accountId, :linkId linkId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics.manage.users"],
     :body EntityUserLink}))

(defn management-profileUserLinks-delete
  "Removes a user from the given view (profile).
https://developers.google.com/analytics

accountId <string> Account ID to delete the user link for.
webPropertyId <string> Web Property ID to delete the user link for.
profileId <string> View (Profile) ID to delete the user link for.
linkId <string> Link ID to delete the user link for."
  [accountId webPropertyId profileId linkId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/entityUserLinks/{linkId}",
     :uri-template-args
     {:accountId accountId,
      :linkId linkId,
      :profileId profileId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics.manage.users"]}))

(defn management-profileUserLinks-insert
  "Adds a new user to the given view (profile).
https://developers.google.com/analytics

accountId <string> Account ID to create the user link for.
webPropertyId <string> Web Property ID to create the user link for.
profileId <string> View (Profile) ID to create the user link for.
EntityUserLink:
{:entity
 {:accountRef {:href string, :id string, :kind string, :name string},
  :profileRef
  {:accountId string,
   :href string,
   :id string,
   :internalWebPropertyId string,
   :kind string,
   :name string,
   :webPropertyId string},
  :webPropertyRef
  {:accountId string,
   :href string,
   :id string,
   :internalWebPropertyId string,
   :kind string,
   :name string}},
 :id string,
 :kind string,
 :permissions {:effective [string], :local [string]},
 :selfLink string,
 :userRef {:email string, :id string, :kind string}}"
  [accountId webPropertyId profileId EntityUserLink]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/entityUserLinks",
     :uri-template-args
     {:accountId accountId,
      :profileId profileId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics.manage.users"],
     :body EntityUserLink}))

(defn management-profileUserLinks-list
  "Lists profile-user links for a given view (profile).
https://developers.google.com/analytics

accountId <string> Account ID which the given view (profile) belongs to.
webPropertyId <string> Web Property ID which the given view (profile) belongs to. Can either be a specific web property ID or '~all', which refers to all the web properties that user has access to.
profileId <string> View (Profile) ID to retrieve the profile-user links for. Can either be a specific profile ID or '~all', which refers to all the profiles that user has access to.

optional:
max-results <integer> The maximum number of profile-user links to include in this response.
start-index <integer> An index of the first profile-user link to retrieve. Use this parameter as a pagination mechanism along with the max-results parameter."
  ([accountId webPropertyId profileId]
    (management-profileUserLinks-list
      accountId
      webPropertyId
      profileId
      nil))
  ([accountId webPropertyId profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/entityUserLinks",
       :uri-template-args
       {:accountId accountId,
        :profileId profileId,
        :webPropertyId webPropertyId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/analytics.manage.users"
        "https://www.googleapis.com/auth/analytics.manage.users.readonly"]})))

(defn management-profileUserLinks-update
  "Updates permissions for an existing user on the given view (profile).
https://developers.google.com/analytics

accountId <string> Account ID to update the user link for.
webPropertyId <string> Web Property ID to update the user link for.
profileId <string> View (Profile ID) to update the user link for.
linkId <string> Link ID to update the user link for.
EntityUserLink:
{:entity
 {:accountRef {:href string, :id string, :kind string, :name string},
  :profileRef
  {:accountId string,
   :href string,
   :id string,
   :internalWebPropertyId string,
   :kind string,
   :name string,
   :webPropertyId string},
  :webPropertyRef
  {:accountId string,
   :href string,
   :id string,
   :internalWebPropertyId string,
   :kind string,
   :name string}},
 :id string,
 :kind string,
 :permissions {:effective [string], :local [string]},
 :selfLink string,
 :userRef {:email string, :id string, :kind string}}"
  [accountId webPropertyId profileId linkId EntityUserLink]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/entityUserLinks/{linkId}",
     :uri-template-args
     {:accountId accountId,
      :linkId linkId,
      :profileId profileId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics.manage.users"],
     :body EntityUserLink}))

(defn management-uploads-deleteUploadData
  "Delete data associated with a previous upload.
https://developers.google.com/analytics

accountId <string> Account Id for the uploads to be deleted.
webPropertyId <string> Web property Id for the uploads to be deleted.
customDataSourceId <string> Custom data source Id for the uploads to be deleted.
AnalyticsDataimportDeleteUploadDataRequest:
{:customDataImportUids [string]}"
  [accountId
   webPropertyId
   customDataSourceId
   AnalyticsDataimportDeleteUploadDataRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/customDataSources/{customDataSourceId}/deleteUploadData",
     :uri-template-args
     {:accountId accountId,
      :customDataSourceId customDataSourceId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics"
      "https://www.googleapis.com/auth/analytics.edit"],
     :body AnalyticsDataimportDeleteUploadDataRequest}))

(defn management-uploads-get
  "List uploads to which the user has access.
https://developers.google.com/analytics

accountId <string> Account Id for the upload to retrieve.
webPropertyId <string> Web property Id for the upload to retrieve.
customDataSourceId <string> Custom data source Id for upload to retrieve.
uploadId <string> Upload Id to retrieve."
  [accountId webPropertyId customDataSourceId uploadId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/customDataSources/{customDataSourceId}/uploads/{uploadId}",
     :uri-template-args
     {:accountId accountId,
      :customDataSourceId customDataSourceId,
      :uploadId uploadId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics"
      "https://www.googleapis.com/auth/analytics.edit"
      "https://www.googleapis.com/auth/analytics.readonly"]}))

(defn management-uploads-list
  "List uploads to which the user has access.
https://developers.google.com/analytics

accountId <string> Account Id for the uploads to retrieve.
webPropertyId <string> Web property Id for the uploads to retrieve.
customDataSourceId <string> Custom data source Id for uploads to retrieve.

optional:
max-results <integer> The maximum number of uploads to include in this response.
start-index <integer> A 1-based index of the first upload to retrieve. Use this parameter as a pagination mechanism along with the max-results parameter."
  ([accountId webPropertyId customDataSourceId]
    (management-uploads-list
      accountId
      webPropertyId
      customDataSourceId
      nil))
  ([accountId webPropertyId customDataSourceId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/customDataSources/{customDataSourceId}/uploads",
       :uri-template-args
       {:accountId accountId,
        :customDataSourceId customDataSourceId,
        :webPropertyId webPropertyId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/analytics"
        "https://www.googleapis.com/auth/analytics.edit"
        "https://www.googleapis.com/auth/analytics.readonly"]})))

(defn management-uploads-uploadData
  "Upload data for a custom data source.
https://developers.google.com/analytics

accountId <string> Account Id associated with the upload.
webPropertyId <string> Web property UA-string associated with the upload.
customDataSourceId <string> Custom data source Id to which the data being uploaded belongs."
  [accountId webPropertyId customDataSourceId]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/customDataSources/{customDataSourceId}/uploads",
     :uri-template-args
     {:accountId accountId,
      :customDataSourceId customDataSourceId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics"
      "https://www.googleapis.com/auth/analytics.edit"]}))

(defn management-customDataSources-list
  "List custom data sources to which the user has access.
https://developers.google.com/analytics

accountId <string> Account Id for the custom data sources to retrieve.
webPropertyId <string> Web property Id for the custom data sources to retrieve.

optional:
max-results <integer> The maximum number of custom data sources to include in this response.
start-index <integer> A 1-based index of the first custom data source to retrieve. Use this parameter as a pagination mechanism along with the max-results parameter."
  ([accountId webPropertyId]
    (management-customDataSources-list accountId webPropertyId nil))
  ([accountId webPropertyId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/customDataSources",
       :uri-template-args
       {:accountId accountId, :webPropertyId webPropertyId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/analytics"
        "https://www.googleapis.com/auth/analytics.edit"
        "https://www.googleapis.com/auth/analytics.readonly"]})))

(defn management-profiles-delete
  "Deletes a view (profile).
https://developers.google.com/analytics

accountId <string> Account ID to delete the view (profile) for.
webPropertyId <string> Web property ID to delete the view (profile) for.
profileId <string> ID of the view (profile) to be deleted."
  [accountId webPropertyId profileId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}",
     :uri-template-args
     {:accountId accountId,
      :profileId profileId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"]}))

(defn management-profiles-get
  "Gets a view (profile) to which the user has access.
https://developers.google.com/analytics

accountId <string> Account ID to retrieve the view (profile) for.
webPropertyId <string> Web property ID to retrieve the view (profile) for.
profileId <string> View (Profile) ID to retrieve the view (profile) for."
  [accountId webPropertyId profileId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}",
     :uri-template-args
     {:accountId accountId,
      :profileId profileId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics.edit"
      "https://www.googleapis.com/auth/analytics.readonly"]}))

(defn management-profiles-insert
  "Create a new view (profile).
https://developers.google.com/analytics

accountId <string> Account ID to create the view (profile) for.
webPropertyId <string> Web property ID to create the view (profile) for.
Profile:
{:timezone string,
 :permissions {:effective [string]},
 :starred boolean,
 :websiteUrl string,
 :botFilteringEnabled boolean,
 :updated string,
 :name string,
 :defaultPage string,
 :selfLink string,
 :type string,
 :created string,
 :parentLink {:href string, :type string},
 :webPropertyId string,
 :stripSiteSearchCategoryParameters boolean,
 :siteSearchCategoryParameters string,
 :currency string,
 :enhancedECommerceTracking boolean,
 :id string,
 :kind string,
 :childLink {:href string, :type string},
 :internalWebPropertyId string,
 :stripSiteSearchQueryParameters boolean,
 :excludeQueryParameters string,
 :accountId string,
 :eCommerceTracking boolean,
 :siteSearchQueryParameters string}"
  [accountId webPropertyId Profile]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/profiles",
     :uri-template-args
     {:accountId accountId, :webPropertyId webPropertyId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"],
     :body Profile}))

(defn management-profiles-list
  "Lists views (profiles) to which the user has access.
https://developers.google.com/analytics

accountId <string> Account ID for the view (profiles) to retrieve. Can either be a specific account ID or '~all', which refers to all the accounts to which the user has access.
webPropertyId <string> Web property ID for the views (profiles) to retrieve. Can either be a specific web property ID or '~all', which refers to all the web properties to which the user has access.

optional:
max-results <integer> The maximum number of views (profiles) to include in this response.
start-index <integer> An index of the first entity to retrieve. Use this parameter as a pagination mechanism along with the max-results parameter."
  ([accountId webPropertyId]
    (management-profiles-list accountId webPropertyId nil))
  ([accountId webPropertyId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/profiles",
       :uri-template-args
       {:accountId accountId, :webPropertyId webPropertyId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/analytics"
        "https://www.googleapis.com/auth/analytics.edit"
        "https://www.googleapis.com/auth/analytics.readonly"]})))

(defn management-profiles-patch
  "Updates an existing view (profile). This method supports patch semantics.
https://developers.google.com/analytics

accountId <string> Account ID to which the view (profile) belongs
webPropertyId <string> Web property ID to which the view (profile) belongs
profileId <string> ID of the view (profile) to be updated.
Profile:
{:timezone string,
 :permissions {:effective [string]},
 :starred boolean,
 :websiteUrl string,
 :botFilteringEnabled boolean,
 :updated string,
 :name string,
 :defaultPage string,
 :selfLink string,
 :type string,
 :created string,
 :parentLink {:href string, :type string},
 :webPropertyId string,
 :stripSiteSearchCategoryParameters boolean,
 :siteSearchCategoryParameters string,
 :currency string,
 :enhancedECommerceTracking boolean,
 :id string,
 :kind string,
 :childLink {:href string, :type string},
 :internalWebPropertyId string,
 :stripSiteSearchQueryParameters boolean,
 :excludeQueryParameters string,
 :accountId string,
 :eCommerceTracking boolean,
 :siteSearchQueryParameters string}"
  [accountId webPropertyId profileId Profile]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}",
     :uri-template-args
     {:accountId accountId,
      :profileId profileId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"],
     :body Profile}))

(defn management-profiles-update
  "Updates an existing view (profile).
https://developers.google.com/analytics

accountId <string> Account ID to which the view (profile) belongs
webPropertyId <string> Web property ID to which the view (profile) belongs
profileId <string> ID of the view (profile) to be updated.
Profile:
{:timezone string,
 :permissions {:effective [string]},
 :starred boolean,
 :websiteUrl string,
 :botFilteringEnabled boolean,
 :updated string,
 :name string,
 :defaultPage string,
 :selfLink string,
 :type string,
 :created string,
 :parentLink {:href string, :type string},
 :webPropertyId string,
 :stripSiteSearchCategoryParameters boolean,
 :siteSearchCategoryParameters string,
 :currency string,
 :enhancedECommerceTracking boolean,
 :id string,
 :kind string,
 :childLink {:href string, :type string},
 :internalWebPropertyId string,
 :stripSiteSearchQueryParameters boolean,
 :excludeQueryParameters string,
 :accountId string,
 :eCommerceTracking boolean,
 :siteSearchQueryParameters string}"
  [accountId webPropertyId profileId Profile]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}",
     :uri-template-args
     {:accountId accountId,
      :profileId profileId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"],
     :body Profile}))

(defn management-remarketingAudience-delete
  "Delete a remarketing audience.
https://developers.google.com/analytics

accountId <string> Account ID to which the remarketing audience belongs.
webPropertyId <string> Web property ID to which the remarketing audience belongs.
remarketingAudienceId <string> The ID of the remarketing audience to delete."
  [accountId webPropertyId remarketingAudienceId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/remarketingAudiences/{remarketingAudienceId}",
     :uri-template-args
     {:accountId accountId,
      :remarketingAudienceId remarketingAudienceId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"]}))

(defn management-remarketingAudience-get
  "Gets a remarketing audience to which the user has access.
https://developers.google.com/analytics

accountId <string> The account ID of the remarketing audience to retrieve.
webPropertyId <string> The web property ID of the remarketing audience to retrieve.
remarketingAudienceId <string> The ID of the remarketing audience to retrieve."
  [accountId webPropertyId remarketingAudienceId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/remarketingAudiences/{remarketingAudienceId}",
     :uri-template-args
     {:accountId accountId,
      :remarketingAudienceId remarketingAudienceId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics.edit"
      "https://www.googleapis.com/auth/analytics.readonly"]}))

(defn management-remarketingAudience-insert
  "Creates a new remarketing audience.
https://developers.google.com/analytics

accountId <string> The account ID for which to create the remarketing audience.
webPropertyId <string> Web property ID for which to create the remarketing audience.
RemarketingAudience:
{:description string,
 :updated string,
 :name string,
 :audienceType string,
 :created string,
 :audienceDefinition
 {:includeConditions
  {:daysToLookBack integer,
   :isSmartList boolean,
   :kind string,
   :membershipDurationDays integer,
   :segment string}},
 :webPropertyId string,
 :id string,
 :kind string,
 :internalWebPropertyId string,
 :stateBasedAudienceDefinition
 {:excludeConditions {:exclusionDuration string, :segment string},
  :includeConditions
  {:daysToLookBack integer,
   :isSmartList boolean,
   :kind string,
   :membershipDurationDays integer,
   :segment string}},
 :linkedAdAccounts
 [{:eligibleForSearch boolean,
   :linkedAccountId string,
   :type string,
   :webPropertyId string,
   :remarketingAudienceId string,
   :status string,
   :id string,
   :kind string,
   :internalWebPropertyId string,
   :accountId string}],
 :accountId string,
 :linkedViews [string]}"
  [accountId webPropertyId RemarketingAudience]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/remarketingAudiences",
     :uri-template-args
     {:accountId accountId, :webPropertyId webPropertyId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"],
     :body RemarketingAudience}))

(defn management-remarketingAudience-list
  "Lists remarketing audiences to which the user has access.
https://developers.google.com/analytics

accountId <string> The account ID of the remarketing audiences to retrieve.
webPropertyId <string> The web property ID of the remarketing audiences to retrieve.

optional:
max-results <integer> The maximum number of remarketing audiences to include in this response.
start-index <integer> An index of the first entity to retrieve. Use this parameter as a pagination mechanism along with the max-results parameter.
type <string> "
  ([accountId webPropertyId]
    (management-remarketingAudience-list accountId webPropertyId nil))
  ([accountId webPropertyId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/remarketingAudiences",
       :uri-template-args
       {:accountId accountId, :webPropertyId webPropertyId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/analytics.edit"
        "https://www.googleapis.com/auth/analytics.readonly"]})))

(defn management-remarketingAudience-patch
  "Updates an existing remarketing audience. This method supports patch semantics.
https://developers.google.com/analytics

accountId <string> The account ID of the remarketing audience to update.
webPropertyId <string> The web property ID of the remarketing audience to update.
remarketingAudienceId <string> The ID of the remarketing audience to update.
RemarketingAudience:
{:description string,
 :updated string,
 :name string,
 :audienceType string,
 :created string,
 :audienceDefinition
 {:includeConditions
  {:daysToLookBack integer,
   :isSmartList boolean,
   :kind string,
   :membershipDurationDays integer,
   :segment string}},
 :webPropertyId string,
 :id string,
 :kind string,
 :internalWebPropertyId string,
 :stateBasedAudienceDefinition
 {:excludeConditions {:exclusionDuration string, :segment string},
  :includeConditions
  {:daysToLookBack integer,
   :isSmartList boolean,
   :kind string,
   :membershipDurationDays integer,
   :segment string}},
 :linkedAdAccounts
 [{:eligibleForSearch boolean,
   :linkedAccountId string,
   :type string,
   :webPropertyId string,
   :remarketingAudienceId string,
   :status string,
   :id string,
   :kind string,
   :internalWebPropertyId string,
   :accountId string}],
 :accountId string,
 :linkedViews [string]}"
  [accountId webPropertyId remarketingAudienceId RemarketingAudience]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/remarketingAudiences/{remarketingAudienceId}",
     :uri-template-args
     {:accountId accountId,
      :remarketingAudienceId remarketingAudienceId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"],
     :body RemarketingAudience}))

(defn management-remarketingAudience-update
  "Updates an existing remarketing audience.
https://developers.google.com/analytics

accountId <string> The account ID of the remarketing audience to update.
webPropertyId <string> The web property ID of the remarketing audience to update.
remarketingAudienceId <string> The ID of the remarketing audience to update.
RemarketingAudience:
{:description string,
 :updated string,
 :name string,
 :audienceType string,
 :created string,
 :audienceDefinition
 {:includeConditions
  {:daysToLookBack integer,
   :isSmartList boolean,
   :kind string,
   :membershipDurationDays integer,
   :segment string}},
 :webPropertyId string,
 :id string,
 :kind string,
 :internalWebPropertyId string,
 :stateBasedAudienceDefinition
 {:excludeConditions {:exclusionDuration string, :segment string},
  :includeConditions
  {:daysToLookBack integer,
   :isSmartList boolean,
   :kind string,
   :membershipDurationDays integer,
   :segment string}},
 :linkedAdAccounts
 [{:eligibleForSearch boolean,
   :linkedAccountId string,
   :type string,
   :webPropertyId string,
   :remarketingAudienceId string,
   :status string,
   :id string,
   :kind string,
   :internalWebPropertyId string,
   :accountId string}],
 :accountId string,
 :linkedViews [string]}"
  [accountId webPropertyId remarketingAudienceId RemarketingAudience]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/remarketingAudiences/{remarketingAudienceId}",
     :uri-template-args
     {:accountId accountId,
      :remarketingAudienceId remarketingAudienceId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"],
     :body RemarketingAudience}))

(defn management-accounts-list
  "Lists all accounts to which the user has access.
https://developers.google.com/analytics

optional:
max-results <integer> The maximum number of accounts to include in this response.
start-index <integer> An index of the first account to retrieve. Use this parameter as a pagination mechanism along with the max-results parameter."
  ([] (management-accounts-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/analytics/v3/management/accounts",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/analytics"
        "https://www.googleapis.com/auth/analytics.edit"
        "https://www.googleapis.com/auth/analytics.readonly"]})))

(defn management-unsampledReports-delete
  "Deletes an unsampled report.
https://developers.google.com/analytics

accountId <string> Account ID to delete the unsampled report for.
webPropertyId <string> Web property ID to delete the unsampled reports for.
profileId <string> View (Profile) ID to delete the unsampled report for.
unsampledReportId <string> ID of the unsampled report to be deleted."
  [accountId webPropertyId profileId unsampledReportId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/unsampledReports/{unsampledReportId}",
     :uri-template-args
     {:accountId accountId,
      :profileId profileId,
      :unsampledReportId unsampledReportId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"]}))

(defn management-unsampledReports-get
  "Returns a single unsampled report.
https://developers.google.com/analytics

accountId <string> Account ID to retrieve unsampled report for.
webPropertyId <string> Web property ID to retrieve unsampled reports for.
profileId <string> View (Profile) ID to retrieve unsampled report for.
unsampledReportId <string> ID of the unsampled report to retrieve."
  [accountId webPropertyId profileId unsampledReportId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/unsampledReports/{unsampledReportId}",
     :uri-template-args
     {:accountId accountId,
      :profileId profileId,
      :unsampledReportId unsampledReportId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics"
      "https://www.googleapis.com/auth/analytics.edit"
      "https://www.googleapis.com/auth/analytics.readonly"]}))

(defn management-unsampledReports-insert
  "Create a new unsampled report.
https://developers.google.com/analytics

accountId <string> Account ID to create the unsampled report for.
webPropertyId <string> Web property ID to create the unsampled report for.
profileId <string> View (Profile) ID to create the unsampled report for.
UnsampledReport:
{:end-date string,
 :filters string,
 :updated string,
 :selfLink string,
 :created string,
 :webPropertyId string,
 :dimensions string,
 :title string,
 :status string,
 :segment string,
 :id string,
 :kind string,
 :profileId string,
 :start-date string,
 :accountId string,
 :cloudStorageDownloadDetails {:bucketId string, :objectId string},
 :metrics string,
 :driveDownloadDetails {:documentId string},
 :downloadType string}"
  [accountId webPropertyId profileId UnsampledReport]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/unsampledReports",
     :uri-template-args
     {:accountId accountId,
      :profileId profileId,
      :webPropertyId webPropertyId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics"
      "https://www.googleapis.com/auth/analytics.edit"],
     :body UnsampledReport}))

(defn management-unsampledReports-list
  "Lists unsampled reports to which the user has access.
https://developers.google.com/analytics

accountId <string> Account ID to retrieve unsampled reports for. Must be a specific account ID, ~all is not supported.
webPropertyId <string> Web property ID to retrieve unsampled reports for. Must be a specific web property ID, ~all is not supported.
profileId <string> View (Profile) ID to retrieve unsampled reports for. Must be a specific view (profile) ID, ~all is not supported.

optional:
max-results <integer> The maximum number of unsampled reports to include in this response.
start-index <integer> An index of the first unsampled report to retrieve. Use this parameter as a pagination mechanism along with the max-results parameter."
  ([accountId webPropertyId profileId]
    (management-unsampledReports-list
      accountId
      webPropertyId
      profileId
      nil))
  ([accountId webPropertyId profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/analytics/v3/management/accounts/{accountId}/webproperties/{webPropertyId}/profiles/{profileId}/unsampledReports",
       :uri-template-args
       {:accountId accountId,
        :profileId profileId,
        :webPropertyId webPropertyId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/analytics"
        "https://www.googleapis.com/auth/analytics.edit"
        "https://www.googleapis.com/auth/analytics.readonly"]})))

(defn metadata-columns-list
  "Lists all columns for a report type
https://developers.google.com/analytics

reportType <string> Report type. Allowed Values: 'ga'. Where 'ga' corresponds to the Core Reporting API"
  [reportType]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://www.googleapis.com/analytics/v3/metadata/{reportType}/columns",
     :uri-template-args {:reportType reportType},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics"
      "https://www.googleapis.com/auth/analytics.edit"
      "https://www.googleapis.com/auth/analytics.readonly"]}))

(defn provisioning-createAccountTicket
  "Creates an account ticket.
https://developers.google.com/analytics

AccountTicket:
{:account
 {:permissions {:effective [string]},
  :starred boolean,
  :updated string,
  :name string,
  :selfLink string,
  :created string,
  :id string,
  :kind string,
  :childLink {:href string, :type string}},
 :id string,
 :kind string,
 :profile
 {:timezone string,
  :permissions {:effective [string]},
  :starred boolean,
  :websiteUrl string,
  :botFilteringEnabled boolean,
  :updated string,
  :name string,
  :defaultPage string,
  :selfLink string,
  :type string,
  :created string,
  :parentLink {:href string, :type string},
  :webPropertyId string,
  :stripSiteSearchCategoryParameters boolean,
  :siteSearchCategoryParameters string,
  :currency string,
  :enhancedECommerceTracking boolean,
  :id string,
  :kind string,
  :childLink {:href string, :type string},
  :internalWebPropertyId string,
  :stripSiteSearchQueryParameters boolean,
  :excludeQueryParameters string,
  :accountId string,
  :eCommerceTracking boolean,
  :siteSearchQueryParameters string},
 :redirectUri string,
 :webproperty
 {:permissions {:effective [string]},
  :defaultProfileId string,
  :starred boolean,
  :websiteUrl string,
  :updated string,
  :name string,
  :industryVertical string,
  :selfLink string,
  :created string,
  :parentLink {:href string, :type string},
  :level string,
  :id string,
  :kind string,
  :childLink {:href string, :type string},
  :internalWebPropertyId string,
  :dataRetentionTtl string,
  :profileCount integer,
  :dataRetentionResetOnNewActivity boolean,
  :accountId string}}"
  [AccountTicket]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/analytics/v3/provisioning/createAccountTicket",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.provision"],
     :body AccountTicket}))

(defn provisioning-createAccountTree
  "Provision account.
https://developers.google.com/analytics

AccountTreeRequest:
{:accountName string,
 :kind string,
 :profileName string,
 :timezone string,
 :webpropertyName string,
 :websiteUrl string}"
  [AccountTreeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/analytics/v3/provisioning/createAccountTree",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.provision"],
     :body AccountTreeRequest}))

(defn userDeletion-userDeletionRequest-upsert
  "Insert or update a user deletion requests.
https://developers.google.com/analytics

UserDeletionRequest:
{:deletionRequestTime string,
 :firebaseProjectId string,
 :id {:type string, :userId string},
 :kind string,
 :propertyId string,
 :webPropertyId string}"
  [UserDeletionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/analytics/v3/userDeletion/userDeletionRequests:upsert",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics.user.deletion"],
     :body UserDeletionRequest}))

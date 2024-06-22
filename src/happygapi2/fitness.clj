(ns happygapi2.fitness
  "Fitness API
The Fitness API for managing users' fitness tracking data.
See: https://developers.google.com/fit/rest/v1/get-started"
  (:require [happy.oauth2.client :as client]))

(defn users-dataSources-delete
  "Deletes the specified data source. The request will fail if the data source contains any data points.
https://developers.google.com/fit/rest/v1/get-started

userId <string> Retrieve a data source for the person identified. Use me to indicate the authenticated user. Only me is supported at this time.
dataSourceId <string> The data stream ID of the data source to delete."
  [userId dataSourceId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://fitness.googleapis.com/fitness/v1/users/{userId}/dataSources/{dataSourceId}",
     :uri-template-args {:dataSourceId dataSourceId, :userId userId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/fitness.activity.write"
      "https://www.googleapis.com/auth/fitness.blood_glucose.write"
      "https://www.googleapis.com/auth/fitness.blood_pressure.write"
      "https://www.googleapis.com/auth/fitness.body.write"
      "https://www.googleapis.com/auth/fitness.body_temperature.write"
      "https://www.googleapis.com/auth/fitness.heart_rate.write"
      "https://www.googleapis.com/auth/fitness.location.write"
      "https://www.googleapis.com/auth/fitness.nutrition.write"
      "https://www.googleapis.com/auth/fitness.oxygen_saturation.write"
      "https://www.googleapis.com/auth/fitness.reproductive_health.write"
      "https://www.googleapis.com/auth/fitness.sleep.write"]}))

(defn users-dataSources-get
  "Returns the specified data source.
https://developers.google.com/fit/rest/v1/get-started

userId <string> Retrieve a data source for the person identified. Use me to indicate the authenticated user. Only me is supported at this time.
dataSourceId <string> The data stream ID of the data source to retrieve."
  [userId dataSourceId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://fitness.googleapis.com/fitness/v1/users/{userId}/dataSources/{dataSourceId}",
     :uri-template-args {:dataSourceId dataSourceId, :userId userId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/fitness.activity.read"
      "https://www.googleapis.com/auth/fitness.activity.write"
      "https://www.googleapis.com/auth/fitness.blood_glucose.read"
      "https://www.googleapis.com/auth/fitness.blood_glucose.write"
      "https://www.googleapis.com/auth/fitness.blood_pressure.read"
      "https://www.googleapis.com/auth/fitness.blood_pressure.write"
      "https://www.googleapis.com/auth/fitness.body.read"
      "https://www.googleapis.com/auth/fitness.body.write"
      "https://www.googleapis.com/auth/fitness.body_temperature.read"
      "https://www.googleapis.com/auth/fitness.body_temperature.write"
      "https://www.googleapis.com/auth/fitness.heart_rate.read"
      "https://www.googleapis.com/auth/fitness.heart_rate.write"
      "https://www.googleapis.com/auth/fitness.location.read"
      "https://www.googleapis.com/auth/fitness.location.write"
      "https://www.googleapis.com/auth/fitness.nutrition.read"
      "https://www.googleapis.com/auth/fitness.nutrition.write"
      "https://www.googleapis.com/auth/fitness.oxygen_saturation.read"
      "https://www.googleapis.com/auth/fitness.oxygen_saturation.write"
      "https://www.googleapis.com/auth/fitness.reproductive_health.read"
      "https://www.googleapis.com/auth/fitness.reproductive_health.write"
      "https://www.googleapis.com/auth/fitness.sleep.read"
      "https://www.googleapis.com/auth/fitness.sleep.write"]}))

(defn users-dataSources-update
  "Updates the specified data source. The dataStreamId, dataType, type, dataStreamName, and device properties with the exception of version, cannot be modified. Data sources are identified by their dataStreamId.
https://developers.google.com/fit/rest/v1/get-started

userId <string> Update the data source for the person identified. Use me to indicate the authenticated user. Only me is supported at this time.
dataSourceId <string> The data stream ID of the data source to update.
DataSource:
{:dataStreamName string,
 :name string,
 :type [raw derived],
 :dataQualityStandard
 [[dataQualityUnknown
   dataQualityBloodPressureEsh2002
   dataQualityBloodPressureEsh2010
   dataQualityBloodPressureAami
   dataQualityBloodPressureBhsAA
   dataQualityBloodPressureBhsAB
   dataQualityBloodPressureBhsBA
   dataQualityBloodPressureBhsBB
   dataQualityBloodGlucoseIso151972003
   dataQualityBloodGlucoseIso151972013]],
 :dataStreamId string,
 :device
 {:uid string,
  :model string,
  :version string,
  :type
  [unknown
   phone
   tablet
   watch
   chestStrap
   scale
   headMounted
   smartDisplay],
  :manufacturer string},
 :dataType
 {:name string,
  :field
  [{:format [integer floatPoint string map integerList floatList blob],
    :name string,
    :optional boolean}]},
 :application
 {:version string,
  :packageName string,
  :detailsUrl string,
  :name string}}"
  [userId dataSourceId DataSource]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://fitness.googleapis.com/fitness/v1/users/{userId}/dataSources/{dataSourceId}",
     :uri-template-args {:userId userId, :dataSourceId dataSourceId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/fitness.activity.write"
      "https://www.googleapis.com/auth/fitness.blood_glucose.write"
      "https://www.googleapis.com/auth/fitness.blood_pressure.write"
      "https://www.googleapis.com/auth/fitness.body.write"
      "https://www.googleapis.com/auth/fitness.body_temperature.write"
      "https://www.googleapis.com/auth/fitness.heart_rate.write"
      "https://www.googleapis.com/auth/fitness.location.write"
      "https://www.googleapis.com/auth/fitness.nutrition.write"
      "https://www.googleapis.com/auth/fitness.oxygen_saturation.write"
      "https://www.googleapis.com/auth/fitness.reproductive_health.write"
      "https://www.googleapis.com/auth/fitness.sleep.write"],
     :body DataSource}))

(defn users-dataSources-list
  "Lists all data sources that are visible to the developer, using the OAuth scopes provided. The list is not exhaustive; the user may have private data sources that are only visible to other developers, or calls using other scopes.
https://developers.google.com/fit/rest/v1/get-started

userId <string> List data sources for the person identified. Use me to indicate the authenticated user. Only me is supported at this time.

optional:
dataTypeName <string> The names of data types to include in the list. If not specified, all data sources will be returned."
  ([userId] (users-dataSources-list userId nil))
  ([userId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://fitness.googleapis.com/fitness/v1/users/{userId}/dataSources",
       :uri-template-args {:userId userId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/fitness.activity.read"
        "https://www.googleapis.com/auth/fitness.activity.write"
        "https://www.googleapis.com/auth/fitness.blood_glucose.read"
        "https://www.googleapis.com/auth/fitness.blood_glucose.write"
        "https://www.googleapis.com/auth/fitness.blood_pressure.read"
        "https://www.googleapis.com/auth/fitness.blood_pressure.write"
        "https://www.googleapis.com/auth/fitness.body.read"
        "https://www.googleapis.com/auth/fitness.body.write"
        "https://www.googleapis.com/auth/fitness.body_temperature.read"
        "https://www.googleapis.com/auth/fitness.body_temperature.write"
        "https://www.googleapis.com/auth/fitness.heart_rate.read"
        "https://www.googleapis.com/auth/fitness.heart_rate.write"
        "https://www.googleapis.com/auth/fitness.location.read"
        "https://www.googleapis.com/auth/fitness.location.write"
        "https://www.googleapis.com/auth/fitness.nutrition.read"
        "https://www.googleapis.com/auth/fitness.nutrition.write"
        "https://www.googleapis.com/auth/fitness.oxygen_saturation.read"
        "https://www.googleapis.com/auth/fitness.oxygen_saturation.write"
        "https://www.googleapis.com/auth/fitness.reproductive_health.read"
        "https://www.googleapis.com/auth/fitness.reproductive_health.write"
        "https://www.googleapis.com/auth/fitness.sleep.read"
        "https://www.googleapis.com/auth/fitness.sleep.write"]})))

(defn users-dataSources-create
  "Creates a new data source that is unique across all data sources belonging to this user. A data source is a unique source of sensor data. Data sources can expose raw data coming from hardware sensors on local or companion devices. They can also expose derived data, created by transforming or merging other data sources. Multiple data sources can exist for the same data type. Every data point in every dataset inserted into or read from the Fitness API has an associated data source. Each data source produces a unique stream of dataset updates, with a unique data source identifier. Not all changes to data source affect the data stream ID, so that data collected by updated versions of the same application/device can still be considered to belong to the same data source. Data sources are identified using a string generated by the server, based on the contents of the source being created. The dataStreamId field should not be set when invoking this method. It will be automatically generated by the server with the correct format. If a dataStreamId is set, it must match the format that the server would generate. This format is a combination of some fields from the data source, and has a specific order. If it doesn't match, the request will fail with an error. Specifying a DataType which is not a known type (beginning with \"com.google.\") will create a DataSource with a *custom data type*. Custom data types are only readable by the application that created them. Custom data types are *deprecated*; use standard data types instead. In addition to the data source fields included in the data source ID, the developer project number that is authenticated when creating the data source is included. This developer project number is obfuscated when read by any other developer reading public data types.
https://developers.google.com/fit/rest/v1/get-started

userId <string> Create the data source for the person identified. Use me to indicate the authenticated user. Only me is supported at this time.
DataSource:
{:dataStreamName string,
 :name string,
 :type [raw derived],
 :dataQualityStandard
 [[dataQualityUnknown
   dataQualityBloodPressureEsh2002
   dataQualityBloodPressureEsh2010
   dataQualityBloodPressureAami
   dataQualityBloodPressureBhsAA
   dataQualityBloodPressureBhsAB
   dataQualityBloodPressureBhsBA
   dataQualityBloodPressureBhsBB
   dataQualityBloodGlucoseIso151972003
   dataQualityBloodGlucoseIso151972013]],
 :dataStreamId string,
 :device
 {:uid string,
  :model string,
  :version string,
  :type
  [unknown
   phone
   tablet
   watch
   chestStrap
   scale
   headMounted
   smartDisplay],
  :manufacturer string},
 :dataType
 {:name string,
  :field
  [{:format [integer floatPoint string map integerList floatList blob],
    :name string,
    :optional boolean}]},
 :application
 {:version string,
  :packageName string,
  :detailsUrl string,
  :name string}}"
  [userId DataSource]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://fitness.googleapis.com/fitness/v1/users/{userId}/dataSources",
     :uri-template-args {:userId userId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/fitness.activity.write"
      "https://www.googleapis.com/auth/fitness.blood_glucose.write"
      "https://www.googleapis.com/auth/fitness.blood_pressure.write"
      "https://www.googleapis.com/auth/fitness.body.write"
      "https://www.googleapis.com/auth/fitness.body_temperature.write"
      "https://www.googleapis.com/auth/fitness.heart_rate.write"
      "https://www.googleapis.com/auth/fitness.location.write"
      "https://www.googleapis.com/auth/fitness.nutrition.write"
      "https://www.googleapis.com/auth/fitness.oxygen_saturation.write"
      "https://www.googleapis.com/auth/fitness.reproductive_health.write"
      "https://www.googleapis.com/auth/fitness.sleep.write"],
     :body DataSource}))

(defn users-dataSources-datasets-get
  "Returns a dataset containing all data points whose start and end times overlap with the specified range of the dataset minimum start time and maximum end time. Specifically, any data point whose start time is less than or equal to the dataset end time and whose end time is greater than or equal to the dataset start time.
https://developers.google.com/fit/rest/v1/get-started

userId <string> Retrieve a dataset for the person identified. Use me to indicate the authenticated user. Only me is supported at this time.
dataSourceId <string> The data stream ID of the data source that created the dataset.
datasetId <string> Dataset identifier that is a composite of the minimum data point start time and maximum data point end time represented as nanoseconds from the epoch. The ID is formatted like: \"startTime-endTime\" where startTime and endTime are 64 bit integers.

optional:
limit <integer> If specified, no more than this many data points will be included in the dataset. If there are more data points in the dataset, nextPageToken will be set in the dataset response. The limit is applied from the end of the time range. That is, if pageToken is absent, the limit most recent data points will be returned."
  ([userId dataSourceId datasetId]
    (users-dataSources-datasets-get userId dataSourceId datasetId nil))
  ([userId dataSourceId datasetId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://fitness.googleapis.com/fitness/v1/users/{userId}/dataSources/{dataSourceId}/datasets/{datasetId}",
       :uri-template-args
       {:datasetId datasetId,
        :userId userId,
        :dataSourceId dataSourceId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/fitness.activity.read"
        "https://www.googleapis.com/auth/fitness.activity.write"
        "https://www.googleapis.com/auth/fitness.blood_glucose.read"
        "https://www.googleapis.com/auth/fitness.blood_glucose.write"
        "https://www.googleapis.com/auth/fitness.blood_pressure.read"
        "https://www.googleapis.com/auth/fitness.blood_pressure.write"
        "https://www.googleapis.com/auth/fitness.body.read"
        "https://www.googleapis.com/auth/fitness.body.write"
        "https://www.googleapis.com/auth/fitness.body_temperature.read"
        "https://www.googleapis.com/auth/fitness.body_temperature.write"
        "https://www.googleapis.com/auth/fitness.heart_rate.read"
        "https://www.googleapis.com/auth/fitness.heart_rate.write"
        "https://www.googleapis.com/auth/fitness.location.read"
        "https://www.googleapis.com/auth/fitness.location.write"
        "https://www.googleapis.com/auth/fitness.nutrition.read"
        "https://www.googleapis.com/auth/fitness.nutrition.write"
        "https://www.googleapis.com/auth/fitness.oxygen_saturation.read"
        "https://www.googleapis.com/auth/fitness.oxygen_saturation.write"
        "https://www.googleapis.com/auth/fitness.reproductive_health.read"
        "https://www.googleapis.com/auth/fitness.reproductive_health.write"
        "https://www.googleapis.com/auth/fitness.sleep.read"
        "https://www.googleapis.com/auth/fitness.sleep.write"]})))

(defn users-dataSources-datasets-delete
  "Performs an inclusive delete of all data points whose start and end times have any overlap with the time range specified by the dataset ID. For most data types, the entire data point will be deleted. For data types where the time span represents a consistent value (such as com.google.activity.segment), and a data point straddles either end point of the dataset, only the overlapping portion of the data point will be deleted.
https://developers.google.com/fit/rest/v1/get-started

userId <string> Delete a dataset for the person identified. Use me to indicate the authenticated user. Only me is supported at this time.
dataSourceId <string> The data stream ID of the data source that created the dataset.
datasetId <string> Dataset identifier that is a composite of the minimum data point start time and maximum data point end time represented as nanoseconds from the epoch. The ID is formatted like: \"startTime-endTime\" where startTime and endTime are 64 bit integers."
  [userId dataSourceId datasetId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://fitness.googleapis.com/fitness/v1/users/{userId}/dataSources/{dataSourceId}/datasets/{datasetId}",
     :uri-template-args
     {:dataSourceId dataSourceId,
      :userId userId,
      :datasetId datasetId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/fitness.activity.write"
      "https://www.googleapis.com/auth/fitness.blood_glucose.write"
      "https://www.googleapis.com/auth/fitness.blood_pressure.write"
      "https://www.googleapis.com/auth/fitness.body.write"
      "https://www.googleapis.com/auth/fitness.body_temperature.write"
      "https://www.googleapis.com/auth/fitness.heart_rate.write"
      "https://www.googleapis.com/auth/fitness.location.write"
      "https://www.googleapis.com/auth/fitness.nutrition.write"
      "https://www.googleapis.com/auth/fitness.oxygen_saturation.write"
      "https://www.googleapis.com/auth/fitness.reproductive_health.write"
      "https://www.googleapis.com/auth/fitness.sleep.write"]}))

(defn users-dataSources-datasets-patch
  "Adds data points to a dataset. The dataset need not be previously created. All points within the given dataset will be returned with subsquent calls to retrieve this dataset. Data points can belong to more than one dataset. This method does not use patch semantics: the data points provided are merely inserted, with no existing data replaced.
https://developers.google.com/fit/rest/v1/get-started

userId <string> Patch a dataset for the person identified. Use me to indicate the authenticated user. Only me is supported at this time.
dataSourceId <string> The data stream ID of the data source that created the dataset.
datasetId <string> This field is not used, and can be safely omitted.
Dataset:
{:point
 [{:endTimeNanos string,
   :rawTimestampNanos string,
   :originDataSourceId string,
   :modifiedTimeMillis string,
   :startTimeNanos string,
   :computationTimeMillis string,
   :dataTypeName string,
   :value
   [{:stringVal string,
     :intVal integer,
     :mapVal [{:value {:fpVal number}, :key string}],
     :fpVal number}]}],
 :nextPageToken string,
 :dataSourceId string,
 :maxEndTimeNs string,
 :minStartTimeNs string}"
  [userId dataSourceId datasetId Dataset]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://fitness.googleapis.com/fitness/v1/users/{userId}/dataSources/{dataSourceId}/datasets/{datasetId}",
     :uri-template-args
     {:datasetId datasetId,
      :dataSourceId dataSourceId,
      :userId userId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/fitness.activity.write"
      "https://www.googleapis.com/auth/fitness.blood_glucose.write"
      "https://www.googleapis.com/auth/fitness.blood_pressure.write"
      "https://www.googleapis.com/auth/fitness.body.write"
      "https://www.googleapis.com/auth/fitness.body_temperature.write"
      "https://www.googleapis.com/auth/fitness.heart_rate.write"
      "https://www.googleapis.com/auth/fitness.location.write"
      "https://www.googleapis.com/auth/fitness.nutrition.write"
      "https://www.googleapis.com/auth/fitness.oxygen_saturation.write"
      "https://www.googleapis.com/auth/fitness.reproductive_health.write"
      "https://www.googleapis.com/auth/fitness.sleep.write"],
     :body Dataset}))

(defn users-dataSources-dataPointChanges-list
  "Queries for user's data point changes for a particular data source.
https://developers.google.com/fit/rest/v1/get-started

userId <string> List data points for the person identified. Use me to indicate the authenticated user. Only me is supported at this time.
dataSourceId <string> The data stream ID of the data source that created the dataset.

optional:
limit <integer> If specified, no more than this many data point changes will be included in the response."
  ([userId dataSourceId]
    (users-dataSources-dataPointChanges-list userId dataSourceId nil))
  ([userId dataSourceId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://fitness.googleapis.com/fitness/v1/users/{userId}/dataSources/{dataSourceId}/dataPointChanges",
       :uri-template-args {:dataSourceId dataSourceId, :userId userId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/fitness.activity.read"
        "https://www.googleapis.com/auth/fitness.activity.write"
        "https://www.googleapis.com/auth/fitness.blood_glucose.read"
        "https://www.googleapis.com/auth/fitness.blood_glucose.write"
        "https://www.googleapis.com/auth/fitness.blood_pressure.read"
        "https://www.googleapis.com/auth/fitness.blood_pressure.write"
        "https://www.googleapis.com/auth/fitness.body.read"
        "https://www.googleapis.com/auth/fitness.body.write"
        "https://www.googleapis.com/auth/fitness.body_temperature.read"
        "https://www.googleapis.com/auth/fitness.body_temperature.write"
        "https://www.googleapis.com/auth/fitness.heart_rate.read"
        "https://www.googleapis.com/auth/fitness.heart_rate.write"
        "https://www.googleapis.com/auth/fitness.location.read"
        "https://www.googleapis.com/auth/fitness.location.write"
        "https://www.googleapis.com/auth/fitness.nutrition.read"
        "https://www.googleapis.com/auth/fitness.nutrition.write"
        "https://www.googleapis.com/auth/fitness.oxygen_saturation.read"
        "https://www.googleapis.com/auth/fitness.oxygen_saturation.write"
        "https://www.googleapis.com/auth/fitness.reproductive_health.read"
        "https://www.googleapis.com/auth/fitness.reproductive_health.write"
        "https://www.googleapis.com/auth/fitness.sleep.read"
        "https://www.googleapis.com/auth/fitness.sleep.write"]})))

(defn users-sessions-delete
  "Deletes a session specified by the given session ID.
https://developers.google.com/fit/rest/v1/get-started

userId <string> Delete a session for the person identified. Use me to indicate the authenticated user. Only me is supported at this time.
sessionId <string> The ID of the session to be deleted."
  [userId sessionId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://fitness.googleapis.com/fitness/v1/users/{userId}/sessions/{sessionId}",
     :uri-template-args {:userId userId, :sessionId sessionId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/fitness.activity.write"
      "https://www.googleapis.com/auth/fitness.sleep.write"]}))

(defn users-sessions-update
  "Updates or insert a given session.
https://developers.google.com/fit/rest/v1/get-started

userId <string> Create sessions for the person identified. Use me to indicate the authenticated user. Only me is supported at this time.
sessionId <string> The ID of the session to be created.
Session:
{:description string,
 :application
 {:version string,
  :packageName string,
  :detailsUrl string,
  :name string},
 :name string,
 :endTimeMillis string,
 :activityType integer,
 :modifiedTimeMillis string,
 :id string,
 :startTimeMillis string,
 :activeTimeMillis string}"
  [userId sessionId Session]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://fitness.googleapis.com/fitness/v1/users/{userId}/sessions/{sessionId}",
     :uri-template-args {:sessionId sessionId, :userId userId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/fitness.activity.write"
      "https://www.googleapis.com/auth/fitness.sleep.write"],
     :body Session}))

(defn users-sessions-list
  "Lists sessions previously created.
https://developers.google.com/fit/rest/v1/get-started

userId <string> List sessions for the person identified. Use me to indicate the authenticated user. Only me is supported at this time.

optional:
activityType <integer> If non-empty, only sessions with these activity types should be returned.
endTime <string> An RFC3339 timestamp. Only sessions ending between the start and end times will be included in the response. If this time is omitted but startTime is specified, all sessions from startTime to the end of time will be returned.
includeDeleted <boolean> If true, and if both startTime and endTime are omitted, session deletions will be returned.
startTime <string> An RFC3339 timestamp. Only sessions ending between the start and end times will be included in the response. If this time is omitted but endTime is specified, all sessions from the start of time up to endTime will be returned."
  ([userId] (users-sessions-list userId nil))
  ([userId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://fitness.googleapis.com/fitness/v1/users/{userId}/sessions",
       :uri-template-args {:userId userId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/fitness.activity.read"
        "https://www.googleapis.com/auth/fitness.activity.write"
        "https://www.googleapis.com/auth/fitness.blood_glucose.read"
        "https://www.googleapis.com/auth/fitness.blood_glucose.write"
        "https://www.googleapis.com/auth/fitness.blood_pressure.read"
        "https://www.googleapis.com/auth/fitness.blood_pressure.write"
        "https://www.googleapis.com/auth/fitness.body.read"
        "https://www.googleapis.com/auth/fitness.body.write"
        "https://www.googleapis.com/auth/fitness.body_temperature.read"
        "https://www.googleapis.com/auth/fitness.body_temperature.write"
        "https://www.googleapis.com/auth/fitness.heart_rate.read"
        "https://www.googleapis.com/auth/fitness.heart_rate.write"
        "https://www.googleapis.com/auth/fitness.location.read"
        "https://www.googleapis.com/auth/fitness.location.write"
        "https://www.googleapis.com/auth/fitness.nutrition.read"
        "https://www.googleapis.com/auth/fitness.nutrition.write"
        "https://www.googleapis.com/auth/fitness.oxygen_saturation.read"
        "https://www.googleapis.com/auth/fitness.oxygen_saturation.write"
        "https://www.googleapis.com/auth/fitness.reproductive_health.read"
        "https://www.googleapis.com/auth/fitness.reproductive_health.write"
        "https://www.googleapis.com/auth/fitness.sleep.read"
        "https://www.googleapis.com/auth/fitness.sleep.write"]})))

(defn users-dataset-aggregate
  "Aggregates data of a certain type or stream into buckets divided by a given type of boundary. Multiple data sets of multiple types and from multiple sources can be aggregated into exactly one bucket type per request.
https://developers.google.com/fit/rest/v1/get-started

userId <string> Aggregate data for the person identified. Use me to indicate the authenticated user. Only me is supported at this time.
AggregateRequest:
{:bucketByTime
 {:period {:type [day week month], :timeZoneId string, :value integer},
  :durationMillis string},
 :filteredDataQualityStandard
 [[dataQualityUnknown
   dataQualityBloodPressureEsh2002
   dataQualityBloodPressureEsh2010
   dataQualityBloodPressureAami
   dataQualityBloodPressureBhsAA
   dataQualityBloodPressureBhsAB
   dataQualityBloodPressureBhsBA
   dataQualityBloodPressureBhsBB
   dataQualityBloodGlucoseIso151972003
   dataQualityBloodGlucoseIso151972013]],
 :endTimeMillis string,
 :startTimeMillis string,
 :bucketByActivityType
 {:activityDataSourceId string, :minDurationMillis string},
 :bucketBySession {:minDurationMillis string},
 :aggregateBy [{:dataTypeName string, :dataSourceId string}],
 :bucketByActivitySegment
 {:activityDataSourceId string, :minDurationMillis string}}"
  [userId AggregateRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://fitness.googleapis.com/fitness/v1/users/{userId}/dataset:aggregate",
     :uri-template-args {:userId userId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/fitness.activity.read"
      "https://www.googleapis.com/auth/fitness.activity.write"
      "https://www.googleapis.com/auth/fitness.blood_glucose.read"
      "https://www.googleapis.com/auth/fitness.blood_glucose.write"
      "https://www.googleapis.com/auth/fitness.blood_pressure.read"
      "https://www.googleapis.com/auth/fitness.blood_pressure.write"
      "https://www.googleapis.com/auth/fitness.body.read"
      "https://www.googleapis.com/auth/fitness.body.write"
      "https://www.googleapis.com/auth/fitness.body_temperature.read"
      "https://www.googleapis.com/auth/fitness.body_temperature.write"
      "https://www.googleapis.com/auth/fitness.heart_rate.read"
      "https://www.googleapis.com/auth/fitness.heart_rate.write"
      "https://www.googleapis.com/auth/fitness.location.read"
      "https://www.googleapis.com/auth/fitness.location.write"
      "https://www.googleapis.com/auth/fitness.nutrition.read"
      "https://www.googleapis.com/auth/fitness.nutrition.write"
      "https://www.googleapis.com/auth/fitness.oxygen_saturation.read"
      "https://www.googleapis.com/auth/fitness.oxygen_saturation.write"
      "https://www.googleapis.com/auth/fitness.reproductive_health.read"
      "https://www.googleapis.com/auth/fitness.reproductive_health.write"
      "https://www.googleapis.com/auth/fitness.sleep.read"
      "https://www.googleapis.com/auth/fitness.sleep.write"],
     :body AggregateRequest}))

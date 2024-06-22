(ns happygapi2.analyticsreporting
  "Analytics Reporting API
Accesses Analytics report data.
See: https://developers.google.com/analytics/devguides/reporting/core/v4/"
  (:require [happy.oauth2.client :as client]))

(defn reports-batchGet
  "Returns the Analytics data.
https://developers.google.com/analytics/devguides/reporting/core/v4

GetReportsRequest:
{:reportRequests
 [{:filtersExpression string,
   :hideTotals boolean,
   :viewId string,
   :dimensionFilterClauses
   [{:operator [OPERATOR_UNSPECIFIED OR AND],
     :filters
     [{:dimensionName string,
       :not boolean,
       :operator
       [OPERATOR_UNSPECIFIED
        REGEXP
        BEGINS_WITH
        ENDS_WITH
        PARTIAL
        EXACT
        NUMERIC_EQUAL
        NUMERIC_GREATER_THAN
        NUMERIC_LESS_THAN
        IN_LIST],
       :expressions [string],
       :caseSensitive boolean}]}],
   :cohortGroup
   {:cohorts
    [{:name string,
      :type [UNSPECIFIED_COHORT_TYPE FIRST_VISIT_DATE],
      :dateRange {:startDate string, :endDate string}}],
    :lifetimeValue boolean},
   :segments
   [{:dynamicSegment
     {:name string,
      :userSegment {:segmentFilters [SegmentFilter]},
      :sessionSegment {:segmentFilters [SegmentFilter]}},
     :segmentId string}],
   :dimensions [{:name string, :histogramBuckets [string]}],
   :pageToken string,
   :hideValueRanges boolean,
   :pageSize integer,
   :metricFilterClauses
   [{:operator [OPERATOR_UNSPECIFIED OR AND],
     :filters
     [{:metricName string,
       :not boolean,
       :operator
       [OPERATOR_UNSPECIFIED EQUAL LESS_THAN GREATER_THAN IS_MISSING],
       :comparisonValue string}]}],
   :includeEmptyRows boolean,
   :samplingLevel [SAMPLING_UNSPECIFIED DEFAULT SMALL LARGE],
   :pivots
   [{:dimensions [{:name string, :histogramBuckets [string]}],
     :dimensionFilterClauses
     [{:operator [OPERATOR_UNSPECIFIED OR AND],
       :filters
       [{:dimensionName string,
         :not boolean,
         :operator
         [OPERATOR_UNSPECIFIED
          REGEXP
          BEGINS_WITH
          ENDS_WITH
          PARTIAL
          EXACT
          NUMERIC_EQUAL
          NUMERIC_GREATER_THAN
          NUMERIC_LESS_THAN
          IN_LIST],
         :expressions [string],
         :caseSensitive boolean}]}],
     :metrics
     [{:expression string,
       :alias string,
       :formattingType
       [METRIC_TYPE_UNSPECIFIED INTEGER FLOAT CURRENCY PERCENT TIME]}],
     :startGroup integer,
     :maxGroupCount integer}],
   :dateRanges [{:startDate string, :endDate string}],
   :orderBys
   [{:fieldName string,
     :orderType
     [ORDER_TYPE_UNSPECIFIED
      VALUE
      DELTA
      SMART
      HISTOGRAM_BUCKET
      DIMENSION_AS_INTEGER],
     :sortOrder [SORT_ORDER_UNSPECIFIED ASCENDING DESCENDING]}],
   :metrics
   [{:expression string,
     :alias string,
     :formattingType
     [METRIC_TYPE_UNSPECIFIED INTEGER FLOAT CURRENCY PERCENT TIME]}]}],
 :useResourceQuotas boolean}"
  [GetReportsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://analyticsreporting.googleapis.com/v4/reports:batchGet",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics"
      "https://www.googleapis.com/auth/analytics.readonly"],
     :body GetReportsRequest}))

(defn userActivity-search
  "Returns User Activity data.
https://developers.google.com/analytics/devguides/reporting/core/v4

SearchUserActivityRequest:
{:dateRange {:startDate string, :endDate string},
 :viewId string,
 :user
 {:type [USER_ID_TYPE_UNSPECIFIED USER_ID CLIENT_ID], :userId string},
 :activityTypes
 [[ACTIVITY_TYPE_UNSPECIFIED
   PAGEVIEW
   SCREENVIEW
   GOAL
   ECOMMERCE
   EVENT]],
 :pageSize integer,
 :pageToken string}"
  [SearchUserActivityRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://analyticsreporting.googleapis.com/v4/userActivity:search",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics"
      "https://www.googleapis.com/auth/analytics.readonly"],
     :body SearchUserActivityRequest}))

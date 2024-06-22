(ns happygapi2.analyticsdata
  "Google Analytics Data API
Accesses report data in Google Analytics. Warning: Creating multiple Customer Applications, Accounts, or Projects to simulate or act as a single Customer Application, Account, or Project (respectively) or to circumvent Service-specific usage limits or quotas is a direct violation of Google Cloud Platform Terms of Service as well as Google APIs Terms of Service. These actions can result in immediate termination of your GCP project(s) without any warning. 
See: https://developers.google.com/analytics/devguides/reporting/data/v1/"
  (:require [happy.oauth2.client :as client]))

(defn properties-runReport
  "Returns a customized report of your Google Analytics event data. Reports contain statistics derived from data collected by the Google Analytics tracking code. The data returned from the API is as a table with columns for the requested dimensions and metrics. Metrics are individual measurements of user activity on your property, such as active users or event count. Dimensions break down metrics across some common criteria, such as country or event name. For a guide to constructing requests & understanding responses, see [Creating a Report](https://developers.google.com/analytics/devguides/reporting/data/v1/basics).
https://developers.google.com/analytics/devguides/reporting/data/v1

property <string> A Google Analytics GA4 property identifier whose events are tracked. Specified in the URL path and not the body. To learn more, see [where to find your Property ID](https://developers.google.com/analytics/devguides/reporting/data/v1/property-id). Within a batch request, this property should either be unspecified or consistent with the batch-level property. Example: properties/1234
RunReportRequest:
{:limit string,
 :offset string,
 :property string,
 :cohortSpec
 {:cohorts
  [{:name string,
    :dimension string,
    :dateRange {:startDate string, :endDate string, :name string}}],
  :cohortsRange
  {:granularity [GRANULARITY_UNSPECIFIED DAILY WEEKLY MONTHLY],
   :startOffset integer,
   :endOffset integer},
  :cohortReportSettings {:accumulate boolean}},
 :dimensionFilter
 {:andGroup
  {:expressions
   [{:andGroup {:expressions [FilterExpression]},
     :orGroup {:expressions [FilterExpression]},
     :notExpression
     {:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter},
     :filter
     {:fieldName string,
      :stringFilter StringFilter,
      :inListFilter InListFilter,
      :numericFilter NumericFilter,
      :betweenFilter BetweenFilter}}]},
  :orGroup
  {:expressions
   [{:andGroup {:expressions [FilterExpression]},
     :orGroup {:expressions [FilterExpression]},
     :notExpression
     {:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter},
     :filter
     {:fieldName string,
      :stringFilter StringFilter,
      :inListFilter InListFilter,
      :numericFilter NumericFilter,
      :betweenFilter BetweenFilter}}]},
  :notExpression
  {:andGroup
   {:expressions
    [{:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter}]},
   :orGroup
   {:expressions
    [{:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter}]},
   :notExpression
   {:andGroup {:expressions [FilterExpression]},
    :orGroup {:expressions [FilterExpression]},
    :notExpression
    {:andGroup FilterExpressionList,
     :orGroup FilterExpressionList,
     :notExpression FilterExpression,
     :filter Filter},
    :filter
    {:fieldName string,
     :stringFilter StringFilter,
     :inListFilter InListFilter,
     :numericFilter NumericFilter,
     :betweenFilter BetweenFilter}},
   :filter
   {:fieldName string,
    :stringFilter
    {:matchType
     [MATCH_TYPE_UNSPECIFIED
      EXACT
      BEGINS_WITH
      ENDS_WITH
      CONTAINS
      FULL_REGEXP
      PARTIAL_REGEXP],
     :value string,
     :caseSensitive boolean},
    :inListFilter {:values [string], :caseSensitive boolean},
    :numericFilter
    {:operation
     [OPERATION_UNSPECIFIED
      EQUAL
      LESS_THAN
      LESS_THAN_OR_EQUAL
      GREATER_THAN
      GREATER_THAN_OR_EQUAL],
     :value NumericValue},
    :betweenFilter {:fromValue NumericValue, :toValue NumericValue}}},
  :filter
  {:fieldName string,
   :stringFilter
   {:matchType
    [MATCH_TYPE_UNSPECIFIED
     EXACT
     BEGINS_WITH
     ENDS_WITH
     CONTAINS
     FULL_REGEXP
     PARTIAL_REGEXP],
    :value string,
    :caseSensitive boolean},
   :inListFilter {:values [string], :caseSensitive boolean},
   :numericFilter
   {:operation
    [OPERATION_UNSPECIFIED
     EQUAL
     LESS_THAN
     LESS_THAN_OR_EQUAL
     GREATER_THAN
     GREATER_THAN_OR_EQUAL],
    :value {:int64Value string, :doubleValue number}},
   :betweenFilter
   {:fromValue {:int64Value string, :doubleValue number},
    :toValue {:int64Value string, :doubleValue number}}}},
 :dimensions
 [{:name string,
   :dimensionExpression
   {:lowerCase {:dimensionName string},
    :upperCase {:dimensionName string},
    :concatenate {:dimensionNames [string], :delimiter string}}}],
 :metricFilter
 {:andGroup
  {:expressions
   [{:andGroup {:expressions [FilterExpression]},
     :orGroup {:expressions [FilterExpression]},
     :notExpression
     {:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter},
     :filter
     {:fieldName string,
      :stringFilter StringFilter,
      :inListFilter InListFilter,
      :numericFilter NumericFilter,
      :betweenFilter BetweenFilter}}]},
  :orGroup
  {:expressions
   [{:andGroup {:expressions [FilterExpression]},
     :orGroup {:expressions [FilterExpression]},
     :notExpression
     {:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter},
     :filter
     {:fieldName string,
      :stringFilter StringFilter,
      :inListFilter InListFilter,
      :numericFilter NumericFilter,
      :betweenFilter BetweenFilter}}]},
  :notExpression
  {:andGroup
   {:expressions
    [{:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter}]},
   :orGroup
   {:expressions
    [{:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter}]},
   :notExpression
   {:andGroup {:expressions [FilterExpression]},
    :orGroup {:expressions [FilterExpression]},
    :notExpression
    {:andGroup FilterExpressionList,
     :orGroup FilterExpressionList,
     :notExpression FilterExpression,
     :filter Filter},
    :filter
    {:fieldName string,
     :stringFilter StringFilter,
     :inListFilter InListFilter,
     :numericFilter NumericFilter,
     :betweenFilter BetweenFilter}},
   :filter
   {:fieldName string,
    :stringFilter
    {:matchType
     [MATCH_TYPE_UNSPECIFIED
      EXACT
      BEGINS_WITH
      ENDS_WITH
      CONTAINS
      FULL_REGEXP
      PARTIAL_REGEXP],
     :value string,
     :caseSensitive boolean},
    :inListFilter {:values [string], :caseSensitive boolean},
    :numericFilter
    {:operation
     [OPERATION_UNSPECIFIED
      EQUAL
      LESS_THAN
      LESS_THAN_OR_EQUAL
      GREATER_THAN
      GREATER_THAN_OR_EQUAL],
     :value NumericValue},
    :betweenFilter {:fromValue NumericValue, :toValue NumericValue}}},
  :filter
  {:fieldName string,
   :stringFilter
   {:matchType
    [MATCH_TYPE_UNSPECIFIED
     EXACT
     BEGINS_WITH
     ENDS_WITH
     CONTAINS
     FULL_REGEXP
     PARTIAL_REGEXP],
    :value string,
    :caseSensitive boolean},
   :inListFilter {:values [string], :caseSensitive boolean},
   :numericFilter
   {:operation
    [OPERATION_UNSPECIFIED
     EQUAL
     LESS_THAN
     LESS_THAN_OR_EQUAL
     GREATER_THAN
     GREATER_THAN_OR_EQUAL],
    :value {:int64Value string, :doubleValue number}},
   :betweenFilter
   {:fromValue {:int64Value string, :doubleValue number},
    :toValue {:int64Value string, :doubleValue number}}}},
 :metricAggregations
 [[METRIC_AGGREGATION_UNSPECIFIED TOTAL MINIMUM MAXIMUM COUNT]],
 :returnPropertyQuota boolean,
 :keepEmptyRows boolean,
 :currencyCode string,
 :comparisons
 [{:name string,
   :dimensionFilter
   {:andGroup
    {:expressions
     [{:andGroup FilterExpressionList,
       :orGroup FilterExpressionList,
       :notExpression FilterExpression,
       :filter Filter}]},
    :orGroup
    {:expressions
     [{:andGroup FilterExpressionList,
       :orGroup FilterExpressionList,
       :notExpression FilterExpression,
       :filter Filter}]},
    :notExpression
    {:andGroup {:expressions [FilterExpression]},
     :orGroup {:expressions [FilterExpression]},
     :notExpression
     {:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter},
     :filter
     {:fieldName string,
      :stringFilter StringFilter,
      :inListFilter InListFilter,
      :numericFilter NumericFilter,
      :betweenFilter BetweenFilter}},
    :filter
    {:fieldName string,
     :stringFilter
     {:matchType
      [MATCH_TYPE_UNSPECIFIED
       EXACT
       BEGINS_WITH
       ENDS_WITH
       CONTAINS
       FULL_REGEXP
       PARTIAL_REGEXP],
      :value string,
      :caseSensitive boolean},
     :inListFilter {:values [string], :caseSensitive boolean},
     :numericFilter
     {:operation
      [OPERATION_UNSPECIFIED
       EQUAL
       LESS_THAN
       LESS_THAN_OR_EQUAL
       GREATER_THAN
       GREATER_THAN_OR_EQUAL],
      :value NumericValue},
     :betweenFilter {:fromValue NumericValue, :toValue NumericValue}}},
   :comparison string}],
 :dateRanges [{:startDate string, :endDate string, :name string}],
 :orderBys
 [{:metric {:metricName string},
   :dimension
   {:dimensionName string,
    :orderType
    [ORDER_TYPE_UNSPECIFIED
     ALPHANUMERIC
     CASE_INSENSITIVE_ALPHANUMERIC
     NUMERIC]},
   :pivot
   {:metricName string,
    :pivotSelections
    [{:dimensionName string, :dimensionValue string}]},
   :desc boolean}],
 :metrics [{:name string, :expression string, :invisible boolean}]}"
  [property RunReportRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://analyticsdata.googleapis.com/v1beta/{+property}:runReport",
     :uri-template-args {:property property},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics"
      "https://www.googleapis.com/auth/analytics.readonly"],
     :body RunReportRequest}))

(defn properties-runPivotReport
  "Returns a customized pivot report of your Google Analytics event data. Pivot reports are more advanced and expressive formats than regular reports. In a pivot report, dimensions are only visible if they are included in a pivot. Multiple pivots can be specified to further dissect your data.
https://developers.google.com/analytics/devguides/reporting/data/v1

property <string> A Google Analytics GA4 property identifier whose events are tracked. Specified in the URL path and not the body. To learn more, see [where to find your Property ID](https://developers.google.com/analytics/devguides/reporting/data/v1/property-id). Within a batch request, this property should either be unspecified or consistent with the batch-level property. Example: properties/1234
RunPivotReportRequest:
{:property string,
 :cohortSpec
 {:cohorts
  [{:name string,
    :dimension string,
    :dateRange {:startDate string, :endDate string, :name string}}],
  :cohortsRange
  {:granularity [GRANULARITY_UNSPECIFIED DAILY WEEKLY MONTHLY],
   :startOffset integer,
   :endOffset integer},
  :cohortReportSettings {:accumulate boolean}},
 :dimensionFilter
 {:andGroup
  {:expressions
   [{:andGroup {:expressions [FilterExpression]},
     :orGroup {:expressions [FilterExpression]},
     :notExpression
     {:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter},
     :filter
     {:fieldName string,
      :stringFilter StringFilter,
      :inListFilter InListFilter,
      :numericFilter NumericFilter,
      :betweenFilter BetweenFilter}}]},
  :orGroup
  {:expressions
   [{:andGroup {:expressions [FilterExpression]},
     :orGroup {:expressions [FilterExpression]},
     :notExpression
     {:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter},
     :filter
     {:fieldName string,
      :stringFilter StringFilter,
      :inListFilter InListFilter,
      :numericFilter NumericFilter,
      :betweenFilter BetweenFilter}}]},
  :notExpression
  {:andGroup
   {:expressions
    [{:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter}]},
   :orGroup
   {:expressions
    [{:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter}]},
   :notExpression
   {:andGroup {:expressions [FilterExpression]},
    :orGroup {:expressions [FilterExpression]},
    :notExpression
    {:andGroup FilterExpressionList,
     :orGroup FilterExpressionList,
     :notExpression FilterExpression,
     :filter Filter},
    :filter
    {:fieldName string,
     :stringFilter StringFilter,
     :inListFilter InListFilter,
     :numericFilter NumericFilter,
     :betweenFilter BetweenFilter}},
   :filter
   {:fieldName string,
    :stringFilter
    {:matchType
     [MATCH_TYPE_UNSPECIFIED
      EXACT
      BEGINS_WITH
      ENDS_WITH
      CONTAINS
      FULL_REGEXP
      PARTIAL_REGEXP],
     :value string,
     :caseSensitive boolean},
    :inListFilter {:values [string], :caseSensitive boolean},
    :numericFilter
    {:operation
     [OPERATION_UNSPECIFIED
      EQUAL
      LESS_THAN
      LESS_THAN_OR_EQUAL
      GREATER_THAN
      GREATER_THAN_OR_EQUAL],
     :value NumericValue},
    :betweenFilter {:fromValue NumericValue, :toValue NumericValue}}},
  :filter
  {:fieldName string,
   :stringFilter
   {:matchType
    [MATCH_TYPE_UNSPECIFIED
     EXACT
     BEGINS_WITH
     ENDS_WITH
     CONTAINS
     FULL_REGEXP
     PARTIAL_REGEXP],
    :value string,
    :caseSensitive boolean},
   :inListFilter {:values [string], :caseSensitive boolean},
   :numericFilter
   {:operation
    [OPERATION_UNSPECIFIED
     EQUAL
     LESS_THAN
     LESS_THAN_OR_EQUAL
     GREATER_THAN
     GREATER_THAN_OR_EQUAL],
    :value {:int64Value string, :doubleValue number}},
   :betweenFilter
   {:fromValue {:int64Value string, :doubleValue number},
    :toValue {:int64Value string, :doubleValue number}}}},
 :dimensions
 [{:name string,
   :dimensionExpression
   {:lowerCase {:dimensionName string},
    :upperCase {:dimensionName string},
    :concatenate {:dimensionNames [string], :delimiter string}}}],
 :metricFilter
 {:andGroup
  {:expressions
   [{:andGroup {:expressions [FilterExpression]},
     :orGroup {:expressions [FilterExpression]},
     :notExpression
     {:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter},
     :filter
     {:fieldName string,
      :stringFilter StringFilter,
      :inListFilter InListFilter,
      :numericFilter NumericFilter,
      :betweenFilter BetweenFilter}}]},
  :orGroup
  {:expressions
   [{:andGroup {:expressions [FilterExpression]},
     :orGroup {:expressions [FilterExpression]},
     :notExpression
     {:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter},
     :filter
     {:fieldName string,
      :stringFilter StringFilter,
      :inListFilter InListFilter,
      :numericFilter NumericFilter,
      :betweenFilter BetweenFilter}}]},
  :notExpression
  {:andGroup
   {:expressions
    [{:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter}]},
   :orGroup
   {:expressions
    [{:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter}]},
   :notExpression
   {:andGroup {:expressions [FilterExpression]},
    :orGroup {:expressions [FilterExpression]},
    :notExpression
    {:andGroup FilterExpressionList,
     :orGroup FilterExpressionList,
     :notExpression FilterExpression,
     :filter Filter},
    :filter
    {:fieldName string,
     :stringFilter StringFilter,
     :inListFilter InListFilter,
     :numericFilter NumericFilter,
     :betweenFilter BetweenFilter}},
   :filter
   {:fieldName string,
    :stringFilter
    {:matchType
     [MATCH_TYPE_UNSPECIFIED
      EXACT
      BEGINS_WITH
      ENDS_WITH
      CONTAINS
      FULL_REGEXP
      PARTIAL_REGEXP],
     :value string,
     :caseSensitive boolean},
    :inListFilter {:values [string], :caseSensitive boolean},
    :numericFilter
    {:operation
     [OPERATION_UNSPECIFIED
      EQUAL
      LESS_THAN
      LESS_THAN_OR_EQUAL
      GREATER_THAN
      GREATER_THAN_OR_EQUAL],
     :value NumericValue},
    :betweenFilter {:fromValue NumericValue, :toValue NumericValue}}},
  :filter
  {:fieldName string,
   :stringFilter
   {:matchType
    [MATCH_TYPE_UNSPECIFIED
     EXACT
     BEGINS_WITH
     ENDS_WITH
     CONTAINS
     FULL_REGEXP
     PARTIAL_REGEXP],
    :value string,
    :caseSensitive boolean},
   :inListFilter {:values [string], :caseSensitive boolean},
   :numericFilter
   {:operation
    [OPERATION_UNSPECIFIED
     EQUAL
     LESS_THAN
     LESS_THAN_OR_EQUAL
     GREATER_THAN
     GREATER_THAN_OR_EQUAL],
    :value {:int64Value string, :doubleValue number}},
   :betweenFilter
   {:fromValue {:int64Value string, :doubleValue number},
    :toValue {:int64Value string, :doubleValue number}}}},
 :returnPropertyQuota boolean,
 :keepEmptyRows boolean,
 :currencyCode string,
 :comparisons
 [{:name string,
   :dimensionFilter
   {:andGroup
    {:expressions
     [{:andGroup FilterExpressionList,
       :orGroup FilterExpressionList,
       :notExpression FilterExpression,
       :filter Filter}]},
    :orGroup
    {:expressions
     [{:andGroup FilterExpressionList,
       :orGroup FilterExpressionList,
       :notExpression FilterExpression,
       :filter Filter}]},
    :notExpression
    {:andGroup {:expressions [FilterExpression]},
     :orGroup {:expressions [FilterExpression]},
     :notExpression
     {:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter},
     :filter
     {:fieldName string,
      :stringFilter StringFilter,
      :inListFilter InListFilter,
      :numericFilter NumericFilter,
      :betweenFilter BetweenFilter}},
    :filter
    {:fieldName string,
     :stringFilter
     {:matchType
      [MATCH_TYPE_UNSPECIFIED
       EXACT
       BEGINS_WITH
       ENDS_WITH
       CONTAINS
       FULL_REGEXP
       PARTIAL_REGEXP],
      :value string,
      :caseSensitive boolean},
     :inListFilter {:values [string], :caseSensitive boolean},
     :numericFilter
     {:operation
      [OPERATION_UNSPECIFIED
       EQUAL
       LESS_THAN
       LESS_THAN_OR_EQUAL
       GREATER_THAN
       GREATER_THAN_OR_EQUAL],
      :value NumericValue},
     :betweenFilter {:fromValue NumericValue, :toValue NumericValue}}},
   :comparison string}],
 :pivots
 [{:fieldNames [string],
   :orderBys
   [{:metric {:metricName string},
     :dimension
     {:dimensionName string,
      :orderType
      [ORDER_TYPE_UNSPECIFIED
       ALPHANUMERIC
       CASE_INSENSITIVE_ALPHANUMERIC
       NUMERIC]},
     :pivot
     {:metricName string,
      :pivotSelections
      [{:dimensionName string, :dimensionValue string}]},
     :desc boolean}],
   :offset string,
   :limit string,
   :metricAggregations
   [[METRIC_AGGREGATION_UNSPECIFIED TOTAL MINIMUM MAXIMUM COUNT]]}],
 :dateRanges [{:startDate string, :endDate string, :name string}],
 :metrics [{:name string, :expression string, :invisible boolean}]}"
  [property RunPivotReportRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://analyticsdata.googleapis.com/v1beta/{+property}:runPivotReport",
     :uri-template-args {:property property},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics"
      "https://www.googleapis.com/auth/analytics.readonly"],
     :body RunPivotReportRequest}))

(defn properties-batchRunReports
  "Returns multiple reports in a batch. All reports must be for the same GA4 Property.
https://developers.google.com/analytics/devguides/reporting/data/v1

property <string> A Google Analytics GA4 property identifier whose events are tracked. Specified in the URL path and not the body. To learn more, see [where to find your Property ID](https://developers.google.com/analytics/devguides/reporting/data/v1/property-id). This property must be specified for the batch. The property within RunReportRequest may either be unspecified or consistent with this property. Example: properties/1234
BatchRunReportsRequest:
{:requests
 [{:limit string,
   :offset string,
   :property string,
   :cohortSpec
   {:cohorts
    [{:name string,
      :dimension string,
      :dateRange {:startDate string, :endDate string, :name string}}],
    :cohortsRange
    {:granularity [GRANULARITY_UNSPECIFIED DAILY WEEKLY MONTHLY],
     :startOffset integer,
     :endOffset integer},
    :cohortReportSettings {:accumulate boolean}},
   :dimensionFilter
   {:andGroup
    {:expressions
     [{:andGroup FilterExpressionList,
       :orGroup FilterExpressionList,
       :notExpression FilterExpression,
       :filter Filter}]},
    :orGroup
    {:expressions
     [{:andGroup FilterExpressionList,
       :orGroup FilterExpressionList,
       :notExpression FilterExpression,
       :filter Filter}]},
    :notExpression
    {:andGroup {:expressions [FilterExpression]},
     :orGroup {:expressions [FilterExpression]},
     :notExpression
     {:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter},
     :filter
     {:fieldName string,
      :stringFilter StringFilter,
      :inListFilter InListFilter,
      :numericFilter NumericFilter,
      :betweenFilter BetweenFilter}},
    :filter
    {:fieldName string,
     :stringFilter
     {:matchType
      [MATCH_TYPE_UNSPECIFIED
       EXACT
       BEGINS_WITH
       ENDS_WITH
       CONTAINS
       FULL_REGEXP
       PARTIAL_REGEXP],
      :value string,
      :caseSensitive boolean},
     :inListFilter {:values [string], :caseSensitive boolean},
     :numericFilter
     {:operation
      [OPERATION_UNSPECIFIED
       EQUAL
       LESS_THAN
       LESS_THAN_OR_EQUAL
       GREATER_THAN
       GREATER_THAN_OR_EQUAL],
      :value NumericValue},
     :betweenFilter {:fromValue NumericValue, :toValue NumericValue}}},
   :dimensions
   [{:name string,
     :dimensionExpression
     {:lowerCase {:dimensionName string},
      :upperCase {:dimensionName string},
      :concatenate {:dimensionNames [string], :delimiter string}}}],
   :metricFilter
   {:andGroup
    {:expressions
     [{:andGroup FilterExpressionList,
       :orGroup FilterExpressionList,
       :notExpression FilterExpression,
       :filter Filter}]},
    :orGroup
    {:expressions
     [{:andGroup FilterExpressionList,
       :orGroup FilterExpressionList,
       :notExpression FilterExpression,
       :filter Filter}]},
    :notExpression
    {:andGroup {:expressions [FilterExpression]},
     :orGroup {:expressions [FilterExpression]},
     :notExpression
     {:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter},
     :filter
     {:fieldName string,
      :stringFilter StringFilter,
      :inListFilter InListFilter,
      :numericFilter NumericFilter,
      :betweenFilter BetweenFilter}},
    :filter
    {:fieldName string,
     :stringFilter
     {:matchType
      [MATCH_TYPE_UNSPECIFIED
       EXACT
       BEGINS_WITH
       ENDS_WITH
       CONTAINS
       FULL_REGEXP
       PARTIAL_REGEXP],
      :value string,
      :caseSensitive boolean},
     :inListFilter {:values [string], :caseSensitive boolean},
     :numericFilter
     {:operation
      [OPERATION_UNSPECIFIED
       EQUAL
       LESS_THAN
       LESS_THAN_OR_EQUAL
       GREATER_THAN
       GREATER_THAN_OR_EQUAL],
      :value NumericValue},
     :betweenFilter {:fromValue NumericValue, :toValue NumericValue}}},
   :metricAggregations
   [[METRIC_AGGREGATION_UNSPECIFIED TOTAL MINIMUM MAXIMUM COUNT]],
   :returnPropertyQuota boolean,
   :keepEmptyRows boolean,
   :currencyCode string,
   :comparisons
   [{:name string,
     :dimensionFilter
     {:andGroup {:expressions [FilterExpression]},
      :orGroup {:expressions [FilterExpression]},
      :notExpression
      {:andGroup FilterExpressionList,
       :orGroup FilterExpressionList,
       :notExpression FilterExpression,
       :filter Filter},
      :filter
      {:fieldName string,
       :stringFilter StringFilter,
       :inListFilter InListFilter,
       :numericFilter NumericFilter,
       :betweenFilter BetweenFilter}},
     :comparison string}],
   :dateRanges [{:startDate string, :endDate string, :name string}],
   :orderBys
   [{:metric {:metricName string},
     :dimension
     {:dimensionName string,
      :orderType
      [ORDER_TYPE_UNSPECIFIED
       ALPHANUMERIC
       CASE_INSENSITIVE_ALPHANUMERIC
       NUMERIC]},
     :pivot
     {:metricName string,
      :pivotSelections
      [{:dimensionName string, :dimensionValue string}]},
     :desc boolean}],
   :metrics [{:name string, :expression string, :invisible boolean}]}]}"
  [property BatchRunReportsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://analyticsdata.googleapis.com/v1beta/{+property}:batchRunReports",
     :uri-template-args {:property property},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics"
      "https://www.googleapis.com/auth/analytics.readonly"],
     :body BatchRunReportsRequest}))

(defn properties-batchRunPivotReports
  "Returns multiple pivot reports in a batch. All reports must be for the same GA4 Property.
https://developers.google.com/analytics/devguides/reporting/data/v1

property <string> A Google Analytics GA4 property identifier whose events are tracked. Specified in the URL path and not the body. To learn more, see [where to find your Property ID](https://developers.google.com/analytics/devguides/reporting/data/v1/property-id). This property must be specified for the batch. The property within RunPivotReportRequest may either be unspecified or consistent with this property. Example: properties/1234
BatchRunPivotReportsRequest:
{:requests
 [{:property string,
   :cohortSpec
   {:cohorts
    [{:name string,
      :dimension string,
      :dateRange {:startDate string, :endDate string, :name string}}],
    :cohortsRange
    {:granularity [GRANULARITY_UNSPECIFIED DAILY WEEKLY MONTHLY],
     :startOffset integer,
     :endOffset integer},
    :cohortReportSettings {:accumulate boolean}},
   :dimensionFilter
   {:andGroup
    {:expressions
     [{:andGroup FilterExpressionList,
       :orGroup FilterExpressionList,
       :notExpression FilterExpression,
       :filter Filter}]},
    :orGroup
    {:expressions
     [{:andGroup FilterExpressionList,
       :orGroup FilterExpressionList,
       :notExpression FilterExpression,
       :filter Filter}]},
    :notExpression
    {:andGroup {:expressions [FilterExpression]},
     :orGroup {:expressions [FilterExpression]},
     :notExpression
     {:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter},
     :filter
     {:fieldName string,
      :stringFilter StringFilter,
      :inListFilter InListFilter,
      :numericFilter NumericFilter,
      :betweenFilter BetweenFilter}},
    :filter
    {:fieldName string,
     :stringFilter
     {:matchType
      [MATCH_TYPE_UNSPECIFIED
       EXACT
       BEGINS_WITH
       ENDS_WITH
       CONTAINS
       FULL_REGEXP
       PARTIAL_REGEXP],
      :value string,
      :caseSensitive boolean},
     :inListFilter {:values [string], :caseSensitive boolean},
     :numericFilter
     {:operation
      [OPERATION_UNSPECIFIED
       EQUAL
       LESS_THAN
       LESS_THAN_OR_EQUAL
       GREATER_THAN
       GREATER_THAN_OR_EQUAL],
      :value NumericValue},
     :betweenFilter {:fromValue NumericValue, :toValue NumericValue}}},
   :dimensions
   [{:name string,
     :dimensionExpression
     {:lowerCase {:dimensionName string},
      :upperCase {:dimensionName string},
      :concatenate {:dimensionNames [string], :delimiter string}}}],
   :metricFilter
   {:andGroup
    {:expressions
     [{:andGroup FilterExpressionList,
       :orGroup FilterExpressionList,
       :notExpression FilterExpression,
       :filter Filter}]},
    :orGroup
    {:expressions
     [{:andGroup FilterExpressionList,
       :orGroup FilterExpressionList,
       :notExpression FilterExpression,
       :filter Filter}]},
    :notExpression
    {:andGroup {:expressions [FilterExpression]},
     :orGroup {:expressions [FilterExpression]},
     :notExpression
     {:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter},
     :filter
     {:fieldName string,
      :stringFilter StringFilter,
      :inListFilter InListFilter,
      :numericFilter NumericFilter,
      :betweenFilter BetweenFilter}},
    :filter
    {:fieldName string,
     :stringFilter
     {:matchType
      [MATCH_TYPE_UNSPECIFIED
       EXACT
       BEGINS_WITH
       ENDS_WITH
       CONTAINS
       FULL_REGEXP
       PARTIAL_REGEXP],
      :value string,
      :caseSensitive boolean},
     :inListFilter {:values [string], :caseSensitive boolean},
     :numericFilter
     {:operation
      [OPERATION_UNSPECIFIED
       EQUAL
       LESS_THAN
       LESS_THAN_OR_EQUAL
       GREATER_THAN
       GREATER_THAN_OR_EQUAL],
      :value NumericValue},
     :betweenFilter {:fromValue NumericValue, :toValue NumericValue}}},
   :returnPropertyQuota boolean,
   :keepEmptyRows boolean,
   :currencyCode string,
   :comparisons
   [{:name string,
     :dimensionFilter
     {:andGroup {:expressions [FilterExpression]},
      :orGroup {:expressions [FilterExpression]},
      :notExpression
      {:andGroup FilterExpressionList,
       :orGroup FilterExpressionList,
       :notExpression FilterExpression,
       :filter Filter},
      :filter
      {:fieldName string,
       :stringFilter StringFilter,
       :inListFilter InListFilter,
       :numericFilter NumericFilter,
       :betweenFilter BetweenFilter}},
     :comparison string}],
   :pivots
   [{:fieldNames [string],
     :orderBys
     [{:metric {:metricName string},
       :dimension
       {:dimensionName string,
        :orderType
        [ORDER_TYPE_UNSPECIFIED
         ALPHANUMERIC
         CASE_INSENSITIVE_ALPHANUMERIC
         NUMERIC]},
       :pivot {:metricName string, :pivotSelections [PivotSelection]},
       :desc boolean}],
     :offset string,
     :limit string,
     :metricAggregations
     [[METRIC_AGGREGATION_UNSPECIFIED TOTAL MINIMUM MAXIMUM COUNT]]}],
   :dateRanges [{:startDate string, :endDate string, :name string}],
   :metrics [{:name string, :expression string, :invisible boolean}]}]}"
  [property BatchRunPivotReportsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://analyticsdata.googleapis.com/v1beta/{+property}:batchRunPivotReports",
     :uri-template-args {:property property},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics"
      "https://www.googleapis.com/auth/analytics.readonly"],
     :body BatchRunPivotReportsRequest}))

(defn properties-getMetadata
  "Returns metadata for dimensions and metrics available in reporting methods. Used to explore the dimensions and metrics. In this method, a Google Analytics GA4 Property Identifier is specified in the request, and the metadata response includes Custom dimensions and metrics as well as Universal metadata. For example if a custom metric with parameter name `levels_unlocked` is registered to a property, the Metadata response will contain `customEvent:levels_unlocked`. Universal metadata are dimensions and metrics applicable to any property such as `country` and `totalUsers`.
https://developers.google.com/analytics/devguides/reporting/data/v1

name <string> Required. The resource name of the metadata to retrieve. This name field is specified in the URL path and not URL parameters. Property is a numeric Google Analytics GA4 Property identifier. To learn more, see [where to find your Property ID](https://developers.google.com/analytics/devguides/reporting/data/v1/property-id). Example: properties/1234/metadata Set the Property ID to 0 for dimensions and metrics common to all properties. In this special mode, this method will not return custom dimensions and metrics."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://analyticsdata.googleapis.com/v1beta/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics"
      "https://www.googleapis.com/auth/analytics.readonly"]}))

(defn properties-runRealtimeReport
  "Returns a customized report of realtime event data for your property. Events appear in realtime reports seconds after they have been sent to the Google Analytics. Realtime reports show events and usage data for the periods of time ranging from the present moment to 30 minutes ago (up to 60 minutes for Google Analytics 360 properties). For a guide to constructing realtime requests & understanding responses, see [Creating a Realtime Report](https://developers.google.com/analytics/devguides/reporting/data/v1/realtime-basics).
https://developers.google.com/analytics/devguides/reporting/data/v1

property <string> A Google Analytics GA4 property identifier whose events are tracked. Specified in the URL path and not the body. To learn more, see [where to find your Property ID](https://developers.google.com/analytics/devguides/reporting/data/v1/property-id). Example: properties/1234
RunRealtimeReportRequest:
{:limit string,
 :dimensionFilter
 {:andGroup
  {:expressions
   [{:andGroup {:expressions [FilterExpression]},
     :orGroup {:expressions [FilterExpression]},
     :notExpression
     {:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter},
     :filter
     {:fieldName string,
      :stringFilter StringFilter,
      :inListFilter InListFilter,
      :numericFilter NumericFilter,
      :betweenFilter BetweenFilter}}]},
  :orGroup
  {:expressions
   [{:andGroup {:expressions [FilterExpression]},
     :orGroup {:expressions [FilterExpression]},
     :notExpression
     {:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter},
     :filter
     {:fieldName string,
      :stringFilter StringFilter,
      :inListFilter InListFilter,
      :numericFilter NumericFilter,
      :betweenFilter BetweenFilter}}]},
  :notExpression
  {:andGroup
   {:expressions
    [{:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter}]},
   :orGroup
   {:expressions
    [{:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter}]},
   :notExpression
   {:andGroup {:expressions [FilterExpression]},
    :orGroup {:expressions [FilterExpression]},
    :notExpression
    {:andGroup FilterExpressionList,
     :orGroup FilterExpressionList,
     :notExpression FilterExpression,
     :filter Filter},
    :filter
    {:fieldName string,
     :stringFilter StringFilter,
     :inListFilter InListFilter,
     :numericFilter NumericFilter,
     :betweenFilter BetweenFilter}},
   :filter
   {:fieldName string,
    :stringFilter
    {:matchType
     [MATCH_TYPE_UNSPECIFIED
      EXACT
      BEGINS_WITH
      ENDS_WITH
      CONTAINS
      FULL_REGEXP
      PARTIAL_REGEXP],
     :value string,
     :caseSensitive boolean},
    :inListFilter {:values [string], :caseSensitive boolean},
    :numericFilter
    {:operation
     [OPERATION_UNSPECIFIED
      EQUAL
      LESS_THAN
      LESS_THAN_OR_EQUAL
      GREATER_THAN
      GREATER_THAN_OR_EQUAL],
     :value NumericValue},
    :betweenFilter {:fromValue NumericValue, :toValue NumericValue}}},
  :filter
  {:fieldName string,
   :stringFilter
   {:matchType
    [MATCH_TYPE_UNSPECIFIED
     EXACT
     BEGINS_WITH
     ENDS_WITH
     CONTAINS
     FULL_REGEXP
     PARTIAL_REGEXP],
    :value string,
    :caseSensitive boolean},
   :inListFilter {:values [string], :caseSensitive boolean},
   :numericFilter
   {:operation
    [OPERATION_UNSPECIFIED
     EQUAL
     LESS_THAN
     LESS_THAN_OR_EQUAL
     GREATER_THAN
     GREATER_THAN_OR_EQUAL],
    :value {:int64Value string, :doubleValue number}},
   :betweenFilter
   {:fromValue {:int64Value string, :doubleValue number},
    :toValue {:int64Value string, :doubleValue number}}}},
 :dimensions
 [{:name string,
   :dimensionExpression
   {:lowerCase {:dimensionName string},
    :upperCase {:dimensionName string},
    :concatenate {:dimensionNames [string], :delimiter string}}}],
 :metricFilter
 {:andGroup
  {:expressions
   [{:andGroup {:expressions [FilterExpression]},
     :orGroup {:expressions [FilterExpression]},
     :notExpression
     {:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter},
     :filter
     {:fieldName string,
      :stringFilter StringFilter,
      :inListFilter InListFilter,
      :numericFilter NumericFilter,
      :betweenFilter BetweenFilter}}]},
  :orGroup
  {:expressions
   [{:andGroup {:expressions [FilterExpression]},
     :orGroup {:expressions [FilterExpression]},
     :notExpression
     {:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter},
     :filter
     {:fieldName string,
      :stringFilter StringFilter,
      :inListFilter InListFilter,
      :numericFilter NumericFilter,
      :betweenFilter BetweenFilter}}]},
  :notExpression
  {:andGroup
   {:expressions
    [{:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter}]},
   :orGroup
   {:expressions
    [{:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter}]},
   :notExpression
   {:andGroup {:expressions [FilterExpression]},
    :orGroup {:expressions [FilterExpression]},
    :notExpression
    {:andGroup FilterExpressionList,
     :orGroup FilterExpressionList,
     :notExpression FilterExpression,
     :filter Filter},
    :filter
    {:fieldName string,
     :stringFilter StringFilter,
     :inListFilter InListFilter,
     :numericFilter NumericFilter,
     :betweenFilter BetweenFilter}},
   :filter
   {:fieldName string,
    :stringFilter
    {:matchType
     [MATCH_TYPE_UNSPECIFIED
      EXACT
      BEGINS_WITH
      ENDS_WITH
      CONTAINS
      FULL_REGEXP
      PARTIAL_REGEXP],
     :value string,
     :caseSensitive boolean},
    :inListFilter {:values [string], :caseSensitive boolean},
    :numericFilter
    {:operation
     [OPERATION_UNSPECIFIED
      EQUAL
      LESS_THAN
      LESS_THAN_OR_EQUAL
      GREATER_THAN
      GREATER_THAN_OR_EQUAL],
     :value NumericValue},
    :betweenFilter {:fromValue NumericValue, :toValue NumericValue}}},
  :filter
  {:fieldName string,
   :stringFilter
   {:matchType
    [MATCH_TYPE_UNSPECIFIED
     EXACT
     BEGINS_WITH
     ENDS_WITH
     CONTAINS
     FULL_REGEXP
     PARTIAL_REGEXP],
    :value string,
    :caseSensitive boolean},
   :inListFilter {:values [string], :caseSensitive boolean},
   :numericFilter
   {:operation
    [OPERATION_UNSPECIFIED
     EQUAL
     LESS_THAN
     LESS_THAN_OR_EQUAL
     GREATER_THAN
     GREATER_THAN_OR_EQUAL],
    :value {:int64Value string, :doubleValue number}},
   :betweenFilter
   {:fromValue {:int64Value string, :doubleValue number},
    :toValue {:int64Value string, :doubleValue number}}}},
 :metricAggregations
 [[METRIC_AGGREGATION_UNSPECIFIED TOTAL MINIMUM MAXIMUM COUNT]],
 :returnPropertyQuota boolean,
 :minuteRanges
 [{:startMinutesAgo integer, :endMinutesAgo integer, :name string}],
 :orderBys
 [{:metric {:metricName string},
   :dimension
   {:dimensionName string,
    :orderType
    [ORDER_TYPE_UNSPECIFIED
     ALPHANUMERIC
     CASE_INSENSITIVE_ALPHANUMERIC
     NUMERIC]},
   :pivot
   {:metricName string,
    :pivotSelections
    [{:dimensionName string, :dimensionValue string}]},
   :desc boolean}],
 :metrics [{:name string, :expression string, :invisible boolean}]}"
  [property RunRealtimeReportRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://analyticsdata.googleapis.com/v1beta/{+property}:runRealtimeReport",
     :uri-template-args {:property property},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics"
      "https://www.googleapis.com/auth/analytics.readonly"],
     :body RunRealtimeReportRequest}))

(defn properties-checkCompatibility
  "This compatibility method lists dimensions and metrics that can be added to a report request and maintain compatibility. This method fails if the request's dimensions and metrics are incompatible. In Google Analytics, reports fail if they request incompatible dimensions and/or metrics; in that case, you will need to remove dimensions and/or metrics from the incompatible report until the report is compatible. The Realtime and Core reports have different compatibility rules. This method checks compatibility for Core reports.
https://developers.google.com/analytics/devguides/reporting/data/v1

property <string> A Google Analytics GA4 property identifier whose events are tracked. To learn more, see [where to find your Property ID](https://developers.google.com/analytics/devguides/reporting/data/v1/property-id). `property` should be the same value as in your `runReport` request. Example: properties/1234
CheckCompatibilityRequest:
{:dimensions
 [{:name string,
   :dimensionExpression
   {:lowerCase {:dimensionName string},
    :upperCase {:dimensionName string},
    :concatenate {:dimensionNames [string], :delimiter string}}}],
 :metrics [{:name string, :expression string, :invisible boolean}],
 :dimensionFilter
 {:andGroup
  {:expressions
   [{:andGroup {:expressions [FilterExpression]},
     :orGroup {:expressions [FilterExpression]},
     :notExpression
     {:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter},
     :filter
     {:fieldName string,
      :stringFilter StringFilter,
      :inListFilter InListFilter,
      :numericFilter NumericFilter,
      :betweenFilter BetweenFilter}}]},
  :orGroup
  {:expressions
   [{:andGroup {:expressions [FilterExpression]},
     :orGroup {:expressions [FilterExpression]},
     :notExpression
     {:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter},
     :filter
     {:fieldName string,
      :stringFilter StringFilter,
      :inListFilter InListFilter,
      :numericFilter NumericFilter,
      :betweenFilter BetweenFilter}}]},
  :notExpression
  {:andGroup
   {:expressions
    [{:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter}]},
   :orGroup
   {:expressions
    [{:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter}]},
   :notExpression
   {:andGroup {:expressions [FilterExpression]},
    :orGroup {:expressions [FilterExpression]},
    :notExpression
    {:andGroup FilterExpressionList,
     :orGroup FilterExpressionList,
     :notExpression FilterExpression,
     :filter Filter},
    :filter
    {:fieldName string,
     :stringFilter StringFilter,
     :inListFilter InListFilter,
     :numericFilter NumericFilter,
     :betweenFilter BetweenFilter}},
   :filter
   {:fieldName string,
    :stringFilter
    {:matchType
     [MATCH_TYPE_UNSPECIFIED
      EXACT
      BEGINS_WITH
      ENDS_WITH
      CONTAINS
      FULL_REGEXP
      PARTIAL_REGEXP],
     :value string,
     :caseSensitive boolean},
    :inListFilter {:values [string], :caseSensitive boolean},
    :numericFilter
    {:operation
     [OPERATION_UNSPECIFIED
      EQUAL
      LESS_THAN
      LESS_THAN_OR_EQUAL
      GREATER_THAN
      GREATER_THAN_OR_EQUAL],
     :value NumericValue},
    :betweenFilter {:fromValue NumericValue, :toValue NumericValue}}},
  :filter
  {:fieldName string,
   :stringFilter
   {:matchType
    [MATCH_TYPE_UNSPECIFIED
     EXACT
     BEGINS_WITH
     ENDS_WITH
     CONTAINS
     FULL_REGEXP
     PARTIAL_REGEXP],
    :value string,
    :caseSensitive boolean},
   :inListFilter {:values [string], :caseSensitive boolean},
   :numericFilter
   {:operation
    [OPERATION_UNSPECIFIED
     EQUAL
     LESS_THAN
     LESS_THAN_OR_EQUAL
     GREATER_THAN
     GREATER_THAN_OR_EQUAL],
    :value {:int64Value string, :doubleValue number}},
   :betweenFilter
   {:fromValue {:int64Value string, :doubleValue number},
    :toValue {:int64Value string, :doubleValue number}}}},
 :metricFilter
 {:andGroup
  {:expressions
   [{:andGroup {:expressions [FilterExpression]},
     :orGroup {:expressions [FilterExpression]},
     :notExpression
     {:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter},
     :filter
     {:fieldName string,
      :stringFilter StringFilter,
      :inListFilter InListFilter,
      :numericFilter NumericFilter,
      :betweenFilter BetweenFilter}}]},
  :orGroup
  {:expressions
   [{:andGroup {:expressions [FilterExpression]},
     :orGroup {:expressions [FilterExpression]},
     :notExpression
     {:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter},
     :filter
     {:fieldName string,
      :stringFilter StringFilter,
      :inListFilter InListFilter,
      :numericFilter NumericFilter,
      :betweenFilter BetweenFilter}}]},
  :notExpression
  {:andGroup
   {:expressions
    [{:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter}]},
   :orGroup
   {:expressions
    [{:andGroup FilterExpressionList,
      :orGroup FilterExpressionList,
      :notExpression FilterExpression,
      :filter Filter}]},
   :notExpression
   {:andGroup {:expressions [FilterExpression]},
    :orGroup {:expressions [FilterExpression]},
    :notExpression
    {:andGroup FilterExpressionList,
     :orGroup FilterExpressionList,
     :notExpression FilterExpression,
     :filter Filter},
    :filter
    {:fieldName string,
     :stringFilter StringFilter,
     :inListFilter InListFilter,
     :numericFilter NumericFilter,
     :betweenFilter BetweenFilter}},
   :filter
   {:fieldName string,
    :stringFilter
    {:matchType
     [MATCH_TYPE_UNSPECIFIED
      EXACT
      BEGINS_WITH
      ENDS_WITH
      CONTAINS
      FULL_REGEXP
      PARTIAL_REGEXP],
     :value string,
     :caseSensitive boolean},
    :inListFilter {:values [string], :caseSensitive boolean},
    :numericFilter
    {:operation
     [OPERATION_UNSPECIFIED
      EQUAL
      LESS_THAN
      LESS_THAN_OR_EQUAL
      GREATER_THAN
      GREATER_THAN_OR_EQUAL],
     :value NumericValue},
    :betweenFilter {:fromValue NumericValue, :toValue NumericValue}}},
  :filter
  {:fieldName string,
   :stringFilter
   {:matchType
    [MATCH_TYPE_UNSPECIFIED
     EXACT
     BEGINS_WITH
     ENDS_WITH
     CONTAINS
     FULL_REGEXP
     PARTIAL_REGEXP],
    :value string,
    :caseSensitive boolean},
   :inListFilter {:values [string], :caseSensitive boolean},
   :numericFilter
   {:operation
    [OPERATION_UNSPECIFIED
     EQUAL
     LESS_THAN
     LESS_THAN_OR_EQUAL
     GREATER_THAN
     GREATER_THAN_OR_EQUAL],
    :value {:int64Value string, :doubleValue number}},
   :betweenFilter
   {:fromValue {:int64Value string, :doubleValue number},
    :toValue {:int64Value string, :doubleValue number}}}},
 :compatibilityFilter
 [COMPATIBILITY_UNSPECIFIED COMPATIBLE INCOMPATIBLE]}"
  [property CheckCompatibilityRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://analyticsdata.googleapis.com/v1beta/{+property}:checkCompatibility",
     :uri-template-args {:property property},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics"
      "https://www.googleapis.com/auth/analytics.readonly"],
     :body CheckCompatibilityRequest}))

(defn properties-audienceExports-create
  "Creates an audience export for later retrieval. This method quickly returns the audience export's resource name and initiates a long running asynchronous request to form an audience export. To export the users in an audience export, first create the audience export through this method and then send the audience resource name to the `QueryAudienceExport` method. See [Creating an Audience Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics) for an introduction to Audience Exports with examples. An audience export is a snapshot of the users currently in the audience at the time of audience export creation. Creating audience exports for one audience on different days will return different results as users enter and exit the audience. Audiences in Google Analytics 4 allow you to segment your users in the ways that are important to your business. To learn more, see https://support.google.com/analytics/answer/9267572. Audience exports contain the users in each audience. Audience Export APIs have some methods at alpha and other methods at beta stability. The intention is to advance methods to beta stability after some feedback and adoption. To give your feedback on this API, complete the [Google Analytics Audience Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
https://developers.google.com/analytics/devguides/reporting/data/v1

parent <string> Required. The parent resource where this audience export will be created. Format: `properties/{property}`
AudienceExport:
{:audienceDisplayName string,
 :errorMessage string,
 :name string,
 :percentageCompleted number,
 :state [STATE_UNSPECIFIED CREATING ACTIVE FAILED],
 :dimensions [{:dimensionName string}],
 :creationQuotaTokensCharged integer,
 :audience string,
 :rowCount integer,
 :beginCreatingTime string}"
  [parent AudienceExport]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://analyticsdata.googleapis.com/v1beta/{+parent}/audienceExports",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics"
      "https://www.googleapis.com/auth/analytics.readonly"],
     :body AudienceExport}))

(defn properties-audienceExports-query
  "Retrieves an audience export of users. After creating an audience, the users are not immediately available for exporting. First, a request to `CreateAudienceExport` is necessary to create an audience export of users, and then second, this method is used to retrieve the users in the audience export. See [Creating an Audience Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics) for an introduction to Audience Exports with examples. Audiences in Google Analytics 4 allow you to segment your users in the ways that are important to your business. To learn more, see https://support.google.com/analytics/answer/9267572. Audience Export APIs have some methods at alpha and other methods at beta stability. The intention is to advance methods to beta stability after some feedback and adoption. To give your feedback on this API, complete the [Google Analytics Audience Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
https://developers.google.com/analytics/devguides/reporting/data/v1

name <string> Required. The name of the audience export to retrieve users from. Format: `properties/{property}/audienceExports/{audience_export}`
QueryAudienceExportRequest:
{:offset string, :limit string}"
  [name QueryAudienceExportRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://analyticsdata.googleapis.com/v1beta/{+name}:query",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics"
      "https://www.googleapis.com/auth/analytics.readonly"],
     :body QueryAudienceExportRequest}))

(defn properties-audienceExports-get
  "Gets configuration metadata about a specific audience export. This method can be used to understand an audience export after it has been created. See [Creating an Audience Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics) for an introduction to Audience Exports with examples. Audience Export APIs have some methods at alpha and other methods at beta stability. The intention is to advance methods to beta stability after some feedback and adoption. To give your feedback on this API, complete the [Google Analytics Audience Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
https://developers.google.com/analytics/devguides/reporting/data/v1

name <string> Required. The audience export resource name. Format: `properties/{property}/audienceExports/{audience_export}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://analyticsdata.googleapis.com/v1beta/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics"
      "https://www.googleapis.com/auth/analytics.readonly"]}))

(defn properties-audienceExports-list
  "Lists all audience exports for a property. This method can be used for you to find and reuse existing audience exports rather than creating unnecessary new audience exports. The same audience can have multiple audience exports that represent the export of users that were in an audience on different days. See [Creating an Audience Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics) for an introduction to Audience Exports with examples. Audience Export APIs have some methods at alpha and other methods at beta stability. The intention is to advance methods to beta stability after some feedback and adoption. To give your feedback on this API, complete the [Google Analytics Audience Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
https://developers.google.com/analytics/devguides/reporting/data/v1

parent <string> Required. All audience exports for this property will be listed in the response. Format: `properties/{property}`

optional:
pageSize <integer> Optional. The maximum number of audience exports to return. The service may return fewer than this value. If unspecified, at most 200 audience exports will be returned. The maximum value is 1000 (higher values will be coerced to the maximum)."
  ([parent] (properties-audienceExports-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://analyticsdata.googleapis.com/v1beta/{+parent}/audienceExports",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/analytics"
        "https://www.googleapis.com/auth/analytics.readonly"]})))

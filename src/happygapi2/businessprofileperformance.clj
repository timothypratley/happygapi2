(ns happygapi2.businessprofileperformance
  "Business Profile Performance API
The Business Profile Performance API allows merchants to fetch performance reports about their business profile on Google. Note - If you have a quota of 0 after enabling the API, please request for GBP API access.
See: https://developers.google.com/my-business/"
  (:require [happy.oauth2.client :as client]))

(defn locations-getDailyMetricsTimeSeries
  " Returns the values for each date from a given time range that are associated with the specific daily metric. Example request: `GET https://businessprofileperformance.googleapis.com/v1/locations/12345:getDailyMetricsTimeSeries?dailyMetric=WEBSITE_CLICKS&daily_range.start_date.year=2022&daily_range.start_date.month=1&daily_range.start_date.day=1&daily_range.end_date.year=2022&daily_range.end_date.month=3&daily_range.end_date.day=31`
https://developers.google.com/my-business

name <string> Required. The location for which the time series should be fetched. Format: locations/{location_id} where location_id is an unobfuscated listing id.

optional:
dailyRange.endDate.year <integer> Year of the date. Must be from 1 to 9999, or 0 to specify a date without a year.
dailySubEntityType.timeOfDay.hours <integer> Hours of day in 24 hour format. Should be from 0 to 23. An API may choose to allow the value \"24:00:00\" for scenarios like business closing time.
dailySubEntityType.timeOfDay.nanos <integer> Fractions of seconds in nanoseconds. Must be from 0 to 999,999,999.
dailyRange.startDate.month <integer> Month of a year. Must be from 1 to 12, or 0 to specify a year without a month and day.
dailyRange.startDate.day <integer> Day of a month. Must be from 1 to 31 and valid for the year and month, or 0 to specify a year by itself or a year and month where the day isn't significant.
dailySubEntityType.timeOfDay.minutes <integer> Minutes of hour of day. Must be from 0 to 59.
dailyMetric <string> Required. The metric to retrieve time series.
dailySubEntityType.timeOfDay.seconds <integer> Seconds of minutes of the time. Must normally be from 0 to 59. An API may allow the value 60 if it allows leap-seconds.
dailyRange.endDate.month <integer> Month of a year. Must be from 1 to 12, or 0 to specify a year without a month and day.
dailySubEntityType.dayOfWeek <string> Represents the day of the week. Eg: MONDAY. Currently supported DailyMetrics = NONE.
dailyRange.startDate.year <integer> Year of the date. Must be from 1 to 9999, or 0 to specify a date without a year.
dailyRange.endDate.day <integer> Day of a month. Must be from 1 to 31 and valid for the year and month, or 0 to specify a year by itself or a year and month where the day isn't significant."
  ([name] (locations-getDailyMetricsTimeSeries name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://businessprofileperformance.googleapis.com/v1/{+name}:getDailyMetricsTimeSeries",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes nil})))

(defn locations-fetchMultiDailyMetricsTimeSeries
  " Returns the values for each date from a given time range and optionally the sub entity type, where applicable, that are associated with the specific daily metrics. Example request: `GET https://businessprofileperformance.googleapis.com/v1/locations/12345:fetchMultiDailyMetricsTimeSeries?dailyMetrics=WEBSITE_CLICKS&dailyMetrics=CALL_CLICKS&daily_range.start_date.year=2022&daily_range.start_date.month=1&daily_range.start_date.day=1&daily_range.end_date.year=2022&daily_range.end_date.month=3&daily_range.end_date.day=31`
https://developers.google.com/my-business

location <string> Required. The location for which the time series should be fetched. Format: locations/{location_id} where location_id is an unobfuscated listing id.

optional:
dailyMetrics <string> Required. The metrics to retrieve time series for.
dailyRange.startDate.year <integer> Year of the date. Must be from 1 to 9999, or 0 to specify a date without a year.
dailyRange.startDate.month <integer> Month of a year. Must be from 1 to 12, or 0 to specify a year without a month and day.
dailyRange.startDate.day <integer> Day of a month. Must be from 1 to 31 and valid for the year and month, or 0 to specify a year by itself or a year and month where the day isn't significant.
dailyRange.endDate.year <integer> Year of the date. Must be from 1 to 9999, or 0 to specify a date without a year.
dailyRange.endDate.month <integer> Month of a year. Must be from 1 to 12, or 0 to specify a year without a month and day.
dailyRange.endDate.day <integer> Day of a month. Must be from 1 to 31 and valid for the year and month, or 0 to specify a year by itself or a year and month where the day isn't significant."
  ([location]
    (locations-fetchMultiDailyMetricsTimeSeries location nil))
  ([location optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://businessprofileperformance.googleapis.com/v1/{+location}:fetchMultiDailyMetricsTimeSeries",
       :uri-template-args {:location location},
       :query-params (merge {} optional),
       :scopes nil})))

(defn locations-searchkeywords-impressions-monthly-list
  "Returns the search keywords used to find a business in search or maps. Each search keyword is accompanied by impressions which are aggregated on a monthly basis. Example request: `GET https://businessprofileperformance.googleapis.com/v1/locations/12345/searchkeywords/impressions/monthly?monthly_range.start_month.year=2022&monthly_range.start_month.month=1&monthly_range.end_month.year=2022&monthly_range.end_month.month=3`
https://developers.google.com/my-business

parent <string> Required. The location for which the time series should be fetched. Format: locations/{location_id} where location_id is an unobfuscated listing id.

optional:
monthlyRange.startMonth.day <integer> Day of a month. Must be from 1 to 31 and valid for the year and month, or 0 to specify a year by itself or a year and month where the day isn't significant.
monthlyRange.endMonth.day <integer> Day of a month. Must be from 1 to 31 and valid for the year and month, or 0 to specify a year by itself or a year and month where the day isn't significant.
monthlyRange.startMonth.year <integer> Year of the date. Must be from 1 to 9999, or 0 to specify a date without a year.
monthlyRange.startMonth.month <integer> Month of a year. Must be from 1 to 12, or 0 to specify a year without a month and day.
pageSize <integer> Optional. The number of results requested. The default page size is 100. Page size can be set to a maximum of 100.
monthlyRange.endMonth.year <integer> Year of the date. Must be from 1 to 9999, or 0 to specify a date without a year.
monthlyRange.endMonth.month <integer> Month of a year. Must be from 1 to 12, or 0 to specify a year without a month and day."
  ([parent]
    (locations-searchkeywords-impressions-monthly-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://businessprofileperformance.googleapis.com/v1/{+parent}/searchkeywords/impressions/monthly",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes nil})))

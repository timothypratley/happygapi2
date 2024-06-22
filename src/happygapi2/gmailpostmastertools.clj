(ns happygapi2.gmailpostmastertools
  "Gmail Postmaster Tools API
The Postmaster Tools API is a RESTful API that provides programmatic access to email traffic metrics (like spam reports, delivery errors etc) otherwise available through the Gmail Postmaster Tools UI currently.
See: https://developers.google.com/gmail/postmaster"
  (:require [happy.oauth2.client :as client]))

(defn domains-get
  "Gets a specific domain registered by the client. Returns NOT_FOUND if the domain does not exist.
https://developers.google.com/gmail/postmaster/reference/rest/v1/domains/get

name <string> The resource name of the domain. It should have the form `domains/{domain_name}`, where domain_name is the fully qualified domain name."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://gmailpostmastertools.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/postmaster.readonly"]}))

(defn domains-list
  "Lists the domains that have been registered by the client. The order of domains in the response is unspecified and non-deterministic. Newly created domains will not necessarily be added to the end of this list.
https://developers.google.com/gmail/postmaster/reference/rest/v1/domains/list

optional:
pageSize <integer> Requested page size. Server may return fewer domains than requested. If unspecified, server will pick an appropriate default."
  ([] (domains-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gmailpostmastertools.googleapis.com/v1/domains",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/postmaster.readonly"]})))

(defn domains-trafficStats-list
  "List traffic statistics for all available days. Returns PERMISSION_DENIED if user does not have permission to access TrafficStats for the domain.
https://developers.google.com/gmail/postmaster/reference/rest/v1/domains/trafficStats/list

parent <string> The resource name of the domain whose traffic statistics we'd like to list. It should have the form `domains/{domain_name}`, where domain_name is the fully qualified domain name.

optional:
startDate.day <integer> Day of a month. Must be from 1 to 31 and valid for the year and month, or 0 to specify a year by itself or a year and month where the day isn't significant.
endDate.month <integer> Month of a year. Must be from 1 to 12, or 0 to specify a year without a month and day.
endDate.day <integer> Day of a month. Must be from 1 to 31 and valid for the year and month, or 0 to specify a year by itself or a year and month where the day isn't significant.
startDate.year <integer> Year of the date. Must be from 1 to 9999, or 0 to specify a date without a year.
pageSize <integer> Requested page size. Server may return fewer TrafficStats than requested. If unspecified, server will pick an appropriate default.
startDate.month <integer> Month of a year. Must be from 1 to 12, or 0 to specify a year without a month and day.
endDate.year <integer> Year of the date. Must be from 1 to 9999, or 0 to specify a date without a year."
  ([parent] (domains-trafficStats-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gmailpostmastertools.googleapis.com/v1/{+parent}/trafficStats",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/postmaster.readonly"]})))

(defn domains-trafficStats-get
  "Get traffic statistics for a domain on a specific date. Returns PERMISSION_DENIED if user does not have permission to access TrafficStats for the domain.
https://developers.google.com/gmail/postmaster/reference/rest/v1/domains/trafficStats/get

name <string> The resource name of the traffic statistics to get. E.g., domains/mymail.mydomain.com/trafficStats/20160807."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://gmailpostmastertools.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/postmaster.readonly"]}))

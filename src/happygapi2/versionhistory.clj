(ns happygapi2.versionhistory
  "versionhistory.googleapis.com API
Version History API - Prod
See: https://developers.chrome.com/versionhistory"
  (:require [happy.oauth2.client :as client]))

(defn platforms-list
  "Returns list of platforms that are available for a given product. The resource \"product\" has no resource name in its name.
https://developers.chrome.com/versionhistory

parent <string> Required. The product, which owns this collection of platforms. Format: {product}

optional:
pageSize <integer> Optional. Optional limit on the number of channels to include in the response. If unspecified, the server will pick an appropriate default."
  ([parent] (platforms-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://versionhistory.googleapis.com/v1/{+parent}/platforms",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes nil})))

(defn platforms-channels-list
  "Returns list of channels that are available for a given platform.
https://developers.chrome.com/versionhistory

parent <string> Required. The platform, which owns this collection of channels. Format: {product}/platforms/{platform}

optional:
pageSize <integer> Optional. Optional limit on the number of channels to include in the response. If unspecified, the server will pick an appropriate default."
  ([parent] (platforms-channels-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://versionhistory.googleapis.com/v1/{+parent}/channels",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes nil})))

(defn platforms-channels-versions-list
  "Returns list of version for the given platform/channel.
https://developers.chrome.com/versionhistory

parent <string> Required. The channel, which owns this collection of versions. Format: {product}/platforms/{platform}/channels/{channel}

optional:
pageSize <integer> Optional. Optional limit on the number of versions to include in the response. If unspecified, the server will pick an appropriate default.
orderBy <string> Optional. Ordering string. Valid order_by strings are \"version\", \"name\", \"platform\", and \"channel\". Optionally, you can append \" desc\" or \" asc\" to specify the sorting order. Multiple order_by strings can be used in a comma separated list. Ordering by channel will sort by distance from the stable channel (not alphabetically). A list of channels sorted in this order is: stable, beta, dev, canary, and canary_asan. Sorting by name may cause unexpected behaviour as it is a naive string sort. For example, 1.0.0.8 will be before 1.0.0.10 in descending order. If order_by is not specified the response will be sorted by version in descending order. Ex) \"...?order_by=version asc\" Ex) \"...?order_by=platform desc, channel, version\"
filter <string> Optional. Filter string. Format is a comma separated list of All comma separated filter clauses are conjoined with a logical \"and\". Valid field_names are \"version\", \"name\", \"platform\", and \"channel\". Valid operators are \"<\", \"<=\", \"=\", \">=\", and \">\". Channel comparison is done by distance from stable. Ex) stable < beta, beta < dev, canary < canary_asan. Version comparison is done numerically. If version is not entirely written, the version will be appended with 0 in missing fields. Ex) version > 80 becoms version > 80.0.0.0 Name and platform are filtered by string comparison. Ex) \"...?filter=channel<=beta, version >= 80 Ex) \"...?filter=version > 80, version < 81"
  ([parent] (platforms-channels-versions-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://versionhistory.googleapis.com/v1/{+parent}/versions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes nil})))

(defn platforms-channels-versions-releases-list
  "Returns list of releases of the given version.
https://developers.chrome.com/versionhistory

parent <string> Required. The version, which owns this collection of releases. Format: {product}/platforms/{platform}/channels/{channel}/versions/{version}

optional:
pageSize <integer> Optional. Optional limit on the number of releases to include in the response. If unspecified, the server will pick an appropriate default.
orderBy <string> Optional. Ordering string. Valid order_by strings are \"version\", \"name\", \"starttime\", \"endtime\", \"platform\", \"channel\", and \"fraction\". Optionally, you can append \"desc\" or \"asc\" to specify the sorting order. Multiple order_by strings can be used in a comma separated list. Ordering by channel will sort by distance from the stable channel (not alphabetically). A list of channels sorted in this order is: stable, beta, dev, canary, and canary_asan. Sorting by name may cause unexpected behaviour as it is a naive string sort. For example, 1.0.0.8 will be before 1.0.0.10 in descending order. If order_by is not specified the response will be sorted by starttime in descending order. Ex) \"...?order_by=starttime asc\" Ex) \"...?order_by=platform desc, channel, startime desc\"
filter <string> Optional. Filter string. Format is a comma separated list of All comma separated filter clauses are conjoined with a logical \"and\". Valid field_names are \"version\", \"name\", \"platform\", \"channel\", \"fraction\" \"starttime\", and \"endtime\". Valid operators are \"<\", \"<=\", \"=\", \">=\", and \">\". Channel comparison is done by distance from stable. must be a valid channel when filtering by channel. Ex) stable < beta, beta < dev, canary < canary_asan. Version comparison is done numerically. Ex) 1.0.0.8 < 1.0.0.10. If version is not entirely written, the version will be appended with 0 for the missing fields. Ex) version > 80 becoms version > 80.0.0.0 When filtering by starttime or endtime, string must be in RFC 3339 date string format. Name and platform are filtered by string comparison. Ex) \"...?filter=channel<=beta, version >= 80 Ex) \"...?filter=version > 80, version < 81 Ex) \"...?filter=starttime>2020-01-01T00:00:00Z"
  ([parent] (platforms-channels-versions-releases-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://versionhistory.googleapis.com/v1/{+parent}/releases",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes nil})))

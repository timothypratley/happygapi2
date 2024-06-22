(ns happygapi2.safebrowsing
  "Safe Browsing API
Enables client applications to check web resources (most commonly URLs) against Google-generated lists of unsafe web resources. The Safe Browsing APIs are for non-commercial use only. If you need to use APIs to detect malicious URLs for commercial purposes – meaning “for sale or revenue-generating purposes” – please refer to the Web Risk API.
See: https://developers.google.com/safe-browsing/"
  (:require [happy.oauth2.client :as client]))

(defn hashes-search
  "Search for full hashes matching the specified prefixes. This is a custom method as defined by https://google.aip.dev/136 (the custom method refers to this method having a custom name within Google's general API development nomenclature; it does not refer to using a custom HTTP method).
https://developers.google.com/safe-browsing/reference/rest/v5/hashes/search

optional:
hashPrefixes <string> Required. The hash prefixes to be looked up. Clients MUST NOT send more than 1000 hash prefixes. However, following the URL processing procedure, clients SHOULD NOT need to send more than 30 hash prefixes. Currently each hash prefix is required to be exactly 4 bytes long. This MAY be relaxed in the future."
  ([] (hashes-search nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://safebrowsing.googleapis.com/v5/hashes:search",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes nil})))

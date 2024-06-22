(ns happygapi2.domainsrdap
  "Domains RDAP API
Read-only public API that lets users search for information about domain names.
See: https://developers.google.com/domains/rdap/"
  (:require [happy.oauth2.client :as client]))

(defn domain-get
  "Look up RDAP information for a domain by name.
https://developers.google.com/domains/rdap/reference/rest/v1/domain/get

domainName <string> Full domain name to look up. Example: \"example.com\""
  [domainName]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://domainsrdap.googleapis.com/v1/domain/{+domainName}",
     :uri-template-args {:domainName domainName},
     :query-params {},
     :scopes nil}))

(defn getHelp
  "Get help information for the RDAP API, including links to documentation.
https://developers.google.com/domains/rdap/reference/rest/v1/getHelp"
  []
  (client/api-request
    {:method "GET",
     :uri-template "https://domainsrdap.googleapis.com/v1/help",
     :uri-template-args {},
     :query-params {},
     :scopes nil}))

(defn getIp
  "The RDAP API recognizes this command from the RDAP specification but does not support it. The response is a formatted 501 error.
https://developers.google.com/domains/rdap/reference/rest/v1/getIp"
  []
  (client/api-request
    {:method "GET",
     :uri-template "https://domainsrdap.googleapis.com/v1/ip",
     :uri-template-args {},
     :query-params {},
     :scopes nil}))

(defn getDomains
  "The RDAP API recognizes this command from the RDAP specification but does not support it. The response is a formatted 501 error.
https://developers.google.com/domains/rdap/reference/rest/v1/getDomains"
  []
  (client/api-request
    {:method "GET",
     :uri-template "https://domainsrdap.googleapis.com/v1/domains",
     :uri-template-args {},
     :query-params {},
     :scopes nil}))

(defn getEntities
  "The RDAP API recognizes this command from the RDAP specification but does not support it. The response is a formatted 501 error.
https://developers.google.com/domains/rdap/reference/rest/v1/getEntities"
  []
  (client/api-request
    {:method "GET",
     :uri-template "https://domainsrdap.googleapis.com/v1/entities",
     :uri-template-args {},
     :query-params {},
     :scopes nil}))

(defn getNameservers
  "The RDAP API recognizes this command from the RDAP specification but does not support it. The response is a formatted 501 error.
https://developers.google.com/domains/rdap/reference/rest/v1/getNameservers"
  []
  (client/api-request
    {:method "GET",
     :uri-template "https://domainsrdap.googleapis.com/v1/nameservers",
     :uri-template-args {},
     :query-params {},
     :scopes nil}))

(defn entity-get
  "The RDAP API recognizes this command from the RDAP specification but does not support it. The response is a formatted 501 error.
https://developers.google.com/domains/rdap/reference/rest/v1/entity/get

entityId <string> "
  [entityId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://domainsrdap.googleapis.com/v1/entity/{entityId}",
     :uri-template-args {:entityId entityId},
     :query-params {},
     :scopes nil}))

(defn autnum-get
  "The RDAP API recognizes this command from the RDAP specification but does not support it. The response is a formatted 501 error.
https://developers.google.com/domains/rdap/reference/rest/v1/autnum/get

autnumId <string> "
  [autnumId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://domainsrdap.googleapis.com/v1/autnum/{autnumId}",
     :uri-template-args {:autnumId autnumId},
     :query-params {},
     :scopes nil}))

(defn nameserver-get
  "The RDAP API recognizes this command from the RDAP specification but does not support it. The response is a formatted 501 error.
https://developers.google.com/domains/rdap/reference/rest/v1/nameserver/get

nameserverId <string> "
  [nameserverId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://domainsrdap.googleapis.com/v1/nameserver/{nameserverId}",
     :uri-template-args {:nameserverId nameserverId},
     :query-params {},
     :scopes nil}))

(defn ip-get
  "The RDAP API recognizes this command from the RDAP specification but does not support it. The response is a formatted 501 error.
https://developers.google.com/domains/rdap/reference/rest/v1/ip/get

ipId <string> 
ipId1 <string> "
  [ipId ipId1]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://domainsrdap.googleapis.com/v1/ip/{ipId}/{ipId1}",
     :uri-template-args {:ipId ipId, :ipId1 ipId1},
     :query-params {},
     :scopes nil}))

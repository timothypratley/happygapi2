(ns happygapi2.acmedns
  "ACME DNS API
Google Domains ACME DNS API that allows users to complete ACME DNS-01 challenges for a domain.
See: https://developers.google.com/domains/acme-dns/"
  (:require [happy.oauth2.client :as client]))

(defn acmeChallengeSets-get
  "Gets the ACME challenge set for a given domain name. Domain names must be provided in Punycode.
https://developers.google.com/domains/acme-dns/reference/rest/v1/acmeChallengeSets/get

rootDomain <string> Required. SLD + TLD domain name to list challenges. For example, this would be \"google.com\" for any FQDN under \"google.com\". That includes challenges for \"subdomain.google.com\". This MAY be Unicode or Punycode."
  [rootDomain]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://acmedns.googleapis.com/v1/acmeChallengeSets/{rootDomain}",
     :uri-template-args {:rootDomain rootDomain},
     :query-params {},
     :scopes nil}))

(defn acmeChallengeSets-rotateChallenges
  "Rotate the ACME challenges for a given domain name. By default, removes any challenges that are older than 30 days. Domain names must be provided in Punycode.
https://developers.google.com/domains/acme-dns/reference/rest/v1/acmeChallengeSets/rotateChallenges

rootDomain <string> Required. SLD + TLD domain name to update records for. For example, this would be \"google.com\" for any FQDN under \"google.com\". That includes challenges for \"subdomain.google.com\". This MAY be Unicode or Punycode.
RotateChallengesRequest:
{:accessToken string,
 :recordsToRemove [{:digest string, :updateTime string, :fqdn string}],
 :keepExpiredRecords boolean,
 :recordsToAdd [{:digest string, :updateTime string, :fqdn string}]}"
  [rootDomain RotateChallengesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://acmedns.googleapis.com/v1/acmeChallengeSets/{rootDomain}:rotateChallenges",
     :uri-template-args {:rootDomain rootDomain},
     :query-params {},
     :scopes nil,
     :body RotateChallengesRequest}))

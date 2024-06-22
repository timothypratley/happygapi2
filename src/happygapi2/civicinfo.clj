(ns happygapi2.civicinfo
  "Google Civic Information API
Provides polling places, early vote locations, contest data, election officials, and government representatives for U.S. residential addresses.
See: https://developers.google.com/civic-information/"
  (:require [happy.oauth2.client :as client]))

(defn elections-voterInfoQuery
  "Looks up information relevant to a voter based on the voter's registered address.
https://developers.google.com/civic-information/docs/v2/elections/voterInfoQuery

optional:
address <string> The registered address of the voter to look up.
electionId <string> The unique ID of the election to look up. A list of election IDs can be obtained at https://www.googleapis.com/civicinfo/{version}/elections. If no election ID is specified in the query and there is more than one election with data for the given voter, the additional elections are provided in the otherElections response field.
officialOnly <boolean> If set to true, only data from official state sources will be returned.
returnAllAvailableData <boolean> If set to true, the query will return the success code and include any partial information when it is unable to determine a matching address or unable to determine the election for electionId=0 queries.
productionDataOnly <boolean> Whether to include data that has not been vetted yet. Should only be made available to internal IPs or trusted partners. This is a non-discoverable parameter in the One Platform API config."
  ([] (elections-voterInfoQuery nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://civicinfo.googleapis.com/civicinfo/v2/voterinfo",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes nil})))

(defn elections-electionQuery
  "List of available elections to query.
https://developers.google.com/civic-information/docs/v2/elections/electionQuery

optional:
productionDataOnly <boolean> Whether to include data that has not been allowlisted yet"
  ([] (elections-electionQuery nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://civicinfo.googleapis.com/civicinfo/v2/elections",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes nil})))

(defn representatives-representativeInfoByDivision
  "Looks up representative information for a single geographic division.
https://developers.google.com/civic-information/docs/v2/representatives/representativeInfoByDivision

ocdId <string> The Open Civic Data division identifier of the division to look up.

optional:
recursive <boolean> If true, information about all divisions contained in the division requested will be included as well. For example, if querying ocd-division/country:us/district:dc, this would also return all DC's wards and ANCs.
roles <string> A list of office roles to filter by. Only offices fulfilling one of these roles will be returned. Divisions that don't contain a matching office will not be returned.
levels <string> A list of office levels to filter by. Only offices that serve at least one of these levels will be returned. Divisions that don't contain a matching office will not be returned."
  ([ocdId] (representatives-representativeInfoByDivision ocdId nil))
  ([ocdId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://civicinfo.googleapis.com/civicinfo/v2/representatives/{ocdId}",
       :uri-template-args {:ocdId ocdId},
       :query-params (merge {} optional),
       :scopes nil})))

(defn representatives-representativeInfoByAddress
  "Looks up political geography and representative information for a single address.
https://developers.google.com/civic-information/docs/v2/representatives/representativeInfoByAddress

optional:
address <string> The address to look up. May only be specified if the field ocdId is not given in the URL
roles <string> A list of office roles to filter by. Only offices fulfilling one of these roles will be returned. Divisions that don't contain a matching office will not be returned.
levels <string> A list of office levels to filter by. Only offices that serve at least one of these levels will be returned. Divisions that don't contain a matching office will not be returned.
includeOffices <boolean> Whether to return information about offices and officials. If false, only the top-level district information will be returned."
  ([] (representatives-representativeInfoByAddress nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://civicinfo.googleapis.com/civicinfo/v2/representatives",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes nil})))

(defn divisions-search
  "Searches for political divisions by their natural name or OCD ID.
https://developers.google.com/civic-information/docs/v2/divisions/search

optional:
query <string> The search query. Queries can cover any parts of a OCD ID or a human readable division name. All words given in the query are treated as required patterns. In addition to that, most query operators of the Apache Lucene library are supported. See http://lucene.apache.org/core/2_9_4/queryparsersyntax.html"
  ([] (divisions-search nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://civicinfo.googleapis.com/civicinfo/v2/divisions",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes nil})))

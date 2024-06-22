(ns happygapi2.people
  "People API
Provides access to information about profiles and contacts.
See: https://developers.google.com/people/"
  (:require [happy.oauth2.client :as client]))

(defn people-createContact
  "Create a new contact and return the person resource for that contact. The request returns a 400 error if more than one field is specified on a field that is a singleton for contact sources: * biographies * birthdays * genders * names Mutate requests for the same user should be sent sequentially to avoid increased latency and failures.
https://developers.google.com/people/api/rest/v1/people/createContact

Person:
{:addresses
 [{:formattedType string,
   :poBox string,
   :city string,
   :type string,
   :streetAddress string,
   :region string,
   :formattedValue string,
   :postalCode string,
   :extendedAddress string,
   :country string,
   :metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :countryCode string}],
 :urls
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string,
   :type string,
   :formattedType string}],
 :relationshipStatuses
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string,
   :formattedValue string}],
 :coverPhotos
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :url string,
   :default boolean}],
 :birthdays
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :date {:year integer, :month integer, :day integer},
   :text string}],
 :relations
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :person string,
   :type string,
   :formattedType string}],
 :ageRange
 [AGE_RANGE_UNSPECIFIED
  LESS_THAN_EIGHTEEN
  EIGHTEEN_TO_TWENTY
  TWENTY_ONE_OR_OLDER],
 :events
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :date {:year integer, :month integer, :day integer},
   :type string,
   :formattedType string}],
 :phoneNumbers
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string,
   :canonicalForm string,
   :type string,
   :formattedType string}],
 :etag string,
 :fileAses
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string}],
 :biographies
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string,
   :contentType [CONTENT_TYPE_UNSPECIFIED TEXT_PLAIN TEXT_HTML]}],
 :emailAddresses
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string,
   :type string,
   :formattedType string,
   :displayName string}],
 :miscKeywords
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string,
   :type
   [TYPE_UNSPECIFIED
    OUTLOOK_BILLING_INFORMATION
    OUTLOOK_DIRECTORY_SERVER
    OUTLOOK_KEYWORD
    OUTLOOK_MILEAGE
    OUTLOOK_PRIORITY
    OUTLOOK_SENSITIVITY
    OUTLOOK_SUBJECT
    OUTLOOK_USER
    HOME
    WORK
    OTHER],
   :formattedType string}],
 :organizations
 [{:department string,
   :formattedType string,
   :symbol string,
   :name string,
   :startDate {:year integer, :month integer, :day integer},
   :type string,
   :fullTimeEquivalentMillipercent integer,
   :phoneticName string,
   :costCenter string,
   :title string,
   :endDate {:year integer, :month integer, :day integer},
   :jobDescription string,
   :current boolean,
   :domain string,
   :location string,
   :metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}}}],
 :sipAddresses
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string,
   :type string,
   :formattedType string}],
 :braggingRights
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string}],
 :resourceName string,
 :locations
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string,
   :type string,
   :current boolean,
   :buildingId string,
   :floor string,
   :floorSection string,
   :deskCode string}],
 :externalIds
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string,
   :type string,
   :formattedType string}],
 :relationshipInterests
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string,
   :formattedValue string}],
 :photos
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :url string,
   :default boolean}],
 :skills
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string}],
 :locales
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string}],
 :ageRanges
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :ageRange
   [AGE_RANGE_UNSPECIFIED
    LESS_THAN_EIGHTEEN
    EIGHTEEN_TO_TWENTY
    TWENTY_ONE_OR_OLDER]}],
 :memberships
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :contactGroupMembership
   {:contactGroupId string, :contactGroupResourceName string},
   :domainMembership {:inViewerDomain boolean}}],
 :clientData
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :key string,
   :value string}],
 :interests
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string}],
 :nicknames
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string,
   :type
   [DEFAULT
    MAIDEN_NAME
    INITIALS
    GPLUS
    OTHER_NAME
    ALTERNATE_NAME
    SHORT_NAME]}],
 :residences
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string,
   :current boolean}],
 :imClients
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :username string,
   :type string,
   :formattedType string,
   :protocol string,
   :formattedProtocol string}],
 :genders
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string,
   :formattedValue string,
   :addressMeAs string}],
 :calendarUrls
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :url string,
   :type string,
   :formattedType string}],
 :taglines
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string}],
 :occupations
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string}],
 :metadata
 {:sources
  [{:type
    [SOURCE_TYPE_UNSPECIFIED
     ACCOUNT
     PROFILE
     DOMAIN_PROFILE
     CONTACT
     OTHER_CONTACT
     DOMAIN_CONTACT],
    :id string,
    :etag string,
    :profileMetadata
    {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
     :userTypes
     [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
    :updateTime string}],
  :previousResourceNames [string],
  :linkedPeopleResourceNames [string],
  :deleted boolean,
  :objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE]},
 :names
 [{:middleName string,
   :phoneticHonorificPrefix string,
   :phoneticHonorificSuffix string,
   :displayNameLastFirst string,
   :displayName string,
   :phoneticGivenName string,
   :honorificPrefix string,
   :phoneticFullName string,
   :phoneticFamilyName string,
   :familyName string,
   :phoneticMiddleName string,
   :unstructuredName string,
   :givenName string,
   :honorificSuffix string,
   :metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}}}],
 :userDefined
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :key string,
   :value string}]}

optional:
personFields <string> Required. A field mask to restrict which fields on each person are returned. Multiple fields can be specified by separating them with commas. Defaults to all fields if not set. Valid values are: * addresses * ageRanges * biographies * birthdays * calendarUrls * clientData * coverPhotos * emailAddresses * events * externalIds * genders * imClients * interests * locales * locations * memberships * metadata * miscKeywords * names * nicknames * occupations * organizations * phoneNumbers * photos * relations * sipAddresses * skills * urls * userDefined
sources <string> Optional. A mask of what source types to return. Defaults to READ_SOURCE_TYPE_CONTACT and READ_SOURCE_TYPE_PROFILE if not set."
  ([Person] (people-createContact Person nil))
  ([Person optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://people.googleapis.com/v1/people:createContact",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/contacts"],
       :body Person})))

(defn people-searchContacts
  "Provides a list of contacts in the authenticated user's grouped contacts that matches the search query. The query matches on a contact's `names`, `nickNames`, `emailAddresses`, `phoneNumbers`, and `organizations` fields that are from the CONTACT source. **IMPORTANT**: Before searching, clients should send a warmup request with an empty query to update the cache. See https://developers.google.com/people/v1/contacts#search_the_users_contacts
https://developers.google.com/people/api/rest/v1/people/searchContacts

optional:
query <string> Required. The plain-text query for the request. The query is used to match prefix phrases of the fields on a person. For example, a person with name \"foo name\" matches queries such as \"f\", \"fo\", \"foo\", \"foo n\", \"nam\", etc., but not \"oo n\".
pageSize <integer> Optional. The number of results to return. Defaults to 10 if field is not set, or set to 0. Values greater than 30 will be capped to 30.
readMask <string> Required. A field mask to restrict which fields on each person are returned. Multiple fields can be specified by separating them with commas. Valid values are: * addresses * ageRanges * biographies * birthdays * calendarUrls * clientData * coverPhotos * emailAddresses * events * externalIds * genders * imClients * interests * locales * locations * memberships * metadata * miscKeywords * names * nicknames * occupations * organizations * phoneNumbers * photos * relations * sipAddresses * skills * urls * userDefined
sources <string> Optional. A mask of what source types to return. Defaults to READ_SOURCE_TYPE_CONTACT if not set."
  ([] (people-searchContacts nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://people.googleapis.com/v1/people:searchContacts",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/contacts"
        "https://www.googleapis.com/auth/contacts.readonly"]})))

(defn people-get
  "Provides information about a person by specifying a resource name. Use `people/me` to indicate the authenticated user. The request returns a 400 error if 'personFields' is not specified.
https://developers.google.com/people/api/rest/v1/people/get

resourceName <string> Required. The resource name of the person to provide information about. - To get information about the authenticated user, specify `people/me`. - To get information about a google account, specify `people/{account_id}`. - To get information about a contact, specify the resource name that identifies the contact as returned by `people.connections.list`.

optional:
requestMask.includeField <string> Required. Comma-separated list of person fields to be included in the response. Each path should start with `person.`: for example, `person.names` or `person.photos`.
personFields <string> Required. A field mask to restrict which fields on the person are returned. Multiple fields can be specified by separating them with commas. Valid values are: * addresses * ageRanges * biographies * birthdays * calendarUrls * clientData * coverPhotos * emailAddresses * events * externalIds * genders * imClients * interests * locales * locations * memberships * metadata * miscKeywords * names * nicknames * occupations * organizations * phoneNumbers * photos * relations * sipAddresses * skills * urls * userDefined
sources <string> Optional. A mask of what source types to return. Defaults to READ_SOURCE_TYPE_PROFILE and READ_SOURCE_TYPE_CONTACT if not set."
  ([resourceName] (people-get resourceName nil))
  ([resourceName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://people.googleapis.com/v1/{+resourceName}",
       :uri-template-args {:resourceName resourceName},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/contacts"
        "https://www.googleapis.com/auth/contacts.other.readonly"
        "https://www.googleapis.com/auth/contacts.readonly"
        "https://www.googleapis.com/auth/directory.readonly"
        "https://www.googleapis.com/auth/user.addresses.read"
        "https://www.googleapis.com/auth/user.birthday.read"
        "https://www.googleapis.com/auth/user.emails.read"
        "https://www.googleapis.com/auth/user.gender.read"
        "https://www.googleapis.com/auth/user.organization.read"
        "https://www.googleapis.com/auth/user.phonenumbers.read"
        "https://www.googleapis.com/auth/userinfo.email"
        "https://www.googleapis.com/auth/userinfo.profile"]})))

(defn people-searchDirectoryPeople
  "Provides a list of domain profiles and domain contacts in the authenticated user's domain directory that match the search query.
https://developers.google.com/people/api/rest/v1/people/searchDirectoryPeople

optional:
query <string> Required. Prefix query that matches fields in the person. Does NOT use the read_mask for determining what fields to match.
readMask <string> Required. A field mask to restrict which fields on each person are returned. Multiple fields can be specified by separating them with commas. Valid values are: * addresses * ageRanges * biographies * birthdays * calendarUrls * clientData * coverPhotos * emailAddresses * events * externalIds * genders * imClients * interests * locales * locations * memberships * metadata * miscKeywords * names * nicknames * occupations * organizations * phoneNumbers * photos * relations * sipAddresses * skills * urls * userDefined
sources <string> Required. Directory sources to return.
mergeSources <string> Optional. Additional data to merge into the directory sources if they are connected through verified join keys such as email addresses or phone numbers.
pageSize <integer> Optional. The number of people to include in the response. Valid values are between 1 and 500, inclusive. Defaults to 100 if not set or set to 0."
  ([] (people-searchDirectoryPeople nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://people.googleapis.com/v1/people:searchDirectoryPeople",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/directory.readonly"]})))

(defn people-deleteContact
  "Delete a contact person. Any non-contact data will not be deleted. Mutate requests for the same user should be sent sequentially to avoid increased latency and failures.
https://developers.google.com/people/api/rest/v1/people/deleteContact

resourceName <string> Required. The resource name of the contact to delete."
  [resourceName]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://people.googleapis.com/v1/{+resourceName}:deleteContact",
     :uri-template-args {:resourceName resourceName},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/contacts"]}))

(defn people-updateContact
  "Update contact data for an existing contact person. Any non-contact data will not be modified. Any non-contact data in the person to update will be ignored. All fields specified in the `update_mask` will be replaced. The server returns a 400 error if `person.metadata.sources` is not specified for the contact to be updated or if there is no contact source. The server returns a 400 error with reason `\"failedPrecondition\"` if `person.metadata.sources.etag` is different than the contact's etag, which indicates the contact has changed since its data was read. Clients should get the latest person and merge their updates into the latest person. The server returns a 400 error if `memberships` are being updated and there are no contact group memberships specified on the person. The server returns a 400 error if more than one field is specified on a field that is a singleton for contact sources: * biographies * birthdays * genders * names Mutate requests for the same user should be sent sequentially to avoid increased latency and failures.
https://developers.google.com/people/api/rest/v1/people/updateContact

resourceName <string> The resource name for the person, assigned by the server. An ASCII string in the form of `people/{person_id}`.
Person:
{:addresses
 [{:formattedType string,
   :poBox string,
   :city string,
   :type string,
   :streetAddress string,
   :region string,
   :formattedValue string,
   :postalCode string,
   :extendedAddress string,
   :country string,
   :metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :countryCode string}],
 :urls
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string,
   :type string,
   :formattedType string}],
 :relationshipStatuses
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string,
   :formattedValue string}],
 :coverPhotos
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :url string,
   :default boolean}],
 :birthdays
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :date {:year integer, :month integer, :day integer},
   :text string}],
 :relations
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :person string,
   :type string,
   :formattedType string}],
 :ageRange
 [AGE_RANGE_UNSPECIFIED
  LESS_THAN_EIGHTEEN
  EIGHTEEN_TO_TWENTY
  TWENTY_ONE_OR_OLDER],
 :events
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :date {:year integer, :month integer, :day integer},
   :type string,
   :formattedType string}],
 :phoneNumbers
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string,
   :canonicalForm string,
   :type string,
   :formattedType string}],
 :etag string,
 :fileAses
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string}],
 :biographies
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string,
   :contentType [CONTENT_TYPE_UNSPECIFIED TEXT_PLAIN TEXT_HTML]}],
 :emailAddresses
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string,
   :type string,
   :formattedType string,
   :displayName string}],
 :miscKeywords
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string,
   :type
   [TYPE_UNSPECIFIED
    OUTLOOK_BILLING_INFORMATION
    OUTLOOK_DIRECTORY_SERVER
    OUTLOOK_KEYWORD
    OUTLOOK_MILEAGE
    OUTLOOK_PRIORITY
    OUTLOOK_SENSITIVITY
    OUTLOOK_SUBJECT
    OUTLOOK_USER
    HOME
    WORK
    OTHER],
   :formattedType string}],
 :organizations
 [{:department string,
   :formattedType string,
   :symbol string,
   :name string,
   :startDate {:year integer, :month integer, :day integer},
   :type string,
   :fullTimeEquivalentMillipercent integer,
   :phoneticName string,
   :costCenter string,
   :title string,
   :endDate {:year integer, :month integer, :day integer},
   :jobDescription string,
   :current boolean,
   :domain string,
   :location string,
   :metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}}}],
 :sipAddresses
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string,
   :type string,
   :formattedType string}],
 :braggingRights
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string}],
 :resourceName string,
 :locations
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string,
   :type string,
   :current boolean,
   :buildingId string,
   :floor string,
   :floorSection string,
   :deskCode string}],
 :externalIds
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string,
   :type string,
   :formattedType string}],
 :relationshipInterests
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string,
   :formattedValue string}],
 :photos
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :url string,
   :default boolean}],
 :skills
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string}],
 :locales
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string}],
 :ageRanges
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :ageRange
   [AGE_RANGE_UNSPECIFIED
    LESS_THAN_EIGHTEEN
    EIGHTEEN_TO_TWENTY
    TWENTY_ONE_OR_OLDER]}],
 :memberships
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :contactGroupMembership
   {:contactGroupId string, :contactGroupResourceName string},
   :domainMembership {:inViewerDomain boolean}}],
 :clientData
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :key string,
   :value string}],
 :interests
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string}],
 :nicknames
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string,
   :type
   [DEFAULT
    MAIDEN_NAME
    INITIALS
    GPLUS
    OTHER_NAME
    ALTERNATE_NAME
    SHORT_NAME]}],
 :residences
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string,
   :current boolean}],
 :imClients
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :username string,
   :type string,
   :formattedType string,
   :protocol string,
   :formattedProtocol string}],
 :genders
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string,
   :formattedValue string,
   :addressMeAs string}],
 :calendarUrls
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :url string,
   :type string,
   :formattedType string}],
 :taglines
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string}],
 :occupations
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :value string}],
 :metadata
 {:sources
  [{:type
    [SOURCE_TYPE_UNSPECIFIED
     ACCOUNT
     PROFILE
     DOMAIN_PROFILE
     CONTACT
     OTHER_CONTACT
     DOMAIN_CONTACT],
    :id string,
    :etag string,
    :profileMetadata
    {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
     :userTypes
     [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
    :updateTime string}],
  :previousResourceNames [string],
  :linkedPeopleResourceNames [string],
  :deleted boolean,
  :objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE]},
 :names
 [{:middleName string,
   :phoneticHonorificPrefix string,
   :phoneticHonorificSuffix string,
   :displayNameLastFirst string,
   :displayName string,
   :phoneticGivenName string,
   :honorificPrefix string,
   :phoneticFullName string,
   :phoneticFamilyName string,
   :familyName string,
   :phoneticMiddleName string,
   :unstructuredName string,
   :givenName string,
   :honorificSuffix string,
   :metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}}}],
 :userDefined
 [{:metadata
   {:primary boolean,
    :sourcePrimary boolean,
    :verified boolean,
    :source
    {:type
     [SOURCE_TYPE_UNSPECIFIED
      ACCOUNT
      PROFILE
      DOMAIN_PROFILE
      CONTACT
      OTHER_CONTACT
      DOMAIN_CONTACT],
     :id string,
     :etag string,
     :profileMetadata
     {:objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE],
      :userTypes
      [[USER_TYPE_UNKNOWN GOOGLE_USER GPLUS_USER GOOGLE_APPS_USER]]},
     :updateTime string}},
   :key string,
   :value string}]}

optional:
updatePersonFields <string> Required. A field mask to restrict which fields on the person are updated. Multiple fields can be specified by separating them with commas. All updated fields will be replaced. Valid values are: * addresses * biographies * birthdays * calendarUrls * clientData * emailAddresses * events * externalIds * genders * imClients * interests * locales * locations * memberships * miscKeywords * names * nicknames * occupations * organizations * phoneNumbers * relations * sipAddresses * urls * userDefined
personFields <string> Optional. A field mask to restrict which fields on each person are returned. Multiple fields can be specified by separating them with commas. Defaults to all fields if not set. Valid values are: * addresses * ageRanges * biographies * birthdays * calendarUrls * clientData * coverPhotos * emailAddresses * events * externalIds * genders * imClients * interests * locales * locations * memberships * metadata * miscKeywords * names * nicknames * occupations * organizations * phoneNumbers * photos * relations * sipAddresses * skills * urls * userDefined
sources <string> Optional. A mask of what source types to return. Defaults to READ_SOURCE_TYPE_CONTACT and READ_SOURCE_TYPE_PROFILE if not set."
  ([resourceName Person]
    (people-updateContact resourceName Person nil))
  ([resourceName Person optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://people.googleapis.com/v1/{+resourceName}:updateContact",
       :uri-template-args {:resourceName resourceName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/contacts"],
       :body Person})))

(defn people-updateContactPhoto
  "Update a contact's photo. Mutate requests for the same user should be sent sequentially to avoid increased latency and failures.
https://developers.google.com/people/api/rest/v1/people/updateContactPhoto

resourceName <string> Required. Person resource name
UpdateContactPhotoRequest:
{:photoBytes string,
 :personFields string,
 :sources
 [[READ_SOURCE_TYPE_UNSPECIFIED
   READ_SOURCE_TYPE_PROFILE
   READ_SOURCE_TYPE_CONTACT
   READ_SOURCE_TYPE_DOMAIN_CONTACT
   READ_SOURCE_TYPE_OTHER_CONTACT]]}"
  [resourceName UpdateContactPhotoRequest]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://people.googleapis.com/v1/{+resourceName}:updateContactPhoto",
     :uri-template-args {:resourceName resourceName},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/contacts"],
     :body UpdateContactPhotoRequest}))

(defn people-deleteContactPhoto
  "Delete a contact's photo. Mutate requests for the same user should be done sequentially to avoid // lock contention.
https://developers.google.com/people/api/rest/v1/people/deleteContactPhoto

resourceName <string> Required. The resource name of the contact whose photo will be deleted.

optional:
personFields <string> Optional. A field mask to restrict which fields on the person are returned. Multiple fields can be specified by separating them with commas. Defaults to empty if not set, which will skip the post mutate get. Valid values are: * addresses * ageRanges * biographies * birthdays * calendarUrls * clientData * coverPhotos * emailAddresses * events * externalIds * genders * imClients * interests * locales * locations * memberships * metadata * miscKeywords * names * nicknames * occupations * organizations * phoneNumbers * photos * relations * sipAddresses * skills * urls * userDefined
sources <string> Optional. A mask of what source types to return. Defaults to READ_SOURCE_TYPE_CONTACT and READ_SOURCE_TYPE_PROFILE if not set."
  ([resourceName] (people-deleteContactPhoto resourceName nil))
  ([resourceName optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://people.googleapis.com/v1/{+resourceName}:deleteContactPhoto",
       :uri-template-args {:resourceName resourceName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/contacts"]})))

(defn people-batchDeleteContacts
  "Delete a batch of contacts. Any non-contact data will not be deleted. Mutate requests for the same user should be sent sequentially to avoid increased latency and failures.
https://developers.google.com/people/api/rest/v1/people/batchDeleteContacts

BatchDeleteContactsRequest:
{:resourceNames [string]}"
  [BatchDeleteContactsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://people.googleapis.com/v1/people:batchDeleteContacts",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/contacts"],
     :body BatchDeleteContactsRequest}))

(defn people-batchUpdateContacts
  "Update a batch of contacts and return a map of resource names to PersonResponses for the updated contacts. Mutate requests for the same user should be sent sequentially to avoid increased latency and failures.
https://developers.google.com/people/api/rest/v1/people/batchUpdateContacts

BatchUpdateContactsRequest:
{:contacts object,
 :updateMask string,
 :readMask string,
 :sources
 [[READ_SOURCE_TYPE_UNSPECIFIED
   READ_SOURCE_TYPE_PROFILE
   READ_SOURCE_TYPE_CONTACT
   READ_SOURCE_TYPE_DOMAIN_CONTACT
   READ_SOURCE_TYPE_OTHER_CONTACT]]}"
  [BatchUpdateContactsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://people.googleapis.com/v1/people:batchUpdateContacts",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/contacts"],
     :body BatchUpdateContactsRequest}))

(defn people-listDirectoryPeople
  "Provides a list of domain profiles and domain contacts in the authenticated user's domain directory. When the `sync_token` is specified, resources deleted since the last sync will be returned as a person with `PersonMetadata.deleted` set to true. When the `page_token` or `sync_token` is specified, all other request parameters must match the first call. Writes may have a propagation delay of several minutes for sync requests. Incremental syncs are not intended for read-after-write use cases. See example usage at [List the directory people that have changed](/people/v1/directory#list_the_directory_people_that_have_changed).
https://developers.google.com/people/api/rest/v1/people/listDirectoryPeople

optional:
readMask <string> Required. A field mask to restrict which fields on each person are returned. Multiple fields can be specified by separating them with commas. Valid values are: * addresses * ageRanges * biographies * birthdays * calendarUrls * clientData * coverPhotos * emailAddresses * events * externalIds * genders * imClients * interests * locales * locations * memberships * metadata * miscKeywords * names * nicknames * occupations * organizations * phoneNumbers * photos * relations * sipAddresses * skills * urls * userDefined
sources <string> Required. Directory sources to return.
mergeSources <string> Optional. Additional data to merge into the directory sources if they are connected through verified join keys such as email addresses or phone numbers.
pageSize <integer> Optional. The number of people to include in the response. Valid values are between 1 and 1000, inclusive. Defaults to 100 if not set or set to 0.
requestSyncToken <boolean> Optional. Whether the response should return `next_sync_token`. It can be used to get incremental changes since the last request by setting it on the request `sync_token`. More details about sync behavior at `people.listDirectoryPeople`.
syncToken <string> Optional. A sync token, received from a previous response `next_sync_token` Provide this to retrieve only the resources changed since the last request. When syncing, all other parameters provided to `people.listDirectoryPeople` must match the first call that provided the sync token. More details about sync behavior at `people.listDirectoryPeople`."
  ([] (people-listDirectoryPeople nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://people.googleapis.com/v1/people:listDirectoryPeople",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/directory.readonly"]})))

(defn people-getBatchGet
  "Provides information about a list of specific people by specifying a list of requested resource names. Use `people/me` to indicate the authenticated user. The request returns a 400 error if 'personFields' is not specified.
https://developers.google.com/people/api/rest/v1/people/getBatchGet

optional:
resourceNames <string> Required. The resource names of the people to provide information about. It's repeatable. The URL query parameter should be resourceNames=<name1>&resourceNames=<name2>&... - To get information about the authenticated user, specify `people/me`. - To get information about a google account, specify `people/{account_id}`. - To get information about a contact, specify the resource name that identifies the contact as returned by `people.connections.list`. There is a maximum of 200 resource names.
requestMask.includeField <string> Required. Comma-separated list of person fields to be included in the response. Each path should start with `person.`: for example, `person.names` or `person.photos`.
personFields <string> Required. A field mask to restrict which fields on each person are returned. Multiple fields can be specified by separating them with commas. Valid values are: * addresses * ageRanges * biographies * birthdays * calendarUrls * clientData * coverPhotos * emailAddresses * events * externalIds * genders * imClients * interests * locales * locations * memberships * metadata * miscKeywords * names * nicknames * occupations * organizations * phoneNumbers * photos * relations * sipAddresses * skills * urls * userDefined
sources <string> Optional. A mask of what source types to return. Defaults to READ_SOURCE_TYPE_CONTACT and READ_SOURCE_TYPE_PROFILE if not set."
  ([] (people-getBatchGet nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://people.googleapis.com/v1/people:batchGet",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/contacts"
        "https://www.googleapis.com/auth/contacts.other.readonly"
        "https://www.googleapis.com/auth/contacts.readonly"
        "https://www.googleapis.com/auth/directory.readonly"
        "https://www.googleapis.com/auth/user.addresses.read"
        "https://www.googleapis.com/auth/user.birthday.read"
        "https://www.googleapis.com/auth/user.emails.read"
        "https://www.googleapis.com/auth/user.gender.read"
        "https://www.googleapis.com/auth/user.organization.read"
        "https://www.googleapis.com/auth/user.phonenumbers.read"
        "https://www.googleapis.com/auth/userinfo.email"
        "https://www.googleapis.com/auth/userinfo.profile"]})))

(defn people-batchCreateContacts
  "Create a batch of new contacts and return the PersonResponses for the newly Mutate requests for the same user should be sent sequentially to avoid increased latency and failures.
https://developers.google.com/people/api/rest/v1/people/batchCreateContacts

BatchCreateContactsRequest:
{:contacts
 [{:contactPerson
   {:addresses
    [{:formattedType string,
      :poBox string,
      :city string,
      :type string,
      :streetAddress string,
      :region string,
      :formattedValue string,
      :postalCode string,
      :extendedAddress string,
      :country string,
      :metadata
      {:primary boolean,
       :sourcePrimary boolean,
       :verified boolean,
       :source Source},
      :countryCode string}],
    :urls
    [{:metadata
      {:primary boolean,
       :sourcePrimary boolean,
       :verified boolean,
       :source Source},
      :value string,
      :type string,
      :formattedType string}],
    :relationshipStatuses
    [{:metadata
      {:primary boolean,
       :sourcePrimary boolean,
       :verified boolean,
       :source Source},
      :value string,
      :formattedValue string}],
    :coverPhotos
    [{:metadata
      {:primary boolean,
       :sourcePrimary boolean,
       :verified boolean,
       :source Source},
      :url string,
      :default boolean}],
    :birthdays
    [{:metadata
      {:primary boolean,
       :sourcePrimary boolean,
       :verified boolean,
       :source Source},
      :date {:year integer, :month integer, :day integer},
      :text string}],
    :relations
    [{:metadata
      {:primary boolean,
       :sourcePrimary boolean,
       :verified boolean,
       :source Source},
      :person string,
      :type string,
      :formattedType string}],
    :ageRange
    [AGE_RANGE_UNSPECIFIED
     LESS_THAN_EIGHTEEN
     EIGHTEEN_TO_TWENTY
     TWENTY_ONE_OR_OLDER],
    :events
    [{:metadata
      {:primary boolean,
       :sourcePrimary boolean,
       :verified boolean,
       :source Source},
      :date {:year integer, :month integer, :day integer},
      :type string,
      :formattedType string}],
    :phoneNumbers
    [{:metadata
      {:primary boolean,
       :sourcePrimary boolean,
       :verified boolean,
       :source Source},
      :value string,
      :canonicalForm string,
      :type string,
      :formattedType string}],
    :etag string,
    :fileAses
    [{:metadata
      {:primary boolean,
       :sourcePrimary boolean,
       :verified boolean,
       :source Source},
      :value string}],
    :biographies
    [{:metadata
      {:primary boolean,
       :sourcePrimary boolean,
       :verified boolean,
       :source Source},
      :value string,
      :contentType [CONTENT_TYPE_UNSPECIFIED TEXT_PLAIN TEXT_HTML]}],
    :emailAddresses
    [{:metadata
      {:primary boolean,
       :sourcePrimary boolean,
       :verified boolean,
       :source Source},
      :value string,
      :type string,
      :formattedType string,
      :displayName string}],
    :miscKeywords
    [{:metadata
      {:primary boolean,
       :sourcePrimary boolean,
       :verified boolean,
       :source Source},
      :value string,
      :type
      [TYPE_UNSPECIFIED
       OUTLOOK_BILLING_INFORMATION
       OUTLOOK_DIRECTORY_SERVER
       OUTLOOK_KEYWORD
       OUTLOOK_MILEAGE
       OUTLOOK_PRIORITY
       OUTLOOK_SENSITIVITY
       OUTLOOK_SUBJECT
       OUTLOOK_USER
       HOME
       WORK
       OTHER],
      :formattedType string}],
    :organizations
    [{:department string,
      :formattedType string,
      :symbol string,
      :name string,
      :startDate {:year integer, :month integer, :day integer},
      :type string,
      :fullTimeEquivalentMillipercent integer,
      :phoneticName string,
      :costCenter string,
      :title string,
      :endDate {:year integer, :month integer, :day integer},
      :jobDescription string,
      :current boolean,
      :domain string,
      :location string,
      :metadata
      {:primary boolean,
       :sourcePrimary boolean,
       :verified boolean,
       :source Source}}],
    :sipAddresses
    [{:metadata
      {:primary boolean,
       :sourcePrimary boolean,
       :verified boolean,
       :source Source},
      :value string,
      :type string,
      :formattedType string}],
    :braggingRights
    [{:metadata
      {:primary boolean,
       :sourcePrimary boolean,
       :verified boolean,
       :source Source},
      :value string}],
    :resourceName string,
    :locations
    [{:metadata
      {:primary boolean,
       :sourcePrimary boolean,
       :verified boolean,
       :source Source},
      :value string,
      :type string,
      :current boolean,
      :buildingId string,
      :floor string,
      :floorSection string,
      :deskCode string}],
    :externalIds
    [{:metadata
      {:primary boolean,
       :sourcePrimary boolean,
       :verified boolean,
       :source Source},
      :value string,
      :type string,
      :formattedType string}],
    :relationshipInterests
    [{:metadata
      {:primary boolean,
       :sourcePrimary boolean,
       :verified boolean,
       :source Source},
      :value string,
      :formattedValue string}],
    :photos
    [{:metadata
      {:primary boolean,
       :sourcePrimary boolean,
       :verified boolean,
       :source Source},
      :url string,
      :default boolean}],
    :skills
    [{:metadata
      {:primary boolean,
       :sourcePrimary boolean,
       :verified boolean,
       :source Source},
      :value string}],
    :locales
    [{:metadata
      {:primary boolean,
       :sourcePrimary boolean,
       :verified boolean,
       :source Source},
      :value string}],
    :ageRanges
    [{:metadata
      {:primary boolean,
       :sourcePrimary boolean,
       :verified boolean,
       :source Source},
      :ageRange
      [AGE_RANGE_UNSPECIFIED
       LESS_THAN_EIGHTEEN
       EIGHTEEN_TO_TWENTY
       TWENTY_ONE_OR_OLDER]}],
    :memberships
    [{:metadata
      {:primary boolean,
       :sourcePrimary boolean,
       :verified boolean,
       :source Source},
      :contactGroupMembership
      {:contactGroupId string, :contactGroupResourceName string},
      :domainMembership {:inViewerDomain boolean}}],
    :clientData
    [{:metadata
      {:primary boolean,
       :sourcePrimary boolean,
       :verified boolean,
       :source Source},
      :key string,
      :value string}],
    :interests
    [{:metadata
      {:primary boolean,
       :sourcePrimary boolean,
       :verified boolean,
       :source Source},
      :value string}],
    :nicknames
    [{:metadata
      {:primary boolean,
       :sourcePrimary boolean,
       :verified boolean,
       :source Source},
      :value string,
      :type
      [DEFAULT
       MAIDEN_NAME
       INITIALS
       GPLUS
       OTHER_NAME
       ALTERNATE_NAME
       SHORT_NAME]}],
    :residences
    [{:metadata
      {:primary boolean,
       :sourcePrimary boolean,
       :verified boolean,
       :source Source},
      :value string,
      :current boolean}],
    :imClients
    [{:metadata
      {:primary boolean,
       :sourcePrimary boolean,
       :verified boolean,
       :source Source},
      :username string,
      :type string,
      :formattedType string,
      :protocol string,
      :formattedProtocol string}],
    :genders
    [{:metadata
      {:primary boolean,
       :sourcePrimary boolean,
       :verified boolean,
       :source Source},
      :value string,
      :formattedValue string,
      :addressMeAs string}],
    :calendarUrls
    [{:metadata
      {:primary boolean,
       :sourcePrimary boolean,
       :verified boolean,
       :source Source},
      :url string,
      :type string,
      :formattedType string}],
    :taglines
    [{:metadata
      {:primary boolean,
       :sourcePrimary boolean,
       :verified boolean,
       :source Source},
      :value string}],
    :occupations
    [{:metadata
      {:primary boolean,
       :sourcePrimary boolean,
       :verified boolean,
       :source Source},
      :value string}],
    :metadata
    {:sources
     [{:type
       [SOURCE_TYPE_UNSPECIFIED
        ACCOUNT
        PROFILE
        DOMAIN_PROFILE
        CONTACT
        OTHER_CONTACT
        DOMAIN_CONTACT],
       :id string,
       :etag string,
       :profileMetadata ProfileMetadata,
       :updateTime string}],
     :previousResourceNames [string],
     :linkedPeopleResourceNames [string],
     :deleted boolean,
     :objectType [OBJECT_TYPE_UNSPECIFIED PERSON PAGE]},
    :names
    [{:middleName string,
      :phoneticHonorificPrefix string,
      :phoneticHonorificSuffix string,
      :displayNameLastFirst string,
      :displayName string,
      :phoneticGivenName string,
      :honorificPrefix string,
      :phoneticFullName string,
      :phoneticFamilyName string,
      :familyName string,
      :phoneticMiddleName string,
      :unstructuredName string,
      :givenName string,
      :honorificSuffix string,
      :metadata
      {:primary boolean,
       :sourcePrimary boolean,
       :verified boolean,
       :source Source}}],
    :userDefined
    [{:metadata
      {:primary boolean,
       :sourcePrimary boolean,
       :verified boolean,
       :source Source},
      :key string,
      :value string}]}}],
 :readMask string,
 :sources
 [[READ_SOURCE_TYPE_UNSPECIFIED
   READ_SOURCE_TYPE_PROFILE
   READ_SOURCE_TYPE_CONTACT
   READ_SOURCE_TYPE_DOMAIN_CONTACT
   READ_SOURCE_TYPE_OTHER_CONTACT]]}"
  [BatchCreateContactsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://people.googleapis.com/v1/people:batchCreateContacts",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/contacts"],
     :body BatchCreateContactsRequest}))

(defn people-connections-list
  "Provides a list of the authenticated user's contacts. Sync tokens expire 7 days after the full sync. A request with an expired sync token will get an error with an [google.rpc.ErrorInfo](https://cloud.google.com/apis/design/errors#error_info) with reason \"EXPIRED_SYNC_TOKEN\". In the case of such an error clients should make a full sync request without a `sync_token`. The first page of a full sync request has an additional quota. If the quota is exceeded, a 429 error will be returned. This quota is fixed and can not be increased. When the `sync_token` is specified, resources deleted since the last sync will be returned as a person with `PersonMetadata.deleted` set to true. When the `page_token` or `sync_token` is specified, all other request parameters must match the first call. Writes may have a propagation delay of several minutes for sync requests. Incremental syncs are not intended for read-after-write use cases. See example usage at [List the user's contacts that have changed](/people/v1/contacts#list_the_users_contacts_that_have_changed).
https://developers.google.com/people/api/rest/v1/people.connections/list

resourceName <string> Required. The resource name to return connections for. Only `people/me` is valid.

optional:
requestSyncToken <boolean> Optional. Whether the response should return `next_sync_token` on the last page of results. It can be used to get incremental changes since the last request by setting it on the request `sync_token`. More details about sync behavior at `people.connections.list`.
requestMask.includeField <string> Required. Comma-separated list of person fields to be included in the response. Each path should start with `person.`: for example, `person.names` or `person.photos`.
sources <string> Optional. A mask of what source types to return. Defaults to READ_SOURCE_TYPE_CONTACT and READ_SOURCE_TYPE_PROFILE if not set.
personFields <string> Required. A field mask to restrict which fields on each person are returned. Multiple fields can be specified by separating them with commas. Valid values are: * addresses * ageRanges * biographies * birthdays * calendarUrls * clientData * coverPhotos * emailAddresses * events * externalIds * genders * imClients * interests * locales * locations * memberships * metadata * miscKeywords * names * nicknames * occupations * organizations * phoneNumbers * photos * relations * sipAddresses * skills * urls * userDefined
syncToken <string> Optional. A sync token, received from a previous response `next_sync_token` Provide this to retrieve only the resources changed since the last request. When syncing, all other parameters provided to `people.connections.list` must match the first call that provided the sync token. More details about sync behavior at `people.connections.list`.
pageSize <integer> Optional. The number of connections to include in the response. Valid values are between 1 and 1000, inclusive. Defaults to 100 if not set or set to 0.
sortOrder <string> Optional. The order in which the connections should be sorted. Defaults to `LAST_MODIFIED_ASCENDING`."
  ([resourceName] (people-connections-list resourceName nil))
  ([resourceName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://people.googleapis.com/v1/{+resourceName}/connections",
       :uri-template-args {:resourceName resourceName},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/contacts"
        "https://www.googleapis.com/auth/contacts.readonly"]})))

(defn otherContacts-list
  "List all \"Other contacts\", that is contacts that are not in a contact group. \"Other contacts\" are typically auto created contacts from interactions. Sync tokens expire 7 days after the full sync. A request with an expired sync token will get an error with an [google.rpc.ErrorInfo](https://cloud.google.com/apis/design/errors#error_info) with reason \"EXPIRED_SYNC_TOKEN\". In the case of such an error clients should make a full sync request without a `sync_token`. The first page of a full sync request has an additional quota. If the quota is exceeded, a 429 error will be returned. This quota is fixed and can not be increased. When the `sync_token` is specified, resources deleted since the last sync will be returned as a person with `PersonMetadata.deleted` set to true. When the `page_token` or `sync_token` is specified, all other request parameters must match the first call. Writes may have a propagation delay of several minutes for sync requests. Incremental syncs are not intended for read-after-write use cases. See example usage at [List the user's other contacts that have changed](/people/v1/other-contacts#list_the_users_other_contacts_that_have_changed).
https://developers.google.com/people/api/rest/v1/otherContacts/list

optional:
pageSize <integer> Optional. The number of \"Other contacts\" to include in the response. Valid values are between 1 and 1000, inclusive. Defaults to 100 if not set or set to 0.
requestSyncToken <boolean> Optional. Whether the response should return `next_sync_token` on the last page of results. It can be used to get incremental changes since the last request by setting it on the request `sync_token`. More details about sync behavior at `otherContacts.list`.
syncToken <string> Optional. A sync token, received from a previous response `next_sync_token` Provide this to retrieve only the resources changed since the last request. When syncing, all other parameters provided to `otherContacts.list` must match the first call that provided the sync token. More details about sync behavior at `otherContacts.list`.
readMask <string> Required. A field mask to restrict which fields on each person are returned. Multiple fields can be specified by separating them with commas. What values are valid depend on what ReadSourceType is used. If READ_SOURCE_TYPE_CONTACT is used, valid values are: * emailAddresses * metadata * names * phoneNumbers * photos If READ_SOURCE_TYPE_PROFILE is used, valid values are: * addresses * ageRanges * biographies * birthdays * calendarUrls * clientData * coverPhotos * emailAddresses * events * externalIds * genders * imClients * interests * locales * locations * memberships * metadata * miscKeywords * names * nicknames * occupations * organizations * phoneNumbers * photos * relations * sipAddresses * skills * urls * userDefined
sources <string> Optional. A mask of what source types to return. Defaults to READ_SOURCE_TYPE_CONTACT if not set. Possible values for this field are: * READ_SOURCE_TYPE_CONTACT * READ_SOURCE_TYPE_CONTACT,READ_SOURCE_TYPE_PROFILE Specifying READ_SOURCE_TYPE_PROFILE without specifying READ_SOURCE_TYPE_CONTACT is not permitted."
  ([] (otherContacts-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://people.googleapis.com/v1/otherContacts",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/contacts.other.readonly"]})))

(defn otherContacts-copyOtherContactToMyContactsGroup
  "Copies an \"Other contact\" to a new contact in the user's \"myContacts\" group Mutate requests for the same user should be sent sequentially to avoid increased latency and failures.
https://developers.google.com/people/api/rest/v1/otherContacts/copyOtherContactToMyContactsGroup

resourceName <string> Required. The resource name of the \"Other contact\" to copy.
CopyOtherContactToMyContactsGroupRequest:
{:copyMask string,
 :readMask string,
 :sources
 [[READ_SOURCE_TYPE_UNSPECIFIED
   READ_SOURCE_TYPE_PROFILE
   READ_SOURCE_TYPE_CONTACT
   READ_SOURCE_TYPE_DOMAIN_CONTACT
   READ_SOURCE_TYPE_OTHER_CONTACT]]}"
  [resourceName CopyOtherContactToMyContactsGroupRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://people.googleapis.com/v1/{+resourceName}:copyOtherContactToMyContactsGroup",
     :uri-template-args {:resourceName resourceName},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/contacts"
      "https://www.googleapis.com/auth/contacts.other.readonly"],
     :body CopyOtherContactToMyContactsGroupRequest}))

(defn otherContacts-search
  "Provides a list of contacts in the authenticated user's other contacts that matches the search query. The query matches on a contact's `names`, `emailAddresses`, and `phoneNumbers` fields that are from the OTHER_CONTACT source. **IMPORTANT**: Before searching, clients should send a warmup request with an empty query to update the cache. See https://developers.google.com/people/v1/other-contacts#search_the_users_other_contacts
https://developers.google.com/people/api/rest/v1/otherContacts/search

optional:
query <string> Required. The plain-text query for the request. The query is used to match prefix phrases of the fields on a person. For example, a person with name \"foo name\" matches queries such as \"f\", \"fo\", \"foo\", \"foo n\", \"nam\", etc., but not \"oo n\".
pageSize <integer> Optional. The number of results to return. Defaults to 10 if field is not set, or set to 0. Values greater than 30 will be capped to 30.
readMask <string> Required. A field mask to restrict which fields on each person are returned. Multiple fields can be specified by separating them with commas. Valid values are: * emailAddresses * metadata * names * phoneNumbers"
  ([] (otherContacts-search nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://people.googleapis.com/v1/otherContacts:search",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/contacts.other.readonly"]})))

(defn contactGroups-batchGet
  "Get a list of contact groups owned by the authenticated user by specifying a list of contact group resource names.
https://developers.google.com/people/api/rest/v1/contactGroups/batchGet

optional:
resourceNames <string> Required. The resource names of the contact groups to get. There is a maximum of 200 resource names.
maxMembers <integer> Optional. Specifies the maximum number of members to return for each group. Defaults to 0 if not set, which will return zero members.
groupFields <string> Optional. A field mask to restrict which fields on the group are returned. Defaults to `metadata`, `groupType`, `memberCount`, and `name` if not set or set to empty. Valid fields are: * clientData * groupType * memberCount * metadata * name"
  ([] (contactGroups-batchGet nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://people.googleapis.com/v1/contactGroups:batchGet",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/contacts"
        "https://www.googleapis.com/auth/contacts.readonly"]})))

(defn contactGroups-create
  "Create a new contact group owned by the authenticated user. Created contact group names must be unique to the users contact groups. Attempting to create a group with a duplicate name will return a HTTP 409 error. Mutate requests for the same user should be sent sequentially to avoid increased latency and failures.
https://developers.google.com/people/api/rest/v1/contactGroups/create

CreateContactGroupRequest:
{:contactGroup
 {:memberCount integer,
  :groupType
  [GROUP_TYPE_UNSPECIFIED USER_CONTACT_GROUP SYSTEM_CONTACT_GROUP],
  :name string,
  :etag string,
  :memberResourceNames [string],
  :resourceName string,
  :clientData [{:key string, :value string}],
  :metadata {:updateTime string, :deleted boolean},
  :formattedName string},
 :readGroupFields string}"
  [CreateContactGroupRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://people.googleapis.com/v1/contactGroups",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/contacts"],
     :body CreateContactGroupRequest}))

(defn contactGroups-delete
  "Delete an existing contact group owned by the authenticated user by specifying a contact group resource name. Mutate requests for the same user should be sent sequentially to avoid increased latency and failures.
https://developers.google.com/people/api/rest/v1/contactGroups/delete

resourceName <string> Required. The resource name of the contact group to delete.

optional:
deleteContacts <boolean> Optional. Set to true to also delete the contacts in the specified group."
  ([resourceName] (contactGroups-delete resourceName nil))
  ([resourceName optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://people.googleapis.com/v1/{+resourceName}",
       :uri-template-args {:resourceName resourceName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/contacts"]})))

(defn contactGroups-get
  "Get a specific contact group owned by the authenticated user by specifying a contact group resource name.
https://developers.google.com/people/api/rest/v1/contactGroups/get

resourceName <string> Required. The resource name of the contact group to get.

optional:
maxMembers <integer> Optional. Specifies the maximum number of members to return. Defaults to 0 if not set, which will return zero members.
groupFields <string> Optional. A field mask to restrict which fields on the group are returned. Defaults to `metadata`, `groupType`, `memberCount`, and `name` if not set or set to empty. Valid fields are: * clientData * groupType * memberCount * metadata * name"
  ([resourceName] (contactGroups-get resourceName nil))
  ([resourceName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://people.googleapis.com/v1/{+resourceName}",
       :uri-template-args {:resourceName resourceName},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/contacts"
        "https://www.googleapis.com/auth/contacts.readonly"]})))

(defn contactGroups-list
  "List all contact groups owned by the authenticated user. Members of the contact groups are not populated.
https://developers.google.com/people/api/rest/v1/contactGroups/list

optional:
pageSize <integer> Optional. The maximum number of resources to return. Valid values are between 1 and 1000, inclusive. Defaults to 30 if not set or set to 0.
syncToken <string> Optional. A sync token, returned by a previous call to `contactgroups.list`. Only resources changed since the sync token was created will be returned.
groupFields <string> Optional. A field mask to restrict which fields on the group are returned. Defaults to `metadata`, `groupType`, `memberCount`, and `name` if not set or set to empty. Valid fields are: * clientData * groupType * memberCount * metadata * name"
  ([] (contactGroups-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://people.googleapis.com/v1/contactGroups",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/contacts"
        "https://www.googleapis.com/auth/contacts.readonly"]})))

(defn contactGroups-update
  "Update the name of an existing contact group owned by the authenticated user. Updated contact group names must be unique to the users contact groups. Attempting to create a group with a duplicate name will return a HTTP 409 error. Mutate requests for the same user should be sent sequentially to avoid increased latency and failures.
https://developers.google.com/people/api/rest/v1/contactGroups/update

resourceName <string> The resource name for the contact group, assigned by the server. An ASCII string, in the form of `contactGroups/{contact_group_id}`.
UpdateContactGroupRequest:
{:contactGroup
 {:memberCount integer,
  :groupType
  [GROUP_TYPE_UNSPECIFIED USER_CONTACT_GROUP SYSTEM_CONTACT_GROUP],
  :name string,
  :etag string,
  :memberResourceNames [string],
  :resourceName string,
  :clientData [{:key string, :value string}],
  :metadata {:updateTime string, :deleted boolean},
  :formattedName string},
 :updateGroupFields string,
 :readGroupFields string}"
  [resourceName UpdateContactGroupRequest]
  (client/api-request
    {:method "PUT",
     :uri-template "https://people.googleapis.com/v1/{+resourceName}",
     :uri-template-args {:resourceName resourceName},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/contacts"],
     :body UpdateContactGroupRequest}))

(defn contactGroups-members-modify
  "Modify the members of a contact group owned by the authenticated user. The only system contact groups that can have members added are `contactGroups/myContacts` and `contactGroups/starred`. Other system contact groups are deprecated and can only have contacts removed.
https://developers.google.com/people/api/rest/v1/contactGroups.members/modify

resourceName <string> Required. The resource name of the contact group to modify.
ModifyContactGroupMembersRequest:
{:resourceNamesToAdd [string], :resourceNamesToRemove [string]}"
  [resourceName ModifyContactGroupMembersRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://people.googleapis.com/v1/{+resourceName}/members:modify",
     :uri-template-args {:resourceName resourceName},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/contacts"],
     :body ModifyContactGroupMembersRequest}))

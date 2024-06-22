(ns happygapi2.dfareporting
  "Campaign Manager 360 API
Build applications to efficiently manage large or complex trafficking, reporting, and attribution workflows for Campaign Manager 360.
See: https://developers.google.com/doubleclick-advertisers/"
  (:require [happy.oauth2.client :as client]))

(defn advertiserInvoices-list
  "Retrieves a list of invoices for a particular issue month. The api only works if the billing profile invoice level is set to either advertiser or campaign non-consolidated invoice level.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
advertiserId <string> Advertiser ID of this invoice.

optional:
maxResults <integer> Maximum number of results to return.
issueMonth <string> Month for which invoices are needed in the format YYYYMM. Required field"
  ([profileId advertiserId]
    (advertiserInvoices-list profileId advertiserId nil))
  ([profileId advertiserId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/advertisers/{+advertiserId}/invoices",
       :uri-template-args
       {:profileId profileId, :advertiserId advertiserId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn billingProfiles-get
  "Gets one billing profile by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Billing Profile ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/billingProfiles/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn billingProfiles-list
  "Retrieves a list of billing profiles, possibly filtered. This method supports paging.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.

optional:
name <string> Allows searching for billing profiles by name. Wildcards (*) are allowed. For example, \"profile*2020\" will return objects with names like \"profile June 2020\", \"profile April 2020\", or simply \"profile 2020\". Most of the searches also add wildcards implicitly at the start and the end of the search string. For example, a search string of \"profile\" will match objects with name \"my profile\", \"profile 2021\", or simply \"profile\".
ids <string> Select only billing profile with these IDs.
sortField <string> Field by which to sort the list.
status <string> Select only billing profile with the specified status.
sortOrder <string> Order of sorted results.
onlySuggestion <boolean> Select only billing profile which is suggested for the currency_code & subaccount_id using the Billing Suggestion API.
subaccountIds <string> Select only billing profile with the specified subaccount.When only_suggestion is true, only a single subaccount_id is supported.
maxResults <integer> Maximum number of results to return.
currency_code <string> Select only billing profile with currency."
  ([profileId] (billingProfiles-list profileId nil))
  ([profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/billingProfiles",
       :uri-template-args {:profileId profileId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn billingProfiles-update
  "Updates an existing billing profile.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
BillingProfile:
{:paymentsAccountId string,
 :secondaryPaymentsCustomerId string,
 :isDefault boolean,
 :consolidatedInvoice boolean,
 :purchaseOrder string,
 :name string,
 :paymentsCustomerId string,
 :invoiceLevel [ACCOUNT_LEVEL ADVERTISER_LEVEL CAMPAIGN_LEVEL],
 :status [UNDER_REVIEW ACTIVE ARCHIVED],
 :id string,
 :kind string,
 :currencyCode string,
 :countryCode string}"
  [profileId BillingProfile]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/billingProfiles",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body BillingProfile}))

(defn orders-get
  "Gets one order by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
projectId <string> Project ID for orders.
id <string> Order ID."
  [profileId projectId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/projects/{projectId}/orders/{+id}",
     :uri-template-args
     {:profileId profileId, :projectId projectId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn orders-list
  "Retrieves a list of orders, possibly filtered. This method supports paging.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
projectId <string> Project ID for orders.

optional:
siteId <string> Select only orders that are associated with these site IDs.
ids <string> Select only orders with these IDs.
searchString <string> Allows searching for orders by name or ID. Wildcards (*) are allowed. For example, \"order*2015\" will return orders with names like \"order June 2015\", \"order April 2015\", or simply \"order 2015\". Most of the searches also add wildcards implicitly at the start and the end of the search string. For example, a search string of \"order\" will match orders with name \"my order\", \"order 2015\", or simply \"order\".
sortField <string> Field by which to sort the list.
sortOrder <string> Order of sorted results.
maxResults <integer> Maximum number of results to return."
  ([profileId projectId] (orders-list profileId projectId nil))
  ([profileId projectId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/projects/{projectId}/orders",
       :uri-template-args {:profileId profileId, :projectId projectId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn projects-get
  "Gets one project by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Project ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/projects/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn projects-list
  "Retrieves a list of projects, possibly filtered. This method supports paging .
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.

optional:
ids <string> Select only projects with these IDs.
searchString <string> Allows searching for projects by name or ID. Wildcards (*) are allowed. For example, \"project*2015\" will return projects with names like \"project June 2015\", \"project April 2015\", or simply \"project 2015\". Most of the searches also add wildcards implicitly at the start and the end of the search string. For example, a search string of \"project\" will match projects with name \"my project\", \"project 2015\", or simply \"project\".
advertiserIds <string> Select only projects with these advertiser IDs.
maxResults <integer> Maximum number of results to return.
sortField <string> Field by which to sort the list.
sortOrder <string> Order of sorted results."
  ([profileId] (projects-list profileId nil))
  ([profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/projects",
       :uri-template-args {:profileId profileId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn creativeGroups-get
  "Gets one creative group by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Creative group ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/creativeGroups/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn creativeGroups-insert
  "Inserts a new creative group.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
CreativeGroup:
{:id string,
 :accountId string,
 :subaccountId string,
 :advertiserId string,
 :name string,
 :groupNumber integer,
 :advertiserIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :kind string}"
  [profileId CreativeGroup]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/creativeGroups",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body CreativeGroup}))

(defn creativeGroups-list
  "Retrieves a list of creative groups, possibly filtered. This method supports paging.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.

optional:
groupNumber <integer> Select only creative groups that belong to this subgroup.
ids <string> Select only creative groups with these IDs.
searchString <string> Allows searching for creative groups by name or ID. Wildcards (*) are allowed. For example, \"creativegroup*2015\" will return creative groups with names like \"creativegroup June 2015\", \"creativegroup April 2015\", or simply \"creativegroup 2015\". Most of the searches also add wild-cards implicitly at the start and the end of the search string. For example, a search string of \"creativegroup\" will match creative groups with the name \"my creativegroup\", \"creativegroup 2015\", or simply \"creativegroup\".
sortField <string> Field by which to sort the list.
advertiserIds <string> Select only creative groups that belong to these advertisers.
sortOrder <string> Order of sorted results.
maxResults <integer> Maximum number of results to return."
  ([profileId] (creativeGroups-list profileId nil))
  ([profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/creativeGroups",
       :uri-template-args {:profileId profileId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn creativeGroups-update
  "Updates an existing creative group.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
CreativeGroup:
{:id string,
 :accountId string,
 :subaccountId string,
 :advertiserId string,
 :name string,
 :groupNumber integer,
 :advertiserIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :kind string}"
  [profileId CreativeGroup]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/creativeGroups",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body CreativeGroup}))

(defn creativeGroups-patch
  "Updates an existing creative group. This method supports patch semantics.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Required. Creative Group ID.
CreativeGroup:
{:id string,
 :accountId string,
 :subaccountId string,
 :advertiserId string,
 :name string,
 :groupNumber integer,
 :advertiserIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :kind string}"
  [profileId id CreativeGroup]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/creativeGroups",
     :uri-template-args {:profileId profileId},
     :query-params {:id id},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body CreativeGroup}))

(defn remarketingLists-patch
  "Updates an existing remarketing list. This method supports patch semantics.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Required. RemarketingList ID.
RemarketingList:
{:description string,
 :listSource
 [REMARKETING_LIST_SOURCE_OTHER
  REMARKETING_LIST_SOURCE_ADX
  REMARKETING_LIST_SOURCE_DFP
  REMARKETING_LIST_SOURCE_XFP
  REMARKETING_LIST_SOURCE_DFA
  REMARKETING_LIST_SOURCE_GA
  REMARKETING_LIST_SOURCE_YOUTUBE
  REMARKETING_LIST_SOURCE_DBM
  REMARKETING_LIST_SOURCE_GPLUS
  REMARKETING_LIST_SOURCE_DMP
  REMARKETING_LIST_SOURCE_PLAY_STORE],
 :listPopulationRule
 {:floodlightActivityId string,
  :floodlightActivityName string,
  :listPopulationClauses
  [{:terms
    [{:variableName string,
      :variableFriendlyName string,
      :operator
      [NUM_EQUALS
       NUM_LESS_THAN
       NUM_LESS_THAN_EQUAL
       NUM_GREATER_THAN
       NUM_GREATER_THAN_EQUAL
       STRING_EQUALS
       STRING_CONTAINS],
      :value string,
      :negation boolean,
      :remarketingListId string,
      :contains boolean,
      :type
      [CUSTOM_VARIABLE_TERM LIST_MEMBERSHIP_TERM REFERRER_TERM]}]}]},
 :advertiserIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :name string,
 :lifeSpan string,
 :advertiserId string,
 :active boolean,
 :id string,
 :kind string,
 :listSize string,
 :subaccountId string,
 :accountId string}"
  [profileId id RemarketingList]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/remarketingLists",
     :uri-template-args {:profileId profileId},
     :query-params {:id id},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body RemarketingList}))

(defn remarketingLists-get
  "Gets one remarketing list by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Remarketing list ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/remarketingLists/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn remarketingLists-insert
  "Inserts a new remarketing list.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
RemarketingList:
{:description string,
 :listSource
 [REMARKETING_LIST_SOURCE_OTHER
  REMARKETING_LIST_SOURCE_ADX
  REMARKETING_LIST_SOURCE_DFP
  REMARKETING_LIST_SOURCE_XFP
  REMARKETING_LIST_SOURCE_DFA
  REMARKETING_LIST_SOURCE_GA
  REMARKETING_LIST_SOURCE_YOUTUBE
  REMARKETING_LIST_SOURCE_DBM
  REMARKETING_LIST_SOURCE_GPLUS
  REMARKETING_LIST_SOURCE_DMP
  REMARKETING_LIST_SOURCE_PLAY_STORE],
 :listPopulationRule
 {:floodlightActivityId string,
  :floodlightActivityName string,
  :listPopulationClauses
  [{:terms
    [{:variableName string,
      :variableFriendlyName string,
      :operator
      [NUM_EQUALS
       NUM_LESS_THAN
       NUM_LESS_THAN_EQUAL
       NUM_GREATER_THAN
       NUM_GREATER_THAN_EQUAL
       STRING_EQUALS
       STRING_CONTAINS],
      :value string,
      :negation boolean,
      :remarketingListId string,
      :contains boolean,
      :type
      [CUSTOM_VARIABLE_TERM LIST_MEMBERSHIP_TERM REFERRER_TERM]}]}]},
 :advertiserIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :name string,
 :lifeSpan string,
 :advertiserId string,
 :active boolean,
 :id string,
 :kind string,
 :listSize string,
 :subaccountId string,
 :accountId string}"
  [profileId RemarketingList]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/remarketingLists",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body RemarketingList}))

(defn remarketingLists-list
  "Retrieves a list of remarketing lists, possibly filtered. This method supports paging.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
advertiserId <string> Required. Select only remarketing lists owned by this advertiser.

optional:
name <string> Allows searching for objects by name or ID. Wildcards (*) are allowed. For example, \"remarketing list*2015\" will return objects with names like \"remarketing list June 2015\", \"remarketing list April 2015\", or simply \"remarketing list 2015\". Most of the searches also add wildcards implicitly at the start and the end of the search string. For example, a search string of \"remarketing list\" will match objects with name \"my remarketing list\", \"remarketing list 2015\", or simply \"remarketing list\".
sortField <string> Field by which to sort the list.
active <boolean> Select only active or only inactive remarketing lists.
sortOrder <string> Order of sorted results.
maxResults <integer> Maximum number of results to return.
floodlightActivityId <string> Select only remarketing lists that have this floodlight activity ID."
  ([profileId advertiserId]
    (remarketingLists-list profileId advertiserId nil))
  ([profileId advertiserId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/remarketingLists",
       :uri-template-args {:profileId profileId},
       :query-params (merge {:advertiserId advertiserId} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn remarketingLists-update
  "Updates an existing remarketing list.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
RemarketingList:
{:description string,
 :listSource
 [REMARKETING_LIST_SOURCE_OTHER
  REMARKETING_LIST_SOURCE_ADX
  REMARKETING_LIST_SOURCE_DFP
  REMARKETING_LIST_SOURCE_XFP
  REMARKETING_LIST_SOURCE_DFA
  REMARKETING_LIST_SOURCE_GA
  REMARKETING_LIST_SOURCE_YOUTUBE
  REMARKETING_LIST_SOURCE_DBM
  REMARKETING_LIST_SOURCE_GPLUS
  REMARKETING_LIST_SOURCE_DMP
  REMARKETING_LIST_SOURCE_PLAY_STORE],
 :listPopulationRule
 {:floodlightActivityId string,
  :floodlightActivityName string,
  :listPopulationClauses
  [{:terms
    [{:variableName string,
      :variableFriendlyName string,
      :operator
      [NUM_EQUALS
       NUM_LESS_THAN
       NUM_LESS_THAN_EQUAL
       NUM_GREATER_THAN
       NUM_GREATER_THAN_EQUAL
       STRING_EQUALS
       STRING_CONTAINS],
      :value string,
      :negation boolean,
      :remarketingListId string,
      :contains boolean,
      :type
      [CUSTOM_VARIABLE_TERM LIST_MEMBERSHIP_TERM REFERRER_TERM]}]}]},
 :advertiserIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :name string,
 :lifeSpan string,
 :advertiserId string,
 :active boolean,
 :id string,
 :kind string,
 :listSize string,
 :subaccountId string,
 :accountId string}"
  [profileId RemarketingList]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/remarketingLists",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body RemarketingList}))

(defn mobileApps-get
  "Gets one mobile app by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Mobile app ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/mobileApps/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn mobileApps-list
  "Retrieves list of available mobile apps.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.

optional:
ids <string> Select only apps with these IDs.
searchString <string> Allows searching for objects by name or ID. Wildcards (*) are allowed. For example, \"app*2015\" will return objects with names like \"app Jan 2018\", \"app Jan 2018\", or simply \"app 2018\". Most of the searches also add wildcards implicitly at the start and the end of the search string. For example, a search string of \"app\" will match objects with name \"my app\", \"app 2018\", or simply \"app\".
directories <string> Select only apps from these directories.
maxResults <integer> Maximum number of results to return."
  ([profileId] (mobileApps-list profileId nil))
  ([profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/mobileApps",
       :uri-template-args {:profileId profileId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn sizes-get
  "Gets one size by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Size ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/sizes/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn sizes-insert
  "Inserts a new size.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
Size:
{:id string,
 :width integer,
 :height integer,
 :iab boolean,
 :kind string}"
  [profileId Size]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/sizes",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body Size}))

(defn sizes-list
  "Retrieves a list of sizes, possibly filtered. Retrieved sizes are globally unique and may include values not currently in use by your account. Due to this, the list of sizes returned by this method may differ from the list seen in the Trafficking UI.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.

optional:
ids <string> Select only sizes with these IDs.
height <integer> Select only sizes with this height.
iabStandard <boolean> Select only IAB standard sizes.
width <integer> Select only sizes with this width."
  ([profileId] (sizes-list profileId nil))
  ([profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/sizes",
       :uri-template-args {:profileId profileId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn creativeFieldValues-delete
  "Deletes an existing creative field value.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
creativeFieldId <string> Creative field ID for this creative field value.
id <string> Creative Field Value ID"
  [profileId creativeFieldId id]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/creativeFields/{+creativeFieldId}/creativeFieldValues/{+id}",
     :uri-template-args
     {:profileId profileId, :creativeFieldId creativeFieldId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn creativeFieldValues-get
  "Gets one creative field value by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
creativeFieldId <string> Creative field ID for this creative field value.
id <string> Creative Field Value ID"
  [profileId creativeFieldId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/creativeFields/{+creativeFieldId}/creativeFieldValues/{+id}",
     :uri-template-args
     {:profileId profileId, :creativeFieldId creativeFieldId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn creativeFieldValues-insert
  "Inserts a new creative field value.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
creativeFieldId <string> Creative field ID for this creative field value.
CreativeFieldValue:
{:kind string, :id string, :value string}"
  [profileId creativeFieldId CreativeFieldValue]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/creativeFields/{+creativeFieldId}/creativeFieldValues",
     :uri-template-args
     {:profileId profileId, :creativeFieldId creativeFieldId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body CreativeFieldValue}))

(defn creativeFieldValues-list
  "Retrieves a list of creative field values, possibly filtered. This method supports paging.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
creativeFieldId <string> Creative field ID for this creative field value.

optional:
maxResults <integer> Maximum number of results to return.
searchString <string> Allows searching for creative field values by their values. Wildcards (e.g. *) are not allowed.
ids <string> Select only creative field values with these IDs.
sortField <string> Field by which to sort the list.
sortOrder <string> Order of sorted results."
  ([profileId creativeFieldId]
    (creativeFieldValues-list profileId creativeFieldId nil))
  ([profileId creativeFieldId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/creativeFields/{+creativeFieldId}/creativeFieldValues",
       :uri-template-args
       {:profileId profileId, :creativeFieldId creativeFieldId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn creativeFieldValues-update
  "Updates an existing creative field value.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
creativeFieldId <string> Creative field ID for this creative field value.
CreativeFieldValue:
{:kind string, :id string, :value string}"
  [profileId creativeFieldId CreativeFieldValue]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/creativeFields/{+creativeFieldId}/creativeFieldValues",
     :uri-template-args
     {:profileId profileId, :creativeFieldId creativeFieldId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body CreativeFieldValue}))

(defn creativeFieldValues-patch
  "Updates an existing creative field value. This method supports patch semantics.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
creativeFieldId <string> CreativeField ID.
id <string> CreativeFieldValue ID.
CreativeFieldValue:
{:kind string, :id string, :value string}"
  [profileId creativeFieldId id CreativeFieldValue]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/creativeFields/{+creativeFieldId}/creativeFieldValues",
     :uri-template-args
     {:profileId profileId, :creativeFieldId creativeFieldId},
     :query-params {:id id},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body CreativeFieldValue}))

(defn operatingSystemVersions-get
  "Gets one operating system version by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Operating system version ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/operatingSystemVersions/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn operatingSystemVersions-list
  "Retrieves a list of operating system versions.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request."
  [profileId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/operatingSystemVersions",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn sites-patch
  "Updates an existing site. This method supports patch semantics.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Required. Site ID.
Site:
{:directorySiteId string,
 :keyName string,
 :idDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :name string,
 :approved boolean,
 :videoSettings
 {:companionSettings
  {:companionsDisabled boolean,
   :enabledSizes
   [{:id string,
     :width integer,
     :height integer,
     :iab boolean,
     :kind string}],
   :imageOnly boolean,
   :kind string},
  :transcodeSettings {:enabledVideoFormats [integer], :kind string},
  :skippableSettings
  {:skippable boolean,
   :skipOffset {:offsetSeconds integer, :offsetPercentage integer},
   :progressOffset {:offsetSeconds integer, :offsetPercentage integer},
   :kind string},
  :orientation [ANY LANDSCAPE PORTRAIT],
  :kind string,
  :obaSettings
  {:resourceUrl string,
   :xPosition string,
   :yPosition string,
   :size
   {:id string,
    :width integer,
    :height integer,
    :iab boolean,
    :kind string},
   :program string,
   :iconClickThroughUrl string,
   :iconClickTrackingUrl string,
   :iconViewTrackingUrl string},
  :obaEnabled boolean,
  :publisherSpecificationId string},
 :directorySiteIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :id string,
 :kind string,
 :siteSettings
 {:disableNewCookie boolean,
  :tagSetting
  {:additionalKeyValues string,
   :includeClickTracking boolean,
   :includeClickThroughUrls boolean,
   :keywordOption
   [PLACEHOLDER_WITH_LIST_OF_KEYWORDS
    IGNORE
    GENERATE_SEPARATE_TAG_FOR_EACH_KEYWORD]},
  :activeViewOptOut boolean,
  :adBlockingOptOut boolean,
  :videoActiveViewOptOutTemplate boolean,
  :vpaidAdapterChoiceTemplate [DEFAULT FLASH HTML5 BOTH]},
 :subaccountId string,
 :siteContacts
 [{:id string,
   :contactType [SALES_PERSON TRAFFICKER],
   :email string,
   :firstName string,
   :lastName string,
   :title string,
   :address string,
   :phone string}],
 :accountId string}"
  [profileId id Site]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/sites",
     :uri-template-args {:profileId profileId},
     :query-params {:id id},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body Site}))

(defn sites-get
  "Gets one site by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Site ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/sites/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn sites-insert
  "Inserts a new site.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
Site:
{:directorySiteId string,
 :keyName string,
 :idDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :name string,
 :approved boolean,
 :videoSettings
 {:companionSettings
  {:companionsDisabled boolean,
   :enabledSizes
   [{:id string,
     :width integer,
     :height integer,
     :iab boolean,
     :kind string}],
   :imageOnly boolean,
   :kind string},
  :transcodeSettings {:enabledVideoFormats [integer], :kind string},
  :skippableSettings
  {:skippable boolean,
   :skipOffset {:offsetSeconds integer, :offsetPercentage integer},
   :progressOffset {:offsetSeconds integer, :offsetPercentage integer},
   :kind string},
  :orientation [ANY LANDSCAPE PORTRAIT],
  :kind string,
  :obaSettings
  {:resourceUrl string,
   :xPosition string,
   :yPosition string,
   :size
   {:id string,
    :width integer,
    :height integer,
    :iab boolean,
    :kind string},
   :program string,
   :iconClickThroughUrl string,
   :iconClickTrackingUrl string,
   :iconViewTrackingUrl string},
  :obaEnabled boolean,
  :publisherSpecificationId string},
 :directorySiteIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :id string,
 :kind string,
 :siteSettings
 {:disableNewCookie boolean,
  :tagSetting
  {:additionalKeyValues string,
   :includeClickTracking boolean,
   :includeClickThroughUrls boolean,
   :keywordOption
   [PLACEHOLDER_WITH_LIST_OF_KEYWORDS
    IGNORE
    GENERATE_SEPARATE_TAG_FOR_EACH_KEYWORD]},
  :activeViewOptOut boolean,
  :adBlockingOptOut boolean,
  :videoActiveViewOptOutTemplate boolean,
  :vpaidAdapterChoiceTemplate [DEFAULT FLASH HTML5 BOTH]},
 :subaccountId string,
 :siteContacts
 [{:id string,
   :contactType [SALES_PERSON TRAFFICKER],
   :email string,
   :firstName string,
   :lastName string,
   :title string,
   :address string,
   :phone string}],
 :accountId string}"
  [profileId Site]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/sites",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body Site}))

(defn sites-list
  "Retrieves a list of sites, possibly filtered. This method supports paging.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.

optional:
acceptsInterstitialPlacements <boolean> This search filter is no longer supported and will have no effect on the results returned.
campaignIds <string> Select only sites with these campaign IDs.
unmappedSite <boolean> Select only sites that have not been mapped to a directory site.
ids <string> Select only sites with these IDs.
acceptsInStreamVideoPlacements <boolean> This search filter is no longer supported and will have no effect on the results returned.
approved <boolean> Select only approved sites.
searchString <string> Allows searching for objects by name, ID or keyName. Wildcards (*) are allowed. For example, \"site*2015\" will return objects with names like \"site June 2015\", \"site April 2015\", or simply \"site 2015\". Most of the searches also add wildcards implicitly at the start and the end of the search string. For example, a search string of \"site\" will match objects with name \"my site\", \"site 2015\", or simply \"site\".
sortField <string> Field by which to sort the list.
sortOrder <string> Order of sorted results.
acceptsPublisherPaidPlacements <boolean> Select only sites that accept publisher paid placements.
adWordsSite <boolean> Select only AdWords sites.
directorySiteIds <string> Select only sites with these directory site IDs.
subaccountId <string> Select only sites with this subaccount ID.
maxResults <integer> Maximum number of results to return."
  ([profileId] (sites-list profileId nil))
  ([profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/sites",
       :uri-template-args {:profileId profileId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn sites-update
  "Updates an existing site.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
Site:
{:directorySiteId string,
 :keyName string,
 :idDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :name string,
 :approved boolean,
 :videoSettings
 {:companionSettings
  {:companionsDisabled boolean,
   :enabledSizes
   [{:id string,
     :width integer,
     :height integer,
     :iab boolean,
     :kind string}],
   :imageOnly boolean,
   :kind string},
  :transcodeSettings {:enabledVideoFormats [integer], :kind string},
  :skippableSettings
  {:skippable boolean,
   :skipOffset {:offsetSeconds integer, :offsetPercentage integer},
   :progressOffset {:offsetSeconds integer, :offsetPercentage integer},
   :kind string},
  :orientation [ANY LANDSCAPE PORTRAIT],
  :kind string,
  :obaSettings
  {:resourceUrl string,
   :xPosition string,
   :yPosition string,
   :size
   {:id string,
    :width integer,
    :height integer,
    :iab boolean,
    :kind string},
   :program string,
   :iconClickThroughUrl string,
   :iconClickTrackingUrl string,
   :iconViewTrackingUrl string},
  :obaEnabled boolean,
  :publisherSpecificationId string},
 :directorySiteIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :id string,
 :kind string,
 :siteSettings
 {:disableNewCookie boolean,
  :tagSetting
  {:additionalKeyValues string,
   :includeClickTracking boolean,
   :includeClickThroughUrls boolean,
   :keywordOption
   [PLACEHOLDER_WITH_LIST_OF_KEYWORDS
    IGNORE
    GENERATE_SEPARATE_TAG_FOR_EACH_KEYWORD]},
  :activeViewOptOut boolean,
  :adBlockingOptOut boolean,
  :videoActiveViewOptOutTemplate boolean,
  :vpaidAdapterChoiceTemplate [DEFAULT FLASH HTML5 BOTH]},
 :subaccountId string,
 :siteContacts
 [{:id string,
   :contactType [SALES_PERSON TRAFFICKER],
   :email string,
   :firstName string,
   :lastName string,
   :title string,
   :address string,
   :phone string}],
 :accountId string}"
  [profileId Site]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/sites",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body Site}))

(defn mobileCarriers-get
  "Gets one mobile carrier by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Mobile carrier ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/mobileCarriers/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn mobileCarriers-list
  "Retrieves a list of mobile carriers.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request."
  [profileId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/mobileCarriers",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn cities-list
  "Retrieves a list of cities, possibly filtered.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.

optional:
namePrefix <string> Select only cities with names starting with this prefix.
countryDartIds <string> Select only cities from these countries.
dartIds <string> Select only cities with these DART IDs.
regionDartIds <string> Select only cities from these regions."
  ([profileId] (cities-list profileId nil))
  ([profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/cities",
       :uri-template-args {:profileId profileId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn advertisers-get
  "Gets one advertiser by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Advertiser ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/advertisers/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn advertisers-insert
  "Inserts a new advertiser.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
Advertiser:
{:idDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :floodlightConfigurationIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :measurementPartnerLink
 {:measurementPartner [NONE INTEGRAL_AD_SCIENCE DOUBLE_VERIFY],
  :linkStatus
  [MEASUREMENT_PARTNER_UNLINKED
   MEASUREMENT_PARTNER_LINKED
   MEASUREMENT_PARTNER_LINK_PENDING
   MEASUREMENT_PARTNER_LINK_FAILURE
   MEASUREMENT_PARTNER_LINK_OPT_OUT
   MEASUREMENT_PARTNER_LINK_OPT_OUT_PENDING
   MEASUREMENT_PARTNER_LINK_WRAPPING_PENDING
   MEASUREMENT_PARTNER_MODE_CHANGE_PENDING
   MEASUREMENT_PARTNER_UNLINK_PENDING],
  :partnerAdvertiserId string},
 :clickThroughUrlSuffix string,
 :floodlightConfigurationId string,
 :name string,
 :advertiserGroupId string,
 :suspended boolean,
 :status [APPROVED ON_HOLD],
 :id string,
 :kind string,
 :defaultEmail string,
 :defaultClickThroughEventTagId string,
 :subaccountId string,
 :accountId string,
 :originalFloodlightConfigurationId string}"
  [profileId Advertiser]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/advertisers",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body Advertiser}))

(defn advertisers-list
  "Retrieves a list of advertisers, possibly filtered. This method supports paging.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.

optional:
includeAdvertisersWithoutGroupsOnly <boolean> Select only advertisers which do not belong to any advertiser group.
floodlightConfigurationIds <string> Select only advertisers with these floodlight configuration IDs.
ids <string> Select only advertisers with these IDs.
searchString <string> Allows searching for objects by name or ID. Wildcards (*) are allowed. For example, \"advertiser*2015\" will return objects with names like \"advertiser June 2015\", \"advertiser April 2015\", or simply \"advertiser 2015\". Most of the searches also add wildcards implicitly at the start and the end of the search string. For example, a search string of \"advertiser\" will match objects with name \"my advertiser\", \"advertiser 2015\", or simply \"advertiser\" .
advertiserGroupIds <string> Select only advertisers with these advertiser group IDs.
sortField <string> Field by which to sort the list.
status <string> Select only advertisers with the specified status.
sortOrder <string> Order of sorted results.
onlyParent <boolean> Select only advertisers which use another advertiser's floodlight configuration.
subaccountId <string> Select only advertisers with these subaccount IDs.
maxResults <integer> Maximum number of results to return."
  ([profileId] (advertisers-list profileId nil))
  ([profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/advertisers",
       :uri-template-args {:profileId profileId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn advertisers-update
  "Updates an existing advertiser.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
Advertiser:
{:idDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :floodlightConfigurationIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :measurementPartnerLink
 {:measurementPartner [NONE INTEGRAL_AD_SCIENCE DOUBLE_VERIFY],
  :linkStatus
  [MEASUREMENT_PARTNER_UNLINKED
   MEASUREMENT_PARTNER_LINKED
   MEASUREMENT_PARTNER_LINK_PENDING
   MEASUREMENT_PARTNER_LINK_FAILURE
   MEASUREMENT_PARTNER_LINK_OPT_OUT
   MEASUREMENT_PARTNER_LINK_OPT_OUT_PENDING
   MEASUREMENT_PARTNER_LINK_WRAPPING_PENDING
   MEASUREMENT_PARTNER_MODE_CHANGE_PENDING
   MEASUREMENT_PARTNER_UNLINK_PENDING],
  :partnerAdvertiserId string},
 :clickThroughUrlSuffix string,
 :floodlightConfigurationId string,
 :name string,
 :advertiserGroupId string,
 :suspended boolean,
 :status [APPROVED ON_HOLD],
 :id string,
 :kind string,
 :defaultEmail string,
 :defaultClickThroughEventTagId string,
 :subaccountId string,
 :accountId string,
 :originalFloodlightConfigurationId string}"
  [profileId Advertiser]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/advertisers",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body Advertiser}))

(defn advertisers-patch
  "Updates an existing advertiser. This method supports patch semantics.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Required. Advertiser ID.
Advertiser:
{:idDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :floodlightConfigurationIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :measurementPartnerLink
 {:measurementPartner [NONE INTEGRAL_AD_SCIENCE DOUBLE_VERIFY],
  :linkStatus
  [MEASUREMENT_PARTNER_UNLINKED
   MEASUREMENT_PARTNER_LINKED
   MEASUREMENT_PARTNER_LINK_PENDING
   MEASUREMENT_PARTNER_LINK_FAILURE
   MEASUREMENT_PARTNER_LINK_OPT_OUT
   MEASUREMENT_PARTNER_LINK_OPT_OUT_PENDING
   MEASUREMENT_PARTNER_LINK_WRAPPING_PENDING
   MEASUREMENT_PARTNER_MODE_CHANGE_PENDING
   MEASUREMENT_PARTNER_UNLINK_PENDING],
  :partnerAdvertiserId string},
 :clickThroughUrlSuffix string,
 :floodlightConfigurationId string,
 :name string,
 :advertiserGroupId string,
 :suspended boolean,
 :status [APPROVED ON_HOLD],
 :id string,
 :kind string,
 :defaultEmail string,
 :defaultClickThroughEventTagId string,
 :subaccountId string,
 :accountId string,
 :originalFloodlightConfigurationId string}"
  [profileId id Advertiser]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/advertisers",
     :uri-template-args {:profileId profileId},
     :query-params {:id id},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body Advertiser}))

(defn regions-list
  "Retrieves a list of regions.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request."
  [profileId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/regions",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn platformTypes-get
  "Gets one platform type by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Platform type ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/platformTypes/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn platformTypes-list
  "Retrieves a list of platform types.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request."
  [profileId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/platformTypes",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn advertiserGroups-delete
  "Deletes an existing advertiser group.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Advertiser group ID."
  [profileId id]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/advertiserGroups/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn advertiserGroups-get
  "Gets one advertiser group by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Advertiser group ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/advertiserGroups/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn advertiserGroups-insert
  "Inserts a new advertiser group.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
AdvertiserGroup:
{:id string, :name string, :accountId string, :kind string}"
  [profileId AdvertiserGroup]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/advertiserGroups",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body AdvertiserGroup}))

(defn advertiserGroups-list
  "Retrieves a list of advertiser groups, possibly filtered. This method supports paging.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.

optional:
maxResults <integer> Maximum number of results to return.
ids <string> Select only advertiser groups with these IDs.
searchString <string> Allows searching for objects by name or ID. Wildcards (*) are allowed. For example, \"advertiser*2015\" will return objects with names like \"advertiser group June 2015\", \"advertiser group April 2015\", or simply \"advertiser group 2015\". Most of the searches also add wildcards implicitly at the start and the end of the search string. For example, a search string of \"advertisergroup\" will match objects with name \"my advertisergroup\", \"advertisergroup 2015\", or simply \"advertisergroup\".
sortField <string> Field by which to sort the list.
sortOrder <string> Order of sorted results."
  ([profileId] (advertiserGroups-list profileId nil))
  ([profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/advertiserGroups",
       :uri-template-args {:profileId profileId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn advertiserGroups-update
  "Updates an existing advertiser group.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
AdvertiserGroup:
{:id string, :name string, :accountId string, :kind string}"
  [profileId AdvertiserGroup]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/advertiserGroups",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body AdvertiserGroup}))

(defn advertiserGroups-patch
  "Updates an existing advertiser group. This method supports patch semantics.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Required. Advertiser Group ID.
AdvertiserGroup:
{:id string, :name string, :accountId string, :kind string}"
  [profileId id AdvertiserGroup]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/advertiserGroups",
     :uri-template-args {:profileId profileId},
     :query-params {:id id},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body AdvertiserGroup}))

(defn placements-patch
  "Updates an existing placement. This method supports patch semantics.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Required. Placement ID.
Placement:
{:directorySiteId string,
 :placementGroupIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :keyName string,
 :primary boolean,
 :siteId string,
 :idDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :additionalSizes
 [{:id string,
   :width integer,
   :height integer,
   :iab boolean,
   :kind string}],
 :wrappingOptOut boolean,
 :pricingSchedule
 {:testingStartDate string,
  :startDate string,
  :endDate string,
  :pricingType
  [PRICING_TYPE_CPM
   PRICING_TYPE_CPC
   PRICING_TYPE_CPA
   PRICING_TYPE_FLAT_RATE_IMPRESSIONS
   PRICING_TYPE_FLAT_RATE_CLICKS
   PRICING_TYPE_CPM_ACTIVEVIEW],
  :capCostOption [CAP_COST_NONE CAP_COST_MONTHLY CAP_COST_CUMULATIVE],
  :flighted boolean,
  :pricingPeriods
  [{:startDate string,
    :endDate string,
    :units string,
    :rateOrCostNanos string,
    :pricingComment string}],
  :floodlightActivityId string},
 :adBlockingOptOut boolean,
 :compatibility
 [DISPLAY
  DISPLAY_INTERSTITIAL
  APP
  APP_INTERSTITIAL
  IN_STREAM_VIDEO
  IN_STREAM_AUDIO],
 :tagFormats
 [[PLACEMENT_TAG_STANDARD
   PLACEMENT_TAG_IFRAME_JAVASCRIPT
   PLACEMENT_TAG_IFRAME_ILAYER
   PLACEMENT_TAG_INTERNAL_REDIRECT
   PLACEMENT_TAG_JAVASCRIPT
   PLACEMENT_TAG_INTERSTITIAL_IFRAME_JAVASCRIPT
   PLACEMENT_TAG_INTERSTITIAL_INTERNAL_REDIRECT
   PLACEMENT_TAG_INTERSTITIAL_JAVASCRIPT
   PLACEMENT_TAG_CLICK_COMMANDS
   PLACEMENT_TAG_INSTREAM_VIDEO_PREFETCH
   PLACEMENT_TAG_TRACKING
   PLACEMENT_TAG_TRACKING_IFRAME
   PLACEMENT_TAG_TRACKING_JAVASCRIPT
   PLACEMENT_TAG_INSTREAM_VIDEO_PREFETCH_VAST_3
   PLACEMENT_TAG_IFRAME_JAVASCRIPT_LEGACY
   PLACEMENT_TAG_JAVASCRIPT_LEGACY
   PLACEMENT_TAG_INTERSTITIAL_IFRAME_JAVASCRIPT_LEGACY
   PLACEMENT_TAG_INTERSTITIAL_JAVASCRIPT_LEGACY
   PLACEMENT_TAG_INSTREAM_VIDEO_PREFETCH_VAST_4
   PLACEMENT_TAG_TRACKING_THIRD_PARTY_MEASUREMENT]],
 :vpaidAdapterChoice [DEFAULT FLASH HTML5 BOTH],
 :advertiserIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :name string,
 :placementStrategyId string,
 :campaignId string,
 :conversionDomainOverride
 {:conversionDomains
  [{:conversionDomainId string, :conversionDomainValue string}]},
 :createInfo {:time string},
 :videoActiveViewOptOut boolean,
 :partnerWrappingData
 {:measurementPartner [NONE INTEGRAL_AD_SCIENCE DOUBLE_VERIFY],
  :linkStatus
  [MEASUREMENT_PARTNER_UNLINKED
   MEASUREMENT_PARTNER_LINKED
   MEASUREMENT_PARTNER_LINK_PENDING
   MEASUREMENT_PARTNER_LINK_FAILURE
   MEASUREMENT_PARTNER_LINK_OPT_OUT
   MEASUREMENT_PARTNER_LINK_OPT_OUT_PENDING
   MEASUREMENT_PARTNER_LINK_WRAPPING_PENDING
   MEASUREMENT_PARTNER_MODE_CHANGE_PENDING
   MEASUREMENT_PARTNER_UNLINK_PENDING],
  :wrappedTag string,
  :tagWrappingMode
  [NONE
   BLOCKING
   MONITORING
   MONITORING_READ_ONLY
   VIDEO_PIXEL_MONITORING
   TRACKING
   VPAID_MONITORING
   VPAID_BLOCKING
   NON_VPAID_MONITORING
   VPAID_ONLY_MONITORING
   VPAID_ONLY_BLOCKING
   VPAID_ONLY_FILTERING
   VPAID_FILTERING
   NON_VPAID_FILTERING]},
 :campaignIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :size
 {:id string,
  :width integer,
  :height integer,
  :iab boolean,
  :kind string},
 :placementGroupId string,
 :tagSetting
 {:additionalKeyValues string,
  :includeClickTracking boolean,
  :includeClickThroughUrls boolean,
  :keywordOption
  [PLACEHOLDER_WITH_LIST_OF_KEYWORDS
   IGNORE
   GENERATE_SEPARATE_TAG_FOR_EACH_KEYWORD]},
 :contentCategoryId string,
 :videoSettings
 {:publisherSpecificationId string,
  :obaEnabled boolean,
  :companionSettings
  {:companionsDisabled boolean,
   :enabledSizes
   [{:id string,
     :width integer,
     :height integer,
     :iab boolean,
     :kind string}],
   :imageOnly boolean,
   :kind string},
  :obaSettings
  {:resourceUrl string,
   :xPosition string,
   :yPosition string,
   :size
   {:id string,
    :width integer,
    :height integer,
    :iab boolean,
    :kind string},
   :program string,
   :iconClickThroughUrl string,
   :iconClickTrackingUrl string,
   :iconViewTrackingUrl string},
  :skippableSettings
  {:skippable boolean,
   :skipOffset {:offsetSeconds integer, :offsetPercentage integer},
   :progressOffset {:offsetSeconds integer, :offsetPercentage integer},
   :kind string},
  :orientation [ANY LANDSCAPE PORTRAIT],
  :durationSeconds integer,
  :transcodeSettings {:enabledVideoFormats [integer], :kind string},
  :kind string},
 :activeStatus
 [PLACEMENT_STATUS_UNKNOWN
  PLACEMENT_STATUS_ACTIVE
  PLACEMENT_STATUS_INACTIVE
  PLACEMENT_STATUS_ARCHIVED
  PLACEMENT_STATUS_PERMANENTLY_ARCHIVED],
 :advertiserId string,
 :externalId string,
 :directorySiteIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :status
 [PENDING_REVIEW
  PAYMENT_ACCEPTED
  PAYMENT_REJECTED
  ACKNOWLEDGE_REJECTION
  ACKNOWLEDGE_ACCEPTANCE
  DRAFT],
 :sslRequired boolean,
 :id string,
 :siteIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :kind string,
 :comment string,
 :lookbackConfiguration
 {:clickDuration integer, :postImpressionActivitiesDuration integer},
 :lastModifiedInfo {:time string},
 :publisherUpdateInfo {:time string},
 :subaccountId string,
 :paymentApproved boolean,
 :accountId string,
 :paymentSource [PLACEMENT_AGENCY_PAID PLACEMENT_PUBLISHER_PAID]}"
  [profileId id Placement]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/placements",
     :uri-template-args {:profileId profileId},
     :query-params {:id id},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body Placement}))

(defn placements-generatetags
  "Generates tags for a placement.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.

optional:
placementIds <string> Generate tags for these placements.
campaignId <string> Generate placements belonging to this campaign. This is a required field.
tagFormats <string> Tag formats to generate for these placements. *Note:* PLACEMENT_TAG_STANDARD can only be generated for 1x1 placements."
  ([profileId] (placements-generatetags profileId nil))
  ([profileId optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/placements/generatetags",
       :uri-template-args {:profileId profileId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn placements-get
  "Gets one placement by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Placement ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/placements/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn placements-insert
  "Inserts a new placement.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
Placement:
{:directorySiteId string,
 :placementGroupIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :keyName string,
 :primary boolean,
 :siteId string,
 :idDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :additionalSizes
 [{:id string,
   :width integer,
   :height integer,
   :iab boolean,
   :kind string}],
 :wrappingOptOut boolean,
 :pricingSchedule
 {:testingStartDate string,
  :startDate string,
  :endDate string,
  :pricingType
  [PRICING_TYPE_CPM
   PRICING_TYPE_CPC
   PRICING_TYPE_CPA
   PRICING_TYPE_FLAT_RATE_IMPRESSIONS
   PRICING_TYPE_FLAT_RATE_CLICKS
   PRICING_TYPE_CPM_ACTIVEVIEW],
  :capCostOption [CAP_COST_NONE CAP_COST_MONTHLY CAP_COST_CUMULATIVE],
  :flighted boolean,
  :pricingPeriods
  [{:startDate string,
    :endDate string,
    :units string,
    :rateOrCostNanos string,
    :pricingComment string}],
  :floodlightActivityId string},
 :adBlockingOptOut boolean,
 :compatibility
 [DISPLAY
  DISPLAY_INTERSTITIAL
  APP
  APP_INTERSTITIAL
  IN_STREAM_VIDEO
  IN_STREAM_AUDIO],
 :tagFormats
 [[PLACEMENT_TAG_STANDARD
   PLACEMENT_TAG_IFRAME_JAVASCRIPT
   PLACEMENT_TAG_IFRAME_ILAYER
   PLACEMENT_TAG_INTERNAL_REDIRECT
   PLACEMENT_TAG_JAVASCRIPT
   PLACEMENT_TAG_INTERSTITIAL_IFRAME_JAVASCRIPT
   PLACEMENT_TAG_INTERSTITIAL_INTERNAL_REDIRECT
   PLACEMENT_TAG_INTERSTITIAL_JAVASCRIPT
   PLACEMENT_TAG_CLICK_COMMANDS
   PLACEMENT_TAG_INSTREAM_VIDEO_PREFETCH
   PLACEMENT_TAG_TRACKING
   PLACEMENT_TAG_TRACKING_IFRAME
   PLACEMENT_TAG_TRACKING_JAVASCRIPT
   PLACEMENT_TAG_INSTREAM_VIDEO_PREFETCH_VAST_3
   PLACEMENT_TAG_IFRAME_JAVASCRIPT_LEGACY
   PLACEMENT_TAG_JAVASCRIPT_LEGACY
   PLACEMENT_TAG_INTERSTITIAL_IFRAME_JAVASCRIPT_LEGACY
   PLACEMENT_TAG_INTERSTITIAL_JAVASCRIPT_LEGACY
   PLACEMENT_TAG_INSTREAM_VIDEO_PREFETCH_VAST_4
   PLACEMENT_TAG_TRACKING_THIRD_PARTY_MEASUREMENT]],
 :vpaidAdapterChoice [DEFAULT FLASH HTML5 BOTH],
 :advertiserIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :name string,
 :placementStrategyId string,
 :campaignId string,
 :conversionDomainOverride
 {:conversionDomains
  [{:conversionDomainId string, :conversionDomainValue string}]},
 :createInfo {:time string},
 :videoActiveViewOptOut boolean,
 :partnerWrappingData
 {:measurementPartner [NONE INTEGRAL_AD_SCIENCE DOUBLE_VERIFY],
  :linkStatus
  [MEASUREMENT_PARTNER_UNLINKED
   MEASUREMENT_PARTNER_LINKED
   MEASUREMENT_PARTNER_LINK_PENDING
   MEASUREMENT_PARTNER_LINK_FAILURE
   MEASUREMENT_PARTNER_LINK_OPT_OUT
   MEASUREMENT_PARTNER_LINK_OPT_OUT_PENDING
   MEASUREMENT_PARTNER_LINK_WRAPPING_PENDING
   MEASUREMENT_PARTNER_MODE_CHANGE_PENDING
   MEASUREMENT_PARTNER_UNLINK_PENDING],
  :wrappedTag string,
  :tagWrappingMode
  [NONE
   BLOCKING
   MONITORING
   MONITORING_READ_ONLY
   VIDEO_PIXEL_MONITORING
   TRACKING
   VPAID_MONITORING
   VPAID_BLOCKING
   NON_VPAID_MONITORING
   VPAID_ONLY_MONITORING
   VPAID_ONLY_BLOCKING
   VPAID_ONLY_FILTERING
   VPAID_FILTERING
   NON_VPAID_FILTERING]},
 :campaignIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :size
 {:id string,
  :width integer,
  :height integer,
  :iab boolean,
  :kind string},
 :placementGroupId string,
 :tagSetting
 {:additionalKeyValues string,
  :includeClickTracking boolean,
  :includeClickThroughUrls boolean,
  :keywordOption
  [PLACEHOLDER_WITH_LIST_OF_KEYWORDS
   IGNORE
   GENERATE_SEPARATE_TAG_FOR_EACH_KEYWORD]},
 :contentCategoryId string,
 :videoSettings
 {:publisherSpecificationId string,
  :obaEnabled boolean,
  :companionSettings
  {:companionsDisabled boolean,
   :enabledSizes
   [{:id string,
     :width integer,
     :height integer,
     :iab boolean,
     :kind string}],
   :imageOnly boolean,
   :kind string},
  :obaSettings
  {:resourceUrl string,
   :xPosition string,
   :yPosition string,
   :size
   {:id string,
    :width integer,
    :height integer,
    :iab boolean,
    :kind string},
   :program string,
   :iconClickThroughUrl string,
   :iconClickTrackingUrl string,
   :iconViewTrackingUrl string},
  :skippableSettings
  {:skippable boolean,
   :skipOffset {:offsetSeconds integer, :offsetPercentage integer},
   :progressOffset {:offsetSeconds integer, :offsetPercentage integer},
   :kind string},
  :orientation [ANY LANDSCAPE PORTRAIT],
  :durationSeconds integer,
  :transcodeSettings {:enabledVideoFormats [integer], :kind string},
  :kind string},
 :activeStatus
 [PLACEMENT_STATUS_UNKNOWN
  PLACEMENT_STATUS_ACTIVE
  PLACEMENT_STATUS_INACTIVE
  PLACEMENT_STATUS_ARCHIVED
  PLACEMENT_STATUS_PERMANENTLY_ARCHIVED],
 :advertiserId string,
 :externalId string,
 :directorySiteIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :status
 [PENDING_REVIEW
  PAYMENT_ACCEPTED
  PAYMENT_REJECTED
  ACKNOWLEDGE_REJECTION
  ACKNOWLEDGE_ACCEPTANCE
  DRAFT],
 :sslRequired boolean,
 :id string,
 :siteIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :kind string,
 :comment string,
 :lookbackConfiguration
 {:clickDuration integer, :postImpressionActivitiesDuration integer},
 :lastModifiedInfo {:time string},
 :publisherUpdateInfo {:time string},
 :subaccountId string,
 :paymentApproved boolean,
 :accountId string,
 :paymentSource [PLACEMENT_AGENCY_PAID PLACEMENT_PUBLISHER_PAID]}"
  [profileId Placement]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/placements",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body Placement}))

(defn placements-list
  "Retrieves a list of placements, possibly filtered. This method supports paging.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.

optional:
pricingTypes <string> Select only placements with these pricing types.
minEndDate <string> Select only placements or placement groups whose end date is on or after the specified minEndDate. The date should be formatted as \"yyyy-MM-dd\".
campaignIds <string> Select only placements that belong to these campaigns.
contentCategoryIds <string> Select only placements that are associated with these content categories.
ids <string> Select only placements with these IDs.
searchString <string> Allows searching for placements by name or ID. Wildcards (*) are allowed. For example, \"placement*2015\" will return placements with names like \"placement June 2015\", \"placement May 2015\", or simply \"placements 2015\". Most of the searches also add wildcards implicitly at the start and the end of the search string. For example, a search string of \"placement\" will match placements with name \"my placement\", \"placement 2015\", or simply \"placement\" .
groupIds <string> Select only placements that belong to these placement groups.
compatibilities <string> Select only placements that are associated with these compatibilities. DISPLAY and DISPLAY_INTERSTITIAL refer to rendering either on desktop or on mobile devices for regular or interstitial ads respectively. APP and APP_INTERSTITIAL are for rendering in mobile apps. IN_STREAM_VIDEO refers to rendering in in-stream video ads developed with the VAST standard.
sortField <string> Field by which to sort the list.
minStartDate <string> Select only placements or placement groups whose start date is on or after the specified minStartDate. The date should be formatted as \"yyyy-MM-dd\".
advertiserIds <string> Select only placements that belong to these advertisers.
activeStatus <string> Select only placements with these active statuses.
maxEndDate <string> Select only placements or placement groups whose end date is on or before the specified maxEndDate. The date should be formatted as \"yyyy-MM-dd\".
sortOrder <string> Order of sorted results.
sizeIds <string> Select only placements that are associated with these sizes.
placementStrategyIds <string> Select only placements that are associated with these placement strategies.
directorySiteIds <string> Select only placements that are associated with these directory sites.
maxStartDate <string> Select only placements or placement groups whose start date is on or before the specified maxStartDate. The date should be formatted as \"yyyy-MM-dd\".
paymentSource <string> Select only placements with this payment source.
maxResults <integer> Maximum number of results to return.
siteIds <string> Select only placements that are associated with these sites."
  ([profileId] (placements-list profileId nil))
  ([profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/placements",
       :uri-template-args {:profileId profileId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn placements-update
  "Updates an existing placement.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
Placement:
{:directorySiteId string,
 :placementGroupIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :keyName string,
 :primary boolean,
 :siteId string,
 :idDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :additionalSizes
 [{:id string,
   :width integer,
   :height integer,
   :iab boolean,
   :kind string}],
 :wrappingOptOut boolean,
 :pricingSchedule
 {:testingStartDate string,
  :startDate string,
  :endDate string,
  :pricingType
  [PRICING_TYPE_CPM
   PRICING_TYPE_CPC
   PRICING_TYPE_CPA
   PRICING_TYPE_FLAT_RATE_IMPRESSIONS
   PRICING_TYPE_FLAT_RATE_CLICKS
   PRICING_TYPE_CPM_ACTIVEVIEW],
  :capCostOption [CAP_COST_NONE CAP_COST_MONTHLY CAP_COST_CUMULATIVE],
  :flighted boolean,
  :pricingPeriods
  [{:startDate string,
    :endDate string,
    :units string,
    :rateOrCostNanos string,
    :pricingComment string}],
  :floodlightActivityId string},
 :adBlockingOptOut boolean,
 :compatibility
 [DISPLAY
  DISPLAY_INTERSTITIAL
  APP
  APP_INTERSTITIAL
  IN_STREAM_VIDEO
  IN_STREAM_AUDIO],
 :tagFormats
 [[PLACEMENT_TAG_STANDARD
   PLACEMENT_TAG_IFRAME_JAVASCRIPT
   PLACEMENT_TAG_IFRAME_ILAYER
   PLACEMENT_TAG_INTERNAL_REDIRECT
   PLACEMENT_TAG_JAVASCRIPT
   PLACEMENT_TAG_INTERSTITIAL_IFRAME_JAVASCRIPT
   PLACEMENT_TAG_INTERSTITIAL_INTERNAL_REDIRECT
   PLACEMENT_TAG_INTERSTITIAL_JAVASCRIPT
   PLACEMENT_TAG_CLICK_COMMANDS
   PLACEMENT_TAG_INSTREAM_VIDEO_PREFETCH
   PLACEMENT_TAG_TRACKING
   PLACEMENT_TAG_TRACKING_IFRAME
   PLACEMENT_TAG_TRACKING_JAVASCRIPT
   PLACEMENT_TAG_INSTREAM_VIDEO_PREFETCH_VAST_3
   PLACEMENT_TAG_IFRAME_JAVASCRIPT_LEGACY
   PLACEMENT_TAG_JAVASCRIPT_LEGACY
   PLACEMENT_TAG_INTERSTITIAL_IFRAME_JAVASCRIPT_LEGACY
   PLACEMENT_TAG_INTERSTITIAL_JAVASCRIPT_LEGACY
   PLACEMENT_TAG_INSTREAM_VIDEO_PREFETCH_VAST_4
   PLACEMENT_TAG_TRACKING_THIRD_PARTY_MEASUREMENT]],
 :vpaidAdapterChoice [DEFAULT FLASH HTML5 BOTH],
 :advertiserIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :name string,
 :placementStrategyId string,
 :campaignId string,
 :conversionDomainOverride
 {:conversionDomains
  [{:conversionDomainId string, :conversionDomainValue string}]},
 :createInfo {:time string},
 :videoActiveViewOptOut boolean,
 :partnerWrappingData
 {:measurementPartner [NONE INTEGRAL_AD_SCIENCE DOUBLE_VERIFY],
  :linkStatus
  [MEASUREMENT_PARTNER_UNLINKED
   MEASUREMENT_PARTNER_LINKED
   MEASUREMENT_PARTNER_LINK_PENDING
   MEASUREMENT_PARTNER_LINK_FAILURE
   MEASUREMENT_PARTNER_LINK_OPT_OUT
   MEASUREMENT_PARTNER_LINK_OPT_OUT_PENDING
   MEASUREMENT_PARTNER_LINK_WRAPPING_PENDING
   MEASUREMENT_PARTNER_MODE_CHANGE_PENDING
   MEASUREMENT_PARTNER_UNLINK_PENDING],
  :wrappedTag string,
  :tagWrappingMode
  [NONE
   BLOCKING
   MONITORING
   MONITORING_READ_ONLY
   VIDEO_PIXEL_MONITORING
   TRACKING
   VPAID_MONITORING
   VPAID_BLOCKING
   NON_VPAID_MONITORING
   VPAID_ONLY_MONITORING
   VPAID_ONLY_BLOCKING
   VPAID_ONLY_FILTERING
   VPAID_FILTERING
   NON_VPAID_FILTERING]},
 :campaignIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :size
 {:id string,
  :width integer,
  :height integer,
  :iab boolean,
  :kind string},
 :placementGroupId string,
 :tagSetting
 {:additionalKeyValues string,
  :includeClickTracking boolean,
  :includeClickThroughUrls boolean,
  :keywordOption
  [PLACEHOLDER_WITH_LIST_OF_KEYWORDS
   IGNORE
   GENERATE_SEPARATE_TAG_FOR_EACH_KEYWORD]},
 :contentCategoryId string,
 :videoSettings
 {:publisherSpecificationId string,
  :obaEnabled boolean,
  :companionSettings
  {:companionsDisabled boolean,
   :enabledSizes
   [{:id string,
     :width integer,
     :height integer,
     :iab boolean,
     :kind string}],
   :imageOnly boolean,
   :kind string},
  :obaSettings
  {:resourceUrl string,
   :xPosition string,
   :yPosition string,
   :size
   {:id string,
    :width integer,
    :height integer,
    :iab boolean,
    :kind string},
   :program string,
   :iconClickThroughUrl string,
   :iconClickTrackingUrl string,
   :iconViewTrackingUrl string},
  :skippableSettings
  {:skippable boolean,
   :skipOffset {:offsetSeconds integer, :offsetPercentage integer},
   :progressOffset {:offsetSeconds integer, :offsetPercentage integer},
   :kind string},
  :orientation [ANY LANDSCAPE PORTRAIT],
  :durationSeconds integer,
  :transcodeSettings {:enabledVideoFormats [integer], :kind string},
  :kind string},
 :activeStatus
 [PLACEMENT_STATUS_UNKNOWN
  PLACEMENT_STATUS_ACTIVE
  PLACEMENT_STATUS_INACTIVE
  PLACEMENT_STATUS_ARCHIVED
  PLACEMENT_STATUS_PERMANENTLY_ARCHIVED],
 :advertiserId string,
 :externalId string,
 :directorySiteIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :status
 [PENDING_REVIEW
  PAYMENT_ACCEPTED
  PAYMENT_REJECTED
  ACKNOWLEDGE_REJECTION
  ACKNOWLEDGE_ACCEPTANCE
  DRAFT],
 :sslRequired boolean,
 :id string,
 :siteIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :kind string,
 :comment string,
 :lookbackConfiguration
 {:clickDuration integer, :postImpressionActivitiesDuration integer},
 :lastModifiedInfo {:time string},
 :publisherUpdateInfo {:time string},
 :subaccountId string,
 :paymentApproved boolean,
 :accountId string,
 :paymentSource [PLACEMENT_AGENCY_PAID PLACEMENT_PUBLISHER_PAID]}"
  [profileId Placement]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/placements",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body Placement}))

(defn ads-get
  "Gets one ad by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Ad ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/ads/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn ads-insert
  "Inserts a new ad.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
Ad:
{:archived boolean,
 :dynamicClickTracker boolean,
 :dayPartTargeting
 {:userLocalTime boolean,
  :daysOfWeek
  [[SUNDAY MONDAY TUESDAY WEDNESDAY THURSDAY FRIDAY SATURDAY]],
  :hoursOfDay [integer]},
 :languageTargeting
 {:languages
  [{:id string, :name string, :languageCode string, :kind string}]},
 :geoTargeting
 {:excludeCountries boolean,
  :countries
  [{:dartId string,
    :name string,
    :countryCode string,
    :sslEnabled boolean,
    :kind string}],
  :regions
  [{:dartId string,
    :name string,
    :countryCode string,
    :countryDartId string,
    :regionCode string,
    :kind string}],
  :cities
  [{:name string,
    :dartId string,
    :metroCode string,
    :kind string,
    :regionCode string,
    :regionDartId string,
    :metroDmaId string,
    :countryDartId string,
    :countryCode string}],
  :metros
  [{:dmaId string,
    :dartId string,
    :name string,
    :metroCode string,
    :countryCode string,
    :countryDartId string,
    :kind string}],
  :postalCodes
  [{:id string,
    :countryCode string,
    :countryDartId string,
    :code string,
    :kind string}]},
 :idDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :clickThroughUrl
 {:defaultLandingPage boolean,
  :landingPageId string,
  :customClickThroughUrl string,
  :computedClickThroughUrl string},
 :startTime string,
 :compatibility
 [DISPLAY
  DISPLAY_INTERSTITIAL
  APP
  APP_INTERSTITIAL
  IN_STREAM_VIDEO
  IN_STREAM_AUDIO],
 :sslCompliant boolean,
 :advertiserIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :name string,
 :creativeRotation
 {:type
  [CREATIVE_ROTATION_TYPE_SEQUENTIAL CREATIVE_ROTATION_TYPE_RANDOM],
  :weightCalculationStrategy
  [WEIGHT_STRATEGY_EQUAL
   WEIGHT_STRATEGY_CUSTOM
   WEIGHT_STRATEGY_HIGHEST_CTR
   WEIGHT_STRATEGY_OPTIMIZED],
  :creativeOptimizationConfigurationId string,
  :creativeAssignments
  [{:clickThroughUrl
    {:defaultLandingPage boolean,
     :landingPageId string,
     :customClickThroughUrl string,
     :computedClickThroughUrl string},
    :companionCreativeOverrides
    [{:creativeId string,
      :clickThroughUrl
      {:defaultLandingPage boolean,
       :landingPageId string,
       :customClickThroughUrl string,
       :computedClickThroughUrl string}}],
    :startTime string,
    :sslCompliant boolean,
    :endTime string,
    :applyEventTags boolean,
    :creativeIdDimensionValue
    {:dimensionName string,
     :value string,
     :id string,
     :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
     :kind string,
     :etag string},
    :creativeId string,
    :weight integer,
    :active boolean,
    :sequence integer,
    :creativeGroupAssignments
    [{:creativeGroupId string,
      :creativeGroupNumber [CREATIVE_GROUP_ONE CREATIVE_GROUP_TWO]}],
    :richMediaExitOverrides
    [{:exitId string,
      :enabled boolean,
      :clickThroughUrl
      {:defaultLandingPage boolean,
       :landingPageId string,
       :customClickThroughUrl string,
       :computedClickThroughUrl string}}]}]},
 :campaignId string,
 :comments string,
 :endTime string,
 :type
 [AD_SERVING_STANDARD_AD
  AD_SERVING_DEFAULT_AD
  AD_SERVING_CLICK_TRACKER
  AD_SERVING_TRACKING
  AD_SERVING_BRAND_SAFE_AD],
 :createInfo {:time string},
 :audienceSegmentId string,
 :eventTagOverrides [{:id string, :enabled boolean}],
 :remarketingListExpression {:expression string},
 :campaignIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :defaultClickThroughEventTagProperties
 {:overrideInheritedEventTag boolean,
  :defaultClickThroughEventTagId string},
 :size
 {:id string,
  :width integer,
  :height integer,
  :iab boolean,
  :kind string},
 :clickThroughUrlSuffixProperties
 {:overrideInheritedSuffix boolean, :clickThroughUrlSuffix string},
 :advertiserId string,
 :keyValueTargetingExpression {:expression string},
 :technologyTargeting
 {:operatingSystems
  [{:dartId string,
    :name string,
    :desktop boolean,
    :mobile boolean,
    :kind string}],
  :browsers
  [{:browserVersionId string,
    :dartId string,
    :name string,
    :majorVersion string,
    :minorVersion string,
    :kind string}],
  :platformTypes [{:id string, :name string, :kind string}],
  :mobileCarriers
  [{:id string,
    :name string,
    :countryCode string,
    :countryDartId string,
    :kind string}],
  :connectionTypes [{:id string, :name string, :kind string}],
  :operatingSystemVersions
  [{:id string,
    :name string,
    :operatingSystem
    {:dartId string,
     :name string,
     :desktop boolean,
     :mobile boolean,
     :kind string},
    :majorVersion string,
    :minorVersion string,
    :kind string}]},
 :sslRequired boolean,
 :active boolean,
 :id string,
 :kind string,
 :deliverySchedule
 {:hardCutoff boolean,
  :priority
  [AD_PRIORITY_01
   AD_PRIORITY_02
   AD_PRIORITY_03
   AD_PRIORITY_04
   AD_PRIORITY_05
   AD_PRIORITY_06
   AD_PRIORITY_07
   AD_PRIORITY_08
   AD_PRIORITY_09
   AD_PRIORITY_10
   AD_PRIORITY_11
   AD_PRIORITY_12
   AD_PRIORITY_13
   AD_PRIORITY_14
   AD_PRIORITY_15
   AD_PRIORITY_16],
  :impressionRatio string,
  :frequencyCap {:impressions string, :duration string}},
 :creativeGroupAssignments
 [{:creativeGroupId string,
   :creativeGroupNumber [CREATIVE_GROUP_ONE CREATIVE_GROUP_TWO]}],
 :placementAssignments
 [{:placementId string,
   :active boolean,
   :sslRequired boolean,
   :placementIdDimensionValue
   {:dimensionName string,
    :value string,
    :id string,
    :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
    :kind string,
    :etag string}}],
 :lastModifiedInfo {:time string},
 :subaccountId string,
 :accountId string,
 :targetingTemplateId string}"
  [profileId Ad]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/ads",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body Ad}))

(defn ads-list
  "Retrieves a list of ads, possibly filtered. This method supports paging.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.

optional:
archived <boolean> Select only archived ads.
dynamicClickTracker <boolean> Select only dynamic click trackers. Applicable when type is AD_SERVING_CLICK_TRACKER. If true, select dynamic click trackers. If false, select static click trackers. Leave unset to select both.
creativeOptimizationConfigurationIds <string> Select only ads with these creative optimization configuration IDs.
compatibility <string> Select default ads with the specified compatibility. Applicable when type is AD_SERVING_DEFAULT_AD. DISPLAY and DISPLAY_INTERSTITIAL refer to rendering either on desktop or on mobile devices for regular or interstitial ads, respectively. APP and APP_INTERSTITIAL are for rendering in mobile apps. IN_STREAM_VIDEO refers to rendering an in-stream video ads developed with the VAST standard.
overriddenEventTagId <string> Select only ads with this event tag override ID.
sslCompliant <boolean> Select only ads that are SSL-compliant.
campaignIds <string> Select only ads with these campaign IDs.
audienceSegmentIds <string> Select only ads with these audience segment IDs.
ids <string> Select only ads with these IDs.
type <string> Select only ads with these types.
searchString <string> Allows searching for objects by name or ID. Wildcards (*) are allowed. For example, \"ad*2015\" will return objects with names like \"ad June 2015\", \"ad April 2015\", or simply \"ad 2015\". Most of the searches also add wildcards implicitly at the start and the end of the search string. For example, a search string of \"ad\" will match objects with name \"my ad\", \"ad 2015\", or simply \"ad\".
remarketingListIds <string> Select only ads whose list targeting expression use these remarketing list IDs.
sortField <string> Field by which to sort the list.
creativeIds <string> Select only ads with these creative IDs assigned.
advertiserId <string> Select only ads with this advertiser ID.
sslRequired <boolean> Select only ads that require SSL.
active <boolean> Select only active ads.
sortOrder <string> Order of sorted results.
placementIds <string> Select only ads with these placement IDs assigned.
sizeIds <string> Select only ads with these size IDs.
landingPageIds <string> Select only ads with these landing page IDs.
maxResults <integer> Maximum number of results to return."
  ([profileId] (ads-list profileId nil))
  ([profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/ads",
       :uri-template-args {:profileId profileId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn ads-update
  "Updates an existing ad.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
Ad:
{:archived boolean,
 :dynamicClickTracker boolean,
 :dayPartTargeting
 {:userLocalTime boolean,
  :daysOfWeek
  [[SUNDAY MONDAY TUESDAY WEDNESDAY THURSDAY FRIDAY SATURDAY]],
  :hoursOfDay [integer]},
 :languageTargeting
 {:languages
  [{:id string, :name string, :languageCode string, :kind string}]},
 :geoTargeting
 {:excludeCountries boolean,
  :countries
  [{:dartId string,
    :name string,
    :countryCode string,
    :sslEnabled boolean,
    :kind string}],
  :regions
  [{:dartId string,
    :name string,
    :countryCode string,
    :countryDartId string,
    :regionCode string,
    :kind string}],
  :cities
  [{:name string,
    :dartId string,
    :metroCode string,
    :kind string,
    :regionCode string,
    :regionDartId string,
    :metroDmaId string,
    :countryDartId string,
    :countryCode string}],
  :metros
  [{:dmaId string,
    :dartId string,
    :name string,
    :metroCode string,
    :countryCode string,
    :countryDartId string,
    :kind string}],
  :postalCodes
  [{:id string,
    :countryCode string,
    :countryDartId string,
    :code string,
    :kind string}]},
 :idDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :clickThroughUrl
 {:defaultLandingPage boolean,
  :landingPageId string,
  :customClickThroughUrl string,
  :computedClickThroughUrl string},
 :startTime string,
 :compatibility
 [DISPLAY
  DISPLAY_INTERSTITIAL
  APP
  APP_INTERSTITIAL
  IN_STREAM_VIDEO
  IN_STREAM_AUDIO],
 :sslCompliant boolean,
 :advertiserIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :name string,
 :creativeRotation
 {:type
  [CREATIVE_ROTATION_TYPE_SEQUENTIAL CREATIVE_ROTATION_TYPE_RANDOM],
  :weightCalculationStrategy
  [WEIGHT_STRATEGY_EQUAL
   WEIGHT_STRATEGY_CUSTOM
   WEIGHT_STRATEGY_HIGHEST_CTR
   WEIGHT_STRATEGY_OPTIMIZED],
  :creativeOptimizationConfigurationId string,
  :creativeAssignments
  [{:clickThroughUrl
    {:defaultLandingPage boolean,
     :landingPageId string,
     :customClickThroughUrl string,
     :computedClickThroughUrl string},
    :companionCreativeOverrides
    [{:creativeId string,
      :clickThroughUrl
      {:defaultLandingPage boolean,
       :landingPageId string,
       :customClickThroughUrl string,
       :computedClickThroughUrl string}}],
    :startTime string,
    :sslCompliant boolean,
    :endTime string,
    :applyEventTags boolean,
    :creativeIdDimensionValue
    {:dimensionName string,
     :value string,
     :id string,
     :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
     :kind string,
     :etag string},
    :creativeId string,
    :weight integer,
    :active boolean,
    :sequence integer,
    :creativeGroupAssignments
    [{:creativeGroupId string,
      :creativeGroupNumber [CREATIVE_GROUP_ONE CREATIVE_GROUP_TWO]}],
    :richMediaExitOverrides
    [{:exitId string,
      :enabled boolean,
      :clickThroughUrl
      {:defaultLandingPage boolean,
       :landingPageId string,
       :customClickThroughUrl string,
       :computedClickThroughUrl string}}]}]},
 :campaignId string,
 :comments string,
 :endTime string,
 :type
 [AD_SERVING_STANDARD_AD
  AD_SERVING_DEFAULT_AD
  AD_SERVING_CLICK_TRACKER
  AD_SERVING_TRACKING
  AD_SERVING_BRAND_SAFE_AD],
 :createInfo {:time string},
 :audienceSegmentId string,
 :eventTagOverrides [{:id string, :enabled boolean}],
 :remarketingListExpression {:expression string},
 :campaignIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :defaultClickThroughEventTagProperties
 {:overrideInheritedEventTag boolean,
  :defaultClickThroughEventTagId string},
 :size
 {:id string,
  :width integer,
  :height integer,
  :iab boolean,
  :kind string},
 :clickThroughUrlSuffixProperties
 {:overrideInheritedSuffix boolean, :clickThroughUrlSuffix string},
 :advertiserId string,
 :keyValueTargetingExpression {:expression string},
 :technologyTargeting
 {:operatingSystems
  [{:dartId string,
    :name string,
    :desktop boolean,
    :mobile boolean,
    :kind string}],
  :browsers
  [{:browserVersionId string,
    :dartId string,
    :name string,
    :majorVersion string,
    :minorVersion string,
    :kind string}],
  :platformTypes [{:id string, :name string, :kind string}],
  :mobileCarriers
  [{:id string,
    :name string,
    :countryCode string,
    :countryDartId string,
    :kind string}],
  :connectionTypes [{:id string, :name string, :kind string}],
  :operatingSystemVersions
  [{:id string,
    :name string,
    :operatingSystem
    {:dartId string,
     :name string,
     :desktop boolean,
     :mobile boolean,
     :kind string},
    :majorVersion string,
    :minorVersion string,
    :kind string}]},
 :sslRequired boolean,
 :active boolean,
 :id string,
 :kind string,
 :deliverySchedule
 {:hardCutoff boolean,
  :priority
  [AD_PRIORITY_01
   AD_PRIORITY_02
   AD_PRIORITY_03
   AD_PRIORITY_04
   AD_PRIORITY_05
   AD_PRIORITY_06
   AD_PRIORITY_07
   AD_PRIORITY_08
   AD_PRIORITY_09
   AD_PRIORITY_10
   AD_PRIORITY_11
   AD_PRIORITY_12
   AD_PRIORITY_13
   AD_PRIORITY_14
   AD_PRIORITY_15
   AD_PRIORITY_16],
  :impressionRatio string,
  :frequencyCap {:impressions string, :duration string}},
 :creativeGroupAssignments
 [{:creativeGroupId string,
   :creativeGroupNumber [CREATIVE_GROUP_ONE CREATIVE_GROUP_TWO]}],
 :placementAssignments
 [{:placementId string,
   :active boolean,
   :sslRequired boolean,
   :placementIdDimensionValue
   {:dimensionName string,
    :value string,
    :id string,
    :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
    :kind string,
    :etag string}}],
 :lastModifiedInfo {:time string},
 :subaccountId string,
 :accountId string,
 :targetingTemplateId string}"
  [profileId Ad]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/ads",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body Ad}))

(defn ads-patch
  "Updates an existing ad. This method supports patch semantics.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Required. RemarketingList ID.
Ad:
{:archived boolean,
 :dynamicClickTracker boolean,
 :dayPartTargeting
 {:userLocalTime boolean,
  :daysOfWeek
  [[SUNDAY MONDAY TUESDAY WEDNESDAY THURSDAY FRIDAY SATURDAY]],
  :hoursOfDay [integer]},
 :languageTargeting
 {:languages
  [{:id string, :name string, :languageCode string, :kind string}]},
 :geoTargeting
 {:excludeCountries boolean,
  :countries
  [{:dartId string,
    :name string,
    :countryCode string,
    :sslEnabled boolean,
    :kind string}],
  :regions
  [{:dartId string,
    :name string,
    :countryCode string,
    :countryDartId string,
    :regionCode string,
    :kind string}],
  :cities
  [{:name string,
    :dartId string,
    :metroCode string,
    :kind string,
    :regionCode string,
    :regionDartId string,
    :metroDmaId string,
    :countryDartId string,
    :countryCode string}],
  :metros
  [{:dmaId string,
    :dartId string,
    :name string,
    :metroCode string,
    :countryCode string,
    :countryDartId string,
    :kind string}],
  :postalCodes
  [{:id string,
    :countryCode string,
    :countryDartId string,
    :code string,
    :kind string}]},
 :idDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :clickThroughUrl
 {:defaultLandingPage boolean,
  :landingPageId string,
  :customClickThroughUrl string,
  :computedClickThroughUrl string},
 :startTime string,
 :compatibility
 [DISPLAY
  DISPLAY_INTERSTITIAL
  APP
  APP_INTERSTITIAL
  IN_STREAM_VIDEO
  IN_STREAM_AUDIO],
 :sslCompliant boolean,
 :advertiserIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :name string,
 :creativeRotation
 {:type
  [CREATIVE_ROTATION_TYPE_SEQUENTIAL CREATIVE_ROTATION_TYPE_RANDOM],
  :weightCalculationStrategy
  [WEIGHT_STRATEGY_EQUAL
   WEIGHT_STRATEGY_CUSTOM
   WEIGHT_STRATEGY_HIGHEST_CTR
   WEIGHT_STRATEGY_OPTIMIZED],
  :creativeOptimizationConfigurationId string,
  :creativeAssignments
  [{:clickThroughUrl
    {:defaultLandingPage boolean,
     :landingPageId string,
     :customClickThroughUrl string,
     :computedClickThroughUrl string},
    :companionCreativeOverrides
    [{:creativeId string,
      :clickThroughUrl
      {:defaultLandingPage boolean,
       :landingPageId string,
       :customClickThroughUrl string,
       :computedClickThroughUrl string}}],
    :startTime string,
    :sslCompliant boolean,
    :endTime string,
    :applyEventTags boolean,
    :creativeIdDimensionValue
    {:dimensionName string,
     :value string,
     :id string,
     :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
     :kind string,
     :etag string},
    :creativeId string,
    :weight integer,
    :active boolean,
    :sequence integer,
    :creativeGroupAssignments
    [{:creativeGroupId string,
      :creativeGroupNumber [CREATIVE_GROUP_ONE CREATIVE_GROUP_TWO]}],
    :richMediaExitOverrides
    [{:exitId string,
      :enabled boolean,
      :clickThroughUrl
      {:defaultLandingPage boolean,
       :landingPageId string,
       :customClickThroughUrl string,
       :computedClickThroughUrl string}}]}]},
 :campaignId string,
 :comments string,
 :endTime string,
 :type
 [AD_SERVING_STANDARD_AD
  AD_SERVING_DEFAULT_AD
  AD_SERVING_CLICK_TRACKER
  AD_SERVING_TRACKING
  AD_SERVING_BRAND_SAFE_AD],
 :createInfo {:time string},
 :audienceSegmentId string,
 :eventTagOverrides [{:id string, :enabled boolean}],
 :remarketingListExpression {:expression string},
 :campaignIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :defaultClickThroughEventTagProperties
 {:overrideInheritedEventTag boolean,
  :defaultClickThroughEventTagId string},
 :size
 {:id string,
  :width integer,
  :height integer,
  :iab boolean,
  :kind string},
 :clickThroughUrlSuffixProperties
 {:overrideInheritedSuffix boolean, :clickThroughUrlSuffix string},
 :advertiserId string,
 :keyValueTargetingExpression {:expression string},
 :technologyTargeting
 {:operatingSystems
  [{:dartId string,
    :name string,
    :desktop boolean,
    :mobile boolean,
    :kind string}],
  :browsers
  [{:browserVersionId string,
    :dartId string,
    :name string,
    :majorVersion string,
    :minorVersion string,
    :kind string}],
  :platformTypes [{:id string, :name string, :kind string}],
  :mobileCarriers
  [{:id string,
    :name string,
    :countryCode string,
    :countryDartId string,
    :kind string}],
  :connectionTypes [{:id string, :name string, :kind string}],
  :operatingSystemVersions
  [{:id string,
    :name string,
    :operatingSystem
    {:dartId string,
     :name string,
     :desktop boolean,
     :mobile boolean,
     :kind string},
    :majorVersion string,
    :minorVersion string,
    :kind string}]},
 :sslRequired boolean,
 :active boolean,
 :id string,
 :kind string,
 :deliverySchedule
 {:hardCutoff boolean,
  :priority
  [AD_PRIORITY_01
   AD_PRIORITY_02
   AD_PRIORITY_03
   AD_PRIORITY_04
   AD_PRIORITY_05
   AD_PRIORITY_06
   AD_PRIORITY_07
   AD_PRIORITY_08
   AD_PRIORITY_09
   AD_PRIORITY_10
   AD_PRIORITY_11
   AD_PRIORITY_12
   AD_PRIORITY_13
   AD_PRIORITY_14
   AD_PRIORITY_15
   AD_PRIORITY_16],
  :impressionRatio string,
  :frequencyCap {:impressions string, :duration string}},
 :creativeGroupAssignments
 [{:creativeGroupId string,
   :creativeGroupNumber [CREATIVE_GROUP_ONE CREATIVE_GROUP_TWO]}],
 :placementAssignments
 [{:placementId string,
   :active boolean,
   :sslRequired boolean,
   :placementIdDimensionValue
   {:dimensionName string,
    :value string,
    :id string,
    :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
    :kind string,
    :etag string}}],
 :lastModifiedInfo {:time string},
 :subaccountId string,
 :accountId string,
 :targetingTemplateId string}"
  [profileId id Ad]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/ads",
     :uri-template-args {:profileId profileId},
     :query-params {:id id},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body Ad}))

(defn changeLogs-get
  "Gets one change log by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Change log ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/changeLogs/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn changeLogs-list
  "Retrieves a list of change logs. This method supports paging.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.

optional:
userProfileIds <string> Select only change logs with these user profile IDs.
ids <string> Select only change logs with these IDs.
searchString <string> Select only change logs whose object ID, user name, old or new values match the search string.
objectIds <string> Select only change logs with these object IDs.
objectType <string> Select only change logs with the specified object type.
minChangeTime <string> Select only change logs whose change time is after the specified minChangeTime.The time should be formatted as an RFC3339 date/time string. For example, for 10:54 PM on July 18th, 2015, in the America/New York time zone, the format is \"2015-07-18T22:54:00-04:00\". In other words, the year, month, day, the letter T, the hour (24-hour clock system), minute, second, and then the time zone offset.
maxChangeTime <string> Select only change logs whose change time is before the specified maxChangeTime.The time should be formatted as an RFC3339 date/time string. For example, for 10:54 PM on July 18th, 2015, in the America/New York time zone, the format is \"2015-07-18T22:54:00-04:00\". In other words, the year, month, day, the letter T, the hour (24-hour clock system), minute, second, and then the time zone offset.
action <string> Select only change logs with the specified action.
maxResults <integer> Maximum number of results to return."
  ([profileId] (changeLogs-list profileId nil))
  ([profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/changeLogs",
       :uri-template-args {:profileId profileId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn targetableRemarketingLists-get
  "Gets one remarketing list by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Remarketing list ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/targetableRemarketingLists/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn targetableRemarketingLists-list
  "Retrieves a list of targetable remarketing lists, possibly filtered. This method supports paging.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
advertiserId <string> Required. Select only targetable remarketing lists targetable by these advertisers.

optional:
active <boolean> Select only active or only inactive targetable remarketing lists.
maxResults <integer> Maximum number of results to return.
name <string> Allows searching for objects by name or ID. Wildcards (*) are allowed. For example, \"remarketing list*2015\" will return objects with names like \"remarketing list June 2015\", \"remarketing list April 2015\", or simply \"remarketing list 2015\". Most of the searches also add wildcards implicitly at the start and the end of the search string. For example, a search string of \"remarketing list\" will match objects with name \"my remarketing list\", \"remarketing list 2015\", or simply \"remarketing list\".
sortField <string> Field by which to sort the list.
sortOrder <string> Order of sorted results."
  ([profileId advertiserId]
    (targetableRemarketingLists-list profileId advertiserId nil))
  ([profileId advertiserId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/targetableRemarketingLists",
       :uri-template-args {:profileId profileId},
       :query-params (merge {:advertiserId advertiserId} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn targetingTemplates-patch
  "Updates an existing targeting template. This method supports patch semantics.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Required. RemarketingList ID.
TargetingTemplate:
{:dayPartTargeting
 {:userLocalTime boolean,
  :daysOfWeek
  [[SUNDAY MONDAY TUESDAY WEDNESDAY THURSDAY FRIDAY SATURDAY]],
  :hoursOfDay [integer]},
 :languageTargeting
 {:languages
  [{:id string, :name string, :languageCode string, :kind string}]},
 :geoTargeting
 {:excludeCountries boolean,
  :countries
  [{:dartId string,
    :name string,
    :countryCode string,
    :sslEnabled boolean,
    :kind string}],
  :regions
  [{:dartId string,
    :name string,
    :countryCode string,
    :countryDartId string,
    :regionCode string,
    :kind string}],
  :cities
  [{:name string,
    :dartId string,
    :metroCode string,
    :kind string,
    :regionCode string,
    :regionDartId string,
    :metroDmaId string,
    :countryDartId string,
    :countryCode string}],
  :metros
  [{:dmaId string,
    :dartId string,
    :name string,
    :metroCode string,
    :countryCode string,
    :countryDartId string,
    :kind string}],
  :postalCodes
  [{:id string,
    :countryCode string,
    :countryDartId string,
    :code string,
    :kind string}]},
 :advertiserIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :name string,
 :advertiserId string,
 :keyValueTargetingExpression {:expression string},
 :technologyTargeting
 {:operatingSystems
  [{:dartId string,
    :name string,
    :desktop boolean,
    :mobile boolean,
    :kind string}],
  :browsers
  [{:browserVersionId string,
    :dartId string,
    :name string,
    :majorVersion string,
    :minorVersion string,
    :kind string}],
  :platformTypes [{:id string, :name string, :kind string}],
  :mobileCarriers
  [{:id string,
    :name string,
    :countryCode string,
    :countryDartId string,
    :kind string}],
  :connectionTypes [{:id string, :name string, :kind string}],
  :operatingSystemVersions
  [{:id string,
    :name string,
    :operatingSystem
    {:dartId string,
     :name string,
     :desktop boolean,
     :mobile boolean,
     :kind string},
    :majorVersion string,
    :minorVersion string,
    :kind string}]},
 :id string,
 :kind string,
 :listTargetingExpression {:expression string},
 :subaccountId string,
 :accountId string}"
  [profileId id TargetingTemplate]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/targetingTemplates",
     :uri-template-args {:profileId profileId},
     :query-params {:id id},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body TargetingTemplate}))

(defn targetingTemplates-get
  "Gets one targeting template by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Targeting template ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/targetingTemplates/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn targetingTemplates-insert
  "Inserts a new targeting template.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
TargetingTemplate:
{:dayPartTargeting
 {:userLocalTime boolean,
  :daysOfWeek
  [[SUNDAY MONDAY TUESDAY WEDNESDAY THURSDAY FRIDAY SATURDAY]],
  :hoursOfDay [integer]},
 :languageTargeting
 {:languages
  [{:id string, :name string, :languageCode string, :kind string}]},
 :geoTargeting
 {:excludeCountries boolean,
  :countries
  [{:dartId string,
    :name string,
    :countryCode string,
    :sslEnabled boolean,
    :kind string}],
  :regions
  [{:dartId string,
    :name string,
    :countryCode string,
    :countryDartId string,
    :regionCode string,
    :kind string}],
  :cities
  [{:name string,
    :dartId string,
    :metroCode string,
    :kind string,
    :regionCode string,
    :regionDartId string,
    :metroDmaId string,
    :countryDartId string,
    :countryCode string}],
  :metros
  [{:dmaId string,
    :dartId string,
    :name string,
    :metroCode string,
    :countryCode string,
    :countryDartId string,
    :kind string}],
  :postalCodes
  [{:id string,
    :countryCode string,
    :countryDartId string,
    :code string,
    :kind string}]},
 :advertiserIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :name string,
 :advertiserId string,
 :keyValueTargetingExpression {:expression string},
 :technologyTargeting
 {:operatingSystems
  [{:dartId string,
    :name string,
    :desktop boolean,
    :mobile boolean,
    :kind string}],
  :browsers
  [{:browserVersionId string,
    :dartId string,
    :name string,
    :majorVersion string,
    :minorVersion string,
    :kind string}],
  :platformTypes [{:id string, :name string, :kind string}],
  :mobileCarriers
  [{:id string,
    :name string,
    :countryCode string,
    :countryDartId string,
    :kind string}],
  :connectionTypes [{:id string, :name string, :kind string}],
  :operatingSystemVersions
  [{:id string,
    :name string,
    :operatingSystem
    {:dartId string,
     :name string,
     :desktop boolean,
     :mobile boolean,
     :kind string},
    :majorVersion string,
    :minorVersion string,
    :kind string}]},
 :id string,
 :kind string,
 :listTargetingExpression {:expression string},
 :subaccountId string,
 :accountId string}"
  [profileId TargetingTemplate]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/targetingTemplates",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body TargetingTemplate}))

(defn targetingTemplates-list
  "Retrieves a list of targeting templates, optionally filtered. This method supports paging.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.

optional:
ids <string> Select only targeting templates with these IDs.
searchString <string> Allows searching for objects by name or ID. Wildcards (*) are allowed. For example, \"template*2015\" will return objects with names like \"template June 2015\", \"template April 2015\", or simply \"template 2015\". Most of the searches also add wildcards implicitly at the start and the end of the search string. For example, a search string of \"template\" will match objects with name \"my template\", \"template 2015\", or simply \"template\".
advertiserId <string> Select only targeting templates with this advertiser ID.
maxResults <integer> Maximum number of results to return.
sortField <string> Field by which to sort the list.
sortOrder <string> Order of sorted results."
  ([profileId] (targetingTemplates-list profileId nil))
  ([profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/targetingTemplates",
       :uri-template-args {:profileId profileId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn targetingTemplates-update
  "Updates an existing targeting template.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
TargetingTemplate:
{:dayPartTargeting
 {:userLocalTime boolean,
  :daysOfWeek
  [[SUNDAY MONDAY TUESDAY WEDNESDAY THURSDAY FRIDAY SATURDAY]],
  :hoursOfDay [integer]},
 :languageTargeting
 {:languages
  [{:id string, :name string, :languageCode string, :kind string}]},
 :geoTargeting
 {:excludeCountries boolean,
  :countries
  [{:dartId string,
    :name string,
    :countryCode string,
    :sslEnabled boolean,
    :kind string}],
  :regions
  [{:dartId string,
    :name string,
    :countryCode string,
    :countryDartId string,
    :regionCode string,
    :kind string}],
  :cities
  [{:name string,
    :dartId string,
    :metroCode string,
    :kind string,
    :regionCode string,
    :regionDartId string,
    :metroDmaId string,
    :countryDartId string,
    :countryCode string}],
  :metros
  [{:dmaId string,
    :dartId string,
    :name string,
    :metroCode string,
    :countryCode string,
    :countryDartId string,
    :kind string}],
  :postalCodes
  [{:id string,
    :countryCode string,
    :countryDartId string,
    :code string,
    :kind string}]},
 :advertiserIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :name string,
 :advertiserId string,
 :keyValueTargetingExpression {:expression string},
 :technologyTargeting
 {:operatingSystems
  [{:dartId string,
    :name string,
    :desktop boolean,
    :mobile boolean,
    :kind string}],
  :browsers
  [{:browserVersionId string,
    :dartId string,
    :name string,
    :majorVersion string,
    :minorVersion string,
    :kind string}],
  :platformTypes [{:id string, :name string, :kind string}],
  :mobileCarriers
  [{:id string,
    :name string,
    :countryCode string,
    :countryDartId string,
    :kind string}],
  :connectionTypes [{:id string, :name string, :kind string}],
  :operatingSystemVersions
  [{:id string,
    :name string,
    :operatingSystem
    {:dartId string,
     :name string,
     :desktop boolean,
     :mobile boolean,
     :kind string},
    :majorVersion string,
    :minorVersion string,
    :kind string}]},
 :id string,
 :kind string,
 :listTargetingExpression {:expression string},
 :subaccountId string,
 :accountId string}"
  [profileId TargetingTemplate]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/targetingTemplates",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body TargetingTemplate}))

(defn creativeAssets-insert
  "Inserts a new creative asset.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
advertiserId <string> Advertiser ID of this creative. This is a required field.
CreativeAssetMetadata:
{:counterCustomEvents
 [{:advertiserCustomEventName string,
   :popupWindowProperties
   {:offset {:top integer, :left integer},
    :positionType [CENTER COORDINATES],
    :showMenuBar boolean,
    :showToolBar boolean,
    :title string,
    :showStatusBar boolean,
    :showAddressBar boolean,
    :dimension
    {:id string,
     :width integer,
     :height integer,
     :iab boolean,
     :kind string},
    :showScrollBar boolean},
   :artworkType
   [ARTWORK_TYPE_FLASH
    ARTWORK_TYPE_HTML5
    ARTWORK_TYPE_MIXED
    ARTWORK_TYPE_IMAGE],
   :artworkLabel string,
   :videoReportingId string,
   :advertiserCustomEventId string,
   :id string,
   :targetType
   [TARGET_BLANK TARGET_TOP TARGET_SELF TARGET_PARENT TARGET_POPUP],
   :exitClickThroughUrl
   {:landingPageId string,
    :customClickThroughUrl string,
    :computedClickThroughUrl string},
   :advertiserCustomEventType
   [ADVERTISER_EVENT_TIMER
    ADVERTISER_EVENT_EXIT
    ADVERTISER_EVENT_COUNTER]}],
 :richMedia boolean,
 :idDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :timerCustomEvents
 [{:advertiserCustomEventName string,
   :popupWindowProperties
   {:offset {:top integer, :left integer},
    :positionType [CENTER COORDINATES],
    :showMenuBar boolean,
    :showToolBar boolean,
    :title string,
    :showStatusBar boolean,
    :showAddressBar boolean,
    :dimension
    {:id string,
     :width integer,
     :height integer,
     :iab boolean,
     :kind string},
    :showScrollBar boolean},
   :artworkType
   [ARTWORK_TYPE_FLASH
    ARTWORK_TYPE_HTML5
    ARTWORK_TYPE_MIXED
    ARTWORK_TYPE_IMAGE],
   :artworkLabel string,
   :videoReportingId string,
   :advertiserCustomEventId string,
   :id string,
   :targetType
   [TARGET_BLANK TARGET_TOP TARGET_SELF TARGET_PARENT TARGET_POPUP],
   :exitClickThroughUrl
   {:landingPageId string,
    :customClickThroughUrl string,
    :computedClickThroughUrl string},
   :advertiserCustomEventType
   [ADVERTISER_EVENT_TIMER
    ADVERTISER_EVENT_EXIT
    ADVERTISER_EVENT_COUNTER]}],
 :detectedFeatures
 [[CSS_FONT_FACE
   CSS_BACKGROUND_SIZE
   CSS_BORDER_IMAGE
   CSS_BORDER_RADIUS
   CSS_BOX_SHADOW
   CSS_FLEX_BOX
   CSS_HSLA
   CSS_MULTIPLE_BGS
   CSS_OPACITY
   CSS_RGBA
   CSS_TEXT_SHADOW
   CSS_ANIMATIONS
   CSS_COLUMNS
   CSS_GENERATED_CONTENT
   CSS_GRADIENTS
   CSS_REFLECTIONS
   CSS_TRANSFORMS
   CSS_TRANSFORMS3D
   CSS_TRANSITIONS
   APPLICATION_CACHE
   CANVAS
   CANVAS_TEXT
   DRAG_AND_DROP
   HASH_CHANGE
   HISTORY
   AUDIO
   VIDEO
   INDEXED_DB
   INPUT_ATTR_AUTOCOMPLETE
   INPUT_ATTR_AUTOFOCUS
   INPUT_ATTR_LIST
   INPUT_ATTR_PLACEHOLDER
   INPUT_ATTR_MAX
   INPUT_ATTR_MIN
   INPUT_ATTR_MULTIPLE
   INPUT_ATTR_PATTERN
   INPUT_ATTR_REQUIRED
   INPUT_ATTR_STEP
   INPUT_TYPE_SEARCH
   INPUT_TYPE_TEL
   INPUT_TYPE_URL
   INPUT_TYPE_EMAIL
   INPUT_TYPE_DATETIME
   INPUT_TYPE_DATE
   INPUT_TYPE_MONTH
   INPUT_TYPE_WEEK
   INPUT_TYPE_TIME
   INPUT_TYPE_DATETIME_LOCAL
   INPUT_TYPE_NUMBER
   INPUT_TYPE_RANGE
   INPUT_TYPE_COLOR
   LOCAL_STORAGE
   POST_MESSAGE
   SESSION_STORAGE
   WEB_SOCKETS
   WEB_SQL_DATABASE
   WEB_WORKERS
   GEO_LOCATION
   INLINE_SVG
   SMIL
   SVG_HREF
   SVG_CLIP_PATHS
   TOUCH
   WEBGL
   SVG_FILTERS
   SVG_FE_IMAGE]],
 :exitCustomEvents
 [{:advertiserCustomEventName string,
   :popupWindowProperties
   {:offset {:top integer, :left integer},
    :positionType [CENTER COORDINATES],
    :showMenuBar boolean,
    :showToolBar boolean,
    :title string,
    :showStatusBar boolean,
    :showAddressBar boolean,
    :dimension
    {:id string,
     :width integer,
     :height integer,
     :iab boolean,
     :kind string},
    :showScrollBar boolean},
   :artworkType
   [ARTWORK_TYPE_FLASH
    ARTWORK_TYPE_HTML5
    ARTWORK_TYPE_MIXED
    ARTWORK_TYPE_IMAGE],
   :artworkLabel string,
   :videoReportingId string,
   :advertiserCustomEventId string,
   :id string,
   :targetType
   [TARGET_BLANK TARGET_TOP TARGET_SELF TARGET_PARENT TARGET_POPUP],
   :exitClickThroughUrl
   {:landingPageId string,
    :customClickThroughUrl string,
    :computedClickThroughUrl string},
   :advertiserCustomEventType
   [ADVERTISER_EVENT_TIMER
    ADVERTISER_EVENT_EXIT
    ADVERTISER_EVENT_COUNTER]}],
 :warnedValidationRules
 [[CLICK_TAG_NON_TOP_LEVEL
   CLICK_TAG_MISSING
   CLICK_TAG_MORE_THAN_ONE
   CLICK_TAG_INVALID
   ORPHANED_ASSET
   PRIMARY_HTML_MISSING
   EXTERNAL_FILE_REFERENCED
   MRAID_REFERENCED
   ADMOB_REFERENCED
   FILE_TYPE_INVALID
   ZIP_INVALID
   LINKED_FILE_NOT_FOUND
   MAX_FLASH_VERSION_11
   NOT_SSL_COMPLIANT
   FILE_DETAIL_EMPTY
   ASSET_INVALID
   GWD_PROPERTIES_INVALID
   ENABLER_UNSUPPORTED_METHOD_DCM
   ASSET_FORMAT_UNSUPPORTED_DCM
   COMPONENT_UNSUPPORTED_DCM
   HTML5_FEATURE_UNSUPPORTED
   CLICK_TAG_IN_GWD
   CLICK_TAG_HARD_CODED
   SVG_INVALID
   CLICK_TAG_IN_RICH_MEDIA
   MISSING_ENABLER_REFERENCE]],
 :id string,
 :kind string,
 :clickTags
 [{:name string,
   :eventName string,
   :clickThroughUrl
   {:landingPageId string,
    :customClickThroughUrl string,
    :computedClickThroughUrl string}}],
 :assetIdentifier
 {:type [IMAGE FLASH VIDEO HTML HTML_IMAGE AUDIO], :name string}}"
  [profileId advertiserId CreativeAssetMetadata]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/creativeAssets/{+advertiserId}/creativeAssets",
     :uri-template-args
     {:profileId profileId, :advertiserId advertiserId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body CreativeAssetMetadata}))

(defn inventoryItems-get
  "Gets one inventory item by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
projectId <string> Project ID for order documents.
id <string> Inventory item ID."
  [profileId projectId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/projects/{projectId}/inventoryItems/{+id}",
     :uri-template-args
     {:profileId profileId, :projectId projectId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn inventoryItems-list
  "Retrieves a list of inventory items, possibly filtered. This method supports paging.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
projectId <string> Project ID for order documents.

optional:
siteId <string> Select only inventory items that are associated with these sites.
inPlan <boolean> Select only inventory items that are in plan.
ids <string> Select only inventory items with these IDs.
type <string> Select only inventory items with this type.
sortField <string> Field by which to sort the list.
sortOrder <string> Order of sorted results.
maxResults <integer> Maximum number of results to return.
orderId <string> Select only inventory items that belong to specified orders."
  ([profileId projectId] (inventoryItems-list profileId projectId nil))
  ([profileId projectId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/projects/{projectId}/inventoryItems",
       :uri-template-args {:profileId profileId, :projectId projectId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn countries-get
  "Gets one country by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
dartId <string> Country DART ID."
  [profileId dartId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/countries/{+dartId}",
     :uri-template-args {:profileId profileId, :dartId dartId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn countries-list
  "Retrieves a list of countries.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request."
  [profileId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/countries",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn dimensionValues-query
  "Retrieves list of report dimension values for a list of filters.
https://developers.google.com/doubleclick-advertisers

profileId <string> The Campaign Manager 360 user profile ID.
DimensionValueRequest:
{:dimensionName string,
 :filters [{:dimensionName string, :value string, :kind string}],
 :startDate string,
 :endDate string,
 :kind string}

optional:
maxResults <integer> Maximum number of results to return."
  ([profileId DimensionValueRequest]
    (dimensionValues-query profileId DimensionValueRequest nil))
  ([profileId DimensionValueRequest optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{profileId}/dimensionvalues/query",
       :uri-template-args {:profileId profileId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfareporting"],
       :body DimensionValueRequest})))

(defn subaccounts-patch
  "Updates an existing subaccount. This method supports patch semantics.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Required. Subaccount ID.
Subaccount:
{:id string,
 :name string,
 :accountId string,
 :availablePermissionIds [string],
 :kind string}"
  [profileId id Subaccount]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/subaccounts",
     :uri-template-args {:profileId profileId},
     :query-params {:id id},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body Subaccount}))

(defn subaccounts-get
  "Gets one subaccount by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Subaccount ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/subaccounts/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn subaccounts-insert
  "Inserts a new subaccount.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
Subaccount:
{:id string,
 :name string,
 :accountId string,
 :availablePermissionIds [string],
 :kind string}"
  [profileId Subaccount]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/subaccounts",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body Subaccount}))

(defn subaccounts-list
  "Gets a list of subaccounts, possibly filtered. This method supports paging.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.

optional:
ids <string> Select only subaccounts with these IDs.
maxResults <integer> Maximum number of results to return.
searchString <string> Allows searching for objects by name or ID. Wildcards (*) are allowed. For example, \"subaccount*2015\" will return objects with names like \"subaccount June 2015\", \"subaccount April 2015\", or simply \"subaccount 2015\". Most of the searches also add wildcards implicitly at the start and the end of the search string. For example, a search string of \"subaccount\" will match objects with name \"my subaccount\", \"subaccount 2015\", or simply \"subaccount\" .
sortField <string> Field by which to sort the list.
sortOrder <string> Order of sorted results."
  ([profileId] (subaccounts-list profileId nil))
  ([profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/subaccounts",
       :uri-template-args {:profileId profileId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn subaccounts-update
  "Updates an existing subaccount.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
Subaccount:
{:id string,
 :name string,
 :accountId string,
 :availablePermissionIds [string],
 :kind string}"
  [profileId Subaccount]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/subaccounts",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body Subaccount}))

(defn contentCategories-delete
  "Deletes an existing content category.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Content category ID."
  [profileId id]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/contentCategories/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn contentCategories-get
  "Gets one content category by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Content category ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/contentCategories/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn contentCategories-insert
  "Inserts a new content category.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
ContentCategory:
{:id string, :name string, :accountId string, :kind string}"
  [profileId ContentCategory]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/contentCategories",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body ContentCategory}))

(defn contentCategories-list
  "Retrieves a list of content categories, possibly filtered. This method supports paging.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.

optional:
ids <string> Select only content categories with these IDs.
maxResults <integer> Maximum number of results to return.
searchString <string> Allows searching for objects by name or ID. Wildcards (*) are allowed. For example, \"contentcategory*2015\" will return objects with names like \"contentcategory June 2015\", \"contentcategory April 2015\", or simply \"contentcategory 2015\". Most of the searches also add wildcards implicitly at the start and the end of the search string. For example, a search string of \"contentcategory\" will match objects with name \"my contentcategory\", \"contentcategory 2015\", or simply \"contentcategory\".
sortField <string> Field by which to sort the list.
sortOrder <string> Order of sorted results."
  ([profileId] (contentCategories-list profileId nil))
  ([profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/contentCategories",
       :uri-template-args {:profileId profileId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn contentCategories-update
  "Updates an existing content category.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
ContentCategory:
{:id string, :name string, :accountId string, :kind string}"
  [profileId ContentCategory]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/contentCategories",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body ContentCategory}))

(defn contentCategories-patch
  "Updates an existing content category. This method supports patch semantics.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Required. ContentCategory ID.
ContentCategory:
{:id string, :name string, :accountId string, :kind string}"
  [profileId id ContentCategory]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/contentCategories",
     :uri-template-args {:profileId profileId},
     :query-params {:id id},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body ContentCategory}))

(defn remarketingListShares-patch
  "Updates an existing remarketing list share. This method supports patch semantics.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Required. RemarketingList ID.
RemarketingListShare:
{:remarketingListId string,
 :sharedAccountIds [string],
 :sharedAdvertiserIds [string],
 :kind string}"
  [profileId id RemarketingListShare]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/remarketingListShares",
     :uri-template-args {:profileId profileId},
     :query-params {:id id},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body RemarketingListShare}))

(defn remarketingListShares-get
  "Gets one remarketing list share by remarketing list ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
remarketingListId <string> Remarketing list ID."
  [profileId remarketingListId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/remarketingListShares/{+remarketingListId}",
     :uri-template-args
     {:profileId profileId, :remarketingListId remarketingListId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn remarketingListShares-update
  "Updates an existing remarketing list share.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
RemarketingListShare:
{:remarketingListId string,
 :sharedAccountIds [string],
 :sharedAdvertiserIds [string],
 :kind string}"
  [profileId RemarketingListShare]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/remarketingListShares",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body RemarketingListShare}))

(defn campaigns-get
  "Gets one campaign by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Campaign ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/campaigns/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn campaigns-insert
  "Inserts a new campaign.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
Campaign:
{:archived boolean,
 :idDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :creativeGroupIds [string],
 :measurementPartnerLink
 {:measurementPartner [NONE INTEGRAL_AD_SCIENCE DOUBLE_VERIFY],
  :linkStatus
  [MEASUREMENT_PARTNER_UNLINKED
   MEASUREMENT_PARTNER_LINKED
   MEASUREMENT_PARTNER_LINK_PENDING
   MEASUREMENT_PARTNER_LINK_FAILURE
   MEASUREMENT_PARTNER_LINK_OPT_OUT
   MEASUREMENT_PARTNER_LINK_OPT_OUT_PENDING
   MEASUREMENT_PARTNER_LINK_WRAPPING_PENDING
   MEASUREMENT_PARTNER_MODE_CHANGE_PENDING
   MEASUREMENT_PARTNER_UNLINK_PENDING],
  :partnerCampaignId string},
 :additionalCreativeOptimizationConfigurations
 [{:optimizationModel
   [CLICK
    POST_CLICK
    POST_IMPRESSION
    POST_CLICK_AND_IMPRESSION
    VIDEO_COMPLETION],
   :optimizationActivitys
   [{:floodlightActivityId string,
     :weight integer,
     :floodlightActivityIdDimensionValue
     {:dimensionName string,
      :value string,
      :id string,
      :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
      :kind string,
      :etag string}}],
   :id string,
   :name string}],
 :advertiserIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :name string,
 :startDate string,
 :createInfo {:time string},
 :advertiserGroupId string,
 :eventTagOverrides [{:id string, :enabled boolean}],
 :defaultClickThroughEventTagProperties
 {:overrideInheritedEventTag boolean,
  :defaultClickThroughEventTagId string},
 :adBlockingConfiguration {:enabled boolean},
 :endDate string,
 :clickThroughUrlSuffixProperties
 {:overrideInheritedSuffix boolean, :clickThroughUrlSuffix string},
 :advertiserId string,
 :externalId string,
 :defaultLandingPageId string,
 :id string,
 :kind string,
 :comment string,
 :creativeOptimizationConfiguration
 {:optimizationModel
  [CLICK
   POST_CLICK
   POST_IMPRESSION
   POST_CLICK_AND_IMPRESSION
   VIDEO_COMPLETION],
  :optimizationActivitys
  [{:floodlightActivityId string,
    :weight integer,
    :floodlightActivityIdDimensionValue
    {:dimensionName string,
     :value string,
     :id string,
     :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
     :kind string,
     :etag string}}],
  :id string,
  :name string},
 :billingInvoiceCode string,
 :lastModifiedInfo {:time string},
 :subaccountId string,
 :accountId string,
 :audienceSegmentGroups
 [{:id string,
   :name string,
   :audienceSegments
   [{:id string, :name string, :allocation integer}]}]}"
  [profileId Campaign]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/campaigns",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body Campaign}))

(defn campaigns-list
  "Retrieves a list of campaigns, possibly filtered. This method supports paging.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.

optional:
archived <boolean> Select only archived campaigns. Don't set this field to select both archived and non-archived campaigns.
atLeastOneOptimizationActivity <boolean> Select only campaigns that have at least one optimization activity.
overriddenEventTagId <string> Select only campaigns that have overridden this event tag ID.
ids <string> Select only campaigns with these IDs.
searchString <string> Allows searching for campaigns by name or ID. Wildcards (*) are allowed. For example, \"campaign*2015\" will return campaigns with names like \"campaign June 2015\", \"campaign April 2015\", or simply \"campaign 2015\". Most of the searches also add wildcards implicitly at the start and the end of the search string. For example, a search string of \"campaign\" will match campaigns with name \"my campaign\", \"campaign 2015\", or simply \"campaign\".
advertiserGroupIds <string> Select only campaigns whose advertisers belong to these advertiser groups.
sortField <string> Field by which to sort the list.
advertiserIds <string> Select only campaigns that belong to these advertisers.
sortOrder <string> Order of sorted results.
subaccountId <string> Select only campaigns that belong to this subaccount.
maxResults <integer> Maximum number of results to return.
excludedIds <string> Exclude campaigns with these IDs."
  ([profileId] (campaigns-list profileId nil))
  ([profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/campaigns",
       :uri-template-args {:profileId profileId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn campaigns-update
  "Updates an existing campaign.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
Campaign:
{:archived boolean,
 :idDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :creativeGroupIds [string],
 :measurementPartnerLink
 {:measurementPartner [NONE INTEGRAL_AD_SCIENCE DOUBLE_VERIFY],
  :linkStatus
  [MEASUREMENT_PARTNER_UNLINKED
   MEASUREMENT_PARTNER_LINKED
   MEASUREMENT_PARTNER_LINK_PENDING
   MEASUREMENT_PARTNER_LINK_FAILURE
   MEASUREMENT_PARTNER_LINK_OPT_OUT
   MEASUREMENT_PARTNER_LINK_OPT_OUT_PENDING
   MEASUREMENT_PARTNER_LINK_WRAPPING_PENDING
   MEASUREMENT_PARTNER_MODE_CHANGE_PENDING
   MEASUREMENT_PARTNER_UNLINK_PENDING],
  :partnerCampaignId string},
 :additionalCreativeOptimizationConfigurations
 [{:optimizationModel
   [CLICK
    POST_CLICK
    POST_IMPRESSION
    POST_CLICK_AND_IMPRESSION
    VIDEO_COMPLETION],
   :optimizationActivitys
   [{:floodlightActivityId string,
     :weight integer,
     :floodlightActivityIdDimensionValue
     {:dimensionName string,
      :value string,
      :id string,
      :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
      :kind string,
      :etag string}}],
   :id string,
   :name string}],
 :advertiserIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :name string,
 :startDate string,
 :createInfo {:time string},
 :advertiserGroupId string,
 :eventTagOverrides [{:id string, :enabled boolean}],
 :defaultClickThroughEventTagProperties
 {:overrideInheritedEventTag boolean,
  :defaultClickThroughEventTagId string},
 :adBlockingConfiguration {:enabled boolean},
 :endDate string,
 :clickThroughUrlSuffixProperties
 {:overrideInheritedSuffix boolean, :clickThroughUrlSuffix string},
 :advertiserId string,
 :externalId string,
 :defaultLandingPageId string,
 :id string,
 :kind string,
 :comment string,
 :creativeOptimizationConfiguration
 {:optimizationModel
  [CLICK
   POST_CLICK
   POST_IMPRESSION
   POST_CLICK_AND_IMPRESSION
   VIDEO_COMPLETION],
  :optimizationActivitys
  [{:floodlightActivityId string,
    :weight integer,
    :floodlightActivityIdDimensionValue
    {:dimensionName string,
     :value string,
     :id string,
     :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
     :kind string,
     :etag string}}],
  :id string,
  :name string},
 :billingInvoiceCode string,
 :lastModifiedInfo {:time string},
 :subaccountId string,
 :accountId string,
 :audienceSegmentGroups
 [{:id string,
   :name string,
   :audienceSegments
   [{:id string, :name string, :allocation integer}]}]}"
  [profileId Campaign]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/campaigns",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body Campaign}))

(defn campaigns-patch
  "Updates an existing campaign. This method supports patch semantics.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Required. Campaign ID.
Campaign:
{:archived boolean,
 :idDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :creativeGroupIds [string],
 :measurementPartnerLink
 {:measurementPartner [NONE INTEGRAL_AD_SCIENCE DOUBLE_VERIFY],
  :linkStatus
  [MEASUREMENT_PARTNER_UNLINKED
   MEASUREMENT_PARTNER_LINKED
   MEASUREMENT_PARTNER_LINK_PENDING
   MEASUREMENT_PARTNER_LINK_FAILURE
   MEASUREMENT_PARTNER_LINK_OPT_OUT
   MEASUREMENT_PARTNER_LINK_OPT_OUT_PENDING
   MEASUREMENT_PARTNER_LINK_WRAPPING_PENDING
   MEASUREMENT_PARTNER_MODE_CHANGE_PENDING
   MEASUREMENT_PARTNER_UNLINK_PENDING],
  :partnerCampaignId string},
 :additionalCreativeOptimizationConfigurations
 [{:optimizationModel
   [CLICK
    POST_CLICK
    POST_IMPRESSION
    POST_CLICK_AND_IMPRESSION
    VIDEO_COMPLETION],
   :optimizationActivitys
   [{:floodlightActivityId string,
     :weight integer,
     :floodlightActivityIdDimensionValue
     {:dimensionName string,
      :value string,
      :id string,
      :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
      :kind string,
      :etag string}}],
   :id string,
   :name string}],
 :advertiserIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :name string,
 :startDate string,
 :createInfo {:time string},
 :advertiserGroupId string,
 :eventTagOverrides [{:id string, :enabled boolean}],
 :defaultClickThroughEventTagProperties
 {:overrideInheritedEventTag boolean,
  :defaultClickThroughEventTagId string},
 :adBlockingConfiguration {:enabled boolean},
 :endDate string,
 :clickThroughUrlSuffixProperties
 {:overrideInheritedSuffix boolean, :clickThroughUrlSuffix string},
 :advertiserId string,
 :externalId string,
 :defaultLandingPageId string,
 :id string,
 :kind string,
 :comment string,
 :creativeOptimizationConfiguration
 {:optimizationModel
  [CLICK
   POST_CLICK
   POST_IMPRESSION
   POST_CLICK_AND_IMPRESSION
   VIDEO_COMPLETION],
  :optimizationActivitys
  [{:floodlightActivityId string,
    :weight integer,
    :floodlightActivityIdDimensionValue
    {:dimensionName string,
     :value string,
     :id string,
     :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
     :kind string,
     :etag string}}],
  :id string,
  :name string},
 :billingInvoiceCode string,
 :lastModifiedInfo {:time string},
 :subaccountId string,
 :accountId string,
 :audienceSegmentGroups
 [{:id string,
   :name string,
   :audienceSegments
   [{:id string, :name string, :allocation integer}]}]}"
  [profileId id Campaign]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/campaigns",
     :uri-template-args {:profileId profileId},
     :query-params {:id id},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body Campaign}))

(defn browsers-list
  "Retrieves a list of browsers.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request."
  [profileId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/browsers",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn billingAssignments-insert
  "Inserts a new billing assignment and returns the new assignment. Only one of advertiser_id or campaign_id is support per request. If the new assignment has no effect (assigning a campaign to the parent advertiser billing profile or assigning an advertiser to the account billing profile), no assignment will be returned.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
billingProfileId <string> Billing profile ID of this billing assignment.
BillingAssignment:
{:accountId string,
 :subaccountId string,
 :advertiserId string,
 :campaignId string,
 :kind string}"
  [profileId billingProfileId BillingAssignment]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/billingProfiles/{+billingProfileId}/billingAssignments",
     :uri-template-args
     {:profileId profileId, :billingProfileId billingProfileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body BillingAssignment}))

(defn billingAssignments-list
  "Retrieves a list of billing assignments.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
billingProfileId <string> Billing profile ID of this billing assignment."
  [profileId billingProfileId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/billingProfiles/{+billingProfileId}/billingAssignments",
     :uri-template-args
     {:profileId profileId, :billingProfileId billingProfileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn accountPermissions-get
  "Gets one account permission by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Account permission ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/accountPermissions/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn accountPermissions-list
  "Retrieves the list of account permissions.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request."
  [profileId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/accountPermissions",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn creativeFields-delete
  "Deletes an existing creative field.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Creative Field ID"
  [profileId id]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/creativeFields/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn creativeFields-get
  "Gets one creative field by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Creative Field ID"
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/creativeFields/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn creativeFields-insert
  "Inserts a new creative field.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
CreativeField:
{:id string,
 :accountId string,
 :subaccountId string,
 :advertiserId string,
 :name string,
 :advertiserIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :kind string}"
  [profileId CreativeField]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/creativeFields",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body CreativeField}))

(defn creativeFields-list
  "Retrieves a list of creative fields, possibly filtered. This method supports paging.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.

optional:
ids <string> Select only creative fields with these IDs.
searchString <string> Allows searching for creative fields by name or ID. Wildcards (*) are allowed. For example, \"creativefield*2015\" will return creative fields with names like \"creativefield June 2015\", \"creativefield April 2015\", or simply \"creativefield 2015\". Most of the searches also add wild-cards implicitly at the start and the end of the search string. For example, a search string of \"creativefield\" will match creative fields with the name \"my creativefield\", \"creativefield 2015\", or simply \"creativefield\".
advertiserIds <string> Select only creative fields that belong to these advertisers.
maxResults <integer> Maximum number of results to return.
sortField <string> Field by which to sort the list.
sortOrder <string> Order of sorted results."
  ([profileId] (creativeFields-list profileId nil))
  ([profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/creativeFields",
       :uri-template-args {:profileId profileId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn creativeFields-update
  "Updates an existing creative field.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
CreativeField:
{:id string,
 :accountId string,
 :subaccountId string,
 :advertiserId string,
 :name string,
 :advertiserIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :kind string}"
  [profileId CreativeField]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/creativeFields",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body CreativeField}))

(defn creativeFields-patch
  "Updates an existing creative field. This method supports patch semantics.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> CreativeField ID.
CreativeField:
{:id string,
 :accountId string,
 :subaccountId string,
 :advertiserId string,
 :name string,
 :advertiserIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :kind string}"
  [profileId id CreativeField]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/creativeFields",
     :uri-template-args {:profileId profileId},
     :query-params {:id id},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body CreativeField}))

(defn userRolePermissionGroups-get
  "Gets one user role permission group by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> User role permission group ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/userRolePermissionGroups/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn userRolePermissionGroups-list
  "Gets a list of all supported user role permission groups.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request."
  [profileId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/userRolePermissionGroups",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn creatives-get
  "Gets one creative by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Creative ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/creatives/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn creatives-insert
  "Inserts a new creative.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
Creative:
{:archived boolean,
 :counterCustomEvents
 [{:advertiserCustomEventName string,
   :popupWindowProperties
   {:offset {:top integer, :left integer},
    :positionType [CENTER COORDINATES],
    :showMenuBar boolean,
    :showToolBar boolean,
    :title string,
    :showStatusBar boolean,
    :showAddressBar boolean,
    :dimension
    {:id string,
     :width integer,
     :height integer,
     :iab boolean,
     :kind string},
    :showScrollBar boolean},
   :artworkType
   [ARTWORK_TYPE_FLASH
    ARTWORK_TYPE_HTML5
    ARTWORK_TYPE_MIXED
    ARTWORK_TYPE_IMAGE],
   :artworkLabel string,
   :videoReportingId string,
   :advertiserCustomEventId string,
   :id string,
   :targetType
   [TARGET_BLANK TARGET_TOP TARGET_SELF TARGET_PARENT TARGET_POPUP],
   :exitClickThroughUrl
   {:landingPageId string,
    :customClickThroughUrl string,
    :computedClickThroughUrl string},
   :advertiserCustomEventType
   [ADVERTISER_EVENT_TIMER
    ADVERTISER_EVENT_EXIT
    ADVERTISER_EVENT_COUNTER]}],
 :thirdPartyBackupImageImpressionsUrl string,
 :overrideCss string,
 :adParameters string,
 :skippable boolean,
 :allowScriptAccess boolean,
 :customKeyValues [string],
 :studioCreativeId string,
 :idDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :additionalSizes
 [{:id string,
   :width integer,
   :height integer,
   :iab boolean,
   :kind string}],
 :fsCommand
 {:positionOption [CENTERED DISTANCE_FROM_TOP_LEFT_CORNER],
  :top integer,
  :left integer,
  :windowWidth integer,
  :windowHeight integer},
 :backupImageClickThroughUrl
 {:landingPageId string,
  :customClickThroughUrl string,
  :computedClickThroughUrl string},
 :timerCustomEvents
 [{:advertiserCustomEventName string,
   :popupWindowProperties
   {:offset {:top integer, :left integer},
    :positionType [CENTER COORDINATES],
    :showMenuBar boolean,
    :showToolBar boolean,
    :title string,
    :showStatusBar boolean,
    :showAddressBar boolean,
    :dimension
    {:id string,
     :width integer,
     :height integer,
     :iab boolean,
     :kind string},
    :showScrollBar boolean},
   :artworkType
   [ARTWORK_TYPE_FLASH
    ARTWORK_TYPE_HTML5
    ARTWORK_TYPE_MIXED
    ARTWORK_TYPE_IMAGE],
   :artworkLabel string,
   :videoReportingId string,
   :advertiserCustomEventId string,
   :id string,
   :targetType
   [TARGET_BLANK TARGET_TOP TARGET_SELF TARGET_PARENT TARGET_POPUP],
   :exitClickThroughUrl
   {:landingPageId string,
    :customClickThroughUrl string,
    :computedClickThroughUrl string},
   :advertiserCustomEventType
   [ADVERTISER_EVENT_TIMER
    ADVERTISER_EVENT_EXIT
    ADVERTISER_EVENT_COUNTER]}],
 :sslOverride boolean,
 :compatibility
 [[DISPLAY
   DISPLAY_INTERSTITIAL
   APP
   APP_INTERSTITIAL
   IN_STREAM_VIDEO
   IN_STREAM_AUDIO]],
 :sslCompliant boolean,
 :skipOffset {:offsetSeconds integer, :offsetPercentage integer},
 :thirdPartyRichMediaImpressionsUrl string,
 :name string,
 :convertFlashToHtml5 boolean,
 :universalAdId
 {:registry [OTHER AD_ID_OFFICIAL CLEARCAST DCM ARPP], :value string},
 :artworkType
 [ARTWORK_TYPE_FLASH
  ARTWORK_TYPE_HTML5
  ARTWORK_TYPE_MIXED
  ARTWORK_TYPE_IMAGE],
 :authoringSource
 [CREATIVE_AUTHORING_SOURCE_DCM
  CREATIVE_AUTHORING_SOURCE_DBM
  CREATIVE_AUTHORING_SOURCE_STUDIO
  CREATIVE_AUTHORING_SOURCE_GWD
  CREATIVE_AUTHORING_SOURCE_ACS],
 :type
 [IMAGE
  DISPLAY_REDIRECT
  CUSTOM_DISPLAY
  INTERNAL_REDIRECT
  CUSTOM_DISPLAY_INTERSTITIAL
  INTERSTITIAL_INTERNAL_REDIRECT
  TRACKING_TEXT
  RICH_MEDIA_DISPLAY_BANNER
  RICH_MEDIA_INPAGE_FLOATING
  RICH_MEDIA_IM_EXPAND
  RICH_MEDIA_DISPLAY_EXPANDING
  RICH_MEDIA_DISPLAY_INTERSTITIAL
  RICH_MEDIA_DISPLAY_MULTI_FLOATING_INTERSTITIAL
  RICH_MEDIA_MOBILE_IN_APP
  FLASH_INPAGE
  INSTREAM_VIDEO
  VPAID_LINEAR_VIDEO
  VPAID_NON_LINEAR_VIDEO
  INSTREAM_VIDEO_REDIRECT
  RICH_MEDIA_PEEL_DOWN
  HTML5_BANNER
  DISPLAY
  DISPLAY_IMAGE_GALLERY
  BRAND_SAFE_DEFAULT_INSTREAM_VIDEO
  INSTREAM_AUDIO],
 :creativeAssets
 [{:role
   [PRIMARY
    BACKUP_IMAGE
    ADDITIONAL_IMAGE
    ADDITIONAL_FLASH
    PARENT_VIDEO
    TRANSCODED_VIDEO
    OTHER
    ALTERNATE_VIDEO
    PARENT_AUDIO
    TRANSCODED_AUDIO],
   :fileSize string,
   :idDimensionValue
   {:dimensionName string,
    :value string,
    :id string,
    :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
    :kind string,
    :etag string},
   :additionalSizes
   [{:id string,
     :width integer,
     :height integer,
     :iab boolean,
     :kind string}],
   :windowMode [OPAQUE WINDOW TRANSPARENT],
   :bitRate integer,
   :verticallyLocked boolean,
   :offset {:top integer, :left integer},
   :horizontallyLocked boolean,
   :sslCompliant boolean,
   :positionLeftUnit
   [OFFSET_UNIT_PIXEL
    OFFSET_UNIT_PERCENT
    OFFSET_UNIT_PIXEL_FROM_CENTER],
   :frameRate number,
   :alignment
   [ALIGNMENT_TOP ALIGNMENT_RIGHT ALIGNMENT_BOTTOM ALIGNMENT_LEFT],
   :pushdownDuration number,
   :artworkType
   [ARTWORK_TYPE_FLASH
    ARTWORK_TYPE_HTML5
    ARTWORK_TYPE_MIXED
    ARTWORK_TYPE_IMAGE],
   :zipFilesize string,
   :childAssetType
   [CHILD_ASSET_TYPE_FLASH
    CHILD_ASSET_TYPE_VIDEO
    CHILD_ASSET_TYPE_IMAGE
    CHILD_ASSET_TYPE_DATA],
   :startTimeType
   [ASSET_START_TIME_TYPE_NONE ASSET_START_TIME_TYPE_CUSTOM],
   :orientation [LANDSCAPE PORTRAIT SQUARE],
   :flashVersion integer,
   :duration integer,
   :streamingServingUrl string,
   :audioSampleRate integer,
   :displayType
   [ASSET_DISPLAY_TYPE_INPAGE
    ASSET_DISPLAY_TYPE_FLOATING
    ASSET_DISPLAY_TYPE_OVERLAY
    ASSET_DISPLAY_TYPE_EXPANDING
    ASSET_DISPLAY_TYPE_FLASH_IN_FLASH
    ASSET_DISPLAY_TYPE_FLASH_IN_FLASH_EXPANDING
    ASSET_DISPLAY_TYPE_PEEL_DOWN
    ASSET_DISPLAY_TYPE_VPAID_LINEAR
    ASSET_DISPLAY_TYPE_VPAID_NON_LINEAR
    ASSET_DISPLAY_TYPE_BACKDROP],
   :detectedFeatures
   [[CSS_FONT_FACE
     CSS_BACKGROUND_SIZE
     CSS_BORDER_IMAGE
     CSS_BORDER_RADIUS
     CSS_BOX_SHADOW
     CSS_FLEX_BOX
     CSS_HSLA
     CSS_MULTIPLE_BGS
     CSS_OPACITY
     CSS_RGBA
     CSS_TEXT_SHADOW
     CSS_ANIMATIONS
     CSS_COLUMNS
     CSS_GENERATED_CONTENT
     CSS_GRADIENTS
     CSS_REFLECTIONS
     CSS_TRANSFORMS
     CSS_TRANSFORMS3D
     CSS_TRANSITIONS
     APPLICATION_CACHE
     CANVAS
     CANVAS_TEXT
     DRAG_AND_DROP
     HASH_CHANGE
     HISTORY
     AUDIO
     VIDEO
     INDEXED_DB
     INPUT_ATTR_AUTOCOMPLETE
     INPUT_ATTR_AUTOFOCUS
     INPUT_ATTR_LIST
     INPUT_ATTR_PLACEHOLDER
     INPUT_ATTR_MAX
     INPUT_ATTR_MIN
     INPUT_ATTR_MULTIPLE
     INPUT_ATTR_PATTERN
     INPUT_ATTR_REQUIRED
     INPUT_ATTR_STEP
     INPUT_TYPE_SEARCH
     INPUT_TYPE_TEL
     INPUT_TYPE_URL
     INPUT_TYPE_EMAIL
     INPUT_TYPE_DATETIME
     INPUT_TYPE_DATE
     INPUT_TYPE_MONTH
     INPUT_TYPE_WEEK
     INPUT_TYPE_TIME
     INPUT_TYPE_DATETIME_LOCAL
     INPUT_TYPE_NUMBER
     INPUT_TYPE_RANGE
     INPUT_TYPE_COLOR
     LOCAL_STORAGE
     POST_MESSAGE
     SESSION_STORAGE
     WEB_SOCKETS
     WEB_SQL_DATABASE
     WEB_WORKERS
     GEO_LOCATION
     INLINE_SVG
     SMIL
     SVG_HREF
     SVG_CLIP_PATHS
     TOUCH
     WEBGL
     SVG_FILTERS
     SVG_FE_IMAGE]],
   :size
   {:id string,
    :width integer,
    :height integer,
    :iab boolean,
    :kind string},
   :progressiveServingUrl string,
   :originalBackup boolean,
   :collapsedSize
   {:id string,
    :width integer,
    :height integer,
    :iab boolean,
    :kind string},
   :durationType
   [ASSET_DURATION_TYPE_AUTO
    ASSET_DURATION_TYPE_NONE
    ASSET_DURATION_TYPE_CUSTOM],
   :hideFlashObjects boolean,
   :positionTopUnit
   [OFFSET_UNIT_PIXEL
    OFFSET_UNIT_PERCENT
    OFFSET_UNIT_PIXEL_FROM_CENTER],
   :active boolean,
   :id string,
   :customStartTimeValue integer,
   :pushdown boolean,
   :mimeType string,
   :zIndex integer,
   :position {:top integer, :left integer},
   :hideSelectionBoxes boolean,
   :politeLoad boolean,
   :expandedDimension
   {:id string,
    :width integer,
    :height integer,
    :iab boolean,
    :kind string},
   :companionCreativeIds [string],
   :zipFilename string,
   :assetIdentifier
   {:type [IMAGE FLASH VIDEO HTML HTML_IMAGE AUDIO], :name string},
   :mediaDuration number,
   :audioBitRate integer,
   :actionScript3 boolean,
   :transparency boolean,
   :backupImageExit
   {:advertiserCustomEventName string,
    :popupWindowProperties
    {:offset {:top integer, :left integer},
     :positionType [CENTER COORDINATES],
     :showMenuBar boolean,
     :showToolBar boolean,
     :title string,
     :showStatusBar boolean,
     :showAddressBar boolean,
     :dimension
     {:id string,
      :width integer,
      :height integer,
      :iab boolean,
      :kind string},
     :showScrollBar boolean},
    :artworkType
    [ARTWORK_TYPE_FLASH
     ARTWORK_TYPE_HTML5
     ARTWORK_TYPE_MIXED
     ARTWORK_TYPE_IMAGE],
    :artworkLabel string,
    :videoReportingId string,
    :advertiserCustomEventId string,
    :id string,
    :targetType
    [TARGET_BLANK TARGET_TOP TARGET_SELF TARGET_PARENT TARGET_POPUP],
    :exitClickThroughUrl
    {:landingPageId string,
     :customClickThroughUrl string,
     :computedClickThroughUrl string},
    :advertiserCustomEventType
    [ADVERTISER_EVENT_TIMER
     ADVERTISER_EVENT_EXIT
     ADVERTISER_EVENT_COUNTER]}}],
 :exitCustomEvents
 [{:advertiserCustomEventName string,
   :popupWindowProperties
   {:offset {:top integer, :left integer},
    :positionType [CENTER COORDINATES],
    :showMenuBar boolean,
    :showToolBar boolean,
    :title string,
    :showStatusBar boolean,
    :showAddressBar boolean,
    :dimension
    {:id string,
     :width integer,
     :height integer,
     :iab boolean,
     :kind string},
    :showScrollBar boolean},
   :artworkType
   [ARTWORK_TYPE_FLASH
    ARTWORK_TYPE_HTML5
    ARTWORK_TYPE_MIXED
    ARTWORK_TYPE_IMAGE],
   :artworkLabel string,
   :videoReportingId string,
   :advertiserCustomEventId string,
   :id string,
   :targetType
   [TARGET_BLANK TARGET_TOP TARGET_SELF TARGET_PARENT TARGET_POPUP],
   :exitClickThroughUrl
   {:landingPageId string,
    :customClickThroughUrl string,
    :computedClickThroughUrl string},
   :advertiserCustomEventType
   [ADVERTISER_EVENT_TIMER
    ADVERTISER_EVENT_EXIT
    ADVERTISER_EVENT_COUNTER]}],
 :size
 {:id string,
  :width integer,
  :height integer,
  :iab boolean,
  :kind string},
 :studioAdvertiserId string,
 :creativeFieldAssignments
 [{:creativeFieldId string, :creativeFieldValueId string}],
 :thirdPartyUrls
 [{:thirdPartyUrlType
   [IMPRESSION
    CLICK_TRACKING
    VIDEO_START
    VIDEO_FIRST_QUARTILE
    VIDEO_MIDPOINT
    VIDEO_THIRD_QUARTILE
    VIDEO_COMPLETE
    VIDEO_MUTE
    VIDEO_PAUSE
    VIDEO_REWIND
    VIDEO_FULLSCREEN
    VIDEO_STOP
    VIDEO_CUSTOM
    SURVEY
    RICH_MEDIA_IMPRESSION
    RICH_MEDIA_RM_IMPRESSION
    RICH_MEDIA_BACKUP_IMPRESSION
    VIDEO_SKIP
    VIDEO_PROGRESS],
   :url string}],
 :commercialId string,
 :backupImageFeatures
 [[CSS_FONT_FACE
   CSS_BACKGROUND_SIZE
   CSS_BORDER_IMAGE
   CSS_BORDER_RADIUS
   CSS_BOX_SHADOW
   CSS_FLEX_BOX
   CSS_HSLA
   CSS_MULTIPLE_BGS
   CSS_OPACITY
   CSS_RGBA
   CSS_TEXT_SHADOW
   CSS_ANIMATIONS
   CSS_COLUMNS
   CSS_GENERATED_CONTENT
   CSS_GRADIENTS
   CSS_REFLECTIONS
   CSS_TRANSFORMS
   CSS_TRANSFORMS3D
   CSS_TRANSITIONS
   APPLICATION_CACHE
   CANVAS
   CANVAS_TEXT
   DRAG_AND_DROP
   HASH_CHANGE
   HISTORY
   AUDIO
   VIDEO
   INDEXED_DB
   INPUT_ATTR_AUTOCOMPLETE
   INPUT_ATTR_AUTOFOCUS
   INPUT_ATTR_LIST
   INPUT_ATTR_PLACEHOLDER
   INPUT_ATTR_MAX
   INPUT_ATTR_MIN
   INPUT_ATTR_MULTIPLE
   INPUT_ATTR_PATTERN
   INPUT_ATTR_REQUIRED
   INPUT_ATTR_STEP
   INPUT_TYPE_SEARCH
   INPUT_TYPE_TEL
   INPUT_TYPE_URL
   INPUT_TYPE_EMAIL
   INPUT_TYPE_DATETIME
   INPUT_TYPE_DATE
   INPUT_TYPE_MONTH
   INPUT_TYPE_WEEK
   INPUT_TYPE_TIME
   INPUT_TYPE_DATETIME_LOCAL
   INPUT_TYPE_NUMBER
   INPUT_TYPE_RANGE
   INPUT_TYPE_COLOR
   LOCAL_STORAGE
   POST_MESSAGE
   SESSION_STORAGE
   WEB_SOCKETS
   WEB_SQL_DATABASE
   WEB_WORKERS
   GEO_LOCATION
   INLINE_SVG
   SMIL
   SVG_HREF
   SVG_CLIP_PATHS
   TOUCH
   WEBGL
   SVG_FILTERS
   SVG_FE_IMAGE]],
 :authoringTool [NINJA SWIFFY],
 :advertiserId string,
 :htmlCode string,
 :active boolean,
 :id string,
 :requiredFlashPluginVersion string,
 :kind string,
 :progressOffset {:offsetSeconds integer, :offsetPercentage integer},
 :creativeAssetSelection
 {:rules
  [{:name string, :assetId string, :targetingTemplateId string}],
  :defaultAssetId string},
 :adTagKeys [string],
 :obaIcon
 {:resourceUrl string,
  :xPosition string,
  :yPosition string,
  :size
  {:id string,
   :width integer,
   :height integer,
   :iab boolean,
   :kind string},
  :program string,
  :iconClickThroughUrl string,
  :iconClickTrackingUrl string,
  :iconViewTrackingUrl string},
 :clickTags
 [{:name string,
   :eventName string,
   :clickThroughUrl
   {:landingPageId string,
    :customClickThroughUrl string,
    :computedClickThroughUrl string}}],
 :lastModifiedInfo {:time string},
 :latestTraffickedCreativeId string,
 :totalFileSize string,
 :redirectUrl string,
 :requiredFlashVersion integer,
 :backupImageTargetWindow
 {:targetWindowOption [NEW_WINDOW CURRENT_WINDOW CUSTOM],
  :customHtml string},
 :subaccountId string,
 :version integer,
 :dynamicAssetSelection boolean,
 :renderingIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :mediaDuration number,
 :autoAdvanceImages boolean,
 :backgroundColor string,
 :companionCreatives [string],
 :accountId string,
 :backupImageReportingLabel string,
 :studioTraffickedCreativeId string,
 :mediaDescription string,
 :htmlCodeLocked boolean,
 :renderingId string}"
  [profileId Creative]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/creatives",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body Creative}))

(defn creatives-list
  "Retrieves a list of creatives, possibly filtered. This method supports paging.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.

optional:
archived <boolean> Select only archived creatives. Leave blank to select archived and unarchived creatives.
studioCreativeId <string> Select only creatives corresponding to this Studio creative ID.
campaignId <string> Select only creatives with this campaign ID.
renderingIds <string> Select only creatives with these rendering IDs.
ids <string> Select only creatives with these IDs.
searchString <string> Allows searching for objects by name or ID. Wildcards (*) are allowed. For example, \"creative*2015\" will return objects with names like \"creative June 2015\", \"creative April 2015\", or simply \"creative 2015\". Most of the searches also add wildcards implicitly at the start and the end of the search string. For example, a search string of \"creative\" will match objects with name \"my creative\", \"creative 2015\", or simply \"creative\".
types <string> Select only creatives with these creative types.
sortField <string> Field by which to sort the list.
advertiserId <string> Select only creatives with this advertiser ID.
active <boolean> Select only active creatives. Leave blank to select active and inactive creatives.
sortOrder <string> Order of sorted results.
creativeFieldIds <string> Select only creatives with these creative field IDs.
companionCreativeIds <string> Select only in-stream video creatives with these companion IDs.
sizeIds <string> Select only creatives with these size IDs.
maxResults <integer> Maximum number of results to return."
  ([profileId] (creatives-list profileId nil))
  ([profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/creatives",
       :uri-template-args {:profileId profileId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn creatives-update
  "Updates an existing creative.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
Creative:
{:archived boolean,
 :counterCustomEvents
 [{:advertiserCustomEventName string,
   :popupWindowProperties
   {:offset {:top integer, :left integer},
    :positionType [CENTER COORDINATES],
    :showMenuBar boolean,
    :showToolBar boolean,
    :title string,
    :showStatusBar boolean,
    :showAddressBar boolean,
    :dimension
    {:id string,
     :width integer,
     :height integer,
     :iab boolean,
     :kind string},
    :showScrollBar boolean},
   :artworkType
   [ARTWORK_TYPE_FLASH
    ARTWORK_TYPE_HTML5
    ARTWORK_TYPE_MIXED
    ARTWORK_TYPE_IMAGE],
   :artworkLabel string,
   :videoReportingId string,
   :advertiserCustomEventId string,
   :id string,
   :targetType
   [TARGET_BLANK TARGET_TOP TARGET_SELF TARGET_PARENT TARGET_POPUP],
   :exitClickThroughUrl
   {:landingPageId string,
    :customClickThroughUrl string,
    :computedClickThroughUrl string},
   :advertiserCustomEventType
   [ADVERTISER_EVENT_TIMER
    ADVERTISER_EVENT_EXIT
    ADVERTISER_EVENT_COUNTER]}],
 :thirdPartyBackupImageImpressionsUrl string,
 :overrideCss string,
 :adParameters string,
 :skippable boolean,
 :allowScriptAccess boolean,
 :customKeyValues [string],
 :studioCreativeId string,
 :idDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :additionalSizes
 [{:id string,
   :width integer,
   :height integer,
   :iab boolean,
   :kind string}],
 :fsCommand
 {:positionOption [CENTERED DISTANCE_FROM_TOP_LEFT_CORNER],
  :top integer,
  :left integer,
  :windowWidth integer,
  :windowHeight integer},
 :backupImageClickThroughUrl
 {:landingPageId string,
  :customClickThroughUrl string,
  :computedClickThroughUrl string},
 :timerCustomEvents
 [{:advertiserCustomEventName string,
   :popupWindowProperties
   {:offset {:top integer, :left integer},
    :positionType [CENTER COORDINATES],
    :showMenuBar boolean,
    :showToolBar boolean,
    :title string,
    :showStatusBar boolean,
    :showAddressBar boolean,
    :dimension
    {:id string,
     :width integer,
     :height integer,
     :iab boolean,
     :kind string},
    :showScrollBar boolean},
   :artworkType
   [ARTWORK_TYPE_FLASH
    ARTWORK_TYPE_HTML5
    ARTWORK_TYPE_MIXED
    ARTWORK_TYPE_IMAGE],
   :artworkLabel string,
   :videoReportingId string,
   :advertiserCustomEventId string,
   :id string,
   :targetType
   [TARGET_BLANK TARGET_TOP TARGET_SELF TARGET_PARENT TARGET_POPUP],
   :exitClickThroughUrl
   {:landingPageId string,
    :customClickThroughUrl string,
    :computedClickThroughUrl string},
   :advertiserCustomEventType
   [ADVERTISER_EVENT_TIMER
    ADVERTISER_EVENT_EXIT
    ADVERTISER_EVENT_COUNTER]}],
 :sslOverride boolean,
 :compatibility
 [[DISPLAY
   DISPLAY_INTERSTITIAL
   APP
   APP_INTERSTITIAL
   IN_STREAM_VIDEO
   IN_STREAM_AUDIO]],
 :sslCompliant boolean,
 :skipOffset {:offsetSeconds integer, :offsetPercentage integer},
 :thirdPartyRichMediaImpressionsUrl string,
 :name string,
 :convertFlashToHtml5 boolean,
 :universalAdId
 {:registry [OTHER AD_ID_OFFICIAL CLEARCAST DCM ARPP], :value string},
 :artworkType
 [ARTWORK_TYPE_FLASH
  ARTWORK_TYPE_HTML5
  ARTWORK_TYPE_MIXED
  ARTWORK_TYPE_IMAGE],
 :authoringSource
 [CREATIVE_AUTHORING_SOURCE_DCM
  CREATIVE_AUTHORING_SOURCE_DBM
  CREATIVE_AUTHORING_SOURCE_STUDIO
  CREATIVE_AUTHORING_SOURCE_GWD
  CREATIVE_AUTHORING_SOURCE_ACS],
 :type
 [IMAGE
  DISPLAY_REDIRECT
  CUSTOM_DISPLAY
  INTERNAL_REDIRECT
  CUSTOM_DISPLAY_INTERSTITIAL
  INTERSTITIAL_INTERNAL_REDIRECT
  TRACKING_TEXT
  RICH_MEDIA_DISPLAY_BANNER
  RICH_MEDIA_INPAGE_FLOATING
  RICH_MEDIA_IM_EXPAND
  RICH_MEDIA_DISPLAY_EXPANDING
  RICH_MEDIA_DISPLAY_INTERSTITIAL
  RICH_MEDIA_DISPLAY_MULTI_FLOATING_INTERSTITIAL
  RICH_MEDIA_MOBILE_IN_APP
  FLASH_INPAGE
  INSTREAM_VIDEO
  VPAID_LINEAR_VIDEO
  VPAID_NON_LINEAR_VIDEO
  INSTREAM_VIDEO_REDIRECT
  RICH_MEDIA_PEEL_DOWN
  HTML5_BANNER
  DISPLAY
  DISPLAY_IMAGE_GALLERY
  BRAND_SAFE_DEFAULT_INSTREAM_VIDEO
  INSTREAM_AUDIO],
 :creativeAssets
 [{:role
   [PRIMARY
    BACKUP_IMAGE
    ADDITIONAL_IMAGE
    ADDITIONAL_FLASH
    PARENT_VIDEO
    TRANSCODED_VIDEO
    OTHER
    ALTERNATE_VIDEO
    PARENT_AUDIO
    TRANSCODED_AUDIO],
   :fileSize string,
   :idDimensionValue
   {:dimensionName string,
    :value string,
    :id string,
    :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
    :kind string,
    :etag string},
   :additionalSizes
   [{:id string,
     :width integer,
     :height integer,
     :iab boolean,
     :kind string}],
   :windowMode [OPAQUE WINDOW TRANSPARENT],
   :bitRate integer,
   :verticallyLocked boolean,
   :offset {:top integer, :left integer},
   :horizontallyLocked boolean,
   :sslCompliant boolean,
   :positionLeftUnit
   [OFFSET_UNIT_PIXEL
    OFFSET_UNIT_PERCENT
    OFFSET_UNIT_PIXEL_FROM_CENTER],
   :frameRate number,
   :alignment
   [ALIGNMENT_TOP ALIGNMENT_RIGHT ALIGNMENT_BOTTOM ALIGNMENT_LEFT],
   :pushdownDuration number,
   :artworkType
   [ARTWORK_TYPE_FLASH
    ARTWORK_TYPE_HTML5
    ARTWORK_TYPE_MIXED
    ARTWORK_TYPE_IMAGE],
   :zipFilesize string,
   :childAssetType
   [CHILD_ASSET_TYPE_FLASH
    CHILD_ASSET_TYPE_VIDEO
    CHILD_ASSET_TYPE_IMAGE
    CHILD_ASSET_TYPE_DATA],
   :startTimeType
   [ASSET_START_TIME_TYPE_NONE ASSET_START_TIME_TYPE_CUSTOM],
   :orientation [LANDSCAPE PORTRAIT SQUARE],
   :flashVersion integer,
   :duration integer,
   :streamingServingUrl string,
   :audioSampleRate integer,
   :displayType
   [ASSET_DISPLAY_TYPE_INPAGE
    ASSET_DISPLAY_TYPE_FLOATING
    ASSET_DISPLAY_TYPE_OVERLAY
    ASSET_DISPLAY_TYPE_EXPANDING
    ASSET_DISPLAY_TYPE_FLASH_IN_FLASH
    ASSET_DISPLAY_TYPE_FLASH_IN_FLASH_EXPANDING
    ASSET_DISPLAY_TYPE_PEEL_DOWN
    ASSET_DISPLAY_TYPE_VPAID_LINEAR
    ASSET_DISPLAY_TYPE_VPAID_NON_LINEAR
    ASSET_DISPLAY_TYPE_BACKDROP],
   :detectedFeatures
   [[CSS_FONT_FACE
     CSS_BACKGROUND_SIZE
     CSS_BORDER_IMAGE
     CSS_BORDER_RADIUS
     CSS_BOX_SHADOW
     CSS_FLEX_BOX
     CSS_HSLA
     CSS_MULTIPLE_BGS
     CSS_OPACITY
     CSS_RGBA
     CSS_TEXT_SHADOW
     CSS_ANIMATIONS
     CSS_COLUMNS
     CSS_GENERATED_CONTENT
     CSS_GRADIENTS
     CSS_REFLECTIONS
     CSS_TRANSFORMS
     CSS_TRANSFORMS3D
     CSS_TRANSITIONS
     APPLICATION_CACHE
     CANVAS
     CANVAS_TEXT
     DRAG_AND_DROP
     HASH_CHANGE
     HISTORY
     AUDIO
     VIDEO
     INDEXED_DB
     INPUT_ATTR_AUTOCOMPLETE
     INPUT_ATTR_AUTOFOCUS
     INPUT_ATTR_LIST
     INPUT_ATTR_PLACEHOLDER
     INPUT_ATTR_MAX
     INPUT_ATTR_MIN
     INPUT_ATTR_MULTIPLE
     INPUT_ATTR_PATTERN
     INPUT_ATTR_REQUIRED
     INPUT_ATTR_STEP
     INPUT_TYPE_SEARCH
     INPUT_TYPE_TEL
     INPUT_TYPE_URL
     INPUT_TYPE_EMAIL
     INPUT_TYPE_DATETIME
     INPUT_TYPE_DATE
     INPUT_TYPE_MONTH
     INPUT_TYPE_WEEK
     INPUT_TYPE_TIME
     INPUT_TYPE_DATETIME_LOCAL
     INPUT_TYPE_NUMBER
     INPUT_TYPE_RANGE
     INPUT_TYPE_COLOR
     LOCAL_STORAGE
     POST_MESSAGE
     SESSION_STORAGE
     WEB_SOCKETS
     WEB_SQL_DATABASE
     WEB_WORKERS
     GEO_LOCATION
     INLINE_SVG
     SMIL
     SVG_HREF
     SVG_CLIP_PATHS
     TOUCH
     WEBGL
     SVG_FILTERS
     SVG_FE_IMAGE]],
   :size
   {:id string,
    :width integer,
    :height integer,
    :iab boolean,
    :kind string},
   :progressiveServingUrl string,
   :originalBackup boolean,
   :collapsedSize
   {:id string,
    :width integer,
    :height integer,
    :iab boolean,
    :kind string},
   :durationType
   [ASSET_DURATION_TYPE_AUTO
    ASSET_DURATION_TYPE_NONE
    ASSET_DURATION_TYPE_CUSTOM],
   :hideFlashObjects boolean,
   :positionTopUnit
   [OFFSET_UNIT_PIXEL
    OFFSET_UNIT_PERCENT
    OFFSET_UNIT_PIXEL_FROM_CENTER],
   :active boolean,
   :id string,
   :customStartTimeValue integer,
   :pushdown boolean,
   :mimeType string,
   :zIndex integer,
   :position {:top integer, :left integer},
   :hideSelectionBoxes boolean,
   :politeLoad boolean,
   :expandedDimension
   {:id string,
    :width integer,
    :height integer,
    :iab boolean,
    :kind string},
   :companionCreativeIds [string],
   :zipFilename string,
   :assetIdentifier
   {:type [IMAGE FLASH VIDEO HTML HTML_IMAGE AUDIO], :name string},
   :mediaDuration number,
   :audioBitRate integer,
   :actionScript3 boolean,
   :transparency boolean,
   :backupImageExit
   {:advertiserCustomEventName string,
    :popupWindowProperties
    {:offset {:top integer, :left integer},
     :positionType [CENTER COORDINATES],
     :showMenuBar boolean,
     :showToolBar boolean,
     :title string,
     :showStatusBar boolean,
     :showAddressBar boolean,
     :dimension
     {:id string,
      :width integer,
      :height integer,
      :iab boolean,
      :kind string},
     :showScrollBar boolean},
    :artworkType
    [ARTWORK_TYPE_FLASH
     ARTWORK_TYPE_HTML5
     ARTWORK_TYPE_MIXED
     ARTWORK_TYPE_IMAGE],
    :artworkLabel string,
    :videoReportingId string,
    :advertiserCustomEventId string,
    :id string,
    :targetType
    [TARGET_BLANK TARGET_TOP TARGET_SELF TARGET_PARENT TARGET_POPUP],
    :exitClickThroughUrl
    {:landingPageId string,
     :customClickThroughUrl string,
     :computedClickThroughUrl string},
    :advertiserCustomEventType
    [ADVERTISER_EVENT_TIMER
     ADVERTISER_EVENT_EXIT
     ADVERTISER_EVENT_COUNTER]}}],
 :exitCustomEvents
 [{:advertiserCustomEventName string,
   :popupWindowProperties
   {:offset {:top integer, :left integer},
    :positionType [CENTER COORDINATES],
    :showMenuBar boolean,
    :showToolBar boolean,
    :title string,
    :showStatusBar boolean,
    :showAddressBar boolean,
    :dimension
    {:id string,
     :width integer,
     :height integer,
     :iab boolean,
     :kind string},
    :showScrollBar boolean},
   :artworkType
   [ARTWORK_TYPE_FLASH
    ARTWORK_TYPE_HTML5
    ARTWORK_TYPE_MIXED
    ARTWORK_TYPE_IMAGE],
   :artworkLabel string,
   :videoReportingId string,
   :advertiserCustomEventId string,
   :id string,
   :targetType
   [TARGET_BLANK TARGET_TOP TARGET_SELF TARGET_PARENT TARGET_POPUP],
   :exitClickThroughUrl
   {:landingPageId string,
    :customClickThroughUrl string,
    :computedClickThroughUrl string},
   :advertiserCustomEventType
   [ADVERTISER_EVENT_TIMER
    ADVERTISER_EVENT_EXIT
    ADVERTISER_EVENT_COUNTER]}],
 :size
 {:id string,
  :width integer,
  :height integer,
  :iab boolean,
  :kind string},
 :studioAdvertiserId string,
 :creativeFieldAssignments
 [{:creativeFieldId string, :creativeFieldValueId string}],
 :thirdPartyUrls
 [{:thirdPartyUrlType
   [IMPRESSION
    CLICK_TRACKING
    VIDEO_START
    VIDEO_FIRST_QUARTILE
    VIDEO_MIDPOINT
    VIDEO_THIRD_QUARTILE
    VIDEO_COMPLETE
    VIDEO_MUTE
    VIDEO_PAUSE
    VIDEO_REWIND
    VIDEO_FULLSCREEN
    VIDEO_STOP
    VIDEO_CUSTOM
    SURVEY
    RICH_MEDIA_IMPRESSION
    RICH_MEDIA_RM_IMPRESSION
    RICH_MEDIA_BACKUP_IMPRESSION
    VIDEO_SKIP
    VIDEO_PROGRESS],
   :url string}],
 :commercialId string,
 :backupImageFeatures
 [[CSS_FONT_FACE
   CSS_BACKGROUND_SIZE
   CSS_BORDER_IMAGE
   CSS_BORDER_RADIUS
   CSS_BOX_SHADOW
   CSS_FLEX_BOX
   CSS_HSLA
   CSS_MULTIPLE_BGS
   CSS_OPACITY
   CSS_RGBA
   CSS_TEXT_SHADOW
   CSS_ANIMATIONS
   CSS_COLUMNS
   CSS_GENERATED_CONTENT
   CSS_GRADIENTS
   CSS_REFLECTIONS
   CSS_TRANSFORMS
   CSS_TRANSFORMS3D
   CSS_TRANSITIONS
   APPLICATION_CACHE
   CANVAS
   CANVAS_TEXT
   DRAG_AND_DROP
   HASH_CHANGE
   HISTORY
   AUDIO
   VIDEO
   INDEXED_DB
   INPUT_ATTR_AUTOCOMPLETE
   INPUT_ATTR_AUTOFOCUS
   INPUT_ATTR_LIST
   INPUT_ATTR_PLACEHOLDER
   INPUT_ATTR_MAX
   INPUT_ATTR_MIN
   INPUT_ATTR_MULTIPLE
   INPUT_ATTR_PATTERN
   INPUT_ATTR_REQUIRED
   INPUT_ATTR_STEP
   INPUT_TYPE_SEARCH
   INPUT_TYPE_TEL
   INPUT_TYPE_URL
   INPUT_TYPE_EMAIL
   INPUT_TYPE_DATETIME
   INPUT_TYPE_DATE
   INPUT_TYPE_MONTH
   INPUT_TYPE_WEEK
   INPUT_TYPE_TIME
   INPUT_TYPE_DATETIME_LOCAL
   INPUT_TYPE_NUMBER
   INPUT_TYPE_RANGE
   INPUT_TYPE_COLOR
   LOCAL_STORAGE
   POST_MESSAGE
   SESSION_STORAGE
   WEB_SOCKETS
   WEB_SQL_DATABASE
   WEB_WORKERS
   GEO_LOCATION
   INLINE_SVG
   SMIL
   SVG_HREF
   SVG_CLIP_PATHS
   TOUCH
   WEBGL
   SVG_FILTERS
   SVG_FE_IMAGE]],
 :authoringTool [NINJA SWIFFY],
 :advertiserId string,
 :htmlCode string,
 :active boolean,
 :id string,
 :requiredFlashPluginVersion string,
 :kind string,
 :progressOffset {:offsetSeconds integer, :offsetPercentage integer},
 :creativeAssetSelection
 {:rules
  [{:name string, :assetId string, :targetingTemplateId string}],
  :defaultAssetId string},
 :adTagKeys [string],
 :obaIcon
 {:resourceUrl string,
  :xPosition string,
  :yPosition string,
  :size
  {:id string,
   :width integer,
   :height integer,
   :iab boolean,
   :kind string},
  :program string,
  :iconClickThroughUrl string,
  :iconClickTrackingUrl string,
  :iconViewTrackingUrl string},
 :clickTags
 [{:name string,
   :eventName string,
   :clickThroughUrl
   {:landingPageId string,
    :customClickThroughUrl string,
    :computedClickThroughUrl string}}],
 :lastModifiedInfo {:time string},
 :latestTraffickedCreativeId string,
 :totalFileSize string,
 :redirectUrl string,
 :requiredFlashVersion integer,
 :backupImageTargetWindow
 {:targetWindowOption [NEW_WINDOW CURRENT_WINDOW CUSTOM],
  :customHtml string},
 :subaccountId string,
 :version integer,
 :dynamicAssetSelection boolean,
 :renderingIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :mediaDuration number,
 :autoAdvanceImages boolean,
 :backgroundColor string,
 :companionCreatives [string],
 :accountId string,
 :backupImageReportingLabel string,
 :studioTraffickedCreativeId string,
 :mediaDescription string,
 :htmlCodeLocked boolean,
 :renderingId string}"
  [profileId Creative]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/creatives",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body Creative}))

(defn creatives-patch
  "Updates an existing creative. This method supports patch semantics.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Required. Creative ID.
Creative:
{:archived boolean,
 :counterCustomEvents
 [{:advertiserCustomEventName string,
   :popupWindowProperties
   {:offset {:top integer, :left integer},
    :positionType [CENTER COORDINATES],
    :showMenuBar boolean,
    :showToolBar boolean,
    :title string,
    :showStatusBar boolean,
    :showAddressBar boolean,
    :dimension
    {:id string,
     :width integer,
     :height integer,
     :iab boolean,
     :kind string},
    :showScrollBar boolean},
   :artworkType
   [ARTWORK_TYPE_FLASH
    ARTWORK_TYPE_HTML5
    ARTWORK_TYPE_MIXED
    ARTWORK_TYPE_IMAGE],
   :artworkLabel string,
   :videoReportingId string,
   :advertiserCustomEventId string,
   :id string,
   :targetType
   [TARGET_BLANK TARGET_TOP TARGET_SELF TARGET_PARENT TARGET_POPUP],
   :exitClickThroughUrl
   {:landingPageId string,
    :customClickThroughUrl string,
    :computedClickThroughUrl string},
   :advertiserCustomEventType
   [ADVERTISER_EVENT_TIMER
    ADVERTISER_EVENT_EXIT
    ADVERTISER_EVENT_COUNTER]}],
 :thirdPartyBackupImageImpressionsUrl string,
 :overrideCss string,
 :adParameters string,
 :skippable boolean,
 :allowScriptAccess boolean,
 :customKeyValues [string],
 :studioCreativeId string,
 :idDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :additionalSizes
 [{:id string,
   :width integer,
   :height integer,
   :iab boolean,
   :kind string}],
 :fsCommand
 {:positionOption [CENTERED DISTANCE_FROM_TOP_LEFT_CORNER],
  :top integer,
  :left integer,
  :windowWidth integer,
  :windowHeight integer},
 :backupImageClickThroughUrl
 {:landingPageId string,
  :customClickThroughUrl string,
  :computedClickThroughUrl string},
 :timerCustomEvents
 [{:advertiserCustomEventName string,
   :popupWindowProperties
   {:offset {:top integer, :left integer},
    :positionType [CENTER COORDINATES],
    :showMenuBar boolean,
    :showToolBar boolean,
    :title string,
    :showStatusBar boolean,
    :showAddressBar boolean,
    :dimension
    {:id string,
     :width integer,
     :height integer,
     :iab boolean,
     :kind string},
    :showScrollBar boolean},
   :artworkType
   [ARTWORK_TYPE_FLASH
    ARTWORK_TYPE_HTML5
    ARTWORK_TYPE_MIXED
    ARTWORK_TYPE_IMAGE],
   :artworkLabel string,
   :videoReportingId string,
   :advertiserCustomEventId string,
   :id string,
   :targetType
   [TARGET_BLANK TARGET_TOP TARGET_SELF TARGET_PARENT TARGET_POPUP],
   :exitClickThroughUrl
   {:landingPageId string,
    :customClickThroughUrl string,
    :computedClickThroughUrl string},
   :advertiserCustomEventType
   [ADVERTISER_EVENT_TIMER
    ADVERTISER_EVENT_EXIT
    ADVERTISER_EVENT_COUNTER]}],
 :sslOverride boolean,
 :compatibility
 [[DISPLAY
   DISPLAY_INTERSTITIAL
   APP
   APP_INTERSTITIAL
   IN_STREAM_VIDEO
   IN_STREAM_AUDIO]],
 :sslCompliant boolean,
 :skipOffset {:offsetSeconds integer, :offsetPercentage integer},
 :thirdPartyRichMediaImpressionsUrl string,
 :name string,
 :convertFlashToHtml5 boolean,
 :universalAdId
 {:registry [OTHER AD_ID_OFFICIAL CLEARCAST DCM ARPP], :value string},
 :artworkType
 [ARTWORK_TYPE_FLASH
  ARTWORK_TYPE_HTML5
  ARTWORK_TYPE_MIXED
  ARTWORK_TYPE_IMAGE],
 :authoringSource
 [CREATIVE_AUTHORING_SOURCE_DCM
  CREATIVE_AUTHORING_SOURCE_DBM
  CREATIVE_AUTHORING_SOURCE_STUDIO
  CREATIVE_AUTHORING_SOURCE_GWD
  CREATIVE_AUTHORING_SOURCE_ACS],
 :type
 [IMAGE
  DISPLAY_REDIRECT
  CUSTOM_DISPLAY
  INTERNAL_REDIRECT
  CUSTOM_DISPLAY_INTERSTITIAL
  INTERSTITIAL_INTERNAL_REDIRECT
  TRACKING_TEXT
  RICH_MEDIA_DISPLAY_BANNER
  RICH_MEDIA_INPAGE_FLOATING
  RICH_MEDIA_IM_EXPAND
  RICH_MEDIA_DISPLAY_EXPANDING
  RICH_MEDIA_DISPLAY_INTERSTITIAL
  RICH_MEDIA_DISPLAY_MULTI_FLOATING_INTERSTITIAL
  RICH_MEDIA_MOBILE_IN_APP
  FLASH_INPAGE
  INSTREAM_VIDEO
  VPAID_LINEAR_VIDEO
  VPAID_NON_LINEAR_VIDEO
  INSTREAM_VIDEO_REDIRECT
  RICH_MEDIA_PEEL_DOWN
  HTML5_BANNER
  DISPLAY
  DISPLAY_IMAGE_GALLERY
  BRAND_SAFE_DEFAULT_INSTREAM_VIDEO
  INSTREAM_AUDIO],
 :creativeAssets
 [{:role
   [PRIMARY
    BACKUP_IMAGE
    ADDITIONAL_IMAGE
    ADDITIONAL_FLASH
    PARENT_VIDEO
    TRANSCODED_VIDEO
    OTHER
    ALTERNATE_VIDEO
    PARENT_AUDIO
    TRANSCODED_AUDIO],
   :fileSize string,
   :idDimensionValue
   {:dimensionName string,
    :value string,
    :id string,
    :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
    :kind string,
    :etag string},
   :additionalSizes
   [{:id string,
     :width integer,
     :height integer,
     :iab boolean,
     :kind string}],
   :windowMode [OPAQUE WINDOW TRANSPARENT],
   :bitRate integer,
   :verticallyLocked boolean,
   :offset {:top integer, :left integer},
   :horizontallyLocked boolean,
   :sslCompliant boolean,
   :positionLeftUnit
   [OFFSET_UNIT_PIXEL
    OFFSET_UNIT_PERCENT
    OFFSET_UNIT_PIXEL_FROM_CENTER],
   :frameRate number,
   :alignment
   [ALIGNMENT_TOP ALIGNMENT_RIGHT ALIGNMENT_BOTTOM ALIGNMENT_LEFT],
   :pushdownDuration number,
   :artworkType
   [ARTWORK_TYPE_FLASH
    ARTWORK_TYPE_HTML5
    ARTWORK_TYPE_MIXED
    ARTWORK_TYPE_IMAGE],
   :zipFilesize string,
   :childAssetType
   [CHILD_ASSET_TYPE_FLASH
    CHILD_ASSET_TYPE_VIDEO
    CHILD_ASSET_TYPE_IMAGE
    CHILD_ASSET_TYPE_DATA],
   :startTimeType
   [ASSET_START_TIME_TYPE_NONE ASSET_START_TIME_TYPE_CUSTOM],
   :orientation [LANDSCAPE PORTRAIT SQUARE],
   :flashVersion integer,
   :duration integer,
   :streamingServingUrl string,
   :audioSampleRate integer,
   :displayType
   [ASSET_DISPLAY_TYPE_INPAGE
    ASSET_DISPLAY_TYPE_FLOATING
    ASSET_DISPLAY_TYPE_OVERLAY
    ASSET_DISPLAY_TYPE_EXPANDING
    ASSET_DISPLAY_TYPE_FLASH_IN_FLASH
    ASSET_DISPLAY_TYPE_FLASH_IN_FLASH_EXPANDING
    ASSET_DISPLAY_TYPE_PEEL_DOWN
    ASSET_DISPLAY_TYPE_VPAID_LINEAR
    ASSET_DISPLAY_TYPE_VPAID_NON_LINEAR
    ASSET_DISPLAY_TYPE_BACKDROP],
   :detectedFeatures
   [[CSS_FONT_FACE
     CSS_BACKGROUND_SIZE
     CSS_BORDER_IMAGE
     CSS_BORDER_RADIUS
     CSS_BOX_SHADOW
     CSS_FLEX_BOX
     CSS_HSLA
     CSS_MULTIPLE_BGS
     CSS_OPACITY
     CSS_RGBA
     CSS_TEXT_SHADOW
     CSS_ANIMATIONS
     CSS_COLUMNS
     CSS_GENERATED_CONTENT
     CSS_GRADIENTS
     CSS_REFLECTIONS
     CSS_TRANSFORMS
     CSS_TRANSFORMS3D
     CSS_TRANSITIONS
     APPLICATION_CACHE
     CANVAS
     CANVAS_TEXT
     DRAG_AND_DROP
     HASH_CHANGE
     HISTORY
     AUDIO
     VIDEO
     INDEXED_DB
     INPUT_ATTR_AUTOCOMPLETE
     INPUT_ATTR_AUTOFOCUS
     INPUT_ATTR_LIST
     INPUT_ATTR_PLACEHOLDER
     INPUT_ATTR_MAX
     INPUT_ATTR_MIN
     INPUT_ATTR_MULTIPLE
     INPUT_ATTR_PATTERN
     INPUT_ATTR_REQUIRED
     INPUT_ATTR_STEP
     INPUT_TYPE_SEARCH
     INPUT_TYPE_TEL
     INPUT_TYPE_URL
     INPUT_TYPE_EMAIL
     INPUT_TYPE_DATETIME
     INPUT_TYPE_DATE
     INPUT_TYPE_MONTH
     INPUT_TYPE_WEEK
     INPUT_TYPE_TIME
     INPUT_TYPE_DATETIME_LOCAL
     INPUT_TYPE_NUMBER
     INPUT_TYPE_RANGE
     INPUT_TYPE_COLOR
     LOCAL_STORAGE
     POST_MESSAGE
     SESSION_STORAGE
     WEB_SOCKETS
     WEB_SQL_DATABASE
     WEB_WORKERS
     GEO_LOCATION
     INLINE_SVG
     SMIL
     SVG_HREF
     SVG_CLIP_PATHS
     TOUCH
     WEBGL
     SVG_FILTERS
     SVG_FE_IMAGE]],
   :size
   {:id string,
    :width integer,
    :height integer,
    :iab boolean,
    :kind string},
   :progressiveServingUrl string,
   :originalBackup boolean,
   :collapsedSize
   {:id string,
    :width integer,
    :height integer,
    :iab boolean,
    :kind string},
   :durationType
   [ASSET_DURATION_TYPE_AUTO
    ASSET_DURATION_TYPE_NONE
    ASSET_DURATION_TYPE_CUSTOM],
   :hideFlashObjects boolean,
   :positionTopUnit
   [OFFSET_UNIT_PIXEL
    OFFSET_UNIT_PERCENT
    OFFSET_UNIT_PIXEL_FROM_CENTER],
   :active boolean,
   :id string,
   :customStartTimeValue integer,
   :pushdown boolean,
   :mimeType string,
   :zIndex integer,
   :position {:top integer, :left integer},
   :hideSelectionBoxes boolean,
   :politeLoad boolean,
   :expandedDimension
   {:id string,
    :width integer,
    :height integer,
    :iab boolean,
    :kind string},
   :companionCreativeIds [string],
   :zipFilename string,
   :assetIdentifier
   {:type [IMAGE FLASH VIDEO HTML HTML_IMAGE AUDIO], :name string},
   :mediaDuration number,
   :audioBitRate integer,
   :actionScript3 boolean,
   :transparency boolean,
   :backupImageExit
   {:advertiserCustomEventName string,
    :popupWindowProperties
    {:offset {:top integer, :left integer},
     :positionType [CENTER COORDINATES],
     :showMenuBar boolean,
     :showToolBar boolean,
     :title string,
     :showStatusBar boolean,
     :showAddressBar boolean,
     :dimension
     {:id string,
      :width integer,
      :height integer,
      :iab boolean,
      :kind string},
     :showScrollBar boolean},
    :artworkType
    [ARTWORK_TYPE_FLASH
     ARTWORK_TYPE_HTML5
     ARTWORK_TYPE_MIXED
     ARTWORK_TYPE_IMAGE],
    :artworkLabel string,
    :videoReportingId string,
    :advertiserCustomEventId string,
    :id string,
    :targetType
    [TARGET_BLANK TARGET_TOP TARGET_SELF TARGET_PARENT TARGET_POPUP],
    :exitClickThroughUrl
    {:landingPageId string,
     :customClickThroughUrl string,
     :computedClickThroughUrl string},
    :advertiserCustomEventType
    [ADVERTISER_EVENT_TIMER
     ADVERTISER_EVENT_EXIT
     ADVERTISER_EVENT_COUNTER]}}],
 :exitCustomEvents
 [{:advertiserCustomEventName string,
   :popupWindowProperties
   {:offset {:top integer, :left integer},
    :positionType [CENTER COORDINATES],
    :showMenuBar boolean,
    :showToolBar boolean,
    :title string,
    :showStatusBar boolean,
    :showAddressBar boolean,
    :dimension
    {:id string,
     :width integer,
     :height integer,
     :iab boolean,
     :kind string},
    :showScrollBar boolean},
   :artworkType
   [ARTWORK_TYPE_FLASH
    ARTWORK_TYPE_HTML5
    ARTWORK_TYPE_MIXED
    ARTWORK_TYPE_IMAGE],
   :artworkLabel string,
   :videoReportingId string,
   :advertiserCustomEventId string,
   :id string,
   :targetType
   [TARGET_BLANK TARGET_TOP TARGET_SELF TARGET_PARENT TARGET_POPUP],
   :exitClickThroughUrl
   {:landingPageId string,
    :customClickThroughUrl string,
    :computedClickThroughUrl string},
   :advertiserCustomEventType
   [ADVERTISER_EVENT_TIMER
    ADVERTISER_EVENT_EXIT
    ADVERTISER_EVENT_COUNTER]}],
 :size
 {:id string,
  :width integer,
  :height integer,
  :iab boolean,
  :kind string},
 :studioAdvertiserId string,
 :creativeFieldAssignments
 [{:creativeFieldId string, :creativeFieldValueId string}],
 :thirdPartyUrls
 [{:thirdPartyUrlType
   [IMPRESSION
    CLICK_TRACKING
    VIDEO_START
    VIDEO_FIRST_QUARTILE
    VIDEO_MIDPOINT
    VIDEO_THIRD_QUARTILE
    VIDEO_COMPLETE
    VIDEO_MUTE
    VIDEO_PAUSE
    VIDEO_REWIND
    VIDEO_FULLSCREEN
    VIDEO_STOP
    VIDEO_CUSTOM
    SURVEY
    RICH_MEDIA_IMPRESSION
    RICH_MEDIA_RM_IMPRESSION
    RICH_MEDIA_BACKUP_IMPRESSION
    VIDEO_SKIP
    VIDEO_PROGRESS],
   :url string}],
 :commercialId string,
 :backupImageFeatures
 [[CSS_FONT_FACE
   CSS_BACKGROUND_SIZE
   CSS_BORDER_IMAGE
   CSS_BORDER_RADIUS
   CSS_BOX_SHADOW
   CSS_FLEX_BOX
   CSS_HSLA
   CSS_MULTIPLE_BGS
   CSS_OPACITY
   CSS_RGBA
   CSS_TEXT_SHADOW
   CSS_ANIMATIONS
   CSS_COLUMNS
   CSS_GENERATED_CONTENT
   CSS_GRADIENTS
   CSS_REFLECTIONS
   CSS_TRANSFORMS
   CSS_TRANSFORMS3D
   CSS_TRANSITIONS
   APPLICATION_CACHE
   CANVAS
   CANVAS_TEXT
   DRAG_AND_DROP
   HASH_CHANGE
   HISTORY
   AUDIO
   VIDEO
   INDEXED_DB
   INPUT_ATTR_AUTOCOMPLETE
   INPUT_ATTR_AUTOFOCUS
   INPUT_ATTR_LIST
   INPUT_ATTR_PLACEHOLDER
   INPUT_ATTR_MAX
   INPUT_ATTR_MIN
   INPUT_ATTR_MULTIPLE
   INPUT_ATTR_PATTERN
   INPUT_ATTR_REQUIRED
   INPUT_ATTR_STEP
   INPUT_TYPE_SEARCH
   INPUT_TYPE_TEL
   INPUT_TYPE_URL
   INPUT_TYPE_EMAIL
   INPUT_TYPE_DATETIME
   INPUT_TYPE_DATE
   INPUT_TYPE_MONTH
   INPUT_TYPE_WEEK
   INPUT_TYPE_TIME
   INPUT_TYPE_DATETIME_LOCAL
   INPUT_TYPE_NUMBER
   INPUT_TYPE_RANGE
   INPUT_TYPE_COLOR
   LOCAL_STORAGE
   POST_MESSAGE
   SESSION_STORAGE
   WEB_SOCKETS
   WEB_SQL_DATABASE
   WEB_WORKERS
   GEO_LOCATION
   INLINE_SVG
   SMIL
   SVG_HREF
   SVG_CLIP_PATHS
   TOUCH
   WEBGL
   SVG_FILTERS
   SVG_FE_IMAGE]],
 :authoringTool [NINJA SWIFFY],
 :advertiserId string,
 :htmlCode string,
 :active boolean,
 :id string,
 :requiredFlashPluginVersion string,
 :kind string,
 :progressOffset {:offsetSeconds integer, :offsetPercentage integer},
 :creativeAssetSelection
 {:rules
  [{:name string, :assetId string, :targetingTemplateId string}],
  :defaultAssetId string},
 :adTagKeys [string],
 :obaIcon
 {:resourceUrl string,
  :xPosition string,
  :yPosition string,
  :size
  {:id string,
   :width integer,
   :height integer,
   :iab boolean,
   :kind string},
  :program string,
  :iconClickThroughUrl string,
  :iconClickTrackingUrl string,
  :iconViewTrackingUrl string},
 :clickTags
 [{:name string,
   :eventName string,
   :clickThroughUrl
   {:landingPageId string,
    :customClickThroughUrl string,
    :computedClickThroughUrl string}}],
 :lastModifiedInfo {:time string},
 :latestTraffickedCreativeId string,
 :totalFileSize string,
 :redirectUrl string,
 :requiredFlashVersion integer,
 :backupImageTargetWindow
 {:targetWindowOption [NEW_WINDOW CURRENT_WINDOW CUSTOM],
  :customHtml string},
 :subaccountId string,
 :version integer,
 :dynamicAssetSelection boolean,
 :renderingIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :mediaDuration number,
 :autoAdvanceImages boolean,
 :backgroundColor string,
 :companionCreatives [string],
 :accountId string,
 :backupImageReportingLabel string,
 :studioTraffickedCreativeId string,
 :mediaDescription string,
 :htmlCodeLocked boolean,
 :renderingId string}"
  [profileId id Creative]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/creatives",
     :uri-template-args {:profileId profileId},
     :query-params {:id id},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body Creative}))

(defn accountActiveAdSummaries-get
  "Gets the account's active ad summary by account ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
summaryAccountId <string> Account ID."
  [profileId summaryAccountId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/accountActiveAdSummaries/{+summaryAccountId}",
     :uri-template-args
     {:profileId profileId, :summaryAccountId summaryAccountId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn directorySites-get
  "Gets one directory site by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Directory site ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/directorySites/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn directorySites-insert
  "Inserts a new directory site.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
DirectorySite:
{:id string,
 :name string,
 :url string,
 :kind string,
 :settings
 {:interstitialPlacementAccepted boolean,
  :instreamVideoPlacementAccepted boolean,
  :dfpSettings
  {:dfpNetworkCode string,
   :dfpNetworkName string,
   :pubPaidPlacementAccepted boolean,
   :publisherPortalOnly boolean,
   :programmaticPlacementAccepted boolean},
  :activeViewOptOut boolean},
 :inpageTagFormats
 [[STANDARD
   IFRAME_JAVASCRIPT_INPAGE
   INTERNAL_REDIRECT_INPAGE
   JAVASCRIPT_INPAGE]],
 :interstitialTagFormats
 [[IFRAME_JAVASCRIPT_INTERSTITIAL
   INTERNAL_REDIRECT_INTERSTITIAL
   JAVASCRIPT_INTERSTITIAL]],
 :idDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string}}"
  [profileId DirectorySite]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/directorySites",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body DirectorySite}))

(defn directorySites-list
  "Retrieves a list of directory sites, possibly filtered. This method supports paging.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.

optional:
acceptsInterstitialPlacements <boolean> This search filter is no longer supported and will have no effect on the results returned.
dfpNetworkCode <string> Select only directory sites with this Ad Manager network code.
ids <string> Select only directory sites with these IDs.
acceptsInStreamVideoPlacements <boolean> This search filter is no longer supported and will have no effect on the results returned.
searchString <string> Allows searching for objects by name, ID or URL. Wildcards (*) are allowed. For example, \"directory site*2015\" will return objects with names like \"directory site June 2015\", \"directory site April 2015\", or simply \"directory site 2015\". Most of the searches also add wildcards implicitly at the start and the end of the search string. For example, a search string of \"directory site\" will match objects with name \"my directory site\", \"directory site 2015\" or simply, \"directory site\".
sortField <string> Field by which to sort the list.
active <boolean> Select only active directory sites. Leave blank to retrieve both active and inactive directory sites.
sortOrder <string> Order of sorted results.
acceptsPublisherPaidPlacements <boolean> Select only directory sites that accept publisher paid placements. This field can be left blank.
maxResults <integer> Maximum number of results to return."
  ([profileId] (directorySites-list profileId nil))
  ([profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/directorySites",
       :uri-template-args {:profileId profileId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn conversions-batchinsert
  "Inserts conversions.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
ConversionsBatchInsertRequest:
{:kind string,
 :conversions
 [{:encryptedUserId string,
   :childDirectedTreatment boolean,
   :adUserDataConsent [GRANTED DENIED],
   :treatmentForUnderage boolean,
   :floodlightConfigurationId string,
   :nonPersonalizedAd boolean,
   :dclid string,
   :value number,
   :ordinal string,
   :encryptedUserIdCandidates [string],
   :impressionId string,
   :kind string,
   :timestampMicros string,
   :mobileDeviceId string,
   :limitAdTracking boolean,
   :userIdentifiers
   [{:hashedEmail string,
     :hashedPhoneNumber string,
     :addressInfo
     {:hashedFirstName string,
      :hashedLastName string,
      :city string,
      :state string,
      :countryCode string,
      :postalCode string,
      :hashedStreetAddress string}}],
   :matchId string,
   :customVariables
   [{:type
     [U1
      U2
      U3
      U4
      U5
      U6
      U7
      U8
      U9
      U10
      U11
      U12
      U13
      U14
      U15
      U16
      U17
      U18
      U19
      U20
      U21
      U22
      U23
      U24
      U25
      U26
      U27
      U28
      U29
      U30
      U31
      U32
      U33
      U34
      U35
      U36
      U37
      U38
      U39
      U40
      U41
      U42
      U43
      U44
      U45
      U46
      U47
      U48
      U49
      U50
      U51
      U52
      U53
      U54
      U55
      U56
      U57
      U58
      U59
      U60
      U61
      U62
      U63
      U64
      U65
      U66
      U67
      U68
      U69
      U70
      U71
      U72
      U73
      U74
      U75
      U76
      U77
      U78
      U79
      U80
      U81
      U82
      U83
      U84
      U85
      U86
      U87
      U88
      U89
      U90
      U91
      U92
      U93
      U94
      U95
      U96
      U97
      U98
      U99
      U100],
     :value string,
     :kind string}],
   :quantity string,
   :gclid string,
   :floodlightActivityId string}],
 :encryptionInfo
 {:encryptionEntityType
  [ENCRYPTION_ENTITY_TYPE_UNKNOWN
   DCM_ACCOUNT
   DCM_ADVERTISER
   DBM_PARTNER
   DBM_ADVERTISER
   ADWORDS_CUSTOMER
   DFP_NETWORK_CODE],
  :encryptionEntityId string,
  :encryptionSource
  [ENCRYPTION_SCOPE_UNKNOWN AD_SERVING DATA_TRANSFER],
  :kind string}}"
  [profileId ConversionsBatchInsertRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{profileId}/conversions/batchinsert",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/ddmconversions"],
     :body ConversionsBatchInsertRequest}))

(defn conversions-batchupdate
  "Updates existing conversions.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
ConversionsBatchUpdateRequest:
{:kind string,
 :conversions
 [{:encryptedUserId string,
   :childDirectedTreatment boolean,
   :adUserDataConsent [GRANTED DENIED],
   :treatmentForUnderage boolean,
   :floodlightConfigurationId string,
   :nonPersonalizedAd boolean,
   :dclid string,
   :value number,
   :ordinal string,
   :encryptedUserIdCandidates [string],
   :impressionId string,
   :kind string,
   :timestampMicros string,
   :mobileDeviceId string,
   :limitAdTracking boolean,
   :userIdentifiers
   [{:hashedEmail string,
     :hashedPhoneNumber string,
     :addressInfo
     {:hashedFirstName string,
      :hashedLastName string,
      :city string,
      :state string,
      :countryCode string,
      :postalCode string,
      :hashedStreetAddress string}}],
   :matchId string,
   :customVariables
   [{:type
     [U1
      U2
      U3
      U4
      U5
      U6
      U7
      U8
      U9
      U10
      U11
      U12
      U13
      U14
      U15
      U16
      U17
      U18
      U19
      U20
      U21
      U22
      U23
      U24
      U25
      U26
      U27
      U28
      U29
      U30
      U31
      U32
      U33
      U34
      U35
      U36
      U37
      U38
      U39
      U40
      U41
      U42
      U43
      U44
      U45
      U46
      U47
      U48
      U49
      U50
      U51
      U52
      U53
      U54
      U55
      U56
      U57
      U58
      U59
      U60
      U61
      U62
      U63
      U64
      U65
      U66
      U67
      U68
      U69
      U70
      U71
      U72
      U73
      U74
      U75
      U76
      U77
      U78
      U79
      U80
      U81
      U82
      U83
      U84
      U85
      U86
      U87
      U88
      U89
      U90
      U91
      U92
      U93
      U94
      U95
      U96
      U97
      U98
      U99
      U100],
     :value string,
     :kind string}],
   :quantity string,
   :gclid string,
   :floodlightActivityId string}],
 :encryptionInfo
 {:encryptionEntityType
  [ENCRYPTION_ENTITY_TYPE_UNKNOWN
   DCM_ACCOUNT
   DCM_ADVERTISER
   DBM_PARTNER
   DBM_ADVERTISER
   ADWORDS_CUSTOMER
   DFP_NETWORK_CODE],
  :encryptionEntityId string,
  :encryptionSource
  [ENCRYPTION_SCOPE_UNKNOWN AD_SERVING DATA_TRANSFER],
  :kind string}}"
  [profileId ConversionsBatchUpdateRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{profileId}/conversions/batchupdate",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/ddmconversions"],
     :body ConversionsBatchUpdateRequest}))

(defn floodlightConfigurations-get
  "Gets one floodlight configuration by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Floodlight configuration ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/floodlightConfigurations/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn floodlightConfigurations-list
  "Retrieves a list of floodlight configurations, possibly filtered.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.

optional:
ids <string> Set of IDs of floodlight configurations to retrieve. Required field; otherwise an empty list will be returned."
  ([profileId] (floodlightConfigurations-list profileId nil))
  ([profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/floodlightConfigurations",
       :uri-template-args {:profileId profileId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn floodlightConfigurations-update
  "Updates an existing floodlight configuration.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
FloodlightConfiguration:
{:customViewabilityMetric
 {:id string,
  :name string,
  :configuration
  {:viewabilityPercent integer,
   :audible boolean,
   :timeMillis integer,
   :timePercent integer}},
 :inAppAttributionTrackingEnabled boolean,
 :thirdPartyAuthenticationTokens [{:name string, :value string}],
 :idDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :advertiserIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :userDefinedVariableConfigurations
 [{:variableType
   [U1
    U2
    U3
    U4
    U5
    U6
    U7
    U8
    U9
    U10
    U11
    U12
    U13
    U14
    U15
    U16
    U17
    U18
    U19
    U20
    U21
    U22
    U23
    U24
    U25
    U26
    U27
    U28
    U29
    U30
    U31
    U32
    U33
    U34
    U35
    U36
    U37
    U38
    U39
    U40
    U41
    U42
    U43
    U44
    U45
    U46
    U47
    U48
    U49
    U50
    U51
    U52
    U53
    U54
    U55
    U56
    U57
    U58
    U59
    U60
    U61
    U62
    U63
    U64
    U65
    U66
    U67
    U68
    U69
    U70
    U71
    U72
    U73
    U74
    U75
    U76
    U77
    U78
    U79
    U80
    U81
    U82
    U83
    U84
    U85
    U86
    U87
    U88
    U89
    U90
    U91
    U92
    U93
    U94
    U95
    U96
    U97
    U98
    U99
    U100],
   :dataType [STRING NUMBER],
   :reportName string}],
 :naturalSearchConversionAttributionOption
 [EXCLUDE_NATURAL_SEARCH_CONVERSION_ATTRIBUTION
  INCLUDE_NATURAL_SEARCH_CONVERSION_ATTRIBUTION
  INCLUDE_NATURAL_SEARCH_TIERED_CONVERSION_ATTRIBUTION],
 :analyticsDataSharingEnabled boolean,
 :advertiserId string,
 :id string,
 :firstDayOfWeek [SUNDAY MONDAY],
 :kind string,
 :omnitureSettings
 {:omnitureIntegrationEnabled boolean,
  :omnitureCostDataEnabled boolean},
 :lookbackConfiguration
 {:clickDuration integer, :postImpressionActivitiesDuration integer},
 :tagSettings {:dynamicTagEnabled boolean, :imageTagEnabled boolean},
 :subaccountId string,
 :accountId string,
 :exposureToConversionEnabled boolean}"
  [profileId FloodlightConfiguration]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/floodlightConfigurations",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body FloodlightConfiguration}))

(defn floodlightConfigurations-patch
  "Updates an existing floodlight configuration. This method supports patch semantics.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Required. EventTag ID.
FloodlightConfiguration:
{:customViewabilityMetric
 {:id string,
  :name string,
  :configuration
  {:viewabilityPercent integer,
   :audible boolean,
   :timeMillis integer,
   :timePercent integer}},
 :inAppAttributionTrackingEnabled boolean,
 :thirdPartyAuthenticationTokens [{:name string, :value string}],
 :idDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :advertiserIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :userDefinedVariableConfigurations
 [{:variableType
   [U1
    U2
    U3
    U4
    U5
    U6
    U7
    U8
    U9
    U10
    U11
    U12
    U13
    U14
    U15
    U16
    U17
    U18
    U19
    U20
    U21
    U22
    U23
    U24
    U25
    U26
    U27
    U28
    U29
    U30
    U31
    U32
    U33
    U34
    U35
    U36
    U37
    U38
    U39
    U40
    U41
    U42
    U43
    U44
    U45
    U46
    U47
    U48
    U49
    U50
    U51
    U52
    U53
    U54
    U55
    U56
    U57
    U58
    U59
    U60
    U61
    U62
    U63
    U64
    U65
    U66
    U67
    U68
    U69
    U70
    U71
    U72
    U73
    U74
    U75
    U76
    U77
    U78
    U79
    U80
    U81
    U82
    U83
    U84
    U85
    U86
    U87
    U88
    U89
    U90
    U91
    U92
    U93
    U94
    U95
    U96
    U97
    U98
    U99
    U100],
   :dataType [STRING NUMBER],
   :reportName string}],
 :naturalSearchConversionAttributionOption
 [EXCLUDE_NATURAL_SEARCH_CONVERSION_ATTRIBUTION
  INCLUDE_NATURAL_SEARCH_CONVERSION_ATTRIBUTION
  INCLUDE_NATURAL_SEARCH_TIERED_CONVERSION_ATTRIBUTION],
 :analyticsDataSharingEnabled boolean,
 :advertiserId string,
 :id string,
 :firstDayOfWeek [SUNDAY MONDAY],
 :kind string,
 :omnitureSettings
 {:omnitureIntegrationEnabled boolean,
  :omnitureCostDataEnabled boolean},
 :lookbackConfiguration
 {:clickDuration integer, :postImpressionActivitiesDuration integer},
 :tagSettings {:dynamicTagEnabled boolean, :imageTagEnabled boolean},
 :subaccountId string,
 :accountId string,
 :exposureToConversionEnabled boolean}"
  [profileId id FloodlightConfiguration]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/floodlightConfigurations",
     :uri-template-args {:profileId profileId},
     :query-params {:id id},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body FloodlightConfiguration}))

(defn files-get
  "Retrieves a report file by its report ID and file ID. This method supports media download.
https://developers.google.com/doubleclick-advertisers

reportId <string> The ID of the report.
fileId <string> The ID of the report file."
  [reportId fileId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/reports/{reportId}/files/{fileId}",
     :uri-template-args {:reportId reportId, :fileId fileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfareporting"]}))

(defn files-list
  "Lists files for a user profile.
https://developers.google.com/doubleclick-advertisers

profileId <string> The Campaign Manager 360 user profile ID.

optional:
maxResults <integer> Maximum number of results to return.
scope <string> The scope that defines which results are returned.
sortField <string> The field by which to sort the list.
sortOrder <string> Order of sorted results."
  ([profileId] (files-list profileId nil))
  ([profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{profileId}/files",
       :uri-template-args {:profileId profileId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfareporting"]})))

(defn reports-delete
  "Deletes a report by its ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> The Campaign Manager 360 user profile ID.
reportId <string> The ID of the report."
  [profileId reportId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{profileId}/reports/{reportId}",
     :uri-template-args {:profileId profileId, :reportId reportId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfareporting"]}))

(defn reports-get
  "Retrieves a report by its ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> The Campaign Manager 360 user profile ID.
reportId <string> The ID of the report."
  [profileId reportId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{profileId}/reports/{reportId}",
     :uri-template-args {:profileId profileId, :reportId reportId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfareporting"]}))

(defn reports-insert
  "Creates a report.
https://developers.google.com/doubleclick-advertisers

profileId <string> The Campaign Manager 360 user profile ID.
Report:
{:floodlightCriteria
 {:dateRange
  {:startDate string,
   :endDate string,
   :relativeDateRange
   [TODAY
    YESTERDAY
    WEEK_TO_DATE
    MONTH_TO_DATE
    QUARTER_TO_DATE
    YEAR_TO_DATE
    PREVIOUS_WEEK
    PREVIOUS_MONTH
    PREVIOUS_QUARTER
    PREVIOUS_YEAR
    LAST_7_DAYS
    LAST_30_DAYS
    LAST_90_DAYS
    LAST_365_DAYS
    LAST_24_MONTHS
    LAST_14_DAYS
    LAST_60_DAYS],
   :kind string},
  :floodlightConfigId
  {:dimensionName string,
   :value string,
   :id string,
   :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
   :kind string,
   :etag string},
  :dimensionFilters
  [{:dimensionName string,
    :value string,
    :id string,
    :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
    :kind string,
    :etag string}],
  :dimensions
  [{:name string, :sortOrder [ASCENDING DESCENDING], :kind string}],
  :metricNames [string],
  :customRichMediaEvents
  [{:dimensionName string,
    :value string,
    :id string,
    :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
    :kind string,
    :etag string}],
  :reportProperties
  {:includeAttributedIPConversions boolean,
   :includeUnattributedCookieConversions boolean,
   :includeUnattributedIPConversions boolean}},
 :schedule
 {:active boolean,
  :repeats string,
  :repeatsOnWeekDays
  [[SUNDAY MONDAY TUESDAY WEDNESDAY THURSDAY FRIDAY SATURDAY]],
  :every integer,
  :startDate string,
  :expirationDate string,
  :runsOnDayOfMonth [DAY_OF_MONTH WEEK_OF_MONTH],
  :timezone string},
 :format [CSV EXCEL],
 :subAccountId string,
 :name string,
 :fileName string,
 :criteria
 {:dateRange
  {:startDate string,
   :endDate string,
   :relativeDateRange
   [TODAY
    YESTERDAY
    WEEK_TO_DATE
    MONTH_TO_DATE
    QUARTER_TO_DATE
    YEAR_TO_DATE
    PREVIOUS_WEEK
    PREVIOUS_MONTH
    PREVIOUS_QUARTER
    PREVIOUS_YEAR
    LAST_7_DAYS
    LAST_30_DAYS
    LAST_90_DAYS
    LAST_365_DAYS
    LAST_24_MONTHS
    LAST_14_DAYS
    LAST_60_DAYS],
   :kind string},
  :dimensions
  [{:name string, :sortOrder [ASCENDING DESCENDING], :kind string}],
  :metricNames [string],
  :dimensionFilters
  [{:dimensionName string,
    :value string,
    :id string,
    :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
    :kind string,
    :etag string}],
  :activities
  {:filters
   [{:dimensionName string,
     :value string,
     :id string,
     :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
     :kind string,
     :etag string}],
   :metricNames [string],
   :kind string},
  :customRichMediaEvents
  {:filteredEventIds
   [{:dimensionName string,
     :value string,
     :id string,
     :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
     :kind string,
     :etag string}],
   :kind string}},
 :delivery
 {:emailOwner boolean,
  :emailOwnerDeliveryType [LINK ATTACHMENT],
  :message string,
  :recipients
  [{:email string, :deliveryType [LINK ATTACHMENT], :kind string}]},
 :type
 [STANDARD REACH PATH_TO_CONVERSION CROSS_DIMENSION_REACH FLOODLIGHT],
 :etag string,
 :reachCriteria
 {:dateRange
  {:startDate string,
   :endDate string,
   :relativeDateRange
   [TODAY
    YESTERDAY
    WEEK_TO_DATE
    MONTH_TO_DATE
    QUARTER_TO_DATE
    YEAR_TO_DATE
    PREVIOUS_WEEK
    PREVIOUS_MONTH
    PREVIOUS_QUARTER
    PREVIOUS_YEAR
    LAST_7_DAYS
    LAST_30_DAYS
    LAST_90_DAYS
    LAST_365_DAYS
    LAST_24_MONTHS
    LAST_14_DAYS
    LAST_60_DAYS],
   :kind string},
  :dimensions
  [{:name string, :sortOrder [ASCENDING DESCENDING], :kind string}],
  :metricNames [string],
  :dimensionFilters
  [{:dimensionName string,
    :value string,
    :id string,
    :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
    :kind string,
    :etag string}],
  :activities
  {:filters
   [{:dimensionName string,
     :value string,
     :id string,
     :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
     :kind string,
     :etag string}],
   :metricNames [string],
   :kind string},
  :customRichMediaEvents
  {:filteredEventIds
   [{:dimensionName string,
     :value string,
     :id string,
     :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
     :kind string,
     :etag string}],
   :kind string},
  :reachByFrequencyMetricNames [string],
  :enableAllDimensionCombinations boolean},
 :pathToConversionCriteria
 {:dateRange
  {:startDate string,
   :endDate string,
   :relativeDateRange
   [TODAY
    YESTERDAY
    WEEK_TO_DATE
    MONTH_TO_DATE
    QUARTER_TO_DATE
    YEAR_TO_DATE
    PREVIOUS_WEEK
    PREVIOUS_MONTH
    PREVIOUS_QUARTER
    PREVIOUS_YEAR
    LAST_7_DAYS
    LAST_30_DAYS
    LAST_90_DAYS
    LAST_365_DAYS
    LAST_24_MONTHS
    LAST_14_DAYS
    LAST_60_DAYS],
   :kind string},
  :conversionDimensions
  [{:name string, :sortOrder [ASCENDING DESCENDING], :kind string}],
  :customRichMediaEvents
  [{:dimensionName string,
    :value string,
    :id string,
    :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
    :kind string,
    :etag string}],
  :reportProperties
  {:maximumInteractionGap integer,
   :includeAttributedIPConversions boolean,
   :includeUnattributedIPConversions boolean,
   :clicksLookbackWindow integer,
   :includeUnattributedCookieConversions boolean,
   :impressionsLookbackWindow integer,
   :maximumClickInteractions integer,
   :pivotOnInteractionPath boolean,
   :maximumImpressionInteractions integer},
  :activityFilters
  [{:dimensionName string,
    :value string,
    :id string,
    :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
    :kind string,
    :etag string}],
  :customFloodlightVariables
  [{:name string, :sortOrder [ASCENDING DESCENDING], :kind string}],
  :perInteractionDimensions
  [{:name string, :sortOrder [ASCENDING DESCENDING], :kind string}],
  :metricNames [string],
  :floodlightConfigId
  {:dimensionName string,
   :value string,
   :id string,
   :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
   :kind string,
   :etag string}},
 :lastModifiedTime string,
 :id string,
 :kind string,
 :ownerProfileId string,
 :accountId string,
 :crossDimensionReachCriteria
 {:dateRange
  {:startDate string,
   :endDate string,
   :relativeDateRange
   [TODAY
    YESTERDAY
    WEEK_TO_DATE
    MONTH_TO_DATE
    QUARTER_TO_DATE
    YEAR_TO_DATE
    PREVIOUS_WEEK
    PREVIOUS_MONTH
    PREVIOUS_QUARTER
    PREVIOUS_YEAR
    LAST_7_DAYS
    LAST_30_DAYS
    LAST_90_DAYS
    LAST_365_DAYS
    LAST_24_MONTHS
    LAST_14_DAYS
    LAST_60_DAYS],
   :kind string},
  :dimension [ADVERTISER CAMPAIGN SITE_BY_ADVERTISER SITE_BY_CAMPAIGN],
  :pivoted boolean,
  :dimensionFilters
  [{:dimensionName string,
    :value string,
    :id string,
    :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
    :kind string,
    :etag string}],
  :breakdown
  [{:name string, :sortOrder [ASCENDING DESCENDING], :kind string}],
  :metricNames [string],
  :overlapMetricNames [string]}}"
  [profileId Report]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{profileId}/reports",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfareporting"],
     :body Report}))

(defn reports-list
  "Retrieves list of reports.
https://developers.google.com/doubleclick-advertisers

profileId <string> The Campaign Manager 360 user profile ID.

optional:
maxResults <integer> Maximum number of results to return.
scope <string> The scope that defines which results are returned.
sortField <string> The field by which to sort the list.
sortOrder <string> Order of sorted results."
  ([profileId] (reports-list profileId nil))
  ([profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{profileId}/reports",
       :uri-template-args {:profileId profileId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfareporting"]})))

(defn reports-run
  "Runs a report.
https://developers.google.com/doubleclick-advertisers

profileId <string> The Campaign Manager 360 user profile ID.
reportId <string> The ID of the report.

optional:
synchronous <boolean> If set and true, tries to run the report synchronously."
  ([profileId reportId] (reports-run profileId reportId nil))
  ([profileId reportId optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{profileId}/reports/{reportId}/run",
       :uri-template-args {:profileId profileId, :reportId reportId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfareporting"]})))

(defn reports-update
  "Updates a report.
https://developers.google.com/doubleclick-advertisers

profileId <string> The Campaign Manager 360 user profile ID.
reportId <string> The ID of the report.
Report:
{:floodlightCriteria
 {:dateRange
  {:startDate string,
   :endDate string,
   :relativeDateRange
   [TODAY
    YESTERDAY
    WEEK_TO_DATE
    MONTH_TO_DATE
    QUARTER_TO_DATE
    YEAR_TO_DATE
    PREVIOUS_WEEK
    PREVIOUS_MONTH
    PREVIOUS_QUARTER
    PREVIOUS_YEAR
    LAST_7_DAYS
    LAST_30_DAYS
    LAST_90_DAYS
    LAST_365_DAYS
    LAST_24_MONTHS
    LAST_14_DAYS
    LAST_60_DAYS],
   :kind string},
  :floodlightConfigId
  {:dimensionName string,
   :value string,
   :id string,
   :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
   :kind string,
   :etag string},
  :dimensionFilters
  [{:dimensionName string,
    :value string,
    :id string,
    :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
    :kind string,
    :etag string}],
  :dimensions
  [{:name string, :sortOrder [ASCENDING DESCENDING], :kind string}],
  :metricNames [string],
  :customRichMediaEvents
  [{:dimensionName string,
    :value string,
    :id string,
    :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
    :kind string,
    :etag string}],
  :reportProperties
  {:includeAttributedIPConversions boolean,
   :includeUnattributedCookieConversions boolean,
   :includeUnattributedIPConversions boolean}},
 :schedule
 {:active boolean,
  :repeats string,
  :repeatsOnWeekDays
  [[SUNDAY MONDAY TUESDAY WEDNESDAY THURSDAY FRIDAY SATURDAY]],
  :every integer,
  :startDate string,
  :expirationDate string,
  :runsOnDayOfMonth [DAY_OF_MONTH WEEK_OF_MONTH],
  :timezone string},
 :format [CSV EXCEL],
 :subAccountId string,
 :name string,
 :fileName string,
 :criteria
 {:dateRange
  {:startDate string,
   :endDate string,
   :relativeDateRange
   [TODAY
    YESTERDAY
    WEEK_TO_DATE
    MONTH_TO_DATE
    QUARTER_TO_DATE
    YEAR_TO_DATE
    PREVIOUS_WEEK
    PREVIOUS_MONTH
    PREVIOUS_QUARTER
    PREVIOUS_YEAR
    LAST_7_DAYS
    LAST_30_DAYS
    LAST_90_DAYS
    LAST_365_DAYS
    LAST_24_MONTHS
    LAST_14_DAYS
    LAST_60_DAYS],
   :kind string},
  :dimensions
  [{:name string, :sortOrder [ASCENDING DESCENDING], :kind string}],
  :metricNames [string],
  :dimensionFilters
  [{:dimensionName string,
    :value string,
    :id string,
    :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
    :kind string,
    :etag string}],
  :activities
  {:filters
   [{:dimensionName string,
     :value string,
     :id string,
     :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
     :kind string,
     :etag string}],
   :metricNames [string],
   :kind string},
  :customRichMediaEvents
  {:filteredEventIds
   [{:dimensionName string,
     :value string,
     :id string,
     :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
     :kind string,
     :etag string}],
   :kind string}},
 :delivery
 {:emailOwner boolean,
  :emailOwnerDeliveryType [LINK ATTACHMENT],
  :message string,
  :recipients
  [{:email string, :deliveryType [LINK ATTACHMENT], :kind string}]},
 :type
 [STANDARD REACH PATH_TO_CONVERSION CROSS_DIMENSION_REACH FLOODLIGHT],
 :etag string,
 :reachCriteria
 {:dateRange
  {:startDate string,
   :endDate string,
   :relativeDateRange
   [TODAY
    YESTERDAY
    WEEK_TO_DATE
    MONTH_TO_DATE
    QUARTER_TO_DATE
    YEAR_TO_DATE
    PREVIOUS_WEEK
    PREVIOUS_MONTH
    PREVIOUS_QUARTER
    PREVIOUS_YEAR
    LAST_7_DAYS
    LAST_30_DAYS
    LAST_90_DAYS
    LAST_365_DAYS
    LAST_24_MONTHS
    LAST_14_DAYS
    LAST_60_DAYS],
   :kind string},
  :dimensions
  [{:name string, :sortOrder [ASCENDING DESCENDING], :kind string}],
  :metricNames [string],
  :dimensionFilters
  [{:dimensionName string,
    :value string,
    :id string,
    :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
    :kind string,
    :etag string}],
  :activities
  {:filters
   [{:dimensionName string,
     :value string,
     :id string,
     :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
     :kind string,
     :etag string}],
   :metricNames [string],
   :kind string},
  :customRichMediaEvents
  {:filteredEventIds
   [{:dimensionName string,
     :value string,
     :id string,
     :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
     :kind string,
     :etag string}],
   :kind string},
  :reachByFrequencyMetricNames [string],
  :enableAllDimensionCombinations boolean},
 :pathToConversionCriteria
 {:dateRange
  {:startDate string,
   :endDate string,
   :relativeDateRange
   [TODAY
    YESTERDAY
    WEEK_TO_DATE
    MONTH_TO_DATE
    QUARTER_TO_DATE
    YEAR_TO_DATE
    PREVIOUS_WEEK
    PREVIOUS_MONTH
    PREVIOUS_QUARTER
    PREVIOUS_YEAR
    LAST_7_DAYS
    LAST_30_DAYS
    LAST_90_DAYS
    LAST_365_DAYS
    LAST_24_MONTHS
    LAST_14_DAYS
    LAST_60_DAYS],
   :kind string},
  :conversionDimensions
  [{:name string, :sortOrder [ASCENDING DESCENDING], :kind string}],
  :customRichMediaEvents
  [{:dimensionName string,
    :value string,
    :id string,
    :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
    :kind string,
    :etag string}],
  :reportProperties
  {:maximumInteractionGap integer,
   :includeAttributedIPConversions boolean,
   :includeUnattributedIPConversions boolean,
   :clicksLookbackWindow integer,
   :includeUnattributedCookieConversions boolean,
   :impressionsLookbackWindow integer,
   :maximumClickInteractions integer,
   :pivotOnInteractionPath boolean,
   :maximumImpressionInteractions integer},
  :activityFilters
  [{:dimensionName string,
    :value string,
    :id string,
    :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
    :kind string,
    :etag string}],
  :customFloodlightVariables
  [{:name string, :sortOrder [ASCENDING DESCENDING], :kind string}],
  :perInteractionDimensions
  [{:name string, :sortOrder [ASCENDING DESCENDING], :kind string}],
  :metricNames [string],
  :floodlightConfigId
  {:dimensionName string,
   :value string,
   :id string,
   :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
   :kind string,
   :etag string}},
 :lastModifiedTime string,
 :id string,
 :kind string,
 :ownerProfileId string,
 :accountId string,
 :crossDimensionReachCriteria
 {:dateRange
  {:startDate string,
   :endDate string,
   :relativeDateRange
   [TODAY
    YESTERDAY
    WEEK_TO_DATE
    MONTH_TO_DATE
    QUARTER_TO_DATE
    YEAR_TO_DATE
    PREVIOUS_WEEK
    PREVIOUS_MONTH
    PREVIOUS_QUARTER
    PREVIOUS_YEAR
    LAST_7_DAYS
    LAST_30_DAYS
    LAST_90_DAYS
    LAST_365_DAYS
    LAST_24_MONTHS
    LAST_14_DAYS
    LAST_60_DAYS],
   :kind string},
  :dimension [ADVERTISER CAMPAIGN SITE_BY_ADVERTISER SITE_BY_CAMPAIGN],
  :pivoted boolean,
  :dimensionFilters
  [{:dimensionName string,
    :value string,
    :id string,
    :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
    :kind string,
    :etag string}],
  :breakdown
  [{:name string, :sortOrder [ASCENDING DESCENDING], :kind string}],
  :metricNames [string],
  :overlapMetricNames [string]}}"
  [profileId reportId Report]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{profileId}/reports/{reportId}",
     :uri-template-args {:profileId profileId, :reportId reportId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfareporting"],
     :body Report}))

(defn reports-patch
  "Updates an existing report. This method supports patch semantics.
https://developers.google.com/doubleclick-advertisers

profileId <string> The Campaign Manager 360 user profile ID.
reportId <string> The ID of the report.
Report:
{:floodlightCriteria
 {:dateRange
  {:startDate string,
   :endDate string,
   :relativeDateRange
   [TODAY
    YESTERDAY
    WEEK_TO_DATE
    MONTH_TO_DATE
    QUARTER_TO_DATE
    YEAR_TO_DATE
    PREVIOUS_WEEK
    PREVIOUS_MONTH
    PREVIOUS_QUARTER
    PREVIOUS_YEAR
    LAST_7_DAYS
    LAST_30_DAYS
    LAST_90_DAYS
    LAST_365_DAYS
    LAST_24_MONTHS
    LAST_14_DAYS
    LAST_60_DAYS],
   :kind string},
  :floodlightConfigId
  {:dimensionName string,
   :value string,
   :id string,
   :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
   :kind string,
   :etag string},
  :dimensionFilters
  [{:dimensionName string,
    :value string,
    :id string,
    :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
    :kind string,
    :etag string}],
  :dimensions
  [{:name string, :sortOrder [ASCENDING DESCENDING], :kind string}],
  :metricNames [string],
  :customRichMediaEvents
  [{:dimensionName string,
    :value string,
    :id string,
    :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
    :kind string,
    :etag string}],
  :reportProperties
  {:includeAttributedIPConversions boolean,
   :includeUnattributedCookieConversions boolean,
   :includeUnattributedIPConversions boolean}},
 :schedule
 {:active boolean,
  :repeats string,
  :repeatsOnWeekDays
  [[SUNDAY MONDAY TUESDAY WEDNESDAY THURSDAY FRIDAY SATURDAY]],
  :every integer,
  :startDate string,
  :expirationDate string,
  :runsOnDayOfMonth [DAY_OF_MONTH WEEK_OF_MONTH],
  :timezone string},
 :format [CSV EXCEL],
 :subAccountId string,
 :name string,
 :fileName string,
 :criteria
 {:dateRange
  {:startDate string,
   :endDate string,
   :relativeDateRange
   [TODAY
    YESTERDAY
    WEEK_TO_DATE
    MONTH_TO_DATE
    QUARTER_TO_DATE
    YEAR_TO_DATE
    PREVIOUS_WEEK
    PREVIOUS_MONTH
    PREVIOUS_QUARTER
    PREVIOUS_YEAR
    LAST_7_DAYS
    LAST_30_DAYS
    LAST_90_DAYS
    LAST_365_DAYS
    LAST_24_MONTHS
    LAST_14_DAYS
    LAST_60_DAYS],
   :kind string},
  :dimensions
  [{:name string, :sortOrder [ASCENDING DESCENDING], :kind string}],
  :metricNames [string],
  :dimensionFilters
  [{:dimensionName string,
    :value string,
    :id string,
    :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
    :kind string,
    :etag string}],
  :activities
  {:filters
   [{:dimensionName string,
     :value string,
     :id string,
     :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
     :kind string,
     :etag string}],
   :metricNames [string],
   :kind string},
  :customRichMediaEvents
  {:filteredEventIds
   [{:dimensionName string,
     :value string,
     :id string,
     :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
     :kind string,
     :etag string}],
   :kind string}},
 :delivery
 {:emailOwner boolean,
  :emailOwnerDeliveryType [LINK ATTACHMENT],
  :message string,
  :recipients
  [{:email string, :deliveryType [LINK ATTACHMENT], :kind string}]},
 :type
 [STANDARD REACH PATH_TO_CONVERSION CROSS_DIMENSION_REACH FLOODLIGHT],
 :etag string,
 :reachCriteria
 {:dateRange
  {:startDate string,
   :endDate string,
   :relativeDateRange
   [TODAY
    YESTERDAY
    WEEK_TO_DATE
    MONTH_TO_DATE
    QUARTER_TO_DATE
    YEAR_TO_DATE
    PREVIOUS_WEEK
    PREVIOUS_MONTH
    PREVIOUS_QUARTER
    PREVIOUS_YEAR
    LAST_7_DAYS
    LAST_30_DAYS
    LAST_90_DAYS
    LAST_365_DAYS
    LAST_24_MONTHS
    LAST_14_DAYS
    LAST_60_DAYS],
   :kind string},
  :dimensions
  [{:name string, :sortOrder [ASCENDING DESCENDING], :kind string}],
  :metricNames [string],
  :dimensionFilters
  [{:dimensionName string,
    :value string,
    :id string,
    :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
    :kind string,
    :etag string}],
  :activities
  {:filters
   [{:dimensionName string,
     :value string,
     :id string,
     :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
     :kind string,
     :etag string}],
   :metricNames [string],
   :kind string},
  :customRichMediaEvents
  {:filteredEventIds
   [{:dimensionName string,
     :value string,
     :id string,
     :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
     :kind string,
     :etag string}],
   :kind string},
  :reachByFrequencyMetricNames [string],
  :enableAllDimensionCombinations boolean},
 :pathToConversionCriteria
 {:dateRange
  {:startDate string,
   :endDate string,
   :relativeDateRange
   [TODAY
    YESTERDAY
    WEEK_TO_DATE
    MONTH_TO_DATE
    QUARTER_TO_DATE
    YEAR_TO_DATE
    PREVIOUS_WEEK
    PREVIOUS_MONTH
    PREVIOUS_QUARTER
    PREVIOUS_YEAR
    LAST_7_DAYS
    LAST_30_DAYS
    LAST_90_DAYS
    LAST_365_DAYS
    LAST_24_MONTHS
    LAST_14_DAYS
    LAST_60_DAYS],
   :kind string},
  :conversionDimensions
  [{:name string, :sortOrder [ASCENDING DESCENDING], :kind string}],
  :customRichMediaEvents
  [{:dimensionName string,
    :value string,
    :id string,
    :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
    :kind string,
    :etag string}],
  :reportProperties
  {:maximumInteractionGap integer,
   :includeAttributedIPConversions boolean,
   :includeUnattributedIPConversions boolean,
   :clicksLookbackWindow integer,
   :includeUnattributedCookieConversions boolean,
   :impressionsLookbackWindow integer,
   :maximumClickInteractions integer,
   :pivotOnInteractionPath boolean,
   :maximumImpressionInteractions integer},
  :activityFilters
  [{:dimensionName string,
    :value string,
    :id string,
    :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
    :kind string,
    :etag string}],
  :customFloodlightVariables
  [{:name string, :sortOrder [ASCENDING DESCENDING], :kind string}],
  :perInteractionDimensions
  [{:name string, :sortOrder [ASCENDING DESCENDING], :kind string}],
  :metricNames [string],
  :floodlightConfigId
  {:dimensionName string,
   :value string,
   :id string,
   :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
   :kind string,
   :etag string}},
 :lastModifiedTime string,
 :id string,
 :kind string,
 :ownerProfileId string,
 :accountId string,
 :crossDimensionReachCriteria
 {:dateRange
  {:startDate string,
   :endDate string,
   :relativeDateRange
   [TODAY
    YESTERDAY
    WEEK_TO_DATE
    MONTH_TO_DATE
    QUARTER_TO_DATE
    YEAR_TO_DATE
    PREVIOUS_WEEK
    PREVIOUS_MONTH
    PREVIOUS_QUARTER
    PREVIOUS_YEAR
    LAST_7_DAYS
    LAST_30_DAYS
    LAST_90_DAYS
    LAST_365_DAYS
    LAST_24_MONTHS
    LAST_14_DAYS
    LAST_60_DAYS],
   :kind string},
  :dimension [ADVERTISER CAMPAIGN SITE_BY_ADVERTISER SITE_BY_CAMPAIGN],
  :pivoted boolean,
  :dimensionFilters
  [{:dimensionName string,
    :value string,
    :id string,
    :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
    :kind string,
    :etag string}],
  :breakdown
  [{:name string, :sortOrder [ASCENDING DESCENDING], :kind string}],
  :metricNames [string],
  :overlapMetricNames [string]}}"
  [profileId reportId Report]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{profileId}/reports/{reportId}",
     :uri-template-args {:profileId profileId, :reportId reportId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfareporting"],
     :body Report}))

(defn reports-files-get
  "Retrieves a report file by its report ID and file ID. This method supports media download.
https://developers.google.com/doubleclick-advertisers

profileId <string> The Campaign Manager 360 user profile ID.
reportId <string> The ID of the report.
fileId <string> The ID of the report file."
  [profileId reportId fileId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{profileId}/reports/{reportId}/files/{fileId}",
     :uri-template-args
     {:profileId profileId, :reportId reportId, :fileId fileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfareporting"]}))

(defn reports-files-list
  "Lists files for a report.
https://developers.google.com/doubleclick-advertisers

profileId <string> The Campaign Manager 360 user profile ID.
reportId <string> The ID of the parent report.

optional:
sortField <string> The field by which to sort the list.
sortOrder <string> Order of sorted results.
maxResults <integer> Maximum number of results to return."
  ([profileId reportId] (reports-files-list profileId reportId nil))
  ([profileId reportId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{profileId}/reports/{reportId}/files",
       :uri-template-args {:profileId profileId, :reportId reportId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfareporting"]})))

(defn reports-compatibleFields-query
  "Returns the fields that are compatible to be selected in the respective sections of a report criteria, given the fields already selected in the input report and user permissions.
https://developers.google.com/doubleclick-advertisers

profileId <string> The Campaign Manager 360 user profile ID.
Report:
{:floodlightCriteria
 {:dateRange
  {:startDate string,
   :endDate string,
   :relativeDateRange
   [TODAY
    YESTERDAY
    WEEK_TO_DATE
    MONTH_TO_DATE
    QUARTER_TO_DATE
    YEAR_TO_DATE
    PREVIOUS_WEEK
    PREVIOUS_MONTH
    PREVIOUS_QUARTER
    PREVIOUS_YEAR
    LAST_7_DAYS
    LAST_30_DAYS
    LAST_90_DAYS
    LAST_365_DAYS
    LAST_24_MONTHS
    LAST_14_DAYS
    LAST_60_DAYS],
   :kind string},
  :floodlightConfigId
  {:dimensionName string,
   :value string,
   :id string,
   :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
   :kind string,
   :etag string},
  :dimensionFilters
  [{:dimensionName string,
    :value string,
    :id string,
    :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
    :kind string,
    :etag string}],
  :dimensions
  [{:name string, :sortOrder [ASCENDING DESCENDING], :kind string}],
  :metricNames [string],
  :customRichMediaEvents
  [{:dimensionName string,
    :value string,
    :id string,
    :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
    :kind string,
    :etag string}],
  :reportProperties
  {:includeAttributedIPConversions boolean,
   :includeUnattributedCookieConversions boolean,
   :includeUnattributedIPConversions boolean}},
 :schedule
 {:active boolean,
  :repeats string,
  :repeatsOnWeekDays
  [[SUNDAY MONDAY TUESDAY WEDNESDAY THURSDAY FRIDAY SATURDAY]],
  :every integer,
  :startDate string,
  :expirationDate string,
  :runsOnDayOfMonth [DAY_OF_MONTH WEEK_OF_MONTH],
  :timezone string},
 :format [CSV EXCEL],
 :subAccountId string,
 :name string,
 :fileName string,
 :criteria
 {:dateRange
  {:startDate string,
   :endDate string,
   :relativeDateRange
   [TODAY
    YESTERDAY
    WEEK_TO_DATE
    MONTH_TO_DATE
    QUARTER_TO_DATE
    YEAR_TO_DATE
    PREVIOUS_WEEK
    PREVIOUS_MONTH
    PREVIOUS_QUARTER
    PREVIOUS_YEAR
    LAST_7_DAYS
    LAST_30_DAYS
    LAST_90_DAYS
    LAST_365_DAYS
    LAST_24_MONTHS
    LAST_14_DAYS
    LAST_60_DAYS],
   :kind string},
  :dimensions
  [{:name string, :sortOrder [ASCENDING DESCENDING], :kind string}],
  :metricNames [string],
  :dimensionFilters
  [{:dimensionName string,
    :value string,
    :id string,
    :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
    :kind string,
    :etag string}],
  :activities
  {:filters
   [{:dimensionName string,
     :value string,
     :id string,
     :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
     :kind string,
     :etag string}],
   :metricNames [string],
   :kind string},
  :customRichMediaEvents
  {:filteredEventIds
   [{:dimensionName string,
     :value string,
     :id string,
     :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
     :kind string,
     :etag string}],
   :kind string}},
 :delivery
 {:emailOwner boolean,
  :emailOwnerDeliveryType [LINK ATTACHMENT],
  :message string,
  :recipients
  [{:email string, :deliveryType [LINK ATTACHMENT], :kind string}]},
 :type
 [STANDARD REACH PATH_TO_CONVERSION CROSS_DIMENSION_REACH FLOODLIGHT],
 :etag string,
 :reachCriteria
 {:dateRange
  {:startDate string,
   :endDate string,
   :relativeDateRange
   [TODAY
    YESTERDAY
    WEEK_TO_DATE
    MONTH_TO_DATE
    QUARTER_TO_DATE
    YEAR_TO_DATE
    PREVIOUS_WEEK
    PREVIOUS_MONTH
    PREVIOUS_QUARTER
    PREVIOUS_YEAR
    LAST_7_DAYS
    LAST_30_DAYS
    LAST_90_DAYS
    LAST_365_DAYS
    LAST_24_MONTHS
    LAST_14_DAYS
    LAST_60_DAYS],
   :kind string},
  :dimensions
  [{:name string, :sortOrder [ASCENDING DESCENDING], :kind string}],
  :metricNames [string],
  :dimensionFilters
  [{:dimensionName string,
    :value string,
    :id string,
    :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
    :kind string,
    :etag string}],
  :activities
  {:filters
   [{:dimensionName string,
     :value string,
     :id string,
     :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
     :kind string,
     :etag string}],
   :metricNames [string],
   :kind string},
  :customRichMediaEvents
  {:filteredEventIds
   [{:dimensionName string,
     :value string,
     :id string,
     :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
     :kind string,
     :etag string}],
   :kind string},
  :reachByFrequencyMetricNames [string],
  :enableAllDimensionCombinations boolean},
 :pathToConversionCriteria
 {:dateRange
  {:startDate string,
   :endDate string,
   :relativeDateRange
   [TODAY
    YESTERDAY
    WEEK_TO_DATE
    MONTH_TO_DATE
    QUARTER_TO_DATE
    YEAR_TO_DATE
    PREVIOUS_WEEK
    PREVIOUS_MONTH
    PREVIOUS_QUARTER
    PREVIOUS_YEAR
    LAST_7_DAYS
    LAST_30_DAYS
    LAST_90_DAYS
    LAST_365_DAYS
    LAST_24_MONTHS
    LAST_14_DAYS
    LAST_60_DAYS],
   :kind string},
  :conversionDimensions
  [{:name string, :sortOrder [ASCENDING DESCENDING], :kind string}],
  :customRichMediaEvents
  [{:dimensionName string,
    :value string,
    :id string,
    :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
    :kind string,
    :etag string}],
  :reportProperties
  {:maximumInteractionGap integer,
   :includeAttributedIPConversions boolean,
   :includeUnattributedIPConversions boolean,
   :clicksLookbackWindow integer,
   :includeUnattributedCookieConversions boolean,
   :impressionsLookbackWindow integer,
   :maximumClickInteractions integer,
   :pivotOnInteractionPath boolean,
   :maximumImpressionInteractions integer},
  :activityFilters
  [{:dimensionName string,
    :value string,
    :id string,
    :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
    :kind string,
    :etag string}],
  :customFloodlightVariables
  [{:name string, :sortOrder [ASCENDING DESCENDING], :kind string}],
  :perInteractionDimensions
  [{:name string, :sortOrder [ASCENDING DESCENDING], :kind string}],
  :metricNames [string],
  :floodlightConfigId
  {:dimensionName string,
   :value string,
   :id string,
   :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
   :kind string,
   :etag string}},
 :lastModifiedTime string,
 :id string,
 :kind string,
 :ownerProfileId string,
 :accountId string,
 :crossDimensionReachCriteria
 {:dateRange
  {:startDate string,
   :endDate string,
   :relativeDateRange
   [TODAY
    YESTERDAY
    WEEK_TO_DATE
    MONTH_TO_DATE
    QUARTER_TO_DATE
    YEAR_TO_DATE
    PREVIOUS_WEEK
    PREVIOUS_MONTH
    PREVIOUS_QUARTER
    PREVIOUS_YEAR
    LAST_7_DAYS
    LAST_30_DAYS
    LAST_90_DAYS
    LAST_365_DAYS
    LAST_24_MONTHS
    LAST_14_DAYS
    LAST_60_DAYS],
   :kind string},
  :dimension [ADVERTISER CAMPAIGN SITE_BY_ADVERTISER SITE_BY_CAMPAIGN],
  :pivoted boolean,
  :dimensionFilters
  [{:dimensionName string,
    :value string,
    :id string,
    :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
    :kind string,
    :etag string}],
  :breakdown
  [{:name string, :sortOrder [ASCENDING DESCENDING], :kind string}],
  :metricNames [string],
  :overlapMetricNames [string]}}"
  [profileId Report]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{profileId}/reports/compatiblefields/query",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfareporting"],
     :body Report}))

(defn advertiserLandingPages-get
  "Gets one landing page by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Landing page ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/advertiserLandingPages/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn advertiserLandingPages-insert
  "Inserts a new landing page.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
LandingPage:
{:id string,
 :name string,
 :url string,
 :archived boolean,
 :advertiserId string,
 :deepLinks
 [{:kind string,
   :appUrl string,
   :fallbackUrl string,
   :remarketingListIds [string],
   :mobileApp
   {:id string,
    :title string,
    :directory
    [UNKNOWN
     APPLE_APP_STORE
     GOOGLE_PLAY_STORE
     ROKU_APP_STORE
     AMAZON_FIRETV_APP_STORE
     PLAYSTATION_APP_STORE
     APPLE_TV_APP_STORE
     XBOX_APP_STORE
     SAMSUNG_TV_APP_STORE
     ANDROID_TV_APP_STORE
     GENERIC_CTV_APP_STORE],
    :publisherName string,
    :kind string}}],
 :kind string}"
  [profileId LandingPage]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/advertiserLandingPages",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body LandingPage}))

(defn advertiserLandingPages-list
  "Retrieves a list of landing pages.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.

optional:
archived <boolean> Select only archived landing pages. Don't set this field to select both archived and non-archived landing pages.
campaignIds <string> Select only landing pages that are associated with these campaigns.
ids <string> Select only landing pages with these IDs.
searchString <string> Allows searching for landing pages by name or ID. Wildcards (*) are allowed. For example, \"landingpage*2017\" will return landing pages with names like \"landingpage July 2017\", \"landingpage March 2017\", or simply \"landingpage 2017\". Most of the searches also add wildcards implicitly at the start and the end of the search string. For example, a search string of \"landingpage\" will match campaigns with name \"my landingpage\", \"landingpage 2015\", or simply \"landingpage\".
sortField <string> Field by which to sort the list.
advertiserIds <string> Select only landing pages that belong to these advertisers.
sortOrder <string> Order of sorted results.
subaccountId <string> Select only landing pages that belong to this subaccount.
maxResults <integer> Maximum number of results to return."
  ([profileId] (advertiserLandingPages-list profileId nil))
  ([profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/advertiserLandingPages",
       :uri-template-args {:profileId profileId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn advertiserLandingPages-update
  "Updates an existing landing page.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
LandingPage:
{:id string,
 :name string,
 :url string,
 :archived boolean,
 :advertiserId string,
 :deepLinks
 [{:kind string,
   :appUrl string,
   :fallbackUrl string,
   :remarketingListIds [string],
   :mobileApp
   {:id string,
    :title string,
    :directory
    [UNKNOWN
     APPLE_APP_STORE
     GOOGLE_PLAY_STORE
     ROKU_APP_STORE
     AMAZON_FIRETV_APP_STORE
     PLAYSTATION_APP_STORE
     APPLE_TV_APP_STORE
     XBOX_APP_STORE
     SAMSUNG_TV_APP_STORE
     ANDROID_TV_APP_STORE
     GENERIC_CTV_APP_STORE],
    :publisherName string,
    :kind string}}],
 :kind string}"
  [profileId LandingPage]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/advertiserLandingPages",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body LandingPage}))

(defn advertiserLandingPages-patch
  "Updates an existing landing page. This method supports patch semantics.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Required. Landing Page ID.
LandingPage:
{:id string,
 :name string,
 :url string,
 :archived boolean,
 :advertiserId string,
 :deepLinks
 [{:kind string,
   :appUrl string,
   :fallbackUrl string,
   :remarketingListIds [string],
   :mobileApp
   {:id string,
    :title string,
    :directory
    [UNKNOWN
     APPLE_APP_STORE
     GOOGLE_PLAY_STORE
     ROKU_APP_STORE
     AMAZON_FIRETV_APP_STORE
     PLAYSTATION_APP_STORE
     APPLE_TV_APP_STORE
     XBOX_APP_STORE
     SAMSUNG_TV_APP_STORE
     ANDROID_TV_APP_STORE
     GENERIC_CTV_APP_STORE],
    :publisherName string,
    :kind string}}],
 :kind string}"
  [profileId id LandingPage]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/advertiserLandingPages",
     :uri-template-args {:profileId profileId},
     :query-params {:id id},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body LandingPage}))

(defn userRolePermissions-get
  "Gets one user role permission by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> User role permission ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/userRolePermissions/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn userRolePermissions-list
  "Gets a list of user role permissions, possibly filtered.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.

optional:
ids <string> Select only user role permissions with these IDs."
  ([profileId] (userRolePermissions-list profileId nil))
  ([profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/userRolePermissions",
       :uri-template-args {:profileId profileId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn accountPermissionGroups-get
  "Gets one account permission group by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Account permission group ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/accountPermissionGroups/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn accountPermissionGroups-list
  "Retrieves the list of account permission groups.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request."
  [profileId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/accountPermissionGroups",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn postalCodes-get
  "Gets one postal code by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
code <string> Postal code ID."
  [profileId code]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/postalCodes/{+code}",
     :uri-template-args {:profileId profileId, :code code},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn postalCodes-list
  "Retrieves a list of postal codes.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request."
  [profileId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/postalCodes",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn eventTags-delete
  "Deletes an existing event tag.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Event tag ID."
  [profileId id]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/eventTags/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn eventTags-get
  "Gets one event tag by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Event tag ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/eventTags/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn eventTags-insert
  "Inserts a new event tag.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
EventTag:
{:sslCompliant boolean,
 :advertiserIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :name string,
 :campaignId string,
 :urlEscapeLevels integer,
 :type
 [IMPRESSION_IMAGE_EVENT_TAG
  IMPRESSION_JAVASCRIPT_EVENT_TAG
  CLICK_THROUGH_EVENT_TAG],
 :siteFilterType [ALLOWLIST BLOCKLIST],
 :campaignIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :excludeFromAdxRequests boolean,
 :advertiserId string,
 :status [ENABLED DISABLED],
 :id string,
 :kind string,
 :url string,
 :enabledByDefault boolean,
 :subaccountId string,
 :accountId string,
 :siteIds [string]}"
  [profileId EventTag]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/eventTags",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body EventTag}))

(defn eventTags-list
  "Retrieves a list of event tags, possibly filtered.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.

optional:
adId <string> Select only event tags that belong to this ad.
campaignId <string> Select only event tags that belong to this campaign.
ids <string> Select only event tags with these IDs.
searchString <string> Allows searching for objects by name or ID. Wildcards (*) are allowed. For example, \"eventtag*2015\" will return objects with names like \"eventtag June 2015\", \"eventtag April 2015\", or simply \"eventtag 2015\". Most of the searches also add wildcards implicitly at the start and the end of the search string. For example, a search string of \"eventtag\" will match objects with name \"my eventtag\", \"eventtag 2015\", or simply \"eventtag\".
eventTagTypes <string> Select only event tags with the specified event tag types. Event tag types can be used to specify whether to use a third-party pixel, a third-party JavaScript URL, or a third-party click-through URL for either impression or click tracking.
sortField <string> Field by which to sort the list.
definitionsOnly <boolean> Examine only the specified campaign or advertiser's event tags for matching selector criteria. When set to false, the parent advertiser and parent campaign of the specified ad or campaign is examined as well. In addition, when set to false, the status field is examined as well, along with the enabledByDefault field. This parameter can not be set to true when adId is specified as ads do not define their own even tags.
advertiserId <string> Select only event tags that belong to this advertiser.
sortOrder <string> Order of sorted results.
enabled <boolean> Select only enabled event tags. What is considered enabled or disabled depends on the definitionsOnly parameter. When definitionsOnly is set to true, only the specified advertiser or campaign's event tags' enabledByDefault field is examined. When definitionsOnly is set to false, the specified ad or specified campaign's parent advertiser's or parent campaign's event tags' enabledByDefault and status fields are examined as well."
  ([profileId] (eventTags-list profileId nil))
  ([profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/eventTags",
       :uri-template-args {:profileId profileId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn eventTags-update
  "Updates an existing event tag.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
EventTag:
{:sslCompliant boolean,
 :advertiserIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :name string,
 :campaignId string,
 :urlEscapeLevels integer,
 :type
 [IMPRESSION_IMAGE_EVENT_TAG
  IMPRESSION_JAVASCRIPT_EVENT_TAG
  CLICK_THROUGH_EVENT_TAG],
 :siteFilterType [ALLOWLIST BLOCKLIST],
 :campaignIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :excludeFromAdxRequests boolean,
 :advertiserId string,
 :status [ENABLED DISABLED],
 :id string,
 :kind string,
 :url string,
 :enabledByDefault boolean,
 :subaccountId string,
 :accountId string,
 :siteIds [string]}"
  [profileId EventTag]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/eventTags",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body EventTag}))

(defn eventTags-patch
  "Updates an existing event tag. This method supports patch semantics.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Required. EventTag ID.
EventTag:
{:sslCompliant boolean,
 :advertiserIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :name string,
 :campaignId string,
 :urlEscapeLevels integer,
 :type
 [IMPRESSION_IMAGE_EVENT_TAG
  IMPRESSION_JAVASCRIPT_EVENT_TAG
  CLICK_THROUGH_EVENT_TAG],
 :siteFilterType [ALLOWLIST BLOCKLIST],
 :campaignIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :excludeFromAdxRequests boolean,
 :advertiserId string,
 :status [ENABLED DISABLED],
 :id string,
 :kind string,
 :url string,
 :enabledByDefault boolean,
 :subaccountId string,
 :accountId string,
 :siteIds [string]}"
  [profileId id EventTag]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/eventTags",
     :uri-template-args {:profileId profileId},
     :query-params {:id id},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body EventTag}))

(defn metros-list
  "Retrieves a list of metros.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request."
  [profileId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/metros",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn operatingSystems-get
  "Gets one operating system by DART ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
dartId <string> Operating system DART ID."
  [profileId dartId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/operatingSystems/{+dartId}",
     :uri-template-args {:profileId profileId, :dartId dartId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn operatingSystems-list
  "Retrieves a list of operating systems.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request."
  [profileId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/operatingSystems",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn placementStrategies-patch
  "Updates an existing placement strategy. This method supports patch semantics.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Required. PlacementStrategy ID.
PlacementStrategy:
{:id string, :name string, :accountId string, :kind string}"
  [profileId id PlacementStrategy]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/placementStrategies",
     :uri-template-args {:profileId profileId},
     :query-params {:id id},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body PlacementStrategy}))

(defn placementStrategies-delete
  "Deletes an existing placement strategy.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Placement strategy ID."
  [profileId id]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/placementStrategies/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn placementStrategies-get
  "Gets one placement strategy by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Placement strategy ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/placementStrategies/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn placementStrategies-insert
  "Inserts a new placement strategy.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
PlacementStrategy:
{:id string, :name string, :accountId string, :kind string}"
  [profileId PlacementStrategy]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/placementStrategies",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body PlacementStrategy}))

(defn placementStrategies-list
  "Retrieves a list of placement strategies, possibly filtered. This method supports paging.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.

optional:
ids <string> Select only placement strategies with these IDs.
maxResults <integer> Maximum number of results to return.
searchString <string> Allows searching for objects by name or ID. Wildcards (*) are allowed. For example, \"placementstrategy*2015\" will return objects with names like \"placementstrategy June 2015\", \"placementstrategy April 2015\", or simply \"placementstrategy 2015\". Most of the searches also add wildcards implicitly at the start and the end of the search string. For example, a search string of \"placementstrategy\" will match objects with name \"my placementstrategy\", \"placementstrategy 2015\", or simply \"placementstrategy\".
sortField <string> Field by which to sort the list.
sortOrder <string> Order of sorted results."
  ([profileId] (placementStrategies-list profileId nil))
  ([profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/placementStrategies",
       :uri-template-args {:profileId profileId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn placementStrategies-update
  "Updates an existing placement strategy.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
PlacementStrategy:
{:id string, :name string, :accountId string, :kind string}"
  [profileId PlacementStrategy]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/placementStrategies",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body PlacementStrategy}))

(defn videoFormats-get
  "Gets one video format by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <integer> Video format ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/videoFormats/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn videoFormats-list
  "Lists available video formats.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request."
  [profileId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/videoFormats",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn billingRates-list
  "Retrieves a list of billing rates. This method supports paging.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
billingProfileId <string> Billing profile ID of this billing rate."
  [profileId billingProfileId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/billingProfiles/{+billingProfileId}/billingRates",
     :uri-template-args
     {:profileId profileId, :billingProfileId billingProfileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn languages-list
  "Retrieves a list of languages.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request."
  [profileId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/languages",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn accounts-get
  "Gets one account by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Account ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/accounts/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn accounts-list
  "Retrieves the list of accounts, possibly filtered. This method supports paging.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.

optional:
ids <string> Select only accounts with these IDs.
searchString <string> Allows searching for objects by name or ID. Wildcards (*) are allowed. For example, \"account*2015\" will return objects with names like \"account June 2015\", \"account April 2015\", or simply \"account 2015\". Most of the searches also add wildcards implicitly at the start and the end of the search string. For example, a search string of \"account\" will match objects with name \"my account\", \"account 2015\", or simply \"account\".
active <boolean> Select only active accounts. Don't set this field to select both active and non-active accounts.
maxResults <integer> Maximum number of results to return.
sortField <string> Field by which to sort the list.
sortOrder <string> Order of sorted results."
  ([profileId] (accounts-list profileId nil))
  ([profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/accounts",
       :uri-template-args {:profileId profileId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn accounts-update
  "Updates an existing account.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
Account:
{:description string,
 :activeViewOptOut boolean,
 :accountPermissionIds [string],
 :locale string,
 :name string,
 :activeAdsLimitTier
 [ACTIVE_ADS_TIER_40K
  ACTIVE_ADS_TIER_75K
  ACTIVE_ADS_TIER_100K
  ACTIVE_ADS_TIER_200K
  ACTIVE_ADS_TIER_300K
  ACTIVE_ADS_TIER_500K
  ACTIVE_ADS_TIER_750K
  ACTIVE_ADS_TIER_1M],
 :maximumImageSize string,
 :accountProfile [ACCOUNT_PROFILE_BASIC ACCOUNT_PROFILE_STANDARD],
 :reportsConfiguration
 {:reportGenerationTimeZoneId string,
  :exposureToConversionEnabled boolean,
  :lookbackConfiguration
  {:clickDuration integer, :postImpressionActivitiesDuration integer}},
 :availablePermissionIds [string],
 :active boolean,
 :defaultCreativeSizeId string,
 :id string,
 :kind string,
 :currencyId string,
 :countryId string,
 :teaserSizeLimit string,
 :shareReportsWithTwitter boolean,
 :nielsenOcrEnabled boolean}"
  [profileId Account]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/accounts",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body Account}))

(defn accounts-patch
  "Updates an existing account. This method supports patch semantics.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Required. Account ID.
Account:
{:description string,
 :activeViewOptOut boolean,
 :accountPermissionIds [string],
 :locale string,
 :name string,
 :activeAdsLimitTier
 [ACTIVE_ADS_TIER_40K
  ACTIVE_ADS_TIER_75K
  ACTIVE_ADS_TIER_100K
  ACTIVE_ADS_TIER_200K
  ACTIVE_ADS_TIER_300K
  ACTIVE_ADS_TIER_500K
  ACTIVE_ADS_TIER_750K
  ACTIVE_ADS_TIER_1M],
 :maximumImageSize string,
 :accountProfile [ACCOUNT_PROFILE_BASIC ACCOUNT_PROFILE_STANDARD],
 :reportsConfiguration
 {:reportGenerationTimeZoneId string,
  :exposureToConversionEnabled boolean,
  :lookbackConfiguration
  {:clickDuration integer, :postImpressionActivitiesDuration integer}},
 :availablePermissionIds [string],
 :active boolean,
 :defaultCreativeSizeId string,
 :id string,
 :kind string,
 :currencyId string,
 :countryId string,
 :teaserSizeLimit string,
 :shareReportsWithTwitter boolean,
 :nielsenOcrEnabled boolean}"
  [profileId id Account]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/accounts",
     :uri-template-args {:profileId profileId},
     :query-params {:id id},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body Account}))

(defn userRoles-patch
  "Updates an existing user role. This method supports patch semantics.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Required. UserRole ID.
UserRole:
{:id string,
 :name string,
 :accountId string,
 :subaccountId string,
 :parentUserRoleId string,
 :permissions
 [{:id string,
   :name string,
   :permissionGroupId string,
   :availability
   [NOT_AVAILABLE_BY_DEFAULT
    ACCOUNT_BY_DEFAULT
    SUBACCOUNT_AND_ACCOUNT_BY_DEFAULT
    ACCOUNT_ALWAYS
    SUBACCOUNT_AND_ACCOUNT_ALWAYS
    USER_PROFILE_ONLY],
   :kind string}],
 :defaultUserRole boolean,
 :kind string}"
  [profileId id UserRole]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/userRoles",
     :uri-template-args {:profileId profileId},
     :query-params {:id id},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body UserRole}))

(defn userRoles-get
  "Gets one user role by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> User role ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/userRoles/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn userRoles-insert
  "Inserts a new user role.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
UserRole:
{:id string,
 :name string,
 :accountId string,
 :subaccountId string,
 :parentUserRoleId string,
 :permissions
 [{:id string,
   :name string,
   :permissionGroupId string,
   :availability
   [NOT_AVAILABLE_BY_DEFAULT
    ACCOUNT_BY_DEFAULT
    SUBACCOUNT_AND_ACCOUNT_BY_DEFAULT
    ACCOUNT_ALWAYS
    SUBACCOUNT_AND_ACCOUNT_ALWAYS
    USER_PROFILE_ONLY],
   :kind string}],
 :defaultUserRole boolean,
 :kind string}"
  [profileId UserRole]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/userRoles",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body UserRole}))

(defn userRoles-list
  "Retrieves a list of user roles, possibly filtered. This method supports paging.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.

optional:
ids <string> Select only user roles with the specified IDs.
searchString <string> Allows searching for objects by name or ID. Wildcards (*) are allowed. For example, \"userrole*2015\" will return objects with names like \"userrole June 2015\", \"userrole April 2015\", or simply \"userrole 2015\". Most of the searches also add wildcards implicitly at the start and the end of the search string. For example, a search string of \"userrole\" will match objects with name \"my userrole\", \"userrole 2015\", or simply \"userrole\".
sortField <string> Field by which to sort the list.
sortOrder <string> Order of sorted results.
subaccountId <string> Select only user roles that belong to this subaccount.
accountUserRoleOnly <boolean> Select only account level user roles not associated with any specific subaccount.
maxResults <integer> Maximum number of results to return."
  ([profileId] (userRoles-list profileId nil))
  ([profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/userRoles",
       :uri-template-args {:profileId profileId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn userRoles-update
  "Updates an existing user role.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
UserRole:
{:id string,
 :name string,
 :accountId string,
 :subaccountId string,
 :parentUserRoleId string,
 :permissions
 [{:id string,
   :name string,
   :permissionGroupId string,
   :availability
   [NOT_AVAILABLE_BY_DEFAULT
    ACCOUNT_BY_DEFAULT
    SUBACCOUNT_AND_ACCOUNT_BY_DEFAULT
    ACCOUNT_ALWAYS
    SUBACCOUNT_AND_ACCOUNT_ALWAYS
    USER_PROFILE_ONLY],
   :kind string}],
 :defaultUserRole boolean,
 :kind string}"
  [profileId UserRole]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/userRoles",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body UserRole}))

(defn userRoles-delete
  "Deletes an existing user role.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> User role ID."
  [profileId id]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/userRoles/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn floodlightActivities-delete
  "Deletes an existing floodlight activity.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Floodlight activity ID."
  [profileId id]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/floodlightActivities/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn floodlightActivities-generatetag
  "Generates a tag for a floodlight activity.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.

optional:
floodlightActivityId <string> Floodlight activity ID for which we want to generate a tag."
  ([profileId] (floodlightActivities-generatetag profileId nil))
  ([profileId optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/floodlightActivities/generatetag",
       :uri-template-args {:profileId profileId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn floodlightActivities-get
  "Gets one floodlight activity by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Floodlight activity ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/floodlightActivities/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn floodlightActivities-insert
  "Inserts a new floodlight activity.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
FloodlightActivity:
{:tagString string,
 :attributionEnabled boolean,
 :idDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :floodlightConfigurationIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :expectedUrl string,
 :floodlightActivityGroupTagString string,
 :sslCompliant boolean,
 :floodlightConfigurationId string,
 :advertiserIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :name string,
 :publisherTags
 [{:dynamicTag {:id string, :name string, :tag string},
   :siteId string,
   :directorySiteId string,
   :clickThrough boolean,
   :viewThrough boolean,
   :siteIdDimensionValue
   {:dimensionName string,
    :value string,
    :id string,
    :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
    :kind string,
    :etag string}}],
 :floodlightTagType [IFRAME IMAGE GLOBAL_SITE_TAG],
 :tagFormat [HTML XHTML],
 :advertiserId string,
 :status [ACTIVE ARCHIVED_AND_DISABLED ARCHIVED DISABLED_POLICY],
 :countingMethod
 [STANDARD_COUNTING
  UNIQUE_COUNTING
  SESSION_COUNTING
  TRANSACTIONS_COUNTING
  ITEMS_SOLD_COUNTING],
 :sslRequired boolean,
 :id string,
 :kind string,
 :notes string,
 :floodlightActivityGroupName string,
 :defaultTags [{:id string, :name string, :tag string}],
 :cacheBustingType [JAVASCRIPT ACTIVE_SERVER_PAGE JSP PHP COLD_FUSION],
 :subaccountId string,
 :secure boolean,
 :floodlightActivityGroupId string,
 :accountId string,
 :floodlightActivityGroupType [COUNTER SALE],
 :userDefinedVariableTypes
 [[U1
   U2
   U3
   U4
   U5
   U6
   U7
   U8
   U9
   U10
   U11
   U12
   U13
   U14
   U15
   U16
   U17
   U18
   U19
   U20
   U21
   U22
   U23
   U24
   U25
   U26
   U27
   U28
   U29
   U30
   U31
   U32
   U33
   U34
   U35
   U36
   U37
   U38
   U39
   U40
   U41
   U42
   U43
   U44
   U45
   U46
   U47
   U48
   U49
   U50
   U51
   U52
   U53
   U54
   U55
   U56
   U57
   U58
   U59
   U60
   U61
   U62
   U63
   U64
   U65
   U66
   U67
   U68
   U69
   U70
   U71
   U72
   U73
   U74
   U75
   U76
   U77
   U78
   U79
   U80
   U81
   U82
   U83
   U84
   U85
   U86
   U87
   U88
   U89
   U90
   U91
   U92
   U93
   U94
   U95
   U96
   U97
   U98
   U99
   U100]]}"
  [profileId FloodlightActivity]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/floodlightActivities",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body FloodlightActivity}))

(defn floodlightActivities-list
  "Retrieves a list of floodlight activities, possibly filtered. This method supports paging.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.

optional:
tagString <string> Select only floodlight activities with the specified tag string.
floodlightActivityGroupTagString <string> Select only floodlight activities with the specified floodlight activity group tag string.
floodlightConfigurationId <string> Select only floodlight activities for the specified floodlight configuration ID. Must specify either ids, advertiserId, or floodlightConfigurationId for a non-empty result.
ids <string> Select only floodlight activities with the specified IDs. Must specify either ids, advertiserId, or floodlightConfigurationId for a non-empty result.
searchString <string> Allows searching for objects by name or ID. Wildcards (*) are allowed. For example, \"floodlightactivity*2015\" will return objects with names like \"floodlightactivity June 2015\", \"floodlightactivity April 2015\", or simply \"floodlightactivity 2015\". Most of the searches also add wildcards implicitly at the start and the end of the search string. For example, a search string of \"floodlightactivity\" will match objects with name \"my floodlightactivity activity\", \"floodlightactivity 2015\", or simply \"floodlightactivity\".
sortField <string> Field by which to sort the list.
advertiserId <string> Select only floodlight activities for the specified advertiser ID. Must specify either ids, advertiserId, or floodlightConfigurationId for a non-empty result.
floodlightActivityGroupIds <string> Select only floodlight activities with the specified floodlight activity group IDs.
sortOrder <string> Order of sorted results.
floodlightActivityGroupName <string> Select only floodlight activities with the specified floodlight activity group name.
floodlightActivityGroupType <string> Select only floodlight activities with the specified floodlight activity group type.
maxResults <integer> Maximum number of results to return."
  ([profileId] (floodlightActivities-list profileId nil))
  ([profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/floodlightActivities",
       :uri-template-args {:profileId profileId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn floodlightActivities-update
  "Updates an existing floodlight activity.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
FloodlightActivity:
{:tagString string,
 :attributionEnabled boolean,
 :idDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :floodlightConfigurationIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :expectedUrl string,
 :floodlightActivityGroupTagString string,
 :sslCompliant boolean,
 :floodlightConfigurationId string,
 :advertiserIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :name string,
 :publisherTags
 [{:dynamicTag {:id string, :name string, :tag string},
   :siteId string,
   :directorySiteId string,
   :clickThrough boolean,
   :viewThrough boolean,
   :siteIdDimensionValue
   {:dimensionName string,
    :value string,
    :id string,
    :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
    :kind string,
    :etag string}}],
 :floodlightTagType [IFRAME IMAGE GLOBAL_SITE_TAG],
 :tagFormat [HTML XHTML],
 :advertiserId string,
 :status [ACTIVE ARCHIVED_AND_DISABLED ARCHIVED DISABLED_POLICY],
 :countingMethod
 [STANDARD_COUNTING
  UNIQUE_COUNTING
  SESSION_COUNTING
  TRANSACTIONS_COUNTING
  ITEMS_SOLD_COUNTING],
 :sslRequired boolean,
 :id string,
 :kind string,
 :notes string,
 :floodlightActivityGroupName string,
 :defaultTags [{:id string, :name string, :tag string}],
 :cacheBustingType [JAVASCRIPT ACTIVE_SERVER_PAGE JSP PHP COLD_FUSION],
 :subaccountId string,
 :secure boolean,
 :floodlightActivityGroupId string,
 :accountId string,
 :floodlightActivityGroupType [COUNTER SALE],
 :userDefinedVariableTypes
 [[U1
   U2
   U3
   U4
   U5
   U6
   U7
   U8
   U9
   U10
   U11
   U12
   U13
   U14
   U15
   U16
   U17
   U18
   U19
   U20
   U21
   U22
   U23
   U24
   U25
   U26
   U27
   U28
   U29
   U30
   U31
   U32
   U33
   U34
   U35
   U36
   U37
   U38
   U39
   U40
   U41
   U42
   U43
   U44
   U45
   U46
   U47
   U48
   U49
   U50
   U51
   U52
   U53
   U54
   U55
   U56
   U57
   U58
   U59
   U60
   U61
   U62
   U63
   U64
   U65
   U66
   U67
   U68
   U69
   U70
   U71
   U72
   U73
   U74
   U75
   U76
   U77
   U78
   U79
   U80
   U81
   U82
   U83
   U84
   U85
   U86
   U87
   U88
   U89
   U90
   U91
   U92
   U93
   U94
   U95
   U96
   U97
   U98
   U99
   U100]]}"
  [profileId FloodlightActivity]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/floodlightActivities",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body FloodlightActivity}))

(defn floodlightActivities-patch
  "Updates an existing floodlight activity. This method supports patch semantics.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Required. EventTag ID.
FloodlightActivity:
{:tagString string,
 :attributionEnabled boolean,
 :idDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :floodlightConfigurationIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :expectedUrl string,
 :floodlightActivityGroupTagString string,
 :sslCompliant boolean,
 :floodlightConfigurationId string,
 :advertiserIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :name string,
 :publisherTags
 [{:dynamicTag {:id string, :name string, :tag string},
   :siteId string,
   :directorySiteId string,
   :clickThrough boolean,
   :viewThrough boolean,
   :siteIdDimensionValue
   {:dimensionName string,
    :value string,
    :id string,
    :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
    :kind string,
    :etag string}}],
 :floodlightTagType [IFRAME IMAGE GLOBAL_SITE_TAG],
 :tagFormat [HTML XHTML],
 :advertiserId string,
 :status [ACTIVE ARCHIVED_AND_DISABLED ARCHIVED DISABLED_POLICY],
 :countingMethod
 [STANDARD_COUNTING
  UNIQUE_COUNTING
  SESSION_COUNTING
  TRANSACTIONS_COUNTING
  ITEMS_SOLD_COUNTING],
 :sslRequired boolean,
 :id string,
 :kind string,
 :notes string,
 :floodlightActivityGroupName string,
 :defaultTags [{:id string, :name string, :tag string}],
 :cacheBustingType [JAVASCRIPT ACTIVE_SERVER_PAGE JSP PHP COLD_FUSION],
 :subaccountId string,
 :secure boolean,
 :floodlightActivityGroupId string,
 :accountId string,
 :floodlightActivityGroupType [COUNTER SALE],
 :userDefinedVariableTypes
 [[U1
   U2
   U3
   U4
   U5
   U6
   U7
   U8
   U9
   U10
   U11
   U12
   U13
   U14
   U15
   U16
   U17
   U18
   U19
   U20
   U21
   U22
   U23
   U24
   U25
   U26
   U27
   U28
   U29
   U30
   U31
   U32
   U33
   U34
   U35
   U36
   U37
   U38
   U39
   U40
   U41
   U42
   U43
   U44
   U45
   U46
   U47
   U48
   U49
   U50
   U51
   U52
   U53
   U54
   U55
   U56
   U57
   U58
   U59
   U60
   U61
   U62
   U63
   U64
   U65
   U66
   U67
   U68
   U69
   U70
   U71
   U72
   U73
   U74
   U75
   U76
   U77
   U78
   U79
   U80
   U81
   U82
   U83
   U84
   U85
   U86
   U87
   U88
   U89
   U90
   U91
   U92
   U93
   U94
   U95
   U96
   U97
   U98
   U99
   U100]]}"
  [profileId id FloodlightActivity]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/floodlightActivities",
     :uri-template-args {:profileId profileId},
     :query-params {:id id},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body FloodlightActivity}))

(defn connectionTypes-get
  "Gets one connection type by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Connection type ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/connectionTypes/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn connectionTypes-list
  "Retrieves a list of connection types.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request."
  [profileId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/connectionTypes",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn floodlightActivityGroups-get
  "Gets one floodlight activity group by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Floodlight activity Group ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/floodlightActivityGroups/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn floodlightActivityGroups-insert
  "Inserts a new floodlight activity group.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
FloodlightActivityGroup:
{:tagString string,
 :idDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :floodlightConfigurationIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :floodlightConfigurationId string,
 :advertiserIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :name string,
 :type [COUNTER SALE],
 :advertiserId string,
 :id string,
 :kind string,
 :subaccountId string,
 :accountId string}"
  [profileId FloodlightActivityGroup]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/floodlightActivityGroups",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body FloodlightActivityGroup}))

(defn floodlightActivityGroups-list
  "Retrieves a list of floodlight activity groups, possibly filtered. This method supports paging.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.

optional:
floodlightConfigurationId <string> Select only floodlight activity groups with the specified floodlight configuration ID. Must specify either advertiserId, or floodlightConfigurationId for a non-empty result.
ids <string> Select only floodlight activity groups with the specified IDs. Must specify either advertiserId or floodlightConfigurationId for a non-empty result.
type <string> Select only floodlight activity groups with the specified floodlight activity group type.
searchString <string> Allows searching for objects by name or ID. Wildcards (*) are allowed. For example, \"floodlightactivitygroup*2015\" will return objects with names like \"floodlightactivitygroup June 2015\", \"floodlightactivitygroup April 2015\", or simply \"floodlightactivitygroup 2015\". Most of the searches also add wildcards implicitly at the start and the end of the search string. For example, a search string of \"floodlightactivitygroup\" will match objects with name \"my floodlightactivitygroup activity\", \"floodlightactivitygroup 2015\", or simply \"floodlightactivitygroup\".
sortField <string> Field by which to sort the list.
advertiserId <string> Select only floodlight activity groups with the specified advertiser ID. Must specify either advertiserId or floodlightConfigurationId for a non-empty result.
sortOrder <string> Order of sorted results.
maxResults <integer> Maximum number of results to return."
  ([profileId] (floodlightActivityGroups-list profileId nil))
  ([profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/floodlightActivityGroups",
       :uri-template-args {:profileId profileId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn floodlightActivityGroups-update
  "Updates an existing floodlight activity group.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
FloodlightActivityGroup:
{:tagString string,
 :idDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :floodlightConfigurationIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :floodlightConfigurationId string,
 :advertiserIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :name string,
 :type [COUNTER SALE],
 :advertiserId string,
 :id string,
 :kind string,
 :subaccountId string,
 :accountId string}"
  [profileId FloodlightActivityGroup]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/floodlightActivityGroups",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body FloodlightActivityGroup}))

(defn floodlightActivityGroups-patch
  "Updates an existing floodlight activity group. This method supports patch semantics.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Required. EventTag ID.
FloodlightActivityGroup:
{:tagString string,
 :idDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :floodlightConfigurationIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :floodlightConfigurationId string,
 :advertiserIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :name string,
 :type [COUNTER SALE],
 :advertiserId string,
 :id string,
 :kind string,
 :subaccountId string,
 :accountId string}"
  [profileId id FloodlightActivityGroup]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/floodlightActivityGroups",
     :uri-template-args {:profileId profileId},
     :query-params {:id id},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body FloodlightActivityGroup}))

(defn campaignCreativeAssociations-insert
  "Associates a creative with the specified campaign. This method creates a default ad with dimensions matching the creative in the campaign if such a default ad does not exist already.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
campaignId <string> Campaign ID in this association.
CampaignCreativeAssociation:
{:creativeId string, :kind string}"
  [profileId campaignId CampaignCreativeAssociation]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/campaigns/{+campaignId}/campaignCreativeAssociations",
     :uri-template-args {:profileId profileId, :campaignId campaignId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body CampaignCreativeAssociation}))

(defn campaignCreativeAssociations-list
  "Retrieves the list of creative IDs associated with the specified campaign. This method supports paging.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
campaignId <string> Campaign ID in this association.

optional:
maxResults <integer> Maximum number of results to return.
sortOrder <string> Order of sorted results."
  ([profileId campaignId]
    (campaignCreativeAssociations-list profileId campaignId nil))
  ([profileId campaignId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/campaigns/{+campaignId}/campaignCreativeAssociations",
       :uri-template-args
       {:profileId profileId, :campaignId campaignId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn placementGroups-patch
  "Updates an existing placement group. This method supports patch semantics.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Required. Placement ID.
PlacementGroup:
{:directorySiteId string,
 :siteId string,
 :idDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :pricingSchedule
 {:testingStartDate string,
  :startDate string,
  :endDate string,
  :pricingType
  [PRICING_TYPE_CPM
   PRICING_TYPE_CPC
   PRICING_TYPE_CPA
   PRICING_TYPE_FLAT_RATE_IMPRESSIONS
   PRICING_TYPE_FLAT_RATE_CLICKS
   PRICING_TYPE_CPM_ACTIVEVIEW],
  :capCostOption [CAP_COST_NONE CAP_COST_MONTHLY CAP_COST_CUMULATIVE],
  :flighted boolean,
  :pricingPeriods
  [{:startDate string,
    :endDate string,
    :units string,
    :rateOrCostNanos string,
    :pricingComment string}],
  :floodlightActivityId string},
 :advertiserIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :name string,
 :placementStrategyId string,
 :campaignId string,
 :createInfo {:time string},
 :campaignIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :placementGroupType [PLACEMENT_PACKAGE PLACEMENT_ROADBLOCK],
 :contentCategoryId string,
 :primaryPlacementId string,
 :activeStatus
 [PLACEMENT_STATUS_UNKNOWN
  PLACEMENT_STATUS_ACTIVE
  PLACEMENT_STATUS_INACTIVE
  PLACEMENT_STATUS_ARCHIVED
  PLACEMENT_STATUS_PERMANENTLY_ARCHIVED],
 :advertiserId string,
 :externalId string,
 :directorySiteIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :id string,
 :siteIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :kind string,
 :comment string,
 :lastModifiedInfo {:time string},
 :subaccountId string,
 :childPlacementIds [string],
 :primaryPlacementIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :accountId string}"
  [profileId id PlacementGroup]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/placementGroups",
     :uri-template-args {:profileId profileId},
     :query-params {:id id},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body PlacementGroup}))

(defn placementGroups-get
  "Gets one placement group by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Placement group ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/placementGroups/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn placementGroups-insert
  "Inserts a new placement group.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
PlacementGroup:
{:directorySiteId string,
 :siteId string,
 :idDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :pricingSchedule
 {:testingStartDate string,
  :startDate string,
  :endDate string,
  :pricingType
  [PRICING_TYPE_CPM
   PRICING_TYPE_CPC
   PRICING_TYPE_CPA
   PRICING_TYPE_FLAT_RATE_IMPRESSIONS
   PRICING_TYPE_FLAT_RATE_CLICKS
   PRICING_TYPE_CPM_ACTIVEVIEW],
  :capCostOption [CAP_COST_NONE CAP_COST_MONTHLY CAP_COST_CUMULATIVE],
  :flighted boolean,
  :pricingPeriods
  [{:startDate string,
    :endDate string,
    :units string,
    :rateOrCostNanos string,
    :pricingComment string}],
  :floodlightActivityId string},
 :advertiserIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :name string,
 :placementStrategyId string,
 :campaignId string,
 :createInfo {:time string},
 :campaignIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :placementGroupType [PLACEMENT_PACKAGE PLACEMENT_ROADBLOCK],
 :contentCategoryId string,
 :primaryPlacementId string,
 :activeStatus
 [PLACEMENT_STATUS_UNKNOWN
  PLACEMENT_STATUS_ACTIVE
  PLACEMENT_STATUS_INACTIVE
  PLACEMENT_STATUS_ARCHIVED
  PLACEMENT_STATUS_PERMANENTLY_ARCHIVED],
 :advertiserId string,
 :externalId string,
 :directorySiteIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :id string,
 :siteIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :kind string,
 :comment string,
 :lastModifiedInfo {:time string},
 :subaccountId string,
 :childPlacementIds [string],
 :primaryPlacementIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :accountId string}"
  [profileId PlacementGroup]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/placementGroups",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body PlacementGroup}))

(defn placementGroups-list
  "Retrieves a list of placement groups, possibly filtered. This method supports paging.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.

optional:
pricingTypes <string> Select only placement groups with these pricing types.
minEndDate <string> Select only placements or placement groups whose end date is on or after the specified minEndDate. The date should be formatted as \"yyyy-MM-dd\".
campaignIds <string> Select only placement groups that belong to these campaigns.
contentCategoryIds <string> Select only placement groups that are associated with these content categories.
ids <string> Select only placement groups with these IDs.
searchString <string> Allows searching for placement groups by name or ID. Wildcards (*) are allowed. For example, \"placement*2015\" will return placement groups with names like \"placement group June 2015\", \"placement group May 2015\", or simply \"placements 2015\". Most of the searches also add wildcards implicitly at the start and the end of the search string. For example, a search string of \"placementgroup\" will match placement groups with name \"my placementgroup\", \"placementgroup 2015\", or simply \"placementgroup\".
placementGroupType <string> Select only placement groups belonging with this group type. A package is a simple group of placements that acts as a single pricing point for a group of tags. A roadblock is a group of placements that not only acts as a single pricing point but also assumes that all the tags in it will be served at the same time. A roadblock requires one of its assigned placements to be marked as primary for reporting.
sortField <string> Field by which to sort the list.
minStartDate <string> Select only placements or placement groups whose start date is on or after the specified minStartDate. The date should be formatted as \"yyyy-MM-dd\".
advertiserIds <string> Select only placement groups that belong to these advertisers.
activeStatus <string> Select only placements with these active statuses.
maxEndDate <string> Select only placements or placement groups whose end date is on or before the specified maxEndDate. The date should be formatted as \"yyyy-MM-dd\".
sortOrder <string> Order of sorted results.
placementStrategyIds <string> Select only placement groups that are associated with these placement strategies.
directorySiteIds <string> Select only placement groups that are associated with these directory sites.
maxStartDate <string> Select only placements or placement groups whose start date is on or before the specified maxStartDate. The date should be formatted as \"yyyy-MM-dd\".
maxResults <integer> Maximum number of results to return.
siteIds <string> Select only placement groups that are associated with these sites."
  ([profileId] (placementGroups-list profileId nil))
  ([profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/placementGroups",
       :uri-template-args {:profileId profileId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn placementGroups-update
  "Updates an existing placement group.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
PlacementGroup:
{:directorySiteId string,
 :siteId string,
 :idDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :pricingSchedule
 {:testingStartDate string,
  :startDate string,
  :endDate string,
  :pricingType
  [PRICING_TYPE_CPM
   PRICING_TYPE_CPC
   PRICING_TYPE_CPA
   PRICING_TYPE_FLAT_RATE_IMPRESSIONS
   PRICING_TYPE_FLAT_RATE_CLICKS
   PRICING_TYPE_CPM_ACTIVEVIEW],
  :capCostOption [CAP_COST_NONE CAP_COST_MONTHLY CAP_COST_CUMULATIVE],
  :flighted boolean,
  :pricingPeriods
  [{:startDate string,
    :endDate string,
    :units string,
    :rateOrCostNanos string,
    :pricingComment string}],
  :floodlightActivityId string},
 :advertiserIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :name string,
 :placementStrategyId string,
 :campaignId string,
 :createInfo {:time string},
 :campaignIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :placementGroupType [PLACEMENT_PACKAGE PLACEMENT_ROADBLOCK],
 :contentCategoryId string,
 :primaryPlacementId string,
 :activeStatus
 [PLACEMENT_STATUS_UNKNOWN
  PLACEMENT_STATUS_ACTIVE
  PLACEMENT_STATUS_INACTIVE
  PLACEMENT_STATUS_ARCHIVED
  PLACEMENT_STATUS_PERMANENTLY_ARCHIVED],
 :advertiserId string,
 :externalId string,
 :directorySiteIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :id string,
 :siteIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :kind string,
 :comment string,
 :lastModifiedInfo {:time string},
 :subaccountId string,
 :childPlacementIds [string],
 :primaryPlacementIdDimensionValue
 {:dimensionName string,
  :value string,
  :id string,
  :matchType [EXACT BEGINS_WITH CONTAINS WILDCARD_EXPRESSION],
  :kind string,
  :etag string},
 :accountId string}"
  [profileId PlacementGroup]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/placementGroups",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body PlacementGroup}))

(defn dynamicTargetingKeys-delete
  "Deletes an existing dynamic targeting key.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
objectId <string> ID of the object of this dynamic targeting key. This is a required field.
name <string> Required. Name of this dynamic targeting key. This is a required field. Must be less than 256 characters long and cannot contain commas. All characters are converted to lowercase.
objectType <string> Required. Type of the object of this dynamic targeting key. This is a required field."
  [profileId objectId name objectType]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/dynamicTargetingKeys/{+objectId}",
     :uri-template-args {:profileId profileId, :objectId objectId},
     :query-params {:name name, :objectType objectType},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn dynamicTargetingKeys-insert
  "Inserts a new dynamic targeting key. Keys must be created at the advertiser level before being assigned to the advertiser's ads, creatives, or placements. There is a maximum of 1000 keys per advertiser, out of which a maximum of 20 keys can be assigned per ad, creative, or placement.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
DynamicTargetingKey:
{:name string,
 :objectType
 [OBJECT_ADVERTISER OBJECT_AD OBJECT_CREATIVE OBJECT_PLACEMENT],
 :objectId string,
 :kind string}"
  [profileId DynamicTargetingKey]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/dynamicTargetingKeys",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body DynamicTargetingKey}))

(defn dynamicTargetingKeys-list
  "Retrieves a list of dynamic targeting keys.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.

optional:
names <string> Select only dynamic targeting keys exactly matching these names.
objectType <string> Select only dynamic targeting keys with this object type.
objectId <string> Select only dynamic targeting keys with this object ID.
advertiserId <string> Select only dynamic targeting keys whose object has this advertiser ID."
  ([profileId] (dynamicTargetingKeys-list profileId nil))
  ([profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/dynamicTargetingKeys",
       :uri-template-args {:profileId profileId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn userProfiles-get
  "Gets one user profile by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> The user profile ID."
  [profileId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{profileId}",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/ddmconversions"
      "https://www.googleapis.com/auth/dfareporting"
      "https://www.googleapis.com/auth/dfatrafficking"]}))

(defn userProfiles-list
  "Retrieves list of user profiles for a user.
https://developers.google.com/doubleclick-advertisers"
  []
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/ddmconversions"
      "https://www.googleapis.com/auth/dfareporting"
      "https://www.googleapis.com/auth/dfatrafficking"]}))

(defn accountUserProfiles-get
  "Gets one account user profile by ID.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> User profile ID."
  [profileId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{profileId}/accountUserProfiles/{+id}",
     :uri-template-args {:profileId profileId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"]}))

(defn accountUserProfiles-insert
  "Inserts a new account user profile.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
AccountUserProfile:
{:campaignFilter
 {:objectIds [string], :status [NONE ASSIGNED ALL], :kind string},
 :traffickerType
 [INTERNAL_NON_TRAFFICKER INTERNAL_TRAFFICKER EXTERNAL_TRAFFICKER],
 :email string,
 :locale string,
 :userRoleId string,
 :name string,
 :comments string,
 :userRoleFilter
 {:objectIds [string], :status [NONE ASSIGNED ALL], :kind string},
 :userAccessType
 [NORMAL_USER SUPER_USER INTERNAL_ADMINISTRATOR READ_ONLY_SUPER_USER],
 :siteFilter
 {:objectIds [string], :status [NONE ASSIGNED ALL], :kind string},
 :active boolean,
 :id string,
 :kind string,
 :advertiserFilter
 {:objectIds [string], :status [NONE ASSIGNED ALL], :kind string},
 :subaccountId string,
 :accountId string}"
  [profileId AccountUserProfile]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/accountUserProfiles",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body AccountUserProfile}))

(defn accountUserProfiles-list
  "Retrieves a list of account user profiles, possibly filtered. This method supports paging.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.

optional:
userRoleId <string> Select only user profiles with the specified user role ID.
ids <string> Select only user profiles with these IDs.
searchString <string> Allows searching for objects by name, ID or email. Wildcards (*) are allowed. For example, \"user profile*2015\" will return objects with names like \"user profile June 2015\", \"user profile April 2015\", or simply \"user profile 2015\". Most of the searches also add wildcards implicitly at the start and the end of the search string. For example, a search string of \"user profile\" will match objects with name \"my user profile\", \"user profile 2015\", or simply \"user profile\".
sortField <string> Field by which to sort the list.
active <boolean> Select only active user profiles.
sortOrder <string> Order of sorted results.
subaccountId <string> Select only user profiles with the specified subaccount ID.
maxResults <integer> Maximum number of results to return."
  ([profileId] (accountUserProfiles-list profileId nil))
  ([profileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/accountUserProfiles",
       :uri-template-args {:profileId profileId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/dfatrafficking"]})))

(defn accountUserProfiles-update
  "Updates an existing account user profile.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
AccountUserProfile:
{:campaignFilter
 {:objectIds [string], :status [NONE ASSIGNED ALL], :kind string},
 :traffickerType
 [INTERNAL_NON_TRAFFICKER INTERNAL_TRAFFICKER EXTERNAL_TRAFFICKER],
 :email string,
 :locale string,
 :userRoleId string,
 :name string,
 :comments string,
 :userRoleFilter
 {:objectIds [string], :status [NONE ASSIGNED ALL], :kind string},
 :userAccessType
 [NORMAL_USER SUPER_USER INTERNAL_ADMINISTRATOR READ_ONLY_SUPER_USER],
 :siteFilter
 {:objectIds [string], :status [NONE ASSIGNED ALL], :kind string},
 :active boolean,
 :id string,
 :kind string,
 :advertiserFilter
 {:objectIds [string], :status [NONE ASSIGNED ALL], :kind string},
 :subaccountId string,
 :accountId string}"
  [profileId AccountUserProfile]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/accountUserProfiles",
     :uri-template-args {:profileId profileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body AccountUserProfile}))

(defn accountUserProfiles-patch
  "Updates an existing account user profile. This method supports patch semantics.
https://developers.google.com/doubleclick-advertisers

profileId <string> User profile ID associated with this request.
id <string> Required. AccountUserProfile ID.
AccountUserProfile:
{:campaignFilter
 {:objectIds [string], :status [NONE ASSIGNED ALL], :kind string},
 :traffickerType
 [INTERNAL_NON_TRAFFICKER INTERNAL_TRAFFICKER EXTERNAL_TRAFFICKER],
 :email string,
 :locale string,
 :userRoleId string,
 :name string,
 :comments string,
 :userRoleFilter
 {:objectIds [string], :status [NONE ASSIGNED ALL], :kind string},
 :userAccessType
 [NORMAL_USER SUPER_USER INTERNAL_ADMINISTRATOR READ_ONLY_SUPER_USER],
 :siteFilter
 {:objectIds [string], :status [NONE ASSIGNED ALL], :kind string},
 :active boolean,
 :id string,
 :kind string,
 :advertiserFilter
 {:objectIds [string], :status [NONE ASSIGNED ALL], :kind string},
 :subaccountId string,
 :accountId string}"
  [profileId id AccountUserProfile]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://dfareporting.googleapis.com/dfareporting/v4/userprofiles/{+profileId}/accountUserProfiles",
     :uri-template-args {:profileId profileId},
     :query-params {:id id},
     :scopes ["https://www.googleapis.com/auth/dfatrafficking"],
     :body AccountUserProfile}))

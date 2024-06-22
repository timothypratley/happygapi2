(ns happygapi2.authorizedbuyersmarketplace
  "Authorized Buyers Marketplace API
The Authorized Buyers Marketplace API lets buyers programmatically discover inventory; propose, retrieve and negotiate deals with publishers.
See: https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/"
  (:require [happy.oauth2.client :as client]))

(defn buyers-auctionPackages-get
  "Gets an auction package given its name.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/buyers.auctionPackages/get

name <string> Required. Name of auction package to get. Format: `buyers/{accountId}/auctionPackages/{auctionPackageId}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://authorizedbuyersmarketplace.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}))

(defn buyers-auctionPackages-list
  "List the auction packages. Buyers can use the URL path \"/v1/buyers/{accountId}/auctionPackages\" to list auction packages for the current buyer and its clients. Bidders can use the URL path \"/v1/bidders/{accountId}/auctionPackages\" to list auction packages for the bidder, its media planners, its buyers, and all their clients.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/buyers.auctionPackages/list

parent <string> Required. Name of the parent buyer that can access the auction package. Format: `buyers/{accountId}`. When used with a bidder account, the auction packages that the bidder, its media planners, its buyers and clients are subscribed to will be listed, in the format `bidders/{accountId}`.

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. Max allowed page size is 500.
filter <string> Optional. Optional query string using the [Cloud API list filtering syntax](/authorized-buyers/apis/guides/list-filters). Only supported when parent is bidder. Supported columns for filtering are: * displayName * createTime * updateTime * eligibleSeatIds
orderBy <string> Optional. An optional query string to sort auction packages using the [Cloud API sorting syntax](https://cloud.google.com/apis/design/design_patterns#sorting_order). If no sort order is specified, results will be returned in an arbitrary order. Only supported when parent is bidder. Supported columns for sorting are: * displayName * createTime * updateTime"
  ([parent] (buyers-auctionPackages-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://authorizedbuyersmarketplace.googleapis.com/v1/{+parent}/auctionPackages",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]})))

(defn buyers-auctionPackages-subscribe
  "Subscribe to the auction package for the specified buyer. Once subscribed, the bidder will receive a call out for inventory matching the auction package targeting criteria with the auction package deal ID and the specified buyer.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/buyers.auctionPackages/subscribe

name <string> Required. Name of the auction package. Format: `buyers/{accountId}/auctionPackages/{auctionPackageId}`
SubscribeAuctionPackageRequest:
object"
  [name SubscribeAuctionPackageRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://authorizedbuyersmarketplace.googleapis.com/v1/{+name}:subscribe",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/authorized-buyers-marketplace"],
     :body SubscribeAuctionPackageRequest}))

(defn buyers-auctionPackages-unsubscribe
  "Unsubscribe from the auction package for the specified buyer. Once unsubscribed, the bidder will no longer receive a call out for the auction package deal ID and the specified buyer.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/buyers.auctionPackages/unsubscribe

name <string> Required. Name of the auction package. Format: `buyers/{accountId}/auctionPackages/{auctionPackageId}`
UnsubscribeAuctionPackageRequest:
object"
  [name UnsubscribeAuctionPackageRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://authorizedbuyersmarketplace.googleapis.com/v1/{+name}:unsubscribe",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/authorized-buyers-marketplace"],
     :body UnsubscribeAuctionPackageRequest}))

(defn buyers-auctionPackages-subscribeClients
  "Subscribe the specified clients of the buyer to the auction package. If a client in the list does not belong to the buyer, an error response will be returned, and all of the following clients in the list will not be subscribed. Subscribing an already subscribed client will have no effect.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/buyers.auctionPackages/subscribeClients

auctionPackage <string> Required. Name of the auction package. Format: `buyers/{accountId}/auctionPackages/{auctionPackageId}`
SubscribeClientsRequest:
{:clients [string]}"
  [auctionPackage SubscribeClientsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://authorizedbuyersmarketplace.googleapis.com/v1/{+auctionPackage}:subscribeClients",
     :uri-template-args {:auctionPackage auctionPackage},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/authorized-buyers-marketplace"],
     :body SubscribeClientsRequest}))

(defn buyers-auctionPackages-unsubscribeClients
  "Unsubscribe from the auction package for the specified clients of the buyer. Unsubscribing a client that is not subscribed will have no effect.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/buyers.auctionPackages/unsubscribeClients

auctionPackage <string> Required. Name of the auction package. Format: `buyers/{accountId}/auctionPackages/{auctionPackageId}`
UnsubscribeClientsRequest:
{:clients [string]}"
  [auctionPackage UnsubscribeClientsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://authorizedbuyersmarketplace.googleapis.com/v1/{+auctionPackage}:unsubscribeClients",
     :uri-template-args {:auctionPackage auctionPackage},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/authorized-buyers-marketplace"],
     :body UnsubscribeClientsRequest}))

(defn buyers-clients-get
  "Gets a client with a given resource name.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/buyers.clients/get

name <string> Required. Format: `buyers/{accountId}/clients/{clientAccountId}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://authorizedbuyersmarketplace.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}))

(defn buyers-clients-list
  "Lists all the clients for the current buyer.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/buyers.clients/list

parent <string> Required. The name of the buyer. Format: `buyers/{accountId}`

optional:
pageSize <integer> Requested page size. If left blank, a default page size of 500 will be applied.
filter <string> Query string using the [Filtering Syntax](https://developers.google.com/authorized-buyers/apis/guides/list-filters) Supported fields for filtering are: * partnerClientId Use this field to filter the clients by the partnerClientId. For example, if the partnerClientId of the client is \"1234\", the value of this field should be `partnerClientId = \"1234\"`, in order to get only the client whose partnerClientId is \"1234\" in the response."
  ([parent] (buyers-clients-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://authorizedbuyersmarketplace.googleapis.com/v1/{+parent}/clients",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]})))

(defn buyers-clients-create
  "Creates a new client.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/buyers.clients/create

parent <string> Required. The name of the buyer. Format: `buyers/{accountId}`
Client:
{:name string,
 :role
 [CLIENT_ROLE_UNSPECIFIED
  CLIENT_DEAL_VIEWER
  CLIENT_DEAL_NEGOTIATOR
  CLIENT_DEAL_APPROVER],
 :state [STATE_UNSPECIFIED ACTIVE INACTIVE],
 :displayName string,
 :sellerVisible boolean,
 :partnerClientId string}"
  [parent Client]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://authorizedbuyersmarketplace.googleapis.com/v1/{+parent}/clients",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/authorized-buyers-marketplace"],
     :body Client}))

(defn buyers-clients-patch
  "Updates an existing client.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/buyers.clients/patch

name <string> Output only. The resource name of the client. Format: `buyers/{accountId}/clients/{clientAccountId}`
Client:
{:name string,
 :role
 [CLIENT_ROLE_UNSPECIFIED
  CLIENT_DEAL_VIEWER
  CLIENT_DEAL_NEGOTIATOR
  CLIENT_DEAL_APPROVER],
 :state [STATE_UNSPECIFIED ACTIVE INACTIVE],
 :displayName string,
 :sellerVisible boolean,
 :partnerClientId string}

optional:
updateMask <string> List of fields to be updated. If empty or unspecified, the service will update all fields populated in the update request excluding the output only fields and primitive fields with default value. Note that explicit field mask is required in order to reset a primitive field back to its default value, for example, false for boolean fields, 0 for integer fields. A special field mask consisting of a single path \"*\" can be used to indicate full replacement(the equivalent of PUT method), updatable fields unset or unspecified in the input will be cleared or set to default value. Output only fields will be ignored regardless of the value of updateMask."
  ([name Client] (buyers-clients-patch name Client nil))
  ([name Client optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://authorizedbuyersmarketplace.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/authorized-buyers-marketplace"],
       :body Client})))

(defn buyers-clients-activate
  "Activates an existing client. The state of the client will be updated to \"ACTIVE\". This method has no effect if the client is already in \"ACTIVE\" state.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/buyers.clients/activate

name <string> Required. Format: `buyers/{buyerAccountId}/clients/{clientAccountId}`
ActivateClientRequest:
object"
  [name ActivateClientRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://authorizedbuyersmarketplace.googleapis.com/v1/{+name}:activate",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/authorized-buyers-marketplace"],
     :body ActivateClientRequest}))

(defn buyers-clients-deactivate
  "Deactivates an existing client. The state of the client will be updated to \"INACTIVE\". This method has no effect if the client is already in \"INACTIVE\" state.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/buyers.clients/deactivate

name <string> Required. Format: `buyers/{buyerAccountId}/clients/{clientAccountId}`
DeactivateClientRequest:
object"
  [name DeactivateClientRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://authorizedbuyersmarketplace.googleapis.com/v1/{+name}:deactivate",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/authorized-buyers-marketplace"],
     :body DeactivateClientRequest}))

(defn buyers-clients-users-get
  "Retrieves an existing client user.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/buyers.clients.users/get

name <string> Required. Format: `buyers/{buyerAccountId}/clients/{clientAccountId}/clientUsers/{userId}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://authorizedbuyersmarketplace.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}))

(defn buyers-clients-users-list
  "Lists all client users for a specified client.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/buyers.clients.users/list

parent <string> Required. The name of the client. Format: `buyers/{buyerAccountId}/clients/{clientAccountId}`

optional:
pageSize <integer> Requested page size. If left blank, a default page size of 500 will be applied."
  ([parent] (buyers-clients-users-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://authorizedbuyersmarketplace.googleapis.com/v1/{+parent}/users",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]})))

(defn buyers-clients-users-create
  "Creates a new client user in \"INVITED\" state. An email invitation will be sent to the new user, once accepted the user will become active.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/buyers.clients.users/create

parent <string> Required. The name of the client. Format: `buyers/{accountId}/clients/{clientAccountId}`
ClientUser:
{:name string,
 :state [STATE_UNSPECIFIED INVITED ACTIVE INACTIVE],
 :email string}"
  [parent ClientUser]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://authorizedbuyersmarketplace.googleapis.com/v1/{+parent}/users",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/authorized-buyers-marketplace"],
     :body ClientUser}))

(defn buyers-clients-users-delete
  "Deletes an existing client user. The client user will lose access to the Authorized Buyers UI. Note that if a client user is deleted, the user's access to the UI can't be restored unless a new client user is created and activated.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/buyers.clients.users/delete

name <string> Required. Format: `buyers/{buyerAccountId}/clients/{clientAccountId}/clientUsers/{userId}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://authorizedbuyersmarketplace.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}))

(defn buyers-clients-users-activate
  "Activates an existing client user. The state of the client user will be updated from \"INACTIVE\" to \"ACTIVE\". This method has no effect if the client user is already in \"ACTIVE\" state. An error will be returned if the client user to activate is still in \"INVITED\" state.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/buyers.clients.users/activate

name <string> Required. Format: `buyers/{buyerAccountId}/clients/{clientAccountId}/clientUsers/{userId}`
ActivateClientUserRequest:
object"
  [name ActivateClientUserRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://authorizedbuyersmarketplace.googleapis.com/v1/{+name}:activate",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/authorized-buyers-marketplace"],
     :body ActivateClientUserRequest}))

(defn buyers-clients-users-deactivate
  "Deactivates an existing client user. The state of the client user will be updated from \"ACTIVE\" to \"INACTIVE\". This method has no effect if the client user is already in \"INACTIVE\" state. An error will be returned if the client user to deactivate is still in \"INVITED\" state.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/buyers.clients.users/deactivate

name <string> Required. Format: `buyers/{buyerAccountId}/clients/{clientAccountId}/clientUsers/{userId}`
DeactivateClientUserRequest:
object"
  [name DeactivateClientUserRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://authorizedbuyersmarketplace.googleapis.com/v1/{+name}:deactivate",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/authorized-buyers-marketplace"],
     :body DeactivateClientUserRequest}))

(defn buyers-finalizedDeals-get
  "Gets a finalized deal given its name.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/buyers.finalizedDeals/get

name <string> Required. Format: `buyers/{accountId}/finalizedDeals/{dealId}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://authorizedbuyersmarketplace.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}))

(defn buyers-finalizedDeals-list
  "Lists finalized deals. Use the URL path \"/v1/buyers/{accountId}/finalizedDeals\" to list finalized deals for the current buyer and its clients. Bidders can use the URL path \"/v1/bidders/{accountId}/finalizedDeals\" to list finalized deals for the bidder, its buyers and all their clients.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/buyers.finalizedDeals/list

parent <string> Required. The buyer to list the finalized deals for, in the format: `buyers/{accountId}`. When used to list finalized deals for a bidder, its buyers and clients, in the format `bidders/{accountId}`.

optional:
filter <string> Optional query string using the [Cloud API list filtering syntax](https://developers.google.com/authorized-buyers/apis/guides/list-filters) Supported columns for filtering are: * deal.displayName * deal.dealType * deal.createTime * deal.updateTime * deal.flightStartTime * deal.flightEndTime * deal.eligibleSeatIds * dealServingStatus
orderBy <string> An optional query string to sort finalized deals using the [Cloud API sorting syntax](https://cloud.google.com/apis/design/design_patterns#sorting_order). If no sort order is specified, results will be returned in an arbitrary order. Supported columns for sorting are: * deal.displayName * deal.createTime * deal.updateTime * deal.flightStartTime * deal.flightEndTime * rtbMetrics.bidRequests7Days * rtbMetrics.bids7Days * rtbMetrics.adImpressions7Days * rtbMetrics.bidRate7Days * rtbMetrics.filteredBidRate7Days * rtbMetrics.mustBidRateCurrentMonth
pageSize <integer> Requested page size. The server may return fewer results than requested. If requested more than 500, the server will return 500 results per page. If unspecified, the server will pick a default page size of 100."
  ([parent] (buyers-finalizedDeals-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://authorizedbuyersmarketplace.googleapis.com/v1/{+parent}/finalizedDeals",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]})))

(defn buyers-finalizedDeals-pause
  "Pauses serving of the given finalized deal. This call only pauses the serving status, and does not affect other fields of the finalized deal. Calling this method for an already paused deal has no effect. This method only applies to programmatic guaranteed deals and preferred deals.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/buyers.finalizedDeals/pause

name <string> Required. Format: `buyers/{accountId}/finalizedDeals/{dealId}`
PauseFinalizedDealRequest:
{:reason string}"
  [name PauseFinalizedDealRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://authorizedbuyersmarketplace.googleapis.com/v1/{+name}:pause",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/authorized-buyers-marketplace"],
     :body PauseFinalizedDealRequest}))

(defn buyers-finalizedDeals-resume
  "Resumes serving of the given finalized deal. Calling this method for an running deal has no effect. If a deal is initially paused by the seller, calling this method will not resume serving of the deal until the seller also resumes the deal. This method only applies to programmatic guaranteed deals and preferred deals.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/buyers.finalizedDeals/resume

name <string> Required. Format: `buyers/{accountId}/finalizedDeals/{dealId}`
ResumeFinalizedDealRequest:
object"
  [name ResumeFinalizedDealRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://authorizedbuyersmarketplace.googleapis.com/v1/{+name}:resume",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/authorized-buyers-marketplace"],
     :body ResumeFinalizedDealRequest}))

(defn buyers-finalizedDeals-addCreative
  "Add creative to be used in the bidding process for a finalized deal. For programmatic guaranteed deals, it's recommended that you associate at least one approved creative with the deal before calling SetReadyToServe, to help reduce the number of bid responses filtered because they don't contain approved creatives. Creatives successfully added to a deal can be found in the Realtime-bidding Creatives API creative.deal_ids. This method only applies to programmatic guaranteed deals. Maximum number of 1000 creatives can be added to a finalized deal.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/buyers.finalizedDeals/addCreative

deal <string> Required. Name of the finalized deal in the format of: `buyers/{accountId}/finalizedDeals/{dealId}`
AddCreativeRequest:
{:creative string}"
  [deal AddCreativeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://authorizedbuyersmarketplace.googleapis.com/v1/{+deal}:addCreative",
     :uri-template-args {:deal deal},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/authorized-buyers-marketplace"],
     :body AddCreativeRequest}))

(defn buyers-finalizedDeals-setReadyToServe
  "Sets the given finalized deal as ready to serve. By default, deals are set as ready to serve as soon as they're finalized. If you want to opt out of the default behavior, and manually indicate that deals are ready to serve, ask your Technical Account Manager to add you to the allowlist. If you choose to use this method, finalized deals belonging to the bidder and its child seats don't start serving until after you call `setReadyToServe`, and after the deals become active. For example, you can use this method to delay receiving bid requests until your creative is ready. This method only applies to programmatic guaranteed deals.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/buyers.finalizedDeals/setReadyToServe

deal <string> Required. Format: `buyers/{accountId}/finalizedDeals/{dealId}`
SetReadyToServeRequest:
object"
  [deal SetReadyToServeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://authorizedbuyersmarketplace.googleapis.com/v1/{+deal}:setReadyToServe",
     :uri-template-args {:deal deal},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/authorized-buyers-marketplace"],
     :body SetReadyToServeRequest}))

(defn buyers-proposals-get
  "Gets a proposal using its resource name. The proposal is returned at the latest revision.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/buyers.proposals/get

name <string> Required. Name of the proposal. Format: `buyers/{accountId}/proposals/{proposalId}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://authorizedbuyersmarketplace.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}))

(defn buyers-proposals-patch
  "Updates the proposal at the given revision number. If the revision number in the request is behind the latest one kept in the server, an error message will be returned. See FieldMask for how to use FieldMask. Only fields specified in the UpdateProposalRequest.update_mask will be updated; Fields noted as 'Immutable' or 'Output only' yet specified in the UpdateProposalRequest.update_mask will be ignored and left unchanged. Updating a private auction proposal is not allowed and will result in an error.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/buyers.proposals/patch

name <string> Immutable. The name of the proposal serving as a unique identifier. Format: buyers/{accountId}/proposals/{proposalId}
Proposal:
{:displayName string,
 :billedBuyer string,
 :proposalRevision string,
 :name string,
 :client string,
 :originatorRole [BUYER_SELLER_ROLE_UNSPECIFIED BUYER SELLER],
 :state
 [STATE_UNSPECIFIED
  BUYER_REVIEW_REQUESTED
  SELLER_REVIEW_REQUESTED
  BUYER_ACCEPTANCE_REQUESTED
  FINALIZED
  TERMINATED],
 :dealType
 [DEAL_TYPE_UNSPECIFIED
  PREFERRED_DEAL
  PRIVATE_AUCTION
  PROGRAMMATIC_GUARANTEED],
 :publisherProfile string,
 :updateTime string,
 :pausingConsented boolean,
 :notes
 [{:createTime string,
   :creatorRole [BUYER_SELLER_ROLE_UNSPECIFIED BUYER SELLER],
   :note string}],
 :termsAndConditions string,
 :lastUpdaterOrCommentorRole
 [BUYER_SELLER_ROLE_UNSPECIFIED BUYER SELLER],
 :buyerPrivateData {:referenceId string},
 :buyerContacts [{:email string, :displayName string}],
 :buyer string,
 :sellerContacts [{:email string, :displayName string}],
 :isRenegotiating boolean}

optional:
updateMask <string> List of fields to be updated. If empty or unspecified, the service will update all fields populated in the update request excluding the output only fields and primitive fields with default value. Note that explicit field mask is required in order to reset a primitive field back to its default value, for example, false for boolean fields, 0 for integer fields. A special field mask consisting of a single path \"*\" can be used to indicate full replacement(the equivalent of PUT method), updatable fields unset or unspecified in the input will be cleared or set to default value. Output only fields will be ignored regardless of the value of updateMask."
  ([name Proposal] (buyers-proposals-patch name Proposal nil))
  ([name Proposal optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://authorizedbuyersmarketplace.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/authorized-buyers-marketplace"],
       :body Proposal})))

(defn buyers-proposals-list
  "Lists proposals. A filter expression using [Cloud API list filtering syntax](https://developers.google.com/authorized-buyers/apis/guides/list-filters) may be specified to filter the results.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/buyers.proposals/list

parent <string> Required. Parent that owns the collection of proposals Format: `buyers/{accountId}`

optional:
filter <string> Optional query string using the [Cloud API list filtering syntax](https://developers.google.com/authorized-buyers/apis/guides/list-filters) Supported columns for filtering are: * displayName * dealType * updateTime * state
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will put a size of 500."
  ([parent] (buyers-proposals-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://authorizedbuyersmarketplace.googleapis.com/v1/{+parent}/proposals",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]})))

(defn buyers-proposals-cancelNegotiation
  "Cancels an ongoing negotiation on a proposal. This does not cancel or end serving for the deals if the proposal has been finalized. If the proposal has not been finalized before, calling this method will set the Proposal.state to `TERMINATED` and increment the Proposal.proposal_revision. If the proposal has been finalized before and is under renegotiation now, calling this method will reset the Proposal.state to `FINALIZED` and increment the Proposal.proposal_revision. This method does not support private auction proposals whose Proposal.deal_type is 'PRIVATE_AUCTION'.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/buyers.proposals/cancelNegotiation

proposal <string> Name of the proposal. Format: `buyers/{accountId}/proposals/{proposalId}`
CancelNegotiationRequest:
object"
  [proposal CancelNegotiationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://authorizedbuyersmarketplace.googleapis.com/v1/{+proposal}:cancelNegotiation",
     :uri-template-args {:proposal proposal},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/authorized-buyers-marketplace"],
     :body CancelNegotiationRequest}))

(defn buyers-proposals-accept
  "Accepts the proposal at the given revision number. If the revision number in the request is behind the latest from the server, an error message will be returned. This call updates the Proposal.state from `BUYER_ACCEPTANCE_REQUESTED` to `FINALIZED`; it has no side effect if the Proposal.state is already `FINALIZED` and throws exception if the Proposal.state is not either `BUYER_ACCEPTANCE_REQUESTED` or `FINALIZED`. Accepting a proposal means the buyer understands and accepts the Proposal.terms_and_conditions proposed by the seller.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/buyers.proposals/accept

name <string> Name of the proposal. Format: `buyers/{accountId}/proposals/{proposalId}`
AcceptProposalRequest:
{:proposalRevision string}"
  [name AcceptProposalRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://authorizedbuyersmarketplace.googleapis.com/v1/{+name}:accept",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/authorized-buyers-marketplace"],
     :body AcceptProposalRequest}))

(defn buyers-proposals-addNote
  "Creates a note for this proposal and sends to the seller. This method is not supported for proposals with DealType set to 'PRIVATE_AUCTION'.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/buyers.proposals/addNote

proposal <string> Name of the proposal. Format: `buyers/{accountId}/proposals/{proposalId}`
AddNoteRequest:
{:note
 {:createTime string,
  :creatorRole [BUYER_SELLER_ROLE_UNSPECIFIED BUYER SELLER],
  :note string}}"
  [proposal AddNoteRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://authorizedbuyersmarketplace.googleapis.com/v1/{+proposal}:addNote",
     :uri-template-args {:proposal proposal},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/authorized-buyers-marketplace"],
     :body AddNoteRequest}))

(defn buyers-proposals-sendRfp
  "Sends a request for proposal (RFP) to a publisher to initiate the negotiation regarding certain inventory. In the RFP, buyers can specify the deal type, deal terms, start and end dates, targeting, and a message to the publisher. Once the RFP is sent, a proposal in `SELLER_REVIEW_REQUESTED` state will be created and returned in the response. The publisher may review your request and respond with detailed deals in the proposal.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/buyers.proposals/sendRfp

buyer <string> Required. The current buyer who is sending the RFP in the format: `buyers/{accountId}`.
SendRfpRequest:
{:flightStartTime string,
 :geoTargeting
 {:targetedCriteriaIds [string], :excludedCriteriaIds [string]},
 :preferredDealTerms
 {:fixedPrice
  {:type [TYPE_UNSPECIFIED CPM CPD],
   :amount {:currencyCode string, :units string, :nanos integer}}},
 :displayName string,
 :estimatedGrossSpend
 {:currencyCode string, :units string, :nanos integer},
 :client string,
 :programmaticGuaranteedTerms
 {:guaranteedLooks string,
  :fixedPrice
  {:type [TYPE_UNSPECIFIED CPM CPD],
   :amount {:currencyCode string, :units string, :nanos integer}},
  :minimumDailyLooks string,
  :reservationType [RESERVATION_TYPE_UNSPECIFIED STANDARD SPONSORSHIP],
  :impressionCap string,
  :percentShareOfVoice string},
 :publisherProfile string,
 :note string,
 :buyerContacts [{:email string, :displayName string}],
 :flightEndTime string,
 :inventorySizeTargeting
 {:targetedInventorySizes
  [{:width string,
    :height string,
    :type [TYPE_UNSPECIFIED PIXEL INTERSTITIAL NATIVE FLUID]}],
  :excludedInventorySizes
  [{:width string,
    :height string,
    :type [TYPE_UNSPECIFIED PIXEL INTERSTITIAL NATIVE FLUID]}]}}"
  [buyer SendRfpRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://authorizedbuyersmarketplace.googleapis.com/v1/{+buyer}/proposals:sendRfp",
     :uri-template-args {:buyer buyer},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/authorized-buyers-marketplace"],
     :body SendRfpRequest}))

(defn buyers-proposals-deals-get
  "Gets a deal given its name. The deal is returned at its head revision.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/buyers.proposals.deals/get

name <string> Required. Format: buyers/{accountId}/proposals/{proposalId}/deals/{dealId}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://authorizedbuyersmarketplace.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}))

(defn buyers-proposals-deals-patch
  "Updates the given deal at the buyer known revision number. If the server revision has advanced since the passed-in proposal.proposal_revision an ABORTED error message will be returned. The revision number is incremented by the server whenever the proposal or its constituent deals are updated. Note: The revision number is kept at a proposal level. The buyer of the API is expected to keep track of the revision number after the last update operation and send it in as part of the next update request. This way, if there are further changes on the server (for example, seller making new updates), then the server can detect conflicts and reject the proposed changes.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/buyers.proposals.deals/patch

name <string> Immutable. The unique identifier of the deal. Auto-generated by the server when a deal is created. Format: buyers/{accountId}/proposals/{proposalId}/deals/{dealId}
Deal:
{:description string,
 :flightStartTime string,
 :sellerTimeZone {:id string, :version string},
 :preferredDealTerms
 {:fixedPrice
  {:type [TYPE_UNSPECIFIED CPM CPD],
   :amount {:currencyCode string, :units string, :nanos integer}}},
 :displayName string,
 :billedBuyer string,
 :proposalRevision string,
 :name string,
 :estimatedGrossSpend
 {:currencyCode string, :units string, :nanos integer},
 :client string,
 :createTime string,
 :mediaPlanner {:accountId string},
 :dealType
 [DEAL_TYPE_UNSPECIFIED
  PREFERRED_DEAL
  PRIVATE_AUCTION
  PROGRAMMATIC_GUARANTEED],
 :programmaticGuaranteedTerms
 {:guaranteedLooks string,
  :fixedPrice
  {:type [TYPE_UNSPECIFIED CPM CPD],
   :amount {:currencyCode string, :units string, :nanos integer}},
  :minimumDailyLooks string,
  :reservationType [RESERVATION_TYPE_UNSPECIFIED STANDARD SPONSORSHIP],
  :impressionCap string,
  :percentShareOfVoice string},
 :publisherProfile string,
 :updateTime string,
 :eligibleSeatIds [string],
 :privateAuctionTerms
 {:floorPrice
  {:type [TYPE_UNSPECIFIED CPM CPD],
   :amount {:currencyCode string, :units string, :nanos integer}},
  :openAuctionAllowed boolean},
 :creativeRequirements
 {:creativePreApprovalPolicy
  [CREATIVE_PRE_APPROVAL_POLICY_UNSPECIFIED
   SELLER_PRE_APPROVAL_REQUIRED
   SELLER_PRE_APPROVAL_NOT_REQUIRED],
  :creativeSafeFrameCompatibility
  [CREATIVE_SAFE_FRAME_COMPATIBILITY_UNSPECIFIED
   COMPATIBLE
   INCOMPATIBLE],
  :programmaticCreativeSource
  [PROGRAMMATIC_CREATIVE_SOURCE_UNSPECIFIED ADVERTISER PUBLISHER],
  :creativeFormat [CREATIVE_FORMAT_UNSPECIFIED DISPLAY VIDEO AUDIO],
  :skippableAdType
  [SKIPPABLE_AD_TYPE_UNSPECIFIED
   SKIPPABLE
   INSTREAM_SELECT
   NOT_SKIPPABLE
   ANY],
  :maxAdDurationMs string},
 :buyer string,
 :flightEndTime string,
 :deliveryControl
 {:deliveryRateType
  [DELIVERY_RATE_TYPE_UNSPECIFIED
   EVENLY
   FRONT_LOADED
   AS_FAST_AS_POSSIBLE],
  :frequencyCap
  [{:maxImpressions integer,
    :timeUnitsCount integer,
    :timeUnitType
    [TIME_UNIT_TYPE_UNSPECIFIED
     MINUTE
     HOUR
     DAY
     WEEK
     MONTH
     LIFETIME
     POD
     STREAM]}],
  :roadblockingType
  [ROADBLOCKING_TYPE_UNSPECIFIED
   ONLY_ONE
   ONE_OR_MORE
   AS_MANY_AS_POSSIBLE
   ALL_ROADBLOCK
   CREATIVE_SET],
  :companionDeliveryType
  [COMPANION_DELIVERY_TYPE_UNSPECIFIED
   DELIVERY_OPTIONAL
   DELIVERY_AT_LEAST_ONE
   DELIVERY_ALL],
  :creativeRotationType
  [CREATIVE_ROTATION_TYPE_UNSPECIFIED
   ROTATION_EVEN
   ROTATION_OPTIMIZED
   ROTATION_MANUAL
   ROTATION_SEQUENTIAL]},
 :targeting
 {:inventoryTypeTargeting
  {:inventoryTypes
   [[INVENTORY_TYPE_UNSPECIFIED BROWSER MOBILE_APP VIDEO_PLAYER]]},
  :geoTargeting
  {:targetedCriteriaIds [string], :excludedCriteriaIds [string]},
  :verticalTargeting
  {:targetedCriteriaIds [string], :excludedCriteriaIds [string]},
  :userListTargeting
  {:targetedCriteriaIds [string], :excludedCriteriaIds [string]},
  :videoTargeting
  {:targetedPositionTypes
   [[POSITION_TYPE_UNSPECIFIED PREROLL MIDROLL POSTROLL]],
   :excludedPositionTypes
   [[POSITION_TYPE_UNSPECIFIED PREROLL MIDROLL POSTROLL]]},
  :placementTargeting
  {:uriTargeting {:targetedUris [string], :excludedUris [string]},
   :mobileApplicationTargeting
   {:firstPartyTargeting
    {:targetedAppIds [string], :excludedAppIds [string]}}},
  :technologyTargeting
  {:deviceCategoryTargeting
   {:targetedCriteriaIds [string], :excludedCriteriaIds [string]},
   :deviceCapabilityTargeting
   {:targetedCriteriaIds [string], :excludedCriteriaIds [string]},
   :operatingSystemTargeting
   {:operatingSystemCriteria
    {:targetedCriteriaIds [string], :excludedCriteriaIds [string]},
    :operatingSystemVersionCriteria
    {:targetedCriteriaIds [string], :excludedCriteriaIds [string]}}},
  :excludedSensitiveCategoryIds [string],
  :inventorySizeTargeting
  {:targetedInventorySizes
   [{:width string,
     :height string,
     :type [TYPE_UNSPECIFIED PIXEL INTERSTITIAL NATIVE FLUID]}],
   :excludedInventorySizes
   [{:width string,
     :height string,
     :type [TYPE_UNSPECIFIED PIXEL INTERSTITIAL NATIVE FLUID]}]},
  :daypartTargeting
  {:timeZoneType [TIME_ZONE_TYPE_UNSPECIFIED SELLER USER],
   :dayParts
   [{:dayOfWeek
     [DAY_OF_WEEK_UNSPECIFIED
      MONDAY
      TUESDAY
      WEDNESDAY
      THURSDAY
      FRIDAY
      SATURDAY
      SUNDAY],
     :startTime
     {:hours integer,
      :minutes integer,
      :seconds integer,
      :nanos integer},
     :endTime
     {:hours integer,
      :minutes integer,
      :seconds integer,
      :nanos integer}}]}}}

optional:
updateMask <string> List of fields to be updated. If empty or unspecified, the service will update all fields populated in the update request excluding the output only fields and primitive fields with default value. Note that explicit field mask is required in order to reset a primitive field back to its default value, for example, false for boolean fields, 0 for integer fields. A special field mask consisting of a single path \"*\" can be used to indicate full replacement(the equivalent of PUT method), updatable fields unset or unspecified in the input will be cleared or set to default value. Output only fields will be ignored regardless of the value of updateMask."
  ([name Deal] (buyers-proposals-deals-patch name Deal nil))
  ([name Deal optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://authorizedbuyersmarketplace.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/authorized-buyers-marketplace"],
       :body Deal})))

(defn buyers-proposals-deals-batchUpdate
  "Batch updates multiple deals in the same proposal.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/buyers.proposals.deals/batchUpdate

parent <string> Required. The name of the proposal containing the deals to batch update. Format: buyers/{accountId}/proposals/{proposalId}
BatchUpdateDealsRequest:
{:requests
 [{:deal
   {:description string,
    :flightStartTime string,
    :sellerTimeZone {:id string, :version string},
    :preferredDealTerms
    {:fixedPrice {:type [TYPE_UNSPECIFIED CPM CPD], :amount Money}},
    :displayName string,
    :billedBuyer string,
    :proposalRevision string,
    :name string,
    :estimatedGrossSpend
    {:currencyCode string, :units string, :nanos integer},
    :client string,
    :createTime string,
    :mediaPlanner {:accountId string},
    :dealType
    [DEAL_TYPE_UNSPECIFIED
     PREFERRED_DEAL
     PRIVATE_AUCTION
     PROGRAMMATIC_GUARANTEED],
    :programmaticGuaranteedTerms
    {:guaranteedLooks string,
     :fixedPrice {:type [TYPE_UNSPECIFIED CPM CPD], :amount Money},
     :minimumDailyLooks string,
     :reservationType
     [RESERVATION_TYPE_UNSPECIFIED STANDARD SPONSORSHIP],
     :impressionCap string,
     :percentShareOfVoice string},
    :publisherProfile string,
    :updateTime string,
    :eligibleSeatIds [string],
    :privateAuctionTerms
    {:floorPrice {:type [TYPE_UNSPECIFIED CPM CPD], :amount Money},
     :openAuctionAllowed boolean},
    :creativeRequirements
    {:creativePreApprovalPolicy
     [CREATIVE_PRE_APPROVAL_POLICY_UNSPECIFIED
      SELLER_PRE_APPROVAL_REQUIRED
      SELLER_PRE_APPROVAL_NOT_REQUIRED],
     :creativeSafeFrameCompatibility
     [CREATIVE_SAFE_FRAME_COMPATIBILITY_UNSPECIFIED
      COMPATIBLE
      INCOMPATIBLE],
     :programmaticCreativeSource
     [PROGRAMMATIC_CREATIVE_SOURCE_UNSPECIFIED ADVERTISER PUBLISHER],
     :creativeFormat [CREATIVE_FORMAT_UNSPECIFIED DISPLAY VIDEO AUDIO],
     :skippableAdType
     [SKIPPABLE_AD_TYPE_UNSPECIFIED
      SKIPPABLE
      INSTREAM_SELECT
      NOT_SKIPPABLE
      ANY],
     :maxAdDurationMs string},
    :buyer string,
    :flightEndTime string,
    :deliveryControl
    {:deliveryRateType
     [DELIVERY_RATE_TYPE_UNSPECIFIED
      EVENLY
      FRONT_LOADED
      AS_FAST_AS_POSSIBLE],
     :frequencyCap
     [{:maxImpressions integer,
       :timeUnitsCount integer,
       :timeUnitType
       [TIME_UNIT_TYPE_UNSPECIFIED
        MINUTE
        HOUR
        DAY
        WEEK
        MONTH
        LIFETIME
        POD
        STREAM]}],
     :roadblockingType
     [ROADBLOCKING_TYPE_UNSPECIFIED
      ONLY_ONE
      ONE_OR_MORE
      AS_MANY_AS_POSSIBLE
      ALL_ROADBLOCK
      CREATIVE_SET],
     :companionDeliveryType
     [COMPANION_DELIVERY_TYPE_UNSPECIFIED
      DELIVERY_OPTIONAL
      DELIVERY_AT_LEAST_ONE
      DELIVERY_ALL],
     :creativeRotationType
     [CREATIVE_ROTATION_TYPE_UNSPECIFIED
      ROTATION_EVEN
      ROTATION_OPTIMIZED
      ROTATION_MANUAL
      ROTATION_SEQUENTIAL]},
    :targeting
    {:inventoryTypeTargeting
     {:inventoryTypes
      [[INVENTORY_TYPE_UNSPECIFIED BROWSER MOBILE_APP VIDEO_PLAYER]]},
     :geoTargeting
     {:targetedCriteriaIds [string], :excludedCriteriaIds [string]},
     :verticalTargeting
     {:targetedCriteriaIds [string], :excludedCriteriaIds [string]},
     :userListTargeting
     {:targetedCriteriaIds [string], :excludedCriteriaIds [string]},
     :videoTargeting
     {:targetedPositionTypes
      [[POSITION_TYPE_UNSPECIFIED PREROLL MIDROLL POSTROLL]],
      :excludedPositionTypes
      [[POSITION_TYPE_UNSPECIFIED PREROLL MIDROLL POSTROLL]]},
     :placementTargeting
     {:uriTargeting UriTargeting,
      :mobileApplicationTargeting MobileApplicationTargeting},
     :technologyTargeting
     {:deviceCategoryTargeting CriteriaTargeting,
      :deviceCapabilityTargeting CriteriaTargeting,
      :operatingSystemTargeting OperatingSystemTargeting},
     :excludedSensitiveCategoryIds [string],
     :inventorySizeTargeting
     {:targetedInventorySizes [AdSize],
      :excludedInventorySizes [AdSize]},
     :daypartTargeting
     {:timeZoneType [TIME_ZONE_TYPE_UNSPECIFIED SELLER USER],
      :dayParts [DayPart]}}},
   :updateMask string}]}"
  [parent BatchUpdateDealsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://authorizedbuyersmarketplace.googleapis.com/v1/{+parent}/deals:batchUpdate",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/authorized-buyers-marketplace"],
     :body BatchUpdateDealsRequest}))

(defn buyers-proposals-deals-list
  "Lists all deals in a proposal. To retrieve only the finalized revision deals regardless if a deal is being renegotiated, see the FinalizedDeals resource.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/buyers.proposals.deals/list

parent <string> Required. The name of the proposal containing the deals to retrieve. Format: buyers/{accountId}/proposals/{proposalId}

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. If requested more than 500, the server will return 500 results per page. If unspecified, the server will pick a default page size of 100."
  ([parent] (buyers-proposals-deals-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://authorizedbuyersmarketplace.googleapis.com/v1/{+parent}/deals",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]})))

(defn buyers-publisherProfiles-get
  "Gets the requested publisher profile by name.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/buyers.publisherProfiles/get

name <string> Required. Name of the publisher profile. Format: `buyers/{buyerId}/publisherProfiles/{publisherProfileId}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://authorizedbuyersmarketplace.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}))

(defn buyers-publisherProfiles-list
  "Lists publisher profiles. The returned publisher profiles aren't in any defined order. The order of the results might change. A new publisher profile can appear in any place in the list of returned results.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/buyers.publisherProfiles/list

parent <string> Required. Parent that owns the collection of publisher profiles Format: `buyers/{buyerId}`

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. If requested more than 500, the server will return 500 results per page. If unspecified, the server will pick a default page size of 100.
filter <string> Optional query string using the [Cloud API list filtering] (https://developers.google.com/authorized-buyers/apis/guides/list-filters) syntax."
  ([parent] (buyers-publisherProfiles-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://authorizedbuyersmarketplace.googleapis.com/v1/{+parent}/publisherProfiles",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]})))

(defn bidders-auctionPackages-list
  "List the auction packages. Buyers can use the URL path \"/v1/buyers/{accountId}/auctionPackages\" to list auction packages for the current buyer and its clients. Bidders can use the URL path \"/v1/bidders/{accountId}/auctionPackages\" to list auction packages for the bidder, its media planners, its buyers, and all their clients.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/bidders.auctionPackages/list

parent <string> Required. Name of the parent buyer that can access the auction package. Format: `buyers/{accountId}`. When used with a bidder account, the auction packages that the bidder, its media planners, its buyers and clients are subscribed to will be listed, in the format `bidders/{accountId}`.

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. Max allowed page size is 500.
filter <string> Optional. Optional query string using the [Cloud API list filtering syntax](/authorized-buyers/apis/guides/list-filters). Only supported when parent is bidder. Supported columns for filtering are: * displayName * createTime * updateTime * eligibleSeatIds
orderBy <string> Optional. An optional query string to sort auction packages using the [Cloud API sorting syntax](https://cloud.google.com/apis/design/design_patterns#sorting_order). If no sort order is specified, results will be returned in an arbitrary order. Only supported when parent is bidder. Supported columns for sorting are: * displayName * createTime * updateTime"
  ([parent] (bidders-auctionPackages-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://authorizedbuyersmarketplace.googleapis.com/v1/{+parent}/auctionPackages",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]})))

(defn bidders-finalizedDeals-list
  "Lists finalized deals. Use the URL path \"/v1/buyers/{accountId}/finalizedDeals\" to list finalized deals for the current buyer and its clients. Bidders can use the URL path \"/v1/bidders/{accountId}/finalizedDeals\" to list finalized deals for the bidder, its buyers and all their clients.
https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/v1/bidders.finalizedDeals/list

parent <string> Required. The buyer to list the finalized deals for, in the format: `buyers/{accountId}`. When used to list finalized deals for a bidder, its buyers and clients, in the format `bidders/{accountId}`.

optional:
filter <string> Optional query string using the [Cloud API list filtering syntax](https://developers.google.com/authorized-buyers/apis/guides/list-filters) Supported columns for filtering are: * deal.displayName * deal.dealType * deal.createTime * deal.updateTime * deal.flightStartTime * deal.flightEndTime * deal.eligibleSeatIds * dealServingStatus
orderBy <string> An optional query string to sort finalized deals using the [Cloud API sorting syntax](https://cloud.google.com/apis/design/design_patterns#sorting_order). If no sort order is specified, results will be returned in an arbitrary order. Supported columns for sorting are: * deal.displayName * deal.createTime * deal.updateTime * deal.flightStartTime * deal.flightEndTime * rtbMetrics.bidRequests7Days * rtbMetrics.bids7Days * rtbMetrics.adImpressions7Days * rtbMetrics.bidRate7Days * rtbMetrics.filteredBidRate7Days * rtbMetrics.mustBidRateCurrentMonth
pageSize <integer> Requested page size. The server may return fewer results than requested. If requested more than 500, the server will return 500 results per page. If unspecified, the server will pick a default page size of 100."
  ([parent] (bidders-finalizedDeals-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://authorizedbuyersmarketplace.googleapis.com/v1/{+parent}/finalizedDeals",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]})))

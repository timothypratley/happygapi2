(ns happygapi2.mybusinessaccountmanagement
  "My Business Account Management API
The My Business Account Management API provides an interface for managing access to a location on Google. Note - If you have a quota of 0 after enabling the API, please request for GBP API access.
See: https://developers.google.com/my-business/"
  (:require [happy.oauth2.client :as client]))

(defn locations-transfer
  "Moves a location from an account that the user owns to another account that the same user administers. The user must be an owner of the account the location is currently associated with and must also be at least a manager of the destination account.
https://developers.google.com/my-business

name <string> Required. The name of the location to transfer. `locations/{location_id}`.
TransferLocationRequest:
{:destinationAccount string}"
  [name TransferLocationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://mybusinessaccountmanagement.googleapis.com/v1/{+name}:transfer",
     :uri-template-args {:name name},
     :query-params {},
     :scopes nil,
     :body TransferLocationRequest}))

(defn locations-admins-list
  "Lists all of the admins for the specified location.
https://developers.google.com/my-business

parent <string> Required. The name of the location to list admins of. `locations/{location_id}/admins`."
  [parent]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://mybusinessaccountmanagement.googleapis.com/v1/{+parent}/admins",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes nil}))

(defn locations-admins-create
  "Invites the specified user to become an administrator for the specified location. The invitee must accept the invitation in order to be granted access to the location. See AcceptInvitation to programmatically accept an invitation.
https://developers.google.com/my-business

parent <string> Required. The resource name of the location this admin is created for. `locations/{location_id}/admins`.
Admin:
{:name string,
 :admin string,
 :account string,
 :role
 [ADMIN_ROLE_UNSPECIFIED PRIMARY_OWNER OWNER MANAGER SITE_MANAGER],
 :pendingInvitation boolean}"
  [parent Admin]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://mybusinessaccountmanagement.googleapis.com/v1/{+parent}/admins",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes nil,
     :body Admin}))

(defn locations-admins-delete
  "Removes the specified admin as a manager of the specified location.
https://developers.google.com/my-business

name <string> Required. The resource name of the admin to remove from the location."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://mybusinessaccountmanagement.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes nil}))

(defn locations-admins-patch
  "Updates the Admin for the specified location. Only the AdminRole of the Admin can be updated.
https://developers.google.com/my-business

name <string> Immutable. The resource name. For account admins, this is in the form: `accounts/{account_id}/admins/{admin_id}` For location admins, this is in the form: `locations/{location_id}/admins/{admin_id}` This field will be ignored if set during admin creation.
Admin:
{:name string,
 :admin string,
 :account string,
 :role
 [ADMIN_ROLE_UNSPECIFIED PRIMARY_OWNER OWNER MANAGER SITE_MANAGER],
 :pendingInvitation boolean}

optional:
updateMask <string> Required. The specific fields that should be updated. The only editable field is role."
  ([name Admin] (locations-admins-patch name Admin nil))
  ([name Admin optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://mybusinessaccountmanagement.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes nil,
       :body Admin})))

(defn accounts-list
  "Lists all of the accounts for the authenticated user. This includes all accounts that the user owns, as well as any accounts for which the user has management rights.
https://developers.google.com/my-business

optional:
parentAccount <string> Optional. The resource name of the account for which the list of directly accessible accounts is to be retrieved. This only makes sense for Organizations and User Groups. If empty, will return `ListAccounts` for the authenticated user. `accounts/{account_id}`.
pageSize <integer> Optional. How many accounts to fetch per page. The default and maximum is 20.
filter <string> Optional. A filter constraining the accounts to return. The response includes only entries that match the filter. If `filter` is empty, then no constraints are applied and all accounts (paginated) are retrieved for the requested account. For example, a request with the filter `type=USER_GROUP` will only return user groups. The `type` field is the only supported filter."
  ([] (accounts-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://mybusinessaccountmanagement.googleapis.com/v1/accounts",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes nil})))

(defn accounts-get
  "Gets the specified account. Returns `NOT_FOUND` if the account does not exist or if the caller does not have access rights to it.
https://developers.google.com/my-business

name <string> Required. The name of the account to fetch."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://mybusinessaccountmanagement.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes nil}))

(defn accounts-create
  "Creates an account with the specified name and type under the given parent. - Personal accounts and Organizations cannot be created. - User Groups cannot be created with a Personal account as primary owner. - Location Groups cannot be created with a primary owner of a Personal account if the Personal account is in an Organization. - Location Groups cannot own Location Groups.
https://developers.google.com/my-business

Account:
{:role
 [ACCOUNT_ROLE_UNSPECIFIED PRIMARY_OWNER OWNER MANAGER SITE_MANAGER],
 :vettedState [VETTED_STATE_UNSPECIFIED NOT_VETTED VETTED INVALID],
 :primaryOwner string,
 :accountNumber string,
 :name string,
 :accountName string,
 :type
 [ACCOUNT_TYPE_UNSPECIFIED
  PERSONAL
  LOCATION_GROUP
  USER_GROUP
  ORGANIZATION],
 :verificationState
 [VERIFICATION_STATE_UNSPECIFIED
  VERIFIED
  UNVERIFIED
  VERIFICATION_REQUESTED],
 :organizationInfo
 {:registeredDomain string,
  :address
  {:sortingCode string,
   :locality string,
   :revision integer,
   :administrativeArea string,
   :addressLines [string],
   :organization string,
   :recipients [string],
   :languageCode string,
   :regionCode string,
   :postalCode string,
   :sublocality string},
  :phoneNumber string},
 :permissionLevel
 [PERMISSION_LEVEL_UNSPECIFIED OWNER_LEVEL MEMBER_LEVEL]}"
  [Account]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://mybusinessaccountmanagement.googleapis.com/v1/accounts",
     :uri-template-args {},
     :query-params {},
     :scopes nil,
     :body Account}))

(defn accounts-patch
  "Updates the specified business account. Personal accounts cannot be updated using this method.
https://developers.google.com/my-business

name <string> Immutable. The resource name, in the format `accounts/{account_id}`.
Account:
{:role
 [ACCOUNT_ROLE_UNSPECIFIED PRIMARY_OWNER OWNER MANAGER SITE_MANAGER],
 :vettedState [VETTED_STATE_UNSPECIFIED NOT_VETTED VETTED INVALID],
 :primaryOwner string,
 :accountNumber string,
 :name string,
 :accountName string,
 :type
 [ACCOUNT_TYPE_UNSPECIFIED
  PERSONAL
  LOCATION_GROUP
  USER_GROUP
  ORGANIZATION],
 :verificationState
 [VERIFICATION_STATE_UNSPECIFIED
  VERIFIED
  UNVERIFIED
  VERIFICATION_REQUESTED],
 :organizationInfo
 {:registeredDomain string,
  :address
  {:sortingCode string,
   :locality string,
   :revision integer,
   :administrativeArea string,
   :addressLines [string],
   :organization string,
   :recipients [string],
   :languageCode string,
   :regionCode string,
   :postalCode string,
   :sublocality string},
  :phoneNumber string},
 :permissionLevel
 [PERMISSION_LEVEL_UNSPECIFIED OWNER_LEVEL MEMBER_LEVEL]}

optional:
updateMask <string> Required. The specific fields that should be updated. The only editable field is `accountName`.
validateOnly <boolean> Optional. If true, the request is validated without actually updating the account."
  ([name Account] (accounts-patch name Account nil))
  ([name Account optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://mybusinessaccountmanagement.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes nil,
       :body Account})))

(defn accounts-invitations-accept
  "Accepts the specified invitation.
https://developers.google.com/my-business

name <string> Required. The name of the invitation that is being accepted. `accounts/{account_id}/invitations/{invitation_id}`
AcceptInvitationRequest:
object"
  [name AcceptInvitationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://mybusinessaccountmanagement.googleapis.com/v1/{+name}:accept",
     :uri-template-args {:name name},
     :query-params {},
     :scopes nil,
     :body AcceptInvitationRequest}))

(defn accounts-invitations-decline
  "Declines the specified invitation.
https://developers.google.com/my-business

name <string> Required. The name of the account invitation that is being declined. `accounts/{account_id}/invitations/{invitation_id}`
DeclineInvitationRequest:
object"
  [name DeclineInvitationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://mybusinessaccountmanagement.googleapis.com/v1/{+name}:decline",
     :uri-template-args {:name name},
     :query-params {},
     :scopes nil,
     :body DeclineInvitationRequest}))

(defn accounts-invitations-list
  "Lists pending invitations for the specified account.
https://developers.google.com/my-business

parent <string> Required. The name of the account from which the list of invitations is being retrieved. `accounts/{account_id}/invitations`

optional:
filter <string> Optional. Filtering the response is supported via the Invitation.target_type field."
  ([parent] (accounts-invitations-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://mybusinessaccountmanagement.googleapis.com/v1/{+parent}/invitations",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes nil})))

(defn accounts-admins-list
  "Lists the admins for the specified account.
https://developers.google.com/my-business

parent <string> Required. The name of the account from which to retrieve a list of admins. `accounts/{account_id}/admins`."
  [parent]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://mybusinessaccountmanagement.googleapis.com/v1/{+parent}/admins",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes nil}))

(defn accounts-admins-create
  "Invites the specified user to become an administrator for the specified account. The invitee must accept the invitation in order to be granted access to the account. See AcceptInvitation to programmatically accept an invitation.
https://developers.google.com/my-business

parent <string> Required. The resource name of the account this admin is created for. `accounts/{account_id}`.
Admin:
{:name string,
 :admin string,
 :account string,
 :role
 [ADMIN_ROLE_UNSPECIFIED PRIMARY_OWNER OWNER MANAGER SITE_MANAGER],
 :pendingInvitation boolean}"
  [parent Admin]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://mybusinessaccountmanagement.googleapis.com/v1/{+parent}/admins",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes nil,
     :body Admin}))

(defn accounts-admins-delete
  "Removes the specified admin from the specified account.
https://developers.google.com/my-business

name <string> Required. The resource name of the admin to remove from the account. `accounts/{account_id}/admins/{admin_id}`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://mybusinessaccountmanagement.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes nil}))

(defn accounts-admins-patch
  "Updates the Admin for the specified Account Admin.
https://developers.google.com/my-business

name <string> Immutable. The resource name. For account admins, this is in the form: `accounts/{account_id}/admins/{admin_id}` For location admins, this is in the form: `locations/{location_id}/admins/{admin_id}` This field will be ignored if set during admin creation.
Admin:
{:name string,
 :admin string,
 :account string,
 :role
 [ADMIN_ROLE_UNSPECIFIED PRIMARY_OWNER OWNER MANAGER SITE_MANAGER],
 :pendingInvitation boolean}

optional:
updateMask <string> Required. The specific fields that should be updated. The only editable field is role."
  ([name Admin] (accounts-admins-patch name Admin nil))
  ([name Admin optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://mybusinessaccountmanagement.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes nil,
       :body Admin})))

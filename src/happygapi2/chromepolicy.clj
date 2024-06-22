(ns happygapi2.chromepolicy
  "Chrome Policy API
The Chrome Policy API is a suite of services that allows Chrome administrators to control the policies applied to their managed Chrome OS devices and Chrome browsers.
See: https://developers.google.com/chrome/policy"
  (:require [happy.oauth2.client :as client]))

(defn customers-policySchemas-get
  "Get a specific policy schema for a customer by its resource name.
https://developers.google.com/chrome/policy/reference/rest/v1/customers.policySchemas/get

name <string> Required. The policy schema resource name to query."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://chromepolicy.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/chrome.management.policy"
      "https://www.googleapis.com/auth/chrome.management.policy.readonly"]}))

(defn customers-policySchemas-list
  "Gets a list of policy schemas that match a specified filter value for a given customer.
https://developers.google.com/chrome/policy/reference/rest/v1/customers.policySchemas/list

parent <string> Required. The customer for which the listing request will apply.

optional:
pageSize <integer> The maximum number of policy schemas to return, defaults to 100 and has a maximum of 1000.
filter <string> The schema filter used to find a particular schema based on fields like its resource name, description and `additionalTargetKeyNames`."
  ([parent] (customers-policySchemas-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://chromepolicy.googleapis.com/v1/{+parent}/policySchemas",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/chrome.management.policy"
        "https://www.googleapis.com/auth/chrome.management.policy.readonly"]})))

(defn customers-policies-resolve
  "Gets the resolved policy values for a list of policies that match a search query.
https://developers.google.com/chrome/policy/reference/rest/v1/customers.policies/resolve

customer <string> ID of the G Suite account or literal \"my_customer\" for the customer associated to the request.
GoogleChromePolicyVersionsV1ResolveRequest:
{:policyTargetKey
 {:targetResource string, :additionalTargetKeys object},
 :policySchemaFilter string,
 :pageToken string,
 :pageSize integer}"
  [customer GoogleChromePolicyVersionsV1ResolveRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://chromepolicy.googleapis.com/v1/{+customer}/policies:resolve",
     :uri-template-args {:customer customer},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/chrome.management.policy"
      "https://www.googleapis.com/auth/chrome.management.policy.readonly"],
     :body GoogleChromePolicyVersionsV1ResolveRequest}))

(defn customers-policies-networks-defineNetwork
  "Define a new network.
https://developers.google.com/chrome/policy/reference/rest/v1/customers.policies.networks/defineNetwork

customer <string> Required. The customer who will own this new network.
GoogleChromePolicyVersionsV1DefineNetworkRequest:
{:settings [{:policySchema string, :value object}],
 :targetResource string,
 :name string}"
  [customer GoogleChromePolicyVersionsV1DefineNetworkRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://chromepolicy.googleapis.com/v1/{+customer}/policies/networks:defineNetwork",
     :uri-template-args {:customer customer},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/chrome.management.policy"],
     :body GoogleChromePolicyVersionsV1DefineNetworkRequest}))

(defn customers-policies-networks-defineCertificate
  "Creates a certificate at a specified OU for a customer.
https://developers.google.com/chrome/policy/reference/rest/v1/customers.policies.networks/defineCertificate

customer <string> Required. The customer for which the certificate will apply.
GoogleChromePolicyVersionsV1DefineCertificateRequest:
{:settings [{:policySchema string, :value object}],
 :targetResource string,
 :certificate string,
 :ceritificateName string}"
  [customer GoogleChromePolicyVersionsV1DefineCertificateRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://chromepolicy.googleapis.com/v1/{+customer}/policies/networks:defineCertificate",
     :uri-template-args {:customer customer},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/chrome.management.policy"],
     :body GoogleChromePolicyVersionsV1DefineCertificateRequest}))

(defn customers-policies-networks-removeNetwork
  "Remove an existing network by guid.
https://developers.google.com/chrome/policy/reference/rest/v1/customers.policies.networks/removeNetwork

customer <string> Required. The customer whose network will be removed.
GoogleChromePolicyVersionsV1RemoveNetworkRequest:
{:networkId string, :targetResource string}"
  [customer GoogleChromePolicyVersionsV1RemoveNetworkRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://chromepolicy.googleapis.com/v1/{+customer}/policies/networks:removeNetwork",
     :uri-template-args {:customer customer},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/chrome.management.policy"],
     :body GoogleChromePolicyVersionsV1RemoveNetworkRequest}))

(defn customers-policies-networks-removeCertificate
  "Remove an existing certificate by guid.
https://developers.google.com/chrome/policy/reference/rest/v1/customers.policies.networks/removeCertificate

customer <string> Required. The customer whose certificate will be removed.
GoogleChromePolicyVersionsV1RemoveCertificateRequest:
{:networkId string, :targetResource string}"
  [customer GoogleChromePolicyVersionsV1RemoveCertificateRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://chromepolicy.googleapis.com/v1/{+customer}/policies/networks:removeCertificate",
     :uri-template-args {:customer customer},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/chrome.management.policy"],
     :body GoogleChromePolicyVersionsV1RemoveCertificateRequest}))

(defn customers-policies-groups-batchDelete
  "Delete multiple policy values that are applied to a specific group. All targets must have the same target format. That is to say that they must point to the same target resource and must have the same keys specified in `additionalTargetKeyNames`, though the values for those keys may be different. On failure the request will return the error details as part of the google.rpc.Status.
https://developers.google.com/chrome/policy/reference/rest/v1/customers.policies.groups/batchDelete

customer <string> ID of the Google Workspace account or literal \"my_customer\" for the customer associated to the request.
GoogleChromePolicyVersionsV1BatchDeleteGroupPoliciesRequest:
{:requests
 [{:policySchema string,
   :policyTargetKey
   {:targetResource string, :additionalTargetKeys object}}]}"
  [customer
   GoogleChromePolicyVersionsV1BatchDeleteGroupPoliciesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://chromepolicy.googleapis.com/v1/{+customer}/policies/groups:batchDelete",
     :uri-template-args {:customer customer},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/chrome.management.policy"],
     :body
     GoogleChromePolicyVersionsV1BatchDeleteGroupPoliciesRequest}))

(defn customers-policies-groups-listGroupPriorityOrdering
  "Retrieve a group priority ordering for an app. The target app must be supplied in `additionalTargetKeyNames` in the PolicyTargetKey. On failure the request will return the error details as part of the google.rpc.Status.
https://developers.google.com/chrome/policy/reference/rest/v1/customers.policies.groups/listGroupPriorityOrdering

customer <string> Required. ID of the Google Workspace account or literal \"my_customer\" for the customer associated to the request.
GoogleChromePolicyVersionsV1ListGroupPriorityOrderingRequest:
{:policyTargetKey
 {:targetResource string, :additionalTargetKeys object},
 :policyNamespace string,
 :policySchema string}"
  [customer
   GoogleChromePolicyVersionsV1ListGroupPriorityOrderingRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://chromepolicy.googleapis.com/v1/{+customer}/policies/groups:listGroupPriorityOrdering",
     :uri-template-args {:customer customer},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/chrome.management.policy"
      "https://www.googleapis.com/auth/chrome.management.policy.readonly"],
     :body
     GoogleChromePolicyVersionsV1ListGroupPriorityOrderingRequest}))

(defn customers-policies-groups-updateGroupPriorityOrdering
  "Update a group priority ordering for an app. The target app must be supplied in `additionalTargetKeyNames` in the PolicyTargetKey. On failure the request will return the error details as part of the google.rpc.Status.
https://developers.google.com/chrome/policy/reference/rest/v1/customers.policies.groups/updateGroupPriorityOrdering

customer <string> Required. ID of the Google Workspace account or literal \"my_customer\" for the customer associated to the request.
GoogleChromePolicyVersionsV1UpdateGroupPriorityOrderingRequest:
{:policyNamespace string,
 :policyTargetKey
 {:targetResource string, :additionalTargetKeys object},
 :policySchema string,
 :groupIds [string]}"
  [customer
   GoogleChromePolicyVersionsV1UpdateGroupPriorityOrderingRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://chromepolicy.googleapis.com/v1/{+customer}/policies/groups:updateGroupPriorityOrdering",
     :uri-template-args {:customer customer},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/chrome.management.policy"],
     :body
     GoogleChromePolicyVersionsV1UpdateGroupPriorityOrderingRequest}))

(defn customers-policies-groups-batchModify
  "Modify multiple policy values that are applied to a specific group. All targets must have the same target format. That is to say that they must point to the same target resource and must have the same keys specified in `additionalTargetKeyNames`, though the values for those keys may be different. On failure the request will return the error details as part of the google.rpc.Status.
https://developers.google.com/chrome/policy/reference/rest/v1/customers.policies.groups/batchModify

customer <string> ID of the Google Workspace account or literal \"my_customer\" for the customer associated to the request.
GoogleChromePolicyVersionsV1BatchModifyGroupPoliciesRequest:
{:requests
 [{:updateMask string,
   :policyValue {:policySchema string, :value object},
   :policyTargetKey
   {:targetResource string, :additionalTargetKeys object}}]}"
  [customer
   GoogleChromePolicyVersionsV1BatchModifyGroupPoliciesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://chromepolicy.googleapis.com/v1/{+customer}/policies/groups:batchModify",
     :uri-template-args {:customer customer},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/chrome.management.policy"],
     :body
     GoogleChromePolicyVersionsV1BatchModifyGroupPoliciesRequest}))

(defn customers-policies-orgunits-batchInherit
  "Modify multiple policy values that are applied to a specific org unit so that they now inherit the value from a parent (if applicable). All targets must have the same target format. That is to say that they must point to the same target resource and must have the same keys specified in `additionalTargetKeyNames`, though the values for those keys may be different. On failure the request will return the error details as part of the google.rpc.Status.
https://developers.google.com/chrome/policy/reference/rest/v1/customers.policies.orgunits/batchInherit

customer <string> ID of the G Suite account or literal \"my_customer\" for the customer associated to the request.
GoogleChromePolicyVersionsV1BatchInheritOrgUnitPoliciesRequest:
{:requests
 [{:policySchema string,
   :policyTargetKey
   {:targetResource string, :additionalTargetKeys object}}]}"
  [customer
   GoogleChromePolicyVersionsV1BatchInheritOrgUnitPoliciesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://chromepolicy.googleapis.com/v1/{+customer}/policies/orgunits:batchInherit",
     :uri-template-args {:customer customer},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/chrome.management.policy"],
     :body
     GoogleChromePolicyVersionsV1BatchInheritOrgUnitPoliciesRequest}))

(defn customers-policies-orgunits-batchModify
  "Modify multiple policy values that are applied to a specific org unit. All targets must have the same target format. That is to say that they must point to the same target resource and must have the same keys specified in `additionalTargetKeyNames`, though the values for those keys may be different. On failure the request will return the error details as part of the google.rpc.Status.
https://developers.google.com/chrome/policy/reference/rest/v1/customers.policies.orgunits/batchModify

customer <string> ID of the G Suite account or literal \"my_customer\" for the customer associated to the request.
GoogleChromePolicyVersionsV1BatchModifyOrgUnitPoliciesRequest:
{:requests
 [{:policyValue {:policySchema string, :value object},
   :updateMask string,
   :policyTargetKey
   {:targetResource string, :additionalTargetKeys object}}]}"
  [customer
   GoogleChromePolicyVersionsV1BatchModifyOrgUnitPoliciesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://chromepolicy.googleapis.com/v1/{+customer}/policies/orgunits:batchModify",
     :uri-template-args {:customer customer},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/chrome.management.policy"],
     :body
     GoogleChromePolicyVersionsV1BatchModifyOrgUnitPoliciesRequest}))

(defn media-upload
  "Creates an enterprise file from the content provided by user. Returns a public download url for end user.
https://developers.google.com/chrome/policy/reference/rest/v1/media/upload

customer <string> Required. The customer for which the file upload will apply.
GoogleChromePolicyVersionsV1UploadPolicyFileRequest:
{:policyField string}"
  [customer GoogleChromePolicyVersionsV1UploadPolicyFileRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://chromepolicy.googleapis.com/v1/{+customer}/policies/files:uploadPolicyFile",
     :uri-template-args {:customer customer},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/chrome.management.policy"],
     :body GoogleChromePolicyVersionsV1UploadPolicyFileRequest}))

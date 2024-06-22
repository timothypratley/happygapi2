(ns happygapi2.iam
  "Identity and Access Management (IAM) API
Manages identity and access control for Google Cloud resources, including the creation of service accounts, which you can use to authenticate to Google and make API calls. Enabling this API also enables the IAM Service Account Credentials API (iamcredentials.googleapis.com). However, disabling this API doesn't disable the IAM Service Account Credentials API. 
See: https://cloud.google.com/security/products/iam"
  (:require [happy.oauth2.client :as client]))

(defn policies-listPolicies
  "Retrieves the policies of the specified kind that are attached to a resource. The response lists only policy metadata. In particular, policy rules are omitted.
https://cloud.google.com/security/products/iam/v2/docs/policies/listPolicies

parent <string> Required. The resource that the policy is attached to, along with the kind of policy to list. Format: `policies/{attachment_point}/denypolicies` The attachment point is identified by its URL-encoded full resource name, which means that the forward-slash character, `/`, must be written as `%2F`. For example, `policies/cloudresourcemanager.googleapis.com%2Fprojects%2Fmy-project/denypolicies`. For organizations and folders, use the numeric ID in the full resource name. For projects, you can use the alphanumeric or the numeric ID.

optional:
pageSize <integer> The maximum number of policies to return. IAM ignores this value and uses the value 1000."
  ([parent] (policies-listPolicies parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://iam.googleapis.com/v2/{+parent}",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn policies-get
  "Gets a policy.
https://cloud.google.com/security/products/iam/v2/docs/policies/get

name <string> Required. The resource name of the policy to retrieve. Format: `policies/{attachment_point}/denypolicies/{policy_id}` Use the URL-encoded full resource name, which means that the forward-slash character, `/`, must be written as `%2F`. For example, `policies/cloudresourcemanager.googleapis.com%2Fprojects%2Fmy-project/denypolicies/my-policy`. For organizations and folders, use the numeric ID in the full resource name. For projects, you can use the alphanumeric or the numeric ID."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://iam.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn policies-createPolicy
  "Creates a policy.
https://cloud.google.com/security/products/iam/v2/docs/policies/createPolicy

parent <string> Required. The resource that the policy is attached to, along with the kind of policy to create. Format: `policies/{attachment_point}/denypolicies` The attachment point is identified by its URL-encoded full resource name, which means that the forward-slash character, `/`, must be written as `%2F`. For example, `policies/cloudresourcemanager.googleapis.com%2Fprojects%2Fmy-project/denypolicies`. For organizations and folders, use the numeric ID in the full resource name. For projects, you can use the alphanumeric or the numeric ID.
GoogleIamV2Policy:
{:deleteTime string,
 :displayName string,
 :uid string,
 :name string,
 :createTime string,
 :etag string,
 :rules
 [{:denyRule
   {:deniedPrincipals [string],
    :exceptionPrincipals [string],
    :deniedPermissions [string],
    :exceptionPermissions [string],
    :denialCondition
    {:expression string,
     :title string,
     :description string,
     :location string}},
   :description string}],
 :updateTime string,
 :kind string,
 :annotations object}

optional:
policyId <string> The ID to use for this policy, which will become the final component of the policy's resource name. The ID must contain 3 to 63 characters. It can contain lowercase letters and numbers, as well as dashes (`-`) and periods (`.`). The first character must be a lowercase letter."
  ([parent GoogleIamV2Policy]
    (policies-createPolicy parent GoogleIamV2Policy nil))
  ([parent GoogleIamV2Policy optional]
    (client/api-request
      {:method "POST",
       :uri-template "https://iam.googleapis.com/v2/{+parent}",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleIamV2Policy})))

(defn policies-update
  "Updates the specified policy. You can update only the rules and the display name for the policy. To update a policy, you should use a read-modify-write loop: 1. Use GetPolicy to read the current version of the policy. 2. Modify the policy as needed. 3. Use `UpdatePolicy` to write the updated policy. This pattern helps prevent conflicts between concurrent updates.
https://cloud.google.com/security/products/iam/v2/docs/policies/update

name <string> Immutable. The resource name of the `Policy`, which must be unique. Format: `policies/{attachment_point}/denypolicies/{policy_id}` The attachment point is identified by its URL-encoded full resource name, which means that the forward-slash character, `/`, must be written as `%2F`. For example, `policies/cloudresourcemanager.googleapis.com%2Fprojects%2Fmy-project/denypolicies/my-deny-policy`. For organizations and folders, use the numeric ID in the full resource name. For projects, requests can use the alphanumeric or the numeric ID. Responses always contain the numeric ID.
GoogleIamV2Policy:
{:deleteTime string,
 :displayName string,
 :uid string,
 :name string,
 :createTime string,
 :etag string,
 :rules
 [{:denyRule
   {:deniedPrincipals [string],
    :exceptionPrincipals [string],
    :deniedPermissions [string],
    :exceptionPermissions [string],
    :denialCondition
    {:expression string,
     :title string,
     :description string,
     :location string}},
   :description string}],
 :updateTime string,
 :kind string,
 :annotations object}"
  [name GoogleIamV2Policy]
  (client/api-request
    {:method "PUT",
     :uri-template "https://iam.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV2Policy}))

(defn policies-delete
  "Deletes a policy. This action is permanent.
https://cloud.google.com/security/products/iam/v2/docs/policies/delete

name <string> Required. The resource name of the policy to delete. Format: `policies/{attachment_point}/denypolicies/{policy_id}` Use the URL-encoded full resource name, which means that the forward-slash character, `/`, must be written as `%2F`. For example, `policies/cloudresourcemanager.googleapis.com%2Fprojects%2Fmy-project/denypolicies/my-policy`. For organizations and folders, use the numeric ID in the full resource name. For projects, you can use the alphanumeric or the numeric ID.

optional:
etag <string> Optional. The expected `etag` of the policy to delete. If the value does not match the value that is stored in IAM, the request fails with a `409` error code and `ABORTED` status. If you omit this field, the policy is deleted regardless of its current `etag`."
  ([name] (policies-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://iam.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn policies-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/security/products/iam/v2/docs/policies/operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://iam.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

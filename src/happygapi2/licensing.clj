(ns happygapi2.licensing
  "Enterprise License Manager API
The Google Enterprise License Manager API lets you manage Google Workspace and related licenses for all users of a customer that you manage.
See: https://developers.google.com/admin-sdk/licensing/v1/how-tos/concepts"
  (:require [happy.oauth2.client :as client]))

(defn licenseAssignments-delete
  "Revoke a license.
https://developers.google.com/admin-sdk/licensing/v1/how-tos/concepts

productId <string> A product's unique identifier. For more information about products in this version of the API, see Products and SKUs.
skuId <string> A product SKU's unique identifier. For more information about available SKUs in this version of the API, see Products and SKUs.
userId <string> The user's current primary email address. If the user's email address changes, use the new email address in your API requests. Since a `userId` is subject to change, do not use a `userId` value as a key for persistent data. This key could break if the current user's email address changes. If the `userId` is suspended, the license status changes."
  [productId skuId userId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://licensing.googleapis.com/apps/licensing/v1/product/{productId}/sku/{skuId}/user/{userId}",
     :uri-template-args
     {:productId productId, :skuId skuId, :userId userId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/apps.licensing"]}))

(defn licenseAssignments-get
  "Get a specific user's license by product SKU.
https://developers.google.com/admin-sdk/licensing/v1/how-tos/concepts

productId <string> A product's unique identifier. For more information about products in this version of the API, see Products and SKUs.
skuId <string> A product SKU's unique identifier. For more information about available SKUs in this version of the API, see Products and SKUs.
userId <string> The user's current primary email address. If the user's email address changes, use the new email address in your API requests. Since a `userId` is subject to change, do not use a `userId` value as a key for persistent data. This key could break if the current user's email address changes. If the `userId` is suspended, the license status changes."
  [productId skuId userId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://licensing.googleapis.com/apps/licensing/v1/product/{productId}/sku/{skuId}/user/{userId}",
     :uri-template-args
     {:productId productId, :skuId skuId, :userId userId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/apps.licensing"]}))

(defn licenseAssignments-insert
  "Assign a license.
https://developers.google.com/admin-sdk/licensing/v1/how-tos/concepts

productId <string> A product's unique identifier. For more information about products in this version of the API, see Products and SKUs.
skuId <string> A product SKU's unique identifier. For more information about available SKUs in this version of the API, see Products and SKUs.
LicenseAssignmentInsert:
{:userId string}"
  [productId skuId LicenseAssignmentInsert]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://licensing.googleapis.com/apps/licensing/v1/product/{productId}/sku/{skuId}/user",
     :uri-template-args {:productId productId, :skuId skuId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/apps.licensing"],
     :body LicenseAssignmentInsert}))

(defn licenseAssignments-listForProduct
  "List all users assigned licenses for a specific product SKU.
https://developers.google.com/admin-sdk/licensing/v1/how-tos/concepts

productId <string> A product's unique identifier. For more information about products in this version of the API, see Products and SKUs.
customerId <string> The customer's unique ID as defined in the Admin console, such as `C00000000`. If the customer is suspended, the server returns an error.

optional:
maxResults <integer> The `maxResults` query string determines how many entries are returned on each page of a large response. This is an optional parameter. The value must be a positive number."
  ([productId customerId]
    (licenseAssignments-listForProduct productId customerId nil))
  ([productId customerId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://licensing.googleapis.com/apps/licensing/v1/product/{productId}/users",
       :uri-template-args {:productId productId},
       :query-params (merge {:customerId customerId} optional),
       :scopes ["https://www.googleapis.com/auth/apps.licensing"]})))

(defn licenseAssignments-listForProductAndSku
  "List all users assigned licenses for a specific product SKU.
https://developers.google.com/admin-sdk/licensing/v1/how-tos/concepts

productId <string> A product's unique identifier. For more information about products in this version of the API, see Products and SKUs.
skuId <string> A product SKU's unique identifier. For more information about available SKUs in this version of the API, see Products and SKUs.
customerId <string> The customer's unique ID as defined in the Admin console, such as `C00000000`. If the customer is suspended, the server returns an error.

optional:
maxResults <integer> The `maxResults` query string determines how many entries are returned on each page of a large response. This is an optional parameter. The value must be a positive number."
  ([productId skuId customerId]
    (licenseAssignments-listForProductAndSku
      productId
      skuId
      customerId
      nil))
  ([productId skuId customerId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://licensing.googleapis.com/apps/licensing/v1/product/{productId}/sku/{skuId}/users",
       :uri-template-args {:productId productId, :skuId skuId},
       :query-params (merge {:customerId customerId} optional),
       :scopes ["https://www.googleapis.com/auth/apps.licensing"]})))

(defn licenseAssignments-update
  "Reassign a user's product SKU with a different SKU in the same product.
https://developers.google.com/admin-sdk/licensing/v1/how-tos/concepts

productId <string> A product's unique identifier. For more information about products in this version of the API, see Products and SKUs.
skuId <string> A product SKU's unique identifier. For more information about available SKUs in this version of the API, see Products and SKUs.
userId <string> The user's current primary email address. If the user's email address changes, use the new email address in your API requests. Since a `userId` is subject to change, do not use a `userId` value as a key for persistent data. This key could break if the current user's email address changes. If the `userId` is suspended, the license status changes.
LicenseAssignment:
{:kind string,
 :etags string,
 :productId string,
 :userId string,
 :selfLink string,
 :skuId string,
 :skuName string,
 :productName string}"
  [productId skuId userId LicenseAssignment]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://licensing.googleapis.com/apps/licensing/v1/product/{productId}/sku/{skuId}/user/{userId}",
     :uri-template-args
     {:productId productId, :skuId skuId, :userId userId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/apps.licensing"],
     :body LicenseAssignment}))

(defn licenseAssignments-patch
  "Reassign a user's product SKU with a different SKU in the same product. This method supports patch semantics.
https://developers.google.com/admin-sdk/licensing/v1/how-tos/concepts

productId <string> A product's unique identifier. For more information about products in this version of the API, see Products and SKUs.
skuId <string> A product SKU's unique identifier. For more information about available SKUs in this version of the API, see Products and SKUs.
userId <string> The user's current primary email address. If the user's email address changes, use the new email address in your API requests. Since a `userId` is subject to change, do not use a `userId` value as a key for persistent data. This key could break if the current user's email address changes. If the `userId` is suspended, the license status changes.
LicenseAssignment:
{:kind string,
 :etags string,
 :productId string,
 :userId string,
 :selfLink string,
 :skuId string,
 :skuName string,
 :productName string}"
  [productId skuId userId LicenseAssignment]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://licensing.googleapis.com/apps/licensing/v1/product/{productId}/sku/{skuId}/user/{userId}",
     :uri-template-args
     {:productId productId, :skuId skuId, :userId userId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/apps.licensing"],
     :body LicenseAssignment}))

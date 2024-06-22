(ns happygapi2.manufacturers
  "Manufacturer Center API
Public API for managing Manufacturer Center related data.
See: https://developers.google.com/manufacturers/quickstart"
  (:require [happy.oauth2.client :as client]))

(defn accounts-products-list
  "Lists all the products in a Manufacturer Center account.
https://developers.google.com/manufacturers/reference/rest/v1/accounts.products/list

parent <string> Parent ID in the format `accounts/{account_id}`. `account_id` - The ID of the Manufacturer Center account.

optional:
pageSize <integer> Maximum number of product statuses to return in the response, used for paging.
include <string> The information to be included in the response. Only sections listed here will be returned."
  ([parent] (accounts-products-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://manufacturers.googleapis.com/v1/{+parent}/products",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/manufacturercenter"]})))

(defn accounts-products-get
  "Gets the product from a Manufacturer Center account, including product issues. A recently updated product takes around 15 minutes to process. Changes are only visible after it has been processed. While some issues may be available once the product has been processed, other issues may take days to appear.
https://developers.google.com/manufacturers/reference/rest/v1/accounts.products/get

parent <string> Parent ID in the format `accounts/{account_id}`. `account_id` - The ID of the Manufacturer Center account.
name <string> Name in the format `{target_country}:{content_language}:{product_id}`. `target_country` - The target country of the product as a CLDR territory code (for example, US). `content_language` - The content language of the product as a two-letter ISO 639-1 language code (for example, en). `product_id` - The ID of the product. For more information, see https://support.google.com/manufacturers/answer/6124116#id.

optional:
include <string> The information to be included in the response. Only sections listed here will be returned."
  ([parent name] (accounts-products-get parent name nil))
  ([parent name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://manufacturers.googleapis.com/v1/{+parent}/products/{+name}",
       :uri-template-args {:parent parent, :name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/manufacturercenter"]})))

(defn accounts-products-update
  "Inserts or updates the attributes of the product in a Manufacturer Center account. Creates a product with the provided attributes. If the product already exists, then all attributes are replaced with the new ones. The checks at upload time are minimal. All required attributes need to be present for a product to be valid. Issues may show up later after the API has accepted a new upload for a product and it is possible to overwrite an existing valid product with an invalid product. To detect this, you should retrieve the product and check it for issues once the new version is available. Uploaded attributes first need to be processed before they can be retrieved. Until then, new products will be unavailable, and retrieval of previously uploaded products will return the original state of the product.
https://developers.google.com/manufacturers/reference/rest/v1/accounts.products/update

parent <string> Parent ID in the format `accounts/{account_id}`. `account_id` - The ID of the Manufacturer Center account.
name <string> Name in the format `{target_country}:{content_language}:{product_id}`. `target_country` - The target country of the product as a CLDR territory code (for example, US). `content_language` - The content language of the product as a two-letter ISO 639-1 language code (for example, en). `product_id` - The ID of the product. For more information, see https://support.google.com/manufacturers/answer/6124116#id.
Attributes:
{:description string,
 :mpn string,
 :format string,
 :ageGroup string,
 :sizeSystem string,
 :suggestedRetailPrice {:amount string, :currency string},
 :flavor string,
 :color string,
 :productLine string,
 :capacity {:value string, :unit string},
 :includedDestination [string],
 :additionalImageLink
 [{:type [TYPE_UNSPECIFIED CRAWLED UPLOADED],
   :status
   [STATUS_UNSPECIFIED
    PENDING_PROCESSING
    PENDING_CRAWL
    OK
    ROBOTED
    XROBOTED
    CRAWL_ERROR
    PROCESSING_ERROR
    DECODING_ERROR
    TOO_BIG
    CRAWL_SKIPPED
    HOSTLOADED
    HTTP_404],
   :imageUrl string}],
 :productPageUrl string,
 :releaseDate string,
 :productDetail
 [{:sectionName string,
   :attributeName string,
   :attributeValue string}],
 :productName string,
 :sizeType [string],
 :size string,
 :brand string,
 :title string,
 :theme string,
 :excludedDestination [string],
 :scent string,
 :itemGroupId string,
 :certification [{:name string, :authority string, :code string}],
 :productType [string],
 :disclosureDate string,
 :featureDescription
 [{:headline string,
   :text string,
   :image
   {:type [TYPE_UNSPECIFIED CRAWLED UPLOADED],
    :status
    [STATUS_UNSPECIFIED
     PENDING_PROCESSING
     PENDING_CRAWL
     OK
     ROBOTED
     XROBOTED
     CRAWL_ERROR
     PROCESSING_ERROR
     DECODING_ERROR
     TOO_BIG
     CRAWL_SKIPPED
     HOSTLOADED
     HTTP_404],
    :imageUrl string}}],
 :count {:value string, :unit string},
 :material string,
 :virtualModelLink string,
 :videoLink [string],
 :grocery
 {:allergens string,
  :directions string,
  :nutritionClaim [string],
  :activeIngredients string,
  :storageInstructions string,
  :indications string,
  :ingredients string,
  :derivedNutritionClaim [string],
  :alcoholByVolume number},
 :gtin [string],
 :gender string,
 :targetClientId string,
 :productHighlight [string],
 :nutrition
 {:folateDailyPercentage number,
  :saturatedFatDailyPercentage number,
  :calciumDailyPercentage number,
  :totalFat {:amount number, :unit string},
  :nutritionFactMeasure string,
  :totalSugarsDailyPercentage number,
  :vitaminDDailyPercentage number,
  :monounsaturatedFat {:amount number, :unit string},
  :servingsPerContainer string,
  :servingSizeMeasure {:amount number, :unit string},
  :energyFromFat {:amount number, :unit string},
  :potassiumDailyPercentage number,
  :folateMcgDfe number,
  :addedSugarsDailyPercentage number,
  :transFatDailyPercentage number,
  :voluntaryNutritionFact
  [{:name string,
    :value {:amount number, :unit string},
    :dailyPercentage number}],
  :energy {:amount number, :unit string},
  :preparedSizeDescription string,
  :calcium {:amount number, :unit string},
  :dietaryFiberDailyPercentage number,
  :iron {:amount number, :unit string},
  :saturatedFat {:amount number, :unit string},
  :potassium {:amount number, :unit string},
  :proteinDailyPercentage number,
  :cholesterolDailyPercentage number,
  :polyols {:amount number, :unit string},
  :cholesterol {:amount number, :unit string},
  :folateFolicAcid {:amount number, :unit string},
  :ironDailyPercentage number,
  :dietaryFiber {:amount number, :unit string},
  :transFat {:amount number, :unit string},
  :totalFatDailyPercentage number,
  :totalCarbohydrateDailyPercentage number,
  :sodium {:amount number, :unit string},
  :protein {:amount number, :unit string},
  :totalSugars {:amount number, :unit string},
  :vitaminD {:amount number, :unit string},
  :totalCarbohydrate {:amount number, :unit string},
  :sodiumDailyPercentage number,
  :addedSugars {:amount number, :unit string},
  :starch {:amount number, :unit string},
  :servingSizeDescription string,
  :polyunsaturatedFat {:amount number, :unit string}},
 :imageLink
 {:type [TYPE_UNSPECIFIED CRAWLED UPLOADED],
  :status
  [STATUS_UNSPECIFIED
   PENDING_PROCESSING
   PENDING_CRAWL
   OK
   ROBOTED
   XROBOTED
   CRAWL_ERROR
   PROCESSING_ERROR
   DECODING_ERROR
   TOO_BIG
   CRAWL_SKIPPED
   HOSTLOADED
   HTTP_404],
  :imageUrl string},
 :pattern string,
 :richProductContent [string]}"
  [parent name Attributes]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://manufacturers.googleapis.com/v1/{+parent}/products/{+name}",
     :uri-template-args {:parent parent, :name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/manufacturercenter"],
     :body Attributes}))

(defn accounts-products-delete
  "Deletes the product from a Manufacturer Center account.
https://developers.google.com/manufacturers/reference/rest/v1/accounts.products/delete

parent <string> Parent ID in the format `accounts/{account_id}`. `account_id` - The ID of the Manufacturer Center account.
name <string> Name in the format `{target_country}:{content_language}:{product_id}`. `target_country` - The target country of the product as a CLDR territory code (for example, US). `content_language` - The content language of the product as a two-letter ISO 639-1 language code (for example, en). `product_id` - The ID of the product. For more information, see https://support.google.com/manufacturers/answer/6124116#id."
  [parent name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://manufacturers.googleapis.com/v1/{+parent}/products/{+name}",
     :uri-template-args {:parent parent, :name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/manufacturercenter"]}))

(defn accounts-languages-productCertifications-patch
  "Updates (or creates if allow_missing = true) a product certification which links certifications with products. This method can only be called by certification bodies.
https://developers.google.com/manufacturers/reference/rest/v1/accounts.languages.productCertifications/patch

name <string> Required. The unique name identifier of a product certification Format: accounts/{account}/languages/{language_code}/productCertifications/{id} Where `id` is a some unique identifier and `language_code` is a 2-letter ISO 639-1 code of a Shopping supported language according to https://support.google.com/merchants/answer/160637.
ProductCertification:
{:mpn [string],
 :issues
 [{:type string,
   :severity [SEVERITY_UNSPECIFIED ERROR WARNING INFO],
   :attribute string,
   :title string,
   :description string,
   :resolution [RESOLUTION_UNSPECIFIED USER_ACTION PENDING_PROCESSING],
   :destination string,
   :timestamp string}],
 :destinationStatuses
 [{:destination string, :status [UNKNOWN ACTIVE PENDING DISAPPROVED]}],
 :name string,
 :brand string,
 :title string,
 :certification
 [{:name string,
   :authority string,
   :code string,
   :value string,
   :link string,
   :logo string,
   :validUntil string}],
 :productType [string],
 :productCode [string],
 :countryCode [string]}

optional:
updateMask <string> Optional. The list of fields to update according to aip.dev/134. However, only full update is supported as of right now. Therefore, it can be either ignored or set to \"*\". Setting any other values will returns UNIMPLEMENTED error."
  ([name ProductCertification]
    (accounts-languages-productCertifications-patch
      name
      ProductCertification
      nil))
  ([name ProductCertification optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://manufacturers.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/manufacturercenter"],
       :body ProductCertification})))

(defn accounts-languages-productCertifications-list
  "Lists product certifications from a specified certification body. This method can only be called by certification bodies.
https://developers.google.com/manufacturers/reference/rest/v1/accounts.languages.productCertifications/list

parent <string> Required. The parent, which owns this collection of product certifications. Format: accounts/{account}/languages/{language_code}

optional:
pageSize <integer> Optional. The maximum number of product certifications to return. The service may return fewer than this value. If unspecified, at most 50 product certifications will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent] (accounts-languages-productCertifications-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://manufacturers.googleapis.com/v1/{+parent}/productCertifications",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/manufacturercenter"]})))

(defn accounts-languages-productCertifications-get
  "Gets a product certification by its name. This method can only be called by certification bodies.
https://developers.google.com/manufacturers/reference/rest/v1/accounts.languages.productCertifications/get

name <string> Required. The name of the product certification to get. Format: accounts/{account}/languages/{language_code}/productCertifications/{id}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://manufacturers.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/manufacturercenter"]}))

(defn accounts-languages-productCertifications-delete
  "Deletes a product certification by its name. This method can only be called by certification bodies.
https://developers.google.com/manufacturers/reference/rest/v1/accounts.languages.productCertifications/delete

name <string> Required. The name of the product certification to delete. Format: accounts/{account}/languages/{language_code}/productCertifications/{id}"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://manufacturers.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/manufacturercenter"]}))

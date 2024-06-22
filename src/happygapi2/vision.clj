(ns happygapi2.vision
  "Cloud Vision API
Integrates Google Vision features, including image labeling, face, logo, and landmark detection, optical character recognition (OCR), and detection of explicit content, into applications.
See: https://cloud.google.com/vision/"
  (:require [happy.oauth2.client :as client]))

(defn operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vision/reference/rest/v1/operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://vision.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-vision"]})))

(defn operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vision/reference/rest/v1/operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://vision.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-vision"]}))

(defn operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vision/reference/rest/v1/operations/delete

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://vision.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-vision"]}))

(defn operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vision/reference/rest/v1/operations/cancel

name <string> The name of the operation resource to be cancelled.
CancelOperationRequest:
object"
  [name CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://vision.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-vision"],
     :body CancelOperationRequest}))

(defn projects-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vision/reference/rest/v1/projects/operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://vision.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-vision"]}))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vision/reference/rest/v1/projects/locations/operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://vision.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-vision"]}))

(defn projects-locations-productSets-create
  "Creates and returns a new ProductSet resource. Possible errors: * Returns INVALID_ARGUMENT if display_name is missing, or is longer than 4096 characters.
https://cloud.google.com/vision/reference/rest/v1/projects/locations/productSets/create

parent <string> Required. The project in which the ProductSet should be created. Format is `projects/PROJECT_ID/locations/LOC_ID`.
ProductSet:
{:name string,
 :displayName string,
 :indexTime string,
 :indexError {:code integer, :message string, :details [object]}}

optional:
productSetId <string> A user-supplied resource id for this ProductSet. If set, the server will attempt to use this value as the resource id. If it is already in use, an error is returned with code ALREADY_EXISTS. Must be at most 128 characters long. It cannot contain the character `/`."
  ([parent ProductSet]
    (projects-locations-productSets-create parent ProductSet nil))
  ([parent ProductSet optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://vision.googleapis.com/v1/{+parent}/productSets",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-vision"],
       :body ProductSet})))

(defn projects-locations-productSets-list
  "Lists ProductSets in an unspecified order. Possible errors: * Returns INVALID_ARGUMENT if page_size is greater than 100, or less than 1.
https://cloud.google.com/vision/reference/rest/v1/projects/locations/productSets/list

parent <string> Required. The project from which ProductSets should be listed. Format is `projects/PROJECT_ID/locations/LOC_ID`.

optional:
pageSize <integer> The maximum number of items to return. Default 10, maximum 100."
  ([parent] (projects-locations-productSets-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://vision.googleapis.com/v1/{+parent}/productSets",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-vision"]})))

(defn projects-locations-productSets-get
  "Gets information associated with a ProductSet. Possible errors: * Returns NOT_FOUND if the ProductSet does not exist.
https://cloud.google.com/vision/reference/rest/v1/projects/locations/productSets/get

name <string> Required. Resource name of the ProductSet to get. Format is: `projects/PROJECT_ID/locations/LOC_ID/productSets/PRODUCT_SET_ID`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://vision.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-vision"]}))

(defn projects-locations-productSets-patch
  "Makes changes to a ProductSet resource. Only display_name can be updated currently. Possible errors: * Returns NOT_FOUND if the ProductSet does not exist. * Returns INVALID_ARGUMENT if display_name is present in update_mask but missing from the request or longer than 4096 characters.
https://cloud.google.com/vision/reference/rest/v1/projects/locations/productSets/patch

name <string> The resource name of the ProductSet. Format is: `projects/PROJECT_ID/locations/LOC_ID/productSets/PRODUCT_SET_ID`. This field is ignored when creating a ProductSet.
ProductSet:
{:name string,
 :displayName string,
 :indexTime string,
 :indexError {:code integer, :message string, :details [object]}}

optional:
updateMask <string> The FieldMask that specifies which fields to update. If update_mask isn't specified, all mutable fields are to be updated. Valid mask path is `display_name`."
  ([name ProductSet]
    (projects-locations-productSets-patch name ProductSet nil))
  ([name ProductSet optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://vision.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-vision"],
       :body ProductSet})))

(defn projects-locations-productSets-delete
  "Permanently deletes a ProductSet. Products and ReferenceImages in the ProductSet are not deleted. The actual image files are not deleted from Google Cloud Storage.
https://cloud.google.com/vision/reference/rest/v1/projects/locations/productSets/delete

name <string> Required. Resource name of the ProductSet to delete. Format is: `projects/PROJECT_ID/locations/LOC_ID/productSets/PRODUCT_SET_ID`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://vision.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-vision"]}))

(defn projects-locations-productSets-addProduct
  "Adds a Product to the specified ProductSet. If the Product is already present, no change is made. One Product can be added to at most 100 ProductSets. Possible errors: * Returns NOT_FOUND if the Product or the ProductSet doesn't exist.
https://cloud.google.com/vision/reference/rest/v1/projects/locations/productSets/addProduct

name <string> Required. The resource name for the ProductSet to modify. Format is: `projects/PROJECT_ID/locations/LOC_ID/productSets/PRODUCT_SET_ID`
AddProductToProductSetRequest:
{:product string}"
  [name AddProductToProductSetRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://vision.googleapis.com/v1/{+name}:addProduct",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-vision"],
     :body AddProductToProductSetRequest}))

(defn projects-locations-productSets-removeProduct
  "Removes a Product from the specified ProductSet.
https://cloud.google.com/vision/reference/rest/v1/projects/locations/productSets/removeProduct

name <string> Required. The resource name for the ProductSet to modify. Format is: `projects/PROJECT_ID/locations/LOC_ID/productSets/PRODUCT_SET_ID`
RemoveProductFromProductSetRequest:
{:product string}"
  [name RemoveProductFromProductSetRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://vision.googleapis.com/v1/{+name}:removeProduct",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-vision"],
     :body RemoveProductFromProductSetRequest}))

(defn projects-locations-productSets-import
  "Asynchronous API that imports a list of reference images to specified product sets based on a list of image information. The google.longrunning.Operation API can be used to keep track of the progress and results of the request. `Operation.metadata` contains `BatchOperationMetadata`. (progress) `Operation.response` contains `ImportProductSetsResponse`. (results) The input source of this method is a csv file on Google Cloud Storage. For the format of the csv file please see ImportProductSetsGcsSource.csv_file_uri.
https://cloud.google.com/vision/reference/rest/v1/projects/locations/productSets/import

parent <string> Required. The project in which the ProductSets should be imported. Format is `projects/PROJECT_ID/locations/LOC_ID`.
ImportProductSetsRequest:
{:inputConfig {:gcsSource {:csvFileUri string}}}"
  [parent ImportProductSetsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://vision.googleapis.com/v1/{+parent}/productSets:import",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-vision"],
     :body ImportProductSetsRequest}))

(defn projects-locations-productSets-products-list
  "Lists the Products in a ProductSet, in an unspecified order. If the ProductSet does not exist, the products field of the response will be empty. Possible errors: * Returns INVALID_ARGUMENT if page_size is greater than 100 or less than 1.
https://cloud.google.com/vision/reference/rest/v1/projects/locations/productSets/products/list

name <string> Required. The ProductSet resource for which to retrieve Products. Format is: `projects/PROJECT_ID/locations/LOC_ID/productSets/PRODUCT_SET_ID`

optional:
pageSize <integer> The maximum number of items to return. Default 10, maximum 100."
  ([name] (projects-locations-productSets-products-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://vision.googleapis.com/v1/{+name}/products",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-vision"]})))

(defn projects-locations-products-create
  "Creates and returns a new product resource. Possible errors: * Returns INVALID_ARGUMENT if display_name is missing or longer than 4096 characters. * Returns INVALID_ARGUMENT if description is longer than 4096 characters. * Returns INVALID_ARGUMENT if product_category is missing or invalid.
https://cloud.google.com/vision/reference/rest/v1/projects/locations/products/create

parent <string> Required. The project in which the Product should be created. Format is `projects/PROJECT_ID/locations/LOC_ID`.
Product:
{:name string,
 :displayName string,
 :description string,
 :productCategory string,
 :productLabels [{:key string, :value string}]}

optional:
productId <string> A user-supplied resource id for this Product. If set, the server will attempt to use this value as the resource id. If it is already in use, an error is returned with code ALREADY_EXISTS. Must be at most 128 characters long. It cannot contain the character `/`."
  ([parent Product]
    (projects-locations-products-create parent Product nil))
  ([parent Product optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://vision.googleapis.com/v1/{+parent}/products",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-vision"],
       :body Product})))

(defn projects-locations-products-list
  "Lists products in an unspecified order. Possible errors: * Returns INVALID_ARGUMENT if page_size is greater than 100 or less than 1.
https://cloud.google.com/vision/reference/rest/v1/projects/locations/products/list

parent <string> Required. The project OR ProductSet from which Products should be listed. Format: `projects/PROJECT_ID/locations/LOC_ID`

optional:
pageSize <integer> The maximum number of items to return. Default 10, maximum 100."
  ([parent] (projects-locations-products-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://vision.googleapis.com/v1/{+parent}/products",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-vision"]})))

(defn projects-locations-products-get
  "Gets information associated with a Product. Possible errors: * Returns NOT_FOUND if the Product does not exist.
https://cloud.google.com/vision/reference/rest/v1/projects/locations/products/get

name <string> Required. Resource name of the Product to get. Format is: `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://vision.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-vision"]}))

(defn projects-locations-products-patch
  "Makes changes to a Product resource. Only the `display_name`, `description`, and `labels` fields can be updated right now. If labels are updated, the change will not be reflected in queries until the next index time. Possible errors: * Returns NOT_FOUND if the Product does not exist. * Returns INVALID_ARGUMENT if display_name is present in update_mask but is missing from the request or longer than 4096 characters. * Returns INVALID_ARGUMENT if description is present in update_mask but is longer than 4096 characters. * Returns INVALID_ARGUMENT if product_category is present in update_mask.
https://cloud.google.com/vision/reference/rest/v1/projects/locations/products/patch

name <string> The resource name of the product. Format is: `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID`. This field is ignored when creating a product.
Product:
{:name string,
 :displayName string,
 :description string,
 :productCategory string,
 :productLabels [{:key string, :value string}]}

optional:
updateMask <string> The FieldMask that specifies which fields to update. If update_mask isn't specified, all mutable fields are to be updated. Valid mask paths include `product_labels`, `display_name`, and `description`."
  ([name Product] (projects-locations-products-patch name Product nil))
  ([name Product optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://vision.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-vision"],
       :body Product})))

(defn projects-locations-products-delete
  "Permanently deletes a product and its reference images. Metadata of the product and all its images will be deleted right away, but search queries against ProductSets containing the product may still work until all related caches are refreshed.
https://cloud.google.com/vision/reference/rest/v1/projects/locations/products/delete

name <string> Required. Resource name of product to delete. Format is: `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://vision.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-vision"]}))

(defn projects-locations-products-purge
  "Asynchronous API to delete all Products in a ProductSet or all Products that are in no ProductSet. If a Product is a member of the specified ProductSet in addition to other ProductSets, the Product will still be deleted. It is recommended to not delete the specified ProductSet until after this operation has completed. It is also recommended to not add any of the Products involved in the batch delete to a new ProductSet while this operation is running because those Products may still end up deleted. It's not possible to undo the PurgeProducts operation. Therefore, it is recommended to keep the csv files used in ImportProductSets (if that was how you originally built the Product Set) before starting PurgeProducts, in case you need to re-import the data after deletion. If the plan is to purge all of the Products from a ProductSet and then re-use the empty ProductSet to re-import new Products into the empty ProductSet, you must wait until the PurgeProducts operation has finished for that ProductSet. The google.longrunning.Operation API can be used to keep track of the progress and results of the request. `Operation.metadata` contains `BatchOperationMetadata`. (progress)
https://cloud.google.com/vision/reference/rest/v1/projects/locations/products/purge

parent <string> Required. The project and location in which the Products should be deleted. Format is `projects/PROJECT_ID/locations/LOC_ID`.
PurgeProductsRequest:
{:productSetPurgeConfig {:productSetId string},
 :deleteOrphanProducts boolean,
 :force boolean}"
  [parent PurgeProductsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://vision.googleapis.com/v1/{+parent}/products:purge",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-vision"],
     :body PurgeProductsRequest}))

(defn projects-locations-products-referenceImages-create
  "Creates and returns a new ReferenceImage resource. The `bounding_poly` field is optional. If `bounding_poly` is not specified, the system will try to detect regions of interest in the image that are compatible with the product_category on the parent product. If it is specified, detection is ALWAYS skipped. The system converts polygons into non-rotated rectangles. Note that the pipeline will resize the image if the image resolution is too large to process (above 50MP). Possible errors: * Returns INVALID_ARGUMENT if the image_uri is missing or longer than 4096 characters. * Returns INVALID_ARGUMENT if the product does not exist. * Returns INVALID_ARGUMENT if bounding_poly is not provided, and nothing compatible with the parent product's product_category is detected. * Returns INVALID_ARGUMENT if bounding_poly contains more than 10 polygons.
https://cloud.google.com/vision/reference/rest/v1/projects/locations/products/referenceImages/create

parent <string> Required. Resource name of the product in which to create the reference image. Format is `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID`.
ReferenceImage:
{:name string,
 :uri string,
 :boundingPolys
 [{:vertices [{:x integer, :y integer}],
   :normalizedVertices [{:x number, :y number}]}]}

optional:
referenceImageId <string> A user-supplied resource id for the ReferenceImage to be added. If set, the server will attempt to use this value as the resource id. If it is already in use, an error is returned with code ALREADY_EXISTS. Must be at most 128 characters long. It cannot contain the character `/`."
  ([parent ReferenceImage]
    (projects-locations-products-referenceImages-create
      parent
      ReferenceImage
      nil))
  ([parent ReferenceImage optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://vision.googleapis.com/v1/{+parent}/referenceImages",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-vision"],
       :body ReferenceImage})))

(defn projects-locations-products-referenceImages-delete
  "Permanently deletes a reference image. The image metadata will be deleted right away, but search queries against ProductSets containing the image may still work until all related caches are refreshed. The actual image files are not deleted from Google Cloud Storage.
https://cloud.google.com/vision/reference/rest/v1/projects/locations/products/referenceImages/delete

name <string> Required. The resource name of the reference image to delete. Format is: `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID/referenceImages/IMAGE_ID`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://vision.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-vision"]}))

(defn projects-locations-products-referenceImages-list
  "Lists reference images. Possible errors: * Returns NOT_FOUND if the parent product does not exist. * Returns INVALID_ARGUMENT if the page_size is greater than 100, or less than 1.
https://cloud.google.com/vision/reference/rest/v1/projects/locations/products/referenceImages/list

parent <string> Required. Resource name of the product containing the reference images. Format is `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID`.

optional:
pageSize <integer> The maximum number of items to return. Default 10, maximum 100."
  ([parent]
    (projects-locations-products-referenceImages-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://vision.googleapis.com/v1/{+parent}/referenceImages",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-vision"]})))

(defn projects-locations-products-referenceImages-get
  "Gets information associated with a ReferenceImage. Possible errors: * Returns NOT_FOUND if the specified image does not exist.
https://cloud.google.com/vision/reference/rest/v1/projects/locations/products/referenceImages/get

name <string> Required. The resource name of the ReferenceImage to get. Format is: `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID/referenceImages/IMAGE_ID`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://vision.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-vision"]}))

(defn projects-locations-images-annotate
  "Run image detection and annotation for a batch of images.
https://cloud.google.com/vision/reference/rest/v1/projects/locations/images/annotate

parent <string> Optional. Target project and location to make a call. Format: `projects/{project-id}/locations/{location-id}`. If no parent is specified, a region will be chosen automatically. Supported location-ids: `us`: USA country only, `asia`: East asia areas, like Japan, Taiwan, `eu`: The European Union. Example: `projects/project-A/locations/eu`.
BatchAnnotateImagesRequest:
{:requests
 [{:image
   {:content string, :source {:gcsImageUri string, :imageUri string}},
   :features
   [{:type
     [TYPE_UNSPECIFIED
      FACE_DETECTION
      LANDMARK_DETECTION
      LOGO_DETECTION
      LABEL_DETECTION
      TEXT_DETECTION
      DOCUMENT_TEXT_DETECTION
      SAFE_SEARCH_DETECTION
      IMAGE_PROPERTIES
      CROP_HINTS
      WEB_DETECTION
      PRODUCT_SEARCH
      OBJECT_LOCALIZATION],
     :maxResults integer,
     :model string}],
   :imageContext
   {:latLongRect
    {:minLatLng {:latitude number, :longitude number},
     :maxLatLng {:latitude number, :longitude number}},
    :languageHints [string],
    :cropHintsParams {:aspectRatios [number]},
    :productSearchParams
    {:boundingPoly
     {:vertices [Vertex], :normalizedVertices [NormalizedVertex]},
     :productSet string,
     :productCategories [string],
     :filter string},
    :webDetectionParams {:includeGeoResults boolean},
    :textDetectionParams
    {:enableTextDetectionConfidenceScore boolean,
     :advancedOcrOptions [string]}}}],
 :parent string,
 :labels object}"
  [parent BatchAnnotateImagesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://vision.googleapis.com/v1/{+parent}/images:annotate",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-vision"],
     :body BatchAnnotateImagesRequest}))

(defn projects-locations-images-asyncBatchAnnotate
  "Run asynchronous image detection and annotation for a list of images. Progress and results can be retrieved through the `google.longrunning.Operations` interface. `Operation.metadata` contains `OperationMetadata` (metadata). `Operation.response` contains `AsyncBatchAnnotateImagesResponse` (results). This service will write image annotation outputs to json files in customer GCS bucket, each json file containing BatchAnnotateImagesResponse proto.
https://cloud.google.com/vision/reference/rest/v1/projects/locations/images/asyncBatchAnnotate

parent <string> Optional. Target project and location to make a call. Format: `projects/{project-id}/locations/{location-id}`. If no parent is specified, a region will be chosen automatically. Supported location-ids: `us`: USA country only, `asia`: East asia areas, like Japan, Taiwan, `eu`: The European Union. Example: `projects/project-A/locations/eu`.
AsyncBatchAnnotateImagesRequest:
{:requests
 [{:image
   {:content string, :source {:gcsImageUri string, :imageUri string}},
   :features
   [{:type
     [TYPE_UNSPECIFIED
      FACE_DETECTION
      LANDMARK_DETECTION
      LOGO_DETECTION
      LABEL_DETECTION
      TEXT_DETECTION
      DOCUMENT_TEXT_DETECTION
      SAFE_SEARCH_DETECTION
      IMAGE_PROPERTIES
      CROP_HINTS
      WEB_DETECTION
      PRODUCT_SEARCH
      OBJECT_LOCALIZATION],
     :maxResults integer,
     :model string}],
   :imageContext
   {:latLongRect
    {:minLatLng {:latitude number, :longitude number},
     :maxLatLng {:latitude number, :longitude number}},
    :languageHints [string],
    :cropHintsParams {:aspectRatios [number]},
    :productSearchParams
    {:boundingPoly
     {:vertices [Vertex], :normalizedVertices [NormalizedVertex]},
     :productSet string,
     :productCategories [string],
     :filter string},
    :webDetectionParams {:includeGeoResults boolean},
    :textDetectionParams
    {:enableTextDetectionConfidenceScore boolean,
     :advancedOcrOptions [string]}}}],
 :outputConfig {:gcsDestination {:uri string}, :batchSize integer},
 :parent string,
 :labels object}"
  [parent AsyncBatchAnnotateImagesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://vision.googleapis.com/v1/{+parent}/images:asyncBatchAnnotate",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-vision"],
     :body AsyncBatchAnnotateImagesRequest}))

(defn projects-locations-files-annotate
  "Service that performs image detection and annotation for a batch of files. Now only \"application/pdf\", \"image/tiff\" and \"image/gif\" are supported. This service will extract at most 5 (customers can specify which 5 in AnnotateFileRequest.pages) frames (gif) or pages (pdf or tiff) from each file provided and perform detection and annotation for each image extracted.
https://cloud.google.com/vision/reference/rest/v1/projects/locations/files/annotate

parent <string> Optional. Target project and location to make a call. Format: `projects/{project-id}/locations/{location-id}`. If no parent is specified, a region will be chosen automatically. Supported location-ids: `us`: USA country only, `asia`: East asia areas, like Japan, Taiwan, `eu`: The European Union. Example: `projects/project-A/locations/eu`.
BatchAnnotateFilesRequest:
{:requests
 [{:inputConfig
   {:gcsSource {:uri string}, :content string, :mimeType string},
   :features
   [{:type
     [TYPE_UNSPECIFIED
      FACE_DETECTION
      LANDMARK_DETECTION
      LOGO_DETECTION
      LABEL_DETECTION
      TEXT_DETECTION
      DOCUMENT_TEXT_DETECTION
      SAFE_SEARCH_DETECTION
      IMAGE_PROPERTIES
      CROP_HINTS
      WEB_DETECTION
      PRODUCT_SEARCH
      OBJECT_LOCALIZATION],
     :maxResults integer,
     :model string}],
   :imageContext
   {:latLongRect
    {:minLatLng {:latitude number, :longitude number},
     :maxLatLng {:latitude number, :longitude number}},
    :languageHints [string],
    :cropHintsParams {:aspectRatios [number]},
    :productSearchParams
    {:boundingPoly
     {:vertices [Vertex], :normalizedVertices [NormalizedVertex]},
     :productSet string,
     :productCategories [string],
     :filter string},
    :webDetectionParams {:includeGeoResults boolean},
    :textDetectionParams
    {:enableTextDetectionConfidenceScore boolean,
     :advancedOcrOptions [string]}},
   :pages [integer]}],
 :parent string,
 :labels object}"
  [parent BatchAnnotateFilesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://vision.googleapis.com/v1/{+parent}/files:annotate",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-vision"],
     :body BatchAnnotateFilesRequest}))

(defn projects-locations-files-asyncBatchAnnotate
  "Run asynchronous image detection and annotation for a list of generic files, such as PDF files, which may contain multiple pages and multiple images per page. Progress and results can be retrieved through the `google.longrunning.Operations` interface. `Operation.metadata` contains `OperationMetadata` (metadata). `Operation.response` contains `AsyncBatchAnnotateFilesResponse` (results).
https://cloud.google.com/vision/reference/rest/v1/projects/locations/files/asyncBatchAnnotate

parent <string> Optional. Target project and location to make a call. Format: `projects/{project-id}/locations/{location-id}`. If no parent is specified, a region will be chosen automatically. Supported location-ids: `us`: USA country only, `asia`: East asia areas, like Japan, Taiwan, `eu`: The European Union. Example: `projects/project-A/locations/eu`.
AsyncBatchAnnotateFilesRequest:
{:requests
 [{:inputConfig
   {:gcsSource {:uri string}, :content string, :mimeType string},
   :features
   [{:type
     [TYPE_UNSPECIFIED
      FACE_DETECTION
      LANDMARK_DETECTION
      LOGO_DETECTION
      LABEL_DETECTION
      TEXT_DETECTION
      DOCUMENT_TEXT_DETECTION
      SAFE_SEARCH_DETECTION
      IMAGE_PROPERTIES
      CROP_HINTS
      WEB_DETECTION
      PRODUCT_SEARCH
      OBJECT_LOCALIZATION],
     :maxResults integer,
     :model string}],
   :imageContext
   {:latLongRect
    {:minLatLng {:latitude number, :longitude number},
     :maxLatLng {:latitude number, :longitude number}},
    :languageHints [string],
    :cropHintsParams {:aspectRatios [number]},
    :productSearchParams
    {:boundingPoly
     {:vertices [Vertex], :normalizedVertices [NormalizedVertex]},
     :productSet string,
     :productCategories [string],
     :filter string},
    :webDetectionParams {:includeGeoResults boolean},
    :textDetectionParams
    {:enableTextDetectionConfidenceScore boolean,
     :advancedOcrOptions [string]}},
   :outputConfig {:gcsDestination {:uri string}, :batchSize integer}}],
 :parent string,
 :labels object}"
  [parent AsyncBatchAnnotateFilesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://vision.googleapis.com/v1/{+parent}/files:asyncBatchAnnotate",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-vision"],
     :body AsyncBatchAnnotateFilesRequest}))

(defn projects-images-annotate
  "Run image detection and annotation for a batch of images.
https://cloud.google.com/vision/reference/rest/v1/projects/images/annotate

parent <string> Optional. Target project and location to make a call. Format: `projects/{project-id}/locations/{location-id}`. If no parent is specified, a region will be chosen automatically. Supported location-ids: `us`: USA country only, `asia`: East asia areas, like Japan, Taiwan, `eu`: The European Union. Example: `projects/project-A/locations/eu`.
BatchAnnotateImagesRequest:
{:requests
 [{:image
   {:content string, :source {:gcsImageUri string, :imageUri string}},
   :features
   [{:type
     [TYPE_UNSPECIFIED
      FACE_DETECTION
      LANDMARK_DETECTION
      LOGO_DETECTION
      LABEL_DETECTION
      TEXT_DETECTION
      DOCUMENT_TEXT_DETECTION
      SAFE_SEARCH_DETECTION
      IMAGE_PROPERTIES
      CROP_HINTS
      WEB_DETECTION
      PRODUCT_SEARCH
      OBJECT_LOCALIZATION],
     :maxResults integer,
     :model string}],
   :imageContext
   {:latLongRect
    {:minLatLng {:latitude number, :longitude number},
     :maxLatLng {:latitude number, :longitude number}},
    :languageHints [string],
    :cropHintsParams {:aspectRatios [number]},
    :productSearchParams
    {:boundingPoly
     {:vertices [Vertex], :normalizedVertices [NormalizedVertex]},
     :productSet string,
     :productCategories [string],
     :filter string},
    :webDetectionParams {:includeGeoResults boolean},
    :textDetectionParams
    {:enableTextDetectionConfidenceScore boolean,
     :advancedOcrOptions [string]}}}],
 :parent string,
 :labels object}"
  [parent BatchAnnotateImagesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://vision.googleapis.com/v1/{+parent}/images:annotate",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-vision"],
     :body BatchAnnotateImagesRequest}))

(defn projects-images-asyncBatchAnnotate
  "Run asynchronous image detection and annotation for a list of images. Progress and results can be retrieved through the `google.longrunning.Operations` interface. `Operation.metadata` contains `OperationMetadata` (metadata). `Operation.response` contains `AsyncBatchAnnotateImagesResponse` (results). This service will write image annotation outputs to json files in customer GCS bucket, each json file containing BatchAnnotateImagesResponse proto.
https://cloud.google.com/vision/reference/rest/v1/projects/images/asyncBatchAnnotate

parent <string> Optional. Target project and location to make a call. Format: `projects/{project-id}/locations/{location-id}`. If no parent is specified, a region will be chosen automatically. Supported location-ids: `us`: USA country only, `asia`: East asia areas, like Japan, Taiwan, `eu`: The European Union. Example: `projects/project-A/locations/eu`.
AsyncBatchAnnotateImagesRequest:
{:requests
 [{:image
   {:content string, :source {:gcsImageUri string, :imageUri string}},
   :features
   [{:type
     [TYPE_UNSPECIFIED
      FACE_DETECTION
      LANDMARK_DETECTION
      LOGO_DETECTION
      LABEL_DETECTION
      TEXT_DETECTION
      DOCUMENT_TEXT_DETECTION
      SAFE_SEARCH_DETECTION
      IMAGE_PROPERTIES
      CROP_HINTS
      WEB_DETECTION
      PRODUCT_SEARCH
      OBJECT_LOCALIZATION],
     :maxResults integer,
     :model string}],
   :imageContext
   {:latLongRect
    {:minLatLng {:latitude number, :longitude number},
     :maxLatLng {:latitude number, :longitude number}},
    :languageHints [string],
    :cropHintsParams {:aspectRatios [number]},
    :productSearchParams
    {:boundingPoly
     {:vertices [Vertex], :normalizedVertices [NormalizedVertex]},
     :productSet string,
     :productCategories [string],
     :filter string},
    :webDetectionParams {:includeGeoResults boolean},
    :textDetectionParams
    {:enableTextDetectionConfidenceScore boolean,
     :advancedOcrOptions [string]}}}],
 :outputConfig {:gcsDestination {:uri string}, :batchSize integer},
 :parent string,
 :labels object}"
  [parent AsyncBatchAnnotateImagesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://vision.googleapis.com/v1/{+parent}/images:asyncBatchAnnotate",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-vision"],
     :body AsyncBatchAnnotateImagesRequest}))

(defn projects-files-annotate
  "Service that performs image detection and annotation for a batch of files. Now only \"application/pdf\", \"image/tiff\" and \"image/gif\" are supported. This service will extract at most 5 (customers can specify which 5 in AnnotateFileRequest.pages) frames (gif) or pages (pdf or tiff) from each file provided and perform detection and annotation for each image extracted.
https://cloud.google.com/vision/reference/rest/v1/projects/files/annotate

parent <string> Optional. Target project and location to make a call. Format: `projects/{project-id}/locations/{location-id}`. If no parent is specified, a region will be chosen automatically. Supported location-ids: `us`: USA country only, `asia`: East asia areas, like Japan, Taiwan, `eu`: The European Union. Example: `projects/project-A/locations/eu`.
BatchAnnotateFilesRequest:
{:requests
 [{:inputConfig
   {:gcsSource {:uri string}, :content string, :mimeType string},
   :features
   [{:type
     [TYPE_UNSPECIFIED
      FACE_DETECTION
      LANDMARK_DETECTION
      LOGO_DETECTION
      LABEL_DETECTION
      TEXT_DETECTION
      DOCUMENT_TEXT_DETECTION
      SAFE_SEARCH_DETECTION
      IMAGE_PROPERTIES
      CROP_HINTS
      WEB_DETECTION
      PRODUCT_SEARCH
      OBJECT_LOCALIZATION],
     :maxResults integer,
     :model string}],
   :imageContext
   {:latLongRect
    {:minLatLng {:latitude number, :longitude number},
     :maxLatLng {:latitude number, :longitude number}},
    :languageHints [string],
    :cropHintsParams {:aspectRatios [number]},
    :productSearchParams
    {:boundingPoly
     {:vertices [Vertex], :normalizedVertices [NormalizedVertex]},
     :productSet string,
     :productCategories [string],
     :filter string},
    :webDetectionParams {:includeGeoResults boolean},
    :textDetectionParams
    {:enableTextDetectionConfidenceScore boolean,
     :advancedOcrOptions [string]}},
   :pages [integer]}],
 :parent string,
 :labels object}"
  [parent BatchAnnotateFilesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://vision.googleapis.com/v1/{+parent}/files:annotate",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-vision"],
     :body BatchAnnotateFilesRequest}))

(defn projects-files-asyncBatchAnnotate
  "Run asynchronous image detection and annotation for a list of generic files, such as PDF files, which may contain multiple pages and multiple images per page. Progress and results can be retrieved through the `google.longrunning.Operations` interface. `Operation.metadata` contains `OperationMetadata` (metadata). `Operation.response` contains `AsyncBatchAnnotateFilesResponse` (results).
https://cloud.google.com/vision/reference/rest/v1/projects/files/asyncBatchAnnotate

parent <string> Optional. Target project and location to make a call. Format: `projects/{project-id}/locations/{location-id}`. If no parent is specified, a region will be chosen automatically. Supported location-ids: `us`: USA country only, `asia`: East asia areas, like Japan, Taiwan, `eu`: The European Union. Example: `projects/project-A/locations/eu`.
AsyncBatchAnnotateFilesRequest:
{:requests
 [{:inputConfig
   {:gcsSource {:uri string}, :content string, :mimeType string},
   :features
   [{:type
     [TYPE_UNSPECIFIED
      FACE_DETECTION
      LANDMARK_DETECTION
      LOGO_DETECTION
      LABEL_DETECTION
      TEXT_DETECTION
      DOCUMENT_TEXT_DETECTION
      SAFE_SEARCH_DETECTION
      IMAGE_PROPERTIES
      CROP_HINTS
      WEB_DETECTION
      PRODUCT_SEARCH
      OBJECT_LOCALIZATION],
     :maxResults integer,
     :model string}],
   :imageContext
   {:latLongRect
    {:minLatLng {:latitude number, :longitude number},
     :maxLatLng {:latitude number, :longitude number}},
    :languageHints [string],
    :cropHintsParams {:aspectRatios [number]},
    :productSearchParams
    {:boundingPoly
     {:vertices [Vertex], :normalizedVertices [NormalizedVertex]},
     :productSet string,
     :productCategories [string],
     :filter string},
    :webDetectionParams {:includeGeoResults boolean},
    :textDetectionParams
    {:enableTextDetectionConfidenceScore boolean,
     :advancedOcrOptions [string]}},
   :outputConfig {:gcsDestination {:uri string}, :batchSize integer}}],
 :parent string,
 :labels object}"
  [parent AsyncBatchAnnotateFilesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://vision.googleapis.com/v1/{+parent}/files:asyncBatchAnnotate",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-vision"],
     :body AsyncBatchAnnotateFilesRequest}))

(defn locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vision/reference/rest/v1/locations/operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://vision.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-vision"]}))

(defn images-annotate
  "Run image detection and annotation for a batch of images.
https://cloud.google.com/vision/reference/rest/v1/images/annotate

BatchAnnotateImagesRequest:
{:requests
 [{:image
   {:content string, :source {:gcsImageUri string, :imageUri string}},
   :features
   [{:type
     [TYPE_UNSPECIFIED
      FACE_DETECTION
      LANDMARK_DETECTION
      LOGO_DETECTION
      LABEL_DETECTION
      TEXT_DETECTION
      DOCUMENT_TEXT_DETECTION
      SAFE_SEARCH_DETECTION
      IMAGE_PROPERTIES
      CROP_HINTS
      WEB_DETECTION
      PRODUCT_SEARCH
      OBJECT_LOCALIZATION],
     :maxResults integer,
     :model string}],
   :imageContext
   {:latLongRect
    {:minLatLng {:latitude number, :longitude number},
     :maxLatLng {:latitude number, :longitude number}},
    :languageHints [string],
    :cropHintsParams {:aspectRatios [number]},
    :productSearchParams
    {:boundingPoly
     {:vertices [Vertex], :normalizedVertices [NormalizedVertex]},
     :productSet string,
     :productCategories [string],
     :filter string},
    :webDetectionParams {:includeGeoResults boolean},
    :textDetectionParams
    {:enableTextDetectionConfidenceScore boolean,
     :advancedOcrOptions [string]}}}],
 :parent string,
 :labels object}"
  [BatchAnnotateImagesRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://vision.googleapis.com/v1/images:annotate",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-vision"],
     :body BatchAnnotateImagesRequest}))

(defn images-asyncBatchAnnotate
  "Run asynchronous image detection and annotation for a list of images. Progress and results can be retrieved through the `google.longrunning.Operations` interface. `Operation.metadata` contains `OperationMetadata` (metadata). `Operation.response` contains `AsyncBatchAnnotateImagesResponse` (results). This service will write image annotation outputs to json files in customer GCS bucket, each json file containing BatchAnnotateImagesResponse proto.
https://cloud.google.com/vision/reference/rest/v1/images/asyncBatchAnnotate

AsyncBatchAnnotateImagesRequest:
{:requests
 [{:image
   {:content string, :source {:gcsImageUri string, :imageUri string}},
   :features
   [{:type
     [TYPE_UNSPECIFIED
      FACE_DETECTION
      LANDMARK_DETECTION
      LOGO_DETECTION
      LABEL_DETECTION
      TEXT_DETECTION
      DOCUMENT_TEXT_DETECTION
      SAFE_SEARCH_DETECTION
      IMAGE_PROPERTIES
      CROP_HINTS
      WEB_DETECTION
      PRODUCT_SEARCH
      OBJECT_LOCALIZATION],
     :maxResults integer,
     :model string}],
   :imageContext
   {:latLongRect
    {:minLatLng {:latitude number, :longitude number},
     :maxLatLng {:latitude number, :longitude number}},
    :languageHints [string],
    :cropHintsParams {:aspectRatios [number]},
    :productSearchParams
    {:boundingPoly
     {:vertices [Vertex], :normalizedVertices [NormalizedVertex]},
     :productSet string,
     :productCategories [string],
     :filter string},
    :webDetectionParams {:includeGeoResults boolean},
    :textDetectionParams
    {:enableTextDetectionConfidenceScore boolean,
     :advancedOcrOptions [string]}}}],
 :outputConfig {:gcsDestination {:uri string}, :batchSize integer},
 :parent string,
 :labels object}"
  [AsyncBatchAnnotateImagesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://vision.googleapis.com/v1/images:asyncBatchAnnotate",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-vision"],
     :body AsyncBatchAnnotateImagesRequest}))

(defn files-annotate
  "Service that performs image detection and annotation for a batch of files. Now only \"application/pdf\", \"image/tiff\" and \"image/gif\" are supported. This service will extract at most 5 (customers can specify which 5 in AnnotateFileRequest.pages) frames (gif) or pages (pdf or tiff) from each file provided and perform detection and annotation for each image extracted.
https://cloud.google.com/vision/reference/rest/v1/files/annotate

BatchAnnotateFilesRequest:
{:requests
 [{:inputConfig
   {:gcsSource {:uri string}, :content string, :mimeType string},
   :features
   [{:type
     [TYPE_UNSPECIFIED
      FACE_DETECTION
      LANDMARK_DETECTION
      LOGO_DETECTION
      LABEL_DETECTION
      TEXT_DETECTION
      DOCUMENT_TEXT_DETECTION
      SAFE_SEARCH_DETECTION
      IMAGE_PROPERTIES
      CROP_HINTS
      WEB_DETECTION
      PRODUCT_SEARCH
      OBJECT_LOCALIZATION],
     :maxResults integer,
     :model string}],
   :imageContext
   {:latLongRect
    {:minLatLng {:latitude number, :longitude number},
     :maxLatLng {:latitude number, :longitude number}},
    :languageHints [string],
    :cropHintsParams {:aspectRatios [number]},
    :productSearchParams
    {:boundingPoly
     {:vertices [Vertex], :normalizedVertices [NormalizedVertex]},
     :productSet string,
     :productCategories [string],
     :filter string},
    :webDetectionParams {:includeGeoResults boolean},
    :textDetectionParams
    {:enableTextDetectionConfidenceScore boolean,
     :advancedOcrOptions [string]}},
   :pages [integer]}],
 :parent string,
 :labels object}"
  [BatchAnnotateFilesRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://vision.googleapis.com/v1/files:annotate",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-vision"],
     :body BatchAnnotateFilesRequest}))

(defn files-asyncBatchAnnotate
  "Run asynchronous image detection and annotation for a list of generic files, such as PDF files, which may contain multiple pages and multiple images per page. Progress and results can be retrieved through the `google.longrunning.Operations` interface. `Operation.metadata` contains `OperationMetadata` (metadata). `Operation.response` contains `AsyncBatchAnnotateFilesResponse` (results).
https://cloud.google.com/vision/reference/rest/v1/files/asyncBatchAnnotate

AsyncBatchAnnotateFilesRequest:
{:requests
 [{:inputConfig
   {:gcsSource {:uri string}, :content string, :mimeType string},
   :features
   [{:type
     [TYPE_UNSPECIFIED
      FACE_DETECTION
      LANDMARK_DETECTION
      LOGO_DETECTION
      LABEL_DETECTION
      TEXT_DETECTION
      DOCUMENT_TEXT_DETECTION
      SAFE_SEARCH_DETECTION
      IMAGE_PROPERTIES
      CROP_HINTS
      WEB_DETECTION
      PRODUCT_SEARCH
      OBJECT_LOCALIZATION],
     :maxResults integer,
     :model string}],
   :imageContext
   {:latLongRect
    {:minLatLng {:latitude number, :longitude number},
     :maxLatLng {:latitude number, :longitude number}},
    :languageHints [string],
    :cropHintsParams {:aspectRatios [number]},
    :productSearchParams
    {:boundingPoly
     {:vertices [Vertex], :normalizedVertices [NormalizedVertex]},
     :productSet string,
     :productCategories [string],
     :filter string},
    :webDetectionParams {:includeGeoResults boolean},
    :textDetectionParams
    {:enableTextDetectionConfidenceScore boolean,
     :advancedOcrOptions [string]}},
   :outputConfig {:gcsDestination {:uri string}, :batchSize integer}}],
 :parent string,
 :labels object}"
  [AsyncBatchAnnotateFilesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://vision.googleapis.com/v1/files:asyncBatchAnnotate",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-vision"],
     :body AsyncBatchAnnotateFilesRequest}))

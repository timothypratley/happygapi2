(ns happygapi2.mybusinessplaceactions
  "My Business Place Actions API
The My Business Place Actions API provides an interface for managing place action links of a location on Google. Note - If you have a quota of 0 after enabling the API, please request for GBP API access.
See: https://developers.google.com/my-business/"
  (:require [happy.oauth2.client :as client]))

(defn placeActionTypeMetadata-list
  "Returns the list of available place action types for a location or country.
https://developers.google.com/my-business

optional:
languageCode <string> Optional. The IETF BCP-47 code of language to get display names in. If this language is not available, they will be provided in English.
pageSize <integer> Optional. How many action types to include per page. Default is 10, minimum is 1.
filter <string> Optional. A filter constraining the place action types to return metadata for. The response includes entries that match the filter. We support only the following filters: 1. location=XYZ where XYZ is a string indicating the resource name of a location, in the format `locations/{location_id}`. 2. region_code=XYZ where XYZ is a Unicode CLDR region code to find available action types. If no filter is provided, all place action types are returned."
  ([] (placeActionTypeMetadata-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://mybusinessplaceactions.googleapis.com/v1/placeActionTypeMetadata",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes nil})))

(defn locations-placeActionLinks-list
  "Lists the place action links for the specified location.
https://developers.google.com/my-business

parent <string> Required. The name of the location whose place action links will be listed. `locations/{location_id}`.

optional:
filter <string> Optional. A filter constraining the place action links to return. The response includes entries that match the filter. We support only the following filter: 1. place_action_type=XYZ where XYZ is a valid PlaceActionType.
pageSize <integer> Optional. How many place action links to return per page. Default of 10. The minimum is 1."
  ([parent] (locations-placeActionLinks-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://mybusinessplaceactions.googleapis.com/v1/{+parent}/placeActionLinks",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes nil})))

(defn locations-placeActionLinks-get
  "Gets the specified place action link.
https://developers.google.com/my-business

name <string> Required. The name of the place action link to fetch."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://mybusinessplaceactions.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes nil}))

(defn locations-placeActionLinks-create
  "Creates a place action link associated with the specified location, and returns it. The request is considered duplicate if the `parent`, `place_action_link.uri` and `place_action_link.place_action_type` are the same as a previous request.
https://developers.google.com/my-business

parent <string> Required. The resource name of the location where to create this place action link. `locations/{location_id}`.
PlaceActionLink:
{:name string,
 :providerType [PROVIDER_TYPE_UNSPECIFIED MERCHANT AGGREGATOR_3P],
 :isEditable boolean,
 :uri string,
 :placeActionType
 [PLACE_ACTION_TYPE_UNSPECIFIED
  APPOINTMENT
  ONLINE_APPOINTMENT
  DINING_RESERVATION
  FOOD_ORDERING
  FOOD_DELIVERY
  FOOD_TAKEOUT
  SHOP_ONLINE],
 :isPreferred boolean,
 :createTime string,
 :updateTime string}"
  [parent PlaceActionLink]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://mybusinessplaceactions.googleapis.com/v1/{+parent}/placeActionLinks",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes nil,
     :body PlaceActionLink}))

(defn locations-placeActionLinks-patch
  "Updates the specified place action link and returns it.
https://developers.google.com/my-business

name <string> Optional. The resource name, in the format `locations/{location_id}/placeActionLinks/{place_action_link_id}`. The name field will only be considered in UpdatePlaceActionLink and DeletePlaceActionLink requests for updating and deleting links respectively. However, it will be ignored in CreatePlaceActionLink request, where `place_action_link_id` will be assigned by the server on successful creation of a new link and returned as part of the response.
PlaceActionLink:
{:name string,
 :providerType [PROVIDER_TYPE_UNSPECIFIED MERCHANT AGGREGATOR_3P],
 :isEditable boolean,
 :uri string,
 :placeActionType
 [PLACE_ACTION_TYPE_UNSPECIFIED
  APPOINTMENT
  ONLINE_APPOINTMENT
  DINING_RESERVATION
  FOOD_ORDERING
  FOOD_DELIVERY
  FOOD_TAKEOUT
  SHOP_ONLINE],
 :isPreferred boolean,
 :createTime string,
 :updateTime string}

optional:
updateMask <string> Required. The specific fields to update. The only editable fields are `uri`, `place_action_type` and `is_preferred`. If the updated link already exists at the same location with the same `place_action_type` and `uri`, fails with an `ALREADY_EXISTS` error."
  ([name PlaceActionLink]
    (locations-placeActionLinks-patch name PlaceActionLink nil))
  ([name PlaceActionLink optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://mybusinessplaceactions.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes nil,
       :body PlaceActionLink})))

(defn locations-placeActionLinks-delete
  "Deletes a place action link from the specified location.
https://developers.google.com/my-business

name <string> Required. The resource name of the place action link to remove from the location."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://mybusinessplaceactions.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes nil}))

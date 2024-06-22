(ns happygapi2.places
  "Places API (New)

See: https://mapsplatform.google.com/maps-products/#places-section"
  (:require [happy.oauth2.client :as client]))

(defn places-searchText
  "Text query based place search.
https://mapsplatform.google.com/maps-products/#places-section/v1/docs/places/searchText

GoogleMapsPlacesV1SearchTextRequest:
{:minRating number,
 :textQuery string,
 :locationBias
 {:circle
  {:radius number, :center {:latitude number, :longitude number}},
  :rectangle
  {:low {:latitude number, :longitude number},
   :high {:latitude number, :longitude number}}},
 :maxResultCount integer,
 :locationRestriction
 {:rectangle
  {:low {:latitude number, :longitude number},
   :high {:latitude number, :longitude number}}},
 :includedType string,
 :pageToken string,
 :languageCode string,
 :openNow boolean,
 :strictTypeFiltering boolean,
 :pageSize integer,
 :regionCode string,
 :rankPreference [RANK_PREFERENCE_UNSPECIFIED DISTANCE RELEVANCE],
 :evOptions
 {:minimumChargingRateKw number,
  :connectorTypes
  [[EV_CONNECTOR_TYPE_UNSPECIFIED
    EV_CONNECTOR_TYPE_OTHER
    EV_CONNECTOR_TYPE_J1772
    EV_CONNECTOR_TYPE_TYPE_2
    EV_CONNECTOR_TYPE_CHADEMO
    EV_CONNECTOR_TYPE_CCS_COMBO_1
    EV_CONNECTOR_TYPE_CCS_COMBO_2
    EV_CONNECTOR_TYPE_TESLA
    EV_CONNECTOR_TYPE_UNSPECIFIED_GB_T
    EV_CONNECTOR_TYPE_UNSPECIFIED_WALL_OUTLET]]},
 :priceLevels
 [[PRICE_LEVEL_UNSPECIFIED
   PRICE_LEVEL_FREE
   PRICE_LEVEL_INEXPENSIVE
   PRICE_LEVEL_MODERATE
   PRICE_LEVEL_EXPENSIVE
   PRICE_LEVEL_VERY_EXPENSIVE]]}"
  [GoogleMapsPlacesV1SearchTextRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://places.googleapis.com/v1/places:searchText",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/maps-platform.places"
      "https://www.googleapis.com/auth/maps-platform.places.textsearch"],
     :body GoogleMapsPlacesV1SearchTextRequest}))

(defn places-get
  "Get the details of a place based on its resource name, which is a string in the `places/{place_id}` format.
https://mapsplatform.google.com/maps-products/#places-section/v1/docs/places/get

name <string> Required. The resource name of a place, in the `places/{place_id}` format.

optional:
regionCode <string> Optional. The Unicode country/region code (CLDR) of the location where the request is coming from. This parameter is used to display the place details, like region-specific place name, if available. The parameter can affect results based on applicable law. For more information, see https://www.unicode.org/cldr/charts/latest/supplemental/territory_language_information.html. Note that 3-digit region codes are not currently supported.
sessionToken <string> Optional. A string which identifies an Autocomplete session for billing purposes. Must be a URL and filename safe base64 string with at most 36 ASCII characters in length. Otherwise an INVALID_ARGUMENT error is returned. The session begins when the user starts typing a query, and concludes when they select a place and a call to Place Details or Address Validation is made. Each session can have multiple queries, followed by one Place Details or Address Validation request. The credentials used for each request within a session must belong to the same Google Cloud Console project. Once a session has concluded, the token is no longer valid; your app must generate a fresh token for each session. If the `session_token` parameter is omitted, or if you reuse a session token, the session is charged as if no session token was provided (each request is billed separately). We recommend the following guidelines: * Use session tokens for all Place Autocomplete calls. * Generate a fresh token for each session. Using a version 4 UUID is recommended. * Ensure that the credentials used for all Place Autocomplete, Place Details, and Address Validation requests within a session belong to the same Cloud Console project. * Be sure to pass a unique session token for each new session. Using the same token for more than one session will result in each request being billed individually.
languageCode <string> Optional. Place details will be displayed with the preferred language if available. Current list of supported languages: https://developers.google.com/maps/faq#languagesupport."
  ([name] (places-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://places.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/maps-platform.places"
        "https://www.googleapis.com/auth/maps-platform.places.details"]})))

(defn places-searchNearby
  "Search for places near locations.
https://mapsplatform.google.com/maps-products/#places-section/v1/docs/places/searchNearby

GoogleMapsPlacesV1SearchNearbyRequest:
{:maxResultCount integer,
 :locationRestriction
 {:circle
  {:radius number, :center {:latitude number, :longitude number}}},
 :includedPrimaryTypes [string],
 :excludedPrimaryTypes [string],
 :excludedTypes [string],
 :includedTypes [string],
 :languageCode string,
 :regionCode string,
 :rankPreference [RANK_PREFERENCE_UNSPECIFIED DISTANCE POPULARITY]}"
  [GoogleMapsPlacesV1SearchNearbyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://places.googleapis.com/v1/places:searchNearby",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/maps-platform.places"
      "https://www.googleapis.com/auth/maps-platform.places.nearbysearch"],
     :body GoogleMapsPlacesV1SearchNearbyRequest}))

(defn places-autocomplete
  "Returns predictions for the given input.
https://mapsplatform.google.com/maps-products/#places-section/v1/docs/places/autocomplete

GoogleMapsPlacesV1AutocompletePlacesRequest:
{:locationBias
 {:rectangle
  {:low {:latitude number, :longitude number},
   :high {:latitude number, :longitude number}},
  :circle
  {:radius number, :center {:latitude number, :longitude number}}},
 :sessionToken string,
 :inputOffset integer,
 :locationRestriction
 {:rectangle
  {:low {:latitude number, :longitude number},
   :high {:latitude number, :longitude number}},
  :circle
  {:radius number, :center {:latitude number, :longitude number}}},
 :includedRegionCodes [string],
 :includedPrimaryTypes [string],
 :languageCode string,
 :regionCode string,
 :origin {:latitude number, :longitude number},
 :input string,
 :includeQueryPredictions boolean}"
  [GoogleMapsPlacesV1AutocompletePlacesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://places.googleapis.com/v1/places:autocomplete",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/maps-platform.places"
      "https://www.googleapis.com/auth/maps-platform.places.autocomplete"],
     :body GoogleMapsPlacesV1AutocompletePlacesRequest}))

(defn places-photos-getMedia
  "Get a photo media with a photo reference string.
https://mapsplatform.google.com/maps-products/#places-section/v1/docs/places/photos/getMedia

name <string> Required. The resource name of a photo media in the format: `places/{place_id}/photos/{photo_reference}/media`. The resource name of a photo as returned in a Place object's `photos.name` field comes with the format `places/{place_id}/photos/{photo_reference}`. You need to append `/media` at the end of the photo resource to get the photo media resource name.

optional:
maxHeightPx <integer> Optional. Specifies the maximum desired height, in pixels, of the image. If the image is smaller than the values specified, the original image will be returned. If the image is larger in either dimension, it will be scaled to match the smaller of the two dimensions, restricted to its original aspect ratio. Both the max_height_px and max_width_px properties accept an integer between 1 and 4800, inclusively. If the value is not within the allowed range, an INVALID_ARGUMENT error will be returned. At least one of max_height_px or max_width_px needs to be specified. If neither max_height_px nor max_width_px is specified, an INVALID_ARGUMENT error will be returned.
skipHttpRedirect <boolean> Optional. If set, skip the default HTTP redirect behavior and render a text format (for example, in JSON format for HTTP use case) response. If not set, an HTTP redirect will be issued to redirect the call to the image media. This option is ignored for non-HTTP requests.
maxWidthPx <integer> Optional. Specifies the maximum desired width, in pixels, of the image. If the image is smaller than the values specified, the original image will be returned. If the image is larger in either dimension, it will be scaled to match the smaller of the two dimensions, restricted to its original aspect ratio. Both the max_height_px and max_width_px properties accept an integer between 1 and 4800, inclusively. If the value is not within the allowed range, an INVALID_ARGUMENT error will be returned. At least one of max_height_px or max_width_px needs to be specified. If neither max_height_px nor max_width_px is specified, an INVALID_ARGUMENT error will be returned."
  ([name] (places-photos-getMedia name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://places.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/maps-platform.places"]})))

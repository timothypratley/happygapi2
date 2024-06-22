(ns happygapi2.solar
  "Solar API
Solar API.
See: https://developers.google.com/maps/documentation/solar"
  (:require [happy.oauth2.client :as client]))

(defn buildingInsights-findClosest
  "Locates the closest building to a query point. Returns an error with code `NOT_FOUND` if there are no buildings within approximately 50m of the query point.
https://developers.google.com/maps/documentation/solar/reference/rest/v1/buildingInsights/findClosest

optional:
location.latitude <number> The latitude in degrees. It must be in the range [-90.0, +90.0].
location.longitude <number> The longitude in degrees. It must be in the range [-180.0, +180.0].
requiredQuality <string> Optional. The minimum quality level allowed in the results. No result with lower quality than this will be returned. Not specifying this is equivalent to restricting to HIGH quality only."
  ([] (buildingInsights-findClosest nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://solar.googleapis.com/v1/buildingInsights:findClosest",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn geoTiff-get
  "Returns an image by its ID.
https://developers.google.com/maps/documentation/solar/reference/rest/v1/geoTiff/get

optional:
id <string> Required. The ID of the asset being requested."
  ([] (geoTiff-get nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://solar.googleapis.com/v1/geoTiff:get",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn dataLayers-get
  "Gets solar information for a region surrounding a location. Returns an error with code `NOT_FOUND` if the location is outside the coverage area.
https://developers.google.com/maps/documentation/solar/reference/rest/v1/dataLayers/get

optional:
view <string> Optional. The desired subset of the data to return.
location.longitude <number> The longitude in degrees. It must be in the range [-180.0, +180.0].
pixelSizeMeters <number> Optional. The minimum scale, in meters per pixel, of the data to return. Values of 0.1 (the default, if this field is not set explicitly), 0.25, 0.5, and 1.0 are supported. Imagery components whose normal resolution is less than `pixel_size_meters` will be returned at the resolution specified by `pixel_size_meters`; imagery components whose normal resolution is equal to or greater than `pixel_size_meters` will be returned at that normal resolution.
exactQualityRequired <boolean> Optional. Whether to require exact quality of the imagery. If set to false, the `required_quality` field is interpreted as the minimum required quality, such that HIGH quality imagery may be returned when `required_quality` is set to MEDIUM. If set to true, `required_quality` is interpreted as the exact required quality and only `MEDIUM` quality imagery is returned if `required_quality` is set to `MEDIUM`.
radiusMeters <number> Required. The radius, in meters, defining the region surrounding that centre point for which data should be returned. The limitations on this value are: * Any value up to 100m can always be specified. * Values over 100m can be specified, as long as `radius_meters` <= `pixel_size_meters * 1000`. * However, for values over 175m, the `DataLayerView` in the request must not include monthly flux or hourly shade.
location.latitude <number> The latitude in degrees. It must be in the range [-90.0, +90.0].
requiredQuality <string> Optional. The minimum quality level allowed in the results. No result with lower quality than this will be returned. Not specifying this is equivalent to restricting to HIGH quality only."
  ([] (dataLayers-get nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://solar.googleapis.com/v1/dataLayers:get",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(ns happygapi2.pollen
  "Pollen API
The Pollen API. 
See: https://developers.google.com/maps/documentation/pollen"
  (:require [happy.oauth2.client :as client]))

(defn forecast-lookup
  "Returns up to 5 days of daily pollen information in more than 65 countries, up to 1km resolution.
https://developers.google.com/maps/documentation/pollen/reference/rest/v1/forecast/lookup

optional:
plantsDescription <boolean> Optional. Contains general information about plants, including details on their seasonality, special shapes and colors, information about allergic cross-reactions, and plant photos.
location.latitude <number> The latitude in degrees. It must be in the range [-90.0, +90.0].
days <integer> Required. A number that indicates how many forecast days to request (minimum value 1, maximum value is 5).
languageCode <string> Optional. Allows the client to choose the language for the response. If data cannot be provided for that language the API uses the closest match. Allowed values rely on the IETF BCP-47 standard. Default value is \"en\".
pageSize <integer> Optional. The maximum number of daily info records to return per page. The default and max value is 5 (5 days of data).
location.longitude <number> The longitude in degrees. It must be in the range [-180.0, +180.0]."
  ([] (forecast-lookup nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://pollen.googleapis.com/v1/forecast:lookup",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn mapTypes-heatmapTiles-lookupHeatmapTile
  "Returns a byte array containing the data of the tile PNG image.
https://developers.google.com/maps/documentation/pollen/reference/rest/v1/mapTypes/heatmapTiles/lookupHeatmapTile

mapType <string> Required. The type of the pollen heatmap. Defines the combination of pollen type and index that the map will graphically represent.
zoom <integer> Required. The map's zoom level. Defines how large or small the contents of a map appear in a map view. * Zoom level 0 is the entire world in a single tile. * Zoom level 1 is the entire world in 4 tiles. * Zoom level 2 is the entire world in 16 tiles. * Zoom level 16 is the entire world in 65,536 tiles. Allowed values: 0-16
x <integer> Required. Defines the east-west point in the requested tile.
y <integer> Required. Defines the north-south point in the requested tile."
  [mapType zoom x y]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://pollen.googleapis.com/v1/mapTypes/{mapType}/heatmapTiles/{zoom}/{x}/{y}",
     :uri-template-args {:mapType mapType, :y y, :x x, :zoom zoom},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

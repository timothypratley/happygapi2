(ns happygapi2.airquality
  "Air Quality API
The Air Quality API.
See: https://developers.google.com/maps/documentation/air-quality"
  (:require [happy.oauth2.client :as client]))

(defn mapTypes-heatmapTiles-lookupHeatmapTile
  "Returns a bytes array containing the data of the tile PNG image.
https://developers.google.com/maps/documentation/air-quality/reference/rest/v1/mapTypes.heatmapTiles/lookupHeatmapTile

mapType <string> Required. The type of the air quality heatmap. Defines the pollutant that the map will graphically represent. Allowed values: - UAQI_RED_GREEN (UAQI, red-green palette) - UAQI_INDIGO_PERSIAN (UAQI, indigo-persian palette) - PM25_INDIGO_PERSIAN - GBR_DEFRA - DEU_UBA - CAN_EC - FRA_ATMO - US_AQI
zoom <integer> Required. The map's zoom level. Defines how large or small the contents of a map appear in a map view. Zoom level 0 is the entire world in a single tile. Zoom level 1 is the entire world in 4 tiles. Zoom level 2 is the entire world in 16 tiles. Zoom level 16 is the entire world in 65,536 tiles. Allowed values: 0-16
x <integer> Required. Defines the east-west point in the requested tile.
y <integer> Required. Defines the north-south point in the requested tile."
  [mapType zoom x y]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://airquality.googleapis.com/v1/mapTypes/{mapType}/heatmapTiles/{zoom}/{x}/{y}",
     :uri-template-args {:y y, :zoom zoom, :x x, :mapType mapType},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn history-lookup
  "Returns air quality history for a specific location for a given time range.
https://developers.google.com/maps/documentation/air-quality/reference/rest/v1/history/lookup

LookupHistoryRequest:
{:extraComputations
 [[EXTRA_COMPUTATION_UNSPECIFIED
   LOCAL_AQI
   HEALTH_RECOMMENDATIONS
   POLLUTANT_ADDITIONAL_INFO
   DOMINANT_POLLUTANT_CONCENTRATION
   POLLUTANT_CONCENTRATION]],
 :customLocalAqis [{:aqi string, :regionCode string}],
 :universalAqi boolean,
 :pageToken string,
 :dateTime string,
 :languageCode string,
 :pageSize integer,
 :uaqiColorPalette
 [COLOR_PALETTE_UNSPECIFIED
  RED_GREEN
  INDIGO_PERSIAN_DARK
  INDIGO_PERSIAN_LIGHT],
 :hours integer,
 :period {:startTime string, :endTime string},
 :location {:latitude number, :longitude number}}"
  [LookupHistoryRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://airquality.googleapis.com/v1/history:lookup",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body LookupHistoryRequest}))

(defn forecast-lookup
  "Returns air quality forecast for a specific location for a given time range.
https://developers.google.com/maps/documentation/air-quality/reference/rest/v1/forecast/lookup

LookupForecastRequest:
{:extraComputations
 [[EXTRA_COMPUTATION_UNSPECIFIED
   LOCAL_AQI
   HEALTH_RECOMMENDATIONS
   POLLUTANT_ADDITIONAL_INFO
   DOMINANT_POLLUTANT_CONCENTRATION
   POLLUTANT_CONCENTRATION]],
 :customLocalAqis [{:aqi string, :regionCode string}],
 :universalAqi boolean,
 :pageToken string,
 :dateTime string,
 :languageCode string,
 :pageSize integer,
 :uaqiColorPalette
 [COLOR_PALETTE_UNSPECIFIED
  RED_GREEN
  INDIGO_PERSIAN_DARK
  INDIGO_PERSIAN_LIGHT],
 :period {:startTime string, :endTime string},
 :location {:latitude number, :longitude number}}"
  [LookupForecastRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://airquality.googleapis.com/v1/forecast:lookup",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body LookupForecastRequest}))

(defn currentConditions-lookup
  "The Current Conditions endpoint provides hourly air quality information in more than 100 countries, up to a 500 x 500 meters resolution. Includes over 70 local indexes and global air quality index and categories.
https://developers.google.com/maps/documentation/air-quality/reference/rest/v1/currentConditions/lookup

LookupCurrentConditionsRequest:
{:location {:latitude number, :longitude number},
 :customLocalAqis [{:aqi string, :regionCode string}],
 :extraComputations
 [[EXTRA_COMPUTATION_UNSPECIFIED
   LOCAL_AQI
   HEALTH_RECOMMENDATIONS
   POLLUTANT_ADDITIONAL_INFO
   DOMINANT_POLLUTANT_CONCENTRATION
   POLLUTANT_CONCENTRATION]],
 :uaqiColorPalette
 [COLOR_PALETTE_UNSPECIFIED
  RED_GREEN
  INDIGO_PERSIAN_DARK
  INDIGO_PERSIAN_LIGHT],
 :languageCode string,
 :universalAqi boolean}"
  [LookupCurrentConditionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://airquality.googleapis.com/v1/currentConditions:lookup",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body LookupCurrentConditionsRequest}))

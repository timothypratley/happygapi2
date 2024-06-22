(ns happygapi2.mybusinesslodging
  "My Business Lodging API
The My Business Lodging API enables managing lodging business information on Google. Note - If you have a quota of 0 after enabling the API, please request for GBP API access.
See: https://developers.google.com/my-business/"
  (:require [happy.oauth2.client :as client]))

(defn locations-getLodging
  "Returns the Lodging of a specific location.
https://developers.google.com/my-business

name <string> Required. Google identifier for this location in the form: `locations/{location_id}/lodging`

optional:
readMask <string> Required. The specific fields to return. Use \"*\" to include all fields. Repeated field items cannot be individually specified."
  ([name] (locations-getLodging name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://mybusinesslodging.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes nil})))

(defn locations-updateLodging
  "Updates the Lodging of a specific location.
https://developers.google.com/my-business

name <string> Required. Google identifier for this location in the form: `locations/{location_id}/lodging`
Lodging:
{:someUnits
 {:tier [UNIT_TIER_UNSPECIFIED STANDARD_UNIT DELUXE_UNIT],
  :bungalowOrVillaException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :privateHome boolean,
  :maxAdultOccupantsCountException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :totalLivingAreas
  {:layout
   {:livingAreaSqMetersException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :livingAreaSqMeters number,
    :nonSmoking boolean,
    :loftException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :patioException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :patio boolean,
    :loft boolean,
    :balcony boolean,
    :stairs boolean,
    :nonSmokingException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :balconyException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :stairsException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK]},
   :features
   {:washer boolean,
    :universalPowerAdapters boolean,
    :bidet boolean,
    :tv boolean,
    :ironingEquipment boolean,
    :fireplaceException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :electronicRoomKeyException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :privateBathroom boolean,
    :shower boolean,
    :dryer boolean,
    :airConditioning boolean,
    :inunitSafe boolean,
    :inunitWifiAvailableException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :dryerException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :tvException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :inunitWifiAvailable boolean,
    :heatingException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :tvCastingException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :bidetException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :privateBathroomException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :ironingEquipmentException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :toilet boolean,
    :inunitSafeException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :bathtub boolean,
    :toiletException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :hairdryerException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :payPerViewMoviesException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :showerException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :tvStreamingException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :washerException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :fireplace boolean,
    :tvCasting boolean,
    :universalPowerAdaptersException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :tvStreaming boolean,
    :airConditioningException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :electronicRoomKey boolean,
    :heating boolean,
    :hairdryer boolean,
    :bathtubException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :payPerViewMovies boolean},
   :eating
   {:microwaveException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :teaStationException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :cookwareException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :microwave boolean,
    :outdoorGrill boolean,
    :kitchenAvailableException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :toasterException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :kettle boolean,
    :coffeeMaker boolean,
    :toaster boolean,
    :dishwasher boolean,
    :refrigerator boolean,
    :snackbarException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :refrigeratorException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :stove boolean,
    :dishwasherException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :cookware boolean,
    :kitchenAvailable boolean,
    :coffeeMakerException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :ovenException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :oven boolean,
    :sinkException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :indoorGrill boolean,
    :outdoorGrillException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :indoorGrillException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :kettleException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :minibar boolean,
    :snackbar boolean,
    :minibarException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :sink boolean,
    :teaStation boolean,
    :stoveException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK]},
   :sleeping
   {:syntheticPillowsException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :memoryFoamPillows boolean,
    :cribsCountException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :hypoallergenicBeddingException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :syntheticPillows boolean,
    :cribsCount integer,
    :doubleBedsCount integer,
    :kingBedsCount integer,
    :rollAwayBedsCount integer,
    :bunkBedsCountException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :bedsCountException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :queenBedsCountException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :queenBedsCount integer,
    :singleOrTwinBedsCountException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :hypoallergenicBedding boolean,
    :featherPillows boolean,
    :memoryFoamPillowsException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :otherBedsCountException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :bunkBedsCount integer,
    :doubleBedsCountException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :otherBedsCount integer,
    :sofaBedsCount integer,
    :kingBedsCountException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :bedsCount integer,
    :featherPillowsException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :rollAwayBedsCountException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :singleOrTwinBedsCount integer,
    :sofaBedsCountException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK]},
   :accessibility
   {:hearingAccessibleDoorbellException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :adaCompliantUnit boolean,
    :mobilityAccessibleUnitException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :hearingAccessibleUnit boolean,
    :mobilityAccessibleShowerException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :mobilityAccessibleShower boolean,
    :mobilityAccessibleBathtubException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :mobilityAccessibleToilet boolean,
    :hearingAccessibleFireAlarm boolean,
    :hearingAccessibleFireAlarmException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :hearingAccessibleDoorbell boolean,
    :mobilityAccessibleBathtub boolean,
    :mobilityAccessibleUnit boolean,
    :mobilityAccessibleToiletException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :hearingAccessibleUnitException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :adaCompliantUnitException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK]}},
  :maxChildOccupantsCountException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :executiveFloorException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :suiteException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :bungalowOrVilla boolean,
  :maxAdultOccupantsCount integer,
  :maxChildOccupantsCount integer,
  :tierException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :connectingUnitAvailable boolean,
  :connectingUnitAvailableException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :maxOccupantsCountException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :executiveFloor boolean,
  :privateHomeException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :suite boolean,
  :maxOccupantsCount integer,
  :views
  {:valleyViewException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :cityViewException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :lakeView boolean,
   :poolView boolean,
   :beachViewException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :valleyView boolean,
   :landmarkViewException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :lakeViewException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :landmarkView boolean,
   :gardenViewException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :cityView boolean,
   :oceanViewException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :poolViewException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :oceanView boolean,
   :gardenView boolean,
   :beachView boolean}},
 :allUnits
 {:tier [UNIT_TIER_UNSPECIFIED STANDARD_UNIT DELUXE_UNIT],
  :bungalowOrVillaException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :privateHome boolean,
  :maxAdultOccupantsCountException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :totalLivingAreas
  {:layout
   {:livingAreaSqMetersException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :livingAreaSqMeters number,
    :nonSmoking boolean,
    :loftException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :patioException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :patio boolean,
    :loft boolean,
    :balcony boolean,
    :stairs boolean,
    :nonSmokingException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :balconyException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :stairsException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK]},
   :features
   {:washer boolean,
    :universalPowerAdapters boolean,
    :bidet boolean,
    :tv boolean,
    :ironingEquipment boolean,
    :fireplaceException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :electronicRoomKeyException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :privateBathroom boolean,
    :shower boolean,
    :dryer boolean,
    :airConditioning boolean,
    :inunitSafe boolean,
    :inunitWifiAvailableException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :dryerException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :tvException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :inunitWifiAvailable boolean,
    :heatingException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :tvCastingException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :bidetException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :privateBathroomException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :ironingEquipmentException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :toilet boolean,
    :inunitSafeException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :bathtub boolean,
    :toiletException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :hairdryerException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :payPerViewMoviesException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :showerException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :tvStreamingException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :washerException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :fireplace boolean,
    :tvCasting boolean,
    :universalPowerAdaptersException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :tvStreaming boolean,
    :airConditioningException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :electronicRoomKey boolean,
    :heating boolean,
    :hairdryer boolean,
    :bathtubException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :payPerViewMovies boolean},
   :eating
   {:microwaveException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :teaStationException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :cookwareException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :microwave boolean,
    :outdoorGrill boolean,
    :kitchenAvailableException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :toasterException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :kettle boolean,
    :coffeeMaker boolean,
    :toaster boolean,
    :dishwasher boolean,
    :refrigerator boolean,
    :snackbarException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :refrigeratorException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :stove boolean,
    :dishwasherException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :cookware boolean,
    :kitchenAvailable boolean,
    :coffeeMakerException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :ovenException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :oven boolean,
    :sinkException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :indoorGrill boolean,
    :outdoorGrillException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :indoorGrillException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :kettleException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :minibar boolean,
    :snackbar boolean,
    :minibarException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :sink boolean,
    :teaStation boolean,
    :stoveException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK]},
   :sleeping
   {:syntheticPillowsException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :memoryFoamPillows boolean,
    :cribsCountException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :hypoallergenicBeddingException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :syntheticPillows boolean,
    :cribsCount integer,
    :doubleBedsCount integer,
    :kingBedsCount integer,
    :rollAwayBedsCount integer,
    :bunkBedsCountException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :bedsCountException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :queenBedsCountException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :queenBedsCount integer,
    :singleOrTwinBedsCountException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :hypoallergenicBedding boolean,
    :featherPillows boolean,
    :memoryFoamPillowsException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :otherBedsCountException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :bunkBedsCount integer,
    :doubleBedsCountException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :otherBedsCount integer,
    :sofaBedsCount integer,
    :kingBedsCountException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :bedsCount integer,
    :featherPillowsException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :rollAwayBedsCountException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :singleOrTwinBedsCount integer,
    :sofaBedsCountException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK]},
   :accessibility
   {:hearingAccessibleDoorbellException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :adaCompliantUnit boolean,
    :mobilityAccessibleUnitException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :hearingAccessibleUnit boolean,
    :mobilityAccessibleShowerException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :mobilityAccessibleShower boolean,
    :mobilityAccessibleBathtubException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :mobilityAccessibleToilet boolean,
    :hearingAccessibleFireAlarm boolean,
    :hearingAccessibleFireAlarmException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :hearingAccessibleDoorbell boolean,
    :mobilityAccessibleBathtub boolean,
    :mobilityAccessibleUnit boolean,
    :mobilityAccessibleToiletException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :hearingAccessibleUnitException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :adaCompliantUnitException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK]}},
  :maxChildOccupantsCountException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :executiveFloorException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :suiteException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :bungalowOrVilla boolean,
  :maxAdultOccupantsCount integer,
  :maxChildOccupantsCount integer,
  :tierException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :connectingUnitAvailable boolean,
  :connectingUnitAvailableException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :maxOccupantsCountException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :executiveFloor boolean,
  :privateHomeException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :suite boolean,
  :maxOccupantsCount integer,
  :views
  {:valleyViewException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :cityViewException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :lakeView boolean,
   :poolView boolean,
   :beachViewException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :valleyView boolean,
   :landmarkViewException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :lakeViewException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :landmarkView boolean,
   :gardenViewException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :cityView boolean,
   :oceanViewException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :poolViewException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :oceanView boolean,
   :gardenView boolean,
   :beachView boolean}},
 :healthAndSafety
 {:enhancedCleaning
  {:guestRoomsEnhancedCleaning boolean,
   :commonAreasEnhancedCleaningException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :employeesWearProtectiveEquipmentException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :commonAreasEnhancedCleaning boolean,
   :employeesTrainedThoroughHandWashing boolean,
   :employeesWearProtectiveEquipment boolean,
   :commercialGradeDisinfectantCleaningException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :guestRoomsEnhancedCleaningException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :employeesTrainedThoroughHandWashingException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :employeesTrainedCleaningProcedures boolean,
   :employeesTrainedCleaningProceduresException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :commercialGradeDisinfectantCleaning boolean},
  :increasedFoodSafety
  {:foodPreparationAndServingAdditionalSafety boolean,
   :disposableFlatware boolean,
   :individualPackagedMeals boolean,
   :diningAreasAdditionalSanitationException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :individualPackagedMealsException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :singleUseFoodMenusException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :diningAreasAdditionalSanitation boolean,
   :disposableFlatwareException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :foodPreparationAndServingAdditionalSafetyException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :singleUseFoodMenus boolean},
  :minimizedContact
  {:noHighTouchItemsGuestRoomsException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :noHighTouchItemsCommonAreasException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :plasticKeycardsDisinfected boolean,
   :digitalGuestRoomKeysException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :roomBookingsBuffer boolean,
   :noHighTouchItemsCommonAreas boolean,
   :contactlessCheckinCheckout boolean,
   :housekeepingScheduledRequestOnlyException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :digitalGuestRoomKeys boolean,
   :noHighTouchItemsGuestRooms boolean,
   :housekeepingScheduledRequestOnly boolean,
   :roomBookingsBufferException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :plasticKeycardsDisinfectedException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :contactlessCheckinCheckoutException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK]},
  :personalProtection
  {:commonAreasOfferSanitizingItems boolean,
   :commonAreasOfferSanitizingItemsException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :guestRoomHygieneKitsAvailable boolean,
   :guestRoomHygieneKitsAvailableException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :protectiveEquipmentAvailable boolean,
   :protectiveEquipmentAvailableException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :faceMaskRequired boolean,
   :faceMaskRequiredException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK]},
  :physicalDistancing
  {:safetyDividers boolean,
   :wellnessAreasHavePrivateSpaces boolean,
   :sharedAreasLimitedOccupancy boolean,
   :sharedAreasLimitedOccupancyException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :commonAreasPhysicalDistancingArrangedException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :commonAreasPhysicalDistancingArranged boolean,
   :wellnessAreasHavePrivateSpacesException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :physicalDistancingRequired boolean,
   :physicalDistancingRequiredException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :safetyDividersException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK]}},
 :transportation
 {:privateCarService boolean,
  :transferException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :transfer boolean,
  :localShuttleException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :carRentalOnPropertyException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :airportShuttle boolean,
  :airportShuttleException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :freePrivateCarServiceException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :privateCarServiceException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :localShuttle boolean,
  :freeAirportShuttle boolean,
  :carRentalOnProperty boolean,
  :freePrivateCarService boolean,
  :freeAirportShuttleException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK]},
 :accessibility
 {:mobilityAccessible boolean,
  :mobilityAccessibleException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :mobilityAccessibleParking boolean,
  :mobilityAccessibleParkingException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :mobilityAccessibleElevator boolean,
  :mobilityAccessibleElevatorException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :mobilityAccessiblePool boolean,
  :mobilityAccessiblePoolException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK]},
 :policies
 {:checkinTimeException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :allInclusiveAvailable boolean,
  :kidsStayFree boolean,
  :paymentOptions
  {:cheque boolean,
   :cashException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :mobileNfc boolean,
   :cash boolean,
   :creditCardException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :debitCardException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :chequeException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :debitCard boolean,
   :creditCard boolean,
   :mobileNfcException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK]},
  :checkoutTimeException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :checkinTime
  {:hours integer, :minutes integer, :seconds integer, :nanos integer},
  :checkoutTime
  {:hours integer, :minutes integer, :seconds integer, :nanos integer},
  :maxKidsStayFreeCountException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :allInclusiveOnlyException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :smokeFreePropertyException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :allInclusiveOnly boolean,
  :allInclusiveAvailableException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :smokeFreeProperty boolean,
  :kidsStayFreeException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :maxChildAge integer,
  :maxChildAgeException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :maxKidsStayFreeCount integer},
 :property
 {:builtYear integer,
  :builtYearException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :lastRenovatedYear integer,
  :lastRenovatedYearException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :roomsCount integer,
  :roomsCountException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :floorsCount integer,
  :floorsCountException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK]},
 :name string,
 :wellness
 {:freeFitnessCenterException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :saunaException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :sauna boolean,
  :fitnessCenterException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :salonException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :salon boolean,
  :doctorOnCallException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :massage boolean,
  :massageException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :freeWeightsException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :spaException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :spa boolean,
  :weightMachine boolean,
  :doctorOnCall boolean,
  :ellipticalMachine boolean,
  :freeWeights boolean,
  :treadmillException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :weightMachineException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :fitnessCenter boolean,
  :ellipticalMachineException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :treadmill boolean,
  :freeFitnessCenter boolean},
 :commonLivingArea
 {:layout
  {:livingAreaSqMetersException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :livingAreaSqMeters number,
   :nonSmoking boolean,
   :loftException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :patioException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :patio boolean,
   :loft boolean,
   :balcony boolean,
   :stairs boolean,
   :nonSmokingException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :balconyException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :stairsException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK]},
  :features
  {:washer boolean,
   :universalPowerAdapters boolean,
   :bidet boolean,
   :tv boolean,
   :ironingEquipment boolean,
   :fireplaceException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :electronicRoomKeyException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :privateBathroom boolean,
   :shower boolean,
   :dryer boolean,
   :airConditioning boolean,
   :inunitSafe boolean,
   :inunitWifiAvailableException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :dryerException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :tvException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :inunitWifiAvailable boolean,
   :heatingException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :tvCastingException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :bidetException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :privateBathroomException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :ironingEquipmentException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :toilet boolean,
   :inunitSafeException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :bathtub boolean,
   :toiletException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :hairdryerException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :payPerViewMoviesException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :showerException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :tvStreamingException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :washerException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :fireplace boolean,
   :tvCasting boolean,
   :universalPowerAdaptersException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :tvStreaming boolean,
   :airConditioningException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :electronicRoomKey boolean,
   :heating boolean,
   :hairdryer boolean,
   :bathtubException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :payPerViewMovies boolean},
  :eating
  {:microwaveException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :teaStationException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :cookwareException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :microwave boolean,
   :outdoorGrill boolean,
   :kitchenAvailableException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :toasterException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :kettle boolean,
   :coffeeMaker boolean,
   :toaster boolean,
   :dishwasher boolean,
   :refrigerator boolean,
   :snackbarException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :refrigeratorException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :stove boolean,
   :dishwasherException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :cookware boolean,
   :kitchenAvailable boolean,
   :coffeeMakerException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :ovenException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :oven boolean,
   :sinkException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :indoorGrill boolean,
   :outdoorGrillException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :indoorGrillException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :kettleException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :minibar boolean,
   :snackbar boolean,
   :minibarException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :sink boolean,
   :teaStation boolean,
   :stoveException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK]},
  :sleeping
  {:syntheticPillowsException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :memoryFoamPillows boolean,
   :cribsCountException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :hypoallergenicBeddingException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :syntheticPillows boolean,
   :cribsCount integer,
   :doubleBedsCount integer,
   :kingBedsCount integer,
   :rollAwayBedsCount integer,
   :bunkBedsCountException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :bedsCountException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :queenBedsCountException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :queenBedsCount integer,
   :singleOrTwinBedsCountException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :hypoallergenicBedding boolean,
   :featherPillows boolean,
   :memoryFoamPillowsException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :otherBedsCountException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :bunkBedsCount integer,
   :doubleBedsCountException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :otherBedsCount integer,
   :sofaBedsCount integer,
   :kingBedsCountException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :bedsCount integer,
   :featherPillowsException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :rollAwayBedsCountException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :singleOrTwinBedsCount integer,
   :sofaBedsCountException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK]},
  :accessibility
  {:hearingAccessibleDoorbellException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :adaCompliantUnit boolean,
   :mobilityAccessibleUnitException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :hearingAccessibleUnit boolean,
   :mobilityAccessibleShowerException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :mobilityAccessibleShower boolean,
   :mobilityAccessibleBathtubException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :mobilityAccessibleToilet boolean,
   :hearingAccessibleFireAlarm boolean,
   :hearingAccessibleFireAlarmException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :hearingAccessibleDoorbell boolean,
   :mobilityAccessibleBathtub boolean,
   :mobilityAccessibleUnit boolean,
   :mobilityAccessibleToiletException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :hearingAccessibleUnitException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :adaCompliantUnitException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK]}},
 :connectivity
 {:wifiAvailable boolean,
  :wifiAvailableException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :freeWifi boolean,
  :freeWifiException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :publicAreaWifiAvailable boolean,
  :publicAreaWifiAvailableException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :publicInternetTerminal boolean,
  :publicInternetTerminalException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK]},
 :pools
 {:poolsCount integer,
  :adultPool boolean,
  :lazyRiver boolean,
  :pool boolean,
  :wavePoolException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :outdoorPoolsCount integer,
  :wadingPoolException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :poolException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :wadingPool boolean,
  :hotTub boolean,
  :outdoorPool boolean,
  :waterPark boolean,
  :indoorPoolsCount integer,
  :indoorPoolException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :waterParkException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :wavePool boolean,
  :indoorPool boolean,
  :lifeguardException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :lazyRiverException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :poolsCountException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :lifeguard boolean,
  :outdoorPoolsCountException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :indoorPoolsCountException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :outdoorPoolException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :waterslide boolean,
  :waterslideException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :hotTubException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :adultPoolException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK]},
 :pets
 {:petsAllowed boolean,
  :petsAllowedException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :petsAllowedFree boolean,
  :petsAllowedFreeException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :dogsAllowed boolean,
  :dogsAllowedException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :catsAllowed boolean,
  :catsAllowedException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK]},
 :parking
 {:selfParkingAvailableException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :freeSelfParking boolean,
  :freeSelfParkingException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :freeParking boolean,
  :parkingAvailable boolean,
  :freeValetParking boolean,
  :parkingAvailableException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :freeValetParkingException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :valetParkingAvailableException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :freeParkingException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :electricCarChargingStations boolean,
  :valetParkingAvailable boolean,
  :selfParkingAvailable boolean,
  :electricCarChargingStationsException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK]},
 :housekeeping
 {:housekeepingAvailable boolean,
  :housekeepingAvailableException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :dailyHousekeeping boolean,
  :dailyHousekeepingException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :turndownService boolean,
  :turndownServiceException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK]},
 :foodAndDrink
 {:breakfastAvailable boolean,
  :restaurantException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :roomService boolean,
  :buffet boolean,
  :roomServiceException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :breakfastAvailableException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :bar boolean,
  :breakfastBuffetException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :tableServiceException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :restaurant boolean,
  :vendingMachine boolean,
  :breakfastBuffet boolean,
  :freeBreakfastException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :vendingMachineException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :buffetException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :dinnerBuffet boolean,
  :freeBreakfast boolean,
  :restaurantsCountException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :restaurantsCount integer,
  :dinnerBuffetException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :tableService boolean,
  :twentyFourHourRoomServiceException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :barException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :twentyFourHourRoomService boolean},
 :sustainability
 {:energyEfficiency
  {:energySavingThermostats boolean,
   :carbonFreeEnergySources boolean,
   :energyEfficientLighting boolean,
   :carbonFreeEnergySourcesException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :energyConservationProgram boolean,
   :energyEfficientHeatingAndCoolingSystemsException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :energyEfficientHeatingAndCoolingSystems boolean,
   :independentOrganizationAuditsEnergyUseException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :energySavingThermostatsException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :energyEfficientLightingException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :greenBuildingDesign boolean,
   :independentOrganizationAuditsEnergyUse boolean,
   :greenBuildingDesignException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :energyConservationProgramException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK]},
  :waterConservation
  {:waterSavingToiletsException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :towelReuseProgramException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :linenReuseProgram boolean,
   :independentOrganizationAuditsWaterUse boolean,
   :independentOrganizationAuditsWaterUseException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :waterSavingSinksException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :linenReuseProgramException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :waterSavingToilets boolean,
   :towelReuseProgram boolean,
   :waterSavingSinks boolean,
   :waterSavingShowers boolean,
   :waterSavingShowersException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK]},
  :wasteReduction
  {:recyclingProgram boolean,
   :refillableToiletryContainersException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :toiletryDonationProgramException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :noSingleUsePlasticStrawsException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :waterBottleFillingStations boolean,
   :toiletryDonationProgram boolean,
   :foodWasteReductionProgramException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :recyclingProgramException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :compostsExcessFood boolean,
   :soapDonationProgram boolean,
   :donatesExcessFood boolean,
   :safelyDisposesLightbulbs boolean,
   :safelyDisposesElectronicsException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :noStyrofoamFoodContainersException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :noSingleUsePlasticStraws boolean,
   :waterBottleFillingStationsException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :safelyDisposesElectronics boolean,
   :noSingleUsePlasticWaterBottlesException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :noSingleUsePlasticWaterBottles boolean,
   :safelyDisposesBatteriesException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :safelyHandlesHazardousSubstances boolean,
   :foodWasteReductionProgram boolean,
   :donatesExcessFoodException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :compostsExcessFoodException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :safelyDisposesBatteries boolean,
   :safelyDisposesLightbulbsException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :safelyHandlesHazardousSubstancesException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :compostableFoodContainersAndCutlery boolean,
   :soapDonationProgramException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :noStyrofoamFoodContainers boolean,
   :compostableFoodContainersAndCutleryException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :refillableToiletryContainers boolean},
  :sustainableSourcing
  {:locallySourcedFoodAndBeveragesException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :responsiblySourcesSeafoodException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :responsiblySourcesSeafood boolean,
   :ecoFriendlyToiletries boolean,
   :responsiblePurchasingPolicyException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :ecoFriendlyToiletriesException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :veganMealsException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :organicFoodAndBeveragesException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :vegetarianMealsException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :responsiblePurchasingPolicy boolean,
   :veganMeals boolean,
   :locallySourcedFoodAndBeverages boolean,
   :vegetarianMeals boolean,
   :organicCageFreeEggs boolean,
   :organicCageFreeEggsException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :organicFoodAndBeverages boolean},
  :sustainabilityCertifications
  {:breeamCertification
   [BREEAM_CERTIFICATION_UNSPECIFIED
    NO_BREEAM_CERTIFICATION
    BREEAM_PASS
    BREEAM_GOOD
    BREEAM_VERY_GOOD
    BREEAM_EXCELLENT
    BREEAM_OUTSTANDING],
   :breeamCertificationException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :leedCertification
   [LEED_CERTIFICATION_UNSPECIFIED
    NO_LEED_CERTIFICATION
    LEED_CERTIFIED
    LEED_SILVER
    LEED_GOLD
    LEED_PLATINUM],
   :leedCertificationException
   [EXCEPTION_UNSPECIFIED
    UNDER_CONSTRUCTION
    DEPENDENT_ON_SEASON
    DEPENDENT_ON_DAY_OF_WEEK],
   :ecoCertifications
   [{:ecoCertificate
     [ECO_CERTIFICATE_UNSPECIFIED
      ISO14001
      ISO50001
      ASIAN_ECOTOURISM
      BIOSPHERE_RESPOSNIBLE_TOURISM
      BUREAU_VERITAS
      CONTROL_UNION
      EARTHCHECK
      ECO_CERTIFICATION_MALTA
      ECOTOURISM_AUSTRALIAS_ECO
      GREAT_GREEN_DEAL
      GREEN_GLOBE
      GREEN_GROWTH2050
      GREEN_KEY
      GREEN_KEY_ECO_RATING
      GREEN_SEAL
      GREEN_STAR
      GREEN_TOURISM_ACTIVE
      HILTON_LIGHTSTAY
      HOSTELLING_INTERNATIONALS_QUALITY_AND_SUSTAINABILITY
      HOTELES_MAS_VERDES
      NORDIC_SWAN_ECOLABEL
      PREFERRED_BY_NATURE_SUSTAINABLE_TOURISM
      SUSTAINABLE_TRAVEL_IRELAND
      TOF_TIGERS_INITITIVES_PUG
      TRAVELIFE
      UNITED_CERTIFICATION_SYSTEMS_LIMITED
      VIREO_SRL],
     :awarded boolean,
     :awardedException
     [EXCEPTION_UNSPECIFIED
      UNDER_CONSTRUCTION
      DEPENDENT_ON_SEASON
      DEPENDENT_ON_DAY_OF_WEEK]}]}},
 :guestUnits
 [{:codes [string],
   :label string,
   :features
   {:tier [UNIT_TIER_UNSPECIFIED STANDARD_UNIT DELUXE_UNIT],
    :bungalowOrVillaException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :privateHome boolean,
    :maxAdultOccupantsCountException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :totalLivingAreas
    {:layout
     {:livingAreaSqMetersException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :livingAreaSqMeters number,
      :nonSmoking boolean,
      :loftException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :patioException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :patio boolean,
      :loft boolean,
      :balcony boolean,
      :stairs boolean,
      :nonSmokingException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :balconyException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :stairsException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK]},
     :features
     {:washer boolean,
      :universalPowerAdapters boolean,
      :bidet boolean,
      :tv boolean,
      :ironingEquipment boolean,
      :fireplaceException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :electronicRoomKeyException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :privateBathroom boolean,
      :shower boolean,
      :dryer boolean,
      :airConditioning boolean,
      :inunitSafe boolean,
      :inunitWifiAvailableException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :dryerException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :tvException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :inunitWifiAvailable boolean,
      :heatingException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :tvCastingException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :bidetException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :privateBathroomException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :ironingEquipmentException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :toilet boolean,
      :inunitSafeException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :bathtub boolean,
      :toiletException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :hairdryerException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :payPerViewMoviesException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :showerException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :tvStreamingException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :washerException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :fireplace boolean,
      :tvCasting boolean,
      :universalPowerAdaptersException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :tvStreaming boolean,
      :airConditioningException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :electronicRoomKey boolean,
      :heating boolean,
      :hairdryer boolean,
      :bathtubException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :payPerViewMovies boolean},
     :eating
     {:microwaveException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :teaStationException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :cookwareException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :microwave boolean,
      :outdoorGrill boolean,
      :kitchenAvailableException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :toasterException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :kettle boolean,
      :coffeeMaker boolean,
      :toaster boolean,
      :dishwasher boolean,
      :refrigerator boolean,
      :snackbarException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :refrigeratorException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :stove boolean,
      :dishwasherException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :cookware boolean,
      :kitchenAvailable boolean,
      :coffeeMakerException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :ovenException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :oven boolean,
      :sinkException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :indoorGrill boolean,
      :outdoorGrillException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :indoorGrillException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :kettleException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :minibar boolean,
      :snackbar boolean,
      :minibarException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :sink boolean,
      :teaStation boolean,
      :stoveException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK]},
     :sleeping
     {:syntheticPillowsException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :memoryFoamPillows boolean,
      :cribsCountException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :hypoallergenicBeddingException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :syntheticPillows boolean,
      :cribsCount integer,
      :doubleBedsCount integer,
      :kingBedsCount integer,
      :rollAwayBedsCount integer,
      :bunkBedsCountException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :bedsCountException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :queenBedsCountException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :queenBedsCount integer,
      :singleOrTwinBedsCountException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :hypoallergenicBedding boolean,
      :featherPillows boolean,
      :memoryFoamPillowsException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :otherBedsCountException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :bunkBedsCount integer,
      :doubleBedsCountException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :otherBedsCount integer,
      :sofaBedsCount integer,
      :kingBedsCountException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :bedsCount integer,
      :featherPillowsException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :rollAwayBedsCountException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :singleOrTwinBedsCount integer,
      :sofaBedsCountException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK]},
     :accessibility
     {:hearingAccessibleDoorbellException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :adaCompliantUnit boolean,
      :mobilityAccessibleUnitException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :hearingAccessibleUnit boolean,
      :mobilityAccessibleShowerException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :mobilityAccessibleShower boolean,
      :mobilityAccessibleBathtubException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :mobilityAccessibleToilet boolean,
      :hearingAccessibleFireAlarm boolean,
      :hearingAccessibleFireAlarmException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :hearingAccessibleDoorbell boolean,
      :mobilityAccessibleBathtub boolean,
      :mobilityAccessibleUnit boolean,
      :mobilityAccessibleToiletException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :hearingAccessibleUnitException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK],
      :adaCompliantUnitException
      [EXCEPTION_UNSPECIFIED
       UNDER_CONSTRUCTION
       DEPENDENT_ON_SEASON
       DEPENDENT_ON_DAY_OF_WEEK]}},
    :maxChildOccupantsCountException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :executiveFloorException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :suiteException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :bungalowOrVilla boolean,
    :maxAdultOccupantsCount integer,
    :maxChildOccupantsCount integer,
    :tierException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :connectingUnitAvailable boolean,
    :connectingUnitAvailableException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :maxOccupantsCountException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :executiveFloor boolean,
    :privateHomeException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK],
    :suite boolean,
    :maxOccupantsCount integer,
    :views
    {:valleyViewException
     [EXCEPTION_UNSPECIFIED
      UNDER_CONSTRUCTION
      DEPENDENT_ON_SEASON
      DEPENDENT_ON_DAY_OF_WEEK],
     :cityViewException
     [EXCEPTION_UNSPECIFIED
      UNDER_CONSTRUCTION
      DEPENDENT_ON_SEASON
      DEPENDENT_ON_DAY_OF_WEEK],
     :lakeView boolean,
     :poolView boolean,
     :beachViewException
     [EXCEPTION_UNSPECIFIED
      UNDER_CONSTRUCTION
      DEPENDENT_ON_SEASON
      DEPENDENT_ON_DAY_OF_WEEK],
     :valleyView boolean,
     :landmarkViewException
     [EXCEPTION_UNSPECIFIED
      UNDER_CONSTRUCTION
      DEPENDENT_ON_SEASON
      DEPENDENT_ON_DAY_OF_WEEK],
     :lakeViewException
     [EXCEPTION_UNSPECIFIED
      UNDER_CONSTRUCTION
      DEPENDENT_ON_SEASON
      DEPENDENT_ON_DAY_OF_WEEK],
     :landmarkView boolean,
     :gardenViewException
     [EXCEPTION_UNSPECIFIED
      UNDER_CONSTRUCTION
      DEPENDENT_ON_SEASON
      DEPENDENT_ON_DAY_OF_WEEK],
     :cityView boolean,
     :oceanViewException
     [EXCEPTION_UNSPECIFIED
      UNDER_CONSTRUCTION
      DEPENDENT_ON_SEASON
      DEPENDENT_ON_DAY_OF_WEEK],
     :poolViewException
     [EXCEPTION_UNSPECIFIED
      UNDER_CONSTRUCTION
      DEPENDENT_ON_SEASON
      DEPENDENT_ON_DAY_OF_WEEK],
     :oceanView boolean,
     :gardenView boolean,
     :beachView boolean}}}],
 :business
 {:businessCenter boolean,
  :businessCenterException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :meetingRooms boolean,
  :meetingRoomsException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :meetingRoomsCount integer,
  :meetingRoomsCountException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK]},
 :activities
 {:watercraftRentalException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :beachAccessException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :golfException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :watercraftRental boolean,
  :tennis boolean,
  :scuba boolean,
  :beachFrontException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :gameRoomException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :nightclubException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :tennisException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :waterSkiingException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :casino boolean,
  :nightclub boolean,
  :privateBeachException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :casinoException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :boutiqueStores boolean,
  :beachAccess boolean,
  :freeBicycleRentalException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :bicycleRental boolean,
  :privateBeach boolean,
  :freeBicycleRental boolean,
  :beachFront boolean,
  :gameRoom boolean,
  :boutiqueStoresException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :freeWatercraftRental boolean,
  :freeWatercraftRentalException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :snorkeling boolean,
  :horsebackRidingException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :snorkelingException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :bicycleRentalException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :golf boolean,
  :waterSkiing boolean,
  :scubaException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :horsebackRiding boolean},
 :metadata {:updateTime string},
 :services
 {:wakeUpCalls boolean,
  :fullServiceLaundry boolean,
  :convenienceStore boolean,
  :fullServiceLaundryException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :socialHour boolean,
  :elevatorException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :twentyFourHourFrontDesk boolean,
  :languagesSpoken
  [{:languageCode string,
    :spoken boolean,
    :spokenException
    [EXCEPTION_UNSPECIFIED
     UNDER_CONSTRUCTION
     DEPENDENT_ON_SEASON
     DEPENDENT_ON_DAY_OF_WEEK]}],
  :baggageStorage boolean,
  :twentyFourHourFrontDeskException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :currencyExchangeException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :giftShopException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :wakeUpCallsException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :frontDeskException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :convenienceStoreException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :baggageStorageException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :selfServiceLaundryException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :concierge boolean,
  :selfServiceLaundry boolean,
  :conciergeException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :elevator boolean,
  :frontDesk boolean,
  :giftShop boolean,
  :currencyExchange boolean,
  :socialHourException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK]},
 :families
 {:babysitting boolean,
  :babysittingException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :kidsActivities boolean,
  :kidsActivitiesException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :kidsClub boolean,
  :kidsClubException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK],
  :kidsFriendly boolean,
  :kidsFriendlyException
  [EXCEPTION_UNSPECIFIED
   UNDER_CONSTRUCTION
   DEPENDENT_ON_SEASON
   DEPENDENT_ON_DAY_OF_WEEK]}}

optional:
updateMask <string> Required. The specific fields to update. Use \"*\" to update all fields, which may include unsetting empty fields in the request. Repeated field items cannot be individually updated."
  ([name Lodging] (locations-updateLodging name Lodging nil))
  ([name Lodging optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://mybusinesslodging.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes nil,
       :body Lodging})))

(defn locations-lodging-getGoogleUpdated
  "Returns the Google updated Lodging of a specific location.
https://developers.google.com/my-business

name <string> Required. Google identifier for this location in the form: `locations/{location_id}/lodging`

optional:
readMask <string> Required. The specific fields to return. Use \"*\" to include all fields. Repeated field items cannot be individually specified."
  ([name] (locations-lodging-getGoogleUpdated name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://mybusinesslodging.googleapis.com/v1/{+name}:getGoogleUpdated",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes nil})))

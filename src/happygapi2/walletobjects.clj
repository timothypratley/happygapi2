(ns happygapi2.walletobjects
  "Google Wallet API
API for issuers to save and manage Google Wallet Objects.
See: https://developers.google.com/wallet"
  (:require [happy.oauth2.client :as client]))

(defn eventticketobject-get
  "Returns the event ticket object with the given object ID.
https://developers.google.com/wallet/reference/rest/v1/eventticketobject/get

resourceId <string> The unique identifier for an object. This ID must be unique across all objects from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'."
  [resourceId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/eventTicketObject/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}))

(defn eventticketobject-insert
  "Inserts an event ticket object with the given ID and properties.
https://developers.google.com/wallet/reference/rest/v1/eventticketobject/insert

EventTicketObject:
{:faceValue {:micros string, :currencyCode string, :kind string},
 :hasUsers boolean,
 :smartTapRedemptionValue string,
 :reservationInfo {:confirmationCode string, :kind string},
 :rotatingBarcode
 {:totpDetails
  {:periodMillis string,
   :algorithm [TOTP_ALGORITHM_UNSPECIFIED TOTP_SHA1],
   :parameters [{:valueLength integer, :key string}]},
  :alternateText string,
  :initialRotatingBarcodeValues
  {:startDateTime string, :values [string], :periodMillis string},
  :valuePattern string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :barcode
 {:kind string,
  :alternateText string,
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :value string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :hasLinkedDevice boolean,
 :seatInfo
 {:gate
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :row
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :seat
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :section
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :kind string},
 :groupingInfo {:groupingId string, :sortIndex integer},
 :ticketType
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :state
 [STATE_UNSPECIFIED
  ACTIVE
  active
  COMPLETED
  completed
  EXPIRED
  expired
  INACTIVE
  inactive],
 :classReference
 {:wordMark
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :eventName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :reviewStatus
  [REVIEW_STATUS_UNSPECIFIED
   UNDER_REVIEW
   underReview
   APPROVED
   approved
   REJECTED
   rejected
   DRAFT
   draft],
  :rowLabel [ROW_LABEL_UNSPECIFIED ROW row],
  :textModulesData
  [{:header string,
    :id string,
    :localizedHeader
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :localizedBody
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :body string}],
  :issuerName string,
  :logo
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :wideLogo
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :securityAnimation
  {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
  :multipleDevicesAndHoldersAllowedStatus
  [STATUS_UNSPECIFIED
   MULTIPLE_HOLDERS
   ONE_USER_ALL_DEVICES
   ONE_USER_ONE_DEVICE
   multipleHolders
   oneUserAllDevices
   oneUserOneDevice],
  :homepageUri
  {:description string,
   :kind string,
   :id string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :customSeatLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :customSectionLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :callbackOptions {:updateRequestUrl string, :url string},
  :linksModuleData
  {:uris
   [{:description string,
     :kind string,
     :id string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string}]},
  :imageModulesData
  [{:id string,
    :mainImage
    {:contentDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :sourceUri
     {:description string,
      :localizedDescription LocalizedString,
      :uri string},
     :kind string}}],
  :eventId string,
  :locations [{:longitude number, :kind string, :latitude number}],
  :dateTime
  {:end string,
   :kind string,
   :start string,
   :doorsOpenLabel
   [DOORS_OPEN_LABEL_UNSPECIFIED
    DOORS_OPEN
    doorsOpen
    GATES_OPEN
    gatesOpen],
   :doorsOpen string,
   :customDoorsOpenLabel
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}}},
  :allowMultipleUsersPerObject boolean,
  :hexBackgroundColor string,
  :messages
  [{:kind string,
    :displayInterval
    {:start {:date string}, :kind string, :end {:date string}},
    :body string,
    :localizedBody
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :id string,
    :messageType
    [MESSAGE_TYPE_UNSPECIFIED
     TEXT
     text
     EXPIRATION_NOTIFICATION
     expirationNotification
     TEXT_AND_NOTIFY],
    :localizedHeader
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :header string}],
  :sectionLabel
  [SECTION_LABEL_UNSPECIFIED SECTION section THEATER theater],
  :localizedIssuerName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :redemptionIssuers [string],
  :review {:comments string},
  :id string,
  :kind string,
  :venue
  {:address
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :name
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :kind string},
  :customRowLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :finePrint
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :gateLabel
  [GATE_LABEL_UNSPECIFIED GATE gate DOOR door ENTRANCE entrance],
  :seatLabel [SEAT_LABEL_UNSPECIFIED SEAT seat],
  :customConfirmationCodeLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :appLinkData
  {:androidAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}},
   :webAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}},
   :iosAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}}},
  :confirmationCodeLabel
  [CONFIRMATION_CODE_LABEL_UNSPECIFIED
   CONFIRMATION_CODE
   confirmationCode
   CONFIRMATION_NUMBER
   confirmationNumber
   ORDER_NUMBER
   orderNumber
   RESERVATION_NUMBER
   reservationNumber],
  :classTemplateInfo
  {:detailsTemplateOverride {:detailsItemInfos [{:item TemplateItem}]},
   :listTemplateOverride
   {:firstRowOption
    {:transitOption
     [TRANSIT_OPTION_UNSPECIFIED
      ORIGIN_AND_DESTINATION_NAMES
      originAndDestinationNames
      ORIGIN_AND_DESTINATION_CODES
      originAndDestinationCodes
      ORIGIN_NAME
      originName],
     :fieldOption FieldSelector},
    :secondRowOption {:fields [FieldReference]},
    :thirdRowOption {:fields [FieldReference]}},
   :cardTemplateOverride
   {:cardRowTemplateInfos
    [{:oneItem CardRowOneItem,
      :twoItems CardRowTwoItems,
      :threeItems CardRowThreeItems}]},
   :cardBarcodeSectionDetails
   {:firstTopDetail {:fieldSelector FieldSelector},
    :secondTopDetail {:fieldSelector FieldSelector},
    :firstBottomDetail {:fieldSelector FieldSelector}}},
  :enableSmartTap boolean,
  :version string,
  :viewUnlockRequirement
  [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
   UNLOCK_NOT_REQUIRED
   UNLOCK_REQUIRED_TO_VIEW],
  :customGateLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :infoModuleData
  {:showLastUpdateTime boolean,
   :labelValueRows
   [{:columns
     [{:localizedLabel LocalizedString,
       :localizedValue LocalizedString,
       :label string,
       :value string}]}]},
  :heroImage
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :countryCode string},
 :disableExpirationNotification boolean,
 :linkedOfferIds [string],
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :validTimeInterval
 {:start {:date string}, :kind string, :end {:date string}},
 :locations [{:longitude number, :kind string, :latitude number}],
 :hexBackgroundColor string,
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :ticketNumber string,
 :id string,
 :kind string,
 :classId string,
 :passConstraints
 {:nfcConstraint
  [[NFC_CONSTRAINT_UNSPECIFIED
    BLOCK_PAYMENT
    BLOCK_CLOSED_LOOP_TRANSIT]],
  :screenshotEligibility
  [SCREENSHOT_ELIGIBILITY_UNSPECIFIED ELIGIBLE INELIGIBLE]},
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :version string,
 :infoModuleData
 {:showLastUpdateTime boolean,
  :labelValueRows
  [{:columns
    [{:localizedLabel
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :localizedValue
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :label string,
      :value string}]}]},
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :ticketHolderName string}"
  [EventTicketObject]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/eventTicketObject",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body EventTicketObject}))

(defn eventticketobject-update
  "Updates the event ticket object referenced by the given object ID.
https://developers.google.com/wallet/reference/rest/v1/eventticketobject/update

resourceId <string> The unique identifier for an object. This ID must be unique across all objects from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
EventTicketObject:
{:faceValue {:micros string, :currencyCode string, :kind string},
 :hasUsers boolean,
 :smartTapRedemptionValue string,
 :reservationInfo {:confirmationCode string, :kind string},
 :rotatingBarcode
 {:totpDetails
  {:periodMillis string,
   :algorithm [TOTP_ALGORITHM_UNSPECIFIED TOTP_SHA1],
   :parameters [{:valueLength integer, :key string}]},
  :alternateText string,
  :initialRotatingBarcodeValues
  {:startDateTime string, :values [string], :periodMillis string},
  :valuePattern string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :barcode
 {:kind string,
  :alternateText string,
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :value string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :hasLinkedDevice boolean,
 :seatInfo
 {:gate
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :row
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :seat
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :section
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :kind string},
 :groupingInfo {:groupingId string, :sortIndex integer},
 :ticketType
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :state
 [STATE_UNSPECIFIED
  ACTIVE
  active
  COMPLETED
  completed
  EXPIRED
  expired
  INACTIVE
  inactive],
 :classReference
 {:wordMark
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :eventName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :reviewStatus
  [REVIEW_STATUS_UNSPECIFIED
   UNDER_REVIEW
   underReview
   APPROVED
   approved
   REJECTED
   rejected
   DRAFT
   draft],
  :rowLabel [ROW_LABEL_UNSPECIFIED ROW row],
  :textModulesData
  [{:header string,
    :id string,
    :localizedHeader
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :localizedBody
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :body string}],
  :issuerName string,
  :logo
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :wideLogo
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :securityAnimation
  {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
  :multipleDevicesAndHoldersAllowedStatus
  [STATUS_UNSPECIFIED
   MULTIPLE_HOLDERS
   ONE_USER_ALL_DEVICES
   ONE_USER_ONE_DEVICE
   multipleHolders
   oneUserAllDevices
   oneUserOneDevice],
  :homepageUri
  {:description string,
   :kind string,
   :id string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :customSeatLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :customSectionLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :callbackOptions {:updateRequestUrl string, :url string},
  :linksModuleData
  {:uris
   [{:description string,
     :kind string,
     :id string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string}]},
  :imageModulesData
  [{:id string,
    :mainImage
    {:contentDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :sourceUri
     {:description string,
      :localizedDescription LocalizedString,
      :uri string},
     :kind string}}],
  :eventId string,
  :locations [{:longitude number, :kind string, :latitude number}],
  :dateTime
  {:end string,
   :kind string,
   :start string,
   :doorsOpenLabel
   [DOORS_OPEN_LABEL_UNSPECIFIED
    DOORS_OPEN
    doorsOpen
    GATES_OPEN
    gatesOpen],
   :doorsOpen string,
   :customDoorsOpenLabel
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}}},
  :allowMultipleUsersPerObject boolean,
  :hexBackgroundColor string,
  :messages
  [{:kind string,
    :displayInterval
    {:start {:date string}, :kind string, :end {:date string}},
    :body string,
    :localizedBody
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :id string,
    :messageType
    [MESSAGE_TYPE_UNSPECIFIED
     TEXT
     text
     EXPIRATION_NOTIFICATION
     expirationNotification
     TEXT_AND_NOTIFY],
    :localizedHeader
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :header string}],
  :sectionLabel
  [SECTION_LABEL_UNSPECIFIED SECTION section THEATER theater],
  :localizedIssuerName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :redemptionIssuers [string],
  :review {:comments string},
  :id string,
  :kind string,
  :venue
  {:address
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :name
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :kind string},
  :customRowLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :finePrint
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :gateLabel
  [GATE_LABEL_UNSPECIFIED GATE gate DOOR door ENTRANCE entrance],
  :seatLabel [SEAT_LABEL_UNSPECIFIED SEAT seat],
  :customConfirmationCodeLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :appLinkData
  {:androidAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}},
   :webAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}},
   :iosAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}}},
  :confirmationCodeLabel
  [CONFIRMATION_CODE_LABEL_UNSPECIFIED
   CONFIRMATION_CODE
   confirmationCode
   CONFIRMATION_NUMBER
   confirmationNumber
   ORDER_NUMBER
   orderNumber
   RESERVATION_NUMBER
   reservationNumber],
  :classTemplateInfo
  {:detailsTemplateOverride {:detailsItemInfos [{:item TemplateItem}]},
   :listTemplateOverride
   {:firstRowOption
    {:transitOption
     [TRANSIT_OPTION_UNSPECIFIED
      ORIGIN_AND_DESTINATION_NAMES
      originAndDestinationNames
      ORIGIN_AND_DESTINATION_CODES
      originAndDestinationCodes
      ORIGIN_NAME
      originName],
     :fieldOption FieldSelector},
    :secondRowOption {:fields [FieldReference]},
    :thirdRowOption {:fields [FieldReference]}},
   :cardTemplateOverride
   {:cardRowTemplateInfos
    [{:oneItem CardRowOneItem,
      :twoItems CardRowTwoItems,
      :threeItems CardRowThreeItems}]},
   :cardBarcodeSectionDetails
   {:firstTopDetail {:fieldSelector FieldSelector},
    :secondTopDetail {:fieldSelector FieldSelector},
    :firstBottomDetail {:fieldSelector FieldSelector}}},
  :enableSmartTap boolean,
  :version string,
  :viewUnlockRequirement
  [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
   UNLOCK_NOT_REQUIRED
   UNLOCK_REQUIRED_TO_VIEW],
  :customGateLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :infoModuleData
  {:showLastUpdateTime boolean,
   :labelValueRows
   [{:columns
     [{:localizedLabel LocalizedString,
       :localizedValue LocalizedString,
       :label string,
       :value string}]}]},
  :heroImage
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :countryCode string},
 :disableExpirationNotification boolean,
 :linkedOfferIds [string],
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :validTimeInterval
 {:start {:date string}, :kind string, :end {:date string}},
 :locations [{:longitude number, :kind string, :latitude number}],
 :hexBackgroundColor string,
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :ticketNumber string,
 :id string,
 :kind string,
 :classId string,
 :passConstraints
 {:nfcConstraint
  [[NFC_CONSTRAINT_UNSPECIFIED
    BLOCK_PAYMENT
    BLOCK_CLOSED_LOOP_TRANSIT]],
  :screenshotEligibility
  [SCREENSHOT_ELIGIBILITY_UNSPECIFIED ELIGIBLE INELIGIBLE]},
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :version string,
 :infoModuleData
 {:showLastUpdateTime boolean,
  :labelValueRows
  [{:columns
    [{:localizedLabel
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :localizedValue
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :label string,
      :value string}]}]},
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :ticketHolderName string}"
  [resourceId EventTicketObject]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/eventTicketObject/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body EventTicketObject}))

(defn eventticketobject-addmessage
  "Adds a message to the event ticket object referenced by the given object ID.
https://developers.google.com/wallet/reference/rest/v1/eventticketobject/addmessage

resourceId <string> The unique identifier for an object. This ID must be unique across all objects from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
AddMessageRequest:
{:message
 {:kind string,
  :displayInterval
  {:start {:date string}, :kind string, :end {:date string}},
  :body string,
  :localizedBody
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :id string,
  :messageType
  [MESSAGE_TYPE_UNSPECIFIED
   TEXT
   text
   EXPIRATION_NOTIFICATION
   expirationNotification
   TEXT_AND_NOTIFY],
  :localizedHeader
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :header string}}"
  [resourceId AddMessageRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/eventTicketObject/{resourceId}/addMessage",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body AddMessageRequest}))

(defn eventticketobject-list
  "Returns a list of all event ticket objects for a given issuer ID.
https://developers.google.com/wallet/reference/rest/v1/eventticketobject/list

optional:
maxResults <integer> Identifies the max number of results returned by a list. All results are returned if `maxResults` isn't defined.
classId <string> The ID of the class whose objects will be listed.
token <string> Used to get the next set of results if `maxResults` is specified, but more than `maxResults` objects are available in a list. For example, if you have a list of 200 objects and you call list with `maxResults` set to 20, list will return the first 20 objects and a token. Call list again with `maxResults` set to 20 and the token to get the next 20 objects."
  ([] (eventticketobject-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://walletobjects.googleapis.com/walletobjects/v1/eventTicketObject",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/wallet_object.issuer"]})))

(defn eventticketobject-patch
  "Updates the event ticket object referenced by the given object ID. This method supports patch semantics.
https://developers.google.com/wallet/reference/rest/v1/eventticketobject/patch

resourceId <string> The unique identifier for an object. This ID must be unique across all objects from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
EventTicketObject:
{:faceValue {:micros string, :currencyCode string, :kind string},
 :hasUsers boolean,
 :smartTapRedemptionValue string,
 :reservationInfo {:confirmationCode string, :kind string},
 :rotatingBarcode
 {:totpDetails
  {:periodMillis string,
   :algorithm [TOTP_ALGORITHM_UNSPECIFIED TOTP_SHA1],
   :parameters [{:valueLength integer, :key string}]},
  :alternateText string,
  :initialRotatingBarcodeValues
  {:startDateTime string, :values [string], :periodMillis string},
  :valuePattern string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :barcode
 {:kind string,
  :alternateText string,
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :value string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :hasLinkedDevice boolean,
 :seatInfo
 {:gate
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :row
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :seat
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :section
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :kind string},
 :groupingInfo {:groupingId string, :sortIndex integer},
 :ticketType
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :state
 [STATE_UNSPECIFIED
  ACTIVE
  active
  COMPLETED
  completed
  EXPIRED
  expired
  INACTIVE
  inactive],
 :classReference
 {:wordMark
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :eventName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :reviewStatus
  [REVIEW_STATUS_UNSPECIFIED
   UNDER_REVIEW
   underReview
   APPROVED
   approved
   REJECTED
   rejected
   DRAFT
   draft],
  :rowLabel [ROW_LABEL_UNSPECIFIED ROW row],
  :textModulesData
  [{:header string,
    :id string,
    :localizedHeader
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :localizedBody
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :body string}],
  :issuerName string,
  :logo
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :wideLogo
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :securityAnimation
  {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
  :multipleDevicesAndHoldersAllowedStatus
  [STATUS_UNSPECIFIED
   MULTIPLE_HOLDERS
   ONE_USER_ALL_DEVICES
   ONE_USER_ONE_DEVICE
   multipleHolders
   oneUserAllDevices
   oneUserOneDevice],
  :homepageUri
  {:description string,
   :kind string,
   :id string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :customSeatLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :customSectionLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :callbackOptions {:updateRequestUrl string, :url string},
  :linksModuleData
  {:uris
   [{:description string,
     :kind string,
     :id string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string}]},
  :imageModulesData
  [{:id string,
    :mainImage
    {:contentDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :sourceUri
     {:description string,
      :localizedDescription LocalizedString,
      :uri string},
     :kind string}}],
  :eventId string,
  :locations [{:longitude number, :kind string, :latitude number}],
  :dateTime
  {:end string,
   :kind string,
   :start string,
   :doorsOpenLabel
   [DOORS_OPEN_LABEL_UNSPECIFIED
    DOORS_OPEN
    doorsOpen
    GATES_OPEN
    gatesOpen],
   :doorsOpen string,
   :customDoorsOpenLabel
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}}},
  :allowMultipleUsersPerObject boolean,
  :hexBackgroundColor string,
  :messages
  [{:kind string,
    :displayInterval
    {:start {:date string}, :kind string, :end {:date string}},
    :body string,
    :localizedBody
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :id string,
    :messageType
    [MESSAGE_TYPE_UNSPECIFIED
     TEXT
     text
     EXPIRATION_NOTIFICATION
     expirationNotification
     TEXT_AND_NOTIFY],
    :localizedHeader
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :header string}],
  :sectionLabel
  [SECTION_LABEL_UNSPECIFIED SECTION section THEATER theater],
  :localizedIssuerName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :redemptionIssuers [string],
  :review {:comments string},
  :id string,
  :kind string,
  :venue
  {:address
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :name
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :kind string},
  :customRowLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :finePrint
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :gateLabel
  [GATE_LABEL_UNSPECIFIED GATE gate DOOR door ENTRANCE entrance],
  :seatLabel [SEAT_LABEL_UNSPECIFIED SEAT seat],
  :customConfirmationCodeLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :appLinkData
  {:androidAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}},
   :webAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}},
   :iosAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}}},
  :confirmationCodeLabel
  [CONFIRMATION_CODE_LABEL_UNSPECIFIED
   CONFIRMATION_CODE
   confirmationCode
   CONFIRMATION_NUMBER
   confirmationNumber
   ORDER_NUMBER
   orderNumber
   RESERVATION_NUMBER
   reservationNumber],
  :classTemplateInfo
  {:detailsTemplateOverride {:detailsItemInfos [{:item TemplateItem}]},
   :listTemplateOverride
   {:firstRowOption
    {:transitOption
     [TRANSIT_OPTION_UNSPECIFIED
      ORIGIN_AND_DESTINATION_NAMES
      originAndDestinationNames
      ORIGIN_AND_DESTINATION_CODES
      originAndDestinationCodes
      ORIGIN_NAME
      originName],
     :fieldOption FieldSelector},
    :secondRowOption {:fields [FieldReference]},
    :thirdRowOption {:fields [FieldReference]}},
   :cardTemplateOverride
   {:cardRowTemplateInfos
    [{:oneItem CardRowOneItem,
      :twoItems CardRowTwoItems,
      :threeItems CardRowThreeItems}]},
   :cardBarcodeSectionDetails
   {:firstTopDetail {:fieldSelector FieldSelector},
    :secondTopDetail {:fieldSelector FieldSelector},
    :firstBottomDetail {:fieldSelector FieldSelector}}},
  :enableSmartTap boolean,
  :version string,
  :viewUnlockRequirement
  [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
   UNLOCK_NOT_REQUIRED
   UNLOCK_REQUIRED_TO_VIEW],
  :customGateLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :infoModuleData
  {:showLastUpdateTime boolean,
   :labelValueRows
   [{:columns
     [{:localizedLabel LocalizedString,
       :localizedValue LocalizedString,
       :label string,
       :value string}]}]},
  :heroImage
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :countryCode string},
 :disableExpirationNotification boolean,
 :linkedOfferIds [string],
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :validTimeInterval
 {:start {:date string}, :kind string, :end {:date string}},
 :locations [{:longitude number, :kind string, :latitude number}],
 :hexBackgroundColor string,
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :ticketNumber string,
 :id string,
 :kind string,
 :classId string,
 :passConstraints
 {:nfcConstraint
  [[NFC_CONSTRAINT_UNSPECIFIED
    BLOCK_PAYMENT
    BLOCK_CLOSED_LOOP_TRANSIT]],
  :screenshotEligibility
  [SCREENSHOT_ELIGIBILITY_UNSPECIFIED ELIGIBLE INELIGIBLE]},
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :version string,
 :infoModuleData
 {:showLastUpdateTime boolean,
  :labelValueRows
  [{:columns
    [{:localizedLabel
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :localizedValue
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :label string,
      :value string}]}]},
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :ticketHolderName string}"
  [resourceId EventTicketObject]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/eventTicketObject/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body EventTicketObject}))

(defn eventticketobject-modifylinkedofferobjects
  "Modifies linked offer objects for the event ticket object with the given ID.
https://developers.google.com/wallet/reference/rest/v1/eventticketobject/modifylinkedofferobjects

resourceId <string> The unique identifier for an object. This ID must be unique across all objects from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
ModifyLinkedOfferObjectsRequest:
{:linkedOfferObjectIds
 {:removeLinkedOfferObjectIds [string],
  :addLinkedOfferObjectIds [string]}}"
  [resourceId ModifyLinkedOfferObjectsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/eventTicketObject/{resourceId}/modifyLinkedOfferObjects",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body ModifyLinkedOfferObjectsRequest}))

(defn offerclass-patch
  "Updates the offer class referenced by the given class ID. This method supports patch semantics.
https://developers.google.com/wallet/reference/rest/v1/offerclass/patch

resourceId <string> The unique identifier for a class. This ID must be unique across all classes from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
OfferClass:
{:helpUri
 {:description string,
  :kind string,
  :id string,
  :localizedDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :uri string},
 :wordMark
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :reviewStatus
 [REVIEW_STATUS_UNSPECIFIED
  UNDER_REVIEW
  underReview
  APPROVED
  approved
  REJECTED
  rejected
  DRAFT
  draft],
 :localizedFinePrint
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :issuerName string,
 :localizedTitle
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :redemptionChannel
 [REDEMPTION_CHANNEL_UNSPECIFIED
  INSTORE
  instore
  ONLINE
  online
  BOTH
  both
  TEMPORARY_PRICE_REDUCTION
  temporaryPriceReduction],
 :securityAnimation
 {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
 :multipleDevicesAndHoldersAllowedStatus
 [STATUS_UNSPECIFIED
  MULTIPLE_HOLDERS
  ONE_USER_ALL_DEVICES
  ONE_USER_ONE_DEVICE
  multipleHolders
  oneUserAllDevices
  oneUserOneDevice],
 :localizedProvider
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :homepageUri
 {:description string,
  :kind string,
  :id string,
  :localizedDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :uri string},
 :titleImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :callbackOptions {:updateRequestUrl string, :url string},
 :title string,
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :locations [{:longitude number, :kind string, :latitude number}],
 :allowMultipleUsersPerObject boolean,
 :hexBackgroundColor string,
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :localizedIssuerName
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :details string,
 :redemptionIssuers [string],
 :review {:comments string},
 :localizedShortTitle
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :wideTitleImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :id string,
 :kind string,
 :finePrint string,
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :classTemplateInfo
 {:detailsTemplateOverride
  {:detailsItemInfos
   [{:item
     {:firstValue FieldSelector,
      :predefinedItem
      [PREDEFINED_ITEM_UNSPECIFIED
       FREQUENT_FLYER_PROGRAM_NAME_AND_NUMBER
       frequentFlyerProgramNameAndNumber
       FLIGHT_NUMBER_AND_OPERATING_FLIGHT_NUMBER
       flightNumberAndOperatingFlightNumber],
      :secondValue FieldSelector}}]},
  :listTemplateOverride
  {:firstRowOption
   {:transitOption
    [TRANSIT_OPTION_UNSPECIFIED
     ORIGIN_AND_DESTINATION_NAMES
     originAndDestinationNames
     ORIGIN_AND_DESTINATION_CODES
     originAndDestinationCodes
     ORIGIN_NAME
     originName],
    :fieldOption {:fields [FieldReference]}},
   :secondRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]},
   :thirdRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]}},
  :cardTemplateOverride
  {:cardRowTemplateInfos
   [{:oneItem {:item TemplateItem},
     :twoItems {:endItem TemplateItem, :startItem TemplateItem},
     :threeItems
     {:startItem TemplateItem,
      :middleItem TemplateItem,
      :endItem TemplateItem}}]},
  :cardBarcodeSectionDetails
  {:firstTopDetail {:fieldSelector {:fields [FieldReference]}},
   :secondTopDetail {:fieldSelector {:fields [FieldReference]}},
   :firstBottomDetail {:fieldSelector {:fields [FieldReference]}}}},
 :shortTitle string,
 :enableSmartTap boolean,
 :version string,
 :viewUnlockRequirement
 [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
  UNLOCK_NOT_REQUIRED
  UNLOCK_REQUIRED_TO_VIEW],
 :infoModuleData
 {:showLastUpdateTime boolean,
  :labelValueRows
  [{:columns
    [{:localizedLabel
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :localizedValue
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :label string,
      :value string}]}]},
 :provider string,
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :localizedDetails
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :countryCode string}"
  [resourceId OfferClass]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/offerClass/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body OfferClass}))

(defn offerclass-addmessage
  "Adds a message to the offer class referenced by the given class ID.
https://developers.google.com/wallet/reference/rest/v1/offerclass/addmessage

resourceId <string> The unique identifier for a class. This ID must be unique across all classes from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
AddMessageRequest:
{:message
 {:kind string,
  :displayInterval
  {:start {:date string}, :kind string, :end {:date string}},
  :body string,
  :localizedBody
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :id string,
  :messageType
  [MESSAGE_TYPE_UNSPECIFIED
   TEXT
   text
   EXPIRATION_NOTIFICATION
   expirationNotification
   TEXT_AND_NOTIFY],
  :localizedHeader
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :header string}}"
  [resourceId AddMessageRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/offerClass/{resourceId}/addMessage",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body AddMessageRequest}))

(defn offerclass-insert
  "Inserts an offer class with the given ID and properties.
https://developers.google.com/wallet/reference/rest/v1/offerclass/insert

OfferClass:
{:helpUri
 {:description string,
  :kind string,
  :id string,
  :localizedDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :uri string},
 :wordMark
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :reviewStatus
 [REVIEW_STATUS_UNSPECIFIED
  UNDER_REVIEW
  underReview
  APPROVED
  approved
  REJECTED
  rejected
  DRAFT
  draft],
 :localizedFinePrint
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :issuerName string,
 :localizedTitle
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :redemptionChannel
 [REDEMPTION_CHANNEL_UNSPECIFIED
  INSTORE
  instore
  ONLINE
  online
  BOTH
  both
  TEMPORARY_PRICE_REDUCTION
  temporaryPriceReduction],
 :securityAnimation
 {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
 :multipleDevicesAndHoldersAllowedStatus
 [STATUS_UNSPECIFIED
  MULTIPLE_HOLDERS
  ONE_USER_ALL_DEVICES
  ONE_USER_ONE_DEVICE
  multipleHolders
  oneUserAllDevices
  oneUserOneDevice],
 :localizedProvider
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :homepageUri
 {:description string,
  :kind string,
  :id string,
  :localizedDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :uri string},
 :titleImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :callbackOptions {:updateRequestUrl string, :url string},
 :title string,
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :locations [{:longitude number, :kind string, :latitude number}],
 :allowMultipleUsersPerObject boolean,
 :hexBackgroundColor string,
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :localizedIssuerName
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :details string,
 :redemptionIssuers [string],
 :review {:comments string},
 :localizedShortTitle
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :wideTitleImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :id string,
 :kind string,
 :finePrint string,
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :classTemplateInfo
 {:detailsTemplateOverride
  {:detailsItemInfos
   [{:item
     {:firstValue FieldSelector,
      :predefinedItem
      [PREDEFINED_ITEM_UNSPECIFIED
       FREQUENT_FLYER_PROGRAM_NAME_AND_NUMBER
       frequentFlyerProgramNameAndNumber
       FLIGHT_NUMBER_AND_OPERATING_FLIGHT_NUMBER
       flightNumberAndOperatingFlightNumber],
      :secondValue FieldSelector}}]},
  :listTemplateOverride
  {:firstRowOption
   {:transitOption
    [TRANSIT_OPTION_UNSPECIFIED
     ORIGIN_AND_DESTINATION_NAMES
     originAndDestinationNames
     ORIGIN_AND_DESTINATION_CODES
     originAndDestinationCodes
     ORIGIN_NAME
     originName],
    :fieldOption {:fields [FieldReference]}},
   :secondRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]},
   :thirdRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]}},
  :cardTemplateOverride
  {:cardRowTemplateInfos
   [{:oneItem {:item TemplateItem},
     :twoItems {:endItem TemplateItem, :startItem TemplateItem},
     :threeItems
     {:startItem TemplateItem,
      :middleItem TemplateItem,
      :endItem TemplateItem}}]},
  :cardBarcodeSectionDetails
  {:firstTopDetail {:fieldSelector {:fields [FieldReference]}},
   :secondTopDetail {:fieldSelector {:fields [FieldReference]}},
   :firstBottomDetail {:fieldSelector {:fields [FieldReference]}}}},
 :shortTitle string,
 :enableSmartTap boolean,
 :version string,
 :viewUnlockRequirement
 [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
  UNLOCK_NOT_REQUIRED
  UNLOCK_REQUIRED_TO_VIEW],
 :infoModuleData
 {:showLastUpdateTime boolean,
  :labelValueRows
  [{:columns
    [{:localizedLabel
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :localizedValue
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :label string,
      :value string}]}]},
 :provider string,
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :localizedDetails
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :countryCode string}"
  [OfferClass]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/offerClass",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body OfferClass}))

(defn offerclass-update
  "Updates the offer class referenced by the given class ID.
https://developers.google.com/wallet/reference/rest/v1/offerclass/update

resourceId <string> The unique identifier for a class. This ID must be unique across all classes from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
OfferClass:
{:helpUri
 {:description string,
  :kind string,
  :id string,
  :localizedDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :uri string},
 :wordMark
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :reviewStatus
 [REVIEW_STATUS_UNSPECIFIED
  UNDER_REVIEW
  underReview
  APPROVED
  approved
  REJECTED
  rejected
  DRAFT
  draft],
 :localizedFinePrint
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :issuerName string,
 :localizedTitle
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :redemptionChannel
 [REDEMPTION_CHANNEL_UNSPECIFIED
  INSTORE
  instore
  ONLINE
  online
  BOTH
  both
  TEMPORARY_PRICE_REDUCTION
  temporaryPriceReduction],
 :securityAnimation
 {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
 :multipleDevicesAndHoldersAllowedStatus
 [STATUS_UNSPECIFIED
  MULTIPLE_HOLDERS
  ONE_USER_ALL_DEVICES
  ONE_USER_ONE_DEVICE
  multipleHolders
  oneUserAllDevices
  oneUserOneDevice],
 :localizedProvider
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :homepageUri
 {:description string,
  :kind string,
  :id string,
  :localizedDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :uri string},
 :titleImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :callbackOptions {:updateRequestUrl string, :url string},
 :title string,
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :locations [{:longitude number, :kind string, :latitude number}],
 :allowMultipleUsersPerObject boolean,
 :hexBackgroundColor string,
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :localizedIssuerName
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :details string,
 :redemptionIssuers [string],
 :review {:comments string},
 :localizedShortTitle
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :wideTitleImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :id string,
 :kind string,
 :finePrint string,
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :classTemplateInfo
 {:detailsTemplateOverride
  {:detailsItemInfos
   [{:item
     {:firstValue FieldSelector,
      :predefinedItem
      [PREDEFINED_ITEM_UNSPECIFIED
       FREQUENT_FLYER_PROGRAM_NAME_AND_NUMBER
       frequentFlyerProgramNameAndNumber
       FLIGHT_NUMBER_AND_OPERATING_FLIGHT_NUMBER
       flightNumberAndOperatingFlightNumber],
      :secondValue FieldSelector}}]},
  :listTemplateOverride
  {:firstRowOption
   {:transitOption
    [TRANSIT_OPTION_UNSPECIFIED
     ORIGIN_AND_DESTINATION_NAMES
     originAndDestinationNames
     ORIGIN_AND_DESTINATION_CODES
     originAndDestinationCodes
     ORIGIN_NAME
     originName],
    :fieldOption {:fields [FieldReference]}},
   :secondRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]},
   :thirdRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]}},
  :cardTemplateOverride
  {:cardRowTemplateInfos
   [{:oneItem {:item TemplateItem},
     :twoItems {:endItem TemplateItem, :startItem TemplateItem},
     :threeItems
     {:startItem TemplateItem,
      :middleItem TemplateItem,
      :endItem TemplateItem}}]},
  :cardBarcodeSectionDetails
  {:firstTopDetail {:fieldSelector {:fields [FieldReference]}},
   :secondTopDetail {:fieldSelector {:fields [FieldReference]}},
   :firstBottomDetail {:fieldSelector {:fields [FieldReference]}}}},
 :shortTitle string,
 :enableSmartTap boolean,
 :version string,
 :viewUnlockRequirement
 [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
  UNLOCK_NOT_REQUIRED
  UNLOCK_REQUIRED_TO_VIEW],
 :infoModuleData
 {:showLastUpdateTime boolean,
  :labelValueRows
  [{:columns
    [{:localizedLabel
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :localizedValue
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :label string,
      :value string}]}]},
 :provider string,
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :localizedDetails
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :countryCode string}"
  [resourceId OfferClass]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/offerClass/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body OfferClass}))

(defn offerclass-list
  "Returns a list of all offer classes for a given issuer ID.
https://developers.google.com/wallet/reference/rest/v1/offerclass/list

optional:
issuerId <string> The ID of the issuer authorized to list classes.
token <string> Used to get the next set of results if `maxResults` is specified, but more than `maxResults` classes are available in a list. For example, if you have a list of 200 classes and you call list with `maxResults` set to 20, list will return the first 20 classes and a token. Call list again with `maxResults` set to 20 and the token to get the next 20 classes.
maxResults <integer> Identifies the max number of results returned by a list. All results are returned if `maxResults` isn't defined."
  ([] (offerclass-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://walletobjects.googleapis.com/walletobjects/v1/offerClass",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/wallet_object.issuer"]})))

(defn offerclass-get
  "Returns the offer class with the given class ID.
https://developers.google.com/wallet/reference/rest/v1/offerclass/get

resourceId <string> The unique identifier for a class. This ID must be unique across all classes from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'."
  [resourceId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/offerClass/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}))

(defn permissions-update
  "Updates the permissions for the given issuer.
https://developers.google.com/wallet/reference/rest/v1/permissions/update

resourceId <string> The unique identifier for an issuer. This ID must be unique across all issuers.
Permissions:
{:permissions
 [{:emailAddress string,
   :role [ROLE_UNSPECIFIED OWNER owner READER reader WRITER writer]}],
 :issuerId string}"
  [resourceId Permissions]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/permissions/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body Permissions}))

(defn permissions-get
  "Returns the permissions for the given issuer id.
https://developers.google.com/wallet/reference/rest/v1/permissions/get

resourceId <string> The unique identifier for an issuer. This ID must be unique across all issuers."
  [resourceId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/permissions/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}))

(defn loyaltyclass-addmessage
  "Adds a message to the loyalty class referenced by the given class ID.
https://developers.google.com/wallet/reference/rest/v1/loyaltyclass/addmessage

resourceId <string> The unique identifier for a class. This ID must be unique across all classes from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
AddMessageRequest:
{:message
 {:kind string,
  :displayInterval
  {:start {:date string}, :kind string, :end {:date string}},
  :body string,
  :localizedBody
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :id string,
  :messageType
  [MESSAGE_TYPE_UNSPECIFIED
   TEXT
   text
   EXPIRATION_NOTIFICATION
   expirationNotification
   TEXT_AND_NOTIFY],
  :localizedHeader
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :header string}}"
  [resourceId AddMessageRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/loyaltyClass/{resourceId}/addMessage",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body AddMessageRequest}))

(defn loyaltyclass-patch
  "Updates the loyalty class referenced by the given class ID. This method supports patch semantics.
https://developers.google.com/wallet/reference/rest/v1/loyaltyclass/patch

resourceId <string> The unique identifier for a class. This ID must be unique across all classes from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
LoyaltyClass:
{:localizedAccountIdLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :wordMark
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :reviewStatus
 [REVIEW_STATUS_UNSPECIFIED
  UNDER_REVIEW
  underReview
  APPROVED
  approved
  REJECTED
  rejected
  DRAFT
  draft],
 :localizedRewardsTier
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :wideProgramLogo
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :issuerName string,
 :discoverableProgram
 {:merchantSigninInfo
  {:signinWebsite
   {:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string}},
  :state
  [STATE_UNSPECIFIED
   TRUSTED_TESTERS
   trustedTesters
   LIVE
   live
   DISABLED
   disabled],
  :merchantSignupInfo
  {:signupWebsite
   {:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :signupSharedDatas
   [[SHARED_DATA_TYPE_UNSPECIFIED
     FIRST_NAME
     LAST_NAME
     STREET_ADDRESS
     ADDRESS_LINE_1
     ADDRESS_LINE_2
     ADDRESS_LINE_3
     CITY
     STATE
     ZIPCODE
     COUNTRY
     EMAIL
     PHONE]]}},
 :localizedRewardsTierLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :securityAnimation
 {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
 :multipleDevicesAndHoldersAllowedStatus
 [STATUS_UNSPECIFIED
  MULTIPLE_HOLDERS
  ONE_USER_ALL_DEVICES
  ONE_USER_ONE_DEVICE
  multipleHolders
  oneUserAllDevices
  oneUserOneDevice],
 :homepageUri
 {:description string,
  :kind string,
  :id string,
  :localizedDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :uri string},
 :secondaryRewardsTierLabel string,
 :accountNameLabel string,
 :rewardsTierLabel string,
 :callbackOptions {:updateRequestUrl string, :url string},
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :localizedSecondaryRewardsTier
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :secondaryRewardsTier string,
 :locations [{:longitude number, :kind string, :latitude number}],
 :rewardsTier string,
 :allowMultipleUsersPerObject boolean,
 :hexBackgroundColor string,
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :localizedIssuerName
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :redemptionIssuers [string],
 :review {:comments string},
 :programLogo
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :id string,
 :kind string,
 :localizedSecondaryRewardsTierLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :localizedAccountNameLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :programName string,
 :classTemplateInfo
 {:detailsTemplateOverride
  {:detailsItemInfos
   [{:item
     {:firstValue FieldSelector,
      :predefinedItem
      [PREDEFINED_ITEM_UNSPECIFIED
       FREQUENT_FLYER_PROGRAM_NAME_AND_NUMBER
       frequentFlyerProgramNameAndNumber
       FLIGHT_NUMBER_AND_OPERATING_FLIGHT_NUMBER
       flightNumberAndOperatingFlightNumber],
      :secondValue FieldSelector}}]},
  :listTemplateOverride
  {:firstRowOption
   {:transitOption
    [TRANSIT_OPTION_UNSPECIFIED
     ORIGIN_AND_DESTINATION_NAMES
     originAndDestinationNames
     ORIGIN_AND_DESTINATION_CODES
     originAndDestinationCodes
     ORIGIN_NAME
     originName],
    :fieldOption {:fields [FieldReference]}},
   :secondRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]},
   :thirdRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]}},
  :cardTemplateOverride
  {:cardRowTemplateInfos
   [{:oneItem {:item TemplateItem},
     :twoItems {:endItem TemplateItem, :startItem TemplateItem},
     :threeItems
     {:startItem TemplateItem,
      :middleItem TemplateItem,
      :endItem TemplateItem}}]},
  :cardBarcodeSectionDetails
  {:firstTopDetail {:fieldSelector {:fields [FieldReference]}},
   :secondTopDetail {:fieldSelector {:fields [FieldReference]}},
   :firstBottomDetail {:fieldSelector {:fields [FieldReference]}}}},
 :enableSmartTap boolean,
 :version string,
 :viewUnlockRequirement
 [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
  UNLOCK_NOT_REQUIRED
  UNLOCK_REQUIRED_TO_VIEW],
 :infoModuleData
 {:showLastUpdateTime boolean,
  :labelValueRows
  [{:columns
    [{:localizedLabel
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :localizedValue
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :label string,
      :value string}]}]},
 :localizedProgramName
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :accountIdLabel string,
 :countryCode string}"
  [resourceId LoyaltyClass]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/loyaltyClass/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body LoyaltyClass}))

(defn loyaltyclass-update
  "Updates the loyalty class referenced by the given class ID.
https://developers.google.com/wallet/reference/rest/v1/loyaltyclass/update

resourceId <string> The unique identifier for a class. This ID must be unique across all classes from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
LoyaltyClass:
{:localizedAccountIdLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :wordMark
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :reviewStatus
 [REVIEW_STATUS_UNSPECIFIED
  UNDER_REVIEW
  underReview
  APPROVED
  approved
  REJECTED
  rejected
  DRAFT
  draft],
 :localizedRewardsTier
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :wideProgramLogo
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :issuerName string,
 :discoverableProgram
 {:merchantSigninInfo
  {:signinWebsite
   {:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string}},
  :state
  [STATE_UNSPECIFIED
   TRUSTED_TESTERS
   trustedTesters
   LIVE
   live
   DISABLED
   disabled],
  :merchantSignupInfo
  {:signupWebsite
   {:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :signupSharedDatas
   [[SHARED_DATA_TYPE_UNSPECIFIED
     FIRST_NAME
     LAST_NAME
     STREET_ADDRESS
     ADDRESS_LINE_1
     ADDRESS_LINE_2
     ADDRESS_LINE_3
     CITY
     STATE
     ZIPCODE
     COUNTRY
     EMAIL
     PHONE]]}},
 :localizedRewardsTierLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :securityAnimation
 {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
 :multipleDevicesAndHoldersAllowedStatus
 [STATUS_UNSPECIFIED
  MULTIPLE_HOLDERS
  ONE_USER_ALL_DEVICES
  ONE_USER_ONE_DEVICE
  multipleHolders
  oneUserAllDevices
  oneUserOneDevice],
 :homepageUri
 {:description string,
  :kind string,
  :id string,
  :localizedDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :uri string},
 :secondaryRewardsTierLabel string,
 :accountNameLabel string,
 :rewardsTierLabel string,
 :callbackOptions {:updateRequestUrl string, :url string},
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :localizedSecondaryRewardsTier
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :secondaryRewardsTier string,
 :locations [{:longitude number, :kind string, :latitude number}],
 :rewardsTier string,
 :allowMultipleUsersPerObject boolean,
 :hexBackgroundColor string,
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :localizedIssuerName
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :redemptionIssuers [string],
 :review {:comments string},
 :programLogo
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :id string,
 :kind string,
 :localizedSecondaryRewardsTierLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :localizedAccountNameLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :programName string,
 :classTemplateInfo
 {:detailsTemplateOverride
  {:detailsItemInfos
   [{:item
     {:firstValue FieldSelector,
      :predefinedItem
      [PREDEFINED_ITEM_UNSPECIFIED
       FREQUENT_FLYER_PROGRAM_NAME_AND_NUMBER
       frequentFlyerProgramNameAndNumber
       FLIGHT_NUMBER_AND_OPERATING_FLIGHT_NUMBER
       flightNumberAndOperatingFlightNumber],
      :secondValue FieldSelector}}]},
  :listTemplateOverride
  {:firstRowOption
   {:transitOption
    [TRANSIT_OPTION_UNSPECIFIED
     ORIGIN_AND_DESTINATION_NAMES
     originAndDestinationNames
     ORIGIN_AND_DESTINATION_CODES
     originAndDestinationCodes
     ORIGIN_NAME
     originName],
    :fieldOption {:fields [FieldReference]}},
   :secondRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]},
   :thirdRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]}},
  :cardTemplateOverride
  {:cardRowTemplateInfos
   [{:oneItem {:item TemplateItem},
     :twoItems {:endItem TemplateItem, :startItem TemplateItem},
     :threeItems
     {:startItem TemplateItem,
      :middleItem TemplateItem,
      :endItem TemplateItem}}]},
  :cardBarcodeSectionDetails
  {:firstTopDetail {:fieldSelector {:fields [FieldReference]}},
   :secondTopDetail {:fieldSelector {:fields [FieldReference]}},
   :firstBottomDetail {:fieldSelector {:fields [FieldReference]}}}},
 :enableSmartTap boolean,
 :version string,
 :viewUnlockRequirement
 [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
  UNLOCK_NOT_REQUIRED
  UNLOCK_REQUIRED_TO_VIEW],
 :infoModuleData
 {:showLastUpdateTime boolean,
  :labelValueRows
  [{:columns
    [{:localizedLabel
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :localizedValue
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :label string,
      :value string}]}]},
 :localizedProgramName
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :accountIdLabel string,
 :countryCode string}"
  [resourceId LoyaltyClass]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/loyaltyClass/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body LoyaltyClass}))

(defn loyaltyclass-get
  "Returns the loyalty class with the given class ID.
https://developers.google.com/wallet/reference/rest/v1/loyaltyclass/get

resourceId <string> The unique identifier for a class. This ID must be unique across all classes from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'."
  [resourceId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/loyaltyClass/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}))

(defn loyaltyclass-list
  "Returns a list of all loyalty classes for a given issuer ID.
https://developers.google.com/wallet/reference/rest/v1/loyaltyclass/list

optional:
issuerId <string> The ID of the issuer authorized to list classes.
token <string> Used to get the next set of results if `maxResults` is specified, but more than `maxResults` classes are available in a list. For example, if you have a list of 200 classes and you call list with `maxResults` set to 20, list will return the first 20 classes and a token. Call list again with `maxResults` set to 20 and the token to get the next 20 classes.
maxResults <integer> Identifies the max number of results returned by a list. All results are returned if `maxResults` isn't defined."
  ([] (loyaltyclass-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://walletobjects.googleapis.com/walletobjects/v1/loyaltyClass",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/wallet_object.issuer"]})))

(defn loyaltyclass-insert
  "Inserts an loyalty class with the given ID and properties.
https://developers.google.com/wallet/reference/rest/v1/loyaltyclass/insert

LoyaltyClass:
{:localizedAccountIdLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :wordMark
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :reviewStatus
 [REVIEW_STATUS_UNSPECIFIED
  UNDER_REVIEW
  underReview
  APPROVED
  approved
  REJECTED
  rejected
  DRAFT
  draft],
 :localizedRewardsTier
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :wideProgramLogo
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :issuerName string,
 :discoverableProgram
 {:merchantSigninInfo
  {:signinWebsite
   {:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string}},
  :state
  [STATE_UNSPECIFIED
   TRUSTED_TESTERS
   trustedTesters
   LIVE
   live
   DISABLED
   disabled],
  :merchantSignupInfo
  {:signupWebsite
   {:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :signupSharedDatas
   [[SHARED_DATA_TYPE_UNSPECIFIED
     FIRST_NAME
     LAST_NAME
     STREET_ADDRESS
     ADDRESS_LINE_1
     ADDRESS_LINE_2
     ADDRESS_LINE_3
     CITY
     STATE
     ZIPCODE
     COUNTRY
     EMAIL
     PHONE]]}},
 :localizedRewardsTierLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :securityAnimation
 {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
 :multipleDevicesAndHoldersAllowedStatus
 [STATUS_UNSPECIFIED
  MULTIPLE_HOLDERS
  ONE_USER_ALL_DEVICES
  ONE_USER_ONE_DEVICE
  multipleHolders
  oneUserAllDevices
  oneUserOneDevice],
 :homepageUri
 {:description string,
  :kind string,
  :id string,
  :localizedDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :uri string},
 :secondaryRewardsTierLabel string,
 :accountNameLabel string,
 :rewardsTierLabel string,
 :callbackOptions {:updateRequestUrl string, :url string},
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :localizedSecondaryRewardsTier
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :secondaryRewardsTier string,
 :locations [{:longitude number, :kind string, :latitude number}],
 :rewardsTier string,
 :allowMultipleUsersPerObject boolean,
 :hexBackgroundColor string,
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :localizedIssuerName
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :redemptionIssuers [string],
 :review {:comments string},
 :programLogo
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :id string,
 :kind string,
 :localizedSecondaryRewardsTierLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :localizedAccountNameLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :programName string,
 :classTemplateInfo
 {:detailsTemplateOverride
  {:detailsItemInfos
   [{:item
     {:firstValue FieldSelector,
      :predefinedItem
      [PREDEFINED_ITEM_UNSPECIFIED
       FREQUENT_FLYER_PROGRAM_NAME_AND_NUMBER
       frequentFlyerProgramNameAndNumber
       FLIGHT_NUMBER_AND_OPERATING_FLIGHT_NUMBER
       flightNumberAndOperatingFlightNumber],
      :secondValue FieldSelector}}]},
  :listTemplateOverride
  {:firstRowOption
   {:transitOption
    [TRANSIT_OPTION_UNSPECIFIED
     ORIGIN_AND_DESTINATION_NAMES
     originAndDestinationNames
     ORIGIN_AND_DESTINATION_CODES
     originAndDestinationCodes
     ORIGIN_NAME
     originName],
    :fieldOption {:fields [FieldReference]}},
   :secondRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]},
   :thirdRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]}},
  :cardTemplateOverride
  {:cardRowTemplateInfos
   [{:oneItem {:item TemplateItem},
     :twoItems {:endItem TemplateItem, :startItem TemplateItem},
     :threeItems
     {:startItem TemplateItem,
      :middleItem TemplateItem,
      :endItem TemplateItem}}]},
  :cardBarcodeSectionDetails
  {:firstTopDetail {:fieldSelector {:fields [FieldReference]}},
   :secondTopDetail {:fieldSelector {:fields [FieldReference]}},
   :firstBottomDetail {:fieldSelector {:fields [FieldReference]}}}},
 :enableSmartTap boolean,
 :version string,
 :viewUnlockRequirement
 [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
  UNLOCK_NOT_REQUIRED
  UNLOCK_REQUIRED_TO_VIEW],
 :infoModuleData
 {:showLastUpdateTime boolean,
  :labelValueRows
  [{:columns
    [{:localizedLabel
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :localizedValue
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :label string,
      :value string}]}]},
 :localizedProgramName
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :accountIdLabel string,
 :countryCode string}"
  [LoyaltyClass]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/loyaltyClass",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body LoyaltyClass}))

(defn transitobject-get
  "Returns the transit object with the given object ID.
https://developers.google.com/wallet/reference/rest/v1/transitobject/get

resourceId <string> The unique identifier for an object. This ID must be unique across all objects from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'."
  [resourceId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/transitObject/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}))

(defn transitobject-update
  "Updates the transit object referenced by the given object ID.
https://developers.google.com/wallet/reference/rest/v1/transitobject/update

resourceId <string> The unique identifier for an object. This ID must be unique across all objects from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
TransitObject:
{:ticketStatus
 [TICKET_STATUS_UNSPECIFIED
  USED
  used
  REFUNDED
  refunded
  EXCHANGED
  exchanged],
 :purchaseDetails
 {:accountId string,
  :confirmationCode string,
  :purchaseReceiptNumber string,
  :purchaseDateTime string,
  :ticketCost
  {:purchasePrice {:micros string, :currencyCode string, :kind string},
   :faceValue {:micros string, :currencyCode string, :kind string},
   :discountMessage
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}}}},
 :ticketLegs
 [{:originName
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :destinationName
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :zone string,
   :originStationCode string,
   :transitOperatorName
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :ticketSeats
   [{:coach string,
     :seat string,
     :fareClass
     [FARE_CLASS_UNSPECIFIED
      ECONOMY
      economy
      FIRST
      first
      BUSINESS
      business],
     :customFareClass
     {:translatedValues
      [{:value string, :language string, :kind string}],
      :kind string,
      :defaultValue {:value string, :language string, :kind string}},
     :seatAssignment
     {:translatedValues
      [{:value string, :language string, :kind string}],
      :kind string,
      :defaultValue {:value string, :language string, :kind string}}}],
   :transitTerminusName
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :destinationStationCode string,
   :arrivalDateTime string,
   :departureDateTime string,
   :ticketSeat
   {:coach string,
    :seat string,
    :fareClass
    [FARE_CLASS_UNSPECIFIED
     ECONOMY
     economy
     FIRST
     first
     BUSINESS
     business],
    :customFareClass
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :seatAssignment
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}}},
   :fareName
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :platform string,
   :carriage string}],
 :hasUsers boolean,
 :smartTapRedemptionValue string,
 :rotatingBarcode
 {:totpDetails
  {:periodMillis string,
   :algorithm [TOTP_ALGORITHM_UNSPECIFIED TOTP_SHA1],
   :parameters [{:valueLength integer, :key string}]},
  :alternateText string,
  :initialRotatingBarcodeValues
  {:startDateTime string, :values [string], :periodMillis string},
  :valuePattern string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :tripType [TRIP_TYPE_UNSPECIFIED ROUND_TRIP roundTrip ONE_WAY oneWay],
 :barcode
 {:kind string,
  :alternateText string,
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :value string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :passengerType
 [PASSENGER_TYPE_UNSPECIFIED
  SINGLE_PASSENGER
  singlePassenger
  MULTIPLE_PASSENGERS
  multiplePassengers],
 :hasLinkedDevice boolean,
 :groupingInfo {:groupingId string, :sortIndex integer},
 :state
 [STATE_UNSPECIFIED
  ACTIVE
  active
  COMPLETED
  completed
  EXPIRED
  expired
  INACTIVE
  inactive],
 :customConcessionCategory
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :classReference
 {:wordMark
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :transitType
  [TRANSIT_TYPE_UNSPECIFIED
   BUS
   bus
   RAIL
   rail
   TRAM
   tram
   FERRY
   ferry
   OTHER
   other],
  :customFareNameLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :customDiscountMessageLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :customPlatformLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :reviewStatus
  [REVIEW_STATUS_UNSPECIFIED
   UNDER_REVIEW
   underReview
   APPROVED
   approved
   REJECTED
   rejected
   DRAFT
   draft],
  :customRouteRestrictionsDetailsLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :customCarriageLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :textModulesData
  [{:header string,
    :id string,
    :localizedHeader
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :localizedBody
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :body string}],
  :issuerName string,
  :customZoneLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :customFareClassLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :customPurchaseReceiptNumberLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :logo
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :activationOptions
  {:activationUrl string, :allowReactivation boolean},
  :enableSingleLegItinerary boolean,
  :wideLogo
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :securityAnimation
  {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
  :multipleDevicesAndHoldersAllowedStatus
  [STATUS_UNSPECIFIED
   MULTIPLE_HOLDERS
   ONE_USER_ALL_DEVICES
   ONE_USER_ONE_DEVICE
   multipleHolders
   oneUserAllDevices
   oneUserOneDevice],
  :transitOperatorName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :homepageUri
  {:description string,
   :kind string,
   :id string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :customConcessionCategoryLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :customSeatLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :customTransitTerminusNameLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :callbackOptions {:updateRequestUrl string, :url string},
  :linksModuleData
  {:uris
   [{:description string,
     :kind string,
     :id string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string}]},
  :imageModulesData
  [{:id string,
    :mainImage
    {:contentDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :sourceUri
     {:description string,
      :localizedDescription LocalizedString,
      :uri string},
     :kind string}}],
  :customRouteRestrictionsLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :locations [{:longitude number, :kind string, :latitude number}],
  :allowMultipleUsersPerObject boolean,
  :hexBackgroundColor string,
  :customTimeRestrictionsLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :customOtherRestrictionsLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :messages
  [{:kind string,
    :displayInterval
    {:start {:date string}, :kind string, :end {:date string}},
    :body string,
    :localizedBody
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :id string,
    :messageType
    [MESSAGE_TYPE_UNSPECIFIED
     TEXT
     text
     EXPIRATION_NOTIFICATION
     expirationNotification
     TEXT_AND_NOTIFY],
    :localizedHeader
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :header string}],
  :localizedIssuerName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :redemptionIssuers [string],
  :review {:comments string},
  :id string,
  :customPurchaseFaceValueLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :customConfirmationCodeLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :appLinkData
  {:androidAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}},
   :webAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}},
   :iosAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}}},
  :customCoachLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :classTemplateInfo
  {:detailsTemplateOverride {:detailsItemInfos [{:item TemplateItem}]},
   :listTemplateOverride
   {:firstRowOption
    {:transitOption
     [TRANSIT_OPTION_UNSPECIFIED
      ORIGIN_AND_DESTINATION_NAMES
      originAndDestinationNames
      ORIGIN_AND_DESTINATION_CODES
      originAndDestinationCodes
      ORIGIN_NAME
      originName],
     :fieldOption FieldSelector},
    :secondRowOption {:fields [FieldReference]},
    :thirdRowOption {:fields [FieldReference]}},
   :cardTemplateOverride
   {:cardRowTemplateInfos
    [{:oneItem CardRowOneItem,
      :twoItems CardRowTwoItems,
      :threeItems CardRowThreeItems}]},
   :cardBarcodeSectionDetails
   {:firstTopDetail {:fieldSelector FieldSelector},
    :secondTopDetail {:fieldSelector FieldSelector},
    :firstBottomDetail {:fieldSelector FieldSelector}}},
  :enableSmartTap boolean,
  :version string,
  :customPurchasePriceLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :viewUnlockRequirement
  [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
   UNLOCK_NOT_REQUIRED
   UNLOCK_REQUIRED_TO_VIEW],
  :infoModuleData
  {:showLastUpdateTime boolean,
   :labelValueRows
   [{:columns
     [{:localizedLabel LocalizedString,
       :localizedValue LocalizedString,
       :label string,
       :value string}]}]},
  :heroImage
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :watermark
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :countryCode string,
  :customTicketNumberLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :languageOverride string},
 :disableExpirationNotification boolean,
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :ticketLeg
 {:originName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :destinationName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :zone string,
  :originStationCode string,
  :transitOperatorName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :ticketSeats
  [{:coach string,
    :seat string,
    :fareClass
    [FARE_CLASS_UNSPECIFIED
     ECONOMY
     economy
     FIRST
     first
     BUSINESS
     business],
    :customFareClass
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :seatAssignment
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}}}],
  :transitTerminusName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :destinationStationCode string,
  :arrivalDateTime string,
  :departureDateTime string,
  :ticketSeat
  {:coach string,
   :seat string,
   :fareClass
   [FARE_CLASS_UNSPECIFIED
    ECONOMY
    economy
    FIRST
    first
    BUSINESS
    business],
   :customFareClass
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :seatAssignment
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}}},
  :fareName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :platform string,
  :carriage string},
 :validTimeInterval
 {:start {:date string}, :kind string, :end {:date string}},
 :locations [{:longitude number, :kind string, :latitude number}],
 :hexBackgroundColor string,
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :ticketNumber string,
 :id string,
 :classId string,
 :passConstraints
 {:nfcConstraint
  [[NFC_CONSTRAINT_UNSPECIFIED
    BLOCK_PAYMENT
    BLOCK_CLOSED_LOOP_TRANSIT]],
  :screenshotEligibility
  [SCREENSHOT_ELIGIBILITY_UNSPECIFIED ELIGIBLE INELIGIBLE]},
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :concessionCategory
 [CONCESSION_CATEGORY_UNSPECIFIED
  ADULT
  adult
  CHILD
  child
  SENIOR
  senior],
 :passengerNames string,
 :ticketRestrictions
 {:timeRestrictions
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :routeRestrictions
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :routeRestrictionsDetails
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :otherRestrictions
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}}},
 :tripId string,
 :version string,
 :deviceContext {:deviceToken string},
 :infoModuleData
 {:showLastUpdateTime boolean,
  :labelValueRows
  [{:columns
    [{:localizedLabel
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :localizedValue
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :label string,
      :value string}]}]},
 :customTicketStatus
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :activationStatus
 {:state
  [UNKNOWN_STATE NOT_ACTIVATED not_activated ACTIVATED activated]}}"
  [resourceId TransitObject]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/transitObject/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body TransitObject}))

(defn transitobject-insert
  "Inserts an transit object with the given ID and properties.
https://developers.google.com/wallet/reference/rest/v1/transitobject/insert

TransitObject:
{:ticketStatus
 [TICKET_STATUS_UNSPECIFIED
  USED
  used
  REFUNDED
  refunded
  EXCHANGED
  exchanged],
 :purchaseDetails
 {:accountId string,
  :confirmationCode string,
  :purchaseReceiptNumber string,
  :purchaseDateTime string,
  :ticketCost
  {:purchasePrice {:micros string, :currencyCode string, :kind string},
   :faceValue {:micros string, :currencyCode string, :kind string},
   :discountMessage
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}}}},
 :ticketLegs
 [{:originName
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :destinationName
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :zone string,
   :originStationCode string,
   :transitOperatorName
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :ticketSeats
   [{:coach string,
     :seat string,
     :fareClass
     [FARE_CLASS_UNSPECIFIED
      ECONOMY
      economy
      FIRST
      first
      BUSINESS
      business],
     :customFareClass
     {:translatedValues
      [{:value string, :language string, :kind string}],
      :kind string,
      :defaultValue {:value string, :language string, :kind string}},
     :seatAssignment
     {:translatedValues
      [{:value string, :language string, :kind string}],
      :kind string,
      :defaultValue {:value string, :language string, :kind string}}}],
   :transitTerminusName
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :destinationStationCode string,
   :arrivalDateTime string,
   :departureDateTime string,
   :ticketSeat
   {:coach string,
    :seat string,
    :fareClass
    [FARE_CLASS_UNSPECIFIED
     ECONOMY
     economy
     FIRST
     first
     BUSINESS
     business],
    :customFareClass
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :seatAssignment
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}}},
   :fareName
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :platform string,
   :carriage string}],
 :hasUsers boolean,
 :smartTapRedemptionValue string,
 :rotatingBarcode
 {:totpDetails
  {:periodMillis string,
   :algorithm [TOTP_ALGORITHM_UNSPECIFIED TOTP_SHA1],
   :parameters [{:valueLength integer, :key string}]},
  :alternateText string,
  :initialRotatingBarcodeValues
  {:startDateTime string, :values [string], :periodMillis string},
  :valuePattern string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :tripType [TRIP_TYPE_UNSPECIFIED ROUND_TRIP roundTrip ONE_WAY oneWay],
 :barcode
 {:kind string,
  :alternateText string,
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :value string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :passengerType
 [PASSENGER_TYPE_UNSPECIFIED
  SINGLE_PASSENGER
  singlePassenger
  MULTIPLE_PASSENGERS
  multiplePassengers],
 :hasLinkedDevice boolean,
 :groupingInfo {:groupingId string, :sortIndex integer},
 :state
 [STATE_UNSPECIFIED
  ACTIVE
  active
  COMPLETED
  completed
  EXPIRED
  expired
  INACTIVE
  inactive],
 :customConcessionCategory
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :classReference
 {:wordMark
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :transitType
  [TRANSIT_TYPE_UNSPECIFIED
   BUS
   bus
   RAIL
   rail
   TRAM
   tram
   FERRY
   ferry
   OTHER
   other],
  :customFareNameLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :customDiscountMessageLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :customPlatformLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :reviewStatus
  [REVIEW_STATUS_UNSPECIFIED
   UNDER_REVIEW
   underReview
   APPROVED
   approved
   REJECTED
   rejected
   DRAFT
   draft],
  :customRouteRestrictionsDetailsLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :customCarriageLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :textModulesData
  [{:header string,
    :id string,
    :localizedHeader
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :localizedBody
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :body string}],
  :issuerName string,
  :customZoneLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :customFareClassLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :customPurchaseReceiptNumberLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :logo
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :activationOptions
  {:activationUrl string, :allowReactivation boolean},
  :enableSingleLegItinerary boolean,
  :wideLogo
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :securityAnimation
  {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
  :multipleDevicesAndHoldersAllowedStatus
  [STATUS_UNSPECIFIED
   MULTIPLE_HOLDERS
   ONE_USER_ALL_DEVICES
   ONE_USER_ONE_DEVICE
   multipleHolders
   oneUserAllDevices
   oneUserOneDevice],
  :transitOperatorName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :homepageUri
  {:description string,
   :kind string,
   :id string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :customConcessionCategoryLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :customSeatLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :customTransitTerminusNameLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :callbackOptions {:updateRequestUrl string, :url string},
  :linksModuleData
  {:uris
   [{:description string,
     :kind string,
     :id string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string}]},
  :imageModulesData
  [{:id string,
    :mainImage
    {:contentDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :sourceUri
     {:description string,
      :localizedDescription LocalizedString,
      :uri string},
     :kind string}}],
  :customRouteRestrictionsLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :locations [{:longitude number, :kind string, :latitude number}],
  :allowMultipleUsersPerObject boolean,
  :hexBackgroundColor string,
  :customTimeRestrictionsLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :customOtherRestrictionsLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :messages
  [{:kind string,
    :displayInterval
    {:start {:date string}, :kind string, :end {:date string}},
    :body string,
    :localizedBody
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :id string,
    :messageType
    [MESSAGE_TYPE_UNSPECIFIED
     TEXT
     text
     EXPIRATION_NOTIFICATION
     expirationNotification
     TEXT_AND_NOTIFY],
    :localizedHeader
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :header string}],
  :localizedIssuerName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :redemptionIssuers [string],
  :review {:comments string},
  :id string,
  :customPurchaseFaceValueLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :customConfirmationCodeLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :appLinkData
  {:androidAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}},
   :webAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}},
   :iosAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}}},
  :customCoachLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :classTemplateInfo
  {:detailsTemplateOverride {:detailsItemInfos [{:item TemplateItem}]},
   :listTemplateOverride
   {:firstRowOption
    {:transitOption
     [TRANSIT_OPTION_UNSPECIFIED
      ORIGIN_AND_DESTINATION_NAMES
      originAndDestinationNames
      ORIGIN_AND_DESTINATION_CODES
      originAndDestinationCodes
      ORIGIN_NAME
      originName],
     :fieldOption FieldSelector},
    :secondRowOption {:fields [FieldReference]},
    :thirdRowOption {:fields [FieldReference]}},
   :cardTemplateOverride
   {:cardRowTemplateInfos
    [{:oneItem CardRowOneItem,
      :twoItems CardRowTwoItems,
      :threeItems CardRowThreeItems}]},
   :cardBarcodeSectionDetails
   {:firstTopDetail {:fieldSelector FieldSelector},
    :secondTopDetail {:fieldSelector FieldSelector},
    :firstBottomDetail {:fieldSelector FieldSelector}}},
  :enableSmartTap boolean,
  :version string,
  :customPurchasePriceLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :viewUnlockRequirement
  [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
   UNLOCK_NOT_REQUIRED
   UNLOCK_REQUIRED_TO_VIEW],
  :infoModuleData
  {:showLastUpdateTime boolean,
   :labelValueRows
   [{:columns
     [{:localizedLabel LocalizedString,
       :localizedValue LocalizedString,
       :label string,
       :value string}]}]},
  :heroImage
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :watermark
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :countryCode string,
  :customTicketNumberLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :languageOverride string},
 :disableExpirationNotification boolean,
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :ticketLeg
 {:originName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :destinationName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :zone string,
  :originStationCode string,
  :transitOperatorName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :ticketSeats
  [{:coach string,
    :seat string,
    :fareClass
    [FARE_CLASS_UNSPECIFIED
     ECONOMY
     economy
     FIRST
     first
     BUSINESS
     business],
    :customFareClass
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :seatAssignment
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}}}],
  :transitTerminusName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :destinationStationCode string,
  :arrivalDateTime string,
  :departureDateTime string,
  :ticketSeat
  {:coach string,
   :seat string,
   :fareClass
   [FARE_CLASS_UNSPECIFIED
    ECONOMY
    economy
    FIRST
    first
    BUSINESS
    business],
   :customFareClass
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :seatAssignment
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}}},
  :fareName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :platform string,
  :carriage string},
 :validTimeInterval
 {:start {:date string}, :kind string, :end {:date string}},
 :locations [{:longitude number, :kind string, :latitude number}],
 :hexBackgroundColor string,
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :ticketNumber string,
 :id string,
 :classId string,
 :passConstraints
 {:nfcConstraint
  [[NFC_CONSTRAINT_UNSPECIFIED
    BLOCK_PAYMENT
    BLOCK_CLOSED_LOOP_TRANSIT]],
  :screenshotEligibility
  [SCREENSHOT_ELIGIBILITY_UNSPECIFIED ELIGIBLE INELIGIBLE]},
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :concessionCategory
 [CONCESSION_CATEGORY_UNSPECIFIED
  ADULT
  adult
  CHILD
  child
  SENIOR
  senior],
 :passengerNames string,
 :ticketRestrictions
 {:timeRestrictions
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :routeRestrictions
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :routeRestrictionsDetails
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :otherRestrictions
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}}},
 :tripId string,
 :version string,
 :deviceContext {:deviceToken string},
 :infoModuleData
 {:showLastUpdateTime boolean,
  :labelValueRows
  [{:columns
    [{:localizedLabel
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :localizedValue
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :label string,
      :value string}]}]},
 :customTicketStatus
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :activationStatus
 {:state
  [UNKNOWN_STATE NOT_ACTIVATED not_activated ACTIVATED activated]}}"
  [TransitObject]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/transitObject",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body TransitObject}))

(defn transitobject-addmessage
  "Adds a message to the transit object referenced by the given object ID.
https://developers.google.com/wallet/reference/rest/v1/transitobject/addmessage

resourceId <string> The unique identifier for an object. This ID must be unique across all objects from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
AddMessageRequest:
{:message
 {:kind string,
  :displayInterval
  {:start {:date string}, :kind string, :end {:date string}},
  :body string,
  :localizedBody
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :id string,
  :messageType
  [MESSAGE_TYPE_UNSPECIFIED
   TEXT
   text
   EXPIRATION_NOTIFICATION
   expirationNotification
   TEXT_AND_NOTIFY],
  :localizedHeader
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :header string}}"
  [resourceId AddMessageRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/transitObject/{resourceId}/addMessage",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body AddMessageRequest}))

(defn transitobject-list
  "Returns a list of all transit objects for a given issuer ID.
https://developers.google.com/wallet/reference/rest/v1/transitobject/list

optional:
maxResults <integer> Identifies the max number of results returned by a list. All results are returned if `maxResults` isn't defined.
token <string> Used to get the next set of results if `maxResults` is specified, but more than `maxResults` objects are available in a list. For example, if you have a list of 200 objects and you call list with `maxResults` set to 20, list will return the first 20 objects and a token. Call list again with `maxResults` set to 20 and the token to get the next 20 objects.
classId <string> The ID of the class whose objects will be listed."
  ([] (transitobject-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://walletobjects.googleapis.com/walletobjects/v1/transitObject",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/wallet_object.issuer"]})))

(defn transitobject-patch
  "Updates the transit object referenced by the given object ID. This method supports patch semantics.
https://developers.google.com/wallet/reference/rest/v1/transitobject/patch

resourceId <string> The unique identifier for an object. This ID must be unique across all objects from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
TransitObject:
{:ticketStatus
 [TICKET_STATUS_UNSPECIFIED
  USED
  used
  REFUNDED
  refunded
  EXCHANGED
  exchanged],
 :purchaseDetails
 {:accountId string,
  :confirmationCode string,
  :purchaseReceiptNumber string,
  :purchaseDateTime string,
  :ticketCost
  {:purchasePrice {:micros string, :currencyCode string, :kind string},
   :faceValue {:micros string, :currencyCode string, :kind string},
   :discountMessage
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}}}},
 :ticketLegs
 [{:originName
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :destinationName
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :zone string,
   :originStationCode string,
   :transitOperatorName
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :ticketSeats
   [{:coach string,
     :seat string,
     :fareClass
     [FARE_CLASS_UNSPECIFIED
      ECONOMY
      economy
      FIRST
      first
      BUSINESS
      business],
     :customFareClass
     {:translatedValues
      [{:value string, :language string, :kind string}],
      :kind string,
      :defaultValue {:value string, :language string, :kind string}},
     :seatAssignment
     {:translatedValues
      [{:value string, :language string, :kind string}],
      :kind string,
      :defaultValue {:value string, :language string, :kind string}}}],
   :transitTerminusName
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :destinationStationCode string,
   :arrivalDateTime string,
   :departureDateTime string,
   :ticketSeat
   {:coach string,
    :seat string,
    :fareClass
    [FARE_CLASS_UNSPECIFIED
     ECONOMY
     economy
     FIRST
     first
     BUSINESS
     business],
    :customFareClass
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :seatAssignment
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}}},
   :fareName
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :platform string,
   :carriage string}],
 :hasUsers boolean,
 :smartTapRedemptionValue string,
 :rotatingBarcode
 {:totpDetails
  {:periodMillis string,
   :algorithm [TOTP_ALGORITHM_UNSPECIFIED TOTP_SHA1],
   :parameters [{:valueLength integer, :key string}]},
  :alternateText string,
  :initialRotatingBarcodeValues
  {:startDateTime string, :values [string], :periodMillis string},
  :valuePattern string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :tripType [TRIP_TYPE_UNSPECIFIED ROUND_TRIP roundTrip ONE_WAY oneWay],
 :barcode
 {:kind string,
  :alternateText string,
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :value string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :passengerType
 [PASSENGER_TYPE_UNSPECIFIED
  SINGLE_PASSENGER
  singlePassenger
  MULTIPLE_PASSENGERS
  multiplePassengers],
 :hasLinkedDevice boolean,
 :groupingInfo {:groupingId string, :sortIndex integer},
 :state
 [STATE_UNSPECIFIED
  ACTIVE
  active
  COMPLETED
  completed
  EXPIRED
  expired
  INACTIVE
  inactive],
 :customConcessionCategory
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :classReference
 {:wordMark
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :transitType
  [TRANSIT_TYPE_UNSPECIFIED
   BUS
   bus
   RAIL
   rail
   TRAM
   tram
   FERRY
   ferry
   OTHER
   other],
  :customFareNameLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :customDiscountMessageLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :customPlatformLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :reviewStatus
  [REVIEW_STATUS_UNSPECIFIED
   UNDER_REVIEW
   underReview
   APPROVED
   approved
   REJECTED
   rejected
   DRAFT
   draft],
  :customRouteRestrictionsDetailsLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :customCarriageLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :textModulesData
  [{:header string,
    :id string,
    :localizedHeader
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :localizedBody
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :body string}],
  :issuerName string,
  :customZoneLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :customFareClassLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :customPurchaseReceiptNumberLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :logo
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :activationOptions
  {:activationUrl string, :allowReactivation boolean},
  :enableSingleLegItinerary boolean,
  :wideLogo
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :securityAnimation
  {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
  :multipleDevicesAndHoldersAllowedStatus
  [STATUS_UNSPECIFIED
   MULTIPLE_HOLDERS
   ONE_USER_ALL_DEVICES
   ONE_USER_ONE_DEVICE
   multipleHolders
   oneUserAllDevices
   oneUserOneDevice],
  :transitOperatorName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :homepageUri
  {:description string,
   :kind string,
   :id string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :customConcessionCategoryLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :customSeatLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :customTransitTerminusNameLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :callbackOptions {:updateRequestUrl string, :url string},
  :linksModuleData
  {:uris
   [{:description string,
     :kind string,
     :id string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string}]},
  :imageModulesData
  [{:id string,
    :mainImage
    {:contentDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :sourceUri
     {:description string,
      :localizedDescription LocalizedString,
      :uri string},
     :kind string}}],
  :customRouteRestrictionsLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :locations [{:longitude number, :kind string, :latitude number}],
  :allowMultipleUsersPerObject boolean,
  :hexBackgroundColor string,
  :customTimeRestrictionsLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :customOtherRestrictionsLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :messages
  [{:kind string,
    :displayInterval
    {:start {:date string}, :kind string, :end {:date string}},
    :body string,
    :localizedBody
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :id string,
    :messageType
    [MESSAGE_TYPE_UNSPECIFIED
     TEXT
     text
     EXPIRATION_NOTIFICATION
     expirationNotification
     TEXT_AND_NOTIFY],
    :localizedHeader
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :header string}],
  :localizedIssuerName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :redemptionIssuers [string],
  :review {:comments string},
  :id string,
  :customPurchaseFaceValueLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :customConfirmationCodeLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :appLinkData
  {:androidAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}},
   :webAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}},
   :iosAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}}},
  :customCoachLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :classTemplateInfo
  {:detailsTemplateOverride {:detailsItemInfos [{:item TemplateItem}]},
   :listTemplateOverride
   {:firstRowOption
    {:transitOption
     [TRANSIT_OPTION_UNSPECIFIED
      ORIGIN_AND_DESTINATION_NAMES
      originAndDestinationNames
      ORIGIN_AND_DESTINATION_CODES
      originAndDestinationCodes
      ORIGIN_NAME
      originName],
     :fieldOption FieldSelector},
    :secondRowOption {:fields [FieldReference]},
    :thirdRowOption {:fields [FieldReference]}},
   :cardTemplateOverride
   {:cardRowTemplateInfos
    [{:oneItem CardRowOneItem,
      :twoItems CardRowTwoItems,
      :threeItems CardRowThreeItems}]},
   :cardBarcodeSectionDetails
   {:firstTopDetail {:fieldSelector FieldSelector},
    :secondTopDetail {:fieldSelector FieldSelector},
    :firstBottomDetail {:fieldSelector FieldSelector}}},
  :enableSmartTap boolean,
  :version string,
  :customPurchasePriceLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :viewUnlockRequirement
  [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
   UNLOCK_NOT_REQUIRED
   UNLOCK_REQUIRED_TO_VIEW],
  :infoModuleData
  {:showLastUpdateTime boolean,
   :labelValueRows
   [{:columns
     [{:localizedLabel LocalizedString,
       :localizedValue LocalizedString,
       :label string,
       :value string}]}]},
  :heroImage
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :watermark
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :countryCode string,
  :customTicketNumberLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :languageOverride string},
 :disableExpirationNotification boolean,
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :ticketLeg
 {:originName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :destinationName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :zone string,
  :originStationCode string,
  :transitOperatorName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :ticketSeats
  [{:coach string,
    :seat string,
    :fareClass
    [FARE_CLASS_UNSPECIFIED
     ECONOMY
     economy
     FIRST
     first
     BUSINESS
     business],
    :customFareClass
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :seatAssignment
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}}}],
  :transitTerminusName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :destinationStationCode string,
  :arrivalDateTime string,
  :departureDateTime string,
  :ticketSeat
  {:coach string,
   :seat string,
   :fareClass
   [FARE_CLASS_UNSPECIFIED
    ECONOMY
    economy
    FIRST
    first
    BUSINESS
    business],
   :customFareClass
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :seatAssignment
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}}},
  :fareName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :platform string,
  :carriage string},
 :validTimeInterval
 {:start {:date string}, :kind string, :end {:date string}},
 :locations [{:longitude number, :kind string, :latitude number}],
 :hexBackgroundColor string,
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :ticketNumber string,
 :id string,
 :classId string,
 :passConstraints
 {:nfcConstraint
  [[NFC_CONSTRAINT_UNSPECIFIED
    BLOCK_PAYMENT
    BLOCK_CLOSED_LOOP_TRANSIT]],
  :screenshotEligibility
  [SCREENSHOT_ELIGIBILITY_UNSPECIFIED ELIGIBLE INELIGIBLE]},
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :concessionCategory
 [CONCESSION_CATEGORY_UNSPECIFIED
  ADULT
  adult
  CHILD
  child
  SENIOR
  senior],
 :passengerNames string,
 :ticketRestrictions
 {:timeRestrictions
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :routeRestrictions
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :routeRestrictionsDetails
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :otherRestrictions
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}}},
 :tripId string,
 :version string,
 :deviceContext {:deviceToken string},
 :infoModuleData
 {:showLastUpdateTime boolean,
  :labelValueRows
  [{:columns
    [{:localizedLabel
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :localizedValue
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :label string,
      :value string}]}]},
 :customTicketStatus
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :activationStatus
 {:state
  [UNKNOWN_STATE NOT_ACTIVATED not_activated ACTIVATED activated]}}"
  [resourceId TransitObject]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/transitObject/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body TransitObject}))

(defn genericclass-addmessage
  "Adds a message to the generic class referenced by the given class ID.
https://developers.google.com/wallet/reference/rest/v1/genericclass/addmessage

resourceId <string> The unique identifier for a class. This ID must be unique across all classes from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
AddMessageRequest:
{:message
 {:kind string,
  :displayInterval
  {:start {:date string}, :kind string, :end {:date string}},
  :body string,
  :localizedBody
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :id string,
  :messageType
  [MESSAGE_TYPE_UNSPECIFIED
   TEXT
   text
   EXPIRATION_NOTIFICATION
   expirationNotification
   TEXT_AND_NOTIFY],
  :localizedHeader
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :header string}}"
  [resourceId AddMessageRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/genericClass/{resourceId}/addMessage",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body AddMessageRequest}))

(defn genericclass-insert
  "Inserts a generic class with the given ID and properties.
https://developers.google.com/wallet/reference/rest/v1/genericclass/insert

GenericClass:
{:textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :securityAnimation
 {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
 :multipleDevicesAndHoldersAllowedStatus
 [STATUS_UNSPECIFIED
  MULTIPLE_HOLDERS
  ONE_USER_ALL_DEVICES
  ONE_USER_ONE_DEVICE
  multipleHolders
  oneUserAllDevices
  oneUserOneDevice],
 :callbackOptions {:updateRequestUrl string, :url string},
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :redemptionIssuers [string],
 :id string,
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :classTemplateInfo
 {:detailsTemplateOverride
  {:detailsItemInfos
   [{:item
     {:firstValue FieldSelector,
      :predefinedItem
      [PREDEFINED_ITEM_UNSPECIFIED
       FREQUENT_FLYER_PROGRAM_NAME_AND_NUMBER
       frequentFlyerProgramNameAndNumber
       FLIGHT_NUMBER_AND_OPERATING_FLIGHT_NUMBER
       flightNumberAndOperatingFlightNumber],
      :secondValue FieldSelector}}]},
  :listTemplateOverride
  {:firstRowOption
   {:transitOption
    [TRANSIT_OPTION_UNSPECIFIED
     ORIGIN_AND_DESTINATION_NAMES
     originAndDestinationNames
     ORIGIN_AND_DESTINATION_CODES
     originAndDestinationCodes
     ORIGIN_NAME
     originName],
    :fieldOption {:fields [FieldReference]}},
   :secondRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]},
   :thirdRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]}},
  :cardTemplateOverride
  {:cardRowTemplateInfos
   [{:oneItem {:item TemplateItem},
     :twoItems {:endItem TemplateItem, :startItem TemplateItem},
     :threeItems
     {:startItem TemplateItem,
      :middleItem TemplateItem,
      :endItem TemplateItem}}]},
  :cardBarcodeSectionDetails
  {:firstTopDetail {:fieldSelector {:fields [FieldReference]}},
   :secondTopDetail {:fieldSelector {:fields [FieldReference]}},
   :firstBottomDetail {:fieldSelector {:fields [FieldReference]}}}},
 :enableSmartTap boolean,
 :viewUnlockRequirement
 [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
  UNLOCK_NOT_REQUIRED
  UNLOCK_REQUIRED_TO_VIEW]}"
  [GenericClass]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/genericClass",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body GenericClass}))

(defn genericclass-get
  "Returns the generic class with the given class ID.
https://developers.google.com/wallet/reference/rest/v1/genericclass/get

resourceId <string> The unique identifier for a class. This ID must be unique across all classes from an issuer. This value needs to follow the format `issuerID.identifier` where `issuerID` is issued by Google and `identifier` is chosen by you. The unique identifier can only include alphanumeric characters, `.`, `_`, or `-`."
  [resourceId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/genericClass/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}))

(defn genericclass-list
  "Returns a list of all generic classes for a given issuer ID.
https://developers.google.com/wallet/reference/rest/v1/genericclass/list

optional:
issuerId <string> The ID of the issuer authorized to list classes.
maxResults <integer> Identifies the max number of results returned by a list. All results are returned if `maxResults` isn't defined.
token <string> Used to get the next set of results if `maxResults` is specified, but more than `maxResults` classes are available in a list. For example, if you have a list of 200 classes and you call list with `maxResults` set to 20, list will return the first 20 classes and a token. Call list again with `maxResults` set to 20 and the token to get the next 20 classes."
  ([] (genericclass-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://walletobjects.googleapis.com/walletobjects/v1/genericClass",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/wallet_object.issuer"]})))

(defn genericclass-patch
  "Updates the generic class referenced by the given class ID. This method supports patch semantics.
https://developers.google.com/wallet/reference/rest/v1/genericclass/patch

resourceId <string> The unique identifier for a class. This ID must be unique across all classes from an issuer. This value needs to follow the format `issuerID.identifier` where `issuerID` is issued by Google and `identifier` is chosen by you. The unique identifier can only include alphanumeric characters, `.`, `_`, or `-`.
GenericClass:
{:textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :securityAnimation
 {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
 :multipleDevicesAndHoldersAllowedStatus
 [STATUS_UNSPECIFIED
  MULTIPLE_HOLDERS
  ONE_USER_ALL_DEVICES
  ONE_USER_ONE_DEVICE
  multipleHolders
  oneUserAllDevices
  oneUserOneDevice],
 :callbackOptions {:updateRequestUrl string, :url string},
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :redemptionIssuers [string],
 :id string,
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :classTemplateInfo
 {:detailsTemplateOverride
  {:detailsItemInfos
   [{:item
     {:firstValue FieldSelector,
      :predefinedItem
      [PREDEFINED_ITEM_UNSPECIFIED
       FREQUENT_FLYER_PROGRAM_NAME_AND_NUMBER
       frequentFlyerProgramNameAndNumber
       FLIGHT_NUMBER_AND_OPERATING_FLIGHT_NUMBER
       flightNumberAndOperatingFlightNumber],
      :secondValue FieldSelector}}]},
  :listTemplateOverride
  {:firstRowOption
   {:transitOption
    [TRANSIT_OPTION_UNSPECIFIED
     ORIGIN_AND_DESTINATION_NAMES
     originAndDestinationNames
     ORIGIN_AND_DESTINATION_CODES
     originAndDestinationCodes
     ORIGIN_NAME
     originName],
    :fieldOption {:fields [FieldReference]}},
   :secondRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]},
   :thirdRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]}},
  :cardTemplateOverride
  {:cardRowTemplateInfos
   [{:oneItem {:item TemplateItem},
     :twoItems {:endItem TemplateItem, :startItem TemplateItem},
     :threeItems
     {:startItem TemplateItem,
      :middleItem TemplateItem,
      :endItem TemplateItem}}]},
  :cardBarcodeSectionDetails
  {:firstTopDetail {:fieldSelector {:fields [FieldReference]}},
   :secondTopDetail {:fieldSelector {:fields [FieldReference]}},
   :firstBottomDetail {:fieldSelector {:fields [FieldReference]}}}},
 :enableSmartTap boolean,
 :viewUnlockRequirement
 [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
  UNLOCK_NOT_REQUIRED
  UNLOCK_REQUIRED_TO_VIEW]}"
  [resourceId GenericClass]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/genericClass/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body GenericClass}))

(defn genericclass-update
  "Updates the Generic class referenced by the given class ID.
https://developers.google.com/wallet/reference/rest/v1/genericclass/update

resourceId <string> The unique identifier for a class. This ID must be unique across all classes from an issuer. This value needs to follow the format `issuerID.identifier` where `issuerID` is issued by Google and `identifier` is chosen by you. The unique identifier can only include alphanumeric characters, `.`, `_`, or `-`.
GenericClass:
{:textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :securityAnimation
 {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
 :multipleDevicesAndHoldersAllowedStatus
 [STATUS_UNSPECIFIED
  MULTIPLE_HOLDERS
  ONE_USER_ALL_DEVICES
  ONE_USER_ONE_DEVICE
  multipleHolders
  oneUserAllDevices
  oneUserOneDevice],
 :callbackOptions {:updateRequestUrl string, :url string},
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :redemptionIssuers [string],
 :id string,
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :classTemplateInfo
 {:detailsTemplateOverride
  {:detailsItemInfos
   [{:item
     {:firstValue FieldSelector,
      :predefinedItem
      [PREDEFINED_ITEM_UNSPECIFIED
       FREQUENT_FLYER_PROGRAM_NAME_AND_NUMBER
       frequentFlyerProgramNameAndNumber
       FLIGHT_NUMBER_AND_OPERATING_FLIGHT_NUMBER
       flightNumberAndOperatingFlightNumber],
      :secondValue FieldSelector}}]},
  :listTemplateOverride
  {:firstRowOption
   {:transitOption
    [TRANSIT_OPTION_UNSPECIFIED
     ORIGIN_AND_DESTINATION_NAMES
     originAndDestinationNames
     ORIGIN_AND_DESTINATION_CODES
     originAndDestinationCodes
     ORIGIN_NAME
     originName],
    :fieldOption {:fields [FieldReference]}},
   :secondRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]},
   :thirdRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]}},
  :cardTemplateOverride
  {:cardRowTemplateInfos
   [{:oneItem {:item TemplateItem},
     :twoItems {:endItem TemplateItem, :startItem TemplateItem},
     :threeItems
     {:startItem TemplateItem,
      :middleItem TemplateItem,
      :endItem TemplateItem}}]},
  :cardBarcodeSectionDetails
  {:firstTopDetail {:fieldSelector {:fields [FieldReference]}},
   :secondTopDetail {:fieldSelector {:fields [FieldReference]}},
   :firstBottomDetail {:fieldSelector {:fields [FieldReference]}}}},
 :enableSmartTap boolean,
 :viewUnlockRequirement
 [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
  UNLOCK_NOT_REQUIRED
  UNLOCK_REQUIRED_TO_VIEW]}"
  [resourceId GenericClass]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/genericClass/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body GenericClass}))

(defn giftcardobject-insert
  "Inserts an gift card object with the given ID and properties.
https://developers.google.com/wallet/reference/rest/v1/giftcardobject/insert

GiftCardObject:
{:cardNumber string,
 :hasUsers boolean,
 :smartTapRedemptionValue string,
 :rotatingBarcode
 {:totpDetails
  {:periodMillis string,
   :algorithm [TOTP_ALGORITHM_UNSPECIFIED TOTP_SHA1],
   :parameters [{:valueLength integer, :key string}]},
  :alternateText string,
  :initialRotatingBarcodeValues
  {:startDateTime string, :values [string], :periodMillis string},
  :valuePattern string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :barcode
 {:kind string,
  :alternateText string,
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :value string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :hasLinkedDevice boolean,
 :groupingInfo {:groupingId string, :sortIndex integer},
 :state
 [STATE_UNSPECIFIED
  ACTIVE
  active
  COMPLETED
  completed
  EXPIRED
  expired
  INACTIVE
  inactive],
 :classReference
 {:wordMark
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :reviewStatus
  [REVIEW_STATUS_UNSPECIFIED
   UNDER_REVIEW
   underReview
   APPROVED
   approved
   REJECTED
   rejected
   DRAFT
   draft],
  :wideProgramLogo
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :textModulesData
  [{:header string,
    :id string,
    :localizedHeader
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :localizedBody
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :body string}],
  :issuerName string,
  :securityAnimation
  {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
  :multipleDevicesAndHoldersAllowedStatus
  [STATUS_UNSPECIFIED
   MULTIPLE_HOLDERS
   ONE_USER_ALL_DEVICES
   ONE_USER_ONE_DEVICE
   multipleHolders
   oneUserAllDevices
   oneUserOneDevice],
  :localizedEventNumberLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :pinLabel string,
  :merchantName string,
  :localizedMerchantName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :homepageUri
  {:description string,
   :kind string,
   :id string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :callbackOptions {:updateRequestUrl string, :url string},
  :linksModuleData
  {:uris
   [{:description string,
     :kind string,
     :id string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string}]},
  :imageModulesData
  [{:id string,
    :mainImage
    {:contentDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :sourceUri
     {:description string,
      :localizedDescription LocalizedString,
      :uri string},
     :kind string}}],
  :locations [{:longitude number, :kind string, :latitude number}],
  :allowMultipleUsersPerObject boolean,
  :hexBackgroundColor string,
  :messages
  [{:kind string,
    :displayInterval
    {:start {:date string}, :kind string, :end {:date string}},
    :body string,
    :localizedBody
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :id string,
    :messageType
    [MESSAGE_TYPE_UNSPECIFIED
     TEXT
     text
     EXPIRATION_NOTIFICATION
     expirationNotification
     TEXT_AND_NOTIFY],
    :localizedHeader
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :header string}],
  :localizedIssuerName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :redemptionIssuers [string],
  :review {:comments string},
  :programLogo
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :id string,
  :kind string,
  :appLinkData
  {:androidAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}},
   :webAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}},
   :iosAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}}},
  :localizedPinLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :classTemplateInfo
  {:detailsTemplateOverride {:detailsItemInfos [{:item TemplateItem}]},
   :listTemplateOverride
   {:firstRowOption
    {:transitOption
     [TRANSIT_OPTION_UNSPECIFIED
      ORIGIN_AND_DESTINATION_NAMES
      originAndDestinationNames
      ORIGIN_AND_DESTINATION_CODES
      originAndDestinationCodes
      ORIGIN_NAME
      originName],
     :fieldOption FieldSelector},
    :secondRowOption {:fields [FieldReference]},
    :thirdRowOption {:fields [FieldReference]}},
   :cardTemplateOverride
   {:cardRowTemplateInfos
    [{:oneItem CardRowOneItem,
      :twoItems CardRowTwoItems,
      :threeItems CardRowThreeItems}]},
   :cardBarcodeSectionDetails
   {:firstTopDetail {:fieldSelector FieldSelector},
    :secondTopDetail {:fieldSelector FieldSelector},
    :firstBottomDetail {:fieldSelector FieldSelector}}},
  :enableSmartTap boolean,
  :cardNumberLabel string,
  :version string,
  :viewUnlockRequirement
  [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
   UNLOCK_NOT_REQUIRED
   UNLOCK_REQUIRED_TO_VIEW],
  :infoModuleData
  {:showLastUpdateTime boolean,
   :labelValueRows
   [{:columns
     [{:localizedLabel LocalizedString,
       :localizedValue LocalizedString,
       :label string,
       :value string}]}]},
  :heroImage
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :allowBarcodeRedemption boolean,
  :eventNumberLabel string,
  :countryCode string,
  :localizedCardNumberLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}}},
 :disableExpirationNotification boolean,
 :pin string,
 :eventNumber string,
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :validTimeInterval
 {:start {:date string}, :kind string, :end {:date string}},
 :locations [{:longitude number, :kind string, :latitude number}],
 :balance {:micros string, :currencyCode string, :kind string},
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :id string,
 :kind string,
 :classId string,
 :passConstraints
 {:nfcConstraint
  [[NFC_CONSTRAINT_UNSPECIFIED
    BLOCK_PAYMENT
    BLOCK_CLOSED_LOOP_TRANSIT]],
  :screenshotEligibility
  [SCREENSHOT_ELIGIBILITY_UNSPECIFIED ELIGIBLE INELIGIBLE]},
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :version string,
 :infoModuleData
 {:showLastUpdateTime boolean,
  :labelValueRows
  [{:columns
    [{:localizedLabel
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :localizedValue
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :label string,
      :value string}]}]},
 :balanceUpdateTime {:date string},
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string}}"
  [GiftCardObject]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/giftCardObject",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body GiftCardObject}))

(defn giftcardobject-get
  "Returns the gift card object with the given object ID.
https://developers.google.com/wallet/reference/rest/v1/giftcardobject/get

resourceId <string> The unique identifier for an object. This ID must be unique across all objects from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'."
  [resourceId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/giftCardObject/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}))

(defn giftcardobject-list
  "Returns a list of all gift card objects for a given issuer ID.
https://developers.google.com/wallet/reference/rest/v1/giftcardobject/list

optional:
token <string> Used to get the next set of results if `maxResults` is specified, but more than `maxResults` objects are available in a list. For example, if you have a list of 200 objects and you call list with `maxResults` set to 20, list will return the first 20 objects and a token. Call list again with `maxResults` set to 20 and the token to get the next 20 objects.
classId <string> The ID of the class whose objects will be listed.
maxResults <integer> Identifies the max number of results returned by a list. All results are returned if `maxResults` isn't defined."
  ([] (giftcardobject-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://walletobjects.googleapis.com/walletobjects/v1/giftCardObject",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/wallet_object.issuer"]})))

(defn giftcardobject-addmessage
  "Adds a message to the gift card object referenced by the given object ID.
https://developers.google.com/wallet/reference/rest/v1/giftcardobject/addmessage

resourceId <string> The unique identifier for an object. This ID must be unique across all objects from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
AddMessageRequest:
{:message
 {:kind string,
  :displayInterval
  {:start {:date string}, :kind string, :end {:date string}},
  :body string,
  :localizedBody
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :id string,
  :messageType
  [MESSAGE_TYPE_UNSPECIFIED
   TEXT
   text
   EXPIRATION_NOTIFICATION
   expirationNotification
   TEXT_AND_NOTIFY],
  :localizedHeader
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :header string}}"
  [resourceId AddMessageRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/giftCardObject/{resourceId}/addMessage",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body AddMessageRequest}))

(defn giftcardobject-update
  "Updates the gift card object referenced by the given object ID.
https://developers.google.com/wallet/reference/rest/v1/giftcardobject/update

resourceId <string> The unique identifier for an object. This ID must be unique across all objects from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
GiftCardObject:
{:cardNumber string,
 :hasUsers boolean,
 :smartTapRedemptionValue string,
 :rotatingBarcode
 {:totpDetails
  {:periodMillis string,
   :algorithm [TOTP_ALGORITHM_UNSPECIFIED TOTP_SHA1],
   :parameters [{:valueLength integer, :key string}]},
  :alternateText string,
  :initialRotatingBarcodeValues
  {:startDateTime string, :values [string], :periodMillis string},
  :valuePattern string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :barcode
 {:kind string,
  :alternateText string,
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :value string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :hasLinkedDevice boolean,
 :groupingInfo {:groupingId string, :sortIndex integer},
 :state
 [STATE_UNSPECIFIED
  ACTIVE
  active
  COMPLETED
  completed
  EXPIRED
  expired
  INACTIVE
  inactive],
 :classReference
 {:wordMark
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :reviewStatus
  [REVIEW_STATUS_UNSPECIFIED
   UNDER_REVIEW
   underReview
   APPROVED
   approved
   REJECTED
   rejected
   DRAFT
   draft],
  :wideProgramLogo
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :textModulesData
  [{:header string,
    :id string,
    :localizedHeader
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :localizedBody
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :body string}],
  :issuerName string,
  :securityAnimation
  {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
  :multipleDevicesAndHoldersAllowedStatus
  [STATUS_UNSPECIFIED
   MULTIPLE_HOLDERS
   ONE_USER_ALL_DEVICES
   ONE_USER_ONE_DEVICE
   multipleHolders
   oneUserAllDevices
   oneUserOneDevice],
  :localizedEventNumberLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :pinLabel string,
  :merchantName string,
  :localizedMerchantName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :homepageUri
  {:description string,
   :kind string,
   :id string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :callbackOptions {:updateRequestUrl string, :url string},
  :linksModuleData
  {:uris
   [{:description string,
     :kind string,
     :id string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string}]},
  :imageModulesData
  [{:id string,
    :mainImage
    {:contentDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :sourceUri
     {:description string,
      :localizedDescription LocalizedString,
      :uri string},
     :kind string}}],
  :locations [{:longitude number, :kind string, :latitude number}],
  :allowMultipleUsersPerObject boolean,
  :hexBackgroundColor string,
  :messages
  [{:kind string,
    :displayInterval
    {:start {:date string}, :kind string, :end {:date string}},
    :body string,
    :localizedBody
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :id string,
    :messageType
    [MESSAGE_TYPE_UNSPECIFIED
     TEXT
     text
     EXPIRATION_NOTIFICATION
     expirationNotification
     TEXT_AND_NOTIFY],
    :localizedHeader
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :header string}],
  :localizedIssuerName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :redemptionIssuers [string],
  :review {:comments string},
  :programLogo
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :id string,
  :kind string,
  :appLinkData
  {:androidAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}},
   :webAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}},
   :iosAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}}},
  :localizedPinLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :classTemplateInfo
  {:detailsTemplateOverride {:detailsItemInfos [{:item TemplateItem}]},
   :listTemplateOverride
   {:firstRowOption
    {:transitOption
     [TRANSIT_OPTION_UNSPECIFIED
      ORIGIN_AND_DESTINATION_NAMES
      originAndDestinationNames
      ORIGIN_AND_DESTINATION_CODES
      originAndDestinationCodes
      ORIGIN_NAME
      originName],
     :fieldOption FieldSelector},
    :secondRowOption {:fields [FieldReference]},
    :thirdRowOption {:fields [FieldReference]}},
   :cardTemplateOverride
   {:cardRowTemplateInfos
    [{:oneItem CardRowOneItem,
      :twoItems CardRowTwoItems,
      :threeItems CardRowThreeItems}]},
   :cardBarcodeSectionDetails
   {:firstTopDetail {:fieldSelector FieldSelector},
    :secondTopDetail {:fieldSelector FieldSelector},
    :firstBottomDetail {:fieldSelector FieldSelector}}},
  :enableSmartTap boolean,
  :cardNumberLabel string,
  :version string,
  :viewUnlockRequirement
  [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
   UNLOCK_NOT_REQUIRED
   UNLOCK_REQUIRED_TO_VIEW],
  :infoModuleData
  {:showLastUpdateTime boolean,
   :labelValueRows
   [{:columns
     [{:localizedLabel LocalizedString,
       :localizedValue LocalizedString,
       :label string,
       :value string}]}]},
  :heroImage
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :allowBarcodeRedemption boolean,
  :eventNumberLabel string,
  :countryCode string,
  :localizedCardNumberLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}}},
 :disableExpirationNotification boolean,
 :pin string,
 :eventNumber string,
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :validTimeInterval
 {:start {:date string}, :kind string, :end {:date string}},
 :locations [{:longitude number, :kind string, :latitude number}],
 :balance {:micros string, :currencyCode string, :kind string},
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :id string,
 :kind string,
 :classId string,
 :passConstraints
 {:nfcConstraint
  [[NFC_CONSTRAINT_UNSPECIFIED
    BLOCK_PAYMENT
    BLOCK_CLOSED_LOOP_TRANSIT]],
  :screenshotEligibility
  [SCREENSHOT_ELIGIBILITY_UNSPECIFIED ELIGIBLE INELIGIBLE]},
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :version string,
 :infoModuleData
 {:showLastUpdateTime boolean,
  :labelValueRows
  [{:columns
    [{:localizedLabel
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :localizedValue
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :label string,
      :value string}]}]},
 :balanceUpdateTime {:date string},
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string}}"
  [resourceId GiftCardObject]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/giftCardObject/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body GiftCardObject}))

(defn giftcardobject-patch
  "Updates the gift card object referenced by the given object ID. This method supports patch semantics.
https://developers.google.com/wallet/reference/rest/v1/giftcardobject/patch

resourceId <string> The unique identifier for an object. This ID must be unique across all objects from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
GiftCardObject:
{:cardNumber string,
 :hasUsers boolean,
 :smartTapRedemptionValue string,
 :rotatingBarcode
 {:totpDetails
  {:periodMillis string,
   :algorithm [TOTP_ALGORITHM_UNSPECIFIED TOTP_SHA1],
   :parameters [{:valueLength integer, :key string}]},
  :alternateText string,
  :initialRotatingBarcodeValues
  {:startDateTime string, :values [string], :periodMillis string},
  :valuePattern string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :barcode
 {:kind string,
  :alternateText string,
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :value string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :hasLinkedDevice boolean,
 :groupingInfo {:groupingId string, :sortIndex integer},
 :state
 [STATE_UNSPECIFIED
  ACTIVE
  active
  COMPLETED
  completed
  EXPIRED
  expired
  INACTIVE
  inactive],
 :classReference
 {:wordMark
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :reviewStatus
  [REVIEW_STATUS_UNSPECIFIED
   UNDER_REVIEW
   underReview
   APPROVED
   approved
   REJECTED
   rejected
   DRAFT
   draft],
  :wideProgramLogo
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :textModulesData
  [{:header string,
    :id string,
    :localizedHeader
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :localizedBody
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :body string}],
  :issuerName string,
  :securityAnimation
  {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
  :multipleDevicesAndHoldersAllowedStatus
  [STATUS_UNSPECIFIED
   MULTIPLE_HOLDERS
   ONE_USER_ALL_DEVICES
   ONE_USER_ONE_DEVICE
   multipleHolders
   oneUserAllDevices
   oneUserOneDevice],
  :localizedEventNumberLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :pinLabel string,
  :merchantName string,
  :localizedMerchantName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :homepageUri
  {:description string,
   :kind string,
   :id string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :callbackOptions {:updateRequestUrl string, :url string},
  :linksModuleData
  {:uris
   [{:description string,
     :kind string,
     :id string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string}]},
  :imageModulesData
  [{:id string,
    :mainImage
    {:contentDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :sourceUri
     {:description string,
      :localizedDescription LocalizedString,
      :uri string},
     :kind string}}],
  :locations [{:longitude number, :kind string, :latitude number}],
  :allowMultipleUsersPerObject boolean,
  :hexBackgroundColor string,
  :messages
  [{:kind string,
    :displayInterval
    {:start {:date string}, :kind string, :end {:date string}},
    :body string,
    :localizedBody
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :id string,
    :messageType
    [MESSAGE_TYPE_UNSPECIFIED
     TEXT
     text
     EXPIRATION_NOTIFICATION
     expirationNotification
     TEXT_AND_NOTIFY],
    :localizedHeader
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :header string}],
  :localizedIssuerName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :redemptionIssuers [string],
  :review {:comments string},
  :programLogo
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :id string,
  :kind string,
  :appLinkData
  {:androidAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}},
   :webAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}},
   :iosAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}}},
  :localizedPinLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :classTemplateInfo
  {:detailsTemplateOverride {:detailsItemInfos [{:item TemplateItem}]},
   :listTemplateOverride
   {:firstRowOption
    {:transitOption
     [TRANSIT_OPTION_UNSPECIFIED
      ORIGIN_AND_DESTINATION_NAMES
      originAndDestinationNames
      ORIGIN_AND_DESTINATION_CODES
      originAndDestinationCodes
      ORIGIN_NAME
      originName],
     :fieldOption FieldSelector},
    :secondRowOption {:fields [FieldReference]},
    :thirdRowOption {:fields [FieldReference]}},
   :cardTemplateOverride
   {:cardRowTemplateInfos
    [{:oneItem CardRowOneItem,
      :twoItems CardRowTwoItems,
      :threeItems CardRowThreeItems}]},
   :cardBarcodeSectionDetails
   {:firstTopDetail {:fieldSelector FieldSelector},
    :secondTopDetail {:fieldSelector FieldSelector},
    :firstBottomDetail {:fieldSelector FieldSelector}}},
  :enableSmartTap boolean,
  :cardNumberLabel string,
  :version string,
  :viewUnlockRequirement
  [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
   UNLOCK_NOT_REQUIRED
   UNLOCK_REQUIRED_TO_VIEW],
  :infoModuleData
  {:showLastUpdateTime boolean,
   :labelValueRows
   [{:columns
     [{:localizedLabel LocalizedString,
       :localizedValue LocalizedString,
       :label string,
       :value string}]}]},
  :heroImage
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :allowBarcodeRedemption boolean,
  :eventNumberLabel string,
  :countryCode string,
  :localizedCardNumberLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}}},
 :disableExpirationNotification boolean,
 :pin string,
 :eventNumber string,
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :validTimeInterval
 {:start {:date string}, :kind string, :end {:date string}},
 :locations [{:longitude number, :kind string, :latitude number}],
 :balance {:micros string, :currencyCode string, :kind string},
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :id string,
 :kind string,
 :classId string,
 :passConstraints
 {:nfcConstraint
  [[NFC_CONSTRAINT_UNSPECIFIED
    BLOCK_PAYMENT
    BLOCK_CLOSED_LOOP_TRANSIT]],
  :screenshotEligibility
  [SCREENSHOT_ELIGIBILITY_UNSPECIFIED ELIGIBLE INELIGIBLE]},
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :version string,
 :infoModuleData
 {:showLastUpdateTime boolean,
  :labelValueRows
  [{:columns
    [{:localizedLabel
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :localizedValue
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :label string,
      :value string}]}]},
 :balanceUpdateTime {:date string},
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string}}"
  [resourceId GiftCardObject]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/giftCardObject/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body GiftCardObject}))

(defn jwt-insert
  "Inserts the resources in the JWT.
https://developers.google.com/wallet/reference/rest/v1/jwt/insert

JwtResource:
{:jwt string}"
  [JwtResource]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/jwt",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body JwtResource}))

(defn flightobject-update
  "Updates the flight object referenced by the given object ID.
https://developers.google.com/wallet/reference/rest/v1/flightobject/update

resourceId <string> The unique identifier for an object. This ID must be unique across all objects from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
FlightObject:
{:securityProgramLogo
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :hasUsers boolean,
 :smartTapRedemptionValue string,
 :reservationInfo
 {:confirmationCode string,
  :eticketNumber string,
  :frequentFlyerInfo
  {:kind string,
   :frequentFlyerProgramName
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :frequentFlyerNumber string},
  :kind string},
 :rotatingBarcode
 {:totpDetails
  {:periodMillis string,
   :algorithm [TOTP_ALGORITHM_UNSPECIFIED TOTP_SHA1],
   :parameters [{:valueLength integer, :key string}]},
  :alternateText string,
  :initialRotatingBarcodeValues
  {:startDateTime string, :values [string], :periodMillis string},
  :valuePattern string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :barcode
 {:kind string,
  :alternateText string,
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :value string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :hasLinkedDevice boolean,
 :groupingInfo {:groupingId string, :sortIndex integer},
 :state
 [STATE_UNSPECIFIED
  ACTIVE
  active
  COMPLETED
  completed
  EXPIRED
  expired
  INACTIVE
  inactive],
 :classReference
 {:localScheduledDepartureDateTime string,
  :wordMark
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :localGateClosingDateTime string,
  :localBoardingDateTime string,
  :reviewStatus
  [REVIEW_STATUS_UNSPECIFIED
   UNDER_REVIEW
   underReview
   APPROVED
   approved
   REJECTED
   rejected
   DRAFT
   draft],
  :boardingAndSeatingPolicy
  {:boardingPolicy
   [BOARDING_POLICY_UNSPECIFIED
    ZONE_BASED
    zoneBased
    GROUP_BASED
    groupBased
    BOARDING_POLICY_OTHER
    boardingPolicyOther],
   :kind string,
   :seatClassPolicy
   [SEAT_CLASS_POLICY_UNSPECIFIED
    CABIN_BASED
    cabinBased
    CLASS_BASED
    classBased
    TIER_BASED
    tierBased
    SEAT_CLASS_POLICY_OTHER
    seatClassPolicyOther]},
  :textModulesData
  [{:header string,
    :id string,
    :localizedHeader
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :localizedBody
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :body string}],
  :issuerName string,
  :flightHeader
  {:kind string,
   :flightNumberDisplayOverride string,
   :flightNumber string,
   :operatingCarrier
   {:kind string,
    :wideAirlineLogo
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :carrierIataCode string,
    :airlineAllianceLogo
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :airlineLogo
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :carrierIcaoCode string,
    :airlineName
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString}},
   :carrier
   {:kind string,
    :wideAirlineLogo
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :carrierIataCode string,
    :airlineAllianceLogo
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :airlineLogo
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :carrierIcaoCode string,
    :airlineName
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString}},
   :operatingFlightNumber string},
  :localEstimatedOrActualArrivalDateTime string,
  :securityAnimation
  {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
  :multipleDevicesAndHoldersAllowedStatus
  [STATUS_UNSPECIFIED
   MULTIPLE_HOLDERS
   ONE_USER_ALL_DEVICES
   ONE_USER_ONE_DEVICE
   multipleHolders
   oneUserAllDevices
   oneUserOneDevice],
  :homepageUri
  {:description string,
   :kind string,
   :id string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :callbackOptions {:updateRequestUrl string, :url string},
  :linksModuleData
  {:uris
   [{:description string,
     :kind string,
     :id string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string}]},
  :imageModulesData
  [{:id string,
    :mainImage
    {:contentDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :sourceUri
     {:description string,
      :localizedDescription LocalizedString,
      :uri string},
     :kind string}}],
  :locations [{:longitude number, :kind string, :latitude number}],
  :allowMultipleUsersPerObject boolean,
  :hexBackgroundColor string,
  :messages
  [{:kind string,
    :displayInterval
    {:start {:date string}, :kind string, :end {:date string}},
    :body string,
    :localizedBody
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :id string,
    :messageType
    [MESSAGE_TYPE_UNSPECIFIED
     TEXT
     text
     EXPIRATION_NOTIFICATION
     expirationNotification
     TEXT_AND_NOTIFY],
    :localizedHeader
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :header string}],
  :localizedIssuerName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :redemptionIssuers [string],
  :localEstimatedOrActualDepartureDateTime string,
  :review {:comments string},
  :localScheduledArrivalDateTime string,
  :id string,
  :kind string,
  :flightStatus
  [FLIGHT_STATUS_UNSPECIFIED
   SCHEDULED
   scheduled
   ACTIVE
   active
   LANDED
   landed
   CANCELLED
   cancelled
   REDIRECTED
   redirected
   DIVERTED
   diverted],
  :appLinkData
  {:androidAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}},
   :webAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}},
   :iosAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}}},
  :origin
  {:airportIataCode string,
   :kind string,
   :gate string,
   :airportNameOverride
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :terminal string},
  :classTemplateInfo
  {:detailsTemplateOverride {:detailsItemInfos [{:item TemplateItem}]},
   :listTemplateOverride
   {:firstRowOption
    {:transitOption
     [TRANSIT_OPTION_UNSPECIFIED
      ORIGIN_AND_DESTINATION_NAMES
      originAndDestinationNames
      ORIGIN_AND_DESTINATION_CODES
      originAndDestinationCodes
      ORIGIN_NAME
      originName],
     :fieldOption FieldSelector},
    :secondRowOption {:fields [FieldReference]},
    :thirdRowOption {:fields [FieldReference]}},
   :cardTemplateOverride
   {:cardRowTemplateInfos
    [{:oneItem CardRowOneItem,
      :twoItems CardRowTwoItems,
      :threeItems CardRowThreeItems}]},
   :cardBarcodeSectionDetails
   {:firstTopDetail {:fieldSelector FieldSelector},
    :secondTopDetail {:fieldSelector FieldSelector},
    :firstBottomDetail {:fieldSelector FieldSelector}}},
  :enableSmartTap boolean,
  :version string,
  :viewUnlockRequirement
  [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
   UNLOCK_NOT_REQUIRED
   UNLOCK_REQUIRED_TO_VIEW],
  :infoModuleData
  {:showLastUpdateTime boolean,
   :labelValueRows
   [{:columns
     [{:localizedLabel LocalizedString,
       :localizedValue LocalizedString,
       :label string,
       :value string}]}]},
  :heroImage
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :destination
  {:airportIataCode string,
   :kind string,
   :gate string,
   :airportNameOverride
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :terminal string},
  :countryCode string,
  :languageOverride string},
 :disableExpirationNotification boolean,
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :validTimeInterval
 {:start {:date string}, :kind string, :end {:date string}},
 :locations [{:longitude number, :kind string, :latitude number}],
 :boardingAndSeatingInfo
 {:sequenceNumber string,
  :seatAssignment
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :seatNumber string,
  :boardingPosition string,
  :kind string,
  :boardingGroup string,
  :boardingPrivilegeImage
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :boardingDoor [BOARDING_DOOR_UNSPECIFIED FRONT front BACK back],
  :seatClass string},
 :hexBackgroundColor string,
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :id string,
 :kind string,
 :classId string,
 :passengerName string,
 :passConstraints
 {:nfcConstraint
  [[NFC_CONSTRAINT_UNSPECIFIED
    BLOCK_PAYMENT
    BLOCK_CLOSED_LOOP_TRANSIT]],
  :screenshotEligibility
  [SCREENSHOT_ELIGIBILITY_UNSPECIFIED ELIGIBLE INELIGIBLE]},
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :version string,
 :infoModuleData
 {:showLastUpdateTime boolean,
  :labelValueRows
  [{:columns
    [{:localizedLabel
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :localizedValue
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :label string,
      :value string}]}]},
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string}}"
  [resourceId FlightObject]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/flightObject/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body FlightObject}))

(defn flightobject-addmessage
  "Adds a message to the flight object referenced by the given object ID.
https://developers.google.com/wallet/reference/rest/v1/flightobject/addmessage

resourceId <string> The unique identifier for an object. This ID must be unique across all objects from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
AddMessageRequest:
{:message
 {:kind string,
  :displayInterval
  {:start {:date string}, :kind string, :end {:date string}},
  :body string,
  :localizedBody
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :id string,
  :messageType
  [MESSAGE_TYPE_UNSPECIFIED
   TEXT
   text
   EXPIRATION_NOTIFICATION
   expirationNotification
   TEXT_AND_NOTIFY],
  :localizedHeader
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :header string}}"
  [resourceId AddMessageRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/flightObject/{resourceId}/addMessage",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body AddMessageRequest}))

(defn flightobject-insert
  "Inserts an flight object with the given ID and properties.
https://developers.google.com/wallet/reference/rest/v1/flightobject/insert

FlightObject:
{:securityProgramLogo
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :hasUsers boolean,
 :smartTapRedemptionValue string,
 :reservationInfo
 {:confirmationCode string,
  :eticketNumber string,
  :frequentFlyerInfo
  {:kind string,
   :frequentFlyerProgramName
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :frequentFlyerNumber string},
  :kind string},
 :rotatingBarcode
 {:totpDetails
  {:periodMillis string,
   :algorithm [TOTP_ALGORITHM_UNSPECIFIED TOTP_SHA1],
   :parameters [{:valueLength integer, :key string}]},
  :alternateText string,
  :initialRotatingBarcodeValues
  {:startDateTime string, :values [string], :periodMillis string},
  :valuePattern string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :barcode
 {:kind string,
  :alternateText string,
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :value string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :hasLinkedDevice boolean,
 :groupingInfo {:groupingId string, :sortIndex integer},
 :state
 [STATE_UNSPECIFIED
  ACTIVE
  active
  COMPLETED
  completed
  EXPIRED
  expired
  INACTIVE
  inactive],
 :classReference
 {:localScheduledDepartureDateTime string,
  :wordMark
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :localGateClosingDateTime string,
  :localBoardingDateTime string,
  :reviewStatus
  [REVIEW_STATUS_UNSPECIFIED
   UNDER_REVIEW
   underReview
   APPROVED
   approved
   REJECTED
   rejected
   DRAFT
   draft],
  :boardingAndSeatingPolicy
  {:boardingPolicy
   [BOARDING_POLICY_UNSPECIFIED
    ZONE_BASED
    zoneBased
    GROUP_BASED
    groupBased
    BOARDING_POLICY_OTHER
    boardingPolicyOther],
   :kind string,
   :seatClassPolicy
   [SEAT_CLASS_POLICY_UNSPECIFIED
    CABIN_BASED
    cabinBased
    CLASS_BASED
    classBased
    TIER_BASED
    tierBased
    SEAT_CLASS_POLICY_OTHER
    seatClassPolicyOther]},
  :textModulesData
  [{:header string,
    :id string,
    :localizedHeader
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :localizedBody
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :body string}],
  :issuerName string,
  :flightHeader
  {:kind string,
   :flightNumberDisplayOverride string,
   :flightNumber string,
   :operatingCarrier
   {:kind string,
    :wideAirlineLogo
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :carrierIataCode string,
    :airlineAllianceLogo
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :airlineLogo
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :carrierIcaoCode string,
    :airlineName
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString}},
   :carrier
   {:kind string,
    :wideAirlineLogo
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :carrierIataCode string,
    :airlineAllianceLogo
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :airlineLogo
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :carrierIcaoCode string,
    :airlineName
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString}},
   :operatingFlightNumber string},
  :localEstimatedOrActualArrivalDateTime string,
  :securityAnimation
  {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
  :multipleDevicesAndHoldersAllowedStatus
  [STATUS_UNSPECIFIED
   MULTIPLE_HOLDERS
   ONE_USER_ALL_DEVICES
   ONE_USER_ONE_DEVICE
   multipleHolders
   oneUserAllDevices
   oneUserOneDevice],
  :homepageUri
  {:description string,
   :kind string,
   :id string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :callbackOptions {:updateRequestUrl string, :url string},
  :linksModuleData
  {:uris
   [{:description string,
     :kind string,
     :id string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string}]},
  :imageModulesData
  [{:id string,
    :mainImage
    {:contentDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :sourceUri
     {:description string,
      :localizedDescription LocalizedString,
      :uri string},
     :kind string}}],
  :locations [{:longitude number, :kind string, :latitude number}],
  :allowMultipleUsersPerObject boolean,
  :hexBackgroundColor string,
  :messages
  [{:kind string,
    :displayInterval
    {:start {:date string}, :kind string, :end {:date string}},
    :body string,
    :localizedBody
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :id string,
    :messageType
    [MESSAGE_TYPE_UNSPECIFIED
     TEXT
     text
     EXPIRATION_NOTIFICATION
     expirationNotification
     TEXT_AND_NOTIFY],
    :localizedHeader
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :header string}],
  :localizedIssuerName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :redemptionIssuers [string],
  :localEstimatedOrActualDepartureDateTime string,
  :review {:comments string},
  :localScheduledArrivalDateTime string,
  :id string,
  :kind string,
  :flightStatus
  [FLIGHT_STATUS_UNSPECIFIED
   SCHEDULED
   scheduled
   ACTIVE
   active
   LANDED
   landed
   CANCELLED
   cancelled
   REDIRECTED
   redirected
   DIVERTED
   diverted],
  :appLinkData
  {:androidAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}},
   :webAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}},
   :iosAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}}},
  :origin
  {:airportIataCode string,
   :kind string,
   :gate string,
   :airportNameOverride
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :terminal string},
  :classTemplateInfo
  {:detailsTemplateOverride {:detailsItemInfos [{:item TemplateItem}]},
   :listTemplateOverride
   {:firstRowOption
    {:transitOption
     [TRANSIT_OPTION_UNSPECIFIED
      ORIGIN_AND_DESTINATION_NAMES
      originAndDestinationNames
      ORIGIN_AND_DESTINATION_CODES
      originAndDestinationCodes
      ORIGIN_NAME
      originName],
     :fieldOption FieldSelector},
    :secondRowOption {:fields [FieldReference]},
    :thirdRowOption {:fields [FieldReference]}},
   :cardTemplateOverride
   {:cardRowTemplateInfos
    [{:oneItem CardRowOneItem,
      :twoItems CardRowTwoItems,
      :threeItems CardRowThreeItems}]},
   :cardBarcodeSectionDetails
   {:firstTopDetail {:fieldSelector FieldSelector},
    :secondTopDetail {:fieldSelector FieldSelector},
    :firstBottomDetail {:fieldSelector FieldSelector}}},
  :enableSmartTap boolean,
  :version string,
  :viewUnlockRequirement
  [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
   UNLOCK_NOT_REQUIRED
   UNLOCK_REQUIRED_TO_VIEW],
  :infoModuleData
  {:showLastUpdateTime boolean,
   :labelValueRows
   [{:columns
     [{:localizedLabel LocalizedString,
       :localizedValue LocalizedString,
       :label string,
       :value string}]}]},
  :heroImage
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :destination
  {:airportIataCode string,
   :kind string,
   :gate string,
   :airportNameOverride
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :terminal string},
  :countryCode string,
  :languageOverride string},
 :disableExpirationNotification boolean,
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :validTimeInterval
 {:start {:date string}, :kind string, :end {:date string}},
 :locations [{:longitude number, :kind string, :latitude number}],
 :boardingAndSeatingInfo
 {:sequenceNumber string,
  :seatAssignment
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :seatNumber string,
  :boardingPosition string,
  :kind string,
  :boardingGroup string,
  :boardingPrivilegeImage
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :boardingDoor [BOARDING_DOOR_UNSPECIFIED FRONT front BACK back],
  :seatClass string},
 :hexBackgroundColor string,
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :id string,
 :kind string,
 :classId string,
 :passengerName string,
 :passConstraints
 {:nfcConstraint
  [[NFC_CONSTRAINT_UNSPECIFIED
    BLOCK_PAYMENT
    BLOCK_CLOSED_LOOP_TRANSIT]],
  :screenshotEligibility
  [SCREENSHOT_ELIGIBILITY_UNSPECIFIED ELIGIBLE INELIGIBLE]},
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :version string,
 :infoModuleData
 {:showLastUpdateTime boolean,
  :labelValueRows
  [{:columns
    [{:localizedLabel
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :localizedValue
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :label string,
      :value string}]}]},
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string}}"
  [FlightObject]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/flightObject",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body FlightObject}))

(defn flightobject-list
  "Returns a list of all flight objects for a given issuer ID.
https://developers.google.com/wallet/reference/rest/v1/flightobject/list

optional:
maxResults <integer> Identifies the max number of results returned by a list. All results are returned if `maxResults` isn't defined.
token <string> Used to get the next set of results if `maxResults` is specified, but more than `maxResults` objects are available in a list. For example, if you have a list of 200 objects and you call list with `maxResults` set to 20, list will return the first 20 objects and a token. Call list again with `maxResults` set to 20 and the token to get the next 20 objects.
classId <string> The ID of the class whose objects will be listed."
  ([] (flightobject-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://walletobjects.googleapis.com/walletobjects/v1/flightObject",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/wallet_object.issuer"]})))

(defn flightobject-get
  "Returns the flight object with the given object ID.
https://developers.google.com/wallet/reference/rest/v1/flightobject/get

resourceId <string> The unique identifier for an object. This ID must be unique across all objects from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'."
  [resourceId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/flightObject/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}))

(defn flightobject-patch
  "Updates the flight object referenced by the given object ID. This method supports patch semantics.
https://developers.google.com/wallet/reference/rest/v1/flightobject/patch

resourceId <string> The unique identifier for an object. This ID must be unique across all objects from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
FlightObject:
{:securityProgramLogo
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :hasUsers boolean,
 :smartTapRedemptionValue string,
 :reservationInfo
 {:confirmationCode string,
  :eticketNumber string,
  :frequentFlyerInfo
  {:kind string,
   :frequentFlyerProgramName
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :frequentFlyerNumber string},
  :kind string},
 :rotatingBarcode
 {:totpDetails
  {:periodMillis string,
   :algorithm [TOTP_ALGORITHM_UNSPECIFIED TOTP_SHA1],
   :parameters [{:valueLength integer, :key string}]},
  :alternateText string,
  :initialRotatingBarcodeValues
  {:startDateTime string, :values [string], :periodMillis string},
  :valuePattern string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :barcode
 {:kind string,
  :alternateText string,
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :value string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :hasLinkedDevice boolean,
 :groupingInfo {:groupingId string, :sortIndex integer},
 :state
 [STATE_UNSPECIFIED
  ACTIVE
  active
  COMPLETED
  completed
  EXPIRED
  expired
  INACTIVE
  inactive],
 :classReference
 {:localScheduledDepartureDateTime string,
  :wordMark
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :localGateClosingDateTime string,
  :localBoardingDateTime string,
  :reviewStatus
  [REVIEW_STATUS_UNSPECIFIED
   UNDER_REVIEW
   underReview
   APPROVED
   approved
   REJECTED
   rejected
   DRAFT
   draft],
  :boardingAndSeatingPolicy
  {:boardingPolicy
   [BOARDING_POLICY_UNSPECIFIED
    ZONE_BASED
    zoneBased
    GROUP_BASED
    groupBased
    BOARDING_POLICY_OTHER
    boardingPolicyOther],
   :kind string,
   :seatClassPolicy
   [SEAT_CLASS_POLICY_UNSPECIFIED
    CABIN_BASED
    cabinBased
    CLASS_BASED
    classBased
    TIER_BASED
    tierBased
    SEAT_CLASS_POLICY_OTHER
    seatClassPolicyOther]},
  :textModulesData
  [{:header string,
    :id string,
    :localizedHeader
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :localizedBody
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :body string}],
  :issuerName string,
  :flightHeader
  {:kind string,
   :flightNumberDisplayOverride string,
   :flightNumber string,
   :operatingCarrier
   {:kind string,
    :wideAirlineLogo
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :carrierIataCode string,
    :airlineAllianceLogo
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :airlineLogo
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :carrierIcaoCode string,
    :airlineName
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString}},
   :carrier
   {:kind string,
    :wideAirlineLogo
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :carrierIataCode string,
    :airlineAllianceLogo
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :airlineLogo
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :carrierIcaoCode string,
    :airlineName
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString}},
   :operatingFlightNumber string},
  :localEstimatedOrActualArrivalDateTime string,
  :securityAnimation
  {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
  :multipleDevicesAndHoldersAllowedStatus
  [STATUS_UNSPECIFIED
   MULTIPLE_HOLDERS
   ONE_USER_ALL_DEVICES
   ONE_USER_ONE_DEVICE
   multipleHolders
   oneUserAllDevices
   oneUserOneDevice],
  :homepageUri
  {:description string,
   :kind string,
   :id string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :callbackOptions {:updateRequestUrl string, :url string},
  :linksModuleData
  {:uris
   [{:description string,
     :kind string,
     :id string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string}]},
  :imageModulesData
  [{:id string,
    :mainImage
    {:contentDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :sourceUri
     {:description string,
      :localizedDescription LocalizedString,
      :uri string},
     :kind string}}],
  :locations [{:longitude number, :kind string, :latitude number}],
  :allowMultipleUsersPerObject boolean,
  :hexBackgroundColor string,
  :messages
  [{:kind string,
    :displayInterval
    {:start {:date string}, :kind string, :end {:date string}},
    :body string,
    :localizedBody
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :id string,
    :messageType
    [MESSAGE_TYPE_UNSPECIFIED
     TEXT
     text
     EXPIRATION_NOTIFICATION
     expirationNotification
     TEXT_AND_NOTIFY],
    :localizedHeader
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :header string}],
  :localizedIssuerName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :redemptionIssuers [string],
  :localEstimatedOrActualDepartureDateTime string,
  :review {:comments string},
  :localScheduledArrivalDateTime string,
  :id string,
  :kind string,
  :flightStatus
  [FLIGHT_STATUS_UNSPECIFIED
   SCHEDULED
   scheduled
   ACTIVE
   active
   LANDED
   landed
   CANCELLED
   cancelled
   REDIRECTED
   redirected
   DIVERTED
   diverted],
  :appLinkData
  {:androidAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}},
   :webAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}},
   :iosAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}}},
  :origin
  {:airportIataCode string,
   :kind string,
   :gate string,
   :airportNameOverride
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :terminal string},
  :classTemplateInfo
  {:detailsTemplateOverride {:detailsItemInfos [{:item TemplateItem}]},
   :listTemplateOverride
   {:firstRowOption
    {:transitOption
     [TRANSIT_OPTION_UNSPECIFIED
      ORIGIN_AND_DESTINATION_NAMES
      originAndDestinationNames
      ORIGIN_AND_DESTINATION_CODES
      originAndDestinationCodes
      ORIGIN_NAME
      originName],
     :fieldOption FieldSelector},
    :secondRowOption {:fields [FieldReference]},
    :thirdRowOption {:fields [FieldReference]}},
   :cardTemplateOverride
   {:cardRowTemplateInfos
    [{:oneItem CardRowOneItem,
      :twoItems CardRowTwoItems,
      :threeItems CardRowThreeItems}]},
   :cardBarcodeSectionDetails
   {:firstTopDetail {:fieldSelector FieldSelector},
    :secondTopDetail {:fieldSelector FieldSelector},
    :firstBottomDetail {:fieldSelector FieldSelector}}},
  :enableSmartTap boolean,
  :version string,
  :viewUnlockRequirement
  [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
   UNLOCK_NOT_REQUIRED
   UNLOCK_REQUIRED_TO_VIEW],
  :infoModuleData
  {:showLastUpdateTime boolean,
   :labelValueRows
   [{:columns
     [{:localizedLabel LocalizedString,
       :localizedValue LocalizedString,
       :label string,
       :value string}]}]},
  :heroImage
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :destination
  {:airportIataCode string,
   :kind string,
   :gate string,
   :airportNameOverride
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :terminal string},
  :countryCode string,
  :languageOverride string},
 :disableExpirationNotification boolean,
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :validTimeInterval
 {:start {:date string}, :kind string, :end {:date string}},
 :locations [{:longitude number, :kind string, :latitude number}],
 :boardingAndSeatingInfo
 {:sequenceNumber string,
  :seatAssignment
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :seatNumber string,
  :boardingPosition string,
  :kind string,
  :boardingGroup string,
  :boardingPrivilegeImage
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :boardingDoor [BOARDING_DOOR_UNSPECIFIED FRONT front BACK back],
  :seatClass string},
 :hexBackgroundColor string,
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :id string,
 :kind string,
 :classId string,
 :passengerName string,
 :passConstraints
 {:nfcConstraint
  [[NFC_CONSTRAINT_UNSPECIFIED
    BLOCK_PAYMENT
    BLOCK_CLOSED_LOOP_TRANSIT]],
  :screenshotEligibility
  [SCREENSHOT_ELIGIBILITY_UNSPECIFIED ELIGIBLE INELIGIBLE]},
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :version string,
 :infoModuleData
 {:showLastUpdateTime boolean,
  :labelValueRows
  [{:columns
    [{:localizedLabel
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :localizedValue
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :label string,
      :value string}]}]},
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string}}"
  [resourceId FlightObject]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/flightObject/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body FlightObject}))

(defn smarttap-insert
  "Inserts the smart tap.
https://developers.google.com/wallet/reference/rest/v1/smarttap/insert

SmartTap:
{:id string,
 :infos
 [{:action [ACTION_UNSPECIFIED S2AP s2ap SIGN_UP signUp],
   :value string,
   :signUpInfo {:classId string},
   :url string}],
 :kind string,
 :merchantId string}"
  [SmartTap]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/smartTap",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body SmartTap}))

(defn flightclass-insert
  "Inserts an flight class with the given ID and properties.
https://developers.google.com/wallet/reference/rest/v1/flightclass/insert

FlightClass:
{:localScheduledDepartureDateTime string,
 :wordMark
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :localGateClosingDateTime string,
 :localBoardingDateTime string,
 :reviewStatus
 [REVIEW_STATUS_UNSPECIFIED
  UNDER_REVIEW
  underReview
  APPROVED
  approved
  REJECTED
  rejected
  DRAFT
  draft],
 :boardingAndSeatingPolicy
 {:boardingPolicy
  [BOARDING_POLICY_UNSPECIFIED
   ZONE_BASED
   zoneBased
   GROUP_BASED
   groupBased
   BOARDING_POLICY_OTHER
   boardingPolicyOther],
  :kind string,
  :seatClassPolicy
  [SEAT_CLASS_POLICY_UNSPECIFIED
   CABIN_BASED
   cabinBased
   CLASS_BASED
   classBased
   TIER_BASED
   tierBased
   SEAT_CLASS_POLICY_OTHER
   seatClassPolicyOther]},
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :issuerName string,
 :flightHeader
 {:kind string,
  :flightNumberDisplayOverride string,
  :flightNumber string,
  :operatingCarrier
  {:kind string,
   :wideAirlineLogo
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :carrierIataCode string,
   :airlineAllianceLogo
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :airlineLogo
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :carrierIcaoCode string,
   :airlineName
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}}},
  :carrier
  {:kind string,
   :wideAirlineLogo
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :carrierIataCode string,
   :airlineAllianceLogo
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :airlineLogo
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :carrierIcaoCode string,
   :airlineName
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}}},
  :operatingFlightNumber string},
 :localEstimatedOrActualArrivalDateTime string,
 :securityAnimation
 {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
 :multipleDevicesAndHoldersAllowedStatus
 [STATUS_UNSPECIFIED
  MULTIPLE_HOLDERS
  ONE_USER_ALL_DEVICES
  ONE_USER_ONE_DEVICE
  multipleHolders
  oneUserAllDevices
  oneUserOneDevice],
 :homepageUri
 {:description string,
  :kind string,
  :id string,
  :localizedDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :uri string},
 :callbackOptions {:updateRequestUrl string, :url string},
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :locations [{:longitude number, :kind string, :latitude number}],
 :allowMultipleUsersPerObject boolean,
 :hexBackgroundColor string,
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :localizedIssuerName
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :redemptionIssuers [string],
 :localEstimatedOrActualDepartureDateTime string,
 :review {:comments string},
 :localScheduledArrivalDateTime string,
 :id string,
 :kind string,
 :flightStatus
 [FLIGHT_STATUS_UNSPECIFIED
  SCHEDULED
  scheduled
  ACTIVE
  active
  LANDED
  landed
  CANCELLED
  cancelled
  REDIRECTED
  redirected
  DIVERTED
  diverted],
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :origin
 {:airportIataCode string,
  :kind string,
  :gate string,
  :airportNameOverride
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :terminal string},
 :classTemplateInfo
 {:detailsTemplateOverride
  {:detailsItemInfos
   [{:item
     {:firstValue FieldSelector,
      :predefinedItem
      [PREDEFINED_ITEM_UNSPECIFIED
       FREQUENT_FLYER_PROGRAM_NAME_AND_NUMBER
       frequentFlyerProgramNameAndNumber
       FLIGHT_NUMBER_AND_OPERATING_FLIGHT_NUMBER
       flightNumberAndOperatingFlightNumber],
      :secondValue FieldSelector}}]},
  :listTemplateOverride
  {:firstRowOption
   {:transitOption
    [TRANSIT_OPTION_UNSPECIFIED
     ORIGIN_AND_DESTINATION_NAMES
     originAndDestinationNames
     ORIGIN_AND_DESTINATION_CODES
     originAndDestinationCodes
     ORIGIN_NAME
     originName],
    :fieldOption {:fields [FieldReference]}},
   :secondRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]},
   :thirdRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]}},
  :cardTemplateOverride
  {:cardRowTemplateInfos
   [{:oneItem {:item TemplateItem},
     :twoItems {:endItem TemplateItem, :startItem TemplateItem},
     :threeItems
     {:startItem TemplateItem,
      :middleItem TemplateItem,
      :endItem TemplateItem}}]},
  :cardBarcodeSectionDetails
  {:firstTopDetail {:fieldSelector {:fields [FieldReference]}},
   :secondTopDetail {:fieldSelector {:fields [FieldReference]}},
   :firstBottomDetail {:fieldSelector {:fields [FieldReference]}}}},
 :enableSmartTap boolean,
 :version string,
 :viewUnlockRequirement
 [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
  UNLOCK_NOT_REQUIRED
  UNLOCK_REQUIRED_TO_VIEW],
 :infoModuleData
 {:showLastUpdateTime boolean,
  :labelValueRows
  [{:columns
    [{:localizedLabel
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :localizedValue
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :label string,
      :value string}]}]},
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :destination
 {:airportIataCode string,
  :kind string,
  :gate string,
  :airportNameOverride
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :terminal string},
 :countryCode string,
 :languageOverride string}"
  [FlightClass]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/flightClass",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body FlightClass}))

(defn flightclass-list
  "Returns a list of all flight classes for a given issuer ID.
https://developers.google.com/wallet/reference/rest/v1/flightclass/list

optional:
maxResults <integer> Identifies the max number of results returned by a list. All results are returned if `maxResults` isn't defined.
issuerId <string> The ID of the issuer authorized to list classes.
token <string> Used to get the next set of results if `maxResults` is specified, but more than `maxResults` classes are available in a list. For example, if you have a list of 200 classes and you call list with `maxResults` set to 20, list will return the first 20 classes and a token. Call list again with `maxResults` set to 20 and the token to get the next 20 classes."
  ([] (flightclass-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://walletobjects.googleapis.com/walletobjects/v1/flightClass",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/wallet_object.issuer"]})))

(defn flightclass-update
  "Updates the flight class referenced by the given class ID.
https://developers.google.com/wallet/reference/rest/v1/flightclass/update

resourceId <string> The unique identifier for a class. This ID must be unique across all classes from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
FlightClass:
{:localScheduledDepartureDateTime string,
 :wordMark
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :localGateClosingDateTime string,
 :localBoardingDateTime string,
 :reviewStatus
 [REVIEW_STATUS_UNSPECIFIED
  UNDER_REVIEW
  underReview
  APPROVED
  approved
  REJECTED
  rejected
  DRAFT
  draft],
 :boardingAndSeatingPolicy
 {:boardingPolicy
  [BOARDING_POLICY_UNSPECIFIED
   ZONE_BASED
   zoneBased
   GROUP_BASED
   groupBased
   BOARDING_POLICY_OTHER
   boardingPolicyOther],
  :kind string,
  :seatClassPolicy
  [SEAT_CLASS_POLICY_UNSPECIFIED
   CABIN_BASED
   cabinBased
   CLASS_BASED
   classBased
   TIER_BASED
   tierBased
   SEAT_CLASS_POLICY_OTHER
   seatClassPolicyOther]},
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :issuerName string,
 :flightHeader
 {:kind string,
  :flightNumberDisplayOverride string,
  :flightNumber string,
  :operatingCarrier
  {:kind string,
   :wideAirlineLogo
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :carrierIataCode string,
   :airlineAllianceLogo
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :airlineLogo
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :carrierIcaoCode string,
   :airlineName
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}}},
  :carrier
  {:kind string,
   :wideAirlineLogo
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :carrierIataCode string,
   :airlineAllianceLogo
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :airlineLogo
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :carrierIcaoCode string,
   :airlineName
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}}},
  :operatingFlightNumber string},
 :localEstimatedOrActualArrivalDateTime string,
 :securityAnimation
 {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
 :multipleDevicesAndHoldersAllowedStatus
 [STATUS_UNSPECIFIED
  MULTIPLE_HOLDERS
  ONE_USER_ALL_DEVICES
  ONE_USER_ONE_DEVICE
  multipleHolders
  oneUserAllDevices
  oneUserOneDevice],
 :homepageUri
 {:description string,
  :kind string,
  :id string,
  :localizedDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :uri string},
 :callbackOptions {:updateRequestUrl string, :url string},
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :locations [{:longitude number, :kind string, :latitude number}],
 :allowMultipleUsersPerObject boolean,
 :hexBackgroundColor string,
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :localizedIssuerName
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :redemptionIssuers [string],
 :localEstimatedOrActualDepartureDateTime string,
 :review {:comments string},
 :localScheduledArrivalDateTime string,
 :id string,
 :kind string,
 :flightStatus
 [FLIGHT_STATUS_UNSPECIFIED
  SCHEDULED
  scheduled
  ACTIVE
  active
  LANDED
  landed
  CANCELLED
  cancelled
  REDIRECTED
  redirected
  DIVERTED
  diverted],
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :origin
 {:airportIataCode string,
  :kind string,
  :gate string,
  :airportNameOverride
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :terminal string},
 :classTemplateInfo
 {:detailsTemplateOverride
  {:detailsItemInfos
   [{:item
     {:firstValue FieldSelector,
      :predefinedItem
      [PREDEFINED_ITEM_UNSPECIFIED
       FREQUENT_FLYER_PROGRAM_NAME_AND_NUMBER
       frequentFlyerProgramNameAndNumber
       FLIGHT_NUMBER_AND_OPERATING_FLIGHT_NUMBER
       flightNumberAndOperatingFlightNumber],
      :secondValue FieldSelector}}]},
  :listTemplateOverride
  {:firstRowOption
   {:transitOption
    [TRANSIT_OPTION_UNSPECIFIED
     ORIGIN_AND_DESTINATION_NAMES
     originAndDestinationNames
     ORIGIN_AND_DESTINATION_CODES
     originAndDestinationCodes
     ORIGIN_NAME
     originName],
    :fieldOption {:fields [FieldReference]}},
   :secondRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]},
   :thirdRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]}},
  :cardTemplateOverride
  {:cardRowTemplateInfos
   [{:oneItem {:item TemplateItem},
     :twoItems {:endItem TemplateItem, :startItem TemplateItem},
     :threeItems
     {:startItem TemplateItem,
      :middleItem TemplateItem,
      :endItem TemplateItem}}]},
  :cardBarcodeSectionDetails
  {:firstTopDetail {:fieldSelector {:fields [FieldReference]}},
   :secondTopDetail {:fieldSelector {:fields [FieldReference]}},
   :firstBottomDetail {:fieldSelector {:fields [FieldReference]}}}},
 :enableSmartTap boolean,
 :version string,
 :viewUnlockRequirement
 [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
  UNLOCK_NOT_REQUIRED
  UNLOCK_REQUIRED_TO_VIEW],
 :infoModuleData
 {:showLastUpdateTime boolean,
  :labelValueRows
  [{:columns
    [{:localizedLabel
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :localizedValue
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :label string,
      :value string}]}]},
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :destination
 {:airportIataCode string,
  :kind string,
  :gate string,
  :airportNameOverride
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :terminal string},
 :countryCode string,
 :languageOverride string}"
  [resourceId FlightClass]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/flightClass/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body FlightClass}))

(defn flightclass-get
  "Returns the flight class with the given class ID.
https://developers.google.com/wallet/reference/rest/v1/flightclass/get

resourceId <string> The unique identifier for a class. This ID must be unique across all classes from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'."
  [resourceId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/flightClass/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}))

(defn flightclass-patch
  "Updates the flight class referenced by the given class ID. This method supports patch semantics.
https://developers.google.com/wallet/reference/rest/v1/flightclass/patch

resourceId <string> The unique identifier for a class. This ID must be unique across all classes from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
FlightClass:
{:localScheduledDepartureDateTime string,
 :wordMark
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :localGateClosingDateTime string,
 :localBoardingDateTime string,
 :reviewStatus
 [REVIEW_STATUS_UNSPECIFIED
  UNDER_REVIEW
  underReview
  APPROVED
  approved
  REJECTED
  rejected
  DRAFT
  draft],
 :boardingAndSeatingPolicy
 {:boardingPolicy
  [BOARDING_POLICY_UNSPECIFIED
   ZONE_BASED
   zoneBased
   GROUP_BASED
   groupBased
   BOARDING_POLICY_OTHER
   boardingPolicyOther],
  :kind string,
  :seatClassPolicy
  [SEAT_CLASS_POLICY_UNSPECIFIED
   CABIN_BASED
   cabinBased
   CLASS_BASED
   classBased
   TIER_BASED
   tierBased
   SEAT_CLASS_POLICY_OTHER
   seatClassPolicyOther]},
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :issuerName string,
 :flightHeader
 {:kind string,
  :flightNumberDisplayOverride string,
  :flightNumber string,
  :operatingCarrier
  {:kind string,
   :wideAirlineLogo
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :carrierIataCode string,
   :airlineAllianceLogo
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :airlineLogo
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :carrierIcaoCode string,
   :airlineName
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}}},
  :carrier
  {:kind string,
   :wideAirlineLogo
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :carrierIataCode string,
   :airlineAllianceLogo
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :airlineLogo
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :carrierIcaoCode string,
   :airlineName
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}}},
  :operatingFlightNumber string},
 :localEstimatedOrActualArrivalDateTime string,
 :securityAnimation
 {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
 :multipleDevicesAndHoldersAllowedStatus
 [STATUS_UNSPECIFIED
  MULTIPLE_HOLDERS
  ONE_USER_ALL_DEVICES
  ONE_USER_ONE_DEVICE
  multipleHolders
  oneUserAllDevices
  oneUserOneDevice],
 :homepageUri
 {:description string,
  :kind string,
  :id string,
  :localizedDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :uri string},
 :callbackOptions {:updateRequestUrl string, :url string},
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :locations [{:longitude number, :kind string, :latitude number}],
 :allowMultipleUsersPerObject boolean,
 :hexBackgroundColor string,
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :localizedIssuerName
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :redemptionIssuers [string],
 :localEstimatedOrActualDepartureDateTime string,
 :review {:comments string},
 :localScheduledArrivalDateTime string,
 :id string,
 :kind string,
 :flightStatus
 [FLIGHT_STATUS_UNSPECIFIED
  SCHEDULED
  scheduled
  ACTIVE
  active
  LANDED
  landed
  CANCELLED
  cancelled
  REDIRECTED
  redirected
  DIVERTED
  diverted],
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :origin
 {:airportIataCode string,
  :kind string,
  :gate string,
  :airportNameOverride
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :terminal string},
 :classTemplateInfo
 {:detailsTemplateOverride
  {:detailsItemInfos
   [{:item
     {:firstValue FieldSelector,
      :predefinedItem
      [PREDEFINED_ITEM_UNSPECIFIED
       FREQUENT_FLYER_PROGRAM_NAME_AND_NUMBER
       frequentFlyerProgramNameAndNumber
       FLIGHT_NUMBER_AND_OPERATING_FLIGHT_NUMBER
       flightNumberAndOperatingFlightNumber],
      :secondValue FieldSelector}}]},
  :listTemplateOverride
  {:firstRowOption
   {:transitOption
    [TRANSIT_OPTION_UNSPECIFIED
     ORIGIN_AND_DESTINATION_NAMES
     originAndDestinationNames
     ORIGIN_AND_DESTINATION_CODES
     originAndDestinationCodes
     ORIGIN_NAME
     originName],
    :fieldOption {:fields [FieldReference]}},
   :secondRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]},
   :thirdRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]}},
  :cardTemplateOverride
  {:cardRowTemplateInfos
   [{:oneItem {:item TemplateItem},
     :twoItems {:endItem TemplateItem, :startItem TemplateItem},
     :threeItems
     {:startItem TemplateItem,
      :middleItem TemplateItem,
      :endItem TemplateItem}}]},
  :cardBarcodeSectionDetails
  {:firstTopDetail {:fieldSelector {:fields [FieldReference]}},
   :secondTopDetail {:fieldSelector {:fields [FieldReference]}},
   :firstBottomDetail {:fieldSelector {:fields [FieldReference]}}}},
 :enableSmartTap boolean,
 :version string,
 :viewUnlockRequirement
 [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
  UNLOCK_NOT_REQUIRED
  UNLOCK_REQUIRED_TO_VIEW],
 :infoModuleData
 {:showLastUpdateTime boolean,
  :labelValueRows
  [{:columns
    [{:localizedLabel
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :localizedValue
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :label string,
      :value string}]}]},
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :destination
 {:airportIataCode string,
  :kind string,
  :gate string,
  :airportNameOverride
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :terminal string},
 :countryCode string,
 :languageOverride string}"
  [resourceId FlightClass]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/flightClass/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body FlightClass}))

(defn flightclass-addmessage
  "Adds a message to the flight class referenced by the given class ID.
https://developers.google.com/wallet/reference/rest/v1/flightclass/addmessage

resourceId <string> The unique identifier for a class. This ID must be unique across all classes from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
AddMessageRequest:
{:message
 {:kind string,
  :displayInterval
  {:start {:date string}, :kind string, :end {:date string}},
  :body string,
  :localizedBody
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :id string,
  :messageType
  [MESSAGE_TYPE_UNSPECIFIED
   TEXT
   text
   EXPIRATION_NOTIFICATION
   expirationNotification
   TEXT_AND_NOTIFY],
  :localizedHeader
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :header string}}"
  [resourceId AddMessageRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/flightClass/{resourceId}/addMessage",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body AddMessageRequest}))

(defn transitclass-patch
  "Updates the transit class referenced by the given class ID. This method supports patch semantics.
https://developers.google.com/wallet/reference/rest/v1/transitclass/patch

resourceId <string> The unique identifier for a class. This ID must be unique across all classes from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
TransitClass:
{:wordMark
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :transitType
 [TRANSIT_TYPE_UNSPECIFIED
  BUS
  bus
  RAIL
  rail
  TRAM
  tram
  FERRY
  ferry
  OTHER
  other],
 :customFareNameLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :customDiscountMessageLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :customPlatformLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :reviewStatus
 [REVIEW_STATUS_UNSPECIFIED
  UNDER_REVIEW
  underReview
  APPROVED
  approved
  REJECTED
  rejected
  DRAFT
  draft],
 :customRouteRestrictionsDetailsLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :customCarriageLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :issuerName string,
 :customZoneLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :customFareClassLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :customPurchaseReceiptNumberLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :logo
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :activationOptions
 {:activationUrl string, :allowReactivation boolean},
 :enableSingleLegItinerary boolean,
 :wideLogo
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :securityAnimation
 {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
 :multipleDevicesAndHoldersAllowedStatus
 [STATUS_UNSPECIFIED
  MULTIPLE_HOLDERS
  ONE_USER_ALL_DEVICES
  ONE_USER_ONE_DEVICE
  multipleHolders
  oneUserAllDevices
  oneUserOneDevice],
 :transitOperatorName
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :homepageUri
 {:description string,
  :kind string,
  :id string,
  :localizedDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :uri string},
 :customConcessionCategoryLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :customSeatLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :customTransitTerminusNameLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :callbackOptions {:updateRequestUrl string, :url string},
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :customRouteRestrictionsLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :locations [{:longitude number, :kind string, :latitude number}],
 :allowMultipleUsersPerObject boolean,
 :hexBackgroundColor string,
 :customTimeRestrictionsLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :customOtherRestrictionsLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :localizedIssuerName
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :redemptionIssuers [string],
 :review {:comments string},
 :id string,
 :customPurchaseFaceValueLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :customConfirmationCodeLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :customCoachLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :classTemplateInfo
 {:detailsTemplateOverride
  {:detailsItemInfos
   [{:item
     {:firstValue FieldSelector,
      :predefinedItem
      [PREDEFINED_ITEM_UNSPECIFIED
       FREQUENT_FLYER_PROGRAM_NAME_AND_NUMBER
       frequentFlyerProgramNameAndNumber
       FLIGHT_NUMBER_AND_OPERATING_FLIGHT_NUMBER
       flightNumberAndOperatingFlightNumber],
      :secondValue FieldSelector}}]},
  :listTemplateOverride
  {:firstRowOption
   {:transitOption
    [TRANSIT_OPTION_UNSPECIFIED
     ORIGIN_AND_DESTINATION_NAMES
     originAndDestinationNames
     ORIGIN_AND_DESTINATION_CODES
     originAndDestinationCodes
     ORIGIN_NAME
     originName],
    :fieldOption {:fields [FieldReference]}},
   :secondRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]},
   :thirdRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]}},
  :cardTemplateOverride
  {:cardRowTemplateInfos
   [{:oneItem {:item TemplateItem},
     :twoItems {:endItem TemplateItem, :startItem TemplateItem},
     :threeItems
     {:startItem TemplateItem,
      :middleItem TemplateItem,
      :endItem TemplateItem}}]},
  :cardBarcodeSectionDetails
  {:firstTopDetail {:fieldSelector {:fields [FieldReference]}},
   :secondTopDetail {:fieldSelector {:fields [FieldReference]}},
   :firstBottomDetail {:fieldSelector {:fields [FieldReference]}}}},
 :enableSmartTap boolean,
 :version string,
 :customPurchasePriceLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :viewUnlockRequirement
 [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
  UNLOCK_NOT_REQUIRED
  UNLOCK_REQUIRED_TO_VIEW],
 :infoModuleData
 {:showLastUpdateTime boolean,
  :labelValueRows
  [{:columns
    [{:localizedLabel
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :localizedValue
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :label string,
      :value string}]}]},
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :watermark
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :countryCode string,
 :customTicketNumberLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :languageOverride string}"
  [resourceId TransitClass]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/transitClass/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body TransitClass}))

(defn transitclass-addmessage
  "Adds a message to the transit class referenced by the given class ID.
https://developers.google.com/wallet/reference/rest/v1/transitclass/addmessage

resourceId <string> The unique identifier for a class. This ID must be unique across all classes from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
AddMessageRequest:
{:message
 {:kind string,
  :displayInterval
  {:start {:date string}, :kind string, :end {:date string}},
  :body string,
  :localizedBody
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :id string,
  :messageType
  [MESSAGE_TYPE_UNSPECIFIED
   TEXT
   text
   EXPIRATION_NOTIFICATION
   expirationNotification
   TEXT_AND_NOTIFY],
  :localizedHeader
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :header string}}"
  [resourceId AddMessageRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/transitClass/{resourceId}/addMessage",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body AddMessageRequest}))

(defn transitclass-insert
  "Inserts a transit class with the given ID and properties.
https://developers.google.com/wallet/reference/rest/v1/transitclass/insert

TransitClass:
{:wordMark
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :transitType
 [TRANSIT_TYPE_UNSPECIFIED
  BUS
  bus
  RAIL
  rail
  TRAM
  tram
  FERRY
  ferry
  OTHER
  other],
 :customFareNameLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :customDiscountMessageLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :customPlatformLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :reviewStatus
 [REVIEW_STATUS_UNSPECIFIED
  UNDER_REVIEW
  underReview
  APPROVED
  approved
  REJECTED
  rejected
  DRAFT
  draft],
 :customRouteRestrictionsDetailsLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :customCarriageLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :issuerName string,
 :customZoneLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :customFareClassLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :customPurchaseReceiptNumberLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :logo
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :activationOptions
 {:activationUrl string, :allowReactivation boolean},
 :enableSingleLegItinerary boolean,
 :wideLogo
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :securityAnimation
 {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
 :multipleDevicesAndHoldersAllowedStatus
 [STATUS_UNSPECIFIED
  MULTIPLE_HOLDERS
  ONE_USER_ALL_DEVICES
  ONE_USER_ONE_DEVICE
  multipleHolders
  oneUserAllDevices
  oneUserOneDevice],
 :transitOperatorName
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :homepageUri
 {:description string,
  :kind string,
  :id string,
  :localizedDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :uri string},
 :customConcessionCategoryLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :customSeatLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :customTransitTerminusNameLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :callbackOptions {:updateRequestUrl string, :url string},
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :customRouteRestrictionsLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :locations [{:longitude number, :kind string, :latitude number}],
 :allowMultipleUsersPerObject boolean,
 :hexBackgroundColor string,
 :customTimeRestrictionsLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :customOtherRestrictionsLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :localizedIssuerName
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :redemptionIssuers [string],
 :review {:comments string},
 :id string,
 :customPurchaseFaceValueLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :customConfirmationCodeLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :customCoachLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :classTemplateInfo
 {:detailsTemplateOverride
  {:detailsItemInfos
   [{:item
     {:firstValue FieldSelector,
      :predefinedItem
      [PREDEFINED_ITEM_UNSPECIFIED
       FREQUENT_FLYER_PROGRAM_NAME_AND_NUMBER
       frequentFlyerProgramNameAndNumber
       FLIGHT_NUMBER_AND_OPERATING_FLIGHT_NUMBER
       flightNumberAndOperatingFlightNumber],
      :secondValue FieldSelector}}]},
  :listTemplateOverride
  {:firstRowOption
   {:transitOption
    [TRANSIT_OPTION_UNSPECIFIED
     ORIGIN_AND_DESTINATION_NAMES
     originAndDestinationNames
     ORIGIN_AND_DESTINATION_CODES
     originAndDestinationCodes
     ORIGIN_NAME
     originName],
    :fieldOption {:fields [FieldReference]}},
   :secondRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]},
   :thirdRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]}},
  :cardTemplateOverride
  {:cardRowTemplateInfos
   [{:oneItem {:item TemplateItem},
     :twoItems {:endItem TemplateItem, :startItem TemplateItem},
     :threeItems
     {:startItem TemplateItem,
      :middleItem TemplateItem,
      :endItem TemplateItem}}]},
  :cardBarcodeSectionDetails
  {:firstTopDetail {:fieldSelector {:fields [FieldReference]}},
   :secondTopDetail {:fieldSelector {:fields [FieldReference]}},
   :firstBottomDetail {:fieldSelector {:fields [FieldReference]}}}},
 :enableSmartTap boolean,
 :version string,
 :customPurchasePriceLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :viewUnlockRequirement
 [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
  UNLOCK_NOT_REQUIRED
  UNLOCK_REQUIRED_TO_VIEW],
 :infoModuleData
 {:showLastUpdateTime boolean,
  :labelValueRows
  [{:columns
    [{:localizedLabel
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :localizedValue
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :label string,
      :value string}]}]},
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :watermark
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :countryCode string,
 :customTicketNumberLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :languageOverride string}"
  [TransitClass]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/transitClass",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body TransitClass}))

(defn transitclass-update
  "Updates the transit class referenced by the given class ID.
https://developers.google.com/wallet/reference/rest/v1/transitclass/update

resourceId <string> The unique identifier for a class. This ID must be unique across all classes from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
TransitClass:
{:wordMark
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :transitType
 [TRANSIT_TYPE_UNSPECIFIED
  BUS
  bus
  RAIL
  rail
  TRAM
  tram
  FERRY
  ferry
  OTHER
  other],
 :customFareNameLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :customDiscountMessageLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :customPlatformLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :reviewStatus
 [REVIEW_STATUS_UNSPECIFIED
  UNDER_REVIEW
  underReview
  APPROVED
  approved
  REJECTED
  rejected
  DRAFT
  draft],
 :customRouteRestrictionsDetailsLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :customCarriageLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :issuerName string,
 :customZoneLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :customFareClassLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :customPurchaseReceiptNumberLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :logo
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :activationOptions
 {:activationUrl string, :allowReactivation boolean},
 :enableSingleLegItinerary boolean,
 :wideLogo
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :securityAnimation
 {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
 :multipleDevicesAndHoldersAllowedStatus
 [STATUS_UNSPECIFIED
  MULTIPLE_HOLDERS
  ONE_USER_ALL_DEVICES
  ONE_USER_ONE_DEVICE
  multipleHolders
  oneUserAllDevices
  oneUserOneDevice],
 :transitOperatorName
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :homepageUri
 {:description string,
  :kind string,
  :id string,
  :localizedDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :uri string},
 :customConcessionCategoryLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :customSeatLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :customTransitTerminusNameLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :callbackOptions {:updateRequestUrl string, :url string},
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :customRouteRestrictionsLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :locations [{:longitude number, :kind string, :latitude number}],
 :allowMultipleUsersPerObject boolean,
 :hexBackgroundColor string,
 :customTimeRestrictionsLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :customOtherRestrictionsLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :localizedIssuerName
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :redemptionIssuers [string],
 :review {:comments string},
 :id string,
 :customPurchaseFaceValueLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :customConfirmationCodeLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :customCoachLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :classTemplateInfo
 {:detailsTemplateOverride
  {:detailsItemInfos
   [{:item
     {:firstValue FieldSelector,
      :predefinedItem
      [PREDEFINED_ITEM_UNSPECIFIED
       FREQUENT_FLYER_PROGRAM_NAME_AND_NUMBER
       frequentFlyerProgramNameAndNumber
       FLIGHT_NUMBER_AND_OPERATING_FLIGHT_NUMBER
       flightNumberAndOperatingFlightNumber],
      :secondValue FieldSelector}}]},
  :listTemplateOverride
  {:firstRowOption
   {:transitOption
    [TRANSIT_OPTION_UNSPECIFIED
     ORIGIN_AND_DESTINATION_NAMES
     originAndDestinationNames
     ORIGIN_AND_DESTINATION_CODES
     originAndDestinationCodes
     ORIGIN_NAME
     originName],
    :fieldOption {:fields [FieldReference]}},
   :secondRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]},
   :thirdRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]}},
  :cardTemplateOverride
  {:cardRowTemplateInfos
   [{:oneItem {:item TemplateItem},
     :twoItems {:endItem TemplateItem, :startItem TemplateItem},
     :threeItems
     {:startItem TemplateItem,
      :middleItem TemplateItem,
      :endItem TemplateItem}}]},
  :cardBarcodeSectionDetails
  {:firstTopDetail {:fieldSelector {:fields [FieldReference]}},
   :secondTopDetail {:fieldSelector {:fields [FieldReference]}},
   :firstBottomDetail {:fieldSelector {:fields [FieldReference]}}}},
 :enableSmartTap boolean,
 :version string,
 :customPurchasePriceLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :viewUnlockRequirement
 [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
  UNLOCK_NOT_REQUIRED
  UNLOCK_REQUIRED_TO_VIEW],
 :infoModuleData
 {:showLastUpdateTime boolean,
  :labelValueRows
  [{:columns
    [{:localizedLabel
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :localizedValue
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :label string,
      :value string}]}]},
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :watermark
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :countryCode string,
 :customTicketNumberLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :languageOverride string}"
  [resourceId TransitClass]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/transitClass/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body TransitClass}))

(defn transitclass-list
  "Returns a list of all transit classes for a given issuer ID.
https://developers.google.com/wallet/reference/rest/v1/transitclass/list

optional:
maxResults <integer> Identifies the max number of results returned by a list. All results are returned if `maxResults` isn't defined.
token <string> Used to get the next set of results if `maxResults` is specified, but more than `maxResults` classes are available in a list. For example, if you have a list of 200 classes and you call list with `maxResults` set to 20, list will return the first 20 classes and a token. Call list again with `maxResults` set to 20 and the token to get the next 20 classes.
issuerId <string> The ID of the issuer authorized to list classes."
  ([] (transitclass-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://walletobjects.googleapis.com/walletobjects/v1/transitClass",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/wallet_object.issuer"]})))

(defn transitclass-get
  "Returns the transit class with the given class ID.
https://developers.google.com/wallet/reference/rest/v1/transitclass/get

resourceId <string> The unique identifier for a class. This ID must be unique across all classes from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'."
  [resourceId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/transitClass/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}))

(defn giftcardclass-get
  "Returns the gift card class with the given class ID.
https://developers.google.com/wallet/reference/rest/v1/giftcardclass/get

resourceId <string> The unique identifier for a class. This ID must be unique across all classes from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'."
  [resourceId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/giftCardClass/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}))

(defn giftcardclass-update
  "Updates the gift card class referenced by the given class ID.
https://developers.google.com/wallet/reference/rest/v1/giftcardclass/update

resourceId <string> The unique identifier for a class. This ID must be unique across all classes from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
GiftCardClass:
{:wordMark
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :reviewStatus
 [REVIEW_STATUS_UNSPECIFIED
  UNDER_REVIEW
  underReview
  APPROVED
  approved
  REJECTED
  rejected
  DRAFT
  draft],
 :wideProgramLogo
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :issuerName string,
 :securityAnimation
 {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
 :multipleDevicesAndHoldersAllowedStatus
 [STATUS_UNSPECIFIED
  MULTIPLE_HOLDERS
  ONE_USER_ALL_DEVICES
  ONE_USER_ONE_DEVICE
  multipleHolders
  oneUserAllDevices
  oneUserOneDevice],
 :localizedEventNumberLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :pinLabel string,
 :merchantName string,
 :localizedMerchantName
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :homepageUri
 {:description string,
  :kind string,
  :id string,
  :localizedDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :uri string},
 :callbackOptions {:updateRequestUrl string, :url string},
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :locations [{:longitude number, :kind string, :latitude number}],
 :allowMultipleUsersPerObject boolean,
 :hexBackgroundColor string,
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :localizedIssuerName
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :redemptionIssuers [string],
 :review {:comments string},
 :programLogo
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :id string,
 :kind string,
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :localizedPinLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :classTemplateInfo
 {:detailsTemplateOverride
  {:detailsItemInfos
   [{:item
     {:firstValue FieldSelector,
      :predefinedItem
      [PREDEFINED_ITEM_UNSPECIFIED
       FREQUENT_FLYER_PROGRAM_NAME_AND_NUMBER
       frequentFlyerProgramNameAndNumber
       FLIGHT_NUMBER_AND_OPERATING_FLIGHT_NUMBER
       flightNumberAndOperatingFlightNumber],
      :secondValue FieldSelector}}]},
  :listTemplateOverride
  {:firstRowOption
   {:transitOption
    [TRANSIT_OPTION_UNSPECIFIED
     ORIGIN_AND_DESTINATION_NAMES
     originAndDestinationNames
     ORIGIN_AND_DESTINATION_CODES
     originAndDestinationCodes
     ORIGIN_NAME
     originName],
    :fieldOption {:fields [FieldReference]}},
   :secondRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]},
   :thirdRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]}},
  :cardTemplateOverride
  {:cardRowTemplateInfos
   [{:oneItem {:item TemplateItem},
     :twoItems {:endItem TemplateItem, :startItem TemplateItem},
     :threeItems
     {:startItem TemplateItem,
      :middleItem TemplateItem,
      :endItem TemplateItem}}]},
  :cardBarcodeSectionDetails
  {:firstTopDetail {:fieldSelector {:fields [FieldReference]}},
   :secondTopDetail {:fieldSelector {:fields [FieldReference]}},
   :firstBottomDetail {:fieldSelector {:fields [FieldReference]}}}},
 :enableSmartTap boolean,
 :cardNumberLabel string,
 :version string,
 :viewUnlockRequirement
 [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
  UNLOCK_NOT_REQUIRED
  UNLOCK_REQUIRED_TO_VIEW],
 :infoModuleData
 {:showLastUpdateTime boolean,
  :labelValueRows
  [{:columns
    [{:localizedLabel
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :localizedValue
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :label string,
      :value string}]}]},
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :allowBarcodeRedemption boolean,
 :eventNumberLabel string,
 :countryCode string,
 :localizedCardNumberLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}}}"
  [resourceId GiftCardClass]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/giftCardClass/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body GiftCardClass}))

(defn giftcardclass-list
  "Returns a list of all gift card classes for a given issuer ID.
https://developers.google.com/wallet/reference/rest/v1/giftcardclass/list

optional:
issuerId <string> The ID of the issuer authorized to list classes.
maxResults <integer> Identifies the max number of results returned by a list. All results are returned if `maxResults` isn't defined.
token <string> Used to get the next set of results if `maxResults` is specified, but more than `maxResults` classes are available in a list. For example, if you have a list of 200 classes and you call list with `maxResults` set to 20, list will return the first 20 classes and a token. Call list again with `maxResults` set to 20 and the token to get the next 20 classes."
  ([] (giftcardclass-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://walletobjects.googleapis.com/walletobjects/v1/giftCardClass",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/wallet_object.issuer"]})))

(defn giftcardclass-patch
  "Updates the gift card class referenced by the given class ID. This method supports patch semantics.
https://developers.google.com/wallet/reference/rest/v1/giftcardclass/patch

resourceId <string> The unique identifier for a class. This ID must be unique across all classes from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
GiftCardClass:
{:wordMark
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :reviewStatus
 [REVIEW_STATUS_UNSPECIFIED
  UNDER_REVIEW
  underReview
  APPROVED
  approved
  REJECTED
  rejected
  DRAFT
  draft],
 :wideProgramLogo
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :issuerName string,
 :securityAnimation
 {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
 :multipleDevicesAndHoldersAllowedStatus
 [STATUS_UNSPECIFIED
  MULTIPLE_HOLDERS
  ONE_USER_ALL_DEVICES
  ONE_USER_ONE_DEVICE
  multipleHolders
  oneUserAllDevices
  oneUserOneDevice],
 :localizedEventNumberLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :pinLabel string,
 :merchantName string,
 :localizedMerchantName
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :homepageUri
 {:description string,
  :kind string,
  :id string,
  :localizedDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :uri string},
 :callbackOptions {:updateRequestUrl string, :url string},
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :locations [{:longitude number, :kind string, :latitude number}],
 :allowMultipleUsersPerObject boolean,
 :hexBackgroundColor string,
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :localizedIssuerName
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :redemptionIssuers [string],
 :review {:comments string},
 :programLogo
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :id string,
 :kind string,
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :localizedPinLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :classTemplateInfo
 {:detailsTemplateOverride
  {:detailsItemInfos
   [{:item
     {:firstValue FieldSelector,
      :predefinedItem
      [PREDEFINED_ITEM_UNSPECIFIED
       FREQUENT_FLYER_PROGRAM_NAME_AND_NUMBER
       frequentFlyerProgramNameAndNumber
       FLIGHT_NUMBER_AND_OPERATING_FLIGHT_NUMBER
       flightNumberAndOperatingFlightNumber],
      :secondValue FieldSelector}}]},
  :listTemplateOverride
  {:firstRowOption
   {:transitOption
    [TRANSIT_OPTION_UNSPECIFIED
     ORIGIN_AND_DESTINATION_NAMES
     originAndDestinationNames
     ORIGIN_AND_DESTINATION_CODES
     originAndDestinationCodes
     ORIGIN_NAME
     originName],
    :fieldOption {:fields [FieldReference]}},
   :secondRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]},
   :thirdRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]}},
  :cardTemplateOverride
  {:cardRowTemplateInfos
   [{:oneItem {:item TemplateItem},
     :twoItems {:endItem TemplateItem, :startItem TemplateItem},
     :threeItems
     {:startItem TemplateItem,
      :middleItem TemplateItem,
      :endItem TemplateItem}}]},
  :cardBarcodeSectionDetails
  {:firstTopDetail {:fieldSelector {:fields [FieldReference]}},
   :secondTopDetail {:fieldSelector {:fields [FieldReference]}},
   :firstBottomDetail {:fieldSelector {:fields [FieldReference]}}}},
 :enableSmartTap boolean,
 :cardNumberLabel string,
 :version string,
 :viewUnlockRequirement
 [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
  UNLOCK_NOT_REQUIRED
  UNLOCK_REQUIRED_TO_VIEW],
 :infoModuleData
 {:showLastUpdateTime boolean,
  :labelValueRows
  [{:columns
    [{:localizedLabel
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :localizedValue
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :label string,
      :value string}]}]},
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :allowBarcodeRedemption boolean,
 :eventNumberLabel string,
 :countryCode string,
 :localizedCardNumberLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}}}"
  [resourceId GiftCardClass]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/giftCardClass/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body GiftCardClass}))

(defn giftcardclass-addmessage
  "Adds a message to the gift card class referenced by the given class ID.
https://developers.google.com/wallet/reference/rest/v1/giftcardclass/addmessage

resourceId <string> The unique identifier for a class. This ID must be unique across all classes from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
AddMessageRequest:
{:message
 {:kind string,
  :displayInterval
  {:start {:date string}, :kind string, :end {:date string}},
  :body string,
  :localizedBody
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :id string,
  :messageType
  [MESSAGE_TYPE_UNSPECIFIED
   TEXT
   text
   EXPIRATION_NOTIFICATION
   expirationNotification
   TEXT_AND_NOTIFY],
  :localizedHeader
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :header string}}"
  [resourceId AddMessageRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/giftCardClass/{resourceId}/addMessage",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body AddMessageRequest}))

(defn giftcardclass-insert
  "Inserts an gift card class with the given ID and properties.
https://developers.google.com/wallet/reference/rest/v1/giftcardclass/insert

GiftCardClass:
{:wordMark
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :reviewStatus
 [REVIEW_STATUS_UNSPECIFIED
  UNDER_REVIEW
  underReview
  APPROVED
  approved
  REJECTED
  rejected
  DRAFT
  draft],
 :wideProgramLogo
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :issuerName string,
 :securityAnimation
 {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
 :multipleDevicesAndHoldersAllowedStatus
 [STATUS_UNSPECIFIED
  MULTIPLE_HOLDERS
  ONE_USER_ALL_DEVICES
  ONE_USER_ONE_DEVICE
  multipleHolders
  oneUserAllDevices
  oneUserOneDevice],
 :localizedEventNumberLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :pinLabel string,
 :merchantName string,
 :localizedMerchantName
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :homepageUri
 {:description string,
  :kind string,
  :id string,
  :localizedDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :uri string},
 :callbackOptions {:updateRequestUrl string, :url string},
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :locations [{:longitude number, :kind string, :latitude number}],
 :allowMultipleUsersPerObject boolean,
 :hexBackgroundColor string,
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :localizedIssuerName
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :redemptionIssuers [string],
 :review {:comments string},
 :programLogo
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :id string,
 :kind string,
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :localizedPinLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :classTemplateInfo
 {:detailsTemplateOverride
  {:detailsItemInfos
   [{:item
     {:firstValue FieldSelector,
      :predefinedItem
      [PREDEFINED_ITEM_UNSPECIFIED
       FREQUENT_FLYER_PROGRAM_NAME_AND_NUMBER
       frequentFlyerProgramNameAndNumber
       FLIGHT_NUMBER_AND_OPERATING_FLIGHT_NUMBER
       flightNumberAndOperatingFlightNumber],
      :secondValue FieldSelector}}]},
  :listTemplateOverride
  {:firstRowOption
   {:transitOption
    [TRANSIT_OPTION_UNSPECIFIED
     ORIGIN_AND_DESTINATION_NAMES
     originAndDestinationNames
     ORIGIN_AND_DESTINATION_CODES
     originAndDestinationCodes
     ORIGIN_NAME
     originName],
    :fieldOption {:fields [FieldReference]}},
   :secondRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]},
   :thirdRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]}},
  :cardTemplateOverride
  {:cardRowTemplateInfos
   [{:oneItem {:item TemplateItem},
     :twoItems {:endItem TemplateItem, :startItem TemplateItem},
     :threeItems
     {:startItem TemplateItem,
      :middleItem TemplateItem,
      :endItem TemplateItem}}]},
  :cardBarcodeSectionDetails
  {:firstTopDetail {:fieldSelector {:fields [FieldReference]}},
   :secondTopDetail {:fieldSelector {:fields [FieldReference]}},
   :firstBottomDetail {:fieldSelector {:fields [FieldReference]}}}},
 :enableSmartTap boolean,
 :cardNumberLabel string,
 :version string,
 :viewUnlockRequirement
 [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
  UNLOCK_NOT_REQUIRED
  UNLOCK_REQUIRED_TO_VIEW],
 :infoModuleData
 {:showLastUpdateTime boolean,
  :labelValueRows
  [{:columns
    [{:localizedLabel
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :localizedValue
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :label string,
      :value string}]}]},
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :allowBarcodeRedemption boolean,
 :eventNumberLabel string,
 :countryCode string,
 :localizedCardNumberLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}}}"
  [GiftCardClass]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/giftCardClass",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body GiftCardClass}))

(defn offerobject-addmessage
  "Adds a message to the offer object referenced by the given object ID.
https://developers.google.com/wallet/reference/rest/v1/offerobject/addmessage

resourceId <string> The unique identifier for an object. This ID must be unique across all objects from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
AddMessageRequest:
{:message
 {:kind string,
  :displayInterval
  {:start {:date string}, :kind string, :end {:date string}},
  :body string,
  :localizedBody
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :id string,
  :messageType
  [MESSAGE_TYPE_UNSPECIFIED
   TEXT
   text
   EXPIRATION_NOTIFICATION
   expirationNotification
   TEXT_AND_NOTIFY],
  :localizedHeader
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :header string}}"
  [resourceId AddMessageRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/offerObject/{resourceId}/addMessage",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body AddMessageRequest}))

(defn offerobject-list
  "Returns a list of all offer objects for a given issuer ID.
https://developers.google.com/wallet/reference/rest/v1/offerobject/list

optional:
classId <string> The ID of the class whose objects will be listed.
maxResults <integer> Identifies the max number of results returned by a list. All results are returned if `maxResults` isn't defined.
token <string> Used to get the next set of results if `maxResults` is specified, but more than `maxResults` objects are available in a list. For example, if you have a list of 200 objects and you call list with `maxResults` set to 20, list will return the first 20 objects and a token. Call list again with `maxResults` set to 20 and the token to get the next 20 objects."
  ([] (offerobject-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://walletobjects.googleapis.com/walletobjects/v1/offerObject",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/wallet_object.issuer"]})))

(defn offerobject-patch
  "Updates the offer object referenced by the given object ID. This method supports patch semantics.
https://developers.google.com/wallet/reference/rest/v1/offerobject/patch

resourceId <string> The unique identifier for an object. This ID must be unique across all objects from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
OfferObject:
{:hasUsers boolean,
 :smartTapRedemptionValue string,
 :rotatingBarcode
 {:totpDetails
  {:periodMillis string,
   :algorithm [TOTP_ALGORITHM_UNSPECIFIED TOTP_SHA1],
   :parameters [{:valueLength integer, :key string}]},
  :alternateText string,
  :initialRotatingBarcodeValues
  {:startDateTime string, :values [string], :periodMillis string},
  :valuePattern string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :barcode
 {:kind string,
  :alternateText string,
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :value string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :hasLinkedDevice boolean,
 :groupingInfo {:groupingId string, :sortIndex integer},
 :state
 [STATE_UNSPECIFIED
  ACTIVE
  active
  COMPLETED
  completed
  EXPIRED
  expired
  INACTIVE
  inactive],
 :classReference
 {:helpUri
  {:description string,
   :kind string,
   :id string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :wordMark
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :reviewStatus
  [REVIEW_STATUS_UNSPECIFIED
   UNDER_REVIEW
   underReview
   APPROVED
   approved
   REJECTED
   rejected
   DRAFT
   draft],
  :localizedFinePrint
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :textModulesData
  [{:header string,
    :id string,
    :localizedHeader
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :localizedBody
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :body string}],
  :issuerName string,
  :localizedTitle
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :redemptionChannel
  [REDEMPTION_CHANNEL_UNSPECIFIED
   INSTORE
   instore
   ONLINE
   online
   BOTH
   both
   TEMPORARY_PRICE_REDUCTION
   temporaryPriceReduction],
  :securityAnimation
  {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
  :multipleDevicesAndHoldersAllowedStatus
  [STATUS_UNSPECIFIED
   MULTIPLE_HOLDERS
   ONE_USER_ALL_DEVICES
   ONE_USER_ONE_DEVICE
   multipleHolders
   oneUserAllDevices
   oneUserOneDevice],
  :localizedProvider
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :homepageUri
  {:description string,
   :kind string,
   :id string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :titleImage
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :callbackOptions {:updateRequestUrl string, :url string},
  :title string,
  :linksModuleData
  {:uris
   [{:description string,
     :kind string,
     :id string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string}]},
  :imageModulesData
  [{:id string,
    :mainImage
    {:contentDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :sourceUri
     {:description string,
      :localizedDescription LocalizedString,
      :uri string},
     :kind string}}],
  :locations [{:longitude number, :kind string, :latitude number}],
  :allowMultipleUsersPerObject boolean,
  :hexBackgroundColor string,
  :messages
  [{:kind string,
    :displayInterval
    {:start {:date string}, :kind string, :end {:date string}},
    :body string,
    :localizedBody
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :id string,
    :messageType
    [MESSAGE_TYPE_UNSPECIFIED
     TEXT
     text
     EXPIRATION_NOTIFICATION
     expirationNotification
     TEXT_AND_NOTIFY],
    :localizedHeader
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :header string}],
  :localizedIssuerName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :details string,
  :redemptionIssuers [string],
  :review {:comments string},
  :localizedShortTitle
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :wideTitleImage
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :id string,
  :kind string,
  :finePrint string,
  :appLinkData
  {:androidAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}},
   :webAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}},
   :iosAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}}},
  :classTemplateInfo
  {:detailsTemplateOverride {:detailsItemInfos [{:item TemplateItem}]},
   :listTemplateOverride
   {:firstRowOption
    {:transitOption
     [TRANSIT_OPTION_UNSPECIFIED
      ORIGIN_AND_DESTINATION_NAMES
      originAndDestinationNames
      ORIGIN_AND_DESTINATION_CODES
      originAndDestinationCodes
      ORIGIN_NAME
      originName],
     :fieldOption FieldSelector},
    :secondRowOption {:fields [FieldReference]},
    :thirdRowOption {:fields [FieldReference]}},
   :cardTemplateOverride
   {:cardRowTemplateInfos
    [{:oneItem CardRowOneItem,
      :twoItems CardRowTwoItems,
      :threeItems CardRowThreeItems}]},
   :cardBarcodeSectionDetails
   {:firstTopDetail {:fieldSelector FieldSelector},
    :secondTopDetail {:fieldSelector FieldSelector},
    :firstBottomDetail {:fieldSelector FieldSelector}}},
  :shortTitle string,
  :enableSmartTap boolean,
  :version string,
  :viewUnlockRequirement
  [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
   UNLOCK_NOT_REQUIRED
   UNLOCK_REQUIRED_TO_VIEW],
  :infoModuleData
  {:showLastUpdateTime boolean,
   :labelValueRows
   [{:columns
     [{:localizedLabel LocalizedString,
       :localizedValue LocalizedString,
       :label string,
       :value string}]}]},
  :provider string,
  :heroImage
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :localizedDetails
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :countryCode string},
 :disableExpirationNotification boolean,
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :validTimeInterval
 {:start {:date string}, :kind string, :end {:date string}},
 :locations [{:longitude number, :kind string, :latitude number}],
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :id string,
 :kind string,
 :classId string,
 :passConstraints
 {:nfcConstraint
  [[NFC_CONSTRAINT_UNSPECIFIED
    BLOCK_PAYMENT
    BLOCK_CLOSED_LOOP_TRANSIT]],
  :screenshotEligibility
  [SCREENSHOT_ELIGIBILITY_UNSPECIFIED ELIGIBLE INELIGIBLE]},
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :version string,
 :infoModuleData
 {:showLastUpdateTime boolean,
  :labelValueRows
  [{:columns
    [{:localizedLabel
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :localizedValue
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :label string,
      :value string}]}]},
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string}}"
  [resourceId OfferObject]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/offerObject/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body OfferObject}))

(defn offerobject-get
  "Returns the offer object with the given object ID.
https://developers.google.com/wallet/reference/rest/v1/offerobject/get

resourceId <string> The unique identifier for an object. This ID must be unique across all objects from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'."
  [resourceId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/offerObject/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}))

(defn offerobject-insert
  "Inserts an offer object with the given ID and properties.
https://developers.google.com/wallet/reference/rest/v1/offerobject/insert

OfferObject:
{:hasUsers boolean,
 :smartTapRedemptionValue string,
 :rotatingBarcode
 {:totpDetails
  {:periodMillis string,
   :algorithm [TOTP_ALGORITHM_UNSPECIFIED TOTP_SHA1],
   :parameters [{:valueLength integer, :key string}]},
  :alternateText string,
  :initialRotatingBarcodeValues
  {:startDateTime string, :values [string], :periodMillis string},
  :valuePattern string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :barcode
 {:kind string,
  :alternateText string,
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :value string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :hasLinkedDevice boolean,
 :groupingInfo {:groupingId string, :sortIndex integer},
 :state
 [STATE_UNSPECIFIED
  ACTIVE
  active
  COMPLETED
  completed
  EXPIRED
  expired
  INACTIVE
  inactive],
 :classReference
 {:helpUri
  {:description string,
   :kind string,
   :id string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :wordMark
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :reviewStatus
  [REVIEW_STATUS_UNSPECIFIED
   UNDER_REVIEW
   underReview
   APPROVED
   approved
   REJECTED
   rejected
   DRAFT
   draft],
  :localizedFinePrint
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :textModulesData
  [{:header string,
    :id string,
    :localizedHeader
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :localizedBody
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :body string}],
  :issuerName string,
  :localizedTitle
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :redemptionChannel
  [REDEMPTION_CHANNEL_UNSPECIFIED
   INSTORE
   instore
   ONLINE
   online
   BOTH
   both
   TEMPORARY_PRICE_REDUCTION
   temporaryPriceReduction],
  :securityAnimation
  {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
  :multipleDevicesAndHoldersAllowedStatus
  [STATUS_UNSPECIFIED
   MULTIPLE_HOLDERS
   ONE_USER_ALL_DEVICES
   ONE_USER_ONE_DEVICE
   multipleHolders
   oneUserAllDevices
   oneUserOneDevice],
  :localizedProvider
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :homepageUri
  {:description string,
   :kind string,
   :id string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :titleImage
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :callbackOptions {:updateRequestUrl string, :url string},
  :title string,
  :linksModuleData
  {:uris
   [{:description string,
     :kind string,
     :id string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string}]},
  :imageModulesData
  [{:id string,
    :mainImage
    {:contentDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :sourceUri
     {:description string,
      :localizedDescription LocalizedString,
      :uri string},
     :kind string}}],
  :locations [{:longitude number, :kind string, :latitude number}],
  :allowMultipleUsersPerObject boolean,
  :hexBackgroundColor string,
  :messages
  [{:kind string,
    :displayInterval
    {:start {:date string}, :kind string, :end {:date string}},
    :body string,
    :localizedBody
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :id string,
    :messageType
    [MESSAGE_TYPE_UNSPECIFIED
     TEXT
     text
     EXPIRATION_NOTIFICATION
     expirationNotification
     TEXT_AND_NOTIFY],
    :localizedHeader
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :header string}],
  :localizedIssuerName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :details string,
  :redemptionIssuers [string],
  :review {:comments string},
  :localizedShortTitle
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :wideTitleImage
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :id string,
  :kind string,
  :finePrint string,
  :appLinkData
  {:androidAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}},
   :webAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}},
   :iosAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}}},
  :classTemplateInfo
  {:detailsTemplateOverride {:detailsItemInfos [{:item TemplateItem}]},
   :listTemplateOverride
   {:firstRowOption
    {:transitOption
     [TRANSIT_OPTION_UNSPECIFIED
      ORIGIN_AND_DESTINATION_NAMES
      originAndDestinationNames
      ORIGIN_AND_DESTINATION_CODES
      originAndDestinationCodes
      ORIGIN_NAME
      originName],
     :fieldOption FieldSelector},
    :secondRowOption {:fields [FieldReference]},
    :thirdRowOption {:fields [FieldReference]}},
   :cardTemplateOverride
   {:cardRowTemplateInfos
    [{:oneItem CardRowOneItem,
      :twoItems CardRowTwoItems,
      :threeItems CardRowThreeItems}]},
   :cardBarcodeSectionDetails
   {:firstTopDetail {:fieldSelector FieldSelector},
    :secondTopDetail {:fieldSelector FieldSelector},
    :firstBottomDetail {:fieldSelector FieldSelector}}},
  :shortTitle string,
  :enableSmartTap boolean,
  :version string,
  :viewUnlockRequirement
  [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
   UNLOCK_NOT_REQUIRED
   UNLOCK_REQUIRED_TO_VIEW],
  :infoModuleData
  {:showLastUpdateTime boolean,
   :labelValueRows
   [{:columns
     [{:localizedLabel LocalizedString,
       :localizedValue LocalizedString,
       :label string,
       :value string}]}]},
  :provider string,
  :heroImage
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :localizedDetails
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :countryCode string},
 :disableExpirationNotification boolean,
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :validTimeInterval
 {:start {:date string}, :kind string, :end {:date string}},
 :locations [{:longitude number, :kind string, :latitude number}],
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :id string,
 :kind string,
 :classId string,
 :passConstraints
 {:nfcConstraint
  [[NFC_CONSTRAINT_UNSPECIFIED
    BLOCK_PAYMENT
    BLOCK_CLOSED_LOOP_TRANSIT]],
  :screenshotEligibility
  [SCREENSHOT_ELIGIBILITY_UNSPECIFIED ELIGIBLE INELIGIBLE]},
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :version string,
 :infoModuleData
 {:showLastUpdateTime boolean,
  :labelValueRows
  [{:columns
    [{:localizedLabel
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :localizedValue
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :label string,
      :value string}]}]},
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string}}"
  [OfferObject]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/offerObject",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body OfferObject}))

(defn offerobject-update
  "Updates the offer object referenced by the given object ID.
https://developers.google.com/wallet/reference/rest/v1/offerobject/update

resourceId <string> The unique identifier for an object. This ID must be unique across all objects from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
OfferObject:
{:hasUsers boolean,
 :smartTapRedemptionValue string,
 :rotatingBarcode
 {:totpDetails
  {:periodMillis string,
   :algorithm [TOTP_ALGORITHM_UNSPECIFIED TOTP_SHA1],
   :parameters [{:valueLength integer, :key string}]},
  :alternateText string,
  :initialRotatingBarcodeValues
  {:startDateTime string, :values [string], :periodMillis string},
  :valuePattern string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :barcode
 {:kind string,
  :alternateText string,
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :value string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :hasLinkedDevice boolean,
 :groupingInfo {:groupingId string, :sortIndex integer},
 :state
 [STATE_UNSPECIFIED
  ACTIVE
  active
  COMPLETED
  completed
  EXPIRED
  expired
  INACTIVE
  inactive],
 :classReference
 {:helpUri
  {:description string,
   :kind string,
   :id string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :wordMark
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :reviewStatus
  [REVIEW_STATUS_UNSPECIFIED
   UNDER_REVIEW
   underReview
   APPROVED
   approved
   REJECTED
   rejected
   DRAFT
   draft],
  :localizedFinePrint
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :textModulesData
  [{:header string,
    :id string,
    :localizedHeader
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :localizedBody
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :body string}],
  :issuerName string,
  :localizedTitle
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :redemptionChannel
  [REDEMPTION_CHANNEL_UNSPECIFIED
   INSTORE
   instore
   ONLINE
   online
   BOTH
   both
   TEMPORARY_PRICE_REDUCTION
   temporaryPriceReduction],
  :securityAnimation
  {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
  :multipleDevicesAndHoldersAllowedStatus
  [STATUS_UNSPECIFIED
   MULTIPLE_HOLDERS
   ONE_USER_ALL_DEVICES
   ONE_USER_ONE_DEVICE
   multipleHolders
   oneUserAllDevices
   oneUserOneDevice],
  :localizedProvider
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :homepageUri
  {:description string,
   :kind string,
   :id string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :titleImage
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :callbackOptions {:updateRequestUrl string, :url string},
  :title string,
  :linksModuleData
  {:uris
   [{:description string,
     :kind string,
     :id string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string}]},
  :imageModulesData
  [{:id string,
    :mainImage
    {:contentDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :sourceUri
     {:description string,
      :localizedDescription LocalizedString,
      :uri string},
     :kind string}}],
  :locations [{:longitude number, :kind string, :latitude number}],
  :allowMultipleUsersPerObject boolean,
  :hexBackgroundColor string,
  :messages
  [{:kind string,
    :displayInterval
    {:start {:date string}, :kind string, :end {:date string}},
    :body string,
    :localizedBody
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :id string,
    :messageType
    [MESSAGE_TYPE_UNSPECIFIED
     TEXT
     text
     EXPIRATION_NOTIFICATION
     expirationNotification
     TEXT_AND_NOTIFY],
    :localizedHeader
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :header string}],
  :localizedIssuerName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :details string,
  :redemptionIssuers [string],
  :review {:comments string},
  :localizedShortTitle
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :wideTitleImage
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :id string,
  :kind string,
  :finePrint string,
  :appLinkData
  {:androidAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}},
   :webAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}},
   :iosAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}}},
  :classTemplateInfo
  {:detailsTemplateOverride {:detailsItemInfos [{:item TemplateItem}]},
   :listTemplateOverride
   {:firstRowOption
    {:transitOption
     [TRANSIT_OPTION_UNSPECIFIED
      ORIGIN_AND_DESTINATION_NAMES
      originAndDestinationNames
      ORIGIN_AND_DESTINATION_CODES
      originAndDestinationCodes
      ORIGIN_NAME
      originName],
     :fieldOption FieldSelector},
    :secondRowOption {:fields [FieldReference]},
    :thirdRowOption {:fields [FieldReference]}},
   :cardTemplateOverride
   {:cardRowTemplateInfos
    [{:oneItem CardRowOneItem,
      :twoItems CardRowTwoItems,
      :threeItems CardRowThreeItems}]},
   :cardBarcodeSectionDetails
   {:firstTopDetail {:fieldSelector FieldSelector},
    :secondTopDetail {:fieldSelector FieldSelector},
    :firstBottomDetail {:fieldSelector FieldSelector}}},
  :shortTitle string,
  :enableSmartTap boolean,
  :version string,
  :viewUnlockRequirement
  [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
   UNLOCK_NOT_REQUIRED
   UNLOCK_REQUIRED_TO_VIEW],
  :infoModuleData
  {:showLastUpdateTime boolean,
   :labelValueRows
   [{:columns
     [{:localizedLabel LocalizedString,
       :localizedValue LocalizedString,
       :label string,
       :value string}]}]},
  :provider string,
  :heroImage
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :localizedDetails
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :countryCode string},
 :disableExpirationNotification boolean,
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :validTimeInterval
 {:start {:date string}, :kind string, :end {:date string}},
 :locations [{:longitude number, :kind string, :latitude number}],
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :id string,
 :kind string,
 :classId string,
 :passConstraints
 {:nfcConstraint
  [[NFC_CONSTRAINT_UNSPECIFIED
    BLOCK_PAYMENT
    BLOCK_CLOSED_LOOP_TRANSIT]],
  :screenshotEligibility
  [SCREENSHOT_ELIGIBILITY_UNSPECIFIED ELIGIBLE INELIGIBLE]},
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :version string,
 :infoModuleData
 {:showLastUpdateTime boolean,
  :labelValueRows
  [{:columns
    [{:localizedLabel
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :localizedValue
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :label string,
      :value string}]}]},
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string}}"
  [resourceId OfferObject]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/offerObject/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body OfferObject}))

(defn issuer-update
  "Updates the issuer referenced by the given issuer ID.
https://developers.google.com/wallet/reference/rest/v1/issuer/update

resourceId <string> The unique identifier for an issuer.
Issuer:
{:name string,
 :contactInfo
 {:email string, :phone string, :name string, :alertsEmails [string]},
 :issuerId string,
 :homepageUrl string,
 :smartTapMerchantData
 {:authenticationKeys [{:publicKeyPem string, :id integer}],
  :smartTapMerchantId string},
 :callbackOptions {:updateRequestUrl string, :url string}}"
  [resourceId Issuer]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/issuer/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body Issuer}))

(defn issuer-list
  "Returns a list of all issuers shared to the caller.
https://developers.google.com/wallet/reference/rest/v1/issuer/list"
  []
  (client/api-request
    {:method "GET",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/issuer",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}))

(defn issuer-get
  "Returns the issuer with the given issuer ID.
https://developers.google.com/wallet/reference/rest/v1/issuer/get

resourceId <string> The unique identifier for an issuer."
  [resourceId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/issuer/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}))

(defn issuer-insert
  "Inserts an issuer with the given ID and properties.
https://developers.google.com/wallet/reference/rest/v1/issuer/insert

Issuer:
{:name string,
 :contactInfo
 {:email string, :phone string, :name string, :alertsEmails [string]},
 :issuerId string,
 :homepageUrl string,
 :smartTapMerchantData
 {:authenticationKeys [{:publicKeyPem string, :id integer}],
  :smartTapMerchantId string},
 :callbackOptions {:updateRequestUrl string, :url string}}"
  [Issuer]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/issuer",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body Issuer}))

(defn issuer-patch
  "Updates the issuer referenced by the given issuer ID. This method supports patch semantics.
https://developers.google.com/wallet/reference/rest/v1/issuer/patch

resourceId <string> The unique identifier for an issuer.
Issuer:
{:name string,
 :contactInfo
 {:email string, :phone string, :name string, :alertsEmails [string]},
 :issuerId string,
 :homepageUrl string,
 :smartTapMerchantData
 {:authenticationKeys [{:publicKeyPem string, :id integer}],
  :smartTapMerchantId string},
 :callbackOptions {:updateRequestUrl string, :url string}}"
  [resourceId Issuer]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/issuer/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body Issuer}))

(defn loyaltyobject-addmessage
  "Adds a message to the loyalty object referenced by the given object ID.
https://developers.google.com/wallet/reference/rest/v1/loyaltyobject/addmessage

resourceId <string> The unique identifier for an object. This ID must be unique across all objects from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
AddMessageRequest:
{:message
 {:kind string,
  :displayInterval
  {:start {:date string}, :kind string, :end {:date string}},
  :body string,
  :localizedBody
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :id string,
  :messageType
  [MESSAGE_TYPE_UNSPECIFIED
   TEXT
   text
   EXPIRATION_NOTIFICATION
   expirationNotification
   TEXT_AND_NOTIFY],
  :localizedHeader
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :header string}}"
  [resourceId AddMessageRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/loyaltyObject/{resourceId}/addMessage",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body AddMessageRequest}))

(defn loyaltyobject-list
  "Returns a list of all loyalty objects for a given issuer ID.
https://developers.google.com/wallet/reference/rest/v1/loyaltyobject/list

optional:
token <string> Used to get the next set of results if `maxResults` is specified, but more than `maxResults` objects are available in a list. For example, if you have a list of 200 objects and you call list with `maxResults` set to 20, list will return the first 20 objects and a token. Call list again with `maxResults` set to 20 and the token to get the next 20 objects.
classId <string> The ID of the class whose objects will be listed.
maxResults <integer> Identifies the max number of results returned by a list. All results are returned if `maxResults` isn't defined."
  ([] (loyaltyobject-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://walletobjects.googleapis.com/walletobjects/v1/loyaltyObject",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/wallet_object.issuer"]})))

(defn loyaltyobject-update
  "Updates the loyalty object referenced by the given object ID.
https://developers.google.com/wallet/reference/rest/v1/loyaltyobject/update

resourceId <string> The unique identifier for an object. This ID must be unique across all objects from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
LoyaltyObject:
{:hasUsers boolean,
 :smartTapRedemptionValue string,
 :rotatingBarcode
 {:totpDetails
  {:periodMillis string,
   :algorithm [TOTP_ALGORITHM_UNSPECIFIED TOTP_SHA1],
   :parameters [{:valueLength integer, :key string}]},
  :alternateText string,
  :initialRotatingBarcodeValues
  {:startDateTime string, :values [string], :periodMillis string},
  :valuePattern string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :barcode
 {:kind string,
  :alternateText string,
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :value string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :hasLinkedDevice boolean,
 :groupingInfo {:groupingId string, :sortIndex integer},
 :accountName string,
 :state
 [STATE_UNSPECIFIED
  ACTIVE
  active
  COMPLETED
  completed
  EXPIRED
  expired
  INACTIVE
  inactive],
 :classReference
 {:localizedAccountIdLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :wordMark
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :reviewStatus
  [REVIEW_STATUS_UNSPECIFIED
   UNDER_REVIEW
   underReview
   APPROVED
   approved
   REJECTED
   rejected
   DRAFT
   draft],
  :localizedRewardsTier
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :wideProgramLogo
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :textModulesData
  [{:header string,
    :id string,
    :localizedHeader
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :localizedBody
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :body string}],
  :issuerName string,
  :discoverableProgram
  {:merchantSigninInfo
   {:signinWebsite
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}},
   :state
   [STATE_UNSPECIFIED
    TRUSTED_TESTERS
    trustedTesters
    LIVE
    live
    DISABLED
    disabled],
   :merchantSignupInfo
   {:signupWebsite
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string},
    :signupSharedDatas
    [[SHARED_DATA_TYPE_UNSPECIFIED
      FIRST_NAME
      LAST_NAME
      STREET_ADDRESS
      ADDRESS_LINE_1
      ADDRESS_LINE_2
      ADDRESS_LINE_3
      CITY
      STATE
      ZIPCODE
      COUNTRY
      EMAIL
      PHONE]]}},
  :localizedRewardsTierLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :securityAnimation
  {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
  :multipleDevicesAndHoldersAllowedStatus
  [STATUS_UNSPECIFIED
   MULTIPLE_HOLDERS
   ONE_USER_ALL_DEVICES
   ONE_USER_ONE_DEVICE
   multipleHolders
   oneUserAllDevices
   oneUserOneDevice],
  :homepageUri
  {:description string,
   :kind string,
   :id string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :secondaryRewardsTierLabel string,
  :accountNameLabel string,
  :rewardsTierLabel string,
  :callbackOptions {:updateRequestUrl string, :url string},
  :linksModuleData
  {:uris
   [{:description string,
     :kind string,
     :id string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string}]},
  :localizedSecondaryRewardsTier
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :imageModulesData
  [{:id string,
    :mainImage
    {:contentDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :sourceUri
     {:description string,
      :localizedDescription LocalizedString,
      :uri string},
     :kind string}}],
  :secondaryRewardsTier string,
  :locations [{:longitude number, :kind string, :latitude number}],
  :rewardsTier string,
  :allowMultipleUsersPerObject boolean,
  :hexBackgroundColor string,
  :messages
  [{:kind string,
    :displayInterval
    {:start {:date string}, :kind string, :end {:date string}},
    :body string,
    :localizedBody
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :id string,
    :messageType
    [MESSAGE_TYPE_UNSPECIFIED
     TEXT
     text
     EXPIRATION_NOTIFICATION
     expirationNotification
     TEXT_AND_NOTIFY],
    :localizedHeader
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :header string}],
  :localizedIssuerName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :redemptionIssuers [string],
  :review {:comments string},
  :programLogo
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :id string,
  :kind string,
  :localizedSecondaryRewardsTierLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :localizedAccountNameLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :appLinkData
  {:androidAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}},
   :webAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}},
   :iosAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}}},
  :programName string,
  :classTemplateInfo
  {:detailsTemplateOverride {:detailsItemInfos [{:item TemplateItem}]},
   :listTemplateOverride
   {:firstRowOption
    {:transitOption
     [TRANSIT_OPTION_UNSPECIFIED
      ORIGIN_AND_DESTINATION_NAMES
      originAndDestinationNames
      ORIGIN_AND_DESTINATION_CODES
      originAndDestinationCodes
      ORIGIN_NAME
      originName],
     :fieldOption FieldSelector},
    :secondRowOption {:fields [FieldReference]},
    :thirdRowOption {:fields [FieldReference]}},
   :cardTemplateOverride
   {:cardRowTemplateInfos
    [{:oneItem CardRowOneItem,
      :twoItems CardRowTwoItems,
      :threeItems CardRowThreeItems}]},
   :cardBarcodeSectionDetails
   {:firstTopDetail {:fieldSelector FieldSelector},
    :secondTopDetail {:fieldSelector FieldSelector},
    :firstBottomDetail {:fieldSelector FieldSelector}}},
  :enableSmartTap boolean,
  :version string,
  :viewUnlockRequirement
  [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
   UNLOCK_NOT_REQUIRED
   UNLOCK_REQUIRED_TO_VIEW],
  :infoModuleData
  {:showLastUpdateTime boolean,
   :labelValueRows
   [{:columns
     [{:localizedLabel LocalizedString,
       :localizedValue LocalizedString,
       :label string,
       :value string}]}]},
  :localizedProgramName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :heroImage
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :accountIdLabel string,
  :countryCode string},
 :disableExpirationNotification boolean,
 :linkedOfferIds [string],
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :loyaltyPoints
 {:localizedLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :balance
  {:double number,
   :int integer,
   :money {:micros string, :currencyCode string, :kind string},
   :string string},
  :label string},
 :secondaryLoyaltyPoints
 {:localizedLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :balance
  {:double number,
   :int integer,
   :money {:micros string, :currencyCode string, :kind string},
   :string string},
  :label string},
 :validTimeInterval
 {:start {:date string}, :kind string, :end {:date string}},
 :locations [{:longitude number, :kind string, :latitude number}],
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :id string,
 :kind string,
 :classId string,
 :passConstraints
 {:nfcConstraint
  [[NFC_CONSTRAINT_UNSPECIFIED
    BLOCK_PAYMENT
    BLOCK_CLOSED_LOOP_TRANSIT]],
  :screenshotEligibility
  [SCREENSHOT_ELIGIBILITY_UNSPECIFIED ELIGIBLE INELIGIBLE]},
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :version string,
 :infoModuleData
 {:showLastUpdateTime boolean,
  :labelValueRows
  [{:columns
    [{:localizedLabel
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :localizedValue
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :label string,
      :value string}]}]},
 :accountId string,
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string}}"
  [resourceId LoyaltyObject]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/loyaltyObject/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body LoyaltyObject}))

(defn loyaltyobject-patch
  "Updates the loyalty object referenced by the given object ID. This method supports patch semantics.
https://developers.google.com/wallet/reference/rest/v1/loyaltyobject/patch

resourceId <string> The unique identifier for an object. This ID must be unique across all objects from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
LoyaltyObject:
{:hasUsers boolean,
 :smartTapRedemptionValue string,
 :rotatingBarcode
 {:totpDetails
  {:periodMillis string,
   :algorithm [TOTP_ALGORITHM_UNSPECIFIED TOTP_SHA1],
   :parameters [{:valueLength integer, :key string}]},
  :alternateText string,
  :initialRotatingBarcodeValues
  {:startDateTime string, :values [string], :periodMillis string},
  :valuePattern string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :barcode
 {:kind string,
  :alternateText string,
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :value string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :hasLinkedDevice boolean,
 :groupingInfo {:groupingId string, :sortIndex integer},
 :accountName string,
 :state
 [STATE_UNSPECIFIED
  ACTIVE
  active
  COMPLETED
  completed
  EXPIRED
  expired
  INACTIVE
  inactive],
 :classReference
 {:localizedAccountIdLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :wordMark
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :reviewStatus
  [REVIEW_STATUS_UNSPECIFIED
   UNDER_REVIEW
   underReview
   APPROVED
   approved
   REJECTED
   rejected
   DRAFT
   draft],
  :localizedRewardsTier
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :wideProgramLogo
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :textModulesData
  [{:header string,
    :id string,
    :localizedHeader
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :localizedBody
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :body string}],
  :issuerName string,
  :discoverableProgram
  {:merchantSigninInfo
   {:signinWebsite
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}},
   :state
   [STATE_UNSPECIFIED
    TRUSTED_TESTERS
    trustedTesters
    LIVE
    live
    DISABLED
    disabled],
   :merchantSignupInfo
   {:signupWebsite
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string},
    :signupSharedDatas
    [[SHARED_DATA_TYPE_UNSPECIFIED
      FIRST_NAME
      LAST_NAME
      STREET_ADDRESS
      ADDRESS_LINE_1
      ADDRESS_LINE_2
      ADDRESS_LINE_3
      CITY
      STATE
      ZIPCODE
      COUNTRY
      EMAIL
      PHONE]]}},
  :localizedRewardsTierLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :securityAnimation
  {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
  :multipleDevicesAndHoldersAllowedStatus
  [STATUS_UNSPECIFIED
   MULTIPLE_HOLDERS
   ONE_USER_ALL_DEVICES
   ONE_USER_ONE_DEVICE
   multipleHolders
   oneUserAllDevices
   oneUserOneDevice],
  :homepageUri
  {:description string,
   :kind string,
   :id string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :secondaryRewardsTierLabel string,
  :accountNameLabel string,
  :rewardsTierLabel string,
  :callbackOptions {:updateRequestUrl string, :url string},
  :linksModuleData
  {:uris
   [{:description string,
     :kind string,
     :id string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string}]},
  :localizedSecondaryRewardsTier
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :imageModulesData
  [{:id string,
    :mainImage
    {:contentDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :sourceUri
     {:description string,
      :localizedDescription LocalizedString,
      :uri string},
     :kind string}}],
  :secondaryRewardsTier string,
  :locations [{:longitude number, :kind string, :latitude number}],
  :rewardsTier string,
  :allowMultipleUsersPerObject boolean,
  :hexBackgroundColor string,
  :messages
  [{:kind string,
    :displayInterval
    {:start {:date string}, :kind string, :end {:date string}},
    :body string,
    :localizedBody
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :id string,
    :messageType
    [MESSAGE_TYPE_UNSPECIFIED
     TEXT
     text
     EXPIRATION_NOTIFICATION
     expirationNotification
     TEXT_AND_NOTIFY],
    :localizedHeader
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :header string}],
  :localizedIssuerName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :redemptionIssuers [string],
  :review {:comments string},
  :programLogo
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :id string,
  :kind string,
  :localizedSecondaryRewardsTierLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :localizedAccountNameLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :appLinkData
  {:androidAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}},
   :webAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}},
   :iosAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}}},
  :programName string,
  :classTemplateInfo
  {:detailsTemplateOverride {:detailsItemInfos [{:item TemplateItem}]},
   :listTemplateOverride
   {:firstRowOption
    {:transitOption
     [TRANSIT_OPTION_UNSPECIFIED
      ORIGIN_AND_DESTINATION_NAMES
      originAndDestinationNames
      ORIGIN_AND_DESTINATION_CODES
      originAndDestinationCodes
      ORIGIN_NAME
      originName],
     :fieldOption FieldSelector},
    :secondRowOption {:fields [FieldReference]},
    :thirdRowOption {:fields [FieldReference]}},
   :cardTemplateOverride
   {:cardRowTemplateInfos
    [{:oneItem CardRowOneItem,
      :twoItems CardRowTwoItems,
      :threeItems CardRowThreeItems}]},
   :cardBarcodeSectionDetails
   {:firstTopDetail {:fieldSelector FieldSelector},
    :secondTopDetail {:fieldSelector FieldSelector},
    :firstBottomDetail {:fieldSelector FieldSelector}}},
  :enableSmartTap boolean,
  :version string,
  :viewUnlockRequirement
  [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
   UNLOCK_NOT_REQUIRED
   UNLOCK_REQUIRED_TO_VIEW],
  :infoModuleData
  {:showLastUpdateTime boolean,
   :labelValueRows
   [{:columns
     [{:localizedLabel LocalizedString,
       :localizedValue LocalizedString,
       :label string,
       :value string}]}]},
  :localizedProgramName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :heroImage
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :accountIdLabel string,
  :countryCode string},
 :disableExpirationNotification boolean,
 :linkedOfferIds [string],
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :loyaltyPoints
 {:localizedLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :balance
  {:double number,
   :int integer,
   :money {:micros string, :currencyCode string, :kind string},
   :string string},
  :label string},
 :secondaryLoyaltyPoints
 {:localizedLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :balance
  {:double number,
   :int integer,
   :money {:micros string, :currencyCode string, :kind string},
   :string string},
  :label string},
 :validTimeInterval
 {:start {:date string}, :kind string, :end {:date string}},
 :locations [{:longitude number, :kind string, :latitude number}],
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :id string,
 :kind string,
 :classId string,
 :passConstraints
 {:nfcConstraint
  [[NFC_CONSTRAINT_UNSPECIFIED
    BLOCK_PAYMENT
    BLOCK_CLOSED_LOOP_TRANSIT]],
  :screenshotEligibility
  [SCREENSHOT_ELIGIBILITY_UNSPECIFIED ELIGIBLE INELIGIBLE]},
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :version string,
 :infoModuleData
 {:showLastUpdateTime boolean,
  :labelValueRows
  [{:columns
    [{:localizedLabel
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :localizedValue
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :label string,
      :value string}]}]},
 :accountId string,
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string}}"
  [resourceId LoyaltyObject]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/loyaltyObject/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body LoyaltyObject}))

(defn loyaltyobject-get
  "Returns the loyalty object with the given object ID.
https://developers.google.com/wallet/reference/rest/v1/loyaltyobject/get

resourceId <string> The unique identifier for an object. This ID must be unique across all objects from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'."
  [resourceId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/loyaltyObject/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}))

(defn loyaltyobject-insert
  "Inserts an loyalty object with the given ID and properties.
https://developers.google.com/wallet/reference/rest/v1/loyaltyobject/insert

LoyaltyObject:
{:hasUsers boolean,
 :smartTapRedemptionValue string,
 :rotatingBarcode
 {:totpDetails
  {:periodMillis string,
   :algorithm [TOTP_ALGORITHM_UNSPECIFIED TOTP_SHA1],
   :parameters [{:valueLength integer, :key string}]},
  :alternateText string,
  :initialRotatingBarcodeValues
  {:startDateTime string, :values [string], :periodMillis string},
  :valuePattern string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :barcode
 {:kind string,
  :alternateText string,
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :value string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :hasLinkedDevice boolean,
 :groupingInfo {:groupingId string, :sortIndex integer},
 :accountName string,
 :state
 [STATE_UNSPECIFIED
  ACTIVE
  active
  COMPLETED
  completed
  EXPIRED
  expired
  INACTIVE
  inactive],
 :classReference
 {:localizedAccountIdLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :wordMark
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :reviewStatus
  [REVIEW_STATUS_UNSPECIFIED
   UNDER_REVIEW
   underReview
   APPROVED
   approved
   REJECTED
   rejected
   DRAFT
   draft],
  :localizedRewardsTier
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :wideProgramLogo
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :textModulesData
  [{:header string,
    :id string,
    :localizedHeader
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :localizedBody
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :body string}],
  :issuerName string,
  :discoverableProgram
  {:merchantSigninInfo
   {:signinWebsite
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}},
   :state
   [STATE_UNSPECIFIED
    TRUSTED_TESTERS
    trustedTesters
    LIVE
    live
    DISABLED
    disabled],
   :merchantSignupInfo
   {:signupWebsite
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string},
    :signupSharedDatas
    [[SHARED_DATA_TYPE_UNSPECIFIED
      FIRST_NAME
      LAST_NAME
      STREET_ADDRESS
      ADDRESS_LINE_1
      ADDRESS_LINE_2
      ADDRESS_LINE_3
      CITY
      STATE
      ZIPCODE
      COUNTRY
      EMAIL
      PHONE]]}},
  :localizedRewardsTierLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :securityAnimation
  {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
  :multipleDevicesAndHoldersAllowedStatus
  [STATUS_UNSPECIFIED
   MULTIPLE_HOLDERS
   ONE_USER_ALL_DEVICES
   ONE_USER_ONE_DEVICE
   multipleHolders
   oneUserAllDevices
   oneUserOneDevice],
  :homepageUri
  {:description string,
   :kind string,
   :id string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :secondaryRewardsTierLabel string,
  :accountNameLabel string,
  :rewardsTierLabel string,
  :callbackOptions {:updateRequestUrl string, :url string},
  :linksModuleData
  {:uris
   [{:description string,
     :kind string,
     :id string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string}]},
  :localizedSecondaryRewardsTier
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :imageModulesData
  [{:id string,
    :mainImage
    {:contentDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :sourceUri
     {:description string,
      :localizedDescription LocalizedString,
      :uri string},
     :kind string}}],
  :secondaryRewardsTier string,
  :locations [{:longitude number, :kind string, :latitude number}],
  :rewardsTier string,
  :allowMultipleUsersPerObject boolean,
  :hexBackgroundColor string,
  :messages
  [{:kind string,
    :displayInterval
    {:start {:date string}, :kind string, :end {:date string}},
    :body string,
    :localizedBody
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :id string,
    :messageType
    [MESSAGE_TYPE_UNSPECIFIED
     TEXT
     text
     EXPIRATION_NOTIFICATION
     expirationNotification
     TEXT_AND_NOTIFY],
    :localizedHeader
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :header string}],
  :localizedIssuerName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :redemptionIssuers [string],
  :review {:comments string},
  :programLogo
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :id string,
  :kind string,
  :localizedSecondaryRewardsTierLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :localizedAccountNameLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :appLinkData
  {:androidAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}},
   :webAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}},
   :iosAppLinkInfo
   {:appLogoImage
    {:contentDescription LocalizedString,
     :sourceUri ImageUri,
     :kind string},
    :description
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :title
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :appTarget {:packageName string, :targetUri Uri}}},
  :programName string,
  :classTemplateInfo
  {:detailsTemplateOverride {:detailsItemInfos [{:item TemplateItem}]},
   :listTemplateOverride
   {:firstRowOption
    {:transitOption
     [TRANSIT_OPTION_UNSPECIFIED
      ORIGIN_AND_DESTINATION_NAMES
      originAndDestinationNames
      ORIGIN_AND_DESTINATION_CODES
      originAndDestinationCodes
      ORIGIN_NAME
      originName],
     :fieldOption FieldSelector},
    :secondRowOption {:fields [FieldReference]},
    :thirdRowOption {:fields [FieldReference]}},
   :cardTemplateOverride
   {:cardRowTemplateInfos
    [{:oneItem CardRowOneItem,
      :twoItems CardRowTwoItems,
      :threeItems CardRowThreeItems}]},
   :cardBarcodeSectionDetails
   {:firstTopDetail {:fieldSelector FieldSelector},
    :secondTopDetail {:fieldSelector FieldSelector},
    :firstBottomDetail {:fieldSelector FieldSelector}}},
  :enableSmartTap boolean,
  :version string,
  :viewUnlockRequirement
  [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
   UNLOCK_NOT_REQUIRED
   UNLOCK_REQUIRED_TO_VIEW],
  :infoModuleData
  {:showLastUpdateTime boolean,
   :labelValueRows
   [{:columns
     [{:localizedLabel LocalizedString,
       :localizedValue LocalizedString,
       :label string,
       :value string}]}]},
  :localizedProgramName
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :heroImage
  {:contentDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :sourceUri
   {:description string,
    :localizedDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :uri string},
   :kind string},
  :accountIdLabel string,
  :countryCode string},
 :disableExpirationNotification boolean,
 :linkedOfferIds [string],
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :loyaltyPoints
 {:localizedLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :balance
  {:double number,
   :int integer,
   :money {:micros string, :currencyCode string, :kind string},
   :string string},
  :label string},
 :secondaryLoyaltyPoints
 {:localizedLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :balance
  {:double number,
   :int integer,
   :money {:micros string, :currencyCode string, :kind string},
   :string string},
  :label string},
 :validTimeInterval
 {:start {:date string}, :kind string, :end {:date string}},
 :locations [{:longitude number, :kind string, :latitude number}],
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :id string,
 :kind string,
 :classId string,
 :passConstraints
 {:nfcConstraint
  [[NFC_CONSTRAINT_UNSPECIFIED
    BLOCK_PAYMENT
    BLOCK_CLOSED_LOOP_TRANSIT]],
  :screenshotEligibility
  [SCREENSHOT_ELIGIBILITY_UNSPECIFIED ELIGIBLE INELIGIBLE]},
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :version string,
 :infoModuleData
 {:showLastUpdateTime boolean,
  :labelValueRows
  [{:columns
    [{:localizedLabel
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :localizedValue
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :label string,
      :value string}]}]},
 :accountId string,
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string}}"
  [LoyaltyObject]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/loyaltyObject",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body LoyaltyObject}))

(defn loyaltyobject-modifylinkedofferobjects
  "Modifies linked offer objects for the loyalty object with the given ID.
https://developers.google.com/wallet/reference/rest/v1/loyaltyobject/modifylinkedofferobjects

resourceId <string> The unique identifier for an object. This ID must be unique across all objects from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
ModifyLinkedOfferObjectsRequest:
{:linkedOfferObjectIds
 {:removeLinkedOfferObjectIds [string],
  :addLinkedOfferObjectIds [string]}}"
  [resourceId ModifyLinkedOfferObjectsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/loyaltyObject/{resourceId}/modifyLinkedOfferObjects",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body ModifyLinkedOfferObjectsRequest}))

(defn eventticketclass-list
  "Returns a list of all event ticket classes for a given issuer ID.
https://developers.google.com/wallet/reference/rest/v1/eventticketclass/list

optional:
maxResults <integer> Identifies the max number of results returned by a list. All results are returned if `maxResults` isn't defined.
token <string> Used to get the next set of results if `maxResults` is specified, but more than `maxResults` classes are available in a list. For example, if you have a list of 200 classes and you call list with `maxResults` set to 20, list will return the first 20 classes and a token. Call list again with `maxResults` set to 20 and the token to get the next 20 classes.
issuerId <string> The ID of the issuer authorized to list classes."
  ([] (eventticketclass-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://walletobjects.googleapis.com/walletobjects/v1/eventTicketClass",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/wallet_object.issuer"]})))

(defn eventticketclass-patch
  "Updates the event ticket class referenced by the given class ID. This method supports patch semantics.
https://developers.google.com/wallet/reference/rest/v1/eventticketclass/patch

resourceId <string> The unique identifier for a class. This ID must be unique across all classes from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
EventTicketClass:
{:wordMark
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :eventName
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :reviewStatus
 [REVIEW_STATUS_UNSPECIFIED
  UNDER_REVIEW
  underReview
  APPROVED
  approved
  REJECTED
  rejected
  DRAFT
  draft],
 :rowLabel [ROW_LABEL_UNSPECIFIED ROW row],
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :issuerName string,
 :logo
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :wideLogo
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :securityAnimation
 {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
 :multipleDevicesAndHoldersAllowedStatus
 [STATUS_UNSPECIFIED
  MULTIPLE_HOLDERS
  ONE_USER_ALL_DEVICES
  ONE_USER_ONE_DEVICE
  multipleHolders
  oneUserAllDevices
  oneUserOneDevice],
 :homepageUri
 {:description string,
  :kind string,
  :id string,
  :localizedDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :uri string},
 :customSeatLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :customSectionLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :callbackOptions {:updateRequestUrl string, :url string},
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :eventId string,
 :locations [{:longitude number, :kind string, :latitude number}],
 :dateTime
 {:end string,
  :kind string,
  :start string,
  :doorsOpenLabel
  [DOORS_OPEN_LABEL_UNSPECIFIED
   DOORS_OPEN
   doorsOpen
   GATES_OPEN
   gatesOpen],
  :doorsOpen string,
  :customDoorsOpenLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}}},
 :allowMultipleUsersPerObject boolean,
 :hexBackgroundColor string,
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :sectionLabel
 [SECTION_LABEL_UNSPECIFIED SECTION section THEATER theater],
 :localizedIssuerName
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :redemptionIssuers [string],
 :review {:comments string},
 :id string,
 :kind string,
 :venue
 {:address
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :name
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :kind string},
 :customRowLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :finePrint
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :gateLabel
 [GATE_LABEL_UNSPECIFIED GATE gate DOOR door ENTRANCE entrance],
 :seatLabel [SEAT_LABEL_UNSPECIFIED SEAT seat],
 :customConfirmationCodeLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :confirmationCodeLabel
 [CONFIRMATION_CODE_LABEL_UNSPECIFIED
  CONFIRMATION_CODE
  confirmationCode
  CONFIRMATION_NUMBER
  confirmationNumber
  ORDER_NUMBER
  orderNumber
  RESERVATION_NUMBER
  reservationNumber],
 :classTemplateInfo
 {:detailsTemplateOverride
  {:detailsItemInfos
   [{:item
     {:firstValue FieldSelector,
      :predefinedItem
      [PREDEFINED_ITEM_UNSPECIFIED
       FREQUENT_FLYER_PROGRAM_NAME_AND_NUMBER
       frequentFlyerProgramNameAndNumber
       FLIGHT_NUMBER_AND_OPERATING_FLIGHT_NUMBER
       flightNumberAndOperatingFlightNumber],
      :secondValue FieldSelector}}]},
  :listTemplateOverride
  {:firstRowOption
   {:transitOption
    [TRANSIT_OPTION_UNSPECIFIED
     ORIGIN_AND_DESTINATION_NAMES
     originAndDestinationNames
     ORIGIN_AND_DESTINATION_CODES
     originAndDestinationCodes
     ORIGIN_NAME
     originName],
    :fieldOption {:fields [FieldReference]}},
   :secondRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]},
   :thirdRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]}},
  :cardTemplateOverride
  {:cardRowTemplateInfos
   [{:oneItem {:item TemplateItem},
     :twoItems {:endItem TemplateItem, :startItem TemplateItem},
     :threeItems
     {:startItem TemplateItem,
      :middleItem TemplateItem,
      :endItem TemplateItem}}]},
  :cardBarcodeSectionDetails
  {:firstTopDetail {:fieldSelector {:fields [FieldReference]}},
   :secondTopDetail {:fieldSelector {:fields [FieldReference]}},
   :firstBottomDetail {:fieldSelector {:fields [FieldReference]}}}},
 :enableSmartTap boolean,
 :version string,
 :viewUnlockRequirement
 [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
  UNLOCK_NOT_REQUIRED
  UNLOCK_REQUIRED_TO_VIEW],
 :customGateLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :infoModuleData
 {:showLastUpdateTime boolean,
  :labelValueRows
  [{:columns
    [{:localizedLabel
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :localizedValue
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :label string,
      :value string}]}]},
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :countryCode string}"
  [resourceId EventTicketClass]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/eventTicketClass/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body EventTicketClass}))

(defn eventticketclass-addmessage
  "Adds a message to the event ticket class referenced by the given class ID.
https://developers.google.com/wallet/reference/rest/v1/eventticketclass/addmessage

resourceId <string> The unique identifier for a class. This ID must be unique across all classes from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
AddMessageRequest:
{:message
 {:kind string,
  :displayInterval
  {:start {:date string}, :kind string, :end {:date string}},
  :body string,
  :localizedBody
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :id string,
  :messageType
  [MESSAGE_TYPE_UNSPECIFIED
   TEXT
   text
   EXPIRATION_NOTIFICATION
   expirationNotification
   TEXT_AND_NOTIFY],
  :localizedHeader
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :header string}}"
  [resourceId AddMessageRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/eventTicketClass/{resourceId}/addMessage",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body AddMessageRequest}))

(defn eventticketclass-insert
  "Inserts an event ticket class with the given ID and properties.
https://developers.google.com/wallet/reference/rest/v1/eventticketclass/insert

EventTicketClass:
{:wordMark
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :eventName
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :reviewStatus
 [REVIEW_STATUS_UNSPECIFIED
  UNDER_REVIEW
  underReview
  APPROVED
  approved
  REJECTED
  rejected
  DRAFT
  draft],
 :rowLabel [ROW_LABEL_UNSPECIFIED ROW row],
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :issuerName string,
 :logo
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :wideLogo
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :securityAnimation
 {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
 :multipleDevicesAndHoldersAllowedStatus
 [STATUS_UNSPECIFIED
  MULTIPLE_HOLDERS
  ONE_USER_ALL_DEVICES
  ONE_USER_ONE_DEVICE
  multipleHolders
  oneUserAllDevices
  oneUserOneDevice],
 :homepageUri
 {:description string,
  :kind string,
  :id string,
  :localizedDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :uri string},
 :customSeatLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :customSectionLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :callbackOptions {:updateRequestUrl string, :url string},
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :eventId string,
 :locations [{:longitude number, :kind string, :latitude number}],
 :dateTime
 {:end string,
  :kind string,
  :start string,
  :doorsOpenLabel
  [DOORS_OPEN_LABEL_UNSPECIFIED
   DOORS_OPEN
   doorsOpen
   GATES_OPEN
   gatesOpen],
  :doorsOpen string,
  :customDoorsOpenLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}}},
 :allowMultipleUsersPerObject boolean,
 :hexBackgroundColor string,
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :sectionLabel
 [SECTION_LABEL_UNSPECIFIED SECTION section THEATER theater],
 :localizedIssuerName
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :redemptionIssuers [string],
 :review {:comments string},
 :id string,
 :kind string,
 :venue
 {:address
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :name
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :kind string},
 :customRowLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :finePrint
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :gateLabel
 [GATE_LABEL_UNSPECIFIED GATE gate DOOR door ENTRANCE entrance],
 :seatLabel [SEAT_LABEL_UNSPECIFIED SEAT seat],
 :customConfirmationCodeLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :confirmationCodeLabel
 [CONFIRMATION_CODE_LABEL_UNSPECIFIED
  CONFIRMATION_CODE
  confirmationCode
  CONFIRMATION_NUMBER
  confirmationNumber
  ORDER_NUMBER
  orderNumber
  RESERVATION_NUMBER
  reservationNumber],
 :classTemplateInfo
 {:detailsTemplateOverride
  {:detailsItemInfos
   [{:item
     {:firstValue FieldSelector,
      :predefinedItem
      [PREDEFINED_ITEM_UNSPECIFIED
       FREQUENT_FLYER_PROGRAM_NAME_AND_NUMBER
       frequentFlyerProgramNameAndNumber
       FLIGHT_NUMBER_AND_OPERATING_FLIGHT_NUMBER
       flightNumberAndOperatingFlightNumber],
      :secondValue FieldSelector}}]},
  :listTemplateOverride
  {:firstRowOption
   {:transitOption
    [TRANSIT_OPTION_UNSPECIFIED
     ORIGIN_AND_DESTINATION_NAMES
     originAndDestinationNames
     ORIGIN_AND_DESTINATION_CODES
     originAndDestinationCodes
     ORIGIN_NAME
     originName],
    :fieldOption {:fields [FieldReference]}},
   :secondRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]},
   :thirdRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]}},
  :cardTemplateOverride
  {:cardRowTemplateInfos
   [{:oneItem {:item TemplateItem},
     :twoItems {:endItem TemplateItem, :startItem TemplateItem},
     :threeItems
     {:startItem TemplateItem,
      :middleItem TemplateItem,
      :endItem TemplateItem}}]},
  :cardBarcodeSectionDetails
  {:firstTopDetail {:fieldSelector {:fields [FieldReference]}},
   :secondTopDetail {:fieldSelector {:fields [FieldReference]}},
   :firstBottomDetail {:fieldSelector {:fields [FieldReference]}}}},
 :enableSmartTap boolean,
 :version string,
 :viewUnlockRequirement
 [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
  UNLOCK_NOT_REQUIRED
  UNLOCK_REQUIRED_TO_VIEW],
 :customGateLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :infoModuleData
 {:showLastUpdateTime boolean,
  :labelValueRows
  [{:columns
    [{:localizedLabel
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :localizedValue
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :label string,
      :value string}]}]},
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :countryCode string}"
  [EventTicketClass]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/eventTicketClass",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body EventTicketClass}))

(defn eventticketclass-update
  "Updates the event ticket class referenced by the given class ID.
https://developers.google.com/wallet/reference/rest/v1/eventticketclass/update

resourceId <string> The unique identifier for a class. This ID must be unique across all classes from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
EventTicketClass:
{:wordMark
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :eventName
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :reviewStatus
 [REVIEW_STATUS_UNSPECIFIED
  UNDER_REVIEW
  underReview
  APPROVED
  approved
  REJECTED
  rejected
  DRAFT
  draft],
 :rowLabel [ROW_LABEL_UNSPECIFIED ROW row],
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :issuerName string,
 :logo
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :wideLogo
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :securityAnimation
 {:animationType [ANIMATION_UNSPECIFIED FOIL_SHIMMER foilShimmer]},
 :multipleDevicesAndHoldersAllowedStatus
 [STATUS_UNSPECIFIED
  MULTIPLE_HOLDERS
  ONE_USER_ALL_DEVICES
  ONE_USER_ONE_DEVICE
  multipleHolders
  oneUserAllDevices
  oneUserOneDevice],
 :homepageUri
 {:description string,
  :kind string,
  :id string,
  :localizedDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :uri string},
 :customSeatLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :customSectionLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :callbackOptions {:updateRequestUrl string, :url string},
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :eventId string,
 :locations [{:longitude number, :kind string, :latitude number}],
 :dateTime
 {:end string,
  :kind string,
  :start string,
  :doorsOpenLabel
  [DOORS_OPEN_LABEL_UNSPECIFIED
   DOORS_OPEN
   doorsOpen
   GATES_OPEN
   gatesOpen],
  :doorsOpen string,
  :customDoorsOpenLabel
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}}},
 :allowMultipleUsersPerObject boolean,
 :hexBackgroundColor string,
 :messages
 [{:kind string,
   :displayInterval
   {:start {:date string}, :kind string, :end {:date string}},
   :body string,
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :id string,
   :messageType
   [MESSAGE_TYPE_UNSPECIFIED
    TEXT
    text
    EXPIRATION_NOTIFICATION
    expirationNotification
    TEXT_AND_NOTIFY],
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :header string}],
 :sectionLabel
 [SECTION_LABEL_UNSPECIFIED SECTION section THEATER theater],
 :localizedIssuerName
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :redemptionIssuers [string],
 :review {:comments string},
 :id string,
 :kind string,
 :venue
 {:address
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :name
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :kind string},
 :customRowLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :finePrint
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :gateLabel
 [GATE_LABEL_UNSPECIFIED GATE gate DOOR door ENTRANCE entrance],
 :seatLabel [SEAT_LABEL_UNSPECIFIED SEAT seat],
 :customConfirmationCodeLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :confirmationCodeLabel
 [CONFIRMATION_CODE_LABEL_UNSPECIFIED
  CONFIRMATION_CODE
  confirmationCode
  CONFIRMATION_NUMBER
  confirmationNumber
  ORDER_NUMBER
  orderNumber
  RESERVATION_NUMBER
  reservationNumber],
 :classTemplateInfo
 {:detailsTemplateOverride
  {:detailsItemInfos
   [{:item
     {:firstValue FieldSelector,
      :predefinedItem
      [PREDEFINED_ITEM_UNSPECIFIED
       FREQUENT_FLYER_PROGRAM_NAME_AND_NUMBER
       frequentFlyerProgramNameAndNumber
       FLIGHT_NUMBER_AND_OPERATING_FLIGHT_NUMBER
       flightNumberAndOperatingFlightNumber],
      :secondValue FieldSelector}}]},
  :listTemplateOverride
  {:firstRowOption
   {:transitOption
    [TRANSIT_OPTION_UNSPECIFIED
     ORIGIN_AND_DESTINATION_NAMES
     originAndDestinationNames
     ORIGIN_AND_DESTINATION_CODES
     originAndDestinationCodes
     ORIGIN_NAME
     originName],
    :fieldOption {:fields [FieldReference]}},
   :secondRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]},
   :thirdRowOption
   {:fields
    [{:dateFormat
      [DATE_FORMAT_UNSPECIFIED
       DATE_TIME
       dateTime
       DATE_ONLY
       dateOnly
       TIME_ONLY
       timeOnly
       DATE_TIME_YEAR
       dateTimeYear
       DATE_YEAR
       dateYear
       YEAR_MONTH
       YEAR_MONTH_DAY],
      :fieldPath string}]}},
  :cardTemplateOverride
  {:cardRowTemplateInfos
   [{:oneItem {:item TemplateItem},
     :twoItems {:endItem TemplateItem, :startItem TemplateItem},
     :threeItems
     {:startItem TemplateItem,
      :middleItem TemplateItem,
      :endItem TemplateItem}}]},
  :cardBarcodeSectionDetails
  {:firstTopDetail {:fieldSelector {:fields [FieldReference]}},
   :secondTopDetail {:fieldSelector {:fields [FieldReference]}},
   :firstBottomDetail {:fieldSelector {:fields [FieldReference]}}}},
 :enableSmartTap boolean,
 :version string,
 :viewUnlockRequirement
 [VIEW_UNLOCK_REQUIREMENT_UNSPECIFIED
  UNLOCK_NOT_REQUIRED
  UNLOCK_REQUIRED_TO_VIEW],
 :customGateLabel
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :infoModuleData
 {:showLastUpdateTime boolean,
  :labelValueRows
  [{:columns
    [{:localizedLabel
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :localizedValue
      {:translatedValues [TranslatedString],
       :kind string,
       :defaultValue TranslatedString},
      :label string,
      :value string}]}]},
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :countryCode string}"
  [resourceId EventTicketClass]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/eventTicketClass/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body EventTicketClass}))

(defn eventticketclass-get
  "Returns the event ticket class with the given class ID.
https://developers.google.com/wallet/reference/rest/v1/eventticketclass/get

resourceId <string> The unique identifier for a class. This ID must be unique across all classes from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'."
  [resourceId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/eventTicketClass/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}))

(defn media-download
  "Downloads rotating barcode values for the transit object referenced by the given object ID.
https://developers.google.com/wallet/reference/rest/v1/media/download

resourceId <string> The unique identifier for an object. This ID must be unique across all objects from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'."
  [resourceId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/transitObject/{resourceId}/downloadRotatingBarcodeValues",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}))

(defn media-upload
  "Uploads rotating barcode values for the transit object referenced by the given object ID. Note the max upload size is specified in google3/production/config/cdd/apps-upload/customers/payments-consumer-passes/config.gcl and enforced by Scotty.
https://developers.google.com/wallet/reference/rest/v1/media/upload

resourceId <string> The unique identifier for an object. This ID must be unique across all objects from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
TransitObjectUploadRotatingBarcodeValuesRequest:
{:blob
 {:path string,
  :sha256Hash string,
  :algorithm string,
  :hash string,
  :contentTypeInfo
  {:fromHeader string,
   :bestGuess string,
   :fromUrlPath string,
   :fromFileName string,
   :fromBytes string},
  :diffChecksumsResponse
  {:checksumsLocation
   {:path string,
    :objectId
    {:bucketName string, :objectName string, :generation string},
    :crc32cHash integer,
    :blobRef string,
    :cosmoBinaryReference string,
    :md5Hash string,
    :sha1Hash string,
    :referenceType
    [PATH BLOB_REF INLINE BIGSTORE_REF COSMO_BINARY_REFERENCE],
    :length string,
    :blobstore2Info
    {:readToken string,
     :blobGeneration string,
     :downloadReadHandle string,
     :blobId string,
     :uploadMetadataContainer string},
    :inline string},
   :objectLocation
   {:path string,
    :objectId
    {:bucketName string, :objectName string, :generation string},
    :crc32cHash integer,
    :blobRef string,
    :cosmoBinaryReference string,
    :md5Hash string,
    :sha1Hash string,
    :referenceType
    [PATH BLOB_REF INLINE BIGSTORE_REF COSMO_BINARY_REFERENCE],
    :length string,
    :blobstore2Info
    {:readToken string,
     :blobGeneration string,
     :downloadReadHandle string,
     :blobId string,
     :uploadMetadataContainer string},
    :inline string},
   :objectSizeBytes string,
   :chunkSizeBytes string,
   :objectVersion string},
  :objectId
  {:bucketName string, :objectName string, :generation string},
  :crc32cHash integer,
  :isPotentialRetry boolean,
  :diffVersionResponse
  {:objectVersion string, :objectSizeBytes string},
  :blobRef string,
  :bigstoreObjectRef string,
  :cosmoBinaryReference string,
  :md5Hash string,
  :token string,
  :filename string,
  :diffUploadResponse
  {:originalObject
   {:path string,
    :objectId
    {:bucketName string, :objectName string, :generation string},
    :crc32cHash integer,
    :blobRef string,
    :cosmoBinaryReference string,
    :md5Hash string,
    :sha1Hash string,
    :referenceType
    [PATH BLOB_REF INLINE BIGSTORE_REF COSMO_BINARY_REFERENCE],
    :length string,
    :blobstore2Info
    {:readToken string,
     :blobGeneration string,
     :downloadReadHandle string,
     :blobId string,
     :uploadMetadataContainer string},
    :inline string},
   :objectVersion string},
  :sha1Hash string,
  :diffDownloadResponse
  {:objectLocation
   {:path string,
    :objectId
    {:bucketName string, :objectName string, :generation string},
    :crc32cHash integer,
    :blobRef string,
    :cosmoBinaryReference string,
    :md5Hash string,
    :sha1Hash string,
    :referenceType
    [PATH BLOB_REF INLINE BIGSTORE_REF COSMO_BINARY_REFERENCE],
    :length string,
    :blobstore2Info
    {:readToken string,
     :blobGeneration string,
     :downloadReadHandle string,
     :blobId string,
     :uploadMetadataContainer string},
    :inline string}},
  :compositeMedia
  [{:path string,
    :objectId
    {:bucketName string, :objectName string, :generation string},
    :crc32cHash integer,
    :blobRef string,
    :cosmoBinaryReference string,
    :md5Hash string,
    :sha1Hash string,
    :referenceType
    [PATH BLOB_REF INLINE BIGSTORE_REF COSMO_BINARY_REFERENCE],
    :length string,
    :blobstore2Info
    {:readToken string,
     :blobGeneration string,
     :downloadReadHandle string,
     :blobId string,
     :uploadMetadataContainer string},
    :inline string}],
  :referenceType
  [PATH
   BLOB_REF
   INLINE
   GET_MEDIA
   COMPOSITE_MEDIA
   BIGSTORE_REF
   DIFF_VERSION_RESPONSE
   DIFF_CHECKSUMS_RESPONSE
   DIFF_DOWNLOAD_RESPONSE
   DIFF_UPLOAD_REQUEST
   DIFF_UPLOAD_RESPONSE
   COSMO_BINARY_REFERENCE
   ARBITRARY_BYTES],
  :length string,
  :downloadParameters
  {:ignoreRange boolean, :allowGzipCompression boolean},
  :blobstore2Info
  {:readToken string,
   :blobGeneration string,
   :downloadReadHandle string,
   :blobId string,
   :uploadMetadataContainer string},
  :hashVerified boolean,
  :contentType string,
  :diffUploadRequest
  {:checksumsInfo
   {:path string,
    :objectId
    {:bucketName string, :objectName string, :generation string},
    :crc32cHash integer,
    :blobRef string,
    :cosmoBinaryReference string,
    :md5Hash string,
    :sha1Hash string,
    :referenceType
    [PATH BLOB_REF INLINE BIGSTORE_REF COSMO_BINARY_REFERENCE],
    :length string,
    :blobstore2Info
    {:readToken string,
     :blobGeneration string,
     :downloadReadHandle string,
     :blobId string,
     :uploadMetadataContainer string},
    :inline string},
   :objectInfo
   {:path string,
    :objectId
    {:bucketName string, :objectName string, :generation string},
    :crc32cHash integer,
    :blobRef string,
    :cosmoBinaryReference string,
    :md5Hash string,
    :sha1Hash string,
    :referenceType
    [PATH BLOB_REF INLINE BIGSTORE_REF COSMO_BINARY_REFERENCE],
    :length string,
    :blobstore2Info
    {:readToken string,
     :blobGeneration string,
     :downloadReadHandle string,
     :blobId string,
     :uploadMetadataContainer string},
    :inline string},
   :objectVersion string},
  :timestamp string,
  :inline string,
  :mediaId string},
 :mediaRequestInfo
 {:currentBytes string,
  :notificationType [START PROGRESS END RESPONSE_SENT ERROR],
  :requestReceivedParamsServingInfo string,
  :totalBytes string,
  :requestId string,
  :diffObjectVersion string,
  :finalStatus integer,
  :customData string,
  :totalBytesIsEstimated boolean}}"
  [resourceId TransitObjectUploadRotatingBarcodeValuesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/transitObject/{resourceId}/uploadRotatingBarcodeValues",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body TransitObjectUploadRotatingBarcodeValuesRequest}))

(defn genericobject-get
  "Returns the generic object with the given object ID.
https://developers.google.com/wallet/reference/rest/v1/genericobject/get

resourceId <string> The unique identifier for an object. This ID must be unique across all objects from an issuer. This value needs to follow the format `issuerID.identifier` where `issuerID` is issued by Google and `identifier` is chosen by you. The unique identifier can only include alphanumeric characters, `.`, `_`, or `-`."
  [resourceId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/genericObject/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}))

(defn genericobject-insert
  "Inserts a generic object with the given ID and properties.
https://developers.google.com/wallet/reference/rest/v1/genericobject/insert

GenericObject:
{:cardTitle
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :hasUsers boolean,
 :smartTapRedemptionValue string,
 :rotatingBarcode
 {:totpDetails
  {:periodMillis string,
   :algorithm [TOTP_ALGORITHM_UNSPECIFIED TOTP_SHA1],
   :parameters [{:valueLength integer, :key string}]},
  :alternateText string,
  :initialRotatingBarcodeValues
  {:startDateTime string, :values [string], :periodMillis string},
  :valuePattern string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :barcode
 {:kind string,
  :alternateText string,
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :value string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :logo
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :wideLogo
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :groupingInfo {:groupingId string, :sortIndex integer},
 :state
 [STATE_UNSPECIFIED
  ACTIVE
  active
  COMPLETED
  completed
  EXPIRED
  expired
  INACTIVE
  inactive],
 :header
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :validTimeInterval
 {:start {:date string}, :kind string, :end {:date string}},
 :notifications
 {:upcomingNotification {:enableNotification boolean},
  :expiryNotification {:enableNotification boolean}},
 :hexBackgroundColor string,
 :id string,
 :classId string,
 :passConstraints
 {:nfcConstraint
  [[NFC_CONSTRAINT_UNSPECIFIED
    BLOCK_PAYMENT
    BLOCK_CLOSED_LOOP_TRANSIT]],
  :screenshotEligibility
  [SCREENSHOT_ELIGIBILITY_UNSPECIFIED ELIGIBLE INELIGIBLE]},
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :genericType
 [GENERIC_TYPE_UNSPECIFIED
  GENERIC_SEASON_PASS
  GENERIC_UTILITY_BILLS
  GENERIC_PARKING_PASS
  GENERIC_VOUCHER
  GENERIC_GYM_MEMBERSHIP
  GENERIC_LIBRARY_MEMBERSHIP
  GENERIC_RESERVATIONS
  GENERIC_AUTO_INSURANCE
  GENERIC_HOME_INSURANCE
  GENERIC_ENTRY_TICKET
  GENERIC_RECEIPT
  GENERIC_OTHER],
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :subheader
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}}}"
  [GenericObject]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/genericObject",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body GenericObject}))

(defn genericobject-update
  "Updates the generic object referenced by the given object ID.
https://developers.google.com/wallet/reference/rest/v1/genericobject/update

resourceId <string> The unique identifier for an object. This ID must be unique across all objects from an issuer. This value needs to follow the format `issuerID.identifier` where `issuerID` is issued by Google and `identifier` is chosen by you. The unique identifier can only include alphanumeric characters, `.`, `_`, or `-`.
GenericObject:
{:cardTitle
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :hasUsers boolean,
 :smartTapRedemptionValue string,
 :rotatingBarcode
 {:totpDetails
  {:periodMillis string,
   :algorithm [TOTP_ALGORITHM_UNSPECIFIED TOTP_SHA1],
   :parameters [{:valueLength integer, :key string}]},
  :alternateText string,
  :initialRotatingBarcodeValues
  {:startDateTime string, :values [string], :periodMillis string},
  :valuePattern string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :barcode
 {:kind string,
  :alternateText string,
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :value string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :logo
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :wideLogo
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :groupingInfo {:groupingId string, :sortIndex integer},
 :state
 [STATE_UNSPECIFIED
  ACTIVE
  active
  COMPLETED
  completed
  EXPIRED
  expired
  INACTIVE
  inactive],
 :header
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :validTimeInterval
 {:start {:date string}, :kind string, :end {:date string}},
 :notifications
 {:upcomingNotification {:enableNotification boolean},
  :expiryNotification {:enableNotification boolean}},
 :hexBackgroundColor string,
 :id string,
 :classId string,
 :passConstraints
 {:nfcConstraint
  [[NFC_CONSTRAINT_UNSPECIFIED
    BLOCK_PAYMENT
    BLOCK_CLOSED_LOOP_TRANSIT]],
  :screenshotEligibility
  [SCREENSHOT_ELIGIBILITY_UNSPECIFIED ELIGIBLE INELIGIBLE]},
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :genericType
 [GENERIC_TYPE_UNSPECIFIED
  GENERIC_SEASON_PASS
  GENERIC_UTILITY_BILLS
  GENERIC_PARKING_PASS
  GENERIC_VOUCHER
  GENERIC_GYM_MEMBERSHIP
  GENERIC_LIBRARY_MEMBERSHIP
  GENERIC_RESERVATIONS
  GENERIC_AUTO_INSURANCE
  GENERIC_HOME_INSURANCE
  GENERIC_ENTRY_TICKET
  GENERIC_RECEIPT
  GENERIC_OTHER],
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :subheader
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}}}"
  [resourceId GenericObject]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/genericObject/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body GenericObject}))

(defn genericobject-list
  "Returns a list of all generic objects for a given issuer ID.
https://developers.google.com/wallet/reference/rest/v1/genericobject/list

optional:
token <string> Used to get the next set of results if `maxResults` is specified, but more than `maxResults` objects are available in a list. For example, if you have a list of 200 objects and you call list with `maxResults` set to 20, list will return the first 20 objects and a token. Call list again with `maxResults` set to 20 and the token to get the next 20 objects.
maxResults <integer> Identifies the max number of results returned by a list. All results are returned if `maxResults` isn't defined.
classId <string> The ID of the class whose objects will be listed."
  ([] (genericobject-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://walletobjects.googleapis.com/walletobjects/v1/genericObject",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/wallet_object.issuer"]})))

(defn genericobject-addmessage
  "Adds a message to the generic object referenced by the given object ID.
https://developers.google.com/wallet/reference/rest/v1/genericobject/addmessage

resourceId <string> The unique identifier for an object. This ID must be unique across all classes from an issuer. This value should follow the format issuer ID. identifier where the former is issued by Google and latter is chosen by you. Your unique identifier should only include alphanumeric characters, '.', '_', or '-'.
AddMessageRequest:
{:message
 {:kind string,
  :displayInterval
  {:start {:date string}, :kind string, :end {:date string}},
  :body string,
  :localizedBody
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :id string,
  :messageType
  [MESSAGE_TYPE_UNSPECIFIED
   TEXT
   text
   EXPIRATION_NOTIFICATION
   expirationNotification
   TEXT_AND_NOTIFY],
  :localizedHeader
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :header string}}"
  [resourceId AddMessageRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/genericObject/{resourceId}/addMessage",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body AddMessageRequest}))

(defn genericobject-patch
  "Updates the generic object referenced by the given object ID. This method supports patch semantics.
https://developers.google.com/wallet/reference/rest/v1/genericobject/patch

resourceId <string> The unique identifier for an object. This ID must be unique across all objects from an issuer. This value needs to follow the format `issuerID.identifier` where `issuerID` is issued by Google and `identifier` is chosen by you. The unique identifier can only include alphanumeric characters, `.`, `_`, or `-`.
GenericObject:
{:cardTitle
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :hasUsers boolean,
 :smartTapRedemptionValue string,
 :rotatingBarcode
 {:totpDetails
  {:periodMillis string,
   :algorithm [TOTP_ALGORITHM_UNSPECIFIED TOTP_SHA1],
   :parameters [{:valueLength integer, :key string}]},
  :alternateText string,
  :initialRotatingBarcodeValues
  {:startDateTime string, :values [string], :periodMillis string},
  :valuePattern string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :textModulesData
 [{:header string,
   :id string,
   :localizedHeader
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :localizedBody
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :body string}],
 :barcode
 {:kind string,
  :alternateText string,
  :renderEncoding [RENDER_ENCODING_UNSPECIFIED UTF_8],
  :value string,
  :showCodeText
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :type
  [BARCODE_TYPE_UNSPECIFIED
   AZTEC
   aztec
   CODE_39
   code39
   CODE_128
   code128
   CODABAR
   codabar
   DATA_MATRIX
   dataMatrix
   EAN_8
   ean8
   EAN_13
   ean13
   EAN13
   ITF_14
   itf14
   PDF_417
   pdf417
   PDF417
   QR_CODE
   qrCode
   qrcode
   UPC_A
   upcA
   TEXT_ONLY
   textOnly]},
 :logo
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :wideLogo
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :groupingInfo {:groupingId string, :sortIndex integer},
 :state
 [STATE_UNSPECIFIED
  ACTIVE
  active
  COMPLETED
  completed
  EXPIRED
  expired
  INACTIVE
  inactive],
 :header
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}},
 :linksModuleData
 {:uris
  [{:description string,
    :kind string,
    :id string,
    :localizedDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :uri string}]},
 :imageModulesData
 [{:id string,
   :mainImage
   {:contentDescription
    {:translatedValues
     [{:value string, :language string, :kind string}],
     :kind string,
     :defaultValue {:value string, :language string, :kind string}},
    :sourceUri
    {:description string,
     :localizedDescription
     {:translatedValues [TranslatedString],
      :kind string,
      :defaultValue TranslatedString},
     :uri string},
    :kind string}}],
 :validTimeInterval
 {:start {:date string}, :kind string, :end {:date string}},
 :notifications
 {:upcomingNotification {:enableNotification boolean},
  :expiryNotification {:enableNotification boolean}},
 :hexBackgroundColor string,
 :id string,
 :classId string,
 :passConstraints
 {:nfcConstraint
  [[NFC_CONSTRAINT_UNSPECIFIED
    BLOCK_PAYMENT
    BLOCK_CLOSED_LOOP_TRANSIT]],
  :screenshotEligibility
  [SCREENSHOT_ELIGIBILITY_UNSPECIFIED ELIGIBLE INELIGIBLE]},
 :appLinkData
 {:androidAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :webAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}},
  :iosAppLinkInfo
  {:appLogoImage
   {:contentDescription
    {:translatedValues [TranslatedString],
     :kind string,
     :defaultValue TranslatedString},
    :sourceUri
    {:description string,
     :localizedDescription LocalizedString,
     :uri string},
    :kind string},
   :description
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :title
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :appTarget
   {:packageName string,
    :targetUri
    {:description string,
     :kind string,
     :id string,
     :localizedDescription LocalizedString,
     :uri string}}}},
 :genericType
 [GENERIC_TYPE_UNSPECIFIED
  GENERIC_SEASON_PASS
  GENERIC_UTILITY_BILLS
  GENERIC_PARKING_PASS
  GENERIC_VOUCHER
  GENERIC_GYM_MEMBERSHIP
  GENERIC_LIBRARY_MEMBERSHIP
  GENERIC_RESERVATIONS
  GENERIC_AUTO_INSURANCE
  GENERIC_HOME_INSURANCE
  GENERIC_ENTRY_TICKET
  GENERIC_RECEIPT
  GENERIC_OTHER],
 :heroImage
 {:contentDescription
  {:translatedValues [{:value string, :language string, :kind string}],
   :kind string,
   :defaultValue {:value string, :language string, :kind string}},
  :sourceUri
  {:description string,
   :localizedDescription
   {:translatedValues
    [{:value string, :language string, :kind string}],
    :kind string,
    :defaultValue {:value string, :language string, :kind string}},
   :uri string},
  :kind string},
 :subheader
 {:translatedValues [{:value string, :language string, :kind string}],
  :kind string,
  :defaultValue {:value string, :language string, :kind string}}}"
  [resourceId GenericObject]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://walletobjects.googleapis.com/walletobjects/v1/genericObject/{resourceId}",
     :uri-template-args {:resourceId resourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/wallet_object.issuer"],
     :body GenericObject}))

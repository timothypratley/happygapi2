(ns happygapi2.adexchangebuyer2
  "Ad Exchange Buyer API II
Accesses the latest features for managing Authorized Buyers accounts, Real-Time Bidding configurations and auction metrics, and Marketplace programmatic deals.
See: https://developers.google.com/authorized-buyers/apis/reference/rest/"
  (:require [happy.oauth2.client :as client]))

(defn accounts-creatives-create
  "Creates a creative.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/accounts.creatives/create

accountId <string> The account that this creative belongs to. Can be used to filter the response of the creatives.list method.
Creative:
{:video {:videoUrl string, :videoVastXml string},
 :detectedProductCategories [integer],
 :servingRestrictions
 [{:status [STATUS_UNSPECIFIED DISAPPROVAL PENDING_REVIEW],
   :contexts
   [{:all [SIMPLE_CONTEXT],
     :location {:geoCriteriaIds [integer]},
     :platform {:platforms [[DESKTOP ANDROID IOS]]},
     :auctionType {:auctionTypes [[OPEN_AUCTION DIRECT_DEALS]]},
     :securityType {:securities [[INSECURE SSL]]},
     :appType {:appTypes [[NATIVE WEB]]}}],
   :disapprovalReasons
   [{:reason
     [LENGTH_OF_IMAGE_ANIMATION
      BROKEN_URL
      MEDIA_NOT_FUNCTIONAL
      INVALID_FOURTH_PARTY_CALL
      INCORRECT_REMARKETING_DECLARATION
      LANDING_PAGE_ERROR
      AD_SIZE_DOES_NOT_MATCH_AD_SLOT
      NO_BORDER
      FOURTH_PARTY_BROWSER_COOKIES
      LSO_OBJECTS
      BLANK_CREATIVE
      DESTINATION_URLS_UNDECLARED
      PROBLEM_WITH_CLICK_MACRO
      INCORRECT_AD_TECHNOLOGY_DECLARATION
      INCORRECT_DESTINATION_URL_DECLARATION
      EXPANDABLE_INCORRECT_DIRECTION
      EXPANDABLE_DIRECTION_NOT_SUPPORTED
      EXPANDABLE_INVALID_VENDOR
      EXPANDABLE_FUNCTIONALITY
      VIDEO_INVALID_VENDOR
      VIDEO_UNSUPPORTED_LENGTH
      VIDEO_UNSUPPORTED_FORMAT
      VIDEO_FUNCTIONALITY
      LANDING_PAGE_DISABLED
      MALWARE_SUSPECTED
      ADULT_IMAGE_OR_VIDEO
      INACCURATE_AD_TEXT
      COUNTERFEIT_DESIGNER_GOODS
      POP_UP
      INVALID_RTB_PROTOCOL_USAGE
      RAW_IP_ADDRESS_IN_SNIPPET
      UNACCEPTABLE_CONTENT_SOFTWARE
      UNAUTHORIZED_COOKIE_ON_GOOGLE_DOMAIN
      UNDECLARED_FLASH_OBJECTS
      INVALID_SSL_DECLARATION
      DIRECT_DOWNLOAD_IN_AD
      MAXIMUM_DOWNLOAD_SIZE_EXCEEDED
      DESTINATION_URL_SITE_NOT_CRAWLABLE
      BAD_URL_LEGAL_DISAPPROVAL
      PHARMA_GAMBLING_ALCOHOL_NOT_ALLOWED
      DYNAMIC_DNS_AT_DESTINATION_URL
      POOR_IMAGE_OR_VIDEO_QUALITY
      UNACCEPTABLE_IMAGE_CONTENT
      INCORRECT_IMAGE_LAYOUT
      IRRELEVANT_IMAGE_OR_VIDEO
      DESTINATION_SITE_DOES_NOT_ALLOW_GOING_BACK
      MISLEADING_CLAIMS_IN_AD
      RESTRICTED_PRODUCTS
      UNACCEPTABLE_CONTENT
      AUTOMATED_AD_CLICKING
      INVALID_URL_PROTOCOL
      UNDECLARED_RESTRICTED_CONTENT
      INVALID_REMARKETING_LIST_USAGE
      DESTINATION_SITE_NOT_CRAWLABLE_ROBOTS_TXT
      CLICK_TO_DOWNLOAD_NOT_AN_APP
      INACCURATE_REVIEW_EXTENSION
      SEXUALLY_EXPLICIT_CONTENT
      GAINING_AN_UNFAIR_ADVANTAGE
      GAMING_THE_GOOGLE_NETWORK
      DANGEROUS_PRODUCTS_KNIVES
      DANGEROUS_PRODUCTS_EXPLOSIVES
      DANGEROUS_PRODUCTS_GUNS
      DANGEROUS_PRODUCTS_DRUGS
      DANGEROUS_PRODUCTS_TOBACCO
      DANGEROUS_PRODUCTS_WEAPONS
      UNCLEAR_OR_IRRELEVANT_AD
      PROFESSIONAL_STANDARDS
      DYSFUNCTIONAL_PROMOTION
      INVALID_INTEREST_BASED_AD
      MISUSE_OF_PERSONAL_INFORMATION
      OMISSION_OF_RELEVANT_INFORMATION
      UNAVAILABLE_PROMOTIONS
      MISLEADING_PROMOTIONS
      INAPPROPRIATE_CONTENT
      SENSITIVE_EVENTS
      SHOCKING_CONTENT
      ENABLING_DISHONEST_BEHAVIOR
      TECHNICAL_REQUIREMENTS
      RESTRICTED_POLITICAL_CONTENT
      UNSUPPORTED_CONTENT
      INVALID_BIDDING_METHOD
      VIDEO_TOO_LONG
      VIOLATES_JAPANESE_PHARMACY_LAW
      UNACCREDITED_PET_PHARMACY
      ABORTION
      CONTRACEPTIVES
      NEED_CERTIFICATES_TO_ADVERTISE_IN_CHINA
      KCDSP_REGISTRATION
      NOT_FAMILY_SAFE
      CLINICAL_TRIAL_RECRUITMENT
      MAXIMUM_NUMBER_OF_HTTP_CALLS_EXCEEDED
      MAXIMUM_NUMBER_OF_COOKIES_EXCEEDED
      PERSONAL_LOANS
      UNSUPPORTED_FLASH_CONTENT
      MISUSE_BY_OMID_SCRIPT
      NON_WHITELISTED_OMID_VENDOR
      DESTINATION_EXPERIENCE
      UNSUPPORTED_LANGUAGE
      NON_SSL_COMPLIANT
      TEMPORARY_PAUSE
      BAIL_BONDS
      EXPERIMENTAL_MEDICAL_TREATMENT],
     :details [string]}],
   :disapproval
   {:reason
    [LENGTH_OF_IMAGE_ANIMATION
     BROKEN_URL
     MEDIA_NOT_FUNCTIONAL
     INVALID_FOURTH_PARTY_CALL
     INCORRECT_REMARKETING_DECLARATION
     LANDING_PAGE_ERROR
     AD_SIZE_DOES_NOT_MATCH_AD_SLOT
     NO_BORDER
     FOURTH_PARTY_BROWSER_COOKIES
     LSO_OBJECTS
     BLANK_CREATIVE
     DESTINATION_URLS_UNDECLARED
     PROBLEM_WITH_CLICK_MACRO
     INCORRECT_AD_TECHNOLOGY_DECLARATION
     INCORRECT_DESTINATION_URL_DECLARATION
     EXPANDABLE_INCORRECT_DIRECTION
     EXPANDABLE_DIRECTION_NOT_SUPPORTED
     EXPANDABLE_INVALID_VENDOR
     EXPANDABLE_FUNCTIONALITY
     VIDEO_INVALID_VENDOR
     VIDEO_UNSUPPORTED_LENGTH
     VIDEO_UNSUPPORTED_FORMAT
     VIDEO_FUNCTIONALITY
     LANDING_PAGE_DISABLED
     MALWARE_SUSPECTED
     ADULT_IMAGE_OR_VIDEO
     INACCURATE_AD_TEXT
     COUNTERFEIT_DESIGNER_GOODS
     POP_UP
     INVALID_RTB_PROTOCOL_USAGE
     RAW_IP_ADDRESS_IN_SNIPPET
     UNACCEPTABLE_CONTENT_SOFTWARE
     UNAUTHORIZED_COOKIE_ON_GOOGLE_DOMAIN
     UNDECLARED_FLASH_OBJECTS
     INVALID_SSL_DECLARATION
     DIRECT_DOWNLOAD_IN_AD
     MAXIMUM_DOWNLOAD_SIZE_EXCEEDED
     DESTINATION_URL_SITE_NOT_CRAWLABLE
     BAD_URL_LEGAL_DISAPPROVAL
     PHARMA_GAMBLING_ALCOHOL_NOT_ALLOWED
     DYNAMIC_DNS_AT_DESTINATION_URL
     POOR_IMAGE_OR_VIDEO_QUALITY
     UNACCEPTABLE_IMAGE_CONTENT
     INCORRECT_IMAGE_LAYOUT
     IRRELEVANT_IMAGE_OR_VIDEO
     DESTINATION_SITE_DOES_NOT_ALLOW_GOING_BACK
     MISLEADING_CLAIMS_IN_AD
     RESTRICTED_PRODUCTS
     UNACCEPTABLE_CONTENT
     AUTOMATED_AD_CLICKING
     INVALID_URL_PROTOCOL
     UNDECLARED_RESTRICTED_CONTENT
     INVALID_REMARKETING_LIST_USAGE
     DESTINATION_SITE_NOT_CRAWLABLE_ROBOTS_TXT
     CLICK_TO_DOWNLOAD_NOT_AN_APP
     INACCURATE_REVIEW_EXTENSION
     SEXUALLY_EXPLICIT_CONTENT
     GAINING_AN_UNFAIR_ADVANTAGE
     GAMING_THE_GOOGLE_NETWORK
     DANGEROUS_PRODUCTS_KNIVES
     DANGEROUS_PRODUCTS_EXPLOSIVES
     DANGEROUS_PRODUCTS_GUNS
     DANGEROUS_PRODUCTS_DRUGS
     DANGEROUS_PRODUCTS_TOBACCO
     DANGEROUS_PRODUCTS_WEAPONS
     UNCLEAR_OR_IRRELEVANT_AD
     PROFESSIONAL_STANDARDS
     DYSFUNCTIONAL_PROMOTION
     INVALID_INTEREST_BASED_AD
     MISUSE_OF_PERSONAL_INFORMATION
     OMISSION_OF_RELEVANT_INFORMATION
     UNAVAILABLE_PROMOTIONS
     MISLEADING_PROMOTIONS
     INAPPROPRIATE_CONTENT
     SENSITIVE_EVENTS
     SHOCKING_CONTENT
     ENABLING_DISHONEST_BEHAVIOR
     TECHNICAL_REQUIREMENTS
     RESTRICTED_POLITICAL_CONTENT
     UNSUPPORTED_CONTENT
     INVALID_BIDDING_METHOD
     VIDEO_TOO_LONG
     VIOLATES_JAPANESE_PHARMACY_LAW
     UNACCREDITED_PET_PHARMACY
     ABORTION
     CONTRACEPTIVES
     NEED_CERTIFICATES_TO_ADVERTISE_IN_CHINA
     KCDSP_REGISTRATION
     NOT_FAMILY_SAFE
     CLINICAL_TRIAL_RECRUITMENT
     MAXIMUM_NUMBER_OF_HTTP_CALLS_EXCEEDED
     MAXIMUM_NUMBER_OF_COOKIES_EXCEEDED
     PERSONAL_LOANS
     UNSUPPORTED_FLASH_CONTENT
     MISUSE_BY_OMID_SCRIPT
     NON_WHITELISTED_OMID_VENDOR
     DESTINATION_EXPERIENCE
     UNSUPPORTED_LANGUAGE
     NON_SSL_COMPLIANT
     TEMPORARY_PAUSE
     BAIL_BONDS
     EXPERIMENTAL_MEDICAL_TREATMENT],
    :details [string]}}],
 :declaredClickThroughUrls [string],
 :advertiserName string,
 :adTechnologyProviders
 {:detectedProviderIds [string], :hasUnidentifiedProvider boolean},
 :adChoicesDestinationUrl string,
 :impressionTrackingUrls [string],
 :dealsStatus
 [STATUS_UNSPECIFIED
  NOT_CHECKED
  CONDITIONALLY_APPROVED
  APPROVED
  DISAPPROVED
  PENDING_REVIEW
  STATUS_TYPE_UNSPECIFIED],
 :apiUpdateTime string,
 :detectedSensitiveCategories [integer],
 :openAuctionStatus
 [STATUS_UNSPECIFIED
  NOT_CHECKED
  CONDITIONALLY_APPROVED
  APPROVED
  DISAPPROVED
  PENDING_REVIEW
  STATUS_TYPE_UNSPECIFIED],
 :restrictedCategories [[NO_RESTRICTED_CATEGORIES ALCOHOL]],
 :corrections
 [{:type
   [CORRECTION_TYPE_UNSPECIFIED
    VENDOR_IDS_ADDED
    SSL_ATTRIBUTE_REMOVED
    FLASH_FREE_ATTRIBUTE_REMOVED
    FLASH_FREE_ATTRIBUTE_ADDED
    REQUIRED_ATTRIBUTE_ADDED
    REQUIRED_VENDOR_ADDED
    SSL_ATTRIBUTE_ADDED
    IN_BANNER_VIDEO_ATTRIBUTE_ADDED
    MRAID_ATTRIBUTE_ADDED
    FLASH_ATTRIBUTE_REMOVED
    VIDEO_IN_SNIPPET_ATTRIBUTE_ADDED],
   :details [string],
   :contexts
   [{:all [SIMPLE_CONTEXT],
     :location {:geoCriteriaIds [integer]},
     :platform {:platforms [[DESKTOP ANDROID IOS]]},
     :auctionType {:auctionTypes [[OPEN_AUCTION DIRECT_DEALS]]},
     :securityType {:securities [[INSECURE SSL]]},
     :appType {:appTypes [[NATIVE WEB]]}}]}],
 :detectedDomains [string],
 :detectedLanguages [string],
 :creativeId string,
 :native
 {:clickLinkUrl string,
  :headline string,
  :starRating number,
  :storeUrl string,
  :logo {:url string, :width integer, :height integer},
  :advertiserName string,
  :appIcon {:url string, :width integer, :height integer},
  :priceDisplayText string,
  :callToAction string,
  :clickTrackingUrl string,
  :videoUrl string,
  :image {:url string, :width integer, :height integer},
  :body string},
 :detectedAdvertiserIds [string],
 :vendorIds [integer],
 :agencyId string,
 :version integer,
 :attributes
 [[ATTRIBUTE_UNSPECIFIED
   IMAGE_RICH_MEDIA
   ADOBE_FLASH_FLV
   IS_TAGGED
   IS_COOKIE_TARGETED
   IS_USER_INTEREST_TARGETED
   EXPANDING_DIRECTION_NONE
   EXPANDING_DIRECTION_UP
   EXPANDING_DIRECTION_DOWN
   EXPANDING_DIRECTION_LEFT
   EXPANDING_DIRECTION_RIGHT
   EXPANDING_DIRECTION_UP_LEFT
   EXPANDING_DIRECTION_UP_RIGHT
   EXPANDING_DIRECTION_DOWN_LEFT
   EXPANDING_DIRECTION_DOWN_RIGHT
   CREATIVE_TYPE_HTML
   CREATIVE_TYPE_VAST_VIDEO
   EXPANDING_DIRECTION_UP_OR_DOWN
   EXPANDING_DIRECTION_LEFT_OR_RIGHT
   EXPANDING_DIRECTION_ANY_DIAGONAL
   EXPANDING_ACTION_ROLLOVER_TO_EXPAND
   INSTREAM_VAST_VIDEO_TYPE_VPAID_FLASH
   RICH_MEDIA_CAPABILITY_TYPE_MRAID
   RICH_MEDIA_CAPABILITY_TYPE_FLASH
   RICH_MEDIA_CAPABILITY_TYPE_HTML5
   SKIPPABLE_INSTREAM_VIDEO
   RICH_MEDIA_CAPABILITY_TYPE_SSL
   RICH_MEDIA_CAPABILITY_TYPE_NON_SSL
   RICH_MEDIA_CAPABILITY_TYPE_INTERSTITIAL
   NON_SKIPPABLE_INSTREAM_VIDEO
   NATIVE_ELIGIBILITY_ELIGIBLE
   NON_VPAID
   NATIVE_ELIGIBILITY_NOT_ELIGIBLE
   ANY_INTERSTITIAL
   NON_INTERSTITIAL
   IN_BANNER_VIDEO
   RENDERING_SIZELESS_ADX
   OMSDK_1_0
   RENDERING_PLAYABLE]],
 :accountId string,
 :clickThroughUrls [string],
 :html {:snippet string, :width integer, :height integer}}

optional:
duplicateIdMode <string> Indicates if multiple creatives can share an ID or not. Default is NO_DUPLICATES (one ID per creative)."
  ([accountId Creative]
    (accounts-creatives-create accountId Creative nil))
  ([accountId Creative optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/accounts/{accountId}/creatives",
       :uri-template-args {:accountId accountId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"],
       :body Creative})))

(defn accounts-creatives-update
  "Updates a creative.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/accounts.creatives/update

accountId <string> The account that this creative belongs to. Can be used to filter the response of the creatives.list method.
creativeId <string> The buyer-defined creative ID of this creative. Can be used to filter the response of the creatives.list method.
Creative:
{:video {:videoUrl string, :videoVastXml string},
 :detectedProductCategories [integer],
 :servingRestrictions
 [{:status [STATUS_UNSPECIFIED DISAPPROVAL PENDING_REVIEW],
   :contexts
   [{:all [SIMPLE_CONTEXT],
     :location {:geoCriteriaIds [integer]},
     :platform {:platforms [[DESKTOP ANDROID IOS]]},
     :auctionType {:auctionTypes [[OPEN_AUCTION DIRECT_DEALS]]},
     :securityType {:securities [[INSECURE SSL]]},
     :appType {:appTypes [[NATIVE WEB]]}}],
   :disapprovalReasons
   [{:reason
     [LENGTH_OF_IMAGE_ANIMATION
      BROKEN_URL
      MEDIA_NOT_FUNCTIONAL
      INVALID_FOURTH_PARTY_CALL
      INCORRECT_REMARKETING_DECLARATION
      LANDING_PAGE_ERROR
      AD_SIZE_DOES_NOT_MATCH_AD_SLOT
      NO_BORDER
      FOURTH_PARTY_BROWSER_COOKIES
      LSO_OBJECTS
      BLANK_CREATIVE
      DESTINATION_URLS_UNDECLARED
      PROBLEM_WITH_CLICK_MACRO
      INCORRECT_AD_TECHNOLOGY_DECLARATION
      INCORRECT_DESTINATION_URL_DECLARATION
      EXPANDABLE_INCORRECT_DIRECTION
      EXPANDABLE_DIRECTION_NOT_SUPPORTED
      EXPANDABLE_INVALID_VENDOR
      EXPANDABLE_FUNCTIONALITY
      VIDEO_INVALID_VENDOR
      VIDEO_UNSUPPORTED_LENGTH
      VIDEO_UNSUPPORTED_FORMAT
      VIDEO_FUNCTIONALITY
      LANDING_PAGE_DISABLED
      MALWARE_SUSPECTED
      ADULT_IMAGE_OR_VIDEO
      INACCURATE_AD_TEXT
      COUNTERFEIT_DESIGNER_GOODS
      POP_UP
      INVALID_RTB_PROTOCOL_USAGE
      RAW_IP_ADDRESS_IN_SNIPPET
      UNACCEPTABLE_CONTENT_SOFTWARE
      UNAUTHORIZED_COOKIE_ON_GOOGLE_DOMAIN
      UNDECLARED_FLASH_OBJECTS
      INVALID_SSL_DECLARATION
      DIRECT_DOWNLOAD_IN_AD
      MAXIMUM_DOWNLOAD_SIZE_EXCEEDED
      DESTINATION_URL_SITE_NOT_CRAWLABLE
      BAD_URL_LEGAL_DISAPPROVAL
      PHARMA_GAMBLING_ALCOHOL_NOT_ALLOWED
      DYNAMIC_DNS_AT_DESTINATION_URL
      POOR_IMAGE_OR_VIDEO_QUALITY
      UNACCEPTABLE_IMAGE_CONTENT
      INCORRECT_IMAGE_LAYOUT
      IRRELEVANT_IMAGE_OR_VIDEO
      DESTINATION_SITE_DOES_NOT_ALLOW_GOING_BACK
      MISLEADING_CLAIMS_IN_AD
      RESTRICTED_PRODUCTS
      UNACCEPTABLE_CONTENT
      AUTOMATED_AD_CLICKING
      INVALID_URL_PROTOCOL
      UNDECLARED_RESTRICTED_CONTENT
      INVALID_REMARKETING_LIST_USAGE
      DESTINATION_SITE_NOT_CRAWLABLE_ROBOTS_TXT
      CLICK_TO_DOWNLOAD_NOT_AN_APP
      INACCURATE_REVIEW_EXTENSION
      SEXUALLY_EXPLICIT_CONTENT
      GAINING_AN_UNFAIR_ADVANTAGE
      GAMING_THE_GOOGLE_NETWORK
      DANGEROUS_PRODUCTS_KNIVES
      DANGEROUS_PRODUCTS_EXPLOSIVES
      DANGEROUS_PRODUCTS_GUNS
      DANGEROUS_PRODUCTS_DRUGS
      DANGEROUS_PRODUCTS_TOBACCO
      DANGEROUS_PRODUCTS_WEAPONS
      UNCLEAR_OR_IRRELEVANT_AD
      PROFESSIONAL_STANDARDS
      DYSFUNCTIONAL_PROMOTION
      INVALID_INTEREST_BASED_AD
      MISUSE_OF_PERSONAL_INFORMATION
      OMISSION_OF_RELEVANT_INFORMATION
      UNAVAILABLE_PROMOTIONS
      MISLEADING_PROMOTIONS
      INAPPROPRIATE_CONTENT
      SENSITIVE_EVENTS
      SHOCKING_CONTENT
      ENABLING_DISHONEST_BEHAVIOR
      TECHNICAL_REQUIREMENTS
      RESTRICTED_POLITICAL_CONTENT
      UNSUPPORTED_CONTENT
      INVALID_BIDDING_METHOD
      VIDEO_TOO_LONG
      VIOLATES_JAPANESE_PHARMACY_LAW
      UNACCREDITED_PET_PHARMACY
      ABORTION
      CONTRACEPTIVES
      NEED_CERTIFICATES_TO_ADVERTISE_IN_CHINA
      KCDSP_REGISTRATION
      NOT_FAMILY_SAFE
      CLINICAL_TRIAL_RECRUITMENT
      MAXIMUM_NUMBER_OF_HTTP_CALLS_EXCEEDED
      MAXIMUM_NUMBER_OF_COOKIES_EXCEEDED
      PERSONAL_LOANS
      UNSUPPORTED_FLASH_CONTENT
      MISUSE_BY_OMID_SCRIPT
      NON_WHITELISTED_OMID_VENDOR
      DESTINATION_EXPERIENCE
      UNSUPPORTED_LANGUAGE
      NON_SSL_COMPLIANT
      TEMPORARY_PAUSE
      BAIL_BONDS
      EXPERIMENTAL_MEDICAL_TREATMENT],
     :details [string]}],
   :disapproval
   {:reason
    [LENGTH_OF_IMAGE_ANIMATION
     BROKEN_URL
     MEDIA_NOT_FUNCTIONAL
     INVALID_FOURTH_PARTY_CALL
     INCORRECT_REMARKETING_DECLARATION
     LANDING_PAGE_ERROR
     AD_SIZE_DOES_NOT_MATCH_AD_SLOT
     NO_BORDER
     FOURTH_PARTY_BROWSER_COOKIES
     LSO_OBJECTS
     BLANK_CREATIVE
     DESTINATION_URLS_UNDECLARED
     PROBLEM_WITH_CLICK_MACRO
     INCORRECT_AD_TECHNOLOGY_DECLARATION
     INCORRECT_DESTINATION_URL_DECLARATION
     EXPANDABLE_INCORRECT_DIRECTION
     EXPANDABLE_DIRECTION_NOT_SUPPORTED
     EXPANDABLE_INVALID_VENDOR
     EXPANDABLE_FUNCTIONALITY
     VIDEO_INVALID_VENDOR
     VIDEO_UNSUPPORTED_LENGTH
     VIDEO_UNSUPPORTED_FORMAT
     VIDEO_FUNCTIONALITY
     LANDING_PAGE_DISABLED
     MALWARE_SUSPECTED
     ADULT_IMAGE_OR_VIDEO
     INACCURATE_AD_TEXT
     COUNTERFEIT_DESIGNER_GOODS
     POP_UP
     INVALID_RTB_PROTOCOL_USAGE
     RAW_IP_ADDRESS_IN_SNIPPET
     UNACCEPTABLE_CONTENT_SOFTWARE
     UNAUTHORIZED_COOKIE_ON_GOOGLE_DOMAIN
     UNDECLARED_FLASH_OBJECTS
     INVALID_SSL_DECLARATION
     DIRECT_DOWNLOAD_IN_AD
     MAXIMUM_DOWNLOAD_SIZE_EXCEEDED
     DESTINATION_URL_SITE_NOT_CRAWLABLE
     BAD_URL_LEGAL_DISAPPROVAL
     PHARMA_GAMBLING_ALCOHOL_NOT_ALLOWED
     DYNAMIC_DNS_AT_DESTINATION_URL
     POOR_IMAGE_OR_VIDEO_QUALITY
     UNACCEPTABLE_IMAGE_CONTENT
     INCORRECT_IMAGE_LAYOUT
     IRRELEVANT_IMAGE_OR_VIDEO
     DESTINATION_SITE_DOES_NOT_ALLOW_GOING_BACK
     MISLEADING_CLAIMS_IN_AD
     RESTRICTED_PRODUCTS
     UNACCEPTABLE_CONTENT
     AUTOMATED_AD_CLICKING
     INVALID_URL_PROTOCOL
     UNDECLARED_RESTRICTED_CONTENT
     INVALID_REMARKETING_LIST_USAGE
     DESTINATION_SITE_NOT_CRAWLABLE_ROBOTS_TXT
     CLICK_TO_DOWNLOAD_NOT_AN_APP
     INACCURATE_REVIEW_EXTENSION
     SEXUALLY_EXPLICIT_CONTENT
     GAINING_AN_UNFAIR_ADVANTAGE
     GAMING_THE_GOOGLE_NETWORK
     DANGEROUS_PRODUCTS_KNIVES
     DANGEROUS_PRODUCTS_EXPLOSIVES
     DANGEROUS_PRODUCTS_GUNS
     DANGEROUS_PRODUCTS_DRUGS
     DANGEROUS_PRODUCTS_TOBACCO
     DANGEROUS_PRODUCTS_WEAPONS
     UNCLEAR_OR_IRRELEVANT_AD
     PROFESSIONAL_STANDARDS
     DYSFUNCTIONAL_PROMOTION
     INVALID_INTEREST_BASED_AD
     MISUSE_OF_PERSONAL_INFORMATION
     OMISSION_OF_RELEVANT_INFORMATION
     UNAVAILABLE_PROMOTIONS
     MISLEADING_PROMOTIONS
     INAPPROPRIATE_CONTENT
     SENSITIVE_EVENTS
     SHOCKING_CONTENT
     ENABLING_DISHONEST_BEHAVIOR
     TECHNICAL_REQUIREMENTS
     RESTRICTED_POLITICAL_CONTENT
     UNSUPPORTED_CONTENT
     INVALID_BIDDING_METHOD
     VIDEO_TOO_LONG
     VIOLATES_JAPANESE_PHARMACY_LAW
     UNACCREDITED_PET_PHARMACY
     ABORTION
     CONTRACEPTIVES
     NEED_CERTIFICATES_TO_ADVERTISE_IN_CHINA
     KCDSP_REGISTRATION
     NOT_FAMILY_SAFE
     CLINICAL_TRIAL_RECRUITMENT
     MAXIMUM_NUMBER_OF_HTTP_CALLS_EXCEEDED
     MAXIMUM_NUMBER_OF_COOKIES_EXCEEDED
     PERSONAL_LOANS
     UNSUPPORTED_FLASH_CONTENT
     MISUSE_BY_OMID_SCRIPT
     NON_WHITELISTED_OMID_VENDOR
     DESTINATION_EXPERIENCE
     UNSUPPORTED_LANGUAGE
     NON_SSL_COMPLIANT
     TEMPORARY_PAUSE
     BAIL_BONDS
     EXPERIMENTAL_MEDICAL_TREATMENT],
    :details [string]}}],
 :declaredClickThroughUrls [string],
 :advertiserName string,
 :adTechnologyProviders
 {:detectedProviderIds [string], :hasUnidentifiedProvider boolean},
 :adChoicesDestinationUrl string,
 :impressionTrackingUrls [string],
 :dealsStatus
 [STATUS_UNSPECIFIED
  NOT_CHECKED
  CONDITIONALLY_APPROVED
  APPROVED
  DISAPPROVED
  PENDING_REVIEW
  STATUS_TYPE_UNSPECIFIED],
 :apiUpdateTime string,
 :detectedSensitiveCategories [integer],
 :openAuctionStatus
 [STATUS_UNSPECIFIED
  NOT_CHECKED
  CONDITIONALLY_APPROVED
  APPROVED
  DISAPPROVED
  PENDING_REVIEW
  STATUS_TYPE_UNSPECIFIED],
 :restrictedCategories [[NO_RESTRICTED_CATEGORIES ALCOHOL]],
 :corrections
 [{:type
   [CORRECTION_TYPE_UNSPECIFIED
    VENDOR_IDS_ADDED
    SSL_ATTRIBUTE_REMOVED
    FLASH_FREE_ATTRIBUTE_REMOVED
    FLASH_FREE_ATTRIBUTE_ADDED
    REQUIRED_ATTRIBUTE_ADDED
    REQUIRED_VENDOR_ADDED
    SSL_ATTRIBUTE_ADDED
    IN_BANNER_VIDEO_ATTRIBUTE_ADDED
    MRAID_ATTRIBUTE_ADDED
    FLASH_ATTRIBUTE_REMOVED
    VIDEO_IN_SNIPPET_ATTRIBUTE_ADDED],
   :details [string],
   :contexts
   [{:all [SIMPLE_CONTEXT],
     :location {:geoCriteriaIds [integer]},
     :platform {:platforms [[DESKTOP ANDROID IOS]]},
     :auctionType {:auctionTypes [[OPEN_AUCTION DIRECT_DEALS]]},
     :securityType {:securities [[INSECURE SSL]]},
     :appType {:appTypes [[NATIVE WEB]]}}]}],
 :detectedDomains [string],
 :detectedLanguages [string],
 :creativeId string,
 :native
 {:clickLinkUrl string,
  :headline string,
  :starRating number,
  :storeUrl string,
  :logo {:url string, :width integer, :height integer},
  :advertiserName string,
  :appIcon {:url string, :width integer, :height integer},
  :priceDisplayText string,
  :callToAction string,
  :clickTrackingUrl string,
  :videoUrl string,
  :image {:url string, :width integer, :height integer},
  :body string},
 :detectedAdvertiserIds [string],
 :vendorIds [integer],
 :agencyId string,
 :version integer,
 :attributes
 [[ATTRIBUTE_UNSPECIFIED
   IMAGE_RICH_MEDIA
   ADOBE_FLASH_FLV
   IS_TAGGED
   IS_COOKIE_TARGETED
   IS_USER_INTEREST_TARGETED
   EXPANDING_DIRECTION_NONE
   EXPANDING_DIRECTION_UP
   EXPANDING_DIRECTION_DOWN
   EXPANDING_DIRECTION_LEFT
   EXPANDING_DIRECTION_RIGHT
   EXPANDING_DIRECTION_UP_LEFT
   EXPANDING_DIRECTION_UP_RIGHT
   EXPANDING_DIRECTION_DOWN_LEFT
   EXPANDING_DIRECTION_DOWN_RIGHT
   CREATIVE_TYPE_HTML
   CREATIVE_TYPE_VAST_VIDEO
   EXPANDING_DIRECTION_UP_OR_DOWN
   EXPANDING_DIRECTION_LEFT_OR_RIGHT
   EXPANDING_DIRECTION_ANY_DIAGONAL
   EXPANDING_ACTION_ROLLOVER_TO_EXPAND
   INSTREAM_VAST_VIDEO_TYPE_VPAID_FLASH
   RICH_MEDIA_CAPABILITY_TYPE_MRAID
   RICH_MEDIA_CAPABILITY_TYPE_FLASH
   RICH_MEDIA_CAPABILITY_TYPE_HTML5
   SKIPPABLE_INSTREAM_VIDEO
   RICH_MEDIA_CAPABILITY_TYPE_SSL
   RICH_MEDIA_CAPABILITY_TYPE_NON_SSL
   RICH_MEDIA_CAPABILITY_TYPE_INTERSTITIAL
   NON_SKIPPABLE_INSTREAM_VIDEO
   NATIVE_ELIGIBILITY_ELIGIBLE
   NON_VPAID
   NATIVE_ELIGIBILITY_NOT_ELIGIBLE
   ANY_INTERSTITIAL
   NON_INTERSTITIAL
   IN_BANNER_VIDEO
   RENDERING_SIZELESS_ADX
   OMSDK_1_0
   RENDERING_PLAYABLE]],
 :accountId string,
 :clickThroughUrls [string],
 :html {:snippet string, :width integer, :height integer}}"
  [accountId creativeId Creative]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://adexchangebuyer.googleapis.com/v2beta1/accounts/{accountId}/creatives/{creativeId}",
     :uri-template-args {:accountId accountId, :creativeId creativeId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adexchange.buyer"],
     :body Creative}))

(defn accounts-creatives-get
  "Gets a creative.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/accounts.creatives/get

accountId <string> The account the creative belongs to.
creativeId <string> The ID of the creative to retrieve."
  [accountId creativeId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://adexchangebuyer.googleapis.com/v2beta1/accounts/{accountId}/creatives/{creativeId}",
     :uri-template-args {:accountId accountId, :creativeId creativeId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}))

(defn accounts-creatives-list
  "Lists creatives.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/accounts.creatives/list

accountId <string> The account to list the creatives from. Specify \"-\" to list all creatives the current user has access to.

optional:
pageSize <integer> Requested page size. The server may return fewer creatives than requested (due to timeout constraint) even if more are available through another call. If unspecified, server will pick an appropriate default. Acceptable values are 1 to 1000, inclusive.
query <string> An optional query string to filter creatives. If no filter is specified, all active creatives will be returned. Supported queries are: - accountId=*account_id_string* - creativeId=*creative_id_string* - dealsStatus: {approved, conditionally_approved, disapproved, not_checked} - openAuctionStatus: {approved, conditionally_approved, disapproved, not_checked} - attribute: {a numeric attribute from the list of attributes} - disapprovalReason: {a reason from DisapprovalReason} Example: 'accountId=12345 AND (dealsStatus:disapproved AND disapprovalReason:unacceptable_content) OR attribute:47'"
  ([accountId] (accounts-creatives-list accountId nil))
  ([accountId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/accounts/{accountId}/creatives",
       :uri-template-args {:accountId accountId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn accounts-creatives-watch
  "Watches a creative. Will result in push notifications being sent to the topic when the creative changes status.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/accounts.creatives/watch

accountId <string> The account of the creative to watch.
creativeId <string> The creative ID to watch for status changes. Specify \"-\" to watch all creatives under the above account. If both creative-level and account-level notifications are sent, only a single notification will be sent to the creative-level notification topic.
WatchCreativeRequest:
{:topic string}"
  [accountId creativeId WatchCreativeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://adexchangebuyer.googleapis.com/v2beta1/accounts/{accountId}/creatives/{creativeId}:watch",
     :uri-template-args {:accountId accountId, :creativeId creativeId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adexchange.buyer"],
     :body WatchCreativeRequest}))

(defn accounts-creatives-stopWatching
  "Stops watching a creative. Will stop push notifications being sent to the topics when the creative changes status.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/accounts.creatives/stopWatching

accountId <string> The account of the creative to stop notifications for.
creativeId <string> The creative ID of the creative to stop notifications for. Specify \"-\" to specify stopping account level notifications.
StopWatchingCreativeRequest:
object"
  [accountId creativeId StopWatchingCreativeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://adexchangebuyer.googleapis.com/v2beta1/accounts/{accountId}/creatives/{creativeId}:stopWatching",
     :uri-template-args {:accountId accountId, :creativeId creativeId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adexchange.buyer"],
     :body StopWatchingCreativeRequest}))

(defn accounts-creatives-dealAssociations-add
  "Associate an existing deal with a creative.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/accounts.creatives.dealAssociations/add

accountId <string> The account the creative belongs to.
creativeId <string> The ID of the creative associated with the deal.
AddDealAssociationRequest:
{:association {:accountId string, :creativeId string, :dealsId string}}"
  [accountId creativeId AddDealAssociationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://adexchangebuyer.googleapis.com/v2beta1/accounts/{accountId}/creatives/{creativeId}/dealAssociations:add",
     :uri-template-args {:accountId accountId, :creativeId creativeId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adexchange.buyer"],
     :body AddDealAssociationRequest}))

(defn accounts-creatives-dealAssociations-remove
  "Remove the association between a deal and a creative.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/accounts.creatives.dealAssociations/remove

accountId <string> The account the creative belongs to.
creativeId <string> The ID of the creative associated with the deal.
RemoveDealAssociationRequest:
{:association {:accountId string, :creativeId string, :dealsId string}}"
  [accountId creativeId RemoveDealAssociationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://adexchangebuyer.googleapis.com/v2beta1/accounts/{accountId}/creatives/{creativeId}/dealAssociations:remove",
     :uri-template-args {:accountId accountId, :creativeId creativeId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adexchange.buyer"],
     :body RemoveDealAssociationRequest}))

(defn accounts-creatives-dealAssociations-list
  "List all creative-deal associations.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/accounts.creatives.dealAssociations/list

accountId <string> The account to list the associations from. Specify \"-\" to list all creatives the current user has access to.
creativeId <string> The creative ID to list the associations from. Specify \"-\" to list all creatives under the above account.

optional:
pageSize <integer> Requested page size. Server may return fewer associations than requested. If unspecified, server will pick an appropriate default.
query <string> An optional query string to filter deal associations. If no filter is specified, all associations will be returned. Supported queries are: - accountId=*account_id_string* - creativeId=*creative_id_string* - dealsId=*deals_id_string* - dealsStatus:{approved, conditionally_approved, disapproved, not_checked} - openAuctionStatus:{approved, conditionally_approved, disapproved, not_checked} Example: 'dealsId=12345 AND dealsStatus:disapproved'"
  ([accountId creativeId]
    (accounts-creatives-dealAssociations-list
      accountId
      creativeId
      nil))
  ([accountId creativeId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/accounts/{accountId}/creatives/{creativeId}/dealAssociations",
       :uri-template-args
       {:accountId accountId, :creativeId creativeId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn accounts-clients-get
  "Gets a client buyer with a given client account ID.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/accounts.clients/get

accountId <string> Numerical account ID of the client's sponsor buyer. (required)
clientAccountId <string> Numerical account ID of the client buyer to retrieve. (required)"
  [accountId clientAccountId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://adexchangebuyer.googleapis.com/v2beta1/accounts/{accountId}/clients/{clientAccountId}",
     :uri-template-args
     {:accountId accountId, :clientAccountId clientAccountId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}))

(defn accounts-clients-list
  "Lists all the clients for the current sponsor buyer.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/accounts.clients/list

accountId <string> Unique numerical account ID of the sponsor buyer to list the clients for.

optional:
pageSize <integer> Requested page size. The server may return fewer clients than requested. If unspecified, the server will pick an appropriate default.
partnerClientId <string> Optional unique identifier (from the standpoint of an Ad Exchange sponsor buyer partner) of the client to return. If specified, at most one client will be returned in the response."
  ([accountId] (accounts-clients-list accountId nil))
  ([accountId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/accounts/{accountId}/clients",
       :uri-template-args {:accountId accountId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn accounts-clients-create
  "Creates a new client buyer.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/accounts.clients/create

accountId <string> Unique numerical account ID for the buyer of which the client buyer is a customer; the sponsor buyer to create a client for. (required)
Client:
{:role
 [CLIENT_ROLE_UNSPECIFIED
  CLIENT_DEAL_VIEWER
  CLIENT_DEAL_NEGOTIATOR
  CLIENT_DEAL_APPROVER],
 :entityName string,
 :partnerClientId string,
 :clientAccountId string,
 :visibleToSeller boolean,
 :status [CLIENT_STATUS_UNSPECIFIED DISABLED ACTIVE],
 :entityId string,
 :entityType
 [ENTITY_TYPE_UNSPECIFIED
  ADVERTISER
  BRAND
  AGENCY
  ENTITY_TYPE_UNCLASSIFIED],
 :clientName string}"
  [accountId Client]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://adexchangebuyer.googleapis.com/v2beta1/accounts/{accountId}/clients",
     :uri-template-args {:accountId accountId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adexchange.buyer"],
     :body Client}))

(defn accounts-clients-update
  "Updates an existing client buyer.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/accounts.clients/update

accountId <string> Unique numerical account ID for the buyer of which the client buyer is a customer; the sponsor buyer to update a client for. (required)
clientAccountId <string> Unique numerical account ID of the client to update. (required)
Client:
{:role
 [CLIENT_ROLE_UNSPECIFIED
  CLIENT_DEAL_VIEWER
  CLIENT_DEAL_NEGOTIATOR
  CLIENT_DEAL_APPROVER],
 :entityName string,
 :partnerClientId string,
 :clientAccountId string,
 :visibleToSeller boolean,
 :status [CLIENT_STATUS_UNSPECIFIED DISABLED ACTIVE],
 :entityId string,
 :entityType
 [ENTITY_TYPE_UNSPECIFIED
  ADVERTISER
  BRAND
  AGENCY
  ENTITY_TYPE_UNCLASSIFIED],
 :clientName string}"
  [accountId clientAccountId Client]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://adexchangebuyer.googleapis.com/v2beta1/accounts/{accountId}/clients/{clientAccountId}",
     :uri-template-args
     {:accountId accountId, :clientAccountId clientAccountId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adexchange.buyer"],
     :body Client}))

(defn accounts-clients-users-list
  "Lists all the known client users for a specified sponsor buyer account ID.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/accounts.clients.users/list

accountId <string> Numerical account ID of the sponsor buyer of the client to list users for. (required)
clientAccountId <string> The account ID of the client buyer to list users for. (required) You must specify either a string representation of a numerical account identifier or the `-` character to list all the client users for all the clients of a given sponsor buyer.

optional:
pageSize <integer> Requested page size. The server may return fewer clients than requested. If unspecified, the server will pick an appropriate default."
  ([accountId clientAccountId]
    (accounts-clients-users-list accountId clientAccountId nil))
  ([accountId clientAccountId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/accounts/{accountId}/clients/{clientAccountId}/users",
       :uri-template-args
       {:accountId accountId, :clientAccountId clientAccountId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn accounts-clients-users-update
  "Updates an existing client user. Only the user status can be changed on update.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/accounts.clients.users/update

accountId <string> Numerical account ID of the client's sponsor buyer. (required)
clientAccountId <string> Numerical account ID of the client buyer that the user to be retrieved is associated with. (required)
userId <string> Numerical identifier of the user to retrieve. (required)
ClientUser:
{:userId string,
 :clientAccountId string,
 :status [USER_STATUS_UNSPECIFIED PENDING ACTIVE DISABLED],
 :email string}"
  [accountId clientAccountId userId ClientUser]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://adexchangebuyer.googleapis.com/v2beta1/accounts/{accountId}/clients/{clientAccountId}/users/{userId}",
     :uri-template-args
     {:accountId accountId,
      :clientAccountId clientAccountId,
      :userId userId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adexchange.buyer"],
     :body ClientUser}))

(defn accounts-clients-users-get
  "Retrieves an existing client user.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/accounts.clients.users/get

accountId <string> Numerical account ID of the client's sponsor buyer. (required)
clientAccountId <string> Numerical account ID of the client buyer that the user to be retrieved is associated with. (required)
userId <string> Numerical identifier of the user to retrieve. (required)"
  [accountId clientAccountId userId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://adexchangebuyer.googleapis.com/v2beta1/accounts/{accountId}/clients/{clientAccountId}/users/{userId}",
     :uri-template-args
     {:accountId accountId,
      :clientAccountId clientAccountId,
      :userId userId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}))

(defn accounts-clients-invitations-create
  "Creates and sends out an email invitation to access an Ad Exchange client buyer account.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/accounts.clients.invitations/create

accountId <string> Numerical account ID of the client's sponsor buyer. (required)
clientAccountId <string> Numerical account ID of the client buyer that the user should be associated with. (required)
ClientUserInvitation:
{:invitationId string, :email string, :clientAccountId string}"
  [accountId clientAccountId ClientUserInvitation]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://adexchangebuyer.googleapis.com/v2beta1/accounts/{accountId}/clients/{clientAccountId}/invitations",
     :uri-template-args
     {:accountId accountId, :clientAccountId clientAccountId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adexchange.buyer"],
     :body ClientUserInvitation}))

(defn accounts-clients-invitations-get
  "Retrieves an existing client user invitation.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/accounts.clients.invitations/get

accountId <string> Numerical account ID of the client's sponsor buyer. (required)
clientAccountId <string> Numerical account ID of the client buyer that the user invitation to be retrieved is associated with. (required)
invitationId <string> Numerical identifier of the user invitation to retrieve. (required)"
  [accountId clientAccountId invitationId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://adexchangebuyer.googleapis.com/v2beta1/accounts/{accountId}/clients/{clientAccountId}/invitations/{invitationId}",
     :uri-template-args
     {:accountId accountId,
      :clientAccountId clientAccountId,
      :invitationId invitationId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}))

(defn accounts-clients-invitations-list
  "Lists all the client users invitations for a client with a given account ID.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/accounts.clients.invitations/list

accountId <string> Numerical account ID of the client's sponsor buyer. (required)
clientAccountId <string> Numerical account ID of the client buyer to list invitations for. (required) You must either specify a string representation of a numerical account identifier or the `-` character to list all the invitations for all the clients of a given sponsor buyer.

optional:
pageSize <integer> Requested page size. Server may return fewer clients than requested. If unspecified, server will pick an appropriate default."
  ([accountId clientAccountId]
    (accounts-clients-invitations-list accountId clientAccountId nil))
  ([accountId clientAccountId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/accounts/{accountId}/clients/{clientAccountId}/invitations",
       :uri-template-args
       {:accountId accountId, :clientAccountId clientAccountId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn accounts-proposals-get
  "Gets a proposal given its ID. The proposal is returned at its head revision.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/accounts.proposals/get

accountId <string> Account ID of the buyer.
proposalId <string> The unique ID of the proposal"
  [accountId proposalId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://adexchangebuyer.googleapis.com/v2beta1/accounts/{accountId}/proposals/{proposalId}",
     :uri-template-args {:accountId accountId, :proposalId proposalId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}))

(defn accounts-proposals-create
  "Create the given proposal. Each created proposal and any deals it contains are assigned a unique ID by the server.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/accounts.proposals/create

accountId <string> Account ID of the buyer.
Proposal:
{:isSetupComplete boolean,
 :displayName string,
 :billedBuyer {:accountId string},
 :proposalRevision string,
 :originatorRole [BUYER_SELLER_ROLE_UNSPECIFIED BUYER SELLER],
 :updateTime string,
 :proposalState
 [PROPOSAL_STATE_UNSPECIFIED
  PROPOSED
  BUYER_ACCEPTED
  SELLER_ACCEPTED
  CANCELED
  FINALIZED],
 :notes
 [{:proposalRevision string,
   :noteId string,
   :createTime string,
   :creatorRole [BUYER_SELLER_ROLE_UNSPECIFIED BUYER SELLER],
   :note string}],
 :termsAndConditions string,
 :lastUpdaterOrCommentorRole
 [BUYER_SELLER_ROLE_UNSPECIFIED BUYER SELLER],
 :deals
 [{:syndicationProduct
   [SYNDICATION_PRODUCT_UNSPECIFIED CONTENT MOBILE VIDEO GAMES],
   :description string,
   :createProductRevision string,
   :isSetupComplete boolean,
   :displayName string,
   :creativePreApprovalPolicy
   [CREATIVE_PRE_APPROVAL_POLICY_UNSPECIFIED
    SELLER_PRE_APPROVAL_REQUIRED
    SELLER_PRE_APPROVAL_NOT_REQUIRED],
   :createTime string,
   :targetingCriterion
   [{:key string,
     :exclusions
     [{:longValue string,
       :stringValue string,
       :creativeSizeValue
       {:creativeSizeType
        [CREATIVE_SIZE_TYPE_UNSPECIFIED
         REGULAR
         INTERSTITIAL
         VIDEO
         NATIVE],
        :size Size,
        :companionSizes [Size],
        :skippableAdType
        [SKIPPABLE_AD_TYPE_UNSPECIFIED
         GENERIC
         INSTREAM_SELECT
         NOT_SKIPPABLE],
        :nativeTemplate
        [UNKNOWN_NATIVE_TEMPLATE
         NATIVE_CONTENT_AD
         NATIVE_APP_INSTALL_AD
         NATIVE_VIDEO_CONTENT_AD
         NATIVE_VIDEO_APP_INSTALL_AD],
        :allowedFormats [[UNKNOWN AUDIO]]},
       :dayPartTargetingValue
       {:timeZoneType [TIME_ZONE_SOURCE_UNSPECIFIED PUBLISHER USER],
        :dayParts [DayPart]}}],
     :inclusions
     [{:longValue string,
       :stringValue string,
       :creativeSizeValue
       {:creativeSizeType
        [CREATIVE_SIZE_TYPE_UNSPECIFIED
         REGULAR
         INTERSTITIAL
         VIDEO
         NATIVE],
        :size Size,
        :companionSizes [Size],
        :skippableAdType
        [SKIPPABLE_AD_TYPE_UNSPECIFIED
         GENERIC
         INSTREAM_SELECT
         NOT_SKIPPABLE],
        :nativeTemplate
        [UNKNOWN_NATIVE_TEMPLATE
         NATIVE_CONTENT_AD
         NATIVE_APP_INSTALL_AD
         NATIVE_VIDEO_CONTENT_AD
         NATIVE_VIDEO_APP_INSTALL_AD],
        :allowedFormats [[UNKNOWN AUDIO]]},
       :dayPartTargetingValue
       {:timeZoneType [TIME_ZONE_SOURCE_UNSPECIFIED PUBLISHER USER],
        :dayParts [DayPart]}}]}],
   :dealServingMetadata
   {:dealPauseStatus
    {:hasBuyerPaused boolean,
     :hasSellerPaused boolean,
     :firstPausedBy [BUYER_SELLER_ROLE_UNSPECIFIED BUYER SELLER],
     :buyerPauseReason string,
     :sellerPauseReason string}},
   :updateTime string,
   :creativeSafeFrameCompatibility
   [CREATIVE_SAFE_FRAME_COMPATIBILITY_UNSPECIFIED
    COMPATIBLE
    INCOMPATIBLE],
   :programmaticCreativeSource
   [PROGRAMMATIC_CREATIVE_SOURCE_UNSPECIFIED ADVERTISER PUBLISHER],
   :webPropertyCode string,
   :createProductId string,
   :buyerPrivateData {:referenceId string},
   :externalDealId string,
   :creativeRestrictions
   {:creativeFormat [CREATIVE_FORMAT_UNSPECIFIED DISPLAY VIDEO],
    :creativeSpecifications
    [{:creativeSize
      {:width string,
       :height string,
       :sizeType
       [SIZE_TYPE_UNSPECIFIED PIXEL INTERSTITIAL NATIVE FLUID]},
      :creativeCompanionSizes
      [{:width string,
        :height string,
        :sizeType
        [SIZE_TYPE_UNSPECIFIED PIXEL INTERSTITIAL NATIVE FLUID]}]}],
    :skippableAdType
    [SKIPPABLE_AD_TYPE_UNSPECIFIED
     SKIPPABLE
     INSTREAM_SELECT
     NOT_SKIPPABLE]},
   :proposalId string,
   :deliveryControl
   {:deliveryRateType
    [DELIVERY_RATE_TYPE_UNSPECIFIED
     EVENLY
     FRONT_LOADED
     AS_FAST_AS_POSSIBLE],
    :frequencyCaps
    [{:maxImpressions integer,
      :numTimeUnits integer,
      :timeUnitType
      [TIME_UNIT_TYPE_UNSPECIFIED
       MINUTE
       HOUR
       DAY
       WEEK
       MONTH
       LIFETIME
       POD
       STREAM]}],
    :creativeBlockingLevel
    [CREATIVE_BLOCKING_LEVEL_UNSPECIFIED
     PUBLISHER_BLOCKING_RULES
     ADX_POLICY_BLOCKING_ONLY]},
   :availableStartTime string,
   :sellerContacts [{:email string, :name string}],
   :dealTerms
   {:description string,
    :brandingType [BRANDING_TYPE_UNSPECIFIED BRANDED SEMI_TRANSPARENT],
    :estimatedGrossSpend
    {:pricingType
     [PRICING_TYPE_UNSPECIFIED COST_PER_MILLE COST_PER_DAY],
     :amount {:currencyCode string, :units string, :nanos integer}},
    :estimatedImpressionsPerDay string,
    :sellerTimeZone string,
    :guaranteedFixedPriceTerms
    {:guaranteedLooks string,
     :guaranteedImpressions string,
     :fixedPrices
     [{:price Price, :buyer Buyer, :advertiserIds [string]}],
     :minimumDailyLooks string,
     :reservationType
     [RESERVATION_TYPE_UNSPECIFIED STANDARD SPONSORSHIP],
     :impressionCap string,
     :percentShareOfVoice string},
    :nonGuaranteedFixedPriceTerms
    {:fixedPrices
     [{:price Price, :buyer Buyer, :advertiserIds [string]}]},
    :nonGuaranteedAuctionTerms
    {:reservePricesPerBuyer
     [{:price Price, :buyer Buyer, :advertiserIds [string]}],
     :autoOptimizePrivateAuction boolean}},
   :dealId string,
   :targeting
   {:geoTargeting
    {:targetedCriteriaIds [string], :excludedCriteriaIds [string]},
    :inventorySizeTargeting
    {:targetedInventorySizes
     [{:width string,
       :height string,
       :sizeType
       [SIZE_TYPE_UNSPECIFIED PIXEL INTERSTITIAL NATIVE FLUID]}],
     :excludedInventorySizes
     [{:width string,
       :height string,
       :sizeType
       [SIZE_TYPE_UNSPECIFIED PIXEL INTERSTITIAL NATIVE FLUID]}]},
    :technologyTargeting
    {:deviceCategoryTargeting
     {:targetedCriteriaIds [string], :excludedCriteriaIds [string]},
     :deviceCapabilityTargeting
     {:targetedCriteriaIds [string], :excludedCriteriaIds [string]},
     :operatingSystemTargeting
     {:operatingSystemCriteria CriteriaTargeting,
      :operatingSystemVersionCriteria CriteriaTargeting}},
    :placementTargeting
    {:urlTargeting {:targetedUrls [string], :excludedUrls [string]},
     :mobileApplicationTargeting
     {:firstPartyTargeting FirstPartyMobileApplicationTargeting}},
    :videoTargeting
    {:targetedPositionTypes
     [[POSITION_TYPE_UNSPECIFIED PREROLL MIDROLL POSTROLL]],
     :excludedPositionTypes
     [[POSITION_TYPE_UNSPECIFIED PREROLL MIDROLL POSTROLL]]}},
   :availableEndTime string}],
 :buyerPrivateData {:referenceId string},
 :buyerContacts [{:email string, :name string}],
 :proposalId string,
 :buyer {:accountId string},
 :sellerContacts [{:email string, :name string}],
 :privateAuctionId string,
 :seller {:accountId string, :subAccountId string},
 :isRenegotiating boolean}"
  [accountId Proposal]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://adexchangebuyer.googleapis.com/v2beta1/accounts/{accountId}/proposals",
     :uri-template-args {:accountId accountId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adexchange.buyer"],
     :body Proposal}))

(defn accounts-proposals-update
  "Update the given proposal at the client known revision number. If the server revision has advanced since the passed-in `proposal.proposal_revision`, an `ABORTED` error message will be returned. Only the buyer-modifiable fields of the proposal will be updated. Note that the deals in the proposal will be updated to match the passed-in copy. If a passed-in deal does not have a `deal_id`, the server will assign a new unique ID and create the deal. If passed-in deal has a `deal_id`, it will be updated to match the passed-in copy. Any existing deals not present in the passed-in proposal will be deleted. It is an error to pass in a deal with a `deal_id` not present at head.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/accounts.proposals/update

accountId <string> Account ID of the buyer.
proposalId <string> The unique ID of the proposal.
Proposal:
{:isSetupComplete boolean,
 :displayName string,
 :billedBuyer {:accountId string},
 :proposalRevision string,
 :originatorRole [BUYER_SELLER_ROLE_UNSPECIFIED BUYER SELLER],
 :updateTime string,
 :proposalState
 [PROPOSAL_STATE_UNSPECIFIED
  PROPOSED
  BUYER_ACCEPTED
  SELLER_ACCEPTED
  CANCELED
  FINALIZED],
 :notes
 [{:proposalRevision string,
   :noteId string,
   :createTime string,
   :creatorRole [BUYER_SELLER_ROLE_UNSPECIFIED BUYER SELLER],
   :note string}],
 :termsAndConditions string,
 :lastUpdaterOrCommentorRole
 [BUYER_SELLER_ROLE_UNSPECIFIED BUYER SELLER],
 :deals
 [{:syndicationProduct
   [SYNDICATION_PRODUCT_UNSPECIFIED CONTENT MOBILE VIDEO GAMES],
   :description string,
   :createProductRevision string,
   :isSetupComplete boolean,
   :displayName string,
   :creativePreApprovalPolicy
   [CREATIVE_PRE_APPROVAL_POLICY_UNSPECIFIED
    SELLER_PRE_APPROVAL_REQUIRED
    SELLER_PRE_APPROVAL_NOT_REQUIRED],
   :createTime string,
   :targetingCriterion
   [{:key string,
     :exclusions
     [{:longValue string,
       :stringValue string,
       :creativeSizeValue
       {:creativeSizeType
        [CREATIVE_SIZE_TYPE_UNSPECIFIED
         REGULAR
         INTERSTITIAL
         VIDEO
         NATIVE],
        :size Size,
        :companionSizes [Size],
        :skippableAdType
        [SKIPPABLE_AD_TYPE_UNSPECIFIED
         GENERIC
         INSTREAM_SELECT
         NOT_SKIPPABLE],
        :nativeTemplate
        [UNKNOWN_NATIVE_TEMPLATE
         NATIVE_CONTENT_AD
         NATIVE_APP_INSTALL_AD
         NATIVE_VIDEO_CONTENT_AD
         NATIVE_VIDEO_APP_INSTALL_AD],
        :allowedFormats [[UNKNOWN AUDIO]]},
       :dayPartTargetingValue
       {:timeZoneType [TIME_ZONE_SOURCE_UNSPECIFIED PUBLISHER USER],
        :dayParts [DayPart]}}],
     :inclusions
     [{:longValue string,
       :stringValue string,
       :creativeSizeValue
       {:creativeSizeType
        [CREATIVE_SIZE_TYPE_UNSPECIFIED
         REGULAR
         INTERSTITIAL
         VIDEO
         NATIVE],
        :size Size,
        :companionSizes [Size],
        :skippableAdType
        [SKIPPABLE_AD_TYPE_UNSPECIFIED
         GENERIC
         INSTREAM_SELECT
         NOT_SKIPPABLE],
        :nativeTemplate
        [UNKNOWN_NATIVE_TEMPLATE
         NATIVE_CONTENT_AD
         NATIVE_APP_INSTALL_AD
         NATIVE_VIDEO_CONTENT_AD
         NATIVE_VIDEO_APP_INSTALL_AD],
        :allowedFormats [[UNKNOWN AUDIO]]},
       :dayPartTargetingValue
       {:timeZoneType [TIME_ZONE_SOURCE_UNSPECIFIED PUBLISHER USER],
        :dayParts [DayPart]}}]}],
   :dealServingMetadata
   {:dealPauseStatus
    {:hasBuyerPaused boolean,
     :hasSellerPaused boolean,
     :firstPausedBy [BUYER_SELLER_ROLE_UNSPECIFIED BUYER SELLER],
     :buyerPauseReason string,
     :sellerPauseReason string}},
   :updateTime string,
   :creativeSafeFrameCompatibility
   [CREATIVE_SAFE_FRAME_COMPATIBILITY_UNSPECIFIED
    COMPATIBLE
    INCOMPATIBLE],
   :programmaticCreativeSource
   [PROGRAMMATIC_CREATIVE_SOURCE_UNSPECIFIED ADVERTISER PUBLISHER],
   :webPropertyCode string,
   :createProductId string,
   :buyerPrivateData {:referenceId string},
   :externalDealId string,
   :creativeRestrictions
   {:creativeFormat [CREATIVE_FORMAT_UNSPECIFIED DISPLAY VIDEO],
    :creativeSpecifications
    [{:creativeSize
      {:width string,
       :height string,
       :sizeType
       [SIZE_TYPE_UNSPECIFIED PIXEL INTERSTITIAL NATIVE FLUID]},
      :creativeCompanionSizes
      [{:width string,
        :height string,
        :sizeType
        [SIZE_TYPE_UNSPECIFIED PIXEL INTERSTITIAL NATIVE FLUID]}]}],
    :skippableAdType
    [SKIPPABLE_AD_TYPE_UNSPECIFIED
     SKIPPABLE
     INSTREAM_SELECT
     NOT_SKIPPABLE]},
   :proposalId string,
   :deliveryControl
   {:deliveryRateType
    [DELIVERY_RATE_TYPE_UNSPECIFIED
     EVENLY
     FRONT_LOADED
     AS_FAST_AS_POSSIBLE],
    :frequencyCaps
    [{:maxImpressions integer,
      :numTimeUnits integer,
      :timeUnitType
      [TIME_UNIT_TYPE_UNSPECIFIED
       MINUTE
       HOUR
       DAY
       WEEK
       MONTH
       LIFETIME
       POD
       STREAM]}],
    :creativeBlockingLevel
    [CREATIVE_BLOCKING_LEVEL_UNSPECIFIED
     PUBLISHER_BLOCKING_RULES
     ADX_POLICY_BLOCKING_ONLY]},
   :availableStartTime string,
   :sellerContacts [{:email string, :name string}],
   :dealTerms
   {:description string,
    :brandingType [BRANDING_TYPE_UNSPECIFIED BRANDED SEMI_TRANSPARENT],
    :estimatedGrossSpend
    {:pricingType
     [PRICING_TYPE_UNSPECIFIED COST_PER_MILLE COST_PER_DAY],
     :amount {:currencyCode string, :units string, :nanos integer}},
    :estimatedImpressionsPerDay string,
    :sellerTimeZone string,
    :guaranteedFixedPriceTerms
    {:guaranteedLooks string,
     :guaranteedImpressions string,
     :fixedPrices
     [{:price Price, :buyer Buyer, :advertiserIds [string]}],
     :minimumDailyLooks string,
     :reservationType
     [RESERVATION_TYPE_UNSPECIFIED STANDARD SPONSORSHIP],
     :impressionCap string,
     :percentShareOfVoice string},
    :nonGuaranteedFixedPriceTerms
    {:fixedPrices
     [{:price Price, :buyer Buyer, :advertiserIds [string]}]},
    :nonGuaranteedAuctionTerms
    {:reservePricesPerBuyer
     [{:price Price, :buyer Buyer, :advertiserIds [string]}],
     :autoOptimizePrivateAuction boolean}},
   :dealId string,
   :targeting
   {:geoTargeting
    {:targetedCriteriaIds [string], :excludedCriteriaIds [string]},
    :inventorySizeTargeting
    {:targetedInventorySizes
     [{:width string,
       :height string,
       :sizeType
       [SIZE_TYPE_UNSPECIFIED PIXEL INTERSTITIAL NATIVE FLUID]}],
     :excludedInventorySizes
     [{:width string,
       :height string,
       :sizeType
       [SIZE_TYPE_UNSPECIFIED PIXEL INTERSTITIAL NATIVE FLUID]}]},
    :technologyTargeting
    {:deviceCategoryTargeting
     {:targetedCriteriaIds [string], :excludedCriteriaIds [string]},
     :deviceCapabilityTargeting
     {:targetedCriteriaIds [string], :excludedCriteriaIds [string]},
     :operatingSystemTargeting
     {:operatingSystemCriteria CriteriaTargeting,
      :operatingSystemVersionCriteria CriteriaTargeting}},
    :placementTargeting
    {:urlTargeting {:targetedUrls [string], :excludedUrls [string]},
     :mobileApplicationTargeting
     {:firstPartyTargeting FirstPartyMobileApplicationTargeting}},
    :videoTargeting
    {:targetedPositionTypes
     [[POSITION_TYPE_UNSPECIFIED PREROLL MIDROLL POSTROLL]],
     :excludedPositionTypes
     [[POSITION_TYPE_UNSPECIFIED PREROLL MIDROLL POSTROLL]]}},
   :availableEndTime string}],
 :buyerPrivateData {:referenceId string},
 :buyerContacts [{:email string, :name string}],
 :proposalId string,
 :buyer {:accountId string},
 :sellerContacts [{:email string, :name string}],
 :privateAuctionId string,
 :seller {:accountId string, :subAccountId string},
 :isRenegotiating boolean}"
  [accountId proposalId Proposal]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://adexchangebuyer.googleapis.com/v2beta1/accounts/{accountId}/proposals/{proposalId}",
     :uri-template-args {:accountId accountId, :proposalId proposalId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adexchange.buyer"],
     :body Proposal}))

(defn accounts-proposals-completeSetup
  "You can opt-in to manually update proposals to indicate that setup is complete. By default, proposal setup is automatically completed after their deals are finalized. Contact your Technical Account Manager to opt in. Buyers can call this method when the proposal has been finalized, and all the required creatives have been uploaded using the Creatives API. This call updates the `is_setup_completed` field on the deals in the proposal, and notifies the seller. The server then advances the revision number of the most recent proposal. To mark an individual deal as ready to serve, call `buyers.finalizedDeals.setReadyToServe` in the Marketplace API.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/accounts.proposals/completeSetup

accountId <string> Account ID of the buyer.
proposalId <string> The ID of the proposal to mark as setup completed.
CompleteSetupRequest:
object"
  [accountId proposalId CompleteSetupRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://adexchangebuyer.googleapis.com/v2beta1/accounts/{accountId}/proposals/{proposalId}:completeSetup",
     :uri-template-args {:accountId accountId, :proposalId proposalId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adexchange.buyer"],
     :body CompleteSetupRequest}))

(defn accounts-proposals-list
  "List proposals. A filter expression (PQL query) may be specified to filter the results. To retrieve all finalized proposals, regardless if a proposal is being renegotiated, see the FinalizedProposals resource. Note that Bidder/ChildSeat relationships differ from the usual behavior. A Bidder account can only see its child seats' proposals by specifying the ChildSeat's accountId in the request path.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/accounts.proposals/list

accountId <string> Account ID of the buyer.

optional:
filter <string> An optional PQL filter query used to query for proposals. Nested repeated fields, such as proposal.deals.targetingCriterion, cannot be filtered.
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will pick an appropriate default.
filterSyntax <string> Syntax the filter is written in. Current implementation defaults to PQL but in the future it will be LIST_FILTER."
  ([accountId] (accounts-proposals-list accountId nil))
  ([accountId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/accounts/{accountId}/proposals",
       :uri-template-args {:accountId accountId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn accounts-proposals-addNote
  "Create a new note and attach it to the proposal. The note is assigned a unique ID by the server. The proposal revision number will not increase when associated with a new note.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/accounts.proposals/addNote

accountId <string> Account ID of the buyer.
proposalId <string> The ID of the proposal to attach the note to.
AddNoteRequest:
{:note
 {:proposalRevision string,
  :noteId string,
  :createTime string,
  :creatorRole [BUYER_SELLER_ROLE_UNSPECIFIED BUYER SELLER],
  :note string}}"
  [accountId proposalId AddNoteRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://adexchangebuyer.googleapis.com/v2beta1/accounts/{accountId}/proposals/{proposalId}:addNote",
     :uri-template-args {:accountId accountId, :proposalId proposalId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adexchange.buyer"],
     :body AddNoteRequest}))

(defn accounts-proposals-cancelNegotiation
  "Cancel an ongoing negotiation on a proposal. This does not cancel or end serving for the deals if the proposal has been finalized, but only cancels a negotiation unilaterally.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/accounts.proposals/cancelNegotiation

accountId <string> Account ID of the buyer.
proposalId <string> The ID of the proposal to cancel negotiation for.
CancelNegotiationRequest:
object"
  [accountId proposalId CancelNegotiationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://adexchangebuyer.googleapis.com/v2beta1/accounts/{accountId}/proposals/{proposalId}:cancelNegotiation",
     :uri-template-args {:accountId accountId, :proposalId proposalId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adexchange.buyer"],
     :body CancelNegotiationRequest}))

(defn accounts-proposals-pause
  "Update the given proposal to pause serving. This method will set the `DealServingMetadata.DealPauseStatus.has_buyer_paused` bit to true for all deals in the proposal. It is a no-op to pause an already-paused proposal. It is an error to call PauseProposal for a proposal that is not finalized or renegotiating.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/accounts.proposals/pause

accountId <string> Account ID of the buyer.
proposalId <string> The ID of the proposal to pause.
PauseProposalRequest:
{:reason string}"
  [accountId proposalId PauseProposalRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://adexchangebuyer.googleapis.com/v2beta1/accounts/{accountId}/proposals/{proposalId}:pause",
     :uri-template-args {:accountId accountId, :proposalId proposalId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adexchange.buyer"],
     :body PauseProposalRequest}))

(defn accounts-proposals-resume
  "Update the given proposal to resume serving. This method will set the `DealServingMetadata.DealPauseStatus.has_buyer_paused` bit to false for all deals in the proposal. Note that if the `has_seller_paused` bit is also set, serving will not resume until the seller also resumes. It is a no-op to resume an already-running proposal. It is an error to call ResumeProposal for a proposal that is not finalized or renegotiating.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/accounts.proposals/resume

accountId <string> Account ID of the buyer.
proposalId <string> The ID of the proposal to resume.
ResumeProposalRequest:
object"
  [accountId proposalId ResumeProposalRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://adexchangebuyer.googleapis.com/v2beta1/accounts/{accountId}/proposals/{proposalId}:resume",
     :uri-template-args {:accountId accountId, :proposalId proposalId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adexchange.buyer"],
     :body ResumeProposalRequest}))

(defn accounts-proposals-accept
  "Mark the proposal as accepted at the given revision number. If the number does not match the server's revision number an `ABORTED` error message will be returned. This call updates the proposal_state from `PROPOSED` to `BUYER_ACCEPTED`, or from `SELLER_ACCEPTED` to `FINALIZED`. Upon calling this endpoint, the buyer implicitly agrees to the terms and conditions optionally set within the proposal by the publisher.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/accounts.proposals/accept

accountId <string> Account ID of the buyer.
proposalId <string> The ID of the proposal to accept.
AcceptProposalRequest:
{:proposalRevision string}"
  [accountId proposalId AcceptProposalRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://adexchangebuyer.googleapis.com/v2beta1/accounts/{accountId}/proposals/{proposalId}:accept",
     :uri-template-args {:accountId accountId, :proposalId proposalId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adexchange.buyer"],
     :body AcceptProposalRequest}))

(defn accounts-finalizedProposals-list
  "List finalized proposals, regardless if a proposal is being renegotiated. A filter expression (PQL query) may be specified to filter the results. The notes will not be returned.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/accounts.finalizedProposals/list

accountId <string> Account ID of the buyer.

optional:
filter <string> An optional PQL filter query used to query for proposals. Nested repeated fields, such as proposal.deals.targetingCriterion, cannot be filtered.
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will pick an appropriate default.
filterSyntax <string> Syntax the filter is written in. Current implementation defaults to PQL but in the future it will be LIST_FILTER."
  ([accountId] (accounts-finalizedProposals-list accountId nil))
  ([accountId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/accounts/{accountId}/finalizedProposals",
       :uri-template-args {:accountId accountId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn accounts-finalizedProposals-pause
  "Update given deals to pause serving. This method will set the `DealServingMetadata.DealPauseStatus.has_buyer_paused` bit to true for all listed deals in the request. Currently, this method only applies to PG and PD deals. For PA deals, call accounts.proposals.pause endpoint. It is a no-op to pause already-paused deals. It is an error to call PauseProposalDeals for deals which are not part of the proposal of proposal_id or which are not finalized or renegotiating.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/accounts.finalizedProposals/pause

accountId <string> Account ID of the buyer.
proposalId <string> The proposal_id of the proposal containing the deals.
PauseProposalDealsRequest:
{:externalDealIds [string], :reason string}"
  [accountId proposalId PauseProposalDealsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://adexchangebuyer.googleapis.com/v2beta1/accounts/{accountId}/finalizedProposals/{proposalId}:pause",
     :uri-template-args {:accountId accountId, :proposalId proposalId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adexchange.buyer"],
     :body PauseProposalDealsRequest}))

(defn accounts-finalizedProposals-resume
  "Update given deals to resume serving. This method will set the `DealServingMetadata.DealPauseStatus.has_buyer_paused` bit to false for all listed deals in the request. Currently, this method only applies to PG and PD deals. For PA deals, call accounts.proposals.resume endpoint. It is a no-op to resume running deals or deals paused by the other party. It is an error to call ResumeProposalDeals for deals which are not part of the proposal of proposal_id or which are not finalized or renegotiating.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/accounts.finalizedProposals/resume

accountId <string> Account ID of the buyer.
proposalId <string> The proposal_id of the proposal containing the deals.
ResumeProposalDealsRequest:
{:externalDealIds [string]}"
  [accountId proposalId ResumeProposalDealsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://adexchangebuyer.googleapis.com/v2beta1/accounts/{accountId}/finalizedProposals/{proposalId}:resume",
     :uri-template-args {:accountId accountId, :proposalId proposalId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adexchange.buyer"],
     :body ResumeProposalDealsRequest}))

(defn accounts-products-get
  "Gets the requested product by ID.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/accounts.products/get

accountId <string> Account ID of the buyer.
productId <string> The ID for the product to get the head revision for."
  [accountId productId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://adexchangebuyer.googleapis.com/v2beta1/accounts/{accountId}/products/{productId}",
     :uri-template-args {:accountId accountId, :productId productId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}))

(defn accounts-products-list
  "List all products visible to the buyer (optionally filtered by the specified PQL query).
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/accounts.products/list

accountId <string> Account ID of the buyer.

optional:
filter <string> An optional PQL query used to query for products. See https://developers.google.com/ad-manager/docs/pqlreference for documentation about PQL and examples. Nested repeated fields, such as product.targetingCriterion.inclusions, cannot be filtered.
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will pick an appropriate default."
  ([accountId] (accounts-products-list accountId nil))
  ([accountId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/accounts/{accountId}/products",
       :uri-template-args {:accountId accountId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn accounts-publisherProfiles-get
  "Gets the requested publisher profile by id.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/accounts.publisherProfiles/get

accountId <string> Account ID of the buyer.
publisherProfileId <string> The id for the publisher profile to get."
  [accountId publisherProfileId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://adexchangebuyer.googleapis.com/v2beta1/accounts/{accountId}/publisherProfiles/{publisherProfileId}",
     :uri-template-args
     {:accountId accountId, :publisherProfileId publisherProfileId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}))

(defn accounts-publisherProfiles-list
  "List all publisher profiles visible to the buyer
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/accounts.publisherProfiles/list

accountId <string> Account ID of the buyer.

optional:
pageSize <integer> Specify the number of results to include per page."
  ([accountId] (accounts-publisherProfiles-list accountId nil))
  ([accountId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/accounts/{accountId}/publisherProfiles",
       :uri-template-args {:accountId accountId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn bidders-accounts-filterSets-create
  "Creates the specified filter set for the account with the given account ID.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/bidders.accounts.filterSets/create

ownerName <string> Name of the owner (bidder or account) of the filter set to be created. For example: - For a bidder-level filter set for bidder 123: `bidders/123` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456`
FilterSet:
{:formats
 [[FORMAT_UNSPECIFIED
   NATIVE_DISPLAY
   NATIVE_VIDEO
   NON_NATIVE_DISPLAY
   NON_NATIVE_VIDEO]],
 :format
 [FORMAT_UNSPECIFIED
  NATIVE_DISPLAY
  NATIVE_VIDEO
  NON_NATIVE_DISPLAY
  NON_NATIVE_VIDEO],
 :breakdownDimensions
 [[BREAKDOWN_DIMENSION_UNSPECIFIED PUBLISHER_IDENTIFIER]],
 :name string,
 :realtimeTimeRange {:startTimestamp string},
 :publisherIdentifiers [string],
 :timeSeriesGranularity
 [TIME_SERIES_GRANULARITY_UNSPECIFIED HOURLY DAILY],
 :creativeId string,
 :environment [ENVIRONMENT_UNSPECIFIED WEB APP],
 :absoluteDateRange
 {:startDate {:year integer, :month integer, :day integer},
  :endDate {:year integer, :month integer, :day integer}},
 :dealId string,
 :relativeDateRange {:offsetDays integer, :durationDays integer},
 :platforms [[PLATFORM_UNSPECIFIED DESKTOP TABLET MOBILE]],
 :sellerNetworkIds [integer]}

optional:
isTransient <boolean> Whether the filter set is transient, or should be persisted indefinitely. By default, filter sets are not transient. If transient, it will be available for at least 1 hour after creation."
  ([ownerName FilterSet]
    (bidders-accounts-filterSets-create ownerName FilterSet nil))
  ([ownerName FilterSet optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/{+ownerName}/filterSets",
       :uri-template-args {:ownerName ownerName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"],
       :body FilterSet})))

(defn bidders-accounts-filterSets-get
  "Retrieves the requested filter set for the account with the given account ID.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/bidders.accounts.filterSets/get

name <string> Full name of the resource being requested. For example: - For a bidder-level filter set for bidder 123: `bidders/123/filterSets/abc` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123/filterSets/abc` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456/filterSets/abc`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://adexchangebuyer.googleapis.com/v2beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}))

(defn bidders-accounts-filterSets-list
  "Lists all filter sets for the account with the given account ID.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/bidders.accounts.filterSets/list

ownerName <string> Name of the owner (bidder or account) of the filter sets to be listed. For example: - For a bidder-level filter set for bidder 123: `bidders/123` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456`

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will pick an appropriate default."
  ([ownerName] (bidders-accounts-filterSets-list ownerName nil))
  ([ownerName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/{+ownerName}/filterSets",
       :uri-template-args {:ownerName ownerName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn bidders-accounts-filterSets-delete
  "Deletes the requested filter set from the account with the given account ID.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/bidders.accounts.filterSets/delete

name <string> Full name of the resource to delete. For example: - For a bidder-level filter set for bidder 123: `bidders/123/filterSets/abc` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123/filterSets/abc` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456/filterSets/abc`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://adexchangebuyer.googleapis.com/v2beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}))

(defn bidders-accounts-filterSets-impressionMetrics-list
  "Lists all metrics that are measured in terms of number of impressions.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/bidders.accounts.filterSets.impressionMetrics/list

filterSetName <string> Name of the filter set that should be applied to the requested metrics. For example: - For a bidder-level filter set for bidder 123: `bidders/123/filterSets/abc` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123/filterSets/abc` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456/filterSets/abc`

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will pick an appropriate default."
  ([filterSetName]
    (bidders-accounts-filterSets-impressionMetrics-list
      filterSetName
      nil))
  ([filterSetName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/{+filterSetName}/impressionMetrics",
       :uri-template-args {:filterSetName filterSetName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn bidders-accounts-filterSets-bidMetrics-list
  "Lists all metrics that are measured in terms of number of bids.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/bidders.accounts.filterSets.bidMetrics/list

filterSetName <string> Name of the filter set that should be applied to the requested metrics. For example: - For a bidder-level filter set for bidder 123: `bidders/123/filterSets/abc` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123/filterSets/abc` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456/filterSets/abc`

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will pick an appropriate default."
  ([filterSetName]
    (bidders-accounts-filterSets-bidMetrics-list filterSetName nil))
  ([filterSetName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/{+filterSetName}/bidMetrics",
       :uri-template-args {:filterSetName filterSetName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn bidders-accounts-filterSets-filteredBidRequests-list
  "List all reasons that caused a bid request not to be sent for an impression, with the number of bid requests not sent for each reason.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/bidders.accounts.filterSets.filteredBidRequests/list

filterSetName <string> Name of the filter set that should be applied to the requested metrics. For example: - For a bidder-level filter set for bidder 123: `bidders/123/filterSets/abc` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123/filterSets/abc` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456/filterSets/abc`

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will pick an appropriate default."
  ([filterSetName]
    (bidders-accounts-filterSets-filteredBidRequests-list
      filterSetName
      nil))
  ([filterSetName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/{+filterSetName}/filteredBidRequests",
       :uri-template-args {:filterSetName filterSetName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn bidders-accounts-filterSets-bidResponseErrors-list
  "List all errors that occurred in bid responses, with the number of bid responses affected for each reason.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/bidders.accounts.filterSets.bidResponseErrors/list

filterSetName <string> Name of the filter set that should be applied to the requested metrics. For example: - For a bidder-level filter set for bidder 123: `bidders/123/filterSets/abc` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123/filterSets/abc` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456/filterSets/abc`

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will pick an appropriate default."
  ([filterSetName]
    (bidders-accounts-filterSets-bidResponseErrors-list
      filterSetName
      nil))
  ([filterSetName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/{+filterSetName}/bidResponseErrors",
       :uri-template-args {:filterSetName filterSetName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn bidders-accounts-filterSets-bidResponsesWithoutBids-list
  "List all reasons for which bid responses were considered to have no applicable bids, with the number of bid responses affected for each reason.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/bidders.accounts.filterSets.bidResponsesWithoutBids/list

filterSetName <string> Name of the filter set that should be applied to the requested metrics. For example: - For a bidder-level filter set for bidder 123: `bidders/123/filterSets/abc` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123/filterSets/abc` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456/filterSets/abc`

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will pick an appropriate default."
  ([filterSetName]
    (bidders-accounts-filterSets-bidResponsesWithoutBids-list
      filterSetName
      nil))
  ([filterSetName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/{+filterSetName}/bidResponsesWithoutBids",
       :uri-template-args {:filterSetName filterSetName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn bidders-accounts-filterSets-filteredBids-list
  "List all reasons for which bids were filtered, with the number of bids filtered for each reason.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/bidders.accounts.filterSets.filteredBids/list

filterSetName <string> Name of the filter set that should be applied to the requested metrics. For example: - For a bidder-level filter set for bidder 123: `bidders/123/filterSets/abc` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123/filterSets/abc` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456/filterSets/abc`

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will pick an appropriate default."
  ([filterSetName]
    (bidders-accounts-filterSets-filteredBids-list filterSetName nil))
  ([filterSetName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/{+filterSetName}/filteredBids",
       :uri-template-args {:filterSetName filterSetName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn bidders-accounts-filterSets-filteredBids-details-list
  "List all details associated with a specific reason for which bids were filtered, with the number of bids filtered for each detail.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/bidders.accounts.filterSets.filteredBids.details/list

filterSetName <string> Name of the filter set that should be applied to the requested metrics. For example: - For a bidder-level filter set for bidder 123: `bidders/123/filterSets/abc` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123/filterSets/abc` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456/filterSets/abc`
creativeStatusId <integer> The ID of the creative status for which to retrieve a breakdown by detail. See [creative-status-codes](https://developers.google.com/authorized-buyers/rtb/downloads/creative-status-codes). Details are only available for statuses 10, 14, 15, 17, 18, 19, 86, and 87.

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will pick an appropriate default."
  ([filterSetName creativeStatusId]
    (bidders-accounts-filterSets-filteredBids-details-list
      filterSetName
      creativeStatusId
      nil))
  ([filterSetName creativeStatusId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/{+filterSetName}/filteredBids/{creativeStatusId}/details",
       :uri-template-args
       {:filterSetName filterSetName,
        :creativeStatusId creativeStatusId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn bidders-accounts-filterSets-filteredBids-creatives-list
  "List all creatives associated with a specific reason for which bids were filtered, with the number of bids filtered for each creative.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/bidders.accounts.filterSets.filteredBids.creatives/list

filterSetName <string> Name of the filter set that should be applied to the requested metrics. For example: - For a bidder-level filter set for bidder 123: `bidders/123/filterSets/abc` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123/filterSets/abc` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456/filterSets/abc`
creativeStatusId <integer> The ID of the creative status for which to retrieve a breakdown by creative. See [creative-status-codes](https://developers.google.com/authorized-buyers/rtb/downloads/creative-status-codes).

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will pick an appropriate default."
  ([filterSetName creativeStatusId]
    (bidders-accounts-filterSets-filteredBids-creatives-list
      filterSetName
      creativeStatusId
      nil))
  ([filterSetName creativeStatusId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/{+filterSetName}/filteredBids/{creativeStatusId}/creatives",
       :uri-template-args
       {:filterSetName filterSetName,
        :creativeStatusId creativeStatusId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn bidders-accounts-filterSets-losingBids-list
  "List all reasons for which bids lost in the auction, with the number of bids that lost for each reason.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/bidders.accounts.filterSets.losingBids/list

filterSetName <string> Name of the filter set that should be applied to the requested metrics. For example: - For a bidder-level filter set for bidder 123: `bidders/123/filterSets/abc` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123/filterSets/abc` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456/filterSets/abc`

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will pick an appropriate default."
  ([filterSetName]
    (bidders-accounts-filterSets-losingBids-list filterSetName nil))
  ([filterSetName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/{+filterSetName}/losingBids",
       :uri-template-args {:filterSetName filterSetName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn bidders-accounts-filterSets-nonBillableWinningBids-list
  "List all reasons for which winning bids were not billable, with the number of bids not billed for each reason.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/bidders.accounts.filterSets.nonBillableWinningBids/list

filterSetName <string> Name of the filter set that should be applied to the requested metrics. For example: - For a bidder-level filter set for bidder 123: `bidders/123/filterSets/abc` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123/filterSets/abc` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456/filterSets/abc`

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will pick an appropriate default."
  ([filterSetName]
    (bidders-accounts-filterSets-nonBillableWinningBids-list
      filterSetName
      nil))
  ([filterSetName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/{+filterSetName}/nonBillableWinningBids",
       :uri-template-args {:filterSetName filterSetName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn bidders-filterSets-create
  "Creates the specified filter set for the account with the given account ID.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/bidders.filterSets/create

ownerName <string> Name of the owner (bidder or account) of the filter set to be created. For example: - For a bidder-level filter set for bidder 123: `bidders/123` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456`
FilterSet:
{:formats
 [[FORMAT_UNSPECIFIED
   NATIVE_DISPLAY
   NATIVE_VIDEO
   NON_NATIVE_DISPLAY
   NON_NATIVE_VIDEO]],
 :format
 [FORMAT_UNSPECIFIED
  NATIVE_DISPLAY
  NATIVE_VIDEO
  NON_NATIVE_DISPLAY
  NON_NATIVE_VIDEO],
 :breakdownDimensions
 [[BREAKDOWN_DIMENSION_UNSPECIFIED PUBLISHER_IDENTIFIER]],
 :name string,
 :realtimeTimeRange {:startTimestamp string},
 :publisherIdentifiers [string],
 :timeSeriesGranularity
 [TIME_SERIES_GRANULARITY_UNSPECIFIED HOURLY DAILY],
 :creativeId string,
 :environment [ENVIRONMENT_UNSPECIFIED WEB APP],
 :absoluteDateRange
 {:startDate {:year integer, :month integer, :day integer},
  :endDate {:year integer, :month integer, :day integer}},
 :dealId string,
 :relativeDateRange {:offsetDays integer, :durationDays integer},
 :platforms [[PLATFORM_UNSPECIFIED DESKTOP TABLET MOBILE]],
 :sellerNetworkIds [integer]}

optional:
isTransient <boolean> Whether the filter set is transient, or should be persisted indefinitely. By default, filter sets are not transient. If transient, it will be available for at least 1 hour after creation."
  ([ownerName FilterSet]
    (bidders-filterSets-create ownerName FilterSet nil))
  ([ownerName FilterSet optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/{+ownerName}/filterSets",
       :uri-template-args {:ownerName ownerName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"],
       :body FilterSet})))

(defn bidders-filterSets-get
  "Retrieves the requested filter set for the account with the given account ID.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/bidders.filterSets/get

name <string> Full name of the resource being requested. For example: - For a bidder-level filter set for bidder 123: `bidders/123/filterSets/abc` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123/filterSets/abc` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456/filterSets/abc`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://adexchangebuyer.googleapis.com/v2beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}))

(defn bidders-filterSets-list
  "Lists all filter sets for the account with the given account ID.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/bidders.filterSets/list

ownerName <string> Name of the owner (bidder or account) of the filter sets to be listed. For example: - For a bidder-level filter set for bidder 123: `bidders/123` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456`

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will pick an appropriate default."
  ([ownerName] (bidders-filterSets-list ownerName nil))
  ([ownerName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/{+ownerName}/filterSets",
       :uri-template-args {:ownerName ownerName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn bidders-filterSets-delete
  "Deletes the requested filter set from the account with the given account ID.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/bidders.filterSets/delete

name <string> Full name of the resource to delete. For example: - For a bidder-level filter set for bidder 123: `bidders/123/filterSets/abc` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123/filterSets/abc` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456/filterSets/abc`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://adexchangebuyer.googleapis.com/v2beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}))

(defn bidders-filterSets-impressionMetrics-list
  "Lists all metrics that are measured in terms of number of impressions.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/bidders.filterSets.impressionMetrics/list

filterSetName <string> Name of the filter set that should be applied to the requested metrics. For example: - For a bidder-level filter set for bidder 123: `bidders/123/filterSets/abc` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123/filterSets/abc` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456/filterSets/abc`

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will pick an appropriate default."
  ([filterSetName]
    (bidders-filterSets-impressionMetrics-list filterSetName nil))
  ([filterSetName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/{+filterSetName}/impressionMetrics",
       :uri-template-args {:filterSetName filterSetName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn bidders-filterSets-bidMetrics-list
  "Lists all metrics that are measured in terms of number of bids.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/bidders.filterSets.bidMetrics/list

filterSetName <string> Name of the filter set that should be applied to the requested metrics. For example: - For a bidder-level filter set for bidder 123: `bidders/123/filterSets/abc` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123/filterSets/abc` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456/filterSets/abc`

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will pick an appropriate default."
  ([filterSetName]
    (bidders-filterSets-bidMetrics-list filterSetName nil))
  ([filterSetName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/{+filterSetName}/bidMetrics",
       :uri-template-args {:filterSetName filterSetName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn bidders-filterSets-filteredBidRequests-list
  "List all reasons that caused a bid request not to be sent for an impression, with the number of bid requests not sent for each reason.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/bidders.filterSets.filteredBidRequests/list

filterSetName <string> Name of the filter set that should be applied to the requested metrics. For example: - For a bidder-level filter set for bidder 123: `bidders/123/filterSets/abc` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123/filterSets/abc` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456/filterSets/abc`

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will pick an appropriate default."
  ([filterSetName]
    (bidders-filterSets-filteredBidRequests-list filterSetName nil))
  ([filterSetName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/{+filterSetName}/filteredBidRequests",
       :uri-template-args {:filterSetName filterSetName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn bidders-filterSets-bidResponseErrors-list
  "List all errors that occurred in bid responses, with the number of bid responses affected for each reason.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/bidders.filterSets.bidResponseErrors/list

filterSetName <string> Name of the filter set that should be applied to the requested metrics. For example: - For a bidder-level filter set for bidder 123: `bidders/123/filterSets/abc` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123/filterSets/abc` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456/filterSets/abc`

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will pick an appropriate default."
  ([filterSetName]
    (bidders-filterSets-bidResponseErrors-list filterSetName nil))
  ([filterSetName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/{+filterSetName}/bidResponseErrors",
       :uri-template-args {:filterSetName filterSetName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn bidders-filterSets-bidResponsesWithoutBids-list
  "List all reasons for which bid responses were considered to have no applicable bids, with the number of bid responses affected for each reason.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/bidders.filterSets.bidResponsesWithoutBids/list

filterSetName <string> Name of the filter set that should be applied to the requested metrics. For example: - For a bidder-level filter set for bidder 123: `bidders/123/filterSets/abc` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123/filterSets/abc` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456/filterSets/abc`

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will pick an appropriate default."
  ([filterSetName]
    (bidders-filterSets-bidResponsesWithoutBids-list
      filterSetName
      nil))
  ([filterSetName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/{+filterSetName}/bidResponsesWithoutBids",
       :uri-template-args {:filterSetName filterSetName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn bidders-filterSets-filteredBids-list
  "List all reasons for which bids were filtered, with the number of bids filtered for each reason.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/bidders.filterSets.filteredBids/list

filterSetName <string> Name of the filter set that should be applied to the requested metrics. For example: - For a bidder-level filter set for bidder 123: `bidders/123/filterSets/abc` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123/filterSets/abc` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456/filterSets/abc`

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will pick an appropriate default."
  ([filterSetName]
    (bidders-filterSets-filteredBids-list filterSetName nil))
  ([filterSetName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/{+filterSetName}/filteredBids",
       :uri-template-args {:filterSetName filterSetName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn bidders-filterSets-filteredBids-details-list
  "List all details associated with a specific reason for which bids were filtered, with the number of bids filtered for each detail.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/bidders.filterSets.filteredBids.details/list

filterSetName <string> Name of the filter set that should be applied to the requested metrics. For example: - For a bidder-level filter set for bidder 123: `bidders/123/filterSets/abc` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123/filterSets/abc` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456/filterSets/abc`
creativeStatusId <integer> The ID of the creative status for which to retrieve a breakdown by detail. See [creative-status-codes](https://developers.google.com/authorized-buyers/rtb/downloads/creative-status-codes). Details are only available for statuses 10, 14, 15, 17, 18, 19, 86, and 87.

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will pick an appropriate default."
  ([filterSetName creativeStatusId]
    (bidders-filterSets-filteredBids-details-list
      filterSetName
      creativeStatusId
      nil))
  ([filterSetName creativeStatusId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/{+filterSetName}/filteredBids/{creativeStatusId}/details",
       :uri-template-args
       {:filterSetName filterSetName,
        :creativeStatusId creativeStatusId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn bidders-filterSets-filteredBids-creatives-list
  "List all creatives associated with a specific reason for which bids were filtered, with the number of bids filtered for each creative.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/bidders.filterSets.filteredBids.creatives/list

filterSetName <string> Name of the filter set that should be applied to the requested metrics. For example: - For a bidder-level filter set for bidder 123: `bidders/123/filterSets/abc` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123/filterSets/abc` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456/filterSets/abc`
creativeStatusId <integer> The ID of the creative status for which to retrieve a breakdown by creative. See [creative-status-codes](https://developers.google.com/authorized-buyers/rtb/downloads/creative-status-codes).

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will pick an appropriate default."
  ([filterSetName creativeStatusId]
    (bidders-filterSets-filteredBids-creatives-list
      filterSetName
      creativeStatusId
      nil))
  ([filterSetName creativeStatusId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/{+filterSetName}/filteredBids/{creativeStatusId}/creatives",
       :uri-template-args
       {:filterSetName filterSetName,
        :creativeStatusId creativeStatusId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn bidders-filterSets-losingBids-list
  "List all reasons for which bids lost in the auction, with the number of bids that lost for each reason.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/bidders.filterSets.losingBids/list

filterSetName <string> Name of the filter set that should be applied to the requested metrics. For example: - For a bidder-level filter set for bidder 123: `bidders/123/filterSets/abc` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123/filterSets/abc` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456/filterSets/abc`

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will pick an appropriate default."
  ([filterSetName]
    (bidders-filterSets-losingBids-list filterSetName nil))
  ([filterSetName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/{+filterSetName}/losingBids",
       :uri-template-args {:filterSetName filterSetName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn bidders-filterSets-nonBillableWinningBids-list
  "List all reasons for which winning bids were not billable, with the number of bids not billed for each reason.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/bidders.filterSets.nonBillableWinningBids/list

filterSetName <string> Name of the filter set that should be applied to the requested metrics. For example: - For a bidder-level filter set for bidder 123: `bidders/123/filterSets/abc` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123/filterSets/abc` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456/filterSets/abc`

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will pick an appropriate default."
  ([filterSetName]
    (bidders-filterSets-nonBillableWinningBids-list filterSetName nil))
  ([filterSetName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/{+filterSetName}/nonBillableWinningBids",
       :uri-template-args {:filterSetName filterSetName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn buyers-filterSets-create
  "Creates the specified filter set for the account with the given account ID.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/buyers.filterSets/create

ownerName <string> Name of the owner (bidder or account) of the filter set to be created. For example: - For a bidder-level filter set for bidder 123: `bidders/123` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456`
FilterSet:
{:formats
 [[FORMAT_UNSPECIFIED
   NATIVE_DISPLAY
   NATIVE_VIDEO
   NON_NATIVE_DISPLAY
   NON_NATIVE_VIDEO]],
 :format
 [FORMAT_UNSPECIFIED
  NATIVE_DISPLAY
  NATIVE_VIDEO
  NON_NATIVE_DISPLAY
  NON_NATIVE_VIDEO],
 :breakdownDimensions
 [[BREAKDOWN_DIMENSION_UNSPECIFIED PUBLISHER_IDENTIFIER]],
 :name string,
 :realtimeTimeRange {:startTimestamp string},
 :publisherIdentifiers [string],
 :timeSeriesGranularity
 [TIME_SERIES_GRANULARITY_UNSPECIFIED HOURLY DAILY],
 :creativeId string,
 :environment [ENVIRONMENT_UNSPECIFIED WEB APP],
 :absoluteDateRange
 {:startDate {:year integer, :month integer, :day integer},
  :endDate {:year integer, :month integer, :day integer}},
 :dealId string,
 :relativeDateRange {:offsetDays integer, :durationDays integer},
 :platforms [[PLATFORM_UNSPECIFIED DESKTOP TABLET MOBILE]],
 :sellerNetworkIds [integer]}

optional:
isTransient <boolean> Whether the filter set is transient, or should be persisted indefinitely. By default, filter sets are not transient. If transient, it will be available for at least 1 hour after creation."
  ([ownerName FilterSet]
    (buyers-filterSets-create ownerName FilterSet nil))
  ([ownerName FilterSet optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/{+ownerName}/filterSets",
       :uri-template-args {:ownerName ownerName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"],
       :body FilterSet})))

(defn buyers-filterSets-get
  "Retrieves the requested filter set for the account with the given account ID.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/buyers.filterSets/get

name <string> Full name of the resource being requested. For example: - For a bidder-level filter set for bidder 123: `bidders/123/filterSets/abc` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123/filterSets/abc` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456/filterSets/abc`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://adexchangebuyer.googleapis.com/v2beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}))

(defn buyers-filterSets-list
  "Lists all filter sets for the account with the given account ID.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/buyers.filterSets/list

ownerName <string> Name of the owner (bidder or account) of the filter sets to be listed. For example: - For a bidder-level filter set for bidder 123: `bidders/123` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456`

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will pick an appropriate default."
  ([ownerName] (buyers-filterSets-list ownerName nil))
  ([ownerName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/{+ownerName}/filterSets",
       :uri-template-args {:ownerName ownerName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn buyers-filterSets-delete
  "Deletes the requested filter set from the account with the given account ID.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/buyers.filterSets/delete

name <string> Full name of the resource to delete. For example: - For a bidder-level filter set for bidder 123: `bidders/123/filterSets/abc` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123/filterSets/abc` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456/filterSets/abc`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://adexchangebuyer.googleapis.com/v2beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}))

(defn buyers-filterSets-impressionMetrics-list
  "Lists all metrics that are measured in terms of number of impressions.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/buyers.filterSets.impressionMetrics/list

filterSetName <string> Name of the filter set that should be applied to the requested metrics. For example: - For a bidder-level filter set for bidder 123: `bidders/123/filterSets/abc` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123/filterSets/abc` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456/filterSets/abc`

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will pick an appropriate default."
  ([filterSetName]
    (buyers-filterSets-impressionMetrics-list filterSetName nil))
  ([filterSetName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/{+filterSetName}/impressionMetrics",
       :uri-template-args {:filterSetName filterSetName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn buyers-filterSets-bidMetrics-list
  "Lists all metrics that are measured in terms of number of bids.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/buyers.filterSets.bidMetrics/list

filterSetName <string> Name of the filter set that should be applied to the requested metrics. For example: - For a bidder-level filter set for bidder 123: `bidders/123/filterSets/abc` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123/filterSets/abc` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456/filterSets/abc`

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will pick an appropriate default."
  ([filterSetName]
    (buyers-filterSets-bidMetrics-list filterSetName nil))
  ([filterSetName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/{+filterSetName}/bidMetrics",
       :uri-template-args {:filterSetName filterSetName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn buyers-filterSets-filteredBidRequests-list
  "List all reasons that caused a bid request not to be sent for an impression, with the number of bid requests not sent for each reason.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/buyers.filterSets.filteredBidRequests/list

filterSetName <string> Name of the filter set that should be applied to the requested metrics. For example: - For a bidder-level filter set for bidder 123: `bidders/123/filterSets/abc` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123/filterSets/abc` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456/filterSets/abc`

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will pick an appropriate default."
  ([filterSetName]
    (buyers-filterSets-filteredBidRequests-list filterSetName nil))
  ([filterSetName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/{+filterSetName}/filteredBidRequests",
       :uri-template-args {:filterSetName filterSetName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn buyers-filterSets-bidResponseErrors-list
  "List all errors that occurred in bid responses, with the number of bid responses affected for each reason.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/buyers.filterSets.bidResponseErrors/list

filterSetName <string> Name of the filter set that should be applied to the requested metrics. For example: - For a bidder-level filter set for bidder 123: `bidders/123/filterSets/abc` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123/filterSets/abc` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456/filterSets/abc`

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will pick an appropriate default."
  ([filterSetName]
    (buyers-filterSets-bidResponseErrors-list filterSetName nil))
  ([filterSetName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/{+filterSetName}/bidResponseErrors",
       :uri-template-args {:filterSetName filterSetName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn buyers-filterSets-bidResponsesWithoutBids-list
  "List all reasons for which bid responses were considered to have no applicable bids, with the number of bid responses affected for each reason.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/buyers.filterSets.bidResponsesWithoutBids/list

filterSetName <string> Name of the filter set that should be applied to the requested metrics. For example: - For a bidder-level filter set for bidder 123: `bidders/123/filterSets/abc` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123/filterSets/abc` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456/filterSets/abc`

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will pick an appropriate default."
  ([filterSetName]
    (buyers-filterSets-bidResponsesWithoutBids-list filterSetName nil))
  ([filterSetName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/{+filterSetName}/bidResponsesWithoutBids",
       :uri-template-args {:filterSetName filterSetName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn buyers-filterSets-filteredBids-list
  "List all reasons for which bids were filtered, with the number of bids filtered for each reason.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/buyers.filterSets.filteredBids/list

filterSetName <string> Name of the filter set that should be applied to the requested metrics. For example: - For a bidder-level filter set for bidder 123: `bidders/123/filterSets/abc` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123/filterSets/abc` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456/filterSets/abc`

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will pick an appropriate default."
  ([filterSetName]
    (buyers-filterSets-filteredBids-list filterSetName nil))
  ([filterSetName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/{+filterSetName}/filteredBids",
       :uri-template-args {:filterSetName filterSetName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn buyers-filterSets-filteredBids-details-list
  "List all details associated with a specific reason for which bids were filtered, with the number of bids filtered for each detail.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/buyers.filterSets.filteredBids.details/list

filterSetName <string> Name of the filter set that should be applied to the requested metrics. For example: - For a bidder-level filter set for bidder 123: `bidders/123/filterSets/abc` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123/filterSets/abc` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456/filterSets/abc`
creativeStatusId <integer> The ID of the creative status for which to retrieve a breakdown by detail. See [creative-status-codes](https://developers.google.com/authorized-buyers/rtb/downloads/creative-status-codes). Details are only available for statuses 10, 14, 15, 17, 18, 19, 86, and 87.

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will pick an appropriate default."
  ([filterSetName creativeStatusId]
    (buyers-filterSets-filteredBids-details-list
      filterSetName
      creativeStatusId
      nil))
  ([filterSetName creativeStatusId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/{+filterSetName}/filteredBids/{creativeStatusId}/details",
       :uri-template-args
       {:filterSetName filterSetName,
        :creativeStatusId creativeStatusId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn buyers-filterSets-filteredBids-creatives-list
  "List all creatives associated with a specific reason for which bids were filtered, with the number of bids filtered for each creative.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/buyers.filterSets.filteredBids.creatives/list

filterSetName <string> Name of the filter set that should be applied to the requested metrics. For example: - For a bidder-level filter set for bidder 123: `bidders/123/filterSets/abc` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123/filterSets/abc` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456/filterSets/abc`
creativeStatusId <integer> The ID of the creative status for which to retrieve a breakdown by creative. See [creative-status-codes](https://developers.google.com/authorized-buyers/rtb/downloads/creative-status-codes).

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will pick an appropriate default."
  ([filterSetName creativeStatusId]
    (buyers-filterSets-filteredBids-creatives-list
      filterSetName
      creativeStatusId
      nil))
  ([filterSetName creativeStatusId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/{+filterSetName}/filteredBids/{creativeStatusId}/creatives",
       :uri-template-args
       {:filterSetName filterSetName,
        :creativeStatusId creativeStatusId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn buyers-filterSets-losingBids-list
  "List all reasons for which bids lost in the auction, with the number of bids that lost for each reason.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/buyers.filterSets.losingBids/list

filterSetName <string> Name of the filter set that should be applied to the requested metrics. For example: - For a bidder-level filter set for bidder 123: `bidders/123/filterSets/abc` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123/filterSets/abc` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456/filterSets/abc`

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will pick an appropriate default."
  ([filterSetName]
    (buyers-filterSets-losingBids-list filterSetName nil))
  ([filterSetName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/{+filterSetName}/losingBids",
       :uri-template-args {:filterSetName filterSetName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

(defn buyers-filterSets-nonBillableWinningBids-list
  "List all reasons for which winning bids were not billable, with the number of bids not billed for each reason.
https://developers.google.com/authorized-buyers/apis/reference/rest/v2beta1/buyers.filterSets.nonBillableWinningBids/list

filterSetName <string> Name of the filter set that should be applied to the requested metrics. For example: - For a bidder-level filter set for bidder 123: `bidders/123/filterSets/abc` - For an account-level filter set for the buyer account representing bidder 123: `bidders/123/accounts/123/filterSets/abc` - For an account-level filter set for the child seat buyer account 456 whose bidder is 123: `bidders/123/accounts/456/filterSets/abc`

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will pick an appropriate default."
  ([filterSetName]
    (buyers-filterSets-nonBillableWinningBids-list filterSetName nil))
  ([filterSetName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adexchangebuyer.googleapis.com/v2beta1/{+filterSetName}/nonBillableWinningBids",
       :uri-template-args {:filterSetName filterSetName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adexchange.buyer"]})))

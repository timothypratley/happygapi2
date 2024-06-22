(ns happygapi2.firebasedynamiclinks
  "Firebase Dynamic Links API
Programmatically creates and manages Firebase Dynamic Links.
See: https://firebase.google.com/docs/dynamic-links/"
  (:require [happy.oauth2.client :as client]))

(defn reopenAttribution
  "Get iOS reopen attribution for app universal link open deeplinking.
https://firebase.google.com/docs/dynamic-links/v1/docs/reopenAttribution

GetIosReopenAttributionRequest:
{:sdkVersion string, :bundleId string, :requestedLink string}"
  [GetIosReopenAttributionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://firebasedynamiclinks.googleapis.com/v1/reopenAttribution",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/firebase"],
     :body GetIosReopenAttributionRequest}))

(defn installAttribution
  "Get iOS strong/weak-match info for post-install attribution.
https://firebase.google.com/docs/dynamic-links/v1/docs/installAttribution

GetIosPostInstallAttributionRequest:
{:retrievalMethod
 [UNKNOWN_PAYLOAD_RETRIEVAL_METHOD
  IMPLICIT_WEAK_MATCH
  EXPLICIT_WEAK_MATCH
  EXPLICIT_STRONG_AFTER_WEAK_MATCH],
 :visualStyle [UNKNOWN_VISUAL_STYLE DEFAULT_STYLE CUSTOM_STYLE],
 :appInstallationTime string,
 :uniqueMatchLinkToCheck string,
 :sdkVersion string,
 :device
 {:timezone string,
  :languageCode string,
  :languageCodeFromWebview string,
  :screenResolutionHeight string,
  :languageCodeRaw string,
  :screenResolutionWidth string,
  :deviceModelName string},
 :iosVersion string,
 :bundleId string}"
  [GetIosPostInstallAttributionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://firebasedynamiclinks.googleapis.com/v1/installAttribution",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/firebase"],
     :body GetIosPostInstallAttributionRequest}))

(defn getLinkStats
  "Fetches analytics stats of a short Dynamic Link for a given duration. Metrics include number of clicks, redirects, installs, app first opens, and app reopens.
https://firebase.google.com/docs/dynamic-links/v1/docs/getLinkStats

dynamicLink <string> Dynamic Link URL. e.g. https://abcd.app.goo.gl/wxyz

optional:
durationDays <string> The span of time requested in days.
sdkVersion <string> Google SDK version. Version takes the form \"$major.$minor.$patch\""
  ([dynamicLink] (getLinkStats dynamicLink nil))
  ([dynamicLink optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://firebasedynamiclinks.googleapis.com/v1/{dynamicLink}/linkStats",
       :uri-template-args {:dynamicLink dynamicLink},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/firebase"]})))

(defn managedShortLinks-create
  "Creates a managed short Dynamic Link given either a valid long Dynamic Link or details such as Dynamic Link domain, Android and iOS app information. The created short Dynamic Link will not expire. This differs from CreateShortDynamicLink in the following ways: - The request will also contain a name for the link (non unique name for the front end). - The response must be authenticated with an auth token (generated with the admin service account). - The link will appear in the FDL list of links in the console front end. The Dynamic Link domain in the request must be owned by requester's Firebase project.
https://firebase.google.com/docs/dynamic-links/v1/docs/managedShortLinks/create

CreateManagedShortLinkRequest:
{:name string,
 :sdkVersion string,
 :suffix
 {:customSuffix string,
  :option [OPTION_UNSPECIFIED UNGUESSABLE SHORT CUSTOM]},
 :longDynamicLink string,
 :dynamicLinkInfo
 {:socialMetaTagInfo
  {:socialTitle string,
   :socialImageLink string,
   :socialDescription string},
  :analyticsInfo
  {:googlePlayAnalytics
   {:utmTerm string,
    :gclid string,
    :utmMedium string,
    :utmContent string,
    :utmSource string,
    :utmCampaign string},
   :itunesConnectAnalytics
   {:mt string, :at string, :ct string, :pt string}},
  :desktopInfo {:desktopFallbackLink string},
  :link string,
  :navigationInfo {:enableForcedRedirect boolean},
  :iosInfo
  {:iosIpadBundleId string,
   :iosBundleId string,
   :iosIpadFallbackLink string,
   :iosMinimumVersion string,
   :iosFallbackLink string,
   :iosAppStoreId string,
   :iosCustomScheme string},
  :domainUriPrefix string,
  :androidInfo
  {:androidFallbackLink string,
   :androidLink string,
   :androidMinPackageVersionCode string,
   :androidPackageName string},
  :dynamicLinkDomain string}}"
  [CreateManagedShortLinkRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://firebasedynamiclinks.googleapis.com/v1/managedShortLinks:create",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/firebase"],
     :body CreateManagedShortLinkRequest}))

(defn shortLinks-create
  "Creates a short Dynamic Link given either a valid long Dynamic Link or details such as Dynamic Link domain, Android and iOS app information. The created short Dynamic Link will not expire. Repeated calls with the same long Dynamic Link or Dynamic Link information will produce the same short Dynamic Link. The Dynamic Link domain in the request must be owned by requester's Firebase project.
https://firebase.google.com/docs/dynamic-links/v1/docs/shortLinks/create

CreateShortDynamicLinkRequest:
{:longDynamicLink string,
 :suffix
 {:customSuffix string,
  :option [OPTION_UNSPECIFIED UNGUESSABLE SHORT CUSTOM]},
 :sdkVersion string,
 :dynamicLinkInfo
 {:socialMetaTagInfo
  {:socialTitle string,
   :socialImageLink string,
   :socialDescription string},
  :analyticsInfo
  {:googlePlayAnalytics
   {:utmTerm string,
    :gclid string,
    :utmMedium string,
    :utmContent string,
    :utmSource string,
    :utmCampaign string},
   :itunesConnectAnalytics
   {:mt string, :at string, :ct string, :pt string}},
  :desktopInfo {:desktopFallbackLink string},
  :link string,
  :navigationInfo {:enableForcedRedirect boolean},
  :iosInfo
  {:iosIpadBundleId string,
   :iosBundleId string,
   :iosIpadFallbackLink string,
   :iosMinimumVersion string,
   :iosFallbackLink string,
   :iosAppStoreId string,
   :iosCustomScheme string},
  :domainUriPrefix string,
  :androidInfo
  {:androidFallbackLink string,
   :androidLink string,
   :androidMinPackageVersionCode string,
   :androidPackageName string},
  :dynamicLinkDomain string}}"
  [CreateShortDynamicLinkRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://firebasedynamiclinks.googleapis.com/v1/shortLinks",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/firebase"],
     :body CreateShortDynamicLinkRequest}))

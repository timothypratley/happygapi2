(ns happygapi2.books
  "Books API
The Google Books API allows clients to access the Google Books repository.
See: https://developers.google.com/books/docs/v1/getting_started?csw=1"
  (:require [happy.oauth2.client :as client]))

(defn familysharing-getFamilyInfo
  "Gets information regarding the family that the user is part of.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/familysharing/getFamilyInfo

optional:
source <string> String to identify the originator of this request."
  ([] (familysharing-getFamilyInfo nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://books.googleapis.com/books/v1/familysharing/getFamilyInfo",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn familysharing-share
  "Initiates sharing of the content with the user's family. Empty response indicates success.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/familysharing/share

optional:
docId <string> The docid to share.
source <string> String to identify the originator of this request.
volumeId <string> The volume to share."
  ([] (familysharing-share nil))
  ([optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://books.googleapis.com/books/v1/familysharing/share",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn familysharing-unshare
  "Initiates revoking content that has already been shared with the user's family. Empty response indicates success.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/familysharing/unshare

optional:
docId <string> The docid to unshare.
source <string> String to identify the originator of this request.
volumeId <string> The volume to unshare."
  ([] (familysharing-unshare nil))
  ([optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://books.googleapis.com/books/v1/familysharing/unshare",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn myconfig-getUserSettings
  "Gets the current settings for the user.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/myconfig/getUserSettings

optional:
country <string> Unused. Added only to workaround TEX mandatory request template requirement"
  ([] (myconfig-getUserSettings nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://books.googleapis.com/books/v1/myconfig/getUserSettings",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn myconfig-releaseDownloadAccess
  "Release downloaded content access restriction.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/myconfig/releaseDownloadAccess

cpksver <string> The device/version ID from which to release the restriction.
volumeIds <string> The volume(s) to release restrictions for.

optional:
locale <string> ISO-639-1, ISO-3166-1 codes for message localization, i.e. en_US.
source <string> String to identify the originator of this request."
  ([cpksver volumeIds]
    (myconfig-releaseDownloadAccess cpksver volumeIds nil))
  ([cpksver volumeIds optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://books.googleapis.com/books/v1/myconfig/releaseDownloadAccess",
       :uri-template-args {},
       :query-params
       (merge {:cpksver cpksver, :volumeIds volumeIds} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn myconfig-requestAccess
  "Request concurrent and download access restrictions.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/myconfig/requestAccess

cpksver <string> The device/version ID from which to request the restrictions.
nonce <string> The client nonce value.
source <string> String to identify the originator of this request.
volumeId <string> The volume to request concurrent/download restrictions for.

optional:
licenseTypes <string> The type of access license to request. If not specified, the default is BOTH.
locale <string> ISO-639-1, ISO-3166-1 codes for message localization, i.e. en_US."
  ([cpksver nonce source volumeId]
    (myconfig-requestAccess cpksver nonce source volumeId nil))
  ([cpksver nonce source volumeId optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://books.googleapis.com/books/v1/myconfig/requestAccess",
       :uri-template-args {},
       :query-params
       (merge
         {:cpksver cpksver,
          :nonce nonce,
          :source source,
          :volumeId volumeId}
         optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn myconfig-syncVolumeLicenses
  "Request downloaded content access for specified volumes on the My eBooks shelf.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/myconfig/syncVolumeLicenses

cpksver <string> The device/version ID from which to release the restriction.
nonce <string> The client nonce value.
source <string> String to identify the originator of this request.

optional:
features <string> List of features supported by the client, i.e., 'RENTALS'
includeNonComicsSeries <boolean> Set to true to include non-comics series. Defaults to false.
locale <string> ISO-639-1, ISO-3166-1 codes for message localization, i.e. en_US.
showPreorders <boolean> Set to true to show pre-ordered books. Defaults to false.
volumeIds <string> The volume(s) to request download restrictions for."
  ([cpksver nonce source]
    (myconfig-syncVolumeLicenses cpksver nonce source nil))
  ([cpksver nonce source optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://books.googleapis.com/books/v1/myconfig/syncVolumeLicenses",
       :uri-template-args {},
       :query-params
       (merge
         {:cpksver cpksver, :nonce nonce, :source source}
         optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn myconfig-updateUserSettings
  "Sets the settings for the user. If a sub-object is specified, it will overwrite the existing sub-object stored in the server. Unspecified sub-objects will retain the existing value.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/myconfig/updateUserSettings

Usersettings:
{:kind string,
 :notification
 {:moreFromAuthors {:opted_state string},
  :moreFromSeries {:opted_state string},
  :rewardExpirations {:opted_state string},
  :priceDrop {:opted_state string},
  :matchMyInterests {:opted_state string}},
 :notesExport {:isEnabled boolean, :folderName string}}"
  [Usersettings]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://books.googleapis.com/books/v1/myconfig/updateUserSettings",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/books"],
     :body Usersettings}))

(defn series-get
  "Returns Series metadata for the given series ids.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/series/get

series_id <string> String that identifies the series"
  [series_id]
  (client/api-request
    {:method "GET",
     :uri-template "https://books.googleapis.com/books/v1/series/get",
     :uri-template-args {},
     :query-params {:series_id series_id},
     :scopes ["https://www.googleapis.com/auth/books"]}))

(defn series-membership-get
  "Returns Series membership data given the series id.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/series/membership/get

series_id <string> String that identifies the series

optional:
page_size <integer> Number of maximum results per page to be included in the response.
page_token <string> The value of the nextToken from the previous page."
  ([series_id] (series-membership-get series_id nil))
  ([series_id optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://books.googleapis.com/books/v1/series/membership/get",
       :uri-template-args {},
       :query-params (merge {:series_id series_id} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn notification-get
  "Returns notification details for a given notification id.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/notification/get

notification_id <string> String to identify the notification.

optional:
locale <string> ISO-639-1 language and ISO-3166-1 country code. Ex: 'en_US'. Used for generating notification title and body.
source <string> String to identify the originator of this request."
  ([notification_id] (notification-get notification_id nil))
  ([notification_id optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://books.googleapis.com/books/v1/notification/get",
       :uri-template-args {},
       :query-params
       (merge {:notification_id notification_id} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn dictionary-listOfflineMetadata
  "Returns a list of offline dictionary metadata available
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/dictionary/listOfflineMetadata

cpksver <string> The device/version ID from which to request the data."
  [cpksver]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://books.googleapis.com/books/v1/dictionary/listOfflineMetadata",
     :uri-template-args {},
     :query-params {:cpksver cpksver},
     :scopes ["https://www.googleapis.com/auth/books"]}))

(defn bookshelves-get
  "Retrieves metadata for a specific bookshelf for the specified user.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/bookshelves/get

userId <string> ID of user for whom to retrieve bookshelves.
shelf <string> ID of bookshelf to retrieve.

optional:
source <string> String to identify the originator of this request."
  ([userId shelf] (bookshelves-get userId shelf nil))
  ([userId shelf optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://books.googleapis.com/books/v1/users/{userId}/bookshelves/{shelf}",
       :uri-template-args {:userId userId, :shelf shelf},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn bookshelves-list
  "Retrieves a list of public bookshelves for the specified user.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/bookshelves/list

userId <string> ID of user for whom to retrieve bookshelves.

optional:
source <string> String to identify the originator of this request."
  ([userId] (bookshelves-list userId nil))
  ([userId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://books.googleapis.com/books/v1/users/{userId}/bookshelves",
       :uri-template-args {:userId userId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn bookshelves-volumes-list
  "Retrieves volumes in a specific bookshelf for the specified user.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/bookshelves/volumes/list

userId <string> ID of user for whom to retrieve bookshelf volumes.
shelf <string> ID of bookshelf to retrieve volumes.

optional:
maxResults <integer> Maximum number of results to return
showPreorders <boolean> Set to true to show pre-ordered books. Defaults to false.
source <string> String to identify the originator of this request.
startIndex <integer> Index of the first element to return (starts at 0)"
  ([userId shelf] (bookshelves-volumes-list userId shelf nil))
  ([userId shelf optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://books.googleapis.com/books/v1/users/{userId}/bookshelves/{shelf}/volumes",
       :uri-template-args {:userId userId, :shelf shelf},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn cloudloading-addBook
  "Add a user-upload volume and triggers processing.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/cloudloading/addBook

optional:
drive_document_id <string> A drive document id. The upload_client_token must not be set.
mime_type <string> The document MIME type. It can be set only if the drive_document_id is set.
name <string> The document name. It can be set only if the drive_document_id is set.
upload_client_token <string> Scotty upload token."
  ([] (cloudloading-addBook nil))
  ([optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://books.googleapis.com/books/v1/cloudloading/addBook",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn cloudloading-deleteBook
  "Remove the book and its contents
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/cloudloading/deleteBook

volumeId <string> The id of the book to be removed."
  [volumeId]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://books.googleapis.com/books/v1/cloudloading/deleteBook",
     :uri-template-args {},
     :query-params {:volumeId volumeId},
     :scopes ["https://www.googleapis.com/auth/books"]}))

(defn cloudloading-updateBook
  "Updates a user-upload volume.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/cloudloading/updateBook

BooksCloudloadingResource:
{:volumeId string,
 :title string,
 :author string,
 :processingState string}"
  [BooksCloudloadingResource]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://books.googleapis.com/books/v1/cloudloading/updateBook",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/books"],
     :body BooksCloudloadingResource}))

(defn onboarding-listCategories
  "List categories for onboarding experience.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/onboarding/listCategories

optional:
locale <string> ISO-639-1 language and ISO-3166-1 country code. Default is en-US if unset."
  ([] (onboarding-listCategories nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://books.googleapis.com/books/v1/onboarding/listCategories",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn onboarding-listCategoryVolumes
  "List available volumes under categories for onboarding experience.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/onboarding/listCategoryVolumes

optional:
categoryId <string> List of category ids requested.
locale <string> ISO-639-1 language and ISO-3166-1 country code. Default is en-US if unset.
maxAllowedMaturityRating <string> The maximum allowed maturity rating of returned volumes. Books with a higher maturity rating are filtered out.
pageSize <integer> Number of maximum results per page to be included in the response."
  ([] (onboarding-listCategoryVolumes nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://books.googleapis.com/books/v1/onboarding/listCategoryVolumes",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn volumes-get
  "Gets volume information for a single volume.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/volumes/get

volumeId <string> ID of volume to retrieve.

optional:
country <string> ISO-3166-1 code to override the IP-based location.
includeNonComicsSeries <boolean> Set to true to include non-comics series. Defaults to false.
partner <string> Brand results for partner ID.
projection <string> Restrict information returned to a set of selected fields.
source <string> string to identify the originator of this request.
user_library_consistent_read <boolean> "
  ([volumeId] (volumes-get volumeId nil))
  ([volumeId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://books.googleapis.com/books/v1/volumes/{volumeId}",
       :uri-template-args {:volumeId volumeId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn volumes-list
  "Performs a book search.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/volumes/list

q <string> Full-text search query string.

optional:
maxAllowedMaturityRating <string> The maximum allowed maturity rating of returned recommendations. Books with a higher maturity rating are filtered out.
partner <string> Restrict and brand results for partner ID.
printType <string> Restrict to books or magazines.
libraryRestrict <string> Restrict search to this user's library.
langRestrict <string> Restrict results to books with this language code.
source <string> String to identify the originator of this request.
filter <string> Filter search results.
showPreorders <boolean> Set to true to show books available for preorder. Defaults to false.
download <string> Restrict to volumes by download availability.
startIndex <integer> Index of the first result to return (starts at 0)
projection <string> Restrict information returned to a set of selected fields.
maxResults <integer> Maximum number of results to return.
orderBy <string> Sort search results."
  ([q] (volumes-list q nil))
  ([q optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://books.googleapis.com/books/v1/volumes",
       :uri-template-args {},
       :query-params (merge {:q q} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn volumes-associated-list
  "Return a list of associated books.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/volumes/associated/list

volumeId <string> ID of the source volume.

optional:
association <string> Association type.
locale <string> ISO-639-1 language and ISO-3166-1 country code. Ex: 'en_US'. Used for generating recommendations.
maxAllowedMaturityRating <string> The maximum allowed maturity rating of returned recommendations. Books with a higher maturity rating are filtered out.
source <string> String to identify the originator of this request."
  ([volumeId] (volumes-associated-list volumeId nil))
  ([volumeId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://books.googleapis.com/books/v1/volumes/{volumeId}/associated",
       :uri-template-args {:volumeId volumeId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn volumes-mybooks-list
  "Return a list of books in My Library.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/volumes/mybooks/list

optional:
acquireMethod <string> How the book was acquired
country <string> ISO-3166-1 code to override the IP-based location.
locale <string> ISO-639-1 language and ISO-3166-1 country code. Ex:'en_US'. Used for generating recommendations.
maxResults <integer> Maximum number of results to return.
processingState <string> The processing state of the user uploaded volumes to be returned. Applicable only if the UPLOADED is specified in the acquireMethod.
source <string> String to identify the originator of this request.
startIndex <integer> Index of the first result to return (starts at 0)"
  ([] (volumes-mybooks-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://books.googleapis.com/books/v1/volumes/mybooks",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn volumes-recommended-list
  "Return a list of recommended books for the current user.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/volumes/recommended/list

optional:
locale <string> ISO-639-1 language and ISO-3166-1 country code. Ex: 'en_US'. Used for generating recommendations.
maxAllowedMaturityRating <string> The maximum allowed maturity rating of returned recommendations. Books with a higher maturity rating are filtered out.
source <string> String to identify the originator of this request."
  ([] (volumes-recommended-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://books.googleapis.com/books/v1/volumes/recommended",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn volumes-recommended-rate
  "Rate a recommended book for the current user.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/volumes/recommended/rate

rating <string> Rating to be given to the volume.
volumeId <string> ID of the source volume.

optional:
locale <string> ISO-639-1 language and ISO-3166-1 country code. Ex: 'en_US'. Used for generating recommendations.
source <string> String to identify the originator of this request."
  ([rating volumeId] (volumes-recommended-rate rating volumeId nil))
  ([rating volumeId optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://books.googleapis.com/books/v1/volumes/recommended/rate",
       :uri-template-args {},
       :query-params
       (merge {:rating rating, :volumeId volumeId} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn volumes-useruploaded-list
  "Return a list of books uploaded by the current user.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/volumes/useruploaded/list

optional:
locale <string> ISO-639-1 language and ISO-3166-1 country code. Ex: 'en_US'. Used for generating recommendations.
maxResults <integer> Maximum number of results to return.
processingState <string> The processing state of the user uploaded volumes to be returned.
source <string> String to identify the originator of this request.
startIndex <integer> Index of the first result to return (starts at 0)
volumeId <string> The ids of the volumes to be returned. If not specified all that match the processingState are returned."
  ([] (volumes-useruploaded-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://books.googleapis.com/books/v1/volumes/useruploaded",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn promooffer-accept
  "Accepts the promo offer.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/promooffer/accept

optional:
androidId <string> device android_id
device <string> device device
manufacturer <string> device manufacturer
model <string> device model
offerId <string> 
product <string> device product
serial <string> device serial
volumeId <string> Volume id to exercise the offer"
  ([] (promooffer-accept nil))
  ([optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://books.googleapis.com/books/v1/promooffer/accept",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn promooffer-dismiss
  "Marks the promo offer as dismissed.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/promooffer/dismiss

optional:
androidId <string> device android_id
device <string> device device
manufacturer <string> device manufacturer
model <string> device model
offerId <string> Offer to dimiss
product <string> device product
serial <string> device serial"
  ([] (promooffer-dismiss nil))
  ([optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://books.googleapis.com/books/v1/promooffer/dismiss",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn promooffer-get
  "Returns a list of promo offers available to the user
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/promooffer/get

optional:
androidId <string> device android_id
device <string> device device
manufacturer <string> device manufacturer
model <string> device model
product <string> device product
serial <string> device serial"
  ([] (promooffer-get nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://books.googleapis.com/books/v1/promooffer/get",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn personalizedstream-get
  "Returns a stream of personalized book clusters
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/personalizedstream/get

optional:
locale <string> ISO-639-1 language and ISO-3166-1 country code. Ex: 'en_US'. Used for generating recommendations.
maxAllowedMaturityRating <string> The maximum allowed maturity rating of returned recommendations. Books with a higher maturity rating are filtered out.
source <string> String to identify the originator of this request."
  ([] (personalizedstream-get nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://books.googleapis.com/books/v1/personalizedstream/get",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn layers-get
  "Gets the layer summary for a volume.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/layers/get

volumeId <string> The volume to retrieve layers for.
summaryId <string> The ID for the layer to get the summary for.

optional:
contentVersion <string> The content version for the requested volume.
source <string> String to identify the originator of this request."
  ([volumeId summaryId] (layers-get volumeId summaryId nil))
  ([volumeId summaryId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://books.googleapis.com/books/v1/volumes/{volumeId}/layersummary/{summaryId}",
       :uri-template-args {:volumeId volumeId, :summaryId summaryId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn layers-list
  "List the layer summaries for a volume.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/layers/list

volumeId <string> The volume to retrieve layers for.

optional:
contentVersion <string> The content version for the requested volume.
maxResults <integer> Maximum number of results to return
source <string> String to identify the originator of this request."
  ([volumeId] (layers-list volumeId nil))
  ([volumeId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://books.googleapis.com/books/v1/volumes/{volumeId}/layersummary",
       :uri-template-args {:volumeId volumeId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn layers-annotationData-get
  "Gets the annotation data.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/layers/annotationData/get

volumeId <string> The volume to retrieve annotations for.
layerId <string> The ID for the layer to get the annotations.
annotationDataId <string> The ID of the annotation data to retrieve.
contentVersion <string> The content version for the volume you are trying to retrieve.

optional:
scale <integer> The requested scale for the image.
locale <string> The locale information for the data. ISO-639-1 language and ISO-3166-1 country code. Ex: 'en_US'.
w <integer> The requested pixel width for any images. If width is provided height must also be provided.
source <string> String to identify the originator of this request.
allowWebDefinitions <boolean> For the dictionary layer. Whether or not to allow web definitions.
h <integer> The requested pixel height for any images. If height is provided width must also be provided."
  ([volumeId layerId annotationDataId contentVersion]
    (layers-annotationData-get
      volumeId
      layerId
      annotationDataId
      contentVersion
      nil))
  ([volumeId layerId annotationDataId contentVersion optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://books.googleapis.com/books/v1/volumes/{volumeId}/layers/{layerId}/data/{annotationDataId}",
       :uri-template-args
       {:volumeId volumeId,
        :layerId layerId,
        :annotationDataId annotationDataId},
       :query-params (merge {:contentVersion contentVersion} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn layers-annotationData-list
  "Gets the annotation data for a volume and layer.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/layers/annotationData/list

volumeId <string> The volume to retrieve annotation data for.
layerId <string> The ID for the layer to get the annotation data.
contentVersion <string> The content version for the requested volume.

optional:
scale <integer> The requested scale for the image.
locale <string> The locale information for the data. ISO-639-1 language and ISO-3166-1 country code. Ex: 'en_US'.
w <integer> The requested pixel width for any images. If width is provided height must also be provided.
source <string> String to identify the originator of this request.
h <integer> The requested pixel height for any images. If height is provided width must also be provided.
updatedMax <string> RFC 3339 timestamp to restrict to items updated prior to this timestamp (exclusive).
annotationDataId <string> The list of Annotation Data Ids to retrieve. Pagination is ignored if this is set.
updatedMin <string> RFC 3339 timestamp to restrict to items updated since this timestamp (inclusive).
maxResults <integer> Maximum number of results to return"
  ([volumeId layerId contentVersion]
    (layers-annotationData-list volumeId layerId contentVersion nil))
  ([volumeId layerId contentVersion optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://books.googleapis.com/books/v1/volumes/{volumeId}/layers/{layerId}/data",
       :uri-template-args {:volumeId volumeId, :layerId layerId},
       :query-params (merge {:contentVersion contentVersion} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn layers-volumeAnnotations-get
  "Gets the volume annotation.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/layers/volumeAnnotations/get

volumeId <string> The volume to retrieve annotations for.
layerId <string> The ID for the layer to get the annotations.
annotationId <string> The ID of the volume annotation to retrieve.

optional:
locale <string> The locale information for the data. ISO-639-1 language and ISO-3166-1 country code. Ex: 'en_US'.
source <string> String to identify the originator of this request."
  ([volumeId layerId annotationId]
    (layers-volumeAnnotations-get volumeId layerId annotationId nil))
  ([volumeId layerId annotationId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://books.googleapis.com/books/v1/volumes/{volumeId}/layers/{layerId}/annotations/{annotationId}",
       :uri-template-args
       {:volumeId volumeId,
        :layerId layerId,
        :annotationId annotationId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn layers-volumeAnnotations-list
  "Gets the volume annotations for a volume and layer.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/layers/volumeAnnotations/list

volumeId <string> The volume to retrieve annotations for.
layerId <string> The ID for the layer to get the annotations.
contentVersion <string> The content version for the requested volume.

optional:
startOffset <string> The start offset to start retrieving data from.
endPosition <string> The end position to end retrieving data from.
locale <string> The locale information for the data. ISO-639-1 language and ISO-3166-1 country code. Ex: 'en_US'.
endOffset <string> The end offset to end retrieving data from.
source <string> String to identify the originator of this request.
startPosition <string> The start position to start retrieving data from.
volumeAnnotationsVersion <string> The version of the volume annotations that you are requesting.
updatedMax <string> RFC 3339 timestamp to restrict to items updated prior to this timestamp (exclusive).
showDeleted <boolean> Set to true to return deleted annotations. updatedMin must be in the request to use this. Defaults to false.
updatedMin <string> RFC 3339 timestamp to restrict to items updated since this timestamp (inclusive).
maxResults <integer> Maximum number of results to return"
  ([volumeId layerId contentVersion]
    (layers-volumeAnnotations-list
      volumeId
      layerId
      contentVersion
      nil))
  ([volumeId layerId contentVersion optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://books.googleapis.com/books/v1/volumes/{volumeId}/layers/{layerId}",
       :uri-template-args {:volumeId volumeId, :layerId layerId},
       :query-params (merge {:contentVersion contentVersion} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn mylibrary-annotations-delete
  "Deletes an annotation.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/mylibrary/annotations/delete

annotationId <string> The ID for the annotation to delete.

optional:
source <string> String to identify the originator of this request."
  ([annotationId] (mylibrary-annotations-delete annotationId nil))
  ([annotationId optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://books.googleapis.com/books/v1/mylibrary/annotations/{annotationId}",
       :uri-template-args {:annotationId annotationId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn mylibrary-annotations-insert
  "Inserts a new annotation.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/mylibrary/annotations/insert

Annotation:
{:deleted boolean,
 :volumeId string,
 :selectedText string,
 :layerSummary
 {:remainingCharacterCount integer,
  :allowedCharacterCount integer,
  :limitType string},
 :updated string,
 :selfLink string,
 :highlightStyle string,
 :created string,
 :currentVersionRanges
 {:contentVersion string,
  :gbImageRange
  {:startPosition string,
   :startOffset string,
   :endPosition string,
   :endOffset string},
  :gbTextRange
  {:startPosition string,
   :startOffset string,
   :endPosition string,
   :endOffset string},
  :cfiRange
  {:startPosition string,
   :startOffset string,
   :endPosition string,
   :endOffset string},
  :imageCfiRange
  {:startPosition string,
   :startOffset string,
   :endPosition string,
   :endOffset string}},
 :afterSelectedText string,
 :id string,
 :kind string,
 :pageIds [string],
 :clientVersionRanges
 {:gbImageRange
  {:startPosition string,
   :startOffset string,
   :endPosition string,
   :endOffset string},
  :gbTextRange
  {:startPosition string,
   :startOffset string,
   :endPosition string,
   :endOffset string},
  :cfiRange
  {:startPosition string,
   :startOffset string,
   :endPosition string,
   :endOffset string},
  :contentVersion string,
  :imageCfiRange
  {:startPosition string,
   :startOffset string,
   :endPosition string,
   :endOffset string}},
 :beforeSelectedText string,
 :layerId string,
 :data string}

optional:
annotationId <string> The ID for the annotation to insert.
country <string> ISO-3166-1 code to override the IP-based location.
showOnlySummaryInResponse <boolean> Requests that only the summary of the specified layer be provided in the response.
source <string> String to identify the originator of this request."
  ([Annotation] (mylibrary-annotations-insert Annotation nil))
  ([Annotation optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://books.googleapis.com/books/v1/mylibrary/annotations",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/books"],
       :body Annotation})))

(defn mylibrary-annotations-list
  "Retrieves a list of annotations, possibly filtered.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/mylibrary/annotations/list

optional:
layerIds <string> The layer ID(s) to limit annotation by.
volumeId <string> The volume to restrict annotations to.
source <string> String to identify the originator of this request.
contentVersion <string> The content version for the requested volume.
updatedMax <string> RFC 3339 timestamp to restrict to items updated prior to this timestamp (exclusive).
layerId <string> The layer ID to limit annotation by.
showDeleted <boolean> Set to true to return deleted annotations. updatedMin must be in the request to use this. Defaults to false.
updatedMin <string> RFC 3339 timestamp to restrict to items updated since this timestamp (inclusive).
maxResults <integer> Maximum number of results to return"
  ([] (mylibrary-annotations-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://books.googleapis.com/books/v1/mylibrary/annotations",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn mylibrary-annotations-summary
  "Gets the summary of specified layers.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/mylibrary/annotations/summary

layerIds <string> Array of layer IDs to get the summary for.
volumeId <string> Volume id to get the summary for.

optional:
source <string> Optional. String to identify the originator of this request."
  ([layerIds volumeId]
    (mylibrary-annotations-summary layerIds volumeId nil))
  ([layerIds volumeId optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://books.googleapis.com/books/v1/mylibrary/annotations/summary",
       :uri-template-args {},
       :query-params
       (merge {:layerIds layerIds, :volumeId volumeId} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn mylibrary-annotations-update
  "Updates an existing annotation.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/mylibrary/annotations/update

annotationId <string> The ID for the annotation to update.
Annotation:
{:deleted boolean,
 :volumeId string,
 :selectedText string,
 :layerSummary
 {:remainingCharacterCount integer,
  :allowedCharacterCount integer,
  :limitType string},
 :updated string,
 :selfLink string,
 :highlightStyle string,
 :created string,
 :currentVersionRanges
 {:contentVersion string,
  :gbImageRange
  {:startPosition string,
   :startOffset string,
   :endPosition string,
   :endOffset string},
  :gbTextRange
  {:startPosition string,
   :startOffset string,
   :endPosition string,
   :endOffset string},
  :cfiRange
  {:startPosition string,
   :startOffset string,
   :endPosition string,
   :endOffset string},
  :imageCfiRange
  {:startPosition string,
   :startOffset string,
   :endPosition string,
   :endOffset string}},
 :afterSelectedText string,
 :id string,
 :kind string,
 :pageIds [string],
 :clientVersionRanges
 {:gbImageRange
  {:startPosition string,
   :startOffset string,
   :endPosition string,
   :endOffset string},
  :gbTextRange
  {:startPosition string,
   :startOffset string,
   :endPosition string,
   :endOffset string},
  :cfiRange
  {:startPosition string,
   :startOffset string,
   :endPosition string,
   :endOffset string},
  :contentVersion string,
  :imageCfiRange
  {:startPosition string,
   :startOffset string,
   :endPosition string,
   :endOffset string}},
 :beforeSelectedText string,
 :layerId string,
 :data string}

optional:
source <string> String to identify the originator of this request."
  ([annotationId Annotation]
    (mylibrary-annotations-update annotationId Annotation nil))
  ([annotationId Annotation optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://books.googleapis.com/books/v1/mylibrary/annotations/{annotationId}",
       :uri-template-args {:annotationId annotationId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/books"],
       :body Annotation})))

(defn mylibrary-bookshelves-addVolume
  "Adds a volume to a bookshelf.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/mylibrary/bookshelves/addVolume

shelf <string> ID of bookshelf to which to add a volume.
volumeId <string> ID of volume to add.

optional:
reason <string> The reason for which the book is added to the library.
source <string> String to identify the originator of this request."
  ([shelf volumeId]
    (mylibrary-bookshelves-addVolume shelf volumeId nil))
  ([shelf volumeId optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://books.googleapis.com/books/v1/mylibrary/bookshelves/{shelf}/addVolume",
       :uri-template-args {:shelf shelf},
       :query-params (merge {:volumeId volumeId} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn mylibrary-bookshelves-clearVolumes
  "Clears all volumes from a bookshelf.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/mylibrary/bookshelves/clearVolumes

shelf <string> ID of bookshelf from which to remove a volume.

optional:
source <string> String to identify the originator of this request."
  ([shelf] (mylibrary-bookshelves-clearVolumes shelf nil))
  ([shelf optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://books.googleapis.com/books/v1/mylibrary/bookshelves/{shelf}/clearVolumes",
       :uri-template-args {:shelf shelf},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn mylibrary-bookshelves-get
  "Retrieves metadata for a specific bookshelf belonging to the authenticated user.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/mylibrary/bookshelves/get

shelf <string> ID of bookshelf to retrieve.

optional:
source <string> String to identify the originator of this request."
  ([shelf] (mylibrary-bookshelves-get shelf nil))
  ([shelf optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://books.googleapis.com/books/v1/mylibrary/bookshelves/{shelf}",
       :uri-template-args {:shelf shelf},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn mylibrary-bookshelves-list
  "Retrieves a list of bookshelves belonging to the authenticated user.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/mylibrary/bookshelves/list

optional:
source <string> String to identify the originator of this request."
  ([] (mylibrary-bookshelves-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://books.googleapis.com/books/v1/mylibrary/bookshelves",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn mylibrary-bookshelves-moveVolume
  "Moves a volume within a bookshelf.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/mylibrary/bookshelves/moveVolume

shelf <string> ID of bookshelf with the volume.
volumeId <string> ID of volume to move.
volumePosition <integer> Position on shelf to move the item (0 puts the item before the current first item, 1 puts it between the first and the second and so on.)

optional:
source <string> String to identify the originator of this request."
  ([shelf volumeId volumePosition]
    (mylibrary-bookshelves-moveVolume
      shelf
      volumeId
      volumePosition
      nil))
  ([shelf volumeId volumePosition optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://books.googleapis.com/books/v1/mylibrary/bookshelves/{shelf}/moveVolume",
       :uri-template-args {:shelf shelf},
       :query-params
       (merge
         {:volumeId volumeId, :volumePosition volumePosition}
         optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn mylibrary-bookshelves-removeVolume
  "Removes a volume from a bookshelf.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/mylibrary/bookshelves/removeVolume

shelf <string> ID of bookshelf from which to remove a volume.
volumeId <string> ID of volume to remove.

optional:
reason <string> The reason for which the book is removed from the library.
source <string> String to identify the originator of this request."
  ([shelf volumeId]
    (mylibrary-bookshelves-removeVolume shelf volumeId nil))
  ([shelf volumeId optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://books.googleapis.com/books/v1/mylibrary/bookshelves/{shelf}/removeVolume",
       :uri-template-args {:shelf shelf},
       :query-params (merge {:volumeId volumeId} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn mylibrary-bookshelves-volumes-list
  "Gets volume information for volumes on a bookshelf.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/mylibrary/bookshelves/volumes/list

shelf <string> The bookshelf ID or name retrieve volumes for.

optional:
country <string> ISO-3166-1 code to override the IP-based location.
maxResults <integer> Maximum number of results to return
projection <string> Restrict information returned to a set of selected fields.
q <string> Full-text search query string in this bookshelf.
showPreorders <boolean> Set to true to show pre-ordered books. Defaults to false.
source <string> String to identify the originator of this request.
startIndex <integer> Index of the first element to return (starts at 0)"
  ([shelf] (mylibrary-bookshelves-volumes-list shelf nil))
  ([shelf optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://books.googleapis.com/books/v1/mylibrary/bookshelves/{shelf}/volumes",
       :uri-template-args {:shelf shelf},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn mylibrary-readingpositions-get
  "Retrieves my reading position information for a volume.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/mylibrary/readingpositions/get

volumeId <string> ID of volume for which to retrieve a reading position.

optional:
contentVersion <string> Volume content version for which this reading position is requested.
source <string> String to identify the originator of this request."
  ([volumeId] (mylibrary-readingpositions-get volumeId nil))
  ([volumeId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://books.googleapis.com/books/v1/mylibrary/readingpositions/{volumeId}",
       :uri-template-args {:volumeId volumeId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

(defn mylibrary-readingpositions-setPosition
  "Sets my reading position information for a volume.
https://developers.google.com/books/docs/v1/getting_started?csw=1/v1/docs/mylibrary/readingpositions/setPosition

volumeId <string> ID of volume for which to update the reading position.
position <string> Position string for the new volume reading position.
timestamp <string> RFC 3339 UTC format timestamp associated with this reading position.

optional:
action <string> Action that caused this reading position to be set.
contentVersion <string> Volume content version for which this reading position applies.
deviceCookie <string> Random persistent device cookie optional on set position.
source <string> String to identify the originator of this request."
  ([volumeId position timestamp]
    (mylibrary-readingpositions-setPosition
      volumeId
      position
      timestamp
      nil))
  ([volumeId position timestamp optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://books.googleapis.com/books/v1/mylibrary/readingpositions/{volumeId}/setPosition",
       :uri-template-args {:volumeId volumeId},
       :query-params
       (merge {:position position, :timestamp timestamp} optional),
       :scopes ["https://www.googleapis.com/auth/books"]})))

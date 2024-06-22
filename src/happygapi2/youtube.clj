(ns happygapi2.youtube
  "YouTube Data API v3
The YouTube Data API v3 is an API that provides access to YouTube data, such as videos, playlists, and channels.
See: https://developers.google.com/youtube/"
  (:require [happy.oauth2.client :as client]))

(defn channelBanners-insert
  "Inserts a new resource into this collection.
https://developers.google.com/youtube/v3/docs/channelBanners/insert

ChannelBannerResource:
{:kind string, :url string, :etag string}

optional:
onBehalfOfContentOwnerChannel <string> This parameter can only be used in a properly authorized request. *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwnerChannel* parameter specifies the YouTube channel ID of the channel to which a video is being added. This parameter is required when a request specifies a value for the onBehalfOfContentOwner parameter, and it can only be used in conjunction with that parameter. In addition, the request must be authorized using a CMS account that is linked to the content owner that the onBehalfOfContentOwner parameter specifies. Finally, the channel that the onBehalfOfContentOwnerChannel parameter value specifies must be linked to the content owner that the onBehalfOfContentOwner parameter specifies. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and perform actions on behalf of the channel specified in the parameter value, without having to provide authentication credentials for each separate channel.
channelId <string> Unused, channel_id is currently derived from the security context of the requestor.
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The actual CMS account that the user authenticates with must be linked to the specified YouTube content owner."
  ([ChannelBannerResource]
    (channelBanners-insert ChannelBannerResource nil))
  ([ChannelBannerResource optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/channelBanners/insert",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtube.upload"],
       :body ChannelBannerResource})))

(defn watermarks-set
  "Allows upload of watermark image and setting it for a channel.
https://developers.google.com/youtube/v3/docs/watermarks/set

channelId <string> 
InvideoBranding:
{:timing
 {:type [offsetFromStart offsetFromEnd],
  :durationMs string,
  :offsetMs string},
 :imageUrl string,
 :targetChannelId string,
 :imageBytes string,
 :position
 {:type [corner],
  :cornerPosition [topLeft topRight bottomLeft bottomRight]}}

optional:
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The CMS account that the user authenticates with must be linked to the specified YouTube content owner."
  ([channelId InvideoBranding]
    (watermarks-set channelId InvideoBranding nil))
  ([channelId InvideoBranding optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/watermarks/set",
       :uri-template-args {},
       :query-params (merge {:channelId channelId} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtube.upload"
        "https://www.googleapis.com/auth/youtubepartner"],
       :body InvideoBranding})))

(defn watermarks-unset
  "Allows removal of channel watermark.
https://developers.google.com/youtube/v3/docs/watermarks/unset

channelId <string> 

optional:
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The CMS account that the user authenticates with must be linked to the specified YouTube content owner."
  ([channelId] (watermarks-unset channelId nil))
  ([channelId optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/watermarks/unset",
       :uri-template-args {},
       :query-params (merge {:channelId channelId} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtubepartner"]})))

(defn superChatEvents-list
  "Retrieves a list of resources, possibly filtered.
https://developers.google.com/youtube/v3/docs/superChatEvents/list

part <string> The *part* parameter specifies the superChatEvent resource parts that the API response will include. This parameter is currently not supported.

optional:
hl <string> Return rendered funding amounts in specified language.
maxResults <integer> The *maxResults* parameter specifies the maximum number of items that should be returned in the result set."
  ([part] (superChatEvents-list part nil))
  ([part optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/superChatEvents",
       :uri-template-args {},
       :query-params (merge {:part part} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtube.readonly"]})))

(defn liveStreams-delete
  "Deletes an existing stream for the authenticated user.
https://developers.google.com/youtube/v3/docs/liveStreams/delete

id <string> 

optional:
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The CMS account that the user authenticates with must be linked to the specified YouTube content owner.
onBehalfOfContentOwnerChannel <string> This parameter can only be used in a properly authorized request. *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwnerChannel* parameter specifies the YouTube channel ID of the channel to which a video is being added. This parameter is required when a request specifies a value for the onBehalfOfContentOwner parameter, and it can only be used in conjunction with that parameter. In addition, the request must be authorized using a CMS account that is linked to the content owner that the onBehalfOfContentOwner parameter specifies. Finally, the channel that the onBehalfOfContentOwnerChannel parameter value specifies must be linked to the content owner that the onBehalfOfContentOwner parameter specifies. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and perform actions on behalf of the channel specified in the parameter value, without having to provide authentication credentials for each separate channel."
  ([id] (liveStreams-delete id nil))
  ([id optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/liveStreams",
       :uri-template-args {},
       :query-params (merge {:id id} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"]})))

(defn liveStreams-list
  "Retrieve the list of streams associated with the given channel. --
https://developers.google.com/youtube/v3/docs/liveStreams/list

part <string> The *part* parameter specifies a comma-separated list of one or more liveStream resource properties that the API response will include. The part names that you can include in the parameter value are id, snippet, cdn, and status.

optional:
mine <boolean> 
onBehalfOfContentOwnerChannel <string> This parameter can only be used in a properly authorized request. *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwnerChannel* parameter specifies the YouTube channel ID of the channel to which a video is being added. This parameter is required when a request specifies a value for the onBehalfOfContentOwner parameter, and it can only be used in conjunction with that parameter. In addition, the request must be authorized using a CMS account that is linked to the content owner that the onBehalfOfContentOwner parameter specifies. Finally, the channel that the onBehalfOfContentOwnerChannel parameter value specifies must be linked to the content owner that the onBehalfOfContentOwner parameter specifies. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and perform actions on behalf of the channel specified in the parameter value, without having to provide authentication credentials for each separate channel.
id <string> Return LiveStreams with the given ids from Stubby or Apiary.
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The CMS account that the user authenticates with must be linked to the specified YouTube content owner.
maxResults <integer> The *maxResults* parameter specifies the maximum number of items that should be returned in the result set."
  ([part] (liveStreams-list part nil))
  ([part optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/liveStreams",
       :uri-template-args {},
       :query-params (merge {:part part} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtube.readonly"]})))

(defn liveStreams-update
  "Updates an existing stream for the authenticated user.
https://developers.google.com/youtube/v3/docs/liveStreams/update

part <string> The *part* parameter serves two purposes in this operation. It identifies the properties that the write operation will set as well as the properties that the API response will include. The part properties that you can include in the parameter value are id, snippet, cdn, and status. Note that this method will override the existing values for all of the mutable properties that are contained in any parts that the parameter value specifies. If the request body does not specify a value for a mutable property, the existing value for that property will be removed.
LiveStream:
{:id string,
 :cdn
 {:format string,
  :ingestionType [rtmp dash webrtc hls],
  :resolution [240p 360p 480p 720p 1080p 1440p 2160p variable],
  :ingestionInfo
  {:rtmpsIngestionAddress string,
   :backupIngestionAddress string,
   :rtmpsBackupIngestionAddress string,
   :streamName string,
   :ingestionAddress string},
  :frameRate [30fps 60fps variable]},
 :etag string,
 :kind string,
 :status
 {:healthStatus
  {:lastUpdateTimeSeconds string,
   :status [good ok bad noData revoked],
   :configurationIssues
   [{:description string,
     :type
     [gopSizeOver
      gopSizeLong
      gopSizeShort
      openGop
      badContainer
      audioBitrateHigh
      audioBitrateLow
      audioSampleRate
      bitrateHigh
      bitrateLow
      audioCodec
      videoCodec
      noAudioStream
      noVideoStream
      multipleVideoStreams
      multipleAudioStreams
      audioTooManyChannels
      interlacedVideo
      frameRateHigh
      resolutionMismatch
      videoCodecMismatch
      videoInterlaceMismatch
      videoProfileMismatch
      videoBitrateMismatch
      framerateMismatch
      gopMismatch
      audioSampleRateMismatch
      audioStereoMismatch
      audioCodecMismatch
      audioBitrateMismatch
      videoResolutionSuboptimal
      videoResolutionUnsupported
      videoIngestionStarved
      videoIngestionFasterThanRealtime],
     :reason string,
     :severity [info warning error]}]},
  :streamStatus [created ready active inactive error]},
 :snippet
 {:publishedAt string,
  :channelId string,
  :title string,
  :description string,
  :isDefaultStream boolean},
 :contentDetails
 {:closedCaptionsIngestionUrl string, :isReusable boolean}}

optional:
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The CMS account that the user authenticates with must be linked to the specified YouTube content owner.
onBehalfOfContentOwnerChannel <string> This parameter can only be used in a properly authorized request. *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwnerChannel* parameter specifies the YouTube channel ID of the channel to which a video is being added. This parameter is required when a request specifies a value for the onBehalfOfContentOwner parameter, and it can only be used in conjunction with that parameter. In addition, the request must be authorized using a CMS account that is linked to the content owner that the onBehalfOfContentOwner parameter specifies. Finally, the channel that the onBehalfOfContentOwnerChannel parameter value specifies must be linked to the content owner that the onBehalfOfContentOwner parameter specifies. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and perform actions on behalf of the channel specified in the parameter value, without having to provide authentication credentials for each separate channel."
  ([part LiveStream] (liveStreams-update part LiveStream nil))
  ([part LiveStream optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/liveStreams",
       :uri-template-args {},
       :query-params (merge {:part part} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"],
       :body LiveStream})))

(defn liveStreams-insert
  "Inserts a new stream for the authenticated user.
https://developers.google.com/youtube/v3/docs/liveStreams/insert

part <string> The *part* parameter serves two purposes in this operation. It identifies the properties that the write operation will set as well as the properties that the API response will include. The part properties that you can include in the parameter value are id, snippet, cdn, content_details, and status.
LiveStream:
{:id string,
 :cdn
 {:format string,
  :ingestionType [rtmp dash webrtc hls],
  :resolution [240p 360p 480p 720p 1080p 1440p 2160p variable],
  :ingestionInfo
  {:rtmpsIngestionAddress string,
   :backupIngestionAddress string,
   :rtmpsBackupIngestionAddress string,
   :streamName string,
   :ingestionAddress string},
  :frameRate [30fps 60fps variable]},
 :etag string,
 :kind string,
 :status
 {:healthStatus
  {:lastUpdateTimeSeconds string,
   :status [good ok bad noData revoked],
   :configurationIssues
   [{:description string,
     :type
     [gopSizeOver
      gopSizeLong
      gopSizeShort
      openGop
      badContainer
      audioBitrateHigh
      audioBitrateLow
      audioSampleRate
      bitrateHigh
      bitrateLow
      audioCodec
      videoCodec
      noAudioStream
      noVideoStream
      multipleVideoStreams
      multipleAudioStreams
      audioTooManyChannels
      interlacedVideo
      frameRateHigh
      resolutionMismatch
      videoCodecMismatch
      videoInterlaceMismatch
      videoProfileMismatch
      videoBitrateMismatch
      framerateMismatch
      gopMismatch
      audioSampleRateMismatch
      audioStereoMismatch
      audioCodecMismatch
      audioBitrateMismatch
      videoResolutionSuboptimal
      videoResolutionUnsupported
      videoIngestionStarved
      videoIngestionFasterThanRealtime],
     :reason string,
     :severity [info warning error]}]},
  :streamStatus [created ready active inactive error]},
 :snippet
 {:publishedAt string,
  :channelId string,
  :title string,
  :description string,
  :isDefaultStream boolean},
 :contentDetails
 {:closedCaptionsIngestionUrl string, :isReusable boolean}}

optional:
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The CMS account that the user authenticates with must be linked to the specified YouTube content owner.
onBehalfOfContentOwnerChannel <string> This parameter can only be used in a properly authorized request. *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwnerChannel* parameter specifies the YouTube channel ID of the channel to which a video is being added. This parameter is required when a request specifies a value for the onBehalfOfContentOwner parameter, and it can only be used in conjunction with that parameter. In addition, the request must be authorized using a CMS account that is linked to the content owner that the onBehalfOfContentOwner parameter specifies. Finally, the channel that the onBehalfOfContentOwnerChannel parameter value specifies must be linked to the content owner that the onBehalfOfContentOwner parameter specifies. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and perform actions on behalf of the channel specified in the parameter value, without having to provide authentication credentials for each separate channel."
  ([part LiveStream] (liveStreams-insert part LiveStream nil))
  ([part LiveStream optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/liveStreams",
       :uri-template-args {},
       :query-params (merge {:part part} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"],
       :body LiveStream})))

(defn liveChatMessages-insert
  "Inserts a new resource into this collection.
https://developers.google.com/youtube/v3/docs/liveChatMessages/insert

part <string> The *part* parameter serves two purposes. It identifies the properties that the write operation will set as well as the properties that the API response will include. Set the parameter value to snippet.
LiveChatMessage:
{:kind string,
 :snippet
 {:publishedAt string,
  :superChatDetails
  {:tier integer,
   :amountDisplayString string,
   :amountMicros string,
   :userComment string,
   :currency string},
  :messageDeletedDetails {:deletedMessageId string},
  :hasDisplayContent boolean,
  :superStickerDetails
  {:tier integer,
   :amountMicros string,
   :currency string,
   :amountDisplayString string,
   :superStickerMetadata
   {:altText string, :altTextLanguage string, :stickerId string}},
  :type
  [invalidType
   textMessageEvent
   tombstone
   fanFundingEvent
   chatEndedEvent
   sponsorOnlyModeStartedEvent
   sponsorOnlyModeEndedEvent
   newSponsorEvent
   memberMilestoneChatEvent
   membershipGiftingEvent
   giftMembershipReceivedEvent
   messageDeletedEvent
   messageRetractedEvent
   userBannedEvent
   superChatEvent
   superStickerEvent
   pollEvent],
  :newSponsorDetails {:isUpgrade boolean, :memberLevelName string},
  :pollDetails
  {:status [unknown active closed],
   :metadata
   {:questionText string,
    :options [{:optionText string, :tally string}]}},
  :giftMembershipReceivedDetails
  {:memberLevelName string,
   :gifterChannelId string,
   :associatedMembershipGiftingMessageId string},
  :fanFundingEventDetails
  {:amountMicros string,
   :userComment string,
   :amountDisplayString string,
   :currency string},
  :memberMilestoneChatDetails
  {:memberLevelName string, :userComment string, :memberMonth integer},
  :textMessageDetails {:messageText string},
  :authorChannelId string,
  :userBannedDetails
  {:banDurationSeconds string,
   :bannedUserDetails
   {:channelId string,
    :profileImageUrl string,
    :displayName string,
    :channelUrl string},
   :banType [permanent temporary]},
  :liveChatId string,
  :displayMessage string,
  :messageRetractedDetails {:retractedMessageId string},
  :membershipGiftingDetails
  {:giftMembershipsCount integer, :giftMembershipsLevelName string}},
 :authorDetails
 {:channelUrl string,
  :isVerified boolean,
  :isChatOwner boolean,
  :channelId string,
  :displayName string,
  :isChatModerator boolean,
  :isChatSponsor boolean,
  :profileImageUrl string},
 :etag string,
 :id string}"
  [part LiveChatMessage]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://youtube.googleapis.com/youtube/v3/liveChat/messages",
     :uri-template-args {},
     :query-params {:part part},
     :scopes
     ["https://www.googleapis.com/auth/youtube"
      "https://www.googleapis.com/auth/youtube.force-ssl"],
     :body LiveChatMessage}))

(defn liveChatMessages-delete
  "Deletes a chat message.
https://developers.google.com/youtube/v3/docs/liveChatMessages/delete

id <string> "
  [id]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://youtube.googleapis.com/youtube/v3/liveChat/messages",
     :uri-template-args {},
     :query-params {:id id},
     :scopes
     ["https://www.googleapis.com/auth/youtube"
      "https://www.googleapis.com/auth/youtube.force-ssl"]}))

(defn liveChatMessages-transition
  "Transition a durable chat event.
https://developers.google.com/youtube/v3/docs/liveChatMessages/transition

optional:
status <string> The status to which the chat event is going to transition.
id <string> The ID that uniquely identify the chat message event to transition."
  ([] (liveChatMessages-transition nil))
  ([optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/liveChat/messages/transition",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"]})))

(defn liveChatMessages-list
  "Retrieves a list of resources, possibly filtered.
https://developers.google.com/youtube/v3/docs/liveChatMessages/list

liveChatId <string> The id of the live chat for which comments should be returned.
part <string> The *part* parameter specifies the liveChatComment resource parts that the API response will include. Supported values are id and snippet.

optional:
maxResults <integer> The *maxResults* parameter specifies the maximum number of items that should be returned in the result set.
hl <string> Specifies the localization language in which the system messages should be returned.
profileImageSize <integer> Specifies the size of the profile image that should be returned for each user."
  ([liveChatId part] (liveChatMessages-list liveChatId part nil))
  ([liveChatId part optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/liveChat/messages",
       :uri-template-args {},
       :query-params
       (merge {:part part, :liveChatId liveChatId} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtube.readonly"]})))

(defn videoCategories-list
  "Retrieves a list of resources, possibly filtered.
https://developers.google.com/youtube/v3/docs/videoCategories/list

part <string> The *part* parameter specifies the videoCategory resource properties that the API response will include. Set the parameter value to snippet.

optional:
regionCode <string> 
hl <string> 
id <string> Returns the video categories with the given IDs for Stubby or Apiary."
  ([part] (videoCategories-list part nil))
  ([part optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/videoCategories",
       :uri-template-args {},
       :query-params (merge {:part part} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtube.readonly"
        "https://www.googleapis.com/auth/youtubepartner"]})))

(defn youtube-v3-updateCommentThreads
  "Updates an existing resource.
https://developers.google.com/youtube/v3/docs/youtube/v3/updateCommentThreads

CommentThread:
{:etag string,
 :snippet
 {:channelId string,
  :isPublic boolean,
  :canReply boolean,
  :topLevelComment
  {:etag string,
   :snippet
   {:authorProfileImageUrl string,
    :likeCount integer,
    :publishedAt string,
    :canRate boolean,
    :viewerRating [none like dislike],
    :updatedAt string,
    :authorChannelUrl string,
    :textOriginal string,
    :channelId string,
    :authorDisplayName string,
    :textDisplay string,
    :authorChannelId {:value string},
    :videoId string,
    :parentId string,
    :moderationStatus [published heldForReview likelySpam rejected]},
   :id string,
   :kind string},
  :totalReplyCount integer,
  :videoId string},
 :id string,
 :replies
 {:comments
  [{:etag string,
    :snippet
    {:authorProfileImageUrl string,
     :likeCount integer,
     :publishedAt string,
     :canRate boolean,
     :viewerRating [none like dislike],
     :updatedAt string,
     :authorChannelUrl string,
     :textOriginal string,
     :channelId string,
     :authorDisplayName string,
     :textDisplay string,
     :authorChannelId {:value string},
     :videoId string,
     :parentId string,
     :moderationStatus [published heldForReview likelySpam rejected]},
    :id string,
    :kind string}]},
 :kind string}

optional:
part <string> The *part* parameter specifies a comma-separated list of commentThread resource properties that the API response will include. You must at least include the snippet part in the parameter value since that part contains all of the properties that the API request can update."
  ([CommentThread] (youtube-v3-updateCommentThreads CommentThread nil))
  ([CommentThread optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/commentThreads",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes nil,
       :body CommentThread})))

(defn membershipsLevels-list
  "Retrieves a list of all pricing levels offered by a creator to the fans.
https://developers.google.com/youtube/v3/docs/membershipsLevels/list

part <string> The *part* parameter specifies the membershipsLevel resource parts that the API response will include. Supported values are id and snippet."
  [part]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://youtube.googleapis.com/youtube/v3/membershipsLevels",
     :uri-template-args {},
     :query-params {:part part},
     :scopes
     ["https://www.googleapis.com/auth/youtube.channel-memberships.creator"]}))

(defn channels-update
  "Updates an existing resource.
https://developers.google.com/youtube/v3/docs/channels/update

part <string> The *part* parameter serves two purposes in this operation. It identifies the properties that the write operation will set as well as the properties that the API response will include. The API currently only allows the parameter value to be set to either brandingSettings or invideoPromotion. (You cannot update both of those parts with a single request.) Note that this method overrides the existing values for all of the mutable properties that are contained in any parts that the parameter value specifies.
Channel:
{:contentOwnerDetails {:contentOwner string, :timeLinked string},
 :localizations object,
 :brandingSettings
 {:watch
  {:featuredPlaylistId string,
   :textColor string,
   :backgroundColor string},
  :channel
  {:description string,
   :showBrowseView boolean,
   :keywords string,
   :title string,
   :trackingAnalyticsAccountId string,
   :defaultTab string,
   :featuredChannelsTitle string,
   :profileColor string,
   :unsubscribedTrailer string,
   :moderateComments boolean,
   :country string,
   :showRelatedChannels boolean,
   :defaultLanguage string,
   :featuredChannelsUrls [string]},
  :image
  {:bannerTabletExtraHdImageUrl string,
   :bannerTvMediumImageUrl string,
   :smallBrandedBannerImageUrl
   {:localized [{:language string, :value string}],
    :defaultLanguage {:value string},
    :default string},
   :bannerMobileMediumHdImageUrl string,
   :bannerTabletLowImageUrl string,
   :bannerMobileExtraHdImageUrl string,
   :bannerTabletHdImageUrl string,
   :bannerMobileLowImageUrl string,
   :bannerImageUrl string,
   :backgroundImageUrl
   {:localized [{:language string, :value string}],
    :defaultLanguage {:value string},
    :default string},
   :smallBrandedBannerImageImapScript
   {:localized [{:language string, :value string}],
    :defaultLanguage {:value string},
    :default string},
   :bannerExternalUrl string,
   :bannerTvHighImageUrl string,
   :largeBrandedBannerImageImapScript
   {:localized [{:language string, :value string}],
    :defaultLanguage {:value string},
    :default string},
   :bannerMobileImageUrl string,
   :largeBrandedBannerImageUrl
   {:localized [{:language string, :value string}],
    :defaultLanguage {:value string},
    :default string},
   :bannerMobileHdImageUrl string,
   :bannerTabletImageUrl string,
   :bannerTvImageUrl string,
   :watchIconImageUrl string,
   :trackingImageUrl string,
   :bannerTvLowImageUrl string},
  :hints [{:value string, :property string}]},
 :snippet
 {:defaultLanguage string,
  :localized {:title string, :description string},
  :title string,
  :publishedAt string,
  :customUrl string,
  :description string,
  :country string,
  :thumbnails
  {:high {:width integer, :height integer, :url string},
   :default {:width integer, :height integer, :url string},
   :maxres {:width integer, :height integer, :url string},
   :medium {:width integer, :height integer, :url string},
   :standard {:width integer, :height integer, :url string}}},
 :etag string,
 :auditDetails
 {:communityGuidelinesGoodStanding boolean,
  :copyrightStrikesGoodStanding boolean,
  :contentIdClaimsGoodStanding boolean},
 :conversionPings
 {:pings
  [{:context [subscribe unsubscribe cview], :conversionUrl string}]},
 :statistics
 {:hiddenSubscriberCount boolean,
  :videoCount string,
  :subscriberCount string,
  :commentCount string,
  :viewCount string},
 :status
 {:privacyStatus [public unlisted private],
  :isLinked boolean,
  :madeForKids boolean,
  :selfDeclaredMadeForKids boolean,
  :longUploadsStatus
  [longUploadsUnspecified allowed eligible disallowed]},
 :id string,
 :kind string,
 :contentDetails
 {:relatedPlaylists
  {:watchLater string,
   :likes string,
   :watchHistory string,
   :favorites string,
   :uploads string}},
 :topicDetails {:topicCategories [string], :topicIds [string]}}

optional:
onBehalfOfContentOwner <string> The *onBehalfOfContentOwner* parameter indicates that the authenticated user is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The actual CMS account that the user authenticates with needs to be linked to the specified YouTube content owner."
  ([part Channel] (channels-update part Channel nil))
  ([part Channel optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/channels",
       :uri-template-args {},
       :query-params (merge {:part part} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtubepartner"],
       :body Channel})))

(defn channels-list
  "Retrieves a list of resources, possibly filtered.
https://developers.google.com/youtube/v3/docs/channels/list

part <string> The *part* parameter specifies a comma-separated list of one or more channel resource properties that the API response will include. If the parameter identifies a property that contains child properties, the child properties will be included in the response. For example, in a channel resource, the contentDetails property contains other properties, such as the uploads properties. As such, if you set *part=contentDetails*, the API response will also contain all of those nested properties.

optional:
managedByMe <boolean> Return the channels managed by the authenticated user.
categoryId <string> Return the channels within the specified guide category ID.
forUsername <string> Return the channel associated with a YouTube username.
mine <boolean> Return the ids of channels owned by the authenticated user.
hl <string> Stands for \"host language\". Specifies the localization language of the metadata to be filled into snippet.localized. The field is filled with the default metadata if there is no localization in the specified language. The parameter value must be a language code included in the list returned by the i18nLanguages.list method (e.g. en_US, es_MX).
id <string> Return the channels with the specified IDs.
forHandle <string> Return the channel associated with a YouTube handle.
mySubscribers <boolean> Return the channels subscribed to the authenticated user
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The CMS account that the user authenticates with must be linked to the specified YouTube content owner.
maxResults <integer> The *maxResults* parameter specifies the maximum number of items that should be returned in the result set."
  ([part] (channels-list part nil))
  ([part optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/channels",
       :uri-template-args {},
       :query-params (merge {:part part} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtube.readonly"
        "https://www.googleapis.com/auth/youtubepartner"
        "https://www.googleapis.com/auth/youtubepartner-channel-audit"]})))

(defn videoAbuseReportReasons-list
  "Retrieves a list of resources, possibly filtered.
https://developers.google.com/youtube/v3/docs/videoAbuseReportReasons/list

part <string> The *part* parameter specifies the videoCategory resource parts that the API response will include. Supported values are id and snippet.

optional:
hl <string> "
  ([part] (videoAbuseReportReasons-list part nil))
  ([part optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/videoAbuseReportReasons",
       :uri-template-args {},
       :query-params (merge {:part part} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtube.readonly"]})))

(defn tests-insert
  "POST method.
https://developers.google.com/youtube/v3/docs/tests/insert

part <string> 
TestItem:
{:gaia string, :snippet object, :id string, :featuredPart boolean}

optional:
externalChannelId <string> "
  ([part TestItem] (tests-insert part TestItem nil))
  ([part TestItem optional]
    (client/api-request
      {:method "POST",
       :uri-template "https://youtube.googleapis.com/youtube/v3/tests",
       :uri-template-args {},
       :query-params (merge {:part part} optional),
       :scopes ["https://www.googleapis.com/auth/youtube.readonly"],
       :body TestItem})))

(defn i18nRegions-list
  "Retrieves a list of resources, possibly filtered.
https://developers.google.com/youtube/v3/docs/i18nRegions/list

part <string> The *part* parameter specifies the i18nRegion resource properties that the API response will include. Set the parameter value to snippet.

optional:
hl <string> "
  ([part] (i18nRegions-list part nil))
  ([part optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/i18nRegions",
       :uri-template-args {},
       :query-params (merge {:part part} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtube.readonly"
        "https://www.googleapis.com/auth/youtubepartner"]})))

(defn comments-setModerationStatus
  "Sets the moderation status of one or more comments.
https://developers.google.com/youtube/v3/docs/comments/setModerationStatus

id <string> Modifies the moderation status of the comments with the given IDs
moderationStatus <string> Specifies the requested moderation status. Note, comments can be in statuses, which are not available through this call. For example, this call does not allow to mark a comment as 'likely spam'. Valid values: 'heldForReview', 'published' or 'rejected'.

optional:
banAuthor <boolean> If set to true the author of the comment gets added to the ban list. This means all future comments of the author will autmomatically be rejected. Only valid in combination with STATUS_REJECTED."
  ([id moderationStatus]
    (comments-setModerationStatus id moderationStatus nil))
  ([id moderationStatus optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/comments/setModerationStatus",
       :uri-template-args {},
       :query-params
       (merge {:id id, :moderationStatus moderationStatus} optional),
       :scopes ["https://www.googleapis.com/auth/youtube.force-ssl"]})))

(defn comments-delete
  "Deletes a resource.
https://developers.google.com/youtube/v3/docs/comments/delete

id <string> "
  [id]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://youtube.googleapis.com/youtube/v3/comments",
     :uri-template-args {},
     :query-params {:id id},
     :scopes ["https://www.googleapis.com/auth/youtube.force-ssl"]}))

(defn comments-list
  "Retrieves a list of resources, possibly filtered.
https://developers.google.com/youtube/v3/docs/comments/list

part <string> The *part* parameter specifies a comma-separated list of one or more comment resource properties that the API response will include.

optional:
maxResults <integer> The *maxResults* parameter specifies the maximum number of items that should be returned in the result set.
textFormat <string> The requested text format for the returned comments.
parentId <string> Returns replies to the specified comment. Note, currently YouTube features only one level of replies (ie replies to top level comments). However replies to replies may be supported in the future.
id <string> Returns the comments with the given IDs for One Platform."
  ([part] (comments-list part nil))
  ([part optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/comments",
       :uri-template-args {},
       :query-params (merge {:part part} optional),
       :scopes ["https://www.googleapis.com/auth/youtube.force-ssl"]})))

(defn comments-insert
  "Inserts a new resource into this collection.
https://developers.google.com/youtube/v3/docs/comments/insert

part <string> The *part* parameter identifies the properties that the API response will include. Set the parameter value to snippet. The snippet part has a quota cost of 2 units.
Comment:
{:etag string,
 :snippet
 {:authorProfileImageUrl string,
  :likeCount integer,
  :publishedAt string,
  :canRate boolean,
  :viewerRating [none like dislike],
  :updatedAt string,
  :authorChannelUrl string,
  :textOriginal string,
  :channelId string,
  :authorDisplayName string,
  :textDisplay string,
  :authorChannelId {:value string},
  :videoId string,
  :parentId string,
  :moderationStatus [published heldForReview likelySpam rejected]},
 :id string,
 :kind string}"
  [part Comment]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://youtube.googleapis.com/youtube/v3/comments",
     :uri-template-args {},
     :query-params {:part part},
     :scopes ["https://www.googleapis.com/auth/youtube.force-ssl"],
     :body Comment}))

(defn comments-update
  "Updates an existing resource.
https://developers.google.com/youtube/v3/docs/comments/update

part <string> The *part* parameter identifies the properties that the API response will include. You must at least include the snippet part in the parameter value since that part contains all of the properties that the API request can update.
Comment:
{:etag string,
 :snippet
 {:authorProfileImageUrl string,
  :likeCount integer,
  :publishedAt string,
  :canRate boolean,
  :viewerRating [none like dislike],
  :updatedAt string,
  :authorChannelUrl string,
  :textOriginal string,
  :channelId string,
  :authorDisplayName string,
  :textDisplay string,
  :authorChannelId {:value string},
  :videoId string,
  :parentId string,
  :moderationStatus [published heldForReview likelySpam rejected]},
 :id string,
 :kind string}"
  [part Comment]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://youtube.googleapis.com/youtube/v3/comments",
     :uri-template-args {},
     :query-params {:part part},
     :scopes ["https://www.googleapis.com/auth/youtube.force-ssl"],
     :body Comment}))

(defn comments-markAsSpam
  "Expresses the caller's opinion that one or more comments should be flagged as spam.
https://developers.google.com/youtube/v3/docs/comments/markAsSpam

id <string> Flags the comments with the given IDs as spam in the caller's opinion."
  [id]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://youtube.googleapis.com/youtube/v3/comments/markAsSpam",
     :uri-template-args {},
     :query-params {:id id},
     :scopes ["https://www.googleapis.com/auth/youtube.force-ssl"]}))

(defn videos-list
  "Retrieves a list of resources, possibly filtered.
https://developers.google.com/youtube/v3/docs/videos/list

part <string> The *part* parameter specifies a comma-separated list of one or more video resource properties that the API response will include. If the parameter identifies a property that contains child properties, the child properties will be included in the response. For example, in a video resource, the snippet property contains the channelId, title, description, tags, and categoryId properties. As such, if you set *part=snippet*, the API response will contain all of those properties.

optional:
maxHeight <integer> 
maxWidth <integer> Return the player with maximum height specified in
locale <string> 
chart <string> Return the videos that are in the specified chart.
hl <string> Stands for \"host language\". Specifies the localization language of the metadata to be filled into snippet.localized. The field is filled with the default metadata if there is no localization in the specified language. The parameter value must be a language code included in the list returned by the i18nLanguages.list method (e.g. en_US, es_MX).
id <string> Return videos with the given ids.
regionCode <string> Use a chart that is specific to the specified region
myRating <string> Return videos liked/disliked by the authenticated user. Does not support RateType.RATED_TYPE_NONE.
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The CMS account that the user authenticates with must be linked to the specified YouTube content owner.
maxResults <integer> The *maxResults* parameter specifies the maximum number of items that should be returned in the result set. *Note:* This parameter is supported for use in conjunction with the myRating and chart parameters, but it is not supported for use in conjunction with the id parameter.
videoCategoryId <string> Use chart that is specific to the specified video category"
  ([part] (videos-list part nil))
  ([part optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/videos",
       :uri-template-args {},
       :query-params (merge {:part part} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtube.readonly"
        "https://www.googleapis.com/auth/youtubepartner"]})))

(defn videos-getRating
  "Retrieves the ratings that the authorized user gave to a list of specified videos.
https://developers.google.com/youtube/v3/docs/videos/getRating

id <string> 

optional:
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The CMS account that the user authenticates with must be linked to the specified YouTube content owner."
  ([id] (videos-getRating id nil))
  ([id optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/videos/getRating",
       :uri-template-args {},
       :query-params (merge {:id id} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtubepartner"]})))

(defn videos-reportAbuse
  "Report abuse for a video.
https://developers.google.com/youtube/v3/docs/videos/reportAbuse

VideoAbuseReport:
{:secondaryReasonId string,
 :videoId string,
 :reasonId string,
 :comments string,
 :language string}

optional:
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The CMS account that the user authenticates with must be linked to the specified YouTube content owner."
  ([VideoAbuseReport] (videos-reportAbuse VideoAbuseReport nil))
  ([VideoAbuseReport optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/videos/reportAbuse",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtubepartner"],
       :body VideoAbuseReport})))

(defn videos-rate
  "Adds a like or dislike rating to a video or removes a rating from a video.
https://developers.google.com/youtube/v3/docs/videos/rate

id <string> 
rating <string> "
  [id rating]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://youtube.googleapis.com/youtube/v3/videos/rate",
     :uri-template-args {},
     :query-params {:id id, :rating rating},
     :scopes
     ["https://www.googleapis.com/auth/youtube"
      "https://www.googleapis.com/auth/youtube.force-ssl"
      "https://www.googleapis.com/auth/youtubepartner"]}))

(defn videos-insert
  "Inserts a new resource into this collection.
https://developers.google.com/youtube/v3/docs/videos/insert

part <string> The *part* parameter serves two purposes in this operation. It identifies the properties that the write operation will set as well as the properties that the API response will include. Note that not all parts contain properties that can be set when inserting or updating a video. For example, the statistics object encapsulates statistics that YouTube calculates for a video and does not contain values that you can set or modify. If the parameter value specifies a part that does not contain mutable values, that part will still be included in the API response.
Video:
{:monetizationDetails
 {:access {:exception [string], :allowed boolean}},
 :localizations object,
 :snippet
 {:description string,
  :tags [string],
  :publishedAt string,
  :channelId string,
  :categoryId string,
  :thumbnails
  {:high {:width integer, :height integer, :url string},
   :default {:width integer, :height integer, :url string},
   :maxres {:width integer, :height integer, :url string},
   :medium {:width integer, :height integer, :url string},
   :standard {:width integer, :height integer, :url string}},
  :title string,
  :defaultAudioLanguage string,
  :liveBroadcastContent [none upcoming live completed],
  :localized {:description string, :title string},
  :channelTitle string,
  :defaultLanguage string},
 :fileDetails
 {:creationTime string,
  :fileSize string,
  :fileType [video audio image archive document project other],
  :fileName string,
  :bitrateBps string,
  :videoStreams
  [{:vendor string,
    :rotation [none clockwise upsideDown counterClockwise other],
    :heightPixels integer,
    :frameRateFps number,
    :widthPixels integer,
    :codec string,
    :aspectRatio number,
    :bitrateBps string}],
  :container string,
  :durationMs string,
  :audioStreams
  [{:codec string,
    :bitrateBps string,
    :channelCount integer,
    :vendor string}]},
 :etag string,
 :recordingDetails
 {:location {:latitude number, :longitude number, :altitude number},
  :locationDescription string,
  :recordingDate string},
 :statistics
 {:commentCount string,
  :favoriteCount string,
  :dislikeCount string,
  :likeCount string,
  :viewCount string},
 :ageGating
 {:restricted boolean,
  :alcoholContent boolean,
  :videoGameRating [anyone m15Plus m16Plus m17Plus]},
 :status
 {:uploadStatus [uploaded processed failed rejected deleted],
  :publicStatsViewable boolean,
  :license [youtube creativeCommon],
  :embeddable boolean,
  :publishAt string,
  :madeForKids boolean,
  :privacyStatus [public unlisted private],
  :failureReason
  [conversion invalidFile emptyFile tooSmall codec uploadAborted],
  :rejectionReason
  [copyright
   inappropriate
   duplicate
   termsOfUse
   uploaderAccountSuspended
   length
   claim
   uploaderAccountClosed
   trademark
   legal],
  :selfDeclaredMadeForKids boolean},
 :processingDetails
 {:fileDetailsAvailability string,
  :thumbnailsAvailability string,
  :processingFailureReason
  [uploadFailed transcodeFailed streamingFailed other],
  :tagSuggestionsAvailability string,
  :processingProgress
  {:timeLeftMs string, :partsProcessed string, :partsTotal string},
  :processingStatus [processing succeeded failed terminated],
  :processingIssuesAvailability string,
  :editorSuggestionsAvailability string},
 :id string,
 :kind string,
 :liveStreamingDetails
 {:activeLiveChatId string,
  :actualStartTime string,
  :scheduledEndTime string,
  :actualEndTime string,
  :scheduledStartTime string,
  :concurrentViewers string},
 :suggestions
 {:processingHints
  [[nonStreamableMov
    sendBestQualityVideo
    sphericalVideo
    spatialAudio
    vrVideo
    hdrVideo]],
  :processingErrors
  [[audioFile
    imageFile
    projectFile
    notAVideoFile
    docFile
    archiveFile
    unsupportedSpatialAudioLayout]],
  :tagSuggestions [{:tag string, :categoryRestricts [string]}],
  :processingWarnings
  [[unknownContainer
    unknownVideoCodec
    unknownAudioCodec
    inconsistentResolution
    hasEditlist
    problematicVideoCodec
    problematicAudioCodec
    unsupportedVrStereoMode
    unsupportedSphericalProjectionType
    unsupportedHdrPixelFormat
    unsupportedHdrColorMetadata
    problematicHdrLookupTable]],
  :editorSuggestions
  [[videoAutoLevels videoStabilize videoCrop audioQuietAudioSwap]]},
 :contentDetails
 {:caption [true false],
  :definition [sd hd],
  :licensedContent boolean,
  :duration string,
  :contentRating
  {:mccypRating
   [mccypUnspecified mccypA mccyp7 mccyp11 mccyp15 mccypUnrated],
   :menaMpaaRating
   [menaMpaaUnspecified
    menaMpaaG
    menaMpaaPg
    menaMpaaPg13
    menaMpaaR
    menaMpaaUnrated],
   :ilfilmRating
   [ilfilmUnspecified
    ilfilmAa
    ilfilm12
    ilfilm14
    ilfilm16
    ilfilm18
    ilfilmUnrated],
   :lsfRating
   [lsfUnspecified
    lsfSu
    lsfA
    lsfBo
    lsf13
    lsfR
    lsf17
    lsfD
    lsf21
    lsfUnrated],
   :mccaaRating
   [mccaaUnspecified
    mccaaU
    mccaaPg
    mccaa12a
    mccaa12
    mccaa14
    mccaa15
    mccaa16
    mccaa18
    mccaaUnrated],
   :fskRating [fskUnspecified fsk0 fsk6 fsk12 fsk16 fsk18 fskUnrated],
   :mtrcbRating
   [mtrcbUnspecified
    mtrcbG
    mtrcbPg
    mtrcbR13
    mtrcbR16
    mtrcbR18
    mtrcbX
    mtrcbUnrated],
   :grfilmRating
   [grfilmUnspecified
    grfilmK
    grfilmE
    grfilmK12
    grfilmK13
    grfilmK15
    grfilmK17
    grfilmK18
    grfilmUnrated],
   :kijkwijzerRating
   [kijkwijzerUnspecified
    kijkwijzerAl
    kijkwijzer6
    kijkwijzer9
    kijkwijzer12
    kijkwijzer16
    kijkwijzer18
    kijkwijzerUnrated],
   :czfilmRating
   [czfilmUnspecified
    czfilmU
    czfilm12
    czfilm14
    czfilm18
    czfilmUnrated],
   :incaaRating
   [incaaUnspecified
    incaaAtp
    incaaSam13
    incaaSam16
    incaaSam18
    incaaC
    incaaUnrated],
   :resorteviolenciaRating
   [resorteviolenciaUnspecified
    resorteviolenciaA
    resorteviolenciaB
    resorteviolenciaC
    resorteviolenciaD
    resorteviolenciaE
    resorteviolenciaUnrated],
   :eefilmRating
   [eefilmUnspecified
    eefilmPere
    eefilmL
    eefilmMs6
    eefilmK6
    eefilmMs12
    eefilmK12
    eefilmK14
    eefilmK16
    eefilmUnrated],
   :cnaRating
   [cnaUnspecified cnaAp cna12 cna15 cna18 cna18plus cnaUnrated],
   :moctwRating
   [moctwUnspecified
    moctwG
    moctwP
    moctwPg
    moctwR
    moctwUnrated
    moctwR12
    moctwR15],
   :tvpgRating
   [tvpgUnspecified
    tvpgY
    tvpgY7
    tvpgY7Fv
    tvpgG
    tvpgPg
    pg14
    tvpgMa
    tvpgUnrated],
   :bfvcRating
   [bfvcUnspecified
    bfvcG
    bfvcE
    bfvc13
    bfvc15
    bfvc18
    bfvc20
    bfvcB
    bfvcUnrated],
   :bmukkRating
   [bmukkUnspecified
    bmukkAa
    bmukk6
    bmukk8
    bmukk10
    bmukk12
    bmukk14
    bmukk16
    bmukkUnrated],
   :cceRating
   [cceUnspecified cceM4 cceM6 cceM12 cceM16 cceM18 cceUnrated cceM14],
   :cncRating
   [cncUnspecified
    cncT
    cnc10
    cnc12
    cnc16
    cnc18
    cncE
    cncInterdiction
    cncUnrated],
   :fcoRating
   [fcoUnspecified fcoI fcoIia fcoIib fcoIi fcoIii fcoUnrated],
   :ifcoRating
   [ifcoUnspecified
    ifcoG
    ifcoPg
    ifco12
    ifco12a
    ifco15
    ifco15a
    ifco16
    ifco18
    ifcoUnrated],
   :oflcRating
   [oflcUnspecified
    oflcG
    oflcPg
    oflcM
    oflcR13
    oflcR15
    oflcR16
    oflcR18
    oflcUnrated
    oflcRp13
    oflcRp16
    oflcRp18],
   :chvrsRating
   [chvrsUnspecified
    chvrsG
    chvrsPg
    chvrs14a
    chvrs18a
    chvrsR
    chvrsE
    chvrsUnrated],
   :cbfcRating
   [cbfcUnspecified
    cbfcU
    cbfcUA
    cbfcUA7plus
    cbfcUA13plus
    cbfcUA16plus
    cbfcA
    cbfcS
    cbfcUnrated],
   :csaRating
   [csaUnspecified
    csaT
    csa10
    csa12
    csa16
    csa18
    csaInterdiction
    csaUnrated],
   :icaaRating
   [icaaUnspecified
    icaaApta
    icaa7
    icaa12
    icaa13
    icaa16
    icaa18
    icaaX
    icaaUnrated],
   :djctqRatingReasons
   [[djctqRatingReasonUnspecified
     djctqViolence
     djctqExtremeViolence
     djctqSexualContent
     djctqNudity
     djctqSex
     djctqExplicitSex
     djctqDrugs
     djctqLegalDrugs
     djctqIllegalDrugs
     djctqInappropriateLanguage
     djctqCriminalActs
     djctqImpactingContent]],
   :fcbmRating
   [fcbmUnspecified
    fcbmU
    fcbmPg13
    fcbmP13
    fcbm18
    fcbm18sx
    fcbm18pa
    fcbm18sg
    fcbm18pl
    fcbmUnrated],
   :pefilmRating
   [pefilmUnspecified
    pefilmPt
    pefilmPg
    pefilm14
    pefilm18
    pefilmUnrated],
   :ytRating [ytUnspecified ytAgeRestricted],
   :nfvcbRating
   [nfvcbUnspecified
    nfvcbG
    nfvcbPg
    nfvcb12
    nfvcb12a
    nfvcb15
    nfvcb18
    nfvcbRe
    nfvcbUnrated],
   :cscfRating
   [cscfUnspecified
    cscfAl
    cscfA
    cscf6
    cscf9
    cscf12
    cscf16
    cscf18
    cscfUnrated],
   :djctqRating
   [djctqUnspecified
    djctqL
    djctq10
    djctq12
    djctq14
    djctq16
    djctq18
    djctqEr
    djctqL10
    djctqL12
    djctqL14
    djctqL16
    djctqL18
    djctq1012
    djctq1014
    djctq1016
    djctq1018
    djctq1214
    djctq1216
    djctq1218
    djctq1416
    djctq1418
    djctq1618
    djctqUnrated],
   :kmrbRating
   [kmrbUnspecified
    kmrbAll
    kmrb12plus
    kmrb15plus
    kmrbTeenr
    kmrbR
    kmrbUnrated],
   :smaisRating
   [smaisUnspecified
    smaisL
    smais7
    smais12
    smais14
    smais16
    smais18
    smaisUnrated],
   :bbfcRating
   [bbfcUnspecified
    bbfcU
    bbfcPg
    bbfc12a
    bbfc12
    bbfc15
    bbfc18
    bbfcR18
    bbfcUnrated],
   :skfilmRating
   [skfilmUnspecified
    skfilmG
    skfilmP2
    skfilmP5
    skfilmP8
    skfilmUnrated],
   :nbcRating
   [nbcUnspecified
    nbcG
    nbcPg
    nbc12plus
    nbc15plus
    nbc18plus
    nbc18plusr
    nbcPu
    nbcUnrated],
   :eirinRating
   [eirinUnspecified
    eirinG
    eirinPg12
    eirinR15plus
    eirinR18plus
    eirinUnrated],
   :nkclvRating
   [nkclvUnspecified
    nkclvU
    nkclv7plus
    nkclv12plus
    nkclv16plus
    nkclv18plus
    nkclvUnrated],
   :mocRating
   [mocUnspecified
    mocE
    mocT
    moc7
    moc12
    moc15
    moc18
    mocX
    mocBanned
    mocUnrated],
   :smsaRating [smsaUnspecified smsaA smsa7 smsa11 smsa15 smsaUnrated],
   :medietilsynetRating
   [medietilsynetUnspecified
    medietilsynetA
    medietilsynet6
    medietilsynet7
    medietilsynet9
    medietilsynet11
    medietilsynet12
    medietilsynet15
    medietilsynet18
    medietilsynetUnrated],
   :mpaaRating
   [mpaaUnspecified
    mpaaG
    mpaaPg
    mpaaPg13
    mpaaR
    mpaaNc17
    mpaaX
    mpaaUnrated],
   :mekuRating
   [mekuUnspecified mekuS meku7 meku12 meku16 meku18 mekuUnrated],
   :ecbmctRating
   [ecbmctUnspecified
    ecbmctG
    ecbmct7a
    ecbmct7plus
    ecbmct13a
    ecbmct13plus
    ecbmct15a
    ecbmct15plus
    ecbmct18plus
    ecbmctUnrated],
   :rteRating [rteUnspecified rteGa rteCh rtePs rteMa rteUnrated],
   :mibacRating
   [mibacUnspecified
    mibacT
    mibacVap
    mibacVm6
    mibacVm12
    mibacVm14
    mibacVm16
    mibacVm18
    mibacUnrated],
   :mdaRating
   [mdaUnspecified
    mdaG
    mdaPg
    mdaPg13
    mdaNc16
    mdaM18
    mdaR21
    mdaUnrated],
   :nmcRating
   [nmcUnspecified
    nmcG
    nmcPg
    nmcPg13
    nmcPg15
    nmc15plus
    nmc18plus
    nmc18tc
    nmcUnrated],
   :chfilmRating
   [chfilmUnspecified
    chfilm0
    chfilm6
    chfilm12
    chfilm16
    chfilm18
    chfilmUnrated],
   :rcnofRating
   [rcnofUnspecified
    rcnofI
    rcnofIi
    rcnofIii
    rcnofIv
    rcnofV
    rcnofVi
    rcnofUnrated],
   :egfilmRating
   [egfilmUnspecified egfilmGn egfilm18 egfilmBn egfilmUnrated],
   :anatelRating
   [anatelUnspecified
    anatelF
    anatelI
    anatelI7
    anatelI10
    anatelI12
    anatelR
    anatelA
    anatelUnrated],
   :catvfrRating
   [catvfrUnspecified
    catvfrG
    catvfr8plus
    catvfr13plus
    catvfr16plus
    catvfr18plus
    catvfrUnrated
    catvfrE],
   :acbRating
   [acbUnspecified
    acbE
    acbP
    acbC
    acbG
    acbPg
    acbM
    acbMa15plus
    acbR18plus
    acbUnrated],
   :rtcRating
   [rtcUnspecified rtcAa rtcA rtcB rtcB15 rtcC rtcD rtcUnrated],
   :russiaRating
   [russiaUnspecified
    russia0
    russia6
    russia12
    russia16
    russia18
    russiaUnrated],
   :cccRating
   [cccUnspecified cccTe ccc6 ccc14 ccc18 ccc18v ccc18s cccUnrated],
   :agcomRating
   [agcomUnspecified agcomT agcomVm14 agcomVm18 agcomUnrated],
   :catvRating
   [catvUnspecified
    catvC
    catvC8
    catvG
    catvPg
    catv14plus
    catv18plus
    catvUnrated
    catvE],
   :kfcbRating
   [kfcbUnspecified kfcbG kfcbPg kfcb16plus kfcbR kfcbUnrated],
   :cicfRating [cicfUnspecified cicfE cicfKtEa cicfKntEna cicfUnrated],
   :mcstRating
   [mcstUnspecified
    mcstP
    mcst0
    mcstC13
    mcstC16
    mcst16plus
    mcstC18
    mcstGPg
    mcstUnrated],
   :nbcplRating
   [nbcplUnspecified
    nbcplI
    nbcplIi
    nbcplIii
    nbcplIv
    nbcpl18plus
    nbcplUnrated],
   :nfrcRating
   [nfrcUnspecified nfrcA nfrcB nfrcC nfrcD nfrcX nfrcUnrated],
   :fpbRating
   [fpbUnspecified
    fpbA
    fpbPg
    fpb79Pg
    fpb1012Pg
    fpb13
    fpb16
    fpb18
    fpbX18
    fpbXx
    fpbUnrated
    fpb10],
   :fpbRatingReasons
   [[fpbRatingReasonUnspecified
     fpbBlasphemy
     fpbLanguage
     fpbNudity
     fpbPrejudice
     fpbSex
     fpbViolence
     fpbDrugs
     fpbSexualViolence
     fpbHorror
     fpbCriminalTechniques
     fpbImitativeActsTechniques]],
   :fmocRating
   [fmocUnspecified
    fmocU
    fmoc10
    fmoc12
    fmoc16
    fmoc18
    fmocE
    fmocUnrated],
   :mpaatRating [mpaatUnspecified mpaatGb mpaatRb]},
  :countryRestriction {:exception [string], :allowed boolean},
  :regionRestriction {:allowed [string], :blocked [string]},
  :dimension string,
  :projection [rectangular 360],
  :hasCustomThumbnail boolean},
 :player {:embedWidth string, :embedHeight string, :embedHtml string},
 :projectDetails object,
 :topicDetails
 {:topicIds [string],
  :relevantTopicIds [string],
  :topicCategories [string]}}

optional:
notifySubscribers <boolean> Notify the channel subscribers about the new video. As default, the notification is enabled.
stabilize <boolean> Should stabilize be applied to the upload.
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The CMS account that the user authenticates with must be linked to the specified YouTube content owner.
autoLevels <boolean> Should auto-levels be applied to the upload.
onBehalfOfContentOwnerChannel <string> This parameter can only be used in a properly authorized request. *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwnerChannel* parameter specifies the YouTube channel ID of the channel to which a video is being added. This parameter is required when a request specifies a value for the onBehalfOfContentOwner parameter, and it can only be used in conjunction with that parameter. In addition, the request must be authorized using a CMS account that is linked to the content owner that the onBehalfOfContentOwner parameter specifies. Finally, the channel that the onBehalfOfContentOwnerChannel parameter value specifies must be linked to the content owner that the onBehalfOfContentOwner parameter specifies. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and perform actions on behalf of the channel specified in the parameter value, without having to provide authentication credentials for each separate channel."
  ([part Video] (videos-insert part Video nil))
  ([part Video optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/videos",
       :uri-template-args {},
       :query-params (merge {:part part} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtube.upload"
        "https://www.googleapis.com/auth/youtubepartner"],
       :body Video})))

(defn videos-delete
  "Deletes a resource.
https://developers.google.com/youtube/v3/docs/videos/delete

id <string> 

optional:
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The actual CMS account that the user authenticates with must be linked to the specified YouTube content owner."
  ([id] (videos-delete id nil))
  ([id optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/videos",
       :uri-template-args {},
       :query-params (merge {:id id} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtubepartner"]})))

(defn videos-update
  "Updates an existing resource.
https://developers.google.com/youtube/v3/docs/videos/update

part <string> The *part* parameter serves two purposes in this operation. It identifies the properties that the write operation will set as well as the properties that the API response will include. Note that this method will override the existing values for all of the mutable properties that are contained in any parts that the parameter value specifies. For example, a video's privacy setting is contained in the status part. As such, if your request is updating a private video, and the request's part parameter value includes the status part, the video's privacy setting will be updated to whatever value the request body specifies. If the request body does not specify a value, the existing privacy setting will be removed and the video will revert to the default privacy setting. In addition, not all parts contain properties that can be set when inserting or updating a video. For example, the statistics object encapsulates statistics that YouTube calculates for a video and does not contain values that you can set or modify. If the parameter value specifies a part that does not contain mutable values, that part will still be included in the API response.
Video:
{:monetizationDetails
 {:access {:exception [string], :allowed boolean}},
 :localizations object,
 :snippet
 {:description string,
  :tags [string],
  :publishedAt string,
  :channelId string,
  :categoryId string,
  :thumbnails
  {:high {:width integer, :height integer, :url string},
   :default {:width integer, :height integer, :url string},
   :maxres {:width integer, :height integer, :url string},
   :medium {:width integer, :height integer, :url string},
   :standard {:width integer, :height integer, :url string}},
  :title string,
  :defaultAudioLanguage string,
  :liveBroadcastContent [none upcoming live completed],
  :localized {:description string, :title string},
  :channelTitle string,
  :defaultLanguage string},
 :fileDetails
 {:creationTime string,
  :fileSize string,
  :fileType [video audio image archive document project other],
  :fileName string,
  :bitrateBps string,
  :videoStreams
  [{:vendor string,
    :rotation [none clockwise upsideDown counterClockwise other],
    :heightPixels integer,
    :frameRateFps number,
    :widthPixels integer,
    :codec string,
    :aspectRatio number,
    :bitrateBps string}],
  :container string,
  :durationMs string,
  :audioStreams
  [{:codec string,
    :bitrateBps string,
    :channelCount integer,
    :vendor string}]},
 :etag string,
 :recordingDetails
 {:location {:latitude number, :longitude number, :altitude number},
  :locationDescription string,
  :recordingDate string},
 :statistics
 {:commentCount string,
  :favoriteCount string,
  :dislikeCount string,
  :likeCount string,
  :viewCount string},
 :ageGating
 {:restricted boolean,
  :alcoholContent boolean,
  :videoGameRating [anyone m15Plus m16Plus m17Plus]},
 :status
 {:uploadStatus [uploaded processed failed rejected deleted],
  :publicStatsViewable boolean,
  :license [youtube creativeCommon],
  :embeddable boolean,
  :publishAt string,
  :madeForKids boolean,
  :privacyStatus [public unlisted private],
  :failureReason
  [conversion invalidFile emptyFile tooSmall codec uploadAborted],
  :rejectionReason
  [copyright
   inappropriate
   duplicate
   termsOfUse
   uploaderAccountSuspended
   length
   claim
   uploaderAccountClosed
   trademark
   legal],
  :selfDeclaredMadeForKids boolean},
 :processingDetails
 {:fileDetailsAvailability string,
  :thumbnailsAvailability string,
  :processingFailureReason
  [uploadFailed transcodeFailed streamingFailed other],
  :tagSuggestionsAvailability string,
  :processingProgress
  {:timeLeftMs string, :partsProcessed string, :partsTotal string},
  :processingStatus [processing succeeded failed terminated],
  :processingIssuesAvailability string,
  :editorSuggestionsAvailability string},
 :id string,
 :kind string,
 :liveStreamingDetails
 {:activeLiveChatId string,
  :actualStartTime string,
  :scheduledEndTime string,
  :actualEndTime string,
  :scheduledStartTime string,
  :concurrentViewers string},
 :suggestions
 {:processingHints
  [[nonStreamableMov
    sendBestQualityVideo
    sphericalVideo
    spatialAudio
    vrVideo
    hdrVideo]],
  :processingErrors
  [[audioFile
    imageFile
    projectFile
    notAVideoFile
    docFile
    archiveFile
    unsupportedSpatialAudioLayout]],
  :tagSuggestions [{:tag string, :categoryRestricts [string]}],
  :processingWarnings
  [[unknownContainer
    unknownVideoCodec
    unknownAudioCodec
    inconsistentResolution
    hasEditlist
    problematicVideoCodec
    problematicAudioCodec
    unsupportedVrStereoMode
    unsupportedSphericalProjectionType
    unsupportedHdrPixelFormat
    unsupportedHdrColorMetadata
    problematicHdrLookupTable]],
  :editorSuggestions
  [[videoAutoLevels videoStabilize videoCrop audioQuietAudioSwap]]},
 :contentDetails
 {:caption [true false],
  :definition [sd hd],
  :licensedContent boolean,
  :duration string,
  :contentRating
  {:mccypRating
   [mccypUnspecified mccypA mccyp7 mccyp11 mccyp15 mccypUnrated],
   :menaMpaaRating
   [menaMpaaUnspecified
    menaMpaaG
    menaMpaaPg
    menaMpaaPg13
    menaMpaaR
    menaMpaaUnrated],
   :ilfilmRating
   [ilfilmUnspecified
    ilfilmAa
    ilfilm12
    ilfilm14
    ilfilm16
    ilfilm18
    ilfilmUnrated],
   :lsfRating
   [lsfUnspecified
    lsfSu
    lsfA
    lsfBo
    lsf13
    lsfR
    lsf17
    lsfD
    lsf21
    lsfUnrated],
   :mccaaRating
   [mccaaUnspecified
    mccaaU
    mccaaPg
    mccaa12a
    mccaa12
    mccaa14
    mccaa15
    mccaa16
    mccaa18
    mccaaUnrated],
   :fskRating [fskUnspecified fsk0 fsk6 fsk12 fsk16 fsk18 fskUnrated],
   :mtrcbRating
   [mtrcbUnspecified
    mtrcbG
    mtrcbPg
    mtrcbR13
    mtrcbR16
    mtrcbR18
    mtrcbX
    mtrcbUnrated],
   :grfilmRating
   [grfilmUnspecified
    grfilmK
    grfilmE
    grfilmK12
    grfilmK13
    grfilmK15
    grfilmK17
    grfilmK18
    grfilmUnrated],
   :kijkwijzerRating
   [kijkwijzerUnspecified
    kijkwijzerAl
    kijkwijzer6
    kijkwijzer9
    kijkwijzer12
    kijkwijzer16
    kijkwijzer18
    kijkwijzerUnrated],
   :czfilmRating
   [czfilmUnspecified
    czfilmU
    czfilm12
    czfilm14
    czfilm18
    czfilmUnrated],
   :incaaRating
   [incaaUnspecified
    incaaAtp
    incaaSam13
    incaaSam16
    incaaSam18
    incaaC
    incaaUnrated],
   :resorteviolenciaRating
   [resorteviolenciaUnspecified
    resorteviolenciaA
    resorteviolenciaB
    resorteviolenciaC
    resorteviolenciaD
    resorteviolenciaE
    resorteviolenciaUnrated],
   :eefilmRating
   [eefilmUnspecified
    eefilmPere
    eefilmL
    eefilmMs6
    eefilmK6
    eefilmMs12
    eefilmK12
    eefilmK14
    eefilmK16
    eefilmUnrated],
   :cnaRating
   [cnaUnspecified cnaAp cna12 cna15 cna18 cna18plus cnaUnrated],
   :moctwRating
   [moctwUnspecified
    moctwG
    moctwP
    moctwPg
    moctwR
    moctwUnrated
    moctwR12
    moctwR15],
   :tvpgRating
   [tvpgUnspecified
    tvpgY
    tvpgY7
    tvpgY7Fv
    tvpgG
    tvpgPg
    pg14
    tvpgMa
    tvpgUnrated],
   :bfvcRating
   [bfvcUnspecified
    bfvcG
    bfvcE
    bfvc13
    bfvc15
    bfvc18
    bfvc20
    bfvcB
    bfvcUnrated],
   :bmukkRating
   [bmukkUnspecified
    bmukkAa
    bmukk6
    bmukk8
    bmukk10
    bmukk12
    bmukk14
    bmukk16
    bmukkUnrated],
   :cceRating
   [cceUnspecified cceM4 cceM6 cceM12 cceM16 cceM18 cceUnrated cceM14],
   :cncRating
   [cncUnspecified
    cncT
    cnc10
    cnc12
    cnc16
    cnc18
    cncE
    cncInterdiction
    cncUnrated],
   :fcoRating
   [fcoUnspecified fcoI fcoIia fcoIib fcoIi fcoIii fcoUnrated],
   :ifcoRating
   [ifcoUnspecified
    ifcoG
    ifcoPg
    ifco12
    ifco12a
    ifco15
    ifco15a
    ifco16
    ifco18
    ifcoUnrated],
   :oflcRating
   [oflcUnspecified
    oflcG
    oflcPg
    oflcM
    oflcR13
    oflcR15
    oflcR16
    oflcR18
    oflcUnrated
    oflcRp13
    oflcRp16
    oflcRp18],
   :chvrsRating
   [chvrsUnspecified
    chvrsG
    chvrsPg
    chvrs14a
    chvrs18a
    chvrsR
    chvrsE
    chvrsUnrated],
   :cbfcRating
   [cbfcUnspecified
    cbfcU
    cbfcUA
    cbfcUA7plus
    cbfcUA13plus
    cbfcUA16plus
    cbfcA
    cbfcS
    cbfcUnrated],
   :csaRating
   [csaUnspecified
    csaT
    csa10
    csa12
    csa16
    csa18
    csaInterdiction
    csaUnrated],
   :icaaRating
   [icaaUnspecified
    icaaApta
    icaa7
    icaa12
    icaa13
    icaa16
    icaa18
    icaaX
    icaaUnrated],
   :djctqRatingReasons
   [[djctqRatingReasonUnspecified
     djctqViolence
     djctqExtremeViolence
     djctqSexualContent
     djctqNudity
     djctqSex
     djctqExplicitSex
     djctqDrugs
     djctqLegalDrugs
     djctqIllegalDrugs
     djctqInappropriateLanguage
     djctqCriminalActs
     djctqImpactingContent]],
   :fcbmRating
   [fcbmUnspecified
    fcbmU
    fcbmPg13
    fcbmP13
    fcbm18
    fcbm18sx
    fcbm18pa
    fcbm18sg
    fcbm18pl
    fcbmUnrated],
   :pefilmRating
   [pefilmUnspecified
    pefilmPt
    pefilmPg
    pefilm14
    pefilm18
    pefilmUnrated],
   :ytRating [ytUnspecified ytAgeRestricted],
   :nfvcbRating
   [nfvcbUnspecified
    nfvcbG
    nfvcbPg
    nfvcb12
    nfvcb12a
    nfvcb15
    nfvcb18
    nfvcbRe
    nfvcbUnrated],
   :cscfRating
   [cscfUnspecified
    cscfAl
    cscfA
    cscf6
    cscf9
    cscf12
    cscf16
    cscf18
    cscfUnrated],
   :djctqRating
   [djctqUnspecified
    djctqL
    djctq10
    djctq12
    djctq14
    djctq16
    djctq18
    djctqEr
    djctqL10
    djctqL12
    djctqL14
    djctqL16
    djctqL18
    djctq1012
    djctq1014
    djctq1016
    djctq1018
    djctq1214
    djctq1216
    djctq1218
    djctq1416
    djctq1418
    djctq1618
    djctqUnrated],
   :kmrbRating
   [kmrbUnspecified
    kmrbAll
    kmrb12plus
    kmrb15plus
    kmrbTeenr
    kmrbR
    kmrbUnrated],
   :smaisRating
   [smaisUnspecified
    smaisL
    smais7
    smais12
    smais14
    smais16
    smais18
    smaisUnrated],
   :bbfcRating
   [bbfcUnspecified
    bbfcU
    bbfcPg
    bbfc12a
    bbfc12
    bbfc15
    bbfc18
    bbfcR18
    bbfcUnrated],
   :skfilmRating
   [skfilmUnspecified
    skfilmG
    skfilmP2
    skfilmP5
    skfilmP8
    skfilmUnrated],
   :nbcRating
   [nbcUnspecified
    nbcG
    nbcPg
    nbc12plus
    nbc15plus
    nbc18plus
    nbc18plusr
    nbcPu
    nbcUnrated],
   :eirinRating
   [eirinUnspecified
    eirinG
    eirinPg12
    eirinR15plus
    eirinR18plus
    eirinUnrated],
   :nkclvRating
   [nkclvUnspecified
    nkclvU
    nkclv7plus
    nkclv12plus
    nkclv16plus
    nkclv18plus
    nkclvUnrated],
   :mocRating
   [mocUnspecified
    mocE
    mocT
    moc7
    moc12
    moc15
    moc18
    mocX
    mocBanned
    mocUnrated],
   :smsaRating [smsaUnspecified smsaA smsa7 smsa11 smsa15 smsaUnrated],
   :medietilsynetRating
   [medietilsynetUnspecified
    medietilsynetA
    medietilsynet6
    medietilsynet7
    medietilsynet9
    medietilsynet11
    medietilsynet12
    medietilsynet15
    medietilsynet18
    medietilsynetUnrated],
   :mpaaRating
   [mpaaUnspecified
    mpaaG
    mpaaPg
    mpaaPg13
    mpaaR
    mpaaNc17
    mpaaX
    mpaaUnrated],
   :mekuRating
   [mekuUnspecified mekuS meku7 meku12 meku16 meku18 mekuUnrated],
   :ecbmctRating
   [ecbmctUnspecified
    ecbmctG
    ecbmct7a
    ecbmct7plus
    ecbmct13a
    ecbmct13plus
    ecbmct15a
    ecbmct15plus
    ecbmct18plus
    ecbmctUnrated],
   :rteRating [rteUnspecified rteGa rteCh rtePs rteMa rteUnrated],
   :mibacRating
   [mibacUnspecified
    mibacT
    mibacVap
    mibacVm6
    mibacVm12
    mibacVm14
    mibacVm16
    mibacVm18
    mibacUnrated],
   :mdaRating
   [mdaUnspecified
    mdaG
    mdaPg
    mdaPg13
    mdaNc16
    mdaM18
    mdaR21
    mdaUnrated],
   :nmcRating
   [nmcUnspecified
    nmcG
    nmcPg
    nmcPg13
    nmcPg15
    nmc15plus
    nmc18plus
    nmc18tc
    nmcUnrated],
   :chfilmRating
   [chfilmUnspecified
    chfilm0
    chfilm6
    chfilm12
    chfilm16
    chfilm18
    chfilmUnrated],
   :rcnofRating
   [rcnofUnspecified
    rcnofI
    rcnofIi
    rcnofIii
    rcnofIv
    rcnofV
    rcnofVi
    rcnofUnrated],
   :egfilmRating
   [egfilmUnspecified egfilmGn egfilm18 egfilmBn egfilmUnrated],
   :anatelRating
   [anatelUnspecified
    anatelF
    anatelI
    anatelI7
    anatelI10
    anatelI12
    anatelR
    anatelA
    anatelUnrated],
   :catvfrRating
   [catvfrUnspecified
    catvfrG
    catvfr8plus
    catvfr13plus
    catvfr16plus
    catvfr18plus
    catvfrUnrated
    catvfrE],
   :acbRating
   [acbUnspecified
    acbE
    acbP
    acbC
    acbG
    acbPg
    acbM
    acbMa15plus
    acbR18plus
    acbUnrated],
   :rtcRating
   [rtcUnspecified rtcAa rtcA rtcB rtcB15 rtcC rtcD rtcUnrated],
   :russiaRating
   [russiaUnspecified
    russia0
    russia6
    russia12
    russia16
    russia18
    russiaUnrated],
   :cccRating
   [cccUnspecified cccTe ccc6 ccc14 ccc18 ccc18v ccc18s cccUnrated],
   :agcomRating
   [agcomUnspecified agcomT agcomVm14 agcomVm18 agcomUnrated],
   :catvRating
   [catvUnspecified
    catvC
    catvC8
    catvG
    catvPg
    catv14plus
    catv18plus
    catvUnrated
    catvE],
   :kfcbRating
   [kfcbUnspecified kfcbG kfcbPg kfcb16plus kfcbR kfcbUnrated],
   :cicfRating [cicfUnspecified cicfE cicfKtEa cicfKntEna cicfUnrated],
   :mcstRating
   [mcstUnspecified
    mcstP
    mcst0
    mcstC13
    mcstC16
    mcst16plus
    mcstC18
    mcstGPg
    mcstUnrated],
   :nbcplRating
   [nbcplUnspecified
    nbcplI
    nbcplIi
    nbcplIii
    nbcplIv
    nbcpl18plus
    nbcplUnrated],
   :nfrcRating
   [nfrcUnspecified nfrcA nfrcB nfrcC nfrcD nfrcX nfrcUnrated],
   :fpbRating
   [fpbUnspecified
    fpbA
    fpbPg
    fpb79Pg
    fpb1012Pg
    fpb13
    fpb16
    fpb18
    fpbX18
    fpbXx
    fpbUnrated
    fpb10],
   :fpbRatingReasons
   [[fpbRatingReasonUnspecified
     fpbBlasphemy
     fpbLanguage
     fpbNudity
     fpbPrejudice
     fpbSex
     fpbViolence
     fpbDrugs
     fpbSexualViolence
     fpbHorror
     fpbCriminalTechniques
     fpbImitativeActsTechniques]],
   :fmocRating
   [fmocUnspecified
    fmocU
    fmoc10
    fmoc12
    fmoc16
    fmoc18
    fmocE
    fmocUnrated],
   :mpaatRating [mpaatUnspecified mpaatGb mpaatRb]},
  :countryRestriction {:exception [string], :allowed boolean},
  :regionRestriction {:allowed [string], :blocked [string]},
  :dimension string,
  :projection [rectangular 360],
  :hasCustomThumbnail boolean},
 :player {:embedWidth string, :embedHeight string, :embedHtml string},
 :projectDetails object,
 :topicDetails
 {:topicIds [string],
  :relevantTopicIds [string],
  :topicCategories [string]}}

optional:
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The actual CMS account that the user authenticates with must be linked to the specified YouTube content owner."
  ([part Video] (videos-update part Video nil))
  ([part Video optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/videos",
       :uri-template-args {},
       :query-params (merge {:part part} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtubepartner"],
       :body Video})))

(defn liveBroadcasts-list
  "Retrieve the list of broadcasts associated with the given channel.
https://developers.google.com/youtube/v3/docs/liveBroadcasts/list

part <string> The *part* parameter specifies a comma-separated list of one or more liveBroadcast resource properties that the API response will include. The part names that you can include in the parameter value are id, snippet, contentDetails, status and statistics.

optional:
broadcastType <string> Return only broadcasts with the selected type.
onBehalfOfContentOwnerChannel <string> This parameter can only be used in a properly authorized request. *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwnerChannel* parameter specifies the YouTube channel ID of the channel to which a video is being added. This parameter is required when a request specifies a value for the onBehalfOfContentOwner parameter, and it can only be used in conjunction with that parameter. In addition, the request must be authorized using a CMS account that is linked to the content owner that the onBehalfOfContentOwner parameter specifies. Finally, the channel that the onBehalfOfContentOwnerChannel parameter value specifies must be linked to the content owner that the onBehalfOfContentOwner parameter specifies. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and perform actions on behalf of the channel specified in the parameter value, without having to provide authentication credentials for each separate channel.
mine <boolean> 
id <string> Return broadcasts with the given ids from Stubby or Apiary.
broadcastStatus <string> Return broadcasts with a certain status, e.g. active broadcasts.
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The CMS account that the user authenticates with must be linked to the specified YouTube content owner.
maxResults <integer> The *maxResults* parameter specifies the maximum number of items that should be returned in the result set."
  ([part] (liveBroadcasts-list part nil))
  ([part optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/liveBroadcasts",
       :uri-template-args {},
       :query-params (merge {:part part} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtube.readonly"]})))

(defn liveBroadcasts-bind
  "Bind a broadcast to a stream.
https://developers.google.com/youtube/v3/docs/liveBroadcasts/bind

id <string> Broadcast to bind to the stream
part <string> The *part* parameter specifies a comma-separated list of one or more liveBroadcast resource properties that the API response will include. The part names that you can include in the parameter value are id, snippet, contentDetails, and status.

optional:
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The CMS account that the user authenticates with must be linked to the specified YouTube content owner.
onBehalfOfContentOwnerChannel <string> This parameter can only be used in a properly authorized request. *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwnerChannel* parameter specifies the YouTube channel ID of the channel to which a video is being added. This parameter is required when a request specifies a value for the onBehalfOfContentOwner parameter, and it can only be used in conjunction with that parameter. In addition, the request must be authorized using a CMS account that is linked to the content owner that the onBehalfOfContentOwner parameter specifies. Finally, the channel that the onBehalfOfContentOwnerChannel parameter value specifies must be linked to the content owner that the onBehalfOfContentOwner parameter specifies. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and perform actions on behalf of the channel specified in the parameter value, without having to provide authentication credentials for each separate channel.
streamId <string> Stream to bind, if not set unbind the current one."
  ([id part] (liveBroadcasts-bind id part nil))
  ([id part optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/liveBroadcasts/bind",
       :uri-template-args {},
       :query-params (merge {:part part, :id id} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"]})))

(defn liveBroadcasts-update
  "Updates an existing broadcast for the authenticated user.
https://developers.google.com/youtube/v3/docs/liveBroadcasts/update

part <string> The *part* parameter serves two purposes in this operation. It identifies the properties that the write operation will set as well as the properties that the API response will include. The part properties that you can include in the parameter value are id, snippet, contentDetails, and status. Note that this method will override the existing values for all of the mutable properties that are contained in any parts that the parameter value specifies. For example, a broadcast's privacy status is defined in the status part. As such, if your request is updating a private or unlisted broadcast, and the request's part parameter value includes the status part, the broadcast's privacy setting will be updated to whatever value the request body specifies. If the request body does not specify a value, the existing privacy setting will be removed and the broadcast will revert to the default privacy setting.
LiveBroadcast:
{:contentDetails
 {:stereoLayout [stereoLayoutUnspecified mono leftRight topBottom],
  :enableAutoStop boolean,
  :enableContentEncryption boolean,
  :enableLowLatency boolean,
  :enableAutoStart boolean,
  :latencyPreference
  [latencyPreferenceUnspecified normal low ultraLow],
  :enableDvr boolean,
  :mesh string,
  :boundStreamId string,
  :enableClosedCaptions boolean,
  :boundStreamLastUpdateTimeMs string,
  :recordFromStart boolean,
  :monitorStream
  {:enableMonitorStream boolean,
   :embedHtml string,
   :broadcastStreamDelayMs integer},
  :startWithSlate boolean,
  :enableEmbed boolean,
  :closedCaptionsType
  [closedCaptionsTypeUnspecified
   closedCaptionsDisabled
   closedCaptionsHttpPost
   closedCaptionsEmbedded],
  :projection [projectionUnspecified rectangular 360 mesh]},
 :status
 {:privacyStatus [public unlisted private],
  :selfDeclaredMadeForKids boolean,
  :liveBroadcastPriority
  [liveBroadcastPriorityUnspecified low normal high],
  :madeForKids boolean,
  :lifeCycleStatus
  [lifeCycleStatusUnspecified
   created
   ready
   testing
   live
   complete
   revoked
   testStarting
   liveStarting],
  :recordingStatus
  [liveBroadcastRecordingStatusUnspecified
   notRecording
   recording
   recorded]},
 :statistics {:concurrentViewers string},
 :snippet
 {:description string,
  :publishedAt string,
  :scheduledEndTime string,
  :channelId string,
  :thumbnails
  {:high {:width integer, :height integer, :url string},
   :default {:width integer, :height integer, :url string},
   :maxres {:width integer, :height integer, :url string},
   :medium {:width integer, :height integer, :url string},
   :standard {:width integer, :height integer, :url string}},
  :title string,
  :isDefaultBroadcast boolean,
  :liveChatId string,
  :scheduledStartTime string,
  :actualEndTime string,
  :actualStartTime string},
 :etag string,
 :kind string,
 :id string,
 :monetizationDetails
 {:cuepointSchedule
  {:enabled boolean,
   :pauseAdsUntil string,
   :scheduleStrategy
   [scheduleStrategyUnspecified concurrent nonConcurrent],
   :repeatIntervalSecs integer}}}

optional:
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The CMS account that the user authenticates with must be linked to the specified YouTube content owner.
onBehalfOfContentOwnerChannel <string> This parameter can only be used in a properly authorized request. *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwnerChannel* parameter specifies the YouTube channel ID of the channel to which a video is being added. This parameter is required when a request specifies a value for the onBehalfOfContentOwner parameter, and it can only be used in conjunction with that parameter. In addition, the request must be authorized using a CMS account that is linked to the content owner that the onBehalfOfContentOwner parameter specifies. Finally, the channel that the onBehalfOfContentOwnerChannel parameter value specifies must be linked to the content owner that the onBehalfOfContentOwner parameter specifies. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and perform actions on behalf of the channel specified in the parameter value, without having to provide authentication credentials for each separate channel."
  ([part LiveBroadcast] (liveBroadcasts-update part LiveBroadcast nil))
  ([part LiveBroadcast optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/liveBroadcasts",
       :uri-template-args {},
       :query-params (merge {:part part} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"],
       :body LiveBroadcast})))

(defn liveBroadcasts-delete
  "Delete a given broadcast.
https://developers.google.com/youtube/v3/docs/liveBroadcasts/delete

id <string> Broadcast to delete.

optional:
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The CMS account that the user authenticates with must be linked to the specified YouTube content owner.
onBehalfOfContentOwnerChannel <string> This parameter can only be used in a properly authorized request. *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwnerChannel* parameter specifies the YouTube channel ID of the channel to which a video is being added. This parameter is required when a request specifies a value for the onBehalfOfContentOwner parameter, and it can only be used in conjunction with that parameter. In addition, the request must be authorized using a CMS account that is linked to the content owner that the onBehalfOfContentOwner parameter specifies. Finally, the channel that the onBehalfOfContentOwnerChannel parameter value specifies must be linked to the content owner that the onBehalfOfContentOwner parameter specifies. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and perform actions on behalf of the channel specified in the parameter value, without having to provide authentication credentials for each separate channel."
  ([id] (liveBroadcasts-delete id nil))
  ([id optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/liveBroadcasts",
       :uri-template-args {},
       :query-params (merge {:id id} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"]})))

(defn liveBroadcasts-transition
  "Transition a broadcast to a given status.
https://developers.google.com/youtube/v3/docs/liveBroadcasts/transition

broadcastStatus <string> The status to which the broadcast is going to transition.
id <string> Broadcast to transition.
part <string> The *part* parameter specifies a comma-separated list of one or more liveBroadcast resource properties that the API response will include. The part names that you can include in the parameter value are id, snippet, contentDetails, and status.

optional:
onBehalfOfContentOwnerChannel <string> This parameter can only be used in a properly authorized request. *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwnerChannel* parameter specifies the YouTube channel ID of the channel to which a video is being added. This parameter is required when a request specifies a value for the onBehalfOfContentOwner parameter, and it can only be used in conjunction with that parameter. In addition, the request must be authorized using a CMS account that is linked to the content owner that the onBehalfOfContentOwner parameter specifies. Finally, the channel that the onBehalfOfContentOwnerChannel parameter value specifies must be linked to the content owner that the onBehalfOfContentOwner parameter specifies. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and perform actions on behalf of the channel specified in the parameter value, without having to provide authentication credentials for each separate channel.
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The CMS account that the user authenticates with must be linked to the specified YouTube content owner."
  ([broadcastStatus id part]
    (liveBroadcasts-transition broadcastStatus id part nil))
  ([broadcastStatus id part optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/liveBroadcasts/transition",
       :uri-template-args {},
       :query-params
       (merge
         {:id id, :part part, :broadcastStatus broadcastStatus}
         optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"]})))

(defn liveBroadcasts-insertCuepoint
  "Insert cuepoints in a broadcast
https://developers.google.com/youtube/v3/docs/liveBroadcasts/insertCuepoint

Cuepoint:
{:cueType [cueTypeUnspecified cueTypeAd],
 :insertionOffsetTimeMs string,
 :id string,
 :walltimeMs string,
 :durationSecs integer,
 :etag string}

optional:
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The CMS account that the user authenticates with must be linked to the specified YouTube content owner.
onBehalfOfContentOwnerChannel <string> This parameter can only be used in a properly authorized request. *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwnerChannel* parameter specifies the YouTube channel ID of the channel to which a video is being added. This parameter is required when a request specifies a value for the onBehalfOfContentOwner parameter, and it can only be used in conjunction with that parameter. In addition, the request must be authorized using a CMS account that is linked to the content owner that the onBehalfOfContentOwner parameter specifies. Finally, the channel that the onBehalfOfContentOwnerChannel parameter value specifies must be linked to the content owner that the onBehalfOfContentOwner parameter specifies. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and perform actions on behalf of the channel specified in the parameter value, without having to provide authentication credentials for each separate channel.
part <string> The *part* parameter specifies a comma-separated list of one or more liveBroadcast resource properties that the API response will include. The part names that you can include in the parameter value are id, snippet, contentDetails, and status.
id <string> Broadcast to insert ads to, or equivalently `external_video_id` for internal use."
  ([Cuepoint] (liveBroadcasts-insertCuepoint Cuepoint nil))
  ([Cuepoint optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/liveBroadcasts/cuepoint",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtubepartner"],
       :body Cuepoint})))

(defn liveBroadcasts-insert
  "Inserts a new stream for the authenticated user.
https://developers.google.com/youtube/v3/docs/liveBroadcasts/insert

part <string> The *part* parameter serves two purposes in this operation. It identifies the properties that the write operation will set as well as the properties that the API response will include. The part properties that you can include in the parameter value are id, snippet, contentDetails, and status.
LiveBroadcast:
{:contentDetails
 {:stereoLayout [stereoLayoutUnspecified mono leftRight topBottom],
  :enableAutoStop boolean,
  :enableContentEncryption boolean,
  :enableLowLatency boolean,
  :enableAutoStart boolean,
  :latencyPreference
  [latencyPreferenceUnspecified normal low ultraLow],
  :enableDvr boolean,
  :mesh string,
  :boundStreamId string,
  :enableClosedCaptions boolean,
  :boundStreamLastUpdateTimeMs string,
  :recordFromStart boolean,
  :monitorStream
  {:enableMonitorStream boolean,
   :embedHtml string,
   :broadcastStreamDelayMs integer},
  :startWithSlate boolean,
  :enableEmbed boolean,
  :closedCaptionsType
  [closedCaptionsTypeUnspecified
   closedCaptionsDisabled
   closedCaptionsHttpPost
   closedCaptionsEmbedded],
  :projection [projectionUnspecified rectangular 360 mesh]},
 :status
 {:privacyStatus [public unlisted private],
  :selfDeclaredMadeForKids boolean,
  :liveBroadcastPriority
  [liveBroadcastPriorityUnspecified low normal high],
  :madeForKids boolean,
  :lifeCycleStatus
  [lifeCycleStatusUnspecified
   created
   ready
   testing
   live
   complete
   revoked
   testStarting
   liveStarting],
  :recordingStatus
  [liveBroadcastRecordingStatusUnspecified
   notRecording
   recording
   recorded]},
 :statistics {:concurrentViewers string},
 :snippet
 {:description string,
  :publishedAt string,
  :scheduledEndTime string,
  :channelId string,
  :thumbnails
  {:high {:width integer, :height integer, :url string},
   :default {:width integer, :height integer, :url string},
   :maxres {:width integer, :height integer, :url string},
   :medium {:width integer, :height integer, :url string},
   :standard {:width integer, :height integer, :url string}},
  :title string,
  :isDefaultBroadcast boolean,
  :liveChatId string,
  :scheduledStartTime string,
  :actualEndTime string,
  :actualStartTime string},
 :etag string,
 :kind string,
 :id string,
 :monetizationDetails
 {:cuepointSchedule
  {:enabled boolean,
   :pauseAdsUntil string,
   :scheduleStrategy
   [scheduleStrategyUnspecified concurrent nonConcurrent],
   :repeatIntervalSecs integer}}}

optional:
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The CMS account that the user authenticates with must be linked to the specified YouTube content owner.
onBehalfOfContentOwnerChannel <string> This parameter can only be used in a properly authorized request. *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwnerChannel* parameter specifies the YouTube channel ID of the channel to which a video is being added. This parameter is required when a request specifies a value for the onBehalfOfContentOwner parameter, and it can only be used in conjunction with that parameter. In addition, the request must be authorized using a CMS account that is linked to the content owner that the onBehalfOfContentOwner parameter specifies. Finally, the channel that the onBehalfOfContentOwnerChannel parameter value specifies must be linked to the content owner that the onBehalfOfContentOwner parameter specifies. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and perform actions on behalf of the channel specified in the parameter value, without having to provide authentication credentials for each separate channel."
  ([part LiveBroadcast] (liveBroadcasts-insert part LiveBroadcast nil))
  ([part LiveBroadcast optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/liveBroadcasts",
       :uri-template-args {},
       :query-params (merge {:part part} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"],
       :body LiveBroadcast})))

(defn thumbnails-set
  "As this is not an insert in a strict sense (it supports uploading/setting of a thumbnail for multiple videos, which doesn't result in creation of a single resource), I use a custom verb here.
https://developers.google.com/youtube/v3/docs/thumbnails/set

videoId <string> Returns the Thumbnail with the given video IDs for Stubby or Apiary.

optional:
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The actual CMS account that the user authenticates with must be linked to the specified YouTube content owner."
  ([videoId] (thumbnails-set videoId nil))
  ([videoId optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/thumbnails/set",
       :uri-template-args {},
       :query-params (merge {:videoId videoId} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtube.upload"
        "https://www.googleapis.com/auth/youtubepartner"]})))

(defn abuseReports-insert
  "Inserts a new resource into this collection.
https://developers.google.com/youtube/v3/docs/abuseReports/insert

part <string> The *part* parameter serves two purposes in this operation. It identifies the properties that the write operation will set as well as the properties that the API response will include.
AbuseReport:
{:description string,
 :relatedEntities
 [{:entity {:url string, :typeId string, :id string}}],
 :subject {:url string, :typeId string, :id string},
 :abuseTypes [{:id string}]}"
  [part AbuseReport]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://youtube.googleapis.com/youtube/v3/abuseReports",
     :uri-template-args {},
     :query-params {:part part},
     :scopes
     ["https://www.googleapis.com/auth/youtube"
      "https://www.googleapis.com/auth/youtube.force-ssl"],
     :body AbuseReport}))

(defn playlists-update
  "Updates an existing resource.
https://developers.google.com/youtube/v3/docs/playlists/update

part <string> The *part* parameter serves two purposes in this operation. It identifies the properties that the write operation will set as well as the properties that the API response will include. Note that this method will override the existing values for mutable properties that are contained in any parts that the request body specifies. For example, a playlist's description is contained in the snippet part, which must be included in the request body. If the request does not specify a value for the snippet.description property, the playlist's existing description will be deleted.
Playlist:
{:kind string,
 :status {:privacyStatus [public unlisted private]},
 :contentDetails {:itemCount integer},
 :id string,
 :player {:embedHtml string},
 :etag string,
 :snippet
 {:description string,
  :tags [string],
  :publishedAt string,
  :channelId string,
  :thumbnails
  {:high {:width integer, :height integer, :url string},
   :default {:width integer, :height integer, :url string},
   :maxres {:width integer, :height integer, :url string},
   :medium {:width integer, :height integer, :url string},
   :standard {:width integer, :height integer, :url string}},
  :title string,
  :localized {:description string, :title string},
  :channelTitle string,
  :thumbnailVideoId string,
  :defaultLanguage string},
 :localizations object}

optional:
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The CMS account that the user authenticates with must be linked to the specified YouTube content owner."
  ([part Playlist] (playlists-update part Playlist nil))
  ([part Playlist optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/playlists",
       :uri-template-args {},
       :query-params (merge {:part part} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtubepartner"],
       :body Playlist})))

(defn playlists-delete
  "Deletes a resource.
https://developers.google.com/youtube/v3/docs/playlists/delete

id <string> 

optional:
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The CMS account that the user authenticates with must be linked to the specified YouTube content owner."
  ([id] (playlists-delete id nil))
  ([id optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/playlists",
       :uri-template-args {},
       :query-params (merge {:id id} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtubepartner"]})))

(defn playlists-list
  "Retrieves a list of resources, possibly filtered.
https://developers.google.com/youtube/v3/docs/playlists/list

part <string> The *part* parameter specifies a comma-separated list of one or more playlist resource properties that the API response will include. If the parameter identifies a property that contains child properties, the child properties will be included in the response. For example, in a playlist resource, the snippet property contains properties like author, title, description, tags, and timeCreated. As such, if you set *part=snippet*, the API response will contain all of those properties.

optional:
onBehalfOfContentOwnerChannel <string> This parameter can only be used in a properly authorized request. *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwnerChannel* parameter specifies the YouTube channel ID of the channel to which a video is being added. This parameter is required when a request specifies a value for the onBehalfOfContentOwner parameter, and it can only be used in conjunction with that parameter. In addition, the request must be authorized using a CMS account that is linked to the content owner that the onBehalfOfContentOwner parameter specifies. Finally, the channel that the onBehalfOfContentOwnerChannel parameter value specifies must be linked to the content owner that the onBehalfOfContentOwner parameter specifies. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and perform actions on behalf of the channel specified in the parameter value, without having to provide authentication credentials for each separate channel.
channelId <string> Return the playlists owned by the specified channel ID.
mine <boolean> Return the playlists owned by the authenticated user.
hl <string> Return content in specified language
id <string> Return the playlists with the given IDs for Stubby or Apiary.
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The CMS account that the user authenticates with must be linked to the specified YouTube content owner.
maxResults <integer> The *maxResults* parameter specifies the maximum number of items that should be returned in the result set."
  ([part] (playlists-list part nil))
  ([part optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/playlists",
       :uri-template-args {},
       :query-params (merge {:part part} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtube.readonly"
        "https://www.googleapis.com/auth/youtubepartner"]})))

(defn playlists-insert
  "Inserts a new resource into this collection.
https://developers.google.com/youtube/v3/docs/playlists/insert

part <string> The *part* parameter serves two purposes in this operation. It identifies the properties that the write operation will set as well as the properties that the API response will include.
Playlist:
{:kind string,
 :status {:privacyStatus [public unlisted private]},
 :contentDetails {:itemCount integer},
 :id string,
 :player {:embedHtml string},
 :etag string,
 :snippet
 {:description string,
  :tags [string],
  :publishedAt string,
  :channelId string,
  :thumbnails
  {:high {:width integer, :height integer, :url string},
   :default {:width integer, :height integer, :url string},
   :maxres {:width integer, :height integer, :url string},
   :medium {:width integer, :height integer, :url string},
   :standard {:width integer, :height integer, :url string}},
  :title string,
  :localized {:description string, :title string},
  :channelTitle string,
  :thumbnailVideoId string,
  :defaultLanguage string},
 :localizations object}

optional:
onBehalfOfContentOwnerChannel <string> This parameter can only be used in a properly authorized request. *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwnerChannel* parameter specifies the YouTube channel ID of the channel to which a video is being added. This parameter is required when a request specifies a value for the onBehalfOfContentOwner parameter, and it can only be used in conjunction with that parameter. In addition, the request must be authorized using a CMS account that is linked to the content owner that the onBehalfOfContentOwner parameter specifies. Finally, the channel that the onBehalfOfContentOwnerChannel parameter value specifies must be linked to the content owner that the onBehalfOfContentOwner parameter specifies. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and perform actions on behalf of the channel specified in the parameter value, without having to provide authentication credentials for each separate channel.
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The CMS account that the user authenticates with must be linked to the specified YouTube content owner."
  ([part Playlist] (playlists-insert part Playlist nil))
  ([part Playlist optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/playlists",
       :uri-template-args {},
       :query-params (merge {:part part} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtubepartner"],
       :body Playlist})))

(defn playlistItems-delete
  "Deletes a resource.
https://developers.google.com/youtube/v3/docs/playlistItems/delete

id <string> 

optional:
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The CMS account that the user authenticates with must be linked to the specified YouTube content owner."
  ([id] (playlistItems-delete id nil))
  ([id optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/playlistItems",
       :uri-template-args {},
       :query-params (merge {:id id} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtubepartner"]})))

(defn playlistItems-update
  "Updates an existing resource.
https://developers.google.com/youtube/v3/docs/playlistItems/update

part <string> The *part* parameter serves two purposes in this operation. It identifies the properties that the write operation will set as well as the properties that the API response will include. Note that this method will override the existing values for all of the mutable properties that are contained in any parts that the parameter value specifies. For example, a playlist item can specify a start time and end time, which identify the times portion of the video that should play when users watch the video in the playlist. If your request is updating a playlist item that sets these values, and the request's part parameter value includes the contentDetails part, the playlist item's start and end times will be updated to whatever value the request body specifies. If the request body does not specify values, the existing start and end times will be removed and replaced with the default settings.
PlaylistItem:
{:snippet
 {:videoOwnerChannelTitle string,
  :description string,
  :publishedAt string,
  :channelId string,
  :thumbnails
  {:high {:width integer, :height integer, :url string},
   :default {:width integer, :height integer, :url string},
   :maxres {:width integer, :height integer, :url string},
   :medium {:width integer, :height integer, :url string},
   :standard {:width integer, :height integer, :url string}},
  :title string,
  :resourceId
  {:playlistId string,
   :channelId string,
   :kind string,
   :videoId string},
  :videoOwnerChannelId string,
  :position integer,
  :channelTitle string,
  :playlistId string},
 :contentDetails
 {:videoPublishedAt string,
  :endAt string,
  :note string,
  :videoId string,
  :startAt string},
 :kind string,
 :status {:privacyStatus [public unlisted private]},
 :id string,
 :etag string}

optional:
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The CMS account that the user authenticates with must be linked to the specified YouTube content owner."
  ([part PlaylistItem] (playlistItems-update part PlaylistItem nil))
  ([part PlaylistItem optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/playlistItems",
       :uri-template-args {},
       :query-params (merge {:part part} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtubepartner"],
       :body PlaylistItem})))

(defn playlistItems-list
  "Retrieves a list of resources, possibly filtered.
https://developers.google.com/youtube/v3/docs/playlistItems/list

part <string> The *part* parameter specifies a comma-separated list of one or more playlistItem resource properties that the API response will include. If the parameter identifies a property that contains child properties, the child properties will be included in the response. For example, in a playlistItem resource, the snippet property contains numerous fields, including the title, description, position, and resourceId properties. As such, if you set *part=snippet*, the API response will contain all of those properties.

optional:
maxResults <integer> The *maxResults* parameter specifies the maximum number of items that should be returned in the result set.
playlistId <string> Return the playlist items within the given playlist.
videoId <string> Return the playlist items associated with the given video ID.
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The CMS account that the user authenticates with must be linked to the specified YouTube content owner.
id <string> "
  ([part] (playlistItems-list part nil))
  ([part optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/playlistItems",
       :uri-template-args {},
       :query-params (merge {:part part} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtube.readonly"
        "https://www.googleapis.com/auth/youtubepartner"]})))

(defn playlistItems-insert
  "Inserts a new resource into this collection.
https://developers.google.com/youtube/v3/docs/playlistItems/insert

part <string> The *part* parameter serves two purposes in this operation. It identifies the properties that the write operation will set as well as the properties that the API response will include.
PlaylistItem:
{:snippet
 {:videoOwnerChannelTitle string,
  :description string,
  :publishedAt string,
  :channelId string,
  :thumbnails
  {:high {:width integer, :height integer, :url string},
   :default {:width integer, :height integer, :url string},
   :maxres {:width integer, :height integer, :url string},
   :medium {:width integer, :height integer, :url string},
   :standard {:width integer, :height integer, :url string}},
  :title string,
  :resourceId
  {:playlistId string,
   :channelId string,
   :kind string,
   :videoId string},
  :videoOwnerChannelId string,
  :position integer,
  :channelTitle string,
  :playlistId string},
 :contentDetails
 {:videoPublishedAt string,
  :endAt string,
  :note string,
  :videoId string,
  :startAt string},
 :kind string,
 :status {:privacyStatus [public unlisted private]},
 :id string,
 :etag string}

optional:
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The CMS account that the user authenticates with must be linked to the specified YouTube content owner."
  ([part PlaylistItem] (playlistItems-insert part PlaylistItem nil))
  ([part PlaylistItem optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/playlistItems",
       :uri-template-args {},
       :query-params (merge {:part part} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtubepartner"],
       :body PlaylistItem})))

(defn channelSections-delete
  "Deletes a resource.
https://developers.google.com/youtube/v3/docs/channelSections/delete

id <string> 

optional:
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The CMS account that the user authenticates with must be linked to the specified YouTube content owner."
  ([id] (channelSections-delete id nil))
  ([id optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/channelSections",
       :uri-template-args {},
       :query-params (merge {:id id} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtubepartner"]})))

(defn channelSections-insert
  "Inserts a new resource into this collection.
https://developers.google.com/youtube/v3/docs/channelSections/insert

part <string> The *part* parameter serves two purposes in this operation. It identifies the properties that the write operation will set as well as the properties that the API response will include. The part names that you can include in the parameter value are snippet and contentDetails.
ChannelSection:
{:contentDetails {:playlists [string], :channels [string]},
 :etag string,
 :id string,
 :snippet
 {:defaultLanguage string,
  :style [channelsectionStyleUnspecified horizontalRow verticalList],
  :position integer,
  :title string,
  :localized {:title string},
  :type
  [channelsectionTypeUndefined
   singlePlaylist
   multiplePlaylists
   popularUploads
   recentUploads
   likes
   allPlaylists
   likedPlaylists
   recentPosts
   recentActivity
   liveEvents
   upcomingEvents
   completedEvents
   multipleChannels
   postedVideos
   postedPlaylists
   subscriptions],
  :channelId string},
 :localizations object,
 :targeting
 {:languages [string], :regions [string], :countries [string]},
 :kind string}

optional:
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The CMS account that the user authenticates with must be linked to the specified YouTube content owner.
onBehalfOfContentOwnerChannel <string> This parameter can only be used in a properly authorized request. *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwnerChannel* parameter specifies the YouTube channel ID of the channel to which a video is being added. This parameter is required when a request specifies a value for the onBehalfOfContentOwner parameter, and it can only be used in conjunction with that parameter. In addition, the request must be authorized using a CMS account that is linked to the content owner that the onBehalfOfContentOwner parameter specifies. Finally, the channel that the onBehalfOfContentOwnerChannel parameter value specifies must be linked to the content owner that the onBehalfOfContentOwner parameter specifies. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and perform actions on behalf of the channel specified in the parameter value, without having to provide authentication credentials for each separate channel."
  ([part ChannelSection]
    (channelSections-insert part ChannelSection nil))
  ([part ChannelSection optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/channelSections",
       :uri-template-args {},
       :query-params (merge {:part part} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtubepartner"],
       :body ChannelSection})))

(defn channelSections-list
  "Retrieves a list of resources, possibly filtered.
https://developers.google.com/youtube/v3/docs/channelSections/list

part <string> The *part* parameter specifies a comma-separated list of one or more channelSection resource properties that the API response will include. The part names that you can include in the parameter value are id, snippet, and contentDetails. If the parameter identifies a property that contains child properties, the child properties will be included in the response. For example, in a channelSection resource, the snippet property contains other properties, such as a display title for the channelSection. If you set *part=snippet*, the API response will also contain all of those nested properties.

optional:
id <string> Return the ChannelSections with the given IDs for Stubby or Apiary.
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The CMS account that the user authenticates with must be linked to the specified YouTube content owner.
hl <string> Return content in specified language
channelId <string> Return the ChannelSections owned by the specified channel ID.
mine <boolean> Return the ChannelSections owned by the authenticated user."
  ([part] (channelSections-list part nil))
  ([part optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/channelSections",
       :uri-template-args {},
       :query-params (merge {:part part} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtube.readonly"
        "https://www.googleapis.com/auth/youtubepartner"]})))

(defn channelSections-update
  "Updates an existing resource.
https://developers.google.com/youtube/v3/docs/channelSections/update

part <string> The *part* parameter serves two purposes in this operation. It identifies the properties that the write operation will set as well as the properties that the API response will include. The part names that you can include in the parameter value are snippet and contentDetails.
ChannelSection:
{:contentDetails {:playlists [string], :channels [string]},
 :etag string,
 :id string,
 :snippet
 {:defaultLanguage string,
  :style [channelsectionStyleUnspecified horizontalRow verticalList],
  :position integer,
  :title string,
  :localized {:title string},
  :type
  [channelsectionTypeUndefined
   singlePlaylist
   multiplePlaylists
   popularUploads
   recentUploads
   likes
   allPlaylists
   likedPlaylists
   recentPosts
   recentActivity
   liveEvents
   upcomingEvents
   completedEvents
   multipleChannels
   postedVideos
   postedPlaylists
   subscriptions],
  :channelId string},
 :localizations object,
 :targeting
 {:languages [string], :regions [string], :countries [string]},
 :kind string}

optional:
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The CMS account that the user authenticates with must be linked to the specified YouTube content owner."
  ([part ChannelSection]
    (channelSections-update part ChannelSection nil))
  ([part ChannelSection optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/channelSections",
       :uri-template-args {},
       :query-params (merge {:part part} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtubepartner"],
       :body ChannelSection})))

(defn i18nLanguages-list
  "Retrieves a list of resources, possibly filtered.
https://developers.google.com/youtube/v3/docs/i18nLanguages/list

part <string> The *part* parameter specifies the i18nLanguage resource properties that the API response will include. Set the parameter value to snippet.

optional:
hl <string> "
  ([part] (i18nLanguages-list part nil))
  ([part optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/i18nLanguages",
       :uri-template-args {},
       :query-params (merge {:part part} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtube.readonly"
        "https://www.googleapis.com/auth/youtubepartner"]})))

(defn search-list
  "Retrieves a list of search resources
https://developers.google.com/youtube/v3/docs/search/list

part <string> The *part* parameter specifies a comma-separated list of one or more search resource properties that the API response will include. Set the parameter value to snippet.

optional:
publishedBefore <string> Filter on resources published before this date.
videoDuration <string> Filter on the duration of the videos.
videoSyndicated <string> Filter on syndicated videos.
eventType <string> Filter on the livestream status of the videos.
q <string> Textual search terms to match.
forDeveloper <boolean> Restrict the search to only retrieve videos uploaded using the project id of the authenticated user.
videoCaption <string> Filter on the presence of captions on the videos.
videoEmbeddable <string> Filter on embeddable videos.
channelId <string> Filter on resources belonging to this channelId.
videoDimension <string> Filter on 3d videos.
videoType <string> Filter on videos of a specific type.
topicId <string> Restrict results to a particular topic.
type <string> Restrict results to a particular set of resource types from One Platform.
videoPaidProductPlacement <string> 
safeSearch <string> Indicates whether the search results should include restricted content as well as standard content.
locationRadius <string> Filter on distance from the location (specified above).
videoLicense <string> Filter on the license of the videos.
forContentOwner <boolean> Search owned by a content owner.
regionCode <string> Display the content as seen by viewers in this country.
relevanceLanguage <string> Return results relevant to this language.
publishedAfter <string> Filter on resources published after this date.
order <string> Sort order of the results.
forMine <boolean> Search for the private videos of the authenticated user.
videoDefinition <string> Filter on the definition of the videos.
location <string> Filter on location of the video
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The CMS account that the user authenticates with must be linked to the specified YouTube content owner.
maxResults <integer> The *maxResults* parameter specifies the maximum number of items that should be returned in the result set.
channelType <string> Add a filter on the channel search.
videoCategoryId <string> Filter on videos in a specific category."
  ([part] (search-list part nil))
  ([part optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/search",
       :uri-template-args {},
       :query-params (merge {:part part} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtube.readonly"
        "https://www.googleapis.com/auth/youtubepartner"]})))

(defn commentThreads-list
  "Retrieves a list of resources, possibly filtered.
https://developers.google.com/youtube/v3/docs/commentThreads/list

part <string> The *part* parameter specifies a comma-separated list of one or more commentThread resource properties that the API response will include.

optional:
textFormat <string> The requested text format for the returned comments.
channelId <string> Returns the comment threads for all the channel comments (ie does not include comments left on videos).
allThreadsRelatedToChannelId <string> Returns the comment threads of all videos of the channel and the channel comments as well.
id <string> Returns the comment threads with the given IDs for Stubby or Apiary.
videoId <string> Returns the comment threads of the specified video.
order <string> 
searchTerms <string> Limits the returned comment threads to those matching the specified key words. Not compatible with the 'id' filter.
moderationStatus <string> Limits the returned comment threads to those with the specified moderation status. Not compatible with the 'id' filter. Valid values: published, heldForReview, likelySpam.
maxResults <integer> The *maxResults* parameter specifies the maximum number of items that should be returned in the result set."
  ([part] (commentThreads-list part nil))
  ([part optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/commentThreads",
       :uri-template-args {},
       :query-params (merge {:part part} optional),
       :scopes ["https://www.googleapis.com/auth/youtube.force-ssl"]})))

(defn commentThreads-insert
  "Inserts a new resource into this collection.
https://developers.google.com/youtube/v3/docs/commentThreads/insert

part <string> The *part* parameter identifies the properties that the API response will include. Set the parameter value to snippet. The snippet part has a quota cost of 2 units.
CommentThread:
{:etag string,
 :snippet
 {:channelId string,
  :isPublic boolean,
  :canReply boolean,
  :topLevelComment
  {:etag string,
   :snippet
   {:authorProfileImageUrl string,
    :likeCount integer,
    :publishedAt string,
    :canRate boolean,
    :viewerRating [none like dislike],
    :updatedAt string,
    :authorChannelUrl string,
    :textOriginal string,
    :channelId string,
    :authorDisplayName string,
    :textDisplay string,
    :authorChannelId {:value string},
    :videoId string,
    :parentId string,
    :moderationStatus [published heldForReview likelySpam rejected]},
   :id string,
   :kind string},
  :totalReplyCount integer,
  :videoId string},
 :id string,
 :replies
 {:comments
  [{:etag string,
    :snippet
    {:authorProfileImageUrl string,
     :likeCount integer,
     :publishedAt string,
     :canRate boolean,
     :viewerRating [none like dislike],
     :updatedAt string,
     :authorChannelUrl string,
     :textOriginal string,
     :channelId string,
     :authorDisplayName string,
     :textDisplay string,
     :authorChannelId {:value string},
     :videoId string,
     :parentId string,
     :moderationStatus [published heldForReview likelySpam rejected]},
    :id string,
    :kind string}]},
 :kind string}"
  [part CommentThread]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://youtube.googleapis.com/youtube/v3/commentThreads",
     :uri-template-args {},
     :query-params {:part part},
     :scopes ["https://www.googleapis.com/auth/youtube.force-ssl"],
     :body CommentThread}))

(defn subscriptions-insert
  "Inserts a new resource into this collection.
https://developers.google.com/youtube/v3/docs/subscriptions/insert

part <string> The *part* parameter serves two purposes in this operation. It identifies the properties that the write operation will set as well as the properties that the API response will include.
Subscription:
{:contentDetails
 {:activityType [subscriptionActivityTypeUnspecified all uploads],
  :newItemCount integer,
  :totalItemCount integer},
 :id string,
 :snippet
 {:resourceId
  {:playlistId string,
   :channelId string,
   :kind string,
   :videoId string},
  :channelId string,
  :title string,
  :publishedAt string,
  :channelTitle string,
  :description string,
  :thumbnails
  {:high {:width integer, :height integer, :url string},
   :default {:width integer, :height integer, :url string},
   :maxres {:width integer, :height integer, :url string},
   :medium {:width integer, :height integer, :url string},
   :standard {:width integer, :height integer, :url string}}},
 :subscriberSnippet
 {:channelId string,
  :description string,
  :title string,
  :thumbnails
  {:high {:width integer, :height integer, :url string},
   :default {:width integer, :height integer, :url string},
   :maxres {:width integer, :height integer, :url string},
   :medium {:width integer, :height integer, :url string},
   :standard {:width integer, :height integer, :url string}}},
 :kind string,
 :etag string}"
  [part Subscription]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://youtube.googleapis.com/youtube/v3/subscriptions",
     :uri-template-args {},
     :query-params {:part part},
     :scopes
     ["https://www.googleapis.com/auth/youtube"
      "https://www.googleapis.com/auth/youtube.force-ssl"
      "https://www.googleapis.com/auth/youtubepartner"],
     :body Subscription}))

(defn subscriptions-delete
  "Deletes a resource.
https://developers.google.com/youtube/v3/docs/subscriptions/delete

id <string> "
  [id]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://youtube.googleapis.com/youtube/v3/subscriptions",
     :uri-template-args {},
     :query-params {:id id},
     :scopes
     ["https://www.googleapis.com/auth/youtube"
      "https://www.googleapis.com/auth/youtube.force-ssl"
      "https://www.googleapis.com/auth/youtubepartner"]}))

(defn subscriptions-list
  "Retrieves a list of resources, possibly filtered.
https://developers.google.com/youtube/v3/docs/subscriptions/list

part <string> The *part* parameter specifies a comma-separated list of one or more subscription resource properties that the API response will include. If the parameter identifies a property that contains child properties, the child properties will be included in the response. For example, in a subscription resource, the snippet property contains other properties, such as a display title for the subscription. If you set *part=snippet*, the API response will also contain all of those nested properties.

optional:
forChannelId <string> Return the subscriptions to the subset of these channels that the authenticated user is subscribed to.
onBehalfOfContentOwnerChannel <string> This parameter can only be used in a properly authorized request. *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwnerChannel* parameter specifies the YouTube channel ID of the channel to which a video is being added. This parameter is required when a request specifies a value for the onBehalfOfContentOwner parameter, and it can only be used in conjunction with that parameter. In addition, the request must be authorized using a CMS account that is linked to the content owner that the onBehalfOfContentOwner parameter specifies. Finally, the channel that the onBehalfOfContentOwnerChannel parameter value specifies must be linked to the content owner that the onBehalfOfContentOwner parameter specifies. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and perform actions on behalf of the channel specified in the parameter value, without having to provide authentication credentials for each separate channel.
channelId <string> Return the subscriptions of the given channel owner.
myRecentSubscribers <boolean> 
mine <boolean> Flag for returning the subscriptions of the authenticated user.
id <string> Return the subscriptions with the given IDs for Stubby or Apiary.
order <string> The order of the returned subscriptions
mySubscribers <boolean> Return the subscribers of the given channel owner.
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The CMS account that the user authenticates with must be linked to the specified YouTube content owner.
maxResults <integer> The *maxResults* parameter specifies the maximum number of items that should be returned in the result set."
  ([part] (subscriptions-list part nil))
  ([part optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/subscriptions",
       :uri-template-args {},
       :query-params (merge {:part part} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtube.readonly"
        "https://www.googleapis.com/auth/youtubepartner"]})))

(defn captions-download
  "Downloads a caption track.
https://developers.google.com/youtube/v3/docs/captions/download

id <string> The ID of the caption track to download, required for One Platform.

optional:
tlang <string> tlang is the language code; machine translate the captions into this language.
tfmt <string> Convert the captions into this format. Supported options are sbv, srt, and vtt.
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The actual CMS account that the user authenticates with must be linked to the specified YouTube content owner.
onBehalfOf <string> ID of the Google+ Page for the channel that the request is be on behalf of"
  ([id] (captions-download id nil))
  ([id optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/captions/{id}",
       :uri-template-args {:id id},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtubepartner"]})))

(defn captions-list
  "Retrieves a list of resources, possibly filtered.
https://developers.google.com/youtube/v3/docs/captions/list

part <string> The *part* parameter specifies a comma-separated list of one or more caption resource parts that the API response will include. The part names that you can include in the parameter value are id and snippet.
videoId <string> Returns the captions for the specified video.

optional:
onBehalfOf <string> ID of the Google+ Page for the channel that the request is on behalf of.
id <string> Returns the captions with the given IDs for Stubby or Apiary.
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The actual CMS account that the user authenticates with must be linked to the specified YouTube content owner."
  ([part videoId] (captions-list part videoId nil))
  ([part videoId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/captions",
       :uri-template-args {},
       :query-params (merge {:videoId videoId, :part part} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtubepartner"]})))

(defn captions-insert
  "Inserts a new resource into this collection.
https://developers.google.com/youtube/v3/docs/captions/insert

part <string> The *part* parameter specifies the caption resource parts that the API response will include. Set the parameter value to snippet.
Caption:
{:kind string,
 :snippet
 {:isLarge boolean,
  :trackKind [standard ASR forced],
  :audioTrackType [unknown primary commentary descriptive],
  :name string,
  :isCC boolean,
  :isDraft boolean,
  :isEasyReader boolean,
  :status [serving syncing failed],
  :language string,
  :videoId string,
  :lastUpdated string,
  :failureReason [unknownFormat unsupportedFormat processingFailed],
  :isAutoSynced boolean},
 :id string,
 :etag string}

optional:
onBehalfOf <string> ID of the Google+ Page for the channel that the request is be on behalf of
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The actual CMS account that the user authenticates with must be linked to the specified YouTube content owner.
sync <boolean> Extra parameter to allow automatically syncing the uploaded caption/transcript with the audio."
  ([part Caption] (captions-insert part Caption nil))
  ([part Caption optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/captions",
       :uri-template-args {},
       :query-params (merge {:part part} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtubepartner"],
       :body Caption})))

(defn captions-update
  "Updates an existing resource.
https://developers.google.com/youtube/v3/docs/captions/update

part <string> The *part* parameter specifies a comma-separated list of one or more caption resource parts that the API response will include. The part names that you can include in the parameter value are id and snippet.
Caption:
{:kind string,
 :snippet
 {:isLarge boolean,
  :trackKind [standard ASR forced],
  :audioTrackType [unknown primary commentary descriptive],
  :name string,
  :isCC boolean,
  :isDraft boolean,
  :isEasyReader boolean,
  :status [serving syncing failed],
  :language string,
  :videoId string,
  :lastUpdated string,
  :failureReason [unknownFormat unsupportedFormat processingFailed],
  :isAutoSynced boolean},
 :id string,
 :etag string}

optional:
sync <boolean> Extra parameter to allow automatically syncing the uploaded caption/transcript with the audio.
onBehalfOf <string> ID of the Google+ Page for the channel that the request is on behalf of.
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The actual CMS account that the user authenticates with must be linked to the specified YouTube content owner."
  ([part Caption] (captions-update part Caption nil))
  ([part Caption optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/captions",
       :uri-template-args {},
       :query-params (merge {:part part} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtubepartner"],
       :body Caption})))

(defn captions-delete
  "Deletes a resource.
https://developers.google.com/youtube/v3/docs/captions/delete

id <string> 

optional:
onBehalfOf <string> ID of the Google+ Page for the channel that the request is be on behalf of
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The actual CMS account that the user authenticates with must be linked to the specified YouTube content owner."
  ([id] (captions-delete id nil))
  ([id optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/captions",
       :uri-template-args {},
       :query-params (merge {:id id} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtubepartner"]})))

(defn thirdPartyLinks-insert
  "Inserts a new resource into this collection.
https://developers.google.com/youtube/v3/docs/thirdPartyLinks/insert

part <string> The *part* parameter specifies the thirdPartyLink resource parts that the API request and response will include. Supported values are linkingToken, status, and snippet.
ThirdPartyLink:
{:kind string,
 :etag string,
 :linkingToken string,
 :status {:linkStatus [unknown failed pending linked]},
 :snippet
 {:channelToStoreLink
  {:merchantId string,
   :storeName string,
   :storeUrl string,
   :billingDetails
   {:billingStatus
    [billingStatusUnspecified
     billingStatusPending
     billingStatusActive
     billingStatusInactive]}},
  :type [linkUnspecified channelToStoreLink]}}

optional:
externalChannelId <string> Channel ID to which changes should be applied, for delegation."
  ([part ThirdPartyLink]
    (thirdPartyLinks-insert part ThirdPartyLink nil))
  ([part ThirdPartyLink optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/thirdPartyLinks",
       :uri-template-args {},
       :query-params (merge {:part part} optional),
       :scopes nil,
       :body ThirdPartyLink})))

(defn thirdPartyLinks-list
  "Retrieves a list of resources, possibly filtered.
https://developers.google.com/youtube/v3/docs/thirdPartyLinks/list

part <string> The *part* parameter specifies the thirdPartyLink resource parts that the API response will include. Supported values are linkingToken, status, and snippet.

optional:
externalChannelId <string> Channel ID to which changes should be applied, for delegation.
type <string> Get a third party link of the given type.
linkingToken <string> Get a third party link with the given linking token."
  ([part] (thirdPartyLinks-list part nil))
  ([part optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/thirdPartyLinks",
       :uri-template-args {},
       :query-params (merge {:part part} optional),
       :scopes nil})))

(defn thirdPartyLinks-update
  "Updates an existing resource.
https://developers.google.com/youtube/v3/docs/thirdPartyLinks/update

part <string> The *part* parameter specifies the thirdPartyLink resource parts that the API request and response will include. Supported values are linkingToken, status, and snippet.
ThirdPartyLink:
{:kind string,
 :etag string,
 :linkingToken string,
 :status {:linkStatus [unknown failed pending linked]},
 :snippet
 {:channelToStoreLink
  {:merchantId string,
   :storeName string,
   :storeUrl string,
   :billingDetails
   {:billingStatus
    [billingStatusUnspecified
     billingStatusPending
     billingStatusActive
     billingStatusInactive]}},
  :type [linkUnspecified channelToStoreLink]}}

optional:
externalChannelId <string> Channel ID to which changes should be applied, for delegation."
  ([part ThirdPartyLink]
    (thirdPartyLinks-update part ThirdPartyLink nil))
  ([part ThirdPartyLink optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/thirdPartyLinks",
       :uri-template-args {},
       :query-params (merge {:part part} optional),
       :scopes nil,
       :body ThirdPartyLink})))

(defn thirdPartyLinks-delete
  "Deletes a resource.
https://developers.google.com/youtube/v3/docs/thirdPartyLinks/delete

linkingToken <string> Delete the partner links with the given linking token.
type <string> Type of the link to be deleted.

optional:
externalChannelId <string> Channel ID to which changes should be applied, for delegation.
part <string> Do not use. Required for compatibility."
  ([linkingToken type] (thirdPartyLinks-delete linkingToken type nil))
  ([linkingToken type optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/thirdPartyLinks",
       :uri-template-args {},
       :query-params
       (merge {:type type, :linkingToken linkingToken} optional),
       :scopes nil})))

(defn liveChatModerators-insert
  "Inserts a new resource into this collection.
https://developers.google.com/youtube/v3/docs/liveChatModerators/insert

part <string> The *part* parameter serves two purposes in this operation. It identifies the properties that the write operation will set as well as the properties that the API response returns. Set the parameter value to snippet.
LiveChatModerator:
{:id string,
 :kind string,
 :snippet
 {:moderatorDetails
  {:channelId string,
   :profileImageUrl string,
   :displayName string,
   :channelUrl string},
  :liveChatId string},
 :etag string}"
  [part LiveChatModerator]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://youtube.googleapis.com/youtube/v3/liveChat/moderators",
     :uri-template-args {},
     :query-params {:part part},
     :scopes
     ["https://www.googleapis.com/auth/youtube"
      "https://www.googleapis.com/auth/youtube.force-ssl"],
     :body LiveChatModerator}))

(defn liveChatModerators-list
  "Retrieves a list of resources, possibly filtered.
https://developers.google.com/youtube/v3/docs/liveChatModerators/list

liveChatId <string> The id of the live chat for which moderators should be returned.
part <string> The *part* parameter specifies the liveChatModerator resource parts that the API response will include. Supported values are id and snippet.

optional:
maxResults <integer> The *maxResults* parameter specifies the maximum number of items that should be returned in the result set."
  ([liveChatId part] (liveChatModerators-list liveChatId part nil))
  ([liveChatId part optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/liveChat/moderators",
       :uri-template-args {},
       :query-params
       (merge {:liveChatId liveChatId, :part part} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtube.readonly"]})))

(defn liveChatModerators-delete
  "Deletes a chat moderator.
https://developers.google.com/youtube/v3/docs/liveChatModerators/delete

id <string> "
  [id]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://youtube.googleapis.com/youtube/v3/liveChat/moderators",
     :uri-template-args {},
     :query-params {:id id},
     :scopes
     ["https://www.googleapis.com/auth/youtube"
      "https://www.googleapis.com/auth/youtube.force-ssl"]}))

(defn activities-list
  "Retrieves a list of resources, possibly filtered.
https://developers.google.com/youtube/v3/docs/activities/list

part <string> The *part* parameter specifies a comma-separated list of one or more activity resource properties that the API response will include. If the parameter identifies a property that contains child properties, the child properties will be included in the response. For example, in an activity resource, the snippet property contains other properties that identify the type of activity, a display title for the activity, and so forth. If you set *part=snippet*, the API response will also contain all of those nested properties.

optional:
publishedBefore <string> 
home <boolean> 
channelId <string> 
mine <boolean> 
regionCode <string> 
publishedAfter <string> 
maxResults <integer> The *maxResults* parameter specifies the maximum number of items that should be returned in the result set."
  ([part] (activities-list part nil))
  ([part optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/activities",
       :uri-template-args {},
       :query-params (merge {:part part} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtube.readonly"]})))

(defn liveChatBans-delete
  "Deletes a chat ban.
https://developers.google.com/youtube/v3/docs/liveChatBans/delete

id <string> "
  [id]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://youtube.googleapis.com/youtube/v3/liveChat/bans",
     :uri-template-args {},
     :query-params {:id id},
     :scopes
     ["https://www.googleapis.com/auth/youtube"
      "https://www.googleapis.com/auth/youtube.force-ssl"]}))

(defn liveChatBans-insert
  "Inserts a new resource into this collection.
https://developers.google.com/youtube/v3/docs/liveChatBans/insert

part <string> The *part* parameter serves two purposes in this operation. It identifies the properties that the write operation will set as well as the properties that the API response returns. Set the parameter value to snippet.
LiveChatBan:
{:etag string,
 :snippet
 {:liveChatId string,
  :type [liveChatBanTypeUnspecified permanent temporary],
  :banDurationSeconds string,
  :bannedUserDetails
  {:channelId string,
   :profileImageUrl string,
   :displayName string,
   :channelUrl string}},
 :id string,
 :kind string}"
  [part LiveChatBan]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://youtube.googleapis.com/youtube/v3/liveChat/bans",
     :uri-template-args {},
     :query-params {:part part},
     :scopes
     ["https://www.googleapis.com/auth/youtube"
      "https://www.googleapis.com/auth/youtube.force-ssl"],
     :body LiveChatBan}))

(defn members-list
  "Retrieves a list of members that match the request criteria for a channel.
https://developers.google.com/youtube/v3/docs/members/list

part <string> The *part* parameter specifies the member resource parts that the API response will include. Set the parameter value to snippet.

optional:
hasAccessToLevel <string> Filter members in the results set to the ones that have access to a level.
maxResults <integer> The *maxResults* parameter specifies the maximum number of items that should be returned in the result set.
filterByMemberChannelId <string> Comma separated list of channel IDs. Only data about members that are part of this list will be included in the response.
mode <string> Parameter that specifies which channel members to return."
  ([part] (members-list part nil))
  ([part optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/members",
       :uri-template-args {},
       :query-params (merge {:part part} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube.channel-memberships.creator"]})))

(defn playlistImages-update
  "Updates an existing resource.
https://developers.google.com/youtube/v3/docs/playlistImages/update

PlaylistImage:
{:kind string,
 :id string,
 :snippet
 {:type [hero], :height integer, :width integer, :playlistId string}}

optional:
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The CMS account that the user authenticates with must be linked to the specified YouTube content owner.
part <string> The *part* parameter specifies the properties that the API response will include."
  ([PlaylistImage] (playlistImages-update PlaylistImage nil))
  ([PlaylistImage optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/playlistImages",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtubepartner"],
       :body PlaylistImage})))

(defn playlistImages-insert
  "Inserts a new resource into this collection.
https://developers.google.com/youtube/v3/docs/playlistImages/insert

PlaylistImage:
{:kind string,
 :id string,
 :snippet
 {:type [hero], :height integer, :width integer, :playlistId string}}

optional:
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The CMS account that the user authenticates with must be linked to the specified YouTube content owner.
onBehalfOfContentOwnerChannel <string> This parameter can only be used in a properly authorized request. *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwnerChannel* parameter specifies the YouTube channel ID of the channel to which a video is being added. This parameter is required when a request specifies a value for the onBehalfOfContentOwner parameter, and it can only be used in conjunction with that parameter. In addition, the request must be authorized using a CMS account that is linked to the content owner that the onBehalfOfContentOwner parameter specifies. Finally, the channel that the onBehalfOfContentOwnerChannel parameter value specifies must be linked to the content owner that the onBehalfOfContentOwner parameter specifies. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and perform actions on behalf of the channel specified in the parameter value, without having to provide authentication credentials for each separate channel.
part <string> The *part* parameter specifies the properties that the API response will include."
  ([PlaylistImage] (playlistImages-insert PlaylistImage nil))
  ([PlaylistImage optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/playlistImages",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtubepartner"],
       :body PlaylistImage})))

(defn playlistImages-list
  "Retrieves a list of resources, possibly filtered.
https://developers.google.com/youtube/v3/docs/playlistImages/list

optional:
maxResults <integer> The *maxResults* parameter specifies the maximum number of items that should be returned in the result set.
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The CMS account that the user authenticates with must be linked to the specified YouTube content owner.
onBehalfOfContentOwnerChannel <string> This parameter can only be used in a properly authorized request. *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwnerChannel* parameter specifies the YouTube channel ID of the channel to which a video is being added. This parameter is required when a request specifies a value for the onBehalfOfContentOwner parameter, and it can only be used in conjunction with that parameter. In addition, the request must be authorized using a CMS account that is linked to the content owner that the onBehalfOfContentOwner parameter specifies. Finally, the channel that the onBehalfOfContentOwnerChannel parameter value specifies must be linked to the content owner that the onBehalfOfContentOwner parameter specifies. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and perform actions on behalf of the channel specified in the parameter value, without having to provide authentication credentials for each separate channel.
part <string> The *part* parameter specifies a comma-separated list of one or more playlistImage resource properties that the API response will include. If the parameter identifies a property that contains child properties, the child properties will be included in the response.
parent <string> Return PlaylistImages for this playlist id."
  ([] (playlistImages-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/playlistImages",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtube.readonly"
        "https://www.googleapis.com/auth/youtubepartner"]})))

(defn playlistImages-delete
  "Deletes a resource.
https://developers.google.com/youtube/v3/docs/playlistImages/delete

optional:
onBehalfOfContentOwner <string> *Note:* This parameter is intended exclusively for YouTube content partners. The *onBehalfOfContentOwner* parameter indicates that the request's authorization credentials identify a YouTube CMS user who is acting on behalf of the content owner specified in the parameter value. This parameter is intended for YouTube content partners that own and manage many different YouTube channels. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The CMS account that the user authenticates with must be linked to the specified YouTube content owner.
id <string> Id to identify this image. This is returned from by the List method."
  ([] (playlistImages-delete nil))
  ([optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://youtube.googleapis.com/youtube/v3/playlistImages",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.force-ssl"
        "https://www.googleapis.com/auth/youtubepartner"]})))

(ns happygapi2.groupssettings
  "Groups Settings API
Manages permission levels and related settings of a group.
See: https://developers.google.com/admin-sdk/groups-settings/concepts"
  (:require [happy.oauth2.client :as client]))

(defn groups-get
  "Gets one resource by id.
https://developers.google.com/admin-sdk/groups-settings/concepts

groupUniqueId <string> The group's email address."
  [groupUniqueId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://www.googleapis.com/groups/v1/groups/{groupUniqueId}",
     :uri-template-args {:groupUniqueId groupUniqueId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/apps.groups.settings"]}))

(defn groups-patch
  "Updates an existing resource. This method supports patch semantics.
https://developers.google.com/admin-sdk/groups-settings/concepts

groupUniqueId <string> The group's email address.
Groups:
{:description string,
 :sendMessageDenyNotification string,
 :whoCanModifyMembers string,
 :whoCanViewMembership string,
 :whoCanViewGroup string,
 :whoCanMoveTopicsOut string,
 :whoCanMarkDuplicate string,
 :email string,
 :whoCanModerateMembers string,
 :whoCanInvite string,
 :whoCanDeleteAnyPost string,
 :whoCanJoin string,
 :whoCanMoveTopicsIn string,
 :allowWebPosting string,
 :maxMessageBytes integer,
 :whoCanMarkFavoriteReplyOnOwnTopic string,
 :whoCanBanUsers string,
 :whoCanPostMessage string,
 :favoriteRepliesOnTop string,
 :whoCanAssistContent string,
 :whoCanUnassignTopic string,
 :name string,
 :whoCanMarkNoResponseNeeded string,
 :allowExternalMembers string,
 :default_sender string,
 :defaultMessageDenyNotificationText string,
 :whoCanApproveMembers string,
 :isArchived string,
 :whoCanApproveMessages string,
 :includeCustomFooter string,
 :whoCanHideAbuse string,
 :whoCanContactOwner string,
 :spamModerationLevel string,
 :customFooterText string,
 :whoCanUnmarkFavoriteReplyOnAnyTopic string,
 :whoCanModifyTagsAndCategories string,
 :whoCanMarkFavoriteReplyOnAnyTopic string,
 :whoCanAdd string,
 :whoCanMakeTopicsSticky string,
 :whoCanTakeTopics string,
 :primaryLanguage string,
 :whoCanPostAnnouncements string,
 :whoCanAssignTopics string,
 :whoCanDiscoverGroup string,
 :replyTo string,
 :whoCanLockTopics string,
 :kind string,
 :whoCanDeleteTopics string,
 :whoCanEnterFreeFormTags string,
 :messageModerationLevel string,
 :includeInGlobalAddressList string,
 :whoCanModerateContent string,
 :archiveOnly string,
 :messageDisplayFont string,
 :customRolesEnabledForSettingsToBeMerged string,
 :whoCanAddReferences string,
 :customReplyTo string,
 :whoCanLeaveGroup string,
 :allowGoogleCommunication string,
 :enableCollaborativeInbox string,
 :showInGroupDirectory string,
 :membersCanPostAsTheGroup string}"
  [groupUniqueId Groups]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://www.googleapis.com/groups/v1/groups/{groupUniqueId}",
     :uri-template-args {:groupUniqueId groupUniqueId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/apps.groups.settings"],
     :body Groups}))

(defn groups-update
  "Updates an existing resource.
https://developers.google.com/admin-sdk/groups-settings/concepts

groupUniqueId <string> The group's email address.
Groups:
{:description string,
 :sendMessageDenyNotification string,
 :whoCanModifyMembers string,
 :whoCanViewMembership string,
 :whoCanViewGroup string,
 :whoCanMoveTopicsOut string,
 :whoCanMarkDuplicate string,
 :email string,
 :whoCanModerateMembers string,
 :whoCanInvite string,
 :whoCanDeleteAnyPost string,
 :whoCanJoin string,
 :whoCanMoveTopicsIn string,
 :allowWebPosting string,
 :maxMessageBytes integer,
 :whoCanMarkFavoriteReplyOnOwnTopic string,
 :whoCanBanUsers string,
 :whoCanPostMessage string,
 :favoriteRepliesOnTop string,
 :whoCanAssistContent string,
 :whoCanUnassignTopic string,
 :name string,
 :whoCanMarkNoResponseNeeded string,
 :allowExternalMembers string,
 :default_sender string,
 :defaultMessageDenyNotificationText string,
 :whoCanApproveMembers string,
 :isArchived string,
 :whoCanApproveMessages string,
 :includeCustomFooter string,
 :whoCanHideAbuse string,
 :whoCanContactOwner string,
 :spamModerationLevel string,
 :customFooterText string,
 :whoCanUnmarkFavoriteReplyOnAnyTopic string,
 :whoCanModifyTagsAndCategories string,
 :whoCanMarkFavoriteReplyOnAnyTopic string,
 :whoCanAdd string,
 :whoCanMakeTopicsSticky string,
 :whoCanTakeTopics string,
 :primaryLanguage string,
 :whoCanPostAnnouncements string,
 :whoCanAssignTopics string,
 :whoCanDiscoverGroup string,
 :replyTo string,
 :whoCanLockTopics string,
 :kind string,
 :whoCanDeleteTopics string,
 :whoCanEnterFreeFormTags string,
 :messageModerationLevel string,
 :includeInGlobalAddressList string,
 :whoCanModerateContent string,
 :archiveOnly string,
 :messageDisplayFont string,
 :customRolesEnabledForSettingsToBeMerged string,
 :whoCanAddReferences string,
 :customReplyTo string,
 :whoCanLeaveGroup string,
 :allowGoogleCommunication string,
 :enableCollaborativeInbox string,
 :showInGroupDirectory string,
 :membersCanPostAsTheGroup string}"
  [groupUniqueId Groups]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://www.googleapis.com/groups/v1/groups/{groupUniqueId}",
     :uri-template-args {:groupUniqueId groupUniqueId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/apps.groups.settings"],
     :body Groups}))

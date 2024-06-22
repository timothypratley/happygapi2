(ns happygapi2.gamesConfiguration
  "Google Play Game Services Publishing API
The Google Play Game Services Publishing API allows developers to configure their games in Game Services.
See: https://games.withgoogle.com/"
  (:require [happy.oauth2.client :as client]))

(defn achievementConfigurations-delete
  "Delete the achievement configuration with the given ID.
https://games.withgoogle.com

achievementId <string> The ID of the achievement used by this method."
  [achievementId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://gamesconfiguration.googleapis.com/games/v1configuration/achievements/{achievementId}",
     :uri-template-args {:achievementId achievementId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn achievementConfigurations-get
  "Retrieves the metadata of the achievement configuration with the given ID.
https://games.withgoogle.com

achievementId <string> The ID of the achievement used by this method."
  [achievementId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://gamesconfiguration.googleapis.com/games/v1configuration/achievements/{achievementId}",
     :uri-template-args {:achievementId achievementId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn achievementConfigurations-insert
  "Insert a new achievement configuration in this application.
https://games.withgoogle.com

applicationId <string> The application ID from the Google Play developer console.
AchievementConfiguration:
{:kind string,
 :token string,
 :id string,
 :achievementType [ACHIEVEMENT_TYPE_UNSPECIFIED STANDARD INCREMENTAL],
 :initialState [INITIAL_STATE_UNSPECIFIED HIDDEN REVEALED],
 :stepsToUnlock integer,
 :draft
 {:kind string,
  :name
  {:kind string,
   :translations [{:kind string, :locale string, :value string}]},
  :description
  {:kind string,
   :translations [{:kind string, :locale string, :value string}]},
  :pointValue integer,
  :iconUrl string,
  :sortRank integer},
 :published
 {:kind string,
  :name
  {:kind string,
   :translations [{:kind string, :locale string, :value string}]},
  :description
  {:kind string,
   :translations [{:kind string, :locale string, :value string}]},
  :pointValue integer,
  :iconUrl string,
  :sortRank integer}}"
  [applicationId AchievementConfiguration]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gamesconfiguration.googleapis.com/games/v1configuration/applications/{applicationId}/achievements",
     :uri-template-args {:applicationId applicationId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body AchievementConfiguration}))

(defn achievementConfigurations-list
  "Returns a list of the achievement configurations in this application.
https://games.withgoogle.com

applicationId <string> The application ID from the Google Play developer console.

optional:
maxResults <integer> The maximum number of resource configurations to return in the response, used for paging. For any response, the actual number of resources returned may be less than the specified `maxResults`."
  ([applicationId] (achievementConfigurations-list applicationId nil))
  ([applicationId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gamesconfiguration.googleapis.com/games/v1configuration/applications/{applicationId}/achievements",
       :uri-template-args {:applicationId applicationId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidpublisher"]})))

(defn achievementConfigurations-update
  "Update the metadata of the achievement configuration with the given ID.
https://games.withgoogle.com

achievementId <string> The ID of the achievement used by this method.
AchievementConfiguration:
{:kind string,
 :token string,
 :id string,
 :achievementType [ACHIEVEMENT_TYPE_UNSPECIFIED STANDARD INCREMENTAL],
 :initialState [INITIAL_STATE_UNSPECIFIED HIDDEN REVEALED],
 :stepsToUnlock integer,
 :draft
 {:kind string,
  :name
  {:kind string,
   :translations [{:kind string, :locale string, :value string}]},
  :description
  {:kind string,
   :translations [{:kind string, :locale string, :value string}]},
  :pointValue integer,
  :iconUrl string,
  :sortRank integer},
 :published
 {:kind string,
  :name
  {:kind string,
   :translations [{:kind string, :locale string, :value string}]},
  :description
  {:kind string,
   :translations [{:kind string, :locale string, :value string}]},
  :pointValue integer,
  :iconUrl string,
  :sortRank integer}}"
  [achievementId AchievementConfiguration]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://gamesconfiguration.googleapis.com/games/v1configuration/achievements/{achievementId}",
     :uri-template-args {:achievementId achievementId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body AchievementConfiguration}))

(defn leaderboardConfigurations-delete
  "Delete the leaderboard configuration with the given ID.
https://games.withgoogle.com

leaderboardId <string> The ID of the leaderboard."
  [leaderboardId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://gamesconfiguration.googleapis.com/games/v1configuration/leaderboards/{leaderboardId}",
     :uri-template-args {:leaderboardId leaderboardId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn leaderboardConfigurations-get
  "Retrieves the metadata of the leaderboard configuration with the given ID.
https://games.withgoogle.com

leaderboardId <string> The ID of the leaderboard."
  [leaderboardId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://gamesconfiguration.googleapis.com/games/v1configuration/leaderboards/{leaderboardId}",
     :uri-template-args {:leaderboardId leaderboardId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn leaderboardConfigurations-insert
  "Insert a new leaderboard configuration in this application.
https://games.withgoogle.com

applicationId <string> The application ID from the Google Play developer console.
LeaderboardConfiguration:
{:kind string,
 :token string,
 :id string,
 :scoreOrder
 [SCORE_ORDER_UNSPECIFIED LARGER_IS_BETTER SMALLER_IS_BETTER],
 :scoreMin string,
 :scoreMax string,
 :draft
 {:kind string,
  :name
  {:kind string,
   :translations [{:kind string, :locale string, :value string}]},
  :iconUrl string,
  :sortRank integer,
  :scoreFormat
  {:numberFormatType
   [NUMBER_FORMAT_TYPE_UNSPECIFIED NUMERIC TIME_DURATION CURRENCY],
   :suffix
   {:zero {:kind string, :translations [LocalizedString]},
    :one {:kind string, :translations [LocalizedString]},
    :two {:kind string, :translations [LocalizedString]},
    :few {:kind string, :translations [LocalizedString]},
    :many {:kind string, :translations [LocalizedString]},
    :other {:kind string, :translations [LocalizedString]}},
   :numDecimalPlaces integer,
   :currencyCode string}},
 :published
 {:kind string,
  :name
  {:kind string,
   :translations [{:kind string, :locale string, :value string}]},
  :iconUrl string,
  :sortRank integer,
  :scoreFormat
  {:numberFormatType
   [NUMBER_FORMAT_TYPE_UNSPECIFIED NUMERIC TIME_DURATION CURRENCY],
   :suffix
   {:zero {:kind string, :translations [LocalizedString]},
    :one {:kind string, :translations [LocalizedString]},
    :two {:kind string, :translations [LocalizedString]},
    :few {:kind string, :translations [LocalizedString]},
    :many {:kind string, :translations [LocalizedString]},
    :other {:kind string, :translations [LocalizedString]}},
   :numDecimalPlaces integer,
   :currencyCode string}}}"
  [applicationId LeaderboardConfiguration]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gamesconfiguration.googleapis.com/games/v1configuration/applications/{applicationId}/leaderboards",
     :uri-template-args {:applicationId applicationId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body LeaderboardConfiguration}))

(defn leaderboardConfigurations-list
  "Returns a list of the leaderboard configurations in this application.
https://games.withgoogle.com

applicationId <string> The application ID from the Google Play developer console.

optional:
maxResults <integer> The maximum number of resource configurations to return in the response, used for paging. For any response, the actual number of resources returned may be less than the specified `maxResults`."
  ([applicationId] (leaderboardConfigurations-list applicationId nil))
  ([applicationId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gamesconfiguration.googleapis.com/games/v1configuration/applications/{applicationId}/leaderboards",
       :uri-template-args {:applicationId applicationId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidpublisher"]})))

(defn leaderboardConfigurations-update
  "Update the metadata of the leaderboard configuration with the given ID.
https://games.withgoogle.com

leaderboardId <string> The ID of the leaderboard.
LeaderboardConfiguration:
{:kind string,
 :token string,
 :id string,
 :scoreOrder
 [SCORE_ORDER_UNSPECIFIED LARGER_IS_BETTER SMALLER_IS_BETTER],
 :scoreMin string,
 :scoreMax string,
 :draft
 {:kind string,
  :name
  {:kind string,
   :translations [{:kind string, :locale string, :value string}]},
  :iconUrl string,
  :sortRank integer,
  :scoreFormat
  {:numberFormatType
   [NUMBER_FORMAT_TYPE_UNSPECIFIED NUMERIC TIME_DURATION CURRENCY],
   :suffix
   {:zero {:kind string, :translations [LocalizedString]},
    :one {:kind string, :translations [LocalizedString]},
    :two {:kind string, :translations [LocalizedString]},
    :few {:kind string, :translations [LocalizedString]},
    :many {:kind string, :translations [LocalizedString]},
    :other {:kind string, :translations [LocalizedString]}},
   :numDecimalPlaces integer,
   :currencyCode string}},
 :published
 {:kind string,
  :name
  {:kind string,
   :translations [{:kind string, :locale string, :value string}]},
  :iconUrl string,
  :sortRank integer,
  :scoreFormat
  {:numberFormatType
   [NUMBER_FORMAT_TYPE_UNSPECIFIED NUMERIC TIME_DURATION CURRENCY],
   :suffix
   {:zero {:kind string, :translations [LocalizedString]},
    :one {:kind string, :translations [LocalizedString]},
    :two {:kind string, :translations [LocalizedString]},
    :few {:kind string, :translations [LocalizedString]},
    :many {:kind string, :translations [LocalizedString]},
    :other {:kind string, :translations [LocalizedString]}},
   :numDecimalPlaces integer,
   :currencyCode string}}}"
  [leaderboardId LeaderboardConfiguration]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://gamesconfiguration.googleapis.com/games/v1configuration/leaderboards/{leaderboardId}",
     :uri-template-args {:leaderboardId leaderboardId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body LeaderboardConfiguration}))

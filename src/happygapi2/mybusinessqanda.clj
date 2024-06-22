(ns happygapi2.mybusinessqanda
  "My Business Q&A API
The My Business Q&A API allows questions and answers to be posted for specific listings. Note - If you have a quota of 0 after enabling the API, please request for GBP API access.
See: https://developers.google.com/my-business/"
  (:require [happy.oauth2.client :as client]))

(defn locations-questions-list
  "Returns the paginated list of questions and some of its answers for a specified location. This operation is only valid if the specified location is verified.
https://developers.google.com/my-business

parent <string> Required. The name of the location to fetch questions for.

optional:
pageSize <integer> Optional. How many questions to fetch per page. The default and maximum `page_size` values are 10.
answersPerQuestion <integer> Optional. How many answers to fetch per question. The default and maximum `answers_per_question` values are 10.
filter <string> Optional. A filter constraining the questions to return. The only filter currently supported is \"ignore_answered=true\"
orderBy <string> Optional. The order to return the questions. Valid options include 'update_time desc' and 'upvote_count desc', which will return the questions sorted descendingly by the requested field. The default sort order is 'update_time desc'."
  ([parent] (locations-questions-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://mybusinessqanda.googleapis.com/v1/{+parent}",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes nil})))

(defn locations-questions-create
  "Adds a question for the specified location.
https://developers.google.com/my-business

parent <string> Required. The name of the location to write a question for.
Question:
{:name string,
 :author
 {:displayName string,
  :profilePhotoUri string,
  :type [AUTHOR_TYPE_UNSPECIFIED REGULAR_USER LOCAL_GUIDE MERCHANT]},
 :upvoteCount integer,
 :text string,
 :createTime string,
 :updateTime string,
 :topAnswers
 [{:name string,
   :author
   {:displayName string,
    :profilePhotoUri string,
    :type [AUTHOR_TYPE_UNSPECIFIED REGULAR_USER LOCAL_GUIDE MERCHANT]},
   :upvoteCount integer,
   :text string,
   :createTime string,
   :updateTime string}],
 :totalAnswerCount integer}"
  [parent Question]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://mybusinessqanda.googleapis.com/v1/{+parent}",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes nil,
     :body Question}))

(defn locations-questions-patch
  "Updates a specific question written by the current user.
https://developers.google.com/my-business

name <string> Immutable. The unique name for the question. locations/*/questions/* This field will be ignored if set during question creation.
Question:
{:name string,
 :author
 {:displayName string,
  :profilePhotoUri string,
  :type [AUTHOR_TYPE_UNSPECIFIED REGULAR_USER LOCAL_GUIDE MERCHANT]},
 :upvoteCount integer,
 :text string,
 :createTime string,
 :updateTime string,
 :topAnswers
 [{:name string,
   :author
   {:displayName string,
    :profilePhotoUri string,
    :type [AUTHOR_TYPE_UNSPECIFIED REGULAR_USER LOCAL_GUIDE MERCHANT]},
   :upvoteCount integer,
   :text string,
   :createTime string,
   :updateTime string}],
 :totalAnswerCount integer}

optional:
updateMask <string> Required. The specific fields to update. Only question text can be updated."
  ([name Question] (locations-questions-patch name Question nil))
  ([name Question optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://mybusinessqanda.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes nil,
       :body Question})))

(defn locations-questions-delete
  "Deletes a specific question written by the current user.
https://developers.google.com/my-business

name <string> Required. The name of the question to delete."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://mybusinessqanda.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes nil}))

(defn locations-questions-answers-list
  "Returns the paginated list of answers for a specified question.
https://developers.google.com/my-business

parent <string> Required. The name of the question to fetch answers for.

optional:
pageSize <integer> Optional. How many answers to fetch per page. The default and maximum `page_size` values are 10.
orderBy <string> Optional. The order to return the answers. Valid options include 'update_time desc' and 'upvote_count desc', which will return the answers sorted descendingly by the requested field. The default sort order is 'update_time desc'."
  ([parent] (locations-questions-answers-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://mybusinessqanda.googleapis.com/v1/{+parent}/answers",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes nil})))

(defn locations-questions-answers-upsert
  "Creates an answer or updates the existing answer written by the user for the specified question. A user can only create one answer per question.
https://developers.google.com/my-business

parent <string> Required. The name of the question to write an answer for.
UpsertAnswerRequest:
{:answer
 {:name string,
  :author
  {:displayName string,
   :profilePhotoUri string,
   :type [AUTHOR_TYPE_UNSPECIFIED REGULAR_USER LOCAL_GUIDE MERCHANT]},
  :upvoteCount integer,
  :text string,
  :createTime string,
  :updateTime string}}"
  [parent UpsertAnswerRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://mybusinessqanda.googleapis.com/v1/{+parent}/answers:upsert",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes nil,
     :body UpsertAnswerRequest}))

(defn locations-questions-answers-delete
  "Deletes the answer written by the current user to a question.
https://developers.google.com/my-business

name <string> Required. The name of the question to delete an answer for."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://mybusinessqanda.googleapis.com/v1/{+name}/answers:delete",
     :uri-template-args {:name name},
     :query-params {},
     :scopes nil}))

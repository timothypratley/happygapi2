(ns happygapi2.blogger
  "Blogger API
The Blogger API provides access to posts, comments and pages of a Blogger blog.
See: https://developers.google.com/blogger/docs/3.0/getting_started"
  (:require [happy.oauth2.client :as client]))

(defn postUserInfos-get
  "Gets one post and user info pair, by post_id and user_id.
https://developers.google.com/blogger/docs/3.0/getting_started

userId <string> 
blogId <string> 
postId <string> 

optional:
maxComments <integer> "
  ([userId blogId postId] (postUserInfos-get userId blogId postId nil))
  ([userId blogId postId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://blogger.googleapis.com/v3/users/{userId}/blogs/{blogId}/posts/{postId}",
       :uri-template-args
       {:postId postId, :blogId blogId, :userId userId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/blogger"
        "https://www.googleapis.com/auth/blogger.readonly"]})))

(defn postUserInfos-list
  "Lists post and user info pairs.
https://developers.google.com/blogger/docs/3.0/getting_started

userId <string> 
blogId <string> 

optional:
labels <string> 
startDate <string> 
endDate <string> 
fetchBodies <boolean> 
status <string> 
maxResults <integer> 
view <string> 
orderBy <string> "
  ([userId blogId] (postUserInfos-list userId blogId nil))
  ([userId blogId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://blogger.googleapis.com/v3/users/{userId}/blogs/{blogId}/posts",
       :uri-template-args {:blogId blogId, :userId userId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/blogger"
        "https://www.googleapis.com/auth/blogger.readonly"]})))

(defn blogUserInfos-get
  "Gets one blog and user info pair by blog id and user id.
https://developers.google.com/blogger/docs/3.0/getting_started

userId <string> 
blogId <string> 

optional:
maxPosts <integer> "
  ([userId blogId] (blogUserInfos-get userId blogId nil))
  ([userId blogId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://blogger.googleapis.com/v3/users/{userId}/blogs/{blogId}",
       :uri-template-args {:blogId blogId, :userId userId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/blogger"
        "https://www.googleapis.com/auth/blogger.readonly"]})))

(defn pageViews-get
  "Gets page views by blog id.
https://developers.google.com/blogger/docs/3.0/getting_started

blogId <string> 

optional:
range <string> "
  ([blogId] (pageViews-get blogId nil))
  ([blogId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://blogger.googleapis.com/v3/blogs/{blogId}/pageviews",
       :uri-template-args {:blogId blogId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/blogger"]})))

(defn posts-get
  "Gets a post by blog id and post id
https://developers.google.com/blogger/docs/3.0/getting_started

blogId <string> 
postId <string> 

optional:
fetchBody <boolean> 
view <string> 
fetchImages <boolean> 
maxComments <integer> "
  ([blogId postId] (posts-get blogId postId nil))
  ([blogId postId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://blogger.googleapis.com/v3/blogs/{blogId}/posts/{postId}",
       :uri-template-args {:postId postId, :blogId blogId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/blogger"
        "https://www.googleapis.com/auth/blogger.readonly"]})))

(defn posts-insert
  "Inserts a post.
https://developers.google.com/blogger/docs/3.0/getting_started

blogId <string> 
Post:
{:labels [string],
 :titleLink string,
 :content string,
 :updated string,
 :images [{:url string}],
 :selfLink string,
 :etag string,
 :title string,
 :author
 {:displayName string, :id string, :url string, :image {:url string}},
 :replies
 {:items
  [{:inReplyTo {:id string},
    :content string,
    :updated string,
    :selfLink string,
    :author
    {:displayName string,
     :url string,
     :id string,
     :image {:url string}},
    :status [LIVE EMPTIED PENDING SPAM],
    :id string,
    :kind string,
    :post {:id string},
    :blog {:id string},
    :published string}],
  :totalItems string,
  :selfLink string},
 :status [LIVE DRAFT SCHEDULED SOFT_TRASHED],
 :customMetaData string,
 :trashed string,
 :id string,
 :kind string,
 :url string,
 :readerComments
 [ALLOW DONT_ALLOW_SHOW_EXISTING DONT_ALLOW_HIDE_EXISTING],
 :location {:lng number, :span string, :name string, :lat number},
 :blog {:id string},
 :published string}

optional:
isDraft <boolean> 
fetchBody <boolean> 
fetchImages <boolean> "
  ([blogId Post] (posts-insert blogId Post nil))
  ([blogId Post optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://blogger.googleapis.com/v3/blogs/{blogId}/posts",
       :uri-template-args {:blogId blogId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/blogger"],
       :body Post})))

(defn posts-patch
  "Patches a post.
https://developers.google.com/blogger/docs/3.0/getting_started

blogId <string> 
postId <string> 
Post:
{:labels [string],
 :titleLink string,
 :content string,
 :updated string,
 :images [{:url string}],
 :selfLink string,
 :etag string,
 :title string,
 :author
 {:displayName string, :id string, :url string, :image {:url string}},
 :replies
 {:items
  [{:inReplyTo {:id string},
    :content string,
    :updated string,
    :selfLink string,
    :author
    {:displayName string,
     :url string,
     :id string,
     :image {:url string}},
    :status [LIVE EMPTIED PENDING SPAM],
    :id string,
    :kind string,
    :post {:id string},
    :blog {:id string},
    :published string}],
  :totalItems string,
  :selfLink string},
 :status [LIVE DRAFT SCHEDULED SOFT_TRASHED],
 :customMetaData string,
 :trashed string,
 :id string,
 :kind string,
 :url string,
 :readerComments
 [ALLOW DONT_ALLOW_SHOW_EXISTING DONT_ALLOW_HIDE_EXISTING],
 :location {:lng number, :span string, :name string, :lat number},
 :blog {:id string},
 :published string}

optional:
fetchImages <boolean> 
publish <boolean> 
maxComments <integer> 
fetchBody <boolean> 
revert <boolean> "
  ([blogId postId Post] (posts-patch blogId postId Post nil))
  ([blogId postId Post optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://blogger.googleapis.com/v3/blogs/{blogId}/posts/{postId}",
       :uri-template-args {:postId postId, :blogId blogId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/blogger"],
       :body Post})))

(defn posts-update
  "Updates a post by blog id and post id.
https://developers.google.com/blogger/docs/3.0/getting_started

blogId <string> 
postId <string> 
Post:
{:labels [string],
 :titleLink string,
 :content string,
 :updated string,
 :images [{:url string}],
 :selfLink string,
 :etag string,
 :title string,
 :author
 {:displayName string, :id string, :url string, :image {:url string}},
 :replies
 {:items
  [{:inReplyTo {:id string},
    :content string,
    :updated string,
    :selfLink string,
    :author
    {:displayName string,
     :url string,
     :id string,
     :image {:url string}},
    :status [LIVE EMPTIED PENDING SPAM],
    :id string,
    :kind string,
    :post {:id string},
    :blog {:id string},
    :published string}],
  :totalItems string,
  :selfLink string},
 :status [LIVE DRAFT SCHEDULED SOFT_TRASHED],
 :customMetaData string,
 :trashed string,
 :id string,
 :kind string,
 :url string,
 :readerComments
 [ALLOW DONT_ALLOW_SHOW_EXISTING DONT_ALLOW_HIDE_EXISTING],
 :location {:lng number, :span string, :name string, :lat number},
 :blog {:id string},
 :published string}

optional:
fetchImages <boolean> 
revert <boolean> 
maxComments <integer> 
publish <boolean> 
fetchBody <boolean> "
  ([blogId postId Post] (posts-update blogId postId Post nil))
  ([blogId postId Post optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://blogger.googleapis.com/v3/blogs/{blogId}/posts/{postId}",
       :uri-template-args {:postId postId, :blogId blogId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/blogger"],
       :body Post})))

(defn posts-delete
  "Deletes a post by blog id and post id.
https://developers.google.com/blogger/docs/3.0/getting_started

blogId <string> 
postId <string> 

optional:
useTrash <boolean> Move to Trash if possible"
  ([blogId postId] (posts-delete blogId postId nil))
  ([blogId postId optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://blogger.googleapis.com/v3/blogs/{blogId}/posts/{postId}",
       :uri-template-args {:blogId blogId, :postId postId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/blogger"]})))

(defn posts-search
  "Searches for posts matching given query terms in the specified blog.
https://developers.google.com/blogger/docs/3.0/getting_started

blogId <string> 
q <string> 

optional:
orderBy <string> 
fetchBodies <boolean> "
  ([blogId q] (posts-search blogId q nil))
  ([blogId q optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://blogger.googleapis.com/v3/blogs/{blogId}/posts/search",
       :uri-template-args {:blogId blogId},
       :query-params (merge {:q q} optional),
       :scopes
       ["https://www.googleapis.com/auth/blogger"
        "https://www.googleapis.com/auth/blogger.readonly"]})))

(defn posts-revert
  "Reverts a published or scheduled post to draft state.
https://developers.google.com/blogger/docs/3.0/getting_started

blogId <string> 
postId <string> "
  [blogId postId]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://blogger.googleapis.com/v3/blogs/{blogId}/posts/{postId}/revert",
     :uri-template-args {:postId postId, :blogId blogId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/blogger"]}))

(defn posts-list
  "Lists posts.
https://developers.google.com/blogger/docs/3.0/getting_started

blogId <string> 

optional:
labels <string> 
startDate <string> 
sortOption <string> Sort direction applied to post list.
endDate <string> 
fetchBodies <boolean> 
status <string> 
fetchImages <boolean> 
maxResults <integer> 
view <string> 
orderBy <string> "
  ([blogId] (posts-list blogId nil))
  ([blogId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://blogger.googleapis.com/v3/blogs/{blogId}/posts",
       :uri-template-args {:blogId blogId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/blogger"
        "https://www.googleapis.com/auth/blogger.readonly"]})))

(defn posts-publish
  "Publishes a post.
https://developers.google.com/blogger/docs/3.0/getting_started

blogId <string> 
postId <string> 

optional:
publishDate <string> "
  ([blogId postId] (posts-publish blogId postId nil))
  ([blogId postId optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://blogger.googleapis.com/v3/blogs/{blogId}/posts/{postId}/publish",
       :uri-template-args {:postId postId, :blogId blogId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/blogger"]})))

(defn posts-getByPath
  "Gets a post by path.
https://developers.google.com/blogger/docs/3.0/getting_started

blogId <string> 
path <string> 

optional:
view <string> 
maxComments <integer> "
  ([blogId path] (posts-getByPath blogId path nil))
  ([blogId path optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://blogger.googleapis.com/v3/blogs/{blogId}/posts/bypath",
       :uri-template-args {:blogId blogId},
       :query-params (merge {:path path} optional),
       :scopes
       ["https://www.googleapis.com/auth/blogger"
        "https://www.googleapis.com/auth/blogger.readonly"]})))

(defn users-get
  "Gets one user by user_id.
https://developers.google.com/blogger/docs/3.0/getting_started

userId <string> "
  [userId]
  (client/api-request
    {:method "GET",
     :uri-template "https://blogger.googleapis.com/v3/users/{userId}",
     :uri-template-args {:userId userId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/blogger"
      "https://www.googleapis.com/auth/blogger.readonly"]}))

(defn comments-list
  "Lists comments.
https://developers.google.com/blogger/docs/3.0/getting_started

blogId <string> 
postId <string> 

optional:
startDate <string> 
endDate <string> 
fetchBodies <boolean> 
status <string> 
maxResults <integer> 
view <string> "
  ([blogId postId] (comments-list blogId postId nil))
  ([blogId postId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://blogger.googleapis.com/v3/blogs/{blogId}/posts/{postId}/comments",
       :uri-template-args {:blogId blogId, :postId postId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/blogger"
        "https://www.googleapis.com/auth/blogger.readonly"]})))

(defn comments-delete
  "Deletes a comment by blog id, post id and comment id.
https://developers.google.com/blogger/docs/3.0/getting_started

blogId <string> 
postId <string> 
commentId <string> "
  [blogId postId commentId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://blogger.googleapis.com/v3/blogs/{blogId}/posts/{postId}/comments/{commentId}",
     :uri-template-args
     {:postId postId, :blogId blogId, :commentId commentId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/blogger"]}))

(defn comments-get
  "Gets a comment by id.
https://developers.google.com/blogger/docs/3.0/getting_started

blogId <string> 
postId <string> 
commentId <string> 

optional:
view <string> "
  ([blogId postId commentId]
    (comments-get blogId postId commentId nil))
  ([blogId postId commentId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://blogger.googleapis.com/v3/blogs/{blogId}/posts/{postId}/comments/{commentId}",
       :uri-template-args
       {:postId postId, :commentId commentId, :blogId blogId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/blogger"
        "https://www.googleapis.com/auth/blogger.readonly"]})))

(defn comments-markAsSpam
  "Marks a comment as spam by blog id, post id and comment id.
https://developers.google.com/blogger/docs/3.0/getting_started

blogId <string> 
postId <string> 
commentId <string> "
  [blogId postId commentId]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://blogger.googleapis.com/v3/blogs/{blogId}/posts/{postId}/comments/{commentId}/spam",
     :uri-template-args
     {:blogId blogId, :commentId commentId, :postId postId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/blogger"]}))

(defn comments-removeContent
  "Removes the content of a comment by blog id, post id and comment id.
https://developers.google.com/blogger/docs/3.0/getting_started

blogId <string> 
postId <string> 
commentId <string> "
  [blogId postId commentId]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://blogger.googleapis.com/v3/blogs/{blogId}/posts/{postId}/comments/{commentId}/removecontent",
     :uri-template-args
     {:commentId commentId, :blogId blogId, :postId postId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/blogger"]}))

(defn comments-approve
  "Marks a comment as not spam by blog id, post id and comment id.
https://developers.google.com/blogger/docs/3.0/getting_started

blogId <string> 
postId <string> 
commentId <string> "
  [blogId postId commentId]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://blogger.googleapis.com/v3/blogs/{blogId}/posts/{postId}/comments/{commentId}/approve",
     :uri-template-args
     {:commentId commentId, :postId postId, :blogId blogId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/blogger"]}))

(defn comments-listByBlog
  "Lists comments by blog.
https://developers.google.com/blogger/docs/3.0/getting_started

blogId <string> 

optional:
maxResults <integer> 
endDate <string> 
fetchBodies <boolean> 
startDate <string> 
status <string> "
  ([blogId] (comments-listByBlog blogId nil))
  ([blogId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://blogger.googleapis.com/v3/blogs/{blogId}/comments",
       :uri-template-args {:blogId blogId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/blogger"
        "https://www.googleapis.com/auth/blogger.readonly"]})))

(defn pages-revert
  "Reverts a published or scheduled page to draft state.
https://developers.google.com/blogger/docs/3.0/getting_started

blogId <string> 
pageId <string> "
  [blogId pageId]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://blogger.googleapis.com/v3/blogs/{blogId}/pages/{pageId}/revert",
     :uri-template-args {:pageId pageId, :blogId blogId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/blogger"]}))

(defn pages-list
  "Lists pages.
https://developers.google.com/blogger/docs/3.0/getting_started

blogId <string> 

optional:
maxResults <integer> 
fetchBodies <boolean> 
status <string> 
view <string> "
  ([blogId] (pages-list blogId nil))
  ([blogId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://blogger.googleapis.com/v3/blogs/{blogId}/pages",
       :uri-template-args {:blogId blogId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/blogger"
        "https://www.googleapis.com/auth/blogger.readonly"]})))

(defn pages-patch
  "Patches a page.
https://developers.google.com/blogger/docs/3.0/getting_started

blogId <string> 
pageId <string> 
Page:
{:content string,
 :updated string,
 :selfLink string,
 :etag string,
 :title string,
 :author
 {:url string, :displayName string, :id string, :image {:url string}},
 :status [LIVE DRAFT SOFT_TRASHED],
 :trashed string,
 :id string,
 :kind string,
 :url string,
 :blog {:id string},
 :published string}

optional:
publish <boolean> 
revert <boolean> "
  ([blogId pageId Page] (pages-patch blogId pageId Page nil))
  ([blogId pageId Page optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://blogger.googleapis.com/v3/blogs/{blogId}/pages/{pageId}",
       :uri-template-args {:pageId pageId, :blogId blogId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/blogger"],
       :body Page})))

(defn pages-get
  "Gets a page by blog id and page id.
https://developers.google.com/blogger/docs/3.0/getting_started

blogId <string> 
pageId <string> 

optional:
view <string> "
  ([blogId pageId] (pages-get blogId pageId nil))
  ([blogId pageId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://blogger.googleapis.com/v3/blogs/{blogId}/pages/{pageId}",
       :uri-template-args {:blogId blogId, :pageId pageId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/blogger"
        "https://www.googleapis.com/auth/blogger.readonly"]})))

(defn pages-delete
  "Deletes a page by blog id and page id.
https://developers.google.com/blogger/docs/3.0/getting_started

blogId <string> 
pageId <string> 

optional:
useTrash <boolean> Move to Trash if possible"
  ([blogId pageId] (pages-delete blogId pageId nil))
  ([blogId pageId optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://blogger.googleapis.com/v3/blogs/{blogId}/pages/{pageId}",
       :uri-template-args {:blogId blogId, :pageId pageId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/blogger"]})))

(defn pages-update
  "Updates a page by blog id and page id.
https://developers.google.com/blogger/docs/3.0/getting_started

blogId <string> 
pageId <string> 
Page:
{:content string,
 :updated string,
 :selfLink string,
 :etag string,
 :title string,
 :author
 {:url string, :displayName string, :id string, :image {:url string}},
 :status [LIVE DRAFT SOFT_TRASHED],
 :trashed string,
 :id string,
 :kind string,
 :url string,
 :blog {:id string},
 :published string}

optional:
publish <boolean> 
revert <boolean> "
  ([blogId pageId Page] (pages-update blogId pageId Page nil))
  ([blogId pageId Page optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://blogger.googleapis.com/v3/blogs/{blogId}/pages/{pageId}",
       :uri-template-args {:pageId pageId, :blogId blogId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/blogger"],
       :body Page})))

(defn pages-publish
  "Publishes a page.
https://developers.google.com/blogger/docs/3.0/getting_started

blogId <string> 
pageId <string> "
  [blogId pageId]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://blogger.googleapis.com/v3/blogs/{blogId}/pages/{pageId}/publish",
     :uri-template-args {:blogId blogId, :pageId pageId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/blogger"]}))

(defn pages-insert
  "Inserts a page.
https://developers.google.com/blogger/docs/3.0/getting_started

blogId <string> 
Page:
{:content string,
 :updated string,
 :selfLink string,
 :etag string,
 :title string,
 :author
 {:url string, :displayName string, :id string, :image {:url string}},
 :status [LIVE DRAFT SOFT_TRASHED],
 :trashed string,
 :id string,
 :kind string,
 :url string,
 :blog {:id string},
 :published string}

optional:
isDraft <boolean> "
  ([blogId Page] (pages-insert blogId Page nil))
  ([blogId Page optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://blogger.googleapis.com/v3/blogs/{blogId}/pages",
       :uri-template-args {:blogId blogId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/blogger"],
       :body Page})))

(defn blogs-get
  "Gets a blog by id.
https://developers.google.com/blogger/docs/3.0/getting_started

blogId <string> 

optional:
view <string> 
maxPosts <integer> "
  ([blogId] (blogs-get blogId nil))
  ([blogId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://blogger.googleapis.com/v3/blogs/{blogId}",
       :uri-template-args {:blogId blogId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/blogger"
        "https://www.googleapis.com/auth/blogger.readonly"]})))

(defn blogs-listByUser
  "Lists blogs by user.
https://developers.google.com/blogger/docs/3.0/getting_started

userId <string> 

optional:
role <string> 
status <string> Default value of status is LIVE.
view <string> 
fetchUserInfo <boolean> "
  ([userId] (blogs-listByUser userId nil))
  ([userId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://blogger.googleapis.com/v3/users/{userId}/blogs",
       :uri-template-args {:userId userId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/blogger"
        "https://www.googleapis.com/auth/blogger.readonly"]})))

(defn blogs-getByUrl
  "Gets a blog by url.
https://developers.google.com/blogger/docs/3.0/getting_started

url <string> 

optional:
view <string> "
  ([url] (blogs-getByUrl url nil))
  ([url optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://blogger.googleapis.com/v3/blogs/byurl",
       :uri-template-args {},
       :query-params (merge {:url url} optional),
       :scopes
       ["https://www.googleapis.com/auth/blogger"
        "https://www.googleapis.com/auth/blogger.readonly"]})))

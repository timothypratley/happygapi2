(ns happygapi2.tasks
  "Google Tasks API
The Google Tasks API lets you manage your tasks and task lists.
See: https://developers.google.com/tasks/"
  (:require [happy.oauth2.client :as client]))

(defn tasks-patch
  "Updates the specified task. This method supports patch semantics.
https://developers.google.com/tasks/reference/rest/v1/tasks/patch

tasklist <string> Task list identifier.
task <string> Task identifier.
Task:
{:deleted boolean,
 :parent string,
 :updated string,
 :completed string,
 :selfLink string,
 :etag string,
 :due string,
 :title string,
 :status string,
 :hidden boolean,
 :id string,
 :kind string,
 :notes string,
 :position string,
 :webViewLink string,
 :links [{:type string, :link string, :description string}]}"
  [tasklist task Task]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://tasks.googleapis.com/tasks/v1/lists/{tasklist}/tasks/{task}",
     :uri-template-args {:tasklist tasklist, :task task},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/tasks"],
     :body Task}))

(defn tasks-update
  "Updates the specified task.
https://developers.google.com/tasks/reference/rest/v1/tasks/update

tasklist <string> Task list identifier.
task <string> Task identifier.
Task:
{:deleted boolean,
 :parent string,
 :updated string,
 :completed string,
 :selfLink string,
 :etag string,
 :due string,
 :title string,
 :status string,
 :hidden boolean,
 :id string,
 :kind string,
 :notes string,
 :position string,
 :webViewLink string,
 :links [{:type string, :link string, :description string}]}"
  [tasklist task Task]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://tasks.googleapis.com/tasks/v1/lists/{tasklist}/tasks/{task}",
     :uri-template-args {:task task, :tasklist tasklist},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/tasks"],
     :body Task}))

(defn tasks-insert
  "Creates a new task on the specified task list. A user can have up to 20,000 non-hidden tasks per list and up to 100,000 tasks in total at a time.
https://developers.google.com/tasks/reference/rest/v1/tasks/insert

tasklist <string> Task list identifier.
Task:
{:deleted boolean,
 :parent string,
 :updated string,
 :completed string,
 :selfLink string,
 :etag string,
 :due string,
 :title string,
 :status string,
 :hidden boolean,
 :id string,
 :kind string,
 :notes string,
 :position string,
 :webViewLink string,
 :links [{:type string, :link string, :description string}]}

optional:
parent <string> Parent task identifier. If the task is created at the top level, this parameter is omitted. Optional.
previous <string> Previous sibling task identifier. If the task is created at the first position among its siblings, this parameter is omitted. Optional."
  ([tasklist Task] (tasks-insert tasklist Task nil))
  ([tasklist Task optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://tasks.googleapis.com/tasks/v1/lists/{tasklist}/tasks",
       :uri-template-args {:tasklist tasklist},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/tasks"],
       :body Task})))

(defn tasks-clear
  "Clears all completed tasks from the specified task list. The affected tasks will be marked as 'hidden' and no longer be returned by default when retrieving all tasks for a task list.
https://developers.google.com/tasks/reference/rest/v1/tasks/clear

tasklist <string> Task list identifier."
  [tasklist]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://tasks.googleapis.com/tasks/v1/lists/{tasklist}/clear",
     :uri-template-args {:tasklist tasklist},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/tasks"]}))

(defn tasks-list
  "Returns all tasks in the specified task list. A user can have up to 20,000 non-hidden tasks per list and up to 100,000 tasks in total at a time.
https://developers.google.com/tasks/reference/rest/v1/tasks/list

tasklist <string> Task list identifier.

optional:
completedMin <string> Lower bound for a task's completion date (as a RFC 3339 timestamp) to filter by. Optional. The default is not to filter by completion date.
showCompleted <boolean> Flag indicating whether completed tasks are returned in the result. Optional. The default is True. Note that showHidden must also be True to show tasks completed in first party clients, such as the web UI and Google's mobile apps.
completedMax <string> Upper bound for a task's completion date (as a RFC 3339 timestamp) to filter by. Optional. The default is not to filter by completion date.
showHidden <boolean> Flag indicating whether hidden tasks are returned in the result. Optional. The default is False.
dueMin <string> Lower bound for a task's due date (as a RFC 3339 timestamp) to filter by. Optional. The default is not to filter by due date.
showDeleted <boolean> Flag indicating whether deleted tasks are returned in the result. Optional. The default is False.
updatedMin <string> Lower bound for a task's last modification time (as a RFC 3339 timestamp) to filter by. Optional. The default is not to filter by last modification time.
dueMax <string> Upper bound for a task's due date (as a RFC 3339 timestamp) to filter by. Optional. The default is not to filter by due date.
maxResults <integer> Maximum number of tasks returned on one page. Optional. The default is 20 (max allowed: 100)."
  ([tasklist] (tasks-list tasklist nil))
  ([tasklist optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://tasks.googleapis.com/tasks/v1/lists/{tasklist}/tasks",
       :uri-template-args {:tasklist tasklist},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/tasks"
        "https://www.googleapis.com/auth/tasks.readonly"]})))

(defn tasks-get
  "Returns the specified task.
https://developers.google.com/tasks/reference/rest/v1/tasks/get

tasklist <string> Task list identifier.
task <string> Task identifier."
  [tasklist task]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://tasks.googleapis.com/tasks/v1/lists/{tasklist}/tasks/{task}",
     :uri-template-args {:task task, :tasklist tasklist},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/tasks"
      "https://www.googleapis.com/auth/tasks.readonly"]}))

(defn tasks-move
  "Moves the specified task to another position in the task list. This can include putting it as a child task under a new parent and/or move it to a different position among its sibling tasks. A user can have up to 2,000 subtasks per task.
https://developers.google.com/tasks/reference/rest/v1/tasks/move

tasklist <string> Task list identifier.
task <string> Task identifier.

optional:
parent <string> New parent task identifier. If the task is moved to the top level, this parameter is omitted. Optional.
previous <string> New previous sibling task identifier. If the task is moved to the first position among its siblings, this parameter is omitted. Optional."
  ([tasklist task] (tasks-move tasklist task nil))
  ([tasklist task optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://tasks.googleapis.com/tasks/v1/lists/{tasklist}/tasks/{task}/move",
       :uri-template-args {:tasklist tasklist, :task task},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/tasks"]})))

(defn tasks-delete
  "Deletes the specified task from the task list.
https://developers.google.com/tasks/reference/rest/v1/tasks/delete

tasklist <string> Task list identifier.
task <string> Task identifier."
  [tasklist task]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://tasks.googleapis.com/tasks/v1/lists/{tasklist}/tasks/{task}",
     :uri-template-args {:task task, :tasklist tasklist},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/tasks"]}))

(defn tasklists-list
  "Returns all the authenticated user's task lists. A user can have up to 2000 lists at a time.
https://developers.google.com/tasks/reference/rest/v1/tasklists/list

optional:
maxResults <integer> Maximum number of task lists returned on one page. Optional. The default is 20 (max allowed: 100)."
  ([] (tasklists-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://tasks.googleapis.com/tasks/v1/users/@me/lists",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/tasks"
        "https://www.googleapis.com/auth/tasks.readonly"]})))

(defn tasklists-patch
  "Updates the authenticated user's specified task list. This method supports patch semantics.
https://developers.google.com/tasks/reference/rest/v1/tasklists/patch

tasklist <string> Task list identifier.
TaskList:
{:etag string,
 :kind string,
 :updated string,
 :title string,
 :id string,
 :selfLink string}"
  [tasklist TaskList]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://tasks.googleapis.com/tasks/v1/users/@me/lists/{tasklist}",
     :uri-template-args {:tasklist tasklist},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/tasks"],
     :body TaskList}))

(defn tasklists-delete
  "Deletes the authenticated user's specified task list.
https://developers.google.com/tasks/reference/rest/v1/tasklists/delete

tasklist <string> Task list identifier."
  [tasklist]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://tasks.googleapis.com/tasks/v1/users/@me/lists/{tasklist}",
     :uri-template-args {:tasklist tasklist},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/tasks"]}))

(defn tasklists-get
  "Returns the authenticated user's specified task list.
https://developers.google.com/tasks/reference/rest/v1/tasklists/get

tasklist <string> Task list identifier."
  [tasklist]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://tasks.googleapis.com/tasks/v1/users/@me/lists/{tasklist}",
     :uri-template-args {:tasklist tasklist},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/tasks"
      "https://www.googleapis.com/auth/tasks.readonly"]}))

(defn tasklists-insert
  "Creates a new task list and adds it to the authenticated user's task lists. A user can have up to 2000 lists at a time.
https://developers.google.com/tasks/reference/rest/v1/tasklists/insert

TaskList:
{:etag string,
 :kind string,
 :updated string,
 :title string,
 :id string,
 :selfLink string}"
  [TaskList]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://tasks.googleapis.com/tasks/v1/users/@me/lists",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/tasks"],
     :body TaskList}))

(defn tasklists-update
  "Updates the authenticated user's specified task list.
https://developers.google.com/tasks/reference/rest/v1/tasklists/update

tasklist <string> Task list identifier.
TaskList:
{:etag string,
 :kind string,
 :updated string,
 :title string,
 :id string,
 :selfLink string}"
  [tasklist TaskList]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://tasks.googleapis.com/tasks/v1/users/@me/lists/{tasklist}",
     :uri-template-args {:tasklist tasklist},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/tasks"],
     :body TaskList}))

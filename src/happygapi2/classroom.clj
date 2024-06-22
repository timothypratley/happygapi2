(ns happygapi2.classroom
  "Google Classroom API
Manages classes, rosters, and invitations in Google Classroom.
See: https://developers.google.com/classroom/"
  (:require [happy.oauth2.client :as client]))

(defn courses-create
  "Creates a course. The user specified in `ownerId` is the owner of the created course and added as a teacher. A non-admin requesting user can only create a course with themselves as the owner. Domain admins can create courses owned by any user within their domain. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to create courses or for access errors. * `NOT_FOUND` if the primary teacher is not a valid user. * `FAILED_PRECONDITION` if the course owner's account is disabled or for the following request errors: * UserCannotOwnCourse * UserGroupsMembershipLimitReached * `ALREADY_EXISTS` if an alias was specified in the `id` and already exists.
https://developers.google.com/classroom/reference/rest/v1/courses/create

Course:
{:creationTime string,
 :description string,
 :calendarId string,
 :ownerId string,
 :teacherFolder {:id string, :title string, :alternateLink string},
 :name string,
 :section string,
 :guardiansEnabled boolean,
 :gradebookSettings
 {:calculationType
  [CALCULATION_TYPE_UNSPECIFIED TOTAL_POINTS WEIGHTED_CATEGORIES],
  :displaySetting
  [DISPLAY_SETTING_UNSPECIFIED
   SHOW_OVERALL_GRADE
   HIDE_OVERALL_GRADE
   SHOW_TEACHERS_ONLY],
  :gradeCategories
  [{:id string,
    :name string,
    :weight integer,
    :defaultGradeDenominator integer}]},
 :updateTime string,
 :courseMaterialSets
 [{:title string,
   :materials
   [{:driveFile
     {:id string,
      :title string,
      :alternateLink string,
      :thumbnailUrl string},
     :youTubeVideo
     {:id string,
      :title string,
      :alternateLink string,
      :thumbnailUrl string},
     :link {:url string, :title string, :thumbnailUrl string},
     :form
     {:formUrl string,
      :responseUrl string,
      :title string,
      :thumbnailUrl string}}]}],
 :courseState
 [COURSE_STATE_UNSPECIFIED
  ACTIVE
  ARCHIVED
  PROVISIONED
  DECLINED
  SUSPENDED],
 :enrollmentCode string,
 :id string,
 :alternateLink string,
 :teacherGroupEmail string,
 :room string,
 :courseGroupEmail string,
 :descriptionHeading string}"
  [Course]
  (client/api-request
    {:method "POST",
     :uri-template "https://classroom.googleapis.com/v1/courses",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/classroom.courses"],
     :body Course}))

(defn courses-get
  "Returns a course. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course or for access errors. * `NOT_FOUND` if no course exists with the requested ID.
https://developers.google.com/classroom/reference/rest/v1/courses/get

id <string> Identifier of the course to return. This identifier can be either the Classroom-assigned identifier or an alias."
  [id]
  (client/api-request
    {:method "GET",
     :uri-template "https://classroom.googleapis.com/v1/courses/{id}",
     :uri-template-args {:id id},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/classroom.courses"
      "https://www.googleapis.com/auth/classroom.courses.readonly"]}))

(defn courses-update
  "Updates a course. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to modify the requested course or for access errors. * `NOT_FOUND` if no course exists with the requested ID. * `FAILED_PRECONDITION` for the following request errors: * CourseNotModifiable
https://developers.google.com/classroom/reference/rest/v1/courses/update

id <string> Identifier of the course to update. This identifier can be either the Classroom-assigned identifier or an alias.
Course:
{:creationTime string,
 :description string,
 :calendarId string,
 :ownerId string,
 :teacherFolder {:id string, :title string, :alternateLink string},
 :name string,
 :section string,
 :guardiansEnabled boolean,
 :gradebookSettings
 {:calculationType
  [CALCULATION_TYPE_UNSPECIFIED TOTAL_POINTS WEIGHTED_CATEGORIES],
  :displaySetting
  [DISPLAY_SETTING_UNSPECIFIED
   SHOW_OVERALL_GRADE
   HIDE_OVERALL_GRADE
   SHOW_TEACHERS_ONLY],
  :gradeCategories
  [{:id string,
    :name string,
    :weight integer,
    :defaultGradeDenominator integer}]},
 :updateTime string,
 :courseMaterialSets
 [{:title string,
   :materials
   [{:driveFile
     {:id string,
      :title string,
      :alternateLink string,
      :thumbnailUrl string},
     :youTubeVideo
     {:id string,
      :title string,
      :alternateLink string,
      :thumbnailUrl string},
     :link {:url string, :title string, :thumbnailUrl string},
     :form
     {:formUrl string,
      :responseUrl string,
      :title string,
      :thumbnailUrl string}}]}],
 :courseState
 [COURSE_STATE_UNSPECIFIED
  ACTIVE
  ARCHIVED
  PROVISIONED
  DECLINED
  SUSPENDED],
 :enrollmentCode string,
 :id string,
 :alternateLink string,
 :teacherGroupEmail string,
 :room string,
 :courseGroupEmail string,
 :descriptionHeading string}"
  [id Course]
  (client/api-request
    {:method "PUT",
     :uri-template "https://classroom.googleapis.com/v1/courses/{id}",
     :uri-template-args {:id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/classroom.courses"],
     :body Course}))

(defn courses-patch
  "Updates one or more fields in a course. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to modify the requested course or for access errors. * `NOT_FOUND` if no course exists with the requested ID. * `INVALID_ARGUMENT` if invalid fields are specified in the update mask or if no update mask is supplied. * `FAILED_PRECONDITION` for the following request errors: * CourseNotModifiable * InactiveCourseOwner * IneligibleOwner
https://developers.google.com/classroom/reference/rest/v1/courses/patch

id <string> Identifier of the course to update. This identifier can be either the Classroom-assigned identifier or an alias.
Course:
{:creationTime string,
 :description string,
 :calendarId string,
 :ownerId string,
 :teacherFolder {:id string, :title string, :alternateLink string},
 :name string,
 :section string,
 :guardiansEnabled boolean,
 :gradebookSettings
 {:calculationType
  [CALCULATION_TYPE_UNSPECIFIED TOTAL_POINTS WEIGHTED_CATEGORIES],
  :displaySetting
  [DISPLAY_SETTING_UNSPECIFIED
   SHOW_OVERALL_GRADE
   HIDE_OVERALL_GRADE
   SHOW_TEACHERS_ONLY],
  :gradeCategories
  [{:id string,
    :name string,
    :weight integer,
    :defaultGradeDenominator integer}]},
 :updateTime string,
 :courseMaterialSets
 [{:title string,
   :materials
   [{:driveFile
     {:id string,
      :title string,
      :alternateLink string,
      :thumbnailUrl string},
     :youTubeVideo
     {:id string,
      :title string,
      :alternateLink string,
      :thumbnailUrl string},
     :link {:url string, :title string, :thumbnailUrl string},
     :form
     {:formUrl string,
      :responseUrl string,
      :title string,
      :thumbnailUrl string}}]}],
 :courseState
 [COURSE_STATE_UNSPECIFIED
  ACTIVE
  ARCHIVED
  PROVISIONED
  DECLINED
  SUSPENDED],
 :enrollmentCode string,
 :id string,
 :alternateLink string,
 :teacherGroupEmail string,
 :room string,
 :courseGroupEmail string,
 :descriptionHeading string}

optional:
updateMask <string> Mask that identifies which fields on the course to update. This field is required to do an update. The update will fail if invalid fields are specified. The following fields are valid: * `name` * `section` * `descriptionHeading` * `description` * `room` * `courseState` * `ownerId` Note: patches to ownerId are treated as being effective immediately, but in practice it may take some time for the ownership transfer of all affected resources to complete. When set in a query parameter, this field should be specified as `updateMask=,,...`"
  ([id Course] (courses-patch id Course nil))
  ([id Course optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{id}",
       :uri-template-args {:id id},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/classroom.courses"],
       :body Course})))

(defn courses-delete
  "Deletes a course. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to delete the requested course or for access errors. * `NOT_FOUND` if no course exists with the requested ID.
https://developers.google.com/classroom/reference/rest/v1/courses/delete

id <string> Identifier of the course to delete. This identifier can be either the Classroom-assigned identifier or an alias."
  [id]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://classroom.googleapis.com/v1/courses/{id}",
     :uri-template-args {:id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/classroom.courses"]}))

(defn courses-list
  "Returns a list of courses that the requesting user is permitted to view, restricted to those that match the request. Returned courses are ordered by creation time, with the most recently created coming first. This method returns the following error codes: * `PERMISSION_DENIED` for access errors. * `INVALID_ARGUMENT` if the query argument is malformed. * `NOT_FOUND` if any users specified in the query arguments do not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/list

optional:
studentId <string> Restricts returned courses to those having a student with the specified identifier. The identifier can be one of the following: * the numeric identifier for the user * the email address of the user * the string literal `\"me\"`, indicating the requesting user
teacherId <string> Restricts returned courses to those having a teacher with the specified identifier. The identifier can be one of the following: * the numeric identifier for the user * the email address of the user * the string literal `\"me\"`, indicating the requesting user
courseStates <string> Restricts returned courses to those in one of the specified states The default value is ACTIVE, ARCHIVED, PROVISIONED, DECLINED.
pageSize <integer> Maximum number of items to return. Zero or unspecified indicates that the server may assign a maximum. The server may return fewer than the specified number of results."
  ([] (courses-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://classroom.googleapis.com/v1/courses",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/classroom.courses"
        "https://www.googleapis.com/auth/classroom.courses.readonly"]})))

(defn courses-aliases-create
  "Creates an alias for a course. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to create the alias or for access errors. * `NOT_FOUND` if the course does not exist. * `ALREADY_EXISTS` if the alias already exists. * `FAILED_PRECONDITION` if the alias requested does not make sense for the requesting user or course (for example, if a user not in a domain attempts to access a domain-scoped alias).
https://developers.google.com/classroom/reference/rest/v1/courses/aliases/create

courseId <string> Identifier of the course to alias. This identifier can be either the Classroom-assigned identifier or an alias.
CourseAlias:
{:alias string}"
  [courseId CourseAlias]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://classroom.googleapis.com/v1/courses/{courseId}/aliases",
     :uri-template-args {:courseId courseId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/classroom.courses"],
     :body CourseAlias}))

(defn courses-aliases-delete
  "Deletes an alias of a course. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to remove the alias or for access errors. * `NOT_FOUND` if the alias does not exist. * `FAILED_PRECONDITION` if the alias requested does not make sense for the requesting user or course (for example, if a user not in a domain attempts to delete a domain-scoped alias).
https://developers.google.com/classroom/reference/rest/v1/courses/aliases/delete

courseId <string> Identifier of the course whose alias should be deleted. This identifier can be either the Classroom-assigned identifier or an alias.
alias <string> Alias to delete. This may not be the Classroom-assigned identifier."
  [courseId alias]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://classroom.googleapis.com/v1/courses/{courseId}/aliases/{alias}",
     :uri-template-args {:courseId courseId, :alias alias},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/classroom.courses"]}))

(defn courses-aliases-list
  "Returns a list of aliases for a course. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the course or for access errors. * `NOT_FOUND` if the course does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/aliases/list

courseId <string> The identifier of the course. This identifier can be either the Classroom-assigned identifier or an alias.

optional:
pageSize <integer> Maximum number of items to return. Zero or unspecified indicates that the server may assign a maximum. The server may return fewer than the specified number of results."
  ([courseId] (courses-aliases-list courseId nil))
  ([courseId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/aliases",
       :uri-template-args {:courseId courseId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/classroom.courses"
        "https://www.googleapis.com/auth/classroom.courses.readonly"]})))

(defn courses-courseWork-create
  "Creates course work. The resulting course work (and corresponding student submissions) are associated with the Developer Console project of the [OAuth client ID](https://support.google.com/cloud/answer/6158849) used to make the request. Classroom API requests to modify course work and student submissions must be made with an OAuth client ID from the associated Developer Console project. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course, create course work in the requested course, share a Drive attachment, or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course does not exist. * `FAILED_PRECONDITION` for the following request error: * AttachmentNotVisible
https://developers.google.com/classroom/reference/rest/v1/courses/courseWork/create

courseId <string> Identifier of the course. This identifier can be either the Classroom-assigned identifier or an alias.
CourseWork:
{:creationTime string,
 :description string,
 :individualStudentsOptions {:studentIds [string]},
 :multipleChoiceQuestion {:choices [string]},
 :submissionModificationMode
 [SUBMISSION_MODIFICATION_MODE_UNSPECIFIED
  MODIFIABLE_UNTIL_TURNED_IN
  MODIFIABLE],
 :creatorUserId string,
 :assigneeMode
 [ASSIGNEE_MODE_UNSPECIFIED ALL_STUDENTS INDIVIDUAL_STUDENTS],
 :dueTime
 {:hours integer, :minutes integer, :seconds integer, :nanos integer},
 :topicId string,
 :scheduledTime string,
 :state [COURSE_WORK_STATE_UNSPECIFIED PUBLISHED DRAFT DELETED],
 :title string,
 :updateTime string,
 :id string,
 :dueDate {:year integer, :month integer, :day integer},
 :alternateLink string,
 :materials
 [{:driveFile
   {:driveFile
    {:id string,
     :title string,
     :alternateLink string,
     :thumbnailUrl string},
    :shareMode [UNKNOWN_SHARE_MODE VIEW EDIT STUDENT_COPY]},
   :youtubeVideo
   {:id string,
    :title string,
    :alternateLink string,
    :thumbnailUrl string},
   :link {:url string, :title string, :thumbnailUrl string},
   :form
   {:formUrl string,
    :responseUrl string,
    :title string,
    :thumbnailUrl string}}],
 :assignment
 {:studentWorkFolder
  {:id string, :title string, :alternateLink string}},
 :maxPoints number,
 :gradeCategory
 {:id string,
  :name string,
  :weight integer,
  :defaultGradeDenominator integer},
 :associatedWithDeveloper boolean,
 :courseId string,
 :workType
 [COURSE_WORK_TYPE_UNSPECIFIED
  ASSIGNMENT
  SHORT_ANSWER_QUESTION
  MULTIPLE_CHOICE_QUESTION]}"
  [courseId CourseWork]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://classroom.googleapis.com/v1/courses/{courseId}/courseWork",
     :uri-template-args {:courseId courseId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/classroom.coursework.students"],
     :body CourseWork}))

(defn courses-courseWork-patch
  "Updates one or more fields of a course work. See google.classroom.v1.CourseWork for details of which fields may be updated and who may change them. This request must be made by the Developer Console project of the [OAuth client ID](https://support.google.com/cloud/answer/6158849) used to create the corresponding course work item. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting developer project did not create the corresponding course work, if the user is not permitted to make the requested modification to the student submission, or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `FAILED_PRECONDITION` if the requested course work has already been deleted. * `NOT_FOUND` if the requested course, course work, or student submission does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/courseWork/patch

courseId <string> Identifier of the course. This identifier can be either the Classroom-assigned identifier or an alias.
id <string> Identifier of the course work.
CourseWork:
{:creationTime string,
 :description string,
 :individualStudentsOptions {:studentIds [string]},
 :multipleChoiceQuestion {:choices [string]},
 :submissionModificationMode
 [SUBMISSION_MODIFICATION_MODE_UNSPECIFIED
  MODIFIABLE_UNTIL_TURNED_IN
  MODIFIABLE],
 :creatorUserId string,
 :assigneeMode
 [ASSIGNEE_MODE_UNSPECIFIED ALL_STUDENTS INDIVIDUAL_STUDENTS],
 :dueTime
 {:hours integer, :minutes integer, :seconds integer, :nanos integer},
 :topicId string,
 :scheduledTime string,
 :state [COURSE_WORK_STATE_UNSPECIFIED PUBLISHED DRAFT DELETED],
 :title string,
 :updateTime string,
 :id string,
 :dueDate {:year integer, :month integer, :day integer},
 :alternateLink string,
 :materials
 [{:driveFile
   {:driveFile
    {:id string,
     :title string,
     :alternateLink string,
     :thumbnailUrl string},
    :shareMode [UNKNOWN_SHARE_MODE VIEW EDIT STUDENT_COPY]},
   :youtubeVideo
   {:id string,
    :title string,
    :alternateLink string,
    :thumbnailUrl string},
   :link {:url string, :title string, :thumbnailUrl string},
   :form
   {:formUrl string,
    :responseUrl string,
    :title string,
    :thumbnailUrl string}}],
 :assignment
 {:studentWorkFolder
  {:id string, :title string, :alternateLink string}},
 :maxPoints number,
 :gradeCategory
 {:id string,
  :name string,
  :weight integer,
  :defaultGradeDenominator integer},
 :associatedWithDeveloper boolean,
 :courseId string,
 :workType
 [COURSE_WORK_TYPE_UNSPECIFIED
  ASSIGNMENT
  SHORT_ANSWER_QUESTION
  MULTIPLE_CHOICE_QUESTION]}

optional:
updateMask <string> Mask that identifies which fields on the course work to update. This field is required to do an update. The update fails if invalid fields are specified. If a field supports empty values, it can be cleared by specifying it in the update mask and not in the `CourseWork` object. If a field that does not support empty values is included in the update mask and not set in the `CourseWork` object, an `INVALID_ARGUMENT` error is returned. The following fields may be specified by teachers: * `title` * `description` * `state` * `due_date` * `due_time` * `max_points` * `scheduled_time` * `submission_modification_mode` * `topic_id`"
  ([courseId id CourseWork]
    (courses-courseWork-patch courseId id CourseWork nil))
  ([courseId id CourseWork optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/courseWork/{id}",
       :uri-template-args {:courseId courseId, :id id},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/classroom.coursework.students"],
       :body CourseWork})))

(defn courses-courseWork-delete
  "Deletes a course work. This request must be made by the Developer Console project of the [OAuth client ID](https://support.google.com/cloud/answer/6158849) used to create the corresponding course work item. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting developer project did not create the corresponding course work, if the requesting user is not permitted to delete the requested course or for access errors. * `FAILED_PRECONDITION` if the requested course work has already been deleted. * `NOT_FOUND` if no course exists with the requested ID.
https://developers.google.com/classroom/reference/rest/v1/courses/courseWork/delete

courseId <string> Identifier of the course. This identifier can be either the Classroom-assigned identifier or an alias.
id <string> Identifier of the course work to delete. This identifier is a Classroom-assigned identifier."
  [courseId id]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://classroom.googleapis.com/v1/courses/{courseId}/courseWork/{id}",
     :uri-template-args {:courseId courseId, :id id},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/classroom.coursework.students"]}))

(defn courses-courseWork-get
  "Returns course work. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course or course work, or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course or course work does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/courseWork/get

courseId <string> Identifier of the course. This identifier can be either the Classroom-assigned identifier or an alias.
id <string> Identifier of the course work."
  [courseId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://classroom.googleapis.com/v1/courses/{courseId}/courseWork/{id}",
     :uri-template-args {:courseId courseId, :id id},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/classroom.coursework.me"
      "https://www.googleapis.com/auth/classroom.coursework.me.readonly"
      "https://www.googleapis.com/auth/classroom.coursework.students"
      "https://www.googleapis.com/auth/classroom.coursework.students.readonly"]}))

(defn courses-courseWork-list
  "Returns a list of course work that the requester is permitted to view. Course students may only view `PUBLISHED` course work. Course teachers and domain administrators may view all course work. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/courseWork/list

courseId <string> Identifier of the course. This identifier can be either the Classroom-assigned identifier or an alias.

optional:
courseWorkStates <string> Restriction on the work status to return. Only courseWork that matches is returned. If unspecified, items with a work status of `PUBLISHED` is returned.
orderBy <string> Optional sort ordering for results. A comma-separated list of fields with an optional sort direction keyword. Supported fields are `updateTime` and `dueDate`. Supported direction keywords are `asc` and `desc`. If not specified, `updateTime desc` is the default behavior. Examples: `dueDate asc,updateTime desc`, `updateTime,dueDate desc`
pageSize <integer> Maximum number of items to return. Zero or unspecified indicates that the server may assign a maximum. The server may return fewer than the specified number of results."
  ([courseId] (courses-courseWork-list courseId nil))
  ([courseId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/courseWork",
       :uri-template-args {:courseId courseId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/classroom.coursework.me"
        "https://www.googleapis.com/auth/classroom.coursework.me.readonly"
        "https://www.googleapis.com/auth/classroom.coursework.students"
        "https://www.googleapis.com/auth/classroom.coursework.students.readonly"]})))

(defn courses-courseWork-modifyAssignees
  "Modifies assignee mode and options of a coursework. Only a teacher of the course that contains the coursework may call this method. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course or course work or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course or course work does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/courseWork/modifyAssignees

courseId <string> Identifier of the course. This identifier can be either the Classroom-assigned identifier or an alias.
id <string> Identifier of the coursework.
ModifyCourseWorkAssigneesRequest:
{:assigneeMode
 [ASSIGNEE_MODE_UNSPECIFIED ALL_STUDENTS INDIVIDUAL_STUDENTS],
 :modifyIndividualStudentsOptions
 {:addStudentIds [string], :removeStudentIds [string]}}"
  [courseId id ModifyCourseWorkAssigneesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://classroom.googleapis.com/v1/courses/{courseId}/courseWork/{id}:modifyAssignees",
     :uri-template-args {:courseId courseId, :id id},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/classroom.coursework.students"],
     :body ModifyCourseWorkAssigneesRequest}))

(defn courses-courseWork-getAddOnContext
  "Gets metadata for Classroom add-ons in the context of a specific post. To maintain the integrity of its own data and permissions model, an add-on should call this to validate query parameters and the requesting user's role whenever the add-on is opened in an [iframe](https://developers.google.com/classroom/add-ons/get-started/iframes/iframes-overview). This method returns the following error codes: * `PERMISSION_DENIED` for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if one of the identified resources does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/courseWork/getAddOnContext

courseId <string> Required. Identifier of the course.
itemId <string> Identifier of the announcement, courseWork, or courseWorkMaterial under which the attachment is attached. This field is required, but is not marked as such while we are migrating from post_id.

optional:
postId <string> Optional. Deprecated, use item_id instead.
addOnToken <string> Optional. Token that authorizes the request. The token is passed as a query parameter when the user is redirected from Classroom to the add-on's URL. The authorization token is required when neither of the following is true: * The add-on has attachments on the post. * The developer project issuing the request is the same project that created the post.
attachmentId <string> Optional. The identifier of the attachment. This field is required for student users and optional for teacher users. If not provided in the student case, an error is returned."
  ([courseId itemId]
    (courses-courseWork-getAddOnContext courseId itemId nil))
  ([courseId itemId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/courseWork/{itemId}/addOnContext",
       :uri-template-args {:courseId courseId, :itemId itemId},
       :query-params (merge {} optional),
       :scopes nil})))

(defn courses-courseWork-studentSubmissions-get
  "Returns a student submission. * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course, course work, or student submission or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course, course work, or student submission does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/courseWork/studentSubmissions/get

courseId <string> Identifier of the course. This identifier can be either the Classroom-assigned identifier or an alias.
courseWorkId <string> Identifier of the course work.
id <string> Identifier of the student submission."
  [courseId courseWorkId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://classroom.googleapis.com/v1/courses/{courseId}/courseWork/{courseWorkId}/studentSubmissions/{id}",
     :uri-template-args
     {:courseId courseId, :courseWorkId courseWorkId, :id id},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/classroom.coursework.me"
      "https://www.googleapis.com/auth/classroom.coursework.me.readonly"
      "https://www.googleapis.com/auth/classroom.coursework.students"
      "https://www.googleapis.com/auth/classroom.coursework.students.readonly"
      "https://www.googleapis.com/auth/classroom.student-submissions.me.readonly"
      "https://www.googleapis.com/auth/classroom.student-submissions.students.readonly"]}))

(defn courses-courseWork-studentSubmissions-patch
  "Updates one or more fields of a student submission. See google.classroom.v1.StudentSubmission for details of which fields may be updated and who may change them. This request must be made by the Developer Console project of the [OAuth client ID](https://support.google.com/cloud/answer/6158849) used to create the corresponding course work item. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting developer project did not create the corresponding course work, if the user is not permitted to make the requested modification to the student submission, or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course, course work, or student submission does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/courseWork/studentSubmissions/patch

courseId <string> Identifier of the course. This identifier can be either the Classroom-assigned identifier or an alias.
courseWorkId <string> Identifier of the course work.
id <string> Identifier of the student submission.
StudentSubmission:
{:creationTime string,
 :shortAnswerSubmission {:answer string},
 :late boolean,
 :multipleChoiceSubmission {:answer string},
 :state
 [SUBMISSION_STATE_UNSPECIFIED
  NEW
  CREATED
  TURNED_IN
  RETURNED
  RECLAIMED_BY_STUDENT],
 :updateTime string,
 :assignmentSubmission
 {:attachments
  [{:driveFile
    {:id string,
     :title string,
     :alternateLink string,
     :thumbnailUrl string},
    :youTubeVideo
    {:id string,
     :title string,
     :alternateLink string,
     :thumbnailUrl string},
    :link {:url string, :title string, :thumbnailUrl string},
    :form
    {:formUrl string,
     :responseUrl string,
     :title string,
     :thumbnailUrl string}}]},
 :id string,
 :assignedGrade number,
 :submissionHistory
 [{:stateHistory
   {:state
    [STATE_UNSPECIFIED
     CREATED
     TURNED_IN
     RETURNED
     RECLAIMED_BY_STUDENT
     STUDENT_EDITED_AFTER_TURN_IN],
    :stateTimestamp string,
    :actorUserId string},
   :gradeHistory
   {:pointsEarned number,
    :maxPoints number,
    :gradeTimestamp string,
    :actorUserId string,
    :gradeChangeType
    [UNKNOWN_GRADE_CHANGE_TYPE
     DRAFT_GRADE_POINTS_EARNED_CHANGE
     ASSIGNED_GRADE_POINTS_EARNED_CHANGE
     MAX_POINTS_CHANGE]}}],
 :alternateLink string,
 :userId string,
 :courseWorkType
 [COURSE_WORK_TYPE_UNSPECIFIED
  ASSIGNMENT
  SHORT_ANSWER_QUESTION
  MULTIPLE_CHOICE_QUESTION],
 :courseWorkId string,
 :associatedWithDeveloper boolean,
 :courseId string,
 :draftGrade number}

optional:
updateMask <string> Mask that identifies which fields on the student submission to update. This field is required to do an update. The update fails if invalid fields are specified. The following fields may be specified by teachers: * `draft_grade` * `assigned_grade`"
  ([courseId courseWorkId id StudentSubmission]
    (courses-courseWork-studentSubmissions-patch
      courseId
      courseWorkId
      id
      StudentSubmission
      nil))
  ([courseId courseWorkId id StudentSubmission optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/courseWork/{courseWorkId}/studentSubmissions/{id}",
       :uri-template-args
       {:courseId courseId, :courseWorkId courseWorkId, :id id},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/classroom.coursework.me"
        "https://www.googleapis.com/auth/classroom.coursework.students"],
       :body StudentSubmission})))

(defn courses-courseWork-studentSubmissions-list
  "Returns a list of student submissions that the requester is permitted to view, factoring in the OAuth scopes of the request. `-` may be specified as the `course_work_id` to include student submissions for multiple course work items. Course students may only view their own work. Course teachers and domain administrators may view all student submissions. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course or course work, or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/courseWork/studentSubmissions/list

courseId <string> Identifier of the course. This identifier can be either the Classroom-assigned identifier or an alias.
courseWorkId <string> Identifier of the student work to request. This may be set to the string literal `\"-\"` to request student work for all course work in the specified course.

optional:
userId <string> Optional argument to restrict returned student work to those owned by the student with the specified identifier. The identifier can be one of the following: * the numeric identifier for the user * the email address of the user * the string literal `\"me\"`, indicating the requesting user
states <string> Requested submission states. If specified, returned student submissions match one of the specified submission states.
late <string> Requested lateness value. If specified, returned student submissions are restricted by the requested value. If unspecified, submissions are returned regardless of `late` value.
pageSize <integer> Maximum number of items to return. Zero or unspecified indicates that the server may assign a maximum. The server may return fewer than the specified number of results."
  ([courseId courseWorkId]
    (courses-courseWork-studentSubmissions-list
      courseId
      courseWorkId
      nil))
  ([courseId courseWorkId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/courseWork/{courseWorkId}/studentSubmissions",
       :uri-template-args
       {:courseId courseId, :courseWorkId courseWorkId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/classroom.coursework.me"
        "https://www.googleapis.com/auth/classroom.coursework.me.readonly"
        "https://www.googleapis.com/auth/classroom.coursework.students"
        "https://www.googleapis.com/auth/classroom.coursework.students.readonly"
        "https://www.googleapis.com/auth/classroom.student-submissions.me.readonly"
        "https://www.googleapis.com/auth/classroom.student-submissions.students.readonly"]})))

(defn courses-courseWork-studentSubmissions-turnIn
  "Turns in a student submission. Turning in a student submission transfers ownership of attached Drive files to the teacher and may also update the submission state. This may only be called by the student that owns the specified student submission. This request must be made by the Developer Console project of the [OAuth client ID](https://support.google.com/cloud/answer/6158849) used to create the corresponding course work item. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course or course work, turn in the requested student submission, or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course, course work, or student submission does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/courseWork/studentSubmissions/turnIn

courseId <string> Identifier of the course. This identifier can be either the Classroom-assigned identifier or an alias.
courseWorkId <string> Identifier of the course work.
id <string> Identifier of the student submission.
TurnInStudentSubmissionRequest:
object"
  [courseId courseWorkId id TurnInStudentSubmissionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://classroom.googleapis.com/v1/courses/{courseId}/courseWork/{courseWorkId}/studentSubmissions/{id}:turnIn",
     :uri-template-args
     {:courseId courseId, :courseWorkId courseWorkId, :id id},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/classroom.coursework.me"],
     :body TurnInStudentSubmissionRequest}))

(defn courses-courseWork-studentSubmissions-reclaim
  "Reclaims a student submission on behalf of the student that owns it. Reclaiming a student submission transfers ownership of attached Drive files to the student and updates the submission state. Only the student that owns the requested student submission may call this method, and only for a student submission that has been turned in. This request must be made by the Developer Console project of the [OAuth client ID](https://support.google.com/cloud/answer/6158849) used to create the corresponding course work item. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course or course work, unsubmit the requested student submission, or for access errors. * `FAILED_PRECONDITION` if the student submission has not been turned in. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course, course work, or student submission does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/courseWork/studentSubmissions/reclaim

courseId <string> Identifier of the course. This identifier can be either the Classroom-assigned identifier or an alias.
courseWorkId <string> Identifier of the course work.
id <string> Identifier of the student submission.
ReclaimStudentSubmissionRequest:
object"
  [courseId courseWorkId id ReclaimStudentSubmissionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://classroom.googleapis.com/v1/courses/{courseId}/courseWork/{courseWorkId}/studentSubmissions/{id}:reclaim",
     :uri-template-args
     {:courseId courseId, :courseWorkId courseWorkId, :id id},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/classroom.coursework.me"],
     :body ReclaimStudentSubmissionRequest}))

(defn courses-courseWork-studentSubmissions-return
  "Returns a student submission. Returning a student submission transfers ownership of attached Drive files to the student and may also update the submission state. Unlike the Classroom application, returning a student submission does not set assignedGrade to the draftGrade value. Only a teacher of the course that contains the requested student submission may call this method. This request must be made by the Developer Console project of the [OAuth client ID](https://support.google.com/cloud/answer/6158849) used to create the corresponding course work item. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course or course work, return the requested student submission, or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course, course work, or student submission does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/courseWork/studentSubmissions/return

courseId <string> Identifier of the course. This identifier can be either the Classroom-assigned identifier or an alias.
courseWorkId <string> Identifier of the course work.
id <string> Identifier of the student submission.
ReturnStudentSubmissionRequest:
object"
  [courseId courseWorkId id ReturnStudentSubmissionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://classroom.googleapis.com/v1/courses/{courseId}/courseWork/{courseWorkId}/studentSubmissions/{id}:return",
     :uri-template-args
     {:courseId courseId, :courseWorkId courseWorkId, :id id},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/classroom.coursework.students"],
     :body ReturnStudentSubmissionRequest}))

(defn courses-courseWork-studentSubmissions-modifyAttachments
  "Modifies attachments of student submission. Attachments may only be added to student submissions belonging to course work objects with a `workType` of `ASSIGNMENT`. This request must be made by the Developer Console project of the [OAuth client ID](https://support.google.com/cloud/answer/6158849) used to create the corresponding course work item. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course or course work, if the user is not permitted to modify attachments on the requested student submission, or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course, course work, or student submission does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/courseWork/studentSubmissions/modifyAttachments

courseId <string> Identifier of the course. This identifier can be either the Classroom-assigned identifier or an alias.
courseWorkId <string> Identifier of the course work.
id <string> Identifier of the student submission.
ModifyAttachmentsRequest:
{:addAttachments
 [{:driveFile
   {:id string,
    :title string,
    :alternateLink string,
    :thumbnailUrl string},
   :youTubeVideo
   {:id string,
    :title string,
    :alternateLink string,
    :thumbnailUrl string},
   :link {:url string, :title string, :thumbnailUrl string},
   :form
   {:formUrl string,
    :responseUrl string,
    :title string,
    :thumbnailUrl string}}]}"
  [courseId courseWorkId id ModifyAttachmentsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://classroom.googleapis.com/v1/courses/{courseId}/courseWork/{courseWorkId}/studentSubmissions/{id}:modifyAttachments",
     :uri-template-args
     {:courseId courseId, :courseWorkId courseWorkId, :id id},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/classroom.coursework.me"
      "https://www.googleapis.com/auth/classroom.coursework.students"],
     :body ModifyAttachmentsRequest}))

(defn courses-courseWork-addOnAttachments-get
  "Returns an add-on attachment. Requires the add-on requesting the attachment to be the original creator of the attachment. This method returns the following error codes: * `PERMISSION_DENIED` for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if one of the identified resources does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/courseWork/addOnAttachments/get

courseId <string> Required. Identifier of the course.
itemId <string> Identifier of the announcement, courseWork, or courseWorkMaterial under which the attachment is attached. This field is required, but is not marked as such while we are migrating from post_id.
attachmentId <string> Required. Identifier of the attachment.

optional:
postId <string> Optional. Deprecated, use item_id instead."
  ([courseId itemId attachmentId]
    (courses-courseWork-addOnAttachments-get
      courseId
      itemId
      attachmentId
      nil))
  ([courseId itemId attachmentId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/courseWork/{itemId}/addOnAttachments/{attachmentId}",
       :uri-template-args
       {:courseId courseId,
        :itemId itemId,
        :attachmentId attachmentId},
       :query-params (merge {} optional),
       :scopes nil})))

(defn courses-courseWork-addOnAttachments-list
  "Returns all attachments created by an add-on under the post. Requires the add-on to have active attachments on the post or have permission to create new attachments on the post. This method returns the following error codes: * `PERMISSION_DENIED` for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if one of the identified resources does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/courseWork/addOnAttachments/list

courseId <string> Required. Identifier of the course.
itemId <string> Identifier of the announcement, courseWork, or courseWorkMaterial whose attachments should be enumerated. This field is required, but is not marked as such while we are migrating from post_id.

optional:
postId <string> Optional. Identifier of the post under the course whose attachments to enumerate. Deprecated, use item_id instead.
pageSize <integer> The maximum number of attachments to return. The service may return fewer than this value. If unspecified, at most 20 attachments will be returned. The maximum value is 20; values above 20 will be coerced to 20."
  ([courseId itemId]
    (courses-courseWork-addOnAttachments-list courseId itemId nil))
  ([courseId itemId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/courseWork/{itemId}/addOnAttachments",
       :uri-template-args {:courseId courseId, :itemId itemId},
       :query-params (merge {} optional),
       :scopes nil})))

(defn courses-courseWork-addOnAttachments-create
  "Creates an add-on attachment under a post. Requires the add-on to have permission to create new attachments on the post. This method returns the following error codes: * `PERMISSION_DENIED` for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if one of the identified resources does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/courseWork/addOnAttachments/create

courseId <string> Required. Identifier of the course.
itemId <string> Identifier of the announcement, courseWork, or courseWorkMaterial under which to create the attachment. This field is required, but is not marked as such while we are migrating from post_id.
AddOnAttachment:
{:postId string,
 :dueTime
 {:hours integer, :minutes integer, :seconds integer, :nanos integer},
 :copyHistory
 [{:courseId string,
   :postId string,
   :itemId string,
   :attachmentId string}],
 :title string,
 :studentViewUri {:uri string},
 :id string,
 :dueDate {:year integer, :month integer, :day integer},
 :studentWorkReviewUri {:uri string},
 :maxPoints number,
 :teacherViewUri {:uri string},
 :courseId string,
 :itemId string}

optional:
postId <string> Optional. Deprecated, use item_id instead.
addOnToken <string> Optional. Token that authorizes the request. The token is passed as a query parameter when the user is redirected from Classroom to the add-on's URL. This authorization token is required for in-Classroom attachment creation but optional for partner-first attachment creation. Returns an error if not provided for partner-first attachment creation and the developer projects that created the attachment and its parent stream item do not match."
  ([courseId itemId AddOnAttachment]
    (courses-courseWork-addOnAttachments-create
      courseId
      itemId
      AddOnAttachment
      nil))
  ([courseId itemId AddOnAttachment optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/courseWork/{itemId}/addOnAttachments",
       :uri-template-args {:courseId courseId, :itemId itemId},
       :query-params (merge {} optional),
       :scopes nil,
       :body AddOnAttachment})))

(defn courses-courseWork-addOnAttachments-patch
  "Updates an add-on attachment. Requires the add-on to have been the original creator of the attachment. This method returns the following error codes: * `PERMISSION_DENIED` for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if one of the identified resources does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/courseWork/addOnAttachments/patch

courseId <string> Required. Identifier of the course.
itemId <string> Identifier of the post under which the attachment is attached.
attachmentId <string> Required. Identifier of the attachment.
AddOnAttachment:
{:postId string,
 :dueTime
 {:hours integer, :minutes integer, :seconds integer, :nanos integer},
 :copyHistory
 [{:courseId string,
   :postId string,
   :itemId string,
   :attachmentId string}],
 :title string,
 :studentViewUri {:uri string},
 :id string,
 :dueDate {:year integer, :month integer, :day integer},
 :studentWorkReviewUri {:uri string},
 :maxPoints number,
 :teacherViewUri {:uri string},
 :courseId string,
 :itemId string}

optional:
postId <string> Required. Identifier of the post under which the attachment is attached.
updateMask <string> Required. Mask that identifies which fields on the attachment to update. The update fails if invalid fields are specified. If a field supports empty values, it can be cleared by specifying it in the update mask and not in the `AddOnAttachment` object. If a field that does not support empty values is included in the update mask and not set in the `AddOnAttachment` object, an `INVALID_ARGUMENT` error is returned. The following fields may be specified by teachers: * `title` * `teacher_view_uri` * `student_view_uri` * `student_work_review_uri` * `due_date` * `due_time` * `max_points`"
  ([courseId itemId attachmentId AddOnAttachment]
    (courses-courseWork-addOnAttachments-patch
      courseId
      itemId
      attachmentId
      AddOnAttachment
      nil))
  ([courseId itemId attachmentId AddOnAttachment optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/courseWork/{itemId}/addOnAttachments/{attachmentId}",
       :uri-template-args
       {:courseId courseId,
        :itemId itemId,
        :attachmentId attachmentId},
       :query-params (merge {} optional),
       :scopes nil,
       :body AddOnAttachment})))

(defn courses-courseWork-addOnAttachments-delete
  "Deletes an add-on attachment. Requires the add-on to have been the original creator of the attachment. This method returns the following error codes: * `PERMISSION_DENIED` for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if one of the identified resources does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/courseWork/addOnAttachments/delete

courseId <string> Required. Identifier of the course.
itemId <string> Identifier of the announcement, courseWork, or courseWorkMaterial under which the attachment is attached. This field is required, but is not marked as such while we are migrating from post_id.
attachmentId <string> Required. Identifier of the attachment.

optional:
postId <string> Optional. Deprecated, use item_id instead."
  ([courseId itemId attachmentId]
    (courses-courseWork-addOnAttachments-delete
      courseId
      itemId
      attachmentId
      nil))
  ([courseId itemId attachmentId optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/courseWork/{itemId}/addOnAttachments/{attachmentId}",
       :uri-template-args
       {:courseId courseId,
        :itemId itemId,
        :attachmentId attachmentId},
       :query-params (merge {} optional),
       :scopes nil})))

(defn courses-courseWork-addOnAttachments-studentSubmissions-patch
  "Updates data associated with an add-on attachment submission. Requires the add-on to have been the original creator of the attachment and the attachment to have a positive `max_points` value set. This method returns the following error codes: * `PERMISSION_DENIED` for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if one of the identified resources does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/courseWork/addOnAttachments/studentSubmissions/patch

courseId <string> Required. Identifier of the course.
itemId <string> Identifier of the announcement, courseWork, or courseWorkMaterial under which the attachment is attached. This field is required, but is not marked as such while we are migrating from post_id.
attachmentId <string> Required. Identifier of the attachment.
submissionId <string> Required. Identifier of the student's submission.
AddOnAttachmentStudentSubmission:
{:pointsEarned number,
 :postSubmissionState
 [SUBMISSION_STATE_UNSPECIFIED
  NEW
  CREATED
  TURNED_IN
  RETURNED
  RECLAIMED_BY_STUDENT],
 :userId string}

optional:
postId <string> Optional. Deprecated, use item_id instead.
updateMask <string> Required. Mask that identifies which fields on the attachment to update. The update fails if invalid fields are specified. If a field supports empty values, it can be cleared by specifying it in the update mask and not in the `AddOnAttachmentStudentSubmission` object. The following fields may be specified by teachers: * `points_earned`"
  ([courseId
    itemId
    attachmentId
    submissionId
    AddOnAttachmentStudentSubmission]
    (courses-courseWork-addOnAttachments-studentSubmissions-patch
      courseId
      itemId
      attachmentId
      submissionId
      AddOnAttachmentStudentSubmission
      nil))
  ([courseId
    itemId
    attachmentId
    submissionId
    AddOnAttachmentStudentSubmission
    optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/courseWork/{itemId}/addOnAttachments/{attachmentId}/studentSubmissions/{submissionId}",
       :uri-template-args
       {:courseId courseId,
        :itemId itemId,
        :attachmentId attachmentId,
        :submissionId submissionId},
       :query-params (merge {} optional),
       :scopes nil,
       :body AddOnAttachmentStudentSubmission})))

(defn courses-courseWork-addOnAttachments-studentSubmissions-get
  "Returns a student submission for an add-on attachment. This method returns the following error codes: * `PERMISSION_DENIED` for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if one of the identified resources does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/courseWork/addOnAttachments/studentSubmissions/get

courseId <string> Required. Identifier of the course.
itemId <string> Identifier of the announcement, courseWork, or courseWorkMaterial under which the attachment is attached. This field is required, but is not marked as such while we are migrating from post_id.
attachmentId <string> Required. Identifier of the attachment.
submissionId <string> Required. Identifier of the student’s submission.

optional:
postId <string> Optional. Deprecated, use item_id instead."
  ([courseId itemId attachmentId submissionId]
    (courses-courseWork-addOnAttachments-studentSubmissions-get
      courseId
      itemId
      attachmentId
      submissionId
      nil))
  ([courseId itemId attachmentId submissionId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/courseWork/{itemId}/addOnAttachments/{attachmentId}/studentSubmissions/{submissionId}",
       :uri-template-args
       {:courseId courseId,
        :itemId itemId,
        :attachmentId attachmentId,
        :submissionId submissionId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/classroom.student-submissions.students.readonly"]})))

(defn courses-announcements-delete
  "Deletes an announcement. This request must be made by the Developer Console project of the [OAuth client ID](https://support.google.com/cloud/answer/6158849) used to create the corresponding announcement item. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting developer project did not create the corresponding announcement, if the requesting user is not permitted to delete the requested course or for access errors. * `FAILED_PRECONDITION` if the requested announcement has already been deleted. * `NOT_FOUND` if no course exists with the requested ID.
https://developers.google.com/classroom/reference/rest/v1/courses/announcements/delete

courseId <string> Identifier of the course. This identifier can be either the Classroom-assigned identifier or an alias.
id <string> Identifier of the announcement to delete. This identifier is a Classroom-assigned identifier."
  [courseId id]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://classroom.googleapis.com/v1/courses/{courseId}/announcements/{id}",
     :uri-template-args {:courseId courseId, :id id},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/classroom.announcements"]}))

(defn courses-announcements-create
  "Creates an announcement. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course, create announcements in the requested course, share a Drive attachment, or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course does not exist. * `FAILED_PRECONDITION` for the following request error: * AttachmentNotVisible
https://developers.google.com/classroom/reference/rest/v1/courses/announcements/create

courseId <string> Identifier of the course. This identifier can be either the Classroom-assigned identifier or an alias.
Announcement:
{:creationTime string,
 :individualStudentsOptions {:studentIds [string]},
 :creatorUserId string,
 :assigneeMode
 [ASSIGNEE_MODE_UNSPECIFIED ALL_STUDENTS INDIVIDUAL_STUDENTS],
 :scheduledTime string,
 :state [ANNOUNCEMENT_STATE_UNSPECIFIED PUBLISHED DRAFT DELETED],
 :updateTime string,
 :id string,
 :alternateLink string,
 :materials
 [{:driveFile
   {:driveFile
    {:id string,
     :title string,
     :alternateLink string,
     :thumbnailUrl string},
    :shareMode [UNKNOWN_SHARE_MODE VIEW EDIT STUDENT_COPY]},
   :youtubeVideo
   {:id string,
    :title string,
    :alternateLink string,
    :thumbnailUrl string},
   :link {:url string, :title string, :thumbnailUrl string},
   :form
   {:formUrl string,
    :responseUrl string,
    :title string,
    :thumbnailUrl string}}],
 :courseId string,
 :text string}"
  [courseId Announcement]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://classroom.googleapis.com/v1/courses/{courseId}/announcements",
     :uri-template-args {:courseId courseId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/classroom.announcements"],
     :body Announcement}))

(defn courses-announcements-get
  "Returns an announcement. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course or announcement, or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course or announcement does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/announcements/get

courseId <string> Identifier of the course. This identifier can be either the Classroom-assigned identifier or an alias.
id <string> Identifier of the announcement."
  [courseId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://classroom.googleapis.com/v1/courses/{courseId}/announcements/{id}",
     :uri-template-args {:courseId courseId, :id id},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/classroom.announcements"
      "https://www.googleapis.com/auth/classroom.announcements.readonly"]}))

(defn courses-announcements-list
  "Returns a list of announcements that the requester is permitted to view. Course students may only view `PUBLISHED` announcements. Course teachers and domain administrators may view all announcements. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/announcements/list

courseId <string> Identifier of the course. This identifier can be either the Classroom-assigned identifier or an alias.

optional:
announcementStates <string> Restriction on the `state` of announcements returned. If this argument is left unspecified, the default value is `PUBLISHED`.
orderBy <string> Optional sort ordering for results. A comma-separated list of fields with an optional sort direction keyword. Supported field is `updateTime`. Supported direction keywords are `asc` and `desc`. If not specified, `updateTime desc` is the default behavior. Examples: `updateTime asc`, `updateTime`
pageSize <integer> Maximum number of items to return. Zero or unspecified indicates that the server may assign a maximum. The server may return fewer than the specified number of results."
  ([courseId] (courses-announcements-list courseId nil))
  ([courseId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/announcements",
       :uri-template-args {:courseId courseId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/classroom.announcements"
        "https://www.googleapis.com/auth/classroom.announcements.readonly"]})))

(defn courses-announcements-patch
  "Updates one or more fields of an announcement. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting developer project did not create the corresponding announcement or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `FAILED_PRECONDITION` if the requested announcement has already been deleted. * `NOT_FOUND` if the requested course or announcement does not exist
https://developers.google.com/classroom/reference/rest/v1/courses/announcements/patch

courseId <string> Identifier of the course. This identifier can be either the Classroom-assigned identifier or an alias.
id <string> Identifier of the announcement.
Announcement:
{:creationTime string,
 :individualStudentsOptions {:studentIds [string]},
 :creatorUserId string,
 :assigneeMode
 [ASSIGNEE_MODE_UNSPECIFIED ALL_STUDENTS INDIVIDUAL_STUDENTS],
 :scheduledTime string,
 :state [ANNOUNCEMENT_STATE_UNSPECIFIED PUBLISHED DRAFT DELETED],
 :updateTime string,
 :id string,
 :alternateLink string,
 :materials
 [{:driveFile
   {:driveFile
    {:id string,
     :title string,
     :alternateLink string,
     :thumbnailUrl string},
    :shareMode [UNKNOWN_SHARE_MODE VIEW EDIT STUDENT_COPY]},
   :youtubeVideo
   {:id string,
    :title string,
    :alternateLink string,
    :thumbnailUrl string},
   :link {:url string, :title string, :thumbnailUrl string},
   :form
   {:formUrl string,
    :responseUrl string,
    :title string,
    :thumbnailUrl string}}],
 :courseId string,
 :text string}

optional:
updateMask <string> Mask that identifies which fields on the announcement to update. This field is required to do an update. The update fails if invalid fields are specified. If a field supports empty values, it can be cleared by specifying it in the update mask and not in the Announcement object. If a field that does not support empty values is included in the update mask and not set in the Announcement object, an `INVALID_ARGUMENT` error is returned. The following fields may be specified by teachers: * `text` * `state` * `scheduled_time`"
  ([courseId id Announcement]
    (courses-announcements-patch courseId id Announcement nil))
  ([courseId id Announcement optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/announcements/{id}",
       :uri-template-args {:courseId courseId, :id id},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/classroom.announcements"],
       :body Announcement})))

(defn courses-announcements-modifyAssignees
  "Modifies assignee mode and options of an announcement. Only a teacher of the course that contains the announcement may call this method. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course or course work or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course or course work does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/announcements/modifyAssignees

courseId <string> Identifier of the course. This identifier can be either the Classroom-assigned identifier or an alias.
id <string> Identifier of the announcement.
ModifyAnnouncementAssigneesRequest:
{:assigneeMode
 [ASSIGNEE_MODE_UNSPECIFIED ALL_STUDENTS INDIVIDUAL_STUDENTS],
 :modifyIndividualStudentsOptions
 {:addStudentIds [string], :removeStudentIds [string]}}"
  [courseId id ModifyAnnouncementAssigneesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://classroom.googleapis.com/v1/courses/{courseId}/announcements/{id}:modifyAssignees",
     :uri-template-args {:courseId courseId, :id id},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/classroom.announcements"],
     :body ModifyAnnouncementAssigneesRequest}))

(defn courses-announcements-getAddOnContext
  "Gets metadata for Classroom add-ons in the context of a specific post. To maintain the integrity of its own data and permissions model, an add-on should call this to validate query parameters and the requesting user's role whenever the add-on is opened in an [iframe](https://developers.google.com/classroom/add-ons/get-started/iframes/iframes-overview). This method returns the following error codes: * `PERMISSION_DENIED` for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if one of the identified resources does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/announcements/getAddOnContext

courseId <string> Required. Identifier of the course.
itemId <string> Identifier of the announcement, courseWork, or courseWorkMaterial under which the attachment is attached. This field is required, but is not marked as such while we are migrating from post_id.

optional:
postId <string> Optional. Deprecated, use item_id instead.
addOnToken <string> Optional. Token that authorizes the request. The token is passed as a query parameter when the user is redirected from Classroom to the add-on's URL. The authorization token is required when neither of the following is true: * The add-on has attachments on the post. * The developer project issuing the request is the same project that created the post.
attachmentId <string> Optional. The identifier of the attachment. This field is required for student users and optional for teacher users. If not provided in the student case, an error is returned."
  ([courseId itemId]
    (courses-announcements-getAddOnContext courseId itemId nil))
  ([courseId itemId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/announcements/{itemId}/addOnContext",
       :uri-template-args {:courseId courseId, :itemId itemId},
       :query-params (merge {} optional),
       :scopes nil})))

(defn courses-announcements-addOnAttachments-get
  "Returns an add-on attachment. Requires the add-on requesting the attachment to be the original creator of the attachment. This method returns the following error codes: * `PERMISSION_DENIED` for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if one of the identified resources does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/announcements/addOnAttachments/get

courseId <string> Required. Identifier of the course.
itemId <string> Identifier of the announcement, courseWork, or courseWorkMaterial under which the attachment is attached. This field is required, but is not marked as such while we are migrating from post_id.
attachmentId <string> Required. Identifier of the attachment.

optional:
postId <string> Optional. Deprecated, use item_id instead."
  ([courseId itemId attachmentId]
    (courses-announcements-addOnAttachments-get
      courseId
      itemId
      attachmentId
      nil))
  ([courseId itemId attachmentId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/announcements/{itemId}/addOnAttachments/{attachmentId}",
       :uri-template-args
       {:courseId courseId,
        :itemId itemId,
        :attachmentId attachmentId},
       :query-params (merge {} optional),
       :scopes nil})))

(defn courses-announcements-addOnAttachments-list
  "Returns all attachments created by an add-on under the post. Requires the add-on to have active attachments on the post or have permission to create new attachments on the post. This method returns the following error codes: * `PERMISSION_DENIED` for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if one of the identified resources does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/announcements/addOnAttachments/list

courseId <string> Required. Identifier of the course.
itemId <string> Identifier of the announcement, courseWork, or courseWorkMaterial whose attachments should be enumerated. This field is required, but is not marked as such while we are migrating from post_id.

optional:
postId <string> Optional. Identifier of the post under the course whose attachments to enumerate. Deprecated, use item_id instead.
pageSize <integer> The maximum number of attachments to return. The service may return fewer than this value. If unspecified, at most 20 attachments will be returned. The maximum value is 20; values above 20 will be coerced to 20."
  ([courseId itemId]
    (courses-announcements-addOnAttachments-list courseId itemId nil))
  ([courseId itemId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/announcements/{itemId}/addOnAttachments",
       :uri-template-args {:courseId courseId, :itemId itemId},
       :query-params (merge {} optional),
       :scopes nil})))

(defn courses-announcements-addOnAttachments-create
  "Creates an add-on attachment under a post. Requires the add-on to have permission to create new attachments on the post. This method returns the following error codes: * `PERMISSION_DENIED` for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if one of the identified resources does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/announcements/addOnAttachments/create

courseId <string> Required. Identifier of the course.
itemId <string> Identifier of the announcement, courseWork, or courseWorkMaterial under which to create the attachment. This field is required, but is not marked as such while we are migrating from post_id.
AddOnAttachment:
{:postId string,
 :dueTime
 {:hours integer, :minutes integer, :seconds integer, :nanos integer},
 :copyHistory
 [{:courseId string,
   :postId string,
   :itemId string,
   :attachmentId string}],
 :title string,
 :studentViewUri {:uri string},
 :id string,
 :dueDate {:year integer, :month integer, :day integer},
 :studentWorkReviewUri {:uri string},
 :maxPoints number,
 :teacherViewUri {:uri string},
 :courseId string,
 :itemId string}

optional:
postId <string> Optional. Deprecated, use item_id instead.
addOnToken <string> Optional. Token that authorizes the request. The token is passed as a query parameter when the user is redirected from Classroom to the add-on's URL. This authorization token is required for in-Classroom attachment creation but optional for partner-first attachment creation. Returns an error if not provided for partner-first attachment creation and the developer projects that created the attachment and its parent stream item do not match."
  ([courseId itemId AddOnAttachment]
    (courses-announcements-addOnAttachments-create
      courseId
      itemId
      AddOnAttachment
      nil))
  ([courseId itemId AddOnAttachment optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/announcements/{itemId}/addOnAttachments",
       :uri-template-args {:courseId courseId, :itemId itemId},
       :query-params (merge {} optional),
       :scopes nil,
       :body AddOnAttachment})))

(defn courses-announcements-addOnAttachments-patch
  "Updates an add-on attachment. Requires the add-on to have been the original creator of the attachment. This method returns the following error codes: * `PERMISSION_DENIED` for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if one of the identified resources does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/announcements/addOnAttachments/patch

courseId <string> Required. Identifier of the course.
itemId <string> Identifier of the post under which the attachment is attached.
attachmentId <string> Required. Identifier of the attachment.
AddOnAttachment:
{:postId string,
 :dueTime
 {:hours integer, :minutes integer, :seconds integer, :nanos integer},
 :copyHistory
 [{:courseId string,
   :postId string,
   :itemId string,
   :attachmentId string}],
 :title string,
 :studentViewUri {:uri string},
 :id string,
 :dueDate {:year integer, :month integer, :day integer},
 :studentWorkReviewUri {:uri string},
 :maxPoints number,
 :teacherViewUri {:uri string},
 :courseId string,
 :itemId string}

optional:
postId <string> Required. Identifier of the post under which the attachment is attached.
updateMask <string> Required. Mask that identifies which fields on the attachment to update. The update fails if invalid fields are specified. If a field supports empty values, it can be cleared by specifying it in the update mask and not in the `AddOnAttachment` object. If a field that does not support empty values is included in the update mask and not set in the `AddOnAttachment` object, an `INVALID_ARGUMENT` error is returned. The following fields may be specified by teachers: * `title` * `teacher_view_uri` * `student_view_uri` * `student_work_review_uri` * `due_date` * `due_time` * `max_points`"
  ([courseId itemId attachmentId AddOnAttachment]
    (courses-announcements-addOnAttachments-patch
      courseId
      itemId
      attachmentId
      AddOnAttachment
      nil))
  ([courseId itemId attachmentId AddOnAttachment optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/announcements/{itemId}/addOnAttachments/{attachmentId}",
       :uri-template-args
       {:courseId courseId,
        :itemId itemId,
        :attachmentId attachmentId},
       :query-params (merge {} optional),
       :scopes nil,
       :body AddOnAttachment})))

(defn courses-announcements-addOnAttachments-delete
  "Deletes an add-on attachment. Requires the add-on to have been the original creator of the attachment. This method returns the following error codes: * `PERMISSION_DENIED` for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if one of the identified resources does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/announcements/addOnAttachments/delete

courseId <string> Required. Identifier of the course.
itemId <string> Identifier of the announcement, courseWork, or courseWorkMaterial under which the attachment is attached. This field is required, but is not marked as such while we are migrating from post_id.
attachmentId <string> Required. Identifier of the attachment.

optional:
postId <string> Optional. Deprecated, use item_id instead."
  ([courseId itemId attachmentId]
    (courses-announcements-addOnAttachments-delete
      courseId
      itemId
      attachmentId
      nil))
  ([courseId itemId attachmentId optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/announcements/{itemId}/addOnAttachments/{attachmentId}",
       :uri-template-args
       {:courseId courseId,
        :itemId itemId,
        :attachmentId attachmentId},
       :query-params (merge {} optional),
       :scopes nil})))

(defn courses-courseWorkMaterials-create
  "Creates a course work material. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course, create course work material in the requested course, share a Drive attachment, or for access errors. * `INVALID_ARGUMENT` if the request is malformed or if more than 20 * materials are provided. * `NOT_FOUND` if the requested course does not exist. * `FAILED_PRECONDITION` for the following request error: * AttachmentNotVisible
https://developers.google.com/classroom/reference/rest/v1/courses/courseWorkMaterials/create

courseId <string> Identifier of the course. This identifier can be either the Classroom-assigned identifier or an alias.
CourseWorkMaterial:
{:creationTime string,
 :description string,
 :individualStudentsOptions {:studentIds [string]},
 :creatorUserId string,
 :assigneeMode
 [ASSIGNEE_MODE_UNSPECIFIED ALL_STUDENTS INDIVIDUAL_STUDENTS],
 :topicId string,
 :scheduledTime string,
 :state
 [COURSEWORK_MATERIAL_STATE_UNSPECIFIED PUBLISHED DRAFT DELETED],
 :title string,
 :updateTime string,
 :id string,
 :alternateLink string,
 :materials
 [{:driveFile
   {:driveFile
    {:id string,
     :title string,
     :alternateLink string,
     :thumbnailUrl string},
    :shareMode [UNKNOWN_SHARE_MODE VIEW EDIT STUDENT_COPY]},
   :youtubeVideo
   {:id string,
    :title string,
    :alternateLink string,
    :thumbnailUrl string},
   :link {:url string, :title string, :thumbnailUrl string},
   :form
   {:formUrl string,
    :responseUrl string,
    :title string,
    :thumbnailUrl string}}],
 :courseId string}"
  [courseId CourseWorkMaterial]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://classroom.googleapis.com/v1/courses/{courseId}/courseWorkMaterials",
     :uri-template-args {:courseId courseId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/classroom.courseworkmaterials"],
     :body CourseWorkMaterial}))

(defn courses-courseWorkMaterials-get
  "Returns a course work material. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course or course work material, or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course or course work material does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/courseWorkMaterials/get

courseId <string> Identifier of the course. This identifier can be either the Classroom-assigned identifier or an alias.
id <string> Identifier of the course work material."
  [courseId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://classroom.googleapis.com/v1/courses/{courseId}/courseWorkMaterials/{id}",
     :uri-template-args {:courseId courseId, :id id},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/classroom.courseworkmaterials"
      "https://www.googleapis.com/auth/classroom.courseworkmaterials.readonly"]}))

(defn courses-courseWorkMaterials-list
  "Returns a list of course work material that the requester is permitted to view. Course students may only view `PUBLISHED` course work material. Course teachers and domain administrators may view all course work material. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/courseWorkMaterials/list

courseId <string> Identifier of the course. This identifier can be either the Classroom-assigned identifier or an alias.

optional:
courseWorkMaterialStates <string> Restriction on the work status to return. Only course work material that matches is returned. If unspecified, items with a work status of `PUBLISHED` is returned.
orderBy <string> Optional sort ordering for results. A comma-separated list of fields with an optional sort direction keyword. Supported field is `updateTime`. Supported direction keywords are `asc` and `desc`. If not specified, `updateTime desc` is the default behavior. Examples: `updateTime asc`, `updateTime`
pageSize <integer> Maximum number of items to return. Zero or unspecified indicates that the server may assign a maximum. The server may return fewer than the specified number of results.
materialLink <string> Optional filtering for course work material with at least one link material whose URL partially matches the provided string.
materialDriveId <string> Optional filtering for course work material with at least one Drive material whose ID matches the provided string. If `material_link` is also specified, course work material must have materials matching both filters."
  ([courseId] (courses-courseWorkMaterials-list courseId nil))
  ([courseId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/courseWorkMaterials",
       :uri-template-args {:courseId courseId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/classroom.courseworkmaterials"
        "https://www.googleapis.com/auth/classroom.courseworkmaterials.readonly"]})))

(defn courses-courseWorkMaterials-patch
  "Updates one or more fields of a course work material. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting developer project for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `FAILED_PRECONDITION` if the requested course work material has already been deleted. * `NOT_FOUND` if the requested course or course work material does not exist
https://developers.google.com/classroom/reference/rest/v1/courses/courseWorkMaterials/patch

courseId <string> Identifier of the course. This identifier can be either the Classroom-assigned identifier or an alias.
id <string> Identifier of the course work material.
CourseWorkMaterial:
{:creationTime string,
 :description string,
 :individualStudentsOptions {:studentIds [string]},
 :creatorUserId string,
 :assigneeMode
 [ASSIGNEE_MODE_UNSPECIFIED ALL_STUDENTS INDIVIDUAL_STUDENTS],
 :topicId string,
 :scheduledTime string,
 :state
 [COURSEWORK_MATERIAL_STATE_UNSPECIFIED PUBLISHED DRAFT DELETED],
 :title string,
 :updateTime string,
 :id string,
 :alternateLink string,
 :materials
 [{:driveFile
   {:driveFile
    {:id string,
     :title string,
     :alternateLink string,
     :thumbnailUrl string},
    :shareMode [UNKNOWN_SHARE_MODE VIEW EDIT STUDENT_COPY]},
   :youtubeVideo
   {:id string,
    :title string,
    :alternateLink string,
    :thumbnailUrl string},
   :link {:url string, :title string, :thumbnailUrl string},
   :form
   {:formUrl string,
    :responseUrl string,
    :title string,
    :thumbnailUrl string}}],
 :courseId string}

optional:
updateMask <string> Mask that identifies which fields on the course work material to update. This field is required to do an update. The update fails if invalid fields are specified. If a field supports empty values, it can be cleared by specifying it in the update mask and not in the course work material object. If a field that does not support empty values is included in the update mask and not set in the course work material object, an `INVALID_ARGUMENT` error is returned. The following fields may be specified by teachers: * `title` * `description` * `state` * `scheduled_time` * `topic_id`"
  ([courseId id CourseWorkMaterial]
    (courses-courseWorkMaterials-patch
      courseId
      id
      CourseWorkMaterial
      nil))
  ([courseId id CourseWorkMaterial optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/courseWorkMaterials/{id}",
       :uri-template-args {:courseId courseId, :id id},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/classroom.courseworkmaterials"],
       :body CourseWorkMaterial})))

(defn courses-courseWorkMaterials-delete
  "Deletes a course work material. This request must be made by the Developer Console project of the [OAuth client ID](https://support.google.com/cloud/answer/6158849) used to create the corresponding course work material item. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting developer project did not create the corresponding course work material, if the requesting user is not permitted to delete the requested course or for access errors. * `FAILED_PRECONDITION` if the requested course work material has already been deleted. * `NOT_FOUND` if no course exists with the requested ID.
https://developers.google.com/classroom/reference/rest/v1/courses/courseWorkMaterials/delete

courseId <string> Identifier of the course. This identifier can be either the Classroom-assigned identifier or an alias.
id <string> Identifier of the course work material to delete. This identifier is a Classroom-assigned identifier."
  [courseId id]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://classroom.googleapis.com/v1/courses/{courseId}/courseWorkMaterials/{id}",
     :uri-template-args {:courseId courseId, :id id},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/classroom.courseworkmaterials"]}))

(defn courses-courseWorkMaterials-getAddOnContext
  "Gets metadata for Classroom add-ons in the context of a specific post. To maintain the integrity of its own data and permissions model, an add-on should call this to validate query parameters and the requesting user's role whenever the add-on is opened in an [iframe](https://developers.google.com/classroom/add-ons/get-started/iframes/iframes-overview). This method returns the following error codes: * `PERMISSION_DENIED` for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if one of the identified resources does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/courseWorkMaterials/getAddOnContext

courseId <string> Required. Identifier of the course.
itemId <string> Identifier of the announcement, courseWork, or courseWorkMaterial under which the attachment is attached. This field is required, but is not marked as such while we are migrating from post_id.

optional:
postId <string> Optional. Deprecated, use item_id instead.
addOnToken <string> Optional. Token that authorizes the request. The token is passed as a query parameter when the user is redirected from Classroom to the add-on's URL. The authorization token is required when neither of the following is true: * The add-on has attachments on the post. * The developer project issuing the request is the same project that created the post.
attachmentId <string> Optional. The identifier of the attachment. This field is required for student users and optional for teacher users. If not provided in the student case, an error is returned."
  ([courseId itemId]
    (courses-courseWorkMaterials-getAddOnContext courseId itemId nil))
  ([courseId itemId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/courseWorkMaterials/{itemId}/addOnContext",
       :uri-template-args {:courseId courseId, :itemId itemId},
       :query-params (merge {} optional),
       :scopes nil})))

(defn courses-courseWorkMaterials-addOnAttachments-get
  "Returns an add-on attachment. Requires the add-on requesting the attachment to be the original creator of the attachment. This method returns the following error codes: * `PERMISSION_DENIED` for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if one of the identified resources does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/courseWorkMaterials/addOnAttachments/get

courseId <string> Required. Identifier of the course.
itemId <string> Identifier of the announcement, courseWork, or courseWorkMaterial under which the attachment is attached. This field is required, but is not marked as such while we are migrating from post_id.
attachmentId <string> Required. Identifier of the attachment.

optional:
postId <string> Optional. Deprecated, use item_id instead."
  ([courseId itemId attachmentId]
    (courses-courseWorkMaterials-addOnAttachments-get
      courseId
      itemId
      attachmentId
      nil))
  ([courseId itemId attachmentId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/courseWorkMaterials/{itemId}/addOnAttachments/{attachmentId}",
       :uri-template-args
       {:courseId courseId,
        :itemId itemId,
        :attachmentId attachmentId},
       :query-params (merge {} optional),
       :scopes nil})))

(defn courses-courseWorkMaterials-addOnAttachments-list
  "Returns all attachments created by an add-on under the post. Requires the add-on to have active attachments on the post or have permission to create new attachments on the post. This method returns the following error codes: * `PERMISSION_DENIED` for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if one of the identified resources does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/courseWorkMaterials/addOnAttachments/list

courseId <string> Required. Identifier of the course.
itemId <string> Identifier of the announcement, courseWork, or courseWorkMaterial whose attachments should be enumerated. This field is required, but is not marked as such while we are migrating from post_id.

optional:
postId <string> Optional. Identifier of the post under the course whose attachments to enumerate. Deprecated, use item_id instead.
pageSize <integer> The maximum number of attachments to return. The service may return fewer than this value. If unspecified, at most 20 attachments will be returned. The maximum value is 20; values above 20 will be coerced to 20."
  ([courseId itemId]
    (courses-courseWorkMaterials-addOnAttachments-list
      courseId
      itemId
      nil))
  ([courseId itemId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/courseWorkMaterials/{itemId}/addOnAttachments",
       :uri-template-args {:courseId courseId, :itemId itemId},
       :query-params (merge {} optional),
       :scopes nil})))

(defn courses-courseWorkMaterials-addOnAttachments-create
  "Creates an add-on attachment under a post. Requires the add-on to have permission to create new attachments on the post. This method returns the following error codes: * `PERMISSION_DENIED` for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if one of the identified resources does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/courseWorkMaterials/addOnAttachments/create

courseId <string> Required. Identifier of the course.
itemId <string> Identifier of the announcement, courseWork, or courseWorkMaterial under which to create the attachment. This field is required, but is not marked as such while we are migrating from post_id.
AddOnAttachment:
{:postId string,
 :dueTime
 {:hours integer, :minutes integer, :seconds integer, :nanos integer},
 :copyHistory
 [{:courseId string,
   :postId string,
   :itemId string,
   :attachmentId string}],
 :title string,
 :studentViewUri {:uri string},
 :id string,
 :dueDate {:year integer, :month integer, :day integer},
 :studentWorkReviewUri {:uri string},
 :maxPoints number,
 :teacherViewUri {:uri string},
 :courseId string,
 :itemId string}

optional:
postId <string> Optional. Deprecated, use item_id instead.
addOnToken <string> Optional. Token that authorizes the request. The token is passed as a query parameter when the user is redirected from Classroom to the add-on's URL. This authorization token is required for in-Classroom attachment creation but optional for partner-first attachment creation. Returns an error if not provided for partner-first attachment creation and the developer projects that created the attachment and its parent stream item do not match."
  ([courseId itemId AddOnAttachment]
    (courses-courseWorkMaterials-addOnAttachments-create
      courseId
      itemId
      AddOnAttachment
      nil))
  ([courseId itemId AddOnAttachment optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/courseWorkMaterials/{itemId}/addOnAttachments",
       :uri-template-args {:courseId courseId, :itemId itemId},
       :query-params (merge {} optional),
       :scopes nil,
       :body AddOnAttachment})))

(defn courses-courseWorkMaterials-addOnAttachments-patch
  "Updates an add-on attachment. Requires the add-on to have been the original creator of the attachment. This method returns the following error codes: * `PERMISSION_DENIED` for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if one of the identified resources does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/courseWorkMaterials/addOnAttachments/patch

courseId <string> Required. Identifier of the course.
itemId <string> Identifier of the post under which the attachment is attached.
attachmentId <string> Required. Identifier of the attachment.
AddOnAttachment:
{:postId string,
 :dueTime
 {:hours integer, :minutes integer, :seconds integer, :nanos integer},
 :copyHistory
 [{:courseId string,
   :postId string,
   :itemId string,
   :attachmentId string}],
 :title string,
 :studentViewUri {:uri string},
 :id string,
 :dueDate {:year integer, :month integer, :day integer},
 :studentWorkReviewUri {:uri string},
 :maxPoints number,
 :teacherViewUri {:uri string},
 :courseId string,
 :itemId string}

optional:
postId <string> Required. Identifier of the post under which the attachment is attached.
updateMask <string> Required. Mask that identifies which fields on the attachment to update. The update fails if invalid fields are specified. If a field supports empty values, it can be cleared by specifying it in the update mask and not in the `AddOnAttachment` object. If a field that does not support empty values is included in the update mask and not set in the `AddOnAttachment` object, an `INVALID_ARGUMENT` error is returned. The following fields may be specified by teachers: * `title` * `teacher_view_uri` * `student_view_uri` * `student_work_review_uri` * `due_date` * `due_time` * `max_points`"
  ([courseId itemId attachmentId AddOnAttachment]
    (courses-courseWorkMaterials-addOnAttachments-patch
      courseId
      itemId
      attachmentId
      AddOnAttachment
      nil))
  ([courseId itemId attachmentId AddOnAttachment optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/courseWorkMaterials/{itemId}/addOnAttachments/{attachmentId}",
       :uri-template-args
       {:courseId courseId,
        :itemId itemId,
        :attachmentId attachmentId},
       :query-params (merge {} optional),
       :scopes nil,
       :body AddOnAttachment})))

(defn courses-courseWorkMaterials-addOnAttachments-delete
  "Deletes an add-on attachment. Requires the add-on to have been the original creator of the attachment. This method returns the following error codes: * `PERMISSION_DENIED` for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if one of the identified resources does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/courseWorkMaterials/addOnAttachments/delete

courseId <string> Required. Identifier of the course.
itemId <string> Identifier of the announcement, courseWork, or courseWorkMaterial under which the attachment is attached. This field is required, but is not marked as such while we are migrating from post_id.
attachmentId <string> Required. Identifier of the attachment.

optional:
postId <string> Optional. Deprecated, use item_id instead."
  ([courseId itemId attachmentId]
    (courses-courseWorkMaterials-addOnAttachments-delete
      courseId
      itemId
      attachmentId
      nil))
  ([courseId itemId attachmentId optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/courseWorkMaterials/{itemId}/addOnAttachments/{attachmentId}",
       :uri-template-args
       {:courseId courseId,
        :itemId itemId,
        :attachmentId attachmentId},
       :query-params (merge {} optional),
       :scopes nil})))

(defn courses-topics-create
  "Creates a topic. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course, create a topic in the requested course, or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/topics/create

courseId <string> Identifier of the course. This identifier can be either the Classroom-assigned identifier or an alias.
Topic:
{:courseId string, :topicId string, :name string, :updateTime string}"
  [courseId Topic]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://classroom.googleapis.com/v1/courses/{courseId}/topics",
     :uri-template-args {:courseId courseId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/classroom.topics"],
     :body Topic}))

(defn courses-topics-patch
  "Updates one or more fields of a topic. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting developer project did not create the corresponding topic or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course or topic does not exist
https://developers.google.com/classroom/reference/rest/v1/courses/topics/patch

courseId <string> Identifier of the course. This identifier can be either the Classroom-assigned identifier or an alias.
id <string> Identifier of the topic.
Topic:
{:courseId string, :topicId string, :name string, :updateTime string}

optional:
updateMask <string> Mask that identifies which fields on the topic to update. This field is required to do an update. The update fails if invalid fields are specified. If a field supports empty values, it can be cleared by specifying it in the update mask and not in the Topic object. If a field that does not support empty values is included in the update mask and not set in the Topic object, an `INVALID_ARGUMENT` error is returned. The following fields may be specified: * `name`"
  ([courseId id Topic] (courses-topics-patch courseId id Topic nil))
  ([courseId id Topic optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/topics/{id}",
       :uri-template-args {:courseId courseId, :id id},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/classroom.topics"],
       :body Topic})))

(defn courses-topics-delete
  "Deletes a topic. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not allowed to delete the requested topic or for access errors. * `FAILED_PRECONDITION` if the requested topic has already been deleted. * `NOT_FOUND` if no course or topic exists with the requested ID.
https://developers.google.com/classroom/reference/rest/v1/courses/topics/delete

courseId <string> Identifier of the course. This identifier can be either the Classroom-assigned identifier or an alias.
id <string> Identifier of the topic to delete."
  [courseId id]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://classroom.googleapis.com/v1/courses/{courseId}/topics/{id}",
     :uri-template-args {:courseId courseId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/classroom.topics"]}))

(defn courses-topics-get
  "Returns a topic. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course or topic, or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course or topic does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/topics/get

courseId <string> Identifier of the course.
id <string> Identifier of the topic."
  [courseId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://classroom.googleapis.com/v1/courses/{courseId}/topics/{id}",
     :uri-template-args {:courseId courseId, :id id},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/classroom.topics"
      "https://www.googleapis.com/auth/classroom.topics.readonly"]}))

(defn courses-topics-list
  "Returns the list of topics that the requester is permitted to view. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access the requested course or for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if the requested course does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/topics/list

courseId <string> Identifier of the course. This identifier can be either the Classroom-assigned identifier or an alias.

optional:
pageSize <integer> Maximum number of items to return. Zero or unspecified indicates that the server may assign a maximum. The server may return fewer than the specified number of results."
  ([courseId] (courses-topics-list courseId nil))
  ([courseId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/topics",
       :uri-template-args {:courseId courseId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/classroom.topics"
        "https://www.googleapis.com/auth/classroom.topics.readonly"]})))

(defn courses-posts-getAddOnContext
  "Gets metadata for Classroom add-ons in the context of a specific post. To maintain the integrity of its own data and permissions model, an add-on should call this to validate query parameters and the requesting user's role whenever the add-on is opened in an [iframe](https://developers.google.com/classroom/add-ons/get-started/iframes/iframes-overview). This method returns the following error codes: * `PERMISSION_DENIED` for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if one of the identified resources does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/posts/getAddOnContext

courseId <string> Required. Identifier of the course.
postId <string> Optional. Deprecated, use item_id instead.

optional:
itemId <string> Identifier of the announcement, courseWork, or courseWorkMaterial under which the attachment is attached. This field is required, but is not marked as such while we are migrating from post_id.
addOnToken <string> Optional. Token that authorizes the request. The token is passed as a query parameter when the user is redirected from Classroom to the add-on's URL. The authorization token is required when neither of the following is true: * The add-on has attachments on the post. * The developer project issuing the request is the same project that created the post.
attachmentId <string> Optional. The identifier of the attachment. This field is required for student users and optional for teacher users. If not provided in the student case, an error is returned."
  ([courseId postId]
    (courses-posts-getAddOnContext courseId postId nil))
  ([courseId postId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/posts/{postId}/addOnContext",
       :uri-template-args {:courseId courseId, :postId postId},
       :query-params (merge {} optional),
       :scopes nil})))

(defn courses-posts-addOnAttachments-get
  "Returns an add-on attachment. Requires the add-on requesting the attachment to be the original creator of the attachment. This method returns the following error codes: * `PERMISSION_DENIED` for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if one of the identified resources does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/posts/addOnAttachments/get

courseId <string> Required. Identifier of the course.
postId <string> Optional. Deprecated, use item_id instead.
attachmentId <string> Required. Identifier of the attachment.

optional:
itemId <string> Identifier of the announcement, courseWork, or courseWorkMaterial under which the attachment is attached. This field is required, but is not marked as such while we are migrating from post_id."
  ([courseId postId attachmentId]
    (courses-posts-addOnAttachments-get
      courseId
      postId
      attachmentId
      nil))
  ([courseId postId attachmentId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/posts/{postId}/addOnAttachments/{attachmentId}",
       :uri-template-args
       {:courseId courseId,
        :postId postId,
        :attachmentId attachmentId},
       :query-params (merge {} optional),
       :scopes nil})))

(defn courses-posts-addOnAttachments-list
  "Returns all attachments created by an add-on under the post. Requires the add-on to have active attachments on the post or have permission to create new attachments on the post. This method returns the following error codes: * `PERMISSION_DENIED` for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if one of the identified resources does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/posts/addOnAttachments/list

courseId <string> Required. Identifier of the course.
postId <string> Optional. Identifier of the post under the course whose attachments to enumerate. Deprecated, use item_id instead.

optional:
itemId <string> Identifier of the announcement, courseWork, or courseWorkMaterial whose attachments should be enumerated. This field is required, but is not marked as such while we are migrating from post_id.
pageSize <integer> The maximum number of attachments to return. The service may return fewer than this value. If unspecified, at most 20 attachments will be returned. The maximum value is 20; values above 20 will be coerced to 20."
  ([courseId postId]
    (courses-posts-addOnAttachments-list courseId postId nil))
  ([courseId postId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/posts/{postId}/addOnAttachments",
       :uri-template-args {:courseId courseId, :postId postId},
       :query-params (merge {} optional),
       :scopes nil})))

(defn courses-posts-addOnAttachments-create
  "Creates an add-on attachment under a post. Requires the add-on to have permission to create new attachments on the post. This method returns the following error codes: * `PERMISSION_DENIED` for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if one of the identified resources does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/posts/addOnAttachments/create

courseId <string> Required. Identifier of the course.
postId <string> Optional. Deprecated, use item_id instead.
AddOnAttachment:
{:postId string,
 :dueTime
 {:hours integer, :minutes integer, :seconds integer, :nanos integer},
 :copyHistory
 [{:courseId string,
   :postId string,
   :itemId string,
   :attachmentId string}],
 :title string,
 :studentViewUri {:uri string},
 :id string,
 :dueDate {:year integer, :month integer, :day integer},
 :studentWorkReviewUri {:uri string},
 :maxPoints number,
 :teacherViewUri {:uri string},
 :courseId string,
 :itemId string}

optional:
itemId <string> Identifier of the announcement, courseWork, or courseWorkMaterial under which to create the attachment. This field is required, but is not marked as such while we are migrating from post_id.
addOnToken <string> Optional. Token that authorizes the request. The token is passed as a query parameter when the user is redirected from Classroom to the add-on's URL. This authorization token is required for in-Classroom attachment creation but optional for partner-first attachment creation. Returns an error if not provided for partner-first attachment creation and the developer projects that created the attachment and its parent stream item do not match."
  ([courseId postId AddOnAttachment]
    (courses-posts-addOnAttachments-create
      courseId
      postId
      AddOnAttachment
      nil))
  ([courseId postId AddOnAttachment optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/posts/{postId}/addOnAttachments",
       :uri-template-args {:courseId courseId, :postId postId},
       :query-params (merge {} optional),
       :scopes nil,
       :body AddOnAttachment})))

(defn courses-posts-addOnAttachments-patch
  "Updates an add-on attachment. Requires the add-on to have been the original creator of the attachment. This method returns the following error codes: * `PERMISSION_DENIED` for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if one of the identified resources does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/posts/addOnAttachments/patch

courseId <string> Required. Identifier of the course.
postId <string> Required. Identifier of the post under which the attachment is attached.
attachmentId <string> Required. Identifier of the attachment.
AddOnAttachment:
{:postId string,
 :dueTime
 {:hours integer, :minutes integer, :seconds integer, :nanos integer},
 :copyHistory
 [{:courseId string,
   :postId string,
   :itemId string,
   :attachmentId string}],
 :title string,
 :studentViewUri {:uri string},
 :id string,
 :dueDate {:year integer, :month integer, :day integer},
 :studentWorkReviewUri {:uri string},
 :maxPoints number,
 :teacherViewUri {:uri string},
 :courseId string,
 :itemId string}

optional:
itemId <string> Identifier of the post under which the attachment is attached.
updateMask <string> Required. Mask that identifies which fields on the attachment to update. The update fails if invalid fields are specified. If a field supports empty values, it can be cleared by specifying it in the update mask and not in the `AddOnAttachment` object. If a field that does not support empty values is included in the update mask and not set in the `AddOnAttachment` object, an `INVALID_ARGUMENT` error is returned. The following fields may be specified by teachers: * `title` * `teacher_view_uri` * `student_view_uri` * `student_work_review_uri` * `due_date` * `due_time` * `max_points`"
  ([courseId postId attachmentId AddOnAttachment]
    (courses-posts-addOnAttachments-patch
      courseId
      postId
      attachmentId
      AddOnAttachment
      nil))
  ([courseId postId attachmentId AddOnAttachment optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/posts/{postId}/addOnAttachments/{attachmentId}",
       :uri-template-args
       {:courseId courseId,
        :postId postId,
        :attachmentId attachmentId},
       :query-params (merge {} optional),
       :scopes nil,
       :body AddOnAttachment})))

(defn courses-posts-addOnAttachments-delete
  "Deletes an add-on attachment. Requires the add-on to have been the original creator of the attachment. This method returns the following error codes: * `PERMISSION_DENIED` for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if one of the identified resources does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/posts/addOnAttachments/delete

courseId <string> Required. Identifier of the course.
postId <string> Optional. Deprecated, use item_id instead.
attachmentId <string> Required. Identifier of the attachment.

optional:
itemId <string> Identifier of the announcement, courseWork, or courseWorkMaterial under which the attachment is attached. This field is required, but is not marked as such while we are migrating from post_id."
  ([courseId postId attachmentId]
    (courses-posts-addOnAttachments-delete
      courseId
      postId
      attachmentId
      nil))
  ([courseId postId attachmentId optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/posts/{postId}/addOnAttachments/{attachmentId}",
       :uri-template-args
       {:courseId courseId,
        :postId postId,
        :attachmentId attachmentId},
       :query-params (merge {} optional),
       :scopes nil})))

(defn courses-posts-addOnAttachments-studentSubmissions-patch
  "Updates data associated with an add-on attachment submission. Requires the add-on to have been the original creator of the attachment and the attachment to have a positive `max_points` value set. This method returns the following error codes: * `PERMISSION_DENIED` for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if one of the identified resources does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/posts/addOnAttachments/studentSubmissions/patch

courseId <string> Required. Identifier of the course.
postId <string> Optional. Deprecated, use item_id instead.
attachmentId <string> Required. Identifier of the attachment.
submissionId <string> Required. Identifier of the student's submission.
AddOnAttachmentStudentSubmission:
{:pointsEarned number,
 :postSubmissionState
 [SUBMISSION_STATE_UNSPECIFIED
  NEW
  CREATED
  TURNED_IN
  RETURNED
  RECLAIMED_BY_STUDENT],
 :userId string}

optional:
itemId <string> Identifier of the announcement, courseWork, or courseWorkMaterial under which the attachment is attached. This field is required, but is not marked as such while we are migrating from post_id.
updateMask <string> Required. Mask that identifies which fields on the attachment to update. The update fails if invalid fields are specified. If a field supports empty values, it can be cleared by specifying it in the update mask and not in the `AddOnAttachmentStudentSubmission` object. The following fields may be specified by teachers: * `points_earned`"
  ([courseId
    postId
    attachmentId
    submissionId
    AddOnAttachmentStudentSubmission]
    (courses-posts-addOnAttachments-studentSubmissions-patch
      courseId
      postId
      attachmentId
      submissionId
      AddOnAttachmentStudentSubmission
      nil))
  ([courseId
    postId
    attachmentId
    submissionId
    AddOnAttachmentStudentSubmission
    optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/posts/{postId}/addOnAttachments/{attachmentId}/studentSubmissions/{submissionId}",
       :uri-template-args
       {:courseId courseId,
        :postId postId,
        :attachmentId attachmentId,
        :submissionId submissionId},
       :query-params (merge {} optional),
       :scopes nil,
       :body AddOnAttachmentStudentSubmission})))

(defn courses-posts-addOnAttachments-studentSubmissions-get
  "Returns a student submission for an add-on attachment. This method returns the following error codes: * `PERMISSION_DENIED` for access errors. * `INVALID_ARGUMENT` if the request is malformed. * `NOT_FOUND` if one of the identified resources does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/posts/addOnAttachments/studentSubmissions/get

courseId <string> Required. Identifier of the course.
postId <string> Optional. Deprecated, use item_id instead.
attachmentId <string> Required. Identifier of the attachment.
submissionId <string> Required. Identifier of the student’s submission.

optional:
itemId <string> Identifier of the announcement, courseWork, or courseWorkMaterial under which the attachment is attached. This field is required, but is not marked as such while we are migrating from post_id."
  ([courseId postId attachmentId submissionId]
    (courses-posts-addOnAttachments-studentSubmissions-get
      courseId
      postId
      attachmentId
      submissionId
      nil))
  ([courseId postId attachmentId submissionId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/posts/{postId}/addOnAttachments/{attachmentId}/studentSubmissions/{submissionId}",
       :uri-template-args
       {:courseId courseId,
        :postId postId,
        :attachmentId attachmentId,
        :submissionId submissionId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/classroom.student-submissions.students.readonly"]})))

(defn courses-teachers-create
  "Creates a teacher of a course. Domain administrators are permitted to [directly add](https://developers.google.com/classroom/guides/manage-users) users within their domain as teachers to courses within their domain. Non-admin users should send an Invitation instead. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to create teachers in this course or for access errors. * `NOT_FOUND` if the requested course ID does not exist. * `FAILED_PRECONDITION` if the requested user's account is disabled, for the following request errors: * CourseMemberLimitReached * CourseNotModifiable * CourseTeacherLimitReached * UserGroupsMembershipLimitReached * InactiveCourseOwner * `ALREADY_EXISTS` if the user is already a teacher or student in the course.
https://developers.google.com/classroom/reference/rest/v1/courses/teachers/create

courseId <string> Identifier of the course. This identifier can be either the Classroom-assigned identifier or an alias.
Teacher:
{:courseId string,
 :userId string,
 :profile
 {:id string,
  :name {:givenName string, :familyName string, :fullName string},
  :emailAddress string,
  :photoUrl string,
  :permissions [{:permission [PERMISSION_UNSPECIFIED CREATE_COURSE]}],
  :verifiedTeacher boolean}}"
  [courseId Teacher]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://classroom.googleapis.com/v1/courses/{courseId}/teachers",
     :uri-template-args {:courseId courseId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/classroom.profile.emails"
      "https://www.googleapis.com/auth/classroom.profile.photos"
      "https://www.googleapis.com/auth/classroom.rosters"],
     :body Teacher}))

(defn courses-teachers-get
  "Returns a teacher of a course. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to view teachers of this course or for access errors. * `NOT_FOUND` if no teacher of this course has the requested ID or if the course does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/teachers/get

courseId <string> Identifier of the course. This identifier can be either the Classroom-assigned identifier or an alias.
userId <string> Identifier of the teacher to return. The identifier can be one of the following: * the numeric identifier for the user * the email address of the user * the string literal `\"me\"`, indicating the requesting user"
  [courseId userId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://classroom.googleapis.com/v1/courses/{courseId}/teachers/{userId}",
     :uri-template-args {:courseId courseId, :userId userId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/classroom.profile.emails"
      "https://www.googleapis.com/auth/classroom.profile.photos"
      "https://www.googleapis.com/auth/classroom.rosters"
      "https://www.googleapis.com/auth/classroom.rosters.readonly"]}))

(defn courses-teachers-delete
  "Removes the specified teacher from the specified course. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to delete teachers of this course or for access errors. * `NOT_FOUND` if no teacher of this course has the requested ID or if the course does not exist. * `FAILED_PRECONDITION` if the requested ID belongs to the primary teacher of this course. * `FAILED_PRECONDITION` if the requested ID belongs to the owner of the course Drive folder. * `FAILED_PRECONDITION` if the course no longer has an active owner.
https://developers.google.com/classroom/reference/rest/v1/courses/teachers/delete

courseId <string> Identifier of the course. This identifier can be either the Classroom-assigned identifier or an alias.
userId <string> Identifier of the teacher to delete. The identifier can be one of the following: * the numeric identifier for the user * the email address of the user * the string literal `\"me\"`, indicating the requesting user"
  [courseId userId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://classroom.googleapis.com/v1/courses/{courseId}/teachers/{userId}",
     :uri-template-args {:courseId courseId, :userId userId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/classroom.rosters"]}))

(defn courses-teachers-list
  "Returns a list of teachers of this course that the requester is permitted to view. This method returns the following error codes: * `NOT_FOUND` if the course does not exist. * `PERMISSION_DENIED` for access errors.
https://developers.google.com/classroom/reference/rest/v1/courses/teachers/list

courseId <string> Identifier of the course. This identifier can be either the Classroom-assigned identifier or an alias.

optional:
pageSize <integer> Maximum number of items to return. The default is 30 if unspecified or `0`. The server may return fewer than the specified number of results."
  ([courseId] (courses-teachers-list courseId nil))
  ([courseId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/teachers",
       :uri-template-args {:courseId courseId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/classroom.profile.emails"
        "https://www.googleapis.com/auth/classroom.profile.photos"
        "https://www.googleapis.com/auth/classroom.rosters"
        "https://www.googleapis.com/auth/classroom.rosters.readonly"]})))

(defn courses-students-create
  "Adds a user as a student of a course. Domain administrators are permitted to [directly add](https://developers.google.com/classroom/guides/manage-users) users within their domain as students to courses within their domain. Students are permitted to add themselves to a course using an enrollment code. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to create students in this course or for access errors. * `NOT_FOUND` if the requested course ID does not exist. * `FAILED_PRECONDITION` if the requested user's account is disabled, for the following request errors: * CourseMemberLimitReached * CourseNotModifiable * UserGroupsMembershipLimitReached * InactiveCourseOwner * `ALREADY_EXISTS` if the user is already a student or teacher in the course.
https://developers.google.com/classroom/reference/rest/v1/courses/students/create

courseId <string> Identifier of the course to create the student in. This identifier can be either the Classroom-assigned identifier or an alias.
Student:
{:courseId string,
 :userId string,
 :profile
 {:id string,
  :name {:givenName string, :familyName string, :fullName string},
  :emailAddress string,
  :photoUrl string,
  :permissions [{:permission [PERMISSION_UNSPECIFIED CREATE_COURSE]}],
  :verifiedTeacher boolean},
 :studentWorkFolder {:id string, :title string, :alternateLink string}}

optional:
enrollmentCode <string> Enrollment code of the course to create the student in. This code is required if userId corresponds to the requesting user; it may be omitted if the requesting user has administrative permissions to create students for any user."
  ([courseId Student] (courses-students-create courseId Student nil))
  ([courseId Student optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/students",
       :uri-template-args {:courseId courseId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/classroom.profile.emails"
        "https://www.googleapis.com/auth/classroom.profile.photos"
        "https://www.googleapis.com/auth/classroom.rosters"],
       :body Student})))

(defn courses-students-get
  "Returns a student of a course. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to view students of this course or for access errors. * `NOT_FOUND` if no student of this course has the requested ID or if the course does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/students/get

courseId <string> Identifier of the course. This identifier can be either the Classroom-assigned identifier or an alias.
userId <string> Identifier of the student to return. The identifier can be one of the following: * the numeric identifier for the user * the email address of the user * the string literal `\"me\"`, indicating the requesting user"
  [courseId userId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://classroom.googleapis.com/v1/courses/{courseId}/students/{userId}",
     :uri-template-args {:courseId courseId, :userId userId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/classroom.profile.emails"
      "https://www.googleapis.com/auth/classroom.profile.photos"
      "https://www.googleapis.com/auth/classroom.rosters"
      "https://www.googleapis.com/auth/classroom.rosters.readonly"]}))

(defn courses-students-delete
  "Deletes a student of a course. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to delete students of this course or for access errors. * `NOT_FOUND` if no student of this course has the requested ID or if the course does not exist.
https://developers.google.com/classroom/reference/rest/v1/courses/students/delete

courseId <string> Identifier of the course. This identifier can be either the Classroom-assigned identifier or an alias.
userId <string> Identifier of the student to delete. The identifier can be one of the following: * the numeric identifier for the user * the email address of the user * the string literal `\"me\"`, indicating the requesting user"
  [courseId userId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://classroom.googleapis.com/v1/courses/{courseId}/students/{userId}",
     :uri-template-args {:courseId courseId, :userId userId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/classroom.rosters"]}))

(defn courses-students-list
  "Returns a list of students of this course that the requester is permitted to view. This method returns the following error codes: * `NOT_FOUND` if the course does not exist. * `PERMISSION_DENIED` for access errors.
https://developers.google.com/classroom/reference/rest/v1/courses/students/list

courseId <string> Identifier of the course. This identifier can be either the Classroom-assigned identifier or an alias.

optional:
pageSize <integer> Maximum number of items to return. The default is 30 if unspecified or `0`. The server may return fewer than the specified number of results."
  ([courseId] (courses-students-list courseId nil))
  ([courseId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://classroom.googleapis.com/v1/courses/{courseId}/students",
       :uri-template-args {:courseId courseId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/classroom.profile.emails"
        "https://www.googleapis.com/auth/classroom.profile.photos"
        "https://www.googleapis.com/auth/classroom.rosters"
        "https://www.googleapis.com/auth/classroom.rosters.readonly"]})))

(defn userProfiles-get
  "Returns a user profile. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to access this user profile, if no profile exists with the requested ID, or for access errors.
https://developers.google.com/classroom/reference/rest/v1/userProfiles/get

userId <string> Identifier of the profile to return. The identifier can be one of the following: * the numeric identifier for the user * the email address of the user * the string literal `\"me\"`, indicating the requesting user"
  [userId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://classroom.googleapis.com/v1/userProfiles/{userId}",
     :uri-template-args {:userId userId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/classroom.profile.emails"
      "https://www.googleapis.com/auth/classroom.profile.photos"
      "https://www.googleapis.com/auth/classroom.rosters"
      "https://www.googleapis.com/auth/classroom.rosters.readonly"]}))

(defn userProfiles-guardianInvitations-list
  "Returns a list of guardian invitations that the requesting user is permitted to view, filtered by the parameters provided. This method returns the following error codes: * `PERMISSION_DENIED` if a `student_id` is specified, and the requesting user is not permitted to view guardian invitations for that student, if `\"-\"` is specified as the `student_id` and the user is not a domain administrator, if guardians are not enabled for the domain in question, or for other access errors. * `INVALID_ARGUMENT` if a `student_id` is specified, but its format cannot be recognized (it is not an email address, nor a `student_id` from the API, nor the literal string `me`). May also be returned if an invalid `page_token` or `state` is provided. * `NOT_FOUND` if a `student_id` is specified, and its format can be recognized, but Classroom has no record of that student.
https://developers.google.com/classroom/reference/rest/v1/userProfiles/guardianInvitations/list

studentId <string> The ID of the student whose guardian invitations are to be returned. The identifier can be one of the following: * the numeric identifier for the user * the email address of the user * the string literal `\"me\"`, indicating the requesting user * the string literal `\"-\"`, indicating that results should be returned for all students that the requesting user is permitted to view guardian invitations.

optional:
invitedEmailAddress <string> If specified, only results with the specified `invited_email_address` are returned.
states <string> If specified, only results with the specified `state` values are returned. Otherwise, results with a `state` of `PENDING` are returned.
pageSize <integer> Maximum number of items to return. Zero or unspecified indicates that the server may assign a maximum. The server may return fewer than the specified number of results."
  ([studentId] (userProfiles-guardianInvitations-list studentId nil))
  ([studentId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://classroom.googleapis.com/v1/userProfiles/{studentId}/guardianInvitations",
       :uri-template-args {:studentId studentId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/classroom.guardianlinks.students"
        "https://www.googleapis.com/auth/classroom.guardianlinks.students.readonly"]})))

(defn userProfiles-guardianInvitations-get
  "Returns a specific guardian invitation. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to view guardian invitations for the student identified by the `student_id`, if guardians are not enabled for the domain in question, or for other access errors. * `INVALID_ARGUMENT` if a `student_id` is specified, but its format cannot be recognized (it is not an email address, nor a `student_id` from the API, nor the literal string `me`). * `NOT_FOUND` if Classroom cannot find any record of the given student or `invitation_id`. May also be returned if the student exists, but the requesting user does not have access to see that student.
https://developers.google.com/classroom/reference/rest/v1/userProfiles/guardianInvitations/get

studentId <string> The ID of the student whose guardian invitation is being requested.
invitationId <string> The `id` field of the `GuardianInvitation` being requested."
  [studentId invitationId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://classroom.googleapis.com/v1/userProfiles/{studentId}/guardianInvitations/{invitationId}",
     :uri-template-args
     {:studentId studentId, :invitationId invitationId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/classroom.guardianlinks.students"
      "https://www.googleapis.com/auth/classroom.guardianlinks.students.readonly"]}))

(defn userProfiles-guardianInvitations-create
  "Creates a guardian invitation, and sends an email to the guardian asking them to confirm that they are the student's guardian. Once the guardian accepts the invitation, their `state` will change to `COMPLETED` and they will start receiving guardian notifications. A `Guardian` resource will also be created to represent the active guardian. The request object must have the `student_id` and `invited_email_address` fields set. Failing to set these fields, or setting any other fields in the request, will result in an error. This method returns the following error codes: * `PERMISSION_DENIED` if the current user does not have permission to manage guardians, if the guardian in question has already rejected too many requests for that student, if guardians are not enabled for the domain in question, or for other access errors. * `RESOURCE_EXHAUSTED` if the student or guardian has exceeded the guardian link limit. * `INVALID_ARGUMENT` if the guardian email address is not valid (for example, if it is too long), or if the format of the student ID provided cannot be recognized (it is not an email address, nor a `user_id` from this API). This error will also be returned if read-only fields are set, or if the `state` field is set to to a value other than `PENDING`. * `NOT_FOUND` if the student ID provided is a valid student ID, but Classroom has no record of that student. * `ALREADY_EXISTS` if there is already a pending guardian invitation for the student and `invited_email_address` provided, or if the provided `invited_email_address` matches the Google account of an existing `Guardian` for this user.
https://developers.google.com/classroom/reference/rest/v1/userProfiles/guardianInvitations/create

studentId <string> ID of the student (in standard format)
GuardianInvitation:
{:studentId string,
 :invitationId string,
 :invitedEmailAddress string,
 :state [GUARDIAN_INVITATION_STATE_UNSPECIFIED PENDING COMPLETE],
 :creationTime string}"
  [studentId GuardianInvitation]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://classroom.googleapis.com/v1/userProfiles/{studentId}/guardianInvitations",
     :uri-template-args {:studentId studentId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/classroom.guardianlinks.students"],
     :body GuardianInvitation}))

(defn userProfiles-guardianInvitations-patch
  "Modifies a guardian invitation. Currently, the only valid modification is to change the `state` from `PENDING` to `COMPLETE`. This has the effect of withdrawing the invitation. This method returns the following error codes: * `PERMISSION_DENIED` if the current user does not have permission to manage guardians, if guardians are not enabled for the domain in question or for other access errors. * `FAILED_PRECONDITION` if the guardian link is not in the `PENDING` state. * `INVALID_ARGUMENT` if the format of the student ID provided cannot be recognized (it is not an email address, nor a `user_id` from this API), or if the passed `GuardianInvitation` has a `state` other than `COMPLETE`, or if it modifies fields other than `state`. * `NOT_FOUND` if the student ID provided is a valid student ID, but Classroom has no record of that student, or if the `id` field does not refer to a guardian invitation known to Classroom.
https://developers.google.com/classroom/reference/rest/v1/userProfiles/guardianInvitations/patch

studentId <string> The ID of the student whose guardian invitation is to be modified.
invitationId <string> The `id` field of the `GuardianInvitation` to be modified.
GuardianInvitation:
{:studentId string,
 :invitationId string,
 :invitedEmailAddress string,
 :state [GUARDIAN_INVITATION_STATE_UNSPECIFIED PENDING COMPLETE],
 :creationTime string}

optional:
updateMask <string> Mask that identifies which fields on the course to update. This field is required to do an update. The update fails if invalid fields are specified. The following fields are valid: * `state` When set in a query parameter, this field should be specified as `updateMask=,,...`"
  ([studentId invitationId GuardianInvitation]
    (userProfiles-guardianInvitations-patch
      studentId
      invitationId
      GuardianInvitation
      nil))
  ([studentId invitationId GuardianInvitation optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://classroom.googleapis.com/v1/userProfiles/{studentId}/guardianInvitations/{invitationId}",
       :uri-template-args
       {:studentId studentId, :invitationId invitationId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/classroom.guardianlinks.students"],
       :body GuardianInvitation})))

(defn userProfiles-guardians-list
  "Returns a list of guardians that the requesting user is permitted to view, restricted to those that match the request. To list guardians for any student that the requesting user may view guardians for, use the literal character `-` for the student ID. This method returns the following error codes: * `PERMISSION_DENIED` if a `student_id` is specified, and the requesting user is not permitted to view guardian information for that student, if `\"-\"` is specified as the `student_id` and the user is not a domain administrator, if guardians are not enabled for the domain in question, if the `invited_email_address` filter is set by a user who is not a domain administrator, or for other access errors. * `INVALID_ARGUMENT` if a `student_id` is specified, but its format cannot be recognized (it is not an email address, nor a `student_id` from the API, nor the literal string `me`). May also be returned if an invalid `page_token` is provided. * `NOT_FOUND` if a `student_id` is specified, and its format can be recognized, but Classroom has no record of that student.
https://developers.google.com/classroom/reference/rest/v1/userProfiles/guardians/list

studentId <string> Filter results by the student who the guardian is linked to. The identifier can be one of the following: * the numeric identifier for the user * the email address of the user * the string literal `\"me\"`, indicating the requesting user * the string literal `\"-\"`, indicating that results should be returned for all students that the requesting user has access to view.

optional:
invitedEmailAddress <string> Filter results by the email address that the original invitation was sent to, resulting in this guardian link. This filter can only be used by domain administrators.
pageSize <integer> Maximum number of items to return. Zero or unspecified indicates that the server may assign a maximum. The server may return fewer than the specified number of results."
  ([studentId] (userProfiles-guardians-list studentId nil))
  ([studentId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://classroom.googleapis.com/v1/userProfiles/{studentId}/guardians",
       :uri-template-args {:studentId studentId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/classroom.guardianlinks.me.readonly"
        "https://www.googleapis.com/auth/classroom.guardianlinks.students"
        "https://www.googleapis.com/auth/classroom.guardianlinks.students.readonly"]})))

(defn userProfiles-guardians-get
  "Returns a specific guardian. This method returns the following error codes: * `PERMISSION_DENIED` if no user that matches the provided `student_id` is visible to the requesting user, if the requesting user is not permitted to view guardian information for the student identified by the `student_id`, if guardians are not enabled for the domain in question, or for other access errors. * `INVALID_ARGUMENT` if a `student_id` is specified, but its format cannot be recognized (it is not an email address, nor a `student_id` from the API, nor the literal string `me`). * `NOT_FOUND` if the requesting user is permitted to view guardians for the requested `student_id`, but no `Guardian` record exists for that student that matches the provided `guardian_id`.
https://developers.google.com/classroom/reference/rest/v1/userProfiles/guardians/get

studentId <string> The student whose guardian is being requested. One of the following: * the numeric identifier for the user * the email address of the user * the string literal `\"me\"`, indicating the requesting user
guardianId <string> The `id` field from a `Guardian`."
  [studentId guardianId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://classroom.googleapis.com/v1/userProfiles/{studentId}/guardians/{guardianId}",
     :uri-template-args {:studentId studentId, :guardianId guardianId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/classroom.guardianlinks.me.readonly"
      "https://www.googleapis.com/auth/classroom.guardianlinks.students"
      "https://www.googleapis.com/auth/classroom.guardianlinks.students.readonly"]}))

(defn userProfiles-guardians-delete
  "Deletes a guardian. The guardian will no longer receive guardian notifications and the guardian will no longer be accessible via the API. This method returns the following error codes: * `PERMISSION_DENIED` if no user that matches the provided `student_id` is visible to the requesting user, if the requesting user is not permitted to manage guardians for the student identified by the `student_id`, if guardians are not enabled for the domain in question, or for other access errors. * `INVALID_ARGUMENT` if a `student_id` is specified, but its format cannot be recognized (it is not an email address, nor a `student_id` from the API). * `NOT_FOUND` if the requesting user is permitted to modify guardians for the requested `student_id`, but no `Guardian` record exists for that student with the provided `guardian_id`.
https://developers.google.com/classroom/reference/rest/v1/userProfiles/guardians/delete

studentId <string> The student whose guardian is to be deleted. One of the following: * the numeric identifier for the user * the email address of the user * the string literal `\"me\"`, indicating the requesting user
guardianId <string> The `id` field from a `Guardian`."
  [studentId guardianId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://classroom.googleapis.com/v1/userProfiles/{studentId}/guardians/{guardianId}",
     :uri-template-args {:studentId studentId, :guardianId guardianId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/classroom.guardianlinks.students"]}))

(defn invitations-create
  "Creates an invitation. Only one invitation for a user and course may exist at a time. Delete and re-create an invitation to make changes. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to create invitations for this course or for access errors. * `NOT_FOUND` if the course or the user does not exist. * `FAILED_PRECONDITION`: * if the requested user's account is disabled. * if the user already has this role or a role with greater permissions. * for the following request errors: * IneligibleOwner * `ALREADY_EXISTS` if an invitation for the specified user and course already exists.
https://developers.google.com/classroom/reference/rest/v1/invitations/create

Invitation:
{:id string,
 :userId string,
 :courseId string,
 :role [COURSE_ROLE_UNSPECIFIED STUDENT TEACHER OWNER]}"
  [Invitation]
  (client/api-request
    {:method "POST",
     :uri-template "https://classroom.googleapis.com/v1/invitations",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/classroom.rosters"],
     :body Invitation}))

(defn invitations-get
  "Returns an invitation. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to view the requested invitation or for access errors. * `NOT_FOUND` if no invitation exists with the requested ID.
https://developers.google.com/classroom/reference/rest/v1/invitations/get

id <string> Identifier of the invitation to return."
  [id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://classroom.googleapis.com/v1/invitations/{id}",
     :uri-template-args {:id id},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/classroom.rosters"
      "https://www.googleapis.com/auth/classroom.rosters.readonly"]}))

(defn invitations-delete
  "Deletes an invitation. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to delete the requested invitation or for access errors. * `NOT_FOUND` if no invitation exists with the requested ID.
https://developers.google.com/classroom/reference/rest/v1/invitations/delete

id <string> Identifier of the invitation to delete."
  [id]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://classroom.googleapis.com/v1/invitations/{id}",
     :uri-template-args {:id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/classroom.rosters"]}))

(defn invitations-list
  "Returns a list of invitations that the requesting user is permitted to view, restricted to those that match the list request. *Note:* At least one of `user_id` or `course_id` must be supplied. Both fields can be supplied. This method returns the following error codes: * `PERMISSION_DENIED` for access errors.
https://developers.google.com/classroom/reference/rest/v1/invitations/list

optional:
userId <string> Restricts returned invitations to those for a specific user. The identifier can be one of the following: * the numeric identifier for the user * the email address of the user * the string literal `\"me\"`, indicating the requesting user
courseId <string> Restricts returned invitations to those for a course with the specified identifier.
pageSize <integer> Maximum number of items to return. The default is 500 if unspecified or `0`. The server may return fewer than the specified number of results."
  ([] (invitations-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://classroom.googleapis.com/v1/invitations",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/classroom.rosters"
        "https://www.googleapis.com/auth/classroom.rosters.readonly"]})))

(defn invitations-accept
  "Accepts an invitation, removing it and adding the invited user to the teachers or students (as appropriate) of the specified course. Only the invited user may accept an invitation. This method returns the following error codes: * `PERMISSION_DENIED` if the requesting user is not permitted to accept the requested invitation or for access errors. * `FAILED_PRECONDITION` for the following request errors: * CourseMemberLimitReached * CourseNotModifiable * CourseTeacherLimitReached * UserGroupsMembershipLimitReached * `NOT_FOUND` if no invitation exists with the requested ID.
https://developers.google.com/classroom/reference/rest/v1/invitations/accept

id <string> Identifier of the invitation to accept."
  [id]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://classroom.googleapis.com/v1/invitations/{id}:accept",
     :uri-template-args {:id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/classroom.rosters"]}))

(defn registrations-create
  "Creates a `Registration`, causing Classroom to start sending notifications from the provided `feed` to the destination provided in `cloudPubSubTopic`. Returns the created `Registration`. Currently, this will be the same as the argument, but with server-assigned fields such as `expiry_time` and `id` filled in. Note that any value specified for the `expiry_time` or `id` fields will be ignored. While Classroom may validate the `cloudPubSubTopic` and return errors on a best effort basis, it is the caller's responsibility to ensure that it exists and that Classroom has permission to publish to it. This method may return the following error codes: * `PERMISSION_DENIED` if: * the authenticated user does not have permission to receive notifications from the requested field; or * the current user has not granted access to the current Cloud project with the appropriate scope for the requested feed. Note that domain-wide delegation of authority is not currently supported for this purpose. If the request has the appropriate scope, but no grant exists, a Request Errors is returned. * another access error is encountered. * `INVALID_ARGUMENT` if: * no `cloudPubsubTopic` is specified, or the specified `cloudPubsubTopic` is not valid; or * no `feed` is specified, or the specified `feed` is not valid. * `NOT_FOUND` if: * the specified `feed` cannot be located, or the requesting user does not have permission to determine whether or not it exists; or * the specified `cloudPubsubTopic` cannot be located, or Classroom has not been granted permission to publish to it.
https://developers.google.com/classroom/reference/rest/v1/registrations/create

Registration:
{:registrationId string,
 :feed
 {:feedType
  [FEED_TYPE_UNSPECIFIED
   DOMAIN_ROSTER_CHANGES
   COURSE_ROSTER_CHANGES
   COURSE_WORK_CHANGES],
  :courseRosterChangesInfo {:courseId string},
  :courseWorkChangesInfo {:courseId string}},
 :cloudPubsubTopic {:topicName string},
 :expiryTime string}"
  [Registration]
  (client/api-request
    {:method "POST",
     :uri-template "https://classroom.googleapis.com/v1/registrations",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/classroom.push-notifications"],
     :body Registration}))

(defn registrations-delete
  "Deletes a `Registration`, causing Classroom to stop sending notifications for that `Registration`.
https://developers.google.com/classroom/reference/rest/v1/registrations/delete

registrationId <string> The `registration_id` of the `Registration` to be deleted."
  [registrationId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://classroom.googleapis.com/v1/registrations/{registrationId}",
     :uri-template-args {:registrationId registrationId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/classroom.push-notifications"]}))

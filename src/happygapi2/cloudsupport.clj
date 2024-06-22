(ns happygapi2.cloudsupport
  "Google Cloud Support API
Manages Google Cloud technical support cases for Customer Care support offerings. 
See: https://cloud.google.com/support/docs/apis"
  (:require [happy.oauth2.client :as client]))

(defn media-upload
  "Create a file attachment on a case or Cloud resource. The attachment must have the following fields set: `filename`. EXAMPLES: cURL: ```shell echo \"This text is in a file I'm uploading using CSAPI.\" \\ > \"./example_file.txt\" case=\"projects/some-project/cases/43594844\" curl \\ --header \"Authorization: Bearer $(gcloud auth print-access-token)\" \\ --data-binary @\"./example_file.txt\" \\ \"https://cloudsupport.googleapis.com/upload/v2beta/$case/attachments?attachment.filename=uploaded_via_curl.txt\" ``` Python: ```python import googleapiclient.discovery api_version = \"v2\" supportApiService = googleapiclient.discovery.build( serviceName=\"cloudsupport\", version=api_version, discoveryServiceUrl=f\"https://cloudsupport.googleapis.com/$discovery/rest?version={api_version}\", ) file_path = \"./example_file.txt\" with open(file_path, \"w\") as file: file.write( \"This text is inside a file I'm going to upload using the Cloud Support API.\", ) request = supportApiService.media().upload( parent=\"projects/some-project/cases/43595344\", media_body=file_path ) request.uri = request.uri.split(\"?\")[0] + \"?attachment.filename=uploaded_via_python.txt\" print(request.execute()) ```
https://cloud.google.com/support/docs/apis/v2/docs/media/upload

parent <string> Required. The name of the case or Cloud resource to which the attachment should be attached.
CreateAttachmentRequest:
{:attachment
 {:mimeType string,
  :sizeBytes string,
  :name string,
  :createTime string,
  :filename string,
  :creator
  {:displayName string,
   :email string,
   :googleSupport boolean,
   :username string}}}"
  [parent CreateAttachmentRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudsupport.googleapis.com/v2/{+parent}/attachments",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CreateAttachmentRequest}))

(defn media-download
  "Download a file attached to a case. Note: HTTP requests must append \"?alt=media\" to the URL. EXAMPLES: cURL: ```shell name=\"projects/some-project/cases/43594844/attachments/0674M00000WijAnZAJ\" curl \\ --header \"Authorization: Bearer $(gcloud auth print-access-token)\" \\ \"https://cloudsupport.googleapis.com/v2/$name:download?alt=media\" ``` Python: ```python import googleapiclient.discovery api_version = \"v2\" supportApiService = googleapiclient.discovery.build( serviceName=\"cloudsupport\", version=api_version, discoveryServiceUrl=f\"https://cloudsupport.googleapis.com/$discovery/rest?version={api_version}\", ) request = supportApiService.media().download( name=\"projects/some-project/cases/43595344/attachments/0684M00000Pw6pHQAR\" ) request.uri = request.uri.split(\"?\")[0] + \"?alt=media\" print(request.execute()) ```
https://cloud.google.com/support/docs/apis/v2/docs/media/download

name <string> The name of the file attachment to download."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://cloudsupport.googleapis.com/v2/{+name}:download",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn caseClassifications-search
  "Retrieve valid classifications to use when creating a support case. Classifications are hierarchical. Each classification is a string containing all levels of the hierarchy separated by `\" > \"`. For example, `\"Technical Issue > Compute > Compute Engine\"`. Classification IDs returned by this endpoint are valid for at least six months. When a classification is deactivated, this endpoint immediately stops returning it. After six months, `case.create` requests using the classification will fail. EXAMPLES: cURL: ```shell curl \\ --header \"Authorization: Bearer $(gcloud auth print-access-token)\" \\ 'https://cloudsupport.googleapis.com/v2/caseClassifications:search?query=display_name:\"*Compute%20Engine*\"' ``` Python: ```python import googleapiclient.discovery supportApiService = googleapiclient.discovery.build( serviceName=\"cloudsupport\", version=\"v2\", discoveryServiceUrl=f\"https://cloudsupport.googleapis.com/$discovery/rest?version=v2\", ) request = supportApiService.caseClassifications().search( query='display_name:\"*Compute Engine*\"' ) print(request.execute()) ```
https://cloud.google.com/support/docs/apis/v2/docs/caseClassifications/search

optional:
query <string> An expression used to filter case classifications. If it's an empty string, then no filtering happens. Otherwise, case classifications will be returned that match the filter.
pageSize <integer> The maximum number of classifications fetched with each request."
  ([] (caseClassifications-search nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudsupport.googleapis.com/v2/caseClassifications:search",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn cases-escalate
  "Escalate a case, starting the Google Cloud Support escalation management process. This operation is only available for some support services. Go to https://cloud.google.com/support and look for 'Technical support escalations' in the feature list to find out which ones let you do that. EXAMPLES: cURL: ```shell case=\"projects/some-project/cases/43595344\" curl \\ --request POST \\ --header \"Authorization: Bearer $(gcloud auth print-access-token)\" \\ --header \"Content-Type: application/json\" \\ --data '{ \"escalation\": { \"reason\": \"BUSINESS_IMPACT\", \"justification\": \"This is a test escalation.\" } }' \\ \"https://cloudsupport.googleapis.com/v2/$case:escalate\" ``` Python: ```python import googleapiclient.discovery api_version = \"v2\" supportApiService = googleapiclient.discovery.build( serviceName=\"cloudsupport\", version=api_version, discoveryServiceUrl=f\"https://cloudsupport.googleapis.com/$discovery/rest?version={api_version}\", ) request = supportApiService.cases().escalate( name=\"projects/some-project/cases/43595344\", body={ \"escalation\": { \"reason\": \"BUSINESS_IMPACT\", \"justification\": \"This is a test escalation.\", }, }, ) print(request.execute()) ```
https://cloud.google.com/support/docs/apis/v2/docs/cases/escalate

name <string> Required. The name of the case to be escalated.
EscalateCaseRequest:
{:escalation
 {:justification string,
  :reason
  [REASON_UNSPECIFIED
   RESOLUTION_TIME
   TECHNICAL_EXPERTISE
   BUSINESS_IMPACT]}}"
  [name EscalateCaseRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudsupport.googleapis.com/v2/{+name}:escalate",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body EscalateCaseRequest}))

(defn cases-close
  "Close a case. EXAMPLES: cURL: ```shell case=\"projects/some-project/cases/43595344\" curl \\ --request POST \\ --header \"Authorization: Bearer $(gcloud auth print-access-token)\" \\ \"https://cloudsupport.googleapis.com/v2/$case:close\" ``` Python: ```python import googleapiclient.discovery api_version = \"v2\" supportApiService = googleapiclient.discovery.build( serviceName=\"cloudsupport\", version=api_version, discoveryServiceUrl=f\"https://cloudsupport.googleapis.com/$discovery/rest?version={api_version}\", ) request = supportApiService.cases().close( name=\"projects/some-project/cases/43595344\" ) print(request.execute()) ```
https://cloud.google.com/support/docs/apis/v2/docs/cases/close

name <string> Required. The name of the case to close.
CloseCaseRequest:
object"
  [name CloseCaseRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudsupport.googleapis.com/v2/{+name}:close",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CloseCaseRequest}))

(defn cases-list
  "Retrieve all cases under a parent, but not its children. For example, listing cases under an organization only returns the cases that are directly parented by that organization. To retrieve cases under an organization and its projects, use `cases.search`. EXAMPLES: cURL: ```shell parent=\"projects/some-project\" curl \\ --header \"Authorization: Bearer $(gcloud auth print-access-token)\" \\ \"https://cloudsupport.googleapis.com/v2/$parent/cases\" ``` Python: ```python import googleapiclient.discovery api_version = \"v2\" supportApiService = googleapiclient.discovery.build( serviceName=\"cloudsupport\", version=api_version, discoveryServiceUrl=f\"https://cloudsupport.googleapis.com/$discovery/rest?version={api_version}\", ) request = supportApiService.cases().list(parent=\"projects/some-project\") print(request.execute()) ```
https://cloud.google.com/support/docs/apis/v2/docs/cases/list

parent <string> Required. The name of a parent to list cases under.

optional:
pageSize <integer> The maximum number of cases fetched with each request. Defaults to 10.
filter <string> An expression used to filter cases. If it's an empty string, then no filtering happens. Otherwise, the endpoint returns the cases that match the filter. Expressions use the following fields separated by `AND` and specified with `=`: - `state`: Can be `OPEN` or `CLOSED`. - `priority`: Can be `P0`, `P1`, `P2`, `P3`, or `P4`. You can specify multiple values for priority using the `OR` operator. For example, `priority=P1 OR priority=P2`. - `creator.email`: The email address of the case creator. EXAMPLES: - `state=CLOSED` - `state=OPEN AND creator.email=\"tester@example.com\"` - `state=OPEN AND (priority=P0 OR priority=P1)`"
  ([parent] (cases-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudsupport.googleapis.com/v2/{+parent}/cases",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn cases-search
  "Search for cases using a query. EXAMPLES: cURL: ```shell parent=\"projects/some-project\" curl \\ --header \"Authorization: Bearer $(gcloud auth print-access-token)\" \\ \"https://cloudsupport.googleapis.com/v2/$parent/cases:search\" ``` Python: ```python import googleapiclient.discovery api_version = \"v2\" supportApiService = googleapiclient.discovery.build( serviceName=\"cloudsupport\", version=api_version, discoveryServiceUrl=f\"https://cloudsupport.googleapis.com/$discovery/rest?version={api_version}\", ) request = supportApiService.cases().search( parent=\"projects/some-project\", query=\"state=OPEN\" ) print(request.execute()) ```
https://cloud.google.com/support/docs/apis/v2/docs/cases/search

parent <string> The name of the parent resource to search for cases under.

optional:
pageSize <integer> The maximum number of cases fetched with each request. The default page size is 10.
query <string> An expression used to filter cases. Expressions use the following fields separated by `AND` and specified with `=`: - `organization`: An organization name in the form `organizations/`. - `project`: A project name in the form `projects/`. - `state`: Can be `OPEN` or `CLOSED`. - `priority`: Can be `P0`, `P1`, `P2`, `P3`, or `P4`. You can specify multiple values for priority using the `OR` operator. For example, `priority=P1 OR priority=P2`. - `creator.email`: The email address of the case creator. You must specify either `organization` or `project`. To search across `displayName`, `description`, and comments, use a global restriction with no keyword or operator. For example, `\"my search\"`. To search only cases updated after a certain date, use `update_time` restricted with that particular date, time, and timezone in ISO datetime format. For example, `update_time>\"2020-01-01T00:00:00-05:00\"`. `update_time` only supports the greater than operator (`>`). Examples: - `organization=\"organizations/123456789\"` - `project=\"projects/my-project-id\"` - `project=\"projects/123456789\"` - `organization=\"organizations/123456789\" AND state=CLOSED` - `project=\"projects/my-project-id\" AND creator.email=\"tester@example.com\"` - `project=\"projects/my-project-id\" AND (priority=P0 OR priority=P1)`"
  ([parent] (cases-search parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudsupport.googleapis.com/v2/{+parent}/cases:search",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn cases-patch
  "Update a case. Only some fields can be updated. EXAMPLES: cURL: ```shell case=\"projects/some-project/cases/43595344\" curl \\ --request PATCH \\ --header \"Authorization: Bearer $(gcloud auth print-access-token)\" \\ --header \"Content-Type: application/json\" \\ --data '{ \"priority\": \"P1\" }' \\ \"https://cloudsupport.googleapis.com/v2/$case?updateMask=priority\" ``` Python: ```python import googleapiclient.discovery api_version = \"v2\" supportApiService = googleapiclient.discovery.build( serviceName=\"cloudsupport\", version=api_version, discoveryServiceUrl=f\"https://cloudsupport.googleapis.com/$discovery/rest?version={api_version}\", ) request = supportApiService.cases().patch( name=\"projects/some-project/cases/43112854\", body={ \"displayName\": \"This is Now a New Title\", \"priority\": \"P2\", }, ) print(request.execute()) ```
https://cloud.google.com/support/docs/apis/v2/docs/cases/patch

name <string> The resource name for the case.
Case:
{:description string,
 :timeZone string,
 :creator
 {:displayName string,
  :email string,
  :googleSupport boolean,
  :username string},
 :displayName string,
 :name string,
 :createTime string,
 :state
 [STATE_UNSPECIFIED
  NEW
  IN_PROGRESS_GOOGLE_SUPPORT
  ACTION_REQUIRED
  SOLUTION_PROVIDED
  CLOSED],
 :classification {:id string, :displayName string},
 :escalated boolean,
 :contactEmail string,
 :updateTime string,
 :languageCode string,
 :priority [PRIORITY_UNSPECIFIED P0 P1 P2 P3 P4],
 :testCase boolean,
 :subscriberEmailAddresses [string]}

optional:
updateMask <string> A list of attributes of the case that should be updated. Supported values are `priority`, `display_name`, and `subscriber_email_addresses`. If no fields are specified, all supported fields are updated. Be careful - if you do not provide a field mask, then you might accidentally clear some fields. For example, if you leave the field mask empty and do not provide a value for `subscriber_email_addresses`, then `subscriber_email_addresses` is updated to empty."
  ([name Case] (cases-patch name Case nil))
  ([name Case optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://cloudsupport.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Case})))

(defn cases-get
  "Retrieve a case. EXAMPLES: cURL: ```shell case=\"projects/some-project/cases/16033687\" curl \\ --header \"Authorization: Bearer $(gcloud auth print-access-token)\" \\ \"https://cloudsupport.googleapis.com/v2/$case\" ``` Python: ```python import googleapiclient.discovery api_version = \"v2\" supportApiService = googleapiclient.discovery.build( serviceName=\"cloudsupport\", version=api_version, discoveryServiceUrl=f\"https://cloudsupport.googleapis.com/$discovery/rest?version={api_version}\", ) request = supportApiService.cases().get( name=\"projects/some-project/cases/43595344\", ) print(request.execute()) ```
https://cloud.google.com/support/docs/apis/v2/docs/cases/get

name <string> Required. The full name of a case to be retrieved."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://cloudsupport.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn cases-create
  "Create a new case and associate it with a parent. It must have the following fields set: `display_name`, `description`, `classification`, and `priority`. If you're just testing the API and don't want to route your case to an agent, set `testCase=true`. EXAMPLES: cURL: ```shell parent=\"projects/some-project\" curl \\ --request POST \\ --header \"Authorization: Bearer $(gcloud auth print-access-token)\" \\ --header 'Content-Type: application/json' \\ --data '{ \"display_name\": \"Test case created by me.\", \"description\": \"a random test case, feel free to close\", \"classification\": { \"id\": \"100IK2AKCLHMGRJ9CDGMOCGP8DM6UTB4BT262T31BT1M2T31DHNMENPO6KS36CPJ786L2TBFEHGN6NPI64R3CDHN8880G08I1H3MURR7DHII0GRCDTQM8\" }, \"time_zone\": \"-07:00\", \"subscriber_email_addresses\": [ \"foo@domain.com\", \"bar@domain.com\" ], \"testCase\": true, \"priority\": \"P3\" }' \\ \"https://cloudsupport.googleapis.com/v2/$parent/cases\" ``` Python: ```python import googleapiclient.discovery api_version = \"v2\" supportApiService = googleapiclient.discovery.build( serviceName=\"cloudsupport\", version=api_version, discoveryServiceUrl=f\"https://cloudsupport.googleapis.com/$discovery/rest?version={api_version}\", ) request = supportApiService.cases().create( parent=\"projects/some-project\", body={ \"displayName\": \"A Test Case\", \"description\": \"This is a test case.\", \"testCase\": True, \"priority\": \"P2\", \"classification\": { \"id\": \"100IK2AKCLHMGRJ9CDGMOCGP8DM6UTB4BT262T31BT1M2T31DHNMENPO6KS36CPJ786L2TBFEHGN6NPI64R3CDHN8880G08I1H3MURR7DHII0GRCDTQM8\" }, }, ) print(request.execute()) ```
https://cloud.google.com/support/docs/apis/v2/docs/cases/create

parent <string> Required. The name of the parent under which the case should be created.
Case:
{:description string,
 :timeZone string,
 :creator
 {:displayName string,
  :email string,
  :googleSupport boolean,
  :username string},
 :displayName string,
 :name string,
 :createTime string,
 :state
 [STATE_UNSPECIFIED
  NEW
  IN_PROGRESS_GOOGLE_SUPPORT
  ACTION_REQUIRED
  SOLUTION_PROVIDED
  CLOSED],
 :classification {:id string, :displayName string},
 :escalated boolean,
 :contactEmail string,
 :updateTime string,
 :languageCode string,
 :priority [PRIORITY_UNSPECIFIED P0 P1 P2 P3 P4],
 :testCase boolean,
 :subscriberEmailAddresses [string]}"
  [parent Case]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudsupport.googleapis.com/v2/{+parent}/cases",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body Case}))

(defn cases-comments-list
  "List all the comments associated with a case. EXAMPLES: cURL: ```shell case=\"projects/some-project/cases/43595344\" curl \\ --header \"Authorization: Bearer $(gcloud auth print-access-token)\" \\ \"https://cloudsupport.googleapis.com/v2/$case/comments\" ``` Python: ```python import googleapiclient.discovery api_version = \"v2\" supportApiService = googleapiclient.discovery.build( serviceName=\"cloudsupport\", version=api_version, discoveryServiceUrl=f\"https://cloudsupport.googleapis.com/$discovery/rest?version={api_version}\", ) request = ( supportApiService.cases() .comments() .list(parent=\"projects/some-project/cases/43595344\") ) print(request.execute()) ```
https://cloud.google.com/support/docs/apis/v2/docs/cases/comments/list

parent <string> Required. The name of the case for which to list comments.

optional:
pageSize <integer> The maximum number of comments to fetch. Defaults to 10."
  ([parent] (cases-comments-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudsupport.googleapis.com/v2/{+parent}/comments",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn cases-comments-create
  "Add a new comment to a case. The comment must have the following fields set: `body`. EXAMPLES: cURL: ```shell case=\"projects/some-project/cases/43591344\" curl \\ --request POST \\ --header \"Authorization: Bearer $(gcloud auth print-access-token)\" \\ --header 'Content-Type: application/json' \\ --data '{ \"body\": \"This is a test comment.\" }' \\ \"https://cloudsupport.googleapis.com/v2/$case/comments\" ``` Python: ```python import googleapiclient.discovery api_version = \"v2\" supportApiService = googleapiclient.discovery.build( serviceName=\"cloudsupport\", version=api_version, discoveryServiceUrl=f\"https://cloudsupport.googleapis.com/$discovery/rest?version={api_version}\", ) request = ( supportApiService.cases() .comments() .create( parent=\"projects/some-project/cases/43595344\", body={\"body\": \"This is a test comment.\"}, ) ) print(request.execute()) ```
https://cloud.google.com/support/docs/apis/v2/docs/cases/comments/create

parent <string> Required. The name of the case to which the comment should be added.
Comment:
{:plainTextBody string,
 :name string,
 :createTime string,
 :body string,
 :creator
 {:displayName string,
  :email string,
  :googleSupport boolean,
  :username string}}"
  [parent Comment]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudsupport.googleapis.com/v2/{+parent}/comments",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body Comment}))

(defn cases-attachments-list
  "List all the attachments associated with a support case. EXAMPLES: cURL: ```shell case=\"projects/some-project/cases/23598314\" curl \\ --header \"Authorization: Bearer $(gcloud auth print-access-token)\" \\ \"https://cloudsupport.googleapis.com/v2/$case/attachments\" ``` Python: ```python import googleapiclient.discovery api_version = \"v2\" supportApiService = googleapiclient.discovery.build( serviceName=\"cloudsupport\", version=api_version, discoveryServiceUrl=f\"https://cloudsupport.googleapis.com/$discovery/rest?version={api_version}\", ) request = ( supportApiService.cases() .attachments() .list(parent=\"projects/some-project/cases/43595344\") ) print(request.execute()) ```
https://cloud.google.com/support/docs/apis/v2/docs/cases/attachments/list

parent <string> Required. The name of the case for which attachments should be listed.

optional:
pageSize <integer> The maximum number of attachments fetched with each request. If not provided, the default is 10. The maximum page size that will be returned is 100."
  ([parent] (cases-attachments-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudsupport.googleapis.com/v2/{+parent}/attachments",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

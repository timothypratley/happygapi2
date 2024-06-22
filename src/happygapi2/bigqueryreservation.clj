(ns happygapi2.bigqueryreservation
  "BigQuery Reservation API
A service to modify your BigQuery flat-rate reservations.
See: https://cloud.google.com/bigquery/"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-searchAssignments
  "Deprecated: Looks up assignments for a specified resource for a particular region. If the request is about a project: 1. Assignments created on the project will be returned if they exist. 2. Otherwise assignments created on the closest ancestor will be returned. 3. Assignments for different JobTypes will all be returned. The same logic applies if the request is about a folder. If the request is about an organization, then assignments created on the organization will be returned (organization doesn't have ancestors). Comparing to ListAssignments, there are some behavior differences: 1. permission on the assignee will be verified in this API. 2. Hierarchy lookup (project->folder->organization) happens in this API. 3. Parent here is `projects/*/locations/*`, instead of `projects/*/locations/*reservations/*`. **Note** \"-\" cannot be used for projects nor locations.
https://cloud.google.com/bigquery

parent <string> Required. The resource name of the admin project(containing project and location), e.g.: `projects/myproject/locations/US`.

optional:
query <string> Please specify resource name as assignee in the query. Examples: * `assignee=projects/myproject` * `assignee=folders/123` * `assignee=organizations/456`
pageSize <integer> The maximum number of items to return per page."
  ([parent] (projects-locations-searchAssignments parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigqueryreservation.googleapis.com/v1/{+parent}:searchAssignments",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-searchAllAssignments
  "Looks up assignments for a specified resource for a particular region. If the request is about a project: 1. Assignments created on the project will be returned if they exist. 2. Otherwise assignments created on the closest ancestor will be returned. 3. Assignments for different JobTypes will all be returned. The same logic applies if the request is about a folder. If the request is about an organization, then assignments created on the organization will be returned (organization doesn't have ancestors). Comparing to ListAssignments, there are some behavior differences: 1. permission on the assignee will be verified in this API. 2. Hierarchy lookup (project->folder->organization) happens in this API. 3. Parent here is `projects/*/locations/*`, instead of `projects/*/locations/*reservations/*`.
https://cloud.google.com/bigquery

parent <string> Required. The resource name with location (project name could be the wildcard '-'), e.g.: `projects/-/locations/US`.

optional:
query <string> Please specify resource name as assignee in the query. Examples: * `assignee=projects/myproject` * `assignee=folders/123` * `assignee=organizations/456`
pageSize <integer> The maximum number of items to return per page."
  ([parent] (projects-locations-searchAllAssignments parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigqueryreservation.googleapis.com/v1/{+parent}:searchAllAssignments",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-getBiReservation
  "Retrieves a BI reservation.
https://cloud.google.com/bigquery

name <string> Required. Name of the requested reservation, for example: `projects/{project_id}/locations/{location_id}/biReservation`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://bigqueryreservation.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-updateBiReservation
  "Updates a BI reservation. Only fields specified in the `field_mask` are updated. A singleton BI reservation always exists with default size 0. In order to reserve BI capacity it needs to be updated to an amount greater than 0. In order to release BI capacity reservation size must be set to 0.
https://cloud.google.com/bigquery

name <string> The resource name of the singleton BI reservation. Reservation names have the form `projects/{project_id}/locations/{location_id}/biReservation`.
BiReservation:
{:name string,
 :updateTime string,
 :size string,
 :preferredTables
 [{:projectId string, :datasetId string, :tableId string}]}

optional:
updateMask <string> A list of fields to be updated in this request."
  ([name BiReservation]
    (projects-locations-updateBiReservation name BiReservation nil))
  ([name BiReservation optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://bigqueryreservation.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"],
       :body BiReservation})))

(defn projects-locations-reservations-create
  "Creates a new reservation resource.
https://cloud.google.com/bigquery

parent <string> Required. Project, location. E.g., `projects/myproject/locations/US`
Reservation:
{:creationTime string,
 :autoscale {:currentSlots string, :maxSlots string},
 :concurrency string,
 :name string,
 :originalPrimaryLocation string,
 :secondaryLocation string,
 :updateTime string,
 :multiRegionAuxiliary boolean,
 :slotCapacity string,
 :edition [EDITION_UNSPECIFIED STANDARD ENTERPRISE ENTERPRISE_PLUS],
 :ignoreIdleSlots boolean,
 :primaryLocation string}

optional:
reservationId <string> The reservation ID. It must only contain lower case alphanumeric characters or dashes. It must start with a letter and must not end with a dash. Its maximum length is 64 characters."
  ([parent Reservation]
    (projects-locations-reservations-create parent Reservation nil))
  ([parent Reservation optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://bigqueryreservation.googleapis.com/v1/{+parent}/reservations",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"],
       :body Reservation})))

(defn projects-locations-reservations-list
  "Lists all the reservations for the project in the specified location.
https://cloud.google.com/bigquery

parent <string> Required. The parent resource name containing project and location, e.g.: `projects/myproject/locations/US`

optional:
pageSize <integer> The maximum number of items to return per page."
  ([parent] (projects-locations-reservations-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigqueryreservation.googleapis.com/v1/{+parent}/reservations",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-reservations-get
  "Returns information about the reservation.
https://cloud.google.com/bigquery

name <string> Required. Resource name of the reservation to retrieve. E.g., `projects/myproject/locations/US/reservations/team1-prod`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://bigqueryreservation.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-reservations-delete
  "Deletes a reservation. Returns `google.rpc.Code.FAILED_PRECONDITION` when reservation has assignments.
https://cloud.google.com/bigquery

name <string> Required. Resource name of the reservation to retrieve. E.g., `projects/myproject/locations/US/reservations/team1-prod`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://bigqueryreservation.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-reservations-patch
  "Updates an existing reservation resource.
https://cloud.google.com/bigquery

name <string> The resource name of the reservation, e.g., `projects/*/locations/*/reservations/team1-prod`. The reservation_id must only contain lower case alphanumeric characters or dashes. It must start with a letter and must not end with a dash. Its maximum length is 64 characters.
Reservation:
{:creationTime string,
 :autoscale {:currentSlots string, :maxSlots string},
 :concurrency string,
 :name string,
 :originalPrimaryLocation string,
 :secondaryLocation string,
 :updateTime string,
 :multiRegionAuxiliary boolean,
 :slotCapacity string,
 :edition [EDITION_UNSPECIFIED STANDARD ENTERPRISE ENTERPRISE_PLUS],
 :ignoreIdleSlots boolean,
 :primaryLocation string}

optional:
updateMask <string> Standard field mask for the set of fields to be updated."
  ([name Reservation]
    (projects-locations-reservations-patch name Reservation nil))
  ([name Reservation optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://bigqueryreservation.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"],
       :body Reservation})))

(defn projects-locations-reservations-failoverReservation
  "Failover a reservation to the secondary location. The operation should be done in the current secondary location, which will be promoted to the new primary location for the reservation. Attempting to failover a reservation in the current primary location will fail with the error code `google.rpc.Code.FAILED_PRECONDITION`.
https://cloud.google.com/bigquery

name <string> Required. Resource name of the reservation to failover. E.g., `projects/myproject/locations/US/reservations/team1-prod`
FailoverReservationRequest:
object"
  [name FailoverReservationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigqueryreservation.googleapis.com/v1/{+name}:failoverReservation",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body FailoverReservationRequest}))

(defn projects-locations-reservations-assignments-create
  "Creates an assignment object which allows the given project to submit jobs of a certain type using slots from the specified reservation. Currently a resource (project, folder, organization) can only have one assignment per each (job_type, location) combination, and that reservation will be used for all jobs of the matching type. Different assignments can be created on different levels of the projects, folders or organization hierarchy. During query execution, the assignment is looked up at the project, folder and organization levels in that order. The first assignment found is applied to the query. When creating assignments, it does not matter if other assignments exist at higher levels. Example: * The organization `organizationA` contains two projects, `project1` and `project2`. * Assignments for all three entities (`organizationA`, `project1`, and `project2`) could all be created and mapped to the same or different reservations. \"None\" assignments represent an absence of the assignment. Projects assigned to None use on-demand pricing. To create a \"None\" assignment, use \"none\" as a reservation_id in the parent. Example parent: `projects/myproject/locations/US/reservations/none`. Returns `google.rpc.Code.PERMISSION_DENIED` if user does not have 'bigquery.admin' permissions on the project using the reservation and the project that owns this reservation. Returns `google.rpc.Code.INVALID_ARGUMENT` when location of the assignment does not match location of the reservation.
https://cloud.google.com/bigquery

parent <string> Required. The parent resource name of the assignment E.g. `projects/myproject/locations/US/reservations/team1-prod`
Assignment:
{:name string,
 :assignee string,
 :jobType
 [JOB_TYPE_UNSPECIFIED
  PIPELINE
  QUERY
  ML_EXTERNAL
  BACKGROUND
  CONTINUOUS],
 :state [STATE_UNSPECIFIED PENDING ACTIVE]}

optional:
assignmentId <string> The optional assignment ID. Assignment name will be generated automatically if this field is empty. This field must only contain lower case alphanumeric characters or dashes. Max length is 64 characters."
  ([parent Assignment]
    (projects-locations-reservations-assignments-create
      parent
      Assignment
      nil))
  ([parent Assignment optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://bigqueryreservation.googleapis.com/v1/{+parent}/assignments",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"],
       :body Assignment})))

(defn projects-locations-reservations-assignments-list
  "Lists assignments. Only explicitly created assignments will be returned. Example: * Organization `organizationA` contains two projects, `project1` and `project2`. * Reservation `res1` exists and was created previously. * CreateAssignment was used previously to define the following associations between entities and reservations: `` and `` In this example, ListAssignments will just return the above two assignments for reservation `res1`, and no expansion/merge will happen. The wildcard \"-\" can be used for reservations in the request. In that case all assignments belongs to the specified project and location will be listed. **Note** \"-\" cannot be used for projects nor locations.
https://cloud.google.com/bigquery

parent <string> Required. The parent resource name e.g.: `projects/myproject/locations/US/reservations/team1-prod` Or: `projects/myproject/locations/US/reservations/-`

optional:
pageSize <integer> The maximum number of items to return per page."
  ([parent]
    (projects-locations-reservations-assignments-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigqueryreservation.googleapis.com/v1/{+parent}/assignments",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-reservations-assignments-delete
  "Deletes a assignment. No expansion will happen. Example: * Organization `organizationA` contains two projects, `project1` and `project2`. * Reservation `res1` exists and was created previously. * CreateAssignment was used previously to define the following associations between entities and reservations: `` and `` In this example, deletion of the `` assignment won't affect the other assignment ``. After said deletion, queries from `project1` will still use `res1` while queries from `project2` will switch to use on-demand mode.
https://cloud.google.com/bigquery

name <string> Required. Name of the resource, e.g. `projects/myproject/locations/US/reservations/team1-prod/assignments/123`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://bigqueryreservation.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-reservations-assignments-move
  "Moves an assignment under a new reservation. This differs from removing an existing assignment and recreating a new one by providing a transactional change that ensures an assignee always has an associated reservation.
https://cloud.google.com/bigquery

name <string> Required. The resource name of the assignment, e.g. `projects/myproject/locations/US/reservations/team1-prod/assignments/123`
MoveAssignmentRequest:
{:destinationId string, :assignmentId string}"
  [name MoveAssignmentRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigqueryreservation.googleapis.com/v1/{+name}:move",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body MoveAssignmentRequest}))

(defn projects-locations-reservations-assignments-patch
  "Updates an existing assignment. Only the `priority` field can be updated.
https://cloud.google.com/bigquery

name <string> Output only. Name of the resource. E.g.: `projects/myproject/locations/US/reservations/team1-prod/assignments/123`. The assignment_id must only contain lower case alphanumeric characters or dashes and the max length is 64 characters.
Assignment:
{:name string,
 :assignee string,
 :jobType
 [JOB_TYPE_UNSPECIFIED
  PIPELINE
  QUERY
  ML_EXTERNAL
  BACKGROUND
  CONTINUOUS],
 :state [STATE_UNSPECIFIED PENDING ACTIVE]}

optional:
updateMask <string> Standard field mask for the set of fields to be updated."
  ([name Assignment]
    (projects-locations-reservations-assignments-patch
      name
      Assignment
      nil))
  ([name Assignment optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://bigqueryreservation.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"],
       :body Assignment})))

(defn projects-locations-capacityCommitments-create
  "Creates a new capacity commitment resource.
https://cloud.google.com/bigquery

parent <string> Required. Resource name of the parent reservation. E.g., `projects/myproject/locations/US`
CapacityCommitment:
{:commitmentEndTime string,
 :name string,
 :failureStatus {:code integer, :message string, :details [object]},
 :commitmentStartTime string,
 :state [STATE_UNSPECIFIED PENDING ACTIVE FAILED],
 :renewalPlan
 [COMMITMENT_PLAN_UNSPECIFIED
  FLEX
  FLEX_FLAT_RATE
  TRIAL
  MONTHLY
  MONTHLY_FLAT_RATE
  ANNUAL
  ANNUAL_FLAT_RATE
  THREE_YEAR
  NONE],
 :isFlatRate boolean,
 :multiRegionAuxiliary boolean,
 :edition [EDITION_UNSPECIFIED STANDARD ENTERPRISE ENTERPRISE_PLUS],
 :slotCount string,
 :plan
 [COMMITMENT_PLAN_UNSPECIFIED
  FLEX
  FLEX_FLAT_RATE
  TRIAL
  MONTHLY
  MONTHLY_FLAT_RATE
  ANNUAL
  ANNUAL_FLAT_RATE
  THREE_YEAR
  NONE]}

optional:
enforceSingleAdminProjectPerOrg <boolean> If true, fail the request if another project in the organization has a capacity commitment.
capacityCommitmentId <string> The optional capacity commitment ID. Capacity commitment name will be generated automatically if this field is empty. This field must only contain lower case alphanumeric characters or dashes. The first and last character cannot be a dash. Max length is 64 characters. NOTE: this ID won't be kept if the capacity commitment is split or merged."
  ([parent CapacityCommitment]
    (projects-locations-capacityCommitments-create
      parent
      CapacityCommitment
      nil))
  ([parent CapacityCommitment optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://bigqueryreservation.googleapis.com/v1/{+parent}/capacityCommitments",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"],
       :body CapacityCommitment})))

(defn projects-locations-capacityCommitments-list
  "Lists all the capacity commitments for the admin project.
https://cloud.google.com/bigquery

parent <string> Required. Resource name of the parent reservation. E.g., `projects/myproject/locations/US`

optional:
pageSize <integer> The maximum number of items to return."
  ([parent] (projects-locations-capacityCommitments-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigqueryreservation.googleapis.com/v1/{+parent}/capacityCommitments",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-capacityCommitments-get
  "Returns information about the capacity commitment.
https://cloud.google.com/bigquery

name <string> Required. Resource name of the capacity commitment to retrieve. E.g., `projects/myproject/locations/US/capacityCommitments/123`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://bigqueryreservation.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-capacityCommitments-delete
  "Deletes a capacity commitment. Attempting to delete capacity commitment before its commitment_end_time will fail with the error code `google.rpc.Code.FAILED_PRECONDITION`.
https://cloud.google.com/bigquery

name <string> Required. Resource name of the capacity commitment to delete. E.g., `projects/myproject/locations/US/capacityCommitments/123`

optional:
force <boolean> Can be used to force delete commitments even if assignments exist. Deleting commitments with assignments may cause queries to fail if they no longer have access to slots."
  ([name] (projects-locations-capacityCommitments-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://bigqueryreservation.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-capacityCommitments-patch
  "Updates an existing capacity commitment. Only `plan` and `renewal_plan` fields can be updated. Plan can only be changed to a plan of a longer commitment period. Attempting to change to a plan with shorter commitment period will fail with the error code `google.rpc.Code.FAILED_PRECONDITION`.
https://cloud.google.com/bigquery

name <string> Output only. The resource name of the capacity commitment, e.g., `projects/myproject/locations/US/capacityCommitments/123` The commitment_id must only contain lower case alphanumeric characters or dashes. It must start with a letter and must not end with a dash. Its maximum length is 64 characters.
CapacityCommitment:
{:commitmentEndTime string,
 :name string,
 :failureStatus {:code integer, :message string, :details [object]},
 :commitmentStartTime string,
 :state [STATE_UNSPECIFIED PENDING ACTIVE FAILED],
 :renewalPlan
 [COMMITMENT_PLAN_UNSPECIFIED
  FLEX
  FLEX_FLAT_RATE
  TRIAL
  MONTHLY
  MONTHLY_FLAT_RATE
  ANNUAL
  ANNUAL_FLAT_RATE
  THREE_YEAR
  NONE],
 :isFlatRate boolean,
 :multiRegionAuxiliary boolean,
 :edition [EDITION_UNSPECIFIED STANDARD ENTERPRISE ENTERPRISE_PLUS],
 :slotCount string,
 :plan
 [COMMITMENT_PLAN_UNSPECIFIED
  FLEX
  FLEX_FLAT_RATE
  TRIAL
  MONTHLY
  MONTHLY_FLAT_RATE
  ANNUAL
  ANNUAL_FLAT_RATE
  THREE_YEAR
  NONE]}

optional:
updateMask <string> Standard field mask for the set of fields to be updated."
  ([name CapacityCommitment]
    (projects-locations-capacityCommitments-patch
      name
      CapacityCommitment
      nil))
  ([name CapacityCommitment optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://bigqueryreservation.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"],
       :body CapacityCommitment})))

(defn projects-locations-capacityCommitments-split
  "Splits capacity commitment to two commitments of the same plan and `commitment_end_time`. A common use case is to enable downgrading commitments. For example, in order to downgrade from 10000 slots to 8000, you might split a 10000 capacity commitment into commitments of 2000 and 8000. Then, you delete the first one after the commitment end time passes.
https://cloud.google.com/bigquery

name <string> Required. The resource name e.g.,: `projects/myproject/locations/US/capacityCommitments/123`
SplitCapacityCommitmentRequest:
{:slotCount string}"
  [name SplitCapacityCommitmentRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigqueryreservation.googleapis.com/v1/{+name}:split",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body SplitCapacityCommitmentRequest}))

(defn projects-locations-capacityCommitments-merge
  "Merges capacity commitments of the same plan into a single commitment. The resulting capacity commitment has the greater commitment_end_time out of the to-be-merged capacity commitments. Attempting to merge capacity commitments of different plan will fail with the error code `google.rpc.Code.FAILED_PRECONDITION`.
https://cloud.google.com/bigquery

parent <string> Parent resource that identifies admin project and location e.g., `projects/myproject/locations/us`
MergeCapacityCommitmentsRequest:
{:capacityCommitmentIds [string]}"
  [parent MergeCapacityCommitmentsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigqueryreservation.googleapis.com/v1/{+parent}/capacityCommitments:merge",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body MergeCapacityCommitmentsRequest}))

(ns happygapi2.pubsublite
  "Pub/Sub Lite API

See: https://cloud.google.com/pubsub/lite/docs"
  (:require [happy.oauth2.client :as client]))

(defn admin-projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/pubsub/lite/docs/reference/rest/v1/admin.projects.locations.operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (admin-projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://pubsublite.googleapis.com/v1/admin/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn admin-projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/pubsub/lite/docs/reference/rest/v1/admin.projects.locations.operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://pubsublite.googleapis.com/v1/admin/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn admin-projects-locations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/pubsub/lite/docs/reference/rest/v1/admin.projects.locations.operations/delete

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://pubsublite.googleapis.com/v1/admin/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn admin-projects-locations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/pubsub/lite/docs/reference/rest/v1/admin.projects.locations.operations/cancel

name <string> The name of the operation resource to be cancelled.
CancelOperationRequest:
object"
  [name CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://pubsublite.googleapis.com/v1/admin/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelOperationRequest}))

(defn admin-projects-locations-topics-create
  "Creates a new topic.
https://cloud.google.com/pubsub/lite/docs/reference/rest/v1/admin.projects.locations.topics/create

parent <string> Required. The parent location in which to create the topic. Structured like `projects/{project_number}/locations/{location}`.
Topic:
{:name string,
 :partitionConfig
 {:count string,
  :scale integer,
  :capacity {:publishMibPerSec integer, :subscribeMibPerSec integer}},
 :retentionConfig {:perPartitionBytes string, :period string},
 :reservationConfig {:throughputReservation string}}

optional:
topicId <string> Required. The ID to use for the topic, which will become the final component of the topic's name. This value is structured like: `my-topic-name`."
  ([parent Topic]
    (admin-projects-locations-topics-create parent Topic nil))
  ([parent Topic optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://pubsublite.googleapis.com/v1/admin/{+parent}/topics",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Topic})))

(defn admin-projects-locations-topics-get
  "Returns the topic configuration.
https://cloud.google.com/pubsub/lite/docs/reference/rest/v1/admin.projects.locations.topics/get

name <string> Required. The name of the topic whose configuration to return."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://pubsublite.googleapis.com/v1/admin/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn admin-projects-locations-topics-getPartitions
  "Returns the partition information for the requested topic.
https://cloud.google.com/pubsub/lite/docs/reference/rest/v1/admin.projects.locations.topics/getPartitions

name <string> Required. The topic whose partition information to return."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://pubsublite.googleapis.com/v1/admin/{+name}/partitions",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn admin-projects-locations-topics-list
  "Returns the list of topics for the given project.
https://cloud.google.com/pubsub/lite/docs/reference/rest/v1/admin.projects.locations.topics/list

parent <string> Required. The parent whose topics are to be listed. Structured like `projects/{project_number}/locations/{location}`.

optional:
pageSize <integer> The maximum number of topics to return. The service may return fewer than this value. If unset or zero, all topics for the parent will be returned."
  ([parent] (admin-projects-locations-topics-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://pubsublite.googleapis.com/v1/admin/{+parent}/topics",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn admin-projects-locations-topics-patch
  "Updates properties of the specified topic.
https://cloud.google.com/pubsub/lite/docs/reference/rest/v1/admin.projects.locations.topics/patch

name <string> The name of the topic. Structured like: projects/{project_number}/locations/{location}/topics/{topic_id}
Topic:
{:name string,
 :partitionConfig
 {:count string,
  :scale integer,
  :capacity {:publishMibPerSec integer, :subscribeMibPerSec integer}},
 :retentionConfig {:perPartitionBytes string, :period string},
 :reservationConfig {:throughputReservation string}}

optional:
updateMask <string> Required. A mask specifying the topic fields to change."
  ([name Topic] (admin-projects-locations-topics-patch name Topic nil))
  ([name Topic optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://pubsublite.googleapis.com/v1/admin/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Topic})))

(defn admin-projects-locations-topics-delete
  "Deletes the specified topic.
https://cloud.google.com/pubsub/lite/docs/reference/rest/v1/admin.projects.locations.topics/delete

name <string> Required. The name of the topic to delete."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://pubsublite.googleapis.com/v1/admin/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn admin-projects-locations-topics-subscriptions-list
  "Lists the subscriptions attached to the specified topic.
https://cloud.google.com/pubsub/lite/docs/reference/rest/v1/admin.projects.locations.topics.subscriptions/list

name <string> Required. The name of the topic whose subscriptions to list.

optional:
pageSize <integer> The maximum number of subscriptions to return. The service may return fewer than this value. If unset or zero, all subscriptions for the given topic will be returned."
  ([name]
    (admin-projects-locations-topics-subscriptions-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://pubsublite.googleapis.com/v1/admin/{+name}/subscriptions",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn admin-projects-locations-subscriptions-create
  "Creates a new subscription.
https://cloud.google.com/pubsub/lite/docs/reference/rest/v1/admin.projects.locations.subscriptions/create

parent <string> Required. The parent location in which to create the subscription. Structured like `projects/{project_number}/locations/{location}`.
Subscription:
{:name string,
 :topic string,
 :deliveryConfig
 {:deliveryRequirement
  [DELIVERY_REQUIREMENT_UNSPECIFIED
   DELIVER_IMMEDIATELY
   DELIVER_AFTER_STORED]},
 :exportConfig
 {:desiredState
  [STATE_UNSPECIFIED ACTIVE PAUSED PERMISSION_DENIED NOT_FOUND],
  :currentState
  [STATE_UNSPECIFIED ACTIVE PAUSED PERMISSION_DENIED NOT_FOUND],
  :deadLetterTopic string,
  :pubsubConfig {:topic string}}}

optional:
subscriptionId <string> Required. The ID to use for the subscription, which will become the final component of the subscription's name. This value is structured like: `my-sub-name`.
skipBacklog <boolean> If true, the newly created subscription will only receive messages published after the subscription was created. Otherwise, the entire message backlog will be received on the subscription. Defaults to false."
  ([parent Subscription]
    (admin-projects-locations-subscriptions-create
      parent
      Subscription
      nil))
  ([parent Subscription optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://pubsublite.googleapis.com/v1/admin/{+parent}/subscriptions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Subscription})))

(defn admin-projects-locations-subscriptions-get
  "Returns the subscription configuration.
https://cloud.google.com/pubsub/lite/docs/reference/rest/v1/admin.projects.locations.subscriptions/get

name <string> Required. The name of the subscription whose configuration to return."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://pubsublite.googleapis.com/v1/admin/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn admin-projects-locations-subscriptions-list
  "Returns the list of subscriptions for the given project.
https://cloud.google.com/pubsub/lite/docs/reference/rest/v1/admin.projects.locations.subscriptions/list

parent <string> Required. The parent whose subscriptions are to be listed. Structured like `projects/{project_number}/locations/{location}`.

optional:
pageSize <integer> The maximum number of subscriptions to return. The service may return fewer than this value. If unset or zero, all subscriptions for the parent will be returned."
  ([parent] (admin-projects-locations-subscriptions-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://pubsublite.googleapis.com/v1/admin/{+parent}/subscriptions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn admin-projects-locations-subscriptions-patch
  "Updates properties of the specified subscription.
https://cloud.google.com/pubsub/lite/docs/reference/rest/v1/admin.projects.locations.subscriptions/patch

name <string> The name of the subscription. Structured like: projects/{project_number}/locations/{location}/subscriptions/{subscription_id}
Subscription:
{:name string,
 :topic string,
 :deliveryConfig
 {:deliveryRequirement
  [DELIVERY_REQUIREMENT_UNSPECIFIED
   DELIVER_IMMEDIATELY
   DELIVER_AFTER_STORED]},
 :exportConfig
 {:desiredState
  [STATE_UNSPECIFIED ACTIVE PAUSED PERMISSION_DENIED NOT_FOUND],
  :currentState
  [STATE_UNSPECIFIED ACTIVE PAUSED PERMISSION_DENIED NOT_FOUND],
  :deadLetterTopic string,
  :pubsubConfig {:topic string}}}

optional:
updateMask <string> Required. A mask specifying the subscription fields to change."
  ([name Subscription]
    (admin-projects-locations-subscriptions-patch
      name
      Subscription
      nil))
  ([name Subscription optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://pubsublite.googleapis.com/v1/admin/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Subscription})))

(defn admin-projects-locations-subscriptions-delete
  "Deletes the specified subscription.
https://cloud.google.com/pubsub/lite/docs/reference/rest/v1/admin.projects.locations.subscriptions/delete

name <string> Required. The name of the subscription to delete."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://pubsublite.googleapis.com/v1/admin/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn admin-projects-locations-subscriptions-seek
  "Performs an out-of-band seek for a subscription to a specified target, which may be timestamps or named positions within the message backlog. Seek translates these targets to cursors for each partition and orchestrates subscribers to start consuming messages from these seek cursors. If an operation is returned, the seek has been registered and subscribers will eventually receive messages from the seek cursors (i.e. eventual consistency), as long as they are using a minimum supported client library version and not a system that tracks cursors independently of Pub/Sub Lite (e.g. Apache Beam, Dataflow, Spark). The seek operation will fail for unsupported clients. If clients would like to know when subscribers react to the seek (or not), they can poll the operation. The seek operation will succeed and complete once subscribers are ready to receive messages from the seek cursors for all partitions of the topic. This means that the seek operation will not complete until all subscribers come online. If the previous seek operation has not yet completed, it will be aborted and the new invocation of seek will supersede it.
https://cloud.google.com/pubsub/lite/docs/reference/rest/v1/admin.projects.locations.subscriptions/seek

name <string> Required. The name of the subscription to seek.
SeekSubscriptionRequest:
{:namedTarget [NAMED_TARGET_UNSPECIFIED TAIL HEAD],
 :timeTarget {:publishTime string, :eventTime string}}"
  [name SeekSubscriptionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://pubsublite.googleapis.com/v1/admin/{+name}:seek",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SeekSubscriptionRequest}))

(defn admin-projects-locations-reservations-create
  "Creates a new reservation.
https://cloud.google.com/pubsub/lite/docs/reference/rest/v1/admin.projects.locations.reservations/create

parent <string> Required. The parent location in which to create the reservation. Structured like `projects/{project_number}/locations/{location}`.
Reservation:
{:name string, :throughputCapacity string}

optional:
reservationId <string> Required. The ID to use for the reservation, which will become the final component of the reservation's name. This value is structured like: `my-reservation-name`."
  ([parent Reservation]
    (admin-projects-locations-reservations-create
      parent
      Reservation
      nil))
  ([parent Reservation optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://pubsublite.googleapis.com/v1/admin/{+parent}/reservations",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Reservation})))

(defn admin-projects-locations-reservations-get
  "Returns the reservation configuration.
https://cloud.google.com/pubsub/lite/docs/reference/rest/v1/admin.projects.locations.reservations/get

name <string> Required. The name of the reservation whose configuration to return. Structured like: projects/{project_number}/locations/{location}/reservations/{reservation_id}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://pubsublite.googleapis.com/v1/admin/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn admin-projects-locations-reservations-list
  "Returns the list of reservations for the given project.
https://cloud.google.com/pubsub/lite/docs/reference/rest/v1/admin.projects.locations.reservations/list

parent <string> Required. The parent whose reservations are to be listed. Structured like `projects/{project_number}/locations/{location}`.

optional:
pageSize <integer> The maximum number of reservations to return. The service may return fewer than this value. If unset or zero, all reservations for the parent will be returned."
  ([parent] (admin-projects-locations-reservations-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://pubsublite.googleapis.com/v1/admin/{+parent}/reservations",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn admin-projects-locations-reservations-patch
  "Updates properties of the specified reservation.
https://cloud.google.com/pubsub/lite/docs/reference/rest/v1/admin.projects.locations.reservations/patch

name <string> The name of the reservation. Structured like: projects/{project_number}/locations/{location}/reservations/{reservation_id}
Reservation:
{:name string, :throughputCapacity string}

optional:
updateMask <string> Required. A mask specifying the reservation fields to change."
  ([name Reservation]
    (admin-projects-locations-reservations-patch name Reservation nil))
  ([name Reservation optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://pubsublite.googleapis.com/v1/admin/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Reservation})))

(defn admin-projects-locations-reservations-delete
  "Deletes the specified reservation.
https://cloud.google.com/pubsub/lite/docs/reference/rest/v1/admin.projects.locations.reservations/delete

name <string> Required. The name of the reservation to delete. Structured like: projects/{project_number}/locations/{location}/reservations/{reservation_id}"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://pubsublite.googleapis.com/v1/admin/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn admin-projects-locations-reservations-topics-list
  "Lists the topics attached to the specified reservation.
https://cloud.google.com/pubsub/lite/docs/reference/rest/v1/admin.projects.locations.reservations.topics/list

name <string> Required. The name of the reservation whose topics to list. Structured like: projects/{project_number}/locations/{location}/reservations/{reservation_id}

optional:
pageSize <integer> The maximum number of topics to return. The service may return fewer than this value. If unset or zero, all topics for the given reservation will be returned."
  ([name] (admin-projects-locations-reservations-topics-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://pubsublite.googleapis.com/v1/admin/{+name}/topics",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn cursor-projects-locations-subscriptions-commitCursor
  "Updates the committed cursor.
https://cloud.google.com/pubsub/lite/docs/reference/rest/v1/cursor.projects.locations.subscriptions/commitCursor

subscription <string> The subscription for which to update the cursor.
CommitCursorRequest:
{:partition string, :cursor {:offset string}}"
  [subscription CommitCursorRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://pubsublite.googleapis.com/v1/cursor/{+subscription}:commitCursor",
     :uri-template-args {:subscription subscription},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CommitCursorRequest}))

(defn cursor-projects-locations-subscriptions-cursors-list
  "Returns all committed cursor information for a subscription.
https://cloud.google.com/pubsub/lite/docs/reference/rest/v1/cursor.projects.locations.subscriptions.cursors/list

parent <string> Required. The subscription for which to retrieve cursors. Structured like `projects/{project_number}/locations/{location}/subscriptions/{subscription_id}`.

optional:
pageSize <integer> The maximum number of cursors to return. The service may return fewer than this value. If unset or zero, all cursors for the parent will be returned."
  ([parent]
    (cursor-projects-locations-subscriptions-cursors-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://pubsublite.googleapis.com/v1/cursor/{+parent}/cursors",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn topicStats-projects-locations-topics-computeMessageStats
  "Compute statistics about a range of messages in a given topic and partition.
https://cloud.google.com/pubsub/lite/docs/reference/rest/v1/topicStats.projects.locations.topics/computeMessageStats

topic <string> Required. The topic for which we should compute message stats.
ComputeMessageStatsRequest:
{:partition string,
 :startCursor {:offset string},
 :endCursor {:offset string}}"
  [topic ComputeMessageStatsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://pubsublite.googleapis.com/v1/topicStats/{+topic}:computeMessageStats",
     :uri-template-args {:topic topic},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ComputeMessageStatsRequest}))

(defn topicStats-projects-locations-topics-computeHeadCursor
  "Compute the head cursor for the partition. The head cursor's offset is guaranteed to be less than or equal to all messages which have not yet been acknowledged as published, and greater than the offset of any message whose publish has already been acknowledged. It is zero if there have never been messages in the partition.
https://cloud.google.com/pubsub/lite/docs/reference/rest/v1/topicStats.projects.locations.topics/computeHeadCursor

topic <string> Required. The topic for which we should compute the head cursor.
ComputeHeadCursorRequest:
{:partition string}"
  [topic ComputeHeadCursorRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://pubsublite.googleapis.com/v1/topicStats/{+topic}:computeHeadCursor",
     :uri-template-args {:topic topic},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ComputeHeadCursorRequest}))

(defn topicStats-projects-locations-topics-computeTimeCursor
  "Compute the corresponding cursor for a publish or event time in a topic partition.
https://cloud.google.com/pubsub/lite/docs/reference/rest/v1/topicStats.projects.locations.topics/computeTimeCursor

topic <string> Required. The topic for which we should compute the cursor.
ComputeTimeCursorRequest:
{:partition string, :target {:publishTime string, :eventTime string}}"
  [topic ComputeTimeCursorRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://pubsublite.googleapis.com/v1/topicStats/{+topic}:computeTimeCursor",
     :uri-template-args {:topic topic},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ComputeTimeCursorRequest}))

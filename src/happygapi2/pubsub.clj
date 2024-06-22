(ns happygapi2.pubsub
  "Cloud Pub/Sub API
Provides reliable, many-to-many, asynchronous messaging between applications. 
See: https://cloud.google.com/pubsub/docs"
  (:require [happy.oauth2.client :as client]))

(defn projects-topics-get
  "Gets the configuration of a topic.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.topics/get

topic <string> Required. The name of the topic to get. Format is `projects/{project}/topics/{topic}`."
  [topic]
  (client/api-request
    {:method "GET",
     :uri-template "https://pubsub.googleapis.com/v1/{+topic}",
     :uri-template-args {:topic topic},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/pubsub"]}))

(defn projects-topics-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.topics/setIamPolicy

resource <string> REQUIRED: The resource for which the policy is being specified. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
SetIamPolicyRequest:
{:policy
 {:version integer,
  :bindings
  [{:role string,
    :members [string],
    :condition
    {:expression string,
     :title string,
     :description string,
     :location string}}],
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://pubsub.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/pubsub"],
     :body SetIamPolicyRequest}))

(defn projects-topics-patch
  "Updates an existing topic by updating the fields specified in the update mask. Note that certain properties of a topic are not modifiable.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.topics/patch

name <string> Required. The name of the topic. It must have the format `\"projects/{project}/topics/{topic}\"`. `{topic}` must start with a letter, and contain only letters (`[A-Za-z]`), numbers (`[0-9]`), dashes (`-`), underscores (`_`), periods (`.`), tildes (`~`), plus (`+`) or percent signs (`%`). It must be between 3 and 255 characters in length, and it must not start with `\"goog\"`.
UpdateTopicRequest:
{:topic
 {:labels object,
  :name string,
  :messageStoragePolicy
  {:allowedPersistenceRegions [string], :enforceInTransit boolean},
  :messageRetentionDuration string,
  :state [STATE_UNSPECIFIED ACTIVE INGESTION_RESOURCE_ERROR],
  :satisfiesPzs boolean,
  :kmsKeyName string,
  :schemaSettings
  {:schema string,
   :encoding [ENCODING_UNSPECIFIED JSON BINARY],
   :firstRevisionId string,
   :lastRevisionId string},
  :ingestionDataSourceSettings
  {:awsKinesis
   {:state
    [STATE_UNSPECIFIED
     ACTIVE
     KINESIS_PERMISSION_DENIED
     PUBLISH_PERMISSION_DENIED
     STREAM_NOT_FOUND
     CONSUMER_NOT_FOUND],
    :streamArn string,
    :consumerArn string,
    :awsRoleArn string,
    :gcpServiceAccount string}}},
 :updateMask string}"
  [name UpdateTopicRequest]
  (client/api-request
    {:method "PATCH",
     :uri-template "https://pubsub.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/pubsub"],
     :body UpdateTopicRequest}))

(defn projects-topics-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.topics/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://pubsub.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/pubsub"],
     :body TestIamPermissionsRequest}))

(defn projects-topics-create
  "Creates the given topic with the given name. See the [resource name rules] (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names).
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.topics/create

name <string> Required. The name of the topic. It must have the format `\"projects/{project}/topics/{topic}\"`. `{topic}` must start with a letter, and contain only letters (`[A-Za-z]`), numbers (`[0-9]`), dashes (`-`), underscores (`_`), periods (`.`), tildes (`~`), plus (`+`) or percent signs (`%`). It must be between 3 and 255 characters in length, and it must not start with `\"goog\"`.
Topic:
{:labels object,
 :name string,
 :messageStoragePolicy
 {:allowedPersistenceRegions [string], :enforceInTransit boolean},
 :messageRetentionDuration string,
 :state [STATE_UNSPECIFIED ACTIVE INGESTION_RESOURCE_ERROR],
 :satisfiesPzs boolean,
 :kmsKeyName string,
 :schemaSettings
 {:schema string,
  :encoding [ENCODING_UNSPECIFIED JSON BINARY],
  :firstRevisionId string,
  :lastRevisionId string},
 :ingestionDataSourceSettings
 {:awsKinesis
  {:state
   [STATE_UNSPECIFIED
    ACTIVE
    KINESIS_PERMISSION_DENIED
    PUBLISH_PERMISSION_DENIED
    STREAM_NOT_FOUND
    CONSUMER_NOT_FOUND],
   :streamArn string,
   :consumerArn string,
   :awsRoleArn string,
   :gcpServiceAccount string}}}"
  [name Topic]
  (client/api-request
    {:method "PUT",
     :uri-template "https://pubsub.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/pubsub"],
     :body Topic}))

(defn projects-topics-delete
  "Deletes the topic with the given name. Returns `NOT_FOUND` if the topic does not exist. After a topic is deleted, a new topic may be created with the same name; this is an entirely new topic with none of the old configuration or subscriptions. Existing subscriptions to this topic are not deleted, but their `topic` field is set to `_deleted-topic_`.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.topics/delete

topic <string> Required. Name of the topic to delete. Format is `projects/{project}/topics/{topic}`."
  [topic]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://pubsub.googleapis.com/v1/{+topic}",
     :uri-template-args {:topic topic},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/pubsub"]}))

(defn projects-topics-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.topics/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource] (projects-topics-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://pubsub.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/pubsub"]})))

(defn projects-topics-list
  "Lists matching topics.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.topics/list

project <string> Required. The name of the project in which to list topics. Format is `projects/{project-id}`.

optional:
pageSize <integer> Optional. Maximum number of topics to return."
  ([project] (projects-topics-list project nil))
  ([project optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://pubsub.googleapis.com/v1/{+project}/topics",
       :uri-template-args {:project project},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/pubsub"]})))

(defn projects-topics-publish
  "Adds one or more messages to the topic. Returns `NOT_FOUND` if the topic does not exist.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.topics/publish

topic <string> Required. The messages in the request will be published on this topic. Format is `projects/{project}/topics/{topic}`.
PublishRequest:
{:messages
 [{:data string,
   :attributes object,
   :messageId string,
   :publishTime string,
   :orderingKey string}]}"
  [topic PublishRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://pubsub.googleapis.com/v1/{+topic}:publish",
     :uri-template-args {:topic topic},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/pubsub"],
     :body PublishRequest}))

(defn projects-topics-subscriptions-list
  "Lists the names of the attached subscriptions on this topic.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.topics.subscriptions/list

topic <string> Required. The name of the topic that subscriptions are attached to. Format is `projects/{project}/topics/{topic}`.

optional:
pageSize <integer> Optional. Maximum number of subscription names to return."
  ([topic] (projects-topics-subscriptions-list topic nil))
  ([topic optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://pubsub.googleapis.com/v1/{+topic}/subscriptions",
       :uri-template-args {:topic topic},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/pubsub"]})))

(defn projects-topics-snapshots-list
  "Lists the names of the snapshots on this topic. Snapshots are used in [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to manage message acknowledgments in bulk. That is, you can set the acknowledgment state of messages in an existing subscription to the state captured by a snapshot.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.topics.snapshots/list

topic <string> Required. The name of the topic that snapshots are attached to. Format is `projects/{project}/topics/{topic}`.

optional:
pageSize <integer> Optional. Maximum number of snapshot names to return."
  ([topic] (projects-topics-snapshots-list topic nil))
  ([topic optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://pubsub.googleapis.com/v1/{+topic}/snapshots",
       :uri-template-args {:topic topic},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/pubsub"]})))

(defn projects-subscriptions-get
  "Gets the configuration details of a subscription.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.subscriptions/get

subscription <string> Required. The name of the subscription to get. Format is `projects/{project}/subscriptions/{sub}`."
  [subscription]
  (client/api-request
    {:method "GET",
     :uri-template "https://pubsub.googleapis.com/v1/{+subscription}",
     :uri-template-args {:subscription subscription},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/pubsub"]}))

(defn projects-subscriptions-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.subscriptions/setIamPolicy

resource <string> REQUIRED: The resource for which the policy is being specified. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
SetIamPolicyRequest:
{:policy
 {:version integer,
  :bindings
  [{:role string,
    :members [string],
    :condition
    {:expression string,
     :title string,
     :description string,
     :location string}}],
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://pubsub.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/pubsub"],
     :body SetIamPolicyRequest}))

(defn projects-subscriptions-detach
  "Detaches a subscription from this topic. All messages retained in the subscription are dropped. Subsequent `Pull` and `StreamingPull` requests will return FAILED_PRECONDITION. If the subscription is a push subscription, pushes to the endpoint will stop.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.subscriptions/detach

subscription <string> Required. The subscription to detach. Format is `projects/{project}/subscriptions/{subscription}`."
  [subscription]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://pubsub.googleapis.com/v1/{+subscription}:detach",
     :uri-template-args {:subscription subscription},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/pubsub"]}))

(defn projects-subscriptions-acknowledge
  "Acknowledges the messages associated with the `ack_ids` in the `AcknowledgeRequest`. The Pub/Sub system can remove the relevant messages from the subscription. Acknowledging a message whose ack deadline has expired may succeed, but such a message may be redelivered later. Acknowledging a message more than once will not result in an error.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.subscriptions/acknowledge

subscription <string> Required. The subscription whose message is being acknowledged. Format is `projects/{project}/subscriptions/{sub}`.
AcknowledgeRequest:
{:ackIds [string]}"
  [subscription AcknowledgeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://pubsub.googleapis.com/v1/{+subscription}:acknowledge",
     :uri-template-args {:subscription subscription},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/pubsub"],
     :body AcknowledgeRequest}))

(defn projects-subscriptions-patch
  "Updates an existing subscription by updating the fields specified in the update mask. Note that certain properties of a subscription, such as its topic, are not modifiable.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.subscriptions/patch

name <string> Required. The name of the subscription. It must have the format `\"projects/{project}/subscriptions/{subscription}\"`. `{subscription}` must start with a letter, and contain only letters (`[A-Za-z]`), numbers (`[0-9]`), dashes (`-`), underscores (`_`), periods (`.`), tildes (`~`), plus (`+`) or percent signs (`%`). It must be between 3 and 255 characters in length, and it must not start with `\"goog\"`.
UpdateSubscriptionRequest:
{:subscription
 {:expirationPolicy {:ttl string},
  :labels object,
  :name string,
  :retryPolicy {:minimumBackoff string, :maximumBackoff string},
  :messageRetentionDuration string,
  :detached boolean,
  :topic string,
  :state [STATE_UNSPECIFIED ACTIVE RESOURCE_ERROR],
  :deadLetterPolicy
  {:deadLetterTopic string, :maxDeliveryAttempts integer},
  :cloudStorageConfig
  {:maxDuration string,
   :filenameSuffix string,
   :filenameDatetimeFormat string,
   :maxBytes string,
   :state
   [STATE_UNSPECIFIED
    ACTIVE
    PERMISSION_DENIED
    NOT_FOUND
    IN_TRANSIT_LOCATION_RESTRICTION
    SCHEMA_MISMATCH],
   :serviceAccountEmail string,
   :avroConfig {:writeMetadata boolean, :useTopicSchema boolean},
   :textConfig object,
   :bucket string,
   :filenamePrefix string},
  :retainAckedMessages boolean,
  :filter string,
  :enableMessageOrdering boolean,
  :topicMessageRetentionDuration string,
  :pushConfig
  {:pushEndpoint string,
   :attributes object,
   :oidcToken {:serviceAccountEmail string, :audience string},
   :pubsubWrapper object,
   :noWrapper {:writeMetadata boolean}},
  :ackDeadlineSeconds integer,
  :bigqueryConfig
  {:table string,
   :useTopicSchema boolean,
   :writeMetadata boolean,
   :dropUnknownFields boolean,
   :state
   [STATE_UNSPECIFIED
    ACTIVE
    PERMISSION_DENIED
    NOT_FOUND
    SCHEMA_MISMATCH
    IN_TRANSIT_LOCATION_RESTRICTION],
   :useTableSchema boolean,
   :serviceAccountEmail string},
  :enableExactlyOnceDelivery boolean},
 :updateMask string}"
  [name UpdateSubscriptionRequest]
  (client/api-request
    {:method "PATCH",
     :uri-template "https://pubsub.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/pubsub"],
     :body UpdateSubscriptionRequest}))

(defn projects-subscriptions-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.subscriptions/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://pubsub.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/pubsub"],
     :body TestIamPermissionsRequest}))

(defn projects-subscriptions-create
  "Creates a subscription to a given topic. See the [resource name rules] (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names). If the subscription already exists, returns `ALREADY_EXISTS`. If the corresponding topic doesn't exist, returns `NOT_FOUND`. If the name is not provided in the request, the server will assign a random name for this subscription on the same project as the topic, conforming to the [resource name format] (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names). The generated name is populated in the returned Subscription object. Note that for REST API requests, you must specify a name in the request.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.subscriptions/create

name <string> Required. The name of the subscription. It must have the format `\"projects/{project}/subscriptions/{subscription}\"`. `{subscription}` must start with a letter, and contain only letters (`[A-Za-z]`), numbers (`[0-9]`), dashes (`-`), underscores (`_`), periods (`.`), tildes (`~`), plus (`+`) or percent signs (`%`). It must be between 3 and 255 characters in length, and it must not start with `\"goog\"`.
Subscription:
{:expirationPolicy {:ttl string},
 :labels object,
 :name string,
 :retryPolicy {:minimumBackoff string, :maximumBackoff string},
 :messageRetentionDuration string,
 :detached boolean,
 :topic string,
 :state [STATE_UNSPECIFIED ACTIVE RESOURCE_ERROR],
 :deadLetterPolicy
 {:deadLetterTopic string, :maxDeliveryAttempts integer},
 :cloudStorageConfig
 {:maxDuration string,
  :filenameSuffix string,
  :filenameDatetimeFormat string,
  :maxBytes string,
  :state
  [STATE_UNSPECIFIED
   ACTIVE
   PERMISSION_DENIED
   NOT_FOUND
   IN_TRANSIT_LOCATION_RESTRICTION
   SCHEMA_MISMATCH],
  :serviceAccountEmail string,
  :avroConfig {:writeMetadata boolean, :useTopicSchema boolean},
  :textConfig object,
  :bucket string,
  :filenamePrefix string},
 :retainAckedMessages boolean,
 :filter string,
 :enableMessageOrdering boolean,
 :topicMessageRetentionDuration string,
 :pushConfig
 {:pushEndpoint string,
  :attributes object,
  :oidcToken {:serviceAccountEmail string, :audience string},
  :pubsubWrapper object,
  :noWrapper {:writeMetadata boolean}},
 :ackDeadlineSeconds integer,
 :bigqueryConfig
 {:table string,
  :useTopicSchema boolean,
  :writeMetadata boolean,
  :dropUnknownFields boolean,
  :state
  [STATE_UNSPECIFIED
   ACTIVE
   PERMISSION_DENIED
   NOT_FOUND
   SCHEMA_MISMATCH
   IN_TRANSIT_LOCATION_RESTRICTION],
  :useTableSchema boolean,
  :serviceAccountEmail string},
 :enableExactlyOnceDelivery boolean}"
  [name Subscription]
  (client/api-request
    {:method "PUT",
     :uri-template "https://pubsub.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/pubsub"],
     :body Subscription}))

(defn projects-subscriptions-modifyAckDeadline
  "Modifies the ack deadline for a specific message. This method is useful to indicate that more time is needed to process a message by the subscriber, or to make the message available for redelivery if the processing was interrupted. Note that this does not modify the subscription-level `ackDeadlineSeconds` used for subsequent messages.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.subscriptions/modifyAckDeadline

subscription <string> Required. The name of the subscription. Format is `projects/{project}/subscriptions/{sub}`.
ModifyAckDeadlineRequest:
{:ackIds [string], :ackDeadlineSeconds integer}"
  [subscription ModifyAckDeadlineRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://pubsub.googleapis.com/v1/{+subscription}:modifyAckDeadline",
     :uri-template-args {:subscription subscription},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/pubsub"],
     :body ModifyAckDeadlineRequest}))

(defn projects-subscriptions-delete
  "Deletes an existing subscription. All messages retained in the subscription are immediately dropped. Calls to `Pull` after deletion will return `NOT_FOUND`. After a subscription is deleted, a new one may be created with the same name, but the new one has no association with the old subscription or its topic unless the same topic is specified.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.subscriptions/delete

subscription <string> Required. The subscription to delete. Format is `projects/{project}/subscriptions/{sub}`."
  [subscription]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://pubsub.googleapis.com/v1/{+subscription}",
     :uri-template-args {:subscription subscription},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/pubsub"]}))

(defn projects-subscriptions-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.subscriptions/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource] (projects-subscriptions-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://pubsub.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/pubsub"]})))

(defn projects-subscriptions-modifyPushConfig
  "Modifies the `PushConfig` for a specified subscription. This may be used to change a push subscription to a pull one (signified by an empty `PushConfig`) or vice versa, or change the endpoint URL and other attributes of a push subscription. Messages will accumulate for delivery continuously through the call regardless of changes to the `PushConfig`.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.subscriptions/modifyPushConfig

subscription <string> Required. The name of the subscription. Format is `projects/{project}/subscriptions/{sub}`.
ModifyPushConfigRequest:
{:pushConfig
 {:pushEndpoint string,
  :attributes object,
  :oidcToken {:serviceAccountEmail string, :audience string},
  :pubsubWrapper object,
  :noWrapper {:writeMetadata boolean}}}"
  [subscription ModifyPushConfigRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://pubsub.googleapis.com/v1/{+subscription}:modifyPushConfig",
     :uri-template-args {:subscription subscription},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/pubsub"],
     :body ModifyPushConfigRequest}))

(defn projects-subscriptions-list
  "Lists matching subscriptions.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.subscriptions/list

project <string> Required. The name of the project in which to list subscriptions. Format is `projects/{project-id}`.

optional:
pageSize <integer> Optional. Maximum number of subscriptions to return."
  ([project] (projects-subscriptions-list project nil))
  ([project optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://pubsub.googleapis.com/v1/{+project}/subscriptions",
       :uri-template-args {:project project},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/pubsub"]})))

(defn projects-subscriptions-seek
  "Seeks an existing subscription to a point in time or to a given snapshot, whichever is provided in the request. Snapshots are used in [Seek] (https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to manage message acknowledgments in bulk. That is, you can set the acknowledgment state of messages in an existing subscription to the state captured by a snapshot. Note that both the subscription and the snapshot must be on the same topic.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.subscriptions/seek

subscription <string> Required. The subscription to affect.
SeekRequest:
{:time string, :snapshot string}"
  [subscription SeekRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://pubsub.googleapis.com/v1/{+subscription}:seek",
     :uri-template-args {:subscription subscription},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/pubsub"],
     :body SeekRequest}))

(defn projects-subscriptions-pull
  "Pulls messages from the server.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.subscriptions/pull

subscription <string> Required. The subscription from which messages should be pulled. Format is `projects/{project}/subscriptions/{sub}`.
PullRequest:
{:returnImmediately boolean, :maxMessages integer}"
  [subscription PullRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://pubsub.googleapis.com/v1/{+subscription}:pull",
     :uri-template-args {:subscription subscription},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/pubsub"],
     :body PullRequest}))

(defn projects-snapshots-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.snapshots/setIamPolicy

resource <string> REQUIRED: The resource for which the policy is being specified. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
SetIamPolicyRequest:
{:policy
 {:version integer,
  :bindings
  [{:role string,
    :members [string],
    :condition
    {:expression string,
     :title string,
     :description string,
     :location string}}],
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://pubsub.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/pubsub"],
     :body SetIamPolicyRequest}))

(defn projects-snapshots-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.snapshots/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource] (projects-snapshots-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://pubsub.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/pubsub"]})))

(defn projects-snapshots-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.snapshots/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://pubsub.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/pubsub"],
     :body TestIamPermissionsRequest}))

(defn projects-snapshots-get
  "Gets the configuration details of a snapshot. Snapshots are used in [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to manage message acknowledgments in bulk. That is, you can set the acknowledgment state of messages in an existing subscription to the state captured by a snapshot.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.snapshots/get

snapshot <string> Required. The name of the snapshot to get. Format is `projects/{project}/snapshots/{snap}`."
  [snapshot]
  (client/api-request
    {:method "GET",
     :uri-template "https://pubsub.googleapis.com/v1/{+snapshot}",
     :uri-template-args {:snapshot snapshot},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/pubsub"]}))

(defn projects-snapshots-list
  "Lists the existing snapshots. Snapshots are used in [Seek]( https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to manage message acknowledgments in bulk. That is, you can set the acknowledgment state of messages in an existing subscription to the state captured by a snapshot.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.snapshots/list

project <string> Required. The name of the project in which to list snapshots. Format is `projects/{project-id}`.

optional:
pageSize <integer> Optional. Maximum number of snapshots to return."
  ([project] (projects-snapshots-list project nil))
  ([project optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://pubsub.googleapis.com/v1/{+project}/snapshots",
       :uri-template-args {:project project},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/pubsub"]})))

(defn projects-snapshots-create
  "Creates a snapshot from the requested subscription. Snapshots are used in [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to manage message acknowledgments in bulk. That is, you can set the acknowledgment state of messages in an existing subscription to the state captured by a snapshot. If the snapshot already exists, returns `ALREADY_EXISTS`. If the requested subscription doesn't exist, returns `NOT_FOUND`. If the backlog in the subscription is too old -- and the resulting snapshot would expire in less than 1 hour -- then `FAILED_PRECONDITION` is returned. See also the `Snapshot.expire_time` field. If the name is not provided in the request, the server will assign a random name for this snapshot on the same project as the subscription, conforming to the [resource name format] (https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names). The generated name is populated in the returned Snapshot object. Note that for REST API requests, you must specify a name in the request.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.snapshots/create

name <string> Required. User-provided name for this snapshot. If the name is not provided in the request, the server will assign a random name for this snapshot on the same project as the subscription. Note that for REST API requests, you must specify a name. See the [resource name rules](https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names). Format is `projects/{project}/snapshots/{snap}`.
CreateSnapshotRequest:
{:subscription string, :labels object}"
  [name CreateSnapshotRequest]
  (client/api-request
    {:method "PUT",
     :uri-template "https://pubsub.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/pubsub"],
     :body CreateSnapshotRequest}))

(defn projects-snapshots-patch
  "Updates an existing snapshot by updating the fields specified in the update mask. Snapshots are used in [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to manage message acknowledgments in bulk. That is, you can set the acknowledgment state of messages in an existing subscription to the state captured by a snapshot.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.snapshots/patch

name <string> Optional. The name of the snapshot.
UpdateSnapshotRequest:
{:snapshot
 {:name string, :topic string, :expireTime string, :labels object},
 :updateMask string}"
  [name UpdateSnapshotRequest]
  (client/api-request
    {:method "PATCH",
     :uri-template "https://pubsub.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/pubsub"],
     :body UpdateSnapshotRequest}))

(defn projects-snapshots-delete
  "Removes an existing snapshot. Snapshots are used in [Seek] (https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to manage message acknowledgments in bulk. That is, you can set the acknowledgment state of messages in an existing subscription to the state captured by a snapshot. When the snapshot is deleted, all messages retained in the snapshot are immediately dropped. After a snapshot is deleted, a new one may be created with the same name, but the new one has no association with the old snapshot or its subscription, unless the same subscription is specified.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.snapshots/delete

snapshot <string> Required. The name of the snapshot to delete. Format is `projects/{project}/snapshots/{snap}`."
  [snapshot]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://pubsub.googleapis.com/v1/{+snapshot}",
     :uri-template-args {:snapshot snapshot},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/pubsub"]}))

(defn projects-schemas-rollback
  "Creates a new schema revision that is a copy of the provided revision_id.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.schemas/rollback

name <string> Required. The schema being rolled back with revision id.
RollbackSchemaRequest:
{:revisionId string}"
  [name RollbackSchemaRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://pubsub.googleapis.com/v1/{+name}:rollback",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/pubsub"],
     :body RollbackSchemaRequest}))

(defn projects-schemas-get
  "Gets a schema.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.schemas/get

name <string> Required. The name of the schema to get. Format is `projects/{project}/schemas/{schema}`.

optional:
view <string> The set of fields to return in the response. If not set, returns a Schema with all fields filled out. Set to `BASIC` to omit the `definition`."
  ([name] (projects-schemas-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://pubsub.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/pubsub"]})))

(defn projects-schemas-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.schemas/setIamPolicy

resource <string> REQUIRED: The resource for which the policy is being specified. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
SetIamPolicyRequest:
{:policy
 {:version integer,
  :bindings
  [{:role string,
    :members [string],
    :condition
    {:expression string,
     :title string,
     :description string,
     :location string}}],
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://pubsub.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/pubsub"],
     :body SetIamPolicyRequest}))

(defn projects-schemas-validate
  "Validates a schema.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.schemas/validate

parent <string> Required. The name of the project in which to validate schemas. Format is `projects/{project-id}`.
ValidateSchemaRequest:
{:schema
 {:name string,
  :type [TYPE_UNSPECIFIED PROTOCOL_BUFFER AVRO],
  :definition string,
  :revisionId string,
  :revisionCreateTime string}}"
  [parent ValidateSchemaRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://pubsub.googleapis.com/v1/{+parent}/schemas:validate",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/pubsub"],
     :body ValidateSchemaRequest}))

(defn projects-schemas-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.schemas/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://pubsub.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/pubsub"],
     :body TestIamPermissionsRequest}))

(defn projects-schemas-create
  "Creates a schema.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.schemas/create

parent <string> Required. The name of the project in which to create the schema. Format is `projects/{project-id}`.
Schema:
{:name string,
 :type [TYPE_UNSPECIFIED PROTOCOL_BUFFER AVRO],
 :definition string,
 :revisionId string,
 :revisionCreateTime string}

optional:
schemaId <string> The ID to use for the schema, which will become the final component of the schema's resource name. See https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names for resource name constraints."
  ([parent Schema] (projects-schemas-create parent Schema nil))
  ([parent Schema optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://pubsub.googleapis.com/v1/{+parent}/schemas",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/pubsub"],
       :body Schema})))

(defn projects-schemas-delete
  "Deletes a schema.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.schemas/delete

name <string> Required. Name of the schema to delete. Format is `projects/{project}/schemas/{schema}`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://pubsub.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/pubsub"]}))

(defn projects-schemas-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.schemas/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource] (projects-schemas-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://pubsub.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/pubsub"]})))

(defn projects-schemas-list
  "Lists schemas in a project.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.schemas/list

parent <string> Required. The name of the project in which to list schemas. Format is `projects/{project-id}`.

optional:
view <string> The set of Schema fields to return in the response. If not set, returns Schemas with `name` and `type`, but not `definition`. Set to `FULL` to retrieve all fields.
pageSize <integer> Maximum number of schemas to return."
  ([parent] (projects-schemas-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://pubsub.googleapis.com/v1/{+parent}/schemas",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/pubsub"]})))

(defn projects-schemas-commit
  "Commits a new schema revision to an existing schema.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.schemas/commit

name <string> Required. The name of the schema we are revising. Format is `projects/{project}/schemas/{schema}`.
CommitSchemaRequest:
{:schema
 {:name string,
  :type [TYPE_UNSPECIFIED PROTOCOL_BUFFER AVRO],
  :definition string,
  :revisionId string,
  :revisionCreateTime string}}"
  [name CommitSchemaRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://pubsub.googleapis.com/v1/{+name}:commit",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/pubsub"],
     :body CommitSchemaRequest}))

(defn projects-schemas-deleteRevision
  "Deletes a specific schema revision.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.schemas/deleteRevision

name <string> Required. The name of the schema revision to be deleted, with a revision ID explicitly included. Example: `projects/123/schemas/my-schema@c7cfa2a8`

optional:
revisionId <string> Optional. This field is deprecated and should not be used for specifying the revision ID. The revision ID should be specified via the `name` parameter."
  ([name] (projects-schemas-deleteRevision name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://pubsub.googleapis.com/v1/{+name}:deleteRevision",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/pubsub"]})))

(defn projects-schemas-listRevisions
  "Lists all schema revisions for the named schema.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.schemas/listRevisions

name <string> Required. The name of the schema to list revisions for.

optional:
view <string> The set of Schema fields to return in the response. If not set, returns Schemas with `name` and `type`, but not `definition`. Set to `FULL` to retrieve all fields.
pageSize <integer> The maximum number of revisions to return per page."
  ([name] (projects-schemas-listRevisions name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://pubsub.googleapis.com/v1/{+name}:listRevisions",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/pubsub"]})))

(defn projects-schemas-validateMessage
  "Validates a message against a schema.
https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.schemas/validateMessage

parent <string> Required. The name of the project in which to validate schemas. Format is `projects/{project-id}`.
ValidateMessageRequest:
{:name string,
 :schema
 {:name string,
  :type [TYPE_UNSPECIFIED PROTOCOL_BUFFER AVRO],
  :definition string,
  :revisionId string,
  :revisionCreateTime string},
 :message string,
 :encoding [ENCODING_UNSPECIFIED JSON BINARY]}"
  [parent ValidateMessageRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://pubsub.googleapis.com/v1/{+parent}/schemas:validateMessage",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/pubsub"],
     :body ValidateMessageRequest}))

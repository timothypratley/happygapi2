(ns happygapi2.contactcenteraiplatform
  "Contact Center AI Platform API

See: https://cloud.google.com/solutions/contact-center-ai-platform"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-queryContactCenterQuota
  "Queries the contact center quota, an aggregation over all the projects, that belongs to the billing account, which the input project belongs to.
https://cloud.google.com/solutions/contact-center-ai-platform/v1alpha1/docs/projects/locations/queryContactCenterQuota

parent <string> Required. Parent project resource id."
  [parent]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://contactcenteraiplatform.googleapis.com/v1alpha1/{+parent}:queryContactCenterQuota",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/solutions/contact-center-ai-platform/v1alpha1/docs/projects/locations/list

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://contactcenteraiplatform.googleapis.com/v1alpha1/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/solutions/contact-center-ai-platform/v1alpha1/docs/projects/locations/get

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://contactcenteraiplatform.googleapis.com/v1alpha1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/solutions/contact-center-ai-platform/v1alpha1/docs/projects/locations/operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://contactcenteraiplatform.googleapis.com/v1alpha1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/solutions/contact-center-ai-platform/v1alpha1/docs/projects/locations/operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://contactcenteraiplatform.googleapis.com/v1alpha1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/solutions/contact-center-ai-platform/v1alpha1/docs/projects/locations/operations/delete

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://contactcenteraiplatform.googleapis.com/v1alpha1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/solutions/contact-center-ai-platform/v1alpha1/docs/projects/locations/operations/cancel

name <string> The name of the operation resource to be cancelled.
CancelOperationRequest:
object"
  [name CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://contactcenteraiplatform.googleapis.com/v1alpha1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelOperationRequest}))

(defn projects-locations-contactCenters-list
  "Lists ContactCenters in a given project and location.
https://cloud.google.com/solutions/contact-center-ai-platform/v1alpha1/docs/projects/locations/contactCenters/list

parent <string> Required. Parent value for ListContactCentersRequest

optional:
pageSize <integer> Requested page size. Server may return fewer items than requested. If unspecified, server will pick an appropriate default.
filter <string> Filtering results
orderBy <string> Hint for how to order the results"
  ([parent] (projects-locations-contactCenters-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://contactcenteraiplatform.googleapis.com/v1alpha1/{+parent}/contactCenters",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-contactCenters-get
  "Gets details of a single ContactCenter.
https://cloud.google.com/solutions/contact-center-ai-platform/v1alpha1/docs/projects/locations/contactCenters/get

name <string> Required. Name of the resource"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://contactcenteraiplatform.googleapis.com/v1alpha1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-contactCenters-create
  "Creates a new ContactCenter in a given project and location.
https://cloud.google.com/solutions/contact-center-ai-platform/v1alpha1/docs/projects/locations/contactCenters/create

parent <string> Required. Value for parent.
ContactCenter:
{:labels object,
 :privateAccess
 {:ingressSettings [{:name string, :serviceAttachmentNames [string]}],
  :egressSettings [{:name string, :serviceAttachmentNames [string]}],
  :pscSetting {:allowedConsumerProjectIds [string]}},
 :customerDomainPrefix string,
 :displayName string,
 :name string,
 :createTime string,
 :samlParams
 {:ssoUri string,
  :entityId string,
  :certificate string,
  :userEmail string,
  :emailMapping string,
  :authenticationContexts
  [[AUTHENTICATION_CONTEXT_UNSPECIFIED
    INTERNET_PROTOCOL
    INTERNET_PROTOCOL_PASSWORD
    KERBEROS
    MOBILE_ONE_FACTOR_UNREGISTERED
    MOBILE_TWO_FACTOR_UNREGISTERED
    MOBILE_ONE_FACTOR_CONTRACT
    MOBILE_TWO_FACTOR_CONTRACT
    PASSWORD
    PASSWORD_PROTECTED_TRANSPORT
    PREVIOUS_SESSION
    PUBLIC_KEY_X509
    PUBLIC_KEY_PGP
    PUBLIC_KEY_SPKI
    PUBLIC_KEY_XML_DIGITAL_SIGNATURE
    SMARTCARD
    SMARTCARD_PKI
    SOFTWARE_PKI
    TELEPHONY
    TELEPHONY_NOMADIC
    TELEPHONY_PERSONALIZED
    TELEPHONY_AUTHENTICATED
    SECURE_REMOTE_PASSWORD
    SSL_TLS_CERTIFICATE_BASED
    TIME_SYNC_TOKEN]]},
 :privateComponents [string],
 :state
 [STATE_UNSPECIFIED
  STATE_DEPLOYING
  STATE_DEPLOYED
  STATE_TERMINATING
  STATE_FAILED
  STATE_TERMINATING_FAILED
  STATE_TERMINATED
  STATE_IN_GRACE_PERIOD
  STATE_FAILING_OVER
  STATE_DEGRADED
  STATE_REPAIRING],
 :normal object,
 :early object,
 :updateTime string,
 :adminUser {:givenName string, :familyName string},
 :critical
 {:peakHours
  [{:days
    [[DAY_OF_WEEK_UNSPECIFIED
      MONDAY
      TUESDAY
      WEDNESDAY
      THURSDAY
      FRIDAY
      SATURDAY
      SUNDAY]],
    :startTime
    {:hours integer,
     :minutes integer,
     :seconds integer,
     :nanos integer},
    :endTime
    {:hours integer,
     :minutes integer,
     :seconds integer,
     :nanos integer},
    :duration string}]},
 :ccaipManagedUsers boolean,
 :kmsKey string,
 :instanceConfig
 {:instanceSize
  [INSTANCE_SIZE_UNSPECIFIED
   STANDARD_SMALL
   STANDARD_MEDIUM
   STANDARD_LARGE
   STANDARD_XLARGE
   STANDARD_2XLARGE
   STANDARD_3XLARGE
   DEV_XSMALL
   MULTIREGION_SMALL
   MULTIREGION_MEDIUM
   MULTIREGION_LARGE
   MULTIREGION_XLARGE
   MULTIREGION_2XLARGE
   MULTIREGION_3XLARGE]},
 :uris
 {:rootUri string,
  :mediaUri string,
  :virtualAgentStreamingServiceUri string,
  :chatBotUri string},
 :userEmail string}

optional:
contactCenterId <string> Required. Id of the requesting object If auto-generating Id server-side, remove this field and contact_center_id from the method_signature of Create RPC
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent ContactCenter]
    (projects-locations-contactCenters-create
      parent
      ContactCenter
      nil))
  ([parent ContactCenter optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://contactcenteraiplatform.googleapis.com/v1alpha1/{+parent}/contactCenters",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ContactCenter})))

(defn projects-locations-contactCenters-patch
  "Updates the parameters of a single ContactCenter.
https://cloud.google.com/solutions/contact-center-ai-platform/v1alpha1/docs/projects/locations/contactCenters/patch

name <string> name of resource
ContactCenter:
{:labels object,
 :privateAccess
 {:ingressSettings [{:name string, :serviceAttachmentNames [string]}],
  :egressSettings [{:name string, :serviceAttachmentNames [string]}],
  :pscSetting {:allowedConsumerProjectIds [string]}},
 :customerDomainPrefix string,
 :displayName string,
 :name string,
 :createTime string,
 :samlParams
 {:ssoUri string,
  :entityId string,
  :certificate string,
  :userEmail string,
  :emailMapping string,
  :authenticationContexts
  [[AUTHENTICATION_CONTEXT_UNSPECIFIED
    INTERNET_PROTOCOL
    INTERNET_PROTOCOL_PASSWORD
    KERBEROS
    MOBILE_ONE_FACTOR_UNREGISTERED
    MOBILE_TWO_FACTOR_UNREGISTERED
    MOBILE_ONE_FACTOR_CONTRACT
    MOBILE_TWO_FACTOR_CONTRACT
    PASSWORD
    PASSWORD_PROTECTED_TRANSPORT
    PREVIOUS_SESSION
    PUBLIC_KEY_X509
    PUBLIC_KEY_PGP
    PUBLIC_KEY_SPKI
    PUBLIC_KEY_XML_DIGITAL_SIGNATURE
    SMARTCARD
    SMARTCARD_PKI
    SOFTWARE_PKI
    TELEPHONY
    TELEPHONY_NOMADIC
    TELEPHONY_PERSONALIZED
    TELEPHONY_AUTHENTICATED
    SECURE_REMOTE_PASSWORD
    SSL_TLS_CERTIFICATE_BASED
    TIME_SYNC_TOKEN]]},
 :privateComponents [string],
 :state
 [STATE_UNSPECIFIED
  STATE_DEPLOYING
  STATE_DEPLOYED
  STATE_TERMINATING
  STATE_FAILED
  STATE_TERMINATING_FAILED
  STATE_TERMINATED
  STATE_IN_GRACE_PERIOD
  STATE_FAILING_OVER
  STATE_DEGRADED
  STATE_REPAIRING],
 :normal object,
 :early object,
 :updateTime string,
 :adminUser {:givenName string, :familyName string},
 :critical
 {:peakHours
  [{:days
    [[DAY_OF_WEEK_UNSPECIFIED
      MONDAY
      TUESDAY
      WEDNESDAY
      THURSDAY
      FRIDAY
      SATURDAY
      SUNDAY]],
    :startTime
    {:hours integer,
     :minutes integer,
     :seconds integer,
     :nanos integer},
    :endTime
    {:hours integer,
     :minutes integer,
     :seconds integer,
     :nanos integer},
    :duration string}]},
 :ccaipManagedUsers boolean,
 :kmsKey string,
 :instanceConfig
 {:instanceSize
  [INSTANCE_SIZE_UNSPECIFIED
   STANDARD_SMALL
   STANDARD_MEDIUM
   STANDARD_LARGE
   STANDARD_XLARGE
   STANDARD_2XLARGE
   STANDARD_3XLARGE
   DEV_XSMALL
   MULTIREGION_SMALL
   MULTIREGION_MEDIUM
   MULTIREGION_LARGE
   MULTIREGION_XLARGE
   MULTIREGION_2XLARGE
   MULTIREGION_3XLARGE]},
 :uris
 {:rootUri string,
  :mediaUri string,
  :virtualAgentStreamingServiceUri string,
  :chatBotUri string},
 :userEmail string}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten in the ContactCenter resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then all fields will be overwritten.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name ContactCenter]
    (projects-locations-contactCenters-patch name ContactCenter nil))
  ([name ContactCenter optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://contactcenteraiplatform.googleapis.com/v1alpha1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ContactCenter})))

(defn projects-locations-contactCenters-delete
  "Deletes a single ContactCenter.
https://cloud.google.com/solutions/contact-center-ai-platform/v1alpha1/docs/projects/locations/contactCenters/delete

name <string> Required. Name of the resource

optional:
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name] (projects-locations-contactCenters-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://contactcenteraiplatform.googleapis.com/v1alpha1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

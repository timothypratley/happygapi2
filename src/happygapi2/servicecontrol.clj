(ns happygapi2.servicecontrol
  "Service Control API
Provides admission control and telemetry reporting for services integrated with Service Infrastructure. 
See: https://cloud.google.com/service-infrastructure/docs"
  (:require [happy.oauth2.client :as client]))

(defn services-check
  "Private Preview. This feature is only available for approved services. This method provides admission control for services that are integrated with [Service Infrastructure](https://cloud.google.com/service-infrastructure). It checks whether an operation should be allowed based on the service configuration and relevant policies. It must be called before the operation is executed. For more information, see [Admission Control](https://cloud.google.com/service-infrastructure/docs/admission-control). NOTE: The admission control has an expected policy propagation delay of 60s. The caller **must** not depend on the most recent policy changes. NOTE: The admission control has a hard limit of 1 referenced resources per call. If an operation refers to more than 1 resources, the caller must call the Check method multiple times. This method requires the `servicemanagement.services.check` permission on the specified service. For more information, see [Service Control API Access Control](https://cloud.google.com/service-infrastructure/docs/service-control/access-control).
https://cloud.google.com/service-infrastructure/docs

serviceName <string> The service name as specified in its service configuration. For example, `\"pubsub.googleapis.com\"`. See [google.api.Service](https://cloud.google.com/service-management/reference/rpc/google.api#google.api.Service) for the definition of a service name.
CheckRequest:
{:serviceConfigId string,
 :attributes
 {:origin
  {:ip string,
   :port string,
   :labels object,
   :principal string,
   :regionCode string},
  :source
  {:ip string,
   :port string,
   :labels object,
   :principal string,
   :regionCode string},
  :destination
  {:ip string,
   :port string,
   :labels object,
   :principal string,
   :regionCode string},
  :request
  {:path string,
   :protocol string,
   :method string,
   :time string,
   :auth
   {:principal string,
    :audiences [string],
    :presenter string,
    :claims object,
    :accessLevels [string],
    :credentialId string},
   :size string,
   :headers object,
   :reason string,
   :host string,
   :id string,
   :query string,
   :scheme string},
  :response
  {:code string,
   :size string,
   :headers object,
   :time string,
   :backendLatency string},
  :resource
  {:labels object,
   :service string,
   :deleteTime string,
   :displayName string,
   :uid string,
   :name string,
   :createTime string,
   :type string,
   :etag string,
   :updateTime string,
   :annotations object,
   :location string},
  :api
  {:service string,
   :operation string,
   :protocol string,
   :version string},
  :extensions [object]},
 :resources
 [{:name string,
   :type string,
   :permission string,
   :container string,
   :location string}],
 :flags string}"
  [serviceName CheckRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://servicecontrol.googleapis.com/v2/services/{serviceName}:check",
     :uri-template-args {:serviceName serviceName},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/servicecontrol"],
     :body CheckRequest}))

(defn services-report
  "Private Preview. This feature is only available for approved services. This method provides telemetry reporting for services that are integrated with [Service Infrastructure](https://cloud.google.com/service-infrastructure). It reports a list of operations that have occurred on a service. It must be called after the operations have been executed. For more information, see [Telemetry Reporting](https://cloud.google.com/service-infrastructure/docs/telemetry-reporting). NOTE: The telemetry reporting has a hard limit of 1000 operations and 1MB per Report call. It is recommended to have no more than 100 operations per call. This method requires the `servicemanagement.services.report` permission on the specified service. For more information, see [Service Control API Access Control](https://cloud.google.com/service-infrastructure/docs/service-control/access-control).
https://cloud.google.com/service-infrastructure/docs

serviceName <string> The service name as specified in its service configuration. For example, `\"pubsub.googleapis.com\"`. See [google.api.Service](https://cloud.google.com/service-management/reference/rpc/google.api#google.api.Service) for the definition of a service name.
ReportRequest:
{:serviceConfigId string,
 :operations
 [{:origin
   {:ip string,
    :port string,
    :labels object,
    :principal string,
    :regionCode string},
   :source
   {:ip string,
    :port string,
    :labels object,
    :principal string,
    :regionCode string},
   :destination
   {:ip string,
    :port string,
    :labels object,
    :principal string,
    :regionCode string},
   :request
   {:path string,
    :protocol string,
    :method string,
    :time string,
    :auth
    {:principal string,
     :audiences [string],
     :presenter string,
     :claims object,
     :accessLevels [string],
     :credentialId string},
    :size string,
    :headers object,
    :reason string,
    :host string,
    :id string,
    :query string,
    :scheme string},
   :response
   {:code string,
    :size string,
    :headers object,
    :time string,
    :backendLatency string},
   :resource
   {:labels object,
    :service string,
    :deleteTime string,
    :displayName string,
    :uid string,
    :name string,
    :createTime string,
    :type string,
    :etag string,
    :updateTime string,
    :annotations object,
    :location string},
   :api
   {:service string,
    :operation string,
    :protocol string,
    :version string},
   :extensions [object]}]}"
  [serviceName ReportRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://servicecontrol.googleapis.com/v2/services/{serviceName}:report",
     :uri-template-args {:serviceName serviceName},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/servicecontrol"],
     :body ReportRequest}))

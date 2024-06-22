(ns happygapi2.trafficdirector
  "Traffic Director API

See: https://cloud.google.com/products/service-mesh"
  (:require [happy.oauth2.client :as client]))

(defn discovery-client_status
  "
https://cloud.google.com/products/service-mesh/v3/docs/discovery/client_status

ClientStatusRequest:
{:nodeMatchers
 [{:nodeId
   {:exact string,
    :prefix string,
    :suffix string,
    :safeRegex {:googleRe2 {:maxProgramSize integer}, :regex string},
    :contains string,
    :custom {:name string, :typedConfig object},
    :ignoreCase boolean},
   :nodeMetadatas
   [{:path [{:key string}],
     :value
     {:nullMatch object,
      :doubleMatch {:range DoubleRange, :exact number},
      :stringMatch
      {:exact string,
       :prefix string,
       :suffix string,
       :safeRegex RegexMatcher,
       :contains string,
       :custom TypedExtensionConfig,
       :ignoreCase boolean},
      :boolMatch boolean,
      :presentMatch boolean,
      :listMatch {:oneOf ValueMatcher},
      :orMatch {:valueMatchers [ValueMatcher]}}}]}],
 :node
 {:locality {:region string, :zone string, :subZone string},
  :dynamicParameters object,
  :userAgentVersion string,
  :cluster string,
  :userAgentBuildVersion
  {:version
   {:majorNumber integer, :minorNumber integer, :patch integer},
   :metadata object},
  :listeningAddresses
  [{:socketAddress
    {:protocol [TCP UDP],
     :address string,
     :portValue integer,
     :namedPort string,
     :resolverName string,
     :ipv4Compat boolean},
    :pipe {:path string, :mode integer},
    :envoyInternalAddress
    {:serverListenerName string, :endpointId string}}],
  :extensions
  [{:name string,
    :category string,
    :typeDescriptor string,
    :version
    {:version
     {:majorNumber integer, :minorNumber integer, :patch integer},
     :metadata object},
    :disabled boolean,
    :typeUrls [string]}],
  :id string,
  :userAgentName string,
  :clientFeatures [string],
  :metadata object},
 :excludeResourceContents boolean}"
  [ClientStatusRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://trafficdirector.googleapis.com/v3/discovery:client_status",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ClientStatusRequest}))

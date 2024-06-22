(ns happygapi2.transcoder
  "Transcoder API
This API converts video files into formats suitable for consumer distribution. For more information, see the Transcoder API overview. 
See: https://cloud.google.com/transcoder/docs/"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-jobs-create
  "Creates a job in the specified region.
https://cloud.google.com/transcoder/docs/reference/rest/v1/projects.locations.jobs/create

parent <string> Required. The parent location to create and process this job. Format: `projects/{project}/locations/{location}`
Job:
{:labels object,
 :outputUri string,
 :ttlAfterCompletionDays integer,
 :startTime string,
 :config
 {:overlays
  [{:image
    {:uri string, :resolution {:x number, :y number}, :alpha number},
    :animations
    [{:animationStatic
      {:xy NormalizedCoordinate, :startTimeOffset string},
      :animationFade
      {:fadeType [FADE_TYPE_UNSPECIFIED FADE_IN FADE_OUT],
       :xy NormalizedCoordinate,
       :startTimeOffset string,
       :endTimeOffset string},
      :animationEnd {:startTimeOffset string}}]}],
  :manifests
  [{:fileName string,
    :type [MANIFEST_TYPE_UNSPECIFIED HLS DASH],
    :muxStreams [string],
    :dash
    {:segmentReferenceScheme
     [SEGMENT_REFERENCE_SCHEME_UNSPECIFIED
      SEGMENT_LIST
      SEGMENT_TEMPLATE_NUMBER]}}],
  :adBreaks [{:startTimeOffset string}],
  :output {:uri string},
  :inputs
  [{:key string,
    :uri string,
    :preprocessingConfig
    {:color {:saturation number, :contrast number, :brightness number},
     :denoise {:strength number, :tune string},
     :deblock {:strength number, :enabled boolean},
     :audio {:lufs number, :highBoost boolean, :lowBoost boolean},
     :crop
     {:topPixels integer,
      :bottomPixels integer,
      :leftPixels integer,
      :rightPixels integer},
     :pad
     {:topPixels integer,
      :bottomPixels integer,
      :leftPixels integer,
      :rightPixels integer},
     :deinterlace {:yadif YadifConfig, :bwdif BwdifConfig}}}],
  :spriteSheets
  [{:format string,
    :endTimeOffset string,
    :spriteWidthPixels integer,
    :spriteHeightPixels integer,
    :startTimeOffset string,
    :filePrefix string,
    :columnCount integer,
    :quality integer,
    :totalCount integer,
    :rowCount integer,
    :interval string}],
  :elementaryStreams
  [{:key string,
    :videoStream
    {:h264
     {:aqStrength number,
      :vbvFullnessBits integer,
      :widthPixels integer,
      :tune string,
      :heightPixels integer,
      :entropyCoder string,
      :rateControlMode string,
      :crfLevel integer,
      :frameRate number,
      :bitrateBps integer,
      :bFrameCount integer,
      :gopDuration string,
      :sdr H264ColorFormatSDR,
      :preset string,
      :pixelFormat string,
      :enableTwoPass boolean,
      :gopFrameCount integer,
      :vbvSizeBits integer,
      :hlg H264ColorFormatHLG,
      :allowOpenGop boolean,
      :bPyramid boolean,
      :profile string,
      :frameRateConversionStrategy
      [FRAME_RATE_CONVERSION_STRATEGY_UNSPECIFIED
       DOWNSAMPLE
       DROP_DUPLICATE]},
     :h265
     {:aqStrength number,
      :vbvFullnessBits integer,
      :widthPixels integer,
      :tune string,
      :heightPixels integer,
      :rateControlMode string,
      :crfLevel integer,
      :frameRate number,
      :bitrateBps integer,
      :bFrameCount integer,
      :gopDuration string,
      :sdr H265ColorFormatSDR,
      :preset string,
      :pixelFormat string,
      :enableTwoPass boolean,
      :gopFrameCount integer,
      :hdr10 H265ColorFormatHDR10,
      :vbvSizeBits integer,
      :hlg H265ColorFormatHLG,
      :allowOpenGop boolean,
      :bPyramid boolean,
      :profile string,
      :frameRateConversionStrategy
      [FRAME_RATE_CONVERSION_STRATEGY_UNSPECIFIED
       DOWNSAMPLE
       DROP_DUPLICATE]},
     :vp9
     {:widthPixels integer,
      :heightPixels integer,
      :rateControlMode string,
      :crfLevel integer,
      :frameRate number,
      :bitrateBps integer,
      :gopDuration string,
      :sdr Vp9ColorFormatSDR,
      :pixelFormat string,
      :gopFrameCount integer,
      :hlg Vp9ColorFormatHLG,
      :profile string,
      :frameRateConversionStrategy
      [FRAME_RATE_CONVERSION_STRATEGY_UNSPECIFIED
       DOWNSAMPLE
       DROP_DUPLICATE]}},
    :audioStream
    {:codec string,
     :bitrateBps integer,
     :channelCount integer,
     :channelLayout [string],
     :mapping
     [{:atomKey string,
       :inputKey string,
       :inputTrack integer,
       :inputChannel integer,
       :outputChannel integer,
       :gainDb number}],
     :sampleRateHertz integer,
     :languageCode string,
     :displayName string},
    :textStream
    {:codec string,
     :languageCode string,
     :mapping
     [{:atomKey string, :inputKey string, :inputTrack integer}],
     :displayName string}}],
  :muxStreams
  [{:key string,
    :fileName string,
    :container string,
    :elementaryStreams [string],
    :segmentSettings
    {:segmentDuration string, :individualSegments boolean},
    :encryptionId string,
    :fmp4 {:codecTag string}}],
  :pubsubDestination {:topic string},
  :encryptions
  [{:id string,
    :aes128 object,
    :sampleAes object,
    :mpegCenc {:scheme string},
    :secretManagerKeySource {:secretVersion string},
    :drmSystems
    {:widevine object,
     :fairplay object,
     :playready object,
     :clearkey object}}],
  :editList
  [{:key string,
    :inputs [string],
    :endTimeOffset string,
    :startTimeOffset string}]},
 :name string,
 :endTime string,
 :batchModePriority integer,
 :mode
 [PROCESSING_MODE_UNSPECIFIED
  PROCESSING_MODE_INTERACTIVE
  PROCESSING_MODE_BATCH],
 :createTime string,
 :state
 [PROCESSING_STATE_UNSPECIFIED PENDING RUNNING SUCCEEDED FAILED],
 :optimization [OPTIMIZATION_STRATEGY_UNSPECIFIED AUTODETECT DISABLED],
 :error {:code integer, :message string, :details [object]},
 :templateId string,
 :inputUri string}"
  [parent Job]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://transcoder.googleapis.com/v1/{+parent}/jobs",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body Job}))

(defn projects-locations-jobs-list
  "Lists jobs in the specified region.
https://cloud.google.com/transcoder/docs/reference/rest/v1/projects.locations.jobs/list

parent <string> Required. Format: `projects/{project}/locations/{location}`

optional:
pageSize <integer> The maximum number of items to return.
filter <string> The filter expression, following the syntax outlined in https://google.aip.dev/160.
orderBy <string> One or more fields to compare and use to sort the output. See https://google.aip.dev/132#ordering."
  ([parent] (projects-locations-jobs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://transcoder.googleapis.com/v1/{+parent}/jobs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-jobs-get
  "Returns the job data.
https://cloud.google.com/transcoder/docs/reference/rest/v1/projects.locations.jobs/get

name <string> Required. The name of the job to retrieve. Format: `projects/{project}/locations/{location}/jobs/{job}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://transcoder.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-jobs-delete
  "Deletes a job.
https://cloud.google.com/transcoder/docs/reference/rest/v1/projects.locations.jobs/delete

name <string> Required. The name of the job to delete. Format: `projects/{project}/locations/{location}/jobs/{job}`

optional:
allowMissing <boolean> If set to true, and the job is not found, the request will succeed but no action will be taken on the server."
  ([name] (projects-locations-jobs-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://transcoder.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-jobTemplates-create
  "Creates a job template in the specified region.
https://cloud.google.com/transcoder/docs/reference/rest/v1/projects.locations.jobTemplates/create

parent <string> Required. The parent location to create this job template. Format: `projects/{project}/locations/{location}`
JobTemplate:
{:name string,
 :config
 {:overlays
  [{:image
    {:uri string, :resolution {:x number, :y number}, :alpha number},
    :animations
    [{:animationStatic
      {:xy NormalizedCoordinate, :startTimeOffset string},
      :animationFade
      {:fadeType [FADE_TYPE_UNSPECIFIED FADE_IN FADE_OUT],
       :xy NormalizedCoordinate,
       :startTimeOffset string,
       :endTimeOffset string},
      :animationEnd {:startTimeOffset string}}]}],
  :manifests
  [{:fileName string,
    :type [MANIFEST_TYPE_UNSPECIFIED HLS DASH],
    :muxStreams [string],
    :dash
    {:segmentReferenceScheme
     [SEGMENT_REFERENCE_SCHEME_UNSPECIFIED
      SEGMENT_LIST
      SEGMENT_TEMPLATE_NUMBER]}}],
  :adBreaks [{:startTimeOffset string}],
  :output {:uri string},
  :inputs
  [{:key string,
    :uri string,
    :preprocessingConfig
    {:color {:saturation number, :contrast number, :brightness number},
     :denoise {:strength number, :tune string},
     :deblock {:strength number, :enabled boolean},
     :audio {:lufs number, :highBoost boolean, :lowBoost boolean},
     :crop
     {:topPixels integer,
      :bottomPixels integer,
      :leftPixels integer,
      :rightPixels integer},
     :pad
     {:topPixels integer,
      :bottomPixels integer,
      :leftPixels integer,
      :rightPixels integer},
     :deinterlace {:yadif YadifConfig, :bwdif BwdifConfig}}}],
  :spriteSheets
  [{:format string,
    :endTimeOffset string,
    :spriteWidthPixels integer,
    :spriteHeightPixels integer,
    :startTimeOffset string,
    :filePrefix string,
    :columnCount integer,
    :quality integer,
    :totalCount integer,
    :rowCount integer,
    :interval string}],
  :elementaryStreams
  [{:key string,
    :videoStream
    {:h264
     {:aqStrength number,
      :vbvFullnessBits integer,
      :widthPixels integer,
      :tune string,
      :heightPixels integer,
      :entropyCoder string,
      :rateControlMode string,
      :crfLevel integer,
      :frameRate number,
      :bitrateBps integer,
      :bFrameCount integer,
      :gopDuration string,
      :sdr H264ColorFormatSDR,
      :preset string,
      :pixelFormat string,
      :enableTwoPass boolean,
      :gopFrameCount integer,
      :vbvSizeBits integer,
      :hlg H264ColorFormatHLG,
      :allowOpenGop boolean,
      :bPyramid boolean,
      :profile string,
      :frameRateConversionStrategy
      [FRAME_RATE_CONVERSION_STRATEGY_UNSPECIFIED
       DOWNSAMPLE
       DROP_DUPLICATE]},
     :h265
     {:aqStrength number,
      :vbvFullnessBits integer,
      :widthPixels integer,
      :tune string,
      :heightPixels integer,
      :rateControlMode string,
      :crfLevel integer,
      :frameRate number,
      :bitrateBps integer,
      :bFrameCount integer,
      :gopDuration string,
      :sdr H265ColorFormatSDR,
      :preset string,
      :pixelFormat string,
      :enableTwoPass boolean,
      :gopFrameCount integer,
      :hdr10 H265ColorFormatHDR10,
      :vbvSizeBits integer,
      :hlg H265ColorFormatHLG,
      :allowOpenGop boolean,
      :bPyramid boolean,
      :profile string,
      :frameRateConversionStrategy
      [FRAME_RATE_CONVERSION_STRATEGY_UNSPECIFIED
       DOWNSAMPLE
       DROP_DUPLICATE]},
     :vp9
     {:widthPixels integer,
      :heightPixels integer,
      :rateControlMode string,
      :crfLevel integer,
      :frameRate number,
      :bitrateBps integer,
      :gopDuration string,
      :sdr Vp9ColorFormatSDR,
      :pixelFormat string,
      :gopFrameCount integer,
      :hlg Vp9ColorFormatHLG,
      :profile string,
      :frameRateConversionStrategy
      [FRAME_RATE_CONVERSION_STRATEGY_UNSPECIFIED
       DOWNSAMPLE
       DROP_DUPLICATE]}},
    :audioStream
    {:codec string,
     :bitrateBps integer,
     :channelCount integer,
     :channelLayout [string],
     :mapping
     [{:atomKey string,
       :inputKey string,
       :inputTrack integer,
       :inputChannel integer,
       :outputChannel integer,
       :gainDb number}],
     :sampleRateHertz integer,
     :languageCode string,
     :displayName string},
    :textStream
    {:codec string,
     :languageCode string,
     :mapping
     [{:atomKey string, :inputKey string, :inputTrack integer}],
     :displayName string}}],
  :muxStreams
  [{:key string,
    :fileName string,
    :container string,
    :elementaryStreams [string],
    :segmentSettings
    {:segmentDuration string, :individualSegments boolean},
    :encryptionId string,
    :fmp4 {:codecTag string}}],
  :pubsubDestination {:topic string},
  :encryptions
  [{:id string,
    :aes128 object,
    :sampleAes object,
    :mpegCenc {:scheme string},
    :secretManagerKeySource {:secretVersion string},
    :drmSystems
    {:widevine object,
     :fairplay object,
     :playready object,
     :clearkey object}}],
  :editList
  [{:key string,
    :inputs [string],
    :endTimeOffset string,
    :startTimeOffset string}]},
 :labels object}

optional:
jobTemplateId <string> Required. The ID to use for the job template, which will become the final component of the job template's resource name. This value should be 4-63 characters, and valid characters must match the regular expression `a-zA-Z*`."
  ([parent JobTemplate]
    (projects-locations-jobTemplates-create parent JobTemplate nil))
  ([parent JobTemplate optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://transcoder.googleapis.com/v1/{+parent}/jobTemplates",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body JobTemplate})))

(defn projects-locations-jobTemplates-list
  "Lists job templates in the specified region.
https://cloud.google.com/transcoder/docs/reference/rest/v1/projects.locations.jobTemplates/list

parent <string> Required. The parent location from which to retrieve the collection of job templates. Format: `projects/{project}/locations/{location}`

optional:
pageSize <integer> The maximum number of items to return.
filter <string> The filter expression, following the syntax outlined in https://google.aip.dev/160.
orderBy <string> One or more fields to compare and use to sort the output. See https://google.aip.dev/132#ordering."
  ([parent] (projects-locations-jobTemplates-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://transcoder.googleapis.com/v1/{+parent}/jobTemplates",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-jobTemplates-get
  "Returns the job template data.
https://cloud.google.com/transcoder/docs/reference/rest/v1/projects.locations.jobTemplates/get

name <string> Required. The name of the job template to retrieve. Format: `projects/{project}/locations/{location}/jobTemplates/{job_template}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://transcoder.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-jobTemplates-delete
  "Deletes a job template.
https://cloud.google.com/transcoder/docs/reference/rest/v1/projects.locations.jobTemplates/delete

name <string> Required. The name of the job template to delete. `projects/{project}/locations/{location}/jobTemplates/{job_template}`

optional:
allowMissing <boolean> If set to true, and the job template is not found, the request will succeed but no action will be taken on the server."
  ([name] (projects-locations-jobTemplates-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://transcoder.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

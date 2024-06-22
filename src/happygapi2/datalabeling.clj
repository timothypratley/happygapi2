(ns happygapi2.datalabeling
  "Data Labeling API
Public API for Google Cloud AI Data Labeling Service.
See: https://cloud.google.com/ai-platform/data-labeling/docs"
  (:require [happy.oauth2.client :as client]))

(defn projects-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datalabeling.googleapis.com/v1beta1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://datalabeling.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.operations/delete

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://datalabeling.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.operations/cancel

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://datalabeling.googleapis.com/v1beta1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-datasets-create
  "Creates dataset. If success return a Dataset resource.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.datasets/create

parent <string> Required. Dataset resource parent, format: projects/{project_id}
GoogleCloudDatalabelingV1beta1CreateDatasetRequest:
{:dataset
 {:name string,
  :displayName string,
  :description string,
  :createTime string,
  :inputConfigs
  [{:textMetadata {:languageCode string},
    :gcsSource {:inputUri string, :mimeType string},
    :bigquerySource {:inputUri string},
    :dataType [DATA_TYPE_UNSPECIFIED IMAGE VIDEO TEXT GENERAL_DATA],
    :annotationType
    [ANNOTATION_TYPE_UNSPECIFIED
     IMAGE_CLASSIFICATION_ANNOTATION
     IMAGE_BOUNDING_BOX_ANNOTATION
     IMAGE_ORIENTED_BOUNDING_BOX_ANNOTATION
     IMAGE_BOUNDING_POLY_ANNOTATION
     IMAGE_POLYLINE_ANNOTATION
     IMAGE_SEGMENTATION_ANNOTATION
     VIDEO_SHOTS_CLASSIFICATION_ANNOTATION
     VIDEO_OBJECT_TRACKING_ANNOTATION
     VIDEO_OBJECT_DETECTION_ANNOTATION
     VIDEO_EVENT_ANNOTATION
     TEXT_CLASSIFICATION_ANNOTATION
     TEXT_ENTITY_EXTRACTION_ANNOTATION
     GENERAL_CLASSIFICATION_ANNOTATION],
    :classificationMetadata {:isMultiLabel boolean}}],
  :blockingResources [string],
  :dataItemCount string,
  :lastMigrateTime string}}"
  [parent GoogleCloudDatalabelingV1beta1CreateDatasetRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datalabeling.googleapis.com/v1beta1/{+parent}/datasets",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDatalabelingV1beta1CreateDatasetRequest}))

(defn projects-datasets-get
  "Gets dataset by resource name.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.datasets/get

name <string> Required. Dataset resource name, format: projects/{project_id}/datasets/{dataset_id}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://datalabeling.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-datasets-list
  "Lists datasets under a project. Pagination is supported.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.datasets/list

parent <string> Required. Dataset resource parent, format: projects/{project_id}

optional:
filter <string> Optional. Filter on dataset is not supported at this moment.
pageSize <integer> Optional. Requested page size. Server may return fewer results than requested. Default value is 100."
  ([parent] (projects-datasets-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datalabeling.googleapis.com/v1beta1/{+parent}/datasets",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-datasets-delete
  "Deletes a dataset by resource name.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.datasets/delete

name <string> Required. Dataset resource name, format: projects/{project_id}/datasets/{dataset_id}"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://datalabeling.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-datasets-importData
  "Imports data into dataset based on source locations defined in request. It can be called multiple times for the same dataset. Each dataset can only have one long running operation running on it. For example, no labeling task (also long running operation) can be started while importing is still ongoing. Vice versa.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.datasets/importData

name <string> Required. Dataset resource name, format: projects/{project_id}/datasets/{dataset_id}
GoogleCloudDatalabelingV1beta1ImportDataRequest:
{:inputConfig
 {:textMetadata {:languageCode string},
  :gcsSource {:inputUri string, :mimeType string},
  :bigquerySource {:inputUri string},
  :dataType [DATA_TYPE_UNSPECIFIED IMAGE VIDEO TEXT GENERAL_DATA],
  :annotationType
  [ANNOTATION_TYPE_UNSPECIFIED
   IMAGE_CLASSIFICATION_ANNOTATION
   IMAGE_BOUNDING_BOX_ANNOTATION
   IMAGE_ORIENTED_BOUNDING_BOX_ANNOTATION
   IMAGE_BOUNDING_POLY_ANNOTATION
   IMAGE_POLYLINE_ANNOTATION
   IMAGE_SEGMENTATION_ANNOTATION
   VIDEO_SHOTS_CLASSIFICATION_ANNOTATION
   VIDEO_OBJECT_TRACKING_ANNOTATION
   VIDEO_OBJECT_DETECTION_ANNOTATION
   VIDEO_EVENT_ANNOTATION
   TEXT_CLASSIFICATION_ANNOTATION
   TEXT_ENTITY_EXTRACTION_ANNOTATION
   GENERAL_CLASSIFICATION_ANNOTATION],
  :classificationMetadata {:isMultiLabel boolean}},
 :userEmailAddress string}"
  [name GoogleCloudDatalabelingV1beta1ImportDataRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datalabeling.googleapis.com/v1beta1/{+name}:importData",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDatalabelingV1beta1ImportDataRequest}))

(defn projects-datasets-exportData
  "Exports data and annotations from dataset.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.datasets/exportData

name <string> Required. Dataset resource name, format: projects/{project_id}/datasets/{dataset_id}
GoogleCloudDatalabelingV1beta1ExportDataRequest:
{:annotatedDataset string,
 :filter string,
 :outputConfig
 {:gcsDestination {:outputUri string, :mimeType string},
  :gcsFolderDestination {:outputFolderUri string}},
 :userEmailAddress string}"
  [name GoogleCloudDatalabelingV1beta1ExportDataRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datalabeling.googleapis.com/v1beta1/{+name}:exportData",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDatalabelingV1beta1ExportDataRequest}))

(defn projects-datasets-dataItems-get
  "Gets a data item in a dataset by resource name. This API can be called after data are imported into dataset.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.datasets.dataItems/get

name <string> Required. The name of the data item to get, format: projects/{project_id}/datasets/{dataset_id}/dataItems/{data_item_id}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://datalabeling.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-datasets-dataItems-list
  "Lists data items in a dataset. This API can be called after data are imported into dataset. Pagination is supported.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.datasets.dataItems/list

parent <string> Required. Name of the dataset to list data items, format: projects/{project_id}/datasets/{dataset_id}

optional:
filter <string> Optional. Filter is not supported at this moment.
pageSize <integer> Optional. Requested page size. Server may return fewer results than requested. Default value is 100."
  ([parent] (projects-datasets-dataItems-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datalabeling.googleapis.com/v1beta1/{+parent}/dataItems",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-datasets-annotatedDatasets-get
  "Gets an annotated dataset by resource name.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.datasets.annotatedDatasets/get

name <string> Required. Name of the annotated dataset to get, format: projects/{project_id}/datasets/{dataset_id}/annotatedDatasets/ {annotated_dataset_id}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://datalabeling.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-datasets-annotatedDatasets-list
  "Lists annotated datasets for a dataset. Pagination is supported.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.datasets.annotatedDatasets/list

parent <string> Required. Name of the dataset to list annotated datasets, format: projects/{project_id}/datasets/{dataset_id}

optional:
filter <string> Optional. Filter is not supported at this moment.
pageSize <integer> Optional. Requested page size. Server may return fewer results than requested. Default value is 100."
  ([parent] (projects-datasets-annotatedDatasets-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datalabeling.googleapis.com/v1beta1/{+parent}/annotatedDatasets",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-datasets-annotatedDatasets-delete
  "Deletes an annotated dataset by resource name.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.datasets.annotatedDatasets/delete

name <string> Required. Name of the annotated dataset to delete, format: projects/{project_id}/datasets/{dataset_id}/annotatedDatasets/ {annotated_dataset_id}"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://datalabeling.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-datasets-annotatedDatasets-dataItems-get
  "Gets a data item in a dataset by resource name. This API can be called after data are imported into dataset.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.datasets.annotatedDatasets.dataItems/get

name <string> Required. The name of the data item to get, format: projects/{project_id}/datasets/{dataset_id}/dataItems/{data_item_id}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://datalabeling.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-datasets-annotatedDatasets-dataItems-list
  "Lists data items in a dataset. This API can be called after data are imported into dataset. Pagination is supported.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.datasets.annotatedDatasets.dataItems/list

parent <string> Required. Name of the dataset to list data items, format: projects/{project_id}/datasets/{dataset_id}

optional:
filter <string> Optional. Filter is not supported at this moment.
pageSize <integer> Optional. Requested page size. Server may return fewer results than requested. Default value is 100."
  ([parent]
    (projects-datasets-annotatedDatasets-dataItems-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datalabeling.googleapis.com/v1beta1/{+parent}/dataItems",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-datasets-annotatedDatasets-examples-get
  "Gets an example by resource name, including both data and annotation.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.datasets.annotatedDatasets.examples/get

name <string> Required. Name of example, format: projects/{project_id}/datasets/{dataset_id}/annotatedDatasets/ {annotated_dataset_id}/examples/{example_id}

optional:
filter <string> Optional. An expression for filtering Examples. Filter by annotation_spec.display_name is supported. Format \"annotation_spec.display_name = {display_name}\""
  ([name] (projects-datasets-annotatedDatasets-examples-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datalabeling.googleapis.com/v1beta1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-datasets-annotatedDatasets-examples-list
  "Lists examples in an annotated dataset. Pagination is supported.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.datasets.annotatedDatasets.examples/list

parent <string> Required. Example resource parent.

optional:
filter <string> Optional. An expression for filtering Examples. For annotated datasets that have annotation spec set, filter by annotation_spec.display_name is supported. Format \"annotation_spec.display_name = {display_name}\"
pageSize <integer> Optional. Requested page size. Server may return fewer results than requested. Default value is 100."
  ([parent]
    (projects-datasets-annotatedDatasets-examples-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datalabeling.googleapis.com/v1beta1/{+parent}/examples",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-datasets-annotatedDatasets-feedbackThreads-get
  "Get a FeedbackThread object.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.datasets.annotatedDatasets.feedbackThreads/get

name <string> Required. Name of the feedback. Format: 'projects/{project_id}/datasets/{dataset_id}/annotatedDatasets/{annotated_dataset_id}/feedbackThreads/{feedback_thread_id}'."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://datalabeling.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-datasets-annotatedDatasets-feedbackThreads-list
  "List FeedbackThreads with pagination.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.datasets.annotatedDatasets.feedbackThreads/list

parent <string> Required. FeedbackThread resource parent. Format: \"projects/{project_id}/datasets/{dataset_id}/annotatedDatasets/{annotated_dataset_id}\"

optional:
pageSize <integer> Optional. Requested page size. Server may return fewer results than requested. Default value is 100."
  ([parent]
    (projects-datasets-annotatedDatasets-feedbackThreads-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datalabeling.googleapis.com/v1beta1/{+parent}/feedbackThreads",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-datasets-annotatedDatasets-feedbackThreads-delete
  "Delete a FeedbackThread.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.datasets.annotatedDatasets.feedbackThreads/delete

name <string> Required. Name of the FeedbackThread that is going to be deleted. Format: 'projects/{project_id}/datasets/{dataset_id}/annotatedDatasets/{annotated_dataset_id}/feedbackThreads/{feedback_thread_id}'."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://datalabeling.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-datasets-annotatedDatasets-feedbackThreads-feedbackMessages-create
  "Create a FeedbackMessage object.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.datasets.annotatedDatasets.feedbackThreads.feedbackMessages/create

parent <string> Required. FeedbackMessage resource parent, format: projects/{project_id}/datasets/{dataset_id}/annotatedDatasets/{annotated_dataset_id}/feedbackThreads/{feedback_thread_id}.
GoogleCloudDatalabelingV1beta1FeedbackMessage:
{:requesterFeedbackMetadata object,
 :operatorFeedbackMetadata object,
 :name string,
 :body string,
 :image string,
 :createTime string}"
  [parent GoogleCloudDatalabelingV1beta1FeedbackMessage]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datalabeling.googleapis.com/v1beta1/{+parent}/feedbackMessages",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDatalabelingV1beta1FeedbackMessage}))

(defn projects-datasets-annotatedDatasets-feedbackThreads-feedbackMessages-get
  "Get a FeedbackMessage object.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.datasets.annotatedDatasets.feedbackThreads.feedbackMessages/get

name <string> Required. Name of the feedback. Format: 'projects/{project_id}/datasets/{dataset_id}/annotatedDatasets/{annotated_dataset_id}/feedbackThreads/{feedback_thread_id}/feedbackMessages/{feedback_message_id}'."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://datalabeling.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-datasets-annotatedDatasets-feedbackThreads-feedbackMessages-list
  "List FeedbackMessages with pagination.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.datasets.annotatedDatasets.feedbackThreads.feedbackMessages/list

parent <string> Required. FeedbackMessage resource parent. Format: \"projects/{project_id}/datasets/{dataset_id}/annotatedDatasets/{annotated_dataset_id}/feedbackThreads/{feedback_thread_id}\"

optional:
pageSize <integer> Optional. Requested page size. Server may return fewer results than requested. Default value is 100."
  ([parent]
    (projects-datasets-annotatedDatasets-feedbackThreads-feedbackMessages-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datalabeling.googleapis.com/v1beta1/{+parent}/feedbackMessages",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-datasets-annotatedDatasets-feedbackThreads-feedbackMessages-delete
  "Delete a FeedbackMessage.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.datasets.annotatedDatasets.feedbackThreads.feedbackMessages/delete

name <string> Required. Name of the FeedbackMessage that is going to be deleted. Format: 'projects/{project_id}/datasets/{dataset_id}/annotatedDatasets/{annotated_dataset_id}/feedbackThreads/{feedback_thread_id}/feedbackMessages/{feedback_message_id}'."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://datalabeling.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-datasets-image-label
  "Starts a labeling task for image. The type of image labeling task is configured by feature in the request.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.datasets.image/label

parent <string> Required. Name of the dataset to request labeling task, format: projects/{project_id}/datasets/{dataset_id}
GoogleCloudDatalabelingV1beta1LabelImageRequest:
{:imageClassificationConfig
 {:annotationSpecSet string,
  :allowMultiLabel boolean,
  :answerAggregationType
  [STRING_AGGREGATION_TYPE_UNSPECIFIED
   MAJORITY_VOTE
   UNANIMOUS_VOTE
   NO_AGGREGATION]},
 :boundingPolyConfig
 {:annotationSpecSet string, :instructionMessage string},
 :polylineConfig
 {:annotationSpecSet string, :instructionMessage string},
 :segmentationConfig
 {:annotationSpecSet string, :instructionMessage string},
 :basicConfig
 {:annotatedDatasetDisplayName string,
  :annotatedDatasetDescription string,
  :labelGroup string,
  :languageCode string,
  :userEmailAddress string,
  :contributorEmails [string],
  :replicaCount integer,
  :instruction string,
  :questionDuration string},
 :feature
 [FEATURE_UNSPECIFIED
  CLASSIFICATION
  BOUNDING_BOX
  ORIENTED_BOUNDING_BOX
  BOUNDING_POLY
  POLYLINE
  SEGMENTATION]}"
  [parent GoogleCloudDatalabelingV1beta1LabelImageRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datalabeling.googleapis.com/v1beta1/{+parent}/image:label",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDatalabelingV1beta1LabelImageRequest}))

(defn projects-datasets-video-label
  "Starts a labeling task for video. The type of video labeling task is configured by feature in the request.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.datasets.video/label

parent <string> Required. Name of the dataset to request labeling task, format: projects/{project_id}/datasets/{dataset_id}
GoogleCloudDatalabelingV1beta1LabelVideoRequest:
{:videoClassificationConfig
 {:annotationSpecSetConfigs
  [{:annotationSpecSet string, :allowMultiLabel boolean}],
  :applyShotDetection boolean},
 :objectDetectionConfig
 {:annotationSpecSet string, :extractionFrameRate number},
 :objectTrackingConfig
 {:annotationSpecSet string,
  :clipLength integer,
  :overlapLength integer},
 :eventConfig
 {:annotationSpecSets [string],
  :clipLength integer,
  :overlapLength integer},
 :basicConfig
 {:annotatedDatasetDisplayName string,
  :annotatedDatasetDescription string,
  :labelGroup string,
  :languageCode string,
  :userEmailAddress string,
  :contributorEmails [string],
  :replicaCount integer,
  :instruction string,
  :questionDuration string},
 :feature
 [FEATURE_UNSPECIFIED
  CLASSIFICATION
  OBJECT_DETECTION
  OBJECT_TRACKING
  EVENT]}"
  [parent GoogleCloudDatalabelingV1beta1LabelVideoRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datalabeling.googleapis.com/v1beta1/{+parent}/video:label",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDatalabelingV1beta1LabelVideoRequest}))

(defn projects-datasets-text-label
  "Starts a labeling task for text. The type of text labeling task is configured by feature in the request.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.datasets.text/label

parent <string> Required. Name of the data set to request labeling task, format: projects/{project_id}/datasets/{dataset_id}
GoogleCloudDatalabelingV1beta1LabelTextRequest:
{:textClassificationConfig
 {:allowMultiLabel boolean,
  :annotationSpecSet string,
  :sentimentConfig {:enableLabelSentimentSelection boolean}},
 :textEntityExtractionConfig {:annotationSpecSet string},
 :basicConfig
 {:annotatedDatasetDisplayName string,
  :annotatedDatasetDescription string,
  :labelGroup string,
  :languageCode string,
  :userEmailAddress string,
  :contributorEmails [string],
  :replicaCount integer,
  :instruction string,
  :questionDuration string},
 :feature
 [FEATURE_UNSPECIFIED TEXT_CLASSIFICATION TEXT_ENTITY_EXTRACTION]}"
  [parent GoogleCloudDatalabelingV1beta1LabelTextRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datalabeling.googleapis.com/v1beta1/{+parent}/text:label",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDatalabelingV1beta1LabelTextRequest}))

(defn projects-datasets-evaluations-get
  "Gets an evaluation by resource name (to search, use projects.evaluations.search).
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.datasets.evaluations/get

name <string> Required. Name of the evaluation. Format: \"projects/{project_id}/datasets/ {dataset_id}/evaluations/{evaluation_id}'"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://datalabeling.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-datasets-evaluations-exampleComparisons-search
  "Searches example comparisons from an evaluation. The return format is a list of example comparisons that show ground truth and prediction(s) for a single input. Search by providing an evaluation ID.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.datasets.evaluations.exampleComparisons/search

parent <string> Required. Name of the Evaluation resource to search for example comparisons from. Format: \"projects/{project_id}/datasets/{dataset_id}/evaluations/ {evaluation_id}\"
GoogleCloudDatalabelingV1beta1SearchExampleComparisonsRequest:
{:pageSize integer, :pageToken string}"
  [parent
   GoogleCloudDatalabelingV1beta1SearchExampleComparisonsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datalabeling.googleapis.com/v1beta1/{+parent}/exampleComparisons:search",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudDatalabelingV1beta1SearchExampleComparisonsRequest}))

(defn projects-annotationSpecSets-create
  "Creates an annotation spec set by providing a set of labels.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.annotationSpecSets/create

parent <string> Required. AnnotationSpecSet resource parent, format: projects/{project_id}
GoogleCloudDatalabelingV1beta1CreateAnnotationSpecSetRequest:
{:annotationSpecSet
 {:name string,
  :displayName string,
  :description string,
  :annotationSpecs
  [{:displayName string, :description string, :index integer}],
  :blockingResources [string]}}"
  [parent GoogleCloudDatalabelingV1beta1CreateAnnotationSpecSetRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datalabeling.googleapis.com/v1beta1/{+parent}/annotationSpecSets",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudDatalabelingV1beta1CreateAnnotationSpecSetRequest}))

(defn projects-annotationSpecSets-get
  "Gets an annotation spec set by resource name.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.annotationSpecSets/get

name <string> Required. AnnotationSpecSet resource name, format: projects/{project_id}/annotationSpecSets/{annotation_spec_set_id}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://datalabeling.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-annotationSpecSets-list
  "Lists annotation spec sets for a project. Pagination is supported.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.annotationSpecSets/list

parent <string> Required. Parent of AnnotationSpecSet resource, format: projects/{project_id}

optional:
filter <string> Optional. Filter is not supported at this moment.
pageSize <integer> Optional. Requested page size. Server may return fewer results than requested. Default value is 100."
  ([parent] (projects-annotationSpecSets-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datalabeling.googleapis.com/v1beta1/{+parent}/annotationSpecSets",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-annotationSpecSets-delete
  "Deletes an annotation spec set by resource name.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.annotationSpecSets/delete

name <string> Required. AnnotationSpec resource name, format: `projects/{project_id}/annotationSpecSets/{annotation_spec_set_id}`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://datalabeling.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-instructions-create
  "Creates an instruction for how data should be labeled.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.instructions/create

parent <string> Required. Instruction resource parent, format: projects/{project_id}
GoogleCloudDatalabelingV1beta1CreateInstructionRequest:
{:instruction
 {:description string,
  :pdfInstruction {:gcsFileUri string},
  :displayName string,
  :name string,
  :createTime string,
  :updateTime string,
  :csvInstruction {:gcsFileUri string},
  :dataType [DATA_TYPE_UNSPECIFIED IMAGE VIDEO TEXT GENERAL_DATA],
  :blockingResources [string]}}"
  [parent GoogleCloudDatalabelingV1beta1CreateInstructionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datalabeling.googleapis.com/v1beta1/{+parent}/instructions",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDatalabelingV1beta1CreateInstructionRequest}))

(defn projects-instructions-get
  "Gets an instruction by resource name.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.instructions/get

name <string> Required. Instruction resource name, format: projects/{project_id}/instructions/{instruction_id}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://datalabeling.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-instructions-list
  "Lists instructions for a project. Pagination is supported.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.instructions/list

parent <string> Required. Instruction resource parent, format: projects/{project_id}

optional:
filter <string> Optional. Filter is not supported at this moment.
pageSize <integer> Optional. Requested page size. Server may return fewer results than requested. Default value is 100."
  ([parent] (projects-instructions-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datalabeling.googleapis.com/v1beta1/{+parent}/instructions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-instructions-delete
  "Deletes an instruction object by resource name.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.instructions/delete

name <string> Required. Instruction resource name, format: projects/{project_id}/instructions/{instruction_id}"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://datalabeling.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-evaluations-search
  "Searches evaluations within a project.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.evaluations/search

parent <string> Required. Evaluation search parent (project ID). Format: \"projects/ {project_id}\"

optional:
filter <string> Optional. To search evaluations, you can filter by the following: * evaluation_job.evaluation_job_id (the last part of EvaluationJob.name) * evaluation_job.model_id (the {model_name} portion of EvaluationJob.modelVersion) * evaluation_job.evaluation_job_run_time_start (Minimum threshold for the evaluationJobRunTime that created the evaluation) * evaluation_job.evaluation_job_run_time_end (Maximum threshold for the evaluationJobRunTime that created the evaluation) * evaluation_job.job_state (EvaluationJob.state) * annotation_spec.display_name (the Evaluation contains a metric for the annotation spec with this displayName) To filter by multiple critiera, use the `AND` operator or the `OR` operator. The following examples shows a string that filters by several critiera: \"evaluation_job.evaluation_job_id = {evaluation_job_id} AND evaluation_job.model_id = {model_name} AND evaluation_job.evaluation_job_run_time_start = {timestamp_1} AND evaluation_job.evaluation_job_run_time_end = {timestamp_2} AND annotation_spec.display_name = {display_name}\"
pageSize <integer> Optional. Requested page size. Server may return fewer results than requested. Default value is 100."
  ([parent] (projects-evaluations-search parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datalabeling.googleapis.com/v1beta1/{+parent}/evaluations:search",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-evaluationJobs-create
  "Creates an evaluation job.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.evaluationJobs/create

parent <string> Required. Evaluation job resource parent. Format: \"projects/{project_id}\"
GoogleCloudDatalabelingV1beta1CreateEvaluationJobRequest:
{:job
 {:description string,
  :evaluationJobConfig
  {:boundingPolyConfig
   {:annotationSpecSet string, :instructionMessage string},
   :humanAnnotationConfig
   {:annotatedDatasetDisplayName string,
    :annotatedDatasetDescription string,
    :labelGroup string,
    :languageCode string,
    :userEmailAddress string,
    :contributorEmails [string],
    :replicaCount integer,
    :instruction string,
    :questionDuration string},
   :exampleSamplePercentage number,
   :imageClassificationConfig
   {:annotationSpecSet string,
    :allowMultiLabel boolean,
    :answerAggregationType
    [STRING_AGGREGATION_TYPE_UNSPECIFIED
     MAJORITY_VOTE
     UNANIMOUS_VOTE
     NO_AGGREGATION]},
   :exampleCount integer,
   :bigqueryImportKeys object,
   :evaluationConfig
   {:boundingBoxEvaluationOptions {:iouThreshold number}},
   :evaluationJobAlertConfig
   {:email string, :minAcceptableMeanAveragePrecision number},
   :textClassificationConfig
   {:allowMultiLabel boolean,
    :annotationSpecSet string,
    :sentimentConfig {:enableLabelSentimentSelection boolean}},
   :inputConfig
   {:textMetadata {:languageCode string},
    :gcsSource {:inputUri string, :mimeType string},
    :bigquerySource {:inputUri string},
    :dataType [DATA_TYPE_UNSPECIFIED IMAGE VIDEO TEXT GENERAL_DATA],
    :annotationType
    [ANNOTATION_TYPE_UNSPECIFIED
     IMAGE_CLASSIFICATION_ANNOTATION
     IMAGE_BOUNDING_BOX_ANNOTATION
     IMAGE_ORIENTED_BOUNDING_BOX_ANNOTATION
     IMAGE_BOUNDING_POLY_ANNOTATION
     IMAGE_POLYLINE_ANNOTATION
     IMAGE_SEGMENTATION_ANNOTATION
     VIDEO_SHOTS_CLASSIFICATION_ANNOTATION
     VIDEO_OBJECT_TRACKING_ANNOTATION
     VIDEO_OBJECT_DETECTION_ANNOTATION
     VIDEO_EVENT_ANNOTATION
     TEXT_CLASSIFICATION_ANNOTATION
     TEXT_ENTITY_EXTRACTION_ANNOTATION
     GENERAL_CLASSIFICATION_ANNOTATION],
    :classificationMetadata {:isMultiLabel boolean}}},
  :schedule string,
  :labelMissingGroundTruth boolean,
  :name string,
  :attempts
  [{:attemptTime string,
    :partialFailures
    [{:code integer, :message string, :details [object]}]}],
  :createTime string,
  :state [STATE_UNSPECIFIED SCHEDULED RUNNING PAUSED STOPPED],
  :annotationSpecSet string,
  :modelVersion string}}"
  [parent GoogleCloudDatalabelingV1beta1CreateEvaluationJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datalabeling.googleapis.com/v1beta1/{+parent}/evaluationJobs",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDatalabelingV1beta1CreateEvaluationJobRequest}))

(defn projects-evaluationJobs-patch
  "Updates an evaluation job. You can only update certain fields of the job's EvaluationJobConfig: `humanAnnotationConfig.instruction`, `exampleCount`, and `exampleSamplePercentage`. If you want to change any other aspect of the evaluation job, you must delete the job and create a new one.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.evaluationJobs/patch

name <string> Output only. After you create a job, Data Labeling Service assigns a name to the job with the following format: \"projects/{project_id}/evaluationJobs/ {evaluation_job_id}\"
GoogleCloudDatalabelingV1beta1EvaluationJob:
{:description string,
 :evaluationJobConfig
 {:boundingPolyConfig
  {:annotationSpecSet string, :instructionMessage string},
  :humanAnnotationConfig
  {:annotatedDatasetDisplayName string,
   :annotatedDatasetDescription string,
   :labelGroup string,
   :languageCode string,
   :userEmailAddress string,
   :contributorEmails [string],
   :replicaCount integer,
   :instruction string,
   :questionDuration string},
  :exampleSamplePercentage number,
  :imageClassificationConfig
  {:annotationSpecSet string,
   :allowMultiLabel boolean,
   :answerAggregationType
   [STRING_AGGREGATION_TYPE_UNSPECIFIED
    MAJORITY_VOTE
    UNANIMOUS_VOTE
    NO_AGGREGATION]},
  :exampleCount integer,
  :bigqueryImportKeys object,
  :evaluationConfig
  {:boundingBoxEvaluationOptions {:iouThreshold number}},
  :evaluationJobAlertConfig
  {:email string, :minAcceptableMeanAveragePrecision number},
  :textClassificationConfig
  {:allowMultiLabel boolean,
   :annotationSpecSet string,
   :sentimentConfig {:enableLabelSentimentSelection boolean}},
  :inputConfig
  {:textMetadata {:languageCode string},
   :gcsSource {:inputUri string, :mimeType string},
   :bigquerySource {:inputUri string},
   :dataType [DATA_TYPE_UNSPECIFIED IMAGE VIDEO TEXT GENERAL_DATA],
   :annotationType
   [ANNOTATION_TYPE_UNSPECIFIED
    IMAGE_CLASSIFICATION_ANNOTATION
    IMAGE_BOUNDING_BOX_ANNOTATION
    IMAGE_ORIENTED_BOUNDING_BOX_ANNOTATION
    IMAGE_BOUNDING_POLY_ANNOTATION
    IMAGE_POLYLINE_ANNOTATION
    IMAGE_SEGMENTATION_ANNOTATION
    VIDEO_SHOTS_CLASSIFICATION_ANNOTATION
    VIDEO_OBJECT_TRACKING_ANNOTATION
    VIDEO_OBJECT_DETECTION_ANNOTATION
    VIDEO_EVENT_ANNOTATION
    TEXT_CLASSIFICATION_ANNOTATION
    TEXT_ENTITY_EXTRACTION_ANNOTATION
    GENERAL_CLASSIFICATION_ANNOTATION],
   :classificationMetadata {:isMultiLabel boolean}}},
 :schedule string,
 :labelMissingGroundTruth boolean,
 :name string,
 :attempts
 [{:attemptTime string,
   :partialFailures
   [{:code integer, :message string, :details [object]}]}],
 :createTime string,
 :state [STATE_UNSPECIFIED SCHEDULED RUNNING PAUSED STOPPED],
 :annotationSpecSet string,
 :modelVersion string}

optional:
updateMask <string> Optional. Mask for which fields to update. You can only provide the following fields: * `evaluationJobConfig.humanAnnotationConfig.instruction` * `evaluationJobConfig.exampleCount` * `evaluationJobConfig.exampleSamplePercentage` You can provide more than one of these fields by separating them with commas."
  ([name GoogleCloudDatalabelingV1beta1EvaluationJob]
    (projects-evaluationJobs-patch
      name
      GoogleCloudDatalabelingV1beta1EvaluationJob
      nil))
  ([name GoogleCloudDatalabelingV1beta1EvaluationJob optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://datalabeling.googleapis.com/v1beta1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDatalabelingV1beta1EvaluationJob})))

(defn projects-evaluationJobs-get
  "Gets an evaluation job by resource name.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.evaluationJobs/get

name <string> Required. Name of the evaluation job. Format: \"projects/{project_id} /evaluationJobs/{evaluation_job_id}\""
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://datalabeling.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-evaluationJobs-pause
  "Pauses an evaluation job. Pausing an evaluation job that is already in a `PAUSED` state is a no-op.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.evaluationJobs/pause

name <string> Required. Name of the evaluation job that is going to be paused. Format: \"projects/{project_id}/evaluationJobs/{evaluation_job_id}\"
GoogleCloudDatalabelingV1beta1PauseEvaluationJobRequest:
object"
  [name GoogleCloudDatalabelingV1beta1PauseEvaluationJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datalabeling.googleapis.com/v1beta1/{+name}:pause",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDatalabelingV1beta1PauseEvaluationJobRequest}))

(defn projects-evaluationJobs-resume
  "Resumes a paused evaluation job. A deleted evaluation job can't be resumed. Resuming a running or scheduled evaluation job is a no-op.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.evaluationJobs/resume

name <string> Required. Name of the evaluation job that is going to be resumed. Format: \"projects/{project_id}/evaluationJobs/{evaluation_job_id}\"
GoogleCloudDatalabelingV1beta1ResumeEvaluationJobRequest:
object"
  [name GoogleCloudDatalabelingV1beta1ResumeEvaluationJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datalabeling.googleapis.com/v1beta1/{+name}:resume",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDatalabelingV1beta1ResumeEvaluationJobRequest}))

(defn projects-evaluationJobs-delete
  "Stops and deletes an evaluation job.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.evaluationJobs/delete

name <string> Required. Name of the evaluation job that is going to be deleted. Format: \"projects/{project_id}/evaluationJobs/{evaluation_job_id}\""
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://datalabeling.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-evaluationJobs-list
  "Lists all evaluation jobs within a project with possible filters. Pagination is supported.
https://cloud.google.com/ai-platform/data-labeling/docs/reference/rest/v1beta1/projects.evaluationJobs/list

parent <string> Required. Evaluation job resource parent. Format: \"projects/{project_id}\"

optional:
filter <string> Optional. You can filter the jobs to list by model_id (also known as model_name, as described in EvaluationJob.modelVersion) or by evaluation job state (as described in EvaluationJob.state). To filter by both criteria, use the `AND` operator or the `OR` operator. For example, you can use the following string for your filter: \"evaluation_job.model_id = {model_name} AND evaluation_job.state = {evaluation_job_state}\"
pageSize <integer> Optional. Requested page size. Server may return fewer results than requested. Default value is 100."
  ([parent] (projects-evaluationJobs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datalabeling.googleapis.com/v1beta1/{+parent}/evaluationJobs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

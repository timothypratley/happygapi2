(ns happygapi2.publicca
  "Public Certificate Authority API
The Public Certificate Authority API may be used to create and manage ACME external account binding keys associated with Google Trust Services' publicly trusted certificate authority. 
See: https://cloud.google.com/certificate-manager/docs"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-externalAccountKeys-create
  "Creates a new ExternalAccountKey bound to the project.
https://cloud.google.com/certificate-manager/docs

parent <string> Required. The parent resource where this external_account_key will be created. Format: projects/[project_id]/locations/[location]. At present only the \"global\" location is supported.
ExternalAccountKey:
{:name string, :keyId string, :b64MacKey string}"
  [parent ExternalAccountKey]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://publicca.googleapis.com/v1/{+parent}/externalAccountKeys",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ExternalAccountKey}))

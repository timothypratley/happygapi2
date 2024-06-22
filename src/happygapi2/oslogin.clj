(ns happygapi2.oslogin
  "Cloud OS Login API
You can use OS Login to manage access to your VM instances using IAM roles.
See: https://cloud.google.com/compute/docs/oslogin/"
  (:require [happy.oauth2.client :as client]))

(defn users-getLoginProfile
  "Retrieves the profile information used for logging in to a virtual machine on Google Compute Engine.
https://cloud.google.com/compute/docs/oslogin

name <string> Required. The unique ID for the user in format `users/{user}`.

optional:
projectId <string> The project ID of the Google Cloud Platform project.
systemId <string> A system ID for filtering the results of the request."
  ([name] (users-getLoginProfile name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://oslogin.googleapis.com/v1/{+name}/loginProfile",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/compute"
        "https://www.googleapis.com/auth/compute.readonly"]})))

(defn users-importSshPublicKey
  "Adds an SSH public key and returns the profile information. Default POSIX account information is set when no username and UID exist as part of the login profile.
https://cloud.google.com/compute/docs/oslogin

parent <string> Required. The unique ID for the user in format `users/{user}`.
SshPublicKey:
{:key string,
 :expirationTimeUsec string,
 :fingerprint string,
 :name string}

optional:
projectId <string> The project ID of the Google Cloud Platform project.
regions <string> Optional. The regions to which to assert that the key was written. If unspecified, defaults to all regions. Regions are listed at https://cloud.google.com/about/locations#region."
  ([parent SshPublicKey]
    (users-importSshPublicKey parent SshPublicKey nil))
  ([parent SshPublicKey optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://oslogin.googleapis.com/v1/{+parent}:importSshPublicKey",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/compute"],
       :body SshPublicKey})))

(defn users-sshPublicKeys-create
  "Create an SSH public key
https://cloud.google.com/compute/docs/oslogin

parent <string> Required. The unique ID for the user in format `users/{user}`.
SshPublicKey:
{:key string,
 :expirationTimeUsec string,
 :fingerprint string,
 :name string}"
  [parent SshPublicKey]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://oslogin.googleapis.com/v1/{+parent}/sshPublicKeys",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/compute"],
     :body SshPublicKey}))

(defn users-sshPublicKeys-delete
  "Deletes an SSH public key.
https://cloud.google.com/compute/docs/oslogin

name <string> Required. The fingerprint of the public key to update. Public keys are identified by their SHA-256 fingerprint. The fingerprint of the public key is in format `users/{user}/sshPublicKeys/{fingerprint}`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://oslogin.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/compute"]}))

(defn users-sshPublicKeys-get
  "Retrieves an SSH public key.
https://cloud.google.com/compute/docs/oslogin

name <string> Required. The fingerprint of the public key to retrieve. Public keys are identified by their SHA-256 fingerprint. The fingerprint of the public key is in format `users/{user}/sshPublicKeys/{fingerprint}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://oslogin.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/compute"]}))

(defn users-sshPublicKeys-patch
  "Updates an SSH public key and returns the profile information. This method supports patch semantics.
https://cloud.google.com/compute/docs/oslogin

name <string> Required. The fingerprint of the public key to update. Public keys are identified by their SHA-256 fingerprint. The fingerprint of the public key is in format `users/{user}/sshPublicKeys/{fingerprint}`.
SshPublicKey:
{:key string,
 :expirationTimeUsec string,
 :fingerprint string,
 :name string}

optional:
updateMask <string> Mask to control which fields get updated. Updates all if not present."
  ([name SshPublicKey]
    (users-sshPublicKeys-patch name SshPublicKey nil))
  ([name SshPublicKey optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://oslogin.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/compute"],
       :body SshPublicKey})))

(defn users-projects-delete
  "Deletes a POSIX account.
https://cloud.google.com/compute/docs/oslogin

name <string> Required. A reference to the POSIX account to update. POSIX accounts are identified by the project ID they are associated with. A reference to the POSIX account is in format `users/{user}/projects/{project}`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://oslogin.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/compute"]}))

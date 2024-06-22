(ns happygapi2.merchantapi
  "Merchant API
Programmatically manage your Merchant Center Accounts.
See: https://login.corp.google.com/request?s=developers.devsite.corp.google.com:443/uberproxy/&d=https://developers.devsite.corp.google.com/merchant/api%3Fupxsrf%3DAFIFSXPEHHQ09pe0Qub4VTCPiXzIznHAH7kaygFmp0g-wry9pQ:1719022800012&maxAge=1200&authLevel=2000000&keyIds=DU5,2O9&3pd=1&c=1"
  (:require [happy.oauth2.client :as client]))

(defn accounts-reports-search
  "Retrieves a report defined by a search query. The response might contain fewer rows than specified by `page_size`. Rely on `next_page_token` to determine if there are more rows to be requested.
https://login.corp.google.com/request?s=developers.devsite.corp.google.com:443/uberproxy/&d=https://developers.devsite.corp.google.com/merchant/api%3Fupxsrf%3DAFIFSXPEHHQ09pe0Qub4VTCPiXzIznHAH7kaygFmp0g-wry9pQ:1719022800012&maxAge=1200&authLevel=2000000&keyIds=DU5,2O9&3pd=1&c=1/reports_v1beta/docs/accounts/reports/search

parent <string> Required. Id of the account making the call. Must be a standalone account or an MCA subaccount. Format: accounts/{account}
SearchRequest:
{:query string, :pageSize integer, :pageToken string}"
  [parent SearchRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://merchantapi.googleapis.com/reports/v1beta/{+parent}/reports:search",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/content"],
     :body SearchRequest}))

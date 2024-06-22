(ns happygapi2.pagespeedonline
  "PageSpeed Insights API
The PageSpeed Insights API lets you analyze the performance of your website with a simple API. It offers tailored suggestions for how you can optimize your site, and lets you easily integrate PageSpeed Insights analysis into your development tools and workflow. 
See: https://developers.google.com/speed/docs/insights/v5/about"
  (:require [happy.oauth2.client :as client]))

(defn pagespeedapi-runpagespeed
  "Runs PageSpeed analysis on the page at the specified URL, and returns PageSpeed scores, a list of suggestions to make that page faster, and other information.
https://developers.google.com/speed/docs/insights/v5/about

url <string> Required. The URL to fetch and analyze

optional:
category <string> A Lighthouse category to run; if none are given, only Performance category will be run
locale <string> The locale used to localize formatted results
strategy <string> The analysis strategy (desktop or mobile) to use, and desktop is the default
utm_campaign <string> Campaign name for analytics.
utm_source <string> Campaign source for analytics.
captchaToken <string> The captcha token passed when filling out a captcha."
  ([url] (pagespeedapi-runpagespeed url nil))
  ([url optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://pagespeedonline.googleapis.com/pagespeedonline/v5/runPagespeed",
       :uri-template-args {},
       :query-params (merge {:url url} optional),
       :scopes ["openid"]})))

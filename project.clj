(def project-id "YOUR-PROJECT-ID")
(def app-version "v1")
(def location-id "us-central")

;; TODO(alpeware): fix version 64
(def sdk-version "1.9.63")

(defproject jaq-example "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :local-repo ".m2"

  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.9.946"]

                 [ring/ring-defaults "0.3.2"]
                 [com.alpeware/jaq-services "0.1.0-SNAPSHOT"]

                 [com.google.appengine/appengine-api-1.0-sdk ~sdk-version]
                 [com.google.appengine/appengine-api-labs ~sdk-version]
                 [com.google.appengine/appengine-remote-api ~sdk-version]
                 [com.google.appengine/appengine-tools-sdk ~sdk-version]]

  :plugins [[com.alpeware/lein-jaq "0.1.0-SNAPSHOT"]]

  :ring {:handler jaq.core/app
         :init jaq.core/init
         :destroy jaq.core/destroy
         :web-xml "war-resources/web.xml"}

  :jaq {:sdk-path "sdk"
        :sdk-version ~sdk-version
        :war-app-path "war"
        :generated-dir "data"
        :default-gcs-bucket ~(str "staging." project-id ".appspot.com")
        :address "0.0.0.0"
        :port 3000
        :project-id ~project-id
        :project-name ~project-id
        :location-id ~location-id
        :service :default
        :code-bucket ~(str "staging." project-id ".appspot.com")
        :code-prefix ~(str "apps/" app-version)
        :version ~app-version})

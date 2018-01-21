(def sdk-version "1.9.60")

(defproject jaq-test "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :local-repo ".m2"

  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.9.946"]

                 [com.alpeware/jaq-services "0.1.0-SNAPSHOT"]
                 [com.alpeware/jaq-runtime "0.1.0-SNAPSHOT"]

                 [com.google.appengine/appengine-api-1.0-sdk ~sdk-version]
                 [com.google.appengine/appengine-api-labs ~sdk-version]
                 [com.google.appengine/appengine-remote-api ~sdk-version]
                 [com.google.appengine/appengine-tools-sdk ~sdk-version]]

  :plugins [[com.alpeware/lein-jaq "0.1.0-SNAPSHOT"]]

  :ring {:handler jaq.runtime/app
         :init jaq.runtime/init
         :destroy jaq.runtime/destroy
         :web-xml "war-resources/web.xml"}

  :jaq {:sdk-path "sdk"
        :sdk-version ~sdk-version
        :war-app-path "war"
        :generated-dir "data"
        :default-gcs-bucket "staging.alpeware-foo-bar.appspot.com"
        :address "0.0.0.0"
        :port 3000
        :project-id "alpeware-foo-bar"
        :project-name "projects/alpeware-foo-bar"
        :location-id "europe-west3"
        :bucket "staging.alpeware-foo-bar.appspot.com"
        :prefix "apps/v3"
        :version "v3"})

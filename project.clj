(def sdk-version "1.9.59")

(defproject jaq-test "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :local-repo ".m2"

  :dependencies [[org.clojure/clojure "1.9.0"]
                 [com.alpeware/jaq-services "0.1.0-SNAPSHOT"]
                 [ring/ring "1.6.3"]]

  :plugins [[com.alpeware/lein-jaq "0.1.0-SNAPSHOT"]]

  :ring {:handler jaq-test.core/handler
         :init jaq-test.core/init
         :destroy jaq-test.core/destroy
         :web-xml "war-resources/web.xml"}

  :jaq {:sdk-path "sdk"
        :sdk-version ~sdk-version
        :war-app-path "war"
        :generated-dir "data"
        :default-gcs-bucket "staging.clojure-meetup-amsterdam.appspot.com"
        :address "0.0.0.0"
        :port 3000
        :project-id "clojure-meetup-amsterdam"
        :project-name "Clojure Meetup Amsterdam"
        :location-id "europe-west3"
        :bucket "staging.clojure-meetup-amsterdam.appspot.com"
        :prefix "apps/latest"
        :version "v1"})

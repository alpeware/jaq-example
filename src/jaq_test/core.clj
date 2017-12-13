(ns jaq-test.core
  (:require
   [ring.util.response :as response]
   [ring.util.servlet :refer [defservice]]
   [jaq.services.util :refer [remote! repl-server]]))

(defn handler [request]
  (-> (response/response "Hello World")
      (response/content-type "text/plain")))

(defn init []
  (repl-server))

(defn destroy [])

(defservice handler)

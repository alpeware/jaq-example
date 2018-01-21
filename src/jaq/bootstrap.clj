(ns jaq.bootstrap
  (:require
   [ring.util.response :as response]
   [jaq.runtime :refer [listener-fn]]
   [jaq.services.util :refer [remote! repl-server]]))

(defmethod listener-fn :init [_]
  (repl-server))

(defmethod listener-fn :destroy [_])

(defn handler [request]
  (println request)
  (-> (response/response "foo")
      (response/content-type "text/plain")))

(intern 'jaq.runtime 'handler handler)

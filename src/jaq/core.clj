(ns jaq.core
  (:require
   [jaq.services.util :refer [repl-server]]
   [jaq.services.deferred :refer [defer defer-fn]]
   [ring.util.response :as response]
   [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
	 [ring.middleware.resource :refer [wrap-resource]]
   [ring.util.servlet :refer [defservice]]))

(defn remote! [& [host port]]
	(let [host (or host "localhost")
				port (or port 3000)]
		(try
			(-> (com.google.appengine.tools.remoteapi.RemoteApiInstaller.)
					(.install (-> (com.google.appengine.tools.remoteapi.RemoteApiOptions.)
												(.server host port)
												(.useDevelopmentServerCredential))))
			(catch IllegalStateException e e))))

(defn init []
  (println ::init)
  (repl-server))

(defn destroy []
  (println ::destroy))

(defn handler [request]
  (println request)
	(-> (response/response "foo")
			(response/content-type "text/plain")))

(def app
  (-> #'handler
      (wrap-defaults site-defaults)))

(defservice app)

#_(

;;; a few examples for the REPL

;;; defer work to default task queue

(defmethod defer-fn ::slurp [{:keys [url]}]
  (println "slurping " url)
  (slurp url))

;;; schedule the task 
(defer {:fn ::slurp :url "https://alpeware.com"})

;;; TODO(alpeware): add more examples

)

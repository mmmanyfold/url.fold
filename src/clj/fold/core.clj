(ns fold.core
  (:require [org.httpkit.server :refer [run-server]]
            [reitit.ring :as ring]))

(defonce PORT 4000)

(defonce server (atom nil))

(defn stop-server []
  (when-not (nil? @server)
    (@server :timeout 100)
    (reset! server nil)))

(def app
  (ring/ring-handler
    (ring/router
      [["/api"
        {:get
         (fn [req]
           {:status 200
            :body   "it worked!"})}]])))

(defn -main []
  (printf "server running on port %s\n", PORT)
  (reset! server (run-server app {:port PORT})))

(comment
  @server
  (stop-server))

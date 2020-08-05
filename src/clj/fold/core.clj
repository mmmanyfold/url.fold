(ns fold.core
  (:require [org.httpkit.server :refer [run-server]]
            [reitit.ring :as ring]))

(defonce PORT 4000)

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
  (run-server app {:port PORT}))

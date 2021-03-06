(ns nextbus.web
  (:require [compojure.core :refer [defroutes]]
            [ring.adapter.jetty :as ring]
            [compojure.route :as route]
            [clojure.core.cache :as cache]
            [compojure.handler :as handler]
            [nextbus.controllers.departures :as departures]
            [nextbus.views.layout :as layout])
  (:gen-class))

(defroutes routes
  departures/routes
  (route/resources "/")
  (route/not-found (layout/four-oh-four)))

(def application (handler/site routes))

(defn start [port]
  (ring/run-jetty application {:port port
                               :join? false}))

(defn -main []
  (let [port (Integer. (or (System/getenv "PORT") "8080"))]
    (start port)))
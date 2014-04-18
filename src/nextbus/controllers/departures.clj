(ns nextbus.controllers.departures
  (:require
    [compojure.core :refer [defroutes GET]]
    [nextbus.views.departures :as view]
    [nextbus.models.departure :as model]))

(defn index [site-id]
  (view/index (model/all site-id)))

(defroutes routes
	(GET "/" [] (index :1204))
  (GET "/:site-id" [site-id] (index (keyword site-id))))
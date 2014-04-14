(ns nextbus.controllers.departures
  (:require
    [compojure.core :refer [defroutes GET ANY]]
    [clojure.string :as str]
    [ring.util.response :as ring]
    [nextbus.views.departures :as view]
    [nextbus.models.departure :as model]))

(defn index []
  (view/index (model/all)))

(defroutes routes
  (GET "/" [] index))
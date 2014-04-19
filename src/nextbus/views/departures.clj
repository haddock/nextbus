(ns nextbus.views.departures
	(:require [nextbus.views.layout :as layout]
		[hiccup.core :refer [h]]))

(defn display-departures [departures]
	[:div {:class "row"}	
	(map (fn [destination]  
		[:div {:class "col-sm-4"}
		[:div {:class "panel panel-primary"}
	  [:div {:class "panel-heading"}
	  [:h3 {:class "panel-title"} (clojure.string/upper-case (str (:LineNumber (first (get departures destination))) " MOT " destination))]]
	  [:div {:class "panel-body"}	   
		
		 (map
		 	(fn [departure] [:h3 (h (:DisplayTime departure))])
		 	(take 3 (get departures destination)))
		 ]]])
		(keys departures))])

(defn index [departures]
	(let [stop-name (clojure.string/upper-case (:StopAreaName (first (second (first departures)))))]
	(layout/common (str "NÄSTA BUSS FRÅN " stop-name)
		[:div {:class "page-header"} [:h1 stop-name]]
		 (display-departures departures))))
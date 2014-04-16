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
	(layout/common "NÄSTA BUSS FRÅN KUNGSHOLMS KYRKA"
		[:div {:class "page-header"}
     [:h1 "KUNGSHOLMS KYRKA"]]
		 (display-departures departures)))
(ns nextbus.views.departures
	(:require [nextbus.views.layout :as layout]
		[hiccup.core :refer [h]]))

(defn display-departures [departures]
	[:div {:class "panel panel-primary"}
     [:div {:class "panel-heading"}
       [:h3 {:class "panel-title"} "BUSS 3 MOT SÖDERSJUKHUSET"]]
     	 [:div {:class "panel-body"}
			   [:div
	 (map
	 	(fn [departure] [:h3 (h (:DisplayTime departure))])
	 	(get departures "Södersjukhuset"))]]])

(defn index [departures]
	(layout/common "NÄSTA BUSS FRÅN KUNGSHOLMS KYRKA"
		[:div {:class "page-header"}
     [:h1 "KUNGSHOLMS KYRKA"]]
		 (display-departures departures)))
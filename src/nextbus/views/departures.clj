(ns nextbus.views.departures
	(:require [nextbus.views.layout :as layout]
		[hiccup.core :refer [h]]))

(defn display-departures [departures]
	[:div {:class "panel panel-primary"}
     [:div {:class "panel-heading"}
       [:h3 {:class "panel-title"} "BUSS 3 MOT SÖDERSJUKHUSET"]]
     	 [:div {:class "panel-body"}
			   [:div {:class "departures"}
	 (map
	 	(fn [departure] [:h3 {:class "departure"} (h (:DisplayTime departure))])
	 	(get departures "Södersjukhuset"))]]])

(defn index [departures]
	(layout/common "NÄSTA BUSS"
		[:div {:class "page-header"}
     [:h1 "NÄSTA BUSS FRÅN KUNGSHOLMS KYRKA"]]
		 (display-departures departures)))
(ns nextbus.views.departures
	(:require [nextbus.views.layout :as layout]
		[hiccup.core :refer [h]]))

(defn display-departures [departures]
	[:div {:class "departures"}
	 (map
	 	(fn [departure] [:h4 {:class "departure"} (h (:estimated departure))])
	 	departures)])

(defn index [departures]
	(layout/common "NÄSTA BUSS"
		[:div {:class "page-header"}
     [:h1 "NÄSTA BUSS FRÅN KUNGSHOLMS KYRKA"]]
    [:div {:class "panel panel-primary"}
     [:div {:class "panel-heading"}
       [:h3 {:class "panel-title"} "BUSS 3 MOT SKANSTULL"]]
     [:div {:class "panel-body"}
		 (display-departures departures)]]))
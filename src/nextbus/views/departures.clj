(ns nextbus.views.departures
	(:require [nextbus.views.layout :as layout]
		[hiccup.core :refer [h]]))

(defn display-departures [departures]
	[:div {:class "departures"}
	 (map
	 	(fn [departure] [:h2 {:class "departure"} (h (:body departure))])
	 	departures)])

(defn index [departures]
	(layout/common "NÄSTA BUSS"
		[:div {:id "header" :class "page-header"}
     [:h1 "NÄSTA BUSS"]]
		(display-departures departures)))
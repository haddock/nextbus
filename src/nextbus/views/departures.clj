(ns nextbus.views.departures
	(:require [nextbus.views.layout :as layout]
		[hiccup.core :refer [h]]))

(defn display-departures [departures]
	[:div {:class "nextbus sixteen columns alpha omega"}
	 (map
	 	(fn [departure] [:h2 {:class "departure"} (h (:body departure))])
	 	departures)])

(defn index [departures]
	(layout/common "NEXTBUS"
		(display-departures departures)))
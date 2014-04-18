(ns nextbus.models.departure
	(:require [org.httpkit.client :as http]
						[clojure.core.cache :as cache]
						[clojure.data.json :as json]))

(def ttl-cache (atom (cache/ttl-cache-factory {} :ttl 29000)))

(defn hit-or-miss [c k v]
  (if (cache/has? c k)
    (cache/hit c k)
    (cache/miss c k v)))  

(defn data-from-sl [site-id]
	(let [{:keys [status headers body error] :as resp} @(http/get (str "https://api.trafiklab.se/sl/realtid2/GetAllDepartureTypes.json/" (name site-id) "/30?key=HDefrbKfMrC0mdm1MEuoaziRZT4h01Kk"))]
  	(if error
    	(println "Failed, exception: " error)
    	body)))

(defn all [site-id]
	(println site-id)
	(if (cache/has? @ttl-cache site-id)
		(site-id @ttl-cache)
		(site-id (swap! ttl-cache hit-or-miss site-id (group-by :Destination (:Buses (into {} (json/read-json (data-from-sl site-id)))))))))


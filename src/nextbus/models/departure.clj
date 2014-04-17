(ns nextbus.models.departure
	(:require [org.httpkit.client :as http]
						[clojure.core.cache :as cache]
						[clojure.data.json :as json]))

(def ttl-cache (atom (cache/ttl-cache-factory {} :ttl 29000)))

(defn hit-or-miss [c k v]
  (if (cache/has? c k)
    (cache/hit c k)
    (cache/miss c k v)))  

(defn data-from-sl []
	(println "hämtar data....")
	(let [{:keys [status headers body error] :as resp} @(http/get "https://api.trafiklab.se/sl/realtid2/GetAllDepartureTypes.json/1204/30?key=HDefrbKfMrC0mdm1MEuoaziRZT4h01Kk")]
  	(if error
    	(println "Failed, exception: " error)
    	body)))

(defn all []
	(if (cache/has? @ttl-cache :1024)
		(:1024 @ttl-cache)
		(:1024 (swap! ttl-cache hit-or-miss :1024 (group-by :Destination (:Buses (into {} (json/read-json (data-from-sl)))))))))


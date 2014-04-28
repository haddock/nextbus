(ns nextbus.models.departure
	(:require [org.httpkit.client :as http]
						[clojure.core.cache :as cache]
						[clojure.data.json :as json]))

(def ttl-cache (atom (cache/ttl-cache-factory {} :ttl 29000)))

(defn api-url [site-id api-key]
	(str "https://api.trafiklab.se/sl/realtid2/GetAllDepartureTypes.json/" site-id "/30?key=" api-key))

(defn hit-or-miss [c k v]
  (if (cache/has? c k)
    (cache/hit c k)
    (cache/miss c k v)))  

(defn raw-data-from-sl [site-id]
	(let [{:keys [body error] :as resp} @(http/get (api-url site-id (System/getenv "SL_API_KEY")))]
  	(if error
    	(println "Failed, exception: " error)
    	(json/read-json body))))

(defn bus-data-from-sl [site-id]
	(group-by :Destination (:Buses (into {} (raw-data-from-sl site-id)))))

(defn bus-data [site-id]
	(if (cache/has? @ttl-cache site-id)
		(site-id @ttl-cache)
		(site-id (swap! ttl-cache hit-or-miss site-id (bus-data-from-sl (name site-id))))))
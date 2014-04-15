(ns nextbus.models.departure
	(:require [org.httpkit.client :as http]
						[clojure.data.json :as json]))

(defn data-from-sl []
	(let [{:keys [status headers body error] :as resp} @(http/get "https://api.trafiklab.se/sl/realtid2/GetAllDepartureTypes.json/1204/30?key=HDefrbKfMrC0mdm1MEuoaziRZT4h01Kk")]
  	(if error
    	(println "Failed, exception: " error)
    	body)))

(defn all []
	(group-by :Destination (:Buses (into {} (json/read-json (data-from-sl))))))
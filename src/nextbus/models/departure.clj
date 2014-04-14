(ns nextbus.models.departure
	(:require [org.httpkit.client :as http]
						[clojure.data.json :as json]))

;;(defn all []
;;	[{:id 1, :bus_nr "3", :from_station "Kungsholms Kyrka", :to_station "Skanstull", :estimated "nu", :created_at "2014-04-14"}
;;	 {:id 2, :bus_nr "3", :from_station "Kungsholms Kyrka", :to_station "Skanstull", :estimated "om 3 minuter", :created_at "2014-04-14"}])

(defn all []
	(let [{:keys [status headers body error] :as resp} @(http/get "https://api.trafiklab.se/sl/realtid2/GetAllDepartureTypes.json/1204/10?key=HDefrbKfMrC0mdm1MEuoaziRZT4h01Kk")]
  	(if error
    	(println "Failed, exception: " error)
    	(println "Response: " resp))))

(defn departures-from-response [response]
	(println (json/read-str response)))
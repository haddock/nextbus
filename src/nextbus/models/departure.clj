(ns nextbus.models.departure
	(:require [clojure.java.jdbc :as sql]))

(def spec (or (System/getenv "DATABASE_URL")
							"postgresql://localhost:5432/nextbus"))

(defn all []
	(into [] (sql/query spec ["select * from departures order by id desc"])))
(ns nextbus.models.migration
	(:require [clojure.java.jdbc :as sql]
		[nextbus.models.departure :as departure]))

(defn migrated? []
	(-> (sql/query departure/spec
									[(str "select count(*) from information_schema.tables where table_name='departures'")])
	first :count pos?))

(defn migrate []
	(when (not (migrated?))
		(print "Creating database structure...") (flush)
		(sql/db-do-commands departure/spec
												(sql/create-table-ddl
													:departures
													[:id :serial "PRIMARY KEY"]
													[:bus_nr :varchar "NOT NULL"]
													[:from_station :varchar "NOT NULL"]
													[:to_station :varchar "NOT NULL"]
													[:estimated :varchar "NOT NULL"]
													[:created_at :timestamp "NOT NULL" "DEFAULT CURRENT_TIMESTAMP"]))
		(println " done")))
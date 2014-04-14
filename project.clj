(defproject nextbus "0.0.1"
  :description "When is the next bus leaving?"
  :url "https://github.com/haddock/nextbus"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/java.jdbc "0.3.2"]
                 [http-kit "2.1.16"]
                 [org.clojure/data.json "0.2.4"]
                 [ring/ring-jetty-adapter "1.2.1"]
                 [compojure "1.1.6"]
                 [hiccup "1.0.4"]]
  :min-lein-version "2.0.0"
  :main ^:skip-aot nextbus.web
  :plugins [[lein-ring "0.8.10"]]
  :ring {:handler nextbus.web/application}
  :profiles {:uberjar {:aot :all}})
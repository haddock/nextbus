(defproject nextbus "0.0.1"
  :description "When is the next bus leaving?"
  :url "https://github.com/haddock/nextbus"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/java.jdbc "0.3.2"]
                 [compojure "1.1.6"]
                 [ring/ring-jetty-adapter "1.1.0"]
                 [ring/ring-devel "1.1.0"]
                 [ring-basic-authentication "1.0.1"]
                 [environ "0.2.1"]
                 [com.cemerick/drawbridge "0.0.6"]
                 [postgresql "9.1-901.jdbc4"]
                 [hiccup "1.0.4"]]
  :min-lein-version "2.0.0"
  :main ^:skip-aot nextbus.web
  :plugins [[environ/environ.lein "0.2.1"]]
  :hooks [environ.leiningen.hooks]
  :profiles {:production {:env {:production true}}})

(ns nextbus.views.layout
	(:require [hiccup.page :as h]))

(defn common [title & body]
  (h/html5
   [:head
    [:meta {:charset "utf-8"}]
    [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge,chrome=1"}]
    [:meta {:name "viewport" :content
            "width=device-width, initial-scale=1"}]
    [:title title]
    (h/include-css "//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"
                 "//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css")
    (h/include-js "//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js")]
   [:body
    [:div {:id "content" :class "container theme-showcase"} body]
    (h/include-js "https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js")]))

(defn four-oh-four []
  (common "Page Not Found"
  				[:div {:id "header" :class "page-header"}
     				[:h1 "404"]]
          [:div {:id "four-oh-four" :class "alert alert-danger"}
           "The page you requested could not be found"]))
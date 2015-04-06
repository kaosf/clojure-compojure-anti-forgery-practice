(ns greet.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (POST "/post_name" [first_name last_name]
        (format "Hello, %s %s" first_name last_name))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))

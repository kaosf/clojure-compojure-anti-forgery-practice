(ns greet.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.util.anti-forgery :refer [anti-forgery-field]]))

(defroutes app-routes
  (GET "/" [] "Hello World")
           (GET "/greet.html" []
                (str
"<!DOCTYPE html>
 <html>
   <head>
   </head>
   <body>
     <form method=\"post\" action=\"post_name\">
       <table>
         <tr>
           <td>First Name:</td>
           <td><input name=\"first_name\" type=\"text\" value=\"\" /></td>
         </tr>
         <tr>
           <td>Last Name:</td>
           <td><input name=\"last_name\" type=\"text\" value=\"\" /></td>
         </tr>
       </table>
       <div><input id=\"greet_button\" type=\"submit\" value=\"Greet\" /></div>
"
(anti-forgery-field)
"
       </form>
     <div id=\"greeting_area\"></div><br/>
   </body>
 </html>"))
  (POST "/post_name" [first_name last_name]
        (format "Hello, %s %s" first_name last_name))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))

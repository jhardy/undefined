(ns undefined.handler
  (:use compojure.core
        ring.middleware.resource
        ring.middleware.file-info
        hiccup.middleware)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.util.response :as resp]
            [clojure.data.json :as json]
            [clojure.java.io :as io]
            [undefined.models.member :as member]
            [undefined.models.meetup :as meetup]))

(defn json-response [data]
  {:status 200
   :headers {"Content-Type" "application/json"}
   :body (json/write-str data)})

(defroutes api-routes
  (GET "/members.json" [] (json-response member/all))
  (GET "/meetups.json" [] (json-response meetup/all)))

(defroutes app-routes
  (context "/api" [] api-routes)

  (route/resources "/")

  ;; HACK: tomcat6 seems to have a problem with using (io/resource ...) as it
  ;; ends up serving the file as text/plain. This forces the appropriate
  ;; response.
  (GET "/*" []
    {:status 200
     :headers {"Content-Type" "text/html"}
     :body (slurp (io/resource "public/index.html"))})

  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

(def war-handler
  (-> app
    (wrap-resource "public")
    (wrap-base-url)
    (wrap-file-info)))

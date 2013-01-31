(ns undefined.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.util.response :as resp]
            [clojure.data.json :as json]
            [undefined.models.member :as member]))

(defn json-response [data]
  {:status 200
   :headers {"Content-Type" "application/json"}
   :body (json/write-str data)})

(defroutes api-routes
  (GET "/members.json" []
    (json-response member/all)))

(defroutes app-routes
  ;; SEE: api-routes
  (context "/api" [] api-routes)

  (GET "/" []
    (resp/resource-response "index.html" {:root "public"}))

  (route/resources "/")

  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

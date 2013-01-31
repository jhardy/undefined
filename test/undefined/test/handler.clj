(ns undefined.test.handler
  (:use clojure.test
        ring.mock.request
        undefined.handler))

(deftest test-app
  (testing "main route"
    (let [response (app (request :get "/"))]
      (is (= (:status response) 200))
      (is (= (type (:body response)) java.io.File))))

  (testing "not-found route"
    (let [response (app (request :get "/invalid"))]
      (is (= (:status response) 404)))))

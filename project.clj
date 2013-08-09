(defproject undefined "0.0.1"
  :description "Website for Undefined."
  :url "http://undef.in/ed"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.clojure/data.json "0.2.1"]
                 [compojure "1.1.5"]
                 [hiccup "1.0.2"]
                 [clj-time "0.4.4"]]
  :plugins [[lein-ring "0.8.6"]]
  :source-paths ["src/clj"]
  :ring {:handler undefined.handler/app}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.3"]]
         :ring {:nrepl {:start? true}}}})

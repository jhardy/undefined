(ns undefined.models.meetup
  (:use [clj-time.core :only [date-time]])
  (:require [undefined.models.member :as member]))

(def all
  [{:title "Meetup"
    :description "We haven't had a meeting for a while. Time to meet and discuss what we have been up to."
    :slides nil
    :date (str (date-time 2013 8 13 19))
    :location {:name "Bitwise"
               :map "https://maps.google.com/maps?q=fresno+hashtag&ie=UTF-8&ei=6GD0UN7ZOOHf2QWDooHgDg&ved=0CAsQ_AUoAA"}
    :speakers (member/find-by-name "")}
  {:title "Using Clojure"
    :description "Clojure is a dynamic, functional programming language built for concurrency and runs on the JVM. It is an incredibly well designed language and emphasizes practicality and simplicity. Joel discusses the rational behind the language, motivations for using it, and how to get started."
    :slides nil
    :date (str (date-time 2013 2 13 19))
    :location {:name "The Hash Tag"
               :map "https://maps.google.com/maps?q=fresno+hashtag&ie=UTF-8&ei=6GD0UN7ZOOHf2QWDooHgDg&ved=0CAsQ_AUoAA"}
    :speakers (member/find-by-name "Joel Holdbrooks")}
   {:title "Hacking with Vim"
    :description "Justin and Joel discuss one of the oldest and most powerful text editors available today - Vim. Discover the history, philosophy, and potential behind this amazing editor."
    :slides nil
    :date (str (date-time 2013 1 16 19))
    :location {:name "The Hash Tag"
               :map "https://maps.google.com/maps?q=fresno+hashtag&ie=UTF-8&ei=6GD0UN7ZOOHf2QWDooHgDg&ved=0CAsQ_AUoAA"}
    :speakers (member/find-by-name "Justin Gable" "Joel Holdbrooks")}])


(ns undefined.models.member)

(def all
  [{:name "Joel Holdbrooks"
    :gravatar "a212b1b5a546c274ae1b67f380cc922e"
    :twitter "noprompt"
    :github "noprompt"
    :dribbble "noprompt"
    :founder true}
   {:name "Jared Hardy"
    :gravatar "08a2bc1ddfd19efd69cb92167b0fe52a"
    :twitter "jaredhardy"
    :github "jhardy"
    :dribbble "jaredhardy"
    :founder true}
   {:name "Justin Gable"
    :gravatar "8b061213cb0dae8e5756a81405edd027"
    :twitter "justgable"
    :github "justgable"
    :dribbble nil
    :founder true}
   {:name "Andres Lopez"
    :gravatar "1216d58307df4db6d8fe518ebcc7a024"
    :twitter "lopeza511"
    :github "lopeza511"
    :dribbble nil
    :founder true}
   {:name "Sebastian Dieser"
    :gravatar "292d6f35cb23cb12caa6e6b8682be2ef"
    :twitter "SebastianDieser"
    :github "davier26"
    :dribbble "davier26"
    :founder true}
   {:name "Derek Payton"
    :gravatar "59204aa09b2f2f85f16663a525ff198a"
    :twitter "dmpayton"
    :github "dmpayton"
    :dribbble nil
    :founder false}])

(defn find-by-name
  ([name]
    (filter #(= name (:name %)) all))
  ([name & more]
   (mapcat find-by-name (cons name more))))

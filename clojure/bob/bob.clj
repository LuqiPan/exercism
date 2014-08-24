(ns bob
  (require [clojure.string :as s]))

(defn response-for
  [msg]
  (cond
    (s/blank? msg) "Fine. Be that way!"
    (and (= (s/upper-case msg) msg)
         (some? (re-seq #"[a-zA-Z]" msg))) "Woah, chill out!"
    (= (last msg) \?) "Sure."
    :else "Whatever."))

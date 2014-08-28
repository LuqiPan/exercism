(ns bob
  (require [clojure.string :as s]))

(defn letters-all-upcase?
  [msg]
  (and (= (s/upper-case msg) msg)
       (some? (re-seq #"[a-zA-Z]" msg))))

(defn response-for
  [msg]
  (cond
    (s/blank? msg) "Fine. Be that way!"
    (letters-all-upcase? msg) "Woah, chill out!"
    (= (last msg) \?) "Sure."
    :else "Whatever."))

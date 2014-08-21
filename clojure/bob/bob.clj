(ns bob)

(defn response-for
  [sentence]
  (cond
    (clojure.string/blank? sentence) "Fine. Be that way!"
    (= (clojure.string/upper-case sentence) sentence) "Woah, chill out!"
    (= (last sentence) \?) "Sure."
    :else "Whatever."))

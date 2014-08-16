(ns bob)

(defn response-for
  [sentence]
  (if (clojure.string/blank? sentence)
    "Fine. Be that way!")
  (if (= (last sentence) \?)
    "Sure.")
  (if (= (clojure.string/upper-case sentence) sentence)
    "Woah, chill out!"))

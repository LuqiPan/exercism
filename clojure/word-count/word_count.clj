(ns word_count)

(defn sanitize
  [string]
  (->> string
      (re-seq #"\w+")
      (map clojure.string/lower-case)))

(defn word-count
  [string]
  (reduce (fn [counts word]
            (assoc counts word (inc (get counts word 0))))
          {}
          (sanitize string)))

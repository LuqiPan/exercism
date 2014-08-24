(ns word_count)

(defn sanitize
  [string]
  (->> string
      (re-seq #"\w+")
      (map clojure.string/lower-case)))

(defn word-count
  [string]
  (reduce (fn [counts word]
            (if (get counts word)
              (assoc counts word (inc (get counts word)))
              (assoc counts word 1)))
          {}
          (sanitize string)))

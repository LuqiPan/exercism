(ns etl)

(defn seq->map
  [score coll]
  (reduce (fn [score-map word]
            (assoc score-map (clojure.string/lower-case word) score))
          {}
          coll))

(defn transform
  [original]
  (reduce merge (for [[k v] original] (seq->map k v))))

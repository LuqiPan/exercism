(ns anagram
  (require [clojure.string :as s]))

(defn get-char-count
  [word]
  (reduce (fn [count-map character]
            (assoc count-map character (inc (get count-map character 0))))
          {}
          word))

(defn anagram?
  [word1 word2]
  (let [word1-lower (s/lower-case word1)
        word2-lower (s/lower-case word2)]
    (and (not= word1-lower word2-lower)
         (= (get-char-count word1-lower)
            (get-char-count word2-lower)))))

(defn anagrams-for
  [word words]
  (filter (partial anagram? word) words))

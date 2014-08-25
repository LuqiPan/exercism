(ns beer_song)

(defn pluralized-bottle
  [n]
  (case n
    0 (str "no more bottles")
    1 (str "1 bottle")
    (str n " bottles")))

(defn capitalize-sentence
  [sentence]
  (apply str
         (clojure.string/upper-case (first sentence))
         (rest sentence)))

(defn first-sentence
  [n]
  (let [bottles (pluralized-bottle n)]
    (str (capitalize-sentence bottles)
         " of beer on the wall, "
         bottles
         " of beer.\n")))

(defn on-the-wall
  [n]
  (let [less (dec n)]
    (str (pluralized-bottle (if (= less -1)
                              99
                              less))
         " of beer on the wall.\n")))

(defn second-sentence
  [n]
  (if (= n 0)
    (str "Go to the store and buy some more, "
         (on-the-wall n))
    (str "Take "
         (if (= n 1)
           "it"
           "one")
         " down and pass it around, "
         (on-the-wall n))))

(defn verse
  [n]
  (str (first-sentence n)
       (second-sentence n)))

(defn sing
  ([n] (sing n 0))
  ([start end]
   (assert (> start end -1))
   (clojure.string/join "\n"
                        (map verse
                             (reverse (range end (inc start)))))))

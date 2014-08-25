(ns beer_song)

(defn pluralized-bottle
  [n]
  (case n
    -1 "99 bottles"
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

(defn it-or-one
  [n]
  (if (= n 1)
    "it"
    "one"))

(defn go-to-store
  [n]
  (if (= n 0)
    "Go to the store and buy some more, "
    (str "Take "
         (it-or-one n)
         " down and pass it around, ")))

(defn on-the-wall
  [n]
  (let [less (dec n)]
    (str (pluralized-bottle less)
         " of beer on the wall.\n")))

(defn second-sentence
  [n]
  (str (go-to-store n) (on-the-wall n)))

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

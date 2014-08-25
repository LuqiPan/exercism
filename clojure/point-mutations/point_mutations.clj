(ns point_mutations)

(defn hamming-distance-seq
  [seq1 seq2]
  (if (and (seq seq1) (seq seq2))
    (if (= (first seq1) (first seq2))
      (recur (rest seq1) (rest seq2))
      (inc (hamming-distance-seq (rest seq1) (rest seq2))))
    0))

(defn hamming-distance
  [str1 str2]
  (let [seq1 (seq str1)
        seq2 (seq str2)]
    (hamming-distance-seq seq1 seq2)))

(ns nucleotide_count)

(defn nucleotide-counts
  [nuc-seq]
  (reduce (fn [counts nucleotide]
            (assoc counts nucleotide (inc (get counts nucleotide))))
          {\A 0, \T 0, \C 0, \G 0}
          nuc-seq))

(defn count
  [nucleotide nuc-seq]
  (get (nucleotide-counts nuc-seq) nucleotide 0))

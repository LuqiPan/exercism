(ns nucleotide_count)

(defn nucleotide-counts
  [nuc-seq]
  (reduce (fn [counts nucleotide]
            (assoc counts nucleotide (inc (get counts nucleotide))))
          {\A 0, \T 0, \C 0, \G 0}
          nuc-seq))

(defn valid-nucleotide?
  [nucleotide]
  (#{\A \T \C \G \U} nucleotide))

(defn count
  [nucleotide nuc-seq]
  (if-not (valid-nucleotide? nucleotide)
    (throw (Exception. "invalid nucleotide")))
  (get (nucleotide-counts nuc-seq) nucleotide 0))

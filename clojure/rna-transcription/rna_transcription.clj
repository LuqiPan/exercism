(ns rna_transcription)

(defn get-complement
  [nucleotide]
  (assert (contains? #{\C \G \A \T} nucleotide))
  (case nucleotide
    \C \G
    \G \C
    \A \U
    \T \A))

(defn to-rna
  [dna]
  (apply str (map get-complement dna)))

(ns phone_number)

(def invalid-result (apply str (repeat 10 \0)))

(defn number
  [string]
  (let [numbers (.replaceAll string "[^0-9]" "")]
    (case (count numbers)
      10 numbers
      11 (if (= (first numbers) \1)
           (apply str (rest numbers))
           invalid-result)
      9 invalid-result)))

(defn area-code
  [numbers]
  (subs numbers 0 3))

(defn middle-3
  [numbers]
  (subs numbers 3 6))

(defn last-4
  [numbers]
  (subs numbers 6 10))

(defn pretty-print
  [string]
  (let [numbers (number string)]
    (str "("
         (area-code numbers)
         ") "
         (middle-3 numbers)
         "-"
         (last-4 numbers))))

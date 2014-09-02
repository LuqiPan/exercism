(ns robot-name)

(defn rand-letter
  []
  (char (+ 65 (rand-int 26))))

(defn rand-number
  []
  (rand-int 10))

(defn rand-name
  []
  (apply str [(rand-letter) (rand-letter) (rand-number) (rand-number) (rand-number)]))

(defn robot
  []
  (atom
    (rand-name)))

(defn robot-name
  [r]
  @r)

(defn reset-name
  [r]
  (reset! r
          (rand-name)))

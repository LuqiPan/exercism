(ns grade_school)

(defn add
  [db student-name student-grade]
  (assoc db student-grade (conj (get db student-grade []) student-name)))

(defn grade
  [db student-grade]
  (get db student-grade []))

(defn sorted
  [db]
  (into {} (sort (reduce (fn [new-db student-grade]
                           (assoc new-db student-grade (sort (get db student-grade))))
                         {}
                         (keys db)))))

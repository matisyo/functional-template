(ns exercise9)

(defmulti things type)

(defmethod things clojure.lang.PersistentVector [a] "Soy un Vector")

(defmethod things clojure.lang.PersistentArrayMap [a] "Soy un Map")

(defmethod things java.lang.String [a]  "Soy un String")

(defmethod things java.lang.Long [a] "Soy un default")

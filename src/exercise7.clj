(ns exercise7)

(defmulti fmap
  "Applies function f to each item in the data structure s and returns
   a structure of the same kind."
   {:arglists '([f s])}
   (fn [f s] (type s)))

(defmethod fmap clojure.lang.IPersistentList
  [f v]
  (map f v))

(defmethod fmap clojure.lang.IPersistentVector
  [f v]
  (into (empty v) (map f v)))

(defmethod fmap clojure.lang.IPersistentMap
  [f m]
  (into (empty m) (for [[k v] m] [k (f v)])))

(defmethod fmap clojure.lang.IPersistentSet
  [f s]
  (into (empty s) (map f s)))

(defmethod fmap clojure.lang.IFn
  [f fn]
  (comp f fn))

(prefer-method fmap clojure.lang.IPersistentVector clojure.lang.IFn)
(prefer-method fmap clojure.lang.IPersistentMap clojure.lang.IFn)
(prefer-method fmap clojure.lang.IPersistentSet clojure.lang.IFn)

(defmethod fmap clojure.lang.LazySeq
  [f s]
  (map f s))

(defmethod fmap java.util.concurrent.Future
  [f o]
  (future (f @o)))

(defmethod fmap clojure.lang.Delay
  [f d]
  (delay (f @d)))

(defmethod fmap nil
  [_ _]
nil)
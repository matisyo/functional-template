(ns exercise8)

(defn fderive [f er]

	(fn [x]
		( / (- ( f (+ x er ))  ( f (- x er ))) (* 2 er) )
	)
)

(ns exercise6)

(defn faverage [x]
  (/ 
  	(reduce + x) 
	(if  (empty? x) 
		1 
		(count x)
	)
  )
)





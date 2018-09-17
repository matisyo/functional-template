(ns exercise10)

(defn fvariance [lista]
	( let [total (count lista)					   
		   ala2 #(* % %)
		   cuadrados (reduce + (map ala2 lista) )
		   sumatoria (reduce + lista)
		   hope (/ sumatoria total)
		   ]
		(- (/ cuadrados total) (ala2 hope))
	)
)






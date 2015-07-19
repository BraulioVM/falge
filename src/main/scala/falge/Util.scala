package falge

package object util {

	def cartesianPower[T](set : Set[T], power : Int) : List[List[T]] = {
			
		if (power == 0){	// empty, base case
			List[List[T]]( List() )
		} else {

			val prepower = cartesianPower(set, power - 1)
			var result = List[List[T]]()

			prepower.foreach(combination => {

				set.foreach(element => {
					val new_combination : List[T] = element :: combination
					result = new_combination :: result
				})

			})

			result
		}
	}

}
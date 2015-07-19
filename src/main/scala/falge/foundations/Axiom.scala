package falge.foundations

import falge.foundations.statement.Statement
import falge.util.cartesianPower	

abstract class Axiom[T](val statement : Statement[T]){
	def verify(set: Set[T]) : Boolean
}

class AxiomForAll[T](val numberOfVariables : Int, statement : Statement[T]) extends Axiom[T](statement) {


	def verify(set : Set[T]) : Boolean = {
		cartesianPower(set, numberOfVariables).forall(
			statement(_)
		)
	}

}


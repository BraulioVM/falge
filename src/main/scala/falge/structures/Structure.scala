package falge.structures

import falge.foundations.Axiom

class Structure[T](val elements : Set[T]) {

	private var axioms = List[Axiom[T]]();

	def verify() : Boolean = axioms.forall(_.verify(elements))

	def verifies(axiom : Axiom[T]){
		axioms = axiom :: axioms
	}
}
package falge.structures

import falge.foundations.axioms

class Monoid[T](elements : Set[T], op : (T, T) => T) extends Semigroup[T](elements, op) {

	this verifies (axioms.identityElement(op))

}
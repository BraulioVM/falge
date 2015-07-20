package falge.structures

import falge.foundations.axioms;

class Semigroup[T](elements : Set[T], op : (T, T) => T) extends Magma[T](elements, op) {

	this verifies (axioms.associative(op))
}
package falge.structures

import falge.foundations.axioms;

class Magma[T](elements : Set[T], op : (T, T) => T) extends Structure[T](elements) {

	this verifies (axioms.closure(op))
}
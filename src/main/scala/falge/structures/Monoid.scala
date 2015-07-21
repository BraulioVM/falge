package falge.structures

import falge.foundations.AxiomExplicit


class Monoid[T](elements : Set[T], op : (T, T) => T) extends Semigroup[T](elements, op) {

	var identity : Option[T] = None

	private def hasIdentity() : Boolean = {
		identity = findIdentity()

		if (identity.isDefined)
			true
		else
			false
	}

	private def findIdentity() : Option[T] = {
		val initial = elements.head
		val potentialIdentities = elements.filter(n => op(n, initial) == initial && op(initial, n) == initial)
		val solution = potentialIdentities.filter(isIdentity)

		if (solution.size == 1)
			Some(solution.head)
		else
			None
	}

	private def isIdentity(e : T) : Boolean = {
		elements.tail.forall(a => op(a, e) == a && op(e, a) == a)  // the check for the head was already made
	}

	this verifies (new AxiomExplicit(hasIdentity))


}
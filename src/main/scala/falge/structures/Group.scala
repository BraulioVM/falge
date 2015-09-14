package falge.structures

import falge.foundations.AxiomExplicit
import scala.collection.mutable.HashMap


class Group[T](elements : Set[T], op : (T, T) => T) extends Monoid[T](elements, op) {

	val inverseElements = HashMap[T, T]()


	private implicit def TypeToOption(a : T) = Some(a)

	private def areInverses(a : T, b : T) = {
		Some(op(a, b)) == this.identity && Some(op(b, a)) == this.identity
	}
	

	private def hasInverseElements() : Boolean = {
		val elementsV = this.elements.toVector
		val length = elementsV.length

		for(i <- 0 until length) {
			
			val a = elementsV(i)

			if (inverseElements.contains(a) == false) {	// has an inverse been found for this element already?

				val potential_inverse = elementsV
					.slice(i, length) 
					.find( areInverses(a, _) )	// find wether a has an inverse

				potential_inverse match {
					case Some(a_inverse) => {	// it has an inverse
						inverseElements(a) = a_inverse
						inverseElements(a_inverse) = a
					}
					case None => {	// it doesn't
						return false
					}

				}

			}

		}

		// all elements have inverses
		true
	}

	this verifies (new AxiomExplicit(hasInverseElements))


}

object Group {

	def Z(n : Int) = {
		val set : Set[Int] = (0 until n).toSet

		def operation(a: Int, b : Int) = (a + b) % n

		new Group(set, operation)
	}

}
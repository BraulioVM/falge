package falge.foundations

import falge.foundations.statement.Statement
import falge.util.cartesianPower	

abstract class Axiom[T](){
	def verify(set: Set[T]) : Boolean
}

class AxiomExplicit[T]()

class AxiomForAll[T](val numberOfVariables : Int, val statement : Statement[T]) extends Axiom[T]() {


	def verify(set : Set[T]) : Boolean = cartesianPower(set, numberOfVariables).forall(statement(_, set))

}

class AxiomExists[T](val numberOfVariables : Int, val statement : Statement[T]) extends Axiom[T]() {

	def verify(set : Set[T]) : Boolean = cartesianPower(set, numberOfVariables).exists(statement(_, set))

}




package object axioms {

	def closure[T](op : (T, T) => T) : Axiom[T] = new AxiomForAll[T](2, (l, elements) => {
		val (a, b) = (l(0), l(1))

		elements contains op(a, b)
	})

	def commutative[T](op : (T, T) => T) : Axiom[T] = new AxiomForAll[T](2, (l, _) => {
		val (a, b) = (l(0), l(1))

		op(a, b) == op(b, a)
	})

	def associative[T](op : (T, T) => T) : Axiom[T] = new AxiomForAll[T](3, (l, _) => {
		val (a, b, c) = (l(0), l(1), l(2))

		op(a, op(b, c)) == op(op(a, b), c)
	})

	def identityElement[T](op : (T, T) => T) : Axiom[T] = new AxiomExists[T](1, (l, elements) => {
		val e = l(0)

		elements.forall(x => 
			op(x, e) == x && op(e, x) == x
		)
	})


}
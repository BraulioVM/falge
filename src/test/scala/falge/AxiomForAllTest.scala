package falge

import falge.foundations.AxiomForAll
import org.scalatest._

class AxiomForAllTest extends FlatSpec with Matchers {

	"An AxiomForAll" should "be verified by all elements in the set provided" in {

		val axiom = new AxiomForAll[Int](1, (l, _) => l(0) != 0)

		axiom.verify(Set(1,2,3,4)) shouldBe true
		axiom.verify(Set(0,1,2,3,4)) shouldBe false

	}

	it should "allow a variable number of parameters" in {

		val axiom = new AxiomForAll[Int](2, (l, _) => {	// commutativity axiom
			val (a, b) = (l(0), l(1))

			a + b == b + a
		})

		axiom.verify(Set(1,2,3,4,6,7,10,43)) shouldBe true

		val secondAxiom = new AxiomForAll[Int](2, (l, _) => {
			val (a, b) = (l(0), l(1)) 


			a - b == b - a
		}) 

		secondAxiom.verify(Set(0)) shouldBe true
		secondAxiom.verify(Set(0, 1)) shouldBe false

		val associativeAxiom = new AxiomForAll[Int](3, (l, _) => {
			val (a, b, c) = (l(0), l(1), l(2))

			(a + b) + c == a + (b + c)
		})

		associativeAxiom.verify(Set(23,342,4203,23413,4013,132,1341034,13410)) shouldBe true
	}

	it should "be applicable to different types" in {
		val strLengthAxiom = new AxiomForAll[String](2, (l, _) => {
			val (a, b) = (l(0), l(1))

			(a + b).length == a.length + b.length
		})

		strLengthAxiom.verify(Set("hey", "jarl", "cander")) shouldBe true

		val fakeAxiom = new AxiomForAll[String](1, (l, _) => {
			l(0).length > 0
		})

		fakeAxiom.verify(Set("adsfadf", "")) shouldBe false

		val demorganLaw = new AxiomForAll[Boolean](2, (l, _) => {
			val (a, b) = (l(0), l(1))

			!(a && b) == !a || !b
		})

		demorganLaw.verify(Set(true, false)) shouldBe true
	}

}
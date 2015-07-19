package falge

import falge.foundations.AxiomExists
import org.scalatest._

class AxiomExistsTest extends FlatSpec with Matchers {

	"An AxiomExists" should "be verified by at least one element in the set provided" in {

		val neutralElementAxiom = new AxiomExists[Int](1, (l, elements) => {
			val e = l(0)

			elements.forall(x => (x + e == x) && (x == e + x) )
		})

		neutralElementAxiom.verify(Set(1,2,3,4)) shouldBe false
		neutralElementAxiom.verify(Set(0,1,2,3,4)) shouldBe true

	}

	it should "be applicable to more than one variable" in {

		val axiom = new AxiomExists[Int](2, (l, elements) => {
			val (a, b) = (l(0), l(1))

			a + b == 0
		})

		axiom.verify(Set(1, 3, 4, 5, -3)) shouldBe true
		axiom.verify(Set(0, 2, 4)) shouldBe true
		axiom.verify(Set(1,2,3,4,5,6,8)) shouldBe false
	}

}
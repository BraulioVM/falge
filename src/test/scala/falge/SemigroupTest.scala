package falge

import falge.structures.Semigroup
import org.scalatest._

class SemigroupTest extends FlatSpec with Matchers {

	"A semigroup" should "be closed under its operation" in {
		
		val numbers = Set(0, 1)
		val fakeSemigroup = new Semigroup[Int](numbers, (x, y) => x + y)
		
		fakeSemigroup.verify() shouldBe false
	}

	it should "be associative" in {

		val numbers = Set(-1, 0, 1)

		val op = (x: Int, y: Int) => {
			if (x * y == 1)
				0
			else
				x + y
		}

		val fakeSemigroup = new Semigroup(numbers, op)
		val realSemigroup = new Semigroup(Set(0, 1), op)	// This is Z[2]

		fakeSemigroup.verify() shouldBe false	// -1 op (1 op 1) != (-1 op 1) op 1
		realSemigroup.verify() shouldBe true 
	}

	it should "not need an identity element" in {
		val numbers = Set(-1, 1)
		val op = (x : Int, y: Int) => 1
		val fakeSemigroup = new Semigroup(numbers, op)

		fakeSemigroup.verify() shouldBe true
	}

}
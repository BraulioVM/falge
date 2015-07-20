package falge

import falge.structures.Monoid
import org.scalatest._

class MonoidTest extends FlatSpec with Matchers {

	"A monoid" should "be closed under its operation" in {
		
		val numbers = Set(0, 1)
		val fakeMonoid = new Monoid[Int](numbers, (x, y) => x + y)
		
		fakeMonoid.verify() shouldBe false
	}

	it should "be associative" in {

		val numbers = Set(-1, 0, 1)

		val op = (x: Int, y: Int) => {
			if (x * y == 1)
				0
			else
				x + y
		}

		val fakeMonoid = new Monoid(numbers, op)
		val realMonoid = new Monoid(Set(0, 1), op)	// This is Z[2]

		fakeMonoid.verify() shouldBe false	// -1 op (1 op 1) != (-1 op 1) op 1
		realMonoid.verify() shouldBe true 
	}

	it should "have an identity element" in {
		val numbers = Set(-1, 1)

		val op = (x : Int, y: Int) => 1

		val fakeMonoid = new Monoid(numbers, op)

		fakeMonoid.verify() shouldBe false

	}



}
package falge

import falge.structures.Group
import org.scalatest._

class GroupTest extends FlatSpec with Matchers {

	"A group" should "be closed under its operation" in {
		
		val numbers = Set(0, 1)
		val fakeMonoid = new Group[Int](numbers, (x, y) => x + y)
		
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

		val fakeMonoid = new Group(numbers, op)
		val realMonoid = new Group(Set(0, 1), op)	// This is Z[2]

		fakeMonoid.verify() shouldBe false	// -1 op (1 op 1) != (-1 op 1) op 1
	}

	it should "have an identity element" in {
		val numbers = Set(-1, 1)

		val op = (x : Int, y: Int) => 1

		val fakeMonoid = new Group(numbers, op)

		fakeMonoid.verify() shouldBe false

	}

	it should "be able to verify as Z[n]" in {

		(1 to 20).foreach { n =>
			Group.Z(n).verify() shouldBe true
		}


	}



}
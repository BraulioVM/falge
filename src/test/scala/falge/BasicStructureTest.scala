package falge

import falge.structures.Structure
import falge.foundations.{AxiomForAll, AxiomExists}
import org.scalatest._

class BasicStructureTest extends FlatSpec with Matchers {

	"A basic structure" should " verify all of its axioms" in {
		val axiom1 = new AxiomForAll[Int](1, (l, _) => l(0) >= 0)
		val axiom2 = new AxiomExists[Int](1, (l, _) => l(0) == 0)

		val axioms = List(axiom1, axiom2)

		val structure1 = new Structure(Set(0, 1, 2, 3, 4, 5))
		val structure2 = new Structure(Set(1,2,3,4,5))
		val structure3 = new Structure(Set(-1, 0, 1, 2, 3, 4))
		
		axioms.foreach(structure1 verifies _)
		axioms.foreach(structure2 verifies _)
		axioms.foreach(structure3 verifies _)

		structure1.verify() shouldBe true
		structure2.verify() shouldBe false
		structure3.verify() shouldBe false
	}

}
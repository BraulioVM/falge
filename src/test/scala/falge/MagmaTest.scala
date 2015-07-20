package falge

import falge.structures.Magma
import org.scalatest._

class MagmaTest extends FlatSpec with Matchers {

	"A magma" should "be closed under its operation" in {
		
		val numbers = Set(0, 1, 2, 3, 4)

		val realMagma = new Magma[Int](numbers, (x, y) => 0)
		val fakeMagma = new Magma[Int](numbers, (x, y) => x + y)

		realMagma.verify() shouldBe true
		fakeMagma.verify() shouldBe false
	}



}
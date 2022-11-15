import Funtions.FunctionBasedSpec
import Funtions.IntBiOp
import Funtions.IntUnOp
import io.kotest.matchers.shouldBe
import io.kotest.property.checkAll

class BinaryOperationSpec : FunctionBasedSpec() {
    init {

        "Add" {
            checkAll<Int, Int> { a, b ->

                val add: IntBiOp = { a -> { b -> a + b } }

                val result = add(a)(b)

                val expected = a + b

                result shouldBe expected

            }
        }

        "Square" {
            checkAll<Int> { a ->
                val square: IntUnOp = { it * it }

                val result = square(a)
                val expected = a * a

                result shouldBe expected
            }
        }
    }
}
import Funtions.FunctionBasedSpec
import Funtions.IntBiOp
import Funtions.IntUnOp
import com.appmattus.kotlinfixture.kotlinFixture
import io.kotest.matchers.shouldBe

class BinaryOperationSpec : FunctionBasedSpec() {
    init {
        val fixture = kotlinFixture()
        given("Two Int value") {
            val a = fixture<Int>()
            val b = fixture<Int>()

            `when`("Add a,b") {
                val add: IntBiOp = { a -> { b -> a + b } }

                val result = add(a)(b)

                then("Result will be a plus b") {
                    val expected = a + b

                    result shouldBe expected
                }
            }
        }

        given("A Int value") {
            val a = fixture<Int>()

            `when`("Square it") {
                val square: IntUnOp = { it * it }

                val result = square(a)
                then("Result will be a * a") {
                    val expected = a * a

                    result shouldBe expected
                }
            }
        }
    }
}
import Funtions.FunctionBasedSpec
import Funtions.IntBiOp
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
    }
}
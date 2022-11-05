import Funtions.*
import com.appmattus.kotlinfixture.kotlinFixture
import io.kotest.matchers.shouldBe

class ComposeSpec : FunctionBasedSpec() {
    init {
        val fixture = kotlinFixture()

        given("Random Int value") {
            val value = fixture<Int>()

            `when`("Compose square, triple") {
                fun square(n: Int) = n * n
                fun triple(n: Int) = n * 3

                val squareOfTriple = compose(::square, ::triple)
                val result = squareOfTriple(value)

                then("Value will be tripled then squared.") {
                    val expected = square(triple(value))

                    result shouldBe expected
                }
            }

            `when`("Compose square, triple : Polymorphic") {
                fun square(n: Int) = n * n
                fun triple(n: Int) = n * 3

                val squareOfTriple = polyCompose<Int, Int, Int>(::square, ::triple)
                val result = squareOfTriple(value)

                then("Value will be tripled then squared.") {
                    val expected = square(triple(value))

                    result shouldBe expected
                }
            }

            `when`("Compose square, triple : higherCompose") {
                val square: (Int) -> Int = { it * it }
                val triple: (Int) -> Int = { it * 3 }

                val squareOfTriple = higherCompose<Int, Int, Int>()(square)(triple)
                val result = squareOfTriple(value)

                then("Value will be tripled then squared.") {
                    val expected = square(triple(value))

                    result shouldBe expected
                }
            }

            `when`("Compose square and triple") {
                val compose: (IntUnOp) -> (IntUnOp) -> IntUnOp = { x -> { y -> { z -> x(y(z)) } } }

                val square: IntUnOp = { it * it }
                val triple: IntUnOp = { it * 3 }
                val squareOfTriple = compose(square)(triple)

                val result = squareOfTriple(value)

                then("Value will be tripled then squared") {
                    val expected = square(triple(value))

                    result shouldBe expected
                }
            }
        }
    }
}

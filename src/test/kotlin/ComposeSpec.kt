import Funtions.*
import io.kotest.matchers.shouldBe
import io.kotest.property.checkAll

class ComposeSpec : FunctionBasedSpec() {
    init {
        fun square(n: Int) = n * n
        fun triple(n: Int) = n * 3

        "Compose" {
            checkAll<Int> { value ->
                val squareOfTriple = compose(::square, ::triple)
                val result = squareOfTriple(value)

                val expected = square(triple(value))

                result shouldBe expected
            }
        }

        "Polymorphic compose" {
            checkAll<Int> { value ->
                val squareOfTriple = polyCompose(::square, ::triple)
                val result = squareOfTriple(value)

                val expected = square(triple(value))

                result shouldBe expected
            }
        }

        "Higher Compose" {
            checkAll<Int> { value ->
                val square: (Int) -> Int = { it * it }
                val triple: (Int) -> Int = { it * 3 }

                val squareOfTriple = higherCompose<Int, Int, Int>()(square)(triple)
                val result = squareOfTriple(value)

                val expected = square(triple(value))

                result shouldBe expected
            }
        }

        "Compose square and triple" {
            checkAll<Int> { value ->
                val compose: (IntUnOp) -> (IntUnOp) -> IntUnOp = { x -> { y -> { z -> x(y(z)) } } }

                val square: IntUnOp = { it * it }
                val triple: IntUnOp = { it * 3 }

                val squareOfTriple = compose(square)(triple)

                val result = squareOfTriple(value)

                val expected = square(triple(value))

                result shouldBe expected
            }
        }
    }
}
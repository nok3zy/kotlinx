import Funtions.FunctionBasedSpec
import Funtions.fourArgumentsCurring
import Funtions.partOne
import Funtions.partTwo
import io.kotest.matchers.shouldBe
import io.kotest.property.checkAll
import io.kotest.property.forAll

class CurringSpec : FunctionBasedSpec() {
    init {
        "4ArgumentsCurring" {
            checkAll<String, String, String, String> { a, b, c, d ->
                val result = fourArgumentsCurring<String, String, String, String>()(a)(b)(c)(d)()
                val expected = "$a $b $c $d"
                result shouldBe expected
            }
        }

        "Fixed money then input rate"{
            val tax = { a: Int -> { b: Double -> a * (1 + b / 100) } }

            forAll<Int, Double> { a, b ->
                a != 0 || partOne(a, tax)(b) == tax(a)(b)
            }
        }

        "Fixed rate then input money"{
            val tax = { a: Int -> { b: Double -> a * (1 + b / 100) } }

            forAll<Int, Double> { a, b ->
                a != 0 || partTwo(b, tax)(a) == tax(a)(b)
            }
        }
    }
}
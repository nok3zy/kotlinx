import Funtions.FunctionBasedSpec
import Funtions.fourArgumentsCurring
import io.kotest.matchers.shouldBe
import io.kotest.property.checkAll

class CurringSpec : FunctionBasedSpec() {
    init {
        "4ArgumentsCurring" {
            checkAll<String, String, String, String> { a, b, c, d ->
                val result = fourArgumentsCurring<String, String, String, String>()(a)(b)(c)(d)()
                val expected = "$a $b $c $d"
                result shouldBe expected
            }
        }
    }
}
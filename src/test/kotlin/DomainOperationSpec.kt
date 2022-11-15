import Funtions.FunctionBasedSpec
import io.kotest.assertions.print.print
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.instanceOf
import io.kotest.matchers.types.shouldBeSameInstanceAs
import io.kotest.property.checkAll

class DomainOperationSpec : FunctionBasedSpec() {
    init {
        "Price.times"{
            checkAll<Int> { count ->
                val price = Price(10)
                val expected = 10 * count
                val result = price * count

                result.toString() shouldBe expected.toString()
            }
        }

        "Price.plus"{
            checkAll<Int, Int> { a, b ->
                val priceA = Price(a)
                val priceB = Price(b)
                val expected = a + b
                val result = priceA + priceB

                result.toString() shouldBe expected.toString()
            }
        }

        "Folding"{
            val priceList = listOf(Price(1), Price(2), Price(3))
            val result = priceList.fold(Price.zero) { acc, price -> acc + price }

        }
    }
}
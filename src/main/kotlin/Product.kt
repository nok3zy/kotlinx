data class ProductV0(val name: String, val price: Int)

data class ProductV1(val name: String, val price: Price)

// 객체를 통해서 연산을 하는 것이 안전하다.
data class Price(private val value: Int) {
    operator fun plus(price: Price) = Price(this.value + price.value)
    operator fun times(count: Int) = Price(this.value * count)
    override fun toString(): String = value.toString()

    companion object {
        val zero = Price(0)
        operator fun invoke(value: Int) = if (value > 0) Price(value) else throw RuntimeException("Must be positive")
    }
}
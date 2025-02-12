object PriceDiscounts {
  
  type P = Double => Double

  // These are both higher-order functions
  def applyDiscountUncurried(discount: P, price: Double): Double = discount(price)
  def applyDiscountCurried(discount: P)(price: Double): Double = discount(price)

  def main(args: Array[String]): Unit = {
    // This is an example of partial application
    val discounter: Double => Double = applyDiscountCurried((price: Double) => price * 0.5)

    val originalPrice = 100.0
    val reducedPrice: Double = discounter(originalPrice)

    println(s"The original price was ${originalPrice}")
    println(s"The reduced price is ${reducedPrice}")
  }
}

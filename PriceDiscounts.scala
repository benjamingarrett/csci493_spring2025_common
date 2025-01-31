object PriceDiscounts extends App {

  def applyDiscountUncurried(discount: Double => Double, price: Double): Double = discount(price)

  def applyDiscountCurried(discount: Double => Double)(price: Double): Double = discount(price)

  val discounter: Double => Double = applyDiscountCurried((price: Double) => price * 0.5)

  val originalPrice = 100.0

  val reducedPrice: Double = discounter(originalPrice)

  println(s"The original price was ${originalPrice}")
  println(s"The reduced price is ${reducedPrice}")
}

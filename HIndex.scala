object HIndex extends App {
  val allInputs = List(
    List(2, 4, 0, 3),
    List(100, 5, 1000),
    List(6, 1, 3, 9, 2),
    List(1,2,3,4),
    List(1, 2, 3, 4, 5, 6),
    List(0, 2, 0, 3, 0, 5)
  )
  val hIndex = (citations: List[Int]) => (0 to citations.length).map(
    h => if (citations.filter(k => k >= h).length >= h) h else 0
  ).max

  def hIndex_as_function(citations: List[Int]): Int = {
    def checkH(h: Int): Int = {
      if (citations.filter(k => k >= h).length >= h) h else 0
    }
    val rangeOfIndices: List[Int] = (0 to citations.length).toList
    val listOfHValues: List[Int] = rangeOfIndices.map(checkH)
    listOfHValues.max    
  }
  allInputs.map(input => println(s"${input} => ${hIndex(input)}"))
  println("=================")
  allInputs.map(input => println(s"${input} => ${hIndex_as_function(input)}"))
}

sealed trait Direction
case object Right extends Direction
case object Down extends Direction
case object Left extends Direction
case object Up extends Direction

object Spiral extends App {
  val rotate = (current: Direction) => current match {case Right => Down; case Down => Left; case Left => Up; case Up => Right}
  val allInputs = List(
    List(List(1,2,3,4,5,6,7)),
    List(List(1,2,3,4,5,6,7),List(8,9,10,11,12,13,14)),
    List(List(1,2,3),List(4,5,6),List(7,8,9)),
    List(List(1,2,3,4),List(5,6,7,8),List(9,10,11,12),List(13,14,15,16)),
    List(List(1,2,3,4),List(5,6,7,8),List(9,10,11,12),List(13,14,15,16),List(17,18,19,20)),
    List(List(1,2,3,4,5),List(6,7,8,9,10),List(11,12,13,14,15),List(16,17,18,19,20)),
    List(List(1,2),List(3,4),List(5,6),List(7,8)),
    List(List(1),List(2),List(3),List(4),List(5),List(6),List(7))
  )
  def spiral(a: List[List[Int]]): List[Int] = {
    val rows = a.length
    val cols = a(0).length
    def addLeg(direction: Direction, currRow: Int, currCol: Int, firstRow: Int, firstCol: Int, lastRow: Int, lastCol: Int, acc: List[Int]): List[Int] = 
      if(acc.length >= rows*cols) acc 
      else {
        direction match {
          case Right => addLeg(
            rotate(direction), currRow+1, lastCol, firstRow, firstCol, lastRow, lastCol-1, 
            acc ::: a(currRow).zipWithIndex.filter(x => x._2 >= firstCol && x._2 <= lastCol).map(x => x._1)
          )
          case Down => addLeg(
            rotate(direction), lastRow, currCol-1, firstRow, firstCol, lastRow-1, lastCol,
            acc ::: a.zipWithIndex.filter(x => x._2 >= firstRow && x._2 <= lastRow).map(x => x._1(currCol))
          )
          case Left => addLeg(
            rotate(direction), currRow-1, firstCol, firstRow, firstCol+1, lastRow, lastCol,
            acc ::: a(currRow).zipWithIndex.filter(x => x._2 >= firstCol && x._2 <= lastCol).reverse.map(x => x._1)
          )
          case Up => addLeg(
            rotate(direction), firstRow, currCol+1, firstRow+1, firstCol, lastRow, lastCol,
            acc ::: a.zipWithIndex.filter(x => x._2 >= firstRow && x._2 <= lastRow).reverse.map(x => x._1(currCol))
          )
        }
      }
    addLeg(Right, 0, 0, 1, 0, rows-1, cols-1, List[Int]())
  }
  allInputs.map(input => println(s"${spiral(input)}"))
}

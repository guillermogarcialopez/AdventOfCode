import scala.io.Source

object Day1 extends App {
  val fileName = "./input/Day1part1_input.txt"

  def getNumOfIncreases(depths: Seq[Int]): Int = {
    var numOfIncreases: Int = 0
    var prevDepth = depths.head
    for (depth <- depths) {
      if(depth > prevDepth) {
        numOfIncreases = numOfIncreases + 1
      }
      prevDepth = depth
    }
    numOfIncreases
  }

  // Part one
  val depths = Source.fromFile(fileName).getLines.map(depth => depth.toInt).toSeq
  println("Number of increases part one: " + getNumOfIncreases(depths))

  // Part two
  val depthByWindows = (0 to depths.size-3).map(index => {
    depths.slice(index, index+3).sum
  })
  println("Number of increases part one: " + getNumOfIncreases(depthByWindows))
}

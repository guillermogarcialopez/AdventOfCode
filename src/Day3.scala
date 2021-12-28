import scala.io.Source

object Day3 extends App {
  val fileName = "./input/Day3example_input.txt"

  /* Part one */
  val diagnosticReport = Source.fromFile(fileName).getLines.toSeq
  val lenDimension = diagnosticReport.head.size

  var gammaRate: String = ""
  var epsilonRate: String = ""

  (0 to lenDimension - 1).foreach(digitIndex => {
    var verticalList: List[Int] = List()
    diagnosticReport.foreach(code => {
      verticalList = verticalList :+ code.apply(digitIndex).toString.toInt
    })
    if(verticalList.filter(_ == 0).size > verticalList.filter(_ == 1).size){
      gammaRate = gammaRate + "0"
      epsilonRate = epsilonRate + "1"
    } else {
      gammaRate = gammaRate + "1"
      epsilonRate = epsilonRate + "0"
    }
  })

  println("EPSILON RATE FINAL BINARIO: " + epsilonRate)
  println("EPSILON RATE FINAL DECIMAL: " + Integer.parseInt(epsilonRate, 2))

  println("GAMMA RATE FINAL BINARIO: " + gammaRate)
  println("GAMMA RATE FINAL DECIMAL: " + Integer.parseInt(gammaRate, 2))

  println("POWER CONSUMPTION: " + Integer.parseInt(gammaRate, 2) * Integer.parseInt(epsilonRate, 2))

}

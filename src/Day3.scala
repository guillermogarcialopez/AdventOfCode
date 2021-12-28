import scala.io.Source

object Day3 extends App {
  val fileName = "./input/Day3example_input.txt"
//  val fileName = "./input/Day3_input.txt"

  /* Part one */
  val diagnosticReport = Source.fromFile(fileName).getLines.toSeq
  val lenDimension = diagnosticReport.head.size

  var gammaRate: String = ""
  var epsilonRate: String = ""

  var oxygenList = diagnosticReport
  var co2List = diagnosticReport

  (0 to lenDimension - 1).foreach(digitIndex => {
    var verticalList: List[Int] = List()
    diagnosticReport.foreach(code => { verticalList = verticalList :+ code.apply(digitIndex).toString.toInt })
    if(verticalList.filter(_ == 0).size > verticalList.filter(_ == 1).size){
      gammaRate = gammaRate + "0"
      epsilonRate = epsilonRate + "1"
    } else {
      gammaRate = gammaRate + "1"
      epsilonRate = epsilonRate + "0"
    }

    /* Part two */
//    if(oxygenList.size.<=(2)){
    if(oxygenList.size.equals(2)){
      oxygenList = oxygenList.filter(_.apply(digitIndex).toString.equals("1"))
    } else {
      if(verticalList.filter(_ == 0).size > verticalList.filter(_ == 1).size && oxygenList.size != 1){
        oxygenList = oxygenList.filter(_.apply(digitIndex).toString.equals("0"))
      } else if (oxygenList.size != 1) {
        oxygenList = oxygenList.filter(_.apply(digitIndex).toString.equals("1"))
      }
    }

//    if(co2List.size.<=(2)){
    if(co2List.size.equals(2)){
      co2List = co2List.filter(_.apply(digitIndex).toString.equals("0"))
    } else {
      if(verticalList.filter(_ == 0).size > verticalList.filter(_ == 1).size && co2List.size != 1){
        co2List = co2List.filter(_.apply(digitIndex).toString.equals("1"))
      } else if (co2List.size != 1) {
        co2List = co2List.filter(_.apply(digitIndex).toString.equals("0"))
      }
    }



  })

  println("OXYGEN LIST FINAL: " + Integer.parseInt(oxygenList.head, 2))
  println("CO2 LIST FINAL: " + Integer.parseInt(co2List.head, 2))
  println("LIFE SUPPORTING RATING: " + Integer.parseInt(oxygenList.head, 2) * Integer.parseInt(co2List.head, 2))

  println("EPSILON RATE FINAL DECIMAL: " + Integer.parseInt(epsilonRate, 2))
  println("GAMMA RATE FINAL DECIMAL: " + Integer.parseInt(gammaRate, 2))
  println("POWER CONSUMPTION: " + Integer.parseInt(gammaRate, 2) * Integer.parseInt(epsilonRate, 2))

  /* Part two */



}

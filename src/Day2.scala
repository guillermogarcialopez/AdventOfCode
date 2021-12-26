import scala.io.Source

object Day2 extends App {
  val fileName = "./input/Day2_input.txt"

  /* Part one */
  val instructions = Source.fromFile(fileName).getLines.toSeq
  val forwardInstructions = instructions.filter(_.startsWith("forward"))
  val upInstructions = instructions.filter(_.startsWith("up"))
  val downInstructions = instructions.filter(_.startsWith("down"))

  val movementsForward = forwardInstructions.map(_.split(" ")).map(_.apply(1).toInt).sum
  val movementsUp = upInstructions.map(_.split(" ")).map(_.apply(1).toInt).sum
  val movementsDown = downInstructions.map(_.split(" ")).map(_.apply(1).toInt).sum

  println("HORIZONTAL POSITION: " + movementsForward)
  println("DEPTH: " + (movementsDown - movementsUp))
  println("PRODUCT: " + (movementsForward * (movementsDown - movementsUp)))

  /* Part two */
  var aim = 0
  var horizontalPosition = 0
  var depth = 0
  instructions.foreach(instruction => {
    val (typeOfInst, valueOfInst) = (instruction.split(" ").apply(0), instruction.split(" ").apply(1).toInt)
    if(typeOfInst.equals("down")) {aim = aim + valueOfInst}
    if(typeOfInst.equals("up")) {aim = aim - valueOfInst}
    if(typeOfInst.equals("forward")) {
      horizontalPosition = horizontalPosition + valueOfInst
      depth = depth + (aim * valueOfInst)
    }
  })

  val finalPosition = horizontalPosition * depth

  println("FINAL POSITION: " + finalPosition)
}

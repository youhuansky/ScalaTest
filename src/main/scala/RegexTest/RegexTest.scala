package RegexTest

object RegexTest {

  def main(args: Array[String]): Unit = {
//    val pattern1 = new Regex("(S|s)cala")
//    val pattern2 = "(S|s)cala".r
//    val str = "Scala is scalable and cool"
//    println((pattern2 findAllIn str).mkString(","))
//    val pattern1 = new Regex("[1-9][0-9]{4,}")
    val pattern2 = "[1-9][0-9]{4,}".r
//    val str = "Scala is scalable and cool"
    val str = "284477367"
    val bool = pattern2.pattern.matcher(str).matches()

    println(bool)

  }

}

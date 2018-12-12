package IOTest

import java.io.PrintWriter

object WriteFileTest {


  def main(args: Array[String]): Unit = {

    val writer = new PrintWriter("hdfstest2.txt")
    writer.write("asdasdasdasd")
    writer.close()
  }
}

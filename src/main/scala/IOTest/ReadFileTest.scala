package IOTest

import scala.io.Source

object ReadFileTest {

  def main(args: Array[String]): Unit = {

    val source = Source.fromFile("hdfstest.txt")
//    val strings = source.getLines()
//    for(x<-strings){
//      println(x)
//    }
    println(source.mkString)
    source.close
  }




}

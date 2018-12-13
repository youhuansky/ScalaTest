package ImplicitTest

import java.io.File

import scala.io.Source

object ImplicitTest {
  class RichFile(val from: File) {
    def read = Source.fromFile(from.getPath).mkString
  }


  def main(args: Array[String]): Unit = {

    implicit def file2RichFile(from: File) = new RichFile(from)

    val contents = new File("C:\\Users\\Administrator\\Desktop\\weibo10ques.txt").read
    println(contents)
  }
}

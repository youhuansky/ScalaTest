package IOTest

import scala.io.StdIn
//控制台输入方法
object ConsoleTest {


  def main(args: Array[String]): Unit = {
    print("请输入内容:")
    val consoleLine1 = Console.readLine()
    println("刚才输入的内容是:" + consoleLine1)

    //控制台交互--新API
    print("请输入内容(新API):")
    val consoleLine2 = StdIn.readLine()
    println("刚才输入的内容是:" + consoleLine2)

  }
}

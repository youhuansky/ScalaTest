package FatherTest

class Father {
  def shout(): Unit = {
    println("father")
  }
}

class Son extends Father {
  override def shout(): Unit = {
    println("son")
  }
}


object Main extends App {


  override def main(args: Array[String]): Unit = {
    var f1 = new Father
    var s1 = new Son
    f1.shout()
    s1.shout()
  }
}
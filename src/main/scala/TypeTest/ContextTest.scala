package TypeTest
//上下文定义
object ContextTest {

  def foo[T](x: List[T])(implicit m: Manifest[T]) = {
    println(m)
    if (m <:< manifest[String])
      println("Hey, this list is full of strings")
    else
      println("Non-stringy list")
  }

  def main(args: Array[String]): Unit = {
    foo(List("one", "two"))
    foo(List(1, 2))
    foo(List("one", 2))
  }


}

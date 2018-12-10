package TypeTest

class Pair[T, S](val first: T, val second: S) {
  override def toString = "(" + first + "," + second + ")"
}


object TypeTest {

  def main(args: Array[String]): Unit = {
    //从构造参数推断类型
    val p1 = new Pair(42, "String")
    //设置类型
    val p2 = new Pair[Any, Any](42, "String")

    val p3 = new Pair[Int, String](42, "String")

    println(p1.first.getClass)
    println(p1.second.getClass)
    println(p2.first.getClass)
    println(p2.second.getClass)
    println(p3.first.getClass)
    println(p3.second.getClass)
  }
}

//符号<:表示泛型的上界限，T是Comparable的子类
class Pair1[T <: Comparable[T]](val first: T, val second: T) {
  def smaller = if (first.compareTo(second) < 0) first else second
}

object Main1 extends App{
  override def main(args: Array[String]): Unit = {
    val p = new Pair1("Fred", "Brooks")
    println(p.smaller)
  }
}

//符号>:表示泛型的上界限，R是T的父类
class Pair2[T](val first: T, val second: T) {
  def replaceFirst[R >: T](newFirst: R) = new Pair2[R](newFirst, second)
  override def toString = "(" + first + "," + second + ")"
}

object Main2 extends App{
  override def main(args: Array[String]): Unit = {
    val p = new Pair2("Nick", "Alice")
    println(p)
    println(p.replaceFirst("Joke"))
    println(p)
  }
}

//在Java中，T同时是A和B的子类型，称之为多界，形式如：<T extends A & B>。
//在Scala中，对上界和下界不能有多个，但是可以使用混合类型，如：[T <: A with B]。
//在Java中，不支持下界的多界形式。如:<T super A &Ｂ>这是不支持的。
//在Scala中，对复合类型依然可以使用下界，如：[T >: A with B]。

//隐式转换
class Pair3[T <% Comparable[T]](val first: T, val second: T) {
  def smaller = if (first.compareTo(second) < 0) first else second
  override def toString = "(" + first + "," + second + ")"
  println(first.getClass)
  println(second.getClass)
}

object Main3 extends App {
  val p = new Pair3(4, 2)
  println(p.smaller)
}
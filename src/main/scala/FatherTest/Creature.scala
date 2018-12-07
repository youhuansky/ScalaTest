package FatherTest

class Creature {

  val leg = 5

  var arr: Array[Int] = new Array[Int](leg)

}

class SonTest extends Creature {
  override val leg = 6
}

//此时的构造顺序为：
//1)  Ant的构造器在做它自己的构造之前，调用Creature的构造器
//2)  Creature的构造器将它的range字段设为10
//3)  Creature的构造器为了初始化env数组，调用range()取值器
//4)  该方法被重写以输出（还未初始化的）Ant类的range字段值
//5)  range方法返回0，（这是对象被分配空间时所有整形字段的初始值）
//6)  env被设为长度为0的数组。
//7)  Ant构造器继续执行，将其range字段设为2.
//那么env的大小是多少？是0，惊不惊喜，意不意外？
//问题解决，3种方案：
//1)  可以将val声明为final，这样子类不可改写。
//2)  可以将超类中将数组val声明为lazy，这样安全但并不高效。
//3)  还可以使用提前定义语法，可以在超类的构造器执行之前初始化子类的val字段：

object maintest extends App {
  override def main(args: Array[String]): Unit = {
    //    var c1 = new Creature
    var c1 = new SonTest
    println(c1.arr.length)


  }
}
package FatherTest

//super并不是指继承关系，而是指的加载顺序。
//继承多个相同父特质的类，会从右到左依次调用特质的方法。
//Super指的是继承特质左边的特质，从源码是无法判断super.method会执行哪里的方法，
//如果想要调用具体特质的方法，
//可以指定：super[ConsoleLogger].log(…).其中的泛型必须是该特质的直接超类类型


trait TraitLog {
  def log(str: String)
}

trait TraitTest extends TraitLog {

  override def log(str: String): Unit = {
    println(str)
  }
}


trait TraitTest2 extends TraitLog {

  override def log(str: String): Unit = {
    println("lallalal" + str)
  }
}

abstract class TraitTestClass extends TraitLog {

}

object TraitTestOb {

  def main(args: Array[String]): Unit = {
    //    val testClass = new TraitTestClass() with TraitTest with TraitTest2
    val testClass = new TraitTestClass() with TraitTest2 with TraitTest
    testClass.log("abc")
  }
}
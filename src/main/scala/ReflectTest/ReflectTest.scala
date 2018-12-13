package ReflectTest

object ReflectTest {


  def main(args: Array[String]): Unit = {
    import scala.reflect.runtime.universe._
    val typeTagList = typeTag[List[Int]] //得到了包装Type对象的TypeTag对象
    println(typeTagList)
    //    或者使用：
    //    typeOf[List[Int]] //直接得到了Type对象

    println(typeTagList.tpe)
    println(typeTagList.tpe.decls.take(10))
  }
}

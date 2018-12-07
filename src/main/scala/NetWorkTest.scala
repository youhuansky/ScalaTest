object NetWorkTest {


  def main(args: Array[String]): Unit = {
    val con1 = new NetWork
    val con2 = new NetWork
    var mem1 = con1.join("youhuan")
    var mem2 = con1.join("miaomiao2")
    var mem3 = con2.join("miaomiao")

    println(mem1.getClass)
    println(mem2.getClass)
    mem1.contacts+=mem2
//    mem2.contacts+=mem1
    //这样不行，因为scala严格区分类的绝对路径，mem1属于con1.mem1，但是mem3属于con2.mem3，要解决这种问题，需要把
    //contacts定义为静态属性（在伴生类对象中定义），或者使用类的投影
    mem1.contacts+=mem3
  }
}

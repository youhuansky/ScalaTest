package collection

import scala.collection.mutable.ArrayBuffer

object ArrayTest {

  def main(args: Array[String]): Unit = {
    //定长数组
    val array = new Array[Any](10)
    array(0) = "haha"
    array(1) = "haha2"
    println(array.mkString(" "))

    //变长数组
    var array2=new ArrayBuffer[Any]()
    array2.append(1,2,"haha",true)
    println(array2.mkString(" "))

    //scala转java
    val array3= ArrayBuffer[String]("1","2")
    import scala.collection.JavaConversions.bufferAsJavaList
    val javaArr = new ProcessBuilder(array3)
    val command = javaArr.command
    println(command)

    println(command.getClass())

    //java转scala
    import scala.collection.JavaConversions.asScalaBuffer
    import scala.collection.mutable.Buffer
    val scalaArr: Buffer[String] = javaArr.command()
    println(scalaArr)

    //元组tuple
    val tun=(1,2,3,4)
    println(tun.getClass)
    for (x<- tun.productIterator){
      println(x)
    }
    //元组中_只能用一次，表示当前元素
    tun.productIterator.foreach({print(_);print(_)})
    println()
    tun.productIterator.foreach(i=>{print(i);print(i)})

  }



}

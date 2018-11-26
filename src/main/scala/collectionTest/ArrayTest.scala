package collectionTest

import java.util.Currency

import scala.Boolean
import scala.collection.mutable.ArrayBuffer

object ArrayTest {

  def main(args: Array[String]): Unit = {
    //定长数组
    val array = new Array[Any](10)
    array(0) = "haha"
    array(1) = "haha2"
    println(array.mkString(" "))

    //变长数组
    var array2 = new ArrayBuffer[Any]()
    array2.append(1, 2, "haha", true)
    println(array2.mkString(" "))

    //scala转java
    val array3 = ArrayBuffer[String]("1", "2")
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
    val tun = (1, 2, 3, 4)
    println(tun.getClass)
    for (x <- tun.productIterator) {
      println(x)
    }
    //元组中_只能用一次，表示当前元素
    tun.productIterator.foreach({
      print(_);
      print(_)
    })
    println()
    tun.productIterator.foreach(i => {
      print(i);
      print(i)
    })

    println()
    var list1 = List(1, 2)
    var list2 = 3 +: list1 :+ 5
    println(list2)
    println(list1)

    var list3 = 1 :: 2 :: 4 :: list1 :: Nil
    println(list3)

    println("------queue------")

    import scala.collection.mutable
    val q1 = new mutable.Queue[Any]
    println(q1)

    q1 += 1
    q1 += 3
    q1 += 5
    q1 += 7
    q1 += 9
    //    q1 ++= list3
    //+=追加当前对象，++=追加list当中的内容
    println(q1)
    q1.dequeue()
    println(q1)
    q1.enqueue(1, 2, 0)
    println(q1)
    val head = q1.head
    println(head)
    val last = q1.last
    println(last)
    val tail = q1.tail
    println(tail)

    println("-------map-------")
    var map1 = scala.collection.mutable.Map("bob" -> 20, "youhuan" -> 24)
    println(map1)
    println(map1("bob"))
    map1("youhuan") = 25
    println(map1)
    map1 += ("miaomiao" -> 22)
    println(map1)
    for (k <- map1) {
      println(k)
      println(k.getClass)
    }
    for ((k, v) <- map1) {
      println(k)
      println(v)
      println(k.getClass)
      println(v.getClass)
    }
    println("---------set---------")
    var set1 = mutable.Set(1, 2, 2, 3, 4)
    println(set1)
    set1 += 5
    println(set1)
    set1.add(6)
    println(set1)
    //    set1.remove(4)
    set1 -= 4
    println(set1)
    for (x <- set1) {
      println(x)
    }
    println(set1.max)
    var set2 = mutable.Set("ads", "zcx", "qwe")
    println(set2.max)
    //def &(that: Set[A]): Set[A]	返回两个集合的交集
    //def &~(that: Set[A]): Set[A]	返回两个集合的差集
    //def ++(elems: A): Set[A]	合并两个集合

    println("----------------------map映射函数-----------------------")
    var list6 = List("qwer", "zcxv")
    println(list6.map(x => x.toUpperCase))
    println(list6.map(_.toUpperCase))
    println(list6.flatMap(_.toUpperCase))

    //折叠，化简：将二元函数引用于集合中的函数
    var list7 = List(1, 6, 5, 1, 2)
    //计算（（1-6）-5）-1。。。
    val str = list7.reduceLeft(_ - _)
    //计算6-（5-（1-2））。。。
    val str2 = list7.reduceRight(_ - _)
    val str3 = list7.reduceLeft((x, y) => x * y)
    println(str)
    println(str2)
    println(str3)

    val i = list7.fold(0)(_ - _)
    println(i)
    //fold和foldLeft看起来是一样的
    val i2 = list7.foldLeft(0)(_ - _)
    println(i2)
    //相当与reduceRight（1,6,5,1,2,0）
    val i3 = list7.foldRight(0)(_ - _)
    println(i3)

    //scan是将fold当中的每一步都保存下来，并封装到一个集合
    val i4 = list7.scanLeft(0)(_ + _)
    println(i4)

    //foldLeft和foldRight有一种缩写方法对应分别是：/:和:\     :对着集合，/\对这foldLeft（）和foldRight（）的（）中的参数

    val sentence = "一首现代诗《笑里藏刀》:哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈刀哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈"
    //m +  (“一” -> 1, “首” -> 1, “哈” -> 1)
    var i7 = sentence.foldLeft(mutable.Map[Char, Int]())((map, c) => (map + (c -> (map.getOrElse(c, 0) + 1))))
    println(i7)
    var i8 = (mutable.Map[Char, Int]() /: sentence) ((map, c) => (map + (c -> (map.getOrElse(c, 0) + 1))))
    println(i8)


    println("---------------------------拉链----------------------------")
    val list9 = List("15837312345", "13737312345", "13811332299")
    val list10 = List(17, 87, 45)
    println(list10 zip list9)
    val tuples = list10 zip list9
    println(tuples)
    for (x <- tuples) {
      println(x.getClass)
    }
    println("---------------------------stream----------------------------")

    def streamPlusOne(x: Int): Stream[Int] = {

      return x #:: streamPlusOne(x + 1)
    }

    var tail1 = streamPlusOne(10)
    println(tail1.tail)
    println(tail1)
    println(tail1.tail)
    println(tail1)


    println("------------------------view--------------------------")
    val view1 = (1 to 100000).view.filter(x => {
      x.toString == x.toString.reverse
    })
    for (x <- view1) {
      println(x)
    }

    println("------------------------并行线程--------------------------")
    val result1 = (0 to 10000).par.map { case _ => Thread.currentThread.getName }.distinct
    println(result1)
    val result2 = (0 to 10000).map { case _ => Thread.currentThread.getName }.distinct
    println(result2)


    println("------------------------switch--------------------------")

    var i1 = 0

    var op = "afdeev"

    for (x <- op) {

      x match {
        case 'a' => i1 = 3
        case 'f' => i1 = 2
        case 'd' => i1 = 1
        case _ if x == 'v' => i1 = -1
        case _ => i1 = 0

      }
      println(i1)
    }
    //匹配模式有泛型擦除的概念，如case Map[Int,String]和case Map[String,Int]在运行时都会变成case Map[_,_]
    //除了数组Array除外因为Array本身有类型
    //    var case1=Map[Int,String]
    //    var int5=1
    //    var case1=new AnyRef;
    //    if(int5==1){
    //      case1=new Array[String](1)
    //    }else if(int5==2){
    //      case1=new Array[Int](1)
    //    }else if(int5==3){
    //      case1=Map[Int,String]
    //    }else if(int5==4){
    //      case1=Map[String,Int]
    //    }
    //
    //
    //
    //    var c3 = 0
    //    case1 match {
    //      case m:Map[Int,String] => c3 = 3
    //      case m:Map[String,Int]  => c3 = 2
    //      case m:Array[Int]  => c3 = 1
    //      case m:Array[String]  => c3= -1
    //      case m:Map[Int,String]  => c3 = 0
    //    }
    //    println("泛型擦除："+c3)


    println("-----------------------提取器-----------------------")

    val str99 = "1,2,3,4"
    str99 match {
      case Names(a, b, c) => println("啦啦啦" + a + b + c)
      case _ => println("没有匹配")

    }

    val arr = Array(1, 7, 2, 9)
    val Array(first, second, _*) = arr

    val (q, r) = BigInt(10) /% 3
    println(first, second)
    println(q, r)


    import scala.collection.JavaConverters._
    //    for ((k, v) <- System.getProperties.asScala)
    //      println(k + " -> " + v)

    //    for ((k, "") <- System.getProperties.asScala)
    //      println(k)
    for ((k, v) <- System.getProperties.asScala if v == "")
    println(k)


    println("-----------------样例类------------------")
    case class Dollar(value :Double) extends  Amount
    case class Currency(value :Double,str:String) extends  Amount
    case object Nothing extends Amount
    for (amt <- Array(Dollar(1000.0),Currency(1000.0, "EUR"),Nothing)) {
      val result = amt match {
        case Dollar(v) => "$" + v
        case Currency(_, u) => u
        case Nothing => ""
      }
      println(amt + ": " + result)
      println("-----------------高阶函数------------------")

      def plus(x:Int)=x+3

      var result1=Array(1,2,3,4,5).map(plus(_))
      println(result1.mkString(" "))

      //f:Int =>Double   代表Int是参数类型，Double是返回值类型
      def highOrderFunction1(f: Int => Double) = f(10)
      def minus7(x: Int):Double  =x - 7
      val result2 = highOrderFunction1(minus7)
      println(result2)
      println(result2.getClass)

      println("-----------------闭包------------------")
      def funTest(x1:Int)= (y1:Int)=>x1+y1
      println(funTest(5)(6))

      println("-----------------抽象控制------------------")

      def funConTest(f1:()=>Boolean)(f2:()=>Unit){
        if(f1()){
          f2()
        }else{
          print("lalala")
        }
      }

      funConTest(()=>false)(()=>print("Hello"))
      funConTest(()=>true)(()=>print("Hello"))






    }

  }



}

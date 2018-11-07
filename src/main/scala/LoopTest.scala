object LoopTest {


  def main(args: Array[String]): Unit = {
    //1 数组遍历
    val array=Array(1,2,3,"4",true)
    for (x <-array){
      println(x)
    }

    //2 开区间
    for (x <- 2 to 10){
      print(x)
    }
    println()
    //3 闭区间
    for (x <- 2 until 10){
      print(x)
    }
    println()

    //4 将遍历过程中处理的结果返回到一个，使用yield关键字
    var array2=Array(1,2,3,4,1)
    array2=for (x <- array2 )yield x+1
    println(array2.mkString(" "))

    // 5 双重for循环
    for(i <- 1 to 3; j <- 1 to 3){

      print(i  + " ")
      print(j + " ")
    }
  }

}

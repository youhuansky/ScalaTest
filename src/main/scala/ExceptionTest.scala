object ExceptionTest {

  def main(args: Array[String]): Unit = {
    try{
      var v1=divideInt(10, 1)
      print(v1)

    }catch {
      case e1:Exception =>println(e1.getMessage)
      case e2:IndexOutOfBoundsException =>println(e2.getMessage)
    }finally {
      println("uyi")
    }
  }


  def divideInt(x: Int, y: Int): Int = {
    if (y==0){
      throw new Exception("hahaha")
    }
    return x / y
  }
}

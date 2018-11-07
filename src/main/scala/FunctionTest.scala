/*函数声明调用*/
object FunctionTest {

  def main(args: Array[String]): Unit = {


    var value = play("youhuan")
    println(value)
    println(value.getClass)

    play1("213", "456")
    play1(x2 = "213", x1 = "456")
    play2("456")
    play3("456", "qwe", "ads", "zcx")
    f1("123", "ads")
    println(recursive(2,3))
  }

  def play(content: String) = {
    println(content)
    10
  }

  /*返回时()，没有显示返回值和等号，这是个方法，不是个函数，只是执行过程，不是返回结果*/
  def play4(content: String) {
    10
  }

  def play1(x1: String, x2: String) = {
    println(x1)
    println(x2)
    10
  }

  def play2(x1: String, x2: String = "miaomiao") = {
    println(x1)
    println(x2)
    10
  }

  /** 表示可以传多参数 */
  def play3(x1: String, x2: String*) = {
    println(x1)
    println(x2)
    10
  }

  /** 匿名函数 函数中分步骤要用;分割 */
  var f1 = (x1: String, x2: String) =>{println(x1+x2);println("x1")}



  def recursive(x:Int,n:Int): Int ={
      if(n>1){
        return x*recursive(x,n-1)
      }else{
        return x
      }

  }
}

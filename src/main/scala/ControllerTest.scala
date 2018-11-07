import scala.util.control.Breaks
/*
* if和while的案例
*
* */
object ControllerTest {


  def main(args: Array[String]): Unit = {
    //    val x1=10
    //    val str =if(x1>5)  1 else "youhuan"
    //    p
    // rintln(str)
    var x1 = 10
    val flag = new Breaks
    flag.breakable(
      while (x1 <= 20) {
        x1 = x1 + 1
        if(x1==15){
          flag.break()
        }
      }
    )
    println(x1)
  }
}

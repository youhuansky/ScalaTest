object exercise {


  def main(args: Array[String]): Unit = {

    printSquare()
    printTriangle()
    var map=Map("youhuan"->"24","miaomiao"->"22")
    iterateMap(map)
  }

  /*打印正方形*/
  def printSquare(): Unit = {
    for (x <- 1 to 5; y <- 1 to 15) {
      if(y!=15){
        print("*")
      }else{
        println()
      }
    }
  }

  /*打印三角形*/
  def printTriangle(): Unit = {
    for (x <- 1 to 5;y <- 1 to x) {
      if(x!=y){
        print("*")
      }else{
        println()
      }
    }
  }
  /*遍历map的参数*/
  def iterateMap(map : Map[String,String]): Unit = {
    for (x<-map){
      print(x)
    }

  }



}

object CollectionTest {


  def main(args: Array[String]): Unit = {

    //1.循环map，map当中循环出的是Tuple对象，总共有22组
    var map= Map[String,String]()
    map+=("123"->"456")
    map+=("abc"->"qwe")
    for (x<-map){
      println(x.getClass)
    }

    for ((x,y)<-map){
      println(x)
    }
  }

}

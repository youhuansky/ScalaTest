import scala.math._

object HelloScala {
  def main(args: Array[String]): Unit = {

    var v1 = 20
    v1 = 10
    println(v1)


    sqrt(100)


    println(BigInt.probablePrime(16, scala.util.Random))


    val map = Map("mike" -> "20", "youhuan" -> "22")

    println(map.get("mike"))
    println(map.get("miaomiao"))

    println(math.pow(10, 2) - math.pow(100, 2))

    val array = Array(1, 2, 3, 4, 5, 6)
    print(array(array.length - 1))
  }


}

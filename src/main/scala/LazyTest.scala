object LazyTest {

/*懒值只有在使用val的时候，函数lazyFun才会执行，适合一些初始化比较复杂，但是用的比较少的值*/
  def main(args: Array[String]): Unit = {

    lazy val va1=lazyFun()
    println("zxc")
    print(va1)

  }

  def lazyFun(): Unit = {
    println("213")
  }

}

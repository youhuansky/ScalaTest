object

SingletonTestMain {


  def main(args: Array[String]): Unit = {
    var singleton = SingletonTest()
    var singleton2 = SingletonTest()
    var singleton3 = SingletonTest()

    singleton.describe()
    singleton2.describe()
    singleton3.describe()
  }
}

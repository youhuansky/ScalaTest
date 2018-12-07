package traitTest


//特质加载顺序


//步骤总结：
//1、调用当前类的超类构造器
//2、第一个特质的父特质构造器
//3、第一个特质构造器
//4、第二个特质构造器的父特质构造器由于已经执行完成，所以不再执行
//5、第二个特质构造器
//6、当前类构造器

//多个特质从左往右依次加载

trait Logger6 {
  println("我在Logger6特质构造器中，嘿嘿嘿。。。")
  def log(msg: String)
}


trait Logger61 {
  println("我在ConsoleLogger61特质构造器中，嘿嘿嘿。。。")
}

trait ConsoleLogger6 extends Logger6 {
  println("我在ConsoleLogger6特质构造器中，嘿嘿嘿。。。")
  def log(msg: String) {
    println(msg)
  }
}

trait ShortLogger6 extends Logger61 {
  val maxLength: Int
  println("我在ShortLogger6特质构造器中，嘿嘿嘿。。。")

//  abstract override def log(msg: String) {
//    super.log(if (msg.length <= maxLength) msg else s"${msg.substring(0, maxLength - 3)}...")
//  }
}

class Account6 {
  println("我在Account6构造器中，嘿嘿嘿。。。")
  protected var balance = 0.0
}

abstract class SavingsAccount6 extends Account6 with ConsoleLogger6 with ShortLogger6{
  println("我再SavingsAccount6构造器中")
  var interest = 0.0
  override val maxLength: Int = 20
  def withdraw(amount: Double) {
    if (amount > balance) log("余额不足")
    else balance -= amount
  }
}

object Main6 extends App {
  val acct = new SavingsAccount6 with ConsoleLogger6 with ShortLogger6
  acct.withdraw(100)
  println(acct.maxLength)
}

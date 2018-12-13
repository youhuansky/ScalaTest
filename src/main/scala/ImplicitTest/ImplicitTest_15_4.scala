package ImplicitTest

class ImplicitTest_15_4 {

}
class Dog {
  val name = "金毛"
}

class Skill{
  def fly(animal: Dog, skill: String) = println(animal.name + "已领悟" + skill)
}

object Learn{
  implicit def learningType(s : Dog) = new Skill
}

object Main2 extends App{
  override def main(args: Array[String]): Unit = {
    import Learn._
    val dog = new Dog
    println(dog.getClass)
    dog.fly(dog, "飞行技能")
  }
}
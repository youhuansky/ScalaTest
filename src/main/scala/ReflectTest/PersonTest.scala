package ReflectTest

class Person(name: String, age: Int) {
  def myPrint() = {
    println(name + "," + age)
  }
}

object PersonMain extends App {
  override def main(args: Array[String]): Unit = {
    //得到JavaUniverse用于反射
    val ru = scala.reflect.runtime.universe
    //得到一个JavaMirror，一会用于反射Person.class
    val mirror = ru.runtimeMirror(getClass.getClassLoader)
    //得到Person类的Type对象后，得到type的特征值并转为ClassSymbol对象
    val classPerson = ru.typeOf[Person].typeSymbol.asClass
    //得到classMirror对象
    val classMirror = mirror.reflectClass(classPerson)
    //得到构造器Method
    val constructor = ru.typeOf[Person].decl(ru.termNames.CONSTRUCTOR).asMethod
    //得到MethodMirror
    val methodMirror = classMirror.reflectConstructor(constructor)
    //实例化该对象
    val p = methodMirror("Mike", 1)
    println(p)


    //反射方法并调用
    val instanceMirror = mirror.reflect(p)
    //得到Method的Mirror
    val myPrintMethod = ru.typeOf[Person].decl(ru.TermName("myPrint")).asMethod
    //通过Method的Mirror索取方法
    val myPrint = instanceMirror.reflectMethod(myPrintMethod)
    //运行myPrint方法
    myPrint()

    //得到属性Field的Mirror
    val nameField = ru.typeOf[Person].decl(ru.TermName("name")).asTerm
    val name = instanceMirror.reflectField(nameField)
    println(name.get)
  }
}
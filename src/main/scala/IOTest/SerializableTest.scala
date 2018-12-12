package IOTest

import java.io.{FileInputStream, FileOutputStream, ObjectInputStream, ObjectOutputStream}


class Person extends Serializable{

  var name ="youhuan"
  var age =24

  override def toString: String ={
    name+"_____"+age
  }
}


object SerializableTest {

  def main(args: Array[String]): Unit = {

    val person = new Person
    val oos = new ObjectOutputStream(new FileOutputStream("person.obj"))
    oos.writeObject(person)
    oos.close()
    val ois = new ObjectInputStream(new FileInputStream("person.obj"))
    val person2 = ois.readObject()
    ois.close()
    println(person2)


  }
}

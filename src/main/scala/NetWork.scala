import NetWork.Member

import scala.collection.mutable.ArrayBuffer

class NetWork {

  val members = new ArrayBuffer[Member]



  def join(mem:String) = {
    val m = new Member
    m.name_=(mem)
    members += m
    m
  }


}

//伴生类对象
object NetWork{

  class Member {
    var name: String = ""
    //类的投影
    //    val contacts = new ArrayBuffer[NetWork#Member]
    val contacts = new ArrayBuffer[Member]
  }

}
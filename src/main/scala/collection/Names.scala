package collection

object Names {


  def unapplySeq(str:String): Option[Array[String]] ={

    return Some(str.split(","))
  }

}




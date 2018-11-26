package collectionTest


 class Amount {


  case class Dollar(value :Double) extends  Amount
  case class Currency(value :Double,str:String) extends  Amount
  case object Nothing extends Amount
}

class SingletonTest private(){


  var name:String=_
  var age:Int=_


  def describe(): Unit ={
    println("name:"+name+",age:"+age)
  }
}
object SingletonTest{
  var instance:SingletonTest=null

  def apply(): SingletonTest = {

    if (instance==null){
      instance=new SingletonTest
      instance.age_=(10)
      instance.name_=("youhuan")
    }
    instance
  }


}
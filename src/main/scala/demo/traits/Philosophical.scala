package demo.traits

/**
  * 1.特质也是类型,可以把它当做接口使用
  * 2.可以通过extends（隐式继承特质的父类及with混入特质）和with继承特质及混入特质，
  *   1.如果某个类已经extends某个父类则必须用with混入
  *   2.如果没有extends某个父类不能直接with
  * @author lichuanzhi   
  * @date 2018/12/03 
  */
trait Philosophical {
  def philosophize(): Unit ={
    println("trait")
  }
}

class Animal
trait HasLegs

class Frog extends Animal with Philosophical with HasLegs {

  override def toString: String = "green"
  override def philosophize(): Unit = println("override trait")
}

object Philosophical{

}

object TestPhi{
  def main(args: Array[String]): Unit = {
    val phrog: Philosophical = new Frog
    phrog.philosophize()
  }
}



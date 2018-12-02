package demo

/**
  * @author lichuanzhi   
  * @date 2018/11/29 
  */
object ObjDemo {
  private var  field = "ok"

  def main(args: Array[String]): Unit = {
//    print(test1(1))
    //    val demo = new demo1(2, 3)
    val r5 = new Rational(5)
    val r6 = new Rational(6)
    println(r5 + r6)
//    println(r5.+(r6))
    println(r5 * r6)
  }

  def test1(arg1: Int) : Int = {
    arg1 + 1
    field = "好的"
    1
  }
}

class ObjDemo{

}

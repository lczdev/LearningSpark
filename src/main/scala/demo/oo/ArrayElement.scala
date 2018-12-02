package demo.oo

/**
  * @author lichuanzhi   
  * @date 2018/12/03 
  */
class ArrayElement(conts: Array[String]) extends Element {
  /**
    * 没有实现的函数（抽象方法）
    * 不同于java，这里不用显示加上abstract
    *
    * @return
    */
//  override def contents: Array[String] = conts

  /**
    * scala里面可以用字段重写父类无参数方法
    */
  override val contents: Array[String] = conts

}

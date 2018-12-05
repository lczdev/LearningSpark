package demo.oo

/**
  * 与java 的四个命名空间（分别是字段，方法，类型和包）相对，scala仅有两个命名空间
  * 值（字段，方法，包还有单例对象）
  * 类型（类和特质名）
  *
  * 命名空间与作用域不一样，作用域是块级作用域
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

  /**
    * final 表示该方法不能被子类重写、在类上面加final表示不可继承
    */
  final override def demo(): Unit = super.demo()


}



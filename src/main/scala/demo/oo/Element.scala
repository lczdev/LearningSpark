package demo.oo

/**
  * @author lichuanzhi   
  * @date 2018/12/02 
  */
abstract class Element {

  /**
    * 没有实现的函数（抽象方法）
    * 不同于java，这里不用显示加上abstract
    * @return
    */
  def contents: Array[String]

  def height: Int = contents.length

  def width: Int = if(height == 0) 0 else contents(0).length


}

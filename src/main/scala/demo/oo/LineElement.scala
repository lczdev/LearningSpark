package demo.oo

/**
  * 当发现lineElement 不明显is-a ArrayElement时
  * 且客户不需要吧lineElement当做ArrayElement使用时就没必要继承ArrayElement
  * 直接继承Element即可
  * @author lichuanzhi   
  * @date 2018/12/03 
  */
class LineElement(s: String) extends Element {

  val contents: Array[String] = Array(s)

  override def height: Int = super.height

  override def width: Int = super.width
}

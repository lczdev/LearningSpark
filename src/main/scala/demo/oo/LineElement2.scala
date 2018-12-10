package demo.oo

/**
  * @author lichuanzhi   
  * @date 2018/12/03 
  */
class LineElement2(s: String) extends ArrayElement(Array(s)) {
  override def height: Int = s.length

  override def width: Int = 1
}

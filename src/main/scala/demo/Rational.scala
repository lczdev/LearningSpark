package demo

/**
  * @author lichuanzhi
  * @version 1.0  scala没有@date 注解
  * 私有主构造函数的创建 只需在主构造参数前加private 修饰符
  **/
class Rational private (n: Int, d: Int) extends Ordered[Rational]{

  //除了字段和函数声明，其他代码均放在了主构造器里面。带类参数的才有主构造器
  require(d != 0, "分子不可为零")

  /**
    * 必须添加两个字段才可以在add中访问，类参数实际上是没有生产字段的，默认字段和函数都是public的
    * 可直接通过初始化器将类参数赋值给成员变量
    * 这三个初始化器，将按照源码中的次序添加到主构造其中。g 必需在前，因为后面要用到
    * 若主构造函数中参数带有 val 或 var关键字则该参数会变成类的属性，否则只是一个普通的参数
    *
    */
  private val g = gcd(n.abs, d.abs)
  var numer: Int = n / g
  val denom: Int = d / g

  /**
    * 辅助构造函数的定义中，必须首先都用其他构造函数（主/辅助）
    * 辅助构造器,辅助构造器之间的调用必需按源文件中的声明顺序
    */

  def this(n: Int) = this(n, 1)


  /** 可以不指定函数返回值，但要有等号，会自动推断返回类型，对于public的函数最好声明返回类型，不然用户不知道怎么用 */
  def add(that: Rational): Rational = new Rational(numer * that.denom + denom * that.numer, denom * that.denom)

  //与add一样
  def +(that: Rational): Rational = new Rational(numer * that.denom + denom * that.numer, denom * that.denom)

  /**
    * 函数重载.
    * 重载函数的匹配是根据参数的静态类型来定
    * 如果定义了隐式转换，会自动把操作数转换为Rational，这个方法都可以不用定义
    * implicit def intToRational(x: Int) = new Rational(x) 隐式转换需定义在解释器作用范围
    * @param i
    * @return
    */
  def +(i: Int): Rational = new Rational(numer + i * denom, denom)

  def *(that: Rational): Rational = new Rational(this.numer * that.numer, this.denom * that.denom)

  implicit def intToRational(x: Int): Rational = new Rational(x)

  def lessThan(that: Rational): Boolean = this.numer * that.denom < that.numer * this.denom

  //这里第一个this可选，第二个必需，if else 的三目运算
  def max(that: Rational): Rational = if (this.lessThan(that)) that else this

  //递归函数必需指定返回值类型
  private def gcd(a: Int, b: Int): Int = if(b == 0) a else gcd(b, a % b)


  override def toString: String = n + "/" + d

  override def compare(that: Rational): Int =
    (this.numer - that.denom) - (that.numer * this.denom)
}

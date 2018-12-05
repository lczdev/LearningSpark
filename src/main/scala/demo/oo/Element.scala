package demo.oo

/**
  * 继承的使用场景：
  *   1.确实是is-a关系
  *   2.客户类是否想要把子类类型当做超类类型使用
  * 其他场景最好是使用组合，可以避免脆基类的问题（比如客户类继承了类库中的类并添加了某个方法（功能为a），
  * 而在下个版本中类库设计者也添加了同名的该方法（功能为b），这到底是算覆盖还是什么如果不强制加上override包编译错误，则会等到运行时莫名其妙的问题；
  * 或者在java8之前都不好在接口新增方法，除了添加一个空实现的适配器，java8之后可以添加默认实现，无需强制子类实现）
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

  def above(that: Element): ArrayElement = {
    new ArrayElement(this.contents ++ that.contents)
  }

  def beside(that: Element): Array[String] = {
    for {
      (line1, line2) <- this.contents zip that.contents
    } yield line1 + line2
  }

  override def toString: String = contents mkString "\n"

  def demo(): Unit ={
    println("Element's implementation invoked")
  }

}

/**
  * 1.单例对象（scala中不存在static 类和static属性，取而代之的object 单例对象，单例对象是不带参数的，
  * 因为无法实例化，可以把单例对象作为一个工具类来使用）如果与类同名则称为伴生对象，伴生对象与伴生类必须在同一个源文件中，
  * 2.伴生对象和半生类可以互相访问彼此的私有属性。
  * 3.伴生对象常见作用
  *   1.作为工厂对象提供工厂方法
  *   2.在scala中可以在类和单例对象（Object）的内部（不是源文件并列和是嵌套在内部，当然源文件也可以）定义其他的类和单例对象。
  *   所以让子类私有化（不对客户暴露，只提供工厂方法）可以放在单例对象中定义子类并private修饰
  *
  *   最终代码参考160页的10.12示例
  */
object Element{
  def elem(contents: Array[String]): Element = new ArrayElement(contents)

  def elem(chr: Char, width: Int, height: Int): Element = {
    new UniformElement(chr, width, height)
  }

  private class ArrayElement(conts: Array[String]) extends Element {
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

  private class LineElement(s: String) extends Element {

    //因为这行代码是在朱构造函数中的所以可以直接使用s
    val contents: Array[String] = Array(s)

    override def height: Int = 1

    override def width: Int = s.length
  }

  private class UniformElement(
                              ch: Char,
                              override val width: Int,
                              override val height: Int
                              ) extends Element{

    private val line = ch.toString * width
    override def contents: Array[String] = Array.fill(height)(line)
  }

}

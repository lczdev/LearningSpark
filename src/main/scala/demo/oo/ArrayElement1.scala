package demo.oo

/**
  * 参数化字段（通过类型参数赋值的字段）可以直接将类参数声明和字段声明放在一起
  * 其中val前面还可以加作用域关键字private，protected等，override
  * @author lichuanzhi   
  * @date 2018/12/03 
  */
class ArrayElement1(override val contents: Array[String]) extends Element {

}

class Cat{

}

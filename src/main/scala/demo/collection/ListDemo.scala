package demo.collection

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

/**
  * @author lichuanzhi   
  * @date 2018/12/04 
  */
class ListDemo {

  /**
    * 自己实现::: 方法
    *
    * @param xs
    * @param ys
    * @tparam T
    * @return
    */
  def append[T](xs: List[T], ys: List[T]): List[T] = {
    xs match {
      case Nil => ys
      case x :: xsl => x :: append(xsl, ys) //递归拼接
    }
  }
}

object ListDemo {

  // 工厂方法
  private val ints = List(1, 2, 3)
  private val abced = List('a', 'b', 'c', 'd', 'e')
  //nil 必须放在最后且必需否则报错
  private val value = "test1" :: "test2" :: "test3" :: Nil

  //空列表
  val fruit = List()
  val fruit1: Nil.type = Nil
  val isNil: Boolean = List() == Nil
  //判断类型，转换用asInstanceOf
  val isNothing: Boolean = Nil.isInstanceOf[List[Nothing]]

  def matchList: List[String] => Int = {
    case a :: rest => rest.size
  }


  def main(args: Array[String]): Unit = {
    println(isNil) //true
    println(isNothing) //true
    println(matchList(value))
    println(new ListDemo().append(List(1, 2), List(3, 4)).size)
    println(List.range(1, 5) flatMap (i => List.range(1, i) map (j => (i, j)))) //List((2,1), (3,1), (3,2), (4,1), (4,2), (4,3))
    println(for (i <- List.range(1, 5); j <- List.range(1, i)) yield (i, j)) //List((2,1), (3,1), (3,2), (4,1), (4,2), (4,3))
    println(abced take 2) // List(a, b)
    println(abced takeRight 2) // List(d, e)
    println(abced drop 2) //List(c, d, e)
    println(abced takeWhile(r => r == 'e'))
    println(abced.head) //第一个元素
    println(abced.tail) //除第一个元素外的尾列表
    println(abced.init) //与上面tail相反
    println(abced.last)//与上面head相反

//    println(abced.foldRight('e')())

    //ListBuffer
    val buf = new ListBuffer[Int]
    buf += 1
    buf += 2
    println(buf.toList) //List(1, 2)

    //数组
    val arrays = new Array[Char](10)
    val array1 = Array(1,2,3)
    val abuf = new ArrayBuffer[Int]()
    abuf += 1
    println(abuf.size)
    abced.copyToArray(arrays)
    println(arrays.mkString)

    val ll: List[String] = null
  }
}

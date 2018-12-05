package demo

import java.io.{File, PrintWriter}
import java.util.Date

/**
  * 控制抽象，将控制逻辑抽象出来，让客户端提供具体实现，简化客户端调用.
  * 类似于模板方法模式
  *
  * @author lichuanzhi   
  * @date 2018/12/02 
  */
object FileMatcher {
  private def filehere = new File(".").listFiles()

//  def fileEnding(query: String) =
//    for(file <- filehere; if file.getName.endsWith(query))
//      yield file

  /**
    * 定义一个高价函数（接受函数字面量作为参数的函数）,
    * matcher的类型声明时指定参数的类型和返回值的类型.
    * @param query
    * @param matcher
    * @return
    */
  def fileMatching(query: String, matcher: (String, String) => Boolean): Array[File] = {
    for(file <- filehere; if matcher(file.getName, query))
          yield file
  }

  def fileMatching(matcher: String => Boolean): Array[File] = {
    for(file <- filehere; if matcher(file.getName))
      yield file
  }

  /**
    * endsWith 函数字面量中的填空符号依次对应matcher函数声明的第一个第二个参数也就是fileName和query字符串
    * 下面三种形式都是可以的(将光标定位到参数或方法名按alter + enter键转换不同的形式)
    * @param query
    * @return
    */
  def fileEnding(query: String): Array[File] = fileMatching(query, _.endsWith(_))

//  def fileContaining(query: String): Array[File] = fileMatching(query, _ contains _)
  /**
    * 最终简化版，因为query可以通过matcher传进去，所以上面fileMatching的声明也可以去掉query这个参数
    * 利用了闭包的特性，绑定了除绑定变量fileName之外的自由变量query
    * @param query
    * @return
    */
  def fileContaining(query: String): Array[File] = fileMatching(_.contains(query))

  def fileRegex(query: String): Array[File] =
    fileMatching(query, (fileName, query) => fileName.matches(query))

  /**
    * 柯里化，将原本多个参数的一个参数列表，拆分为多个参数列表。
    * 本身的调用过程是先对这个函数应用第一个参数列表得到一个函数字面量再应用下面的参数，依次类推
    * 柯里化的好处是
    *   1.当函数的最后一个参数是需要函数字面量的时候且只有一个参数的时候（只有一个参数的时候才能将括号换成大括号或省略括号）
    *     通过最后一个参数用大括号实现像内置的控制结构如while一样
    *   2.通过部分应用实现重载
    *
    * @param file
    * @param op
    */
  def withPrintWriter(file: File)(op: PrintWriter => Unit): Unit = {
    val printWriter = new PrintWriter(file)
    try {
      op(printWriter)
    } finally
      printWriter.close()
  }

  /**
    * 传名参数，直接传递参数名称：如果是空参的函数字面量则可以省略掉()
    * 下面两个函数是等价的
    * 在调用第一种函数时可以不用byNameAssert(() => xxx)直接byNameAssert(xxx)
    * @param predicaate
    */
//  def byNameAssert(predicaate:  => Boolean): Unit ={
//
//  }
  def byNameAssert(predicaate: () => Boolean): Unit ={

  }

  def main(args: Array[String]): Unit = {

    //柯里化调用
    val file = new File("")
    withPrintWriter(file){
      _.println(new Date)
    }
  }


}

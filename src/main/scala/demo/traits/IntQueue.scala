package demo.traits

import scala.collection.mutable.ArrayBuffer

/**
  * 注意包名不能是关键字，否则报类找不到
  * 堆叠改动特质
  * @author lichuanzhi   
  * @date 2018/12/03 
  */
abstract class IntQueue {
  def get(): Int
  def put(x:  Int)
}

class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]()
  override def get(): Int = buf.remove(0)
  override def put(x: Int): Unit = buf += x
}

/**
  * 这里是直接继承IntQueue
  */
trait Doubling extends IntQueue {

  /**
    * 1.这里的super调用是调用BasicIntQueue(混入时决定，因下面混入的是myqueue且它继承了BasicIntQueue)
    * 所以调用的是BasicIntQueue的put方法
    * 2.abstract override 这组关键字同时使用智能在特质里面
    * 3.抽象方法中有super调用也只有特质里面才有
    * @param x
    */
  abstract override def put(x: Int): Unit = super.put(2 * x)
}

trait Incrementing extends BasicIntQueue {
  abstract override def put(x: Int): Unit = super.put(x + 1)
}

trait Filtering extends BasicIntQueue {
  abstract override def put(x: Int): Unit = if (x>= 0) super.put(x)
}

/**
  * 因为这个类没有一行代码，所以这里跟下面 new BasicIntQueue with Doubling效果一样
  */
class MyQueue extends BasicIntQueue with Doubling

object TestIntQueue {
  def main(args: Array[String]): Unit = {
    val queue = new BasicIntQueue with Doubling
    val queue1 = new BasicIntQueue with Incrementing with Filtering
    val queue2 = new BasicIntQueue with Filtering with Incrementing
    queue.put(10)
    println(queue.get())
    queue1.put(5)
    println(queue1.get())
  }
}

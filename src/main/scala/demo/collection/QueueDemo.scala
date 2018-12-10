package demo.collection

import scala.collection.mutable


/**
  * @author lichuanzhi   
  * @date 2018/12/04 
  */
class QueueDemo {

}

object QueueDemo {

  def main(args: Array[String]): Unit = {
    val q = mutable.Queue(1, 2, 3)
    val businessName = "test"
    //  val listData: mutable.Seq[collection.Map[String, String]] = mutable.Seq(Map(
    //    "status" -> "1",
    //    "create_time" -> "2018-12-09 12:04:23"
    //  ),mutable.Map(
    //    "status" -> "1",
    //    "create_time" -> "2018-12-09 12:04:23"
    //  ))
    //  val stringToMaps = listData.filter(data => "1".equals(data.get("status").))
    //    .groupBy(elem => s"$businessName:${elem.get("create_time").substring(0, 10)}:${elem.get("create_time").substring(11, 13)}")
    println(BigDecimal("1.3") + BigDecimal("1.56"))
    println(s"$businessName:++")
  }

}
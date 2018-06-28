import org.apache.spark.{SparkConf, SparkContext}

/**
  * Copyright: Copyright (c) 2018 Ztesoft
  *
  *
  * Modification History:
  * Date         Author          Version            Description
  * ------------------------------------------------------------
  * 2018/6/27      wangtongbang          v1.0.0               修改原因
  */
object SparkDemo {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("mySpark")
    //setMaster("local") 本机的spark就用local，远端的就写ip
    //如果是打成jar包运行则需要去掉 setMaster("local")因为在参数中会指定。
    conf.setMaster("local")
    val sc =new SparkContext(conf)
    val rdd =sc.makeRDD(List(1,2,3,4,5,6))
    val mappedRDD=rdd.filter(_>2).collect()
    //对集合求和
    println(rdd.reduce(_+_))
    //输出大于10的元素
    for(arg <- mappedRDD)
      print(arg+" ")
    println()
    println("math is work")
  }
}

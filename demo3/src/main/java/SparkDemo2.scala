import org.apache.spark.{SparkConf, SparkContext}

/**
  * Copyright: Copyright (c) 2018 Ztesoft
  *

  *
  *        Modification History:
  *        Date         Author          Version            Description
  *        ------------------------------------------------------------
  *        2018/6/28      wangtongbang          v1.0.0               修改原因
  */
object SparkDemo2 {
  def main(args: Array[String]): Unit = {
    var conf = new SparkConf().setMaster("local").setAppName("SparkDemo2")
    var sc = new SparkContext(conf)
    var data = Array(1,2,3,4,5)
    var hhh = sc.parallelize(data,2).reduce((a,b)=>a+b);
    println(hhh)
  }
}

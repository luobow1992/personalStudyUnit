import org.apache.spark.{SparkConf, SparkContext}

/**
  * Copyright: Copyright (c) 2018 Ztesoft
  *
  *
  *
  * Modification History:
  * Date         Author          Version            Description
  * ------------------------------------------------------------
  * 2018/6/28      wangtongbang          v1.0.0               修改原因
  */
object WordCountByScala {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("word-count").setMaster("local[4]")
    val sc = new SparkContext(conf)
    val line = sc.textFile("demo3/src/main/resources/word.txt")
    line.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _).collect().foreach(println)
    sc.stop()
  }
}


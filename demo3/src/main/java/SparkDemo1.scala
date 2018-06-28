import org.apache.spark.sql.SparkSession

/**
  * Copyright: Copyright (c) 2018 Ztesoft
  *
  *
  * Modification History:
  * Date         Author          Version            Description
  * ------------------------------------------------------------
  * 2018/6/28      wangtongbang          v1.0.0               修改原因
  */
object SparkDemo1 {
  def main(args: Array[String]): Unit = {
    val logFile = "demo3/src/main/resources/word.txt" // Should be some file on your system
    val spark = SparkSession.builder.appName("Simple Application").getOrCreate()
    val logData = spark.read.textFile(logFile).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numCs = logData.filter(line => line.contains("c")).count()
    println(s"Lines with a: $numAs, Lines with c: $numCs")
    spark.stop()
  }
}

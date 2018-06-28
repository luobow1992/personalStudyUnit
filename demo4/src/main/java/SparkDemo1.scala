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
    val sparkSession = SparkSession.builder().appName("wangtb").master("local")
      .config("spark.some.config.option","some-value").getOrCreate()
    val person = sparkSession.read.json("demo4/src/main/resources/person.json")
    // 显示json文件中的数据
    person.show()
    // 将age字段都加1,并更改别名
    person.select((person("age")+1).alias("my_age")).show()
    //使用spark在内存中创建一个表"TEST_PERSON_TABLE"
    person.createOrReplaceTempView("TEST_PERSON_TABLE")
    //执行一些sql查询
    val selectResult = sparkSession.sql("select * from TEST_PERSON_TABLE t where t.name='Andy'")
    selectResult.show()
    sparkSession.stop()
  }
}

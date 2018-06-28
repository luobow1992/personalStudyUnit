
import org.apache.spark.sql.SparkSession


object SparkSQLExample {

  case class Person(name: String, age: Long)

  def main(args: Array[String]) {
    val spark = SparkSession
      .builder()
      .appName("Spark SQL basic example")
      .config("spark.some.config.option", "some-value")
      .getOrCreate()
    import spark.implicits._

    runDatasetCreationExample(spark)
    spark.stop()
  }



  private def runDatasetCreationExample(spark: SparkSession): Unit = {
    import spark.implicits._
    val caseClassDS = Seq(Person("Andy", 32)).toDS()
    caseClassDS.show()

    val primitiveDS = Seq(1, 2, 3).toDS()
    primitiveDS.map(_ + 1).collect() // Returns: Array(2, 3, 4)

    val path = "examples/src/main/resources/people.json"
    val peopleDS = spark.read.json(path).as[Person]
    peopleDS.show()

  }


}

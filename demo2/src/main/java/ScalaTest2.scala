import scala.runtime.Nothing$

/**
  * Copyright: Copyright (c) 2018 Ztesoft
  *
  *
  * Modification History:
  * Date         Author          Version            Description
  * ------------------------------------------------------------
  * 2018/6/27      wangtongbang          v1.0.0               修改原因
  */
object ScalaTest2 extends App {
  val list: List[Any] = List(
    "a string",
    732,  // an integer
    'c',  // a character
    true, // a boolean value
    () => "an anonymous function returning a string"
  )

  list.foreach(element => println(element))


  var xiaolian:Char = '☺';
  println(xiaolian)


}

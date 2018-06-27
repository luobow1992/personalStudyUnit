/**
  * Copyright: Copyright (c) 2018 Ztesoft
  *
  * Modification History:
  * Date         Author          Version            Description
  * ------------------------------------------------------------
  * 2018/6/27      wangtongbang          v1.0.0               修改原因
  */
object ScalaTest1 extends App {

  val add = (x: Int, y: Int) => {
    var temp = x + 1;
    temp + y
  }
  println(add(1, 2))

  var add1 = (x: Int, y: Int) => {
    x + 1;
    x + y
  }

  println(add1(1, 2))

  var addThenMultiply = (x: Int, y: Int) => (x + y)

  /**
    * Method支持多个表达式操作这种写法，Funtion不支持
    *
    * @param x
    * @param y
    * @param multiplier
    * @return
    */
  def addThenMultiply1(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier

  println(addThenMultiply1(1, 2)(3)) // 9


  class Greeter(prefix: String, suffix: String) {
    //The return type of the method greet is Unit, which says there’s nothing meaningful to return. It’s used similarly to void in Java and C.
    def greet(name: String): Unit =
      println(prefix + name + suffix)
  }


  val greeter = new Greeter("Hello, ", "!")
  greeter.greet("Scala developer") // Hello, Scala developer


  //scala 中没有 static 关键字对于一个class来说，所有的方法和成员变量在实例被 new 出来之前都是无法访问的
  // 因此class文件中的main方法也就没什么用了，
  // scala object 中所有成员变量和方法默认都是 static 的所以 可以直接访问main方法。
}

/**
  * Copyright: Copyright (c) 2018 Ztesoft
  *
  *
  * Modification History:
  * Date         Author          Version            Description
  * ------------------------------------------------------------
  * 2018/6/27      wangtongbang          v1.0.0               修改原因
  */
object ScalaTest extends App {
  //不可变参数定义
  val a = 2;
  println(a)
  //等价于下面这种赋值方式,Int类型可以不写，根据后面赋值的类型进行判断
  val a1: Int = 2;
  println(a1)

  // a = 3;重新给a 赋值a会报错
  //可变参数定义
  var b = 2;
  b = 12;
  println(b)

  //输出一段话可以用"""XXX""""
  println(
    """你好
世界"""
  )

  //输出多个操作语句，可以用{}
  println({
    var temp = 1;
    temp + 1;
  })
}

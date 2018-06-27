> Object和Class的区别

scala 中没有 static 关键字对于一个class来说，所有的方法和成员变量在实例被 new 出来之前都是无法访问的因此class文件中的main方法也就没什么用了，scala object 中所有成员变量和方法默认都是 static 的所以 可以直接访问main方法。

```scala
Object ObjectDemo{
  def add (x:Int,y:Int):Int = {x+y}
}
```
如果我们向调用add方法时，直接使用ObjectDemo.add(1,2) 就可以了
而Class我们需要new一个对象来调用

> Trait 类似于Java中的接口

```scala
//Traits can also have default implementations.

trait Greeter {
  def greet(name: String): Unit =
    println("Hello, " + name + "!")
}
//You can extend traits with the extends keyword and override an implementation with the override keyword.

class DefaultGreeter extends Greeter

class CustomizableGreeter(prefix: String, postfix: String) extends Greeter {
  override def greet(name: String): Unit = {
    println(prefix + name + postfix)
  }
}

val greeter = new DefaultGreeter()
greeter.greet("Scala developer") // Hello, Scala developer!

val customGreeter = new CustomizableGreeter("How are you, ", "?")
customGreeter.greet("Scala developer") // How are you, Scala developer?

```


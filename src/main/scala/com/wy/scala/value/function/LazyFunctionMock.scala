
package com.wy.scala.value.function

object LazyFunctionMock {

  def main(args: Array[String]): Unit = {

    val x = maybeTwice(true, lazyFunction)
    println(x)
  }

  def lazyFunction() ={
    println("hi")
    41+2
  }

  private def maybeTwice(b: Boolean, i: => Int) ={
    println("1111")
    if(b) {
      i+i
    }else {
      0
    }
  }

}
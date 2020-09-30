package com.wy.scala.forkJoin

import scala.concurrent._
/**
 * ClassName ExecutorsCreate
 * Date 2019/10/16
 *
 * @author wangyi
 **/

object ExecutorsCreate extends App {

  val executor = new forkjoin.ForkJoinPool()

  executor.execute(new Runnable {
    override def run(): Unit = println("This task is run asynchronously.")
  })
  Thread.sleep(500)
}


object ExecutionContextGlobal extends  App {
  val ectx = ExecutionContext.global
  ectx.execute(new Runnable {
    override def run(): Unit = println("Running on the execution context.")
  })

  Thread.sleep(500)
}
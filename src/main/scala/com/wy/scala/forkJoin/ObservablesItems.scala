package com.wy.scala.forkJoin

import rx.lang.scala.{Observable, Observer, Subscription}

import scala.concurrent.{ExecutionContext, Future}
import scala.concurrent.duration._

/**
 * ClassName ObservablesItems
 * Date 2019/10/17
 *
 * @author wangyi
 **/
object ObservablesItems extends App {

  val o = Observable.timer(1.second)

  o.subscribe(_=>println("TimeOut"))
  o.subscribe(_=>println("Another timeout"))

  Thread.sleep(2000)

}



object ObservablesLifetime extends App {

  val classics = List("Good, bad, ugly", "Titanic", "Die Hard")

  val movies = Observable.from(classics)

  movies.subscribe(new Observer[String](){
    override def onCompleted(): Unit = super.onCompleted()
  })
import ExecutionContext.Implicits.global

object ObservablesCreateFuture extends  App {

  val f = Future {"back to the Future(s)"}

  val o = Observable.create[String]{
    obs => {
      f foreach{ case s=> obs.onNext(s); obs.onCompleted()}
      f.failed foreach{ case t => obs.onError(t)}
      Subscription()
    }
  }
  o.subscribe(println(_))
}
}

import java.util.concurrent.atomic.AtomicInteger

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

import scala.collection.mutable
import scala.io.Source

/**
 * ClassName HelloActor
 * Date 2019/10/18
 *
 * @author wangyi
 **/
class HelloActor(val hello: String) extends Actor {

  override def receive: Receive = {
    case `hello` => {
      println(s"Received a '$hello'...... $hello")
    }
    case msg => {
      println(s"Unexpected message '$msg'")
      context.stop(self)
    }

  }
}

object HelloActor {

  def props(hello: String) = Props(new HelloActor(hello))

  def propsAlt(hello: String) = Props(classOf[HelloActor], hello)

}

object ActorsCreate extends App {

  lazy val ourSystem = ActorSystem("OurExampleSystem")

  val hiActor: ActorRef =
    ourSystem.actorOf(HelloActor.props("hi"), name = "greeter")

  hiActor ! "hi"
  Thread.sleep(1000L)

  hiActor ! "hola"
  Thread.sleep(1000)

  ourSystem.terminate()
}

class CountdownActor extends Actor {

  var n:AtomicInteger = new AtomicInteger(10);

  def counting :Actor.Receive ={

    case "count" => {
      n.decrementAndGet()
      println(s"n == $n")
      if(n.get()== 0) {
        context.become(done)
      }
    }
  }

  def done = PartialFunction.empty

  def receive = counting

}

object ActorsCountdown extends App {
  lazy val ourSystem = ActorSystem("OurExampleSystem")

  val countdown = ourSystem.actorOf(Props[CountdownActor])

  for(i <- 0 until  20) {
    countdown ! "count"
    Thread.sleep(2000)
    ourSystem.terminate()
  }



  object DictionaryActor {
    case class Init(path :String)
    case class IsWord(w:String)
    case object End
  }
  class DictionaryActor extends Actor {

    private val dictionary = mutable.Set[String]()

    override def receive: Receive = uninitialized
      def uninitialized :PartialFunction[Any, Unit] ={
        case DictionaryActor.Init(path) =>{
          val stream = getClass.getResource(path)

        }
      }

    def initialized :PartialFunction[Any, Unit] ={
      case DictionaryActor.IsWord(w) =>{
        println("")
      }
      case DictionaryActor.End =>{

      }
    }


  }
}
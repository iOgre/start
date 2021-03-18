package iogre
import zio.console._
import zio.ExitCode
import zio.URIO
import zio.ZEnv

object Main extends zio.App {

  //URIO[E, C] = ZIO[R, Nothing, C] - requires R, cannot fail, returns C
  def run(args: List[String]): URIO[ZEnv,ExitCode] = myAppLogic.exitCode

  val myAppLogic = for {
    _ <- putStrLn("Hell, o Name?")
    name <- getStrLn
    _ <- putStrLn(s"$name, welcome")
  } yield()


}

import zio._
object IntegrationExample {
  val runtime = Runtime.default
  runtime.unsafeRun(Task(print("hello")))

}
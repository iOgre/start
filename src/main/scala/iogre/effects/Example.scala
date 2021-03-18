package iogre.effects

object Example {

  sealed trait Console[A]

  final case class Return[A](value: () => A)                    extends Console[A]
  final case class PrintLine[A](line: String, rest: Console[A]) extends Console[A]
  final case class ReadLine[A](rest: String => Console[A])      extends Console[A]

  // Console[A] is immutable, type-safe value which represents a console program
  // which returns a value of type a

  // The Console datastructure is an ordered tree, and at the very and of the
  // program, you will find a Return instruction that stores a value of type A,
  // which is the return value of Console[A] program

  val exampl = PrintLine(
    "Hello, name?",
    ReadLine(name => PrintLine(s"Hello $name", Return(() => ())))
  )

  //This is just describes the program which prints message, asks for input and prints message depending
  //on input

  //To translate it into procedural effcts we need an interpreter

  def interpret[A](progr: Console[A]): A = progr match {
    case Return(value) => value()
    case PrintLine(line, rest) =>
      println(line)
      interpret(rest)
    case ReadLine(rest) =>
      interpret(rest(scala.io.StdIn.readLine()))
  }

}

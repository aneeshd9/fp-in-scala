package fpinscala.datastructures

enum List[+A]:
  case Nil
  case Cons(head: A, tail: List[A])

object List:
  def apply[A](as: A*): List[A] =
    if as.isEmpty then Nil
    else Cons(as.head, apply(as.tail*))

  def sum(ints: List[Int]): Int = ints match
    case Nil              => 0
    case Cons(head, tail) => head + sum(tail)

  def product(doubles: List[Double]): Double =
    doubles match
      case Nil              => 1.0
      case Cons(0.0, _)     => 0.0
      case Cons(head, tail) => head * product(tail)

  def tail[A](as: List[A]): List[A] =
    as match
      case Nil              => sys.error("tail of an empty list!")
      case Cons(head, tail) => tail

  def setHead[A](as: List[A], a: A): List[A] =
    as match
      case Nil              => sys.error("setHead on an empty list!")
      case Cons(head, tail) => Cons(a, tail)

  def drop[A](as: List[A], n: Int): List[A] =
    if n <= 0 then as
    else
      as match
        case Nil           => Nil
        case Cons(_, tail) => drop(tail, n - 1)

  def dropWhile[A](as: List[A], p: A => Boolean): List[A] =
    as match
      case Cons(head, tail) if p(head) => tail
      case _                           => as

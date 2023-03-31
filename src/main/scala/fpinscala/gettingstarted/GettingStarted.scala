package fpinscala.gettingstarted

object MyProgram:
  def abs(n: Int): Int =
    if n < 0 then -n
    else n

  private def formatAbs(x: Int): String =
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))

  private def formatFactorial(n: Int): String =
    val msg = "The factorial of %d is %d"
    msg.format(n, factorial(n))

  def formatResult(name: String, n: Int, f: Int => Int): String =
    val msg = "The %s of %d is %d"
    msg.format(name, n, f(n))

  def factorial(n: Int): Int =
    @annotation.tailrec
    def go(n: Int, acc: Int): Int =
      if n <= 0 then acc
      else go(n - 1, n * acc)

    go(n, 1)

  def fib(n: Int): Int =
    @annotation.tailrec
    def loop(n: Int, a: Int, b: Int): Int =
      if n <= 0 then a
      else loop(n - 1, b, a + b)

    loop(n, 0, 1)

object Search:
  def findFirst(ss: Array[String], key: String): Int =
    @annotation.tailrec
    def loop(n: Int): Int =
      if n >= ss.length then -1
      else if ss(n) == key then n
      else loop(n + 1)

    loop(0)

object PolymorphicFunctions:
  def findFirst[A](as: Array[A], p: A => Boolean): Int =
    def loop(n: Int): Int =
      if n >= as.length then -1
      else if p(as(n)) then n
      else loop(n + 1)

    loop(0)

  def isSorted[A](as: Array[A], gt: (A, A) => Boolean): Boolean =
    @annotation.tailrec
    def loop(n: Int): Boolean =
      if n >= as.length - 1 then true
      else if gt(as(n), as(n + 1)) then false
      else loop(n + 1)

    loop(0)

  def partial1[A, B, C](a: A, f: (A, B) => C): B => C =
    (b: B) => f(a, b)

  def curry[A, B, C](f: (A, B) => C): A => B => C =
    (a: A) => (b: B) => f(a, b)

  def uncurry[A, B, C](f: A => B => C): (A, B) => C =
    (a: A, b: B) => f(a)(b)

  def compose[A, B, C](f: B => C, g: A => B): A => C =
    (a: A) => f(g(a))


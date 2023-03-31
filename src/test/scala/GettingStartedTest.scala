class GettingStartedTest extends munit.FunSuite {
  import fpinscala.gettingstarted.MyProgram.*

  test("Fibonacci test") {
    assertEquals(fib(0), 0)
    assertEquals(fib(1), 1)
    assertEquals(fib(5), 5)
    assertEquals(fib(7), 13)
  }
}

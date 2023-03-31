class GettingStartedTest extends munit.FunSuite {
  import fpinscala.gettingstarted.MyProgram.*
  import fpinscala.gettingstarted.PolymorphicFunctions.*

  test("Fibonacci test") {
    assertEquals(fib(0), 0)
    assertEquals(fib(1), 1)
    assertEquals(fib(5), 5)
    assertEquals(fib(7), 13)
  }

  test("Polymorphic findFirst test") {
    assertEquals(findFirst(Array(1, 3, 4, 5), x => x == 4), 2)
    assertEquals(findFirst(Array(1, 3, 6, 7), x => x == 9), -1)
    assertEquals(findFirst(Array(1.2, 4.6, 7.99), x => x == 1.2), 0)
  }

  test("Polymorphic isSorted test") {
    assertEquals(isSorted(Array(1, 2, 3, 4, 5), _ > _), true)
    assertEquals(isSorted(Array(1, 2, 3, 5, 4), _ > _), false)
    assertEquals(isSorted(Array(1.2, 3.4, 5.6, 10.1), _ > _), true)
  }
}

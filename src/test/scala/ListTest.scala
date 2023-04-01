class ListTest extends munit.FunSuite {
  import fpinscala.datastructures.List
  import fpinscala.datastructures.List.*

  test("Sum of List[Int] test") {
    assertEquals(sum(List(1, 2, 3)), 6)
    assertEquals(sum(List(0, 0, 0)), 0)
  }

  test("Product of List[Double] test") {
    assertEquals(product(List(1.0, 2.0, 3.0)), 6.0)
    assertEquals(product(List(1.0, 2.0, 0.0)), 0.0)
  }

  test("tail of a List[A] test") {
    assertEquals(tail(List(1, 2, 3)), List(2, 3))
    assertEquals(tail(List(1)), Nil)
  }

  test("setHead of a List[A] test") {
    assertEquals(setHead(List(1, 2, 3), 3), List(3, 2, 3))
    assertEquals(setHead(List(1), 3), List(3))
    assertEquals(setHead(List(1.2, 3.2), 0.0), List(0.0, 3.2))
  }

  test("drop from List[A] test") {
    assertEquals(drop(List(1, 2, 3), -1), List(1, 2, 3))
    assertEquals(drop(List(1, 2, 3), 0), List(1, 2, 3))
    assertEquals(drop(List(1, 2, 3), 2), List(3))
    assertEquals(drop(List(1, 2, 3), 3), Nil)
  }
}

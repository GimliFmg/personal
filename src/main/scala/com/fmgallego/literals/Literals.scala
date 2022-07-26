package com.fmgallego.literals

object Literals {

  object Snake {
    val LengthLowerLimit: Int = 3
    val LengthUpperLimit: Int = 10
    val SnakeILengthLimit: Int = 2
    val ValueZero = 0
    val Value1 = 1
    val SnakeArray: Array[Array[Int]] =
      Array(Array(0, 0), Array(1, 0), Array(1, 1), Array(0, 1))
   }

  object ErrorMessages {
   val SnakeOutOfBoardLimitMsg: String = "Your Snake places outside Board's limits."
   val Snake2DimError: String = "Your Snake has to have exactly 2 dimensions. Check your input Array[Array[Int]]"
   val SnakeLengthMsg: String = "Your Snake has to have a length between 3 and 7. Check your input Array[Array[Int]]"
   val SnakeAdjacencyMsg: String = "Some of your Snake position points are not adjacent."
  }

}

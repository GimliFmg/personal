package com.fmgallego.literals

object Literals {

  object Snake {
    val LengthLowerLimit: Int = 3
    val LengthUpperLimit: Int = 10
    val SnakeILengthLimit: Int = 2
    val ValueZero = 0
    val Value1 = 1
    val DashSeparator: String = "-"
    val StringXSeparator: String = "x"
    val MoveRight = "R"
    val MoveLeft = "L"
    val MoveUp = "U"
    val MoveDown = "D"
   }

  object ErrorMessages {
   val SnakeOutOfBoardLimitMsg: String = "Your Snake places outside Board's limits."
   val Snake2DimError: String = "Your Snake has to have exactly 2 dimensions. Check your input SnakeArray"
   val SnakeLengthMsg: String = "Your Snake has to have a length between 3 and 7. Check your input SnakeArray"
   val SnakeAdjacencyMsg: String = "Some of your Snake position points are not adjacent."
  }

}

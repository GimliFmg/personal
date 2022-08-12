package com.fmgallego.literals

object Literals {

  object SnakeLiterals {
    val LengthLowerLimit: Int = 3
    val UpperLimit: Int = 10
    val SnakeILengthLimit: Int = 2
    val Value0 = 0
    val Value1 = 1
    val ExclamationSep: String = "!"
    val StringXSeparator: String = "x"
    val Right = "R"
    val Left = "L"
    val Up = "U"
    val Down = "D"
    val ListaMovimientos: List[String] = List(Left, Up, Right, Down)
    val BigInt10To9Plus7: Int = 10^9 + 7
   }

  object ErrorMessages {
   val SnakeOutOfBoardLimitMsg: String = "Your Snake places outside Board's limits."
   val Snake2DimError: String = "Your Snake has to have exactly 2 dimensions. Check your input SnakeArray"
   val SnakeLengthMsg: String = "Your Snake has to have a length between 3 and 7. Check your input SnakeArray"
   val SnakeAdjacencyMsg: String = "Some of your Snake position points are not adjacent."
  }

}

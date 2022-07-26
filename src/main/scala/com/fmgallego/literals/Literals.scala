package com.fmgallego.literals

import com.fmgallego.snakechallenge.Operations.SnakeArray

object Literals {

  object Snake {
    val LengthLowerLimit: Int = 3
    val LengthUpperLimit: Int = 10
    val SnakeILengthLimit: Int = 2
    val ValueZero = 0
    val Value1 = 1
    val MoveRight = "R"
    val MoveLeft = "L"
    val MoveUp = "U"
    val MoveDown = "D"
    // TODO: find if it makes sense to create a method that transforms string into array
    // in order to pass Snake Array as a Scallop input arg
    val SnakeInputArray: SnakeArray =
      Array(Array(0, 0), Array(1, 0), Array(1, 1), Array(0, 1))
   }

  object ErrorMessages {
   val SnakeOutOfBoardLimitMsg: String = "Your Snake places outside Board's limits."
   val Snake2DimError: String = "Your Snake has to have exactly 2 dimensions. Check your input SnakeArray"
   val SnakeLengthMsg: String = "Your Snake has to have a length between 3 and 7. Check your input SnakeArray"
   val SnakeAdjacencyMsg: String = "Some of your Snake position points are not adjacent."
  }

}

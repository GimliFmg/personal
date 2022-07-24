package com.fmgallego.snakechallenge

import com.fmgallego.literals.Literals.Snake.{LengthLowerLimit, LengthUpperLimit}

class Snake(snake: Array[Array[Int]]) {

  val SnakeLength: Int = snake.length
  val SnakeLengthFlag: Boolean =
    (LengthLowerLimit >= SnakeLength) && (SnakeLength <= LengthUpperLimit)
}

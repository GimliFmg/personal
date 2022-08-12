package com.fmgallego.snakechallenge

import com.fmgallego.snakechallenge.Operations.{assertSnakeConstraints, SnakeArray}
import org.apache.logging.log4j.scala.Logging

case class Snake(snake: SnakeArray) {

  val SnakeArray: SnakeArray = snake
}

object Snake extends Logging {

  def apply(snake: SnakeArray, board: Array[Int],
            newSnakeFlag: Boolean = false,
            newSnake: SnakeArray = Array(Array.empty)): Option[Snake] = {

    if (newSnakeFlag) {
      val BoardAndSnakeLimits: Boolean =
        assertSnakeConstraints(snake, board, newSnakeFlag = true, newSnake)
      if (BoardAndSnakeLimits) Some(new Snake(snake))
      else None
    }
    else {
      val BoardAndSnakeLimits: Boolean = assertSnakeConstraints(snake, board)
      if (BoardAndSnakeLimits) Some(new Snake(snake))
      else None
    }

  }

}

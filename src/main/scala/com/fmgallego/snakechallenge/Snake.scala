package com.fmgallego.snakechallenge

import com.fmgallego.snakechallenge.Operations.{assertSnakeConstraints, SnakeArray}
import org.apache.logging.log4j.scala.Logging

case class Snake(snake: SnakeArray) {

  val SnakeArray: SnakeArray = snake
}

object Snake extends Logging {

  def apply(snake: SnakeArray, cols: Int): Option[Snake] = {

    val BoardAndSnakeLimits: Boolean = assertSnakeConstraints(snake, cols)

    if (BoardAndSnakeLimits) Some(new Snake(snake))
    else None

  }

}

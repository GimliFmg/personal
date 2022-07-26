package com.fmgallego.snakechallenge

import com.fmgallego.snakechallenge.Operations.assertSnakeConstraints
import org.apache.logging.log4j.scala.Logging

case class Snake(snake: Array[Array[Int]]) {

  val SnakeArray: Array[Array[Int]] = snake
}

object Snake extends Logging {

  def apply(snake: Array[Array[Int]], cols: Int): Option[Snake] = {

    val BoardAndSnakeLimits: Boolean = assertSnakeConstraints(snake, cols)

    if (BoardAndSnakeLimits) Some(new Snake(snake))
    else None

  }

}

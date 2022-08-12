package com.fmgallego.snakechallenge

import com.fmgallego.snakechallenge.Operations.{defineMovement, randomDirection, InvalidArray, SnakeArray}
import org.apache.logging.log4j.scala.Logging

import scala.annotation.tailrec

case class SnakePathCalculation2(snake: SnakeArray, boardCols: Int, depth: Int) extends Logging {

  var Depth: Int = 0

  @tailrec
  final def getPaths(snake: SnakeArray): SnakeArray = {

    val lastSnake = snake
    val snakeToTry = defineMovement(snake, randomDirection, boardCols)
    if (Depth < depth) {
      if (!(snakeToTry sameElements InvalidArray)) {
        Depth += 1
        getPaths(snakeToTry)
      }
      else getPaths(lastSnake)
    }
    else lastSnake

  }
}
package com.fmgallego.snakechallenge

import com.fmgallego.snakechallenge.Operations.{isCollapsing, movingDown, movingLeft, movingRight, movingUp, InvalidArray, SnakeArray}
import org.apache.logging.log4j.scala.Logging

import scala.annotation.tailrec

case class SnakePathCalculation(snake: SnakeArray, boardCols: Int, depth: Int) extends Logging {

  val SnakeFirstArray: SnakeArray = snake
  var Depth: Int = 0


  // TODO: WORKS FINE FOR ONE TIME, NOW I NEED TO CHECK IF ARRAYS ARE DIFFERENT
  // CHECK TRACES
  @tailrec
  final def getPaths(snake: SnakeArray): SnakeArray = {

    case class Movement() {
      def getSnakeIf(movement: Option[Snake]): SnakeArray = {
        val mov = if (movement.isDefined) true else false
        if (mov) Option(movement).get.get.snake
        else InvalidArray
      }
      val goUp: SnakeArray = getSnakeIf(Snake(movingUp(snake), boardCols, newSnakeFlag = true, snake))
      val goLeft: SnakeArray = getSnakeIf(Snake(movingLeft(snake), boardCols, newSnakeFlag = true, snake))
      val goDown: SnakeArray = getSnakeIf(Snake(movingDown(snake), boardCols, newSnakeFlag = true, snake))
      val goRight: SnakeArray = getSnakeIf(Snake(movingRight(snake), boardCols, newSnakeFlag = true, snake))
    }
      if (Depth != depth) {
        if (!(Movement().goUp sameElements InvalidArray)) {
          Depth += 1
          getPaths(Movement().goUp)
        }
        else if (!(Movement().goLeft sameElements InvalidArray)) {
          Depth += 1
          getPaths(Movement().goLeft)
        }
        else if (!(Movement().goDown sameElements InvalidArray)) {
          Depth += 1
          getPaths(Movement().goDown)
        }
        else if (!(Movement().goRight sameElements InvalidArray)) {
          Depth += 1
          getPaths(Movement().goRight)
        }
        else snake
      }
    else snake
  }
}

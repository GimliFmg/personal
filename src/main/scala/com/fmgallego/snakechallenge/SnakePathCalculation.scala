package com.fmgallego.snakechallenge

import com.fmgallego.snakechallenge.Operations.{isCollapsing, movingDown, movingLeft, movingRight, movingUp, SnakeArray}
import org.apache.logging.log4j.scala.Logging

import scala.annotation.tailrec

case class SnakePathCalculation(snake: SnakeArray, boardCols: Int, depth: Int) extends Logging {

  val SnakeFirstArray: SnakeArray = snake
  var Depth: Int = 0
  def getSnakeIf(movement: Option[Snake]): SnakeArray = Option(movement).get.get.snake

  // TODO: WORKS FINE FOR ONE TIME, NOW I NEED TO CHECK IF ARRAYS ARE DIFFERENT
  // CHECK TRACES
  @tailrec
  final def getPaths(snake: SnakeArray): Option[Int] = {
    val goUp = Snake(movingUp(snake), boardCols, newSnakeFlag =  true, snake)
    val goLeft = Snake(movingLeft(snake), boardCols, newSnakeFlag =  true, snake)
    val goDown = Snake(movingDown(snake), boardCols, newSnakeFlag =  true, snake)
    val goRight = Snake(movingRight(snake), boardCols, newSnakeFlag =  true, snake)

      if (Depth != depth) {
        if (goUp.isDefined) {
          Depth += 1
          getPaths(getSnakeIf(goUp))
        }
        else if (goLeft.isDefined) {
          Depth += 1
          getPaths(getSnakeIf(goLeft))
        }
        else if (goDown.isDefined) {
          Depth += 1
          getPaths(getSnakeIf(goDown))
        }
        else if (goRight.isDefined) {
          Depth += 1
          getPaths(getSnakeIf(goRight))
        }
        else None
      }
    else Some(Depth)
  }
}

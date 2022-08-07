package com.fmgallego.snakechallenge

import com.fmgallego.snakechallenge.Operations.{isCollapsing, movingDown, movingLeft, movingRight, movingUp, SnakeArray}
import org.apache.logging.log4j.scala.Logging

import scala.annotation.tailrec

case class SnakePathCalculation(snake: SnakeArray, boardCols: Int, depth: Int) extends Logging {

  val SnakeFirstArray: SnakeArray = snake
  var Depth: Int = 0
  var Result: Int = 0

  // TODO: WORKS ALMOST FINE, JUST NEED TO CHECK IF SNAKE IS COLLAPSING
  // CHECK TRACES
  @tailrec
  final def getPaths(snake: SnakeArray): Option[Int] = {
    val goUp = Snake(movingUp(snake), boardCols, newSnakeFlag =  true, snake)
    val goLeft = Snake(movingLeft(snake), boardCols, newSnakeFlag =  true, snake)
    val goDown = Snake(movingDown(snake), boardCols, newSnakeFlag =  true, snake)
    val goRight = Snake(movingRight(snake), boardCols, newSnakeFlag =  true, snake)

    if (goUp.isDefined) {
      if (Depth == depth) Some(Depth)
      else {
        Depth += 1
        getPaths(goUp.get.snake)
      }
    }
    else if (goLeft.isDefined) {
      if (Depth == depth) Some(Depth)
      else {
        Depth += 1
        getPaths(goLeft.get.snake)
      }
    }
    else if (goDown.isDefined) {
      if (Depth == depth) Some(Depth)
      else {
        Depth += 1
        getPaths(goDown.get.snake)
      }
    }
    else if (goRight.isDefined) {
      if (Depth == depth) Some(Depth)
      else {
        Depth += 1
        getPaths(goRight.get.snake)
      }
    }
    else {
      Result += 1
      getPaths(snake)
    }
  }
}

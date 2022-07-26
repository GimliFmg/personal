package com.fmgallego.snakechallenge

import com.fmgallego.snakechallenge.Operations.{movingDown, movingLeft, movingRight, movingUp}

import scala.annotation.tailrec

class SnakePathCalculation(snake: Array[Array[Int]], boardCols: Int, depth: Int) {

  val SnakeFirstArray: Array[Array[Int]] = snake
  var Depth: Int = 0

  // TODO: THINK IM GOING IN THE RIGHT DIRECTION
  @tailrec
  final def getPaths(snake: Array[Array[Int]]): Option[Int] = {
      if (Snake(movingRight(snake), boardCols).isDefined) {
        if(Depth == depth) Some(Depth)
        else {
        Depth += 1
        getPaths(Snake(movingRight(snake), boardCols).get.snake)
          }
      }
      else if (Snake(movingLeft(snake), boardCols).isDefined) {
        if(Depth == depth) Some(Depth)
        else {
          Depth += 1
          getPaths(Snake(movingRight(snake), boardCols).get.snake)
        }
      }
      else if (Snake(movingDown(snake), boardCols).isDefined) {
        if(Depth == depth) Some(Depth)
        else {
          Depth += 1
          getPaths(Snake(movingRight(snake), boardCols).get.snake)
        }
      }
      else if (Snake(movingUp(snake), boardCols).isDefined) {
        if(Depth == depth) Some(Depth)
        else {
          Depth += 1
          getPaths(Snake(movingRight(snake), boardCols).get.snake)
        }
      }
    else None

  }

}
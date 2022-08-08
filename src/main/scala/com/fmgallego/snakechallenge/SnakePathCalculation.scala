package com.fmgallego.snakechallenge

import com.fmgallego.literals.Literals.SnakeLiterals.{Down, Left, Right, Up}
import com.fmgallego.snakechallenge.Operations.{defineMovement, InvalidArray, SnakeArray}
import org.apache.logging.log4j.scala.Logging

import scala.annotation.tailrec

case class SnakePathCalculation(snake: SnakeArray, boardCols: Int, depth: Int) extends Logging {

  val SnakeFirstArray: SnakeArray = snake
  var Depth: Int = 0


  // TODO: WORKS FINE FOR ONE TIME, NOW I NEED TO CHECK IF ARRAYS ARE DIFFERENT
  // CHECK TRACES
  @tailrec
  final def getPaths(snake: SnakeArray): SnakeArray = {
    class Movement {
      def getSnakeIf(movement: Option[Snake]): SnakeArray = {
        if (movement.isDefined) Option(movement).get.get.snake
        else InvalidArray
      }
      def mySnake(movement: String): SnakeArray = {
        getSnakeIf(Snake(defineMovement(snake, movement), boardCols, newSnakeFlag = true, snake))
      }
    }
    val Move = new Movement
    if (Depth != depth) {
      if (!(Move.mySnake(Up) sameElements InvalidArray)) {
        Depth += 1
        getPaths(Move.mySnake(Up))
      }
      else if (!(Move.mySnake(Down) sameElements InvalidArray)) {
        Depth += 1
        getPaths(Move.mySnake(Down))
      }
      else if (!(Move.mySnake(Left) sameElements InvalidArray)) {
        Depth += 1
        getPaths(Move.mySnake(Left))
      }
      else if (!(Move.mySnake(Right) sameElements InvalidArray)) {
        Depth += 1
        getPaths(Move.mySnake(Right))
      }
      else snake
    }
    else snake
  }
}

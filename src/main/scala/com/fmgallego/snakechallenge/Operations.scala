package com.fmgallego.snakechallenge

import com.fmgallego.literals.Literals.ErrorMessages._
import com.fmgallego.literals.Literals.Snake.{LengthLowerLimit, LengthUpperLimit, SnakeArray, SnakeILengthLimit, Value1}
import org.apache.logging.log4j.scala.Logging

object Operations extends Logging {

  /**
    * this method will assert if snake constraints related to the board are met
    * @param snake: snake's input array
    * @param cols: inherited board's columns number
    * @return boolean confirming or denying limits
    */
  def assertSnakeConstraints(snake: Array[Array[Int]], cols: Int): Boolean = {

    val SnakeLength: Int = snake.length
    val SnakeLengthFlag: Boolean = (LengthLowerLimit <= SnakeLength) && (SnakeLength <= LengthUpperLimit)

    val SnakeOutOfBoardLimit: Int = snake.map(arr => arr(Value1))
      .map(coord => if (coord < cols) 0 else 1).sum

    val SnakeILength: Int = snake.map(_.length)
      .map(length => if (length == SnakeILengthLimit) 0 else 1).sum

    val AdjacencyFlag = checkAdjacency(snake)

    if(SnakeOutOfBoardLimit != 0) logger.error(SnakeOutOfBoardLimitMsg)
    if(SnakeILength != 0) logger.error(Snake2DimError)
    if(!SnakeLengthFlag) logger.error(SnakeLengthMsg)
    if(!AdjacencyFlag) logger.error(SnakeAdjacencyMsg)

    if (SnakeOutOfBoardLimit == 0 && SnakeILength == 0 && SnakeLengthFlag && AdjacencyFlag) true
    else false
  }

  def isVerticalAdjacent(snake: Array[Array[Int]], coord: Int): Boolean = {
    val SnakePos: Int = snake(coord)(1)

    if(coord -1 < 0) SnakePos == snake(coord + 1)(1)
    else if (coord + 1 >= SnakeArray.length) SnakePos == snake(coord - 1)(1)
    else (SnakePos == snake(coord - 1)(1)) || (SnakePos == snake(coord + 1)(1))

  }

  def isHorizontalAdjacent(snake: Array[Array[Int]], coord: Int): Boolean = {
    val SnakePos: Int = snake(coord)(0)

    if(coord -1 < 0) SnakePos == snake(coord + 1)(0)
    else if (coord + 1 >= SnakeArray.length) SnakePos == snake(coord - 1)(0)
    else (SnakePos == snake(coord - 1)(0)) || (SnakePos == snake(coord + 1)(0))
  }

  def checkAdjacency(snake: Array[Array[Int]]): Boolean = {
    val LenghtArray: Array[Int] = Array.range(0, snake.length - 1).map(_ => 0)

    for (coords <- 0 until snake.length - 1) {
      if (isVerticalAdjacent(snake, coords) || isHorizontalAdjacent(snake, coords)) LenghtArray(coords) = 0
      else LenghtArray(coords) = 1
    }

    LenghtArray.sum match {
      case 0 => true
      case _ => false
    }
  }

  def movingRight(snake: Array[Array[Int]]): Array[Array[Int]] = {
    val RightMov: List[Int] = List(snake(0)(0), snake(0)(1) + 1)
    val NewSnake = (snake.toList.map(_.toList).reverse :+ RightMov).reverse.take(snake.length)
    NewSnake.toArray.map(_.toArray)
  }

  def movingLeft(snake: Array[Array[Int]]): Array[Array[Int]] = {
    val LeftMov: List[Int] = List(snake(0)(0), snake(0)(1) - 1)
    val NewSnake = (snake.toList.map(_.toList).reverse :+ LeftMov).reverse.take(snake.length)
    NewSnake.toArray.map(_.toArray)
  }

  def movingUp(snake: Array[Array[Int]]): Array[Array[Int]] = {
    val UpMov: List[Int] = List(snake(0)(0) - 1, snake(0)(1))
    val NewSnake = (snake.toList.map(_.toList).reverse :+ UpMov).reverse.take(snake.length)
    NewSnake.toArray.map(_.toArray)
  }

  def movingDown(snake: Array[Array[Int]]): Array[Array[Int]] = {
    val DownMov: List[Int] = List(snake(0)(0) + 1, snake(0)(1))
    val NewSnake = (snake.toList.map(_.toList).reverse :+ DownMov).reverse.take(snake.length)
    NewSnake.toArray.map(_.toArray)
  }

}

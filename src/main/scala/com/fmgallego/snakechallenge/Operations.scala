package com.fmgallego.snakechallenge

import com.fmgallego.literals.Literals.ErrorMessages._
import com.fmgallego.literals.Literals.Snake.{DashSeparator, LengthLowerLimit, LengthUpperLimit, MoveDown, MoveLeft, MoveRight, MoveUp, SnakeILengthLimit, StringXSeparator, Value1}
import org.apache.logging.log4j.scala.Logging

object Operations extends Logging {

  type SnakeArray = Array[Array[Int]]

  /**
    * this method will transform input params from string to Array
    *
    * @param arrayAsString will be input string with board's size as string
    * @return an Array[Int] with board's size
    */
  def newBoardArray(arrayAsString: String): Array[Int] = {
    arrayAsString.split(StringXSeparator).map(_.toInt)
  }

  /**
    * this method will transform input params from string to Array
    *
    * @param arrayAsString will be input string with snake's position as string
    * @return an Array[Int] with snake's position
    */
  def newSnakeArray(arrayAsString: String): SnakeArray =
    arrayAsString.split(DashSeparator)
      .map(_.split(StringXSeparator))
      .map(_.map(_.toInt))

  /**
    * this method will assert if snake constraints related to the board are met
    *
    * @param snake : snake's input array
    * @param cols  : inherited board's columns number
    * @return boolean confirming or denying limits
    */
  def assertSnakeConstraints(snake: SnakeArray, cols: Int): Boolean = {

    val SnakeLength: Int = snake.length
    val SnakeLengthFlag: Boolean = (LengthLowerLimit <= SnakeLength) && (SnakeLength <= LengthUpperLimit)

    val SnakeOutOfBoardLimit: Int = snake.map(arr => arr(Value1))
      .map(coord => if (coord < cols) 0 else 1).sum

    val SnakeILength: Int = snake.map(_.length)
      .map(length => if (length == SnakeILengthLimit) 0 else 1).sum

    val AdjacencyFlag = checkAdjacency(snake)

    if (SnakeOutOfBoardLimit != 0) logger.error(SnakeOutOfBoardLimitMsg)
    if (SnakeILength != 0) logger.error(Snake2DimError)
    if (!SnakeLengthFlag) logger.error(SnakeLengthMsg)
    if (!AdjacencyFlag) logger.error(SnakeAdjacencyMsg)

    if (SnakeOutOfBoardLimit == 0 && SnakeILength == 0 && SnakeLengthFlag && AdjacencyFlag) true
    else false
  }

  def isVerticalAdjacent(snake: SnakeArray, coord: Int): Boolean = {
    val SnakePos: Int = snake(coord)(1)

    if (coord - 1 < 0) SnakePos == snake(coord + 1)(1)
    else if (coord + 1 >= snake.length) SnakePos == snake(coord - 1)(1)
    else (SnakePos == snake(coord - 1)(1)) || (SnakePos == snake(coord + 1)(1))

  }

  def isHorizontalAdjacent(snake: SnakeArray, coord: Int): Boolean = {
    val SnakePos: Int = snake(coord)(0)

    if (coord - 1 < 0) SnakePos == snake(coord + 1)(0)
    else if (coord + 1 >= snake.length) SnakePos == snake(coord - 1)(0)
    else (SnakePos == snake(coord - 1)(0)) || (SnakePos == snake(coord + 1)(0))
  }

  def checkAdjacency(snake: SnakeArray): Boolean = {
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

  def defineMovement(snake: SnakeArray, movType: String): SnakeArray = {
    val x = movType match {
      case MoveRight => 0
      case MoveLeft => 0
      case MoveUp => -1
      case MoveDown => 1
    }
    val y = movType match {
      case MoveRight => 1
      case MoveLeft => -1
      case MoveUp => -0
      case MoveDown => 0
    }
    val MovType = List(snake(0)(0) + x, snake(0)(1) + y)
    (snake.toList.map(_.toList).reverse :+ MovType).reverse.take(snake.length)
      .toArray.map(_.toArray)
  }

  def movingRight(snake: SnakeArray): SnakeArray = defineMovement(snake, MoveRight)

  def movingLeft(snake: SnakeArray): SnakeArray = defineMovement(snake, MoveLeft)

  def movingUp(snake: SnakeArray): SnakeArray = defineMovement(snake, MoveUp)

  def movingDown(snake: SnakeArray): SnakeArray = defineMovement(snake, MoveDown)

  def looking(snakeNewPosition: SnakeArray, lastSnake: SnakeArray): Boolean = {
    val NewHead: Array[Int] = snakeNewPosition take 1 flatMap (_.toList)
    lastSnake contains NewHead
  }

}

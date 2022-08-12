package com.fmgallego.snakechallenge

import com.fmgallego.snakechallenge.Operations.{defineMovement, randomDirection, InvalidArray, SnakeArray}
import org.apache.logging.log4j.scala.Logging

import scala.annotation.tailrec
import scala.collection.mutable
import scala.collection.mutable.ListBuffer

case class SnakePathCalculation(snake: SnakeArray, boardSize: Array[Int], depth: Int) extends Logging {

  val FirstSnake: SnakeArray = snake
  var Depth: Int = 0
  var Times: Int = 0
  val mutableArray: ListBuffer[String] = mutable.ListBuffer[String]()
  var ResultadoCaminos: Int = 0
  val TimesTried: Int = 1000

  @tailrec
  final def getPaths(snake: SnakeArray): Int = {

    val lastSnake = snake
    val snakeToTry = defineMovement(snake, randomDirection, boardSize)

    if (Times != TimesTried) {
      if (Depth < depth) {
        if (!(snakeToTry sameElements InvalidArray)) {
          Depth += 1
          getPaths(snakeToTry)
        }
        else getPaths(lastSnake)
      }
      else {
        Depth = 0
        Times += 1
        mutableArray += lastSnake.flatten.mkString
        getPaths(FirstSnake)
      }
    }
    else {
      ResultadoCaminos = mutableArray.distinct.map(_ => 1).sum
      ResultadoCaminos
    }

  }
}
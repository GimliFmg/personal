package com.fmgallego.snakechallenge

import com.fmgallego.snakechallenge.Operations.{defineMovement, randomDirection, InvalidArray, SnakeArray}
import org.apache.logging.log4j.scala.Logging

import scala.annotation.tailrec

case class SnakePathCalculation(snake: SnakeArray, boardCols: Int, depth: Int) extends Logging {}

 /* val SnakeFirstArray: SnakeArray = snake
  var Depth: Int = 0
  var caminos = 0

    def getSnakeIf(movement: Option[Snake]): SnakeArray = {
      if (movement.isDefined) Option(movement).get.get.snake
      else InvalidArray
    }
    def mySnake(movement: String): SnakeArray = {
      getSnakeIf(Snake(defineMovement(snake, movement), boardCols, newSnakeFlag = true, snake))
    }
  def checkMovement(mov: String): Boolean = {
    !(mySnake(mov) sameElements InvalidArray)
  }

  @tailrec
  final def getPaths(snake: SnakeArray): SnakeArray = {

    if (Depth < 3) {
      val RandomMov = randomDirection
      if (checkMovement(RandomMov)) {
        Depth += 1
        println(s"SERPIENTE CON EL DEPTH = $Depth")
        mySnake(RandomMov).foreach(a => print(a.mkString + ", "))
        println("")
        getPaths(mySnake(RandomMov))
      }
      else {
        getPaths(mySnake(randomDirection))
      }
    }

    else {

      snake}
    }
}

  */
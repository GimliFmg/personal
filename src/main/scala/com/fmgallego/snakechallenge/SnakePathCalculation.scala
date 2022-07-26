package com.fmgallego.snakechallenge

import com.fmgallego.snakechallenge.Operations.{movingDown, movingLeft, movingRight, movingUp}

import scala.collection.mutable

class SnakePathCalculation(snake: Array[Array[Int]], boardCols: Int, depth: Int) {

  var Depth: Int = 0
  val ArrayGen = mutable.ListBuffer[List[Int]]()

  for (arr <- snake.toList.map(_.toList)) ArrayGen += arr

  def getPath: AnyVal = {

    while (Depth != depth) {
      if (Snake(movingRight(snake), boardCols).isDefined) {
        Depth += 1
      }
      else if (Snake(movingLeft(snake), boardCols).isDefined) {
        Depth += 1
      }
      else if (Snake(movingDown(snake), boardCols).isDefined) {
        Depth += 1
      }
      else if (Snake(movingUp(snake), boardCols).isDefined) {
        Depth += 1
      }
    }
    println(s"The deep of this snake reaches $Depth")
  }

}
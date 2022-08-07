package com.fmgallego

import com.fmgallego.snakechallenge.{Board, Snake, SnakePathCalculation}
import com.fmgallego.snakechallenge.Operations.{newBoardArray, newSnakeArray, SnakeArray}
import org.apache.logging.log4j.scala.Logging

object ChallengeApp extends Logging {

  def main(args: Array[String]): Unit = {
    try {
      val snake: String = args(0)
      val board: String = args(1)
      val depth: Int = args(2).toInt

      val BoardSize: Array[Int] = newBoardArray(board)
      val SnakeInputPosition: SnakeArray = newSnakeArray(snake)

      val BoardGeneration: Option[Board] = Board(BoardSize)
      val BoardColumns: Int = BoardGeneration.get.board(1)
      Snake(SnakeInputPosition, BoardColumns)

      val SnakePaths: SnakePathCalculation = SnakePathCalculation(SnakeInputPosition, BoardColumns, depth)

      SnakePaths.getPaths(SnakeInputPosition)
      val AchievedDepth = SnakePaths.Depth
      val AchievedResult = SnakePaths.Result

      println(s"You have achieved depth = $AchievedDepth for $AchievedResult times!")
    }

    catch {
      case e: Exception => throw new Error
    }
  }
}

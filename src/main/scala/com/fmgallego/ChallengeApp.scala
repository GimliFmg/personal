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

      // TODO: just while work is in progress, will find a way to show it cleaner eventually
      println("SERPIENTE INICIAL")
      SnakeInputPosition foreach (a => print(a.mkString + ", "))
      println()
      println("SERPIENTE CON EL CAMINO FINALIZAZO")
      SnakePaths.getPaths(SnakeInputPosition).foreach(a => print(a.mkString + ", "))
      println()
      val AchievedDepth = SnakePaths.Depth

      println(s"You have achieved depth = $AchievedDepth")
    }

    catch {
      case e: Exception => throw new Error
    }
  }
}

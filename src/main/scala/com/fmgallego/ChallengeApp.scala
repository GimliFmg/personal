package com.fmgallego

import com.fmgallego.literals.Literals.SnakeLiterals.BigInt10To9Plus7
import com.fmgallego.snakechallenge.{Board, Snake, SnakePathCalculation}
import com.fmgallego.snakechallenge.Operations.{newBoardArray, newSnakeArray, SnakeArray}
import org.apache.logging.log4j.scala.Logging

object ChallengeApp extends Logging {

  def main(args: Array[String]): Unit = {
    runner(args)
  }

  def runner(args: Array[String]): Int = {
    try {
      val snake: String = args(0)
      val board: String = args(1)
      val depth: Int = args(2).toInt

      val BoardSize: Array[Int] = newBoardArray(board)
      val SnakeInputPosition: SnakeArray = newSnakeArray(snake)

      val BoardGeneration: Option[Board] = Board(BoardSize)
      val BoardArray: Array[Int] = BoardGeneration.get.board.map(_ - 1)

      Snake(SnakeInputPosition, BoardArray)

      val SnakePaths: SnakePathCalculation = SnakePathCalculation(SnakeInputPosition, BoardArray, depth)

      SnakePaths.getPaths(SnakeInputPosition)

      val Resultado = SnakePaths.ResultadoCaminos

      println(s"Your snake can go through ${Resultado} different paths of depth $depth")

      Resultado
    }

    catch {
      case e: Exception => throw new Error
    }
  }

}

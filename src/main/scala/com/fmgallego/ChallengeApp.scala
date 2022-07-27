package com.fmgallego

import com.fmgallego.snakechallenge.{Board, SnakePathCalculation}
import com.fmgallego.configuration.AppConf
import com.fmgallego.snakechallenge.Operations.getParamsAsArray

object ChallengeApp {

  def main(args: Array[String]): Unit = {
    try {
      val config = AppConf(args)
      val BoardSize: Array[Int] = getParamsAsArray(config.inputBoardSize)
      val SnakeInputPosition: Array[Array[Int]] =
        Array(getParamsAsArray(config.inputSnakeArray, board = true))
      val InputDepth: Int = config.requiredDepth.toString.toInt
      val BoardColumns: Int = BoardSize(1)

      // TODO: GET X POSITIONS CHECKED WITH SNAKE
      val BoardGeneration: Option[Board] = Board(BoardSize)

      new SnakePathCalculation(SnakeInputPosition, BoardColumns, InputDepth).getPaths(SnakeInputPosition)
    }

    catch {
      case e: Exception => println("Your Board or Snake doesn't match constraints")
    }
  }
}

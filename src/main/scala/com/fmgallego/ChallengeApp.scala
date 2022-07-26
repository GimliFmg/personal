package com.fmgallego

import com.fmgallego.literals.Literals.Snake.SnakeArray
import com.fmgallego.snakechallenge.{Board, Snake, SnakePathCalculation}

object ChallengeApp extends App {
  try {
    val BoardGeneration: Option[Board] = Board(Array(2, 2))
    val BoardColumns: Int = BoardGeneration.get.board(1)
    val SnakeGeneration: Option[Snake] = Snake(SnakeArray, BoardColumns)

    new SnakePathCalculation(SnakeArray, BoardColumns, 3).getPaths(SnakeArray)
  }

  catch {
    case e: Exception => println("Your Board or Snake doesn't match constraints")
  }

}

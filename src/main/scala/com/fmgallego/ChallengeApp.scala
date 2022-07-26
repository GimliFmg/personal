package com.fmgallego

import com.fmgallego.literals.Literals.Snake.SnakeArray
import com.fmgallego.snakechallenge.{Board, SnakePathCalculation}

object ChallengeApp extends App {
  try {
    val BoardGeneration: Option[Board] = Board(Array(10, 10))
    val BoardColumns: Int = BoardGeneration.get.board(1)

    new SnakePathCalculation(SnakeArray, BoardColumns, 5).getPaths(SnakeArray)
  }

  catch {
    case e: Exception => println("Your Board or Snake doesn't match constraints")
  }

}

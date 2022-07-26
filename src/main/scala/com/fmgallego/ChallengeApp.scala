package com.fmgallego

import com.fmgallego.literals.Literals.Snake.SnakeInputArray
import com.fmgallego.snakechallenge.{Board, SnakePathCalculation}

object ChallengeApp extends App {
  try {
    val BoardGeneration: Option[Board] = Board(Array(10, 10))
    val BoardColumns: Int = BoardGeneration.get.board(1)

    new SnakePathCalculation(SnakeInputArray, BoardColumns, 5).getPaths(SnakeInputArray)
  }

  catch {
    case e: Exception => println("Your Board or Snake doesn't match constraints")
  }

}

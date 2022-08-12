package com.fmgallego.snakechallenge

import com.fmgallego.snakechallenge.Operations.SnakeArray

abstract class SnakeChallenge {
  val InputSnake: SnakeArray
  val SnakeBoard: Option[Board]
  val BoardColumns: Int
  val InputDepth: Int
  val SnakePathCalc: SnakePathCalculation
}

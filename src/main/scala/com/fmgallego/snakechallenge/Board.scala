package com.fmgallego.snakechallenge

/**
  * Will create a new board instance
  */
sealed abstract case class Board(board: Array[Int])


object Board {

  def apply(board: Array[Int]): Option[Board] = {
    val BoardLengthFlag: Boolean = board.length == 2
    val BoardRows: Int = board(0)
    val BoardRowsFlag: Boolean = (BoardRows >= 1) && (BoardRows <= 10)

    if (BoardRowsFlag && BoardLengthFlag) Some(new Board(board) {})
    else None

  }

}

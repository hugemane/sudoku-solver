package com.hugemane.sudoku.solver.model

class SudokuBoard(val rows: Int, val columns: Int) {
  var matrix: Map[Point, Block] = Map[Point, Block]()

  def initialize() {
    for (r <- 0 until rows; c <- 0 until columns) {
      matrix += (Point(r, c) -> Block(None))
    }
  }
}

object SudokuBoard {
  def apply(rows: Int, columns: Int): SudokuBoard = {
    val board = new SudokuBoard(rows, columns)
    board.initialize()
    board
  }
}

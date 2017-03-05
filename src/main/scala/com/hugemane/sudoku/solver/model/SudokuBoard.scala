package com.hugemane.sudoku.solver.model

class SudokuBoard(val rows: Int, val columns: Int) {
  private var board: Map[Point, Block] = Map[Point, Block]()

  def initialize() {
    for (r <- 0 until rows; c <- 0 until columns) {
      board += (Point(r, c) -> Block(None))
    }
  }

  def setInitialValues(values: Map[Point, Int]) {
    for ((point, initialValue) <- values) {
      val boardBlock = board(point)
      board += point -> boardBlock.copy(Some(initialValue))
    }
  }

  def block(point: Point): Block = board(point)

  def blocks: Map[Point, Block] = board
}

object SudokuBoard {
  def apply(rows: Int, columns: Int): SudokuBoard = {
    val board = new SudokuBoard(rows, columns)
    board.initialize()
    board
  }
}

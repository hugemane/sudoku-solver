package com.hugemane.sudoku.solver.model

import com.hugemane.sudoku.solver.BoardPoint.Point
import com.hugemane.sudoku.solver.service.partition.BoardPartitionSolutionCheck

class SudokuBoard(val rows: Int, val columns: Int) extends BoardPartitionSolutionCheck {
  private var board: Map[Point, Block] = Map[Point, Block]()

  def initialize() {
    for (r <- 0 until rows; c <- 0 until columns) {
      board += ((r, c) -> Block(None))
    }
  }

  def setInitialValues(values: Map[Point, Int]) {
    for ((point, initialValue) <- values) {
      val boardBlock = board(point)
      board += point -> boardBlock.copy(Some(initialValue))
    }
  }

  def getBlock(point: Point): Block = board(point)

  def setBlock(point: Point, block: Block) { board += (point -> block) }

  def blocks: Map[Point, Block] = board

  def isSolved(): Boolean = isPartitionSolved(board.toSeq)
}

object SudokuBoard {
  def apply(rows: Int, columns: Int): SudokuBoard = {
    val board = new SudokuBoard(rows, columns)
    board.initialize()
    board
  }

  def apply(dimensions: (Int, Int), initialValues: Map[Point, Int]): SudokuBoard = {
    val board = SudokuBoard(dimensions._1, dimensions._2)
    board.setInitialValues(initialValues)
    board
  }
}

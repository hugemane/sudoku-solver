package com.hugemane.sudoku.solver.model

import com.hugemane.sudoku.solver.TestSpec

class SudokuBoardSpec extends TestSpec {

  it should "initialize 4x4 sudoku board" in {
    val board = SudokuBoard(rows = 4, columns = 4)
    board.matrix should have size 16
  }

  it should "initialize 9x9 sudoku board" in {
    val board = SudokuBoard(rows = 9, columns = 9)
    board.matrix should have size 81
  }
}

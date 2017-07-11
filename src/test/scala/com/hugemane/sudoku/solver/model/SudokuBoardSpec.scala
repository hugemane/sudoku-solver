package com.hugemane.sudoku.solver.model

import com.hugemane.sudoku.solver.TestSpec

class SudokuBoardSpec extends TestSpec {

  it should "initialize 4x4 sudoku board" in {
    val board = SudokuBoard(rows = 4, columns = 4)
    board.blocks should have size 16
  }

  it should "initialize 9x9 sudoku board" in {
    val board = SudokuBoard(rows = 9, columns = 9)
    board.blocks should have size 81
  }

  it should "initialize 4x4 sudoku board with 1 initial value" in {
    val board = SudokuBoard(rows = 4, columns = 4)

    board.setInitialValues(Map((0, 3) -> 2))

    board.blocks should have size 16
    board.blocks((0, 3)) shouldEqual Block(Some(2))
  }

  it should "supply sudoku board point value" in {
    val board = SudokuBoard(rows = 4, columns = 4)

    val boardBlock = board.blocks((0, 0))
    boardBlock.isSolved shouldBe false

    board.setBlock((0, 0), Block(1))

    val boardBlockAfter = board.blocks((0, 0))
    boardBlockAfter.isSolved shouldBe true
  }
}

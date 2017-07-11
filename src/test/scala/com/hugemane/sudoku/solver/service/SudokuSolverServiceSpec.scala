package com.hugemane.sudoku.solver.service

import com.hugemane.sudoku.solver.TerminalOutCaptureSpec
import com.hugemane.sudoku.solver.cli.SudokuTextTerminal
import com.hugemane.sudoku.solver.model.SudokuBoard

class SudokuSolverServiceSpec extends TerminalOutCaptureSpec {

  "service" should "solve simple 4x4 puzzle missing single patch values" in {
    val board = SudokuBoard(4, 4)
    board.setInitialValues(Map(
      (0, 1) -> 3,
      (1, 0) -> 2, (1, 1) -> 1,
      (0, 2) -> 1, (0, 3) -> 2,
      (1, 2) -> 3,
      (2, 0) -> 3, (2, 1) -> 4,
      (3, 0) -> 1,
      (2, 2) -> 2, (2, 3) -> 1,
      (3, 2) -> 4
    ))

    SudokuTextTerminal(board).display()

    val solverService = SudokuSolverService(board)
    val solvedBoard = solverService.solve()

    SudokuTextTerminal(solvedBoard).display(Some("Solution:"))

    val output = terminalOutput

    output shouldEqual
          """╔═══╤═══╦═══╤═══╗
            |║ · │ 3 ║ 1 │ 2 ║
            |╟───┼───╫───┼───╢
            |║ 2 │ 1 ║ 3 │ · ║
            |╠═══╪═══╬═══╪═══╣
            |║ 3 │ 4 ║ 2 │ 1 ║
            |╟───┼───╫───┼───╢
            |║ 1 │ · ║ 4 │ · ║
            |╚═══╧═══╩═══╧═══╝
            |Solution:
            |╔═══╤═══╦═══╤═══╗
            |║ 4 │ 3 ║ 1 │ 2 ║
            |╟───┼───╫───┼───╢
            |║ 2 │ 1 ║ 3 │ 4 ║
            |╠═══╪═══╬═══╪═══╣
            |║ 3 │ 4 ║ 2 │ 1 ║
            |╟───┼───╫───┼───╢
            |║ 1 │ 2 ║ 4 │ 3 ║
            |╚═══╧═══╩═══╧═══╝
            |""".stripMargin
  }
}

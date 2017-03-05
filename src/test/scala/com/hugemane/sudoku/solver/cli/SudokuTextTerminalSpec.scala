package com.hugemane.sudoku.solver.cli

import com.hugemane.sudoku.solver.TerminalOutCaptureSpec
import com.hugemane.sudoku.solver.model.{ Point, SudokuBoard }

class SudokuTextTerminalSpec extends TerminalOutCaptureSpec {

  it should "display 4x4 sudoku board with no solved values" in {
    val board = SudokuBoard(4, 4)
    val terminal = new SudokuTextTerminal(board)
    terminal.display()

    val output = terminalOutput

    output shouldEqual """╔═══╤═══╦═══╤═══╗
                         |║ · │ · ║ · │ · ║
                         |╟───┼───╫───┼───╢
                         |║ · │ · ║ · │ · ║
                         |╠═══╪═══╬═══╪═══╣
                         |║ · │ · ║ · │ · ║
                         |╟───┼───╫───┼───╢
                         |║ · │ · ║ · │ · ║
                         |╚═══╧═══╩═══╧═══╝
                       |""".stripMargin
  }

  it should "display 9x9 sudoku board with no solved values" in {
    val board = SudokuBoard(9, 9)
    val terminal = new SudokuTextTerminal(board)
    terminal.display()

    val output = terminalOutput

    output shouldEqual """╔═══╤═══╤═══╦═══╤═══╤═══╦═══╤═══╤═══╗
                         |║ · │ · │ · ║ · │ · │ · ║ · │ · │ · ║
                         |╟───┼───┼───╫───┼───┼───╫───┼───┼───╢
                         |║ · │ · │ · ║ · │ · │ · ║ · │ · │ · ║
                         |╟───┼───┼───╫───┼───┼───╫───┼───┼───╢
                         |║ · │ · │ · ║ · │ · │ · ║ · │ · │ · ║
                         |╠═══╪═══╪═══╬═══╪═══╪═══╬═══╪═══╪═══╣
                         |║ · │ · │ · ║ · │ · │ · ║ · │ · │ · ║
                         |╟───┼───┼───╫───┼───┼───╫───┼───┼───╢
                         |║ · │ · │ · ║ · │ · │ · ║ · │ · │ · ║
                         |╟───┼───┼───╫───┼───┼───╫───┼───┼───╢
                         |║ · │ · │ · ║ · │ · │ · ║ · │ · │ · ║
                         |╠═══╪═══╪═══╬═══╪═══╪═══╬═══╪═══╪═══╣
                         |║ · │ · │ · ║ · │ · │ · ║ · │ · │ · ║
                         |╟───┼───┼───╫───┼───┼───╫───┼───┼───╢
                         |║ · │ · │ · ║ · │ · │ · ║ · │ · │ · ║
                         |╟───┼───┼───╫───┼───┼───╫───┼───┼───╢
                         |║ · │ · │ · ║ · │ · │ · ║ · │ · │ · ║
                         |╚═══╧═══╧═══╩═══╧═══╧═══╩═══╧═══╧═══╝
                       |""".stripMargin
  }

  it should "display 4x4 sudoku board with initial values" in {
    val board = SudokuBoard(4, 4)
    board.setInitialValues(Map(
      Point(0, 3) -> 2,
      Point(1, 1) -> 1, Point(1, 2) -> 3,
      Point(2, 1) -> 4, Point(2, 2) -> 2,
      Point(3, 0) -> 1
    ))

    val terminal = new SudokuTextTerminal(board)
    terminal.display()

    val output = terminalOutput

    output shouldEqual """╔═══╤═══╦═══╤═══╗
                         |║ · │ · ║ · │ 2 ║
                         |╟───┼───╫───┼───╢
                         |║ · │ 1 ║ 3 │ · ║
                         |╠═══╪═══╬═══╪═══╣
                         |║ · │ 4 ║ 2 │ · ║
                         |╟───┼───╫───┼───╢
                         |║ 1 │ · ║ · │ · ║
                         |╚═══╧═══╩═══╧═══╝
                         |""".stripMargin
  }
}

package com.hugemane.sudoku.solver

import com.hugemane.sudoku.solver.cli.SudokuTextTerminal
import com.hugemane.sudoku.solver.model.SudokuBoard

object Main extends App {

  val board = SudokuBoard(9, 9)

  val terminal = new SudokuTextTerminal(board)
  terminal.display()
}

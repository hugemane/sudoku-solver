package com.hugemane.sudoku.solver.cli

import java.io.ByteArrayOutputStream

import com.hugemane.sudoku.solver.TestSpec
import com.hugemane.sudoku.solver.model.SudokuBoard

class SudokuTextTerminalSpec extends TestSpec {

  it should "display 4x4 sudoku board with no solved values" in {
    val consoleOutputCapture = new ByteArrayOutputStream
    Console.setOut(consoleOutputCapture)

    val board = SudokuBoard(4, 4)
    val terminal = new SudokuTextTerminal(board)
    terminal.display()

    val output = new String(consoleOutputCapture.toByteArray)

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
    val consoleOutputCapture = new ByteArrayOutputStream
    Console.setOut(consoleOutputCapture)

    val board = SudokuBoard(9, 9)
    val terminal = new SudokuTextTerminal(board)
    terminal.display()

    val output = new String(consoleOutputCapture.toByteArray)

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
}

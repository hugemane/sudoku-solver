package com.hugemane.sudoku.solver.cli

import com.hugemane.sudoku.solver.cli.SudokuBoardCharacters._
import com.hugemane.sudoku.solver.model.SudokuBoard

import scala.math._

class SudokuTextTerminal(board: SudokuBoard) {
  private val rowSquareRoot = sqrt(board.rows)
  private val columnSquareRoot = sqrt(board.columns)

  def display(boardTitleText: Option[String] = None) {
    displayBoardTitleText(boardTitleText)
    displayBoardTopBorder()
    displayBoardValues()
    displayBoardBottomBorder()
  }

  private def displayBoardTitleText(boardTitleText: Option[String]) {
    if (boardTitleText.isEmpty) return
    printf("%s%c", boardTitleText.get, '\n')
  }

  private def displayBoardTopBorder() {
    displayRow(`╔`, `╤`, `═`, `╦`, `╗`)
  }

  private def displayBoardValues() {
    for (r <- 0 until board.rows; c <- 0 until board.columns) {
      val block = board.getBlock((r, c))
      val value = block.value.getOrElse(nonSolvedValue)
      val valueFormatted = s" $value "

      val rowNotZeroBoundIndex = r + 1
      val columnNotZeroBoundIndex = c + 1

      c match {
        case 0 =>
          printf("%c%s%c", `║`, valueFormatted, `│`)

        case lastColumn if lastColumn == board.columns - 1 =>
          printf("%1$s%2$c%3$c", valueFormatted, `║`, '\n')

          if (r != 0 && rowNotZeroBoundIndex != board.rows && rowNotZeroBoundIndex % rowSquareRoot == 0) {
            displayRow(`╠`, `╪`, `═`, `╬`, `╣`)
          } else {
            if (rowNotZeroBoundIndex < board.rows) {
              displayRow(`╟`, `┼`, `─`, `╫`, `╢`)
            }
          }

        case _ =>
          print(valueFormatted)

          if (columnNotZeroBoundIndex % columnSquareRoot == 0) {
            print(`║`)
          } else {
            print(`│`)
          }
      }
    }
  }

  private def displayBoardBottomBorder() {
    displayRow(`╚`, `╧`, `═`, `╩`, `╝`)
  }

  def displayRow(leftEnd: Char, minorSeparator: Char, rowSeparator: Char, majorSeparator: Char, rightEnd: Char) {
    for (c <- 0 until board.columns) {
      val columnNotZeroBoundIndex = c + 1
      c match {
        case 0 =>
          printf("%1$c%2$c%2$c%2$c%3$c", leftEnd, rowSeparator, minorSeparator)
        case lastColumn if lastColumn == board.columns - 1 =>
          printf("%1$c%1$c%1$c%2$c%3$c", rowSeparator, rightEnd, '\n')
        case _ =>
          if (columnNotZeroBoundIndex % columnSquareRoot == 0) {
            printf("%1$c%1$c%1$c%2$c", rowSeparator, majorSeparator)
          } else {
            printf("%1$c%1$c%1$c%2$c", rowSeparator, minorSeparator)
          }
      }
    }
  }
}

object SudokuTextTerminal {
  def apply(board: SudokuBoard): SudokuTextTerminal = {
    new SudokuTextTerminal(board)
  }
}

package com.hugemane.sudoku.solver

import com.hugemane.sudoku.solver.BoardPoint.Point
import com.hugemane.sudoku.solver.model.{ Block, SudokuBoard }

package object service {

  case class Solve()

  case class Solved(solution: (Point, Block))

  case class BoardSolved(board: SudokuBoard)

}

package com.hugemane.sudoku.solver.solution

import com.hugemane.sudoku.solver.BoardPoint.Point
import com.hugemane.sudoku.solver.model.Block

trait SolutionBase {
  type Solved

  def solve(line: Map[Point, Block]): Solved
}

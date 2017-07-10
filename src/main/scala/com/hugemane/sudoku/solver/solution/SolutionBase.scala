package com.hugemane.sudoku.solver.solution

import com.hugemane.sudoku.solver.model.{ Block, Point }

trait SolutionBase {
  type Solved

  def solve(line: Map[Point, Block]): Solved
}

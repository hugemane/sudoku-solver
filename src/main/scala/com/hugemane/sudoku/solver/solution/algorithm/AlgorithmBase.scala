package com.hugemane.sudoku.solver.solution.algorithm

import com.hugemane.sudoku.solver.model.{ Block, Point }

trait AlgorithmBase {
  type Solved

  def solve(line: Map[Point, Block]): Solved
}

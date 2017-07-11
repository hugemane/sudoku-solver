package com.hugemane.sudoku.solver.solution

import com.hugemane.sudoku.solver.BoardPoint.Point
import com.hugemane.sudoku.solver.model.Block

class SingleMissingValueSolution extends SolutionBase {
  type Solved = Option[(Point, Block)]

  override def solve(values: Map[Point, Block]): Solved = {
    val nonSolved = for (pointBlock <- values; if !pointBlock._2.isSolved) yield pointBlock

    nonSolved match {
      case x if x.size > 1 => None
      case _ =>
        val numbersSorted = values.toSeq.map(_._2.value.getOrElse(0))

        var result = 0
        for (i <- numbersSorted.indices) {
          if (numbersSorted(i) != 0) result ^= numbersSorted(i)
          result ^= (i + 1)
        }

        val (point, block) = nonSolved.head
        Some((point, block.copy(value = Some(result))))
    }
  }
}

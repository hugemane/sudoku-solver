package com.hugemane.sudoku.solver.service.partition

import com.hugemane.sudoku.solver.BoardPoint.Point
import com.hugemane.sudoku.solver.model.Block

trait BoardPartitionSolutionCheck {

  def isPartitionSolved(partition: Seq[(Point, Block)]): Boolean = {
    val unsolved = partition.filterNot(_._2.isSolved)
    unsolved.isEmpty
  }
}

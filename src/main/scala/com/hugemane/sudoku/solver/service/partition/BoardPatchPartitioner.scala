package com.hugemane.sudoku.solver.service.partition

import com.hugemane.sudoku.solver.BoardPoint.Point
import com.hugemane.sudoku.solver.model.{ Block, SudokuBoard }

import scala.math.sqrt

trait BoardPatchPartitioner {

  def partitionIntoPatches(board: SudokuBoard): List[Map[Point, Block]] = {
    val rowSeparation = sqrt(board.rows)
    val columnSeparation = sqrt(board.columns)

    //todo: solve (get past for now to solve maximum amount of problems)
    val patch1 = board.blocks.filter(x => List((0, 0), (0, 1), (1, 0), (1, 1)).contains(x._1))
    val patch2 = board.blocks.filter(x => List((0, 2), (0, 3), (1, 2), (1, 3)).contains(x._1))
    val patch3 = board.blocks.filter(x => List((2, 0), (2, 1), (3, 0), (3, 1)).contains(x._1))
    val patch4 = board.blocks.filter(x => List((2, 2), (2, 3), (3, 2), (3, 3)).contains(x._1))

    List(patch1, patch2, patch3, patch4)
  }
}

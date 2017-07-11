package com.hugemane.sudoku.solver.service.partition

import com.hugemane.sudoku.solver.TestSpec
import com.hugemane.sudoku.solver.model.SudokuBoard

class BoardPatchPartitionerSpec extends TestSpec with BoardPatchPartitioner {

  it should "partition 4x4 board into 4 patches" in {
    val board = SudokuBoard((4, 4), Map(
      (0, 1) -> 3,
      (1, 0) -> 2, (1, 1) -> 1,
      (0, 2) -> 1, (0, 3) -> 2,
      (1, 2) -> 3,
      (2, 0) -> 3, (2, 1) -> 4,
      (3, 0) -> 1,
      (2, 2) -> 2, (2, 3) -> 1,
      (3, 2) -> 4
    ))

    val boardPatches = partitionIntoPatches(board)

    boardPatches.size shouldEqual 4
    boardPatches.foreach(p => p.size shouldEqual 4)
    boardPatches.flatten.map(_._1).distinct.size shouldEqual 16
  }
}

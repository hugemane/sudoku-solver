package com.hugemane.sudoku.solver.service.partition

import com.hugemane.sudoku.solver.TestSpec
import com.hugemane.sudoku.solver.model.Block

class BoardPartitionSolutionCheckSpec extends TestSpec with BoardPartitionSolutionCheck {

  it should "report partition as solved when all blocks in partition are solved" in {
    val partition = Seq(
      (0, 0) -> Block(4), (0, 1) -> Block(3),
      (1, 0) -> Block(2), (1, 1) -> Block(1)
    )
    isPartitionSolved(partition) shouldBe true
  }

  it should "report partition as not solved when some blocks in partition are not solved" in {
    val partition = Seq(
      (0, 0) -> Block(None), (0, 1) -> Block(3),
      (1, 0) -> Block(2), (1, 1) -> Block(1)
    )
    isPartitionSolved(partition) shouldBe false
  }
}

package com.hugemane.sudoku.solver.model.assist

import com.hugemane.sudoku.solver.TestSpec
import com.hugemane.sudoku.solver.model.Block

class BlockSolvedSpec extends TestSpec {

  it should "be solved when block has value" in {
    val block = Block(Some(1))
    block.isSolved shouldBe true
  }

  it should "not be solved when block has no value" in {
    val block = Block(None)
    block.isSolved shouldBe false
  }
}

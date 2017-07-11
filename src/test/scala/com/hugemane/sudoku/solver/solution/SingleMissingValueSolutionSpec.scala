package com.hugemane.sudoku.solver.solution

import com.hugemane.sudoku.solver.TestSpec
import com.hugemane.sudoku.solver.model.Block

class SingleMissingValueSolutionSpec extends TestSpec {

  it should "solve missing line block value" in {
    val line = Map(
      (0, 0) -> Block(None),
      (0, 1) -> Block(Some(2)),
      (0, 2) -> Block(Some(3)),
      (0, 3) -> Block(Some(4))
    )

    val solution = new SingleMissingValueSolution()
    val solved = solution.solve(line)

    val (point, block) = solved.get

    point shouldBe (0, 0)
    block.isSolved should be(true)
    block.value shouldBe Some(1)
  }

  it should "solve missing patch block value" in {
    val line = Map(
      (0, 0) -> Block(Some(4)),
      (0, 1) -> Block(Some(1)),
      (1, 0) -> Block(None),
      (1, 1) -> Block(Some(3))
    )

    val solution = new SingleMissingValueSolution()
    val solved = solution.solve(line)

    val (point, block) = solved.get

    point shouldBe (1, 0)
    block.isSolved should be(true)
    block.value shouldBe Some(2)
  }

  it should "solve missing line last block value" in {
    val line = Map(
      (0, 0) -> Block(Some(1)),
      (0, 1) -> Block(Some(2)),
      (0, 2) -> Block(Some(3)),
      (0, 3) -> Block(None)
    )

    val solution = new SingleMissingValueSolution()
    val solved = solution.solve(line)

    val (point, block) = solved.get

    point shouldBe (0, 3)
    block.isSolved should be(true)
    block.value shouldBe Some(4)
  }

  it should "not have a solution when line has not got one left over block to solve" in {
    val line = Map(
      (0, 0) -> Block(Some(1)),
      (0, 1) -> Block(None),
      (0, 2) -> Block(Some(3)),
      (0, 3) -> Block(None)
    )

    val solution = new SingleMissingValueSolution()
    val solved = solution.solve(line)

    solved shouldBe None
  }
}

package com.hugemane.sudoku.solver.solution.algorithm

import com.hugemane.sudoku.solver.TestSpec
import com.hugemane.sudoku.solver.model.{ Block, Point }

class SingleMissingValueAlgorithmSpec extends TestSpec {

  it should "solve missing line block value" in {
    val line = Map(
      Point(0, 0) -> Block(None),
      Point(0, 1) -> Block(Some(2)),
      Point(0, 2) -> Block(Some(3)),
      Point(0, 3) -> Block(Some(4))
    )

    val algorithm = new SingleMissingValueAlgorithm()
    val solved = algorithm.solve(line)

    val (point, block) = solved.get

    point shouldBe Point(0, 0)
    block.isSolved should be(true)
    block.value shouldBe Some(1)
  }

  it should "solve missing patch block value" in {
    val line = Map(
      Point(0, 0) -> Block(Some(4)),
      Point(0, 1) -> Block(Some(1)),
      Point(1, 0) -> Block(None),
      Point(1, 1) -> Block(Some(3))
    )

    val algorithm = new SingleMissingValueAlgorithm()
    val solved = algorithm.solve(line)

    val (point, block) = solved.get

    point shouldBe Point(1, 0)
    block.isSolved should be(true)
    block.value shouldBe Some(2)
  }

  it should "solve missing line last block value" in {
    val line = Map(
      Point(0, 0) -> Block(Some(1)),
      Point(0, 1) -> Block(Some(2)),
      Point(0, 2) -> Block(Some(3)),
      Point(0, 3) -> Block(None)
    )

    val algorithm = new SingleMissingValueAlgorithm()
    val solved = algorithm.solve(line)

    val (point, block) = solved.get

    point shouldBe Point(0, 3)
    block.isSolved should be(true)
    block.value shouldBe Some(4)
  }

  it should "not have a solution when line has not got one left over block to solve" in {
    val line = Map(
      Point(0, 0) -> Block(Some(1)),
      Point(0, 1) -> Block(None),
      Point(0, 2) -> Block(Some(3)),
      Point(0, 3) -> Block(None)
    )

    val algorithm = new SingleMissingValueAlgorithm()
    val solved = algorithm.solve(line)

    solved shouldBe None
  }
}

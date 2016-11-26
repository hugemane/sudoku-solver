package com.hugemane.sudoku.solver.model.assist

trait BlockSolved {
  def value: Option[Int]

  def isSolved: Boolean = value.isDefined
}

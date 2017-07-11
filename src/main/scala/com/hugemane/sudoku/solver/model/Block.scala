package com.hugemane.sudoku.solver.model

import com.hugemane.sudoku.solver.model.assist.BlockSolved

case class Block(value: Option[Int], possibilities: List[Int] = List[Int]()) extends BlockSolved

object Block {
  def apply(value: Int): Block = {
    Block(Some(value))
  }
}


package com.hugemane.sudoku.solver.service.board

import akka.actor.{ Actor, ActorRef, Props }
import com.hugemane.sudoku.solver.model.SudokuBoard
import com.hugemane.sudoku.solver.service.{ BoardSolved, Solved }

case class ObtainBoard()
case class ObtainBoardDone(board: SudokuBoard)

case class SolutionHandler(solutionHandler: ActorRef)

class BoardMasterActor(board: SudokuBoard, val solutionHandler: ActorRef) extends Actor {
  private[this] val sudokuBoard: SudokuBoard = board

  def receive = {
    case ObtainBoard() =>
      sender() ! ObtainBoardDone(board)

    case Solved(solution) =>
      sudokuBoard.setBlock(solution._1, solution._2)
      notifyWhenSolved()
  }

  def notifyWhenSolved() {
    if (sudokuBoard.isSolved())
      solutionHandler ! BoardSolved(sudokuBoard)
  }
}

object BoardMasterActor {
  def props(board: SudokuBoard, solutionHandler: ActorRef) = Props(new BoardMasterActor(board, solutionHandler))
  val name = "BoardMaster"
}

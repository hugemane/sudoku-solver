package com.hugemane.sudoku.solver.service

import akka.actor.ActorRef
import akka.pattern.ask
import akka.util.Timeout
import com.hugemane.sudoku.solver.model.SudokuBoard
import com.hugemane.sudoku.solver.service.board.BoardMasterActor
import com.hugemane.sudoku.solver.service.patch.PatchMasterActor
import com.hugemane.sudoku.solver.service.solver.{ BoardSolverActor, SolvedBoard }
import com.hugemane.sudoku.solver.service.system.ActorSystemAccessor

import scala.concurrent.duration._
import scala.concurrent.{ Await, Future }

class SudokuSolverService(board: SudokuBoard) extends ActorSystemAccessor {
  private[this] var boardSolver: ActorRef = _

  def initialize() {
    boardSolver = system.actorOf(BoardSolverActor.props(), BoardSolverActor.name)
    system.actorOf(BoardMasterActor.props(board, boardSolver), BoardMasterActor.name)
    system.actorOf(PatchMasterActor.props(), PatchMasterActor.name)
  }

  def solve(): SudokuBoard = {
    implicit val timeout = Timeout(10.seconds)
    val result = Await.result(boardSolver ? Solve(), timeout.duration).asInstanceOf[SolvedBoard]
    result.board
  }

  def solvedBoardHandler(solvedBoard: SudokuBoard): Future[SudokuBoard] = Future {
    solvedBoard
  }
}

object SudokuSolverService {
  def apply(board: SudokuBoard): SudokuSolverService = {
    val solverService = new SudokuSolverService(board)
    solverService.initialize()
    solverService
  }
}


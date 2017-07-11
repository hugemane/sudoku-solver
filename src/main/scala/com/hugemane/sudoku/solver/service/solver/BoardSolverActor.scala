package com.hugemane.sudoku.solver.service.solver

import akka.actor.{ Actor, ActorLogging, ActorRef, Props }
import com.hugemane.sudoku.solver.model.SudokuBoard
import com.hugemane.sudoku.solver.service.board.BoardMasterActor
import com.hugemane.sudoku.solver.service.system.ActorLocator
import com.hugemane.sudoku.solver.service.{ BoardSolved, Solve, Solved }

import scala.concurrent.duration._

case class RegisterSolutionListener(solutionListener: ActorRef)
case class SolveUsingListeners()
case class SolvedBoard(board: SudokuBoard)

class BoardSolverActor extends Actor with ActorLogging with ActorLocator {
  private[this] var solutionListeners = List[ActorRef]()

  def receive = {
    case RegisterSolutionListener(solutionListener) =>
      solutionListeners = solutionListener :: solutionListeners

    case Solve() =>
      context.become(handleBoardSolution(sender()))

      implicit val ec = context.system.dispatcher

      context.system.scheduler.schedule(
        0.milliseconds,
        100.milliseconds,
        self,
        SolveUsingListeners()
      )
  }

  def handleBoardSolution(requester: ActorRef): Receive = {
    case RegisterSolutionListener(solutionListener) =>
      solutionListeners = solutionListener :: solutionListeners

    case SolveUsingListeners() =>
      solutionListeners.foreach(_ ! Solve())

    case Solved(solution) =>
      localActor(BoardMasterActor.name) ! Solved(solution)

    case BoardSolved(solvedBoard) =>
      requester ! SolvedBoard(solvedBoard)
  }
}

object BoardSolverActor {
  def props() = Props[BoardSolverActor]
  val name = "BoardSolver"
}
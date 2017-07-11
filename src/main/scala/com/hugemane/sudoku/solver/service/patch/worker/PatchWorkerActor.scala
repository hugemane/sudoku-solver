package com.hugemane.sudoku.solver.service.patch.worker

import akka.actor.{ Actor, Props }
import com.hugemane.sudoku.solver.BoardPoint.Point
import com.hugemane.sudoku.solver.model.Block
import com.hugemane.sudoku.solver.service.partition.BoardPartitionSolutionCheck
import com.hugemane.sudoku.solver.service.solver.BoardSolverActor
import com.hugemane.sudoku.solver.service.system.ActorLocator
import com.hugemane.sudoku.solver.service.{ Solve, Solved }
import com.hugemane.sudoku.solver.solution.SingleMissingValueSolution

class PatchWorkerActor(patch: Map[Point, Block]) extends Actor with ActorLocator with BoardPartitionSolutionCheck {
  private[this] val patchSolver = new SingleMissingValueSolution()
  private[this] var workerPatch = patch

  def receive = {
    case Solve() =>
      if (!isPartitionSolved(workerPatch.toSeq)) {
        val solutionResult = patchSolver.solve(patch)

        if (solutionResult.isDefined) {
          val solution = solutionResult.get
          workerPatch += (solution._1 -> solution._2)
          localActor(BoardSolverActor.name) ! Solved(solution)
        }
      }
  }
}

object PatchWorkerActor {
  def props(patch: Map[Point, Block]) = Props(new PatchWorkerActor(patch))
}
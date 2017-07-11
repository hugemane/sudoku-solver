package com.hugemane.sudoku.solver.service.patch

import akka.actor.{ Actor, Props }
import com.hugemane.sudoku.solver.service.board.{ BoardMasterActor, ObtainBoard, ObtainBoardDone }
import com.hugemane.sudoku.solver.service.partition.BoardPatchPartitioner
import com.hugemane.sudoku.solver.service.patch.worker.PatchWorkerActor
import com.hugemane.sudoku.solver.service.solver.{ BoardSolverActor, RegisterSolutionListener }
import com.hugemane.sudoku.solver.service.system.ActorLocator

class PatchMasterActor extends Actor with BoardPatchPartitioner with ActorLocator {

  override def preStart() {
    localActor(BoardMasterActor.name) ! ObtainBoard()
  }

  def receive = {
    case ObtainBoardDone(board) =>
      val boardPatches = partitionIntoPatches(board)

      boardPatches.foreach { patch =>
        val boardPatchWorker = context.actorOf(PatchWorkerActor.props(patch))
        localActor(BoardSolverActor.name) ! RegisterSolutionListener(boardPatchWorker)
      }
  }
}

object PatchMasterActor {
  def props() = Props[PatchMasterActor]
  val name = "PatchMaster"
}

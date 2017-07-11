package com.hugemane.sudoku.solver.service.system

import akka.actor.{ ActorContext, ActorSelection }
import com.hugemane.sudoku.solver.service.system.extender.ActorSystemExtender._

trait ActorLocator {
  implicit val context: ActorContext

  def localActor(actorName: String): ActorSelection = {
    context.system.lookup_existing_actor(actorName)
  }
}

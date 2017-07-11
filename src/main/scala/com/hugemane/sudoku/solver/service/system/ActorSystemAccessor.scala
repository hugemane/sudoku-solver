package com.hugemane.sudoku.solver.service.system

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer

trait ActorSystemAccessor {
  implicit val system: ActorSystem = ActorSystem()
  implicit val executor = system.dispatcher
  implicit val materializer = ActorMaterializer()
}

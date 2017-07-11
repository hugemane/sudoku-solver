name := "sudoku-solver"
organization := "com.hugemane"
version := "0.1"
scalaVersion := "2.12.2"

lazy val akka_version = "2.5.3"

libraryDependencies ++= Seq(
	"com.typesafe.akka" %% "akka-actor" % akka_version,
	"com.typesafe.akka" %% "akka-stream" % akka_version,
	"org.scalatest" %% "scalatest" % "3.0.1" % "test"
)



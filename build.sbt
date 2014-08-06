name := """inspecione"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws ,
  "org.xhtmlrenderer" % "flying-saucer-pdf" % "9.0.6"
)

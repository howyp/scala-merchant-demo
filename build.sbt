import sbt.Keys.libraryDependencies

organization := "com.github.howyp"
name := "scala-merchant-demo"
version := "0.0.1-SNAPSHOT"
scalaVersion := "2.12.4"

val CirceVersion   = "0.8.0"
val Http4sVersion  = "0.17.5"
val LogbackVersion = "1.2.3"

libraryDependencies ++= Seq(
  "org.http4s"     %% "http4s-blaze-server"  % Http4sVersion,
  "org.http4s"     %% "http4s-circe"         % Http4sVersion,
  "org.http4s"     %% "http4s-dsl"           % Http4sVersion,
  "io.circe"       %% "circe-generic"        % CirceVersion,
  "io.circe"       %% "circe-generic-extras" % CirceVersion,
  "io.circe"       %% "circe-literal"        % CirceVersion,
  "io.circe"       %% "circe-java8"          % CirceVersion,
  "ch.qos.logback" % "logback-classic"       % LogbackVersion,
  "org.scalatest"  %% "scalatest"            % "3.0.4" % Test
)

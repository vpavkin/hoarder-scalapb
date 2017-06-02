import sbt.Keys._

lazy val buildSettings = Seq(
  scalaVersion := "2.12.2",
  crossScalaVersions := Seq("2.12.2"),
  organization := "ru.pavkin"
)

lazy val compilerSettings = Seq(
  scalacOptions ++= Seq(
    "-deprecation:false",
    "-encoding", "UTF-8",
    "-feature",
    "-language:existentials",
    "-language:higherKinds",
    "-unchecked",
    "-Xfatal-warnings",
    "-Yno-adapted-args",
    "-Ywarn-dead-code",
    "-Ywarn-numeric-widen",
    "-Ypartial-unification",
    "-Xfuture"
  )
)


lazy val sourceSettings = buildSettings ++ compilerSettings

lazy val hoarderScalaPB = (project in file("."))
  .settings(
    PB.targets in Compile := Seq(
      scalapb.gen(
        flatPackage = true,
        grpc = false) -> (sourceManaged in Compile).value
    )
  )

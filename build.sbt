enablePlugins(GitVersioning)

name := "scalaz-stream-contrib"

organization := "eu.timepit"

licenses += "MIT" -> url("http://opensource.org/licenses/MIT")

scalaVersion := "2.11.6"

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-unchecked",
  "-Xfatal-warnings",
  "-Xlint",
  "-Yno-adapted-args",
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard"
)

scalacOptions in (Compile, doc) ++= Seq(
  "-diagrams",
  "-doc-source-url", scmInfo.value.get.browseUrl + "/tree/master€{FILE_PATH}.scala",
  "-sourcepath", baseDirectory.in(LocalRootProject).value.getAbsolutePath
)

autoAPIMappings := true

libraryDependencies ++= Seq(
  "org.scalaz.stream" %% "scalaz-stream" % "0.7a",
  "com.nicta" %% "rng" % "1.3.0",
  "org.scalacheck" %% "scalacheck" % "1.12.2" % "test"
)

resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"

scmInfo := Some(ScmInfo(url("https://github.com/fthomas/scalaz-stream-contrib"),
  "git@github.com:fthomas/scalaz-stream-contrib.git"))

initialCommands := """
  import scalaz._
  import scalaz.Scalaz._
  import scalaz.concurrent.Task
  import scalaz.stream._
  import eu.timepit.scalaz.stream.contrib._
"""

bintraySettings

publishMavenStyle := true

wartremoverErrors in (Compile, compile) ++= Warts.allBut(
  Wart.Any,
  Wart.Nothing,
  Wart.Throw
)

scalariformSettings

git.useGitDescribe := true

name := "util-backports"
organization := "com.github.bigwheel"
version := "2.1"
scalaVersion := "2.12.10"

crossScalaVersions := Seq("2.11.12", "2.12.10", "2.13.1")

Compile / sources := {
  scalaVersion.value match {
    case CrossVersion.PartialVersion("2", "11" | "12") => (Compile / sources).value
    case _ => Nil
  }
}

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.8" % Test
)

// about maven publish
publishMavenStyle := true
publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}
publishArtifact in Test := false
licenses := Seq("BSD-3-Clause" -> url("https://github.com/bigwheel/util-backports/blob/master/LICENSE"))
homepage := Some(url("https://github.com/bigwheel/util-backports"))
pomExtra := (
  <scm>
    <url>git@github.com:bigwheel/util-backports.git</url>
    <connection>scm:git:git@github.com:bigwheel/util-backports.git</connection>
  </scm>
    <developers>
      <developer>
        <id>bigwheel</id>
        <name>k.bigwheel</name>
        <url>https://github.com/bigwheel</url>
      </developer>
    </developers>
  )

name := "util-backports"
organization := "com.github.bigwheel"
version := "1.0"
scalaVersion := "2.12.6"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.5" % Test
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

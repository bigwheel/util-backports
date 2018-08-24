# util backports from scala 2.13 to 2.12 [![Build Status](https://travis-ci.com/bigwheel/util-backports.svg?branch=master)](https://travis-ci.com/bigwheel/util-backports)

This is a backport library of Scala Standard Library util package from 2.13 to 2.12.
2.13 util package contains following new features.

* tap
* pipe
* loan pattern

## Installation

util-backports is available from maven central.

Latest release: Maven Central

If you use SBT you can include util-backports in your project with

```scala
libraryDependencies += "com.github.bigwheel" %% "util-backports" % "1.0"
```

## Usage

```scala
import com.github.bigwheel.util.chaining._

val str = "42"
str.tap(println)
println(1 + str.pipe(_.length))


import com.github.bigwheel.util.Using

Using.resource(new PrintWriter("write-target.txt")) { pw =>
  pw.write("hello world")
  // no need to close !
}
```

## Development hint

### How to check util package new feature in 2.13

```bash
git clone git@github.com:scala/scala.git
cd scala
git diff --stat=300,300 --stat-graph-width=20 origin/2.12.x..origin/2.13.x -- src/library/scala/util
git diff --stat=300,300 --stat-graph-width=20 origin/2.12.x..origin/2.13.x -- test/junit/scala/util
```

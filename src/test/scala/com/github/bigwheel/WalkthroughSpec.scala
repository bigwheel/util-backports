package com.github.bigwheel

import java.io.PrintWriter

import org.scalatest.FunSuite

class WalkthroughSpec extends FunSuite {

  test("walkthrough") {
    import scala.util.chaining._

    val str = "42"
    str.tap(println)
    println(1 + str.pipe(_.length))


    import scala.util.Using

    Using.resource(new PrintWriter("write-target.txt")) { pw =>
      pw.write("hello world")
      // no need to close !
    }
  }

}

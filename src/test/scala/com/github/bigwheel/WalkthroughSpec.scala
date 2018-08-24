package com.github.bigwheel

import java.io.PrintWriter

import org.scalatest.FunSuite

class WalkthroughSpec extends FunSuite {

  test("walkthrough") {
    import com.github.bigwheel.util.chaining._

    val str = "42"
    str.tap(println)
    println(1 + str.pipe(_.length))


    import com.github.bigwheel.util.Using

    Using.resource(new PrintWriter("write-target.txt")) { pw =>
      pw.write("hello world")
      // no need to close !
    }
  }

}

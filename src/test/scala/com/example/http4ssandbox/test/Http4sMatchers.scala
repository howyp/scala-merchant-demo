package com.example.http4ssandbox.test

import io.circe.Json
import org.http4s.{HeaderKey, Response, Status}
import org.http4s.circe._
import org.scalatest.matchers.{HavePropertyMatchResult, HavePropertyMatcher}

trait Http4sMatchers {
  def status(expected: Status) = HavePropertyMatcher { (response: Response) =>
    HavePropertyMatchResult(response.status == expected, "status", expected, response.status)
  }
  def header(expected: HeaderKey.Extractable) = HavePropertyMatcher { (response: Response) =>
    HavePropertyMatchResult(response.headers.get(expected).isDefined,
                            "header keys",
                            "containing " + expected.name,
                            response.headers.map(_.name))
  }
  def body(expected: Json) = HavePropertyMatcher { (response: Response) =>
    val actual = response.as(jsonOf[Json]).unsafeRun()
    HavePropertyMatchResult(actual == expected, "body", expected, actual)
  }
}
package com.fmgallego

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class ChallengeAppSpec extends AnyFlatSpec with Matchers {

  val args1: Array[String] = Array("2x2!3x2!3x1!3x0!2x0!1x0!0x0", "4x3", "3")
  val args2: Array[String] = Array("0x2!1x2!2x2!3x2!3x1!2x1!1x1", "4x3", "3")
  val args3: Array[String] = Array("0x2!1x2!2x2!3x2!3x1!2x1!1x1", "5x3", "4")
  val args4: Array[String] = Array("0x2!0x1!0x0!1x0!1x1!1x2", "2x3", "10")
  val args5: Array[String] = Array("5x5!5x4!4x4!4x5", "10x10", "4")

  ChallengeApp.runner(args1) shouldBe 7

  ChallengeApp.runner(args2) shouldBe 3

  ChallengeApp.runner(args3) shouldBe 6

  ChallengeApp.runner(args4) shouldBe 1

  ChallengeApp.runner(args5) shouldBe 81

}

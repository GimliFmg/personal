package com.fmgallego.configuration

import org.apache.logging.log4j.scala.Logging
import org.rogach.scallop.{ScallopConf, ScallopOption}

/**
  * Case class for managing the different arguments
  *
  * @param arguments a seq of the different parameters
  */
case class AppConf(arguments: Seq[String]) extends ScallopConf(arguments) with Logging {

  logger.info("Parse execution Args")

  banner("Input parameters: ")

  /**
    * Argument inputSnakeArray: Parameter to create a new Snake Array
    */
  val inputSnakeArray: ScallopOption[String] =
    opt[String](short = 's', required = true,
      descr = "Parameter to create a new Snake Array")

  /**
    * Argument inputBoardSize: Parameter to determine board
    */
  val inputBoardSize: ScallopOption[String] =
    opt[String](short = 'b', required = true,
      descr = "Parameter to create a new board")

  /**
    * Argument requiredDepth: Parameter to determine depth
    */
  val requiredDepth: ScallopOption[String] =
    opt[String](short = 'd', required = true,
      descr = "Parameter to determine depth")

  /**
    * Validations
    */
  validateOpt(inputSnakeArray, inputBoardSize, requiredDepth) {
    case (None, _, _) => Left("Input Snake Array is missing")
    case (_, None, _) => Left("Board size values are missing")
    case (_, _, None) => Left("Required Depth is missing")
  }

  verify()

}

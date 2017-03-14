package com.marotti.cards

import scala.language.implicitConversions

object HandType extends Enumeration {
  protected case class Val(printValue: String) extends super.Val
  implicit def valueToHandVal(x: Value) = x.asInstanceOf[Val]

  type HandType = Value

  val HIGH_CARD = Val("High Card")
  val PAIR = Val("Pair")
  val TWO_PAIR = Val("Two Pairs")
  val TRIPS = Val("Three of a Kind")
  val STRAIGHT = Val("Straight")
  val FLUSH = Val("Flush")
  val FULL_HOUSE = Val("Full House")
  val QUADS = Val("Four of a Kind")
  val STRAIGHT_FLUSH = Val("Straight Flush")
}

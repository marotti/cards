package com.marotti.cards

object FaceCardType extends Enumeration {
  protected case class Val(numericVal: Int, printValue: String) extends super.Val
  implicit def valueToFaceCardVal(x: Value) = x.asInstanceOf[Val]

  type FaceCardType = Value
  val T = Val(10, "10")
  val J = Val(11, "Jack")
  val Q = Val(12, "Queen")
  val K = Val(13, "King")
  val A = Val(14, "Ace")

  def withNameOpt(s: String): Option[Value] = values.find(_.toString == s)
}

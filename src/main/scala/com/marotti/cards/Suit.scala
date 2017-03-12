package com.marotti.cards

object Suit extends Enumeration {
  protected case class Val(printValue: String) extends super.Val
  implicit def valueToFaceSuitVal(x: Value) = x.asInstanceOf[Val]

  type Suit = Value
  val S = Val("Spades")
  val H = Val("Hearts")
  val D = Val("Diamonds")
  val C = Val("Clubs")

  def withNameOpt(s: String): Option[Value] = values.find(_.toString == s)
}

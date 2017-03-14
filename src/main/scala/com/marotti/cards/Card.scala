package com.marotti.cards

import com.marotti.cards.Suit._
import com.marotti.cards.FaceCardType.{FaceCardType, _}

abstract class Card(n: Any, s: Suit) extends Ordered [Card] {
  def numericValue(): Int

  def compare (that: Card) = this.numericValue().compare(that.numericValue())
  def suit = s

  def equalsWithSuit(that: Card): Boolean = {
    compare(that) match {
      case 0 => this.suit == that.suit
      case _ => false
    }
  }

  override def toString() = "" + n + s
  def toVerboseString(): String
}

protected case class NumberCard(n: Int, s: Suit) extends Card(n, s) {
  def numericValue(): Int = {
    n
  }

  def toVerboseString() = "" + n + " " + s.printValue
}

protected case class FaceCard(n: FaceCardType, s: Suit) extends Card(n, s) {
  def numericValue(): Int = {
    n.numericVal
  }

  def toVerboseString() = "" + n.printValue + " " + s.printValue
}

case class CardException(message: String = "", cause: Throwable = null) extends Exception(message, cause)

object Card {

  def createCard(n: Any, s:String): Card = n match {
    case i: Int => NumberCard(convertNumber(i), convertSuit(s))
    case f: String => FaceCard(convertFaceCard(f), convertSuit(s))
  }

  def convertNumber(i: Int) :Int = {
    if(i >= 2 && i <= 9) i
    else throw CardException("Number Card values must be between 2 and 9")
  }

  def convertSuit(s: String) :Suit = {
    def suit: Option[Suit] = Suit.withNameOpt(s)
    suit match {
      case None => throw CardException("Suit can only be the values of H, D, C, or S")
      case _ => return suit.get
    }
  }

  def convertFaceCard(s: String) :FaceCardType = {
    def faceCard: Option[FaceCardType] = FaceCardType.withNameOpt(s)
    faceCard match {
      case None => throw CardException("Face Card values can only be T, J, Q, K, or A")
      case _ => return faceCard.get
    }
  }
}

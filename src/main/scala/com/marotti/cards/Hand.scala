package com.marotti.cards

import com.marotti.cards.HandType._

class Hand(cardList: List[Card]) {
  def cards = cardList
  val sortedList = cardList.sortWith(_ > _)
  val resolved: HandType = {
//    HandType.values.iterator.map(evaluateHand(_)).takeWhile(!_)
  }

  def evaluateHand(handType: HandType) :Boolean = handType match {
//    case STRAIGHT_FLUSH => false
//    case QUADS => false
//    case FULL_HOUSE => false
//    case FLUSH => false
//    case STRAIGHT => false
//    case TRIPS => false
//    case TWO_PAIR => false
//    case PAIR => false
//    case _ => true
  }

  override def toString: String = cards.mkString(" ")
}

object Hand {
  def createHand(cardList: List[Card]): Hand = {
    new Hand(cardList)
  }
}
package com.marotti.cards

import org.scalatest.{FlatSpec, Matchers}

class HandTypeSpec extends FlatSpec with Matchers {
  "HandType" should "have the appropriate print value" in {
    assert("High Card" == HandType.HIGH_CARD.printValue)
    assert("Pair" == HandType.PAIR.printValue)
    assert("Two Pairs" == HandType.TWO_PAIR.printValue)
    assert("Three of a Kind" == HandType.TRIPS.printValue)
    assert("Straight" == HandType.STRAIGHT.printValue)
    assert("Flush" == HandType.FLUSH.printValue)
    assert("Full House" == HandType.FULL_HOUSE.printValue)
    assert("Four of a Kind" == HandType.QUADS.printValue)
    assert("Straight Flush" == HandType.STRAIGHT_FLUSH.printValue)
  }
}

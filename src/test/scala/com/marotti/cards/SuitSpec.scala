package com.marotti.cards

import org.scalatest.{FlatSpec, Matchers}

class SuitSpec extends FlatSpec with Matchers {
  "A Suit" should "have the appropriate print value" in {
    assert("Spades" == Suit.S.printValue)
    assert("Hearts" == Suit.H.printValue)
    assert("Diamonds" == Suit.D.printValue)
    assert("Clubs" == Suit.C.printValue)
  }

  it should "return options for withNameOpt" in {
    assert(Some(Suit.S) == Suit.withNameOpt("S"))
    assert(Some(Suit.H) == Suit.withNameOpt("H"))
    assert(Some(Suit.D) == Suit.withNameOpt("D"))
    assert(Some(Suit.C) == Suit.withNameOpt("C"))
    assert(None == Suit.withNameOpt("X"))
  }

}

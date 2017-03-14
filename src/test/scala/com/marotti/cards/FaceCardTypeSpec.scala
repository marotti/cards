package com.marotti.cards

import org.scalatest.{FlatSpec, Matchers}

class FaceCardTypeSpec  extends FlatSpec with Matchers {
  "A FaceCardType" should "have the appropriate print value" in {
    assert("10" == FaceCardType.T.printValue)
    assert("Jack" == FaceCardType.J.printValue)
    assert("Queen" == FaceCardType.Q.printValue)
    assert("King" == FaceCardType.K.printValue)
    assert("Ace" == FaceCardType.A.printValue)
  }

  it should "have the appropriate numeric value" in {
    assert(10 == FaceCardType.T.numericVal)
    assert(11 == FaceCardType.J.numericVal)
    assert(12 == FaceCardType.Q.numericVal)
    assert(13 == FaceCardType.K.numericVal)
    assert(14 == FaceCardType.A.numericVal)
  }

  it should "return options for withNameOpt" in {
    assert(Some(FaceCardType.T) == FaceCardType.withNameOpt("T"))
    assert(Some(FaceCardType.J) == FaceCardType.withNameOpt("J"))
    assert(Some(FaceCardType.Q) == FaceCardType.withNameOpt("Q"))
    assert(Some(FaceCardType.K) == FaceCardType.withNameOpt("K"))
    assert(Some(FaceCardType.A) == FaceCardType.withNameOpt("A"))

  }
}

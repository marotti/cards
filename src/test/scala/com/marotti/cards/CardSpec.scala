package com.marotti.cards

import org.scalatest.{FlatSpec, Matchers}
import com.marotti.cards.Card._

class CardSpec extends FlatSpec with Matchers {
  "A Card" should "be created with numbers or letters" in {
    createCard(2, "C")
    createCard(5, "C")
    createCard("T", "C")
    createCard("K", "C")
    createCard("A", "C")
  }

  it should "fail if the numbers aren't between 1 and 10" in {
    assertThrows[CardException] {
      createCard(0, "C")
    }
    assertThrows[CardException] {
      createCard(-1, "C")
    }
    assertThrows[CardException] {
      createCard(10, "C")
    }
    assertThrows[CardException] {
      createCard(555, "C")
    }
  }

  it should "fail if the face card values aren't T, J, Q, K, or A" in {
    assertThrows[CardException] {
      createCard("X", "C")
    }
  }

  it should "fail if the suit values aren't H, D, C, or S" in {
    assertThrows[CardException] {
      createCard("T", "X")
    }
  }

  it should "have a numeric value equal to the numbercard integer value" in {
    for (i <- 2 to 9) assert(i == createCard(i, "S").numericValue())
  }

  it should "have correct numeric values for face card values" in {
    assert(10 == createCard("T", "C").numericValue())
    assert(11 == createCard("J", "S").numericValue())
    assert(12 == createCard("Q", "D").numericValue())
    assert(13 == createCard("K", "H").numericValue())
    assert(14 == createCard("A", "C").numericValue())
  }

  it should "print out the card correctly" in {
    assert("2C" == createCard(2, "C").toString)
    assert("TS" == createCard("T", "S").toString)
    assert("5D" == createCard(5, "D").toString)
    assert("AH" == createCard("A", "H").toString)
    assert("JH" == createCard("J", "H").toString)
    assert("QH" == createCard("Q", "H").toString)
    assert("KH" == createCard("K", "H").toString)
  }

  it should "print out the verbose version of the card correctly" in {
    assert("2 Clubs" == createCard(2, "C").toVerboseString)
    assert("10 Spades" == createCard("T", "S").toVerboseString)
    assert("5 Diamonds" == createCard(5, "D").toVerboseString)
    assert("Ace Hearts" == createCard("A", "H").toVerboseString)
    assert("Jack Hearts" == createCard("J", "H").toVerboseString)
    assert("Queen Hearts" == createCard("Q", "H").toVerboseString)
    assert("King Hearts" == createCard("K", "H").toVerboseString)
  }

  it should "execute compare and compare the numbers, but ignore suits" in {
    assert(0 < createCard(3, "H").compare(createCard(2, "H")))
    assert(0 < createCard(4, "H").compare(createCard(3, "H")))
    assert(0 < createCard(5, "H").compare(createCard(4, "H")))
    assert(0 < createCard(6, "H").compare(createCard(5, "H")))
    assert(0 < createCard(7, "H").compare(createCard(6, "H")))
    assert(0 < createCard(8, "H").compare(createCard(7, "H")))
    assert(0 < createCard(9, "H").compare(createCard(8, "H")))
    assert(0 < createCard("T", "H").compare(createCard(9, "H")))
    assert(0 < createCard("J", "H").compare(createCard("T", "H")))
    assert(0 < createCard("Q", "H").compare(createCard("J", "H")))
    assert(0 < createCard("K", "H").compare(createCard("Q", "H")))
    assert(0 < createCard("A", "H").compare(createCard("K", "H")))
    assert(0 < createCard("A", "H").compare(createCard(2, "H")))

    assert(0 == createCard(2, "H").compare(createCard(2, "H")))
    assert(0 == createCard(3, "H").compare(createCard(3, "H")))
    assert(0 == createCard(4, "H").compare(createCard(4, "H")))
    assert(0 == createCard(5, "H").compare(createCard(5, "H")))
    assert(0 == createCard(6, "D").compare(createCard(6, "D")))
    assert(0 == createCard(7, "H").compare(createCard(7, "H")))
    assert(0 == createCard(8, "H").compare(createCard(8, "C")))
    assert(0 == createCard(9, "H").compare(createCard(9, "H")))
    assert(0 == createCard("T", "H").compare(createCard("T", "H")))
    assert(0 == createCard("J", "H").compare(createCard("J", "H")))
    assert(0 == createCard("Q", "H").compare(createCard("Q", "H")))
    assert(0 == createCard("K", "H").compare(createCard("K", "H")))
    assert(0 == createCard("A", "H").compare(createCard("A", "H")))

    assert(0 > createCard(2, "H").compare(createCard(3, "H")))
    assert(0 > createCard(3, "H").compare(createCard(4, "H")))
    assert(0 > createCard(4, "H").compare(createCard(5, "H")))
    assert(0 > createCard(5, "H").compare(createCard(6, "H")))
    assert(0 > createCard(6, "H").compare(createCard(7, "H")))
    assert(0 > createCard(7, "H").compare(createCard(8, "H")))
    assert(0 > createCard(8, "H").compare(createCard(9, "H")))
    assert(0 > createCard(9, "H").compare(createCard("T", "H")))
    assert(0 > createCard("T", "H").compare(createCard("J", "H")))
    assert(0 > createCard("J", "H").compare(createCard("Q", "H")))
    assert(0 > createCard("Q", "H").compare(createCard("K", "H")))
    assert(0 > createCard("K", "H").compare(createCard("A", "H")))
  }

  it should "execute equalsWithSuit and compare the numbers and suits for equality" in {
    assert(createCard(2, "H").equalsWithSuit(createCard(2, "H")))
    assert(createCard(3, "H").equalsWithSuit(createCard(3, "H")))
    assert(createCard(4, "H").equalsWithSuit(createCard(4, "H")))
    assert(createCard(5, "H").equalsWithSuit(createCard(5, "H")))
    assert(createCard(6, "D").equalsWithSuit(createCard(6, "D")))
    assert(createCard(7, "H").equalsWithSuit(createCard(7, "H")))
    assert(!createCard(8, "H").equalsWithSuit(createCard(8, "C")))
    assert(!createCard(9, "H").equalsWithSuit(createCard(8, "H")))
    assert(createCard("T", "H").equalsWithSuit(createCard("T", "H")))
    assert(createCard("J", "S").equalsWithSuit(createCard("J", "S")))
    assert(createCard("Q", "H").equalsWithSuit(createCard("Q", "H")))
    assert(createCard("K", "H").equalsWithSuit(createCard("K", "H")))
    assert(createCard("A", "H").equalsWithSuit(createCard("A", "H")))
  }
}
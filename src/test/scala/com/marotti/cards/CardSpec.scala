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
    assert("2 Clubs" == createCard(2, "C").toString)
    assert("10 Spades" == createCard("T", "S").toString)
    assert("5 Diamonds" == createCard(5, "D").toString)
    assert("Ace Hearts" == createCard("A", "H").toString)
    assert("Jack Hearts" == createCard("J", "H").toString)
    assert("Queen Hearts" == createCard("Q", "H").toString)
    assert("King Hearts" == createCard("K", "H").toString)
  }

  it should "handle greaterThan correctly" in {
    assert(createCard(3, "H").isGreaterThan(createCard(2, "H")))
    assert(createCard(4, "H").isGreaterThan(createCard(3, "H")))
    assert(createCard(5, "H").isGreaterThan(createCard(4, "H")))
    assert(createCard(6, "H").isGreaterThan(createCard(5, "H")))
    assert(createCard(7, "H").isGreaterThan(createCard(6, "H")))
    assert(createCard(8, "H").isGreaterThan(createCard(7, "H")))
    assert(createCard(9, "H").isGreaterThan(createCard(8, "H")))
    assert(createCard("T", "H").isGreaterThan(createCard(9, "H")))
    assert(createCard("J", "H").isGreaterThan(createCard("T", "H")))
    assert(createCard("Q", "H").isGreaterThan(createCard("J", "H")))
    assert(createCard("K", "H").isGreaterThan(createCard("Q", "H")))
    assert(createCard("A", "H").isGreaterThan(createCard("K", "H")))
    assert(createCard("A", "H").isGreaterThan(createCard(2, "H")))

    assert(!createCard(2, "H").isGreaterThan(createCard(2, "H")))
    assert(!createCard(3, "H").isGreaterThan(createCard(3, "H")))
    assert(!createCard(4, "H").isGreaterThan(createCard(4, "H")))
    assert(!createCard(5, "H").isGreaterThan(createCard(5, "H")))
    assert(!createCard(6, "H").isGreaterThan(createCard(6, "H")))
    assert(!createCard(7, "H").isGreaterThan(createCard(7, "H")))
    assert(!createCard(8, "H").isGreaterThan(createCard(8, "H")))
    assert(!createCard(9, "H").isGreaterThan(createCard(9, "H")))
    assert(!createCard("T", "H").isGreaterThan(createCard("T", "H")))
    assert(!createCard("J", "H").isGreaterThan(createCard("J", "H")))
    assert(!createCard("Q", "H").isGreaterThan(createCard("Q", "H")))
    assert(!createCard("K", "H").isGreaterThan(createCard("K", "H")))
    assert(!createCard("A", "H").isGreaterThan(createCard("A", "H")))

    assert(!createCard(2, "H").isGreaterThan(createCard(3, "H")))
    assert(!createCard(3, "H").isGreaterThan(createCard(4, "H")))
    assert(!createCard(4, "H").isGreaterThan(createCard(5, "H")))
    assert(!createCard(5, "H").isGreaterThan(createCard(6, "H")))
    assert(!createCard(6, "H").isGreaterThan(createCard(7, "H")))
    assert(!createCard(7, "H").isGreaterThan(createCard(8, "H")))
    assert(!createCard(8, "H").isGreaterThan(createCard(9, "H")))
    assert(!createCard(9, "H").isGreaterThan(createCard("T", "H")))
    assert(!createCard("T", "H").isGreaterThan(createCard("J", "H")))
    assert(!createCard("J", "H").isGreaterThan(createCard("Q", "H")))
    assert(!createCard("Q", "H").isGreaterThan(createCard("K", "H")))
    assert(!createCard("K", "H").isGreaterThan(createCard("A", "H")))
  }

  it should "handle isEqualTo correctly" in {
    assert(createCard(2, "H").isEqualTo(createCard(2, "H")))
    assert(createCard(3, "H").isEqualTo(createCard(3, "H")))
    assert(createCard(4, "H").isEqualTo(createCard(4, "H")))
    assert(createCard(5, "H").isEqualTo(createCard(5, "H")))
    assert(createCard(6, "H").isEqualTo(createCard(6, "H")))
    assert(createCard(7, "H").isEqualTo(createCard(7, "H")))
    assert(createCard(8, "H").isEqualTo(createCard(8, "H")))
    assert(createCard(9, "H").isEqualTo(createCard(9, "H")))
    assert(createCard("T", "H").isEqualTo(createCard("T", "H")))
    assert(createCard("J", "H").isEqualTo(createCard("J", "H")))
    assert(createCard("Q", "H").isEqualTo(createCard("Q", "H")))
    assert(createCard("K", "H").isEqualTo(createCard("K", "H")))
    assert(createCard("A", "H").isEqualTo(createCard("A", "H")))

    assert(!createCard(3, "H").isEqualTo(createCard(2, "H")))
    assert(!createCard(4, "H").isEqualTo(createCard(3, "H")))
    assert(!createCard(5, "H").isEqualTo(createCard(4, "H")))
    assert(!createCard(6, "H").isEqualTo(createCard(5, "H")))
    assert(!createCard(7, "H").isEqualTo(createCard(6, "H")))
    assert(!createCard(8, "H").isEqualTo(createCard(7, "H")))
    assert(!createCard(9, "H").isEqualTo(createCard(8, "H")))
    assert(!createCard("T", "H").isEqualTo(createCard(9, "H")))
    assert(!createCard("J", "H").isEqualTo(createCard("T", "H")))
    assert(!createCard("Q", "H").isEqualTo(createCard("J", "H")))
    assert(!createCard("K", "H").isEqualTo(createCard("Q", "H")))
    assert(!createCard("A", "H").isEqualTo(createCard("K", "H")))
    assert(!createCard("A", "H").isEqualTo(createCard(2, "H")))

    assert(!createCard(2, "H").isEqualTo(createCard(3, "H")))
    assert(!createCard(3, "H").isEqualTo(createCard(4, "H")))
    assert(!createCard(4, "H").isEqualTo(createCard(5, "H")))
    assert(!createCard(5, "H").isEqualTo(createCard(6, "H")))
    assert(!createCard(6, "H").isEqualTo(createCard(7, "H")))
    assert(!createCard(7, "H").isEqualTo(createCard(8, "H")))
    assert(!createCard(8, "H").isEqualTo(createCard(9, "H")))
    assert(!createCard(9, "H").isEqualTo(createCard("T", "H")))
    assert(!createCard("T", "H").isEqualTo(createCard("J", "H")))
    assert(!createCard("J", "H").isEqualTo(createCard("Q", "H")))
    assert(!createCard("Q", "H").isEqualTo(createCard("K", "H")))
    assert(!createCard("K", "H").isEqualTo(createCard("A", "H")))
  }
}

package com.marotti.cards

import org.scalatest.{FlatSpec, Matchers}
import com.marotti.cards.Card._
import com.marotti.cards.Hand._

class HandSpec extends FlatSpec with Matchers {
  "A Hand" should "contain a list of cards" in {
    def hand = new Hand(aceHighCardList)
    assert(hand.cards.length == aceHighCardList.length)
    for ( (listCard, handCard) <- (aceHighCardList zip hand.cards))
      yield assert(listCard.equalsWithSuit(handCard))
    def createdHand = createHand(aceHighCardList)
    assert(createdHand.cards.length == aceHighCardList.length)
    for ( (listCard, handCard) <- (aceHighCardList zip createdHand.cards))
      yield assert(listCard.equalsWithSuit(handCard))
  }

  it should "provide a string with the appropriate list of cards correctly" in {
    assert("AH JS 3C QH 7D" == new Hand(aceHighCardList).toString)
  }

  it should "correctly sort the list with the high card first" in {
    assert("AH QH JS 7D 3C" == new Hand(aceHighCardList).resolved.toString)
    assert("AH AS AC AD 3C" == new Hand(quadAcesCardList).resolved.toString)
  }

  it should "resolve the hand to the correct hand type" in {
    assert(HandType.HIGH_CARD == createHand(aceHighCardList).resolved)
    assert(HandType.PAIR == createHand(pairCardList).resolved)
    assert(HandType.TWO_PAIR == createHand(twoPairCardList).resolved)
    assert(HandType.TRIPS == createHand(tripsCardList).resolved)
    assert(HandType.STRAIGHT == createHand(straightCardList).resolved)
    assert(HandType.FLUSH == createHand(flushCardList).resolved)
    assert(HandType.FULL_HOUSE == createHand(fullHouseCardList).resolved)
    assert(HandType.QUADS == createHand(quadAcesCardList).resolved)
    assert(HandType.STRAIGHT_FLUSH == createHand(straightFlushCardList).resolved)
  }

  def aceHighCardList = List(createCard("A", "H"),
      createCard("J", "S"),
      createCard(3, "C"),
      createCard("Q", "H"),
      createCard(7, "D"))

  def pairCardList = List(createCard("A", "H"),
    createCard("J", "S"),
    createCard(7, "C"),
    createCard("Q", "H"),
    createCard(7, "D"))

  def twoPairCardList = List(createCard("A", "H"),
    createCard("A", "S"),
    createCard("Q", "D"),
    createCard("Q", "H"),
    createCard(7, "D"))

  def tripsCardList = List(createCard("A", "H"),
    createCard("A", "S"),
    createCard(3, "C"),
    createCard("A", "D"),
    createCard(7, "D"))

  def straightCardList = List(createCard("A", "H"),
    createCard("J", "S"),
    createCard("K", "C"),
    createCard("Q", "H"),
    createCard("T", "D"))

  def flushCardList = List(createCard("A", "H"),
    createCard("J", "H"),
    createCard(3, "H"),
    createCard("Q", "H"),
    createCard(7, "H"))

  def fullHouseCardList = List(createCard("A", "H"),
    createCard("A", "S"),
    createCard("A", "C"),
    createCard("Q", "H"),
    createCard("Q", "D"))

  def quadAcesCardList = { List(createCard("A", "H"),
      createCard("A", "S"),
      createCard(3, "C"),
      createCard("A", "C"),
      createCard("A", "D"))
  }

  def straightFlushCardList = List(createCard("A", "H"),
    createCard("J", "H"),
    createCard("K", "H"),
    createCard("Q", "H"),
    createCard("T", "H"))
}

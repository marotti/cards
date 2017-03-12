package com.marotti.cards

import scala.util.Random

class Deck(cardList: List[Card]) {
  def cards = cardList

  def shuffle(): Deck = {
    new Deck(Random.shuffle(cards))
  }
}


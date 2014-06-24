package com.example.proximosoft.card;

import java.util.ArrayList;
import java.util.Random;

import android.util.Log;

/**
 * This represents a standard deck of 52 playing cards
 * @author Eric G. Geil
 * @version 1.0
 */
public class Deck {
	ArrayList<Card> cards;
	
	public Deck() {
		cards = createDeck();
	}

	/**
	 * Creates new deck and then shuffles the cards in a random order.
	 * @return ArrayList<Card> ArrayList of the cards in a random order.
	 */
	public ArrayList<Card> shuffle() {
		ArrayList<Card> newDeck = createDeck();
		Random r = new Random();
		for (int i = newDeck.size()-1; i > 0; i-- ) {
			int index = r.nextInt(i+1);	// Allow card to be shuffle back to itself
			Card temp = newDeck.get(index);
			newDeck.set(index, newDeck.get(i));
			newDeck.set(i, temp);
		}
		return newDeck;
		/** Old Shuffle
		ArrayList<Card> unshuffle = createDeck();
		ArrayList<Card> shuffled = new ArrayList<Card>();
		while (!unshuffle.isEmpty()) {
			int cardSlot = (int) (Math.random()*unshuffle.size());
			shuffled.add(unshuffle.get(cardSlot));
			unshuffle.remove(cardSlot);
		}
		cards = shuffled;
		return shuffled;
		*/
	}
	
	/**
	 * Creates the Deck with all the cards in order.
	 * @return ArrayList<Card> ArrayList containing all the cards in order.
	 */
	private ArrayList<Card> createDeck() {
		cards = new ArrayList<Card>();
		for (Card.SUITS suit : Card.SUITS.values()) {
			for (Card.RANKS rank : Card.RANKS.values()) {
				cards.add(new Card(suit, rank));
			}
		}
		return cards;
	}
	
	/**
	 * Is there a card available to be drawn??
	 * @return boolean indicating there is a card available to be drawn
	 */
	public boolean haveCardAvailable() {
		boolean returnValue = true;
		if (cards.isEmpty()) {
			returnValue = false;
		}
		return returnValue;
	}
	
	/**
	 * If there is a card still in the deck return it else return null
	 * @return Card representing the card drawn. 
	 */
	public Card drawCard() {
		Card drawn = null;
		if (!cards.isEmpty()) {
			drawn = cards.get(0);
			cards.remove(0);
		} else {
			Log.e("CARDS", "Tried to drawn from empty deck");
		}
		return drawn;
	}
}

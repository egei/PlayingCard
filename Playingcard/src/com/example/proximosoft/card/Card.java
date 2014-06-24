package com.example.proximosoft.card;

import android.graphics.drawable.Drawable;
import android.util.Log;

/**
 * This represents a single playing card with an optional Image (Drawable)
 * @author Eric G. Geil
 * @version 1.0
 */
public class Card {
	private SUITS suit;
	private RANKS rank;
	private Drawable cardImage;
	
	public enum SUITS {CLUBS, DIAMONDS, HEARTS, SPADES};
	public enum RANKS {DUECE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE};
	
	/**
	 * Default constructor made private so you have to use correct version
	 */
	@SuppressWarnings("unused")
	private Card() {
	}
	
	/**
	 * Proper constructor to use. Take suit and rank in suit.  
	 * @param inSuit The suit of the Card
	 * @param inRank The rank of the Card
	 */
	public Card(SUITS inSuit, RANKS inRank) {
		suit = inSuit;
		rank = inRank;
		cardImage = null;
	}
	
	/**
	 * Proper constructor to use. Take suit and rank in suit.  
	 * @param inSuit The suit of the Card
	 * @param inRank The rank of the Card
	 * @param inImage The face image of the Card
	 */
	public Card(SUITS inSuit, RANKS inRank, Drawable inImage) {
		suit = inSuit;
		rank = inRank;
		cardImage = inImage;
	}
	
	/**
	 * The copy Constructor
	 * @param inCard The Card to be copy.
	 */
	public Card(Card inCard) {
		suit = inCard.getSuit();
		rank = inCard.getRank();
		cardImage = inCard.getImage();
	}

	/**
	 * Gets the rank of the suit
	 * @return The cards rank
	 */
	public RANKS getRank() {
		return rank;
	}

	/**
	 * Gets the Card suit
	 * @return Card.SUITS The suit of the Card
	 */
	public SUITS getSuit() {
		return suit;
	}

	/**
	 * Gets a string representing the Card
	 * @return String A string stating what Card it was.
	 */
	public String toString() {
		String result = "";
		switch (rank) {
			case DUECE:
				result = "Duece of ";
				break;
			case THREE:
				result = "Three of ";
				break;
			case FOUR:
				result = "Four of ";
				break;
			case FIVE:
				result = "Five of ";
				break;
			case SIX:
				result = "Six of ";
				break;
			case SEVEN:
				result = "Seven of ";
				break;
			case EIGHT:
				result = "Eight of ";
				break;
			case NINE:
				result = "Nine of ";
				break;
			case TEN:
				result = "Ten of ";
				break;
			case JACK:
				result = "Jack of ";
				break;
			case QUEEN:
				result = "Queen of ";
				break;
			case KING:
				result = "King of ";
				break;
			case ACE:
				result = "Ace of ";
				break;
			default:
				// Should never reach here since every Card must have rank
				Log.e("CARD", "Invalid Card rank encountered");
		}
		switch (suit) {
			case CLUBS:
				result = result.concat("clubs");
				break;
			case DIAMONDS:
				result = result.concat("diamonds");
				break;
			case HEARTS:
				result = result.concat("hearts");
				break;
			case SPADES:
				result = result.concat("spades");
				break;
			default:
				// Should never reach here since every Card must have suit
				Log.e("CARD", "Invalid Card suit encountered");
		}
		return result;
	}
	
	/**
	 * Sets the Image of the Card face.
	 * @param Drawable inImage
	 */
	public void setImage(Drawable inImage) {
		cardImage = inImage;
	}
	
	/**
	 * Gets the face (front) image of the Card
	 * @return Drawable representing the image of the Card
	 */
	public Drawable getImage() {
		return cardImage;
	}
}

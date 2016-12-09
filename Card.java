public class Card {

 private static String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "X", "J", "Q", "K", "A"};
 private static String[] suits = {"s", "h", "d", "c"};
 private static int[] pointValues = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};
 
 private int rank;
 private int suit;
 private int pointVal;
 
 /**
  * Default constructor for Card.
  * Defaults to an Ace of Spades of value 1.
  */
 public Card() {
  this.rank = 0;
  this.suit = 0;
  this.pointVal = 1;
 }
 
 /**
  * Constructor for Card
  * @param newRank: Given suit to initialize to
  * @param newSuit: Given rank to initialize to
  */
 public Card(int newRank, int newSuit) {
  this.rank = newRank;
  this.suit = newSuit;
  this.pointVal = pointValues[newRank%14];
 }
 
 /**
  * Getter method for rank
  * @return Rank of the card
  */
 public String getRank() {
  return ranks[rank];
 }
 
 /**
  * Getter method for suit
  * @return suit of card
  */
 public String getSuit() {
  return suits[suit];
 }
 
 /**
  * Getter method for pointVal
  * @return point value of a Card
  */
 public int getValue() {
  return pointVal;
 }
 
 /**
  * Overloaded toString method, prints the rank, suit, and point value of a card.
  */
 public String toString() {
  return this.getRank() +  " of " + this.getSuit() + " (" + this.getValue() + ")";
 }
 
 /**
  * Returns a Card object that would sequentially follow the current card.
  * Increases rank by one. If the card is a King, make the card an ace of the next rank.
  * If the card is the King of Clubs (the last card) the card after is the first card, the Ace of Spades.
  * 
  * @return A Card object with a higher rank, or suit if needed.
  */
 public Card nextCard() {
  int nextRank = this.rank + 1;
  int nextSuit = this.suit;
  
  if (nextRank > 12) {
   nextRank = 0;
   nextSuit = this.suit + 1;
   
   if (nextSuit > 3) {
    nextSuit = 0;
   }
  }
  
  return new Card(nextRank, nextSuit);
 }
 
 /**
  * Returns a copy of a given card
  * @param curCard : a card object
  * @return A card object identical to curCard
  */
 public Card copyOf(Card curCard) {
  return this;
 }
}
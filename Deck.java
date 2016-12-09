import java.util.ArrayList;
import java.util.List;

public class Deck {

 public List<Card> cards;
 private List<Card> discard;

 public Deck() {
  instantiateDeck();
 }
  
 public void Deal(){
   // int size = numOfPlayers();
  // for(int i = 0; i< size;i++);{
   //giveCard(deck.get(0));
   //deck.remove(0)
   //}
 }
 
 private void instantiateDeck() {
  this.cards = new ArrayList<Card>();
  Card curCard = new Card();
  cards.add(curCard);
  
  for (int i = 0; i < 52; i++) {
   curCard = curCard.nextCard();
   cards.add(curCard);
  }
 }
 
 /**
  * Moves the top card of the deck into the discard pile.
  */
 public void discardCard() {
  this.discard.add(this.cards.get(0));
  this.cards.remove(0);
 }
 
 /**
  * Shuffles all cards not in the discard pile.
  */
 /* public void shuffle() {
  Collections.shuffle(this.cards, new Random());
 }
 
 /**
  * Puts all cards in the discard pile back into the deck, then shuffles the deck.
  */
 public void restart() {
  this.cards.addAll(this.discard);
  this.discard.clear();
  //shuffle();
 }
}

package blackjackGroup;

import java.util.ArrayList;

public class Hand { //constructor
	
	ArrayList<Card> hand = new ArrayList<Card>(); //compilation from 
	int totalPV = 0;
	
	public Hand() {
		for(int x = 0;x < hand.size(); x++)
			totalPV += (hand.get(x).getValue());
	}	
	
	public ArrayList<Card> display(){ //displays hand 
		return hand;
	}
	
	public static int getTotalPoints(ArrayList<Card> hand) {
		int curValue = 0;
		
		for (int i = 0; i < hand.size(); i++) {
			curValue += hand.get(i).getValue();
		}
		
		return curValue;
	}
	public void addCard(ArrayList<Card> playingDeck){
		
			this.hand.add(playingDeck.get(0));
			playingDeck.remove(0);
		
	}
	
	@SuppressWarnings("unused")
	public static void printHand(ArrayList<Card> hand) {
		  	
		  	//First row
		  	for (Card curCard : hand) {System.out.print("┌───┐ ");}
		  	System.out.println();
		  	
		  	//Second row
		  	for (Card curCard : hand) {System.out.print("|" + curCard.getRank() + "  | ");}
		  	System.out.println();
		  	
		  	//Third row
		  	for (Card curCard : hand) {System.out.print("| " + Card.getASCIISuit(curCard.getSuit()) + " | ");}
		  	System.out.println();
		  	
		  	//Fourth row
		  	for (Card curCard : hand) {System.out.print("|  " + curCard.getRank() + "| ");}
		  	System.out.println();
		  	
		  	//Fifth row
		  	for (Card curCard : hand) {System.out.print("└───┘ ");}
		  	System.out.println();
	}
}

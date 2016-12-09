package blackjackGroup;

import java.util.ArrayList;

public class Hand { //constructor
	
	ArrayList<Card> hand = new ArrayList<Card>(); //compilation from 
	int totalPV = 0;
	
	Hand() 
	{
		for(int x=0;x<hand.size();x++)
			totalPV+=(hand.get(x).getValue());
	}	
	
	public ArrayList<Card> display() //displays hand
	{ 	
		return hand;
	}
	
	public int getTotalPoints()
	{
		return totalPV;
	}
}

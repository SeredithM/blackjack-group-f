package blackjackGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

	private List<Player> gamePlayers;
	private Dealer gameDealer;
	private Deck gameDeck;
	private int bettingPool = 0;
	
	public void startGame() {
		
		boolean gameGoing = true;
		int numPlayers;
		String playerName;
		Scanner playerScan = new Scanner(System.in);
		
		System.out.println("How many players?");
		numPlayers = playerScan.nextInt();
		gamePlayers = new ArrayList<Player>();
		
		for (int i = 0; i < numPlayers; i++) {
			System.out.println("Enter name for player " + (i+1) + ":");
			playerName = playerScan.next();
			Player curPlayer = new Player(playerName);
			gamePlayers.add(curPlayer);
			int bet = 0;
			System.out.println("How much will they bet?");
			bet = playerScan.nextInt();
			gamePlayers.get(i).setBet(bet);
			bettingPool += bet;
		}
		
		gameDealer = new Dealer();
		gameDeck = new Deck();
		gameDeck.shuffle();
		
		while(gameGoing) {
			
			
			
			for(int n = 0; n < 2; n++) {
				for (int i = 0; i < gamePlayers.size(); i++) {
					deal(i);
				}
				gameDeck.giveCard(gameDealer);
			}
			
			for (int i = 0; i < gamePlayers.size(); i++) {
				String isHitting = "";
				boolean turnGoing = true;
				
				while (turnGoing) {
					if(checkVal(i) < 0) {
						System.out.println("Player " + gamePlayers.get(i).getName() + " has gone bust!");
						gamePlayers.get(i).printHand();
						gamePlayers.remove(i);
						i--;
						turnGoing = false;
						break;
					}
					System.out.println("Points away from 21: " + checkVal(i));
					System.out.println("Does " + gamePlayers.get(i).getName() + " want to hit? (y/n)");
					gamePlayers.get(i).printHand();
					isHitting = playerScan.next();
					isHitting.toLowerCase();
					//If hit yes, draw a card. If no, end turn. If invalid input, keep going.
					switch(isHitting) {
					case "y": deal(i);
						break;
					case "n": turnGoing = false;
						break;
					default: System.out.println("Invalid input.");
						break;
					}
					
					if(checkVal(i) < 0) {
						System.out.println("Player " + gamePlayers.get(i).getName() + " has gone bust!");
						gamePlayers.get(i).printHand();
						gamePlayers.remove(i);
						i--;
						turnGoing = false;
					}
					else if(checkVal(i) == 0) {
						System.out.println("Player " + gamePlayers.get(i).getName() + " wins!");
						winnings();
						turnGoing = false;
						break;
					}
				}
				
			}
			
			
			int winner = -1;
			int closest = 21;
			
			for (int i = 0; i < gamePlayers.size(); i++) {
				int checkPoints = checkVal(i);
				
				if (checkPoints < closest) {
					winner = i;
					closest = checkPoints;
				}
				
				if(checkPoints == 0) {
					System.out.println("Player " + gamePlayers.get(i).getName() + " wins!");
					winnings();
					winner = i;
					closest = 0;
				}
			}
			
			if (closest != 0) {
				System.out.println("Player " + gamePlayers.get(winner).getName() + " wins!");
				winnings();
			}
			
			if (winner > -1) {
				System.out.println("Winning hand:");
				gamePlayers.get(winner).printHand();
				gameGoing = false;
			}
			
			if(gamePlayers.size() == 0) {
				System.out.println("Dealer wins!");
				winnings();
				gameGoing = false;
			}
			
			
		}
		playerScan.close();
	}
	
	public void deal(int playerNum) {
		gameDeck.giveCard(gamePlayers.get(playerNum));
	}
	
	/**
	 * Returns the difference between 21 and the player's points.
	 * @param playerNum
	 */
	public int checkVal(int playerNum) {
		int curVal = Hand.getTotalPoints(gamePlayers.get(playerNum).hand);
		
		return 21 - curVal;
	}
	
	public void winnings() {
		System.out.println("The winner wins " + bettingPool + " in chips!");
	}
}

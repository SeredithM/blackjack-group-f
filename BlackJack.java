import java.util.Scanner;
import java.util.*;
public class BlackJack{
  
public static void main(String args[]){
  Scanner keyboard = new Scanner (System.in);
  String input;
  int num =1;
  ArrayList<String> players = new ArrayList<String>();

  int numOfPlayers;
  
  System.out.println("Welcome to BlackJack");
  
  System.out.println("How many players are there?");
   input = keyboard.nextLine();
   numOfPlayers = Integer.parseInt(input);
   while(num-1 < numOfPlayers){
     System.out.println("What is the name of Player " + num);
     players.add(keyboard.nextLine());
     num++;
   }
   //Construct the deck
   //Deck.instantiateDeck();
   //Deal two cards to everyone by adding them to hand
   //deal();
   num =0;
   while(num-1 < numOfPlayers){
    // Player.askToHit(deck(),players.get(num));
     
   }

}
}
package blackjackGroup;

import java.util.*;

public class Player{
  Scanner keyboard = new Scanner (System.in);
  String inpUser;
  private int inpInt;
  private int num = 0;
  public int points;
  public int balance = 0;
  private String name;
  ArrayList<Card> hand;
  
  public Player(){
    balance = 25000;
    hand = new ArrayList<Card>();
  }
  
  public Player(String name) {
	  this.name = name;
	  this.balance = 2500;
	  hand = new ArrayList<Card>();
  }
  
  public Player(String n, int b){
    name = n;
    balance =b;
    hand = new ArrayList<Card>();
  }
  
  public void bet(){
    num = 0;
    System.out.println("How much do you want to bet?(Only Integers)");
    inpInt = Integer.parseInt(keyboard.nextLine());
    
    while(num == 0)
      if(inpInt > balance){
      System.out.println("You don't have the chips to make this bet.");
    }else if(inpInt <= balance){
      System.out.println("You bet "+ inpInt);
      balance-= inpInt;
    }else{
      System.out.println("How much do you want to bet?(Only Integers)");
    }
  }
  
  public void askToHit(ArrayList<Card> st){
    num = 0;
    System.out.println("Do you want to hit? (Y or N)");
    inpUser = keyboard.nextLine();
    while(num == 0){
    if(inpUser == "Y"){
        this.hand.add(st.get(0));
        st.remove(0);
         System.out.println("");
    }else if(inpUser == "N"){
      System.out.println("You Stand.");
      num++;
    }else{
      System.out.println("Do you want to hit? (Y or N)");
    }
  }
  
  }
  
  /**
   * Adds a card to the Player's hand
   * @param card is the Card object to add to the player hand.
   */
  public void addCard(Card card){
   this.hand.add(card);
   points += card.getValue();
  }
  
  /**
   * Returns the name of the Player.
   * @return a String that is the name of the player
   */
  public String getName() {
	  return this.name;
  }
  
  public void printHand() {
	  Hand.printHand(this.hand);
  }
  
}

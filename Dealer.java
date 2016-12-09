import java.util.*;

public class Dealer extends Player{  
  
   ArrayList<Card> dealerHand;
   private int handVal;
   
   public Dealer(){}
   
   public void checkToHit(ArrayList<Card> deck){
     
     for(int i = 0; i < dealerHand.size(); i++){
       handVal += dealerHand.get(i).getValue();
     }
     if(handVal < 17 ){
       dealerHand.add(deck.get(0));
       System.out.println("Dealer hand is ");
       System.out.println(dealerHand);
       deck.remove(0);
     }else{
       System.out.println("Dealer Stands.");
     }
   }
}
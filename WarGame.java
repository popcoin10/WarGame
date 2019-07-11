package wargame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
public class WarGame
{
   public static void main (String[] args)
   {
      System.out.println(" Let the War begin!!! ");
      List<Card> cardDeck = new ArrayList<>();
//
      for (int x = 0; x < 4; x++) {          //for loop using the 4 suits
         for (int y = 2; y < 15; y++) {     // for loop for 13 for cards 2-10 and faced cards
            cardDeck.add(new Card(x, y)); //create new card then use add method to combine to array list
         } //end cards for loop
      }//end suit for

      Collections.shuffle(cardDeck, new Random()); //deck shuffler

      //using our newly learnt knowledge on Linked lists to create 2 - one for each player. player 1/player2
      LinkedList<Card> deck1 = new LinkedList<>();
      LinkedList<Card> deck2 = new LinkedList<>();
      //found interesting Java operation called List which can be broken down into sublists to store information. Just add the total # of cards needed in each sublist
      deck1.addAll(cardDeck.subList(0, 25));              //26 cards for p1       
      deck2.addAll(cardDeck.subList(26, cardDeck.size()));//26 cards for p2

      //while list to determine winner of each draw. let the games begin!!!!

      while (true) {
         //use pop to remove card from top of Linked List- thank god for Rich teaching us all this lol
         Card p1Card = deck1.pop();  //each player place one card face up
         Card p2Card = deck2.pop();

         //display the face up card
         System.out.println("Player 1 plays: " + p1Card.toString());
         System.out.println("Player 2 plays: " + p2Card.toString());

         //rank comparation between two cards
         if (p1Card.getCard() > p2Card.getCard()) {//if player 1 win 
            deck1.addLast(p1Card);  //higher rank wins both cards and 
            deck1.addLast(p2Card);  //places them at the bottom of his deck.
            System.out.println("Player 1 wins the round and Player 2's cards: " + p1Card.getCard());
         }//end if

         else if (p1Card.getCard() < p2Card.getCard()) {//if player 2 win 
            deck2.addLast(p1Card);
            deck2.addLast(p2Card);
            System.out.println("Player 2 wins the round and Player 1's card : " + p1Card.getCard());
         }//end else if

         else { //war happens while both players draw the same car
            System.out.println(" War!! Each player places 3 cards face down and flips the 4th! Winner take all!");

            //creating new temp array for tie
            List<Card> war1 = new ArrayList<>();
            List<Card> war2 = new ArrayList<>();

            //checking do players have enough (4)cards to play war / if not game is over
            for (int x = 0; x < 3; x++) {
               //either one player runs out of card is game over
               if (deck1.isEmpty() || deck2.isEmpty()) {
                  break;
               }//end if

               System.out.println("War card for player1 is xx\nWar card for player2 is xx");

               war1.add(deck1.pop());  //place additional card for war
               war2.add(deck2.pop());
            }//end for

            //only compare result when both players have enough cards for war
            if (war1.size() == 3 && war2.size() == 3) {
               //display the war cards from each player
               System.out.println("War card for player1 is " + war1.get(0).toString());
               System.out.println("War card for player2 is " + war2.get(0).toString());

               //if player 1 wins the war round
               if (war1.get(2).getCard() > war2.get(2).getCard()) {
                  deck1.addAll(war1); //player1 get all 10 cards
                  deck1.addAll(war2);
                  System.out.println("Player 1 wins the battle! But as they say, winning the battle does not garuntee winning the War!");
               }//end if
               //otherwise player 2 wins the war round
               else {
                  deck2.addAll(war1); //player2 get all 10 cards
                  deck2.addAll(war2);
                  System.out.println("Player 2  wins the battle! But as they say, winning the battle does not garuntee winning the War!");
               }//end else                      
            }//end if

         }//end war round else

         //game over either one player runs out of card(deck size is 0)
         if (deck1.isEmpty()) {
            System.out.println(" Game over!!! \n Player 1 has won the War! Player 2 is defeated. ");
            break;
         }
         else if (deck2.isEmpty()) {
            System.out.println("Game over!!! \n Player 2 has won the War! Player 1 is defeated.");
            break;
         }
      }//end while  


   }
}

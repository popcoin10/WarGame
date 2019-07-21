package wargame;
/**
 * @author Portia Ocran
 */

/**
 * @author Rich Smith at ZenOfProgramming.com
 */
import java.util.ArrayList;
import java.util.List;

public class War extends Game
{
   public War (ArrayList<Player> players)
   {
      super(players);

   }
   //test

   public void play ()
   {
      while (true) {
         if (this.getPlayers().get(0).getDeck().isEmpty()) {
            System.out.println(" Player 2 wins! ");
            break;
         }
         else if (this.getPlayers().get(1).getDeck().isEmpty()) {
            System.out.println(" Player 1 wins! ");
            break;
         }

         Card p1Card = this.getPlayers().get(0).getDeck().pop();  //each player place one card face up
         Card p2Card = this.getPlayers().get(1).getDeck().pop();

         //display the face up card
         System.out.println("Player 1 plays: " + p1Card.toString());
         System.out.println("Player 2 plays: " + p2Card.toString());

         //rank comparation between two cards
         if (p1Card.getCard() > p2Card.getCard()) {//if player 1 win 
            this.getPlayers().get(0).getDeck().add(p2Card);  //higher rank wins both cards and 
            this.getPlayers().get(0).getDeck().add(p1Card);  //places them at the bottom of his deck.
            System.out.println("Player 1 wins the round and Player 2's cards: " + p2Card.toString());
            System.out.println();
         }//end if

         else if (p1Card.getCard() < p2Card.getCard()) {//if player 2 win 
            this.getPlayers().get(1).getDeck().add(p2Card);
            this.getPlayers().get(1).getDeck().add(p1Card);
            System.out.println("Player 2 wins the round and Player 1's card : " + p1Card.toString());
            System.out.println();
         }//end else if
         // test

         else { //war happens while both players draw the same car
            System.out.println("War!! Each player places 3 cards face down and flips the 4th! Winner take all!\n");


            //creating new temp array for tie
            List<Card> war1 = new ArrayList<>();
            List<Card> war2 = new ArrayList<>();

            //checking do players have enough (4)cards to play war / if not game is over
            for (int x = 0; x < 4; x++) {
               //either one player runs out of card is game over
               if (this.getPlayers().get(0).getDeck().isEmpty() || getPlayers().get(1).getDeck().isEmpty()) {
                  break;
               }//end if

               System.out.println("War card for Player 1 is xx\nWar card for Player 2 is xx\n");

               war1.add(this.getPlayers().get(0).getDeck().pop());  //place additional card for war
               war2.add(this.getPlayers().get(1).getDeck().pop());
            }//end for

            //only compare result when both players have enough cards for war
            if (war1.size() == 4 && war2.size() == 4) {
               //display the war cards from each player
               System.out.println("War card for Player 1 is " + war1.get(3).toString());
               System.out.println("War card for Player 2 is " + war2.get(3).toString());
               System.out.println();

               //if player 1 wins the war round
               if (war1.get(3).getCard() > war2.get(3).getCard()) {
                  this.getPlayers().get(0).getDeck().addAll(war1); //player1 get all 10 cards
                  this.getPlayers().get(0).getDeck().addAll(war2);
                  System.out.println("Player 1 wins the battle! But as they say, winning the battle does not guarantee winning the War!\n");
               }//end if
               //otherwise player 2 wins the war round
               else {
                  getPlayers().get(1).getDeck().addAll(war1); //player2 get all 10 cards
                  getPlayers().get(1).getDeck().addAll(war2);
                  System.out.println("Player 2 wins the battle! But as they say, winning the battle does not guarantee winning the War!\n");
               }//end else                      
            }//end if

         }//end war round else
      }

   }

}

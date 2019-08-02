package finalwar;

/**
 * @author Rich Smith at ZenOfProgramming.com
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class War extends Game {
   public War (ArrayList<Player> players) {
      super(players);
   }


   public void play (ImageView a, ImageView b, Label label1, Label label2) throws InterruptedException {

      if (this.getPlayers().get(0).getDeck().isEmpty()) {
         System.out.println(" Player 2 wins! ");
         label2.setText(" Player 2 wins! ");
         return;
      }
      else if (this.getPlayers().get(1).getDeck().isEmpty()) {
         System.out.println(" Player 1 wins! ");
         label2.setText(" Player 1 wins! ");
         return;
      }

      Card p1Card = this.getPlayers().get(0).getDeck().pop();  //each player place one card face up
      Card p2Card = this.getPlayers().get(1).getDeck().pop();
//       ImageView im1 = new ImageView();

      a.setImage(new Image(getClass().getResource(p1Card.getImageURL()).toExternalForm()));
      a.setFitWidth(250);
      a.setPreserveRatio(true);
      b.setImage(new Image(getClass().getResource(p2Card.getImageURL()).toExternalForm()));
      b.setFitWidth(250);
      b.setPreserveRatio(true);
      //display the face up card
      System.out.println("Player 1 plays: " + p1Card.toString());
      System.out.println("Player 2 plays: " + p2Card.toString());

      //rank comparation between two cards
      if (p1Card.getCard() > p2Card.getCard()) {//if player 1 win 
         this.getPlayers().get(0).getDeck().add(p2Card);  //higher rank wins both cards and 
         this.getPlayers().get(0).getDeck().add(p1Card);  //places them at the bottom of his deck.
         System.out.println("Player 1 wins the round and Player 2's cards: " + p2Card.toString());
         System.out.println();
         label1.setText("Player 1 wins the round and Player 2's cards: " + p2Card.toString());
      }//end if

      else if (p1Card.getCard() < p2Card.getCard()) {//if player 2 win 
         this.getPlayers().get(1).getDeck().add(p2Card);
         this.getPlayers().get(1).getDeck().add(p1Card);
         System.out.println("Player 2 wins the round and Player 1's card : " + p1Card.toString());
         System.out.println();
         label1.setText("Player 1 wins the round and Player 2's cards: " + p2Card.toString());
      }//end else if
      // test

      else { //war happens while both players draw the same car
         System.out.println("War!! Each player places 3 cards face down and flips the 4th! Winner take all!\n");
         label1.setText("War!! Each player places 3 cards face down and flips the 4th! Winner take all!\n");

         //creating new temp array for tie
         List<Card> war1 = new ArrayList<>();
         List<Card> war2 = new ArrayList<>();

         //checking do players have enough (4)cards to play war / if not game is over
         for (int x = 0; x < 4; x++) {
            //either one player runs out of card is game over
            if (this.getPlayers().get(0).getDeck().isEmpty() || getPlayers().get(1).getDeck().isEmpty()) {
               break;
            }//end if

            label1.setText("War card for Player 1 is xx\nWar card for Player 2 is xx\n");

            war1.add(this.getPlayers().get(0).getDeck().pop());  //place additional card for war
            war2.add(this.getPlayers().get(1).getDeck().pop());
         }//end for

         //only compare result when both players have enough cards for war
         if (war1.size() == 4 && war2.size() == 4) {

            //display the war cards from each player
            label1.setText("War card for Player 1 is " + war1.get(3).toString() + "War card for Player 2 is " + war2.get(3).toString());

            //if player 1 wins the war round
            if (war1.get(3).getCard() > war2.get(3).getCard()) {
               TimeUnit.SECONDS.sleep(0x2);
               this.getPlayers().get(0).getDeck().addAll(war1); //player1 get all 10 cards
               a.setImage(new Image(getClass().getResource(war1.get(3).getImageURL()).toExternalForm()));
               a.setFitWidth(250);
               a.setPreserveRatio(true);
               this.getPlayers().get(0).getDeck().addAll(war2);
               b.setImage(new Image(getClass().getResource(war2.get(3).getImageURL()).toExternalForm()));
               b.setFitWidth(250);
               b.setPreserveRatio(true);
               label2.setText("Player 1 wins the battle! But as they say, winning the battle does not guarantee winning the War!\n");
            }//end if
            //otherwise player 2 wins the war round
            else {
               TimeUnit.SECONDS.sleep(0x2);
               getPlayers().get(1).getDeck().addAll(war1); //player2 get all 10 cards
               this.getPlayers().get(0).getDeck().addAll(war1); //player1 get all 10 cards
               a.setImage(new Image(getClass().getResource(war1.get(3).getImageURL()).toExternalForm()));
               a.setFitWidth(250);
               a.setPreserveRatio(true);
               this.getPlayers().get(0).getDeck().addAll(war2);
               b.setImage(new Image(getClass().getResource(war2.get(3).getImageURL()).toExternalForm()));
               b.setFitWidth(250);
               b.setPreserveRatio(true);
               getPlayers().get(1).getDeck().addAll(war2);
               label2.setText("Player 2 wins the battle! But as they say, winning the battle does not guarantee winning the War!\n");
            }//end else                      
         }//end if
      }//end war round else
   }
}

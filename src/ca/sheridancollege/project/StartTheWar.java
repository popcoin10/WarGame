package ca.sheridancollege.project;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
/**
 * @author Rich Smith at ZenOfProgramming.com
 */
public class StartTheWar
{
   public static void main (String[] args)
   {
      System.out.println("Let the War begin!!!\n\nWe will now deal the cards. Best of luck to both players\n ");
      List<Card> cardDeck = new ArrayList<>();

      for (int x = 0; x < 4; x++) {          //for loop using the 4 suits
         for (int y = 2; y < 15; y++) {     // for loop for 13 for cards 2-10 and faced cards1
            cardDeck.add(new Card(x, y)); //create new card then use add method to combine to array list
         } //end cards for loop
      }//end suit for

      Collections.shuffle(cardDeck, new Random()); //deck shuffler

      //using our newly learnt knowledge on Linked lists to create 2 - one for each player. player 1/player2
      LinkedList<Card> deck1 = new LinkedList<>();
      LinkedList<Card> deck2 = new LinkedList<>();


      //found interesting Java operation called List which can be broken down into sublists to store information. Just add the total # of cards needed in each sublist
      deck1.addAll(cardDeck.subList(0, 25));              //26 cards for p1       
///test 5
      deck2.addAll(cardDeck.subList(26, cardDeck.size()));//26 cards for p2

      //Array for player objects to be held
      ArrayList<Player> p3 = new ArrayList<>();
      Player p1 = new Player(deck1);
      Player p2 = new Player(deck2);
      p3.add(p1);
      p3.add(p2);

      War game = new War(p3);
      game.play();

   }
}

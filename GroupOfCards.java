/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package wargame;

import java.util.ArrayList;
import java.util.Collections;
//
/**
 * A concrete class that represents any grouping of cards for a Game.
 * HINT, you might want to subclass this more than once.
 * The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 */
public class GroupOfCards
{

   //The group of cards, stored in an ArrayList
   private ArrayList<Card> cards;
   private int size;//the size of the grouping

   public GroupOfCards (int givenSize)
   {
      size = givenSize;
   }

   public ArrayList<Card> showCards ()
   {
      return cards;
   }

   public void shuffle ()
   {
      Collections.shuffle(cards);
   }

   public int getSize ()
   {
      return size;
   }

   public void setSize (int givenSize)
   {
      size = givenSize;
   }
}//end class

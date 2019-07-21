package wargame;

/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date! * */

import java.util.LinkedList;

public class Player
{

   private LinkedList<Card> deck;

   public Player ()
   {
      this.deck = new LinkedList<>();
   }
   //testt

   public LinkedList<Card> getDeck ()
   {
      return this.deck;
   }
}

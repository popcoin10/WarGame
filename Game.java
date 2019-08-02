package finalwar;
/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
import java.util.ArrayList;

public abstract class Game {
   private ArrayList<Player> players;// the players of the game
//test//

   public Game (ArrayList<Player> players) {
      this.players = players;
   }

   public ArrayList<Player> getPlayers () {
      return players;
   }

   public void setPlayers (ArrayList<Player> players) {
      this.players = players;
   }
}//end class

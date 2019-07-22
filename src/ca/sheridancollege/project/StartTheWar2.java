/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
/**
 *
 * @author m
 */
public class StartTheWar2 extends Application
{

   @Override
   public void start (Stage primaryStage)
   {
      HBox hBox = new HBox(5);
      hBox.setPadding(new Insets(5, 5, 5, 5));
      hBox.setStyle("-fx-background-color: blue");
      ImageView im1 = new ImageView("https://www.mymagic.ch/wp-content/uploads/2017/01/Phoenix-Deck-back-2.png");
      ImageView im2 = new ImageView("https://cdn2.bigcommerce.com/n-d57o0b/1kujmu/products/297/images/929/7C__93490.1440113539.480.480.png?c=2");
      ImageView im3 = new ImageView("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d5/Playing_card_heart_2.svg/300px-Playing_card_heart_2.svg.png");
      ImageView im4 = new ImageView("https://www.mymagic.ch/wp-content/uploads/2017/01/Phoenix-Deck-back-2.png");
      ImageView im5 = new ImageView("https://media.istockphoto.com/photos/three-of-hearts-picture-id624180018?k=6&m=624180018&s=612x612&w=0&h=-RqQPFrrvRmZks5Lbnh4dQUR2dts__KVQx84hj6A34I=");
//      hBox.getChildren().add;
      hBox.getChildren().add(im1);
      hBox.getChildren().add(im2);
      hBox.getChildren().add(im3);
      hBox.getChildren().add(im4);
////      hBox.getChildren().add(im5);
//      hBox.getChildren().add(new ImageView("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d5/Playing_card_heart_2.svg/300px-Playing_card_heart_2.svg.png"));
//      hBox.getChildren().add(new ImageView("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d5/Playing_card_heart_2.svg/300px-Playing_card_heart_2.svg.png"));
//      hBox.getChildren().add(new ImageView("https://media.istockphoto.com/photos/three-of-hearts-picture-id624180018?k=6&m=624180018&s=612x612&w=0&h=-RqQPFrrvRmZks5Lbnh4dQUR2dts__KVQx84hj6A34I="));


      HBox hBox1 = new HBox(5);
      hBox.setPadding(new Insets(5, 5, 5, 5));
      Button btFlip = new Button("Flip Card");

      btFlip.setOnAction((ActionEvent event) -> {
         //         System.out.println("Flip");
         im2.setImage(new Image("https://s3-us-west-2.amazonaws.com/files.queenoftarot.com/production/tarot_cards/images/000/000/912/original/4-3.png?1469803887"));
         im3.setImage(new Image("https://s3-us-west-2.amazonaws.com/files.queenoftarot.com/production/tarot_cards/images/000/000/912/original/4-3.png?1469803887"));
      });

      hBox1.getChildren().add(btFlip);
      Scene scene = new Scene(hBox);
      hBox.getChildren().add(hBox1);

      primaryStage.setTitle("Show Image");
      primaryStage.setScene(scene);
      primaryStage.show();
   }


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
      deck1.addAll(cardDeck.subList(0, 26));              //26 cards for p1       

      deck2.addAll(cardDeck.subList(26, cardDeck.size()));//26 cards for p2

      //Array for player objects to be held
      ArrayList<Player> p3 = new ArrayList<>();
      Player p1 = new Player(deck1);
      Player p2 = new Player(deck2);
      p3.add(p1);
      p3.add(p2);

      War game = new War(p3);
      game.play();
      launch(args);

   }



}

package view;

import javafx.application.Application;
import javafx.stage.Stage;
import model.card.BattleCard;
import model.card.Card;
import model.card.CardAttribute;
import model.card.CardRarity;
import model.card.CardType;
import model.card.Keyword;
import model.cardlists.DeckList;
import model.player.HealthData;
import model.player.MagickaData;
import model.player.Player;
import model.player.PlayerBaseData;
import javafx.scene.Scene;

public class Main extends Application {

	public Card generateCard()
	{

		BattleCard card = new BattleCard();
		card.setType(CardType.CREATURE);
		card.setInitialPower(4);
		card.setInitialHealth(6);
		card.setName("Skidaddle");
		card.setDescription("When another creature in this lane dies, draw a card.");
		card.setMagicka_cost(5);
		card.setRarity(CardRarity.EPIC);

		card.setAttribute(CardAttribute.ENDURANCE);
		card.getKeywords().add(Keyword.DRAIN);
		card.getKeywords().add(Keyword.LETHAL);
		
		return card;
	}

	@Override
	public void start(Stage primaryStage)
	{
		try
		{

			Player p1 = new Player();
			Player p2 = new Player();

			MatchboardUI root = new MatchboardUI(p1, p2);

			Card c1 = generateCard();
			Card c2 = generateCard();
			Card c3 = generateCard();
			Card c4 = generateCard();
			
			Card c5 = generateCard();
			Card c6 = generateCard();
			Card c7 = generateCard();
			Card c8 = generateCard();
			
			Card c9 = generateCard();
			Card c10 = generateCard();
			Card c11 = generateCard();
			Card c12 = generateCard();

			p1.getHand().add(c1);
			p1.getFieldLane().add(c2);
			p1.getShadowLane().add(c3);
			p2.getFieldLane().add(c4);
			
			p1.getHand().add(c5);
			p1.getFieldLane().add(c6);
			p1.getShadowLane().add(c7);
			p2.getFieldLane().add(c8);
			
			p1.getHand().add(c9);
			p1.getHand().add(c10);
			p1.getHand().add(c11);
			p1.getFieldLane().add(c12);
			
			Card c13 = generateCard();
			
			p2.getShadowLane().add(c13);
			((BattleCard)c13).setHealth(20);

			/*
			 * PlayerTowerUI root = new PlayerTowerUI(); HealthData health = new
			 * HealthData(); PlayerBaseData player = new PlayerBaseData();
			 * root.assignUISources(health, player);
			 */
			/*
			 * PlayerBaseData player = new PlayerBaseData(); MagickaData magicka = new
			 * MagickaData(); DeckList deck = new DeckList();
			 * 
			 * PlayerDescriptionUI root = new PlayerDescriptionUI();
			 * root.assignUISources(magicka, deck, player);
			 */

			Scene scene = new Scene(root);
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setFullScreen(true);
			primaryStage.setMaximized(true);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}

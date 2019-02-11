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
import model.player.PlayerBaseData;
import javafx.scene.Scene;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage)
	{
		try
		{

			// GameSessionMasterUI root = new GameSessionMasterUI();

			BattleCard card = new BattleCard();
			card.setType(CardType.CREATURE);
			card.setInitialPower(4);
			card.setInitialHealth(6);
			card.setName("Skidaddle");
			card.setDescription("When another creature in this lane dies, draw a card.");
			card.setMagicka_cost(5);
			card.setRarity(CardRarity.EPIC);

			card.setAttribute(CardAttribute.ENDURANCE);
			// card.addKeyword(Keyword.DRAIN);
			// card.addKeyword(Keyword.GUARD);
			// card.addKeyword(Keyword.BREAKTHROUGH);
			// card.addKeyword(Keyword.LETHAL);
			CardUI root = new CardUI(card);

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

			//primaryStage.setFullScreen(true);
			//primaryStage.setMaximized(true);
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

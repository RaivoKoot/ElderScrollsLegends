package view;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Card;
import model.CardAttribute;
import model.DeckList;
import model.HealthData;
import model.Keyword;
import model.MagickaData;
import model.PlayerBaseData;
import javafx.scene.Scene;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage)
	{
		try
		{

			// GameSessionMasterUI root = new GameSessionMasterUI();

			Card card = new Card();

			card.setAttribute(CardAttribute.ENDURANCE);
			card.addKeyword(Keyword.DRAIN);
			//card.addKeyword(Keyword.GUARD);
			card.addKeyword(Keyword.BREAKTHROUGH);
			card.addKeyword(Keyword.LETHAL);
			CardUI root = new CardUI(card);
			root.showDetailView();

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

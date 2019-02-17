package view;

import controller.action_framework.ActiveActions;
import controller.actions.core.StartTurn;
import controller.actions.core.SummonCreature;
import javafx.application.Application;
import javafx.stage.Stage;
import model.IState;
import model.card.BattleCard;
import model.card.Card;
import model.card.CardAttribute;
import model.card.CardRarity;
import model.card.CardType;
import model.card.Keyword;
import model.game.GameState;
import model.player.Player;
import javafx.scene.Scene;

public class Main extends Application {

	public static Card generateCard(Player owner)
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
		card.setOwner(owner);

		return card;
	}

	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			Player p1 = new Player();
			Player p2 = new Player();

			GameState gameData = new GameState();
			gameData.setPlayer1(p1);
			gameData.setPlayer2(p2);
			gameData.assignOpponents();

			ActiveActions activeEffects = new ActiveActions(gameData);
			gameData.register(activeEffects);

			MatchboardUI root = new MatchboardUI(p1, p2);

			Scene scene = new Scene(root);
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setFullScreen(true);
			primaryStage.setMaximized(true);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			StartTurn action = new StartTurn();
			p1.apply(action);

			SummonCreature summon = new SummonCreature(p1.getHand(), p1.getFieldLane());
			p1.getHand().get(0).apply(summon);
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

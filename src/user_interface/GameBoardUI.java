package user_interface;

import java.io.IOException;

import data_layer.Card;
import data_layer.CardAttribute;
import data_layer.DeckList;
import data_layer.MagickaData;
import data_layer.PlayerBaseData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GameBoardUI extends BorderPane {

	@FXML private VBox vbox_boardAndHand;
	
	// Player Towers
	@FXML private VBox vbox_playerTower;
	@FXML private VBox vbox_opponentPlayerTower;
	
	// Player Descriptions
	@FXML private PlayerDescriptionUI vbox_playerDescription;
	@FXML private PlayerDescriptionUI vbox_opponentPlayerDescription;
	
	// Lanes of the game
	@FXML private BattleLanesUI battleLanesUI_opponent;
	@FXML private BattleLanesUI battleLanesUI_friendlyPlayer;
	
	private HandUI handUI;

	/**
	 * 
	 */
	public GameBoardUI()
	{

		// load fxml file
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GameboardUI.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		// load and setup pane
		try
		{
			fxmlLoader.load();
			createUI();
			testDescriptionUI(); // fill out description uis
			vbox_opponentPlayerDescription.reversePaneOrder();

		} catch (IOException exception)
		{
			throw new RuntimeException(exception);
		}
	}

	private void createUI()
	{
		createHandUI();
	}

	private void createHandUI()
	{
		handUI = new HandUI();
		vbox_boardAndHand.getChildren().add(handUI);
	}

	
	private void populateDescriptionUI(PlayerDescriptionUI descriptionUI, MagickaData magicka, DeckList deck,
			PlayerBaseData player)
	{
		descriptionUI.fillUI(magicka, deck, player);
	}

	public void fillHandTest()
	{

		Card card_1 = new Card();
		Card card_2 = new Card();
		Card card_3 = new Card();
		Card card_4 = new Card();
		Card card_5 = new Card();
		Card card_6 = new Card();

		card_1.setAttribute(CardAttribute.STRENGTH);
		card_2.setAttribute(CardAttribute.INTELLIGENCE);
		card_3.setAttribute(CardAttribute.WILLPOWER);
		card_4.setAttribute(CardAttribute.AGILITY);
		card_5.setAttribute(CardAttribute.ENDURANCE);
		card_6.setAttribute(CardAttribute.NEUTRAL);

		CardUI cardUI_1 = new CardUI(card_1);
		CardUI cardUI_2 = new CardUI(card_2);
		CardUI cardUI_3 = new CardUI(card_3);
		CardUI cardUI_4 = new CardUI(card_4);
		CardUI cardUI_5 = new CardUI(card_5);
		CardUI cardUI_6 = new CardUI(card_6);
		cardUI_5.showDetailView();
		cardUI_4.showDetailView();

		cardUI_3.showWardBubble();

		cardUI_2.showLegendaryBorder();
		cardUI_5.showLegendaryBorder();
		cardUI_4.showGuardBorder();
		// cardUI_6.showDetailView();

		handUI.addCard(cardUI_6);
		handUI.addCard(cardUI_5);

		battleLanesUI_opponent.addCardFieldLane(cardUI_3);
		battleLanesUI_opponent.addCardFieldLane(cardUI_2);
		battleLanesUI_friendlyPlayer.addCardFieldLane(cardUI_1);
		battleLanesUI_friendlyPlayer.addCardFieldLane(cardUI_4);

		// hbox_handcardsHolder.getChildren().addAll(cardUI_1,cardUI_2,cardUI_3,cardUI_4,cardUI_5,cardUI_6);
	}
	
	private void testDescriptionUI()
	{
		MagickaData magicka1 = new MagickaData();
		MagickaData magicka2 = new MagickaData();

		DeckList deck1 = new DeckList();
		DeckList deck2 = new DeckList();

		PlayerBaseData playerData = new PlayerBaseData();

		populateDescriptionUI(vbox_playerDescription, magicka1, deck1, playerData);
		populateDescriptionUI(vbox_opponentPlayerDescription, magicka2, deck2, playerData);
	}

}

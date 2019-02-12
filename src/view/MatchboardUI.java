package view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import model.Subject;
import model.cardlists.CardList;
import model.cardlists.DeckList;
import model.player.MagickaData;
import model.player.Player;
import model.player.PlayerBaseData;

public class MatchboardUI extends BorderPane {

	@FXML private VBox vbox_boardAndHand;

	// Player Towers
	@FXML private VBox vbox_playerTower;
	@FXML private VBox vbox_opponentPlayerTower;

	// Player Descriptions
	@FXML private PlayerDescriptionUI vbox_playerDescription;
	@FXML private PlayerDescriptionUI vbox_opponentPlayerDescription;

	// Lanes of the game
	@FXML GridPane gridpane_lanes;
	@FXML StackPane pane_bottom;

	private LaneUI handUI;

	/**
	 * 
	 */
	public MatchboardUI(Player player_1, Player player_2)
	{

		// load fxml file
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MatchboardUI.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		// load and setup pane
		try
		{
			fxmlLoader.load();

			initialize(player_1, player_2);

		} catch (IOException exception)
		{
			throw new RuntimeException(exception);
		}
	}

	private void initialize(Player player_1, Player player_2)
	{
		addHandUI(player_1.getHand());
		addLaneUIs(player_1, player_2);

		setBackground();
		testDescriptionUI(); // fill out description uis
		vbox_opponentPlayerDescription.reversePaneOrder();
	}

	private void addHandUI(CardList subject)
	{
		handUI = new LaneUI(LaneType.HAND);
		handUI.initializeUiSources(subject);
		pane_bottom.getChildren().add(handUI);
	}

	private void addLaneUIs(Player player_1, Player player_2)
	{
		LaneUI fieldLane_p1 = new LaneUI(LaneType.FIELD);
		LaneUI shadowLane_p1 = new LaneUI(LaneType.SHADOW);
		fieldLane_p1.initializeUiSources(player_1.getFieldLane());
		shadowLane_p1.initializeUiSources(player_1.getShadowLane());
		
		LaneUI fieldLane_p2 = new LaneUI(LaneType.FIELD);
		LaneUI shadowLane_p2 = new LaneUI(LaneType.SHADOW);
		fieldLane_p2.initializeUiSources(player_2.getFieldLane());
		shadowLane_p2.initializeUiSources(player_2.getShadowLane());

		gridpane_lanes.add(fieldLane_p2, 0, 0);
		gridpane_lanes.add(shadowLane_p2, 1, 0);
		
		gridpane_lanes.add(fieldLane_p1, 0, 1);
		gridpane_lanes.add(shadowLane_p1, 1, 1);
		
	}

	private void setBackground()
	{
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();
		double width = bounds.getWidth();
		double height = bounds.getHeight();

		if (width / height > 1.6)
			this.setId("widescreen");
	}

	private void populateDescriptionUI(PlayerDescriptionUI descriptionUI, MagickaData magicka, DeckList deck,
			PlayerBaseData player)
	{
		descriptionUI.assignUISources(magicka, deck, player);
	}

	/*
	 * public void fillHandTest() {
	 * 
	 * Card card_1 = new Card(); Card card_2 = new Card(); Card card_3 = new Card();
	 * Card card_4 = new Card(); Card card_5 = new Card(); Card card_6 = new Card();
	 * 
	 * card_1.setAttribute(CardAttribute.STRENGTH);
	 * card_2.setAttribute(CardAttribute.INTELLIGENCE);
	 * card_3.setAttribute(CardAttribute.WILLPOWER);
	 * card_4.setAttribute(CardAttribute.AGILITY);
	 * card_5.setAttribute(CardAttribute.ENDURANCE);
	 * card_6.setAttribute(CardAttribute.NEUTRAL);
	 * 
	 * CardUI cardUI_1 = new CardUI(card_1); CardUI cardUI_2 = new CardUI(card_2);
	 * CardUI cardUI_3 = new CardUI(card_3); CardUI cardUI_4 = new CardUI(card_4);
	 * CardUI cardUI_5 = new CardUI(card_5); CardUI cardUI_6 = new CardUI(card_6);
	 * //cardUI_5.showDetailView(); //cardUI_4.showDetailView();
	 * 
	 * //cardUI_3.showWardBubble();
	 * 
	 * //cardUI_2.showLegendaryBorder(); //cardUI_5.showLegendaryBorder();
	 * //cardUI_4.showGuardBorder(); // cardUI_6.showDetailView();
	 * 
	 * handUI.addCard(cardUI_6); handUI.addCard(cardUI_5);
	 * 
	 * battleLanesUI_opponent.addCardFieldLane(cardUI_3);
	 * battleLanesUI_opponent.addCardFieldLane(cardUI_2);
	 * battleLanesUI_friendlyPlayer.addCardFieldLane(cardUI_1);
	 * battleLanesUI_friendlyPlayer.addCardFieldLane(cardUI_4);
	 * 
	 * //
	 * hbox_handcardsHolder.getChildren().addAll(cardUI_1,cardUI_2,cardUI_3,cardUI_4
	 * ,cardUI_5,cardUI_6); }
	 */

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

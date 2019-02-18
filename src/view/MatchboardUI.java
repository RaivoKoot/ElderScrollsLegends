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
		
		vbox_playerDescription.assignUISources(player_1.getMagicka(), player_1.getDeck(), player_1.getBaseInfo());
		vbox_opponentPlayerDescription.assignUISources(player_2.getMagicka(), player_2.getDeck(), player_2.getBaseInfo());

		setBackground();
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

}

package application;

import java.io.IOException;

import data_layer.Card;
import data_layer.CardAttribute;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class GameBoardUI extends BorderPane{
	
	@FXML private HBox hbox_handcardsHolder;

	/**
	 * 
	 */
	public GameBoardUI()
	{

		// load fxml file
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Gameboard.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		// load and setup pane
		try
		{
			fxmlLoader.load();

		} catch (IOException exception)
		{
			throw new RuntimeException(exception);
		}
	}
	
	public void fillHandTest() {
		
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
		//cardUI_6.showDetailView();
		
		hbox_handcardsHolder.getChildren().addAll(cardUI_1,cardUI_2,cardUI_3,cardUI_4,cardUI_5,cardUI_6);
	}
	
}

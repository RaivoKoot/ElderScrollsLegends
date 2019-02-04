package user_interface;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class HandUI extends StackPane{
	
	@FXML private HBox hbox_cards;

	public HandUI()
	{

		// load fxml file
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HandUI.fxml"));
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
	
	public void addCard(CardUI card) {
		card.makeBigger();
		hbox_cards.getChildren().add(card);
	}
	
	public void removeCard(CardUI card) {
		hbox_cards.getChildren().remove(card);
	}
	
	
}

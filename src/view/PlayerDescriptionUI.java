package view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.CardAttribute;
import model.DeckList;
import model.HealthData;
import model.MagickaData;
import model.Observer;
import model.PlayerBaseData;
import model.Subject;

public class PlayerDescriptionUI extends VBox implements Observer{
	
	@FXML Label label_currentMagicka;
	@FXML Label label_maxMagicka;
	@FXML Label label_playerName;
	@FXML HBox hbox_attributes;
	
	private Subject subject;
	
	public PlayerDescriptionUI()
	{

		// load fxml file
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PlayerDescriptionUI.fxml"));
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
	
	public void assignUISources(MagickaData magickaData, DeckList deckAttributes, PlayerBaseData player) {
		assignAttributes(deckAttributes);
		changeName(player.getName());
		
		setSubject(magickaData);
		update();
	}
	
	private void changeName(String name) {
		label_playerName.setText(name);
	}
	
	private void assignAttributes(DeckList attributes) {
		for(CardAttribute attribute: attributes.getAttributes()) {
			IconUI attributeUI = new IconUI(attribute);
			hbox_attributes.getChildren().add(attributeUI);
		}
	}
	
	private void updateMagickaLabels(MagickaData magicka) {
		label_currentMagicka.setText(String.valueOf(magicka.getCurrentMagicka()));
		label_maxMagicka.setText(String.valueOf(magicka.getMaxMagicka()));
	}
	
	public void reversePaneOrder() {
		this.getChildren().get(0).toFront();
	}

	@Override
	public void update()
	{
		MagickaData update = (MagickaData) this.subject.getUpdate(this);
		
		updateMagickaLabels(update);

	}

	@Override
	public void setSubject(Subject sub)
	{
		this.subject = sub;
		subject.register(this);
	}
	
	
}

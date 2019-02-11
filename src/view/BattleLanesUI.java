package view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.transform.Scale;
import model.Observer;
import model.Subject;
import model.cardlists.LaneCardList;
import model.player.HealthData;

public class BattleLanesUI extends HBox implements Observer{
	
	@FXML private HBox hbox_fieldLane;
	@FXML private HBox hbox_shadowLane;
	
	private Subject subject;
	
	/**
	 * 
	 */
	public BattleLanesUI()
	{

		// load fxml file
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BattleLanesUI.fxml"));
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
	
	public void addCardFieldLane(CardUI card) {
		hbox_fieldLane.getChildren().add(card);
	}
	
	public void addCardShadowLane(CardUI card) {
		card.hideDetailView();
		hbox_shadowLane.getChildren().add(card);
	}
	
	@Override
	public void update()
	{
		LaneCardList update = (LaneCardList) this.subject.getUpdate(this);

	}

	@Override
	public void setSubject(Subject sub)
	{
		this.subject = sub;
		subject.register(this);
	}

}

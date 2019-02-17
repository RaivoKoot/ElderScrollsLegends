package view;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import model.Observer;
import model.Subject;
import model.card.Card;
import model.cardlists.CardList;
import model.cardlists.CardListChange;

public class LaneUI extends HBox implements Observer {

	private Subject subject;
	private LaneType type;

	/**
	 * 
	 */
	public LaneUI(LaneType type)
	{
		this.type = type;
		String fxml_url = "LaneUI.fxml";

		if (type == LaneType.HAND)
			fxml_url = "HandUI.fxml";

		// load fxml file
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml_url));
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

	public void initializeUiSources(CardList cards)
	{
		setSubject(cards);
	}

	public void addCard(CardUI card)
	{
		this.getChildren().add(card);
	}

	public void removeCard(CardUI card)
	{
		this.getChildren().remove(card);
	}

	/**
	 * gets the updated card from the subject cardList. The card was either added or
	 * removed from the cardlist. This method checks if it was removed and if so
	 * removes the corresponding UI
	 */
	@Override
	public void update()
	{
		System.out.println("Update of a lane UI");
		Object[] update = (Object[]) this.subject.getUpdate(this);
		Card changedCard = (Card) update[0];
		CardListChange changeType = (CardListChange) update[1];

		switch (changeType) {
		case CARD_REMOVED:

			CardUI toBeRemoved = null;
			/*
			 * iterates over cardUI list and checks if each ui's corresponding card object
			 * is the updated one. removes the ui if so
			 */
			ObservableList<Node> children = this.getChildren();
			for (Node cardUI : children)
			{

				if (((CardUI) cardUI).getCard() == changedCard)
				{

					toBeRemoved = (CardUI) cardUI;
					break;
				}

			}
			
			children.remove(toBeRemoved);

			break;

		case CARD_ADDED:

			CardUI addedCard = new CardUI(changedCard);
			this.getChildren().add(addedCard);

			if (this.type == LaneType.HAND)
			{
				addedCard.makeBigger();
				addedCard.toggleMinimalisticView(false);
			}

			break;

		}

	}

	@Override
	public void setSubject(Subject sub)
	{
		this.subject = sub;
		subject.register(this);
	}

}

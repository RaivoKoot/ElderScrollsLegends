package view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import model.Observer;
import model.Subject;
import model.card.Card;
import model.cardlists.CardList;

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

	@Override
	public void update()
	{
		CardList update = (CardList) this.subject.getUpdate(this);

		/*
		 * checks if the cards that are in the ui lane are still in the cardlist. Remove
		 * the card from the ui if it isnt in the cardlist anymore.
		 */
		for (Node cardUI : this.getChildren())
		{

			if (!update.contains(((CardUI) cardUI).getCard()))
			{
				this.getChildren().remove(cardUI);
			}
		}

		for (Card card : update)
		{
			boolean alreadyOnHand = false;
			for (Node cardUI : this.getChildren())
			{
				Card nodesCard = ((CardUI) cardUI).getCard();
				if (nodesCard == card)
					alreadyOnHand = true;
			}

			if (!alreadyOnHand)
			{
				CardUI addedCard = new CardUI(card);
				this.getChildren().add(addedCard);

				if (this.type == LaneType.HAND)
				{
					addedCard.makeBigger();
					addedCard.toggleMinimalisticView(false);
				}

			}
		}

	}

	@Override
	public void setSubject(Subject sub)
	{
		this.subject = sub;
		subject.register(this);
	}

}

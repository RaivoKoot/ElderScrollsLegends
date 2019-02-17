package model.cardlists;

import java.util.ArrayList;

import controller.action_framework.IAction;
import model.IState;
import model.Observer;
import model.Subject;
import model.card.Card;

public class CardList extends ArrayList<Card> implements Subject, IState {

	private int maximumSize;

	// Subject fields
	private ArrayList<Observer> observers;
	private Card lastChangedCard;
	private CardListChange lastChange;

	public CardList(MaximumSize MAX_SIZE)
	{
		setMaxSize(MAX_SIZE);
		observers = new ArrayList<Observer>();
	}

	/**
	 * @return true if the list has not reached its maximum space limit yet
	 */
	public boolean hasSpace()
	{
		if (this.size() < maximumSize)
			return true;

		return false;
	}

	/**
	 * sets the maximum amount of cards allowed in this list
	 * 
	 * @param MAX_SIZE
	 */
	private void setMaxSize(MaximumSize MAX_SIZE)
	{
		switch (MAX_SIZE) {
		case TEN:
			this.maximumSize = 10;
			break;
		case FOUR:
			this.maximumSize = 4;
			break;
		case HUNDRED:
			this.maximumSize = 100;
			break;
		}
	}

	@Override
	public boolean add(Card card)
	{

		if (super.add(card))
		{
			lastChangedCard = card;
			lastChange = CardListChange.CARD_ADDED;

			notifyObservers();
			return true;
		}

		return false;
	}

	@Override
	public boolean remove(Object card)
	{

		if (super.remove(card))
		{
			lastChangedCard = (Card) card;
			lastChange = CardListChange.CARD_REMOVED;

			notifyObservers();
			return true;
		}

		return false;
	}

	@Override
	public void register(Observer observer)
	{
		if (!observers.contains(observer))
			observers.add(observer);
	}

	@Override
	public void unregister(Observer observer)
	{
		observers.remove(observer);
	}

	@Override
	public void notifyObservers()
	{
		for (Observer observer : observers)
		{
			observer.update();
		}
	}

	@Override
	public Object getUpdate(Observer obj)
	{
		Object[] update = { lastChangedCard, lastChange };

		return update;
	}

	@Override
	public void apply(IAction action)
	{
		try
		{
			action.execute(this);
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

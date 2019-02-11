package model.cardlists;

import java.util.ArrayList;

import model.Observer;
import model.Subject;
import model.card.Card;
import model.card.CardAttribute;

public class DeckList extends CardList {

	private ArrayList<CardAttribute> attributes;
	private final int MINIMUM_SIZE = 50;

	private ArrayList<Observer> observers;

	public DeckList()
	{
		super(MaximumSize.HUNDRED);
		attributes = new ArrayList<CardAttribute>();

		// testing
		addAttribute(CardAttribute.ENDURANCE);
		addAttribute(CardAttribute.INTELLIGENCE);
	}

	/**
	 * @return does the deck meet the minimum card requirement of 50
	 */
	public boolean hasEnoughCards()
	{
		if (this.size() >= MINIMUM_SIZE)
			return true;

		return false;
	}

	public ArrayList<CardAttribute> getAttributes()
	{
		return attributes;
	}

	public void addAttribute(CardAttribute attribute)
	{
		this.attributes.add(attribute);
	}

	public void removeAttribute(CardAttribute attribute)
	{
		this.attributes.remove(attribute);
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
		return this;
	}

}

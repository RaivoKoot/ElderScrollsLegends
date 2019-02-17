package model.cardlists;

import java.util.ArrayList;

import model.Observer;
import model.Subject;
import model.card.Card;
import model.card.CardAttribute;
import model.player.Player;
import view.Main;

public class DeckList extends CardList {

	private ArrayList<CardAttribute> attributes;
	private final int MINIMUM_SIZE = 50;
	private Player owner;

	private ArrayList<Observer> observers;

	public DeckList(Player owner)
	{
		super(MaximumSize.HUNDRED);
		this.owner = owner;
		attributes = new ArrayList<CardAttribute>();

		// testing
		addAttribute(CardAttribute.ENDURANCE);
		addAttribute(CardAttribute.INTELLIGENCE);

		// testing
		for (int i = 0; i < 10; i++)
			this.add(Main.generateCard(owner));
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

	public Player getOwner()
	{
		return owner;
	}

	public void setOwner(Player owner)
	{
		this.owner = owner;
	}

}

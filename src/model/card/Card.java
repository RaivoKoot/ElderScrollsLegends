package model.card;

import java.util.ArrayList;

import controller.action_framework.IAction;
import javafx.scene.image.Image;
import model.IState;
import model.Observer;
import model.Subject;
import model.player.Player;

public class Card implements Subject, IState {

	private String name;
	private String description;
	private CardAttribute attribute;
	private CardType type;
	private CardType subtype;
	private CardRarity rarity;
	private int magicka_cost;
	private Image picture;
	
	private Player owner;

	private ArrayList<Observer> observers;

	public Card()
	{
		observers = new ArrayList<Observer>();
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

	public int getMagicka_cost()
	{
		return magicka_cost;
	}

	public void setMagicka_cost(int magicka_cost)
	{
		this.magicka_cost = magicka_cost;
		notifyObservers();
	}

	public Image getPicture()
	{
		return picture;
	}

	public void setPicture(Image picture)
	{
		this.picture = picture;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public CardAttribute getAttribute()
	{
		return attribute;
	}

	public void setAttribute(CardAttribute attribute)
	{
		this.attribute = attribute;
	}

	public CardType getType()
	{
		return type;
	}

	public void setType(CardType type)
	{
		this.type = type;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public CardType getSubtype()
	{
		return subtype;
	}

	public void setSubtype(CardType subtype)
	{
		this.subtype = subtype;
	}

	public CardRarity getRarity()
	{
		return rarity;
	}

	public void setRarity(CardRarity rarity)
	{
		this.rarity = rarity;
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

	public Player getOwner()
	{
		return owner;
	}

	public void setOwner(Player owner)
	{
		this.owner = owner;
	}

}

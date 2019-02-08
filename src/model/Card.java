package model;

import java.util.ArrayList;

import javafx.scene.image.Image;

public class Card implements Subject{

	private CardAttribute attribute;
	private CardType card_type;
	private boolean legendary;
	private int power;
	private int health;
	private String name;
	private int magicka_cost;
	private Image picture;
	private String description;
	private KeywordList keywords;
	
	private ArrayList<Observer> observers;

	public Card()
	{
		keywords = new KeywordList();
		attribute = CardAttribute.STRENGTH;
	}

	public int getPower()
	{
		return power;
	}

	public void setPower(int base_power)
	{
		this.power = base_power;
	}

	public int getHealth()
	{
		return health;
	}

	public void setHealth(int base_health)
	{
		this.health = base_health;
	}

	public int getMagicka_cost()
	{
		return magicka_cost;
	}

	public void setMagicka_cost(int magicka_cost)
	{
		this.magicka_cost = magicka_cost;
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
		return card_type;
	}

	public void setType(CardType type)
	{
		this.card_type = type;
	}

	public KeywordList getKeywords()
	{
		return keywords;
	}

	public void addKeyword(Keyword keyword)
	{
		this.keywords.add(keyword);
	}

	public void removeKeyword(Keyword keyword)
	{
		this.keywords.remove(keyword);
	}

	public boolean isLegendary()
	{
		return legendary;
	}

	public void setLegendary(boolean legendary)
	{
		this.legendary = legendary;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
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

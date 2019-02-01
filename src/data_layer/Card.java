package data_layer;

import javafx.scene.image.Image;

public class Card {
	
	private CardAttribute attribute;
	private CardType card_type;
	private int base_power;
	private int base_health;
	private int name;
	private int magicka_cost;
	private Image picture;
	private String description;
	
	public Card() {
		attribute = CardAttribute.STRENGTH;
	}
	
	public int getBase_power()
	{
		return base_power;
	}
	public void setBase_power(int base_power)
	{
		this.base_power = base_power;
	}
	public int getBase_health()
	{
		return base_health;
	}
	public void setBase_health(int base_health)
	{
		this.base_health = base_health;
	}
	public int getName()
	{
		return name;
	}
	public void setName(int name)
	{
		this.name = name;
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
	

}

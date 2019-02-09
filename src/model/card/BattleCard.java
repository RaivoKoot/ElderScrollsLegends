package model.card;

public class BattleCard extends Card {

	private int power;
	private int health;
	private KeywordList keywords;

	private int initialPower;
	private int initialHealth;

	public BattleCard()
	{
		super();
		keywords = new KeywordList();
	}

	public int getPower()
	{
		return power;
	}

	public void setPower(int power)
	{
		this.power = power;
	}

	public int getHealth()
	{
		return health;
	}

	public void setHealth(int health)
	{
		this.health = health;
	}

	public KeywordList getKeywords()
	{
		return keywords;
	}

	public void setKeywords(KeywordList keywords)
	{
		this.keywords = keywords;
	}

	public int getInitialPower()
	{
		return initialPower;
	}

	public void setInitialPower(int initialPower)
	{
		this.initialPower = initialPower;
		this.power = initialPower;
	}

	public int getInitialHealth()
	{
		return initialHealth;
	}

	public void setInitialHealth(int initialHealth)
	{
		this.initialHealth = initialHealth;
		this.health = initialHealth;
	}
}

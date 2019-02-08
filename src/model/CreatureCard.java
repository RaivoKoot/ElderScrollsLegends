package model;

public class CreatureCard extends Card{

	private int currentHealth;
	private int currentPower;
	private int baseHealth;
	private int basePower;
	
	private CreatureType race;
	
	public CreatureCard() {
		super();
	}

	public int getCurrentHealth()
	{
		return currentHealth;
	}

	public void setCurrentHealth(int currentHealth)
	{
		this.currentHealth = currentHealth;
	}

	public int getCurrentPower()
	{
		return currentPower;
	}

	public void setCurrentPower(int currentPower)
	{
		this.currentPower = currentPower;
	}

	public CreatureType getRace()
	{
		return race;
	}

	public void setRace(CreatureType race)
	{
		this.race = race;
	}

	public int getBasePower()
	{
		return basePower;
	}

	public void setBasePower(int basePower)
	{
		this.basePower = basePower;
	}

	public int getBaseHealth()
	{
		return baseHealth;
	}

	public void setBaseHealth(int baseHealth)
	{
		this.baseHealth = baseHealth;
	}
	
	@Override
	public int getPower() {
		return currentPower;
	}
	
	@Override
	public int getHealth() {
		return currentHealth;
	}

}

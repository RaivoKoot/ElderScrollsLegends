package model;

public class CreatureCard extends Card{

	private int currentHealth;
	private int currentPower;
	private CreatureType race;

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

}

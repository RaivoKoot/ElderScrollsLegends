package model.card;

import model.IState;

public class StatAlteration {
	private int healthAlteration;
	private int powerAlteration;
	private IState source;
	private StatAlterationType type;

	public StatAlteration(int health, int power, IState source, StatAlterationType type)
	{
		this.healthAlteration = health;
		this.powerAlteration = power;
		this.source = source;
		this.type = type;
	}

	public int getHealthAlteration()
	{
		return healthAlteration;
	}

	public void setHealthAlteration(int healthAlteration)
	{
		this.healthAlteration = healthAlteration;
	}

	public int getPowerAlteration()
	{
		return powerAlteration;
	}

	public void setPowerAlteration(int powerAlteration)
	{
		this.powerAlteration = powerAlteration;
	}

	public StatAlterationType getType()
	{
		return type;
	}

	public void setType(StatAlterationType type)
	{
		this.type = type;
	}

	public IState getSource()
	{
		return source;
	}

	public void setSource(IState source)
	{
		this.source = source;
	}
}

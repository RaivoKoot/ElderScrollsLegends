package model;

public class HealthData{
	
	private int health = 30;
	private int runesLeft = 5;
	
	public int getHealth()
	{
		return health;
	}
	public void setHealth(int health)
	{
		this.health = health;
	}
	
	public void decreaseRunesLeft() {
		this.runesLeft--;
	}
	public int getRunesLeft()
	{
		return runesLeft;
	}
	public void setRunesLeft(int runesLeft)
	{
		this.runesLeft = runesLeft;
	}
	
	public void updateRuneAmount() {
		if((health / 5 -1) < runesLeft)
			runesLeft--;
	}

}

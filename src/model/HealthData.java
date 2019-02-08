package model;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;

public class HealthData implements Subject {

	private final int STARTING_HEALTH = 30;
	private final RunesLeft STARTING_RUNES = RunesLeft.FIVE;

	private ArrayList<Observer> observers;
	private int health;
	private RunesLeft runesLeft;

	public HealthData()
	{
		this.health = STARTING_HEALTH;
		this.runesLeft = STARTING_RUNES;
		observers = new ArrayList<Observer>();
	}

	public int getHealth()
	{
		return health;
	}

	public void setHealth(int health)
	{
		this.health = health;
		updateRuneAmount();

		notifyObservers();
	}

	public Image getRuneImage()
	{
		return runesLeft.getFilledRunesImage();
	}

	private void updateRuneAmount()
	{
		int newRuneAmount = health / 5;
		if (newRuneAmount < runesLeft.getAmount())
			runesLeft = RunesLeft.fromValue(newRuneAmount);
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

package model.player;

import java.util.ArrayList;
import java.util.List;

import controller.action_framework.IAction;
import javafx.scene.image.Image;
import model.IState;
import model.Observer;
import model.Subject;

public class HealthData implements Subject, IState {

	private final int STARTING_HEALTH = 30;
	private final RunesLeft STARTING_RUNES = RunesLeft.FIVE;

	private int health;
	private RunesLeft runesLeft;
	
	private ArrayList<Observer> observers;

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

}

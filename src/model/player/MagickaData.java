package model.player;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.scene.image.Image;
import model.Observer;
import model.Subject;

public class MagickaData implements Subject {
	
	public enum MagickaDataFields {CURRENT_MAGICKA, MAX_MAGICKA};

	private final int STARTING_MAGICKA = 0;
	private int currentMagicka;
	private int maxMagicka;

	private ArrayList<Observer> observers;

	public MagickaData()
	{
		currentMagicka = STARTING_MAGICKA;
		maxMagicka = STARTING_MAGICKA;
		observers = new ArrayList<Observer>();
	}

	public int getCurrentMagicka()
	{
		return currentMagicka;
	}

	public void setCurrentMagicka(int currentMagicka)
	{
		this.currentMagicka = currentMagicka;
		notifyObservers();
	}

	public int getMaxMagicka()
	{
		return maxMagicka;
	}

	public void setMaxMagicka(int maxMagicka)
	{
		this.maxMagicka = maxMagicka;
		notifyObservers();
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

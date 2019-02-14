package model.card;

import java.util.ArrayList;

import model.IState;
import model.Observer;
import model.Subject;

public class StatAlterationList extends ArrayList<StatAlteration> implements Subject{
	
	private ArrayList<Observer> observers;
	
	public StatAlterationList() {
		super();
		observers = new ArrayList<Observer>();
	}

	/**
	 * @return returns the sum of health alterations
	 */
	public int sumHealth()
	{
		int sumHealth = 0;

		for (StatAlteration alteration : this)
			sumHealth += alteration.getHealthAlteration();

		return sumHealth;

	}

	/**
	 * @return returns the summed power of the alterations
	 */
	public int sumPower()
	{
		int sumPower = 0;

		for (StatAlteration alteration : this)
			sumPower += alteration.getPowerAlteration();

		return sumPower;

	}
	
	public void addAlteration(StatAlteration alteration) {
		this.add(alteration);
		notifyObservers();
	}

	/**
	 * @param source removes all alterations that come from this source
	 */
	public void removeAlteration(IState source)
	{
		for (StatAlteration alteration : this)
			if (alteration.getSource() == source)
				this.remove(alteration);
		
		notifyObservers();
	}

	/**
	 * removes all alterations that are of type effect or item
	 */
	public void removeSpecialAlterations()
	{
		for (StatAlteration alteration : this)
			if (alteration.getType() != StatAlterationType.DAMAGE)
				this.remove(alteration);
		
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

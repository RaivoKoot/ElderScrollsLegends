package model.game;

import java.util.ArrayList;

import controller.action_framework.IAction;
import model.IState;
import model.Observer;
import model.Subject;
import model.player.Player;

public class GameState implements IState, Subject {

	public static Event currentEvent;
	private Player player1;
	private Player player2;

	private ArrayList<Observer> observers;

	public GameState()
	{
		observers = new ArrayList<Observer>();
		setCurrentEvent(new Event(EventType.IDLE, null, null));
		CurrentEventManager.setGame(this);
	}

	public void assignOpponents()
	{
		player1.setOpponent(player2);
		player2.setOpponent(player1);
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

	public Event getCurrentEvent()
	{
		return currentEvent;
	}

	public void setCurrentEvent(Event currentEvent)
	{
		GameState.currentEvent = currentEvent;
		System.out.println("Event is now: " + currentEvent);

		if (currentEvent.getType() != EventType.IDLE)
			notifyObservers();
	}

	public Player getPlayer1()
	{
		return player1;
	}

	public void setPlayer1(Player player1)
	{
		this.player1 = player1;
	}

	public Player getPlayer2()
	{
		return player2;
	}

	public void setPlayer2(Player player2)
	{
		this.player2 = player2;
	}

}

package model.game;

import controller.actions.IAction;
import model.IState;

public class Event implements IState{

	private EventType type;
	private IState source;
	private IState target;

	public Event(EventType name, IState source, IState target)
	{
		this.type = name;
		this.source = source;
		this.target = target;
	}

	public IState getTarget()
	{
		return target;
	}

	public void setTarget(IState target)
	{
		this.target = target;
	}

	public IState getSource()
	{
		return source;
	}

	public void setSource(IState source)
	{
		this.source = source;
	}

	public EventType getType()
	{
		return type;
	}

	public void setType(EventType name)
	{
		this.type = name;
	}

	@Override
	public void apply(IAction action)
	{
		action.execute(this);
		
	}

}

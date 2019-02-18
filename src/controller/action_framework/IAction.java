package controller.action_framework;

import model.IState;
import model.game.Event;
import model.game.EventType;

public abstract class IAction {
	private boolean repetitive;
	private Event source;
	private EventType trigger;

	public IAction(Event source, boolean repetitive, EventType trigger)
	{
		this.source = source;
		this.repetitive = repetitive;
	}

	public abstract void execute(IState state) throws Exception;

	public boolean isRepetetive()
	{
		return repetitive;
	}

	public boolean isChildOf(IState source)
	{
		return source == this.source;
	}

	public boolean isValid(IState currentEvent)
	{
		return ((Event) currentEvent).getType() == trigger;
	}

	public Event getSource()
	{
		return source;
	}

	public void setSource(Event source)
	{
		this.source = source;
	}
}
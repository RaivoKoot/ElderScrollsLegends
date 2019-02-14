package controller.actions;

import model.IState;
import model.game.Event;
import model.game.EventType;

public abstract class IAction {
	private boolean repetitive;
	private IState source;
	private EventType trigger;

	public IAction(IState source, boolean repetitive, EventType trigger)
	{
		this.source = source;
		this.repetitive = repetitive;
	}
	
	public abstract void execute(IState state);

	public boolean isRepetetive()
	{
		return repetitive;
	}

	public boolean isChildOf(IState source)
	{
		return source == this.source;
	}

	public boolean isValid(Event currentEvent)
	{
		return currentEvent.getType() == trigger;
	}
}
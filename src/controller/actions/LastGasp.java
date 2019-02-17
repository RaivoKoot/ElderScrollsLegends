package controller.actions;

import controller.action_framework.IAction;
import model.IState;
import model.game.Event;
import model.game.EventType;

public class LastGasp extends IAction{
	
	private static final EventType TRIGGER = EventType.CARD_DESTRUCTION;
	private static final boolean REPETITIVE = true;

	public LastGasp(Event source)
	{
		super(source, REPETITIVE, TRIGGER);
	}

	@Override
	public void execute(IState state)
	{
		
	}

}

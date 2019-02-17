package controller.actions.core;

import java.util.ArrayList;

import controller.action_framework.ActiveActions;
import controller.action_framework.IAction;
import controller.actions.LastGasp;
import model.IState;
import model.game.Event;
import model.game.EventType;

/**
 * @author Raivo Koot triggers when a card gets destroyed and removes any active
 *         effects of that card from the active action list apart from last gasp
 *         actions
 */
public class RemoveActionsOfDeadCard extends IAction {

	private static final EventType TRIGGER = EventType.CARD_DESTRUCTION;
	private static final boolean REPETITIVE = true;

	public RemoveActionsOfDeadCard(Event source)
	{
		super(source, REPETITIVE, TRIGGER);
	}

	@Override
	public void execute(IState state)
	{
		IState diedCard = ((Event) state).getTarget();
		ArrayList<IAction> activeActions = ActiveActions.actions;

		for (IAction action : activeActions)
		{
			if (action.isChildOf(diedCard) && action.getClass() != LastGasp.class)
				activeActions.remove(action);
		}

	}

}

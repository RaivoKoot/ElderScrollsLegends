package controller.actions;

import java.util.ArrayList;

import model.IState;
import model.game.Event;
import model.game.EventType;

/**
 * @author Raivo Koot triggers when a card gets destroyed and removes any active
 *         effects of that card from the active action list
 */
public class RemoveActionsOfCard extends IAction{

	private static final EventType TRIGGER = EventType.CARD_DESTRUCTION;
	private static final boolean REPETITIVE = true;
	private ActiveActions source;

	public RemoveActionsOfCard(IState source)
	{
		super(source, REPETITIVE, TRIGGER);
	}

	@Override
	public void execute(IState state)
	{
		IState diedCard = ((Event) state).getTarget();
		ArrayList<IAction> activeActions = source.getActions();

		for (IAction action : activeActions)
		{
			if (action.isChildOf(diedCard))
				activeActions.remove(action);
		}

	}

}

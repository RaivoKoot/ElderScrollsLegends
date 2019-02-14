package controller.actions;

import java.util.ArrayList;

import model.IState;
import model.Observer;
import model.Subject;
import model.game.Event;
import model.game.GameState;

public class ActiveActions implements Observer, IState {

	private ArrayList<IAction> actions;

	private Subject subject;

	public ActiveActions(GameState gameState)
	{
		this.subject = gameState;
		actions = new ArrayList<IAction>();

		/*
		 * initialize with a permanent action that removes actions of cards whenever
		 * they are destroyed
		 */
		actions.add(new RemoveActionsOfCard(this));
	}

	/**
	 * run through action queue one time and execute any events triggered
	 * @param currentEvent that determines which events are triggered
	 */
	public void runActionQueue(Event currentEvent)
	{
		/* check if any actions are triggered by this event */
		for (IAction action : actions)
		{
			if (action.isValid(currentEvent))
			{
				// execute action
				currentEvent.apply(action);
				// remove from active actions if it is a one time action
				if (!action.isRepetetive())
					actions.remove(action);
			}

		}
	}

	@Override
	public void update()
	{
		// current event has changed
		GameState update = (GameState) this.subject.getUpdate(this);

		this.runActionQueue(update.getCurrentEvent());
	}

	@Override
	public void setSubject(Subject sub)
	{
		this.subject = sub;
		subject.register(this);
	}

	@Override
	public void apply(IAction action)
	{
		action.execute(this);

	}

	public ArrayList<IAction> getActions()
	{
		return actions;
	}
}

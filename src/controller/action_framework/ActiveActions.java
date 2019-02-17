package controller.action_framework;

import java.util.ArrayList;

import controller.actions.core.RemoveActionsOfDeadCard;
import model.IState;
import model.Observer;
import model.Subject;
import model.game.Event;
import model.game.EventType;
import model.game.GameState;

public class ActiveActions implements Observer, IState {

	public static ArrayList<IAction> actions;

	private Subject subject;

	/**
	 * Initializes the action queue and adds the default action that removes effects
	 * from destroyed cards
	 * 
	 * @param gameState
	 */
	public ActiveActions(GameState gameState)
	{
		this.subject = gameState;
		actions = new ArrayList<IAction>();

		/*
		 * initialize with a permanent action that removes actions of cards whenever
		 * they are destroyed
		 */
		actions.add(new RemoveActionsOfDeadCard(null));
	}

	/**
	 * run through action queue one time and execute any events triggered
	 * 
	 * @param currentEvent that determines which events are triggered
	 */
	public void runActionQueue(Event currentEvent)
	{
		System.out.println("Action queue run");
		
		/* check if any actions are triggered by this event */
		for (IAction action : actions)
		{
			if (action.isValid(currentEvent))
			{
				System.out.println("an action is valid");
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

		update.setCurrentEvent(new Event(EventType.IDLE, null, null));
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
		try
		{
			action.execute(this);
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<IAction> getActions()
	{
		return actions;
	}
}

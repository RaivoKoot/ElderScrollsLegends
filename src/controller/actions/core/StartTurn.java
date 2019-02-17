package controller.actions.core;

import controller.action_framework.IAction;
import model.IState;
import model.game.CurrentEventManager;
import model.game.Event;
import model.game.EventType;
import model.player.Player;

public class StartTurn extends IAction {

	private static final EventType TRIGGER = null;
	private static final boolean REPETITIVE = false;

	public StartTurn()
	{
		super(null, REPETITIVE, TRIGGER);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(IState state) throws Exception
	{
		Player player = (Player) state;

		Event startTurnEvent = new Event(EventType.START_TURN, player, null);
		CurrentEventManager.setCurrentEvent(startTurnEvent);

		IAction drawCard = new DrawCard(startTurnEvent);
		player.apply(drawCard);
	}

}

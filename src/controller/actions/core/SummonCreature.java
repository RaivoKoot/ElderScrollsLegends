package controller.actions.core;

import controller.action_framework.IAction;
import controller.actions.exceptions.NotEnoughMagickaException;
import model.IState;
import model.card.Card;
import model.cardlists.CardList;
import model.game.CurrentEventManager;
import model.game.Event;
import model.game.EventType;
import model.game.GameState;

public class SummonCreature extends IAction {

	private static final EventType TRIGGER = null;
	private static final boolean REPETITIVE = false;

	/**
	 * @param source the event that would result from this action.
	 *               plannedEvent.target being the target lane
	 */
	public SummonCreature(CardList sourceList, CardList targetList)
	{
		super(null, REPETITIVE, TRIGGER);
		
		Event plannedEvent = new Event(EventType.PLAY_CARD, sourceList, targetList);
		super.setSource(plannedEvent);
	}

	@Override
	public void execute(IState state) throws NotEnoughMagickaException
	{
		Card card = (Card) state;

		Event plannedEvent = (Event) super.getSource();
		CardList targetLane = (CardList) plannedEvent.getTarget();
		CardList hand = (CardList) plannedEvent.getSource();
		
		UseMagicka payMagicka = new UseMagicka(plannedEvent);
		card.apply(payMagicka);
		
		MoveCard moveList = new MoveCard(null, false, null, hand, targetLane);
		card.apply(moveList);

		plannedEvent.setSource(card);

		CurrentEventManager.setCurrentEvent(plannedEvent);

	}

	public boolean isValid(IState event)
	{
		return false;
	}

}
